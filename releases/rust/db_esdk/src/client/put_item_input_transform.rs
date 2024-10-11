// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`PutItemInputTransform`](crate::operation::put_item_input_transform::builders::PutItemInputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`sdk_input(impl Into<Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>>)`](crate::operation::put_item_input_transform::builders::PutItemInputTransformFluentBuilder::sdk_input) / [`set_sdk_input(Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>)`](crate::operation::put_item_input_transform::builders::PutItemInputTransformFluentBuilder::set_sdk_input): (undocumented)<br>
    /// - On success, responds with [`PutItemInputTransformOutput`](crate::operation::put_item_input_transform::PutItemInputTransformOutput) with field(s):
    ///   - [`transformed_input(Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>)`](crate::operation::put_item_input_transform::PutItemInputTransformOutput::transformed_input): (undocumented)
    /// - On failure, responds with [`SdkError<PutItemInputTransformError>`](crate::operation::put_item_input_transform::PutItemInputTransformError)
    pub fn put_item_input_transform(
        &self,
    ) -> crate::operation::put_item_input_transform::builders::PutItemInputTransformFluentBuilder
    {
        crate::operation::put_item_input_transform::builders::PutItemInputTransformFluentBuilder::new(self.clone())
    }
}
