// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]

pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::structured_encryption_config::StructuredEncryptionConfig,
) -> ::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::StructuredEncryptionConfig,
>{
    ::std::rc::Rc::new(to_dafny_plain(value))
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::std::rc::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::StructuredEncryptionConfig,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::structured_encryption_config::StructuredEncryptionConfig{
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::structured_encryption_config::StructuredEncryptionConfig,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::StructuredEncryptionConfig{
    crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::StructuredEncryptionConfig::StructuredEncryptionConfig {

    }
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::StructuredEncryptionConfig,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::structured_encryption_config::StructuredEncryptionConfig{
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::structuredencryption::internaldafny::types::StructuredEncryptionConfig::StructuredEncryptionConfig {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::structured_encryption_config::StructuredEncryptionConfig::builder()

                .build()
                .unwrap()
    }
}
