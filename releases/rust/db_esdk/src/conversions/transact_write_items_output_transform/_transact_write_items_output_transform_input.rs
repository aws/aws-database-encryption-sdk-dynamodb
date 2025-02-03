// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsOutputTransformInput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsOutputTransformInput::TransactWriteItemsOutputTransformInput {
        sdkOutput: crate::deps::com_amazonaws_dynamodb::conversions::transact_write_items::_transact_write_items_response::to_dafny(&value.sdk_output.clone().unwrap())
,
 originalInput: crate::deps::com_amazonaws_dynamodb::conversions::transact_write_items::_transact_write_items_request::to_dafny(&value.original_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsOutputTransformInput,
    >,
) -> crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformInput
{
    crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformInput::builder()
        .set_sdk_output(Some( crate::deps::com_amazonaws_dynamodb::conversions::transact_write_items::_transact_write_items_response::from_dafny(dafny_value.sdkOutput().clone())
 ))
 .set_original_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::transact_write_items::_transact_write_items_request::from_dafny(dafny_value.originalInput().clone())
 ))
        .build()
        .unwrap()
}
