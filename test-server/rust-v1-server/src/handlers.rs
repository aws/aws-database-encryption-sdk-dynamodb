// The three operation handlers: CreateClient / EncryptItem / DecryptItem.
// They delegate to the real DBE `item_encryptor` client and translate between
// the wire `AttributeValue` (scalars only) and the AWS SDK's `AttributeValue`
// that the item encryptor consumes and produces.
//
// A DBE-library failure on Encrypt/Decrypt becomes a DBESDKClientError (this is
// the failure a tamper test asserts on); a bad clientId or an unsupported wire
// value is a GenericServerError.

use crate::error::ServerError;
use crate::factory;
use crate::model;
use crate::registry::ClientRegistry;
use aws_config::SdkConfig;
use aws_db_esdk::dynamodb::client::Client as DbeClient;
use aws_db_esdk::dynamodb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfig;
use aws_db_esdk::dynamodb::types::GetEncryptedDataKeyDescriptionUnion;
use aws_db_esdk::material_providers::client::Client as MplClient;
use aws_sdk_dynamodb::operation::batch_get_item::{
    BatchGetItemInput as SdkBatchGetItemInput, BatchGetItemOutput as SdkBatchGetItemOutput,
};
use aws_sdk_dynamodb::operation::transact_get_items::{
    TransactGetItemsInput as SdkTransactGetItemsInput,
    TransactGetItemsOutput as SdkTransactGetItemsOutput,
};
use aws_sdk_dynamodb::operation::batch_write_item::{
    BatchWriteItemInput as SdkBatchWriteItemInput, BatchWriteItemOutput as SdkBatchWriteItemOutput,
};
use aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput as SdkBatchExecuteStatementInput;
use aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput as SdkBatchExecuteStatementOutput;
use aws_sdk_dynamodb::operation::delete_item::DeleteItemInput as SdkDeleteItemInput;
use aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput as SdkDeleteItemOutput;
use aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput as SdkExecuteStatementInput;
use aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput as SdkExecuteStatementOutput;
use aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput as SdkExecuteTransactionInput;
use aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput as SdkExecuteTransactionOutput;
use aws_sdk_dynamodb::operation::get_item::{
    GetItemInput as SdkGetItemInput, GetItemOutput as SdkGetItemOutput,
};
use aws_sdk_dynamodb::operation::put_item::PutItemInput as SdkPutItemInput;
use aws_sdk_dynamodb::operation::put_item::PutItemOutput as SdkPutItemOutput;
use aws_sdk_dynamodb::operation::query::{QueryInput as SdkQueryInput, QueryOutput as SdkQueryOutput};
use aws_sdk_dynamodb::operation::scan::{ScanInput as SdkScanInput, ScanOutput as SdkScanOutput};
use aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput as SdkTransactWriteItemsInput;
use aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput as SdkTransactWriteItemsOutput;
use aws_sdk_dynamodb::operation::update_item::UpdateItemInput as SdkUpdateItemInput;
use aws_sdk_dynamodb::operation::update_item::UpdateItemOutput as SdkUpdateItemOutput;
use aws_sdk_dynamodb::primitives::Blob;
use aws_sdk_dynamodb::types::AttributeValue as Ddb;
use aws_sdk_dynamodb::types::{
    BatchStatementRequest as SdkBatchStatementRequest, ConditionCheck as SdkConditionCheck,
    Delete as SdkDelete, DeleteRequest as SdkDeleteRequest,
    KeysAndAttributes as SdkKeysAndAttributes, ParameterizedStatement as SdkParameterizedStatement,
    Put as SdkPut, PutRequest as SdkPutRequest, TransactWriteItem as SdkTransactWriteItem,
    Update as SdkUpdate, WriteRequest as SdkWriteRequest,
};
use serde_bytes::ByteBuf;
use std::collections::HashMap;
use std::sync::Arc;

/// Shared, thread-safe state handed to every axum request task.
#[derive(Clone)]
pub struct AppState {
    pub mpl: Arc<MplClient>,
    pub sdk_config: Arc<SdkConfig>,
    pub registry: ClientRegistry,
}

pub async fn create_client(
    state: &AppState,
    request: model::CreateClientRequest,
) -> Result<model::CreateClientResponse, ServerError> {
    let encryptor = factory::build_client(&state.mpl, &state.sdk_config, &request.config).await?;
    let client_id = state.registry.register(encryptor);
    Ok(model::CreateClientResponse { client_id })
}

pub async fn encrypt_item(
    state: &AppState,
    request: model::EncryptItemRequest,
) -> Result<model::EncryptItemResponse, ServerError> {
    let handle = state.registry.get(&request.client_id)?;
    let plaintext = to_ddb_item(&request.plaintext_item)?;
    // Serialize operations on this client: the DBE client cannot tolerate
    // concurrent calls (see registry.rs).
    let _guard = handle.op_lock.lock().await;
    let output = handle
        .encryptor
        .encrypt_item()
        .plaintext_item(plaintext)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let encrypted = output
        .encrypted_item
        .ok_or_else(|| ServerError::Client("EncryptItem returned no encrypted_item".into()))?;
    Ok(model::EncryptItemResponse {
        encrypted_item: from_ddb_item(&encrypted)?,
    })
}

pub async fn decrypt_item(
    state: &AppState,
    request: model::DecryptItemRequest,
) -> Result<model::DecryptItemResponse, ServerError> {
    let handle = state.registry.get(&request.client_id)?;
    let encrypted = to_ddb_item(&request.encrypted_item)?;
    // Serialize operations on this client: the DBE client cannot tolerate
    // concurrent calls (see registry.rs).
    let _guard = handle.op_lock.lock().await;
    let output = handle
        .encryptor
        .decrypt_item()
        .encrypted_item(encrypted)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let plaintext = output
        .plaintext_item
        .ok_or_else(|| ServerError::Client("DecryptItem returned no plaintext_item".into()))?;
    Ok(model::DecryptItemResponse {
        plaintext_item: from_ddb_item(&plaintext)?,
    })
}

/// Describe the Encrypted Data Keys carried by a serialized header (or by an
/// encrypted item's `aws_dbe_head`). No client id / CMM / keyring: the DBE
/// `DynamoDbEncryption` product client only parses the header bytes, so it is
/// built ad hoc from an empty config.
pub async fn get_encrypted_data_key_description(
    _state: &AppState,
    request: model::GetEncryptedDataKeyDescriptionRequest,
) -> Result<model::GetEncryptedDataKeyDescriptionResponse, ServerError> {
    let union = if let Some(bytes) = request.input.header {
        GetEncryptedDataKeyDescriptionUnion::Header(Blob::new(bytes.into_vec()))
    } else if let Some(item) = request.input.item {
        GetEncryptedDataKeyDescriptionUnion::Item(to_ddb_item(&item)?)
    } else {
        return Err(ServerError::Generic(
            "GetEncryptedDataKeyDescription input union has no member set".into(),
        ));
    };
    let dbe = DbeClient::from_conf(
        DynamoDbEncryptionConfig::builder()
            .build()
            .map_err(|e| ServerError::Generic(format!("invalid DynamoDbEncryptionConfig: {e}")))?,
    )
    .map_err(|e| ServerError::Generic(format!("failed to build DynamoDbEncryption client: {e}")))?;
    let output = dbe
        .get_encrypted_data_key_description()
        .input(union)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let descriptions = output
        .encrypted_data_key_description_output
        .unwrap_or_default()
        .into_iter()
        .map(|d| model::EncryptedDataKeyDescription {
            key_provider_id: d.key_provider_id.unwrap_or_default(),
            key_provider_info: d.key_provider_info,
            branch_key_id: d.branch_key_id,
            branch_key_version: d.branch_key_version,
        })
        .collect();
    Ok(model::GetEncryptedDataKeyDescriptionResponse { descriptions })
}

