// Translates a wire DBEClientConfig (a generic CBOR tree, see Cbor.cs) into a
// real DBE DynamoDbItemEncryptor, building the keyring (or CMM) from the
// Material Providers Library. Mirrors the Java ItemEncryptorFactory and the
// Rust factory.rs, including the recursion over the Multi keyring and the
// Default / RequiredEncryptionContext CMMs.
//
// KMS keyrings are handed an AmazonKeyManagementServiceClient in the key's own
// region (KMS rejects an ARN whose region differs from the client's), exactly
// as the Rust factory's kms_client_for_key does. No KMS call happens at
// construction; the network is touched only on EncryptItem / DecryptItem.
//
// The Caching CMM is deferred (throws a GenericServerError): no CachingCMM
// factory exists in the pinned MPL. It is not reached by any current Test. Every
// other variant — including the AwsKmsRsa and AwsKmsHierarchical keyrings — is
// fully wired.
//
// A construction failure (a bad config, an MPL validation error, or the item
// encryptor constructor throwing) is a framework failure -> GenericServerError,
// matching the Java CreateClient handler and the Rust factory.

using Amazon;
using Amazon.KeyManagementService;
using Amazon.KeyManagementService.Model;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms;
using AWS.Cryptography.KeyStore;
using AWS.Cryptography.MaterialProviders;
using StructuredEncryption = AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;

namespace Aws.Cryptography.Dbesdk.TestServer;

internal sealed class ItemEncryptorFactory
{
    private readonly MaterialProviders _mpl;

    public ItemEncryptorFactory(MaterialProviders mpl)
    {
        _mpl = mpl;
    }

    public DynamoDbItemEncryptor Build(Dictionary<string, object?> config)
    {
        var dbeConfig = new DynamoDbItemEncryptorConfig
        {
            LogicalTableName = Wire.RequireString(config, "logicalTableName"),
            PartitionKeyName = Wire.RequireString(config, "partitionKeyName"),
            AttributeActionsOnEncrypt =
                CryptoActions(Wire.RequireMap(config, "attributeActionsOnEncrypt")),
        };

        var sortKeyName = Wire.OptString(config, "sortKeyName");
        if (sortKeyName != null)
        {
            dbeConfig.SortKeyName = sortKeyName;
        }

        var prefix = Wire.OptString(config, "allowedUnsignedAttributePrefix");
        if (prefix != null)
        {
            dbeConfig.AllowedUnsignedAttributePrefix = prefix;
        }

        var allowedUnsigned = Wire.OptStringList(config, "allowedUnsignedAttributes");
        if (allowedUnsigned is { Count: > 0 })
        {
            dbeConfig.AllowedUnsignedAttributes = allowedUnsigned;
        }

        var suite = Wire.OptString(config, "algorithmSuiteId");
        if (suite != null)
        {
            dbeConfig.AlgorithmSuiteId = AlgorithmSuite(suite);
        }

        var plaintextOverride = Wire.OptString(config, "plaintextOverride");
        if (plaintextOverride != null)
        {
            dbeConfig.PlaintextOverride = PlaintextOverrideOf(plaintextOverride);
        }

        var keyring = Wire.OptMap(config, "keyring");
        var cmm = Wire.OptMap(config, "cmm");
        if (keyring != null && cmm == null)
        {
            dbeConfig.Keyring = BuildKeyring(keyring);
        }
        else if (keyring == null && cmm != null)
        {
            dbeConfig.Cmm = BuildCmm(cmm);
        }
        else if (keyring != null)
        {
            throw ServerException.Generic(
                "config set both keyring and cmm; exactly one is required");
        }
        else
        {
            throw ServerException.Generic(
                "config set neither keyring nor cmm; exactly one is required");
        }

        try
        {
            return new DynamoDbItemEncryptor(dbeConfig);
        }
        catch (ServerException)
        {
            throw;
        }
        catch (Exception e)
        {
            throw ServerException.Generic($"failed to build item encryptor: {e.Message}");
        }
    }

    /// Build a DBE DDB-SDK transforms client bound to one physical table.
    /// Reuses the same recursive keyring/CMM construction and Crypto Action
    /// mapping as the item encryptor; only the target config type differs
    /// (DynamoDbTableEncryptionConfig rather than DynamoDbItemEncryptorConfig).
    public DynamoDbEncryptionTransforms BuildTransforms(
        Dictionary<string, object?> config, string tableName, List<object?>? additionalTables)
    {
        var tableConfigs = new Dictionary<string, DynamoDbTableEncryptionConfig>
        {
            [tableName] = BuildTableConfig(config),
        };
        if (additionalTables != null)
        {
            foreach (var entry in additionalTables)
            {
                var extra = Wire.AsMap(entry, "additional table");
                tableConfigs[Wire.RequireString(extra, "tableName")] =
                    BuildTableConfig(Wire.RequireMap(extra, "config"));
            }
        }

        var tablesConfig = new DynamoDbTablesEncryptionConfig
        {
            TableEncryptionConfigs = tableConfigs,
        };

        try
        {
            return new DynamoDbEncryptionTransforms(tablesConfig);
        }
        catch (ServerException)
        {
            throw;
        }
        catch (Exception e)
        {
            throw ServerException.Generic($"failed to build transforms client: {e.Message}");
        }
    }

