// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyOverride,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value.clone()))
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyOverride{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyOverride::LegacyOverride {
        policy: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::legacy_policy::to_dafny(value.policy.clone().unwrap()),
 encryptor: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::legacy_dynamo_db_encryptor::to_dafny(&value.encryptor.clone().unwrap())
,
 attributeActionsOnEncrypt: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.attribute_actions_on_encrypt.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&k),
    |v| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_action::to_dafny(v.clone()),
)
,
 defaultAttributeFlag: ::dafny_runtime::Rc::new(match &value.default_attribute_flag {
    Some(x) => crate::_Wrappers_Compile::Option::Some { value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_action::to_dafny(x.clone()) },
    None => crate::_Wrappers_Compile::Option::None { }
})
,
    }
}

#[allow(dead_code)]
pub fn option_to_dafny(
  value: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride>,
) -> ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
  crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyOverride,
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
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyOverride,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride {
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyOverride,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyOverride::LegacyOverride {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride::builder()
                .set_policy(Some( crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::legacy_policy::from_dafny(dafny_value.policy()) ))
 .set_encryptor(Some( crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::legacy_dynamo_db_encryptor::from_dafny(dafny_value.encryptor().clone())
 ))
 .set_attribute_actions_on_encrypt(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.attributeActionsOnEncrypt(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<::dafny_runtime::dafny_runtime_conversions::DafnyCharUTF16>| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(k),
    |v: &::dafny_runtime::Rc<crate::software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction>| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_action::from_dafny(v),
)
 ))
 .set_default_attribute_flag(match &**dafny_value.defaultAttributeFlag() {
    crate::r#_Wrappers_Compile::Option::Some { value } => Some(
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_action::from_dafny(value)
    ),
    _ => None,
}
)
                .build()
                .unwrap()
    }
}

#[allow(dead_code)]
pub fn option_from_dafny(
    dafny_value: ::dafny_runtime::Rc<crate::_Wrappers_Compile::Option<::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyOverride,
    >>>,
) -> ::std::option::Option<
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
> {
    match &*dafny_value {
        crate::_Wrappers_Compile::Option::Some { value } => {
            ::std::option::Option::Some(plain_from_dafny(value))
        }
        _ => ::std::option::Option::None,
    }
}
