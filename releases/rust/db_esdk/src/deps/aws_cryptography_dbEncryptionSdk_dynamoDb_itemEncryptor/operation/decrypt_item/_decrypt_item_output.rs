// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// Outputs for decrypting a DynamoDB Item.
pub struct DecryptItemOutput {
    /// A parsed version of the header on the encrypted DynamoDB item.
    pub parsed_header: ::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
    >,
    /// The decrypted DynamoDB item.
    pub plaintext_item: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
}
impl DecryptItemOutput {
    /// A parsed version of the header on the encrypted DynamoDB item.
    pub fn parsed_header(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
    > {
        &self.parsed_header
    }
    /// The decrypted DynamoDB item.
    pub fn plaintext_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.plaintext_item
    }
}
impl DecryptItemOutput {
    /// Creates a new builder-style object to manufacture [`DecryptItemOutput`](crate::operation::decrypt_item::builders::DecryptItemOutput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::builders::DecryptItemOutputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::builders::DecryptItemOutputBuilder::default()
    }
}

/// A builder for [`DecryptItemOutput`](crate::operation::operation::DecryptItemOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct DecryptItemOutputBuilder {
    pub(crate) parsed_header: ::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
    >,
    pub(crate) plaintext_item: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
}
impl DecryptItemOutputBuilder {
    /// A parsed version of the header on the encrypted DynamoDB item.
    pub fn parsed_header(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader>,
    ) -> Self {
        self.parsed_header = ::std::option::Option::Some(input.into());
        self
    }
    /// A parsed version of the header on the encrypted DynamoDB item.
    pub fn set_parsed_header(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader>,
    ) -> Self {
        self.parsed_header = input;
        self
    }
    /// A parsed version of the header on the encrypted DynamoDB item.
    pub fn get_parsed_header(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
    > {
        &self.parsed_header
    }
    /// The decrypted DynamoDB item.
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
    /// The decrypted DynamoDB item.
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
    /// The decrypted DynamoDB item.
    pub fn get_plaintext_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.plaintext_item
    }
    /// Consumes the builder and constructs a [`DecryptItemOutput`](crate::operation::operation::DecryptItemOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::DecryptItemOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::decrypt_item::DecryptItemOutput {
            parsed_header: self.parsed_header,
plaintext_item: self.plaintext_item,
        })
    }
}
