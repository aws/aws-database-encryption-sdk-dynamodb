// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::get_item_input_transform::GetItemInputTransformOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetItemInputTransformOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetItemInputTransformOutput::GetItemInputTransformOutput {
        transformedInput: crate::deps::com_amazonaws_dynamodb::conversions::get_item::_get_item_request::to_dafny(&value.transformed_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetItemInputTransformOutput,
    >,
) -> crate::operation::get_item_input_transform::GetItemInputTransformOutput {
    crate::operation::get_item_input_transform::GetItemInputTransformOutput::builder()
        .set_transformed_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::get_item::_get_item_request::from_dafny(dafny_value.transformedInput().clone())
 ))
        .build()
        .unwrap()
}
