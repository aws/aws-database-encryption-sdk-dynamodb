// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::_get_partition_number_output::GetPartitionNumberOutputBuilder;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::_get_partition_number_input::GetPartitionNumberInputBuilder;

impl GetPartitionNumberInputBuilder {
    /// Sends a request with this input using the given client.
    pub async fn send_with(
        self,
        partition_selector: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::partition_selector::PartitionSelectorRef,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumberOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error,
    >{
        let mut fluent_builder = partition_selector.get_partition_number();
        fluent_builder.inner = self;
        fluent_builder.send().await
    }
}
/// Fluent builder constructing a request to `GetPartitionNumber`.
///
#[derive(::std::clone::Clone, ::std::fmt::Debug)]
pub struct GetPartitionNumberFluentBuilder {
    partition_selector: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::partition_selector::PartitionSelectorRef,
    pub(crate) inner: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::builders::GetPartitionNumberInputBuilder,
}
impl GetPartitionNumberFluentBuilder {
    /// Creates a new `GetPartitionNumber`.
    pub(crate) fn new(
        partition_selector: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::partition_selector::PartitionSelectorRef,
    ) -> Self {
        Self {
            partition_selector,
            inner: ::std::default::Default::default(),
        }
    }
    /// Access the GetPartitionNumber as a reference.
    pub fn as_input(&self) -> &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::builders::GetPartitionNumberInputBuilder{
        &self.inner
    }
    /// Sends the request and returns the response.
    pub async fn send(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumberOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error,
    >{
        let input = self
            .inner
            .build()
            // Using Opaque since we don't have a validation-specific error yet.
            // Operations' models don't declare their own validation error,
            // and smithy-rs seems to not generate a ValidationError case unless there is.
            // Vanilla smithy-rs uses SdkError::construction_failure, but we aren't using SdkError.
            .map_err(|mut e| {
	     let msg = format!("{:?}", e);
             crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error::OpaqueWithText {
                obj: ::dafny_runtime::Object::from_ref(&mut e as &mut ::dafny_runtime::DynAny),
		objMessage: msg
             }})?;
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumber::send(&self.partition_selector, input).await
    }

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
        self.inner = self.inner.item(input.into());
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
        self.inner = self.inner.set_item(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        self.inner.get_item()
    }
    #[allow(missing_docs)]
    pub fn logical_table_name(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.inner = self.inner.logical_table_name(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_logical_table_name(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.inner = self.inner.set_logical_table_name(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_logical_table_name(&self) -> &::std::option::Option<::std::string::String> {
        self.inner.get_logical_table_name()
    }
    #[allow(missing_docs)]
    pub fn number_of_partitions(
        mut self,
        input: impl ::std::convert::Into<::std::primitive::i32>,
    ) -> Self {
        self.inner = self.inner.number_of_partitions(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_number_of_partitions(
        mut self,
        input: ::std::option::Option<::std::primitive::i32>,
    ) -> Self {
        self.inner = self.inner.set_number_of_partitions(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_number_of_partitions(&self) -> &::std::option::Option<::std::primitive::i32> {
        self.inner.get_number_of_partitions()
    }
}
