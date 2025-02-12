// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::put_item_output_transform::PutItemOutputTransformOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::PutItemOutputTransformOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::PutItemOutputTransformOutput::PutItemOutputTransformOutput {
        transformedOutput: crate::deps::com_amazonaws_dynamodb::conversions::put_item::_put_item_response::to_dafny(&value.transformed_output.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::PutItemOutputTransformOutput,
    >,
) -> crate::operation::put_item_output_transform::PutItemOutputTransformOutput {
    crate::operation::put_item_output_transform::PutItemOutputTransformOutput::builder()
        .set_transformed_output(Some( crate::deps::com_amazonaws_dynamodb::conversions::put_item::_put_item_response::from_dafny(dafny_value.transformedOutput().clone())
 ))
        .build()
        .unwrap()
}
