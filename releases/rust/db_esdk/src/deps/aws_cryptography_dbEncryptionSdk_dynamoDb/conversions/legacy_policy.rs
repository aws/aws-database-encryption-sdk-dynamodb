// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]

pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy,
) -> ::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyPolicy>{
    ::dafny_runtime::Rc::new(match value {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy::ForceLegacyEncryptAllowLegacyDecrypt => crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyPolicy::FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT {},
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy::ForbidLegacyEncryptAllowLegacyDecrypt => crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyPolicy::FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT {},
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy::ForbidLegacyEncryptForbidLegacyDecrypt => crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyPolicy::FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT {},
        _ => panic!("Unknown enum variant: {}", value),
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyPolicy,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyPolicy::FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT {} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy::ForceLegacyEncryptAllowLegacyDecrypt,
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyPolicy::FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT {} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy::ForbidLegacyEncryptAllowLegacyDecrypt,
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::LegacyPolicy::FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT {} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy::ForbidLegacyEncryptForbidLegacyDecrypt,
    }
}
