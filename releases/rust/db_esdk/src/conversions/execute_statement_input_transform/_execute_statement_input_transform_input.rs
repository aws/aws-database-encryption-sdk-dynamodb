// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::execute_statement_input_transform::ExecuteStatementInputTransformInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteStatementInputTransformInput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteStatementInputTransformInput::ExecuteStatementInputTransformInput {
        sdkInput: crate::deps::com_amazonaws_dynamodb::conversions::execute_statement::_execute_statement_request::to_dafny(&value.sdk_input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::ExecuteStatementInputTransformInput,
    >,
) -> crate::operation::execute_statement_input_transform::ExecuteStatementInputTransformInput {
    crate::operation::execute_statement_input_transform::ExecuteStatementInputTransformInput::builder()
        .set_sdk_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::execute_statement::_execute_statement_request::from_dafny(dafny_value.sdkInput().clone())
 ))
        .build()
        .unwrap()
}
