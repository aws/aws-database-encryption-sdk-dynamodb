// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::transact_write_items_input_transform::TransactWriteItemsInputTransformInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsInputTransformInput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsInputTransformInput::TransactWriteItemsInputTransformInput {
        sdkInput: crate::deps::com_amazonaws_dynamodb::conversions::transact_write_items::_transact_write_items_request::to_dafny(&value.sdk_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactWriteItemsInputTransformInput,
    >,
) -> crate::operation::transact_write_items_input_transform::TransactWriteItemsInputTransformInput {
    crate::operation::transact_write_items_input_transform::TransactWriteItemsInputTransformInput::builder()
        .set_sdk_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::transact_write_items::_transact_write_items_request::from_dafny(dafny_value.sdkInput().clone())
 ))
        .build()
        .unwrap()
}
