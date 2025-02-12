// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// Outputs for encrypting a DynamoDB Item.
pub struct EncryptItemOutput {
    /// The encrypted DynamoDB item.
    pub encrypted_item: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
    /// A parsed version of the header written with the encrypted DynamoDB item.
    pub parsed_header: ::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
    >,
}
impl EncryptItemOutput {
    /// The encrypted DynamoDB item.
    pub fn encrypted_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.encrypted_item
    }
    /// A parsed version of the header written with the encrypted DynamoDB item.
    pub fn parsed_header(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
    > {
        &self.parsed_header
    }
}
impl EncryptItemOutput {
    /// Creates a new builder-style object to manufacture [`EncryptItemOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::EncryptItemOutput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::builders::EncryptItemOutputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::builders::EncryptItemOutputBuilder::default()
    }
}

/// A builder for [`EncryptItemOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::EncryptItemOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct EncryptItemOutputBuilder {
    pub(crate) encrypted_item: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
    pub(crate) parsed_header: ::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
    >,
}
impl EncryptItemOutputBuilder {
    /// The encrypted DynamoDB item.
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
    /// The encrypted DynamoDB item.
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
    /// The encrypted DynamoDB item.
    pub fn get_encrypted_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.encrypted_item
    }
    /// A parsed version of the header written with the encrypted DynamoDB item.
    pub fn parsed_header(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader>,
    ) -> Self {
        self.parsed_header = ::std::option::Option::Some(input.into());
        self
    }
    /// A parsed version of the header written with the encrypted DynamoDB item.
    pub fn set_parsed_header(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader>,
    ) -> Self {
        self.parsed_header = input;
        self
    }
    /// A parsed version of the header written with the encrypted DynamoDB item.
    pub fn get_parsed_header(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
    > {
        &self.parsed_header
    }
    /// Consumes the builder and constructs a [`EncryptItemOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::EncryptItemOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::EncryptItemOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::EncryptItemOutput {
            encrypted_item: self.encrypted_item,
parsed_header: self.parsed_header,
        })
    }
}
