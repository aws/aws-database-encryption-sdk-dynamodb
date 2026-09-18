// The three operation handlers: CreateClient / EncryptItem / DecryptItem.
// They delegate to the real DBE DynamoDbItemEncryptor and translate between the
// wire AttributeValue (scalars only: S / N / B / BOOL / NULL) and the AWS SDK's
// Amazon.DynamoDBv2.Model.AttributeValue that the item encryptor consumes and
// produces. Mirrors the Rust handlers.rs.
//
// A DBE-library failure on Encrypt/Decrypt becomes a DBESDKClientError (this is
// the failure a tamper test asserts on); a bad clientId, an unsupported wire
// value, or a construction failure is a GenericServerError. Operations on a
// single client are serialized by that client's OpLock (see ClientRegistry).

using Amazon.DynamoDBv2.Model;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms;
using AWS.Cryptography.MaterialProviders;
using DbeService = AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using StructuredEncryption = AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;

namespace Aws.Cryptography.Dbesdk.TestServer;

internal sealed class Handlers
{
    private readonly ClientRegistry _registry = new();
    private readonly TransformsRegistry _transformsRegistry = new();
    private readonly StructuredRegistry _structuredRegistry = new();
    private readonly ItemEncryptorFactory _factory;
    private readonly StructuredEncryption.StructuredEncryption _structured;
    private readonly DbeService.DynamoDbEncryption _dbe;

    public Handlers()
    {
        // One shared Material Providers client. Its construction touches no
        // network; KMS is reached only on Encrypt/Decrypt. Building keyrings
        // through it during concurrent CreateClient calls is safe (distinct
        // clients, distinct internal state) — the Rust server proved this.
        var mpl = new MaterialProviders(new MaterialProvidersConfig());
        _factory = new ItemEncryptorFactory(mpl);
        // The Structured Encryption client is stateless (the CMM is a
        // per-operation input), so one shared instance serves every client id.
        _structured = new StructuredEncryption.StructuredEncryption(
            new StructuredEncryption.StructuredEncryptionConfig());
        // The top-level DynamoDbEncryption client only parses header bytes for
        // GetEncryptedDataKeyDescription (no CMM/keyring), so one shared,
        // config-less instance serves every call.
        _dbe = new DbeService.DynamoDbEncryption(new DbeService.DynamoDbEncryptionConfig());
    }

    public Dictionary<string, object?> CreateClient(Dictionary<string, object?> request)
    {
        var config = Wire.RequireMap(request, "config");
        var encryptor = _factory.Build(config);
        var clientId = _registry.Register(encryptor);
        return new Dictionary<string, object?> { ["clientId"] = clientId };
    }

    public async Task<Dictionary<string, object?>> EncryptItem(Dictionary<string, object?> request)
    {
        var handle = _registry.Get(Wire.RequireString(request, "clientId"));
        var plaintext = ToDdbItem(Wire.RequireMap(request, "plaintextItem"));

        Dictionary<string, AttributeValue> encrypted;
        // Serialize operations on this client: the DBE client cannot tolerate
        // concurrent calls (see ClientRegistry). WaitAsync so waiters yield.
        await handle.OpLock.WaitAsync();
        try
        {
            encrypted = handle.Encryptor
                .EncryptItem(new EncryptItemInput { PlaintextItem = plaintext })
                .EncryptedItem;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }
        return new Dictionary<string, object?> { ["encryptedItem"] = FromDdbItem(encrypted) };
    }

    public async Task<Dictionary<string, object?>> DecryptItem(Dictionary<string, object?> request)
    {
        var handle = _registry.Get(Wire.RequireString(request, "clientId"));
        var encrypted = ToDdbItem(Wire.RequireMap(request, "encryptedItem"));

        Dictionary<string, AttributeValue> plaintext;
        // Serialize operations on this client: the DBE client cannot tolerate
        // concurrent calls (see ClientRegistry). WaitAsync so waiters yield.
        await handle.OpLock.WaitAsync();
        try
        {
            plaintext = handle.Encryptor
                .DecryptItem(new DecryptItemInput { EncryptedItem = encrypted })
                .PlaintextItem;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }
        return new Dictionary<string, object?> { ["plaintextItem"] = FromDdbItem(plaintext) };
    }

    // -----------------------------------------------------------------------
    // GetEncryptedDataKeyDescription: parse the Encrypted Data Keys out of a
    // serialized header (supplied directly, or read from an encrypted item's
    // aws_dbe_head). No client id / CMM / keyring — the shared, config-less
    // DynamoDbEncryption client only parses the header bytes.
    // -----------------------------------------------------------------------

    public Dictionary<string, object?> GetEncryptedDataKeyDescription(
        Dictionary<string, object?> request)
    {
        var source = Wire.RequireMap(request, "input");
        var union = new DbeService.GetEncryptedDataKeyDescriptionUnion();
        if (source.TryGetValue("header", out var h) && h is byte[] headerBytes)
        {
            union.Header = new MemoryStream(headerBytes);
        }
        else if (Wire.OptMap(source, "item") is { } itemWire)
        {
            union.Item = ToDdbItem(itemWire);
        }
        else
        {
            throw ServerException.Generic(
                "GetEncryptedDataKeyDescription input union has no supported member set");
        }

        List<DbeService.EncryptedDataKeyDescription> descriptions;
        try
        {
            descriptions = _dbe
                .GetEncryptedDataKeyDescription(
                    new DbeService.GetEncryptedDataKeyDescriptionInput { Input = union })
                .EncryptedDataKeyDescriptionOutput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }

        var wire = new List<object?>(descriptions.Count);
        foreach (var d in descriptions)
        {
            var entry = new Dictionary<string, object?> { ["keyProviderId"] = d.KeyProviderId };
            if (d.IsSetKeyProviderInfo())
            {
                entry["keyProviderInfo"] = d.KeyProviderInfo;
            }
            if (d.IsSetBranchKeyId())
            {
                entry["branchKeyId"] = d.BranchKeyId;
            }
            if (d.IsSetBranchKeyVersion())
            {
                entry["branchKeyVersion"] = d.BranchKeyVersion;
            }
            wire.Add(entry);
        }
        return new Dictionary<string, object?> { ["descriptions"] = wire };
    }

    // -----------------------------------------------------------------------
    // DDB SDK transforms: CreateTransformsClient builds a transforms client
    // bound to one table; PutItemInputTransform encrypts a PutItem input;
    // GetItemOutputTransform decrypts a GetItem output. Each maps the minimal
    // wire shape onto the real Amazon.DynamoDBv2.Model request/response type.
    // -----------------------------------------------------------------------

    public Dictionary<string, object?> CreateTransformsClient(Dictionary<string, object?> request)
    {
        var config = Wire.RequireMap(request, "config");
        var tableName = Wire.RequireString(request, "tableName");
        List<object?>? additionalTables = null;
        if (request.TryGetValue("additionalTables", out var extra) && extra is List<object?> list)
        {
            additionalTables = list;
        }
        var transforms = _factory.BuildTransforms(config, tableName, additionalTables);
        var clientId = _transformsRegistry.Register(transforms);
        return new Dictionary<string, object?> { ["clientId"] = clientId };
    }

    // -----------------------------------------------------------------------
    // Structured Encryption: CreateStructuredClient builds the CMM from
    // the config; Encrypt/DecryptStructure run the raw structured layer beneath
    // the item encryptor over a flat name -> terminal map.
    // -----------------------------------------------------------------------

    public Dictionary<string, object?> CreateStructuredClient(Dictionary<string, object?> request)
    {
        var config = Wire.RequireMap(request, "config");
        var cmm = _factory.CmmFor(config);
        var clientId = _structuredRegistry.Register(cmm);
        return new Dictionary<string, object?> { ["clientId"] = clientId };
    }

    public async Task<Dictionary<string, object?>> EncryptStructure(
        Dictionary<string, object?> request)
    {
        var handle = _structuredRegistry.Get(Wire.RequireString(request, "clientId"));
        var tableName = Wire.RequireString(request, "tableName");
        var plaintext = ToDbeStructure(Wire.RequireMap(request, "plaintextStructure"));
        var schema = ItemEncryptorFactory.CryptoActions(Wire.RequireMap(request, "cryptoSchema"));

        Dictionary<string, StructuredEncryption.StructuredDataTerminal> encrypted;
        await handle.OpLock.WaitAsync();
        try
        {
            encrypted = _structured.EncryptStructure(new StructuredEncryption.EncryptStructureInput
            {
                TableName = tableName,
                PlaintextStructure = plaintext,
                CryptoSchema = schema,
                Cmm = handle.Cmm,
            }).EncryptedStructure;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }
        return new Dictionary<string, object?> { ["encryptedStructure"] = ToWireStructure(encrypted) };
    }

