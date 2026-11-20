// Maps handler failures onto the two modeled error shapes, mirroring the Java
// `ErrorClassifier`: a failure originating inside the real DBE library becomes a
// `DBESDKClientError` (its message forwarded unmodified); any framework failure
// (bad clientId, malformed request, unsupported/unwired variant) becomes a
// `GenericServerError`. Both are modeled `@error("client")`, so both serialize
// with HTTP 400 and a CBOR body carrying `__type` + `message`.

pub const NAMESPACE: &str = "aws.cryptography.dbesdk.testserver";

#[derive(Debug)]
pub enum ServerError {
    /// TestServer-framework failure -> GenericServerError.
    Generic(String),
    /// DBE-library-origin failure -> DBESDKClientError (message unmodified).
    Client(String),
}

impl ServerError {
    /// The fully-qualified Smithy shape id used as the rpcv2Cbor `__type`
    /// discriminator. smithy clients match on the shape name after `#`.
    pub fn type_id(&self) -> String {
        let shape = match self {
            ServerError::Generic(_) => "GenericServerError",
            ServerError::Client(_) => "DBESDKClientError",
        };
        format!("{NAMESPACE}#{shape}")
    }

    pub fn message(&self) -> &str {
        match self {
            ServerError::Generic(m) | ServerError::Client(m) => m,
        }
    }
}
