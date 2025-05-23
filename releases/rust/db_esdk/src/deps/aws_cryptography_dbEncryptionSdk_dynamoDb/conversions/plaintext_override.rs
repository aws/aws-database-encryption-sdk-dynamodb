// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]

pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride,
) -> ::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::PlaintextOverride>{
    ::dafny_runtime::Rc::new(match value {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride::ForcePlaintextWriteAllowPlaintextRead => crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::PlaintextOverride::FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ {},
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride::ForbidPlaintextWriteAllowPlaintextRead => crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::PlaintextOverride::FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ {},
crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride::ForbidPlaintextWriteForbidPlaintextRead => crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::PlaintextOverride::FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ {},
        _ => panic!("Unknown enum variant: {}", value),
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::PlaintextOverride,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::PlaintextOverride::FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ {} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride::ForcePlaintextWriteAllowPlaintextRead,
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::PlaintextOverride::FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ {} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride::ForbidPlaintextWriteAllowPlaintextRead,
crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::PlaintextOverride::FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ {} => crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride::ForbidPlaintextWriteForbidPlaintextRead,
    }
}
