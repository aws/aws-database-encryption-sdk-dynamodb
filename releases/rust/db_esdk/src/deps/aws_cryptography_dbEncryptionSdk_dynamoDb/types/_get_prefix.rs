// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct GetPrefix {
    #[allow(missing_docs)] // documentation missing in model
    pub length: ::std::option::Option<::std::primitive::i32>,
}
impl GetPrefix {
    #[allow(missing_docs)] // documentation missing in model
    pub fn length(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.length
    }
}
impl GetPrefix {
    /// Creates a new builder-style object to manufacture [`GetPrefix`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPrefix).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetPrefixBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetPrefixBuilder::default()
    }
}

/// A builder for [`GetPrefix`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPrefix).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetPrefixBuilder {
    pub(crate) length: ::std::option::Option<::std::primitive::i32>,
}
impl GetPrefixBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn length(mut self, input: impl ::std::convert::Into<::std::primitive::i32>) -> Self {
        self.length = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_length(mut self, input: ::std::option::Option<::std::primitive::i32>) -> Self {
        self.length = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_length(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.length
    }
    /// Consumes the builder and constructs a [`GetPrefix`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPrefix).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPrefix,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPrefix {
                length: self.length,
            },
        )
    }
}