    public async Task<Dictionary<string, object?>> DecryptStructure(
        Dictionary<string, object?> request)
    {
        var handle = _structuredRegistry.Get(Wire.RequireString(request, "clientId"));
        var tableName = Wire.RequireString(request, "tableName");
        var encrypted = ToDbeStructure(Wire.RequireMap(request, "encryptedStructure"));
        var authSchema = AuthenticateSchema(Wire.RequireMap(request, "authenticateSchema"));

        Dictionary<string, StructuredEncryption.StructuredDataTerminal> plaintext;
        await handle.OpLock.WaitAsync();
        try
        {
            plaintext = _structured.DecryptStructure(new StructuredEncryption.DecryptStructureInput
            {
                TableName = tableName,
                EncryptedStructure = encrypted,
                AuthenticateSchema = authSchema,
                Cmm = handle.Cmm,
            }).PlaintextStructure;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }
        return new Dictionary<string, object?> { ["plaintextStructure"] = ToWireStructure(plaintext) };
    }

    private static Dictionary<string, StructuredEncryption.StructuredDataTerminal> ToDbeStructure(
        Dictionary<string, object?> wire)
    {
        var result = new Dictionary<string, StructuredEncryption.StructuredDataTerminal>(wire.Count);
        foreach (var (name, value) in wire)
        {
            var terminal = Wire.AsMap(value, "structured terminal");
            result[name] = new StructuredEncryption.StructuredDataTerminal
            {
                Value = new MemoryStream(Wire.RequireBytes(terminal, "value")),
                TypeId = new MemoryStream(Wire.RequireBytes(terminal, "typeId")),
            };
        }
        return result;
    }

    private static Dictionary<string, object?> ToWireStructure(
        Dictionary<string, StructuredEncryption.StructuredDataTerminal> dbe)
    {
        var result = new Dictionary<string, object?>(dbe.Count);
        foreach (var (name, terminal) in dbe)
        {
            result[name] = new Dictionary<string, object?>
            {
                ["value"] = terminal.Value.ToArray(),
                ["typeId"] = terminal.TypeId.ToArray(),
            };
        }
        return result;
    }

    private static Dictionary<string, StructuredEncryption.AuthenticateAction> AuthenticateSchema(
        Dictionary<string, object?> wire)
    {
        var result = new Dictionary<string, StructuredEncryption.AuthenticateAction>(wire.Count);
        foreach (var (name, value) in wire)
        {
            if (value is not string action)
            {
                throw ServerException.Generic($"authenticate action for '{name}' must be a string");
            }
            result[name] = action switch
            {
                "SIGN" => StructuredEncryption.AuthenticateAction.SIGN,
                "DO_NOT_SIGN" => StructuredEncryption.AuthenticateAction.DO_NOT_SIGN,
                _ => throw ServerException.Generic($"unknown AuthenticateAction '{action}'"),
            };
        }
        return result;
    }

    // -----------------------------------------------------------------------
    // Structured Encryption path ops (increment 2): a Crypto/Auth List
    // keyed by Path, rather than a flat map. Encrypt/Decrypt take a CMM (from the
    // client handle); ResolveAuthActions is a pure function of the header and
    // takes none, so it runs on the shared SE client directly.
    // -----------------------------------------------------------------------

    public async Task<Dictionary<string, object?>> EncryptPathStructure(
        Dictionary<string, object?> request)
    {
        var handle = _structuredRegistry.Get(Wire.RequireString(request, "clientId"));
        var tableName = Wire.RequireString(request, "tableName");
        var plaintext = ToDbeCryptoList(RequireList(request, "plaintextStructure"));

        List<StructuredEncryption.CryptoItem> encrypted;
        await handle.OpLock.WaitAsync();
        try
        {
            encrypted = _structured.EncryptPathStructure(new StructuredEncryption.EncryptPathStructureInput
            {
                TableName = tableName,
                PlaintextStructure = plaintext,
                Cmm = handle.Cmm,
            }).EncryptedStructure;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }
        return new Dictionary<string, object?> { ["encryptedStructure"] = ToWireCryptoList(encrypted) };
    }

    public async Task<Dictionary<string, object?>> DecryptPathStructure(
        Dictionary<string, object?> request)
    {
        var handle = _structuredRegistry.Get(Wire.RequireString(request, "clientId"));
        var tableName = Wire.RequireString(request, "tableName");
        var encrypted = ToDbeAuthList(RequireList(request, "encryptedStructure"));

        List<StructuredEncryption.CryptoItem> plaintext;
        await handle.OpLock.WaitAsync();
        try
        {
            plaintext = _structured.DecryptPathStructure(new StructuredEncryption.DecryptPathStructureInput
            {
                TableName = tableName,
                EncryptedStructure = encrypted,
                Cmm = handle.Cmm,
            }).PlaintextStructure;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }
        return new Dictionary<string, object?> { ["plaintextStructure"] = ToWireCryptoList(plaintext) };
    }

    public Dictionary<string, object?> ResolveAuthActions(Dictionary<string, object?> request)
    {
        var tableName = Wire.RequireString(request, "tableName");
        var authActions = ToDbeAuthList(RequireList(request, "authActions"));
        var headerBytes = new MemoryStream(Wire.RequireBytes(request, "headerBytes"));

        List<StructuredEncryption.CryptoItem> resolved;
        try
        {
            resolved = _structured.ResolveAuthActions(new StructuredEncryption.ResolveAuthActionsInput
            {
                TableName = tableName,
                AuthActions = authActions,
                HeaderBytes = headerBytes,
            }).CryptoActions;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        return new Dictionary<string, object?> { ["cryptoActions"] = ToWireCryptoList(resolved) };
    }

    private static List<object?> RequireList(Dictionary<string, object?> map, string key)
    {
        if (!map.TryGetValue(key, out var value) || value is not List<object?> list)
        {
            throw ServerException.Generic($"missing or non-list '{key}'");
        }
        return list;
    }

    private static List<StructuredEncryption.CryptoItem> ToDbeCryptoList(List<object?> wire)
    {
        var result = new List<StructuredEncryption.CryptoItem>(wire.Count);
        foreach (var entry in wire)
        {
            var item = Wire.AsMap(entry, "crypto item");
            result.Add(new StructuredEncryption.CryptoItem
            {
                Key = ToDbePath(item),
                Data = ToDbeTerminal(Wire.RequireMap(item, "data")),
                Action = CryptoActionFrom(RequireActionString(item)),
            });
        }
        return result;
    }

    private static List<StructuredEncryption.AuthItem> ToDbeAuthList(List<object?> wire)
    {
        var result = new List<StructuredEncryption.AuthItem>(wire.Count);
        foreach (var entry in wire)
        {
            var item = Wire.AsMap(entry, "auth item");
            result.Add(new StructuredEncryption.AuthItem
            {
                Key = ToDbePath(item),
                Data = ToDbeTerminal(Wire.RequireMap(item, "data")),
                Action = AuthActionFrom(RequireActionString(item)),
            });
        }
        return result;
    }

    private static List<object?> ToWireCryptoList(List<StructuredEncryption.CryptoItem> dbe)
    {
        var result = new List<object?>(dbe.Count);
        foreach (var item in dbe)
        {
            result.Add(new Dictionary<string, object?>
            {
                ["path"] = FromDbePath(item.Key),
                ["data"] = new Dictionary<string, object?>
                {
                    ["value"] = item.Data.Value.ToArray(),
                    ["typeId"] = item.Data.TypeId.ToArray(),
                },
                ["action"] = item.Action.ToString(),
            });
        }
        return result;
    }

    private static List<object?> FromDbePath(List<StructuredEncryption.PathSegment> path)
    {
        var result = new List<object?>(path.Count);
        foreach (var segment in path)
        {
            result.Add(segment.Member.Key);
        }
        return result;
    }

    private static List<StructuredEncryption.PathSegment> ToDbePath(Dictionary<string, object?> item)
    {
        if (!item.TryGetValue("path", out var pathObj) || pathObj is not List<object?> segments)
        {
            throw ServerException.Generic("crypto/auth item missing 'path' list");
        }
        var result = new List<StructuredEncryption.PathSegment>(segments.Count);
        foreach (var seg in segments)
        {
            if (seg is not string key)
            {
                throw ServerException.Generic("path segment must be a string");
            }
            result.Add(new StructuredEncryption.PathSegment
            {
                Member = new StructuredEncryption.StructureSegment { Key = key },
            });
        }
        return result;
    }

    private static StructuredEncryption.StructuredDataTerminal ToDbeTerminal(
        Dictionary<string, object?> terminal)
    {
        return new StructuredEncryption.StructuredDataTerminal
        {
            Value = new MemoryStream(Wire.RequireBytes(terminal, "value")),
            TypeId = new MemoryStream(Wire.RequireBytes(terminal, "typeId")),
        };
    }

    private static string RequireActionString(Dictionary<string, object?> item)
    {
        if (!item.TryGetValue("action", out var actionObj) || actionObj is not string action)
        {
            throw ServerException.Generic("crypto/auth item missing 'action' string");
        }
        return action;
    }

    private static StructuredEncryption.CryptoAction CryptoActionFrom(string action) => action switch
    {
        "ENCRYPT_AND_SIGN" => StructuredEncryption.CryptoAction.ENCRYPT_AND_SIGN,
        "SIGN_ONLY" => StructuredEncryption.CryptoAction.SIGN_ONLY,
        "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT" =>
            StructuredEncryption.CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
        "DO_NOTHING" => StructuredEncryption.CryptoAction.DO_NOTHING,
        _ => throw ServerException.Generic($"unknown CryptoAction '{action}'"),
    };

    private static StructuredEncryption.AuthenticateAction AuthActionFrom(string action) => action switch
    {
        "SIGN" => StructuredEncryption.AuthenticateAction.SIGN,
        "DO_NOT_SIGN" => StructuredEncryption.AuthenticateAction.DO_NOT_SIGN,
        _ => throw ServerException.Generic($"unknown AuthenticateAction '{action}'"),
    };

    public async Task<Dictionary<string, object?>> PutItemInputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var sdkInputWire = Wire.RequireMap(request, "sdkInput");
        var putRequest = new PutItemRequest
        {
            TableName = Wire.RequireString(sdkInputWire, "tableName"),
            Item = ToDdbItem(Wire.RequireMap(sdkInputWire, "item")),
        };

        PutItemRequest transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .PutItemInputTransform(new PutItemInputTransformInput { SdkInput = putRequest })
                .TransformedInput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        return new Dictionary<string, object?>
        {
            ["transformedInput"] = new Dictionary<string, object?>
            {
                ["tableName"] = transformed.TableName,
                ["item"] = FromDdbItem(transformed.Item),
            },
        };
    }

