// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::_decrypt_item_output::DecryptItemOutputBuilder;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::_decrypt_item_input::DecryptItemInputBuilder;

impl DecryptItemInputBuilder {
    /// Sends a request with this input using the given client.
    pub async fn send_with(
        self,
        client: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::client::Client,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::DecryptItemOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::error::Error,
    >{
        let mut fluent_builder = client.decrypt_item();
        fluent_builder.inner = self;
        fluent_builder.send().await
    }
}
/// Fluent builder constructing a request to `DecryptItem`.
///
/// Decrypt a DynamoDB Item.
#[derive(::std::clone::Clone, ::std::fmt::Debug)]
pub struct DecryptItemFluentBuilder {
    client: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::client::Client,
    pub(crate) inner: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::builders::DecryptItemInputBuilder,
}
impl DecryptItemFluentBuilder {
    /// Creates a new `DecryptItem`.
    pub(crate) fn new(
        client: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::client::Client,
    ) -> Self {
        Self {
            client,
            inner: ::std::default::Default::default(),
        }
    }
    /// Access the DecryptItem as a reference.
    pub fn as_input(&self) -> &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::builders::DecryptItemInputBuilder{
        &self.inner
    }
    /// Sends the request and returns the response.
    pub async fn send(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::DecryptItemOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::error::Error,
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
             crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::error::Error::OpaqueWithText {
                obj: ::dafny_runtime::Object::from_ref(&mut e as &mut ::dafny_runtime::DynAny),
		objMessage: msg
             }})?;
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::DecryptItem::send(&self.client, input).await
    }

    /// The encrypted DynamoDB item to decrypt.
    pub fn encrypted_item(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.inner = self.inner.encrypted_item(input.into());
        self
    }
    /// The encrypted DynamoDB item to decrypt.
    pub fn set_encrypted_item(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.inner = self.inner.set_encrypted_item(input);
        self
    }
    /// The encrypted DynamoDB item to decrypt.
    pub fn get_encrypted_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        self.inner.get_encrypted_item()
    }
}
