// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub use crate::operation::batch_execute_statement_output_transform::_batch_execute_statement_output_transform_output::BatchExecuteStatementOutputTransformOutputBuilder;

pub use crate::operation::batch_execute_statement_output_transform::_batch_execute_statement_output_transform_input::BatchExecuteStatementOutputTransformInputBuilder;

impl BatchExecuteStatementOutputTransformInputBuilder {
    /// Sends a request with this input using the given client.
    pub async fn send_with(
        self,
        client: &crate::client::Client,
    ) -> ::std::result::Result<
        crate::operation::batch_execute_statement_output_transform::BatchExecuteStatementOutputTransformOutput,
        crate::types::error::Error,
    > {
        let mut fluent_builder = client.batch_execute_statement_output_transform();
        fluent_builder.inner = self;
        fluent_builder.send().await
    }
}
/// Fluent builder constructing a request to `BatchExecuteStatementOutputTransform`.
///
#[derive(::std::clone::Clone, ::std::fmt::Debug)]
pub struct BatchExecuteStatementOutputTransformFluentBuilder {
    client: crate::client::Client,
    pub(crate) inner: crate::operation::batch_execute_statement_output_transform::builders::BatchExecuteStatementOutputTransformInputBuilder,
}
impl BatchExecuteStatementOutputTransformFluentBuilder {
    /// Creates a new `BatchExecuteStatementOutputTransform`.
    pub(crate) fn new(client: crate::client::Client) -> Self {
        Self {
            client,
            inner: ::std::default::Default::default(),
        }
    }
    /// Access the BatchExecuteStatementOutputTransform as a reference.
    pub fn as_input(&self) -> &crate::operation::batch_execute_statement_output_transform::builders::BatchExecuteStatementOutputTransformInputBuilder {
        &self.inner
    }
    /// Sends the request and returns the response.
    pub async fn send(
        self,
    ) -> ::std::result::Result<
        crate::operation::batch_execute_statement_output_transform::BatchExecuteStatementOutputTransformOutput,
        crate::types::error::Error,
    > {
        let input = self
            .inner
            .build()
            // Using Opaque since we don't have a validation-specific error yet.
            // Operations' models don't declare their own validation error,
            // and smithy-rs seems to not generate a ValidationError case unless there is.
            // Vanilla smithy-rs uses SdkError::construction_failure, but we aren't using SdkError.
            .map_err(|mut e| crate::types::error::Error::Opaque {
                obj: ::dafny_runtime::Object::from_ref(&mut e as &mut dyn ::std::any::Any),
		alt_text : format!("{:?}", e)
            })?;
        crate::operation::batch_execute_statement_output_transform::BatchExecuteStatementOutputTransform::send(&self.client, input).await
    }

    #[allow(missing_docs)]
pub fn original_input(mut self, input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput>) -> Self {
    self.inner = self.inner.original_input(input.into());
    self
}
#[allow(missing_docs)]
pub fn set_original_input(mut self, input: ::std::option::Option<aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput>) -> Self {
    self.inner = self.inner.set_original_input(input);
    self
}
#[allow(missing_docs)]
pub fn get_original_input(&self) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementInput> {
    self.inner.get_original_input()
}
#[allow(missing_docs)]
pub fn sdk_output(mut self, input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput>) -> Self {
    self.inner = self.inner.sdk_output(input.into());
    self
}
#[allow(missing_docs)]
pub fn set_sdk_output(mut self, input: ::std::option::Option<aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput>) -> Self {
    self.inner = self.inner.set_sdk_output(input);
    self
}
#[allow(missing_docs)]
pub fn get_sdk_output(&self) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_execute_statement::BatchExecuteStatementOutput> {
    self.inner.get_sdk_output()
}
}
