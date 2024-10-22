// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionInput,
) -> ::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetEncryptedDataKeyDescriptionInput,
>{
    ::std::rc::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetEncryptedDataKeyDescriptionInput::GetEncryptedDataKeyDescriptionInput {
        input: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_encrypted_data_key_description_union::to_dafny(&value.input.clone().unwrap())
,
    })
}
 #[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::std::rc::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetEncryptedDataKeyDescriptionInput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionInput {
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionInput::builder()
        .set_input(Some( crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::get_encrypted_data_key_description_union::from_dafny(dafny_value.input().clone())
 ))
        .build()
        .unwrap()
}
