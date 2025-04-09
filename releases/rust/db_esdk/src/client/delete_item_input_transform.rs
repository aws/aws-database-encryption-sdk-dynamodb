// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`DeleteItemInputTransform`](crate::operation::delete_item_input_transform::builders::DeleteItemInputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`sdk_input(impl Into<Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>>)`](crate::operation::delete_item_input_transform::builders::DeleteItemInputTransformFluentBuilder::sdk_input) / [`set_sdk_input(Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>)`](crate::operation::delete_item_input_transform::builders::DeleteItemInputTransformFluentBuilder::set_sdk_input): (undocumented)<br>
    /// - On success, responds with [`DeleteItemInputTransformOutput`](crate::operation::delete_item_input_transform::DeleteItemInputTransformOutput) with field(s):
    ///   - [`transformed_input(Option<aws_sdk_dynamodb::operation::delete_item::DeleteItemInput>)`](crate::operation::delete_item_input_transform::DeleteItemInputTransformOutput::transformed_input): (undocumented)
    /// - On failure, responds with [`SdkError<DeleteItemInputTransformError>`](crate::operation::delete_item_input_transform::DeleteItemInputTransformError)
    pub fn delete_item_input_transform(&self) -> crate::operation::delete_item_input_transform::builders::DeleteItemInputTransformFluentBuilder{
        crate::operation::delete_item_input_transform::builders::DeleteItemInputTransformFluentBuilder::new(self.clone())
    }
}
