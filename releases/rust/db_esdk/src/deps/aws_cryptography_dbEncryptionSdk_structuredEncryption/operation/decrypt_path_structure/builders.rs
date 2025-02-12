// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub use crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::_decrypt_path_structure_output::DecryptPathStructureOutputBuilder;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::_decrypt_path_structure_input::DecryptPathStructureInputBuilder;

impl DecryptPathStructureInputBuilder {
    /// Sends a request with this input using the given client.
    pub async fn send_with(
        self,
        client: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::client::Client,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::DecryptPathStructureOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error,
    >{
        let mut fluent_builder = client.decrypt_path_structure();
        fluent_builder.inner = self;
        fluent_builder.send().await
    }
}
/// Fluent builder constructing a request to `DecryptPathStructure`.
///
#[derive(::std::clone::Clone, ::std::fmt::Debug)]
pub struct DecryptPathStructureFluentBuilder {
    client: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::client::Client,
    pub(crate) inner: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::builders::DecryptPathStructureInputBuilder,
}
impl DecryptPathStructureFluentBuilder {
    /// Creates a new `DecryptPathStructure`.
    pub(crate) fn new(
        client: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::client::Client,
    ) -> Self {
        Self {
            client,
            inner: ::std::default::Default::default(),
        }
    }
    /// Access the DecryptPathStructure as a reference.
    pub fn as_input(&self) -> &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::builders::DecryptPathStructureInputBuilder{
        &self.inner
    }
    /// Sends the request and returns the response.
    pub async fn send(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::DecryptPathStructureOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error,
    >{
        let input = self
            .inner
            .build()
            // Using Opaque since we don't have a validation-specific error yet.
            // Operations' models don't declare their own validation error,
            // and smithy-rs seems to not generate a ValidationError case unless there is.
            // Vanilla smithy-rs uses SdkError::construction_failure, but we aren't using SdkError.
            .map_err(|mut e| {
	     let msg = format!("{:?}", e);
             crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error::OpaqueWithText {
                obj: ::dafny_runtime::Object::from_ref(&mut e as &mut ::dafny_runtime::DynAny),
		objMessage: msg
             }})?;
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::decrypt_path_structure::DecryptPathStructure::send(&self.client, input).await
    }

    #[allow(missing_docs)]
    pub fn cmm(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
    ) -> Self {
        self.inner = self.inner.cmm(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_cmm(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>,
    ) -> Self {
        self.inner = self.inner.set_cmm(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_cmm(&self) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::cryptographic_materials_manager::CryptographicMaterialsManagerRef>{
        self.inner.get_cmm()
    }
    #[allow(missing_docs)]
    pub fn encrypted_structure(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
            >,
        >,
    ) -> Self {
        self.inner = self.inner.encrypted_structure(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_encrypted_structure(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
            >,
        >,
    ) -> Self {
        self.inner = self.inner.set_encrypted_structure(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_encrypted_structure(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
        >,
    > {
        self.inner.get_encrypted_structure()
    }
    #[allow(missing_docs)]
    pub fn encryption_context(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.inner = self.inner.encryption_context(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_encryption_context(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.inner = self.inner.set_encryption_context(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_encryption_context(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    > {
        self.inner.get_encryption_context()
    }
    #[allow(missing_docs)]
    pub fn table_name(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.inner = self.inner.table_name(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_table_name(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.inner = self.inner.set_table_name(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_table_name(&self) -> &::std::option::Option<::std::string::String> {
        self.inner.get_table_name()
    }
}
