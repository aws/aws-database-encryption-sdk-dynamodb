// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub use crate::operation::batch_get_item_output_transform::_batch_get_item_output_transform_output::BatchGetItemOutputTransformOutputBuilder;

pub use crate::operation::batch_get_item_output_transform::_batch_get_item_output_transform_input::BatchGetItemOutputTransformInputBuilder;

impl BatchGetItemOutputTransformInputBuilder {
    /// Sends a request with this input using the given client.
    pub async fn send_with(
        self,
        client: &crate::client::Client,
    ) -> ::std::result::Result<
        crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformOutput,
        crate::types::error::Error,
    > {
        let mut fluent_builder = client.batch_get_item_output_transform();
        fluent_builder.inner = self;
        fluent_builder.send().await
    }
}
/// Fluent builder constructing a request to `BatchGetItemOutputTransform`.
///
#[derive(::std::clone::Clone, ::std::fmt::Debug)]
pub struct BatchGetItemOutputTransformFluentBuilder {
    client: crate::client::Client,
    pub(crate) inner: crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformInputBuilder,
}
impl BatchGetItemOutputTransformFluentBuilder {
    /// Creates a new `BatchGetItemOutputTransform`.
    pub(crate) fn new(client: crate::client::Client) -> Self {
        Self {
            client,
            inner: ::std::default::Default::default(),
        }
    }
    /// Access the BatchGetItemOutputTransform as a reference.
    pub fn as_input(&self) -> &crate::operation::batch_get_item_output_transform::builders::BatchGetItemOutputTransformInputBuilder{
        &self.inner
    }
    /// Sends the request and returns the response.
    pub async fn send(
        self,
    ) -> ::std::result::Result<
        crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransformOutput,
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
            })?;
        crate::operation::batch_get_item_output_transform::BatchGetItemOutputTransform::send(
            &self.client,
            input,
        )
        .await
    }

    #[allow(missing_docs)] // documentation missing in model
    pub fn original_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>,
    ) -> Self {
        self.inner = self.inner.original_input(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_original_input(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput,
        >,
    ) -> Self {
        self.inner = self.inner.set_original_input(input);
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemInput>
    {
        self.inner.get_original_input()
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn sdk_output(
        mut self,
        input: impl ::std::convert::Into<
            aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput,
        >,
    ) -> Self {
        self.inner = self.inner.sdk_output(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_sdk_output(
        mut self,
        input: ::std::option::Option<
            aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput,
        >,
    ) -> Self {
        self.inner = self.inner.set_sdk_output(input);
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_sdk_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::batch_get_item::BatchGetItemOutput>
    {
        self.inner.get_sdk_output()
    }
}