// ---------------------------------------------------------------------------
// DDB SDK transform handlers. CreateTransformsClient builds a transforms client
// bound to one table; PutItemInputTransform encrypts a PutItem input;
// GetItemOutputTransform decrypts a GetItem output. Each maps the minimal wire
// shape onto the real aws_sdk_dynamodb request/response type.
// ---------------------------------------------------------------------------

pub async fn create_transforms_client(
    state: &AppState,
    request: model::CreateTransformsClientRequest,
) -> Result<model::CreateTransformsClientResponse, ServerError> {
    let client = factory::build_transforms_client(
        &state.mpl,
        &state.sdk_config,
        &request.config,
        &request.table_name,
        request.additional_tables.as_deref().unwrap_or(&[]),
    )
    .await?;
    let client_id = state.registry.register_transforms(client);
    Ok(model::CreateTransformsClientResponse { client_id })
}

pub async fn put_item_input_transform(
    state: &AppState,
    request: model::PutItemInputTransformRequest,
) -> Result<model::PutItemInputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let sdk_input = SdkPutItemInput::builder()
        .table_name(&request.sdk_input.table_name)
        .set_item(Some(to_ddb_item(&request.sdk_input.item)?))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid PutItemInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .put_item_input_transform()
        .sdk_input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_input.ok_or_else(|| {
        ServerError::Client("PutItemInputTransform returned no transformed_input".into())
    })?;

    let table_name = transformed.table_name().unwrap_or_default().to_string();
    let item = transformed.item().cloned().unwrap_or_default();
    Ok(model::PutItemInputTransformResponse {
        transformed_input: model::PutItemInput {
            table_name,
            item: from_ddb_item(&item)?,
        },
    })
}

pub async fn get_item_output_transform(
    state: &AppState,
    request: model::GetItemOutputTransformRequest,
) -> Result<model::GetItemOutputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let original_input = SdkGetItemInput::builder()
        .table_name(&request.original_input.table_name)
        .set_key(Some(to_ddb_item(&request.original_input.key)?))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid GetItemInput: {e}")))?;

    let mut out_builder = SdkGetItemOutput::builder();
    if let Some(item) = &request.sdk_output.item {
        out_builder = out_builder.set_item(Some(to_ddb_item(item)?));
    }
    let sdk_output = out_builder.build();

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .get_item_output_transform()
        .original_input(original_input)
        .sdk_output(sdk_output)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_output.ok_or_else(|| {
        ServerError::Client("GetItemOutputTransform returned no transformed_output".into())
    })?;

    let item = match transformed.item() {
        Some(map) if !map.is_empty() => Some(from_ddb_item(map)?),
        _ => None,
    };
    Ok(model::GetItemOutputTransformResponse {
        transformed_output: model::GetItemOutput { item },
    })
}

/// Modify-after hook for a PutItem; a passthrough when no beacon config exists.
pub async fn put_item_output_transform(
    state: &AppState,
    request: model::PutItemOutputTransformRequest,
) -> Result<model::PutItemOutputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let original_input = SdkPutItemInput::builder()
        .table_name(&request.original_input.table_name)
        .set_item(Some(to_ddb_item(&request.original_input.item)?))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid PutItemInput: {e}")))?;

    let mut out_builder = SdkPutItemOutput::builder();
    if let Some(attrs) = &request.sdk_output.attributes {
        out_builder = out_builder.set_attributes(Some(to_ddb_item(attrs)?));
    }
    let sdk_output = out_builder.build();

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .put_item_output_transform()
        .original_input(original_input)
        .sdk_output(sdk_output)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_output.ok_or_else(|| {
        ServerError::Client("PutItemOutputTransform returned no transformed_output".into())
    })?;
    let attributes = match transformed.attributes() {
        Some(map) if !map.is_empty() => Some(from_ddb_item(map)?),
        _ => None,
    };
    Ok(model::PutItemOutputTransformResponse {
        transformed_output: model::PutItemOutput { attributes },
    })
}

/// Modify-after hook for an UpdateItem; a passthrough when no beacon config exists.
pub async fn update_item_output_transform(
    state: &AppState,
    request: model::UpdateItemOutputTransformRequest,
) -> Result<model::UpdateItemOutputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let original_input = SdkUpdateItemInput::builder()
        .table_name(&request.original_input.table_name)
        .set_key(Some(to_ddb_item(&request.original_input.key)?))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid UpdateItemInput: {e}")))?;

    let mut out_builder = SdkUpdateItemOutput::builder();
    if let Some(attrs) = &request.sdk_output.attributes {
        out_builder = out_builder.set_attributes(Some(to_ddb_item(attrs)?));
    }
    let sdk_output = out_builder.build();

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .update_item_output_transform()
        .original_input(original_input)
        .sdk_output(sdk_output)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_output.ok_or_else(|| {
        ServerError::Client("UpdateItemOutputTransform returned no transformed_output".into())
    })?;
    let attributes = match transformed.attributes() {
        Some(map) if !map.is_empty() => Some(from_ddb_item(map)?),
        _ => None,
    };
    Ok(model::UpdateItemOutputTransformResponse {
        transformed_output: model::UpdateItemOutput { attributes },
    })
}

/// Modify-after hook for a DeleteItem; a passthrough when no beacon config exists.
pub async fn delete_item_output_transform(
    state: &AppState,
    request: model::DeleteItemOutputTransformRequest,
) -> Result<model::DeleteItemOutputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let original_input = SdkDeleteItemInput::builder()
        .table_name(&request.original_input.table_name)
        .set_key(Some(to_ddb_item(&request.original_input.key)?))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid DeleteItemInput: {e}")))?;

    let mut out_builder = SdkDeleteItemOutput::builder();
    if let Some(attrs) = &request.sdk_output.attributes {
        out_builder = out_builder.set_attributes(Some(to_ddb_item(attrs)?));
    }
    let sdk_output = out_builder.build();

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .delete_item_output_transform()
        .original_input(original_input)
        .sdk_output(sdk_output)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_output.ok_or_else(|| {
        ServerError::Client("DeleteItemOutputTransform returned no transformed_output".into())
    })?;
    let attributes = match transformed.attributes() {
        Some(map) if !map.is_empty() => Some(from_ddb_item(map)?),
        _ => None,
    };
    Ok(model::DeleteItemOutputTransformResponse {
        transformed_output: model::DeleteItemOutput { attributes },
    })
}

