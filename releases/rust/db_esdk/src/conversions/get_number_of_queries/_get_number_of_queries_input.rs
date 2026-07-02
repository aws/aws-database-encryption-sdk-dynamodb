// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::operation::get_number_of_queries::GetNumberOfQueriesInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesInput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesInput::GetNumberOfQueriesInput {
        input: crate::deps::com_amazonaws_dynamodb::conversions::query::_query_request::to_dafny(&value.input.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesInput,
    >,
) -> crate::operation::get_number_of_queries::GetNumberOfQueriesInput {
    crate::operation::get_number_of_queries::GetNumberOfQueriesInput::builder()
        .set_input(Some(
            crate::deps::com_amazonaws_dynamodb::conversions::query::_query_request::from_dafny(
                dafny_value.input().clone(),
            ),
        ))
        .build()
        .unwrap()
}
