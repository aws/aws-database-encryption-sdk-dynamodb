// DB-ESDK TestServer — .NET Language_Server entry point + rpcv2Cbor transport.
//
// There is no smithy-dotnet rpcv2Cbor server codegen available, so the
// transport is hand-written on ASP.NET Core / Kestrel, exactly as the Java and
// Rust servers hand-wrote theirs. The protocol is small and fully specified:
//   * request:  POST /service/DBESDKTestServer/operation/<Operation>
//               header `smithy-protocol: rpc-v2-cbor`, CBOR body
//   * response: header `smithy-protocol: rpc-v2-cbor`, `Content-Type:
//               application/cbor`, CBOR body
//   * error:    HTTP 400 + CBOR body carrying `__type` (fully-qualified shape
//               id) and `message`
//
// The one wire contract is shared with the Java and Rust servers, so the single
// generated Java Test_Client speaks to any of them.

using System.Net;
using Aws.Cryptography.Dbesdk.TestServer;

const string SmithyProtocolHeader = "smithy-protocol";
const string RpcV2Cbor = "rpc-v2-cbor";
const string CborContentType = "application/cbor";
const int DefaultPort = 8080;

int port = args.Length > 0 && int.TryParse(args[0].Trim(), out var parsed) ? parsed : DefaultPort;

// Raise the threadpool floor so a burst of requests across distinct clients
// (each doing one blocking synchronous DBE operation) does not wait on the
// pool's slow ramp. Same-client concurrency is serialized asynchronously by the
// per-client gate, so waiters do not consume these threads.
ThreadPool.GetMinThreads(out var minWorker, out var minIo);
ThreadPool.SetMinThreads(Math.Max(minWorker, 64), minIo);

var builder = WebApplication.CreateBuilder();
// Keep stdout to our single readiness line (+ warnings/errors); the launcher
// greps that exact phrase and waits on TCP readiness.
builder.Logging.ClearProviders();
builder.Logging.AddConsole();
builder.Logging.SetMinimumLevel(LogLevel.Warning);
builder.WebHost.ConfigureKestrel(options => options.Listen(IPAddress.Loopback, port));

var handlers = new Handlers();
var app = builder.Build();

app.MapPost("/service/DBESDKTestServer/operation/{operation}",
    async (string operation, HttpContext context) =>
    {
        byte[] body;
        using (var buffer = new MemoryStream())
        {
            await context.Request.Body.CopyToAsync(buffer);
            body = buffer.ToArray();
        }

        int status;
        byte[] payload;
        try
        {
            var input = Wire.AsMap(Cbor.Decode(body), "request body");
            var output = operation switch
            {
                "CreateClient" => handlers.CreateClient(input),
                "EncryptItem" => await handlers.EncryptItem(input),
                "DecryptItem" => await handlers.DecryptItem(input),
                "GetEncryptedDataKeyDescription" =>
                    handlers.GetEncryptedDataKeyDescription(input),
                "GetNumberOfQueries" => await handlers.GetNumberOfQueries(input),
                "CreateTransformsClient" => handlers.CreateTransformsClient(input),
                "CreateStructuredClient" => handlers.CreateStructuredClient(input),
                "EncryptStructure" => await handlers.EncryptStructure(input),
                "DecryptStructure" => await handlers.DecryptStructure(input),
                "EncryptPathStructure" => await handlers.EncryptPathStructure(input),
                "DecryptPathStructure" => await handlers.DecryptPathStructure(input),
                "ResolveAuthActions" => handlers.ResolveAuthActions(input),
                "PutItemInputTransform" => await handlers.PutItemInputTransform(input),
                "PutItemOutputTransform" => await handlers.PutItemOutputTransform(input),
                "UpdateItemOutputTransform" => await handlers.UpdateItemOutputTransform(input),
                "DeleteItemOutputTransform" => await handlers.DeleteItemOutputTransform(input),
                "TransactWriteItemsOutputTransform" => await handlers.TransactWriteItemsOutputTransform(input),
                "ExecuteStatementOutputTransform" => await handlers.ExecuteStatementOutputTransform(input),
                "ExecuteTransactionOutputTransform" => await handlers.ExecuteTransactionOutputTransform(input),
                "BatchExecuteStatementOutputTransform" => await handlers.BatchExecuteStatementOutputTransform(input),
                "GetItemOutputTransform" => await handlers.GetItemOutputTransform(input),
                "GetItemInputTransform" => await handlers.GetItemInputTransform(input),
                "BatchGetItemInputTransform" => await handlers.BatchGetItemInputTransform(input),
                "TransactGetItemsInputTransform" => await handlers.TransactGetItemsInputTransform(input),
                "TransactGetItemsOutputTransform" => await handlers.TransactGetItemsOutputTransform(input),
                "BatchWriteItemInputTransform" =>
                    await handlers.BatchWriteItemInputTransform(input),
                "TransactWriteItemsInputTransform" =>
                    await handlers.TransactWriteItemsInputTransform(input),
                "ScanOutputTransform" => await handlers.ScanOutputTransform(input),
                "QueryOutputTransform" => await handlers.QueryOutputTransform(input),
                "BatchGetItemOutputTransform" =>
                    await handlers.BatchGetItemOutputTransform(input),
                "ExecuteStatementInputTransform" =>
                    await handlers.ExecuteStatementInputTransform(input),
                "BatchExecuteStatementInputTransform" =>
                    await handlers.BatchExecuteStatementInputTransform(input),
                "ExecuteTransactionInputTransform" =>
                    await handlers.ExecuteTransactionInputTransform(input),
                "BatchWriteItemOutputTransform" =>
                    await handlers.BatchWriteItemOutputTransform(input),
                "ScanInputTransform" => await handlers.ScanInputTransform(input),
                "QueryInputTransform" => await handlers.QueryInputTransform(input),
                "UpdateItemInputTransform" =>
                    await handlers.UpdateItemInputTransform(input),
                "DeleteItemInputTransform" =>
                    await handlers.DeleteItemInputTransform(input),
                _ => throw ServerException.Generic($"unknown operation '{operation}'"),
            };
            status = StatusCodes.Status200OK;
            payload = Cbor.Encode(output);
        }
        catch (ServerException serverError)
        {
            status = StatusCodes.Status400BadRequest;
            payload = EncodeError(serverError);
        }
        catch (Exception unexpected)
        {
            // Any non-modeled framework failure (e.g. a malformed CBOR body) is
            // a GenericServerError, per the operation wrapper.
            status = StatusCodes.Status400BadRequest;
            payload = EncodeError(ServerException.Generic(
                $"unexpected server error: {unexpected.Message}"));
        }

        context.Response.StatusCode = status;
        context.Response.Headers[SmithyProtocolHeader] = RpcV2Cbor;
        context.Response.ContentType = CborContentType;
        await context.Response.Body.WriteAsync(payload);
    });

// Bind the listener before announcing readiness, so the launcher's TCP probe
// and the smoke script's phrase grep both see a server that is actually up.
await app.StartAsync();
Console.WriteLine($"DB-ESDK TestServer (.NET) listening at http://127.0.0.1:{port}");
await app.WaitForShutdownAsync();

static byte[] EncodeError(ServerException error) => Cbor.Encode(
    new Dictionary<string, object?>
    {
        ["__type"] = error.TypeId,
        ["message"] = error.Message,
    });