    /// Build one table's DynamoDbTableEncryptionConfig from its wire config.
    private DynamoDbTableEncryptionConfig BuildTableConfig(Dictionary<string, object?> config)
    {
        var tableConfig = new DynamoDbTableEncryptionConfig
        {
            LogicalTableName = Wire.RequireString(config, "logicalTableName"),
            PartitionKeyName = Wire.RequireString(config, "partitionKeyName"),
            AttributeActionsOnEncrypt =
                CryptoActions(Wire.RequireMap(config, "attributeActionsOnEncrypt")),
        };

        var sortKeyName = Wire.OptString(config, "sortKeyName");
        if (sortKeyName != null)
        {
            tableConfig.SortKeyName = sortKeyName;
        }

        var prefix = Wire.OptString(config, "allowedUnsignedAttributePrefix");
        if (prefix != null)
        {
            tableConfig.AllowedUnsignedAttributePrefix = prefix;
        }

        var allowedUnsigned = Wire.OptStringList(config, "allowedUnsignedAttributes");
        if (allowedUnsigned is { Count: > 0 })
        {
            tableConfig.AllowedUnsignedAttributes = allowedUnsigned;
        }

        var suite = Wire.OptString(config, "algorithmSuiteId");
        if (suite != null)
        {
            tableConfig.AlgorithmSuiteId = AlgorithmSuite(suite);
        }

        var keyring = Wire.OptMap(config, "keyring");
        var cmm = Wire.OptMap(config, "cmm");
        if (keyring != null && cmm == null)
        {
            tableConfig.Keyring = BuildKeyring(keyring);
        }
        else if (keyring == null && cmm != null)
        {
            tableConfig.Cmm = BuildCmm(cmm);
        }
        else if (keyring != null)
        {
            throw ServerException.Generic(
                "config set both keyring and cmm; exactly one is required");
        }
        else
        {
            throw ServerException.Generic(
                "config set neither keyring nor cmm; exactly one is required");
        }

        var search = Wire.OptMap(config, "search");
        if (search != null)
        {
            tableConfig.Search = BuildSearchConfig(search);
        }

        return tableConfig;
    }

    /// Build a DBE SearchConfig (beacons) from the wire config. The beacon key
    /// store's DynamoDB and KMS clients are derived from the KMS key ARN's
    /// region (no explicit clients), so the key store reaches KeyStoreDdbTable
    /// with the ambient credentials.
    private static SearchConfig BuildSearchConfig(Dictionary<string, object?> search)
    {
        if (!search.TryGetValue("versions", out var versionsObj)
            || versionsObj is not List<object?> versionsWire)
        {
            throw ServerException.Generic("search.versions must be a list");
        }

        var versions = new List<BeaconVersion>(versionsWire.Count);
        foreach (var vObj in versionsWire)
        {
            var v = Wire.AsMap(vObj, "beacon version");
            var ks = Wire.RequireMap(v, "keyStore");
            var keyStore = new AWS.Cryptography.KeyStore.KeyStore(new KeyStoreConfig
            {
                DdbTableName = Wire.RequireString(ks, "ddbTableName"),
                LogicalKeyStoreName = Wire.RequireString(ks, "logicalKeyStoreName"),
                KmsConfiguration = new KMSConfiguration
                {
                    KmsKeyArn = Wire.RequireString(ks, "kmsKeyArn"),
                },
            });

            var single = Wire.RequireMap(Wire.RequireMap(v, "keySource"), "single");
            var keySource = new BeaconKeySource
            {
                Single = new SingleKeyStore
                {
                    KeyId = Wire.RequireString(single, "keyId"),
                    CacheTTL = Wire.RequireInt(single, "cacheTtlSeconds"),
                },
            };

            var beaconVersion = new BeaconVersion
            {
                Version = Wire.RequireInt(v, "version"),
                KeyStore = keyStore,
                KeySource = keySource,
            };
            if (v.TryGetValue("standardBeacons", out var beaconsObj)
                && beaconsObj is List<object?> beaconsWire && beaconsWire.Count > 0)
            {
                var beacons = new List<StandardBeacon>(beaconsWire.Count);
                foreach (var bObj in beaconsWire)
                {
                    var b = Wire.AsMap(bObj, "standard beacon");
                    var sb = new StandardBeacon
                    {
                        Name = Wire.RequireString(b, "name"),
                        Length = Wire.RequireInt(b, "length"),
                    };
                    var loc = Wire.OptString(b, "loc");
                    if (loc != null)
                    {
                        sb.Loc = loc;
                    }
                    if (b.TryGetValue("numberOfPartitions", out var npObj) && npObj is long npl)
                    {
                        sb.NumberOfPartitions = checked((int)npl);
                    }
                    if (Wire.OptMap(b, "style") is { } style)
                    {
                        sb.Style = BuildBeaconStyle(style);
                    }
                    beacons.Add(sb);
                }
                beaconVersion.StandardBeacons = beacons;
            }
            if (v.TryGetValue("virtualFields", out var vfObj)
                && vfObj is List<object?> vfWire && vfWire.Count > 0)
            {
                beaconVersion.VirtualFields = BuildVirtualFields(vfWire);
            }
            if (v.TryGetValue("encryptedParts", out var epObj)
                && epObj is List<object?> epWire && epWire.Count > 0)
            {
                beaconVersion.EncryptedParts = BuildEncryptedParts(epWire);
            }
            if (v.TryGetValue("signedParts", out var spObj)
                && spObj is List<object?> spWire && spWire.Count > 0)
            {
                beaconVersion.SignedParts = BuildSignedParts(spWire);
            }
            if (v.TryGetValue("compoundBeacons", out var cbObj)
                && cbObj is List<object?> cbWire && cbWire.Count > 0)
            {
                beaconVersion.CompoundBeacons = BuildCompoundBeacons(cbWire);
            }
            if (v.TryGetValue("maximumNumberOfPartitions", out var maxObj) && maxObj is long maxl)
            {
                beaconVersion.MaximumNumberOfPartitions = checked((int)maxl);
            }
            if (v.TryGetValue("defaultNumberOfPartitions", out var defObj) && defObj is long defl)
            {
                beaconVersion.DefaultNumberOfPartitions = checked((int)defl);
            }
            versions.Add(beaconVersion);
        }

        return new SearchConfig
        {
            Versions = versions,
            WriteVersion = search.TryGetValue("writeVersion", out var wv) && wv is long l
                ? checked((int)l)
                : 1,
        };
    }

