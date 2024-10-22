// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::legacy_dynamo_db_encryptor::LegacyDynamoDbEncryptorRef,
) -> ::dafny_runtime::Object<
  dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::ILegacyDynamoDbEncryptor,
> {
  let wrap = LegacyDynamoDbEncryptorWrapper {
      obj: value.clone(),
  };
  let inner = ::std::rc::Rc::new(::std::cell::UnsafeCell::new(wrap));
  ::dafny_runtime::Object (Some(inner) )
}

pub struct LegacyDynamoDbEncryptorWrapper {
  obj: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::legacy_dynamo_db_encryptor::LegacyDynamoDbEncryptorRef,
}

impl ::dafny_runtime::UpcastObject<dyn ::std::any::Any> for LegacyDynamoDbEncryptorWrapper {
  ::dafny_runtime::UpcastObjectFn!(dyn ::std::any::Any);
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Object<
      dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::ILegacyDynamoDbEncryptor,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::legacy_dynamo_db_encryptor::LegacyDynamoDbEncryptorRef {
    let wrap = ILegacyDynamoDbEncryptorDafnyWrapper {
        obj: dafny_value.clone(),
    };
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::legacy_dynamo_db_encryptor::LegacyDynamoDbEncryptorRef {
      inner: ::std::rc::Rc::new(::std::cell::RefCell::new(wrap))
    }
}

#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct ILegacyDynamoDbEncryptorDafnyWrapper {
  pub(crate) obj: ::dafny_runtime::Object<
      dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::ILegacyDynamoDbEncryptor,
  >,
}

impl crate::software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::ILegacyDynamoDbEncryptor
  for LegacyDynamoDbEncryptorWrapper
{

}

impl crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::legacy_dynamo_db_encryptor::LegacyDynamoDbEncryptor for ILegacyDynamoDbEncryptorDafnyWrapper
{

}