/// Modify-before hook for a GetItem; a passthrough when no beacon config exists.
pub async fn get_item_input_transform(
    state: &AppState,
    request: model::GetItemInputTransformRequest,
) -> Result<model::GetItemInputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let sdk_input = SdkGetItemInput::builder()
        .table_name(&request.sdk_input.table_name)
        .set_key(Some(to_ddb_item(&request.sdk_input.key)?))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid GetItemInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .get_item_input_transform()
        .sdk_input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_input.ok_or_else(|| {
        ServerError::Client("GetItemInputTransform returned no transformed_input".into())
    })?;
    Ok(model::GetItemInputTransformResponse {
        transformed_input: model::GetItemInput {
            table_name: transformed.table_name().unwrap_or_default().to_string(),
            key: match transformed.key() {
                Some(m) => from_ddb_item(m)?,
                None => std::collections::HashMap::new(),
            },
        },
    })
}

pub async fn batch_write_item_input_transform(
    state: &AppState,
    request: model::BatchWriteItemInputTransformRequest,
) -> Result<model::BatchWriteItemInputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;

    let sdk_input = SdkBatchWriteItemInput::builder()
        .set_request_items(Some(to_sdk_write_request_map(&request.sdk_input.request_items)?))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid BatchWriteItemInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .batch_write_item_input_transform()
        .sdk_input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_input.ok_or_else(|| {
        ServerError::Client("BatchWriteItemInputTransform returned no transformed_input".into())
    })?;

    let request_items = match transformed.request_items() {
        Some(items) => to_wire_write_request_map(items)?,
        None => HashMap::new(),
    };
    Ok(model::BatchWriteItemInputTransformResponse {
        transformed_input: model::BatchWriteItemInput { request_items },
    })
}

pub async fn batch_write_item_output_transform(
    state: &AppState,
    request: model::BatchWriteItemOutputTransformRequest,
) -> Result<model::BatchWriteItemOutputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;

    let original_input = SdkBatchWriteItemInput::builder()
        .set_request_items(Some(to_sdk_write_request_map(
            &request.original_input.request_items,
        )?))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid BatchWriteItemInput: {e}")))?;

    let mut out_builder = SdkBatchWriteItemOutput::builder();
    if let Some(unprocessed) = &request.sdk_output.unprocessed_items {
        out_builder = out_builder.set_unprocessed_items(Some(to_sdk_write_request_map(unprocessed)?));
    }
    let sdk_output = out_builder.build();

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .batch_write_item_output_transform()
        .original_input(original_input)
        .sdk_output(sdk_output)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_output.ok_or_else(|| {
        ServerError::Client("BatchWriteItemOutputTransform returned no transformed_output".into())
    })?;

    let unprocessed_items = match transformed.unprocessed_items() {
        Some(items) if !items.is_empty() => Some(to_wire_write_request_map(items)?),
        _ => None,
    };
    Ok(model::BatchWriteItemOutputTransformResponse {
        transformed_output: model::BatchWriteItemOutput { unprocessed_items },
    })
}

pub async fn transact_write_items_input_transform(
    state: &AppState,
    request: model::TransactWriteItemsInputTransformRequest,
) -> Result<model::TransactWriteItemsInputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;

    let mut sdk_items = Vec::with_capacity(request.sdk_input.transact_items.len());
    for item in &request.sdk_input.transact_items {
        sdk_items.push(to_sdk_transact_write_item(item)?);
    }
    let sdk_input = SdkTransactWriteItemsInput::builder()
        .set_transact_items(Some(sdk_items))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid TransactWriteItemsInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .transact_write_items_input_transform()
        .sdk_input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_input.ok_or_else(|| {
        ServerError::Client("TransactWriteItemsInputTransform returned no transformed_input".into())
    })?;

    let mut wire_items = Vec::with_capacity(transformed.transact_items().len());
    for item in transformed.transact_items() {
        wire_items.push(to_wire_transact_write_item(item)?);
    }
    Ok(model::TransactWriteItemsInputTransformResponse {
        transformed_input: model::TransactWriteItemsInput {
            transact_items: wire_items,
        },
    })
}

fn to_sdk_write_request(wr: &model::WriteRequest) -> Result<SdkWriteRequest, ServerError> {
    if let Some(pr) = &wr.put_request {
        let put = SdkPutRequest::builder()
            .set_item(Some(to_ddb_item(&pr.item)?))
            .build()
            .map_err(|e| ServerError::Generic(format!("invalid PutRequest: {e}")))?;
        return Ok(SdkWriteRequest::builder().put_request(put).build());
    }
    if let Some(dr) = &wr.delete_request {
        let del = SdkDeleteRequest::builder()
            .set_key(Some(to_ddb_item(&dr.key)?))
            .build()
            .map_err(|e| ServerError::Generic(format!("invalid DeleteRequest: {e}")))?;
        return Ok(SdkWriteRequest::builder().delete_request(del).build());
    }
    Err(ServerError::Generic(
        "WriteRequest must set exactly one of putRequest or deleteRequest".into(),
    ))
}

fn to_wire_write_request(wr: &SdkWriteRequest) -> Result<model::WriteRequest, ServerError> {
    if let Some(pr) = wr.put_request() {
        return Ok(model::WriteRequest {
            put_request: Some(model::PutRequest {
                item: from_ddb_item(pr.item())?,
            }),
            delete_request: None,
        });
    }
    if let Some(dr) = wr.delete_request() {
        return Ok(model::WriteRequest {
            put_request: None,
            delete_request: Some(model::DeleteRequest {
                key: from_ddb_item(dr.key())?,
            }),
        });
    }
    Err(ServerError::Client(
        "DBE returned a WriteRequest with neither putRequest nor deleteRequest".into(),
    ))
}

fn to_sdk_write_request_map(
    wire: &HashMap<String, Vec<model::WriteRequest>>,
) -> Result<HashMap<String, Vec<SdkWriteRequest>>, ServerError> {
    let mut out = HashMap::new();
    for (table, list) in wire {
        let mut sdk_list = Vec::with_capacity(list.len());
        for wr in list {
            sdk_list.push(to_sdk_write_request(wr)?);
        }
        out.insert(table.clone(), sdk_list);
    }
    Ok(out)
}

fn to_wire_write_request_map(
    sdk: &HashMap<String, Vec<SdkWriteRequest>>,
) -> Result<HashMap<String, Vec<model::WriteRequest>>, ServerError> {
    let mut out = HashMap::new();
    for (table, list) in sdk {
        let mut wire_list = Vec::with_capacity(list.len());
        for wr in list {
            wire_list.push(to_wire_write_request(wr)?);
        }
        out.insert(table.clone(), wire_list);
    }
    Ok(out)
}

