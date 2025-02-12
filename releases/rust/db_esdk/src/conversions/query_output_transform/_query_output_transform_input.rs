// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::query_output_transform::QueryOutputTransformInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryOutputTransformInput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryOutputTransformInput::QueryOutputTransformInput {
        sdkOutput: crate::deps::com_amazonaws_dynamodb::conversions::query::_query_response::to_dafny(&value.sdk_output.clone().unwrap())
,
 originalInput: crate::deps::com_amazonaws_dynamodb::conversions::query::_query_request::to_dafny(&value.original_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryOutputTransformInput,
    >,
) -> crate::operation::query_output_transform::QueryOutputTransformInput {
    crate::operation::query_output_transform::QueryOutputTransformInput::builder()
        .set_sdk_output(Some(
            crate::deps::com_amazonaws_dynamodb::conversions::query::_query_response::from_dafny(
                dafny_value.sdkOutput().clone(),
            ),
        ))
        .set_original_input(Some(
            crate::deps::com_amazonaws_dynamodb::conversions::query::_query_request::from_dafny(
                dafny_value.originalInput().clone(),
            ),
        ))
        .build()
        .unwrap()
}
