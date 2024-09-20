// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct DecryptPathStructureOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub parsed_header: ::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
    >,
    #[allow(missing_docs)] // documentation missing in model
    pub plaintext_structure: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    >,
}
impl DecryptPathStructureOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn parsed_header(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
    > {
        &self.parsed_header
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn plaintext_structure(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    > {
        &self.plaintext_structure
    }
}
impl DecryptPathStructureOutput {
    /// Creates a new builder-style object to manufacture [`DecryptPathStructureOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::DecryptPathStructureOutput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::builders::DecryptPathStructureOutputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::builders::DecryptPathStructureOutputBuilder::default()
    }
}

/// A builder for [`DecryptPathStructureOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::DecryptPathStructureOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct DecryptPathStructureOutputBuilder {
    pub(crate) parsed_header: ::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
    >,
    pub(crate) plaintext_structure: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    >,
}
impl DecryptPathStructureOutputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn parsed_header(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
        >,
    ) -> Self {
        self.parsed_header = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_parsed_header(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
        >,
    ) -> Self {
        self.parsed_header = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_parsed_header(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::ParsedHeader,
    > {
        &self.parsed_header
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn plaintext_structure(
        mut self,
        input: impl ::std::convert::Into<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem>>,
    ) -> Self {
        self.plaintext_structure = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_plaintext_structure(
        mut self,
        input: ::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem>>,
    ) -> Self {
        self.plaintext_structure = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_plaintext_structure(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    > {
        &self.plaintext_structure
    }
    /// Consumes the builder and constructs a [`DecryptPathStructureOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::DecryptPathStructureOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::DecryptPathStructureOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::DecryptPathStructureOutput {
            parsed_header: self.parsed_header,
plaintext_structure: self.plaintext_structure,
        })
    }
}