fn to_sdk_transact_write_item(
    item: &model::TransactWriteItem,
) -> Result<SdkTransactWriteItem, ServerError> {
    let mut b = SdkTransactWriteItem::builder();
    if let Some(put) = &item.put {
        b = b.put(
            SdkPut::builder()
                .table_name(&put.table_name)
                .set_item(Some(to_ddb_item(&put.item)?))
                .build()
                .map_err(|e| ServerError::Generic(format!("invalid Put: {e}")))?,
        );
    }
    if let Some(d) = &item.delete {
        let mut db = SdkDelete::builder()
            .table_name(&d.table_name)
            .set_key(Some(to_ddb_item(&d.key)?));
        if let Some(c) = &d.condition_expression {
            db = db.condition_expression(c);
        }
        if let Some(n) = &d.expression_attribute_names {
            db = db.set_expression_attribute_names(Some(n.clone()));
        }
        if let Some(v) = &d.expression_attribute_values {
            db = db.set_expression_attribute_values(Some(to_ddb_item(v)?));
        }
        b = b.delete(
            db.build()
                .map_err(|e| ServerError::Generic(format!("invalid Delete: {e}")))?,
        );
    }
    if let Some(u) = &item.update {
        let mut ub = SdkUpdate::builder()
            .table_name(&u.table_name)
            .set_key(Some(to_ddb_item(&u.key)?))
            .update_expression(&u.update_expression);
        if let Some(c) = &u.condition_expression {
            ub = ub.condition_expression(c);
        }
        if let Some(n) = &u.expression_attribute_names {
            ub = ub.set_expression_attribute_names(Some(n.clone()));
        }
        if let Some(v) = &u.expression_attribute_values {
            ub = ub.set_expression_attribute_values(Some(to_ddb_item(v)?));
        }
        b = b.update(
            ub.build()
                .map_err(|e| ServerError::Generic(format!("invalid Update: {e}")))?,
        );
    }
    if let Some(c) = &item.condition_check {
        let mut cb = SdkConditionCheck::builder()
            .table_name(&c.table_name)
            .set_key(Some(to_ddb_item(&c.key)?))
            .condition_expression(&c.condition_expression);
        if let Some(n) = &c.expression_attribute_names {
            cb = cb.set_expression_attribute_names(Some(n.clone()));
        }
        if let Some(v) = &c.expression_attribute_values {
            cb = cb.set_expression_attribute_values(Some(to_ddb_item(v)?));
        }
        b = b.condition_check(
            cb.build()
                .map_err(|e| ServerError::Generic(format!("invalid ConditionCheck: {e}")))?,
        );
    }
    Ok(b.build())
}

fn to_wire_transact_write_item(
    item: &SdkTransactWriteItem,
) -> Result<model::TransactWriteItem, ServerError> {
    let put = match item.put() {
        Some(p) => Some(model::Put {
            table_name: p.table_name().to_string(),
            item: from_ddb_item(p.item())?,
        }),
        None => None,
    };
    let delete = match item.delete() {
        Some(d) => Some(model::Delete {
            table_name: d.table_name().to_string(),
            key: from_ddb_item(d.key())?,
            condition_expression: d.condition_expression().map(|s| s.to_string()),
            expression_attribute_names: d.expression_attribute_names().cloned(),
            expression_attribute_values: match d.expression_attribute_values() {
                Some(m) => Some(from_ddb_item(m)?),
                None => None,
            },
        }),
        None => None,
    };
    let update = match item.update() {
        Some(u) => Some(model::Update {
            table_name: u.table_name().to_string(),
            key: from_ddb_item(u.key())?,
            update_expression: u.update_expression().to_string(),
            condition_expression: u.condition_expression().map(|s| s.to_string()),
            expression_attribute_names: u.expression_attribute_names().cloned(),
            expression_attribute_values: match u.expression_attribute_values() {
                Some(m) => Some(from_ddb_item(m)?),
                None => None,
            },
        }),
        None => None,
    };
    let condition_check = match item.condition_check() {
        Some(c) => Some(model::ConditionCheck {
            table_name: c.table_name().to_string(),
            key: from_ddb_item(c.key())?,
            condition_expression: c.condition_expression().to_string(),
            expression_attribute_names: c.expression_attribute_names().cloned(),
            expression_attribute_values: match c.expression_attribute_values() {
                Some(m) => Some(from_ddb_item(m)?),
                None => None,
            },
        }),
        None => None,
    };
    Ok(model::TransactWriteItem {
        put,
        delete,
        update,
        condition_check,
    })
}

pub async fn scan_output_transform(
    state: &AppState,
    request: model::ScanOutputTransformRequest,
) -> Result<model::ScanOutputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let mut original_builder = SdkScanInput::builder().table_name(&request.original_input.table_name);
    if let Some(f) = &request.original_input.filter_expression {
        original_builder = original_builder.filter_expression(f);
    }
    if let Some(n) = &request.original_input.expression_attribute_names {
        original_builder = original_builder.set_expression_attribute_names(Some(n.clone()));
    }
    if let Some(v) = &request.original_input.expression_attribute_values {
        original_builder = original_builder.set_expression_attribute_values(Some(to_ddb_item(v)?));
    }
    let original_input = original_builder
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid ScanInput: {e}")))?;

    let mut out_builder = SdkScanOutput::builder();
    if let Some(items) = &request.sdk_output.items {
        out_builder = out_builder.set_items(Some(to_ddb_items(items)?));
    }
    let sdk_output = out_builder.build();

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .scan_output_transform()
        .original_input(original_input)
        .sdk_output(sdk_output)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_output.ok_or_else(|| {
        ServerError::Client("ScanOutputTransform returned no transformed_output".into())
    })?;

    Ok(model::ScanOutputTransformResponse {
        transformed_output: model::ScanOutput {
            items: from_ddb_items_opt(transformed.items())?,
        },
    })
}

pub async fn query_output_transform(
    state: &AppState,
    request: model::QueryOutputTransformRequest,
) -> Result<model::QueryOutputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let mut original_builder = SdkQueryInput::builder().table_name(&request.original_input.table_name);
    if let Some(k) = &request.original_input.key_condition_expression {
        original_builder = original_builder.key_condition_expression(k);
    }
    if let Some(f) = &request.original_input.filter_expression {
        original_builder = original_builder.filter_expression(f);
    }
    if let Some(n) = &request.original_input.expression_attribute_names {
        original_builder = original_builder.set_expression_attribute_names(Some(n.clone()));
    }
    if let Some(v) = &request.original_input.expression_attribute_values {
        original_builder = original_builder.set_expression_attribute_values(Some(to_ddb_item(v)?));
    }
    let original_input = original_builder
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid QueryInput: {e}")))?;

    let mut out_builder = SdkQueryOutput::builder();
    if let Some(items) = &request.sdk_output.items {
        out_builder = out_builder.set_items(Some(to_ddb_items(items)?));
    }
    let sdk_output = out_builder.build();

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .query_output_transform()
        .original_input(original_input)
        .sdk_output(sdk_output)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_output.ok_or_else(|| {
        ServerError::Client("QueryOutputTransform returned no transformed_output".into())
    })?;

    Ok(model::QueryOutputTransformResponse {
        transformed_output: model::QueryOutput {
            items: from_ddb_items_opt(transformed.items())?,
        },
    })
}

