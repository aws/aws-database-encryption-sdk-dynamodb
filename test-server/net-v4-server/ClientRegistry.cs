// clientId -> real DBE item encryptor cache. CreateClient builds one encryptor,
// registers it under a fresh UUID, and returns the id; EncryptItem / DecryptItem
// look it up. Mirrors the Java ClientRegistry and the Rust registry.rs.
//
// Each registered client carries a per-client gate (OpLock) that serializes
// operations on THAT client. The DBE (Dafny-transpiled) client blocks a thread
// for its KMS call and guards its keyring with an internal mutex; ASP.NET Core
// dispatches each request on its own threadpool thread, so concurrent requests
// on one clientId would call the synchronous DBE client concurrently and
// deadlock/corrupt the runtime (the Rust server hit exactly this: it accepted
// TCP but answered nothing). Holding OpLock across a client's operation removes
// the concurrency the DBE client cannot tolerate; distinct clients own distinct
// gates, so cross-pair work still runs in parallel.
//
// The gate is a SemaphoreSlim awaited asynchronously (not a blocking Monitor
// lock): a waiting request must NOT hold a threadpool thread while it waits, or
// a burst of requests on one client starves the pool and Kestrel starts timing
// requests out (observed as sporadic 408s at 32 concurrent). With WaitAsync the
// waiters suspend without a thread; only the single in-flight operation holds
// one. This is the .NET analog of the Rust server's async op_lock.

using AWS.Cryptography.DbEncryptionSDK.DynamoDb.ItemEncryptor;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms;
using AWS.Cryptography.MaterialProviders;

namespace Aws.Cryptography.Dbesdk.TestServer;

internal sealed class ClientRegistry
{
    internal sealed class Handle
    {
        public required DynamoDbItemEncryptor Encryptor { get; init; }

        /// Serializes operations on this client (see the class comment).
        /// Awaited asynchronously so waiting requests do not pin threadpool
        /// threads.
        public SemaphoreSlim OpLock { get; } = new(1, 1);
    }

    private readonly Dictionary<string, Handle> _clients = new();
    private readonly object _registryLock = new();

    /// Register a freshly-built encryptor and return its non-empty UUID id.
    public string Register(DynamoDbItemEncryptor encryptor)
    {
        var id = Guid.NewGuid().ToString();
        var handle = new Handle { Encryptor = encryptor };
        lock (_registryLock)
        {
            _clients[id] = handle;
        }
        return id;
    }

    /// Resolve a registered client handle, or a GenericServerError naming the
    /// bad id.
    public Handle Get(string clientId)
    {
        lock (_registryLock)
        {
            if (_clients.TryGetValue(clientId, out var handle))
            {
                return handle;
            }
        }
        throw ServerException.Generic($"unknown clientId '{clientId}'");
    }
}

/// clientId -> real DBE DDB-SDK transforms client cache. Kept separate from the
/// item-encryptor registry so the two client kinds never collide on an id. Each
/// handle carries the same per-client OpLock: the transforms client is a DBE
/// (Dafny-transpiled) client with the same no-concurrent-calls constraint.
internal sealed class TransformsRegistry
{
    internal sealed class Handle
    {
        public required DynamoDbEncryptionTransforms Transforms { get; init; }

        public SemaphoreSlim OpLock { get; } = new(1, 1);
    }

    private readonly Dictionary<string, Handle> _clients = new();
    private readonly object _registryLock = new();

    /// Register a freshly-built transforms client and return its UUID id.
    public string Register(DynamoDbEncryptionTransforms transforms)
    {
        var id = Guid.NewGuid().ToString();
        var handle = new Handle { Transforms = transforms };
        lock (_registryLock)
        {
            _clients[id] = handle;
        }
        return id;
    }

    /// Resolve a registered transforms client handle, or a GenericServerError
    /// naming the bad id.
    public Handle Get(string clientId)
    {
        lock (_registryLock)
        {
            if (_clients.TryGetValue(clientId, out var handle))
            {
                return handle;
            }
        }
        throw ServerException.Generic($"unknown transforms clientId '{clientId}'");
    }
}

/// clientId -> the CMM a Structured Encryption client was configured with. The
/// StructuredEncryption client itself is shared (stateless; the CMM is a
/// per-operation input), so only the CMM is stored per id. Same per-client
/// OpLock: the CMM wraps a DBE (Dafny-transpiled) keyring with the same
/// no-concurrent-calls constraint.
internal sealed class StructuredRegistry
{
    internal sealed class Handle
    {
        public required ICryptographicMaterialsManager Cmm { get; init; }

        public SemaphoreSlim OpLock { get; } = new(1, 1);
    }

    private readonly Dictionary<string, Handle> _clients = new();
    private readonly object _registryLock = new();

    /// Register a freshly-built CMM and return its UUID id.
    public string Register(ICryptographicMaterialsManager cmm)
    {
        var id = Guid.NewGuid().ToString();
        var handle = new Handle { Cmm = cmm };
        lock (_registryLock)
        {
            _clients[id] = handle;
        }
        return id;
    }

    /// Resolve a registered structured client handle, or a GenericServerError
    /// naming the bad id.
    public Handle Get(string clientId)
    {
        lock (_registryLock)
        {
            if (_clients.TryGetValue(clientId, out var handle))
            {
                return handle;
            }
        }
        throw ServerException.Generic($"unknown structured clientId '{clientId}'");
    }
}
