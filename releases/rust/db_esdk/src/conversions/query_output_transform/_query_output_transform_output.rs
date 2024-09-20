// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::query_output_transform::QueryOutputTransformOutput,
) -> ::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryOutputTransformOutput,
>{
    ::std::rc::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryOutputTransformOutput::QueryOutputTransformOutput {
        transformedOutput: crate::deps::com_amazonaws_dynamodb::conversions::query::_query_response::to_dafny(&value.transformed_output.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::std::rc::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryOutputTransformOutput,
    >,
) -> crate::operation::query_output_transform::QueryOutputTransformOutput {
    crate::operation::query_output_transform::QueryOutputTransformOutput::builder()
        .set_transformed_output(Some(
            crate::deps::com_amazonaws_dynamodb::conversions::query::_query_response::from_dafny(
                dafny_value.transformedOutput().clone(),
            ),
        ))
        .build()
        .unwrap()
}
