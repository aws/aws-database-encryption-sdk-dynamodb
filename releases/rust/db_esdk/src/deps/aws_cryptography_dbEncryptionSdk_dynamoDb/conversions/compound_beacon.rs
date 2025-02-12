// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CompoundBeacon,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CompoundBeacon{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CompoundBeacon::CompoundBeacon {
        name: crate::standard_library_conversions::ostring_to_dafny(&value.name) .Extract(),
 split: crate::standard_library_conversions::ostring_to_dafny(&value.split) .Extract(),
 encrypted: ::dafny_runtime::Rc::new(match &value.encrypted {
    Some(x) => crate::r#_Wrappers_Compile::Option::Some { value :
        ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(x,
            |e| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::encrypted_part::to_dafny(&e.clone())
,
        )
    },
    None => crate::r#_Wrappers_Compile::Option::None {}
})
,
 signed: ::dafny_runtime::Rc::new(match &value.signed {
    Some(x) => crate::r#_Wrappers_Compile::Option::Some { value :
        ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(x,
            |e| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::signed_part::to_dafny(&e.clone())
,
        )
    },
    None => crate::r#_Wrappers_Compile::Option::None {}
})
,
 constructors: ::dafny_runtime::Rc::new(match &value.constructors {
    Some(x) => crate::r#_Wrappers_Compile::Option::Some { value :
        ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(x,
            |e| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::constructor::to_dafny(&e.clone())
,
        )
    },
    None => crate::r#_Wrappers_Compile::Option::None {}
})
,
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon>,
) -> ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CompoundBeacon,
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
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CompoundBeacon,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon {
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CompoundBeacon,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CompoundBeacon::CompoundBeacon {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon::builder()
                .set_name(Some( dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(dafny_value.name()) ))
 .set_split(Some( dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(dafny_value.split()) ))
 .set_encrypted(match (*dafny_value.encrypted()).as_ref() {
    crate::r#_Wrappers_Compile::Option::Some { value } =>
        Some(
            ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(value,
                |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::EncryptedPart>| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::encrypted_part::from_dafny(e.clone())
,
            )
        ),
    _ => None
}
)
 .set_signed(match (*dafny_value.signed()).as_ref() {
    crate::r#_Wrappers_Compile::Option::Some { value } =>
        Some(
            ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(value,
                |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::SignedPart>| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::signed_part::from_dafny(e.clone())
,
            )
        ),
    _ => None
}
)
 .set_constructors(match (*dafny_value.constructors()).as_ref() {
    crate::r#_Wrappers_Compile::Option::Some { value } =>
        Some(
            ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(value,
                |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::Constructor>| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::constructor::from_dafny(e.clone())
,
            )
        ),
    _ => None
}
)
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CompoundBeacon,
    >>>,
) -> ::std::option::Option<
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
> {
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
