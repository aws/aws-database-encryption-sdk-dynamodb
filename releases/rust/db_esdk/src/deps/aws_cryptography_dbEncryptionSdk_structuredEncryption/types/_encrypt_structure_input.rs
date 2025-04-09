// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct EncryptStructureInput {
    #[allow(missing_docs)]
pub algorithm_suite_id: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId>,
#[allow(missing_docs)]
pub cmm: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
#[allow(missing_docs)]
pub crypto_schema: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
#[allow(missing_docs)]
pub encryption_context: ::std::option::Option<::std::collections::HashMap<::std::string::String, ::std::string::String>>,
#[allow(missing_docs)]
pub plaintext_structure: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
#[allow(missing_docs)]
pub table_name: ::std::option::Option<::std::string::String>,
}
impl EncryptStructureInput {
    #[allow(missing_docs)]
    pub fn algorithm_suite_id(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
    > {
        &self.algorithm_suite_id
    }
    #[allow(missing_docs)]
    pub fn cmm(&self) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>{
        &self.cmm
    }
    #[allow(missing_docs)]
    pub fn crypto_schema(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    > {
        &self.crypto_schema
    }
    #[allow(missing_docs)]
    pub fn encryption_context(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    > {
        &self.encryption_context
    }
    #[allow(missing_docs)]
    pub fn plaintext_structure(&self) -> &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>{
        &self.plaintext_structure
    }
    #[allow(missing_docs)]
    pub fn table_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.table_name
    }
}
impl EncryptStructureInput {
    /// Creates a new builder-style object to manufacture [`EncryptStructureInput`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureInput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::builders::EncryptStructureInputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::builders::EncryptStructureInputBuilder::default()
    }
}

/// A builder for [`EncryptStructureInput`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct EncryptStructureInputBuilder {
    pub(crate) algorithm_suite_id: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId>,
pub(crate) cmm: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
pub(crate) crypto_schema: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
pub(crate) encryption_context: ::std::option::Option<::std::collections::HashMap<::std::string::String, ::std::string::String>>,
pub(crate) plaintext_structure: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
pub(crate) table_name: ::std::option::Option<::std::string::String>,
}
impl EncryptStructureInputBuilder {
    #[allow(missing_docs)]
    pub fn algorithm_suite_id(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
        >,
    ) -> Self {
        self.algorithm_suite_id = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_algorithm_suite_id(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
        >,
    ) -> Self {
        self.algorithm_suite_id = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_algorithm_suite_id(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
    > {
        &self.algorithm_suite_id
    }
    #[allow(missing_docs)]
    pub fn cmm(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
    ) -> Self {
        self.cmm = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_cmm(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
    ) -> Self {
        self.cmm = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_cmm(&self) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>{
        &self.cmm
    }
    #[allow(missing_docs)]
    pub fn crypto_schema(
        mut self,
        input: impl ::std::convert::Into<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
    ) -> Self {
        self.crypto_schema = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_crypto_schema(
        mut self,
        input: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
    ) -> Self {
        self.crypto_schema = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_crypto_schema(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    > {
        &self.crypto_schema
    }
    #[allow(missing_docs)]
    pub fn encryption_context(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.encryption_context = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_encryption_context(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.encryption_context = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_encryption_context(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    > {
        &self.encryption_context
    }
    #[allow(missing_docs)]
    pub fn plaintext_structure(
        mut self,
        input: impl ::std::convert::Into<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
    ) -> Self {
        self.plaintext_structure = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_plaintext_structure(
        mut self,
        input: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
    ) -> Self {
        self.plaintext_structure = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_plaintext_structure(&self) -> &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>{
        &self.plaintext_structure
    }
    #[allow(missing_docs)]
    pub fn table_name(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.table_name = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_table_name(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.table_name = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_table_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.table_name
    }
    /// Consumes the builder and constructs a [`EncryptStructureInput`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureInput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureInput {
            algorithm_suite_id: self.algorithm_suite_id,
cmm: self.cmm,
crypto_schema: self.crypto_schema,
encryption_context: self.encryption_context,
plaintext_structure: self.plaintext_structure,
table_name: self.table_name,
        })
    }
}
