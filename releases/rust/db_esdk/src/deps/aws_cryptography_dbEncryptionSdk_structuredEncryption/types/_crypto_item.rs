// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct CryptoItem {
    #[allow(missing_docs)]
pub action: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>,
#[allow(missing_docs)]
pub data: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>,
#[allow(missing_docs)]
pub key: ::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment>>,
}
impl CryptoItem {
    #[allow(missing_docs)]
    pub fn action(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
    > {
        &self.action
    }
    #[allow(missing_docs)]
    pub fn data(&self) -> &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>{
        &self.data
    }
    #[allow(missing_docs)]
    pub fn key(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment,
        >,
    > {
        &self.key
    }
}
impl CryptoItem {
    /// Creates a new builder-style object to manufacture [`CryptoItem`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::builders::CryptoItemBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::builders::CryptoItemBuilder::default()
    }
}

/// A builder for [`CryptoItem`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct CryptoItemBuilder {
    pub(crate) action: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>,
pub(crate) data: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>,
pub(crate) key: ::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment>>,
}
impl CryptoItemBuilder {
    #[allow(missing_docs)]
    pub fn action(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    ) -> Self {
        self.action = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_action(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    ) -> Self {
        self.action = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_action(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
    > {
        &self.action
    }
    #[allow(missing_docs)]
    pub fn data(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>,
    ) -> Self {
        self.data = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_data(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>,
    ) -> Self {
        self.data = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_data(&self) -> &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal>{
        &self.data
    }
    #[allow(missing_docs)]
    pub fn key(
        mut self,
        input: impl ::std::convert::Into<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment>>,
    ) -> Self {
        self.key = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_key(
        mut self,
        input: ::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment>>,
    ) -> Self {
        self.key = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_key(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment,
        >,
    > {
        &self.key
    }
    /// Consumes the builder and constructs a [`CryptoItem`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem {
                action: self.action,
                data: self.data,
                key: self.key,
            },
        )
    }
}
