// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub use crate::operation::execute_transaction_output_transform::_execute_transaction_output_transform_output::ExecuteTransactionOutputTransformOutputBuilder;

pub use crate::operation::execute_transaction_output_transform::_execute_transaction_output_transform_input::ExecuteTransactionOutputTransformInputBuilder;

impl ExecuteTransactionOutputTransformInputBuilder {
    /// Sends a request with this input using the given client.
    pub async fn send_with(
        self,
        client: &crate::client::Client,
    ) -> ::std::result::Result<
        crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformOutput,
        crate::types::error::Error,
    >{
        let mut fluent_builder = client.execute_transaction_output_transform();
        fluent_builder.inner = self;
        fluent_builder.send().await
    }
}
/// Fluent builder constructing a request to `ExecuteTransactionOutputTransform`.
///
#[derive(::std::clone::Clone, ::std::fmt::Debug)]
pub struct ExecuteTransactionOutputTransformFluentBuilder {
    client: crate::client::Client,
    pub(crate) inner: crate::operation::execute_transaction_output_transform::builders::ExecuteTransactionOutputTransformInputBuilder,
}
impl ExecuteTransactionOutputTransformFluentBuilder {
    /// Creates a new `ExecuteTransactionOutputTransform`.
    pub(crate) fn new(client: crate::client::Client) -> Self {
        Self {
            client,
            inner: ::std::default::Default::default(),
        }
    }
    /// Access the ExecuteTransactionOutputTransform as a reference.
    pub fn as_input(&self) -> &crate::operation::execute_transaction_output_transform::builders::ExecuteTransactionOutputTransformInputBuilder{
        &self.inner
    }
    /// Sends the request and returns the response.
    pub async fn send(
        self,
    ) -> ::std::result::Result<
        crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransformOutput,
        crate::types::error::Error,
    >{
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
        crate::operation::execute_transaction_output_transform::ExecuteTransactionOutputTransform::send(&self.client, input).await
    }

    #[allow(missing_docs)]
    pub fn original_input(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
        >,
    ) -> Self {
        self.inner = self.inner.original_input(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_original_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
        >,
    ) -> Self {
        self.inner = self.inner.set_original_input(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_original_input(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionInput,
    > {
        self.inner.get_original_input()
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
        >,
    ) -> Self {
        self.inner = self.inner.sdk_output(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
        >,
    ) -> Self {
        self.inner = self.inner.set_sdk_output(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_output(
        &self,
    ) -> &::std::option::Option<
        aws_sdk_dynamodb::operation::execute_transaction::ExecuteTransactionOutput,
    > {
        self.inner.get_sdk_output()
    }
}
