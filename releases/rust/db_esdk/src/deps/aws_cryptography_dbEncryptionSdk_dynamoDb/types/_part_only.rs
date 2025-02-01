// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// Attribute must be used as part of a Compound Beacon, never alone.
pub struct PartOnly {}
impl PartOnly {}
impl PartOnly {
    /// Creates a new builder-style object to manufacture [`PartOnly`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PartOnly).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::PartOnlyBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::PartOnlyBuilder::default()
    }
}

/// A builder for [`PartOnly`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PartOnly).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct PartOnlyBuilder {}
impl PartOnlyBuilder {
    /// Consumes the builder and constructs a [`PartOnly`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PartOnly).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PartOnly,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PartOnly {},
        )
    }
}
