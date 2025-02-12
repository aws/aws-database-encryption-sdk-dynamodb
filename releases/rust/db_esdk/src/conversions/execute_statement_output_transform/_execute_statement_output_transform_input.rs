// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::execute_statement_output_transform::ExecuteStatementOutputTransformInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteStatementOutputTransformInput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteStatementOutputTransformInput::ExecuteStatementOutputTransformInput {
        sdkOutput: crate::deps::com_amazonaws_dynamodb::conversions::execute_statement::_execute_statement_response::to_dafny(&value.sdk_output.clone().unwrap())
,
 originalInput: crate::deps::com_amazonaws_dynamodb::conversions::execute_statement::_execute_statement_request::to_dafny(&value.original_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteStatementOutputTransformInput,
    >,
) -> crate::operation::execute_statement_output_transform::ExecuteStatementOutputTransformInput {
    crate::operation::execute_statement_output_transform::ExecuteStatementOutputTransformInput::builder()
        .set_sdk_output(Some( crate::deps::com_amazonaws_dynamodb::conversions::execute_statement::_execute_statement_response::from_dafny(dafny_value.sdkOutput().clone())
 ))
 .set_original_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::execute_statement::_execute_statement_request::from_dafny(dafny_value.originalInput().clone())
 ))
        .build()
        .unwrap()
}
