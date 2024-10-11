// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`BatchWriteItemOutputTransform`](crate::operation::batch_write_item_output_transform::builders::BatchWriteItemOutputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`original_input(impl Into<Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>>)`](crate::operation::batch_write_item_output_transform::builders::BatchWriteItemOutputTransformFluentBuilder::original_input) / [`set_original_input(Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemInput>)`](crate::operation::batch_write_item_output_transform::builders::BatchWriteItemOutputTransformFluentBuilder::set_original_input): (undocumented)<br>
    ///   - [`sdk_output(impl Into<Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput>>)`](crate::operation::batch_write_item_output_transform::builders::BatchWriteItemOutputTransformFluentBuilder::sdk_output) / [`set_sdk_output(Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput>)`](crate::operation::batch_write_item_output_transform::builders::BatchWriteItemOutputTransformFluentBuilder::set_sdk_output): (undocumented)<br>
    /// - On success, responds with [`BatchWriteItemOutputTransformOutput`](crate::operation::batch_write_item_output_transform::BatchWriteItemOutputTransformOutput) with field(s):
    ///   - [`transformed_output(Option<aws_sdk_dynamodb::operation::batch_write_item::BatchWriteItemOutput>)`](crate::operation::batch_write_item_output_transform::BatchWriteItemOutputTransformOutput::transformed_output): (undocumented)
    /// - On failure, responds with [`SdkError<BatchWriteItemOutputTransformError>`](crate::operation::batch_write_item_output_transform::BatchWriteItemOutputTransformError)
    pub fn batch_write_item_output_transform(&self) -> crate::operation::batch_write_item_output_transform::builders::BatchWriteItemOutputTransformFluentBuilder{
        crate::operation::batch_write_item_output_transform::builders::BatchWriteItemOutputTransformFluentBuilder::new(self.clone())
    }
}
