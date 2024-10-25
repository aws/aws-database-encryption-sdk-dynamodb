// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::types::QueryInputTransformOutput,
) -> ::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryInputTransformOutput,
>{
    ::std::rc::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::types::QueryInputTransformOutput,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryInputTransformOutput{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryInputTransformOutput::QueryInputTransformOutput {
        transformedInput: crate::deps::com_amazonaws_dynamodb::conversions::query::_query_request::to_dafny(&value.transformed_input.clone().unwrap())
,
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::types::QueryInputTransformOutput>,
) -> ::std::rc::Rc<crate::_Wrappers_Compile::Option<::std::rc::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryInputTransformOutput,
>>>{
    ::std::rc::Rc::new(match value {
        ::std::option::Option::None => crate::_Wrappers_Compile::Option::None {},
        ::std::option::Option::Some(x) => crate::_Wrappers_Compile::Option::Some {
            value: ::std::rc::Rc::new(to_dafny_plain(x)),
        },
    })
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::std::rc::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryInputTransformOutput,
    >,
) -> crate::types::QueryInputTransformOutput {
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryInputTransformOutput,
) -> crate::types::QueryInputTransformOutput {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryInputTransformOutput::QueryInputTransformOutput {..} =>
            crate::types::QueryInputTransformOutput::builder()
                .set_transformed_input(Some( crate::deps::com_amazonaws_dynamodb::conversions::query::_query_request::from_dafny(dafny_value.transformedInput().clone())
 ))
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::std::rc::Rc<crate::_Wrappers_Compile::Option<::std::rc::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::QueryInputTransformOutput,
    >>>,
) -> ::std::option::Option<crate::types::QueryInputTransformOutput> {
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
