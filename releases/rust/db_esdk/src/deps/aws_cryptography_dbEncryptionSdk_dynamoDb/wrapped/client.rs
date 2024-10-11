// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
use std::sync::LazyLock;

pub struct Client {
    wrapped: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::client::Client
}

/// A runtime for executing operations on the asynchronous client in a blocking manner.
/// Necessary because Dafny only generates synchronous code.
static dafny_tokio_runtime: LazyLock<tokio::runtime::Runtime> = LazyLock::new(|| {
    tokio::runtime::Builder::new_multi_thread()
          .enable_all()
          .build()
          .unwrap()
});

impl dafny_runtime::UpcastObject<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IDynamoDbEncryptionClient> for Client {
  ::dafny_runtime::UpcastObjectFn!(dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IDynamoDbEncryptionClient);
}

impl dafny_runtime::UpcastObject<dyn std::any::Any> for Client {
    ::dafny_runtime::UpcastObjectFn!(dyn ::std::any::Any);
}

impl Client {
  pub fn from_conf(config: &::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbEncryptionConfig,
  >) ->
::std::rc::Rc<crate::r#_Wrappers_Compile::Result<
  ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IDynamoDbEncryptionClient>,
  ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Error>
>> {
    let result = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::client::Client::from_conf(
      crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::dynamo_db_encryption_config::_dynamo_db_encryption_config::from_dafny(
          config.clone(),
      ),
    );
    match result {
      Ok(client) =>  {
        let wrap = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::wrapped::client::Client {
          wrapped: client
        };
        std::rc::Rc::new(
          crate::_Wrappers_Compile::Result::Success {
            value: ::dafny_runtime::upcast_object()(::dafny_runtime::object::new(wrap))
          }
        )
      },
      Err(error) => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::error::to_opaque_error_result(error)
    }
  }
}

impl crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IDynamoDbEncryptionClient for Client {
    fn GetEncryptedDataKeyDescription(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetEncryptedDataKeyDescriptionInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetEncryptedDataKeyDescriptionOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_encrypted_data_key_description::_get_encrypted_data_key_description_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescription::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_encrypted_data_key_description::_get_encrypted_data_key_description_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn CreateDynamoDbEncryptionBranchKeyIdSupplier(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::create_dynamo_db_encryption_branch_key_id_supplier::_create_dynamo_db_encryption_branch_key_id_supplier_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplier::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::create_dynamo_db_encryption_branch_key_id_supplier::_create_dynamo_db_encryption_branch_key_id_supplier_output::to_dafny(inner_result),
                },
            ),
        }
    }
}
