// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct GetSegment {
    #[allow(missing_docs)] // documentation missing in model
    pub index: ::std::option::Option<::std::primitive::i32>,
    #[allow(missing_docs)] // documentation missing in model
    pub split: ::std::option::Option<::std::string::String>,
}
impl GetSegment {
    #[allow(missing_docs)] // documentation missing in model
    pub fn index(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.index
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn split(&self) -> &::std::option::Option<::std::string::String> {
        &self.split
    }
}
impl GetSegment {
    /// Creates a new builder-style object to manufacture [`GetSegment`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegment).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetSegmentBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetSegmentBuilder::default()
    }
}

/// A builder for [`GetSegment`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegment).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetSegmentBuilder {
    pub(crate) index: ::std::option::Option<::std::primitive::i32>,
    pub(crate) split: ::std::option::Option<::std::string::String>,
}
impl GetSegmentBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn index(mut self, input: impl ::std::convert::Into<::std::primitive::i32>) -> Self {
        self.index = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_index(mut self, input: ::std::option::Option<::std::primitive::i32>) -> Self {
        self.index = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_index(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.index
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
    /// Consumes the builder and constructs a [`GetSegment`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegment).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegment,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegment {
                index: self.index,
                split: self.split,
            },
        )
    }
}
