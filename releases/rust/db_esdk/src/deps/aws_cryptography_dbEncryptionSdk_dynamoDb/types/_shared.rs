// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// This beacon should calculate values like another beacon, so they can be compared.
pub struct Shared {
    /// Calculate beacon values as for this beacon.
    pub other: ::std::option::Option<::std::string::String>,
}
impl Shared {
    /// Calculate beacon values as for this beacon.
    pub fn other(&self) -> &::std::option::Option<::std::string::String> {
        &self.other
    }
}
impl Shared {
    /// Creates a new builder-style object to manufacture [`Shared`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Shared).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::SharedBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::SharedBuilder::default()
    }
}

/// A builder for [`Shared`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Shared).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct SharedBuilder {
    pub(crate) other: ::std::option::Option<::std::string::String>,
}
impl SharedBuilder {
    /// Calculate beacon values as for this beacon.
    pub fn other(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.other = ::std::option::Option::Some(input.into());
        self
    }
    /// Calculate beacon values as for this beacon.
    pub fn set_other(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.other = input;
        self
    }
    /// Calculate beacon values as for this beacon.
    pub fn get_other(&self) -> &::std::option::Option<::std::string::String> {
        &self.other
    }
    /// Consumes the builder and constructs a [`Shared`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Shared).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Shared,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Shared {
                other: self.other,
            },
        )
    }
}