    private static List<VirtualField> BuildVirtualFields(List<object?> wire)
    {
        var fields = new List<VirtualField>(wire.Count);
        foreach (var fObj in wire)
        {
            var f = Wire.AsMap(fObj, "virtual field");
            var partsWire = f.TryGetValue("parts", out var pObj)
                && pObj is List<object?> pl
                ? pl
                : throw ServerException.Generic("virtual field requires parts");
            var parts = new List<VirtualPart>(partsWire.Count);
            foreach (var pObj2 in partsWire)
            {
                var p = Wire.AsMap(pObj2, "virtual part");
                var part = new VirtualPart { Loc = Wire.RequireString(p, "loc") };
                if (p.TryGetValue("trans", out var tObj)
                    && tObj is List<object?> transWire && transWire.Count > 0)
                {
                    part.Trans = BuildVirtualTransforms(transWire);
                }
                parts.Add(part);
            }
            fields.Add(new VirtualField { Name = Wire.RequireString(f, "name"), Parts = parts });
        }
        return fields;
    }

    private static BeaconStyle BuildBeaconStyle(Dictionary<string, object?> style)
    {
        if (Wire.OptMap(style, "partOnly") is not null)
        {
            return new BeaconStyle { PartOnly = new PartOnly() };
        }
        if (Wire.OptMap(style, "asSet") is not null)
        {
            return new BeaconStyle { AsSet = new AsSet() };
        }
        if (Wire.OptMap(style, "shared") is { } shared)
        {
            return new BeaconStyle { Shared = new Shared { Other = Wire.RequireString(shared, "other") } };
        }
        if (Wire.OptMap(style, "sharedSet") is { } sharedSet)
        {
            return new BeaconStyle { SharedSet = new SharedSet { Other = Wire.RequireString(sharedSet, "other") } };
        }
        throw ServerException.Generic("BeaconStyle had no member set");
    }

    private static List<VirtualTransform> BuildVirtualTransforms(List<object?> wire)
    {
        var transforms = new List<VirtualTransform>(wire.Count);
        foreach (var tObj in wire)
        {
            var t = Wire.AsMap(tObj, "virtual transform");
            if (Wire.OptMap(t, "upper") is not null)
            {
                transforms.Add(new VirtualTransform { Upper = new Upper() });
            }
            else if (Wire.OptMap(t, "lower") is not null)
            {
                transforms.Add(new VirtualTransform { Lower = new Lower() });
            }
            else if (Wire.OptMap(t, "insert") is { } insert)
            {
                transforms.Add(new VirtualTransform
                {
                    Insert = new Insert { Literal = Wire.RequireString(insert, "literal") },
                });
            }
            else if (Wire.OptMap(t, "prefix") is { } prefix)
            {
                transforms.Add(new VirtualTransform
                {
                    Prefix = new GetPrefix { Length = Wire.RequireInt(prefix, "length") },
                });
            }
            else if (Wire.OptMap(t, "suffix") is { } suffix)
            {
                transforms.Add(new VirtualTransform
                {
                    Suffix = new GetSuffix { Length = Wire.RequireInt(suffix, "length") },
                });
            }
            else if (Wire.OptMap(t, "substring") is { } substring)
            {
                transforms.Add(new VirtualTransform
                {
                    Substring = new GetSubstring
                    {
                        Low = Wire.RequireInt(substring, "low"),
                        High = Wire.RequireInt(substring, "high"),
                    },
                });
            }
            else if (Wire.OptMap(t, "segment") is { } segment)
            {
                transforms.Add(new VirtualTransform
                {
                    Segment = new GetSegment
                    {
                        Split = Wire.RequireString(segment, "split"),
                        Index = Wire.RequireInt(segment, "index"),
                    },
                });
            }
            else if (Wire.OptMap(t, "segments") is { } segments)
            {
                transforms.Add(new VirtualTransform
                {
                    Segments = new GetSegments
                    {
                        Split = Wire.RequireString(segments, "split"),
                        Low = Wire.RequireInt(segments, "low"),
                        High = Wire.RequireInt(segments, "high"),
                    },
                });
            }
            else
            {
                throw ServerException.Generic("VirtualTransform had no member set");
            }
        }
        return transforms;
    }

