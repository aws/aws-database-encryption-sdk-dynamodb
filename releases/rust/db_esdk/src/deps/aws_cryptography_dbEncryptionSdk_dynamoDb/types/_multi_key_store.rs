// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct MultiKeyStore {
    #[allow(missing_docs)] // documentation missing in model
    pub cache:
        ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::CacheType>,
    #[allow(missing_docs)] // documentation missing in model
    pub cache_ttl: ::std::option::Option<::std::primitive::i32>,
    #[allow(missing_docs)] // documentation missing in model
    pub key_field_name: ::std::option::Option<::std::string::String>,
}
impl MultiKeyStore {
    #[allow(missing_docs)] // documentation missing in model
    pub fn cache(
        &self,
    ) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::CacheType>
    {
        &self.cache
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn cache_ttl(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.cache_ttl
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn key_field_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.key_field_name
    }
}
impl MultiKeyStore {
    /// Creates a new builder-style object to manufacture [`MultiKeyStore`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::MultiKeyStore).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::MultiKeyStoreBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::MultiKeyStoreBuilder::default()
    }
}

/// A builder for [`MultiKeyStore`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::MultiKeyStore).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct MultiKeyStoreBuilder {
    pub(crate) cache:
        ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::CacheType>,
    pub(crate) cache_ttl: ::std::option::Option<::std::primitive::i32>,
    pub(crate) key_field_name: ::std::option::Option<::std::string::String>,
}
impl MultiKeyStoreBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn cache(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_materialProviders::types::CacheType,
        >,
    ) -> Self {
        self.cache = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_cache(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_materialProviders::types::CacheType,
        >,
    ) -> Self {
        self.cache = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_cache(
        &self,
    ) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::CacheType>
    {
        &self.cache
    }
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
    pub fn key_field_name(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.key_field_name = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_key_field_name(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.key_field_name = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_key_field_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.key_field_name
    }
    /// Consumes the builder and constructs a [`MultiKeyStore`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::MultiKeyStore).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::MultiKeyStore,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::MultiKeyStore {
                cache: self.cache,
                cache_ttl: self.cache_ttl,
                key_field_name: self.key_field_name,
            },
        )
    }
}