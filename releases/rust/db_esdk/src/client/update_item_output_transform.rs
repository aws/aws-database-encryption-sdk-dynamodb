// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`UpdateItemOutputTransform`](crate::operation::update_item_output_transform::builders::UpdateItemOutputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`original_input(impl Into<Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>>)`](crate::operation::update_item_output_transform::builders::UpdateItemOutputTransformFluentBuilder::original_input) / [`set_original_input(Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>)`](crate::operation::update_item_output_transform::builders::UpdateItemOutputTransformFluentBuilder::set_original_input): (undocumented)<br>
    ///   - [`sdk_output(impl Into<Option<aws_sdk_dynamodb::operation::update_item::UpdateItemOutput>>)`](crate::operation::update_item_output_transform::builders::UpdateItemOutputTransformFluentBuilder::sdk_output) / [`set_sdk_output(Option<aws_sdk_dynamodb::operation::update_item::UpdateItemOutput>)`](crate::operation::update_item_output_transform::builders::UpdateItemOutputTransformFluentBuilder::set_sdk_output): (undocumented)<br>
    /// - On success, responds with [`UpdateItemOutputTransformOutput`](crate::operation::update_item_output_transform::UpdateItemOutputTransformOutput) with field(s):
    ///   - [`transformed_output(Option<aws_sdk_dynamodb::operation::update_item::UpdateItemOutput>)`](crate::operation::update_item_output_transform::UpdateItemOutputTransformOutput::transformed_output): (undocumented)
    /// - On failure, responds with [`SdkError<UpdateItemOutputTransformError>`](crate::operation::update_item_output_transform::UpdateItemOutputTransformError)
    pub fn update_item_output_transform(&self) -> crate::operation::update_item_output_transform::builders::UpdateItemOutputTransformFluentBuilder{
        crate::operation::update_item_output_transform::builders::UpdateItemOutputTransformFluentBuilder::new(self.clone())
    }
}
