// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::update_item_output_transform::UpdateItemOutputTransformInput,
) -> ::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::UpdateItemOutputTransformInput,
>{
    ::std::rc::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::UpdateItemOutputTransformInput::UpdateItemOutputTransformInput {
        sdkOutput: crate::deps::com_amazonaws_dynamodb::conversions::update_item::_update_item_response::to_dafny(&value.sdk_output.clone().unwrap())
,
 originalInput: crate::deps::com_amazonaws_dynamodb::conversions::update_item::_update_item_request::to_dafny(&value.original_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::std::rc::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::UpdateItemOutputTransformInput,
    >,
) -> crate::operation::update_item_output_transform::UpdateItemOutputTransformInput {
    crate::operation::update_item_output_transform::UpdateItemOutputTransformInput::builder()
        .set_sdk_output(Some( crate::deps::com_amazonaws_dynamodb::conversions::update_item::_update_item_response::from_dafny(dafny_value.sdkOutput().clone())
 ))
 .set_original_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::update_item::_update_item_request::from_dafny(dafny_value.originalInput().clone())
 ))
        .build()
        .unwrap()
}
