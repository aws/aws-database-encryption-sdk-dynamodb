// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// Output for getting encrypted data key description.
pub struct GetEncryptedDataKeyDescriptionOutput {
    /// A list of encrypted data key description.
pub encrypted_data_key_description_output: ::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>,
}
impl GetEncryptedDataKeyDescriptionOutput {
    /// A list of encrypted data key description.
    pub fn encrypted_data_key_description_output(&self) -> &::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>{
        &self.encrypted_data_key_description_output
    }
}
impl GetEncryptedDataKeyDescriptionOutput {
    /// Creates a new builder-style object to manufacture [`GetEncryptedDataKeyDescriptionOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionOutput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetEncryptedDataKeyDescriptionOutputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::GetEncryptedDataKeyDescriptionOutputBuilder::default()
    }
}

/// A builder for [`GetEncryptedDataKeyDescriptionOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetEncryptedDataKeyDescriptionOutputBuilder {
    pub(crate) encrypted_data_key_description_output: ::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>,
}
impl GetEncryptedDataKeyDescriptionOutputBuilder {
    /// A list of encrypted data key description.
    pub fn encrypted_data_key_description_output(
        mut self,
        input: impl ::std::convert::Into<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>,
    ) -> Self {
        self.encrypted_data_key_description_output = ::std::option::Option::Some(input.into());
        self
    }
    /// A list of encrypted data key description.
    pub fn set_encrypted_data_key_description_output(
        mut self,
        input: ::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>,
    ) -> Self {
        self.encrypted_data_key_description_output = input;
        self
    }
    /// A list of encrypted data key description.
    pub fn get_encrypted_data_key_description_output(&self) -> &::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>{
        &self.encrypted_data_key_description_output
    }
    /// Consumes the builder and constructs a [`GetEncryptedDataKeyDescriptionOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionOutput {
            encrypted_data_key_description_output: self.encrypted_data_key_description_output,
        })
    }
}
