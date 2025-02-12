// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteTransactionOutputTransformOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteTransactionOutputTransformOutput::ExecuteTransactionOutputTransformOutput {
        transformedOutput: crate::deps::com_amazonaws_dynamodb::conversions::execute_transaction::_execute_transaction_response::to_dafny(&value.transformed_output.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteTransactionOutputTransformOutput,
    >,
) -> crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformOutput
{
    crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformOutput::builder()
        .set_transformed_output(Some( crate::deps::com_amazonaws_dynamodb::conversions::execute_transaction::_execute_transaction_response::from_dafny(dafny_value.transformedOutput().clone())
 ))
        .build()
        .unwrap()
}
