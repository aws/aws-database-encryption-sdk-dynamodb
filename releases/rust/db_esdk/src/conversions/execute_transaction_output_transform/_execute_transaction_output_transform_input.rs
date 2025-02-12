// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteTransactionOutputTransformInput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteTransactionOutputTransformInput::ExecuteTransactionOutputTransformInput {
        sdkOutput: crate::deps::com_amazonaws_dynamodb::conversions::execute_transaction::_execute_transaction_response::to_dafny(&value.sdk_output.clone().unwrap())
,
 originalInput: crate::deps::com_amazonaws_dynamodb::conversions::execute_transaction::_execute_transaction_request::to_dafny(&value.original_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteTransactionOutputTransformInput,
    >,
) -> crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformInput
{
    crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformInput::builder()
        .set_sdk_output(Some( crate::deps::com_amazonaws_dynamodb::conversions::execute_transaction::_execute_transaction_response::from_dafny(dafny_value.sdkOutput().clone())
 ))
 .set_original_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::execute_transaction::_execute_transaction_request::from_dafny(dafny_value.originalInput().clone())
 ))
        .build()
        .unwrap()
}
