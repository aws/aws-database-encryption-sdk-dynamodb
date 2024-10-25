// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct ResolveAuthActionsOutput {
    #[allow(missing_docs)]
    pub crypto_actions: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    >,
}
impl ResolveAuthActionsOutput {
    #[allow(missing_docs)]
    pub fn crypto_actions(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    > {
        &self.crypto_actions
    }
}
impl ResolveAuthActionsOutput {
    /// Creates a new builder-style object to manufacture [`ResolveAuthActionsOutput`](crate::operation::resolve_auth_actions::builders::ResolveAuthActionsOutput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::builders::ResolveAuthActionsOutputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::builders::ResolveAuthActionsOutputBuilder::default()
    }
}

/// A builder for [`ResolveAuthActionsOutput`](crate::operation::operation::ResolveAuthActionsOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ResolveAuthActionsOutputBuilder {
    pub(crate) crypto_actions: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    >,
}
impl ResolveAuthActionsOutputBuilder {
    #[allow(missing_docs)]
    pub fn crypto_actions(
        mut self,
        input: impl ::std::convert::Into<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem>>,
    ) -> Self {
        self.crypto_actions = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_crypto_actions(
        mut self,
        input: ::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem>>,
    ) -> Self {
        self.crypto_actions = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_crypto_actions(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoItem,
        >,
    > {
        &self.crypto_actions
    }
    /// Consumes the builder and constructs a [`ResolveAuthActionsOutput`](crate::operation::operation::ResolveAuthActionsOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::ResolveAuthActionsOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::ResolveAuthActionsOutput {
            crypto_actions: self.crypto_actions,
        })
    }
}
