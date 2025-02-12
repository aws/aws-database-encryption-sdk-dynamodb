// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

#![deny(warnings, unconditional_panic)]
#![deny(nonstandard_style)]
#![deny(clippy::all)]
#![allow(unused)]
#![allow(clippy::result_large_err)]

use aws_sdk_dynamodb::{
    config::{
        interceptors::{BeforeSerializationInterceptorContextMut, FinalizerInterceptorContextMut},
        ConfigBag, Intercept, RuntimeComponents,
    },
    error::BoxError,
};
use aws_smithy_runtime_api::client::interceptors::context::Input;
use aws_smithy_types::config_bag::{Storable, StoreReplace};

macro_rules! modify_request {
    ($cfg:ident,$request:ident,$self:ident,$transform:ident) => {{
        // store the original request
        $cfg.interceptor_state()
            .store_put(OriginalRequest(Input::erase($request.clone())));

        // transform the request
        let result = tokio::task::block_in_place(|| {
            tokio::runtime::Handle::current().block_on(async {
                $self
                    .client
                    .$transform()
                    .sdk_input($request.clone())
                    .send()
                    .await
            })
        });
        match result {
            Ok(x) => *$request = x.transformed_input.unwrap(),
            Err(x) => {
                let s = format!("{:?}", x);
                return Err(s.into());
            }
        };
    }};
}

macro_rules! modify_response {
    ($cfg:ident,$type:ty,$response:ident,$self:ident,$transform:ident) => {{
        // retrieve the original request
        let original = $cfg
            .load::<OriginalRequest>()
            .expect("we put this in ourselves");
        let original = original
            .0
            .downcast_ref::<$type>()
            .expect("we know this type corresponds to the output type");

        // transform the response
        let result = tokio::task::block_in_place(|| {
            tokio::runtime::Handle::current().block_on(async {
                $self
                    .client
                    .$transform()
                    .original_input(original.clone())
                    .sdk_output($response.clone())
                    .send()
                    .await
            })
        });
        match result {
            Ok(x) => *$response = x.transformed_output.unwrap(),
            Err(x) => {
                let s = format!("{:?}", x);
                return Err(s.into());
            }
        };
    }};
}

type TClient = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_transforms::client::Client;

#[derive(Debug)]
pub struct DbEsdkInterceptor {
    client: TClient,
}

impl DbEsdkInterceptor {
    pub fn new(
        config: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_transforms::types::DynamoDbTablesEncryptionConfig,
    ) -> Result<Self, crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_transforms::types::error::Error> {
        let client = TClient::from_conf(config)?;
        Ok(DbEsdkInterceptor { client })
    }
}

#[derive(Debug)]
struct OriginalRequest(Input);

impl Storable for OriginalRequest {
    type Storer = StoreReplace<Self>;
}

