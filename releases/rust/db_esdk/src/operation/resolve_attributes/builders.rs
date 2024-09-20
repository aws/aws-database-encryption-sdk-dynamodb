// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub use crate::operation::resolve_attributes::_resolve_attributes_output::ResolveAttributesOutputBuilder;

pub use crate::operation::resolve_attributes::_resolve_attributes_input::ResolveAttributesInputBuilder;

impl ResolveAttributesInputBuilder {
    /// Sends a request with this input using the given client.
    pub async fn send_with(
        self,
        client: &crate::client::Client,
    ) -> ::std::result::Result<
        crate::operation::resolve_attributes::ResolveAttributesOutput,
        crate::types::error::Error,
    > {
        let mut fluent_builder = client.resolve_attributes();
        fluent_builder.inner = self;
        fluent_builder.send().await
    }
}
/// Fluent builder constructing a request to `ResolveAttributes`.
///
#[derive(::std::clone::Clone, ::std::fmt::Debug)]
pub struct ResolveAttributesFluentBuilder {
    client: crate::client::Client,
    pub(crate) inner: crate::operation::resolve_attributes::builders::ResolveAttributesInputBuilder,
}
impl ResolveAttributesFluentBuilder {
    /// Creates a new `ResolveAttributes`.
    pub(crate) fn new(client: crate::client::Client) -> Self {
        Self {
            client,
            inner: ::std::default::Default::default(),
        }
    }
    /// Access the ResolveAttributes as a reference.
    pub fn as_input(
        &self,
    ) -> &crate::operation::resolve_attributes::builders::ResolveAttributesInputBuilder {
        &self.inner
    }
    /// Sends the request and returns the response.
    pub async fn send(
        self,
    ) -> ::std::result::Result<
        crate::operation::resolve_attributes::ResolveAttributesOutput,
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
        crate::operation::resolve_attributes::ResolveAttributes::send(&self.client, input).await
    }

    #[allow(missing_docs)] // documentation missing in model
    pub fn item(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.inner = self.inner.item(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_item(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.inner = self.inner.set_item(input);
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        self.inner.get_item()
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn table_name(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.inner = self.inner.table_name(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_table_name(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.inner = self.inner.set_table_name(input);
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_table_name(&self) -> &::std::option::Option<::std::string::String> {
        self.inner.get_table_name()
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn version(mut self, input: impl ::std::convert::Into<::std::primitive::i32>) -> Self {
        self.inner = self.inner.version(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_version(mut self, input: ::std::option::Option<::std::primitive::i32>) -> Self {
        self.inner = self.inner.set_version(input);
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_version(&self) -> &::std::option::Option<::std::primitive::i32> {
        self.inner.get_version()
    }
}
