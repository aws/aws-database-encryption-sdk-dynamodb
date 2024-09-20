// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::client::Client {
    /// Constructs a fluent builder for the [`TransactWriteItemsInputTransform`](crate::operation::transact_write_items_input_transform::builders::TransactWriteItemsInputTransformFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`sdk_input(impl Into<Option<aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput>>)`](crate::operation::transact_write_items_input_transform::builders::TransactWriteItemsInputTransformFluentBuilder::sdk_input) / [`set_sdk_input(Option<aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput>)`](crate::operation::transact_write_items_input_transform::builders::TransactWriteItemsInputTransformFluentBuilder::set_sdk_input): (undocumented)<br>
    /// - On success, responds with [`TransactWriteItemsInputTransformOutput`](crate::operation::transact_write_items_input_transform::TransactWriteItemsInputTransformOutput) with field(s):
    ///   - [`transformed_input(Option<aws_sdk_dynamodb::operation::transact_write_items::TransactWriteItemsInput>)`](crate::operation::transact_write_items_input_transform::TransactWriteItemsInputTransformOutput::transformed_input): (undocumented)
    /// - On failure, responds with [`SdkError<TransactWriteItemsInputTransformError>`](crate::operation::transact_write_items_input_transform::TransactWriteItemsInputTransformError)
    pub fn transact_write_items_input_transform(&self) -> crate::operation::transact_write_items_input_transform::builders::TransactWriteItemsInputTransformFluentBuilder{
        crate::operation::transact_write_items_input_transform::builders::TransactWriteItemsInputTransformFluentBuilder::new(self.clone())
    }
}
