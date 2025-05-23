// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// The configuration for client-side encryption for a particular DynamoDB table.
pub struct DynamoDbTableEncryptionConfig {
    /// An ID for the algorithm suite to use during encryption and decryption.
pub algorithm_suite_id: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId>,
/// A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
pub allowed_unsigned_attribute_prefix: ::std::option::Option<::std::string::String>,
/// A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
pub allowed_unsigned_attributes: ::std::option::Option<::std::vec::Vec<::std::string::String>>,
/// A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.
pub attribute_actions_on_encrypt: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
/// The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
pub cmm: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
/// The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
pub keyring: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef>,
/// A configuration that override encryption and/or decryption to instead perform legacy encryption and/or decryption. Used as part of migration from version 2.x to version 3.x.
pub legacy_override: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride>,
/// The logical table name for this table. This is the name that is cryptographically bound with your data. This can be the same as the actual DynamoDB table name. It's purpose is to be distinct from the DynamoDB table name so that the data may still be authenticated if being read from different (but logically similar) tables, such as a backup table.
pub logical_table_name: ::std::option::Option<::std::string::String>,
/// The name of the partition key on this table.
pub partition_key_name: ::std::option::Option<::std::string::String>,
/// A configuration that override encryption and/or decryption to instead passthrough and write and/or read plaintext. Used to update plaintext tables to fully use client-side encryption.
pub plaintext_override: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride>,
/// The configuration for searchable encryption.
pub search: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig>,
/// If this table contains a sort key, the name of the sort key on this table.
pub sort_key_name: ::std::option::Option<::std::string::String>,
}
impl DynamoDbTableEncryptionConfig {
    /// An ID for the algorithm suite to use during encryption and decryption.
    pub fn algorithm_suite_id(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
    > {
        &self.algorithm_suite_id
    }
    /// A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
    pub fn allowed_unsigned_attribute_prefix(
        &self,
    ) -> &::std::option::Option<::std::string::String> {
        &self.allowed_unsigned_attribute_prefix
    }
    /// A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
    pub fn allowed_unsigned_attributes(
        &self,
    ) -> &::std::option::Option<::std::vec::Vec<::std::string::String>> {
        &self.allowed_unsigned_attributes
    }
    /// A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.
    pub fn attribute_actions_on_encrypt(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    > {
        &self.attribute_actions_on_encrypt
    }
    /// The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
    pub fn cmm(&self) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>{
        &self.cmm
    }
    /// The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
    pub fn keyring(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef,
    > {
        &self.keyring
    }
    /// A configuration that override encryption and/or decryption to instead perform legacy encryption and/or decryption. Used as part of migration from version 2.x to version 3.x.
    pub fn legacy_override(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
    > {
        &self.legacy_override
    }
    /// The logical table name for this table. This is the name that is cryptographically bound with your data. This can be the same as the actual DynamoDB table name. It's purpose is to be distinct from the DynamoDB table name so that the data may still be authenticated if being read from different (but logically similar) tables, such as a backup table.
    pub fn logical_table_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.logical_table_name
    }
    /// The name of the partition key on this table.
    pub fn partition_key_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.partition_key_name
    }
    /// A configuration that override encryption and/or decryption to instead passthrough and write and/or read plaintext. Used to update plaintext tables to fully use client-side encryption.
    pub fn plaintext_override(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride,
    > {
        &self.plaintext_override
    }
    /// The configuration for searchable encryption.
    pub fn search(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig,
    > {
        &self.search
    }
    /// If this table contains a sort key, the name of the sort key on this table.
    pub fn sort_key_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.sort_key_name
    }
}
impl DynamoDbTableEncryptionConfig {
    /// Creates a new builder-style object to manufacture [`DynamoDbTableEncryptionConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::DynamoDbTableEncryptionConfigBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::DynamoDbTableEncryptionConfigBuilder::default()
    }
}

/// A builder for [`DynamoDbTableEncryptionConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct DynamoDbTableEncryptionConfigBuilder {
    pub(crate) algorithm_suite_id: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId>,
pub(crate) allowed_unsigned_attribute_prefix: ::std::option::Option<::std::string::String>,
pub(crate) allowed_unsigned_attributes: ::std::option::Option<::std::vec::Vec<::std::string::String>>,
pub(crate) attribute_actions_on_encrypt: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
pub(crate) cmm: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
pub(crate) keyring: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef>,
pub(crate) legacy_override: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride>,
pub(crate) logical_table_name: ::std::option::Option<::std::string::String>,
pub(crate) partition_key_name: ::std::option::Option<::std::string::String>,
pub(crate) plaintext_override: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride>,
pub(crate) search: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig>,
pub(crate) sort_key_name: ::std::option::Option<::std::string::String>,
}
impl DynamoDbTableEncryptionConfigBuilder {
    /// An ID for the algorithm suite to use during encryption and decryption.
    pub fn algorithm_suite_id(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
        >,
    ) -> Self {
        self.algorithm_suite_id = ::std::option::Option::Some(input.into());
        self
    }
    /// An ID for the algorithm suite to use during encryption and decryption.
    pub fn set_algorithm_suite_id(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
        >,
    ) -> Self {
        self.algorithm_suite_id = input;
        self
    }
    /// An ID for the algorithm suite to use during encryption and decryption.
    pub fn get_algorithm_suite_id(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
    > {
        &self.algorithm_suite_id
    }
    /// A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
    pub fn allowed_unsigned_attribute_prefix(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.allowed_unsigned_attribute_prefix = ::std::option::Option::Some(input.into());
        self
    }
    /// A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
    pub fn set_allowed_unsigned_attribute_prefix(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.allowed_unsigned_attribute_prefix = input;
        self
    }
    /// A prefix such that, if during decryption any attribute has a name with this prefix, it is treated as unsigned.
    pub fn get_allowed_unsigned_attribute_prefix(
        &self,
    ) -> &::std::option::Option<::std::string::String> {
        &self.allowed_unsigned_attribute_prefix
    }
    /// A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
    pub fn allowed_unsigned_attributes(
        mut self,
        input: impl ::std::convert::Into<::std::vec::Vec<::std::string::String>>,
    ) -> Self {
        self.allowed_unsigned_attributes = ::std::option::Option::Some(input.into());
        self
    }
    /// A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
    pub fn set_allowed_unsigned_attributes(
        mut self,
        input: ::std::option::Option<::std::vec::Vec<::std::string::String>>,
    ) -> Self {
        self.allowed_unsigned_attributes = input;
        self
    }
    /// A list of attribute names such that, if encountered during decryption, those attributes are treated as unsigned.
    pub fn get_allowed_unsigned_attributes(
        &self,
    ) -> &::std::option::Option<::std::vec::Vec<::std::string::String>> {
        &self.allowed_unsigned_attributes
    }
    /// A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.
    pub fn attribute_actions_on_encrypt(
        mut self,
        input: impl ::std::convert::Into<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
    ) -> Self {
        self.attribute_actions_on_encrypt = ::std::option::Option::Some(input.into());
        self
    }
    /// A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.
    pub fn set_attribute_actions_on_encrypt(
        mut self,
        input: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
    ) -> Self {
        self.attribute_actions_on_encrypt = input;
        self
    }
    /// A map that describes what attributes should be encrypted and/or signed on encrypt. This map must contain all attributes that might be encountered during encryption.
    pub fn get_attribute_actions_on_encrypt(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    > {
        &self.attribute_actions_on_encrypt
    }
    /// The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
    pub fn cmm(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
    ) -> Self {
        self.cmm = ::std::option::Option::Some(input.into());
        self
    }
    /// The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
    pub fn set_cmm(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
    ) -> Self {
        self.cmm = input;
        self
    }
    /// The Cryptographic Materials Manager that is used to obtain materials for encryption and decryption.  Either a Keyring or a Cryptographic Materials Manager must be specified.
    pub fn get_cmm(&self) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>{
        &self.cmm
    }
    /// The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
    pub fn keyring(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef,
        >,
    ) -> Self {
        self.keyring = ::std::option::Option::Some(input.into());
        self
    }
    /// The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
    pub fn set_keyring(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef,
        >,
    ) -> Self {
        self.keyring = input;
        self
    }
    /// The Keyring that should be used to wrap and unwrap data keys. If specified a Default Cryptographic Materials Manager with this Keyring is used to obtain materials for encryption and decryption. Either a Keyring or a Cryptographic Materials Manager must be specified.
    pub fn get_keyring(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef,
    > {
        &self.keyring
    }
    /// A configuration that override encryption and/or decryption to instead perform legacy encryption and/or decryption. Used as part of migration from version 2.x to version 3.x.
    pub fn legacy_override(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
        >,
    ) -> Self {
        self.legacy_override = ::std::option::Option::Some(input.into());
        self
    }
    /// A configuration that override encryption and/or decryption to instead perform legacy encryption and/or decryption. Used as part of migration from version 2.x to version 3.x.
    pub fn set_legacy_override(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
        >,
    ) -> Self {
        self.legacy_override = input;
        self
    }
    /// A configuration that override encryption and/or decryption to instead perform legacy encryption and/or decryption. Used as part of migration from version 2.x to version 3.x.
    pub fn get_legacy_override(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
    > {
        &self.legacy_override
    }
    /// The logical table name for this table. This is the name that is cryptographically bound with your data. This can be the same as the actual DynamoDB table name. It's purpose is to be distinct from the DynamoDB table name so that the data may still be authenticated if being read from different (but logically similar) tables, such as a backup table.
    pub fn logical_table_name(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.logical_table_name = ::std::option::Option::Some(input.into());
        self
    }
    /// The logical table name for this table. This is the name that is cryptographically bound with your data. This can be the same as the actual DynamoDB table name. It's purpose is to be distinct from the DynamoDB table name so that the data may still be authenticated if being read from different (but logically similar) tables, such as a backup table.
    pub fn set_logical_table_name(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.logical_table_name = input;
        self
    }
    /// The logical table name for this table. This is the name that is cryptographically bound with your data. This can be the same as the actual DynamoDB table name. It's purpose is to be distinct from the DynamoDB table name so that the data may still be authenticated if being read from different (but logically similar) tables, such as a backup table.
    pub fn get_logical_table_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.logical_table_name
    }
    /// The name of the partition key on this table.
    pub fn partition_key_name(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.partition_key_name = ::std::option::Option::Some(input.into());
        self
    }
    /// The name of the partition key on this table.
    pub fn set_partition_key_name(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.partition_key_name = input;
        self
    }
    /// The name of the partition key on this table.
    pub fn get_partition_key_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.partition_key_name
    }
    /// A configuration that override encryption and/or decryption to instead passthrough and write and/or read plaintext. Used to update plaintext tables to fully use client-side encryption.
    pub fn plaintext_override(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride,
        >,
    ) -> Self {
        self.plaintext_override = ::std::option::Option::Some(input.into());
        self
    }
    /// A configuration that override encryption and/or decryption to instead passthrough and write and/or read plaintext. Used to update plaintext tables to fully use client-side encryption.
    pub fn set_plaintext_override(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride,
        >,
    ) -> Self {
        self.plaintext_override = input;
        self
    }
    /// A configuration that override encryption and/or decryption to instead passthrough and write and/or read plaintext. Used to update plaintext tables to fully use client-side encryption.
    pub fn get_plaintext_override(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride,
    > {
        &self.plaintext_override
    }
    /// The configuration for searchable encryption.
    pub fn search(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig,
        >,
    ) -> Self {
        self.search = ::std::option::Option::Some(input.into());
        self
    }
    /// The configuration for searchable encryption.
    pub fn set_search(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig,
        >,
    ) -> Self {
        self.search = input;
        self
    }
    /// The configuration for searchable encryption.
    pub fn get_search(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig,
    > {
        &self.search
    }
    /// If this table contains a sort key, the name of the sort key on this table.
    pub fn sort_key_name(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.sort_key_name = ::std::option::Option::Some(input.into());
        self
    }
    /// If this table contains a sort key, the name of the sort key on this table.
    pub fn set_sort_key_name(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.sort_key_name = input;
        self
    }
    /// If this table contains a sort key, the name of the sort key on this table.
    pub fn get_sort_key_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.sort_key_name
    }
    /// Consumes the builder and constructs a [`DynamoDbTableEncryptionConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig {
            algorithm_suite_id: self.algorithm_suite_id,
allowed_unsigned_attribute_prefix: self.allowed_unsigned_attribute_prefix,
allowed_unsigned_attributes: self.allowed_unsigned_attributes,
attribute_actions_on_encrypt: self.attribute_actions_on_encrypt,
cmm: self.cmm,
keyring: self.keyring,
legacy_override: self.legacy_override,
logical_table_name: self.logical_table_name,
partition_key_name: self.partition_key_name,
plaintext_override: self.plaintext_override,
search: self.search,
sort_key_name: self.sort_key_name,
        })
    }
}
