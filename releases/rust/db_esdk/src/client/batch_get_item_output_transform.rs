// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`BatchGetItemOutputTransform`](crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`original_input(impl Into<Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>>)`](crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformFluentBuilder::original_input) / [`set_original_input(Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>)`](crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformFluentBuilder::set_original_input): (undocumented)<br>
    ///   - [`sdk_output(impl Into<Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>>)`](crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformFluentBuilder::sdk_output) / [`set_sdk_output(Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>)`](crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformFluentBuilder::set_sdk_output): (undocumented)<br>
    /// - On success, responds with [`BatchGetItemOutputTransformOutput`](crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformOutput) with field(s):
    ///   - [`transformed_output(Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>)`](crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformOutput::transformed_output): (undocumented)
    /// - On failure, responds with [`SdkError<BatchGetItemOutputTransformError>`](crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformError)
    pub fn batch_get_item_output_transform(&self) -> crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformFluentBuilder{
        crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformFluentBuilder::new(self.clone())
    }
}
