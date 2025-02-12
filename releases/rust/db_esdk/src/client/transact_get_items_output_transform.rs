// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`TransactGetItemsOutputTransform`](crate::operation::transact_get_items_output_transform::builders::TransactGetItemsOutputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`original_input(impl Into<Option<aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput>>)`](crate::operation::transact_get_items_output_transform::builders::TransactGetItemsOutputTransformFluentBuilder::original_input) / [`set_original_input(Option<aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput>)`](crate::operation::transact_get_items_output_transform::builders::TransactGetItemsOutputTransformFluentBuilder::set_original_input): (undocumented)<br>
    ///   - [`sdk_output(impl Into<Option<aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput>>)`](crate::operation::transact_get_items_output_transform::builders::TransactGetItemsOutputTransformFluentBuilder::sdk_output) / [`set_sdk_output(Option<aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput>)`](crate::operation::transact_get_items_output_transform::builders::TransactGetItemsOutputTransformFluentBuilder::set_sdk_output): (undocumented)<br>
    /// - On success, responds with [`TransactGetItemsOutputTransformOutput`](crate::operation::transact_get_items_output_transform::TransactGetItemsOutputTransformOutput) with field(s):
    ///   - [`transformed_output(Option<aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsOutput>)`](crate::operation::transact_get_items_output_transform::TransactGetItemsOutputTransformOutput::transformed_output): (undocumented)
    /// - On failure, responds with [`SdkError<TransactGetItemsOutputTransformError>`](crate::operation::transact_get_items_output_transform::TransactGetItemsOutputTransformError)
    pub fn transact_get_items_output_transform(&self) -> crate::operation::transact_get_items_output_transform::builders::TransactGetItemsOutputTransformFluentBuilder{
        crate::operation::transact_get_items_output_transform::builders::TransactGetItemsOutputTransformFluentBuilder::new(self.clone())
    }
}
