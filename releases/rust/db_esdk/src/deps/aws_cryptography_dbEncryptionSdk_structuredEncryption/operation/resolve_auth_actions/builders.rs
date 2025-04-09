// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub use crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::_resolve_auth_actions_output::ResolveAuthActionsOutputBuilder;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::_resolve_auth_actions_input::ResolveAuthActionsInputBuilder;

impl ResolveAuthActionsInputBuilder {
    /// Sends a request with this input using the given client.
    pub async fn send_with(
        self,
        client: &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::client::Client,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::ResolveAuthActionsOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error,
    >{
        let mut fluent_builder = client.resolve_auth_actions();
        fluent_builder.inner = self;
        fluent_builder.send().await
    }
}
/// Fluent builder constructing a request to `ResolveAuthActions`.
///
#[derive(::std::clone::Clone, ::std::fmt::Debug)]
pub struct ResolveAuthActionsFluentBuilder {
    client: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::client::Client,
    pub(crate) inner: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::builders::ResolveAuthActionsInputBuilder,
}
impl ResolveAuthActionsFluentBuilder {
    /// Creates a new `ResolveAuthActions`.
    pub(crate) fn new(
        client: crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::client::Client,
    ) -> Self {
        Self {
            client,
            inner: ::std::default::Default::default(),
        }
    }
    /// Access the ResolveAuthActions as a reference.
    pub fn as_input(&self) -> &crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::builders::ResolveAuthActionsInputBuilder{
        &self.inner
    }
    /// Sends the request and returns the response.
    pub async fn send(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::ResolveAuthActionsOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error,
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
             crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::error::Error::OpaqueWithText {
                obj: ::dafny_runtime::Object::from_ref(&mut e as &mut ::dafny_runtime::DynAny),
		objMessage: msg
             }})?;
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::operation::resolve_auth_actions::ResolveAuthActions::send(&self.client, input).await
    }

    #[allow(missing_docs)]
    pub fn auth_actions(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
            >,
        >,
    ) -> Self {
        self.inner = self.inner.auth_actions(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_auth_actions(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
            >,
        >,
    ) -> Self {
        self.inner = self.inner.set_auth_actions(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_auth_actions(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::AuthItem,
        >,
    > {
        self.inner.get_auth_actions()
    }
    #[allow(missing_docs)]
    pub fn header_bytes(
        mut self,
        input: impl ::std::convert::Into<::aws_smithy_types::Blob>,
    ) -> Self {
        self.inner = self.inner.header_bytes(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_header_bytes(
        mut self,
        input: ::std::option::Option<::aws_smithy_types::Blob>,
    ) -> Self {
        self.inner = self.inner.set_header_bytes(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_header_bytes(&self) -> &::std::option::Option<::aws_smithy_types::Blob> {
        self.inner.get_header_bytes()
    }
    #[allow(missing_docs)]
    pub fn table_name(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.inner = self.inner.table_name(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_table_name(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.inner = self.inner.set_table_name(input);
        self
    }
    #[allow(missing_docs)]
    pub fn get_table_name(&self) -> &::std::option::Option<::std::string::String> {
        self.inner.get_table_name()
    }
}