pub async fn batch_get_item_output_transform(
    state: &AppState,
    request: model::BatchGetItemOutputTransformRequest,
) -> Result<model::BatchGetItemOutputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;

    let mut sdk_request_items: HashMap<String, SdkKeysAndAttributes> = HashMap::new();
    for (table, ka) in &request.original_input.request_items {
        let sdk_ka = SdkKeysAndAttributes::builder()
            .set_keys(Some(to_ddb_items(&ka.keys)?))
            .build()
            .map_err(|e| ServerError::Generic(format!("invalid KeysAndAttributes: {e}")))?;
        sdk_request_items.insert(table.clone(), sdk_ka);
    }
    let original_input = SdkBatchGetItemInput::builder()
        .set_request_items(Some(sdk_request_items))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid BatchGetItemInput: {e}")))?;

    let mut out_builder = SdkBatchGetItemOutput::builder();
    if let Some(responses) = &request.sdk_output.responses {
        let mut sdk_responses: HashMap<String, Vec<HashMap<String, Ddb>>> = HashMap::new();
        for (table, items) in responses {
            sdk_responses.insert(table.clone(), to_ddb_items(items)?);
        }
        out_builder = out_builder.set_responses(Some(sdk_responses));
    }
    let sdk_output = out_builder.build();

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .batch_get_item_output_transform()
        .original_input(original_input)
        .sdk_output(sdk_output)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_output.ok_or_else(|| {
        ServerError::Client("BatchGetItemOutputTransform returned no transformed_output".into())
    })?;

    let responses = match transformed.responses() {
        Some(map) if !map.is_empty() => {
            let mut wire = HashMap::new();
            for (table, items) in map {
                wire.insert(table.clone(), from_ddb_items(items)?);
            }
            Some(wire)
        }
        _ => None,
    };
    Ok(model::BatchGetItemOutputTransformResponse {
        transformed_output: model::BatchGetItemOutput { responses },
    })
}

fn to_ddb_items(items: &[model::DdbItem]) -> Result<Vec<HashMap<String, Ddb>>, ServerError> {
    items.iter().map(to_ddb_item).collect()
}

fn from_ddb_items(items: &[HashMap<String, Ddb>]) -> Result<Vec<model::DdbItem>, ServerError> {
    items.iter().map(from_ddb_item).collect()
}

/// Map an SDK item slice to the wire, treating an empty slice as absent (an
/// SDK output exposes an unset item list as an empty slice, not None).
fn from_ddb_items_opt(
    items: &[HashMap<String, Ddb>],
) -> Result<Option<Vec<model::DdbItem>>, ServerError> {
    if items.is_empty() {
        Ok(None)
    } else {
        Ok(Some(from_ddb_items(items)?))
    }
}

pub async fn execute_statement_input_transform(
    state: &AppState,
    request: model::ExecuteStatementInputTransformRequest,
) -> Result<model::ExecuteStatementInputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let sdk_input = SdkExecuteStatementInput::builder()
        .statement(&request.sdk_input.statement)
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid ExecuteStatementInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .execute_statement_input_transform()
        .sdk_input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_input.ok_or_else(|| {
        ServerError::Client("ExecuteStatementInputTransform returned no transformed_input".into())
    })?;
    Ok(model::ExecuteStatementInputTransformResponse {
        transformed_input: model::ExecuteStatementInput {
            statement: transformed.statement().unwrap_or_default().to_string(),
        },
    })
}

pub async fn batch_execute_statement_input_transform(
    state: &AppState,
    request: model::BatchExecuteStatementInputTransformRequest,
) -> Result<model::BatchExecuteStatementInputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let mut sdk_statements = Vec::with_capacity(request.sdk_input.statements.len());
    for s in &request.sdk_input.statements {
        sdk_statements.push(
            SdkBatchStatementRequest::builder()
                .statement(&s.statement)
                .build()
                .map_err(|e| ServerError::Generic(format!("invalid BatchStatementRequest: {e}")))?,
        );
    }
    let sdk_input = SdkBatchExecuteStatementInput::builder()
        .set_statements(Some(sdk_statements))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid BatchExecuteStatementInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .batch_execute_statement_input_transform()
        .sdk_input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_input.ok_or_else(|| {
        ServerError::Client(
            "BatchExecuteStatementInputTransform returned no transformed_input".into(),
        )
    })?;
    let statements = transformed
        .statements()
        .iter()
        .map(|s| model::BatchStatementRequest {
            statement: s.statement().to_string(),
        })
        .collect();
    Ok(model::BatchExecuteStatementInputTransformResponse {
        transformed_input: model::BatchExecuteStatementInput { statements },
    })
}

pub async fn execute_transaction_input_transform(
    state: &AppState,
    request: model::ExecuteTransactionInputTransformRequest,
) -> Result<model::ExecuteTransactionInputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let mut sdk_statements = Vec::with_capacity(request.sdk_input.transact_statements.len());
    for s in &request.sdk_input.transact_statements {
        sdk_statements.push(
            SdkParameterizedStatement::builder()
                .statement(&s.statement)
                .build()
                .map_err(|e| ServerError::Generic(format!("invalid ParameterizedStatement: {e}")))?,
        );
    }
    let sdk_input = SdkExecuteTransactionInput::builder()
        .set_transact_statements(Some(sdk_statements))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid ExecuteTransactionInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .execute_transaction_input_transform()
        .sdk_input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_input.ok_or_else(|| {
        ServerError::Client("ExecuteTransactionInputTransform returned no transformed_input".into())
    })?;
    let transact_statements = transformed
        .transact_statements()
        .iter()
        .map(|s| model::ParameterizedStatement {
            statement: s.statement().to_string(),
        })
        .collect();
    Ok(model::ExecuteTransactionInputTransformResponse {
        transformed_input: model::ExecuteTransactionInput {
            transact_statements,
        },
    })
}

pub async fn update_item_input_transform(
    state: &AppState,
    request: model::UpdateItemInputTransformRequest,
) -> Result<model::UpdateItemInputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let wire = &request.sdk_input;
    let mut b = SdkUpdateItemInput::builder()
        .table_name(&wire.table_name)
        .set_key(Some(to_ddb_item(&wire.key)?));
    if let Some(e) = &wire.update_expression {
        b = b.update_expression(e);
    }
    if let Some(e) = &wire.condition_expression {
        b = b.condition_expression(e);
    }
    if let Some(names) = &wire.expression_attribute_names {
        if !names.is_empty() {
            b = b.set_expression_attribute_names(Some(names.clone()));
        }
    }
    if let Some(vals) = &wire.expression_attribute_values {
        if !vals.is_empty() {
            b = b.set_expression_attribute_values(Some(to_ddb_item(vals)?));
        }
    }
    let sdk_input = b
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid UpdateItemInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .update_item_input_transform()
        .sdk_input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let t = output.transformed_input.ok_or_else(|| {
        ServerError::Client("UpdateItemInputTransform returned no transformed_input".into())
    })?;

    Ok(model::UpdateItemInputTransformResponse {
        transformed_input: model::UpdateItemInput {
            table_name: t.table_name().unwrap_or_default().to_string(),
            key: match t.key() {
                Some(m) => from_ddb_item(m)?,
                None => HashMap::new(),
            },
            update_expression: t.update_expression().map(String::from),
            condition_expression: t.condition_expression().map(String::from),
            expression_attribute_names: t.expression_attribute_names().cloned(),
            expression_attribute_values: match t.expression_attribute_values() {
                Some(m) => Some(from_ddb_item(m)?),
                None => None,
            },
        },
    })
}

