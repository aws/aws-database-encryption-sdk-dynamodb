// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct EncryptStructureOutput {
    #[allow(missing_docs)]
pub crypto_schema: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
#[allow(missing_docs)]
pub encrypted_structure: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
#[allow(missing_docs)]
pub parsed_header: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader>,
}
impl EncryptStructureOutput {
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
    pub fn encrypted_structure(&self) -> &::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>{
        &self.encrypted_structure
    }
    #[allow(missing_docs)]
    pub fn parsed_header(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
    > {
        &self.parsed_header
    }
}
impl EncryptStructureOutput {
    /// Creates a new builder-style object to manufacture [`EncryptStructureOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureOutput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::builders::EncryptStructureOutputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::builders::EncryptStructureOutputBuilder::default()
    }
}

/// A builder for [`EncryptStructureOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct EncryptStructureOutputBuilder {
    pub(crate) crypto_schema: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
pub(crate) encrypted_structure: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>>,
pub(crate) parsed_header: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader>,
}
impl EncryptStructureOutputBuilder {
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
    pub fn parsed_header(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
        >,
    ) -> Self {
        self.parsed_header = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_parsed_header(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
        >,
    ) -> Self {
        self.parsed_header = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_parsed_header(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
    > {
        &self.parsed_header
    }
    /// Consumes the builder and constructs a [`EncryptStructureOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::EncryptStructureOutput {
            crypto_schema: self.crypto_schema,
encrypted_structure: self.encrypted_structure,
parsed_header: self.parsed_header,
        })
    }
}