    private static List<EncryptedPart> BuildEncryptedParts(List<object?> wire)
    {
        var parts = new List<EncryptedPart>(wire.Count);
        foreach (var pObj in wire)
        {
            var p = Wire.AsMap(pObj, "encrypted part");
            parts.Add(new EncryptedPart
            {
                Name = Wire.RequireString(p, "name"),
                Prefix = Wire.RequireString(p, "prefix"),
            });
        }
        return parts;
    }

    private static List<SignedPart> BuildSignedParts(List<object?> wire)
    {
        var parts = new List<SignedPart>(wire.Count);
        foreach (var pObj in wire)
        {
            var p = Wire.AsMap(pObj, "signed part");
            var sp = new SignedPart
            {
                Name = Wire.RequireString(p, "name"),
                Prefix = Wire.RequireString(p, "prefix"),
            };
            var loc = Wire.OptString(p, "loc");
            if (loc != null)
            {
                sp.Loc = loc;
            }
            parts.Add(sp);
        }
        return parts;
    }

    private static List<CompoundBeacon> BuildCompoundBeacons(List<object?> wire)
    {
        var beacons = new List<CompoundBeacon>(wire.Count);
        foreach (var cObj in wire)
        {
            var c = Wire.AsMap(cObj, "compound beacon");
            var cb = new CompoundBeacon
            {
                Name = Wire.RequireString(c, "name"),
                Split = Wire.RequireString(c, "split"),
            };
            if (c.TryGetValue("encrypted", out var eObj)
                && eObj is List<object?> eWire && eWire.Count > 0)
            {
                cb.Encrypted = BuildEncryptedParts(eWire);
            }
            if (c.TryGetValue("signed", out var sObj)
                && sObj is List<object?> sWire && sWire.Count > 0)
            {
                cb.Signed = BuildSignedParts(sWire);
            }
            if (c.TryGetValue("constructors", out var ctorObj)
                && ctorObj is List<object?> ctorWire && ctorWire.Count > 0)
            {
                var constructors = new List<Constructor>(ctorWire.Count);
                foreach (var ctorItem in ctorWire)
                {
                    var ctor = Wire.AsMap(ctorItem, "constructor");
                    var ctorPartsWire = ctor.TryGetValue("parts", out var cpObj)
                        && cpObj is List<object?> cpl
                        ? cpl
                        : throw ServerException.Generic("constructor requires parts");
                    var ctorParts = new List<ConstructorPart>(ctorPartsWire.Count);
                    foreach (var cpItem in ctorPartsWire)
                    {
                        var cp = Wire.AsMap(cpItem, "constructor part");
                        ctorParts.Add(new ConstructorPart
                        {
                            Name = Wire.RequireString(cp, "name"),
                            Required = cp.TryGetValue("required", out var rq) && rq is bool rb && rb,
                        });
                    }
                    constructors.Add(new Constructor { Parts = ctorParts });
                }
                cb.Constructors = constructors;
            }
            beacons.Add(cb);
        }
        return beacons;
    }

    public static Dictionary<string, StructuredEncryption.CryptoAction> CryptoActions(
        Dictionary<string, object?> actions)
    {
        var result = new Dictionary<string, StructuredEncryption.CryptoAction>(actions.Count);
        foreach (var (name, value) in actions)
        {
            if (value is not string action)
            {
                throw ServerException.Generic($"crypto action for '{name}' must be a string");
            }
            result[name] = action switch
            {
                "ENCRYPT_AND_SIGN" => StructuredEncryption.CryptoAction.ENCRYPT_AND_SIGN,
                "SIGN_ONLY" => StructuredEncryption.CryptoAction.SIGN_ONLY,
                "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT" =>
                    StructuredEncryption.CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
                "DO_NOTHING" => StructuredEncryption.CryptoAction.DO_NOTHING,
                _ => throw ServerException.Generic($"unknown CryptoAction '{action}'"),
            };
        }
        return result;
    }

