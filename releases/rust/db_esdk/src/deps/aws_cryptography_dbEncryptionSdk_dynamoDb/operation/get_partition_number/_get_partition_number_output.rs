// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct GetPartitionNumberOutput {
    #[allow(missing_docs)]
    pub partition_number: ::std::option::Option<::std::primitive::i32>,
}
impl GetPartitionNumberOutput {
    #[allow(missing_docs)]
    pub fn partition_number(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.partition_number
    }
}
impl GetPartitionNumberOutput {
    /// Creates a new builder-style object to manufacture [`GetPartitionNumberOutput`](crate::operation::get_partition_number::builders::GetPartitionNumberOutput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::builders::GetPartitionNumberOutputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::builders::GetPartitionNumberOutputBuilder::default()
    }
}

/// A builder for [`GetPartitionNumberOutput`](crate::operation::operation::GetPartitionNumberOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetPartitionNumberOutputBuilder {
    pub(crate) partition_number: ::std::option::Option<::std::primitive::i32>,
}
impl GetPartitionNumberOutputBuilder {
    #[allow(missing_docs)]
    pub fn partition_number(
        mut self,
        input: impl ::std::convert::Into<::std::primitive::i32>,
    ) -> Self {
        self.partition_number = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_partition_number(
        mut self,
        input: ::std::option::Option<::std::primitive::i32>,
    ) -> Self {
        self.partition_number = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_partition_number(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.partition_number
    }
    /// Consumes the builder and constructs a [`GetPartitionNumberOutput`](crate::operation::operation::GetPartitionNumberOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumberOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumberOutput {
            partition_number: self.partition_number,
        })
    }
}
