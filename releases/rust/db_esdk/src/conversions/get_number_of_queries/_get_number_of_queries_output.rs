// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::get_number_of_queries::GetNumberOfQueriesOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesOutput::GetNumberOfQueriesOutput {
        numberOfQueries: value.number_of_queries.clone().unwrap(),
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesOutput,
    >,
) -> crate::operation::get_number_of_queries::GetNumberOfQueriesOutput {
    crate::operation::get_number_of_queries::GetNumberOfQueriesOutput::builder()
        .set_number_of_queries(Some(dafny_value.numberOfQueries().clone()))
        .build()
        .unwrap()
}
