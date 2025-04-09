// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::batch_execute_statement_output_transform::BatchExecuteStatementOutputTransformOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchExecuteStatementOutputTransformOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchExecuteStatementOutputTransformOutput::BatchExecuteStatementOutputTransformOutput {
        transformedOutput: crate::deps::com_amazonaws_dynamodb::conversions::batch_execute_statement::_batch_execute_statement_response::to_dafny(&value.transformed_output.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::BatchExecuteStatementOutputTransformOutput,
    >,
) -> crate::operation::batch_execute_statement_output_transform::BatchExecuteStatementOutputTransformOutput{
    crate::operation::batch_execute_statement_output_transform::BatchExecuteStatementOutputTransformOutput::builder()
        .set_transformed_output(Some( crate::deps::com_amazonaws_dynamodb::conversions::batch_execute_statement::_batch_execute_statement_response::from_dafny(dafny_value.transformedOutput().clone())
 ))
        .build()
        .unwrap()
}
