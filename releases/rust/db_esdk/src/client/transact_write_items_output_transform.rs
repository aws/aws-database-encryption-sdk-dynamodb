// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`TransactWriteItemsOutputTransform`](crate::operation::transact_write_items_output_transform::builders::TransactWriteItemsOutputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`original_input(impl Into<Option<aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput>>)`](crate::operation::transact_write_items_output_transform::builders::TransactWriteItemsOutputTransformFluentBuilder::original_input) / [`set_original_input(Option<aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput>)`](crate::operation::transact_write_items_output_transform::builders::TransactWriteItemsOutputTransformFluentBuilder::set_original_input): (undocumented)<br>
    ///   - [`sdk_output(impl Into<Option<aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput>>)`](crate::operation::transact_write_items_output_transform::builders::TransactWriteItemsOutputTransformFluentBuilder::sdk_output) / [`set_sdk_output(Option<aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput>)`](crate::operation::transact_write_items_output_transform::builders::TransactWriteItemsOutputTransformFluentBuilder::set_sdk_output): (undocumented)<br>
    /// - On success, responds with [`TransactWriteItemsOutputTransformOutput`](crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformOutput) with field(s):
    ///   - [`transformed_output(Option<aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsOutput>)`](crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformOutput::transformed_output): (undocumented)
    /// - On failure, responds with [`SdkError<TransactWriteItemsOutputTransformError>`](crate::operation::transact_write_items_output_transform::TransactWriteItemsOutputTransformError)
    pub fn transact_write_items_output_transform(&self) -> crate::operation::transact_write_items_output_transform::builders::TransactWriteItemsOutputTransformFluentBuilder{
        crate::operation::transact_write_items_output_transform::builders::TransactWriteItemsOutputTransformFluentBuilder::new(self.clone())
    }
}