impl Intercept for DbEsdkInterceptor {
    fn name(&self) -> &'static str {
        "DbEsdkInterceptor"
    }

    fn modify_before_serialization(
        &self,
        // https://docs.rs/aws-smithy-runtime-api/latest/aws_smithy_runtime_api/client/interceptors/context/struct.BeforeSerializationInterceptorContextMut.html
        context: &mut BeforeSerializationInterceptorContextMut,
        _rc: &RuntimeComponents,
        cfg: &mut ConfigBag,
    ) -> Result<(), BoxError> {
        if let Some(batch_execute_statement_request) = context.input_mut().downcast_mut::<aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput>() {
            modify_request!(cfg, batch_execute_statement_request, self, batch_execute_statement_input_transform);
        } else if let Some(batch_get_item_request) = context.input_mut().downcast_mut::<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>() {
            modify_request!(cfg, batch_get_item_request, self, batch_get_item_input_transform);
        } else if let Some(batch_write_item_request) = context.input_mut().downcast_mut::<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>() {
            modify_request!(cfg, batch_write_item_request, self, batch_write_item_input_transform);
        } else if let Some(delete_item_request) = context.input_mut().downcast_mut::<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>() {
            modify_request!(cfg, delete_item_request, self, delete_item_input_transform);
        } else if let Some(execute_statement_request) = context.input_mut().downcast_mut::<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput>() {
            modify_request!(cfg, execute_statement_request, self, execute_statement_input_transform);
        } else if let Some(execute_transaction_request) = context.input_mut().downcast_mut::<aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput>() {
            modify_request!(cfg, execute_transaction_request, self, execute_transaction_input_transform);
        } else if let Some(get_item_request) = context.input_mut().downcast_mut::<aws_sdk_dynamodb::operation::get_item::GetItemInput>() {
            modify_request!(cfg, get_item_request, self, get_item_input_transform);
        } else if let Some(put_item_request) = context.input_mut().downcast_mut::<aws_sdk_dynamodb::operation::put_item::PutItemInput>() {
            modify_request!(cfg, put_item_request, self, put_item_input_transform);
        } else if let Some(query_request) = context.input_mut().downcast_mut::<aws_sdk_dynamodb::operation::query::QueryInput>() {
            modify_request!(cfg, query_request, self, query_input_transform);
        } else if let Some(scan_request) = context.input_mut().downcast_mut::<aws_sdk_dynamodb::operation::scan::ScanInput>() {
            modify_request!(cfg, scan_request, self, scan_input_transform);
        } else if let Some(transact_get_items_request) = context.input_mut().downcast_mut::<aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput>() {
            modify_request!(cfg, transact_get_items_request, self, transact_get_items_input_transform);
        } else if let Some(transact_write_items_request) = context.input_mut().downcast_mut::<aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput>() {
            modify_request!(cfg, transact_write_items_request, self, transact_write_items_input_transform);
        } else if let Some(update_item_request) = context.input_mut().downcast_mut::<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>() {
            modify_request!(cfg, update_item_request, self, update_item_input_transform);
        }
        Ok(())
    }

    fn modify_before_attempt_completion(
        &self,
        context: &mut FinalizerInterceptorContextMut,
        _rc: &RuntimeComponents,
        cfg: &mut ConfigBag,
    ) -> Result<(), BoxError> {
        if let Some(Ok(output)) = context.output_or_error_mut() {
            if let Some(batch_execute_statement_response) = output.downcast_mut::<aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput>() {
                modify_response!(cfg, aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput, batch_execute_statement_response, self, batch_execute_statement_output_transform);
            } else if let Some(batch_get_item_response) = output.downcast_mut::<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>() {
                modify_response!(cfg, aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput, batch_get_item_response, self, batch_get_item_output_transform);
            } else if let Some(batch_write_item_response) = output.downcast_mut::<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput>() {
                modify_response!(cfg, aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput, batch_write_item_response, self, batch_write_item_output_transform);
            } else if let Some(delete_item_response) = output.downcast_mut::<aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput>() {
                modify_response!(cfg, aws_sdk_dynamodb::operation::delete_item::DeleteItemInput, delete_item_response, self, delete_item_output_transform);
            } else if let Some(execute_statement_response) = output.downcast_mut::<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput>() {
                modify_response!(cfg, aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput, execute_statement_response, self, execute_statement_output_transform);
            } else if let Some(execute_transaction_response) = output.downcast_mut::<aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput>() {
                modify_response!(cfg, aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput, execute_transaction_response, self, execute_transaction_output_transform);
            } else if let Some(get_item_response) = output.downcast_mut::<aws_sdk_dynamodb::operation::get_item::GetItemOutput>() {
                modify_response!(cfg, aws_sdk_dynamodb::operation::get_item::GetItemInput, get_item_response, self, get_item_output_transform);
            } else if let Some(put_item_response) = output.downcast_mut::<aws_sdk_dynamodb::operation::put_item::PutItemOutput>() {
                modify_response!(cfg, aws_sdk_dynamodb::operation::put_item::PutItemInput, put_item_response, self, put_item_output_transform);
            } else if let Some(query_response) = output.downcast_mut::<aws_sdk_dynamodb::operation::query::QueryOutput>() {
                modify_response!(cfg, aws_sdk_dynamodb::operation::query::QueryInput, query_response, self, query_output_transform);
            } else if let Some(scan_response) = output.downcast_mut::<aws_sdk_dynamodb::operation::scan::ScanOutput>() {
                modify_response!(cfg, aws_sdk_dynamodb::operation::scan::ScanInput, scan_response, self, scan_output_transform);
            } else if let Some(transact_get_items_response) = output.downcast_mut::<aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput>() {
                modify_response!(cfg, aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput, transact_get_items_response, self, transact_get_items_output_transform);
            } else if let Some(transact_write_items_response) = output.downcast_mut::<aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput>() {
                modify_response!(cfg, aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput, transact_write_items_response, self, transact_write_items_output_transform);
            } else if let Some(update_item_response) = output.downcast_mut::<aws_sdk_dynamodb::operation::update_item::UpdateItemOutput>() {
                modify_response!(cfg, aws_sdk_dynamodb::operation::update_item::UpdateItemInput, update_item_response, self, update_item_output_transform);
            }
        }
        Ok(())
    }
}
