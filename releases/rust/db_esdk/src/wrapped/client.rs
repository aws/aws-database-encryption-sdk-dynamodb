// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
use std::sync::LazyLock;

pub struct Client {
    wrapped: crate::client::Client
}

/// A runtime for executing operations on the asynchronous client in a blocking manner.
/// Necessary because Dafny only generates synchronous code.
static dafny_tokio_runtime: LazyLock<tokio::runtime::Runtime> = LazyLock::new(|| {
    tokio::runtime::Builder::new_multi_thread()
          .enable_all()
          .build()
          .unwrap()
});

impl dafny_runtime::UpcastObject<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::IDynamoDbEncryptionTransformsClient> for Client {
  ::dafny_runtime::UpcastObjectFn!(dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::IDynamoDbEncryptionTransformsClient);
}

impl dafny_runtime::UpcastObject<dyn std::any::Any> for Client {
    ::dafny_runtime::UpcastObjectFn!(dyn ::std::any::Any);
}

impl Client {
  pub fn from_conf(config: &::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::DynamoDbTablesEncryptionConfig,
  >) ->
::std::rc::Rc<crate::r#_Wrappers_Compile::Result<
  ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::IDynamoDbEncryptionTransformsClient>,
  ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>
>> {
    let result = crate::client::Client::from_conf(
      crate::conversions::dynamo_db_tables_encryption_config::_dynamo_db_tables_encryption_config::from_dafny(
          config.clone(),
      ),
    );
    match result {
      Ok(client) =>  {
        let wrap = crate::wrapped::client::Client {
          wrapped: client
        };
        std::rc::Rc::new(
          crate::_Wrappers_Compile::Result::Success {
            value: ::dafny_runtime::upcast_object()(::dafny_runtime::object::new(wrap))
          }
        )
      },
      Err(error) => crate::conversions::error::to_opaque_error_result(error)
    }
  }
}

