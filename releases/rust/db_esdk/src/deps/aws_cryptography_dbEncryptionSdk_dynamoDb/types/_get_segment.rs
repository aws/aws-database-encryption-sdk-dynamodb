// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// The Virtual Part Transformation that splits a string and gets a particular segment of that split.
pub struct GetSegment {
    /// The index of the split string result to return. 0 represents the segment before the first split character. -1 respresents the segment after the last split character.
    pub index: ::std::option::Option<::std::primitive::i32>,
    /// The characters to split on.
    pub split: ::std::option::Option<::std::string::String>,
}
impl GetSegment {
    /// The index of the split string result to return. 0 represents the segment before the first split character. -1 respresents the segment after the last split character.
    pub fn index(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.index
    }
    /// The characters to split on.
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
    /// The index of the split string result to return. 0 represents the segment before the first split character. -1 respresents the segment after the last split character.
    pub fn index(mut self, input: impl ::std::convert::Into<::std::primitive::i32>) -> Self {
        self.index = ::std::option::Option::Some(input.into());
        self
    }
    /// The index of the split string result to return. 0 represents the segment before the first split character. -1 respresents the segment after the last split character.
    pub fn set_index(mut self, input: ::std::option::Option<::std::primitive::i32>) -> Self {
        self.index = input;
        self
    }
    /// The index of the split string result to return. 0 represents the segment before the first split character. -1 respresents the segment after the last split character.
    pub fn get_index(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.index
    }
    /// The characters to split on.
    pub fn split(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.split = ::std::option::Option::Some(input.into());
        self
    }
    /// The characters to split on.
    pub fn set_split(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.split = input;
        self
    }
    /// The characters to split on.
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
