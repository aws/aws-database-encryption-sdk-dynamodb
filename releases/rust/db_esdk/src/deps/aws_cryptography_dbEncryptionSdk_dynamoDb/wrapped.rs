// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub mod client;

impl crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::wrapped::_default {
  pub fn WrappedDynamoDbEncryption(config: &::std::rc::Rc<
      crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbEncryptionConfig,
  >) -> ::std::rc::Rc<crate::r#_Wrappers_Compile::Result<
          ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IDynamoDbEncryptionClient>,
          ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Error>
  >>{
      crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::wrapped::client::Client::from_conf(config)
  }
}
