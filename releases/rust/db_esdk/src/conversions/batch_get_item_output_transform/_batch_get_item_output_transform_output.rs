// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchGetItemOutputTransformOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchGetItemOutputTransformOutput::BatchGetItemOutputTransformOutput {
        transformedOutput: crate::deps::com_amazonaws_dynamodb::conversions::batch_get_item::_batch_get_item_response::to_dafny(&value.transformed_output.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchGetItemOutputTransformOutput,
    >,
) -> crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformOutput {
    crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformOutput::builder()
        .set_transformed_output(Some( crate::deps::com_amazonaws_dynamodb::conversions::batch_get_item::_batch_get_item_response::from_dafny(dafny_value.transformedOutput().clone())
 ))
        .build()
        .unwrap()
}
