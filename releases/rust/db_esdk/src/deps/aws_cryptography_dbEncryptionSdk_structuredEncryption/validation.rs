// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthenticateSchemaMap(
    input: &::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthenticateSchemaMap_Dkey(inner_key)?;
        validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthenticateSchemaMap_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthenticateSchemaMap_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthenticateSchemaMap_Dvalue(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthItem(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthItem_Dkey(&input.r#key)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthItem_Ddata(
        &input.r#data,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthItem_Daction(
        &input.r#action,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthItem_Daction(
    input: &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "action",
                "action is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthItem_Ddata(
    input: &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "data",
                "data is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataTerminal(
        input,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthItem_Dkey(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "key",
                "key is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HPath(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthList_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthItem(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoItem(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoItem_Dkey(
        &input.r#key,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoItem_Ddata(
        &input.r#data,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoItem_Daction(
        &input.r#action,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoItem_Daction(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "action",
                "action is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoItem_Ddata(
    input: &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "data",
                "data is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataTerminal(
        input,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoItem_Dkey(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "key",
                "key is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HPath(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoList_Dmember(
            inner,
        )?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoList_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoItem(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoSchemaMap(
    input: &::std::collections::HashMap<
        ::std::string::String,
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoSchemaMap_Dkey(
            inner_key,
        )?;
        validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoSchemaMap_Dvalue(
            inner_val,
        )?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoSchemaMap_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoSchemaMap_Dvalue(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::DecryptPathStructureInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput_DtableName(&input.r#table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput_DencryptedStructure(&input.r#encrypted_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput_Dcmm(&input.r#cmm)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput_DencryptionContext(&input.r#encryption_context)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput_for_StructuredEncryption_DecryptPathStructure(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::DecryptPathStructureInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput_DtableName(&input.r#table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput_DencryptedStructure(&input.r#encrypted_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput_Dcmm(&input.r#cmm)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput_DencryptionContext(&input.r#encryption_context)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput_Dcmm(
    input: &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "cmm",
                "cmm is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HCryptographicMaterialsManagerReference(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput_DencryptedStructure(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "encrypted_structure",
                "encrypted_structure is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput_DencryptionContext(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HEncryptionContext(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureInput_DtableName(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "table_name",
                "table_name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureOutput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::DecryptPathStructureOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureOutput_DplaintextStructure(&input.r#plaintext_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureOutput_DparsedHeader(&input.r#parsed_header)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureOutput_for_StructuredEncryption_DecryptPathStructure(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::DecryptPathStructureOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureOutput_DplaintextStructure(&input.r#plaintext_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureOutput_DparsedHeader(&input.r#parsed_header)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureOutput_DparsedHeader(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "parsed_header",
                "parsed_header is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HParsedHeader(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptPathStructureOutput_DplaintextStructure(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "plaintext_structure",
                "plaintext_structure is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::DecryptStructureInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_DtableName(&input.r#table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_DencryptedStructure(&input.r#encrypted_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_DauthenticateSchema(&input.r#authenticate_schema)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_Dcmm(
        &input.r#cmm,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_DencryptionContext(&input.r#encryption_context)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_for_StructuredEncryption_DecryptStructure(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_structure::DecryptStructureInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_DtableName(&input.r#table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_DencryptedStructure(&input.r#encrypted_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_DauthenticateSchema(&input.r#authenticate_schema)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_Dcmm(
        &input.r#cmm,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_DencryptionContext(&input.r#encryption_context)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_DauthenticateSchema(
    input: &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "authenticate_schema",
                "authenticate_schema is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthenticateSchemaMap(
        input,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_Dcmm(
    input: &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "cmm",
                "cmm is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HCryptographicMaterialsManagerReference(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_DencryptedStructure(
    input: &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "encrypted_structure",
                "encrypted_structure is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_DencryptionContext(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HEncryptionContext(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureInput_DtableName(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "table_name",
                "table_name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureOutput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::DecryptStructureOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureOutput_DplaintextStructure(&input.r#plaintext_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureOutput_DcryptoSchema(&input.r#crypto_schema)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureOutput_DparsedHeader(&input.r#parsed_header)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureOutput_for_StructuredEncryption_DecryptStructure(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_structure::DecryptStructureOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureOutput_DplaintextStructure(&input.r#plaintext_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureOutput_DcryptoSchema(&input.r#crypto_schema)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureOutput_DparsedHeader(&input.r#parsed_header)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureOutput_DcryptoSchema(
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
                "crypto_schema",
                "crypto_schema is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoSchemaMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureOutput_DparsedHeader(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "parsed_header",
                "parsed_header is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HParsedHeader(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HDecryptStructureOutput_DplaintextStructure(
    input: &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "plaintext_structure",
                "plaintext_structure is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptPathStructureInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_DtableName(&input.r#table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_DplaintextStructure(&input.r#plaintext_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_Dcmm(&input.r#cmm)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_DalgorithmSuiteId(&input.r#algorithm_suite_id)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_DencryptionContext(&input.r#encryption_context)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_for_StructuredEncryption_EncryptPathStructure(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_path_structure::EncryptPathStructureInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_DtableName(&input.r#table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_DplaintextStructure(&input.r#plaintext_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_Dcmm(&input.r#cmm)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_DalgorithmSuiteId(&input.r#algorithm_suite_id)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_DencryptionContext(&input.r#encryption_context)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_DalgorithmSuiteId(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_Dcmm(
    input: &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "cmm",
                "cmm is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HCryptographicMaterialsManagerReference(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_DencryptionContext(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HEncryptionContext(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_DplaintextStructure(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "plaintext_structure",
                "plaintext_structure is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureInput_DtableName(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "table_name",
                "table_name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureOutput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptPathStructureOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureOutput_DencryptedStructure(&input.r#encrypted_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureOutput_DparsedHeader(&input.r#parsed_header)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureOutput_for_StructuredEncryption_EncryptPathStructure(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_path_structure::EncryptPathStructureOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureOutput_DencryptedStructure(&input.r#encrypted_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureOutput_DparsedHeader(&input.r#parsed_header)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureOutput_DencryptedStructure(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "encrypted_structure",
                "encrypted_structure is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptPathStructureOutput_DparsedHeader(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "parsed_header",
                "parsed_header is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HParsedHeader(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DtableName(&input.r#table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DplaintextStructure(&input.r#plaintext_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DcryptoSchema(&input.r#crypto_schema)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_Dcmm(
        &input.r#cmm,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DalgorithmSuiteId(&input.r#algorithm_suite_id)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DencryptionContext(&input.r#encryption_context)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_for_StructuredEncryption_EncryptStructure(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_structure::EncryptStructureInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DtableName(&input.r#table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DplaintextStructure(&input.r#plaintext_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DcryptoSchema(&input.r#crypto_schema)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_Dcmm(
        &input.r#cmm,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DalgorithmSuiteId(&input.r#algorithm_suite_id)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DencryptionContext(&input.r#encryption_context)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DalgorithmSuiteId(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_Dcmm(
    input: &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "cmm",
                "cmm is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HCryptographicMaterialsManagerReference(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DcryptoSchema(
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
                "crypto_schema",
                "crypto_schema is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoSchemaMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DencryptionContext(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HEncryptionContext(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DplaintextStructure(
    input: &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "plaintext_structure",
                "plaintext_structure is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureInput_DtableName(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "table_name",
                "table_name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureOutput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureOutput_DencryptedStructure(&input.r#encrypted_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureOutput_DcryptoSchema(&input.r#crypto_schema)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureOutput_DparsedHeader(&input.r#parsed_header)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureOutput_for_StructuredEncryption_EncryptStructure(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_structure::EncryptStructureOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureOutput_DencryptedStructure(&input.r#encrypted_structure)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureOutput_DcryptoSchema(&input.r#crypto_schema)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureOutput_DparsedHeader(&input.r#parsed_header)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureOutput_DcryptoSchema(
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
                "crypto_schema",
                "crypto_schema is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoSchemaMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureOutput_DencryptedStructure(
    input: &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "encrypted_structure",
                "encrypted_structure is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HEncryptStructureOutput_DparsedHeader(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "parsed_header",
                "parsed_header is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HParsedHeader(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HParsedHeader(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HParsedHeader_DalgorithmSuiteId(&input.r#algorithm_suite_id)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HParsedHeader_DencryptedDataKeys(&input.r#encrypted_data_keys)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HParsedHeader_DstoredEncryptionContext(&input.r#stored_encryption_context)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HParsedHeader_DencryptionContext(&input.r#encryption_context)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HParsedHeader_DalgorithmSuiteId(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HParsedHeader_DencryptedDataKeys(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HParsedHeader_DencryptionContext(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HParsedHeader_DstoredEncryptionContext(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HPath(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HPath_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HPath_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HPathSegment(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HPathSegment(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if let crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment::Member(ref inner) = &input {
  validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HPathSegment_Dmember(inner)?;
}
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HPathSegment_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructureSegment,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructureSegment(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsInput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsInput_DtableName(&input.r#table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsInput_DauthActions(&input.r#auth_actions)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsInput_DheaderBytes(&input.r#header_bytes)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsInput_for_StructuredEncryption_ResolveAuthActions(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::ResolveAuthActionsInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsInput_DtableName(&input.r#table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsInput_DauthActions(&input.r#auth_actions)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsInput_DheaderBytes(&input.r#header_bytes)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsInput_DauthActions(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "auth_actions",
                "auth_actions is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HAuthList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsInput_DheaderBytes(
    input: &::std::option::Option<::aws_smithy_types::Blob>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "header_bytes",
                "header_bytes is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsInput_DtableName(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "table_name",
                "table_name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsOutput(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ResolveAuthActionsOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsOutput_DcryptoActions(&input.r#crypto_actions)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsOutput_for_StructuredEncryption_ResolveAuthActions(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::ResolveAuthActionsOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsOutput_DcryptoActions(&input.r#crypto_actions)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HResolveAuthActionsOutput_DcryptoActions(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "crypto_actions",
                "crypto_actions is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HCryptoList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataMap(
    input: &::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataMap_Dkey(
            inner_key,
        )?;
        validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataMap_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataMap_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataMap_Dvalue(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataTerminal(
        input,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataTerminal(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataTerminal_Dvalue(&input.r#value)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataTerminal_DtypeId(&input.r#type_id)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataTerminal_DtypeId(
    input: &::std::option::Option<::aws_smithy_types::Blob>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "type_id",
                "type_id is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(2..=2).contains(&input.as_ref().len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "type_id",
        "type_id failed to satisfy constraint: Member must have length between 2 and 2, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredDataTerminal_Dvalue(
    input: &::std::option::Option<::aws_smithy_types::Blob>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "value",
                "value is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructuredEncryptionConfig(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::structured_encryption_config::StructuredEncryptionConfig,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructureSegment(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructureSegment,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructureSegment_Dkey(
        &input.r#key,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PstructuredEncryption_HStructureSegment_Dkey(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "key",
                "key is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

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
