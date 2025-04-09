// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub use crate::operation::execute_statement_input_transform::_execute_statement_input_transform_output::ExecuteStatementInputTransformOutputBuilder;

pub use crate::operation::execute_statement_input_transform::_execute_statement_input_transform_input::ExecuteStatementInputTransformInputBuilder;

impl ExecuteStatementInputTransformInputBuilder {
    /// Sends a request with this input using the given client.
    pub async fn send_with(
        self,
        client: &crate::client::Client,
    ) -> ::std::result::Result<
        crate::operation::execute_statement_input_transform::ExecuteStatementInputTransformOutput,
        crate::types::error::Error,
    > {
        let mut fluent_builder = client.execute_statement_input_transform();
        fluent_builder.inner = self;
        fluent_builder.send().await
    }
}
/// Fluent builder constructing a request to `ExecuteStatementInputTransform`.
///
#[derive(::std::clone::Clone, ::std::fmt::Debug)]
pub struct ExecuteStatementInputTransformFluentBuilder {
    client: crate::client::Client,
    pub(crate) inner: crate::operation::execute_statement_input_transform::builders::ExecuteStatementInputTransformInputBuilder,
}
impl ExecuteStatementInputTransformFluentBuilder {
    /// Creates a new `ExecuteStatementInputTransform`.
    pub(crate) fn new(client: crate::client::Client) -> Self {
        Self {
            client,
            inner: ::std::default::Default::default(),
        }
    }
    /// Access the ExecuteStatementInputTransform as a reference.
    pub fn as_input(&self) -> &crate::operation::execute_statement_input_transform::builders::ExecuteStatementInputTransformInputBuilder{
        &self.inner
    }
    /// Sends the request and returns the response.
    pub async fn send(
        self,
    ) -> ::std::result::Result<
        crate::operation::execute_statement_input_transform::ExecuteStatementInputTransformOutput,
        crate::types::error::Error,
    > {
        let input = self
            .inner
            .build()
            // Using Opaque since we don't have a validation-specific error yet.
            // Operations' models don't declare their own validation error,
            // and smithy-rs seems to not generate a ValidationError case unless there is.
            // Vanilla smithy-rs uses SdkError::construction_failure, but we aren't using SdkError.
            .map_err(|mut e| {
                let msg = format!("{:?}", e);
                crate::types::error::Error::OpaqueWithText {
                    obj: ::dafny_runtime::Object::from_ref(&mut e as &mut ::dafny_runtime::DynAny),
                    objMessage: msg,
                }
            })?;
        crate::operation::execute_statement_input_transform::ExecuteStatementInputTransform::send(
            &self.client,
            input,
        )
        .await
    }

    #[allow(missing_docs)]
    pub fn sdk_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
        >,
    ) -> Self {
        self.inner = self.inner.sdk_input(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput,
        >,
    ) -> Self {
        self.inner = self.inner.set_sdk_input(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::execute_statement::ExecuteStatementInput>
    {
        self.inner.get_sdk_input()
    }
}
