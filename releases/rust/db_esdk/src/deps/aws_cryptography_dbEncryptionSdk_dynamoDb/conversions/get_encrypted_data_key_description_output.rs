// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetEncryptedDataKeyDescriptionOutput,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionOutput,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetEncryptedDataKeyDescriptionOutput{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetEncryptedDataKeyDescriptionOutput::GetEncryptedDataKeyDescriptionOutput {
        EncryptedDataKeyDescriptionOutput: ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(&value.encrypted_data_key_description_output.clone().unwrap(),
    |e| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::encrypted_data_key_description::to_dafny(&e.clone())
,
)
,
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionOutput>,
) -> ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetEncryptedDataKeyDescriptionOutput,
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
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetEncryptedDataKeyDescriptionOutput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionOutput{
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetEncryptedDataKeyDescriptionOutput,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionOutput{
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetEncryptedDataKeyDescriptionOutput::GetEncryptedDataKeyDescriptionOutput {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionOutput::builder()
                .set_encrypted_data_key_description_output(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(dafny_value.EncryptedDataKeyDescriptionOutput(),
    |e: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::EncryptedDataKeyDescription>| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::encrypted_data_key_description::from_dafny(e.clone())
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
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetEncryptedDataKeyDescriptionOutput,
    >>>,
) -> ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionOutput>{
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
