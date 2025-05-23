// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`GetItemOutputTransform`](crate::operation::get_item_output_transform::builders::GetItemOutputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`original_input(impl Into<Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>>)`](crate::operation::get_item_output_transform::builders::GetItemOutputTransformFluentBuilder::original_input) / [`set_original_input(Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>)`](crate::operation::get_item_output_transform::builders::GetItemOutputTransformFluentBuilder::set_original_input): (undocumented)<br>
    ///   - [`sdk_output(impl Into<Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput>>)`](crate::operation::get_item_output_transform::builders::GetItemOutputTransformFluentBuilder::sdk_output) / [`set_sdk_output(Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput>)`](crate::operation::get_item_output_transform::builders::GetItemOutputTransformFluentBuilder::set_sdk_output): (undocumented)<br>
    /// - On success, responds with [`GetItemOutputTransformOutput`](crate::operation::get_item_output_transform::GetItemOutputTransformOutput) with field(s):
    ///   - [`transformed_output(Option<aws_sdk_dynamodb::operation::get_item::GetItemOutput>)`](crate::operation::get_item_output_transform::GetItemOutputTransformOutput::transformed_output): (undocumented)
    /// - On failure, responds with [`SdkError<GetItemOutputTransformError>`](crate::operation::get_item_output_transform::GetItemOutputTransformError)
    pub fn get_item_output_transform(
        &self,
    ) -> crate::operation::get_item_output_transform::builders::GetItemOutputTransformFluentBuilder
    {
        crate::operation::get_item_output_transform::builders::GetItemOutputTransformFluentBuilder::new(self.clone())
    }
}
