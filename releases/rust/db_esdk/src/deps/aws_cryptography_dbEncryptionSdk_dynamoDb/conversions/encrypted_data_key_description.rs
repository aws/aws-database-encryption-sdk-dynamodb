// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::EncryptedDataKeyDescription,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::EncryptedDataKeyDescription{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::EncryptedDataKeyDescription::EncryptedDataKeyDescription {
        keyProviderId: crate::standard_library_conversions::ostring_to_dafny(&value.key_provider_id) .Extract(),
 keyProviderInfo: crate::standard_library_conversions::ostring_to_dafny(&value.key_provider_info),
 branchKeyId: crate::standard_library_conversions::ostring_to_dafny(&value.branch_key_id),
 branchKeyVersion: crate::standard_library_conversions::ostring_to_dafny(&value.branch_key_version),
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>,
) -> ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::EncryptedDataKeyDescription,
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
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::EncryptedDataKeyDescription,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription {
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::EncryptedDataKeyDescription,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::EncryptedDataKeyDescription::EncryptedDataKeyDescription {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription::builder()
                .set_key_provider_id(Some( dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(dafny_value.keyProviderId()) ))
 .set_key_provider_info(crate::standard_library_conversions::ostring_from_dafny(dafny_value.keyProviderInfo().clone()))
 .set_branch_key_id(crate::standard_library_conversions::ostring_from_dafny(dafny_value.branchKeyId().clone()))
 .set_branch_key_version(crate::standard_library_conversions::ostring_from_dafny(dafny_value.branchKeyVersion().clone()))
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::EncryptedDataKeyDescription,
    >>>,
) -> ::std::option::Option<
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription,
> {
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
