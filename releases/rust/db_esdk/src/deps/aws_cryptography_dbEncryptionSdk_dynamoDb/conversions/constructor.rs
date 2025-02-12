// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Constructor,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Constructor{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Constructor::Constructor {
        parts: ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&value.parts.clone().unwrap(),
    |e| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::constructor_part::to_dafny(&e.clone())
,
)
,
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor>,
) -> ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Constructor,
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
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Constructor,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor {
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Constructor,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Constructor::Constructor {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor::builder()
                .set_parts(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(dafny_value.parts(),
    |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::ConstructorPart>| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::constructor_part::from_dafny(e.clone())
,
)
 ))
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Constructor,
    >>>,
) -> ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor>
{
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
