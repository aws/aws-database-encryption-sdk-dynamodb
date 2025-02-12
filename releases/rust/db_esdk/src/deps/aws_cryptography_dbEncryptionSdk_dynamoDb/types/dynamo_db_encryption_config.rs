// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct DynamoDbEncryptionConfig {}
impl DynamoDbEncryptionConfig {}
impl DynamoDbEncryptionConfig {
    /// Creates a new builder-style object to manufacture [`DynamoDbEncryptionConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbEncryptionConfig).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfigBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfigBuilder::default()
    }
}

/// A builder for [`DynamoDbEncryptionConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbEncryptionConfig).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct DynamoDbEncryptionConfigBuilder {}
impl DynamoDbEncryptionConfigBuilder {
    /// Consumes the builder and constructs a [`DynamoDbEncryptionConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbEncryptionConfig).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfig,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfig {

        })
    }
}
