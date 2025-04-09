// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`PutItemOutputTransform`](crate::operation::put_item_output_transform::builders::PutItemOutputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`original_input(impl Into<Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>>)`](crate::operation::put_item_output_transform::builders::PutItemOutputTransformFluentBuilder::original_input) / [`set_original_input(Option<aws_sdk_dynamodb::operation::put_item::PutItemInput>)`](crate::operation::put_item_output_transform::builders::PutItemOutputTransformFluentBuilder::set_original_input): (undocumented)<br>
    ///   - [`sdk_output(impl Into<Option<aws_sdk_dynamodb::operation::put_item::PutItemOutput>>)`](crate::operation::put_item_output_transform::builders::PutItemOutputTransformFluentBuilder::sdk_output) / [`set_sdk_output(Option<aws_sdk_dynamodb::operation::put_item::PutItemOutput>)`](crate::operation::put_item_output_transform::builders::PutItemOutputTransformFluentBuilder::set_sdk_output): (undocumented)<br>
    /// - On success, responds with [`PutItemOutputTransformOutput`](crate::operation::put_item_output_transform::PutItemOutputTransformOutput) with field(s):
    ///   - [`transformed_output(Option<aws_sdk_dynamodb::operation::put_item::PutItemOutput>)`](crate::operation::put_item_output_transform::PutItemOutputTransformOutput::transformed_output): (undocumented)
    /// - On failure, responds with [`SdkError<PutItemOutputTransformError>`](crate::operation::put_item_output_transform::PutItemOutputTransformError)
    pub fn put_item_output_transform(
        &self,
    ) -> crate::operation::put_item_output_transform::builders::PutItemOutputTransformFluentBuilder
    {
        crate::operation::put_item_output_transform::builders::PutItemOutputTransformFluentBuilder::new(self.clone())
    }
}
