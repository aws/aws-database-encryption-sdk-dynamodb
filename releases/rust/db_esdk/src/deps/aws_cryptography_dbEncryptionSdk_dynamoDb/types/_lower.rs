// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// The Virtual Part Transformation that converts ASCII characters to lower case.
pub struct Lower {}
impl Lower {}
impl Lower {
    /// Creates a new builder-style object to manufacture [`Lower`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Lower).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::LowerBuilder {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::LowerBuilder::default()
    }
}

/// A builder for [`Lower`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Lower).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct LowerBuilder {}
impl LowerBuilder {
    /// Consumes the builder and constructs a [`Lower`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Lower).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Lower,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Lower {},
        )
    }
}
