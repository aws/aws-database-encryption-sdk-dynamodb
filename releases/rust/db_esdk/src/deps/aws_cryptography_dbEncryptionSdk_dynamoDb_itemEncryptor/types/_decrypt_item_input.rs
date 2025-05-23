// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// Inputs for decrypting a DynamoDB Item.
pub struct DecryptItemInput {
    /// The encrypted DynamoDB item to decrypt.
    pub encrypted_item: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
}
impl DecryptItemInput {
    /// The encrypted DynamoDB item to decrypt.
    pub fn encrypted_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.encrypted_item
    }
}
impl DecryptItemInput {
    /// Creates a new builder-style object to manufacture [`DecryptItemInput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemInput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::builders::DecryptItemInputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::builders::DecryptItemInputBuilder::default()
    }
}

/// A builder for [`DecryptItemInput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct DecryptItemInputBuilder {
    pub(crate) encrypted_item: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
}
impl DecryptItemInputBuilder {
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
        self.encrypted_item = ::std::option::Option::Some(input.into());
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
        self.encrypted_item = input;
        self
    }
    /// The encrypted DynamoDB item to decrypt.
    pub fn get_encrypted_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.encrypted_item
    }
    /// Consumes the builder and constructs a [`DecryptItemInput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemInput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemInput {
            encrypted_item: self.encrypted_item,
        })
    }
}
