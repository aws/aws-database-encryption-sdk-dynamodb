// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCreateDynamoDbEncryptionBranchKeyIdSupplierInput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCreateDynamoDbEncryptionBranchKeyIdSupplierInput_DddbKeyBranchKeyIdSupplier(&input.r#ddb_key_branch_key_id_supplier)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCreateDynamoDbEncryptionBranchKeyIdSupplierInput_for_DynamoDbEncryption_CreateDynamoDbEncryptionBranchKeyIdSupplier(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplierInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCreateDynamoDbEncryptionBranchKeyIdSupplierInput_DddbKeyBranchKeyIdSupplier(&input.r#ddb_key_branch_key_id_supplier)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCreateDynamoDbEncryptionBranchKeyIdSupplierInput_DddbKeyBranchKeyIdSupplier(
    input: &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "ddb_key_branch_key_id_supplier",
                "ddb_key_branch_key_id_supplier is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbKeyBranchKeyIdSupplierReference(
        input,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCreateDynamoDbEncryptionBranchKeyIdSupplierOutput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCreateDynamoDbEncryptionBranchKeyIdSupplierOutput_DbranchKeyIdSupplier(&input.r#branch_key_id_supplier)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCreateDynamoDbEncryptionBranchKeyIdSupplierOutput_for_DynamoDbEncryption_CreateDynamoDbEncryptionBranchKeyIdSupplier(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCreateDynamoDbEncryptionBranchKeyIdSupplierOutput_DbranchKeyIdSupplier(&input.r#branch_key_id_supplier)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCreateDynamoDbEncryptionBranchKeyIdSupplierOutput_DbranchKeyIdSupplier(
    input: &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::branch_key_id_supplier::BranchKeyIdSupplierRef>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "branch_key_id_supplier",
                "branch_key_id_supplier is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HBranchKeyIdSupplierReference(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbEncryptionConfig(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfig,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbKeyBranchKeyIdSupplierReference(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescription(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescription_DkeyProviderId(&input.r#key_provider_id)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescription_DkeyProviderInfo(&input.r#key_provider_info)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescription_DbranchKeyId(&input.r#branch_key_id)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescription_DbranchKeyVersion(&input.r#branch_key_version)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescription_DbranchKeyId(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescription_DbranchKeyVersion(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescription_DkeyProviderId(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescription_DkeyProviderInfo(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescriptionList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescriptionList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescriptionList_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescription(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetBranchKeyIdFromDdbKeyInput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetBranchKeyIdFromDdbKeyInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetBranchKeyIdFromDdbKeyInput_DddbKey(
        &input.r#ddb_key,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetBranchKeyIdFromDdbKeyInput_for_DynamoDbKeyBranchKeyIdSupplier_GetBranchKeyIdFromDdbKey(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetBranchKeyIdFromDdbKeyInput_DddbKey(
        &input.r#ddb_key,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetBranchKeyIdFromDdbKeyInput_DddbKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "ddb_key",
                "ddb_key is required but was not specified",
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetBranchKeyIdFromDdbKeyOutput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetBranchKeyIdFromDdbKeyOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetBranchKeyIdFromDdbKeyOutput_DbranchKeyId(&input.r#branch_key_id)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetBranchKeyIdFromDdbKeyOutput_for_DynamoDbKeyBranchKeyIdSupplier_GetBranchKeyIdFromDdbKey(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetBranchKeyIdFromDdbKeyOutput_DbranchKeyId(&input.r#branch_key_id)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetBranchKeyIdFromDdbKeyOutput_DbranchKeyId(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "branch_key_id",
                "branch_key_id is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionInput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionInput_Dinput(&input.r#input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionInput_for_DynamoDbEncryption_GetEncryptedDataKeyDescription(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionInput_Dinput(&input.r#input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionInput_Dinput(
    input: &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "input",
                "input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionUnion(
        input,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionOutput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionOutput_DEncryptedDataKeyDescriptionOutput(&input.r#encrypted_data_key_description_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionOutput_for_DynamoDbEncryption_GetEncryptedDataKeyDescription(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionOutput_DEncryptedDataKeyDescriptionOutput(&input.r#encrypted_data_key_description_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionOutput_DEncryptedDataKeyDescriptionOutput(
    input: &::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "encrypted_data_key_description_output",
                "encrypted_data_key_description_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedDataKeyDescriptionList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionUnion(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion::Header(ref inner) = &input {
  validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionUnion_Dheader(inner)?;
}
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion::Item(ref inner) = &input {
  validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionUnion_Ditem(inner)?;
}
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionUnion_Dheader(
    input: &::aws_smithy_types::Blob,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetEncryptedDataKeyDescriptionUnion_Ditem(
    input: &::std::collections::HashMap<
        ::std::string::String,
        aws_sdk_dynamodb::types::AttributeValue,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HBranchKeyIdSupplierReference(
    input: &crate::deps::aws_cryptography_materialProviders::types::branch_key_id_supplier::BranchKeyIdSupplierRef,
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