pub async fn delete_item_input_transform(
    state: &AppState,
    request: model::DeleteItemInputTransformRequest,
) -> Result<model::DeleteItemInputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let wire = &request.sdk_input;
    let mut b = SdkDeleteItemInput::builder()
        .table_name(&wire.table_name)
        .set_key(Some(to_ddb_item(&wire.key)?));
    if let Some(e) = &wire.condition_expression {
        b = b.condition_expression(e);
    }
    if let Some(names) = &wire.expression_attribute_names {
        if !names.is_empty() {
            b = b.set_expression_attribute_names(Some(names.clone()));
        }
    }
    if let Some(vals) = &wire.expression_attribute_values {
        if !vals.is_empty() {
            b = b.set_expression_attribute_values(Some(to_ddb_item(vals)?));
        }
    }
    let sdk_input = b
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid DeleteItemInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .delete_item_input_transform()
        .sdk_input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let t = output.transformed_input.ok_or_else(|| {
        ServerError::Client("DeleteItemInputTransform returned no transformed_input".into())
    })?;

    Ok(model::DeleteItemInputTransformResponse {
        transformed_input: model::DeleteItemInput {
            table_name: t.table_name().unwrap_or_default().to_string(),
            key: match t.key() {
                Some(m) => from_ddb_item(m)?,
                None => HashMap::new(),
            },
            condition_expression: t.condition_expression().map(String::from),
            expression_attribute_names: t.expression_attribute_names().cloned(),
            expression_attribute_values: match t.expression_attribute_values() {
                Some(m) => Some(from_ddb_item(m)?),
                None => None,
            },
        },
    })
}

pub async fn scan_input_transform(
    state: &AppState,
    request: model::ScanInputTransformRequest,
) -> Result<model::ScanInputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let wire = &request.sdk_input;
    let mut b = SdkScanInput::builder().table_name(&wire.table_name);
    if let Some(f) = &wire.filter_expression {
        b = b.filter_expression(f);
    }
    if let Some(names) = &wire.expression_attribute_names {
        if !names.is_empty() {
            b = b.set_expression_attribute_names(Some(names.clone()));
        }
    }
    if let Some(vals) = &wire.expression_attribute_values {
        if !vals.is_empty() {
            b = b.set_expression_attribute_values(Some(to_ddb_item(vals)?));
        }
    }
    let sdk_input = b
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid ScanInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .scan_input_transform()
        .sdk_input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let t = output.transformed_input.ok_or_else(|| {
        ServerError::Client("ScanInputTransform returned no transformed_input".into())
    })?;

    Ok(model::ScanInputTransformResponse {
        transformed_input: model::ScanInput {
            table_name: t.table_name().unwrap_or_default().to_string(),
            filter_expression: t.filter_expression().map(String::from),
            expression_attribute_names: t.expression_attribute_names().cloned(),
            expression_attribute_values: match t.expression_attribute_values() {
                Some(m) => Some(from_ddb_item(m)?),
                None => None,
            },
        },
    })
}

pub async fn query_input_transform(
    state: &AppState,
    request: model::QueryInputTransformRequest,
) -> Result<model::QueryInputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let wire = &request.sdk_input;
    let mut b = SdkQueryInput::builder().table_name(&wire.table_name);
    if let Some(k) = &wire.key_condition_expression {
        b = b.key_condition_expression(k);
    }
    if let Some(f) = &wire.filter_expression {
        b = b.filter_expression(f);
    }
    if let Some(names) = &wire.expression_attribute_names {
        if !names.is_empty() {
            b = b.set_expression_attribute_names(Some(names.clone()));
        }
    }
    if let Some(vals) = &wire.expression_attribute_values {
        if !vals.is_empty() {
            b = b.set_expression_attribute_values(Some(to_ddb_item(vals)?));
        }
    }
    let sdk_input = b
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid QueryInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .query_input_transform()
        .sdk_input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let t = output.transformed_input.ok_or_else(|| {
        ServerError::Client("QueryInputTransform returned no transformed_input".into())
    })?;

    Ok(model::QueryInputTransformResponse {
        transformed_input: model::QueryInput {
            table_name: t.table_name().unwrap_or_default().to_string(),
            key_condition_expression: t.key_condition_expression().map(String::from),
            filter_expression: t.filter_expression().map(String::from),
            expression_attribute_names: t.expression_attribute_names().cloned(),
            expression_attribute_values: match t.expression_attribute_values() {
                Some(m) => Some(from_ddb_item(m)?),
                None => None,
            },
        },
    })
}

/// Return the number of beacon sub-queries the given Query must be split into
/// for the referenced transforms client's beacon configuration.
pub async fn get_number_of_queries(
    state: &AppState,
    request: model::GetNumberOfQueriesRequest,
) -> Result<model::GetNumberOfQueriesResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let wire = &request.sdk_input;
    let mut b = SdkQueryInput::builder().table_name(&wire.table_name);
    if let Some(k) = &wire.key_condition_expression {
        b = b.key_condition_expression(k);
    }
    if let Some(f) = &wire.filter_expression {
        b = b.filter_expression(f);
    }
    if let Some(names) = &wire.expression_attribute_names {
        if !names.is_empty() {
            b = b.set_expression_attribute_names(Some(names.clone()));
        }
    }
    if let Some(vals) = &wire.expression_attribute_values {
        if !vals.is_empty() {
            b = b.set_expression_attribute_values(Some(to_ddb_item(vals)?));
        }
    }
    let sdk_input = b
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid QueryInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .get_number_of_queries()
        .input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let number_of_queries = output
        .number_of_queries
        .ok_or_else(|| ServerError::Client("GetNumberOfQueries returned no number_of_queries".into()))?;
    Ok(model::GetNumberOfQueriesResponse { number_of_queries })
}

// ---------------------------------------------------------------------------
// AttributeValue conversion (wire scalars <-> AWS SDK AttributeValue)
// ---------------------------------------------------------------------------
/// Modify-after hook for TransactWriteItems; the response has no item content
/// so this is a pure passthrough returning an empty output.
pub async fn transact_write_items_output_transform(
    state: &AppState,
    request: model::TransactWriteItemsOutputTransformRequest,
) -> Result<model::TransactWriteItemsOutputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let mut sdk_items = Vec::with_capacity(request.original_input.transact_items.len());
    for item in &request.original_input.transact_items {
        sdk_items.push(to_sdk_transact_write_item(item)?);
    }
    let original_input = SdkTransactWriteItemsInput::builder()
        .set_transact_items(Some(sdk_items))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid TransactWriteItemsInput: {e}")))?;
    let sdk_output = SdkTransactWriteItemsOutput::builder().build();

    let _guard = handle.op_lock.lock().await;
    handle
        .client
        .transact_write_items_output_transform()
        .original_input(original_input)
        .sdk_output(sdk_output)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    Ok(model::TransactWriteItemsOutputTransformResponse {
        transformed_output: model::TransactWriteItemsOutput {},
    })
}

