// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct GetSubstring {
    #[allow(missing_docs)] // documentation missing in model
    pub high: ::std::option::Option<::std::primitive::i32>,
    #[allow(missing_docs)] // documentation missing in model
    pub low: ::std::option::Option<::std::primitive::i32>,
}
impl GetSubstring {
    #[allow(missing_docs)] // documentation missing in model
    pub fn high(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.high
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn low(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.low
    }
}
impl GetSubstring {
    /// Creates a new builder-style object to manufacture [`GetSubstring`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSubstring).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetSubstringBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetSubstringBuilder::default()
    }
}

/// A builder for [`GetSubstring`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSubstring).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetSubstringBuilder {
    pub(crate) high: ::std::option::Option<::std::primitive::i32>,
    pub(crate) low: ::std::option::Option<::std::primitive::i32>,
}
impl GetSubstringBuilder {
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
    /// Consumes the builder and constructs a [`GetSubstring`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSubstring).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSubstring,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSubstring {
                high: self.high,
                low: self.low,
            },
        )
    }
}
