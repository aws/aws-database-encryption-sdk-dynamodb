// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct SearchConfig {
    #[allow(missing_docs)] // documentation missing in model
    pub versions: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
        >,
    >,
    #[allow(missing_docs)] // documentation missing in model
    pub write_version: ::std::option::Option<::std::primitive::i32>,
}
impl SearchConfig {
    #[allow(missing_docs)] // documentation missing in model
    pub fn versions(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
        >,
    > {
        &self.versions
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn write_version(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.write_version
    }
}
impl SearchConfig {
    /// Creates a new builder-style object to manufacture [`SearchConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::SearchConfigBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::SearchConfigBuilder::default()
    }
}

/// A builder for [`SearchConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct SearchConfigBuilder {
    pub(crate) versions: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
        >,
    >,
    pub(crate) write_version: ::std::option::Option<::std::primitive::i32>,
}
impl SearchConfigBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn versions(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
            >,
        >,
    ) -> Self {
        self.versions = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_versions(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
            >,
        >,
    ) -> Self {
        self.versions = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_versions(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
        >,
    > {
        &self.versions
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn write_version(
        mut self,
        input: impl ::std::convert::Into<::std::primitive::i32>,
    ) -> Self {
        self.write_version = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_write_version(
        mut self,
        input: ::std::option::Option<::std::primitive::i32>,
    ) -> Self {
        self.write_version = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_write_version(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.write_version
    }
    /// Consumes the builder and constructs a [`SearchConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SearchConfig {
                versions: self.versions,
                write_version: self.write_version,
            },
        )
    }
}
