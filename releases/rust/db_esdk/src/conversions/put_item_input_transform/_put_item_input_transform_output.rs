// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::put_item_input_transform::PutItemInputTransformOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::PutItemInputTransformOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::PutItemInputTransformOutput::PutItemInputTransformOutput {
        transformedInput: crate::deps::com_amazonaws_dynamodb::conversions::put_item::_put_item_request::to_dafny(&value.transformed_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::PutItemInputTransformOutput,
    >,
) -> crate::operation::put_item_input_transform::PutItemInputTransformOutput {
    crate::operation::put_item_input_transform::PutItemInputTransformOutput::builder()
        .set_transformed_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::put_item::_put_item_request::from_dafny(dafny_value.transformedInput().clone())
 ))
        .build()
        .unwrap()
}
