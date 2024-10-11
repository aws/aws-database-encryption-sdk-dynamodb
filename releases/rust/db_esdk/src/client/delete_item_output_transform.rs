// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`DeleteItemOutputTransform`](crate::operation::delete_item_output_transform::builders::DeleteItemOutputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`original_input(impl Into<Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>>)`](crate::operation::delete_item_output_transform::builders::DeleteItemOutputTransformFluentBuilder::original_input) / [`set_original_input(Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>)`](crate::operation::delete_item_output_transform::builders::DeleteItemOutputTransformFluentBuilder::set_original_input): (undocumented)<br>
    ///   - [`sdk_output(impl Into<Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput>>)`](crate::operation::delete_item_output_transform::builders::DeleteItemOutputTransformFluentBuilder::sdk_output) / [`set_sdk_output(Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput>)`](crate::operation::delete_item_output_transform::builders::DeleteItemOutputTransformFluentBuilder::set_sdk_output): (undocumented)<br>
    /// - On success, responds with [`DeleteItemOutputTransformOutput`](crate::operation::delete_item_output_transform::DeleteItemOutputTransformOutput) with field(s):
    ///   - [`transformed_output(Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemOutput>)`](crate::operation::delete_item_output_transform::DeleteItemOutputTransformOutput::transformed_output): (undocumented)
    /// - On failure, responds with [`SdkError<DeleteItemOutputTransformError>`](crate::operation::delete_item_output_transform::DeleteItemOutputTransformError)
    pub fn delete_item_output_transform(&self) -> crate::operation::delete_item_output_transform::builders::DeleteItemOutputTransformFluentBuilder{
        crate::operation::delete_item_output_transform::builders::DeleteItemOutputTransformFluentBuilder::new(self.clone())
    }
}
