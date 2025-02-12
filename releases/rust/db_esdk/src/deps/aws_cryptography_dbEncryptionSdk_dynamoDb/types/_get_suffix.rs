// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// The Virtual Part Transformation that gets the suffix of a string.
pub struct GetSuffix {
    /// If positive, the number of characters to return from the end. If negative, the absolute number of characters to exclude from the front. e.g. GetSuffix(-1) returns all but the first character.
    pub length: ::std::option::Option<::std::primitive::i32>,
}
impl GetSuffix {
    /// If positive, the number of characters to return from the end. If negative, the absolute number of characters to exclude from the front. e.g. GetSuffix(-1) returns all but the first character.
    pub fn length(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.length
    }
}
impl GetSuffix {
    /// Creates a new builder-style object to manufacture [`GetSuffix`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSuffix).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetSuffixBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetSuffixBuilder::default()
    }
}

/// A builder for [`GetSuffix`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSuffix).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetSuffixBuilder {
    pub(crate) length: ::std::option::Option<::std::primitive::i32>,
}
impl GetSuffixBuilder {
    /// If positive, the number of characters to return from the end. If negative, the absolute number of characters to exclude from the front. e.g. GetSuffix(-1) returns all but the first character.
    pub fn length(mut self, input: impl ::std::convert::Into<::std::primitive::i32>) -> Self {
        self.length = ::std::option::Option::Some(input.into());
        self
    }
    /// If positive, the number of characters to return from the end. If negative, the absolute number of characters to exclude from the front. e.g. GetSuffix(-1) returns all but the first character.
    pub fn set_length(mut self, input: ::std::option::Option<::std::primitive::i32>) -> Self {
        self.length = input;
        self
    }
    /// If positive, the number of characters to return from the end. If negative, the absolute number of characters to exclude from the front. e.g. GetSuffix(-1) returns all but the first character.
    pub fn get_length(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.length
    }
    /// Consumes the builder and constructs a [`GetSuffix`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSuffix).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSuffix,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSuffix {
                length: self.length,
            },
        )
    }
}
