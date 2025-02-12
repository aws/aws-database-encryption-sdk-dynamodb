// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::transact_get_items_input_transform::TransactGetItemsInputTransformInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactGetItemsInputTransformInput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactGetItemsInputTransformInput::TransactGetItemsInputTransformInput {
        sdkInput: crate::deps::com_amazonaws_dynamodb::conversions::transact_get_items::_transact_get_items_request::to_dafny(&value.sdk_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::TransactGetItemsInputTransformInput,
    >,
) -> crate::operation::transact_get_items_input_transform::TransactGetItemsInputTransformInput {
    crate::operation::transact_get_items_input_transform::TransactGetItemsInputTransformInput::builder()
        .set_sdk_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::transact_get_items::_transact_get_items_request::from_dafny(dafny_value.sdkInput().clone())
 ))
        .build()
        .unwrap()
}