/// Modify-after hook for an ExecuteStatement (PartiQL); decrypts returned items.
pub async fn execute_statement_output_transform(
    state: &AppState,
    request: model::ExecuteStatementOutputTransformRequest,
) -> Result<model::ExecuteStatementOutputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let original_input = SdkExecuteStatementInput::builder()
        .statement(&request.original_input.statement)
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid ExecuteStatementInput: {e}")))?;

    let mut out_builder = SdkExecuteStatementOutput::builder();
    if let Some(items) = &request.sdk_output.items {
        out_builder = out_builder.set_items(Some(to_ddb_items(items)?));
    }
    let sdk_output = out_builder.build();

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .execute_statement_output_transform()
        .original_input(original_input)
        .sdk_output(sdk_output)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_output.ok_or_else(|| {
        ServerError::Client("ExecuteStatementOutputTransform returned no transformed_output".into())
    })?;
    Ok(model::ExecuteStatementOutputTransformResponse {
        transformed_output: model::ExecuteStatementOutput {
            items: from_ddb_items_opt(transformed.items())?,
        },
    })
}

/// Modify-after hook for an ExecuteTransaction (PartiQL); decrypts each response item.
pub async fn execute_transaction_output_transform(
    state: &AppState,
    request: model::ExecuteTransactionOutputTransformRequest,
) -> Result<model::ExecuteTransactionOutputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let mut sdk_statements = Vec::new();
    for s in &request.original_input.transact_statements {
        sdk_statements.push(
            aws_sdk_dynamodb::types::ParameterizedStatement::builder()
                .statement(&s.statement)
                .build()
                .map_err(|e| ServerError::Generic(format!("invalid statement: {e}")))?,
        );
    }
    let original_input = SdkExecuteTransactionInput::builder()
        .set_transact_statements(Some(sdk_statements))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid ExecuteTransactionInput: {e}")))?;

    let mut out_builder = SdkExecuteTransactionOutput::builder();
    if let Some(responses) = &request.sdk_output.responses {
        let mut sdk_responses = Vec::new();
        for r in responses {
            let mut b = aws_sdk_dynamodb::types::ItemResponse::builder();
            if let Some(item) = &r.item {
                b = b.set_item(Some(to_ddb_item(item)?));
            }
            sdk_responses.push(b.build());
        }
        out_builder = out_builder.set_responses(Some(sdk_responses));
    }
    let sdk_output = out_builder.build();

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .execute_transaction_output_transform()
        .original_input(original_input)
        .sdk_output(sdk_output)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_output.ok_or_else(|| {
        ServerError::Client("ExecuteTransactionOutputTransform returned no transformed_output".into())
    })?;
    let responses = if transformed.responses().is_empty() {
        None
    } else {
        let mut out = Vec::new();
        for r in transformed.responses() {
            let item = match r.item() {
                Some(m) if !m.is_empty() => Some(from_ddb_item(m)?),
                _ => None,
            };
            out.push(model::ItemResponse { item });
        }
        Some(out)
    };
    Ok(model::ExecuteTransactionOutputTransformResponse {
        transformed_output: model::ExecuteTransactionOutput { responses },
    })
}

/// Modify-after hook for a BatchExecuteStatement (PartiQL); decrypts each response item.
pub async fn batch_execute_statement_output_transform(
    state: &AppState,
    request: model::BatchExecuteStatementOutputTransformRequest,
) -> Result<model::BatchExecuteStatementOutputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let mut sdk_statements = Vec::new();
    for s in &request.original_input.statements {
        sdk_statements.push(
            aws_sdk_dynamodb::types::BatchStatementRequest::builder()
                .statement(&s.statement)
                .build()
                .map_err(|e| ServerError::Generic(format!("invalid statement: {e}")))?,
        );
    }
    let original_input = SdkBatchExecuteStatementInput::builder()
        .set_statements(Some(sdk_statements))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid BatchExecuteStatementInput: {e}")))?;

    let mut out_builder = SdkBatchExecuteStatementOutput::builder();
    if let Some(responses) = &request.sdk_output.responses {
        let mut sdk_responses = Vec::new();
        for r in responses {
            let mut b = aws_sdk_dynamodb::types::BatchStatementResponse::builder();
            if let Some(table_name) = &r.table_name {
                b = b.table_name(table_name);
            }
            if let Some(item) = &r.item {
                b = b.set_item(Some(to_ddb_item(item)?));
            }
            sdk_responses.push(b.build());
        }
        out_builder = out_builder.set_responses(Some(sdk_responses));
    }
    let sdk_output = out_builder.build();

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .batch_execute_statement_output_transform()
        .original_input(original_input)
        .sdk_output(sdk_output)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_output.ok_or_else(|| {
        ServerError::Client(
            "BatchExecuteStatementOutputTransform returned no transformed_output".into(),
        )
    })?;
    let responses = if transformed.responses().is_empty() {
        None
    } else {
        let mut out = Vec::new();
        for r in transformed.responses() {
            let item = match r.item() {
                Some(m) if !m.is_empty() => Some(from_ddb_item(m)?),
                _ => None,
            };
            out.push(model::BatchStatementResponse {
                table_name: r.table_name().map(|s| s.to_string()),
                item,
            });
        }
        Some(out)
    };
    Ok(model::BatchExecuteStatementOutputTransformResponse {
        transformed_output: model::BatchExecuteStatementOutput { responses },
    })
}


/// Modify-before hook for a BatchGetItem; a passthrough when no beacon config exists.
pub async fn batch_get_item_input_transform(
    state: &AppState,
    request: model::BatchGetItemInputTransformRequest,
) -> Result<model::BatchGetItemInputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let mut sdk_request_items: HashMap<String, SdkKeysAndAttributes> = HashMap::new();
    for (table, ka) in &request.sdk_input.request_items {
        sdk_request_items.insert(
            table.clone(),
            SdkKeysAndAttributes::builder()
                .set_keys(Some(to_ddb_items(&ka.keys)?))
                .build()
                .map_err(|e| ServerError::Generic(format!("invalid KeysAndAttributes: {e}")))?,
        );
    }
    let sdk_input = SdkBatchGetItemInput::builder()
        .set_request_items(Some(sdk_request_items))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid BatchGetItemInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .batch_get_item_input_transform()
        .sdk_input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_input.ok_or_else(|| {
        ServerError::Client("BatchGetItemInputTransform returned no transformed_input".into())
    })?;
    let mut request_items = HashMap::new();
    if let Some(map) = transformed.request_items() {
        for (table, ka) in map {
            request_items.insert(
                table.clone(),
                model::KeysAndAttributes {
                    keys: from_ddb_items(ka.keys())?,
                },
            );
        }
    }
    Ok(model::BatchGetItemInputTransformResponse {
        transformed_input: model::BatchGetItemInput { request_items },
    })
}

