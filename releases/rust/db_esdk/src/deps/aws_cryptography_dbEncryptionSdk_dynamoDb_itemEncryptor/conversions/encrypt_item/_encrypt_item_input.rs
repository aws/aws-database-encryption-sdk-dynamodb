// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::encrypt_item::EncryptItemInput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::EncryptItemInput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::EncryptItemInput::EncryptItemInput {
        plaintextItem: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.plaintext_item.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&k),
    |v| crate::deps::com_amazonaws_dynamodb::conversions::attribute_value::to_dafny(&v.clone())
,
)
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::EncryptItemInput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::encrypt_item::EncryptItemInput{
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::encrypt_item::EncryptItemInput::builder()
        .set_plaintext_item(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.plaintextItem(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<::dafny_runtime::dafny_runtime_conversions::DafnyCharUTF16>| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(k),
    |v: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::services::dynamodb::internaldafny::types::AttributeValue>| crate::deps::com_amazonaws_dynamodb::conversions::attribute_value::from_dafny(v.clone())
,
)
 ))
        .build()
        .unwrap()
}
