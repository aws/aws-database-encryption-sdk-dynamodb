// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`UpdateItemInputTransform`](crate::operation::update_item_input_transform::builders::UpdateItemInputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`sdk_input(impl Into<Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>>)`](crate::operation::update_item_input_transform::builders::UpdateItemInputTransformFluentBuilder::sdk_input) / [`set_sdk_input(Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>)`](crate::operation::update_item_input_transform::builders::UpdateItemInputTransformFluentBuilder::set_sdk_input): (undocumented)<br>
    /// - On success, responds with [`UpdateItemInputTransformOutput`](crate::operation::update_item_input_transform::UpdateItemInputTransformOutput) with field(s):
    ///   - [`transformed_input(Option<aws_sdk_dynamodb::operation::update_item::UpdateItemInput>)`](crate::operation::update_item_input_transform::UpdateItemInputTransformOutput::transformed_input): (undocumented)
    /// - On failure, responds with [`SdkError<UpdateItemInputTransformError>`](crate::operation::update_item_input_transform::UpdateItemInputTransformError)
    pub fn update_item_input_transform(&self) -> crate::operation::update_item_input_transform::builders::UpdateItemInputTransformFluentBuilder{
        crate::operation::update_item_input_transform::builders::UpdateItemInputTransformFluentBuilder::new(self.clone())
    }
}
