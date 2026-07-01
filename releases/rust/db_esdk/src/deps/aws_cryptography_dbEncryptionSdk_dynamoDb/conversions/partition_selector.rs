// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::partition_selector::PartitionSelectorRef,
) -> ::dafny_runtime::Object<
  dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IPartitionSelector,
>{
    let wrap = PartitionSelectorWrapper { obj: value.clone() };
    let inner = ::dafny_runtime::Rc::new(::dafny_runtime::UnsafeCell::new(wrap));
    ::dafny_runtime::Object(Some(inner))
}

pub struct PartitionSelectorWrapper {
  obj: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::partition_selector::PartitionSelectorRef,
}

impl ::dafny_runtime::UpcastObject<::dafny_runtime::DynAny> for PartitionSelectorWrapper {
    ::dafny_runtime::UpcastObjectFn!(::dafny_runtime::DynAny);
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Object<
      dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IPartitionSelector,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::partition_selector::PartitionSelectorRef{
    let wrap = IPartitionSelectorDafnyWrapper {
        obj: dafny_value.clone(),
    };
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::partition_selector::PartitionSelectorRef {
      inner: ::dafny_runtime::Rc::new(::dafny_runtime::RefCell::new(wrap))
    }
}

#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct IPartitionSelectorDafnyWrapper {
  pub(crate) obj: ::dafny_runtime::Object<
      dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IPartitionSelector,
  >,
}

impl crate::software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IPartitionSelector
  for PartitionSelectorWrapper
{
  fn r#_GetPartitionNumber_k(
    &self,
    input: &::dafny_runtime::Rc<crate::software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetPartitionNumberInput>,
) -> ::dafny_runtime::Rc<
    crate::r#_Wrappers_Compile::Result<
        ::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetPartitionNumberOutput>,
        ::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Error>,
    >,
>
{
    let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_partition_number::_get_partition_number_input::from_dafny(input.clone());
    let inner_result = self.obj.inner.lock().unwrap().get_partition_number(inner_input);
    let result = match inner_result {
        Ok(x) => crate::r#_Wrappers_Compile::Result::Success {
            value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_partition_number::_get_partition_number_output::to_dafny(x.clone()),
        },
        Err(x) => crate::r#_Wrappers_Compile::Result::Failure {
            error: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::error::to_dafny(x),
        },
    };
    ::dafny_runtime::Rc::new(result)
}
}

impl crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::partition_selector::PartitionSelector for IPartitionSelectorDafnyWrapper
{
  fn get_partition_number(
  &self,
  input: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumberInput,
) -> Result<
  crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumberOutput,
  crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error,
> {
  let inner_input = crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_partition_number::_get_partition_number_input::to_dafny(input);
  let inner_result = ::dafny_runtime::md!(self.obj.clone()).GetPartitionNumber(&inner_input);
  if matches!(
      inner_result.as_ref(),
      crate::r#_Wrappers_Compile::Result::Success { .. }
  ) {
      Ok(
          crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_partition_number::_get_partition_number_output::from_dafny(inner_result.value().clone()),
      )
  } else {
      Err(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::error::from_dafny(
          inner_result.error().clone(),
      ))
  }
}
}
