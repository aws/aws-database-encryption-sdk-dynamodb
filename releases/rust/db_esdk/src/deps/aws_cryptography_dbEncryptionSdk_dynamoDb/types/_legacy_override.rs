// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// A configuration for overriding encryption and/or decryption to instead perform legacy encryption and decryption.
pub struct LegacyOverride {
    /// Overrides which attributes are encrypted and/or signed for any items read or written with legacy behavior.
pub attribute_actions_on_encrypt: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
/// This input is not used in the Java Client and should not be specified.
pub default_attribute_flag: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>,
/// A configuration for the legacy DynamoDB Encryption Client's Encryptor.
pub encryptor: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::legacy_dynamo_db_encryptor::LegacyDynamoDbEncryptorRef>,
/// A policy which configurates whether legacy behavior overrides encryption and/or decryption.
pub policy: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy>,
}
impl LegacyOverride {
    /// Overrides which attributes are encrypted and/or signed for any items read or written with legacy behavior.
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
    /// This input is not used in the Java Client and should not be specified.
    pub fn default_attribute_flag(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
    > {
        &self.default_attribute_flag
    }
    /// A configuration for the legacy DynamoDB Encryption Client's Encryptor.
    pub fn encryptor(&self) -> &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::legacy_dynamo_db_encryptor::LegacyDynamoDbEncryptorRef>{
        &self.encryptor
    }
    /// A policy which configurates whether legacy behavior overrides encryption and/or decryption.
    pub fn policy(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy,
    > {
        &self.policy
    }
}
impl LegacyOverride {
    /// Creates a new builder-style object to manufacture [`LegacyOverride`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::LegacyOverrideBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::LegacyOverrideBuilder::default()
    }
}

/// A builder for [`LegacyOverride`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct LegacyOverrideBuilder {
    pub(crate) attribute_actions_on_encrypt: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
pub(crate) default_attribute_flag: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>,
pub(crate) encryptor: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::legacy_dynamo_db_encryptor::LegacyDynamoDbEncryptorRef>,
pub(crate) policy: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy>,
}
impl LegacyOverrideBuilder {
    /// Overrides which attributes are encrypted and/or signed for any items read or written with legacy behavior.
    pub fn attribute_actions_on_encrypt(
        mut self,
        input: impl ::std::convert::Into<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
    ) -> Self {
        self.attribute_actions_on_encrypt = ::std::option::Option::Some(input.into());
        self
    }
    /// Overrides which attributes are encrypted and/or signed for any items read or written with legacy behavior.
    pub fn set_attribute_actions_on_encrypt(
        mut self,
        input: ::std::option::Option<::std::collections::HashMap<::std::string::String, crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction>>,
    ) -> Self {
        self.attribute_actions_on_encrypt = input;
        self
    }
    /// Overrides which attributes are encrypted and/or signed for any items read or written with legacy behavior.
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
    /// This input is not used in the Java Client and should not be specified.
    pub fn default_attribute_flag(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    ) -> Self {
        self.default_attribute_flag = ::std::option::Option::Some(input.into());
        self
    }
    /// This input is not used in the Java Client and should not be specified.
    pub fn set_default_attribute_flag(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
        >,
    ) -> Self {
        self.default_attribute_flag = input;
        self
    }
    /// This input is not used in the Java Client and should not be specified.
    pub fn get_default_attribute_flag(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction,
    > {
        &self.default_attribute_flag
    }
    /// A configuration for the legacy DynamoDB Encryption Client's Encryptor.
    pub fn encryptor(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::legacy_dynamo_db_encryptor::LegacyDynamoDbEncryptorRef>,
    ) -> Self {
        self.encryptor = ::std::option::Option::Some(input.into());
        self
    }
    /// A configuration for the legacy DynamoDB Encryption Client's Encryptor.
    pub fn set_encryptor(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::legacy_dynamo_db_encryptor::LegacyDynamoDbEncryptorRef>,
    ) -> Self {
        self.encryptor = input;
        self
    }
    /// A configuration for the legacy DynamoDB Encryption Client's Encryptor.
    pub fn get_encryptor(&self) -> &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::legacy_dynamo_db_encryptor::LegacyDynamoDbEncryptorRef>{
        &self.encryptor
    }
    /// A policy which configurates whether legacy behavior overrides encryption and/or decryption.
    pub fn policy(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy,
        >,
    ) -> Self {
        self.policy = ::std::option::Option::Some(input.into());
        self
    }
    /// A policy which configurates whether legacy behavior overrides encryption and/or decryption.
    pub fn set_policy(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy,
        >,
    ) -> Self {
        self.policy = input;
        self
    }
    /// A policy which configurates whether legacy behavior overrides encryption and/or decryption.
    pub fn get_policy(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyPolicy,
    > {
        &self.policy
    }
    /// Consumes the builder and constructs a [`LegacyOverride`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::LegacyOverride {
                attribute_actions_on_encrypt: self.attribute_actions_on_encrypt,
                default_attribute_flag: self.default_attribute_flag,
                encryptor: self.encryptor,
                policy: self.policy,
            },
        )
    }
}
