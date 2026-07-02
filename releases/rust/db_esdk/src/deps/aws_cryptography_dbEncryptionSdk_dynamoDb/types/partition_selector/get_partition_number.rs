// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::partition_selector::PartitionSelectorRef {
    /// Constructs a fluent builder for the [`GetPartitionNumber`](crate::operation::get_partition_number::builders::GetPartitionNumberFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`item(impl Into<Option<::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>>>)`](crate::operation::get_partition_number::builders::GetPartitionNumberFluentBuilder::item) / [`set_item(Option<::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>>)`](crate::operation::get_partition_number::builders::GetPartitionNumberFluentBuilder::set_item): (undocumented)<br>
    ///   - [`logical_table_name(impl Into<Option<::std::string::String>>)`](crate::operation::get_partition_number::builders::GetPartitionNumberFluentBuilder::logical_table_name) / [`set_logical_table_name(Option<::std::string::String>)`](crate::operation::get_partition_number::builders::GetPartitionNumberFluentBuilder::set_logical_table_name): (undocumented)<br>
    ///   - [`number_of_partitions(impl Into<Option<::std::primitive::i32>>)`](crate::operation::get_partition_number::builders::GetPartitionNumberFluentBuilder::number_of_partitions) / [`set_number_of_partitions(Option<::std::primitive::i32>)`](crate::operation::get_partition_number::builders::GetPartitionNumberFluentBuilder::set_number_of_partitions): (undocumented)<br>
    /// - On success, responds with [`GetPartitionNumberOutput`](crate::operation::get_partition_number::GetPartitionNumberOutput) with field(s):
    ///   - [`partition_number(Option<::std::primitive::i32>)`](crate::operation::get_partition_number::GetPartitionNumberOutput::partition_number): (undocumented)
    /// - On failure, responds with [`SdkError<GetPartitionNumberError>`](crate::operation::get_partition_number::GetPartitionNumberError)
    pub fn get_partition_number(&self) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::builders::GetPartitionNumberFluentBuilder {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::builders::GetPartitionNumberFluentBuilder::new(self.clone())
    }
}
