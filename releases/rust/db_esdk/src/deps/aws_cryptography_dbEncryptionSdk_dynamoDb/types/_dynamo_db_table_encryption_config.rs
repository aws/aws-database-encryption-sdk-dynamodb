// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct DynamoDbTableEncryptionConfig {
    #[allow(missing_docs)] // documentation missing in model
pub algorithm_suite_id: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId>,
#[allow(missing_docs)] // documentation missing in model
pub allowed_unsigned_attribute_prefix: ::std::option::Option<::std::string::String>,
#[allow(missing_docs)] // documentation missing in model
pub allowed_unsigned_attributes: ::std::option::Option<::std::vec::Vec<::std::string::String>>,
#[allow(missing_docs)] // documentation missing in model
pub attribute_actions_on_encrypt: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
#[allow(missing_docs)] // documentation missing in model
pub cmm: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
#[allow(missing_docs)] // documentation missing in model
pub keyring: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef>,
#[allow(missing_docs)] // documentation missing in model
pub legacy_override: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride>,
#[allow(missing_docs)] // documentation missing in model
pub logical_table_name: ::std::option::Option<::std::string::String>,
#[allow(missing_docs)] // documentation missing in model
pub partition_key_name: ::std::option::Option<::std::string::String>,
#[allow(missing_docs)] // documentation missing in model
pub plaintext_override: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride>,
#[allow(missing_docs)] // documentation missing in model
pub search: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig>,
#[allow(missing_docs)] // documentation missing in model
pub sort_key_name: ::std::option::Option<::std::string::String>,
}
impl DynamoDbTableEncryptionConfig {
    #[allow(missing_docs)] // documentation missing in model
    pub fn algorithm_suite_id(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
    > {
        &self.algorithm_suite_id
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn allowed_unsigned_attribute_prefix(
        &self,
    ) -> &::std::option::Option<::std::string::String> {
        &self.allowed_unsigned_attribute_prefix
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn allowed_unsigned_attributes(
        &self,
    ) -> &::std::option::Option<::std::vec::Vec<::std::string::String>> {
        &self.allowed_unsigned_attributes
    }
    #[allow(missing_docs)] // documentation missing in model
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
    #[allow(missing_docs)] // documentation missing in model
    pub fn cmm(&self) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>{
        &self.cmm
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn keyring(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef,
    > {
        &self.keyring
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn legacy_override(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
    > {
        &self.legacy_override
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn logical_table_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.logical_table_name
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn partition_key_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.partition_key_name
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn plaintext_override(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride,
    > {
        &self.plaintext_override
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn search(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig,
    > {
        &self.search
    }
    #[allow(missing_docs)] // documentation missing in model
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
    #[allow(missing_docs)] // documentation missing in model
    pub fn algorithm_suite_id(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
        >,
    ) -> Self {
        self.algorithm_suite_id = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_algorithm_suite_id(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
        >,
    ) -> Self {
        self.algorithm_suite_id = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_algorithm_suite_id(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
    > {
        &self.algorithm_suite_id
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn allowed_unsigned_attribute_prefix(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.allowed_unsigned_attribute_prefix = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_allowed_unsigned_attribute_prefix(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.allowed_unsigned_attribute_prefix = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_allowed_unsigned_attribute_prefix(
        &self,
    ) -> &::std::option::Option<::std::string::String> {
        &self.allowed_unsigned_attribute_prefix
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn allowed_unsigned_attributes(
        mut self,
        input: impl ::std::convert::Into<::std::vec::Vec<::std::string::String>>,
    ) -> Self {
        self.allowed_unsigned_attributes = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_allowed_unsigned_attributes(
        mut self,
        input: ::std::option::Option<::std::vec::Vec<::std::string::String>>,
    ) -> Self {
        self.allowed_unsigned_attributes = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_allowed_unsigned_attributes(
        &self,
    ) -> &::std::option::Option<::std::vec::Vec<::std::string::String>> {
        &self.allowed_unsigned_attributes
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn attribute_actions_on_encrypt(
        mut self,
        input: impl ::std::convert::Into<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
    ) -> Self {
        self.attribute_actions_on_encrypt = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_attribute_actions_on_encrypt(
        mut self,
        input: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
    ) -> Self {
        self.attribute_actions_on_encrypt = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
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
    #[allow(missing_docs)] // documentation missing in model
    pub fn cmm(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
    ) -> Self {
        self.cmm = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_cmm(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
    ) -> Self {
        self.cmm = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_cmm(&self) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>{
        &self.cmm
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn keyring(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef,
        >,
    ) -> Self {
        self.keyring = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_keyring(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef,
        >,
    ) -> Self {
        self.keyring = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_keyring(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::keyring::KeyringRef,
    > {
        &self.keyring
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn legacy_override(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
        >,
    ) -> Self {
        self.legacy_override = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_legacy_override(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
        >,
    ) -> Self {
        self.legacy_override = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_legacy_override(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
    > {
        &self.legacy_override
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn logical_table_name(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.logical_table_name = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_logical_table_name(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.logical_table_name = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_logical_table_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.logical_table_name
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn partition_key_name(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.partition_key_name = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_partition_key_name(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.partition_key_name = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_partition_key_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.partition_key_name
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn plaintext_override(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride,
        >,
    ) -> Self {
        self.plaintext_override = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_plaintext_override(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride,
        >,
    ) -> Self {
        self.plaintext_override = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_plaintext_override(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PlaintextOverride,
    > {
        &self.plaintext_override
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn search(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig,
        >,
    ) -> Self {
        self.search = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_search(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig,
        >,
    ) -> Self {
        self.search = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_search(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig,
    > {
        &self.search
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn sort_key_name(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.sort_key_name = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_sort_key_name(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.sort_key_name = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
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
