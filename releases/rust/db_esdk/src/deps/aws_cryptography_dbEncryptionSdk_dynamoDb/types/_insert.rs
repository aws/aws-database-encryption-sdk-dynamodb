// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct Insert {
    #[allow(missing_docs)] // documentation missing in model
    pub literal: ::std::option::Option<::std::string::String>,
}
impl Insert {
    #[allow(missing_docs)] // documentation missing in model
    pub fn literal(&self) -> &::std::option::Option<::std::string::String> {
        &self.literal
    }
}
impl Insert {
    /// Creates a new builder-style object to manufacture [`Insert`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Insert).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::InsertBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::InsertBuilder::default()
    }
}

/// A builder for [`Insert`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Insert).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct InsertBuilder {
    pub(crate) literal: ::std::option::Option<::std::string::String>,
}
impl InsertBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn literal(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.literal = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_literal(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.literal = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_literal(&self) -> &::std::option::Option<::std::string::String> {
        &self.literal
    }
    /// Consumes the builder and constructs a [`Insert`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Insert).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Insert,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Insert {
                literal: self.literal,
            },
        )
    }
}
