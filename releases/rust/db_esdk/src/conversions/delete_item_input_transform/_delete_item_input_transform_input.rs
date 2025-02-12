// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::delete_item_input_transform::DeleteItemInputTransformInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::DeleteItemInputTransformInput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::DeleteItemInputTransformInput::DeleteItemInputTransformInput {
        sdkInput: crate::deps::com_amazonaws_dynamodb::conversions::delete_item::_delete_item_request::to_dafny(&value.sdk_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::DeleteItemInputTransformInput,
    >,
) -> crate::operation::delete_item_input_transform::DeleteItemInputTransformInput {
    crate::operation::delete_item_input_transform::DeleteItemInputTransformInput::builder()
        .set_sdk_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::delete_item::_delete_item_request::from_dafny(dafny_value.sdkInput().clone())
 ))
        .build()
        .unwrap()
}
