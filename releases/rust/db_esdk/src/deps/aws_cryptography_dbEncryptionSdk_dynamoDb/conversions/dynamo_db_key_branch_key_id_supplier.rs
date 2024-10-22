// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef,
) -> ::dafny_runtime::Object<
  dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IDynamoDbKeyBranchKeyIdSupplier,
> {
  let wrap = DynamoDbKeyBranchKeyIdSupplierWrapper {
      obj: value.clone(),
  };
  let inner = ::std::rc::Rc::new(::std::cell::UnsafeCell::new(wrap));
  ::dafny_runtime::Object (Some(inner) )
}

pub struct DynamoDbKeyBranchKeyIdSupplierWrapper {
  obj: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef,
}

impl ::dafny_runtime::UpcastObject<dyn ::std::any::Any> for DynamoDbKeyBranchKeyIdSupplierWrapper {
  ::dafny_runtime::UpcastObjectFn!(dyn ::std::any::Any);
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Object<
      dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IDynamoDbKeyBranchKeyIdSupplier,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef {
    let wrap = IDynamoDbKeyBranchKeyIdSupplierDafnyWrapper {
        obj: dafny_value.clone(),
    };
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef {
      inner: ::std::rc::Rc::new(::std::cell::RefCell::new(wrap))
    }
}

#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct IDynamoDbKeyBranchKeyIdSupplierDafnyWrapper {
  pub(crate) obj: ::dafny_runtime::Object<
      dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IDynamoDbKeyBranchKeyIdSupplier,
  >,
}

impl crate::software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IDynamoDbKeyBranchKeyIdSupplier
  for DynamoDbKeyBranchKeyIdSupplierWrapper
{
  fn r#_GetBranchKeyIdFromDdbKey_k(
    &self,
    input: &::std::rc::Rc<crate::software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetBranchKeyIdFromDdbKeyInput>,
) -> ::std::rc::Rc<
    crate::r#_Wrappers_Compile::Result<
        ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetBranchKeyIdFromDdbKeyOutput>,
        ::std::rc::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Error>,
    >,
>
{
    let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_branch_key_id_from_ddb_key::_get_branch_key_id_from_ddb_key_input::from_dafny(input.clone());
    let inner_result = self.obj.inner.borrow_mut().get_branch_key_id_from_ddb_key(inner_input);
    let result = match inner_result {
        Ok(x) => crate::r#_Wrappers_Compile::Result::Success {
            value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_branch_key_id_from_ddb_key::_get_branch_key_id_from_ddb_key_output::to_dafny(x.clone()),
        },
        Err(x) => crate::r#_Wrappers_Compile::Result::Failure {
            error: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::error::to_dafny(x),
        },
    };
    ::std::rc::Rc::new(result)
}
}

impl crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplier for IDynamoDbKeyBranchKeyIdSupplierDafnyWrapper
{
  fn get_branch_key_id_from_ddb_key(
  &self,
  input: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyInput,
) -> Result<
  crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyOutput,
  crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error,
> {
  let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_branch_key_id_from_ddb_key::_get_branch_key_id_from_ddb_key_input::to_dafny(input);
  let inner_result = ::dafny_runtime::md!(self.obj.clone()).GetBranchKeyIdFromDdbKey(&inner_input);
  if matches!(
      inner_result.as_ref(),
      crate::r#_Wrappers_Compile::Result::Success { .. }
  ) {
      Ok(
          crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_branch_key_id_from_ddb_key::_get_branch_key_id_from_ddb_key_output::from_dafny(inner_result.value().clone()),
      )
  } else {
      Err(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::error::from_dafny(
          inner_result.error().clone(),
      ))
  }
}
}
