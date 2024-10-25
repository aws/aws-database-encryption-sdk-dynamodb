// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub use crate::operation::query_output_transform::_query_output_transform_output::QueryOutputTransformOutputBuilder;

pub use crate::operation::query_output_transform::_query_output_transform_input::QueryOutputTransformInputBuilder;

impl QueryOutputTransformInputBuilder {
    /// Sends a request with this input using the given client.
    pub async fn send_with(
        self,
        client: &crate::client::Client,
    ) -> ::std::result::Result<
        crate::operation::query_output_transform::QueryOutputTransformOutput,
        crate::types::error::Error,
    > {
        let mut fluent_builder = client.query_output_transform();
        fluent_builder.inner = self;
        fluent_builder.send().await
    }
}
/// Fluent builder constructing a request to `QueryOutputTransform`.
///
#[derive(::std::clone::Clone, ::std::fmt::Debug)]
pub struct QueryOutputTransformFluentBuilder {
    client: crate::client::Client,
    pub(crate) inner:
        crate::operation::query_output_transform::builders::QueryOutputTransformInputBuilder,
}
impl QueryOutputTransformFluentBuilder {
    /// Creates a new `QueryOutputTransform`.
    pub(crate) fn new(client: crate::client::Client) -> Self {
        Self {
            client,
            inner: ::std::default::Default::default(),
        }
    }
    /// Access the QueryOutputTransform as a reference.
    pub fn as_input(
        &self,
    ) -> &crate::operation::query_output_transform::builders::QueryOutputTransformInputBuilder {
        &self.inner
    }
    /// Sends the request and returns the response.
    pub async fn send(
        self,
    ) -> ::std::result::Result<
        crate::operation::query_output_transform::QueryOutputTransformOutput,
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
                alt_text: format!("{:?}", e),
            })?;
        crate::operation::query_output_transform::QueryOutputTransform::send(&self.client, input)
            .await
    }

    #[allow(missing_docs)]
    pub fn original_input(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::query::QueryInput>,
    ) -> Self {
        self.inner = self.inner.original_input(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_original_input(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput>,
    ) -> Self {
        self.inner = self.inner.set_original_input(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_original_input(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::query::QueryInput> {
        self.inner.get_original_input()
    }
    #[allow(missing_docs)]
    pub fn sdk_output(
        mut self,
        input: impl ::std::convert::Into<aws_sdk_dynamodb::operation::query::QueryOutput>,
    ) -> Self {
        self.inner = self.inner.sdk_output(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_sdk_output(
        mut self,
        input: ::std::option::Option<aws_sdk_dynamodb::operation::query::QueryOutput>,
    ) -> Self {
        self.inner = self.inner.set_sdk_output(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_sdk_output(
        &self,
    ) -> &::std::option::Option<aws_sdk_dynamodb::operation::query::QueryOutput> {
        self.inner.get_sdk_output()
    }
}
