// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// The Virtual Part Transformation that converts ASCII characters to upper case.
pub struct Upper {}
impl Upper {}
impl Upper {
    /// Creates a new builder-style object to manufacture [`Upper`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Upper).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::UpperBuilder {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::UpperBuilder::default()
    }
}

/// A builder for [`Upper`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Upper).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct UpperBuilder {}
impl UpperBuilder {
    /// Consumes the builder and constructs a [`Upper`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Upper).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Upper,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Upper {},
        )
    }
}
