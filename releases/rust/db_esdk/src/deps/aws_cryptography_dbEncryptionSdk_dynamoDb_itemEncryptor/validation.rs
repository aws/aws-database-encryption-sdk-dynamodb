// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HAttributeActions(
    input: &::std::collections::HashMap<
        ::std::string::String,
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HAttributeActions_Dkey(inner_key)?;
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HAttributeActions_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HAttributeActions_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if !(0..=65535).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "key",
        "key failed to satisfy constraint: Member must have length between 0 and 65535, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HAttributeActions_Dvalue(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLegacyDynamoDbEncryptorReference(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::legacy_dynamo_db_encryptor::LegacyDynamoDbEncryptorRef,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLegacyOverride(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLegacyOverride_Dpolicy(&input.r#policy)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLegacyOverride_Dencryptor(
        &input.r#encryptor,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLegacyOverride_DattributeActionsOnEncrypt(&input.r#attribute_actions_on_encrypt)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLegacyOverride_DdefaultAttributeFlag(
        &input.r#default_attribute_flag,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLegacyOverride_DattributeActionsOnEncrypt(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "attribute_actions_on_encrypt",
                "attribute_actions_on_encrypt is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HAttributeActions(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLegacyOverride_DdefaultAttributeFlag(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLegacyOverride_Dencryptor(
    input: &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::legacy_dynamo_db_encryptor::LegacyDynamoDbEncryptorRef>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "encryptor",
                "encryptor is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLegacyDynamoDbEncryptorReference(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLegacyOverride_Dpolicy(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "policy",
                "policy is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemInput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemInput_DencryptedItem(&input.r#encrypted_item)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemInput_for_DynamoDbItemEncryptor_DecryptItem(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::DecryptItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemInput_DencryptedItem(&input.r#encrypted_item)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemInput_DencryptedItem(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "encrypted_item",
                "encrypted_item is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemOutput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemOutput_DplaintextItem(&input.r#plaintext_item)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemOutput_DparsedHeader(&input.r#parsed_header)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemOutput_for_DynamoDbItemEncryptor_DecryptItem(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::DecryptItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemOutput_DplaintextItem(&input.r#plaintext_item)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemOutput_DparsedHeader(&input.r#parsed_header)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemOutput_DparsedHeader(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDecryptItemOutput_DplaintextItem(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "plaintext_item",
                "plaintext_item is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::dynamo_db_item_encryptor_config::DynamoDbItemEncryptorConfig,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DlogicalTableName(&input.r#logical_table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DpartitionKeyName(&input.r#partition_key_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DsortKeyName(&input.r#sort_key_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DattributeActionsOnEncrypt(&input.r#attribute_actions_on_encrypt)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DallowedUnsignedAttributes(&input.r#allowed_unsigned_attributes)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DallowedUnsignedAttributePrefix(&input.r#allowed_unsigned_attribute_prefix)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DalgorithmSuiteId(&input.r#algorithm_suite_id)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_Dkeyring(&input.r#keyring)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_Dcmm(&input.r#cmm)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DlegacyOverride(&input.r#legacy_override)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DplaintextOverride(&input.r#plaintext_override)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DalgorithmSuiteId(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DallowedUnsignedAttributePrefix(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DallowedUnsignedAttributes(
    input: &::std::option::Option<::std::vec::Vec<::std::string::String>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "allowed_unsigned_attributes",
        "allowed_unsigned_attributes failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HAttributeNameList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DattributeActionsOnEncrypt(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "attribute_actions_on_encrypt",
                "attribute_actions_on_encrypt is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HAttributeActions(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_Dcmm(
    input: &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HCryptographicMaterialsManagerReference(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_Dkeyring(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HKeyringReference(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DlegacyOverride(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLegacyOverride(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DlogicalTableName(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "logical_table_name",
                "logical_table_name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DpartitionKeyName(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "partition_key_name",
                "partition_key_name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=255).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "partition_key_name",
        "partition_key_name failed to satisfy constraint: Member must have length between 1 and 255, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DplaintextOverride(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig_DsortKeyName(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=255).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "sort_key_name",
        "sort_key_name failed to satisfy constraint: Member must have length between 1 and 255, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HEncryptItemInput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::EncryptItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HEncryptItemInput_DplaintextItem(&input.r#plaintext_item)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HEncryptItemInput_for_DynamoDbItemEncryptor_EncryptItem(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::encrypt_item::EncryptItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HEncryptItemInput_DplaintextItem(&input.r#plaintext_item)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HEncryptItemInput_DplaintextItem(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "plaintext_item",
                "plaintext_item is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HEncryptItemOutput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::EncryptItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HEncryptItemOutput_DencryptedItem(&input.r#encrypted_item)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HEncryptItemOutput_DparsedHeader(&input.r#parsed_header)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HEncryptItemOutput_for_DynamoDbItemEncryptor_EncryptItem(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::encrypt_item::EncryptItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HEncryptItemOutput_DencryptedItem(&input.r#encrypted_item)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HEncryptItemOutput_DparsedHeader(&input.r#parsed_header)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HEncryptItemOutput_DencryptedItem(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "encrypted_item",
                "encrypted_item is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HEncryptItemOutput_DparsedHeader(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader_DattributeActionsOnEncrypt(&input.r#attribute_actions_on_encrypt)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader_DalgorithmSuiteId(&input.r#algorithm_suite_id)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader_DencryptedDataKeys(&input.r#encrypted_data_keys)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader_DstoredEncryptionContext(&input.r#stored_encryption_context)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader_DencryptionContext(&input.r#encryption_context)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader_DselectorContext(&input.r#selector_context)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader_DalgorithmSuiteId(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "algorithm_suite_id",
                "algorithm_suite_id is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader_DattributeActionsOnEncrypt(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "attribute_actions_on_encrypt",
                "attribute_actions_on_encrypt is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HAttributeActions(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader_DencryptedDataKeys(
    input: &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_materialProviders::types::EncryptedDataKey>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "encrypted_data_keys",
                "encrypted_data_keys is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HEncryptedDataKeyList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader_DencryptionContext(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "encryption_context",
                "encryption_context is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HEncryptionContext(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader_DselectorContext(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "selector_context",
                "selector_context is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HParsedHeader_DstoredEncryptionContext(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "stored_encryption_context",
                "stored_encryption_context is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HEncryptionContext(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HCryptographicMaterialsManagerReference(
    input: &crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HEncryptedDataKey(
    input: &crate::deps::aws_cryptography_materialProviders::types::EncryptedDataKey,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PmaterialProviders_HEncryptedDataKey_DkeyProviderId(
        &input.r#key_provider_id,
    )?;
    validate_aws_Pcryptography_PmaterialProviders_HEncryptedDataKey_DkeyProviderInfo(
        &input.r#key_provider_info,
    )?;
    validate_aws_Pcryptography_PmaterialProviders_HEncryptedDataKey_Dciphertext(
        &input.r#ciphertext,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HEncryptedDataKey_Dciphertext(
    input: &::std::option::Option<::aws_smithy_types::Blob>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "ciphertext",
                "ciphertext is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HEncryptedDataKey_DkeyProviderId(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "key_provider_id",
                "key_provider_id is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HEncryptedDataKey_DkeyProviderInfo(
    input: &::std::option::Option<::aws_smithy_types::Blob>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "key_provider_info",
                "key_provider_info is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HEncryptedDataKeyList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_materialProviders::types::EncryptedDataKey,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PmaterialProviders_HEncryptedDataKeyList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HEncryptedDataKeyList_Dmember(
    input: &crate::deps::aws_cryptography_materialProviders::types::EncryptedDataKey,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PmaterialProviders_HEncryptedDataKey(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HEncryptionContext(
    input: &::std::collections::HashMap<::std::string::String, ::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_aws_Pcryptography_PmaterialProviders_HEncryptionContext_Dkey(inner_key)?;
        validate_aws_Pcryptography_PmaterialProviders_HEncryptionContext_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HEncryptionContext_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HEncryptionContext_Dvalue(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HKeyringReference(
    input: &crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeMap(
    input: &::std::collections::HashMap<
        ::std::string::String,
        aws_sdk_dynamodb::types::AttributeValue,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HAttributeMap_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HAttributeMap_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeMap_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if !(0..=65535).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "key",
        "key failed to satisfy constraint: Member must have length between 0 and 65535, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeMap_Dvalue(
    input: &aws_sdk_dynamodb::types::AttributeValue,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeNameList(
    input: &::std::vec::Vec<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HAttributeNameList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeNameList_Dmember(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if !(0..=65535).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "member",
        "member failed to satisfy constraint: Member must have length between 0 and 65535, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValue(
    input: &aws_sdk_dynamodb::types::AttributeValue,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if let aws_sdk_dynamodb::types::AttributeValue::S(ref inner) = &input {
        validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DS(inner)?;
    }
    if let aws_sdk_dynamodb::types::AttributeValue::N(ref inner) = &input {
        validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DN(inner)?;
    }
    if let aws_sdk_dynamodb::types::AttributeValue::B(ref inner) = &input {
        validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DB(inner)?;
    }
    if let aws_sdk_dynamodb::types::AttributeValue::Ss(ref inner) = &input {
        validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DSS(inner)?;
    }
    if let aws_sdk_dynamodb::types::AttributeValue::Ns(ref inner) = &input {
        validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DNS(inner)?;
    }
    if let aws_sdk_dynamodb::types::AttributeValue::Bs(ref inner) = &input {
        validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DBS(inner)?;
    }
    if let aws_sdk_dynamodb::types::AttributeValue::M(ref inner) = &input {
        validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DM(inner)?;
    }
    if let aws_sdk_dynamodb::types::AttributeValue::L(ref inner) = &input {
        validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DL(inner)?;
    }
    if let aws_sdk_dynamodb::types::AttributeValue::Null(ref inner) = &input {
        validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DNULL(inner)?;
    }
    if let aws_sdk_dynamodb::types::AttributeValue::Bool(ref inner) = &input {
        validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DBOOL(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DB(
    input: &::aws_smithy_types::Blob,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DBOOL(
    input: &::std::primitive::bool,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DBS(
    input: &::std::vec::Vec<::aws_smithy_types::Blob>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HBinarySetAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DL(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::AttributeValue>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HListAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DM(
    input: &::std::collections::HashMap<
        ::std::string::String,
        aws_sdk_dynamodb::types::AttributeValue,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HMapAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DN(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DNS(
    input: &::std::vec::Vec<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HNumberSetAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DNULL(
    input: &::std::primitive::bool,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DS(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValue_DSS(
    input: &::std::vec::Vec<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HStringSetAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBinarySetAttributeValue(
    input: &::std::vec::Vec<::aws_smithy_types::Blob>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HBinarySetAttributeValue_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBinarySetAttributeValue_Dmember(
    input: &::aws_smithy_types::Blob,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKey(
    input: &::std::collections::HashMap<
        ::std::string::String,
        aws_sdk_dynamodb::types::AttributeValue,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HKey_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HKey_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKey_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if !(0..=65535).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "key",
        "key failed to satisfy constraint: Member must have length between 0 and 65535, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKey_Dvalue(
    input: &aws_sdk_dynamodb::types::AttributeValue,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HListAttributeValue(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::AttributeValue>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HListAttributeValue_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HListAttributeValue_Dmember(
    input: &aws_sdk_dynamodb::types::AttributeValue,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HMapAttributeValue(
    input: &::std::collections::HashMap<
        ::std::string::String,
        aws_sdk_dynamodb::types::AttributeValue,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HMapAttributeValue_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HMapAttributeValue_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HMapAttributeValue_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if !(0..=65535).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "key",
        "key failed to satisfy constraint: Member must have length between 0 and 65535, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HMapAttributeValue_Dvalue(
    input: &aws_sdk_dynamodb::types::AttributeValue,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HNumberSetAttributeValue(
    input: &::std::vec::Vec<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HNumberSetAttributeValue_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HNumberSetAttributeValue_Dmember(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HStringSetAttributeValue(
    input: &::std::vec::Vec<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HStringSetAttributeValue_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HStringSetAttributeValue_Dmember(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