    private static DBEAlgorithmSuiteId AlgorithmSuite(string suite) => suite switch
    {
        "ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384" =>
            DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384,
        "ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384" =>
            DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384,
        _ => throw ServerException.Generic($"unknown DBEAlgorithmSuiteId '{suite}'"),
    };

    private static PlaintextOverride PlaintextOverrideOf(string value) => value switch
    {
        "FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ" =>
            PlaintextOverride.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ,
        "FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ" =>
            PlaintextOverride.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ,
        "FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ" =>
            PlaintextOverride.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ,
        _ => throw ServerException.Generic($"unknown PlaintextOverride '{value}'"),
    };

    // -----------------------------------------------------------------------
    // Keyrings (tagged-union-as-struct; exactly one member set; Multi recurses)
    // -----------------------------------------------------------------------

    private IKeyring BuildKeyring(Dictionary<string, object?> keyring)
    {
        if (Wire.OptMap(keyring, "RawAes") is { } rawAes)
        {
            var input = new CreateRawAesKeyringInput
            {
                KeyNamespace = Wire.RequireString(rawAes, "keyNamespace"),
                KeyName = Wire.RequireString(rawAes, "keyName"),
                WrappingKey = new MemoryStream(Wire.RequireBytes(rawAes, "wrappingKey")),
                WrappingAlg = AesWrappingAlgOf(Wire.RequireString(rawAes, "wrappingAlg")),
            };
            return Create(() => _mpl.CreateRawAesKeyring(input));
        }
        if (Wire.OptMap(keyring, "AwsKms") is { } kms)
        {
            var keyId = Wire.RequireString(kms, "kmsKeyId");
            var input = new CreateAwsKmsKeyringInput
            {
                KmsKeyId = keyId,
                KmsClient = KmsClientForKey(keyId),
            };
            var tokens = Wire.OptStringList(kms, "grantTokens");
            if (tokens is { Count: > 0 })
            {
                input.GrantTokens = tokens;
            }
            return Create(() => _mpl.CreateAwsKmsKeyring(input));
        }
        if (Wire.OptMap(keyring, "AwsKmsMrk") is { } mrk)
        {
            var keyId = Wire.RequireString(mrk, "kmsKeyId");
            var input = new CreateAwsKmsMrkKeyringInput
            {
                KmsKeyId = keyId,
                KmsClient = KmsClientForKey(keyId),
            };
            var tokens = Wire.OptStringList(mrk, "grantTokens");
            if (tokens is { Count: > 0 })
            {
                input.GrantTokens = tokens;
            }
            return Create(() => _mpl.CreateAwsKmsMrkKeyring(input));
        }
        if (Wire.OptMap(keyring, "AwsKmsMultiKeyring") is { } kmsMulti)
        {
            var input = new CreateAwsKmsMultiKeyringInput();
            var generator = Wire.OptString(kmsMulti, "generator");
            if (generator != null)
            {
                input.Generator = generator;
            }
            var keyIds = Wire.OptStringList(kmsMulti, "kmsKeyIds");
            if (keyIds is { Count: > 0 })
            {
                input.KmsKeyIds = keyIds;
            }
            var tokens = Wire.OptStringList(kmsMulti, "grantTokens");
            if (tokens is { Count: > 0 })
            {
                input.GrantTokens = tokens;
            }
            return Create(() => _mpl.CreateAwsKmsMultiKeyring(input));
        }
        if (Wire.OptMap(keyring, "AwsKmsMrkMultiKeyring") is { } mrkMulti)
        {
            var input = new CreateAwsKmsMrkMultiKeyringInput();
            var generator = Wire.OptString(mrkMulti, "generator");
            if (generator != null)
            {
                input.Generator = generator;
            }
            var keyIds = Wire.OptStringList(mrkMulti, "kmsKeyIds");
            if (keyIds is { Count: > 0 })
            {
                input.KmsKeyIds = keyIds;
            }
            var tokens = Wire.OptStringList(mrkMulti, "grantTokens");
            if (tokens is { Count: > 0 })
            {
                input.GrantTokens = tokens;
            }
            return Create(() => _mpl.CreateAwsKmsMrkMultiKeyring(input));
        }
        if (Wire.OptMap(keyring, "AwsKmsDiscovery") is { } discovery)
        {
            var input = new CreateAwsKmsDiscoveryKeyringInput
            {
                KmsClient = new AmazonKeyManagementServiceClient(),
            };
            if (Wire.OptMap(discovery, "discoveryFilter") is { } filter)
            {
                input.DiscoveryFilter = DiscoveryFilterOf(filter);
            }
            var tokens = Wire.OptStringList(discovery, "grantTokens");
            if (tokens is { Count: > 0 })
            {
                input.GrantTokens = tokens;
            }
            return Create(() => _mpl.CreateAwsKmsDiscoveryKeyring(input));
        }
        if (Wire.OptMap(keyring, "AwsKmsMrkDiscovery") is { } mrkDiscovery)
        {
            var region = Wire.RequireString(mrkDiscovery, "region");
            var input = new CreateAwsKmsMrkDiscoveryKeyringInput
            {
                KmsClient = new AmazonKeyManagementServiceClient(
                    RegionEndpoint.GetBySystemName(region)),
                Region = region,
            };
            if (Wire.OptMap(mrkDiscovery, "discoveryFilter") is { } filter)
            {
                input.DiscoveryFilter = DiscoveryFilterOf(filter);
            }
            var tokens = Wire.OptStringList(mrkDiscovery, "grantTokens");
            if (tokens is { Count: > 0 })
            {
                input.GrantTokens = tokens;
            }
            return Create(() => _mpl.CreateAwsKmsMrkDiscoveryKeyring(input));
        }
        if (Wire.OptMap(keyring, "RawRsa") is { } rawRsa)
        {
            var input = new CreateRawRsaKeyringInput
            {
                KeyNamespace = Wire.RequireString(rawRsa, "keyNamespace"),
                KeyName = Wire.RequireString(rawRsa, "keyName"),
                PaddingScheme = PaddingSchemeOf(Wire.RequireString(rawRsa, "paddingScheme")),
            };
            var publicKey = Wire.OptBytes(rawRsa, "publicKey");
            if (publicKey != null)
            {
                input.PublicKey = new MemoryStream(publicKey);
            }
            var privateKey = Wire.OptBytes(rawRsa, "privateKey");
            if (privateKey != null)
            {
                input.PrivateKey = new MemoryStream(privateKey);
            }
            return Create(() => _mpl.CreateRawRsaKeyring(input));
        }
        if (Wire.OptMap(keyring, "Multi") is { } multi)
        {
            var input = new CreateMultiKeyringInput
            {
                ChildKeyrings = new List<IKeyring>(),
            };
            if (Wire.OptMap(multi, "generator") is { } generator)
            {
                input.Generator = BuildKeyring(generator);
            }
            if (multi.TryGetValue("childKeyrings", out var childrenValue)
                && childrenValue is List<object?> children)
            {
                foreach (var child in children)
                {
                    input.ChildKeyrings.Add(BuildKeyring(Wire.AsMap(child, "child keyring")));
                }
            }
            return Create(() => _mpl.CreateMultiKeyring(input));
        }
        if (Wire.OptMap(keyring, "AwsKmsRsa") is { } rsa)
        {
            var keyId = Wire.RequireString(rsa, "kmsKeyId");
            var kmsClient = KmsClientForKey(keyId);
            // The MPL AwsKmsRsa keyring wraps client-side with the RSA public key
            // (KMS Decrypt on read). Supply it as PEM; fetch from KMS GetPublicKey
            // (DER) when the config omits it.
            var inlineKey = Wire.OptBytes(rsa, "publicKey");
            byte[] pem = inlineKey != null
                ? ToPublicKeyPem(inlineKey)
                : ToPublicKeyPem(kmsClient.GetPublicKeyAsync(
                    new GetPublicKeyRequest { KeyId = keyId }).GetAwaiter().GetResult()
                    .PublicKey.ToArray());
            var input = new CreateAwsKmsRsaKeyringInput
            {
                KmsKeyId = keyId,
                PublicKey = new MemoryStream(pem),
                EncryptionAlgorithm = RsaEncryptionAlgorithmOf(Wire.OptString(rsa, "encryptionAlgorithm")),
                KmsClient = kmsClient,
            };
            var tokens = Wire.OptStringList(rsa, "grantTokens");
            if (tokens is { Count: > 0 })
            {
                input.GrantTokens = tokens;
            }
            return Create(() => _mpl.CreateAwsKmsRsaKeyring(input));
        }
        if (Wire.OptMap(keyring, "AwsKmsHierarchical") is { } hierarchical)
        {
            // Branch keys live in a DynamoDB key store and are wrapped by a KMS
            // key. The keystore's DDB/KMS clients are derived from the KMS key
            // ARN's region (no explicit clients), matching BuildSearchConfig.
            var keyStore = new AWS.Cryptography.KeyStore.KeyStore(new KeyStoreConfig
            {
                DdbTableName = Wire.RequireString(hierarchical, "keyStoreTableName"),
                LogicalKeyStoreName = Wire.RequireString(hierarchical, "logicalKeyStoreName"),
                KmsConfiguration = new KMSConfiguration
                {
                    KmsKeyArn = Wire.RequireString(hierarchical, "kmsKeyArn"),
                },
            });
            var input = new CreateAwsKmsHierarchicalKeyringInput
            {
                KeyStore = keyStore,
                TtlSeconds = Wire.RequireInt(hierarchical, "ttlSeconds"),
            };
            // A declarative branchKeyIdSupplier routes each item to a branch key
            // by the string value of one attribute; when it is absent, a single
            // fixed branchKeyId is used. The two are mutually exclusive on the
            // MPL keyring input.
            if (Wire.OptMap(hierarchical, "branchKeyIdSupplier") is { } supplierConfig)
            {
                input.BranchKeyIdSupplier = BuildBranchKeyIdSupplier(supplierConfig);
            }
            else
            {
                input.BranchKeyId = Wire.RequireString(hierarchical, "branchKeyId");
            }
            return Create(() => _mpl.CreateAwsKmsHierarchicalKeyring(input));
        }
        throw ServerException.Generic("Keyring had no variant member set");
    }

