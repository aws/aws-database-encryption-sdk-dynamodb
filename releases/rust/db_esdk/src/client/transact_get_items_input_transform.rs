// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`TransactGetItemsInputTransform`](crate::operation::transact_get_items_input_transform::builders::TransactGetItemsInputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`sdk_input(impl Into<Option<aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput>>)`](crate::operation::transact_get_items_input_transform::builders::TransactGetItemsInputTransformFluentBuilder::sdk_input) / [`set_sdk_input(Option<aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput>)`](crate::operation::transact_get_items_input_transform::builders::TransactGetItemsInputTransformFluentBuilder::set_sdk_input): (undocumented)<br>
    /// - On success, responds with [`TransactGetItemsInputTransformOutput`](crate::operation::transact_get_items_input_transform::TransactGetItemsInputTransformOutput) with field(s):
    ///   - [`transformed_input(Option<aws_sdk_dynamodb::operation::transact_get_items::TransactGetItemsInput>)`](crate::operation::transact_get_items_input_transform::TransactGetItemsInputTransformOutput::transformed_input): (undocumented)
    /// - On failure, responds with [`SdkError<TransactGetItemsInputTransformError>`](crate::operation::transact_get_items_input_transform::TransactGetItemsInputTransformError)
    pub fn transact_get_items_input_transform(&self) -> crate::operation::transact_get_items_input_transform::builders::TransactGetItemsInputTransformFluentBuilder{
        crate::operation::transact_get_items_input_transform::builders::TransactGetItemsInputTransformFluentBuilder::new(self.clone())
    }
}