/// Modify-before hook for a TransactGetItems; a passthrough when no beacon config exists.
pub async fn transact_get_items_input_transform(
    state: &AppState,
    request: model::TransactGetItemsInputTransformRequest,
) -> Result<model::TransactGetItemsInputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let sdk_items = to_sdk_transact_get_items(&request.sdk_input.transact_items)?;
    let sdk_input = SdkTransactGetItemsInput::builder()
        .set_transact_items(Some(sdk_items))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid TransactGetItemsInput: {e}")))?;

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .transact_get_items_input_transform()
        .sdk_input(sdk_input)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_input.ok_or_else(|| {
        ServerError::Client("TransactGetItemsInputTransform returned no transformed_input".into())
    })?;
    Ok(model::TransactGetItemsInputTransformResponse {
        transformed_input: model::TransactGetItemsInput {
            transact_items: from_sdk_transact_get_items(transformed.transact_items())?,
        },
    })
}

/// Modify-after hook for a TransactGetItems; decrypts each returned item.
pub async fn transact_get_items_output_transform(
    state: &AppState,
    request: model::TransactGetItemsOutputTransformRequest,
) -> Result<model::TransactGetItemsOutputTransformResponse, ServerError> {
    let handle = state.registry.get_transforms(&request.client_id)?;
    let sdk_items = to_sdk_transact_get_items(&request.original_input.transact_items)?;
    let original_input = SdkTransactGetItemsInput::builder()
        .set_transact_items(Some(sdk_items))
        .build()
        .map_err(|e| ServerError::Generic(format!("invalid TransactGetItemsInput: {e}")))?;

    let mut out_builder = SdkTransactGetItemsOutput::builder();
    if let Some(responses) = &request.sdk_output.responses {
        let mut sdk_responses = Vec::new();
        for r in responses {
            let mut b = aws_sdk_dynamodb::types::ItemResponse::builder();
            if let Some(item) = &r.item {
                b = b.set_item(Some(to_ddb_item(item)?));
            }
            sdk_responses.push(b.build());
        }
        out_builder = out_builder.set_responses(Some(sdk_responses));
    }
    let sdk_output = out_builder.build();

    let _guard = handle.op_lock.lock().await;
    let output = handle
        .client
        .transact_get_items_output_transform()
        .original_input(original_input)
        .sdk_output(sdk_output)
        .send()
        .await
        .map_err(|e| ServerError::Client(e.to_string()))?;
    let transformed = output.transformed_output.ok_or_else(|| {
        ServerError::Client("TransactGetItemsOutputTransform returned no transformed_output".into())
    })?;
    let responses = if transformed.responses().is_empty() {
        None
    } else {
        let mut out = Vec::new();
        for r in transformed.responses() {
            let item = match r.item() {
                Some(m) if !m.is_empty() => Some(from_ddb_item(m)?),
                _ => None,
            };
            out.push(model::ItemResponse { item });
        }
        Some(out)
    };
    Ok(model::TransactGetItemsOutputTransformResponse {
        transformed_output: model::TransactGetItemsOutput { responses },
    })
}

fn to_sdk_transact_get_items(
    items: &[model::TransactGetItem],
) -> Result<Vec<aws_sdk_dynamodb::types::TransactGetItem>, ServerError> {
    let mut out = Vec::with_capacity(items.len());
    for item in items {
        let get = aws_sdk_dynamodb::types::Get::builder()
            .table_name(&item.get.table_name)
            .set_key(Some(to_ddb_item(&item.get.key)?))
            .build()
            .map_err(|e| ServerError::Generic(format!("invalid Get: {e}")))?;
        out.push(aws_sdk_dynamodb::types::TransactGetItem::builder().get(get).build());
    }
    Ok(out)
}

fn from_sdk_transact_get_items(
    items: &[aws_sdk_dynamodb::types::TransactGetItem],
) -> Result<Vec<model::TransactGetItem>, ServerError> {
    let mut out = Vec::with_capacity(items.len());
    for item in items {
        let get = item
            .get()
            .ok_or_else(|| ServerError::Client("TransactGetItem missing get".into()))?;
        out.push(model::TransactGetItem {
            get: model::Get {
                table_name: get.table_name().to_string(),
                key: from_ddb_item(get.key())?,
            },
        });
    }
    Ok(out)
}

fn to_ddb_item(item: &model::DdbItem) -> Result<HashMap<String, Ddb>, ServerError> {
    item.iter()
        .map(|(name, value)| Ok((name.clone(), to_ddb_value(value)?)))
        .collect()
}

fn to_ddb_value(value: &model::AttributeValue) -> Result<Ddb, ServerError> {
    if let Some(s) = &value.s {
        return Ok(Ddb::S(s.clone()));
    }
    if let Some(n) = &value.n {
        return Ok(Ddb::N(n.clone()));
    }
    if let Some(b) = &value.b {
        return Ok(Ddb::B(Blob::new(b.to_vec())));
    }
    if let Some(flag) = value.bool_value {
        return Ok(Ddb::Bool(flag));
    }
    if value.null.is_some() {
        return Ok(Ddb::Null(true));
    }
    if let Some(ss) = &value.ss {
        return Ok(Ddb::Ss(ss.clone()));
    }
    if let Some(ns) = &value.ns {
        return Ok(Ddb::Ns(ns.clone()));
    }
    if let Some(bs) = &value.bs {
        return Ok(Ddb::Bs(bs.iter().map(|b| Blob::new(b.to_vec())).collect()));
    }
    if let Some(l) = &value.l {
        let items = l
            .iter()
            .map(to_ddb_value)
            .collect::<Result<Vec<_>, _>>()?;
        return Ok(Ddb::L(items));
    }
    if let Some(m) = &value.m {
        return Ok(Ddb::M(to_ddb_item(m)?));
    }
    Err(ServerError::Generic(
        "AttributeValue had no member set".into(),
    ))
}

fn from_ddb_item(item: &HashMap<String, Ddb>) -> Result<model::DdbItem, ServerError> {
    item.iter()
        .map(|(name, value)| Ok((name.clone(), from_ddb_value(value)?)))
        .collect()
}

fn from_ddb_value(value: &Ddb) -> Result<model::AttributeValue, ServerError> {
    let mut out = model::AttributeValue::default();
    match value {
        Ddb::S(s) => out.s = Some(s.clone()),
        Ddb::N(n) => out.n = Some(n.clone()),
        Ddb::B(b) => out.b = Some(ByteBuf::from(b.as_ref().to_vec())),
        Ddb::Bool(flag) => out.bool_value = Some(*flag),
        Ddb::Null(_) => out.null = Some(true),
        Ddb::Ss(ss) => out.ss = Some(ss.clone()),
        Ddb::Ns(ns) => out.ns = Some(ns.clone()),
        Ddb::Bs(bs) => {
            out.bs = Some(bs.iter().map(|b| ByteBuf::from(b.as_ref().to_vec())).collect());
        }
        Ddb::L(list) => {
            let items = list
                .iter()
                .map(from_ddb_value)
                .collect::<Result<Vec<_>, _>>()?;
            out.l = Some(items);
        }
        Ddb::M(map) => out.m = Some(from_ddb_item(map)?),
        other => {
            return Err(ServerError::Generic(format!(
                "unsupported AttributeValue variant on the wire: {other:?}"
            )));
        }
    }
    Ok(out)
}
