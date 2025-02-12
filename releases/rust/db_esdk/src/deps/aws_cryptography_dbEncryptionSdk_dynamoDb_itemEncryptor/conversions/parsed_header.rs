// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::ParsedHeader,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::ParsedHeader{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::ParsedHeader::ParsedHeader {
        attributeActionsOnEncrypt: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.attribute_actions_on_encrypt.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&k),
    |v| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_action::to_dafny(v.clone()),
)
,
 algorithmSuiteId: crate::deps::aws_cryptography_materialProviders::conversions::dbe_algorithm_suite_id::to_dafny(value.algorithm_suite_id.clone().unwrap()),
 encryptedDataKeys: ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&value.encrypted_data_keys.clone().unwrap(),
    |e| crate::deps::aws_cryptography_materialProviders::conversions::encrypted_data_key::to_dafny(&e.clone())
,
)
,
 storedEncryptionContext: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.stored_encryption_context.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&k.as_bytes().to_vec(), |b| *b),
    |v| dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&v.as_bytes().to_vec(), |b| *b),
)
,
 encryptionContext: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.encryption_context.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&k.as_bytes().to_vec(), |b| *b),
    |v| dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&v.as_bytes().to_vec(), |b| *b),
)
,
 selectorContext: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.selector_context.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&k),
    |v| crate::deps::com_amazonaws_dynamodb::conversions::attribute_value::to_dafny(&v.clone())
,
)
,
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader>,
) -> ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::ParsedHeader,
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
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::ParsedHeader,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader {
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::ParsedHeader,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::ParsedHeader::ParsedHeader {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader::builder()
                .set_attribute_actions_on_encrypt(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.attributeActionsOnEncrypt(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<::dafny_runtime::dafny_runtime_conversions::DafnyCharUTF16>| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(k),
    |v: &::dafny_runtime::Rc<crate::software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction>| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_action::from_dafny(v),
)
 ))
 .set_algorithm_suite_id(Some( crate::deps::aws_cryptography_materialProviders::conversions::dbe_algorithm_suite_id::from_dafny(dafny_value.algorithmSuiteId()) ))
 .set_encrypted_data_keys(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(dafny_value.encryptedDataKeys(),
    |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::materialproviders::internaldafny::types::EncryptedDataKey>| crate::deps::aws_cryptography_materialProviders::conversions::encrypted_data_key::from_dafny(e.clone())
,
)
 ))
 .set_stored_encryption_context(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.storedEncryptionContext(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>| ::std::string::String::from_utf8(dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(&::std::borrow::Borrow::borrow(k), |b| *b)).unwrap(),
    |v: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>| ::std::string::String::from_utf8(dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(&::std::borrow::Borrow::borrow(v), |b| *b)).unwrap(),
)
 ))
 .set_encryption_context(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.encryptionContext(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>| ::std::string::String::from_utf8(dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(&::std::borrow::Borrow::borrow(k), |b| *b)).unwrap(),
    |v: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<u8>| ::std::string::String::from_utf8(dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(&::std::borrow::Borrow::borrow(v), |b| *b)).unwrap(),
)
 ))
 .set_selector_context(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.selectorContext(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<::dafny_runtime::dafny_runtime_conversions::DafnyCharUTF16>| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(k),
    |v: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::AttributeValue>| crate::deps::com_amazonaws_dynamodb::conversions::attribute_value::from_dafny(v.clone())
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
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::ParsedHeader,
    >>>,
) -> ::std::option::Option<
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
> {
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