    // Build the MPL IBranchKeyIdSupplier the hierarchical keyring consumes from a
    // declarative { routeAttribute, routes } config. The wrapping is done by
    // CreateDynamoDbEncryptionBranchKeyIdSupplier on the top-level
    // DynamoDbEncryption service (no keyring/CMM needed) — the same service the
    // GetEncryptedDataKeyDescription handler constructs.
    private static AWS.Cryptography.MaterialProviders.IBranchKeyIdSupplier BuildBranchKeyIdSupplier(
        Dictionary<string, object?> supplierConfig)
    {
        var routeAttribute = Wire.RequireString(supplierConfig, "routeAttribute");
        var routesWire = Wire.RequireMap(supplierConfig, "routes");
        // routes is a map<String,String> on the wire; RequireMap exposes it as
        // Dictionary<string,object?>, so pull each value back out as a string
        // (RequireString validates the value type per entry).
        var routes = new Dictionary<string, string>(routesWire.Count);
        foreach (var routeKey in routesWire.Keys)
        {
            routes[routeKey] = Wire.RequireString(routesWire, routeKey);
        }

        var ddbKeySupplier = new RouteAttributeBranchKeyIdSupplier(routeAttribute, routes);
        return new DynamoDbEncryption(new DynamoDbEncryptionConfig())
            .CreateDynamoDbEncryptionBranchKeyIdSupplier(
                new CreateDynamoDbEncryptionBranchKeyIdSupplierInput
                {
                    DdbKeyBranchKeyIdSupplier = ddbKeySupplier,
                })
            .BranchKeyIdSupplier;
    }

