// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]

pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction,
) -> ::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthenticateAction>{
    ::dafny_runtime::Rc::new(match value {
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction::Sign => crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthenticateAction::SIGN {},
crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction::DoNotSign => crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthenticateAction::DO_NOT_SIGN {},
        _ => panic!("Unknown enum variant: {}", value),
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthenticateAction,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthenticateAction::SIGN {} => crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction::Sign,
crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::AuthenticateAction::DO_NOT_SIGN {} => crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction::DoNotSign,
    }
}
