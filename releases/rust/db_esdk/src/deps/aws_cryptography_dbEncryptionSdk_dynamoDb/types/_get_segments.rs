// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct GetSegments {
    #[allow(missing_docs)] // documentation missing in model
    pub high: ::std::option::Option<::std::primitive::i32>,
    #[allow(missing_docs)] // documentation missing in model
    pub low: ::std::option::Option<::std::primitive::i32>,
    #[allow(missing_docs)] // documentation missing in model
    pub split: ::std::option::Option<::std::string::String>,
}
impl GetSegments {
    #[allow(missing_docs)] // documentation missing in model
    pub fn high(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.high
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn low(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.low
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn split(&self) -> &::std::option::Option<::std::string::String> {
        &self.split
    }
}
impl GetSegments {
    /// Creates a new builder-style object to manufacture [`GetSegments`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegments).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetSegmentsBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetSegmentsBuilder::default()
    }
}

/// A builder for [`GetSegments`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegments).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetSegmentsBuilder {
    pub(crate) high: ::std::option::Option<::std::primitive::i32>,
    pub(crate) low: ::std::option::Option<::std::primitive::i32>,
    pub(crate) split: ::std::option::Option<::std::string::String>,
}
impl GetSegmentsBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn high(mut self, input: impl ::std::convert::Into<::std::primitive::i32>) -> Self {
        self.high = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_high(mut self, input: ::std::option::Option<::std::primitive::i32>) -> Self {
        self.high = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_high(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.high
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn low(mut self, input: impl ::std::convert::Into<::std::primitive::i32>) -> Self {
        self.low = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_low(mut self, input: ::std::option::Option<::std::primitive::i32>) -> Self {
        self.low = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_low(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.low
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn split(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.split = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_split(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.split = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_split(&self) -> &::std::option::Option<::std::string::String> {
        &self.split
    }
    /// Consumes the builder and constructs a [`GetSegments`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegments).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegments,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegments {
                high: self.high,
                low: self.low,
                split: self.split,
            },
        )
    }
}
