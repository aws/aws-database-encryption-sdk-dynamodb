// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct EncryptPathStructureOutput {
    #[allow(missing_docs)]
    pub encrypted_structure: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    >,
    #[allow(missing_docs)]
    pub parsed_header: ::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
    >,
}
impl EncryptPathStructureOutput {
    #[allow(missing_docs)]
    pub fn encrypted_structure(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    > {
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
impl EncryptPathStructureOutput {
    /// Creates a new builder-style object to manufacture [`EncryptPathStructureOutput`](crate::operation::encrypt_path_structure::builders::EncryptPathStructureOutput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_path_structure::builders::EncryptPathStructureOutputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_path_structure::builders::EncryptPathStructureOutputBuilder::default()
    }
}

/// A builder for [`EncryptPathStructureOutput`](crate::operation::operation::EncryptPathStructureOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct EncryptPathStructureOutputBuilder {
    pub(crate) encrypted_structure: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    >,
    pub(crate) parsed_header: ::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
    >,
}
impl EncryptPathStructureOutputBuilder {
    #[allow(missing_docs)]
    pub fn encrypted_structure(
        mut self,
        input: impl ::std::convert::Into<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem>>,
    ) -> Self {
        self.encrypted_structure = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_encrypted_structure(
        mut self,
        input: ::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem>>,
    ) -> Self {
        self.encrypted_structure = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_encrypted_structure(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    > {
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
    /// Consumes the builder and constructs a [`EncryptPathStructureOutput`](crate::operation::operation::EncryptPathStructureOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_path_structure::EncryptPathStructureOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::encrypt_path_structure::EncryptPathStructureOutput {
            encrypted_structure: self.encrypted_structure,
parsed_header: self.parsed_header,
        })
    }
}
