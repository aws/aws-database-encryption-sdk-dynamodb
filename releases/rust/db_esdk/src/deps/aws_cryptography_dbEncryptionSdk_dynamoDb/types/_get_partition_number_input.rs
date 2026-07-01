// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct GetPartitionNumberInput {
    #[allow(missing_docs)]
    pub item: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
    #[allow(missing_docs)]
    pub logical_table_name: ::std::option::Option<::std::string::String>,
    #[allow(missing_docs)]
    pub number_of_partitions: ::std::option::Option<::std::primitive::i32>,
}
impl GetPartitionNumberInput {
    #[allow(missing_docs)]
    pub fn item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.item
    }
    #[allow(missing_docs)]
    pub fn logical_table_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.logical_table_name
    }
    #[allow(missing_docs)]
    pub fn number_of_partitions(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.number_of_partitions
    }
}
impl GetPartitionNumberInput {
    /// Creates a new builder-style object to manufacture [`GetPartitionNumberInput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPartitionNumberInput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetPartitionNumberInputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetPartitionNumberInputBuilder::default()
    }
}

/// A builder for [`GetPartitionNumberInput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPartitionNumberInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetPartitionNumberInputBuilder {
    pub(crate) item: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
    pub(crate) logical_table_name: ::std::option::Option<::std::string::String>,
    pub(crate) number_of_partitions: ::std::option::Option<::std::primitive::i32>,
}
impl GetPartitionNumberInputBuilder {
    #[allow(missing_docs)]
    pub fn item(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.item = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_item(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.item = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.item
    }
    #[allow(missing_docs)]
    pub fn logical_table_name(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.logical_table_name = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_logical_table_name(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.logical_table_name = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_logical_table_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.logical_table_name
    }
    #[allow(missing_docs)]
    pub fn number_of_partitions(
        mut self,
        input: impl ::std::convert::Into<::std::primitive::i32>,
    ) -> Self {
        self.number_of_partitions = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_number_of_partitions(
        mut self,
        input: ::std::option::Option<::std::primitive::i32>,
    ) -> Self {
        self.number_of_partitions = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_number_of_partitions(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.number_of_partitions
    }
    /// Consumes the builder and constructs a [`GetPartitionNumberInput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPartitionNumberInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPartitionNumberInput,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPartitionNumberInput {
            item: self.item,
logical_table_name: self.logical_table_name,
number_of_partitions: self.number_of_partitions,
        })
    }
}
