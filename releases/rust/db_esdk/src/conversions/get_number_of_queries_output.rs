// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::types::GetNumberOfQueriesOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesOutput,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::types::GetNumberOfQueriesOutput,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesOutput{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesOutput::GetNumberOfQueriesOutput {
        numberOfQueries: value.number_of_queries.clone().unwrap(),
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::types::GetNumberOfQueriesOutput>,
) -> ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesOutput,
>>>{
    ::dafny_runtime::Rc::new(match value {
        ::std::option::Option::None => crate::_Wrappers_Compile::Option::None {},
        ::std::option::Option::Some(x) => crate::_Wrappers_Compile::Option::Some {
            value: ::dafny_runtime::Rc::new(to_dafny_plain(x)),
        },
    })
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesOutput,
    >,
) -> crate::types::GetNumberOfQueriesOutput {
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesOutput,
) -> crate::types::GetNumberOfQueriesOutput {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesOutput::GetNumberOfQueriesOutput {..} =>
            crate::types::GetNumberOfQueriesOutput::builder()
                .set_number_of_queries(Some( dafny_value.numberOfQueries() .clone() ))
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::GetNumberOfQueriesOutput,
    >>>,
) -> ::std::option::Option<crate::types::GetNumberOfQueriesOutput> {
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
