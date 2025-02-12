// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]

pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
) -> ::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction>{
    ::dafny_runtime::Rc::new(match value {
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction::EncryptAndSign => crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction::ENCRYPT_AND_SIGN {},
crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction::SignAndIncludeInEncryptionContext => crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction::SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT {},
crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction::SignOnly => crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction::SIGN_ONLY {},
crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction::DoNothing => crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction::DO_NOTHING {},
        _ => panic!("Unknown enum variant: {}", value),
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction::ENCRYPT_AND_SIGN {} => crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction::EncryptAndSign,
crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction::SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT {} => crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction::SignAndIncludeInEncryptionContext,
crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction::SIGN_ONLY {} => crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction::SignOnly,
crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::CryptoAction::DO_NOTHING {} => crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction::DoNothing,
    }
}
