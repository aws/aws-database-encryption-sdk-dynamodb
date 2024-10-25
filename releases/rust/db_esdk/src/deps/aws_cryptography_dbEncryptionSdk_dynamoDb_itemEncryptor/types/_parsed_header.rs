// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// A parsed version of the header that was written with or read on an encrypted DynamoDB item.
pub struct ParsedHeader {
    /// The ID of the algorithm suite that was used to encrypt this item.
    pub algorithm_suite_id: ::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
    >,
    /// The non-DO_NOTHING Crypto Actions that were configured when this item was originally encrypted.
    pub attribute_actions_on_encrypt: ::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    >,
    /// The encrypted data keys that are stored in the header of this item.
    pub encrypted_data_keys: ::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_materialProviders::types::EncryptedDataKey>,
    >,
    /// The full encryption context.
    pub encryption_context: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
    /// The encryption context as presented to the branch key selector.
    pub selector_context: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
    /// The portion of the encryption context that was stored in the header of this item.
    pub stored_encryption_context: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
}
impl ParsedHeader {
    /// The ID of the algorithm suite that was used to encrypt this item.
    pub fn algorithm_suite_id(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
    > {
        &self.algorithm_suite_id
    }
    /// The non-DO_NOTHING Crypto Actions that were configured when this item was originally encrypted.
    pub fn attribute_actions_on_encrypt(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    > {
        &self.attribute_actions_on_encrypt
    }
    /// The encrypted data keys that are stored in the header of this item.
    pub fn encrypted_data_keys(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_materialProviders::types::EncryptedDataKey>,
    > {
        &self.encrypted_data_keys
    }
    /// The full encryption context.
    pub fn encryption_context(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    > {
        &self.encryption_context
    }
    /// The encryption context as presented to the branch key selector.
    pub fn selector_context(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.selector_context
    }
    /// The portion of the encryption context that was stored in the header of this item.
    pub fn stored_encryption_context(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    > {
        &self.stored_encryption_context
    }
}
impl ParsedHeader {
    /// Creates a new builder-style object to manufacture [`ParsedHeader`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::builders::ParsedHeaderBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::builders::ParsedHeaderBuilder::default()
    }
}

/// A builder for [`ParsedHeader`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ParsedHeaderBuilder {
    pub(crate) algorithm_suite_id: ::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
    >,
    pub(crate) attribute_actions_on_encrypt: ::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    >,
    pub(crate) encrypted_data_keys: ::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_materialProviders::types::EncryptedDataKey>,
    >,
    pub(crate) encryption_context: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
    pub(crate) selector_context: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    >,
    pub(crate) stored_encryption_context: ::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    >,
}
impl ParsedHeaderBuilder {
    /// The ID of the algorithm suite that was used to encrypt this item.
    pub fn algorithm_suite_id(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
        >,
    ) -> Self {
        self.algorithm_suite_id = ::std::option::Option::Some(input.into());
        self
    }
    /// The ID of the algorithm suite that was used to encrypt this item.
    pub fn set_algorithm_suite_id(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
        >,
    ) -> Self {
        self.algorithm_suite_id = input;
        self
    }
    /// The ID of the algorithm suite that was used to encrypt this item.
    pub fn get_algorithm_suite_id(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId,
    > {
        &self.algorithm_suite_id
    }
    /// The non-DO_NOTHING Crypto Actions that were configured when this item was originally encrypted.
    pub fn attribute_actions_on_encrypt(
        mut self,
        input: impl ::std::convert::Into<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
    ) -> Self {
        self.attribute_actions_on_encrypt = ::std::option::Option::Some(input.into());
        self
    }
    /// The non-DO_NOTHING Crypto Actions that were configured when this item was originally encrypted.
    pub fn set_attribute_actions_on_encrypt(
        mut self,
        input: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
    ) -> Self {
        self.attribute_actions_on_encrypt = input;
        self
    }
    /// The non-DO_NOTHING Crypto Actions that were configured when this item was originally encrypted.
    pub fn get_attribute_actions_on_encrypt(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<
            ::std::string::String,
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    > {
        &self.attribute_actions_on_encrypt
    }
    /// The encrypted data keys that are stored in the header of this item.
    pub fn encrypted_data_keys(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_materialProviders::types::EncryptedDataKey,
            >,
        >,
    ) -> Self {
        self.encrypted_data_keys = ::std::option::Option::Some(input.into());
        self
    }
    /// The encrypted data keys that are stored in the header of this item.
    pub fn set_encrypted_data_keys(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_materialProviders::types::EncryptedDataKey,
            >,
        >,
    ) -> Self {
        self.encrypted_data_keys = input;
        self
    }
    /// The encrypted data keys that are stored in the header of this item.
    pub fn get_encrypted_data_keys(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_materialProviders::types::EncryptedDataKey>,
    > {
        &self.encrypted_data_keys
    }
    /// The full encryption context.
    pub fn encryption_context(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.encryption_context = ::std::option::Option::Some(input.into());
        self
    }
    /// The full encryption context.
    pub fn set_encryption_context(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.encryption_context = input;
        self
    }
    /// The full encryption context.
    pub fn get_encryption_context(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    > {
        &self.encryption_context
    }
    /// The encryption context as presented to the branch key selector.
    pub fn selector_context(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.selector_context = ::std::option::Option::Some(input.into());
        self
    }
    /// The encryption context as presented to the branch key selector.
    pub fn set_selector_context(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<
                ::std::string::String,
                aws_sdk_dynamodb::types::AttributeValue,
            >,
        >,
    ) -> Self {
        self.selector_context = input;
        self
    }
    /// The encryption context as presented to the branch key selector.
    pub fn get_selector_context(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
    > {
        &self.selector_context
    }
    /// The portion of the encryption context that was stored in the header of this item.
    pub fn stored_encryption_context(
        mut self,
        input: impl ::std::convert::Into<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.stored_encryption_context = ::std::option::Option::Some(input.into());
        self
    }
    /// The portion of the encryption context that was stored in the header of this item.
    pub fn set_stored_encryption_context(
        mut self,
        input: ::std::option::Option<
            ::std::collections::HashMap<::std::string::String, ::std::string::String>,
        >,
    ) -> Self {
        self.stored_encryption_context = input;
        self
    }
    /// The portion of the encryption context that was stored in the header of this item.
    pub fn get_stored_encryption_context(
        &self,
    ) -> &::std::option::Option<
        ::std::collections::HashMap<::std::string::String, ::std::string::String>,
    > {
        &self.stored_encryption_context
    }
    /// Consumes the builder and constructs a [`ParsedHeader`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader {
            algorithm_suite_id: self.algorithm_suite_id,
attribute_actions_on_encrypt: self.attribute_actions_on_encrypt,
encrypted_data_keys: self.encrypted_data_keys,
encryption_context: self.encryption_context,
selector_context: self.selector_context,
stored_encryption_context: self.stored_encryption_context,
        })
    }
}
