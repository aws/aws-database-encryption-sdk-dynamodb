// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemInput,
) -> ::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DecryptItemInput,
> {
    ::std::rc::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemInput,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DecryptItemInput {
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DecryptItemInput::DecryptItemInput {
        encryptedItem: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.encrypted_item.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&k),
    |v| crate::deps::com_amazonaws_dynamodb::conversions::attribute_value::to_dafny(&v.clone())
,
)
,
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemInput>,
) -> ::std::rc::Rc<crate::_Wrappers_Compile::Option<::std::rc::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DecryptItemInput,
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
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DecryptItemInput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemInput {
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DecryptItemInput,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemInput {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DecryptItemInput::DecryptItemInput {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemInput::builder()
                .set_encrypted_item(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.encryptedItem(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<::dafny_runtime::dafny_runtime_conversions::DafnyCharUTF16>| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(k),
    |v: &::std::rc::Rc<crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::AttributeValue>| crate::deps::com_amazonaws_dynamodb::conversions::attribute_value::from_dafny(v.clone())
,
)
 ))
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::std::rc::Rc<crate::_Wrappers_Compile::Option<::std::rc::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DecryptItemInput,
    >>>,
) -> ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemInput> {
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
