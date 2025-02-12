// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// The configuration for using multiple Beacon Keys.
pub struct MultiKeyStore {
    /// Which type of local cache to use.
    pub cache:
        ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::CacheType>,
    /// How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
    pub cache_ttl: ::std::option::Option<::std::primitive::i32>,
    /// The name of the field that stores the Beacon Key. This may be a Virtual Field.
    pub key_field_name: ::std::option::Option<::std::string::String>,
    /// Partition ID to distinguish Beacon Key Sources writing to a Shared cache. If the Partition ID is the same for two Beacon Key Sources, they can share the same cache entries in the Shared cache.
    pub partition_id: ::std::option::Option<::std::string::String>,
}
impl MultiKeyStore {
    /// Which type of local cache to use.
    pub fn cache(
        &self,
    ) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::CacheType>
    {
        &self.cache
    }
    /// How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
    pub fn cache_ttl(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.cache_ttl
    }
    /// The name of the field that stores the Beacon Key. This may be a Virtual Field.
    pub fn key_field_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.key_field_name
    }
    /// Partition ID to distinguish Beacon Key Sources writing to a Shared cache. If the Partition ID is the same for two Beacon Key Sources, they can share the same cache entries in the Shared cache.
    pub fn partition_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.partition_id
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
    pub(crate) partition_id: ::std::option::Option<::std::string::String>,
}
impl MultiKeyStoreBuilder {
    /// Which type of local cache to use.
    pub fn cache(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_materialProviders::types::CacheType,
        >,
    ) -> Self {
        self.cache = ::std::option::Option::Some(input.into());
        self
    }
    /// Which type of local cache to use.
    pub fn set_cache(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_materialProviders::types::CacheType,
        >,
    ) -> Self {
        self.cache = input;
        self
    }
    /// Which type of local cache to use.
    pub fn get_cache(
        &self,
    ) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::CacheType>
    {
        &self.cache
    }
    /// How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
    pub fn cache_ttl(mut self, input: impl ::std::convert::Into<::std::primitive::i32>) -> Self {
        self.cache_ttl = ::std::option::Option::Some(input.into());
        self
    }
    /// How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
    pub fn set_cache_ttl(mut self, input: ::std::option::Option<::std::primitive::i32>) -> Self {
        self.cache_ttl = input;
        self
    }
    /// How long (in seconds) the beacon key material is cached locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
    pub fn get_cache_ttl(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.cache_ttl
    }
    /// The name of the field that stores the Beacon Key. This may be a Virtual Field.
    pub fn key_field_name(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.key_field_name = ::std::option::Option::Some(input.into());
        self
    }
    /// The name of the field that stores the Beacon Key. This may be a Virtual Field.
    pub fn set_key_field_name(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.key_field_name = input;
        self
    }
    /// The name of the field that stores the Beacon Key. This may be a Virtual Field.
    pub fn get_key_field_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.key_field_name
    }
    /// Partition ID to distinguish Beacon Key Sources writing to a Shared cache. If the Partition ID is the same for two Beacon Key Sources, they can share the same cache entries in the Shared cache.
    pub fn partition_id(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.partition_id = ::std::option::Option::Some(input.into());
        self
    }
    /// Partition ID to distinguish Beacon Key Sources writing to a Shared cache. If the Partition ID is the same for two Beacon Key Sources, they can share the same cache entries in the Shared cache.
    pub fn set_partition_id(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.partition_id = input;
        self
    }
    /// Partition ID to distinguish Beacon Key Sources writing to a Shared cache. If the Partition ID is the same for two Beacon Key Sources, they can share the same cache entries in the Shared cache.
    pub fn get_partition_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.partition_id
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
                partition_id: self.partition_id,
            },
        )
    }
}
