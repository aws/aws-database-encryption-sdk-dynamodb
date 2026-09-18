// DB-ESDK TestServer — Rust Language_Server entry point + rpcv2Cbor transport.
//
// There is no smithy-rs rpcv2Cbor server codegen available, so the transport is
// hand-written, exactly as the Java server hand-wrote its rpcv2Cbor codec. The
// protocol is small and fully specified:
//   * request:  POST /service/DBESDKTestServer/operation/<Operation>
//               header `smithy-protocol: rpc-v2-cbor`, CBOR body
//   * response: header `smithy-protocol: rpc-v2-cbor`, `Content-Type:
//               application/cbor`, CBOR body
//   * error:    HTTP 400 + CBOR body carrying `__type` (fully-qualified shape
//               id) and `message`
//
// The one wire contract is shared with the Java server (both are the commons
// Smithy model), so the single generated Java Test_Client speaks to either.

mod error;
mod factory;
mod handlers;
mod model;
mod registry;

use crate::error::ServerError;
use crate::handlers::AppState;
use aws_db_esdk::material_providers::client as mpl_client;
use aws_db_esdk::material_providers::types::material_providers_config::MaterialProvidersConfig;
use axum::body::{Body, Bytes};
use axum::extract::{Path, State};
use axum::http::header::CONTENT_TYPE;
use axum::http::StatusCode;
use axum::response::Response;
use axum::routing::post;
use axum::Router;
use serde::Serialize;
use std::net::SocketAddr;
use std::sync::Arc;

const SMITHY_PROTOCOL_HEADER: &str = "smithy-protocol";
const RPC_V2_CBOR: &str = "rpc-v2-cbor";
const CBOR_CONTENT_TYPE: &str = "application/cbor";
const DEFAULT_PORT: u16 = 8080;

#[tokio::main]
async fn main() {
    let port = std::env::args()
        .nth(1)
        .and_then(|arg| arg.trim().parse::<u16>().ok())
        .unwrap_or(DEFAULT_PORT);

    // Build the shared Material Providers client and resolve the ambient AWS
    // config once. Neither touches the network; KMS is reached only on
    // Encrypt/Decrypt. Region comes from the ambient AWS_REGION the launcher
    // sets (us-west-2 for the KMS_Test_Resources key).
    let mpl = mpl_client::Client::from_conf(
        MaterialProvidersConfig::builder()
            .build()
            .expect("MaterialProvidersConfig has no required fields"),
    )
    .expect("failed to build the Material Providers client");
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;

    let state = AppState {
        mpl: Arc::new(mpl),
        sdk_config: Arc::new(sdk_config),
        registry: registry::ClientRegistry::new(),
    };

    let app = Router::new()
        .route(
            "/service/DBESDKTestServer/operation/:operation",
            post(dispatch),
        )
        .with_state(state);

    let addr = SocketAddr::from(([127, 0, 0, 1], port));
    let listener = tokio::net::TcpListener::bind(addr)
        .await
        .unwrap_or_else(|e| panic!("failed to bind {addr}: {e}"));

    // The orchestrate / smoke scripts grep for this exact phrase to detect
    // readiness — keep it byte-for-byte aligned with the Java bootstrap line.
    println!("DB-ESDK TestServer (Rust) listening at http://127.0.0.1:{port}");

    axum::serve(listener, app)
        .await
        .expect("server terminated unexpectedly");
}