    public async Task<Dictionary<string, object?>> GetItemOutputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var originalWire = Wire.RequireMap(request, "originalInput");
        var outputWire = Wire.RequireMap(request, "sdkOutput");

        var getRequest = new GetItemRequest
        {
            TableName = Wire.RequireString(originalWire, "tableName"),
            Key = ToDdbItem(Wire.RequireMap(originalWire, "key")),
        };
        var getResponse = new GetItemResponse();
        var itemWire = Wire.OptMap(outputWire, "item");
        if (itemWire != null)
        {
            getResponse.Item = ToDdbItem(itemWire);
        }

        GetItemResponse transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .GetItemOutputTransform(new GetItemOutputTransformInput
                {
                    OriginalInput = getRequest,
                    SdkOutput = getResponse,
                })
                .TransformedOutput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var output = new Dictionary<string, object?>();
        if (transformed.Item != null && transformed.Item.Count > 0)
        {
            output["item"] = FromDdbItem(transformed.Item);
        }
        return new Dictionary<string, object?> { ["transformedOutput"] = output };
    }

    public async Task<Dictionary<string, object?>> GetItemInputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var wire = Wire.RequireMap(request, "sdkInput");
        var getRequest = new GetItemRequest
        {
            TableName = Wire.RequireString(wire, "tableName"),
            Key = ToDdbItem(Wire.RequireMap(wire, "key")),
        };

        GetItemRequest transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .GetItemInputTransform(new GetItemInputTransformInput { SdkInput = getRequest })
                .TransformedInput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        return new Dictionary<string, object?>
        {
            ["transformedInput"] = new Dictionary<string, object?>
            {
                ["tableName"] = transformed.TableName,
                ["key"] = FromDdbItem(transformed.Key),
            },
        };
    }

    public async Task<Dictionary<string, object?>> PutItemOutputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var originalWire = Wire.RequireMap(request, "originalInput");
        var outputWire = Wire.RequireMap(request, "sdkOutput");

        var putRequest = new PutItemRequest
        {
            TableName = Wire.RequireString(originalWire, "tableName"),
            Item = ToDdbItem(Wire.RequireMap(originalWire, "item")),
        };
        var putResponse = new PutItemResponse();
        var attrsWire = Wire.OptMap(outputWire, "attributes");
        if (attrsWire != null)
        {
            putResponse.Attributes = ToDdbItem(attrsWire);
        }

        PutItemResponse transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .PutItemOutputTransform(new PutItemOutputTransformInput
                {
                    OriginalInput = putRequest,
                    SdkOutput = putResponse,
                })
                .TransformedOutput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var output = new Dictionary<string, object?>();
        if (transformed.Attributes != null && transformed.Attributes.Count > 0)
        {
            output["attributes"] = FromDdbItem(transformed.Attributes);
        }
        return new Dictionary<string, object?> { ["transformedOutput"] = output };
    }

    public async Task<Dictionary<string, object?>> UpdateItemOutputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var originalWire = Wire.RequireMap(request, "originalInput");
        var outputWire = Wire.RequireMap(request, "sdkOutput");

        var req = new UpdateItemRequest
        {
            TableName = Wire.RequireString(originalWire, "tableName"),
            Key = ToDdbItem(Wire.RequireMap(originalWire, "key")),
        };
        var resp = new UpdateItemResponse();
        var attrsWire = Wire.OptMap(outputWire, "attributes");
        if (attrsWire != null)
        {
            resp.Attributes = ToDdbItem(attrsWire);
        }

        UpdateItemResponse transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .UpdateItemOutputTransform(new UpdateItemOutputTransformInput
                {
                    OriginalInput = req,
                    SdkOutput = resp,
                })
                .TransformedOutput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var output = new Dictionary<string, object?>();
        if (transformed.Attributes != null && transformed.Attributes.Count > 0)
        {
            output["attributes"] = FromDdbItem(transformed.Attributes);
        }
        return new Dictionary<string, object?> { ["transformedOutput"] = output };
    }

    public async Task<Dictionary<string, object?>> DeleteItemOutputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var originalWire = Wire.RequireMap(request, "originalInput");
        var outputWire = Wire.RequireMap(request, "sdkOutput");

        var req = new DeleteItemRequest
        {
            TableName = Wire.RequireString(originalWire, "tableName"),
            Key = ToDdbItem(Wire.RequireMap(originalWire, "key")),
        };
        var resp = new DeleteItemResponse();
        var attrsWire = Wire.OptMap(outputWire, "attributes");
        if (attrsWire != null)
        {
            resp.Attributes = ToDdbItem(attrsWire);
        }

        DeleteItemResponse transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .DeleteItemOutputTransform(new DeleteItemOutputTransformInput
                {
                    OriginalInput = req,
                    SdkOutput = resp,
                })
                .TransformedOutput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var output = new Dictionary<string, object?>();
        if (transformed.Attributes != null && transformed.Attributes.Count > 0)
        {
            output["attributes"] = FromDdbItem(transformed.Attributes);
        }
        return new Dictionary<string, object?> { ["transformedOutput"] = output };
    }

    public async Task<Dictionary<string, object?>> TransactWriteItemsOutputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var originalWire = Wire.RequireMap(request, "originalInput");
        var transactItemsWire = RequireList(originalWire, "transactItems");
        var sdkItems = new List<TransactWriteItem>(transactItemsWire.Count);
        foreach (var item in transactItemsWire)
        {
            sdkItems.Add(ToSdkTransactWriteItem(Wire.AsMap(item, "transact item")));
        }

        await handle.OpLock.WaitAsync();
        try
        {
            handle.Transforms.TransactWriteItemsOutputTransform(
                new TransactWriteItemsOutputTransformInput
                {
                    OriginalInput = new TransactWriteItemsRequest { TransactItems = sdkItems },
                    SdkOutput = new TransactWriteItemsResponse(),
                });
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }
        return new Dictionary<string, object?>
        {
            ["transformedOutput"] = new Dictionary<string, object?>(),
        };
    }

    public async Task<Dictionary<string, object?>> ExecuteStatementOutputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var originalWire = Wire.RequireMap(request, "originalInput");
        var outputWire = Wire.RequireMap(request, "sdkOutput");

        var req = new ExecuteStatementRequest
        {
            Statement = Wire.RequireString(originalWire, "statement"),
        };
        var resp = new ExecuteStatementResponse();
        if (outputWire.TryGetValue("items", out var itemsObj) && itemsObj is List<object?> items)
        {
            resp.Items = ToDdbItemList(items);
        }

        ExecuteStatementResponse transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .ExecuteStatementOutputTransform(new ExecuteStatementOutputTransformInput
                {
                    OriginalInput = req,
                    SdkOutput = resp,
                })
                .TransformedOutput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var output = new Dictionary<string, object?>();
        if (transformed.Items is { Count: > 0 })
        {
            output["items"] = FromDdbItemList(transformed.Items);
        }
        return new Dictionary<string, object?> { ["transformedOutput"] = output };
    }

    public async Task<Dictionary<string, object?>> ExecuteTransactionOutputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var originalWire = Wire.RequireMap(request, "originalInput");
        var outputWire = Wire.RequireMap(request, "sdkOutput");

        var req = new ExecuteTransactionRequest { TransactStatements = new List<ParameterizedStatement>() };
        if (originalWire.TryGetValue("transactStatements", out var stmtsObj)
            && stmtsObj is List<object?> stmts)
        {
            foreach (var sObj in stmts)
            {
                var sMap = Wire.AsMap(sObj, "transactStatement");
                req.TransactStatements.Add(new ParameterizedStatement
                {
                    Statement = Wire.RequireString(sMap, "statement"),
                });
            }
        }
        var resp = new ExecuteTransactionResponse { Responses = new List<ItemResponse>() };
        if (outputWire.TryGetValue("responses", out var respObj) && respObj is List<object?> resps)
        {
            foreach (var rObj in resps)
            {
                var rMap = Wire.AsMap(rObj, "itemResponse");
                var ir = new ItemResponse();
                var itemWire = Wire.OptMap(rMap, "item");
                if (itemWire != null)
                {
                    ir.Item = ToDdbItem(itemWire);
                }
                resp.Responses.Add(ir);
            }
        }

        ExecuteTransactionResponse transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .ExecuteTransactionOutputTransform(new ExecuteTransactionOutputTransformInput
                {
                    OriginalInput = req,
                    SdkOutput = resp,
                })
                .TransformedOutput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var output = new Dictionary<string, object?>();
        if (transformed.Responses is { Count: > 0 })
        {
            var wireResponses = new List<object?>();
            foreach (var r in transformed.Responses)
            {
                var m = new Dictionary<string, object?>();
                if (r.Item != null && r.Item.Count > 0)
                {
                    m["item"] = FromDdbItem(r.Item);
                }
                wireResponses.Add(m);
            }
            output["responses"] = wireResponses;
        }
        return new Dictionary<string, object?> { ["transformedOutput"] = output };
    }

    public async Task<Dictionary<string, object?>> BatchExecuteStatementOutputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var originalWire = Wire.RequireMap(request, "originalInput");
        var outputWire = Wire.RequireMap(request, "sdkOutput");

        var req = new BatchExecuteStatementRequest { Statements = new List<BatchStatementRequest>() };
        if (originalWire.TryGetValue("statements", out var stmtsObj) && stmtsObj is List<object?> stmts)
        {
            foreach (var sObj in stmts)
            {
                var sMap = Wire.AsMap(sObj, "batchStatementRequest");
                req.Statements.Add(new BatchStatementRequest
                {
                    Statement = Wire.RequireString(sMap, "statement"),
                });
            }
        }
        var resp = new BatchExecuteStatementResponse { Responses = new List<BatchStatementResponse>() };
        if (outputWire.TryGetValue("responses", out var respObj) && respObj is List<object?> resps)
        {
            foreach (var rObj in resps)
            {
                var rMap = Wire.AsMap(rObj, "batchStatementResponse");
                var bsr = new BatchStatementResponse();
                var tableName = Wire.OptString(rMap, "tableName");
                if (tableName != null)
                {
                    bsr.TableName = tableName;
                }
                var itemWire = Wire.OptMap(rMap, "item");
                if (itemWire != null)
                {
                    bsr.Item = ToDdbItem(itemWire);
                }
                resp.Responses.Add(bsr);
            }
        }

        BatchExecuteStatementResponse transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .BatchExecuteStatementOutputTransform(new BatchExecuteStatementOutputTransformInput
                {
                    OriginalInput = req,
                    SdkOutput = resp,
                })
                .TransformedOutput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var output = new Dictionary<string, object?>();
        if (transformed.Responses is { Count: > 0 })
        {
            var wireResponses = new List<object?>();
            foreach (var r in transformed.Responses)
            {
                var m = new Dictionary<string, object?>();
                if (r.TableName != null)
                {
                    m["tableName"] = r.TableName;
                }
                if (r.Item != null && r.Item.Count > 0)
                {
                    m["item"] = FromDdbItem(r.Item);
                }
                wireResponses.Add(m);
            }
            output["responses"] = wireResponses;
        }
        return new Dictionary<string, object?> { ["transformedOutput"] = output };
    }

    public async Task<Dictionary<string, object?>> BatchWriteItemInputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var sdkInputWire = Wire.RequireMap(request, "sdkInput");
        var sdkRequest = new BatchWriteItemRequest
        {
            RequestItems = ToSdkWriteRequestMap(Wire.RequireMap(sdkInputWire, "requestItems")),
        };

        BatchWriteItemRequest transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .BatchWriteItemInputTransform(
                    new BatchWriteItemInputTransformInput { SdkInput = sdkRequest })
                .TransformedInput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        return new Dictionary<string, object?>
        {
            ["transformedInput"] = new Dictionary<string, object?>
            {
                ["requestItems"] = ToWireWriteRequestMap(transformed.RequestItems),
            },
        };
    }

    public async Task<Dictionary<string, object?>> TransactWriteItemsInputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var sdkInputWire = Wire.RequireMap(request, "sdkInput");
        if (!sdkInputWire.TryGetValue("transactItems", out var tiObj)
            || tiObj is not List<object?> transactItemsWire)
        {
            throw ServerException.Generic("transactItems must be a list");
        }

        var sdkItems = new List<TransactWriteItem>(transactItemsWire.Count);
        foreach (var item in transactItemsWire)
        {
            sdkItems.Add(ToSdkTransactWriteItem(Wire.AsMap(item, "transact item")));
        }
        var sdkRequest = new TransactWriteItemsRequest { TransactItems = sdkItems };

        TransactWriteItemsRequest transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .TransactWriteItemsInputTransform(
                    new TransactWriteItemsInputTransformInput { SdkInput = sdkRequest })
                .TransformedInput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var wireItems = new List<object?>(transformed.TransactItems.Count);
        foreach (var item in transformed.TransactItems)
        {
            wireItems.Add(ToWireTransactWriteItem(item));
        }
        return new Dictionary<string, object?>
        {
            ["transformedInput"] =
                new Dictionary<string, object?> { ["transactItems"] = wireItems },
        };
    }

    public async Task<Dictionary<string, object?>> BatchWriteItemOutputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var originalWire = Wire.RequireMap(request, "originalInput");
        var outputWire = Wire.RequireMap(request, "sdkOutput");

        var originalInput = new BatchWriteItemRequest
        {
            RequestItems = ToSdkWriteRequestMap(Wire.RequireMap(originalWire, "requestItems")),
        };

        var sdkOutput = new BatchWriteItemResponse();
        if (outputWire.TryGetValue("unprocessedItems", out var uObj)
            && uObj is Dictionary<string, object?> unprocessedWire)
        {
            sdkOutput.UnprocessedItems = ToSdkWriteRequestMap(unprocessedWire);
        }

        BatchWriteItemResponse transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .BatchWriteItemOutputTransform(new BatchWriteItemOutputTransformInput
                {
                    OriginalInput = originalInput,
                    SdkOutput = sdkOutput,
                })
                .TransformedOutput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var output = new Dictionary<string, object?>();
        if (transformed.UnprocessedItems is { Count: > 0 })
        {
            output["unprocessedItems"] = ToWireWriteRequestMap(transformed.UnprocessedItems);
        }
        return new Dictionary<string, object?> { ["transformedOutput"] = output };
    }

    private static Dictionary<string, List<WriteRequest>> ToSdkWriteRequestMap(
        Dictionary<string, object?> wire)
    {
        var result = new Dictionary<string, List<WriteRequest>>();
        foreach (var (table, listObj) in wire)
        {
            if (listObj is not List<object?> list)
            {
                throw ServerException.Generic($"requestItems['{table}'] must be a list");
            }
            var sdkList = new List<WriteRequest>(list.Count);
            foreach (var wr in list)
            {
                sdkList.Add(ToSdkWriteRequest(Wire.AsMap(wr, "write request")));
            }
            result[table] = sdkList;
        }
        return result;
    }

    private static Dictionary<string, object?> ToWireWriteRequestMap(
        Dictionary<string, List<WriteRequest>> sdk)
    {
        var result = new Dictionary<string, object?>();
        foreach (var (table, list) in sdk)
        {
            var wireList = new List<object?>(list.Count);
            foreach (var wr in list)
            {
                wireList.Add(ToWireWriteRequest(wr));
            }
            result[table] = wireList;
        }
        return result;
    }

    private static WriteRequest ToSdkWriteRequest(Dictionary<string, object?> wr)
    {
        if (Wire.OptMap(wr, "putRequest") is { } pr)
        {
            return new WriteRequest
            {
                PutRequest = new PutRequest { Item = ToDdbItem(Wire.RequireMap(pr, "item")) },
            };
        }
        if (Wire.OptMap(wr, "deleteRequest") is { } dr)
        {
            return new WriteRequest
            {
                DeleteRequest = new DeleteRequest { Key = ToDdbItem(Wire.RequireMap(dr, "key")) },
            };
        }
        throw ServerException.Generic(
            "WriteRequest must set exactly one of putRequest or deleteRequest");
    }

    private static Dictionary<string, object?> ToWireWriteRequest(WriteRequest wr)
    {
        if (wr.PutRequest != null)
        {
            return new Dictionary<string, object?>
            {
                ["putRequest"] =
                    new Dictionary<string, object?> { ["item"] = FromDdbItem(wr.PutRequest.Item) },
            };
        }
        if (wr.DeleteRequest != null)
        {
            return new Dictionary<string, object?>
            {
                ["deleteRequest"] =
                    new Dictionary<string, object?> { ["key"] = FromDdbItem(wr.DeleteRequest.Key) },
            };
        }
        throw ServerException.Generic(
            "DBE returned a WriteRequest with neither putRequest nor deleteRequest");
    }

    private static TransactWriteItem ToSdkTransactWriteItem(Dictionary<string, object?> item)
    {
        var result = new TransactWriteItem();
        var put = Wire.OptMap(item, "put");
        if (put != null)
        {
            result.Put = new Put
            {
                TableName = Wire.RequireString(put, "tableName"),
                Item = ToDdbItem(Wire.RequireMap(put, "item")),
            };
        }
        var del = Wire.OptMap(item, "delete");
        if (del != null)
        {
            var d = new Delete
            {
                TableName = Wire.RequireString(del, "tableName"),
                Key = ToDdbItem(Wire.RequireMap(del, "key")),
            };
            var ce = Wire.OptString(del, "conditionExpression");
            if (ce != null) { d.ConditionExpression = ce; }
            var ean = ToStringMap(Wire.OptMap(del, "expressionAttributeNames"));
            if (ean != null) { d.ExpressionAttributeNames = ean; }
            var eav = Wire.OptMap(del, "expressionAttributeValues");
            if (eav != null) { d.ExpressionAttributeValues = ToDdbItem(eav); }
            result.Delete = d;
        }
        var upd = Wire.OptMap(item, "update");
        if (upd != null)
        {
            var u = new Update
            {
                TableName = Wire.RequireString(upd, "tableName"),
                Key = ToDdbItem(Wire.RequireMap(upd, "key")),
                UpdateExpression = Wire.RequireString(upd, "updateExpression"),
            };
            var ce = Wire.OptString(upd, "conditionExpression");
            if (ce != null) { u.ConditionExpression = ce; }
            var ean = ToStringMap(Wire.OptMap(upd, "expressionAttributeNames"));
            if (ean != null) { u.ExpressionAttributeNames = ean; }
            var eav = Wire.OptMap(upd, "expressionAttributeValues");
            if (eav != null) { u.ExpressionAttributeValues = ToDdbItem(eav); }
            result.Update = u;
        }
        var cc = Wire.OptMap(item, "conditionCheck");
        if (cc != null)
        {
            var c = new ConditionCheck
            {
                TableName = Wire.RequireString(cc, "tableName"),
                Key = ToDdbItem(Wire.RequireMap(cc, "key")),
                ConditionExpression = Wire.RequireString(cc, "conditionExpression"),
            };
            var ean = ToStringMap(Wire.OptMap(cc, "expressionAttributeNames"));
            if (ean != null) { c.ExpressionAttributeNames = ean; }
            var eav = Wire.OptMap(cc, "expressionAttributeValues");
            if (eav != null) { c.ExpressionAttributeValues = ToDdbItem(eav); }
            result.ConditionCheck = c;
        }
        return result;
    }

    private static Dictionary<string, object?> ToWireTransactWriteItem(TransactWriteItem item)
    {
        var result = new Dictionary<string, object?>();
        if (item.Put != null)
        {
            result["put"] = new Dictionary<string, object?>
            {
                ["tableName"] = item.Put.TableName,
                ["item"] = FromDdbItem(item.Put.Item),
            };
        }
        if (item.Delete != null)
        {
            var d = new Dictionary<string, object?>
            {
                ["tableName"] = item.Delete.TableName,
                ["key"] = FromDdbItem(item.Delete.Key),
            };
            if (item.Delete.ConditionExpression != null)
            {
                d["conditionExpression"] = item.Delete.ConditionExpression;
            }
            if (item.Delete.ExpressionAttributeNames is { Count: > 0 })
            {
                d["expressionAttributeNames"] = FromStringMap(item.Delete.ExpressionAttributeNames);
            }
            if (item.Delete.ExpressionAttributeValues is { Count: > 0 })
            {
                d["expressionAttributeValues"] = FromDdbItem(item.Delete.ExpressionAttributeValues);
            }
            result["delete"] = d;
        }
        if (item.Update != null)
        {
            var u = new Dictionary<string, object?>
            {
                ["tableName"] = item.Update.TableName,
                ["key"] = FromDdbItem(item.Update.Key),
                ["updateExpression"] = item.Update.UpdateExpression,
            };
            if (item.Update.ConditionExpression != null)
            {
                u["conditionExpression"] = item.Update.ConditionExpression;
            }
            if (item.Update.ExpressionAttributeNames is { Count: > 0 })
            {
                u["expressionAttributeNames"] = FromStringMap(item.Update.ExpressionAttributeNames);
            }
            if (item.Update.ExpressionAttributeValues is { Count: > 0 })
            {
                u["expressionAttributeValues"] = FromDdbItem(item.Update.ExpressionAttributeValues);
            }
            result["update"] = u;
        }
        if (item.ConditionCheck != null)
        {
            var c = new Dictionary<string, object?>
            {
                ["tableName"] = item.ConditionCheck.TableName,
                ["key"] = FromDdbItem(item.ConditionCheck.Key),
                ["conditionExpression"] = item.ConditionCheck.ConditionExpression,
            };
            if (item.ConditionCheck.ExpressionAttributeNames is { Count: > 0 })
            {
                c["expressionAttributeNames"] =
                    FromStringMap(item.ConditionCheck.ExpressionAttributeNames);
            }
            if (item.ConditionCheck.ExpressionAttributeValues is { Count: > 0 })
            {
                c["expressionAttributeValues"] = FromDdbItem(item.ConditionCheck.ExpressionAttributeValues);
            }
            result["conditionCheck"] = c;
        }
        return result;
    }

    public async Task<Dictionary<string, object?>> ScanOutputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var originalWire = Wire.RequireMap(request, "originalInput");
        var outputWire = Wire.RequireMap(request, "sdkOutput");

        var scanRequest = new ScanRequest { TableName = Wire.RequireString(originalWire, "tableName") };
        var filterExpression = Wire.OptString(originalWire, "filterExpression");
        if (filterExpression != null) { scanRequest.FilterExpression = filterExpression; }
        var scanEan = ToStringMap(Wire.OptMap(originalWire, "expressionAttributeNames"));
        if (scanEan != null) { scanRequest.ExpressionAttributeNames = scanEan; }
        var scanEav = Wire.OptMap(originalWire, "expressionAttributeValues");
        if (scanEav != null) { scanRequest.ExpressionAttributeValues = ToDdbItem(scanEav); }
        var scanResponse = new ScanResponse();
        if (outputWire.TryGetValue("items", out var itemsObj) && itemsObj is List<object?> items)
        {
            scanResponse.Items = ToDdbItemList(items);
        }

        ScanResponse transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .ScanOutputTransform(new ScanOutputTransformInput
                {
                    OriginalInput = scanRequest,
                    SdkOutput = scanResponse,
                })
                .TransformedOutput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var output = new Dictionary<string, object?>();
        if (transformed.Items is { Count: > 0 })
        {
            output["items"] = FromDdbItemList(transformed.Items);
        }
        return new Dictionary<string, object?> { ["transformedOutput"] = output };
    }

    public async Task<Dictionary<string, object?>> QueryOutputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var originalWire = Wire.RequireMap(request, "originalInput");
        var outputWire = Wire.RequireMap(request, "sdkOutput");

        var queryRequest =
            new QueryRequest { TableName = Wire.RequireString(originalWire, "tableName") };
        var keyCondition = Wire.OptString(originalWire, "keyConditionExpression");
        if (keyCondition != null) { queryRequest.KeyConditionExpression = keyCondition; }
        var queryFilter = Wire.OptString(originalWire, "filterExpression");
        if (queryFilter != null) { queryRequest.FilterExpression = queryFilter; }
        var queryEan = ToStringMap(Wire.OptMap(originalWire, "expressionAttributeNames"));
        if (queryEan != null) { queryRequest.ExpressionAttributeNames = queryEan; }
        var queryEav = Wire.OptMap(originalWire, "expressionAttributeValues");
        if (queryEav != null) { queryRequest.ExpressionAttributeValues = ToDdbItem(queryEav); }
        var queryResponse = new QueryResponse();
        if (outputWire.TryGetValue("items", out var itemsObj) && itemsObj is List<object?> items)
        {
            queryResponse.Items = ToDdbItemList(items);
        }

        QueryResponse transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .QueryOutputTransform(new QueryOutputTransformInput
                {
                    OriginalInput = queryRequest,
                    SdkOutput = queryResponse,
                })
                .TransformedOutput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var output = new Dictionary<string, object?>();
        if (transformed.Items is { Count: > 0 })
        {
            output["items"] = FromDdbItemList(transformed.Items);
        }
        return new Dictionary<string, object?> { ["transformedOutput"] = output };
    }

    public async Task<Dictionary<string, object?>> BatchGetItemOutputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var originalWire = Wire.RequireMap(request, "originalInput");
        var outputWire = Wire.RequireMap(request, "sdkOutput");

        var requestItemsWire = Wire.RequireMap(originalWire, "requestItems");
        var sdkRequestItems = new Dictionary<string, KeysAndAttributes>();
        foreach (var (table, kaObj) in requestItemsWire)
        {
            var ka = Wire.AsMap(kaObj, "keysAndAttributes");
            if (!ka.TryGetValue("keys", out var keysObj) || keysObj is not List<object?> keys)
            {
                throw ServerException.Generic($"requestItems['{table}'].keys must be a list");
            }
            sdkRequestItems[table] = new KeysAndAttributes { Keys = ToDdbItemList(keys) };
        }
        var batchRequest = new BatchGetItemRequest { RequestItems = sdkRequestItems };

        var batchResponse = new BatchGetItemResponse();
        if (outputWire.TryGetValue("responses", out var respObj)
            && respObj is Dictionary<string, object?> respWire)
        {
            var responses = new Dictionary<string, List<Dictionary<string, AttributeValue>>>();
            foreach (var (table, listObj) in respWire)
            {
                if (listObj is not List<object?> list)
                {
                    throw ServerException.Generic($"responses['{table}'] must be a list");
                }
                responses[table] = ToDdbItemList(list);
            }
            batchResponse.Responses = responses;
        }

        BatchGetItemResponse transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .BatchGetItemOutputTransform(new BatchGetItemOutputTransformInput
                {
                    OriginalInput = batchRequest,
                    SdkOutput = batchResponse,
                })
                .TransformedOutput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var output = new Dictionary<string, object?>();
        if (transformed.Responses is { Count: > 0 })
        {
            var wireResponses = new Dictionary<string, object?>();
            foreach (var (table, items) in transformed.Responses)
            {
                wireResponses[table] = FromDdbItemList(items);
            }
            output["responses"] = wireResponses;
        }
        return new Dictionary<string, object?> { ["transformedOutput"] = output };
    }

    public async Task<Dictionary<string, object?>> BatchGetItemInputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var wire = Wire.RequireMap(request, "sdkInput");
        var requestItemsWire = Wire.RequireMap(wire, "requestItems");
        var sdkRequestItems = new Dictionary<string, KeysAndAttributes>();
        foreach (var (table, kaObj) in requestItemsWire)
        {
            var ka = Wire.AsMap(kaObj, "keysAndAttributes");
            if (!ka.TryGetValue("keys", out var keysObj) || keysObj is not List<object?> keys)
            {
                throw ServerException.Generic($"requestItems['{table}'].keys must be a list");
            }
            sdkRequestItems[table] = new KeysAndAttributes { Keys = ToDdbItemList(keys) };
        }

        BatchGetItemRequest transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .BatchGetItemInputTransform(new BatchGetItemInputTransformInput
                {
                    SdkInput = new BatchGetItemRequest { RequestItems = sdkRequestItems },
                })
                .TransformedInput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var wireItems = new Dictionary<string, object?>();
        foreach (var (table, ka) in transformed.RequestItems)
        {
            wireItems[table] = new Dictionary<string, object?>
            {
                ["keys"] = FromDdbItemList(ka.Keys),
            };
        }
        return new Dictionary<string, object?>
        {
            ["transformedInput"] = new Dictionary<string, object?> { ["requestItems"] = wireItems },
        };
    }

    public async Task<Dictionary<string, object?>> TransactGetItemsInputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var wire = Wire.RequireMap(request, "sdkInput");
        var sdkItems = ToSdkTransactGetItems(RequireList(wire, "transactItems"));

        TransactGetItemsRequest transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .TransactGetItemsInputTransform(new TransactGetItemsInputTransformInput
                {
                    SdkInput = new TransactGetItemsRequest { TransactItems = sdkItems },
                })
                .TransformedInput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        return new Dictionary<string, object?>
        {
            ["transformedInput"] = new Dictionary<string, object?>
            {
                ["transactItems"] = FromSdkTransactGetItems(transformed.TransactItems),
            },
        };
    }

    public async Task<Dictionary<string, object?>> TransactGetItemsOutputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var originalWire = Wire.RequireMap(request, "originalInput");
        var outputWire = Wire.RequireMap(request, "sdkOutput");

        var req = new TransactGetItemsRequest
        {
            TransactItems = ToSdkTransactGetItems(RequireList(originalWire, "transactItems")),
        };
        var resp = new TransactGetItemsResponse { Responses = new List<ItemResponse>() };
        if (outputWire.TryGetValue("responses", out var respObj) && respObj is List<object?> resps)
        {
            foreach (var rObj in resps)
            {
                var rMap = Wire.AsMap(rObj, "itemResponse");
                var ir = new ItemResponse();
                var itemWire = Wire.OptMap(rMap, "item");
                if (itemWire != null)
                {
                    ir.Item = ToDdbItem(itemWire);
                }
                resp.Responses.Add(ir);
            }
        }

        TransactGetItemsResponse transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .TransactGetItemsOutputTransform(new TransactGetItemsOutputTransformInput
                {
                    OriginalInput = req,
                    SdkOutput = resp,
                })
                .TransformedOutput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var output = new Dictionary<string, object?>();
        if (transformed.Responses is { Count: > 0 })
        {
            var wireResponses = new List<object?>();
            foreach (var r in transformed.Responses)
            {
                var m = new Dictionary<string, object?>();
                if (r.Item != null && r.Item.Count > 0)
                {
                    m["item"] = FromDdbItem(r.Item);
                }
                wireResponses.Add(m);
            }
            output["responses"] = wireResponses;
        }
        return new Dictionary<string, object?> { ["transformedOutput"] = output };
    }

    private static List<TransactGetItem> ToSdkTransactGetItems(List<object?> wire)
    {
        var items = new List<TransactGetItem>(wire.Count);
        foreach (var itemObj in wire)
        {
            var itemMap = Wire.AsMap(itemObj, "transactGetItem");
            var getMap = Wire.RequireMap(itemMap, "get");
            items.Add(new TransactGetItem
            {
                Get = new Get
                {
                    TableName = Wire.RequireString(getMap, "tableName"),
                    Key = ToDdbItem(Wire.RequireMap(getMap, "key")),
                },
            });
        }
        return items;
    }

    private static List<object?> FromSdkTransactGetItems(List<TransactGetItem> items)
    {
        var wire = new List<object?>(items.Count);
        foreach (var item in items)
        {
            wire.Add(new Dictionary<string, object?>
            {
                ["get"] = new Dictionary<string, object?>
                {
                    ["tableName"] = item.Get.TableName,
                    ["key"] = FromDdbItem(item.Get.Key),
                },
            });
        }
        return wire;
    }

    private static List<Dictionary<string, AttributeValue>> ToDdbItemList(List<object?> list)
    {
        var result = new List<Dictionary<string, AttributeValue>>(list.Count);
        foreach (var item in list)
        {
            result.Add(ToDdbItem(Wire.AsMap(item, "item")));
        }
        return result;
    }

    private static List<object?> FromDdbItemList(List<Dictionary<string, AttributeValue>> items)
    {
        var result = new List<object?>(items.Count);
        foreach (var item in items)
        {
            result.Add(FromDdbItem(item));
        }
        return result;
    }

    public async Task<Dictionary<string, object?>> ExecuteStatementInputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var sdkInputWire = Wire.RequireMap(request, "sdkInput");
        var sdkRequest =
            new ExecuteStatementRequest { Statement = Wire.RequireString(sdkInputWire, "statement") };

        ExecuteStatementRequest transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .ExecuteStatementInputTransform(
                    new ExecuteStatementInputTransformInput { SdkInput = sdkRequest })
                .TransformedInput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        return new Dictionary<string, object?>
        {
            ["transformedInput"] =
                new Dictionary<string, object?> { ["statement"] = transformed.Statement },
        };
    }

    public async Task<Dictionary<string, object?>> BatchExecuteStatementInputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var sdkInputWire = Wire.RequireMap(request, "sdkInput");
        if (!sdkInputWire.TryGetValue("statements", out var sObj) || sObj is not List<object?> statementsWire)
        {
            throw ServerException.Generic("statements must be a list");
        }
        var sdkStatements = new List<BatchStatementRequest>(statementsWire.Count);
        foreach (var s in statementsWire)
        {
            sdkStatements.Add(new BatchStatementRequest
            {
                Statement = Wire.RequireString(Wire.AsMap(s, "statement"), "statement"),
            });
        }
        var sdkRequest = new BatchExecuteStatementRequest { Statements = sdkStatements };

        BatchExecuteStatementRequest transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .BatchExecuteStatementInputTransform(
                    new BatchExecuteStatementInputTransformInput { SdkInput = sdkRequest })
                .TransformedInput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var wireStatements = new List<object?>(transformed.Statements.Count);
        foreach (var s in transformed.Statements)
        {
            wireStatements.Add(new Dictionary<string, object?> { ["statement"] = s.Statement });
        }
        return new Dictionary<string, object?>
        {
            ["transformedInput"] =
                new Dictionary<string, object?> { ["statements"] = wireStatements },
        };
    }

    public async Task<Dictionary<string, object?>> ExecuteTransactionInputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var sdkInputWire = Wire.RequireMap(request, "sdkInput");
        if (!sdkInputWire.TryGetValue("transactStatements", out var sObj)
            || sObj is not List<object?> statementsWire)
        {
            throw ServerException.Generic("transactStatements must be a list");
        }
        var sdkStatements = new List<ParameterizedStatement>(statementsWire.Count);
        foreach (var s in statementsWire)
        {
            sdkStatements.Add(new ParameterizedStatement
            {
                Statement = Wire.RequireString(Wire.AsMap(s, "statement"), "statement"),
            });
        }
        var sdkRequest = new ExecuteTransactionRequest { TransactStatements = sdkStatements };

        ExecuteTransactionRequest transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .ExecuteTransactionInputTransform(
                    new ExecuteTransactionInputTransformInput { SdkInput = sdkRequest })
                .TransformedInput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var wireStatements = new List<object?>(transformed.TransactStatements.Count);
        foreach (var s in transformed.TransactStatements)
        {
            wireStatements.Add(new Dictionary<string, object?> { ["statement"] = s.Statement });
        }
        return new Dictionary<string, object?>
        {
            ["transformedInput"] =
                new Dictionary<string, object?> { ["transactStatements"] = wireStatements },
        };
    }

    public async Task<Dictionary<string, object?>> ScanInputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var wire = Wire.RequireMap(request, "sdkInput");

        var scanRequest = new ScanRequest { TableName = Wire.RequireString(wire, "tableName") };
        var filter = Wire.OptString(wire, "filterExpression");
        if (filter != null)
        {
            scanRequest.FilterExpression = filter;
        }
        var names = ToStringMap(Wire.OptMap(wire, "expressionAttributeNames"));
        if (names is { Count: > 0 })
        {
            scanRequest.ExpressionAttributeNames = names;
        }
        var values = Wire.OptMap(wire, "expressionAttributeValues");
        if (values is { Count: > 0 })
        {
            scanRequest.ExpressionAttributeValues = ToDdbItem(values);
        }

        ScanRequest transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .ScanInputTransform(new ScanInputTransformInput { SdkInput = scanRequest })
                .TransformedInput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var outMap = new Dictionary<string, object?> { ["tableName"] = transformed.TableName };
        if (transformed.FilterExpression != null)
        {
            outMap["filterExpression"] = transformed.FilterExpression;
        }
        if (transformed.ExpressionAttributeNames is { Count: > 0 })
        {
            outMap["expressionAttributeNames"] = FromStringMap(transformed.ExpressionAttributeNames);
        }
        if (transformed.ExpressionAttributeValues is { Count: > 0 })
        {
            outMap["expressionAttributeValues"] = FromDdbItem(transformed.ExpressionAttributeValues);
        }
        return new Dictionary<string, object?> { ["transformedInput"] = outMap };
    }

    public async Task<Dictionary<string, object?>> QueryInputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var wire = Wire.RequireMap(request, "sdkInput");

        var queryRequest = new QueryRequest { TableName = Wire.RequireString(wire, "tableName") };
        var keyCond = Wire.OptString(wire, "keyConditionExpression");
        if (keyCond != null)
        {
            queryRequest.KeyConditionExpression = keyCond;
        }
        var filter = Wire.OptString(wire, "filterExpression");
        if (filter != null)
        {
            queryRequest.FilterExpression = filter;
        }
        var names = ToStringMap(Wire.OptMap(wire, "expressionAttributeNames"));
        if (names is { Count: > 0 })
        {
            queryRequest.ExpressionAttributeNames = names;
        }
        var values = Wire.OptMap(wire, "expressionAttributeValues");
        if (values is { Count: > 0 })
        {
            queryRequest.ExpressionAttributeValues = ToDdbItem(values);
        }

        QueryRequest transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .QueryInputTransform(new QueryInputTransformInput { SdkInput = queryRequest })
                .TransformedInput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var outMap = new Dictionary<string, object?> { ["tableName"] = transformed.TableName };
        if (transformed.KeyConditionExpression != null)
        {
            outMap["keyConditionExpression"] = transformed.KeyConditionExpression;
        }
        if (transformed.FilterExpression != null)
        {
            outMap["filterExpression"] = transformed.FilterExpression;
        }
        if (transformed.ExpressionAttributeNames is { Count: > 0 })
        {
            outMap["expressionAttributeNames"] = FromStringMap(transformed.ExpressionAttributeNames);
        }
        if (transformed.ExpressionAttributeValues is { Count: > 0 })
        {
            outMap["expressionAttributeValues"] = FromDdbItem(transformed.ExpressionAttributeValues);
        }
        return new Dictionary<string, object?> { ["transformedInput"] = outMap };
    }

    public async Task<Dictionary<string, object?>> UpdateItemInputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var wire = Wire.RequireMap(request, "sdkInput");

        var updateRequest = new UpdateItemRequest
        {
            TableName = Wire.RequireString(wire, "tableName"),
            Key = ToDdbItem(Wire.RequireMap(wire, "key")),
        };
        var update = Wire.OptString(wire, "updateExpression");
        if (update != null)
        {
            updateRequest.UpdateExpression = update;
        }
        var condition = Wire.OptString(wire, "conditionExpression");
        if (condition != null)
        {
            updateRequest.ConditionExpression = condition;
        }
        var names = ToStringMap(Wire.OptMap(wire, "expressionAttributeNames"));
        if (names is { Count: > 0 })
        {
            updateRequest.ExpressionAttributeNames = names;
        }
        var values = Wire.OptMap(wire, "expressionAttributeValues");
        if (values is { Count: > 0 })
        {
            updateRequest.ExpressionAttributeValues = ToDdbItem(values);
        }

        UpdateItemRequest transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .UpdateItemInputTransform(new UpdateItemInputTransformInput { SdkInput = updateRequest })
                .TransformedInput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var outMap = new Dictionary<string, object?>
        {
            ["tableName"] = transformed.TableName,
            ["key"] = FromDdbItem(transformed.Key),
        };
        if (transformed.UpdateExpression != null)
        {
            outMap["updateExpression"] = transformed.UpdateExpression;
        }
        if (transformed.ConditionExpression != null)
        {
            outMap["conditionExpression"] = transformed.ConditionExpression;
        }
        if (transformed.ExpressionAttributeNames is { Count: > 0 })
        {
            outMap["expressionAttributeNames"] = FromStringMap(transformed.ExpressionAttributeNames);
        }
        if (transformed.ExpressionAttributeValues is { Count: > 0 })
        {
            outMap["expressionAttributeValues"] = FromDdbItem(transformed.ExpressionAttributeValues);
        }
        return new Dictionary<string, object?> { ["transformedInput"] = outMap };
    }

    public async Task<Dictionary<string, object?>> DeleteItemInputTransform(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var wire = Wire.RequireMap(request, "sdkInput");

        var deleteRequest = new DeleteItemRequest
        {
            TableName = Wire.RequireString(wire, "tableName"),
            Key = ToDdbItem(Wire.RequireMap(wire, "key")),
        };
        var condition = Wire.OptString(wire, "conditionExpression");
        if (condition != null)
        {
            deleteRequest.ConditionExpression = condition;
        }
        var names = ToStringMap(Wire.OptMap(wire, "expressionAttributeNames"));
        if (names is { Count: > 0 })
        {
            deleteRequest.ExpressionAttributeNames = names;
        }
        var values = Wire.OptMap(wire, "expressionAttributeValues");
        if (values is { Count: > 0 })
        {
            deleteRequest.ExpressionAttributeValues = ToDdbItem(values);
        }

        DeleteItemRequest transformed;
        await handle.OpLock.WaitAsync();
        try
        {
            transformed = handle.Transforms
                .DeleteItemInputTransform(new DeleteItemInputTransformInput { SdkInput = deleteRequest })
                .TransformedInput;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }

        var outMap = new Dictionary<string, object?>
        {
            ["tableName"] = transformed.TableName,
            ["key"] = FromDdbItem(transformed.Key),
        };
        if (transformed.ConditionExpression != null)
        {
            outMap["conditionExpression"] = transformed.ConditionExpression;
        }
        if (transformed.ExpressionAttributeNames is { Count: > 0 })
        {
            outMap["expressionAttributeNames"] = FromStringMap(transformed.ExpressionAttributeNames);
        }
        if (transformed.ExpressionAttributeValues is { Count: > 0 })
        {
            outMap["expressionAttributeValues"] = FromDdbItem(transformed.ExpressionAttributeValues);
        }
        return new Dictionary<string, object?> { ["transformedInput"] = outMap };
    }

    public async Task<Dictionary<string, object?>> GetNumberOfQueries(
        Dictionary<string, object?> request)
    {
        var handle = _transformsRegistry.Get(Wire.RequireString(request, "clientId"));
        var wire = Wire.RequireMap(request, "sdkInput");

        var queryRequest = new QueryRequest { TableName = Wire.RequireString(wire, "tableName") };
        var keyCond = Wire.OptString(wire, "keyConditionExpression");
        if (keyCond != null)
        {
            queryRequest.KeyConditionExpression = keyCond;
        }
        var filter = Wire.OptString(wire, "filterExpression");
        if (filter != null)
        {
            queryRequest.FilterExpression = filter;
        }
        var names = ToStringMap(Wire.OptMap(wire, "expressionAttributeNames"));
        if (names is { Count: > 0 })
        {
            queryRequest.ExpressionAttributeNames = names;
        }
        var values = Wire.OptMap(wire, "expressionAttributeValues");
        if (values is { Count: > 0 })
        {
            queryRequest.ExpressionAttributeValues = ToDdbItem(values);
        }

        int numberOfQueries;
        await handle.OpLock.WaitAsync();
        try
        {
            numberOfQueries = handle.Transforms
                .GetNumberOfQueries(new GetNumberOfQueriesInput { Input = queryRequest })
                .NumberOfQueries;
        }
        catch (Exception e)
        {
            throw ServerException.Client(e.Message);
        }
        finally
        {
            handle.OpLock.Release();
        }
        return new Dictionary<string, object?> { ["numberOfQueries"] = numberOfQueries };
    }

    private static Dictionary<string, string>? ToStringMap(Dictionary<string, object?>? wire)
    {
        if (wire == null)
        {
            return null;
        }
        var result = new Dictionary<string, string>(wire.Count);
        foreach (var (k, v) in wire)
        {
            if (v is not string s)
            {
                throw ServerException.Generic($"expressionAttributeNames['{k}'] must be a string");
            }
            result[k] = s;
        }
        return result;
    }

    private static Dictionary<string, object?> FromStringMap(Dictionary<string, string> sdk)
    {
        var result = new Dictionary<string, object?>(sdk.Count);
        foreach (var (k, v) in sdk)
        {
            result[k] = v;
        }
        return result;
    }

    // -----------------------------------------------------------------------
    // AttributeValue conversion (wire scalars <-> AWS SDK AttributeValue)
    // -----------------------------------------------------------------------

    private static Dictionary<string, AttributeValue> ToDdbItem(Dictionary<string, object?> item)
    {
        var result = new Dictionary<string, AttributeValue>(item.Count);
        foreach (var (name, value) in item)
        {
            result[name] = ToDdbValue(Wire.AsMap(value, $"attribute '{name}'"));
        }
        return result;
    }

    private static AttributeValue ToDdbValue(Dictionary<string, object?> value)
    {
        if (value.TryGetValue("S", out var s) && s is string str)
        {
            return new AttributeValue { S = str };
        }
        if (value.TryGetValue("N", out var n) && n is string num)
        {
            return new AttributeValue { N = num };
        }
        if (value.TryGetValue("B", out var b) && b is byte[] bytes)
        {
            return new AttributeValue { B = new MemoryStream(bytes) };
        }
        if (value.TryGetValue("BOOL", out var flag) && flag is bool boolean)
        {
            return new AttributeValue { BOOL = boolean };
        }
        if (value.TryGetValue("NULL", out var isNull) && isNull is bool)
        {
            return new AttributeValue { NULL = true };
        }
        if (value.TryGetValue("SS", out var ss) && ss is List<object?> ssList)
        {
            var set = new List<string>(ssList.Count);
            foreach (var e in ssList)
            {
                set.Add((string)e!);
            }
            return new AttributeValue { SS = set };
        }
        if (value.TryGetValue("NS", out var ns) && ns is List<object?> nsList)
        {
            var set = new List<string>(nsList.Count);
            foreach (var e in nsList)
            {
                set.Add((string)e!);
            }
            return new AttributeValue { NS = set };
        }
        if (value.TryGetValue("BS", out var bs) && bs is List<object?> bsList)
        {
            var set = new List<MemoryStream>(bsList.Count);
            foreach (var e in bsList)
            {
                set.Add(new MemoryStream((byte[])e!));
            }
            return new AttributeValue { BS = set };
        }
        if (value.TryGetValue("L", out var l) && l is List<object?> lList)
        {
            var list = new List<AttributeValue>(lList.Count);
            foreach (var e in lList)
            {
                list.Add(ToDdbValue(Wire.AsMap(e, "list element")));
            }
            return new AttributeValue { L = list };
        }
        if (value.TryGetValue("M", out var m) && m is Dictionary<string, object?> mMap)
        {
            return new AttributeValue { M = ToDdbItem(mMap) };
        }
        throw ServerException.Generic(
            "AttributeValue had no supported member set "
                + "(expected one of S/N/B/BOOL/NULL/SS/NS/BS/L/M)");
    }

    private static Dictionary<string, object?> FromDdbItem(Dictionary<string, AttributeValue> item)
    {
        var result = new Dictionary<string, object?>(item.Count);
        foreach (var (name, value) in item)
        {
            result[name] = FromDdbValue(value);
        }
        return result;
    }

    private static Dictionary<string, object?> FromDdbValue(AttributeValue value)
    {
        if (value.S != null)
        {
            return new Dictionary<string, object?> { ["S"] = value.S };
        }
        if (value.N != null)
        {
            return new Dictionary<string, object?> { ["N"] = value.N };
        }
        if (value.B != null)
        {
            return new Dictionary<string, object?> { ["B"] = value.B.ToArray() };
        }
        if (value.BOOL != null)
        {
            return new Dictionary<string, object?> { ["BOOL"] = value.BOOL.Value };
        }
        if (value.NULL != null)
        {
            return new Dictionary<string, object?> { ["NULL"] = true };
        }
        if (value.IsSSSet)
        {
            var set = new List<object?>(value.SS.Count);
            foreach (var s in value.SS)
            {
                set.Add(s);
            }
            return new Dictionary<string, object?> { ["SS"] = set };
        }
        if (value.IsNSSet)
        {
            var set = new List<object?>(value.NS.Count);
            foreach (var s in value.NS)
            {
                set.Add(s);
            }
            return new Dictionary<string, object?> { ["NS"] = set };
        }
        if (value.IsBSSet)
        {
            var set = new List<object?>(value.BS.Count);
            foreach (var ms in value.BS)
            {
                set.Add(ms.ToArray());
            }
            return new Dictionary<string, object?> { ["BS"] = set };
        }
        if (value.IsLSet)
        {
            var list = new List<object?>(value.L.Count);
            foreach (var av in value.L)
            {
                list.Add(FromDdbValue(av));
            }
            return new Dictionary<string, object?> { ["L"] = list };
        }
        if (value.IsMSet)
        {
            return new Dictionary<string, object?> { ["M"] = FromDdbItem(value.M) };
        }
        throw ServerException.Generic(
            "unsupported AttributeValue variant from DBE "
                + "(supported: S/N/B/BOOL/NULL/SS/NS/BS/L/M)");
    }
}