impl crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::IDynamoDbEncryptionTransformsClient for Client {
    fn QueryInputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryInputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryInputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::query_input_transform::_query_input_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::query_input_transform::QueryInputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::query_input_transform::_query_input_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn TransactWriteItemsInputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsInputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsInputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::transact_write_items_input_transform::_transact_write_items_input_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::transact_write_items_input_transform::TransactWriteItemsInputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::transact_write_items_input_transform::_transact_write_items_input_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn GetItemInputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetItemInputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetItemInputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::get_item_input_transform::_get_item_input_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::get_item_input_transform::GetItemInputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::get_item_input_transform::_get_item_input_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn BatchGetItemInputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchGetItemInputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchGetItemInputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::batch_get_item_input_transform::_batch_get_item_input_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::batch_get_item_input_transform::BatchGetItemInputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::batch_get_item_input_transform::_batch_get_item_input_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn TransactWriteItemsOutputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsOutputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsOutputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::transact_write_items_output_transform::_transact_write_items_output_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::transact_write_items_output_transform::_transact_write_items_output_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn GetItemOutputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetItemOutputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetItemOutputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::get_item_output_transform::_get_item_output_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::get_item_output_transform::GetItemOutputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::get_item_output_transform::_get_item_output_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn BatchGetItemOutputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchGetItemOutputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchGetItemOutputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::batch_get_item_output_transform::_batch_get_item_output_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::batch_get_item_output_transform::_batch_get_item_output_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn ExecuteStatementInputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteStatementInputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteStatementInputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::execute_statement_input_transform::_execute_statement_input_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::execute_statement_input_transform::ExecuteStatementInputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::execute_statement_input_transform::_execute_statement_input_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn ResolveAttributes(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ResolveAttributesInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ResolveAttributesOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::resolve_attributes::_resolve_attributes_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::resolve_attributes::ResolveAttributes::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::resolve_attributes::_resolve_attributes_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn BatchWriteItemInputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchWriteItemInputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchWriteItemInputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::batch_write_item_input_transform::_batch_write_item_input_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::batch_write_item_input_transform::BatchWriteItemInputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::batch_write_item_input_transform::_batch_write_item_input_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn QueryOutputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryOutputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryOutputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::query_output_transform::_query_output_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::query_output_transform::QueryOutputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::query_output_transform::_query_output_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn ExecuteTransactionOutputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteTransactionOutputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteTransactionOutputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::execute_transaction_output_transform::_execute_transaction_output_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::execute_transaction_output_transform::_execute_transaction_output_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn DeleteItemOutputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::DeleteItemOutputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::DeleteItemOutputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::delete_item_output_transform::_delete_item_output_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::delete_item_output_transform::DeleteItemOutputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::delete_item_output_transform::_delete_item_output_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn TransactGetItemsInputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactGetItemsInputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactGetItemsInputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::transact_get_items_input_transform::_transact_get_items_input_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::transact_get_items_input_transform::TransactGetItemsInputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::transact_get_items_input_transform::_transact_get_items_input_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn BatchExecuteStatementInputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchExecuteStatementInputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchExecuteStatementInputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::batch_execute_statement_input_transform::_batch_execute_statement_input_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::batch_execute_statement_input_transform::BatchExecuteStatementInputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::batch_execute_statement_input_transform::_batch_execute_statement_input_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn PutItemOutputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::PutItemOutputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::PutItemOutputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::put_item_output_transform::_put_item_output_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::put_item_output_transform::PutItemOutputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::put_item_output_transform::_put_item_output_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn DeleteItemInputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::DeleteItemInputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::DeleteItemInputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::delete_item_input_transform::_delete_item_input_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::delete_item_input_transform::DeleteItemInputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::delete_item_input_transform::_delete_item_input_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn ScanOutputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ScanOutputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ScanOutputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::scan_output_transform::_scan_output_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::scan_output_transform::ScanOutputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::scan_output_transform::_scan_output_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn BatchExecuteStatementOutputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchExecuteStatementOutputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchExecuteStatementOutputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::batch_execute_statement_output_transform::_batch_execute_statement_output_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::batch_execute_statement_output_transform::BatchExecuteStatementOutputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::batch_execute_statement_output_transform::_batch_execute_statement_output_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn PutItemInputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::PutItemInputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::PutItemInputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::put_item_input_transform::_put_item_input_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::put_item_input_transform::PutItemInputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::put_item_input_transform::_put_item_input_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn ScanInputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ScanInputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ScanInputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::scan_input_transform::_scan_input_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::scan_input_transform::ScanInputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::scan_input_transform::_scan_input_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn UpdateItemOutputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::UpdateItemOutputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::UpdateItemOutputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::update_item_output_transform::_update_item_output_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::update_item_output_transform::UpdateItemOutputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::update_item_output_transform::_update_item_output_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn TransactGetItemsOutputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactGetItemsOutputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactGetItemsOutputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::transact_get_items_output_transform::_transact_get_items_output_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::transact_get_items_output_transform::TransactGetItemsOutputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::transact_get_items_output_transform::_transact_get_items_output_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn BatchWriteItemOutputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchWriteItemOutputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchWriteItemOutputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::batch_write_item_output_transform::_batch_write_item_output_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::batch_write_item_output_transform::BatchWriteItemOutputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::batch_write_item_output_transform::_batch_write_item_output_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn UpdateItemInputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::UpdateItemInputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::UpdateItemInputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::update_item_input_transform::_update_item_input_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::update_item_input_transform::UpdateItemInputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::update_item_input_transform::_update_item_input_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn ExecuteStatementOutputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteStatementOutputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteStatementOutputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::execute_statement_output_transform::_execute_statement_output_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::execute_statement_output_transform::ExecuteStatementOutputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::execute_statement_output_transform::_execute_statement_output_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn ExecuteTransactionInputTransform(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteTransactionInputTransformInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteTransactionInputTransformOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::conversions::execute_transaction_input_transform::_execute_transaction_input_transform_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::operation::execute_transaction_input_transform::ExecuteTransactionInputTransform::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::conversions::execute_transaction_input_transform::_execute_transaction_input_transform_output::to_dafny(inner_result),
                },
            ),
        }
    }
}
