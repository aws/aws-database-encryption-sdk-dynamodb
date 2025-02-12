// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::batch_execute_statement_output_transform::BatchExecuteStatementOutputTransformInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchExecuteStatementOutputTransformInput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchExecuteStatementOutputTransformInput::BatchExecuteStatementOutputTransformInput {
        sdkOutput: crate::deps::com_amazonaws_dynamodb::conversions::batch_execute_statement::_batch_execute_statement_response::to_dafny(&value.sdk_output.clone().unwrap())
,
 originalInput: crate::deps::com_amazonaws_dynamodb::conversions::batch_execute_statement::_batch_execute_statement_request::to_dafny(&value.original_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchExecuteStatementOutputTransformInput,
    >,
) -> crate::operation::batch_execute_statement_output_transform::BatchExecuteStatementOutputTransformInput{
    crate::operation::batch_execute_statement_output_transform::BatchExecuteStatementOutputTransformInput::builder()
        .set_sdk_output(Some( crate::deps::com_amazonaws_dynamodb::conversions::batch_execute_statement::_batch_execute_statement_response::from_dafny(dafny_value.sdkOutput().clone())
 ))
 .set_original_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::batch_execute_statement::_batch_execute_statement_request::from_dafny(dafny_value.originalInput().clone())
 ))
        .build()
        .unwrap()
}
