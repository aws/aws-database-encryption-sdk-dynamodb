// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct DecryptItemOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub parsed_header: ::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
    >,
    #[allow(missing_docs)] // documentation missing in model
    pub plaintext_item: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
}
impl DecryptItemOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn parsed_header(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
    > {
        &self.parsed_header
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn plaintext_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.plaintext_item
    }
}
impl DecryptItemOutput {
    /// Creates a new builder-style object to manufacture [`DecryptItemOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemOutput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::builders::DecryptItemOutputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::builders::DecryptItemOutputBuilder::default()
    }
}

/// A builder for [`DecryptItemOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemOutput).
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
    #[allow(missing_docs)] // documentation missing in model
    pub fn parsed_header(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader>,
    ) -> Self {
        self.parsed_header = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_parsed_header(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader>,
    ) -> Self {
        self.parsed_header = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_parsed_header(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
    > {
        &self.parsed_header
    }
    #[allow(missing_docs)] // documentation missing in model
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
    #[allow(missing_docs)] // documentation missing in model
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
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_plaintext_item(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.plaintext_item
    }
    /// Consumes the builder and constructs a [`DecryptItemOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::DecryptItemOutput {
            parsed_header: self.parsed_header,
plaintext_item: self.plaintext_item,
        })
    }
}
