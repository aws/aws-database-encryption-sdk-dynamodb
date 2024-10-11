// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
use std::sync::LazyLock;

pub struct Client {
    wrapped: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::client::Client
}

/// A runtime for executing operations on the asynchronous client in a blocking manner.
/// Necessary because Dafny only generates synchronous code.
static dafny_tokio_runtime: LazyLock<tokio::runtime::Runtime> = LazyLock::new(|| {
    tokio::runtime::Builder::new_multi_thread()
          .enable_all()
          .build()
          .unwrap()
});

impl dafny_runtime::UpcastObject<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::IDynamoDbItemEncryptorClient> for Client {
  ::dafny_runtime::UpcastObjectFn!(dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::IDynamoDbItemEncryptorClient);
}

impl dafny_runtime::UpcastObject<dyn std::any::Any> for Client {
    ::dafny_runtime::UpcastObjectFn!(dyn ::std::any::Any);
}

impl Client {
  pub fn from_conf(config: &::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DynamoDbItemEncryptorConfig,
  >) ->
::std::rc::Rc<crate::r#_Wrappers_Compile::Result<
  ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::IDynamoDbItemEncryptorClient>,
  ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::Error>
>> {
    let result = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::client::Client::from_conf(
      crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::dynamo_db_item_encryptor_config::_dynamo_db_item_encryptor_config::from_dafny(
          config.clone(),
      ),
    );
    match result {
      Ok(client) =>  {
        let wrap = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::wrapped::client::Client {
          wrapped: client
        };
        std::rc::Rc::new(
          crate::_Wrappers_Compile::Result::Success {
            value: ::dafny_runtime::upcast_object()(::dafny_runtime::object::new(wrap))
          }
        )
      },
      Err(error) => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::error::to_opaque_error_result(error)
    }
  }
}

impl crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::IDynamoDbItemEncryptorClient for Client {
    fn DecryptItem(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DecryptItemInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DecryptItemOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::decrypt_item::_decrypt_item_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::DecryptItem::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::decrypt_item::_decrypt_item_output::to_dafny(inner_result),
                },
            ),
        }
    }

    fn EncryptItem(
        &mut self,
        input: &::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::EncryptItemInput>,
    ) -> std::rc::Rc<
        crate::r#_Wrappers_Compile::Result<
            ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::EncryptItemOutput>,
            std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::Error>,
        >,
    >{
        let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::encrypt_item::_encrypt_item_input::from_dafny(input.clone());
        let result = tokio::task::block_in_place(|| {
            dafny_tokio_runtime.block_on(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::encrypt_item::EncryptItem::send(&self.wrapped, inner_input))
        });
        match result {
            Err(error) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Failure {
                    error: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::error::to_dafny(error),
                },
            ),
            Ok(inner_result) => ::std::rc::Rc::new(
                crate::_Wrappers_Compile::Result::Success {
                    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::encrypt_item::_encrypt_item_output::to_dafny(inner_result),
                },
            ),
        }
    }
}
