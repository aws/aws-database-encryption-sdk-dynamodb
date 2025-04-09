// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]

pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::dynamo_db_item_encryptor_config::DynamoDbItemEncryptorConfig,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DynamoDbItemEncryptorConfig,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value))
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DynamoDbItemEncryptorConfig,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::dynamo_db_item_encryptor_config::DynamoDbItemEncryptorConfig{
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::dynamo_db_item_encryptor_config::DynamoDbItemEncryptorConfig,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DynamoDbItemEncryptorConfig{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DynamoDbItemEncryptorConfig::DynamoDbItemEncryptorConfig {
        logicalTableName: crate::standard_library_conversions::ostring_to_dafny(&value.logical_table_name) .Extract(),
 partitionKeyName: crate::standard_library_conversions::ostring_to_dafny(&value.partition_key_name) .Extract(),
 sortKeyName: crate::standard_library_conversions::ostring_to_dafny(&value.sort_key_name),
 attributeActionsOnEncrypt: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.attribute_actions_on_encrypt.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&k),
    |v| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_action::to_dafny(v.clone()),
)
,
 allowedUnsignedAttributes: ::dafny_runtime::Rc::new(match &value.allowed_unsigned_attributes {
    Some(x) => crate::r#_Wrappers_Compile::Option::Some { value :
        ::dafny_runtime::dafny_runtime_conversions::vec_to_dafny_sequence(x,
            |e| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&e),
        )
    },
    None => crate::r#_Wrappers_Compile::Option::None {}
})
,
 allowedUnsignedAttributePrefix: crate::standard_library_conversions::ostring_to_dafny(&value.allowed_unsigned_attribute_prefix),
 algorithmSuiteId: ::dafny_runtime::Rc::new(match &value.algorithm_suite_id {
    Some(x) => crate::_Wrappers_Compile::Option::Some { value: crate::deps::aws_cryptography_materialProviders::conversions::dbe_algorithm_suite_id::to_dafny(x.clone()) },
    None => crate::_Wrappers_Compile::Option::None { }
})
,
 keyring: ::dafny_runtime::Rc::new(match &value.keyring {
    Some(x) => crate::_Wrappers_Compile::Option::Some { value: crate::deps::aws_cryptography_materialProviders::conversions::keyring::to_dafny(&x.clone()) },
    None => crate::_Wrappers_Compile::Option::None { }
})
,
 cmm: ::dafny_runtime::Rc::new(match &value.cmm {
    Some(x) => crate::_Wrappers_Compile::Option::Some { value: crate::deps::aws_cryptography_materialProviders::conversions::cryptographic_materials_manager::to_dafny(&x.clone()) },
    None => crate::_Wrappers_Compile::Option::None { }
})
,
 legacyOverride: ::dafny_runtime::Rc::new(match &value.legacy_override {
    Some(x) => crate::_Wrappers_Compile::Option::Some { value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::legacy_override::to_dafny(&x.clone()) },
    None => crate::_Wrappers_Compile::Option::None { }
})
,
 plaintextOverride: ::dafny_runtime::Rc::new(match &value.plaintext_override {
    Some(x) => crate::_Wrappers_Compile::Option::Some { value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::plaintext_override::to_dafny(x.clone()) },
    None => crate::_Wrappers_Compile::Option::None { }
})
,
    }
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DynamoDbItemEncryptorConfig,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::dynamo_db_item_encryptor_config::DynamoDbItemEncryptorConfig{
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::DynamoDbItemEncryptorConfig::DynamoDbItemEncryptorConfig {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::dynamo_db_item_encryptor_config::DynamoDbItemEncryptorConfig::builder()
                .set_logical_table_name(Some( dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(dafny_value.logicalTableName()) ))
 .set_partition_key_name(Some( dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(dafny_value.partitionKeyName()) ))
 .set_sort_key_name(crate::standard_library_conversions::ostring_from_dafny(dafny_value.sortKeyName().clone()))
 .set_attribute_actions_on_encrypt(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.attributeActionsOnEncrypt(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<::dafny_runtime::dafny_runtime_conversions::DafnyCharUTF16>| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(k),
    |v: &::dafny_runtime::Rc<crate::software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction>| crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::conversions::crypto_action::from_dafny(v),
)
 ))
 .set_allowed_unsigned_attributes(match (*dafny_value.allowedUnsignedAttributes()).as_ref() {
    crate::r#_Wrappers_Compile::Option::Some { value } =>
        Some(
            ::dafny_runtime::dafny_runtime_conversions::dafny_sequence_to_vec(value,
                |e: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<::dafny_runtime::dafny_runtime_conversions::DafnyCharUTF16>| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(e),
            )
        ),
    _ => None
}
)
 .set_allowed_unsigned_attribute_prefix(crate::standard_library_conversions::ostring_from_dafny(dafny_value.allowedUnsignedAttributePrefix().clone()))
 .set_algorithm_suite_id(match &**dafny_value.algorithmSuiteId() {
    crate::r#_Wrappers_Compile::Option::Some { value } => Some(
        crate::deps::aws_cryptography_materialProviders::conversions::dbe_algorithm_suite_id::from_dafny(value)
    ),
    _ => None,
}
)
 .set_keyring(match (*dafny_value.keyring()).as_ref() {
    crate::r#_Wrappers_Compile::Option::Some { value } =>
        Some(crate::deps::aws_cryptography_materialProviders::conversions::keyring::from_dafny(value.clone())),
    _ => None,
}
)
 .set_cmm(match (*dafny_value.cmm()).as_ref() {
    crate::r#_Wrappers_Compile::Option::Some { value } =>
        Some(crate::deps::aws_cryptography_materialProviders::conversions::cryptographic_materials_manager::from_dafny(value.clone())),
    _ => None,
}
)
 .set_legacy_override(match (*dafny_value.legacyOverride()).as_ref() {
    crate::r#_Wrappers_Compile::Option::Some { value } =>
        Some(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::legacy_override::from_dafny(value.clone())),
    _ => None,
}
)
 .set_plaintext_override(match &**dafny_value.plaintextOverride() {
    crate::r#_Wrappers_Compile::Option::Some { value } => Some(
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::plaintext_override::from_dafny(value)
    ),
    _ => None,
}
)
                .build()
                .unwrap()
    }
}
