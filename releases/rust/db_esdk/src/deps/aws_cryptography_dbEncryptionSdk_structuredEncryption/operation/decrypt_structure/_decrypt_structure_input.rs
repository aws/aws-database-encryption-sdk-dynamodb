// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct DecryptStructureInput {
    #[allow(missing_docs)]
pub authenticate_schema: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction>>,
#[allow(missing_docs)]
pub cmm: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
#[allow(missing_docs)]
pub encrypted_structure: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
#[allow(missing_docs)]
pub encryption_context: ::std::option::Option<::std::collections::HashMap<::std::string::String, ::std::string::String>>,
#[allow(missing_docs)]
pub table_name: ::std::option::Option<::std::string::String>,
}
impl DecryptStructureInput {
    #[allow(missing_docs)]
    pub fn authenticate_schema(&self) -> &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction>>{
        &self.authenticate_schema
    }
    #[allow(missing_docs)]
    pub fn cmm(&self) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>{
        &self.cmm
    }
    #[allow(missing_docs)]
    pub fn encrypted_structure(&self) -> &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>{
        &self.encrypted_structure
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
    pub fn table_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.table_name
    }
}
impl DecryptStructureInput {
    /// Creates a new builder-style object to manufacture [`DecryptStructureInput`](crate::operation::decrypt_structure::builders::DecryptStructureInput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_structure::builders::DecryptStructureInputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_structure::builders::DecryptStructureInputBuilder::default()
    }
}

/// A builder for [`DecryptStructureInput`](crate::operation::operation::DecryptStructureInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct DecryptStructureInputBuilder {
    pub(crate) authenticate_schema: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction>>,
pub(crate) cmm: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
pub(crate) encrypted_structure: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
pub(crate) encryption_context: ::std::option::Option<::std::collections::HashMap<::std::string::String, ::std::string::String>>,
pub(crate) table_name: ::std::option::Option<::std::string::String>,
}
impl DecryptStructureInputBuilder {
    #[allow(missing_docs)]
    pub fn authenticate_schema(
        mut self,
        input: impl ::std::convert::Into<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction>>,
    ) -> Self {
        self.authenticate_schema = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_authenticate_schema(
        mut self,
        input: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction>>,
    ) -> Self {
        self.authenticate_schema = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_authenticate_schema(&self) -> &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthenticateAction>>{
        &self.authenticate_schema
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
    pub fn encrypted_structure(
        mut self,
        input: impl ::std::convert::Into<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
    ) -> Self {
        self.encrypted_structure = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_encrypted_structure(
        mut self,
        input: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
    ) -> Self {
        self.encrypted_structure = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_encrypted_structure(&self) -> &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>{
        &self.encrypted_structure
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
    /// Consumes the builder and constructs a [`DecryptStructureInput`](crate::operation::operation::DecryptStructureInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_structure::DecryptStructureInput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_structure::DecryptStructureInput {
            authenticate_schema: self.authenticate_schema,
cmm: self.cmm,
encrypted_structure: self.encrypted_structure,
encryption_context: self.encryption_context,
table_name: self.table_name,
        })
    }
}
