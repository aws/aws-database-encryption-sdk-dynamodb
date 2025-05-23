// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HAsSet(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::AsSet,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconKeySource(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource::Single(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconKeySource_Dsingle(inner)?;
    }
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource::Multi(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconKeySource_Dmulti(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconKeySource_Dmulti(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::MultiKeyStore,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HMultiKeyStore(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconKeySource_Dsingle(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SingleKeyStore,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSingleKeyStore(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconStyle(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::PartOnly(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconStyle_DpartOnly(inner)?;
    }
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::Shared(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconStyle_Dshared(inner)?;
    }
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::AsSet(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconStyle_DasSet(inner)?;
    }
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::SharedSet(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconStyle_DsharedSet(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconStyle_DasSet(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::AsSet,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HAsSet(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconStyle_DpartOnly(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PartOnly,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HPartOnly(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconStyle_Dshared(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Shared,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HShared(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconStyle_DsharedSet(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SharedSet,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSharedSet(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_Dversion(
        &input.r#version,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DkeyStore(
        &input.r#key_store,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DkeySource(
        &input.r#key_source,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DstandardBeacons(
        &input.r#standard_beacons,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DcompoundBeacons(
        &input.r#compound_beacons,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DvirtualFields(
        &input.r#virtual_fields,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DencryptedParts(
        &input.r#encrypted_parts,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DsignedParts(
        &input.r#signed_parts,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DcompoundBeacons(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "compound_beacons",
        "compound_beacons failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeaconList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DencryptedParts(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "encrypted_parts",
        "encrypted_parts failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedPartsList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DkeySource(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "key_source",
                "key_source is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconKeySource(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DkeyStore(
    input: &::std::option::Option<crate::deps::aws_cryptography_keyStore::client::Client>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "key_store",
                "key_store is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HKeyStoreReference(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DsignedParts(
    input: &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "signed_parts",
        "signed_parts failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSignedPartsList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DstandardBeacons(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "standard_beacons",
                "standard_beacons is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "standard_beacons",
        "standard_beacons failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeaconList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_Dversion(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "version",
                "version is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::invalid_field(
                "version",
                "version failed to satisfy constraint: Member must be greater than or equal to 1",
            ),
        );
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion_DvirtualFields(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "virtual_fields",
        "virtual_fields failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualFieldList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersionList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersionList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersionList_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersion(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeacon(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeacon_Dname(&input.r#name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeacon_Dsplit(&input.r#split)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeacon_Dencrypted(
        &input.r#encrypted,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeacon_Dsigned(&input.r#signed)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeacon_Dconstructors(
        &input.r#constructors,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeacon_Dconstructors(
    input: &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "constructors",
        "constructors failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeacon_Dencrypted(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "encrypted",
        "encrypted failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedPartsList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeacon_Dname(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "name",
                "name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeacon_Dsigned(
    input: &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "signed",
        "signed failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSignedPartsList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeacon_Dsplit(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "split",
                "split is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=1).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "split",
        "split failed to satisfy constraint: Member must have length between 1 and 1, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeaconList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeaconList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeaconList_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HCompoundBeacon(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructor(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructor_Dparts(&input.r#parts)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructor_Dparts(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "parts",
                "parts is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "parts",
        "parts failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorPartList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorList_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructor(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorPart(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorPart_Dname(&input.r#name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorPart_Drequired(
        &input.r#required,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorPart_Dname(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "name",
                "name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorPart_Drequired(
    input: &::std::option::Option<::std::primitive::bool>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "required",
                "required is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorPartList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorPartList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorPartList_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HConstructorPart(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DlogicalTableName(&input.r#logical_table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DpartitionKeyName(&input.r#partition_key_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DsortKeyName(&input.r#sort_key_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_Dsearch(
        &input.r#search,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DattributeActionsOnEncrypt(&input.r#attribute_actions_on_encrypt)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DallowedUnsignedAttributes(&input.r#allowed_unsigned_attributes)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DallowedUnsignedAttributePrefix(&input.r#allowed_unsigned_attribute_prefix)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DalgorithmSuiteId(&input.r#algorithm_suite_id)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_Dkeyring(
        &input.r#keyring,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_Dcmm(
        &input.r#cmm,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DlegacyOverride(&input.r#legacy_override)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DplaintextOverride(&input.r#plaintext_override)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DalgorithmSuiteId(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DallowedUnsignedAttributePrefix(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DallowedUnsignedAttributes(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DattributeActionsOnEncrypt(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_Dcmm(
    input: &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HCryptographicMaterialsManagerReference(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_Dkeyring(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DlegacyOverride(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DlogicalTableName(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DpartitionKeyName(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DplaintextOverride(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_Dsearch(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSearchConfig(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig_DsortKeyName(
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfigList(
    input: &::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfigList_Dkey(inner_key)?;
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfigList_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfigList_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if !(3..=255).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "key",
        "key failed to satisfy constraint: Member must have length between 3 and 255, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfigList_Dvalue(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfig(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTablesEncryptionConfig(
    input: &crate::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfig,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTablesEncryptionConfig_DtableEncryptionConfigs(&input.r#table_encryption_configs)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTablesEncryptionConfig_DtableEncryptionConfigs(
    input: &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "table_encryption_configs",
                "table_encryption_configs is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTableEncryptionConfigList(
        input,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedPart(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedPart_Dname(&input.r#name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedPart_Dprefix(&input.r#prefix)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedPart_Dname(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "name",
                "name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedPart_Dprefix(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "prefix",
                "prefix is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "prefix",
        "prefix failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedPartsList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedPartsList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedPartsList_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HEncryptedPart(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetPrefix(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPrefix,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetPrefix_Dlength(&input.r#length)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetPrefix_Dlength(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "length",
                "length is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegment(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegment,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegment_Dsplit(&input.r#split)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegment_Dindex(&input.r#index)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegment_Dindex(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "index",
                "index is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegment_Dsplit(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "split",
                "split is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=1).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "split",
        "split failed to satisfy constraint: Member must have length between 1 and 1, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegments(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegments,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegments_Dsplit(&input.r#split)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegments_Dlow(&input.r#low)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegments_Dhigh(&input.r#high)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegments_Dhigh(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "high",
                "high is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegments_Dlow(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "low",
                "low is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegments_Dsplit(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "split",
                "split is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=1).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "split",
        "split failed to satisfy constraint: Member must have length between 1 and 1, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSubstring(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSubstring,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSubstring_Dlow(&input.r#low)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSubstring_Dhigh(&input.r#high)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSubstring_Dhigh(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "high",
                "high is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSubstring_Dlow(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "low",
                "low is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSuffix(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSuffix,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSuffix_Dlength(&input.r#length)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSuffix_Dlength(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "length",
                "length is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HInsert(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Insert,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HInsert_Dliteral(&input.r#literal)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HInsert_Dliteral(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "literal",
                "literal is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HKeyStoreReference(
    input: &crate::deps::aws_cryptography_keyStore::client::Client,
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLower(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Lower,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HMultiKeyStore(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::MultiKeyStore,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HMultiKeyStore_DkeyFieldName(
        &input.r#key_field_name,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HMultiKeyStore_DcacheTTL(
        &input.r#cache_ttl,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HMultiKeyStore_Dcache(&input.r#cache)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HMultiKeyStore_DpartitionId(
        &input.r#partition_id,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HMultiKeyStore_Dcache(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::CacheType,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HCacheType(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HMultiKeyStore_DcacheTTL(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "cache_ttl",
                "cache_ttl is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HMultiKeyStore_DkeyFieldName(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "key_field_name",
                "key_field_name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HMultiKeyStore_DpartitionId(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HPartOnly(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PartOnly,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSearchConfig(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSearchConfig_Dversions(
        &input.r#versions,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSearchConfig_DwriteVersion(
        &input.r#write_version,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSearchConfig_Dversions(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "versions",
                "versions is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=1).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "versions",
        "versions failed to satisfy constraint: Member must have length between 1 and 1, inclusive",
    ));
    }
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconVersionList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSearchConfig_DwriteVersion(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "write_version",
                "write_version is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "write_version",
        "write_version failed to satisfy constraint: Member must be greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HShared(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Shared,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HShared_Dother(&input.r#other)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HShared_Dother(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "other",
                "other is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSharedSet(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SharedSet,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSharedSet_Dother(&input.r#other)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSharedSet_Dother(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "other",
                "other is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSignedPart(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSignedPart_Dname(&input.r#name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSignedPart_Dprefix(&input.r#prefix)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSignedPart_Dloc(&input.r#loc)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSignedPart_Dloc(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "loc",
        "loc failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSignedPart_Dname(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "name",
                "name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSignedPart_Dprefix(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "prefix",
                "prefix is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "prefix",
        "prefix failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSignedPartsList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSignedPartsList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSignedPartsList_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSignedPart(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSingleKeyStore(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SingleKeyStore,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSingleKeyStore_DkeyId(&input.r#key_id)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSingleKeyStore_DcacheTTL(
        &input.r#cache_ttl,
    )?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSingleKeyStore_Dcache(&input.r#cache)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSingleKeyStore_DpartitionId(
        &input.r#partition_id,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSingleKeyStore_Dcache(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::CacheType,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PmaterialProviders_HCacheType(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSingleKeyStore_DcacheTTL(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "cache_ttl",
                "cache_ttl is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSingleKeyStore_DkeyId(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "key_id",
                "key_id is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HSingleKeyStore_DpartitionId(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeacon(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeacon_Dname(&input.r#name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeacon_Dlength(&input.r#length)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeacon_Dloc(&input.r#loc)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeacon_Dstyle(&input.r#style)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeacon_Dlength(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "length",
                "length is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=63).contains(input) {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::invalid_field(
                "length",
                "length failed to satisfy constraint: Member must be between 1 and 63, inclusive",
            ),
        );
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeacon_Dloc(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "loc",
        "loc failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeacon_Dname(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "name",
                "name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeacon_Dstyle(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HBeaconStyle(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeaconList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeaconList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeaconList_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HStandardBeacon(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HUpper(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Upper,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualField(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualField_Dname(&input.r#name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualField_Dparts(&input.r#parts)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualField_Dname(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "name",
                "name is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualField_Dparts(
    input: &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "parts",
                "parts is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "parts",
        "parts failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualPartList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualFieldList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualFieldList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualFieldList_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualField(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualPart(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualPart_Dloc(&input.r#loc)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualPart_Dtrans(&input.r#trans)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualPart_Dloc(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "loc",
                "loc is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "loc",
        "loc failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualPart_Dtrans(
    input: &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "trans",
        "trans failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransformList(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualPartList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualPartList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualPartList_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualPart(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Upper(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dupper(inner)?;
    }
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Lower(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dlower(inner)?;
    }
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Insert(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dinsert(inner)?;
    }
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Prefix(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dprefix(inner)?;
    }
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Suffix(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dsuffix(inner)?;
    }
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Substring(ref inner) = &input {
  validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dsubstring(inner)?;
}
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Segment(ref inner) = &input {
  validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dsegment(inner)?;
}
    if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Segments(ref inner) = &input {
  validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dsegments(inner)?;
}
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dinsert(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Insert,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HInsert(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dlower(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Lower,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HLower(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dprefix(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPrefix,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetPrefix(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dsegment(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegment,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegment(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dsegments(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegments,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSegments(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dsubstring(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSubstring,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSubstring(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dsuffix(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSuffix,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetSuffix(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform_Dupper(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Upper,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HUpper(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransformList(
    input: &::std::vec::Vec<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransformList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransformList_Dmember(
    input: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HVirtualTransform(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementInputTransformInput(
    input: &crate::types::BatchExecuteStatementInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementInputTransformInput_for_DynamoDbEncryptionTransforms_BatchExecuteStatementInputTransform(
    input: &crate::operation::batch_execute_statement_input_transform::BatchExecuteStatementInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementInputTransformInput_DsdkInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_input",
                "sdk_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementInputTransformOutput(
    input: &crate::types::BatchExecuteStatementInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementInputTransformOutput_for_DynamoDbEncryptionTransforms_BatchExecuteStatementInputTransform(
    input: &crate::operation::batch_execute_statement_input_transform::BatchExecuteStatementInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementInputTransformOutput_DtransformedInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_input",
                "transformed_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementOutputTransformInput(
    input: &crate::types::BatchExecuteStatementOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementOutputTransformInput_for_DynamoDbEncryptionTransforms_BatchExecuteStatementOutputTransform(
    input: &crate::operation::batch_execute_statement_output_transform::BatchExecuteStatementOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementOutputTransformInput_DoriginalInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "original_input",
                "original_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementOutputTransformInput_DsdkOutput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_output",
                "sdk_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementOutputTransformOutput(
    input: &crate::types::BatchExecuteStatementOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementOutputTransformOutput_for_DynamoDbEncryptionTransforms_BatchExecuteStatementOutputTransform(
    input: &crate::operation::batch_execute_statement_output_transform::BatchExecuteStatementOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchExecuteStatementOutputTransformOutput_DtransformedOutput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_output",
                "transformed_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemInputTransformInput(
    input: &crate::types::BatchGetItemInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemInputTransformInput_for_DynamoDbEncryptionTransforms_BatchGetItemInputTransform(
    input: &crate::operation::batch_get_item_input_transform::BatchGetItemInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemInputTransformInput_DsdkInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_input",
                "sdk_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchGetItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemInputTransformOutput(
    input: &crate::types::BatchGetItemInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemInputTransformOutput_for_DynamoDbEncryptionTransforms_BatchGetItemInputTransform(
    input: &crate::operation::batch_get_item_input_transform::BatchGetItemInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemInputTransformOutput_DtransformedInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_input",
                "transformed_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchGetItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemOutputTransformInput(
    input: &crate::types::BatchGetItemOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemOutputTransformInput_for_DynamoDbEncryptionTransforms_BatchGetItemOutputTransform(
    input: &crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemOutputTransformInput_DoriginalInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "original_input",
                "original_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchGetItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemOutputTransformInput_DsdkOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_output",
                "sdk_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchGetItemOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemOutputTransformOutput(
    input: &crate::types::BatchGetItemOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemOutputTransformOutput_for_DynamoDbEncryptionTransforms_BatchGetItemOutputTransform(
    input: &crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchGetItemOutputTransformOutput_DtransformedOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_output",
                "transformed_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchGetItemOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemInputTransformInput(
    input: &crate::types::BatchWriteItemInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemInputTransformInput_for_DynamoDbEncryptionTransforms_BatchWriteItemInputTransform(
    input: &crate::operation::batch_write_item_input_transform::BatchWriteItemInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemInputTransformInput_DsdkInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_input",
                "sdk_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemInputTransformOutput(
    input: &crate::types::BatchWriteItemInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemInputTransformOutput_for_DynamoDbEncryptionTransforms_BatchWriteItemInputTransform(
    input: &crate::operation::batch_write_item_input_transform::BatchWriteItemInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemInputTransformOutput_DtransformedInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_input",
                "transformed_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemOutputTransformInput(
    input: &crate::types::BatchWriteItemOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemOutputTransformInput_for_DynamoDbEncryptionTransforms_BatchWriteItemOutputTransform(
    input: &crate::operation::batch_write_item_output_transform::BatchWriteItemOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemOutputTransformInput_DoriginalInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "original_input",
                "original_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemOutputTransformInput_DsdkOutput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_output",
                "sdk_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemOutputTransformOutput(
    input: &crate::types::BatchWriteItemOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemOutputTransformOutput_for_DynamoDbEncryptionTransforms_BatchWriteItemOutputTransform(
    input: &crate::operation::batch_write_item_output_transform::BatchWriteItemOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HBatchWriteItemOutputTransformOutput_DtransformedOutput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_output",
                "transformed_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemInputTransformInput(
    input: &crate::types::DeleteItemInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemInputTransformInput_for_DynamoDbEncryptionTransforms_DeleteItemInputTransform(
    input: &crate::operation::delete_item_input_transform::DeleteItemInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemInputTransformInput_DsdkInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_input",
                "sdk_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemInputTransformOutput(
    input: &crate::types::DeleteItemInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemInputTransformOutput_for_DynamoDbEncryptionTransforms_DeleteItemInputTransform(
    input: &crate::operation::delete_item_input_transform::DeleteItemInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemInputTransformOutput_DtransformedInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_input",
                "transformed_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemOutputTransformInput(
    input: &crate::types::DeleteItemOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemOutputTransformInput_for_DynamoDbEncryptionTransforms_DeleteItemOutputTransform(
    input: &crate::operation::delete_item_output_transform::DeleteItemOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemOutputTransformInput_DoriginalInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "original_input",
                "original_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemOutputTransformInput_DsdkOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_output",
                "sdk_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HDeleteItemOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemOutputTransformOutput(
    input: &crate::types::DeleteItemOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemOutputTransformOutput_for_DynamoDbEncryptionTransforms_DeleteItemOutputTransform(
    input: &crate::operation::delete_item_output_transform::DeleteItemOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HDeleteItemOutputTransformOutput_DtransformedOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_output",
                "transformed_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HDeleteItemOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementInputTransformInput(
    input: &crate::types::ExecuteStatementInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementInputTransformInput_for_DynamoDbEncryptionTransforms_ExecuteStatementInputTransform(
    input: &crate::operation::execute_statement_input_transform::ExecuteStatementInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementInputTransformInput_DsdkInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_input",
                "sdk_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementInputTransformOutput(
    input: &crate::types::ExecuteStatementInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementInputTransformOutput_for_DynamoDbEncryptionTransforms_ExecuteStatementInputTransform(
    input: &crate::operation::execute_statement_input_transform::ExecuteStatementInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementInputTransformOutput_DtransformedInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_input",
                "transformed_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementOutputTransformInput(
    input: &crate::types::ExecuteStatementOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementOutputTransformInput_for_DynamoDbEncryptionTransforms_ExecuteStatementOutputTransform(
    input: &crate::operation::execute_statement_output_transform::ExecuteStatementOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementOutputTransformInput_DoriginalInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "original_input",
                "original_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementOutputTransformInput_DsdkOutput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_output",
                "sdk_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementOutputTransformOutput(
    input: &crate::types::ExecuteStatementOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementOutputTransformOutput_for_DynamoDbEncryptionTransforms_ExecuteStatementOutputTransform(
    input: &crate::operation::execute_statement_output_transform::ExecuteStatementOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteStatementOutputTransformOutput_DtransformedOutput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_output",
                "transformed_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionInputTransformInput(
    input: &crate::types::ExecuteTransactionInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionInputTransformInput_for_DynamoDbEncryptionTransforms_ExecuteTransactionInputTransform(
    input: &crate::operation::execute_transaction_input_transform::ExecuteTransactionInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionInputTransformInput_DsdkInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_input",
                "sdk_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionInputTransformOutput(
    input: &crate::types::ExecuteTransactionInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionInputTransformOutput_for_DynamoDbEncryptionTransforms_ExecuteTransactionInputTransform(
    input: &crate::operation::execute_transaction_input_transform::ExecuteTransactionInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionInputTransformOutput_DtransformedInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_input",
                "transformed_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionOutputTransformInput(
    input: &crate::types::ExecuteTransactionOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionOutputTransformInput_for_DynamoDbEncryptionTransforms_ExecuteTransactionOutputTransform(
    input: &crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionOutputTransformInput_DoriginalInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "original_input",
                "original_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionOutputTransformInput_DsdkOutput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_output",
                "sdk_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionOutputTransformOutput(
    input: &crate::types::ExecuteTransactionOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionOutputTransformOutput_for_DynamoDbEncryptionTransforms_ExecuteTransactionOutputTransform(
    input: &crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HExecuteTransactionOutputTransformOutput_DtransformedOutput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_output",
                "transformed_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemInputTransformInput(
    input: &crate::types::GetItemInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemInputTransformInput_for_DynamoDbEncryptionTransforms_GetItemInputTransform(
    input: &crate::operation::get_item_input_transform::GetItemInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemInputTransformInput_DsdkInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_input",
                "sdk_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HGetItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemInputTransformOutput(
    input: &crate::types::GetItemInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemInputTransformOutput_for_DynamoDbEncryptionTransforms_GetItemInputTransform(
    input: &crate::operation::get_item_input_transform::GetItemInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemInputTransformOutput_DtransformedInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_input",
                "transformed_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HGetItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformInput(
    input: &crate::types::GetItemOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformInput_for_DynamoDbEncryptionTransforms_GetItemOutputTransform(
    input: &crate::operation::get_item_output_transform::GetItemOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformInput_DoriginalInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "original_input",
                "original_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HGetItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformInput_DsdkOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_output",
                "sdk_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HGetItemOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformOutput(
    input: &crate::types::GetItemOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformOutput_for_DynamoDbEncryptionTransforms_GetItemOutputTransform(
    input: &crate::operation::get_item_output_transform::GetItemOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HGetItemOutputTransformOutput_DtransformedOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_output",
                "transformed_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HGetItemOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemInputTransformInput(
    input: &crate::types::PutItemInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemInputTransformInput_for_DynamoDbEncryptionTransforms_PutItemInputTransform(
    input: &crate::operation::put_item_input_transform::PutItemInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemInputTransformInput_DsdkInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_input",
                "sdk_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HPutItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemInputTransformOutput(
    input: &crate::types::PutItemInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemInputTransformOutput_for_DynamoDbEncryptionTransforms_PutItemInputTransform(
    input: &crate::operation::put_item_input_transform::PutItemInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemInputTransformOutput_DtransformedInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_input",
                "transformed_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HPutItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemOutputTransformInput(
    input: &crate::types::PutItemOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemOutputTransformInput_for_DynamoDbEncryptionTransforms_PutItemOutputTransform(
    input: &crate::operation::put_item_output_transform::PutItemOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemOutputTransformInput_DoriginalInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "original_input",
                "original_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HPutItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemOutputTransformInput_DsdkOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_output",
                "sdk_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HPutItemOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemOutputTransformOutput(
    input: &crate::types::PutItemOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemOutputTransformOutput_for_DynamoDbEncryptionTransforms_PutItemOutputTransform(
    input: &crate::operation::put_item_output_transform::PutItemOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HPutItemOutputTransformOutput_DtransformedOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::put_item::PutItemOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_output",
                "transformed_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HPutItemOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryInputTransformInput(
    input: &crate::types::QueryInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryInputTransformInput_for_DynamoDbEncryptionTransforms_QueryInputTransform(
    input: &crate::operation::query_input_transform::QueryInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryInputTransformInput_DsdkInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_input",
                "sdk_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HQueryInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryInputTransformOutput(
    input: &crate::types::QueryInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryInputTransformOutput_for_DynamoDbEncryptionTransforms_QueryInputTransform(
    input: &crate::operation::query_input_transform::QueryInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryInputTransformOutput_DtransformedInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_input",
                "transformed_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HQueryInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformInput(
    input: &crate::types::QueryOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformInput_for_DynamoDbEncryptionTransforms_QueryOutputTransform(
    input: &crate::operation::query_output_transform::QueryOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformInput_DoriginalInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "original_input",
                "original_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HQueryInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformInput_DsdkOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::query::QueryOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_output",
                "sdk_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HQueryOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformOutput(
    input: &crate::types::QueryOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformOutput_for_DynamoDbEncryptionTransforms_QueryOutputTransform(
    input: &crate::operation::query_output_transform::QueryOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HQueryOutputTransformOutput_DtransformedOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::query::QueryOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_output",
                "transformed_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HQueryOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesInput(
    input: &crate::types::ResolveAttributesInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesInput_DTableName(&input.r#table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesInput_DItem(&input.r#item)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesInput_DVersion(&input.r#version)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesInput_for_DynamoDbEncryptionTransforms_ResolveAttributes(
    input: &crate::operation::resolve_attributes::ResolveAttributesInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesInput_DTableName(&input.r#table_name)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesInput_DItem(&input.r#item)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesInput_DVersion(&input.r#version)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesInput_DItem(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "item",
                "item is required but was not specified",
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
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesInput_DTableName(
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

    if !(3..=255).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 3 and 255, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesInput_DVersion(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::invalid_field(
                "version",
                "version failed to satisfy constraint: Member must be greater than or equal to 1",
            ),
        );
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesOutput(
    input: &crate::types::ResolveAttributesOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesOutput_DVirtualFields(&input.r#virtual_fields)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesOutput_DCompoundBeacons(&input.r#compound_beacons)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesOutput_for_DynamoDbEncryptionTransforms_ResolveAttributes(
    input: &crate::operation::resolve_attributes::ResolveAttributesOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesOutput_DVirtualFields(&input.r#virtual_fields)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesOutput_DCompoundBeacons(&input.r#compound_beacons)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesOutput_DCompoundBeacons(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "compound_beacons",
                "compound_beacons is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HStringMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HResolveAttributesOutput_DVirtualFields(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "virtual_fields",
                "virtual_fields is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HStringMap(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanInputTransformInput(
    input: &crate::types::ScanInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanInputTransformInput_for_DynamoDbEncryptionTransforms_ScanInputTransform(
    input: &crate::operation::scan_input_transform::ScanInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanInputTransformInput_DsdkInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_input",
                "sdk_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HScanInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanInputTransformOutput(
    input: &crate::types::ScanInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanInputTransformOutput_for_DynamoDbEncryptionTransforms_ScanInputTransform(
    input: &crate::operation::scan_input_transform::ScanInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanInputTransformOutput_DtransformedInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_input",
                "transformed_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HScanInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanOutputTransformInput(
    input: &crate::types::ScanOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanOutputTransformInput_for_DynamoDbEncryptionTransforms_ScanOutputTransform(
    input: &crate::operation::scan_output_transform::ScanOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanOutputTransformInput_DoriginalInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "original_input",
                "original_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HScanInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanOutputTransformInput_DsdkOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_output",
                "sdk_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HScanOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanOutputTransformOutput(
    input: &crate::types::ScanOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanOutputTransformOutput_for_DynamoDbEncryptionTransforms_ScanOutputTransform(
    input: &crate::operation::scan_output_transform::ScanOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HScanOutputTransformOutput_DtransformedOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::scan::ScanOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_output",
                "transformed_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HScanOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HStringMap(
    input: &::std::collections::HashMap<::std::string::String, ::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HStringMap_Dkey(
            inner_key,
        )?;
        validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HStringMap_Dvalue(
            inner_val,
        )?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HStringMap_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HStringMap_Dvalue(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsInputTransformInput(
    input: &crate::types::TransactGetItemsInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsInputTransformInput_for_DynamoDbEncryptionTransforms_TransactGetItemsInputTransform(
    input: &crate::operation::transact_get_items_input_transform::TransactGetItemsInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsInputTransformInput_DsdkInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_input",
                "sdk_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsInputTransformOutput(
    input: &crate::types::TransactGetItemsInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsInputTransformOutput_for_DynamoDbEncryptionTransforms_TransactGetItemsInputTransform(
    input: &crate::operation::transact_get_items_input_transform::TransactGetItemsInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsInputTransformOutput_DtransformedInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_input",
                "transformed_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsOutputTransformInput(
    input: &crate::types::TransactGetItemsOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsOutputTransformInput_for_DynamoDbEncryptionTransforms_TransactGetItemsOutputTransform(
    input: &crate::operation::transact_get_items_output_transform::TransactGetItemsOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsOutputTransformInput_DoriginalInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "original_input",
                "original_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsOutputTransformInput_DsdkOutput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_output",
                "sdk_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsOutputTransformOutput(
    input: &crate::types::TransactGetItemsOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsOutputTransformOutput_for_DynamoDbEncryptionTransforms_TransactGetItemsOutputTransform(
    input: &crate::operation::transact_get_items_output_transform::TransactGetItemsOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactGetItemsOutputTransformOutput_DtransformedOutput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_output",
                "transformed_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsInputTransformInput(
    input: &crate::types::TransactWriteItemsInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsInputTransformInput_for_DynamoDbEncryptionTransforms_TransactWriteItemsInputTransform(
    input: &crate::operation::transact_write_items_input_transform::TransactWriteItemsInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsInputTransformInput_DsdkInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_input",
                "sdk_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsInputTransformOutput(
    input: &crate::types::TransactWriteItemsInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsInputTransformOutput_for_DynamoDbEncryptionTransforms_TransactWriteItemsInputTransform(
    input: &crate::operation::transact_write_items_input_transform::TransactWriteItemsInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsInputTransformOutput_DtransformedInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_input",
                "transformed_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformInput(
    input: &crate::types::TransactWriteItemsOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformInput_for_DynamoDbEncryptionTransforms_TransactWriteItemsOutputTransform(
    input: &crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformInput_DoriginalInput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "original_input",
                "original_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformInput_DsdkOutput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_output",
                "sdk_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformOutput(
    input: &crate::types::TransactWriteItemsOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformOutput_for_DynamoDbEncryptionTransforms_TransactWriteItemsOutputTransform(
    input: &crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HTransactWriteItemsOutputTransformOutput_DtransformedOutput(
    input: &::std::option::Option<
        aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_output",
                "transformed_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemInputTransformInput(
    input: &crate::types::UpdateItemInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemInputTransformInput_for_DynamoDbEncryptionTransforms_UpdateItemInputTransform(
    input: &crate::operation::update_item_input_transform::UpdateItemInputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemInputTransformInput_DsdkInput(&input.r#sdk_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemInputTransformInput_DsdkInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_input",
                "sdk_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemInputTransformOutput(
    input: &crate::types::UpdateItemInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemInputTransformOutput_for_DynamoDbEncryptionTransforms_UpdateItemInputTransform(
    input: &crate::operation::update_item_input_transform::UpdateItemInputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemInputTransformOutput_DtransformedInput(&input.r#transformed_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemInputTransformOutput_DtransformedInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_input",
                "transformed_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemOutputTransformInput(
    input: &crate::types::UpdateItemOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemOutputTransformInput_for_DynamoDbEncryptionTransforms_UpdateItemOutputTransform(
    input: &crate::operation::update_item_output_transform::UpdateItemOutputTransformInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemOutputTransformInput_DsdkOutput(&input.r#sdk_output)?;
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemOutputTransformInput_DoriginalInput(&input.r#original_input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemOutputTransformInput_DoriginalInput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "original_input",
                "original_input is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemOutputTransformInput_DsdkOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sdk_output",
                "sdk_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HUpdateItemOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemOutputTransformOutput(
    input: &crate::types::UpdateItemOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemOutputTransformOutput_for_DynamoDbEncryptionTransforms_UpdateItemOutputTransform(
    input: &crate::operation::update_item_output_transform::UpdateItemOutputTransformOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemOutputTransformOutput_DtransformedOutput(&input.r#transformed_output)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_Ptransforms_HUpdateItemOutputTransformOutput_DtransformedOutput(
    input: &::std::option::Option<aws_sdk_dynamodb::operation::update_item::UpdateItemOutput>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transformed_output",
                "transformed_output is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HUpdateItemOutput(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HCacheType(
    input: &crate::deps::aws_cryptography_materialProviders::types::CacheType,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if let crate::deps::aws_cryptography_materialProviders::types::CacheType::Default(ref inner) =
        &input
    {
        validate_aws_Pcryptography_PmaterialProviders_HCacheType_DDefault(inner)?;
    }
    if let crate::deps::aws_cryptography_materialProviders::types::CacheType::No(ref inner) = &input
    {
        validate_aws_Pcryptography_PmaterialProviders_HCacheType_DNo(inner)?;
    }
    if let crate::deps::aws_cryptography_materialProviders::types::CacheType::SingleThreaded(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PmaterialProviders_HCacheType_DSingleThreaded(inner)?;
    }
    if let crate::deps::aws_cryptography_materialProviders::types::CacheType::MultiThreaded(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PmaterialProviders_HCacheType_DMultiThreaded(inner)?;
    }
    if let crate::deps::aws_cryptography_materialProviders::types::CacheType::StormTracking(
        ref inner,
    ) = &input
    {
        validate_aws_Pcryptography_PmaterialProviders_HCacheType_DStormTracking(inner)?;
    }
    if let crate::deps::aws_cryptography_materialProviders::types::CacheType::Shared(ref inner) =
        &input
    {
        validate_aws_Pcryptography_PmaterialProviders_HCacheType_DShared(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HCacheType_DDefault(
    input: &crate::deps::aws_cryptography_materialProviders::types::DefaultCache,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PmaterialProviders_HDefaultCache(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HCacheType_DMultiThreaded(
    input: &crate::deps::aws_cryptography_materialProviders::types::MultiThreadedCache,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PmaterialProviders_HMultiThreadedCache(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HCacheType_DNo(
    input: &crate::deps::aws_cryptography_materialProviders::types::NoCache,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PmaterialProviders_HNoCache(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HCacheType_DShared(
    input: &crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_cache::CryptographicMaterialsCacheRef,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PmaterialProviders_HCryptographicMaterialsCacheReference(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HCacheType_DSingleThreaded(
    input: &crate::deps::aws_cryptography_materialProviders::types::SingleThreadedCache,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PmaterialProviders_HSingleThreadedCache(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HCacheType_DStormTracking(
    input: &crate::deps::aws_cryptography_materialProviders::types::StormTrackingCache,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache(input)?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HCryptographicMaterialsCacheReference(
    input: &crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_cache::CryptographicMaterialsCacheRef,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HCryptographicMaterialsManagerReference(
    input: &crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HDefaultCache(
    input: &crate::deps::aws_cryptography_materialProviders::types::DefaultCache,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PmaterialProviders_HDefaultCache_DentryCapacity(
        &input.r#entry_capacity,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HDefaultCache_DentryCapacity(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "entry_capacity",
                "entry_capacity is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "entry_capacity",
        "entry_capacity failed to satisfy constraint: Member must be greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HKeyringReference(
    input: &crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HMultiThreadedCache(
    input: &crate::deps::aws_cryptography_materialProviders::types::MultiThreadedCache,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PmaterialProviders_HMultiThreadedCache_DentryCapacity(
        &input.r#entry_capacity,
    )?;
    validate_aws_Pcryptography_PmaterialProviders_HMultiThreadedCache_DentryPruningTailSize(
        &input.r#entry_pruning_tail_size,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HMultiThreadedCache_DentryCapacity(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "entry_capacity",
                "entry_capacity is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "entry_capacity",
        "entry_capacity failed to satisfy constraint: Member must be greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HMultiThreadedCache_DentryPruningTailSize(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "entry_pruning_tail_size",
        "entry_pruning_tail_size failed to satisfy constraint: Member must be greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HNoCache(
    input: &crate::deps::aws_cryptography_materialProviders::types::NoCache,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HSingleThreadedCache(
    input: &crate::deps::aws_cryptography_materialProviders::types::SingleThreadedCache,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PmaterialProviders_HSingleThreadedCache_DentryCapacity(
        &input.r#entry_capacity,
    )?;
    validate_aws_Pcryptography_PmaterialProviders_HSingleThreadedCache_DentryPruningTailSize(
        &input.r#entry_pruning_tail_size,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HSingleThreadedCache_DentryCapacity(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "entry_capacity",
                "entry_capacity is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "entry_capacity",
        "entry_capacity failed to satisfy constraint: Member must be greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HSingleThreadedCache_DentryPruningTailSize(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "entry_pruning_tail_size",
        "entry_pruning_tail_size failed to satisfy constraint: Member must be greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache(
    input: &crate::deps::aws_cryptography_materialProviders::types::StormTrackingCache,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DentryCapacity(
        &input.r#entry_capacity,
    )?;
    validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DentryPruningTailSize(
        &input.r#entry_pruning_tail_size,
    )?;
    validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DgracePeriod(
        &input.r#grace_period,
    )?;
    validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DgraceInterval(
        &input.r#grace_interval,
    )?;
    validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DfanOut(&input.r#fan_out)?;
    validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DinFlightTTL(
        &input.r#in_flight_ttl,
    )?;
    validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DsleepMilli(
        &input.r#sleep_milli,
    )?;
    validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DtimeUnits(
        &input.r#time_units,
    )?;
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DentryCapacity(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "entry_capacity",
                "entry_capacity is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "entry_capacity",
        "entry_capacity failed to satisfy constraint: Member must be greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DentryPruningTailSize(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "entry_pruning_tail_size",
        "entry_pruning_tail_size failed to satisfy constraint: Member must be greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DfanOut(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "fan_out",
                "fan_out is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::invalid_field(
                "fan_out",
                "fan_out failed to satisfy constraint: Member must be greater than or equal to 1",
            ),
        );
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DgraceInterval(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "grace_interval",
                "grace_interval is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "grace_interval",
        "grace_interval failed to satisfy constraint: Member must be greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DgracePeriod(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "grace_period",
                "grace_period is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "grace_period",
        "grace_period failed to satisfy constraint: Member must be greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DinFlightTTL(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "in_flight_ttl",
                "in_flight_ttl is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "in_flight_ttl",
        "in_flight_ttl failed to satisfy constraint: Member must be greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DsleepMilli(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "sleep_milli",
                "sleep_milli is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "sleep_milli",
        "sleep_milli failed to satisfy constraint: Member must be greater than or equal to 1",
    ));
    }
    Ok(())
}
pub(crate) fn validate_aws_Pcryptography_PmaterialProviders_HStormTrackingCache_DtimeUnits(
    input: &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::TimeUnits,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

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
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeUpdates(
    input: &::std::collections::HashMap<
        ::std::string::String,
        aws_sdk_dynamodb::types::AttributeValueUpdate,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HAttributeUpdates_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HAttributeUpdates_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeUpdates_Dkey(
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
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeUpdates_Dvalue(
    input: &aws_sdk_dynamodb::types::AttributeValueUpdate,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HAttributeValueUpdate(input)?;
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
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValueList(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::AttributeValue>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HAttributeValueList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValueList_Dmember(
    input: &aws_sdk_dynamodb::types::AttributeValue,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValueUpdate(
    input: &aws_sdk_dynamodb::types::AttributeValueUpdate,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HAttributeValueUpdate_DValue(&input.r#value)?;
    validate_com_Pamazonaws_Pdynamodb_HAttributeValueUpdate_DAction(&input.r#action)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValueUpdate_DAction(
    input: &::std::option::Option<aws_sdk_dynamodb::types::AttributeAction>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HAttributeValueUpdate_DValue(
    input: &::std::option::Option<aws_sdk_dynamodb::types::AttributeValue>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementInput(
    input: &aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementInput_DStatements(&input.r#statements)?;
    validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementInput_for_DynamoDB__20120810_BatchExecuteStatement(
    input: &aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementInput_DStatements(&input.r#statements)?;
    validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementInput_DReturnConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementInput_DStatements(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::BatchStatementRequest>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "statements",
                "statements is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=25).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "statements",
        "statements failed to satisfy constraint: Member must have length between 1 and 25, inclusive",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HPartiQLBatchRequest(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementOutput(
    input: &aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementOutput_for_DynamoDB__20120810_BatchExecuteStatement(
    input: &aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementOutput_DConsumedCapacity(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::ConsumedCapacity>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacityMultiple(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchExecuteStatementOutput_DResponses(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::BatchStatementResponse>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HPartiQLBatchResponse(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetItemInput(
    input: &aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HBatchGetItemInput_DRequestItems(&input.r#request_items)?;
    validate_com_Pamazonaws_Pdynamodb_HBatchGetItemInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetItemInput_for_DynamoDB__20120810_BatchGetItem(
    input: &aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HBatchGetItemInput_DRequestItems(&input.r#request_items)?;
    validate_com_Pamazonaws_Pdynamodb_HBatchGetItemInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetItemInput_DRequestItems(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            aws_sdk_dynamodb::types::KeysAndAttributes,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "request_items",
                "request_items is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=100).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "request_items",
        "request_items failed to satisfy constraint: Member must have length between 1 and 100, inclusive",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HBatchGetRequestMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetItemInput_DReturnConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetItemOutput(
    input: &aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetItemOutput_for_DynamoDB__20120810_BatchGetItem(
    input: &aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetItemOutput_DConsumedCapacity(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::ConsumedCapacity>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacityMultiple(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetItemOutput_DResponses(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            ::std::vec::Vec<
                ::std::collections::HashMap<
                    ::std::string::String,
                    aws_sdk_dynamodb::types::AttributeValue,
                >,
            >,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchGetResponseMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetItemOutput_DUnprocessedKeys(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            aws_sdk_dynamodb::types::KeysAndAttributes,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=100).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "unprocessed_keys",
        "unprocessed_keys failed to satisfy constraint: Member must have length between 1 and 100, inclusive",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HBatchGetRequestMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetRequestMap(
    input: &::std::collections::HashMap<
        ::std::string::String,
        aws_sdk_dynamodb::types::KeysAndAttributes,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HBatchGetRequestMap_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HBatchGetRequestMap_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetRequestMap_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "key",
        "key failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetRequestMap_Dvalue(
    input: &aws_sdk_dynamodb::types::KeysAndAttributes,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HKeysAndAttributes(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetResponseMap(
    input: &::std::collections::HashMap<
        ::std::string::String,
        ::std::vec::Vec<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HBatchGetResponseMap_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HBatchGetResponseMap_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetResponseMap_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "key",
        "key failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchGetResponseMap_Dvalue(
    input: &::std::vec::Vec<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HItemList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchStatementError(
    input: &aws_sdk_dynamodb::types::BatchStatementError,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HBatchStatementError_DCode(&input.r#code)?;
    validate_com_Pamazonaws_Pdynamodb_HBatchStatementError_DMessage(&input.r#message)?;
    validate_com_Pamazonaws_Pdynamodb_HBatchStatementError_DItem(&input.r#item)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchStatementError_DCode(
    input: &::std::option::Option<aws_sdk_dynamodb::types::BatchStatementErrorCodeEnum>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchStatementError_DItem(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchStatementError_DMessage(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchStatementRequest(
    input: &aws_sdk_dynamodb::types::BatchStatementRequest,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HBatchStatementRequest_DStatement(&Some(
        input.r#statement.clone(),
    ))?;
    validate_com_Pamazonaws_Pdynamodb_HBatchStatementRequest_DParameters(&input.r#parameters)?;
    validate_com_Pamazonaws_Pdynamodb_HBatchStatementRequest_DConsistentRead(
        &input.r#consistent_read,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HBatchStatementRequest_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchStatementRequest_DConsistentRead(
    input: &::std::option::Option<::std::primitive::bool>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchStatementRequest_DParameters(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::AttributeValue>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "parameters",
        "parameters failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HPreparedStatementParameters(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchStatementRequest_DReturnValuesOnConditionCheckFailure(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnValuesOnConditionCheckFailure>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchStatementRequest_DStatement(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "statement",
                "statement is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=8192).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "statement",
        "statement failed to satisfy constraint: Member must have length between 1 and 8192, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchStatementResponse(
    input: &aws_sdk_dynamodb::types::BatchStatementResponse,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HBatchStatementResponse_DError(&input.r#error)?;
    validate_com_Pamazonaws_Pdynamodb_HBatchStatementResponse_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HBatchStatementResponse_DItem(&input.r#item)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchStatementResponse_DError(
    input: &::std::option::Option<aws_sdk_dynamodb::types::BatchStatementError>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HBatchStatementError(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchStatementResponse_DItem(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchStatementResponse_DTableName(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(3..=255).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 3 and 255, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput(
    input: &aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput_DRequestItems(&input.r#request_items)?;
    validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput_DReturnItemCollectionMetrics(
        &input.r#return_item_collection_metrics,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput_for_DynamoDB__20120810_BatchWriteItem(
    input: &aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput_DRequestItems(&input.r#request_items)?;
    validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput_DReturnItemCollectionMetrics(
        &input.r#return_item_collection_metrics,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput_DRequestItems(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            ::std::vec::Vec<aws_sdk_dynamodb::types::WriteRequest>,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "request_items",
                "request_items is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=25).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "request_items",
        "request_items failed to satisfy constraint: Member must have length between 1 and 25, inclusive",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemRequestMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput_DReturnConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemInput_DReturnItemCollectionMetrics(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnItemCollectionMetrics>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemOutput(
    input: &aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemOutput_for_DynamoDB__20120810_BatchWriteItem(
    input: &aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemOutput_DConsumedCapacity(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::ConsumedCapacity>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacityMultiple(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemOutput_DItemCollectionMetrics(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            ::std::vec::Vec<aws_sdk_dynamodb::types::ItemCollectionMetrics>,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetricsPerTable(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemOutput_DUnprocessedItems(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            ::std::vec::Vec<aws_sdk_dynamodb::types::WriteRequest>,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=25).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "unprocessed_items",
        "unprocessed_items failed to satisfy constraint: Member must have length between 1 and 25, inclusive",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemRequestMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemRequestMap(
    input: &::std::collections::HashMap<
        ::std::string::String,
        ::std::vec::Vec<aws_sdk_dynamodb::types::WriteRequest>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemRequestMap_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemRequestMap_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemRequestMap_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "key",
        "key failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HBatchWriteItemRequestMap_Dvalue(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::WriteRequest>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if !(1..=25).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "value",
        "value failed to satisfy constraint: Member must have length between 1 and 25, inclusive",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HWriteRequests(input)?;
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
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HCapacity(
    input: &aws_sdk_dynamodb::types::Capacity,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HCapacity_DReadCapacityUnits(&input.r#read_capacity_units)?;
    validate_com_Pamazonaws_Pdynamodb_HCapacity_DWriteCapacityUnits(&input.r#write_capacity_units)?;
    validate_com_Pamazonaws_Pdynamodb_HCapacity_DCapacityUnits(&input.r#capacity_units)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HCapacity_DCapacityUnits(
    input: &::std::option::Option<::std::primitive::f64>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HCapacity_DReadCapacityUnits(
    input: &::std::option::Option<::std::primitive::f64>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HCapacity_DWriteCapacityUnits(
    input: &::std::option::Option<::std::primitive::f64>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HCondition(
    input: &aws_sdk_dynamodb::types::Condition,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HCondition_DAttributeValueList(
        &input.r#attribute_value_list,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HCondition_DComparisonOperator(&Some(
        input.r#comparison_operator.clone(),
    ))?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HCondition_DAttributeValueList(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::AttributeValue>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeValueList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HCondition_DComparisonOperator(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ComparisonOperator>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "comparison_operator",
                "comparison_operator is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConditionCheck(
    input: &aws_sdk_dynamodb::types::ConditionCheck,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HConditionCheck_DKey(&Some(input.r#key.clone()))?;
    validate_com_Pamazonaws_Pdynamodb_HConditionCheck_DTableName(&Some(
        input.r#table_name.clone(),
    ))?;
    validate_com_Pamazonaws_Pdynamodb_HConditionCheck_DConditionExpression(&Some(
        input.r#condition_expression.clone(),
    ))?;
    validate_com_Pamazonaws_Pdynamodb_HConditionCheck_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HConditionCheck_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HConditionCheck_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConditionCheck_DConditionExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "condition_expression",
                "condition_expression is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConditionCheck_DExpressionAttributeNames(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConditionCheck_DExpressionAttributeValues(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConditionCheck_DKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
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

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConditionCheck_DReturnValuesOnConditionCheckFailure(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnValuesOnConditionCheckFailure>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConditionCheck_DTableName(
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

    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity(
    input: &aws_sdk_dynamodb::types::ConsumedCapacity,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DCapacityUnits(&input.r#capacity_units)?;
    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DReadCapacityUnits(
        &input.r#read_capacity_units,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DWriteCapacityUnits(
        &input.r#write_capacity_units,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DTable(&input.r#table)?;
    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DLocalSecondaryIndexes(
        &input.r#local_secondary_indexes,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DGlobalSecondaryIndexes(
        &input.r#global_secondary_indexes,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DCapacityUnits(
    input: &::std::option::Option<::std::primitive::f64>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DGlobalSecondaryIndexes(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::Capacity>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HSecondaryIndexesCapacityMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DLocalSecondaryIndexes(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::Capacity>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HSecondaryIndexesCapacityMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DReadCapacityUnits(
    input: &::std::option::Option<::std::primitive::f64>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DTable(
    input: &::std::option::Option<aws_sdk_dynamodb::types::Capacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HCapacity(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DTableName(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity_DWriteCapacityUnits(
    input: &::std::option::Option<::std::primitive::f64>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConsumedCapacityMultiple(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::ConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HConsumedCapacityMultiple_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HConsumedCapacityMultiple_Dmember(
    input: &aws_sdk_dynamodb::types::ConsumedCapacity,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDelete(
    input: &aws_sdk_dynamodb::types::Delete,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HDelete_DKey(&Some(input.r#key.clone()))?;
    validate_com_Pamazonaws_Pdynamodb_HDelete_DTableName(&Some(input.r#table_name.clone()))?;
    validate_com_Pamazonaws_Pdynamodb_HDelete_DConditionExpression(&input.r#condition_expression)?;
    validate_com_Pamazonaws_Pdynamodb_HDelete_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDelete_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDelete_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDelete_DConditionExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDelete_DExpressionAttributeNames(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDelete_DExpressionAttributeValues(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDelete_DKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
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

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDelete_DReturnValuesOnConditionCheckFailure(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnValuesOnConditionCheckFailure>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDelete_DTableName(
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

    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput(
    input: &aws_sdk_dynamodb::operation::delete_item::DeleteItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DKey(&input.r#key)?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DExpected(&input.r#expected)?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DConditionalOperator(
        &input.r#conditional_operator,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DReturnValues(&input.r#return_values)?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DReturnItemCollectionMetrics(
        &input.r#return_item_collection_metrics,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DConditionExpression(
        &input.r#condition_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_for_DynamoDB__20120810_DeleteItem(
    input: &aws_sdk_dynamodb::operation::delete_item::DeleteItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DKey(&input.r#key)?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DExpected(&input.r#expected)?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DConditionalOperator(
        &input.r#conditional_operator,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DReturnValues(&input.r#return_values)?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DReturnItemCollectionMetrics(
        &input.r#return_item_collection_metrics,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DConditionExpression(
        &input.r#condition_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DConditionalOperator(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ConditionalOperator>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DConditionExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DExpected(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            aws_sdk_dynamodb::types::ExpectedAttributeValue,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DExpressionAttributeNames(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DExpressionAttributeValues(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
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

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DReturnConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DReturnItemCollectionMetrics(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnItemCollectionMetrics>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DReturnValues(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnValue>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DReturnValuesOnConditionCheckFailure(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnValuesOnConditionCheckFailure>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemInput_DTableName(
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

    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemOutput(
    input: &aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemOutput_for_DynamoDB__20120810_DeleteItem(
    input: &aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemOutput_DAttributes(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemOutput_DConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteItemOutput_DItemCollectionMetrics(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ItemCollectionMetrics>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetrics(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteRequest(
    input: &aws_sdk_dynamodb::types::DeleteRequest,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HDeleteRequest_DKey(&Some(input.r#key.clone()))?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HDeleteRequest_DKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
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

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput(
    input: &aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DStatement(&input.r#statement)?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DParameters(&input.r#parameters)?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DConsistentRead(
        &input.r#consistent_read,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DNextToken(&input.r#next_token)?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DLimit(&input.r#limit)?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_for_DynamoDB__20120810_ExecuteStatement(
    input: &aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DStatement(&input.r#statement)?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DParameters(&input.r#parameters)?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DConsistentRead(
        &input.r#consistent_read,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DNextToken(&input.r#next_token)?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DLimit(&input.r#limit)?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DConsistentRead(
    input: &::std::option::Option<::std::primitive::bool>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DLimit(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::invalid_field(
                "limit",
                "limit failed to satisfy constraint: Member must be greater than or equal to 1",
            ),
        );
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DNextToken(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=32768).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "next_token",
        "next_token failed to satisfy constraint: Member must have length between 1 and 32768, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DParameters(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::AttributeValue>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "parameters",
        "parameters failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HPreparedStatementParameters(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DReturnConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DReturnValuesOnConditionCheckFailure(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnValuesOnConditionCheckFailure>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementInput_DStatement(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "statement",
                "statement is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=8192).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "statement",
        "statement failed to satisfy constraint: Member must have length between 1 and 8192, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementOutput(
    input: &aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementOutput_for_DynamoDB__20120810_ExecuteStatement(
    input: &aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementOutput_DConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementOutput_DItems(
    input: &::std::option::Option<
        ::std::vec::Vec<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HItemList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementOutput_DLastEvaluatedKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteStatementOutput_DNextToken(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=32768).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "next_token",
        "next_token failed to satisfy constraint: Member must have length between 1 and 32768, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput(
    input: &aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput_DTransactStatements(
        &input.r#transact_statements,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput_DClientRequestToken(
        &input.r#client_request_token,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput_for_DynamoDB__20120810_ExecuteTransaction(
    input: &aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput_DTransactStatements(
        &input.r#transact_statements,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput_DClientRequestToken(
        &input.r#client_request_token,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput_DClientRequestToken(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=36).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "client_request_token",
        "client_request_token failed to satisfy constraint: Member must have length between 1 and 36, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput_DReturnConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionInput_DTransactStatements(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::ParameterizedStatement>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transact_statements",
                "transact_statements is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=100).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "transact_statements",
        "transact_statements failed to satisfy constraint: Member must have length between 1 and 100, inclusive",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HParameterizedStatements(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionOutput(
    input: &aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionOutput_for_DynamoDB__20120810_ExecuteTransaction(
    input: &aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionOutput_DConsumedCapacity(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::ConsumedCapacity>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacityMultiple(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExecuteTransactionOutput_DResponses(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::ItemResponse>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=100).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "responses",
        "responses failed to satisfy constraint: Member must have length between 1 and 100, inclusive",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HItemResponseList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeMap(
    input: &::std::collections::HashMap<
        ::std::string::String,
        aws_sdk_dynamodb::types::ExpectedAttributeValue,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeMap_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeMap_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeMap_Dkey(
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
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeMap_Dvalue(
    input: &aws_sdk_dynamodb::types::ExpectedAttributeValue,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeValue(
    input: &aws_sdk_dynamodb::types::ExpectedAttributeValue,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeValue_DValue(&input.r#value)?;
    validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeValue_DExists(&input.r#exists)?;
    validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeValue_DComparisonOperator(
        &input.r#comparison_operator,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeValue_DAttributeValueList(
        &input.r#attribute_value_list,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeValue_DAttributeValueList(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::AttributeValue>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeValueList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeValue_DComparisonOperator(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ComparisonOperator>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeValue_DExists(
    input: &::std::option::Option<::std::primitive::bool>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeValue_DValue(
    input: &::std::option::Option<aws_sdk_dynamodb::types::AttributeValue>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap(
    input: &::std::collections::HashMap<::std::string::String, ::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap_Dvalue(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if !(0..=65535).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "value",
        "value failed to satisfy constraint: Member must have length between 0 and 65535, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap(
    input: &::std::collections::HashMap<
        ::std::string::String,
        aws_sdk_dynamodb::types::AttributeValue,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap_Dvalue(
    input: &aws_sdk_dynamodb::types::AttributeValue,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HFilterConditionMap(
    input: &::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::Condition>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HFilterConditionMap_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HFilterConditionMap_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HFilterConditionMap_Dkey(
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
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HFilterConditionMap_Dvalue(
    input: &aws_sdk_dynamodb::types::Condition,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HCondition(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGet(
    input: &aws_sdk_dynamodb::types::Get,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HGet_DKey(&Some(input.r#key.clone()))?;
    validate_com_Pamazonaws_Pdynamodb_HGet_DTableName(&Some(input.r#table_name.clone()))?;
    validate_com_Pamazonaws_Pdynamodb_HGet_DProjectionExpression(&input.r#projection_expression)?;
    validate_com_Pamazonaws_Pdynamodb_HGet_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGet_DExpressionAttributeNames(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGet_DKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
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

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGet_DProjectionExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGet_DTableName(
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

    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGetItemInput(
    input: &aws_sdk_dynamodb::operation::get_item::GetItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DKey(&input.r#key)?;
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DAttributesToGet(&input.r#attributes_to_get)?;
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DConsistentRead(&input.r#consistent_read)?;
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DProjectionExpression(
        &input.r#projection_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGetItemInput_for_DynamoDB__20120810_GetItem(
    input: &aws_sdk_dynamodb::operation::get_item::GetItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DKey(&input.r#key)?;
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DAttributesToGet(&input.r#attributes_to_get)?;
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DConsistentRead(&input.r#consistent_read)?;
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DProjectionExpression(
        &input.r#projection_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DAttributesToGet(
    input: &::std::option::Option<::std::vec::Vec<::std::string::String>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "attributes_to_get",
        "attributes_to_get failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HAttributeNameList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DConsistentRead(
    input: &::std::option::Option<::std::primitive::bool>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DExpressionAttributeNames(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
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

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DProjectionExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DReturnConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGetItemInput_DTableName(
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

    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGetItemOutput(
    input: &aws_sdk_dynamodb::operation::get_item::GetItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGetItemOutput_for_DynamoDB__20120810_GetItem(
    input: &aws_sdk_dynamodb::operation::get_item::GetItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGetItemOutput_DConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HGetItemOutput_DItem(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemCollectionKeyAttributeMap(
    input: &::std::collections::HashMap<
        ::std::string::String,
        aws_sdk_dynamodb::types::AttributeValue,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HItemCollectionKeyAttributeMap_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HItemCollectionKeyAttributeMap_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemCollectionKeyAttributeMap_Dkey(
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
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemCollectionKeyAttributeMap_Dvalue(
    input: &aws_sdk_dynamodb::types::AttributeValue,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetrics(
    input: &aws_sdk_dynamodb::types::ItemCollectionMetrics,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetrics_DItemCollectionKey(
        &input.r#item_collection_key,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetrics_DSizeEstimateRangeGB(
        &input.r#size_estimate_range_gb,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetrics_DItemCollectionKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HItemCollectionKeyAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetrics_DSizeEstimateRangeGB(
    input: &::std::option::Option<::std::vec::Vec<::std::primitive::f64>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HItemCollectionSizeEstimateRange(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetricsMultiple(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::ItemCollectionMetrics>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetricsMultiple_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetricsMultiple_Dmember(
    input: &aws_sdk_dynamodb::types::ItemCollectionMetrics,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetrics(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetricsPerTable(
    input: &::std::collections::HashMap<
        ::std::string::String,
        ::std::vec::Vec<aws_sdk_dynamodb::types::ItemCollectionMetrics>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetricsPerTable_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetricsPerTable_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetricsPerTable_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "key",
        "key failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetricsPerTable_Dvalue(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::ItemCollectionMetrics>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetricsMultiple(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemCollectionSizeEstimateRange(
    input: &::std::vec::Vec<::std::primitive::f64>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HItemCollectionSizeEstimateRange_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemCollectionSizeEstimateRange_Dmember(
    input: &::std::primitive::f64,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemList(
    input: &::std::vec::Vec<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HItemList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemList_Dmember(
    input: &::std::collections::HashMap<
        ::std::string::String,
        aws_sdk_dynamodb::types::AttributeValue,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemResponse(
    input: &aws_sdk_dynamodb::types::ItemResponse,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HItemResponse_DItem(&input.r#item)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemResponse_DItem(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemResponseList(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::ItemResponse>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HItemResponseList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HItemResponseList_Dmember(
    input: &aws_sdk_dynamodb::types::ItemResponse,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HItemResponse(input)?;
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
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKeyConditions(
    input: &::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::Condition>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HKeyConditions_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HKeyConditions_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKeyConditions_Dkey(
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
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKeyConditions_Dvalue(
    input: &aws_sdk_dynamodb::types::Condition,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HCondition(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKeyList(
    input: &::std::vec::Vec<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HKeyList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKeyList_Dmember(
    input: &::std::collections::HashMap<
        ::std::string::String,
        aws_sdk_dynamodb::types::AttributeValue,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKeysAndAttributes(
    input: &aws_sdk_dynamodb::types::KeysAndAttributes,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HKeysAndAttributes_DKeys(&Some(input.r#keys.clone()))?;
    validate_com_Pamazonaws_Pdynamodb_HKeysAndAttributes_DAttributesToGet(
        &input.r#attributes_to_get,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HKeysAndAttributes_DConsistentRead(&input.r#consistent_read)?;
    validate_com_Pamazonaws_Pdynamodb_HKeysAndAttributes_DProjectionExpression(
        &input.r#projection_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HKeysAndAttributes_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKeysAndAttributes_DAttributesToGet(
    input: &::std::option::Option<::std::vec::Vec<::std::string::String>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "attributes_to_get",
        "attributes_to_get failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HAttributeNameList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKeysAndAttributes_DConsistentRead(
    input: &::std::option::Option<::std::primitive::bool>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKeysAndAttributes_DExpressionAttributeNames(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKeysAndAttributes_DKeys(
    input: &::std::option::Option<
        ::std::vec::Vec<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "keys",
                "keys is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=100).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "keys",
        "keys failed to satisfy constraint: Member must have length between 1 and 100, inclusive",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HKeyList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HKeysAndAttributes_DProjectionExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

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
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HParameterizedStatement(
    input: &aws_sdk_dynamodb::types::ParameterizedStatement,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HParameterizedStatement_DStatement(&Some(
        input.r#statement.clone(),
    ))?;
    validate_com_Pamazonaws_Pdynamodb_HParameterizedStatement_DParameters(&input.r#parameters)?;
    validate_com_Pamazonaws_Pdynamodb_HParameterizedStatement_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HParameterizedStatement_DParameters(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::AttributeValue>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "parameters",
        "parameters failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HPreparedStatementParameters(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HParameterizedStatement_DReturnValuesOnConditionCheckFailure(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnValuesOnConditionCheckFailure>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HParameterizedStatement_DStatement(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "statement",
                "statement is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=8192).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "statement",
        "statement failed to satisfy constraint: Member must have length between 1 and 8192, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HParameterizedStatements(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::ParameterizedStatement>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HParameterizedStatements_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HParameterizedStatements_Dmember(
    input: &aws_sdk_dynamodb::types::ParameterizedStatement,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HParameterizedStatement(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPartiQLBatchRequest(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::BatchStatementRequest>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HPartiQLBatchRequest_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPartiQLBatchRequest_Dmember(
    input: &aws_sdk_dynamodb::types::BatchStatementRequest,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HBatchStatementRequest(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPartiQLBatchResponse(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::BatchStatementResponse>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HPartiQLBatchResponse_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPartiQLBatchResponse_Dmember(
    input: &aws_sdk_dynamodb::types::BatchStatementResponse,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HBatchStatementResponse(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPreparedStatementParameters(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::AttributeValue>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HPreparedStatementParameters_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPreparedStatementParameters_Dmember(
    input: &aws_sdk_dynamodb::types::AttributeValue,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPut(
    input: &aws_sdk_dynamodb::types::Put,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HPut_DItem(&Some(input.r#item.clone()))?;
    validate_com_Pamazonaws_Pdynamodb_HPut_DTableName(&Some(input.r#table_name.clone()))?;
    validate_com_Pamazonaws_Pdynamodb_HPut_DConditionExpression(&input.r#condition_expression)?;
    validate_com_Pamazonaws_Pdynamodb_HPut_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPut_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPut_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPut_DConditionExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPut_DExpressionAttributeNames(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPut_DExpressionAttributeValues(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPut_DItem(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "item",
                "item is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HPutItemInputAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPut_DReturnValuesOnConditionCheckFailure(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnValuesOnConditionCheckFailure>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPut_DTableName(
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

    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInput(
    input: &aws_sdk_dynamodb::operation::put_item::PutItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DItem(&input.r#item)?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DExpected(&input.r#expected)?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DReturnValues(&input.r#return_values)?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DReturnItemCollectionMetrics(
        &input.r#return_item_collection_metrics,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DConditionalOperator(
        &input.r#conditional_operator,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DConditionExpression(
        &input.r#condition_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInput_for_DynamoDB__20120810_PutItem(
    input: &aws_sdk_dynamodb::operation::put_item::PutItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DItem(&input.r#item)?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DExpected(&input.r#expected)?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DReturnValues(&input.r#return_values)?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DReturnItemCollectionMetrics(
        &input.r#return_item_collection_metrics,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DConditionalOperator(
        &input.r#conditional_operator,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DConditionExpression(
        &input.r#condition_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DConditionalOperator(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ConditionalOperator>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DConditionExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DExpected(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            aws_sdk_dynamodb::types::ExpectedAttributeValue,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DExpressionAttributeNames(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DExpressionAttributeValues(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DItem(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "item",
                "item is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HPutItemInputAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DReturnConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DReturnItemCollectionMetrics(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnItemCollectionMetrics>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DReturnValues(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnValue>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DReturnValuesOnConditionCheckFailure(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnValuesOnConditionCheckFailure>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInput_DTableName(
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

    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInputAttributeMap(
    input: &::std::collections::HashMap<
        ::std::string::String,
        aws_sdk_dynamodb::types::AttributeValue,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HPutItemInputAttributeMap_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HPutItemInputAttributeMap_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInputAttributeMap_Dkey(
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
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemInputAttributeMap_Dvalue(
    input: &aws_sdk_dynamodb::types::AttributeValue,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HAttributeValue(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemOutput(
    input: &aws_sdk_dynamodb::operation::put_item::PutItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemOutput_for_DynamoDB__20120810_PutItem(
    input: &aws_sdk_dynamodb::operation::put_item::PutItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemOutput_DAttributes(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemOutput_DConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutItemOutput_DItemCollectionMetrics(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ItemCollectionMetrics>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetrics(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutRequest(
    input: &aws_sdk_dynamodb::types::PutRequest,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HPutRequest_DItem(&Some(input.r#item.clone()))?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HPutRequest_DItem(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "item",
                "item is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HPutItemInputAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput(
    input: &aws_sdk_dynamodb::operation::query::QueryInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DIndexName(&input.r#index_name)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DSelect(&input.r#select)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DAttributesToGet(&input.r#attributes_to_get)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DLimit(&input.r#limit)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DConsistentRead(&input.r#consistent_read)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DKeyConditions(&input.r#key_conditions)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DQueryFilter(&input.r#query_filter)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DConditionalOperator(
        &input.r#conditional_operator,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DScanIndexForward(&input.r#scan_index_forward)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DExclusiveStartKey(&input.r#exclusive_start_key)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DProjectionExpression(
        &input.r#projection_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DFilterExpression(&input.r#filter_expression)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DKeyConditionExpression(
        &input.r#key_condition_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_for_DynamoDB__20120810_Query(
    input: &aws_sdk_dynamodb::operation::query::QueryInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DIndexName(&input.r#index_name)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DSelect(&input.r#select)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DAttributesToGet(&input.r#attributes_to_get)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DLimit(&input.r#limit)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DConsistentRead(&input.r#consistent_read)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DKeyConditions(&input.r#key_conditions)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DQueryFilter(&input.r#query_filter)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DConditionalOperator(
        &input.r#conditional_operator,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DScanIndexForward(&input.r#scan_index_forward)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DExclusiveStartKey(&input.r#exclusive_start_key)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DProjectionExpression(
        &input.r#projection_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DFilterExpression(&input.r#filter_expression)?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DKeyConditionExpression(
        &input.r#key_condition_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HQueryInput_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DAttributesToGet(
    input: &::std::option::Option<::std::vec::Vec<::std::string::String>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "attributes_to_get",
        "attributes_to_get failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HAttributeNameList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DConditionalOperator(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ConditionalOperator>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DConsistentRead(
    input: &::std::option::Option<::std::primitive::bool>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DExclusiveStartKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DExpressionAttributeNames(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DExpressionAttributeValues(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DFilterExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DIndexName(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(3..=255).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "index_name",
        "index_name failed to satisfy constraint: Member must have length between 3 and 255, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DKeyConditionExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DKeyConditions(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::Condition>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HKeyConditions(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DLimit(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::invalid_field(
                "limit",
                "limit failed to satisfy constraint: Member must be greater than or equal to 1",
            ),
        );
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DProjectionExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DQueryFilter(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::Condition>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HFilterConditionMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DReturnConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DScanIndexForward(
    input: &::std::option::Option<::std::primitive::bool>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DSelect(
    input: &::std::option::Option<aws_sdk_dynamodb::types::Select>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryInput_DTableName(
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

    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryOutput(
    input: &aws_sdk_dynamodb::operation::query::QueryOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryOutput_for_DynamoDB__20120810_Query(
    input: &aws_sdk_dynamodb::operation::query::QueryOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryOutput_DConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryOutput_DCount(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryOutput_DItems(
    input: &::std::option::Option<
        ::std::vec::Vec<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HItemList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryOutput_DLastEvaluatedKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HQueryOutput_DScannedCount(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput(
    input: &aws_sdk_dynamodb::operation::scan::ScanInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DIndexName(&input.r#index_name)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DAttributesToGet(&input.r#attributes_to_get)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DLimit(&input.r#limit)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DSelect(&input.r#select)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DScanFilter(&input.r#scan_filter)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DConditionalOperator(
        &input.r#conditional_operator,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DExclusiveStartKey(&input.r#exclusive_start_key)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DTotalSegments(&input.r#total_segments)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DSegment(&input.r#segment)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DProjectionExpression(
        &input.r#projection_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DFilterExpression(&input.r#filter_expression)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DConsistentRead(&input.r#consistent_read)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_for_DynamoDB__20120810_Scan(
    input: &aws_sdk_dynamodb::operation::scan::ScanInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DIndexName(&input.r#index_name)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DAttributesToGet(&input.r#attributes_to_get)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DLimit(&input.r#limit)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DSelect(&input.r#select)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DScanFilter(&input.r#scan_filter)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DConditionalOperator(
        &input.r#conditional_operator,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DExclusiveStartKey(&input.r#exclusive_start_key)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DTotalSegments(&input.r#total_segments)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DSegment(&input.r#segment)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DProjectionExpression(
        &input.r#projection_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DFilterExpression(&input.r#filter_expression)?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HScanInput_DConsistentRead(&input.r#consistent_read)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DAttributesToGet(
    input: &::std::option::Option<::std::vec::Vec<::std::string::String>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "attributes_to_get",
        "attributes_to_get failed to satisfy constraint: Member must have length greater than or equal to 1",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HAttributeNameList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DConditionalOperator(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ConditionalOperator>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DConsistentRead(
    input: &::std::option::Option<::std::primitive::bool>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DExclusiveStartKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DExpressionAttributeNames(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DExpressionAttributeValues(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DFilterExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DIndexName(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(3..=255).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "index_name",
        "index_name failed to satisfy constraint: Member must have length between 3 and 255, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DLimit(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..).contains(input) {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::invalid_field(
                "limit",
                "limit failed to satisfy constraint: Member must be greater than or equal to 1",
            ),
        );
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DProjectionExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DReturnConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DScanFilter(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::Condition>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HFilterConditionMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DSegment(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(0..=999999).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "segment",
        "segment failed to satisfy constraint: Member must be between 0 and 999999, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DSelect(
    input: &::std::option::Option<aws_sdk_dynamodb::types::Select>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DTableName(
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

    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanInput_DTotalSegments(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=1000000).contains(input) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "total_segments",
        "total_segments failed to satisfy constraint: Member must be between 1 and 1000000, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanOutput(
    input: &aws_sdk_dynamodb::operation::scan::ScanOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanOutput_for_DynamoDB__20120810_Scan(
    input: &aws_sdk_dynamodb::operation::scan::ScanOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanOutput_DConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanOutput_DCount(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanOutput_DItems(
    input: &::std::option::Option<
        ::std::vec::Vec<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HItemList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanOutput_DLastEvaluatedKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HScanOutput_DScannedCount(
    input: &::std::option::Option<::std::primitive::i32>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HSecondaryIndexesCapacityMap(
    input: &::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::Capacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for (inner_key, inner_val) in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HSecondaryIndexesCapacityMap_Dkey(inner_key)?;
        validate_com_Pamazonaws_Pdynamodb_HSecondaryIndexesCapacityMap_Dvalue(inner_val)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HSecondaryIndexesCapacityMap_Dkey(
    input: &::std::string::String,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if !(3..=255).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "key",
        "key failed to satisfy constraint: Member must have length between 3 and 255, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HSecondaryIndexesCapacityMap_Dvalue(
    input: &aws_sdk_dynamodb::types::Capacity,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HCapacity(input)?;
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
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactGetItem(
    input: &aws_sdk_dynamodb::types::TransactGetItem,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HTransactGetItem_DGet(&input.r#get)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactGetItem_DGet(
    input: &::std::option::Option<aws_sdk_dynamodb::types::Get>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "get",
                "get is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HGet(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactGetItemList(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::TransactGetItem>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HTransactGetItemList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactGetItemList_Dmember(
    input: &aws_sdk_dynamodb::types::TransactGetItem,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HTransactGetItem(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsInput(
    input: &aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsInput_DTransactItems(
        &input.r#transact_items,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsInput_for_DynamoDB__20120810_TransactGetItems(
    input: &aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsInput_DTransactItems(
        &input.r#transact_items,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsInput_DReturnConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsInput_DTransactItems(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::TransactGetItem>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transact_items",
                "transact_items is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=100).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "transact_items",
        "transact_items failed to satisfy constraint: Member must have length between 1 and 100, inclusive",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HTransactGetItemList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsOutput(
    input: &aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsOutput_for_DynamoDB__20120810_TransactGetItems(
    input: &aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsOutput_DConsumedCapacity(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::ConsumedCapacity>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacityMultiple(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactGetItemsOutput_DResponses(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::ItemResponse>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=100).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "responses",
        "responses failed to satisfy constraint: Member must have length between 1 and 100, inclusive",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HItemResponseList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItem(
    input: &aws_sdk_dynamodb::types::TransactWriteItem,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItem_DConditionCheck(&input.r#condition_check)?;
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItem_DPut(&input.r#put)?;
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItem_DDelete(&input.r#delete)?;
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItem_DUpdate(&input.r#update)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItem_DConditionCheck(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ConditionCheck>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConditionCheck(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItem_DDelete(
    input: &::std::option::Option<aws_sdk_dynamodb::types::Delete>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HDelete(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItem_DPut(
    input: &::std::option::Option<aws_sdk_dynamodb::types::Put>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HPut(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItem_DUpdate(
    input: &::std::option::Option<aws_sdk_dynamodb::types::Update>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HUpdate(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemList(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::TransactWriteItem>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemList_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemList_Dmember(
    input: &aws_sdk_dynamodb::types::TransactWriteItem,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItem(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput(
    input: &aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput_DTransactItems(
        &input.r#transact_items,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput_DReturnItemCollectionMetrics(
        &input.r#return_item_collection_metrics,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput_DClientRequestToken(
        &input.r#client_request_token,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput_for_DynamoDB__20120810_TransactWriteItems(
    input: &aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput_DTransactItems(
        &input.r#transact_items,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput_DReturnItemCollectionMetrics(
        &input.r#return_item_collection_metrics,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput_DClientRequestToken(
        &input.r#client_request_token,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput_DClientRequestToken(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=36).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "client_request_token",
        "client_request_token failed to satisfy constraint: Member must have length between 1 and 36, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput_DReturnConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput_DReturnItemCollectionMetrics(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnItemCollectionMetrics>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsInput_DTransactItems(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::TransactWriteItem>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "transact_items",
                "transact_items is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    if !(1..=100).contains(&input.len()) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "transact_items",
        "transact_items failed to satisfy constraint: Member must have length between 1 and 100, inclusive",
    ));
    }
    validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemList(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsOutput(
    input: &aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsOutput_for_DynamoDB__20120810_TransactWriteItems(
    input: &aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsOutput_DConsumedCapacity(
    input: &::std::option::Option<::std::vec::Vec<aws_sdk_dynamodb::types::ConsumedCapacity>>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacityMultiple(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HTransactWriteItemsOutput_DItemCollectionMetrics(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            ::std::vec::Vec<aws_sdk_dynamodb::types::ItemCollectionMetrics>,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetricsPerTable(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdate(
    input: &aws_sdk_dynamodb::types::Update,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HUpdate_DKey(&Some(input.r#key.clone()))?;
    validate_com_Pamazonaws_Pdynamodb_HUpdate_DUpdateExpression(&Some(
        input.r#update_expression.clone(),
    ))?;
    validate_com_Pamazonaws_Pdynamodb_HUpdate_DTableName(&Some(input.r#table_name.clone()))?;
    validate_com_Pamazonaws_Pdynamodb_HUpdate_DConditionExpression(&input.r#condition_expression)?;
    validate_com_Pamazonaws_Pdynamodb_HUpdate_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdate_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdate_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdate_DConditionExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdate_DExpressionAttributeNames(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdate_DExpressionAttributeValues(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdate_DKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
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

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdate_DReturnValuesOnConditionCheckFailure(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnValuesOnConditionCheckFailure>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdate_DTableName(
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

    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdate_DUpdateExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Err(
            ::aws_smithy_types::error::operation::BuildError::missing_field(
                "update_expression",
                "update_expression is required but was not specified",
            ),
        );
    }
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput(
    input: &aws_sdk_dynamodb::operation::update_item::UpdateItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DKey(&input.r#key)?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DAttributeUpdates(
        &input.r#attribute_updates,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DExpected(&input.r#expected)?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DConditionalOperator(
        &input.r#conditional_operator,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DReturnValues(&input.r#return_values)?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DReturnItemCollectionMetrics(
        &input.r#return_item_collection_metrics,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DUpdateExpression(
        &input.r#update_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DConditionExpression(
        &input.r#condition_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_for_DynamoDB__20120810_UpdateItem(
    input: &aws_sdk_dynamodb::operation::update_item::UpdateItemInput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DTableName(&input.r#table_name)?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DKey(&input.r#key)?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DAttributeUpdates(
        &input.r#attribute_updates,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DExpected(&input.r#expected)?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DConditionalOperator(
        &input.r#conditional_operator,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DReturnValues(&input.r#return_values)?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DReturnConsumedCapacity(
        &input.r#return_consumed_capacity,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DReturnItemCollectionMetrics(
        &input.r#return_item_collection_metrics,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DUpdateExpression(
        &input.r#update_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DConditionExpression(
        &input.r#condition_expression,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DExpressionAttributeNames(
        &input.r#expression_attribute_names,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DExpressionAttributeValues(
        &input.r#expression_attribute_values,
    )?;
    validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DReturnValuesOnConditionCheckFailure(
        &input.r#return_values_on_condition_check_failure,
    )?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DAttributeUpdates(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            aws_sdk_dynamodb::types::AttributeValueUpdate,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeUpdates(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DConditionalOperator(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ConditionalOperator>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DConditionExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DExpected(
    input: &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            aws_sdk_dynamodb::types::ExpectedAttributeValue,
        >,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpectedAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DExpressionAttributeNames(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeNameMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DExpressionAttributeValues(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HExpressionAttributeValueMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DKey(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
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

    validate_com_Pamazonaws_Pdynamodb_HKey(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DReturnConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DReturnItemCollectionMetrics(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnItemCollectionMetrics>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DReturnValues(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnValue>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DReturnValuesOnConditionCheckFailure(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ReturnValuesOnConditionCheckFailure>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DTableName(
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

    if !(1..=1024).contains(
        &input
            .chars()
            .map(::std::primitive::char::len_utf16)
            .fold(0usize, ::std::ops::Add::add),
    ) {
        return ::std::result::Result::Err(::aws_smithy_types::error::operation::BuildError::invalid_field(
        "table_name",
        "table_name failed to satisfy constraint: Member must have length between 1 and 1024, inclusive",
    ));
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemInput_DUpdateExpression(
    input: &::std::option::Option<::std::string::String>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemOutput(
    input: &aws_sdk_dynamodb::operation::update_item::UpdateItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemOutput_for_DynamoDB__20120810_UpdateItem(
    input: &aws_sdk_dynamodb::operation::update_item::UpdateItemOutput,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    // Validation intentionally suppressed for AWS SDK response structures
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemOutput_DAttributes(
    input: &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HAttributeMap(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemOutput_DConsumedCapacity(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ConsumedCapacity>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HConsumedCapacity(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HUpdateItemOutput_DItemCollectionMetrics(
    input: &::std::option::Option<aws_sdk_dynamodb::types::ItemCollectionMetrics>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HItemCollectionMetrics(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HWriteRequest(
    input: &aws_sdk_dynamodb::types::WriteRequest,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HWriteRequest_DPutRequest(&input.r#put_request)?;
    validate_com_Pamazonaws_Pdynamodb_HWriteRequest_DDeleteRequest(&input.r#delete_request)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HWriteRequest_DDeleteRequest(
    input: &::std::option::Option<aws_sdk_dynamodb::types::DeleteRequest>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HDeleteRequest(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HWriteRequest_DPutRequest(
    input: &::std::option::Option<aws_sdk_dynamodb::types::PutRequest>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    if input.is_none() {
        return ::std::result::Result::Ok(());
    }
    let input = input.as_ref().unwrap();

    validate_com_Pamazonaws_Pdynamodb_HPutRequest(input)?;
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HWriteRequests(
    input: &::std::vec::Vec<aws_sdk_dynamodb::types::WriteRequest>,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    for inner in input.iter() {
        validate_com_Pamazonaws_Pdynamodb_HWriteRequests_Dmember(inner)?;
    }
    Ok(())
}
pub(crate) fn validate_com_Pamazonaws_Pdynamodb_HWriteRequests_Dmember(
    input: &aws_sdk_dynamodb::types::WriteRequest,
) -> ::std::result::Result<(), ::aws_smithy_types::error::operation::BuildError> {
    validate_com_Pamazonaws_Pdynamodb_HWriteRequest(input)?;
    Ok(())
}
