// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]

pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfig,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbEncryptionConfig,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value))
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbEncryptionConfig,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfig{
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfig,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbEncryptionConfig{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbEncryptionConfig::DynamoDbEncryptionConfig {

    }
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbEncryptionConfig,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfig{
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbEncryptionConfig::DynamoDbEncryptionConfig {..} =>
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfig::builder()

                .build()
                .unwrap()
    }
}
