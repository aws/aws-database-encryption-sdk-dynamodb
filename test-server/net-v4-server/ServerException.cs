// The two modeled errors, mirroring the Java ErrorClassifier and the Rust
// error.rs: a failure originating inside the real DBE library becomes a
// DBESDKClientError (its message forwarded unmodified); any framework failure
// (bad clientId, malformed request, unsupported/unwired variant, missing
// member) becomes a GenericServerError. Both are modeled @error("client"), so
// both serialize as HTTP 400 with a CBOR body carrying __type + message.

namespace Aws.Cryptography.Dbesdk.TestServer;

internal sealed class ServerException : Exception
{
    public const string Namespace = "aws.cryptography.dbesdk.testserver";

    public enum Kind
    {
        /// TestServer-framework failure -> GenericServerError.
        Generic,

        /// DBE-library-origin failure -> DBESDKClientError (message unmodified).
        Client,
    }

    public Kind ErrorKind { get; }

    private ServerException(Kind kind, string message) : base(message)
    {
        ErrorKind = kind;
    }

    /// The fully-qualified Smithy shape id used as the rpcv2Cbor __type
    /// discriminator; smithy clients match on the shape name after '#'.
    public string TypeId =>
        $"{Namespace}#{(ErrorKind == Kind.Generic ? "GenericServerError" : "DBESDKClientError")}";

    public static ServerException Generic(string message) => new(Kind.Generic, message);

    public static ServerException Client(string message) => new(Kind.Client, message);
}