    // Maps a DynamoDB item to a branch key id by the string (.S) value of a single
    // route attribute, per a fixed route table. A missing/non-string attribute or
    // an unmapped value is a framework failure (GenericServerError), matching the
    // rest of the factory's construction-time failure handling.
    private sealed class RouteAttributeBranchKeyIdSupplier : DynamoDbKeyBranchKeyIdSupplierBase
    {
        private readonly string _routeAttribute;
        private readonly Dictionary<string, string> _routes;

        public RouteAttributeBranchKeyIdSupplier(string routeAttribute, Dictionary<string, string> routes)
        {
            _routeAttribute = routeAttribute;
            _routes = routes;
        }

        protected override GetBranchKeyIdFromDdbKeyOutput _GetBranchKeyIdFromDdbKey(GetBranchKeyIdFromDdbKeyInput input)
        {
            if (!input.DdbKey.TryGetValue(_routeAttribute, out var attr) || attr.S is not { } routeValue)
            {
                throw ServerException.Generic(
                    $"branchKeyIdSupplier: item has no string attribute '{_routeAttribute}'");
            }
            if (!_routes.TryGetValue(routeValue, out var branchKeyId))
            {
                throw ServerException.Generic(
                    $"branchKeyIdSupplier: no route for attribute '{_routeAttribute}' value '{routeValue}'");
            }
            return new GetBranchKeyIdFromDdbKeyOutput { BranchKeyId = branchKeyId };
        }
    }

    // -----------------------------------------------------------------------
    // CMMs (recursive; exactly one member set)
    // -----------------------------------------------------------------------

    /// Build a CMM from a DBEClientConfig for the Structured Encryption client:
    /// a keyring-only config is wrapped in a Default CMM (Encrypt/DecryptStructure
    /// take a CMM, not a keyring, per operation); otherwise the config's CMM is
    /// built directly.
    public ICryptographicMaterialsManager CmmFor(Dictionary<string, object?> config)
    {
        if (Wire.OptMap(config, "keyring") is { } keyring)
        {
            return CreateCmm(() => _mpl.CreateDefaultCryptographicMaterialsManager(
                new CreateDefaultCryptographicMaterialsManagerInput { Keyring = BuildKeyring(keyring) }));
        }
        return BuildCmm(Wire.RequireMap(config, "cmm"));
    }

