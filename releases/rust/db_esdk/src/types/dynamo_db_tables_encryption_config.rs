// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct DynamoDbTablesEncryptionConfig {
    #[allow(missing_docs)] // documentation missing in model
pub table_encryption_configs: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig>>,
}
impl DynamoDbTablesEncryptionConfig {
    #[allow(missing_docs)] // documentation missing in model
    pub fn table_encryption_configs(&self) -> &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig>>{
        &self.table_encryption_configs
    }
}
impl DynamoDbTablesEncryptionConfig {
    /// Creates a new builder-style object to manufacture [`DynamoDbTablesEncryptionConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTablesEncryptionConfig).
    pub fn builder(
    ) -> crate::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfigBuilder
    {
        crate::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfigBuilder::default()
    }
}

/// A builder for [`DynamoDbTablesEncryptionConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTablesEncryptionConfig).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct DynamoDbTablesEncryptionConfigBuilder {
    pub(crate) table_encryption_configs: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig>>,
}
impl DynamoDbTablesEncryptionConfigBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn table_encryption_configs(
        mut self,
        input: impl ::std::convert::Into<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig>>,
    ) -> Self {
        self.table_encryption_configs = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_table_encryption_configs(
        mut self,
        input: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig>>,
    ) -> Self {
        self.table_encryption_configs = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_table_encryption_configs(&self) -> &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig>>{
        &self.table_encryption_configs
    }
    /// Consumes the builder and constructs a [`DynamoDbTablesEncryptionConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTablesEncryptionConfig).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfig,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfig {
                table_encryption_configs: self.table_encryption_configs,
            },
        )
    }
}