/// Route a single rpcv2Cbor operation call: decode the CBOR request, run the
/// handler, and encode the CBOR response (or a modeled error).
async fn dispatch(
    State(state): State<AppState>,
    Path(operation): Path<String>,
    body: Bytes,
) -> Response {
    let result = match operation.as_str() {
        "CreateClient" => match decode(&body) {
            Ok(request) => handlers::create_client(&state, request).await.map(ok_body),
            Err(e) => Err(e),
        },
        "EncryptItem" => match decode(&body) {
            Ok(request) => handlers::encrypt_item(&state, request).await.map(ok_body),
            Err(e) => Err(e),
        },
        "DecryptItem" => match decode(&body) {
            Ok(request) => handlers::decrypt_item(&state, request).await.map(ok_body),
            Err(e) => Err(e),
        },
        "GetEncryptedDataKeyDescription" => match decode(&body) {
            Ok(request) => handlers::get_encrypted_data_key_description(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "GetNumberOfQueries" => match decode(&body) {
            Ok(request) => handlers::get_number_of_queries(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "CreateTransformsClient" => match decode(&body) {
            Ok(request) => handlers::create_transforms_client(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "PutItemInputTransform" => match decode(&body) {
            Ok(request) => handlers::put_item_input_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "PutItemOutputTransform" => match decode(&body) {
            Ok(request) => handlers::put_item_output_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "UpdateItemOutputTransform" => match decode(&body) {
            Ok(request) => handlers::update_item_output_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "DeleteItemOutputTransform" => match decode(&body) {
            Ok(request) => handlers::delete_item_output_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "TransactWriteItemsOutputTransform" => match decode(&body) {
            Ok(request) => handlers::transact_write_items_output_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "ExecuteStatementOutputTransform" => match decode(&body) {
            Ok(request) => handlers::execute_statement_output_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "ExecuteTransactionOutputTransform" => match decode(&body) {
            Ok(request) => handlers::execute_transaction_output_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "BatchExecuteStatementOutputTransform" => match decode(&body) {
            Ok(request) => handlers::batch_execute_statement_output_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "GetItemOutputTransform" => match decode(&body) {
            Ok(request) => handlers::get_item_output_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "GetItemInputTransform" => match decode(&body) {
            Ok(request) => handlers::get_item_input_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "BatchGetItemInputTransform" => match decode(&body) {
            Ok(request) => handlers::batch_get_item_input_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "TransactGetItemsInputTransform" => match decode(&body) {
            Ok(request) => handlers::transact_get_items_input_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "TransactGetItemsOutputTransform" => match decode(&body) {
            Ok(request) => handlers::transact_get_items_output_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "BatchWriteItemInputTransform" => match decode(&body) {
            Ok(request) => handlers::batch_write_item_input_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "TransactWriteItemsInputTransform" => match decode(&body) {
            Ok(request) => handlers::transact_write_items_input_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "ScanOutputTransform" => match decode(&body) {
            Ok(request) => handlers::scan_output_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "QueryOutputTransform" => match decode(&body) {
            Ok(request) => handlers::query_output_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "BatchGetItemOutputTransform" => match decode(&body) {
            Ok(request) => handlers::batch_get_item_output_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "ExecuteStatementInputTransform" => match decode(&body) {
            Ok(request) => handlers::execute_statement_input_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "BatchExecuteStatementInputTransform" => match decode(&body) {
            Ok(request) => handlers::batch_execute_statement_input_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "ExecuteTransactionInputTransform" => match decode(&body) {
            Ok(request) => handlers::execute_transaction_input_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "BatchWriteItemOutputTransform" => match decode(&body) {
            Ok(request) => handlers::batch_write_item_output_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "ScanInputTransform" => match decode(&body) {
            Ok(request) => handlers::scan_input_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "QueryInputTransform" => match decode(&body) {
            Ok(request) => handlers::query_input_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "UpdateItemInputTransform" => match decode(&body) {
            Ok(request) => handlers::update_item_input_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        "DeleteItemInputTransform" => match decode(&body) {
            Ok(request) => handlers::delete_item_input_transform(&state, request)
                .await
                .map(ok_body),
            Err(e) => Err(e),
        },
        // Structured Encryption is gated Rust-unsupported (aws-db-esdk exposes it
        // as pub(crate)); the `structured-encryption` feature marks it so, and no
        // Test reaches these ops on a Rust server.
        "CreateStructuredClient" | "EncryptStructure" | "DecryptStructure"
        | "EncryptPathStructure" | "DecryptPathStructure" | "ResolveAuthActions" => {
            Err(ServerError::Generic(
                "Structured Encryption is not supported by the Rust TestServer".into(),
            ))
        }
        other => Err(ServerError::Generic(format!("unknown operation '{other}'"))),
    };

    match result {
        Ok(response) => response,
        Err(err) => error_response(&err),
    }
}

/// Decode a CBOR request body into the operation input, mapping any malformed
/// input to a GenericServerError (a framework failure, per the Java classifier).
fn decode<T: serde::de::DeserializeOwned>(body: &Bytes) -> Result<T, ServerError> {
    ciborium::from_reader(body.as_ref())
        .map_err(|e| ServerError::Generic(format!("malformed rpcv2Cbor request body: {e}")))
}

/// Encode a successful operation output as an rpcv2Cbor response.
fn ok_body<T: Serialize>(value: T) -> Response {
    let mut buf = Vec::new();
    ciborium::into_writer(&value, &mut buf).expect("output serialization is infallible");
    Response::builder()
        .status(StatusCode::OK)
        .header(SMITHY_PROTOCOL_HEADER, RPC_V2_CBOR)
        .header(CONTENT_TYPE, CBOR_CONTENT_TYPE)
        .body(Body::from(buf))
        .expect("valid response")
}

/// Encode a modeled error as an rpcv2Cbor error response (HTTP 400 + `__type`).
fn error_response(err: &ServerError) -> Response {
    #[derive(Serialize)]
    struct WireError<'a> {
        #[serde(rename = "__type")]
        type_id: String,
        message: &'a str,
    }
    let mut buf = Vec::new();
    let wire = WireError {
        type_id: err.type_id(),
        message: err.message(),
    };
    ciborium::into_writer(&wire, &mut buf).expect("error serialization is infallible");
    Response::builder()
        .status(StatusCode::BAD_REQUEST)
        .header(SMITHY_PROTOCOL_HEADER, RPC_V2_CBOR)
        .header(CONTENT_TYPE, CBOR_CONTENT_TYPE)
        .body(Body::from(buf))
        .expect("valid error response")
}
