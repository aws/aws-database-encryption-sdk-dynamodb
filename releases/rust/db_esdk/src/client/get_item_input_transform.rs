// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`GetItemInputTransform`](crate::operation::get_item_input_transform::builders::GetItemInputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`sdk_input(impl Into<Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>>)`](crate::operation::get_item_input_transform::builders::GetItemInputTransformFluentBuilder::sdk_input) / [`set_sdk_input(Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>)`](crate::operation::get_item_input_transform::builders::GetItemInputTransformFluentBuilder::set_sdk_input): (undocumented)<br>
    /// - On success, responds with [`GetItemInputTransformOutput`](crate::operation::get_item_input_transform::GetItemInputTransformOutput) with field(s):
    ///   - [`transformed_input(Option<aws_sdk_dynamodb::operation::get_item::GetItemInput>)`](crate::operation::get_item_input_transform::GetItemInputTransformOutput::transformed_input): (undocumented)
    /// - On failure, responds with [`SdkError<GetItemInputTransformError>`](crate::operation::get_item_input_transform::GetItemInputTransformError)
    pub fn get_item_input_transform(
        &self,
    ) -> crate::operation::get_item_input_transform::builders::GetItemInputTransformFluentBuilder
    {
        crate::operation::get_item_input_transform::builders::GetItemInputTransformFluentBuilder::new(self.clone())
    }
}
