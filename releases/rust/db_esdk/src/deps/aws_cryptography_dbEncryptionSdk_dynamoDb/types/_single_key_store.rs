// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct SingleKeyStore {
    #[allow(missing_docs)] // documentation missing in model
    pub cache_ttl: ::std::option::Option<::std::primitive::i32>,
    #[allow(missing_docs)] // documentation missing in model
    pub key_id: ::std::option::Option<::std::string::String>,
}
impl SingleKeyStore {
    #[allow(missing_docs)] // documentation missing in model
    pub fn cache_ttl(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.cache_ttl
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn key_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.key_id
    }
}
impl SingleKeyStore {
    /// Creates a new builder-style object to manufacture [`SingleKeyStore`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SingleKeyStore).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::SingleKeyStoreBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::SingleKeyStoreBuilder::default()
    }
}

/// A builder for [`SingleKeyStore`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SingleKeyStore).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct SingleKeyStoreBuilder {
    pub(crate) cache_ttl: ::std::option::Option<::std::primitive::i32>,
    pub(crate) key_id: ::std::option::Option<::std::string::String>,
}
impl SingleKeyStoreBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn cache_ttl(mut self, input: impl ::std::convert::Into<::std::primitive::i32>) -> Self {
        self.cache_ttl = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_cache_ttl(mut self, input: ::std::option::Option<::std::primitive::i32>) -> Self {
        self.cache_ttl = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_cache_ttl(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.cache_ttl
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn key_id(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.key_id = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_key_id(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.key_id = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_key_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.key_id
    }
    /// Consumes the builder and constructs a [`SingleKeyStore`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SingleKeyStore).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SingleKeyStore,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SingleKeyStore {
                cache_ttl: self.cache_ttl,
                key_id: self.key_id,
            },
        )
    }
}