    private ICryptographicMaterialsManager BuildCmm(Dictionary<string, object?> cmm)
    {
        if (Wire.OptMap(cmm, "Default") is { } defaultCmm)
        {
            var keyring = BuildKeyring(Wire.RequireMap(defaultCmm, "keyring"));
            return CreateCmm(() => _mpl.CreateDefaultCryptographicMaterialsManager(
                new CreateDefaultCryptographicMaterialsManagerInput { Keyring = keyring }));
        }
        if (Wire.OptMap(cmm, "RequiredEncryptionContext") is { } requiredEc)
        {
            var underlying = BuildCmm(Wire.RequireMap(requiredEc, "underlyingCMM"));
            var keys = Wire.OptStringList(requiredEc, "requiredEncryptionContextKeys")
                ?? new List<string>();
            return CreateCmm(() => _mpl.CreateRequiredEncryptionContextCMM(
                new CreateRequiredEncryptionContextCMMInput
                {
                    UnderlyingCMM = underlying,
                    RequiredEncryptionContextKeys = keys,
                }));
        }
        if (cmm.ContainsKey("Caching"))
        {
            throw ServerException.Generic(
                "Caching CMM is not wired in this pass of the .NET TestServer");
        }
        throw ServerException.Generic(
            "CryptographicMaterialsManager had no variant member set");
    }

    // -----------------------------------------------------------------------
    // Enum / helper mappers
    // -----------------------------------------------------------------------

    private static AesWrappingAlg AesWrappingAlgOf(string alg) => alg switch
    {
        "ALG_AES128_GCM_IV12_TAG16" => AesWrappingAlg.ALG_AES128_GCM_IV12_TAG16,
        "ALG_AES192_GCM_IV12_TAG16" => AesWrappingAlg.ALG_AES192_GCM_IV12_TAG16,
        "ALG_AES256_GCM_IV12_TAG16" => AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16,
        _ => throw ServerException.Generic($"unknown AesWrappingAlg '{alg}'"),
    };

    private static PaddingScheme PaddingSchemeOf(string scheme) => scheme switch
    {
        "PKCS1" => PaddingScheme.PKCS1,
        "OAEP_SHA1_MGF1" => PaddingScheme.OAEP_SHA1_MGF1,
        "OAEP_SHA256_MGF1" => PaddingScheme.OAEP_SHA256_MGF1,
        "OAEP_SHA384_MGF1" => PaddingScheme.OAEP_SHA384_MGF1,
        "OAEP_SHA512_MGF1" => PaddingScheme.OAEP_SHA512_MGF1,
        _ => throw ServerException.Generic($"unknown PaddingScheme '{scheme}'"),
    };

    private static DiscoveryFilter DiscoveryFilterOf(Dictionary<string, object?> filter)
    {
        var accountIds = Wire.OptStringList(filter, "accountIds")
            ?? throw ServerException.Generic("discoveryFilter.accountIds is required");
        return new DiscoveryFilter
        {
            Partition = Wire.RequireString(filter, "partition"),
            AccountIds = accountIds,
        };
    }

    /// The KMS client in the key's own region (KMS rejects an ARN whose region
    /// differs from the client's). Falls back to the ambient region for a bare
    /// key id or alias. Mirrors the Rust kms_client_for_key.
    private static byte[] ToPublicKeyPem(byte[] key)
    {
        var head = System.Text.Encoding.ASCII.GetString(key, 0, System.Math.Min(key.Length, 10));
        if (head.StartsWith("-----BEGIN"))
        {
            return key;
        }
        var base64 = System.Convert.ToBase64String(key);
        var sb = new System.Text.StringBuilder("-----BEGIN PUBLIC KEY-----\n");
        for (int i = 0; i < base64.Length; i += 64)
        {
            sb.Append(base64, i, System.Math.Min(64, base64.Length - i)).Append('\n');
        }
        sb.Append("-----END PUBLIC KEY-----\n");
        return System.Text.Encoding.ASCII.GetBytes(sb.ToString());
    }

    private static EncryptionAlgorithmSpec RsaEncryptionAlgorithmOf(string? algorithm)
    {
        return algorithm == "RSAES_OAEP_SHA_1"
            ? EncryptionAlgorithmSpec.RSAES_OAEP_SHA_1
            : EncryptionAlgorithmSpec.RSAES_OAEP_SHA_256;
    }

    private static IAmazonKeyManagementService KmsClientForKey(string keyId)
    {
        var region = RegionForKey(keyId);
        return region != null
            ? new AmazonKeyManagementServiceClient(RegionEndpoint.GetBySystemName(region))
            : new AmazonKeyManagementServiceClient();
    }

    private static string? RegionForKey(string keyId)
    {
        if (keyId.StartsWith("arn:", StringComparison.Ordinal))
        {
            var parts = keyId.Split(':');
            if (parts.Length > 3 && parts[3].Length > 0)
            {
                return parts[3];
            }
        }
        return null;
    }

    private static IKeyring Create(Func<IKeyring> build)
    {
        try
        {
            return build();
        }
        catch (ServerException)
        {
            throw;
        }
        catch (Exception e)
        {
            throw ServerException.Generic($"keyring construction failed: {e.Message}");
        }
    }

    private static ICryptographicMaterialsManager CreateCmm(
        Func<ICryptographicMaterialsManager> build)
    {
        try
        {
            return build();
        }
        catch (ServerException)
        {
            throw;
        }
        catch (Exception e)
        {
            throw ServerException.Generic($"CMM construction failed: {e.Message}");
        }
    }
}
