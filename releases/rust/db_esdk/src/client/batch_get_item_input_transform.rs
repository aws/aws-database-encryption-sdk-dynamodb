// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`BatchGetItemInputTransform`](crate::operation::batch_get_item_input_transform::builders::BatchGetItemInputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`sdk_input(impl Into<Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>>)`](crate::operation::batch_get_item_input_transform::builders::BatchGetItemInputTransformFluentBuilder::sdk_input) / [`set_sdk_input(Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>)`](crate::operation::batch_get_item_input_transform::builders::BatchGetItemInputTransformFluentBuilder::set_sdk_input): (undocumented)<br>
    /// - On success, responds with [`BatchGetItemInputTransformOutput`](crate::operation::batch_get_item_input_transform::BatchGetItemInputTransformOutput) with field(s):
    ///   - [`transformed_input(Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>)`](crate::operation::batch_get_item_input_transform::BatchGetItemInputTransformOutput::transformed_input): (undocumented)
    /// - On failure, responds with [`SdkError<BatchGetItemInputTransformError>`](crate::operation::batch_get_item_input_transform::BatchGetItemInputTransformError)
    pub fn batch_get_item_input_transform(&self) -> crate::operation::batch_get_item_input_transform::builders::BatchGetItemInputTransformFluentBuilder{
        crate::operation::batch_get_item_input_transform::builders::BatchGetItemInputTransformFluentBuilder::new(self.clone())
    }
}
