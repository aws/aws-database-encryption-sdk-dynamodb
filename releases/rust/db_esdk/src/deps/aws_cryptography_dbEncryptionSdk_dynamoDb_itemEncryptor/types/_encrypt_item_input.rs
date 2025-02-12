// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// Inputs for encrypting a DynamoDB Item.
pub struct EncryptItemInput {
    /// The DynamoDB item to encrypt.
    pub plaintext_item: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
}
impl EncryptItemInput {
    /// The DynamoDB item to encrypt.
    pub fn plaintext_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.plaintext_item
    }
}
impl EncryptItemInput {
    /// Creates a new builder-style object to manufacture [`EncryptItemInput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::EncryptItemInput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::builders::EncryptItemInputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::builders::EncryptItemInputBuilder::default()
    }
}

/// A builder for [`EncryptItemInput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::EncryptItemInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct EncryptItemInputBuilder {
    pub(crate) plaintext_item: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
}
impl EncryptItemInputBuilder {
    /// The DynamoDB item to encrypt.
    pub fn plaintext_item(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.plaintext_item = ::std::option::Option::Some(input.into());
        self
    }
    /// The DynamoDB item to encrypt.
    pub fn set_plaintext_item(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.plaintext_item = input;
        self
    }
    /// The DynamoDB item to encrypt.
    pub fn get_plaintext_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.plaintext_item
    }
    /// Consumes the builder and constructs a [`EncryptItemInput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::EncryptItemInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::EncryptItemInput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::EncryptItemInput {
            plaintext_item: self.plaintext_item,
        })
    }
}
