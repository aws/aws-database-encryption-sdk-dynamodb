// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct GetEncryptedDataKeyDescriptionOutput {
    #[allow(missing_docs)] // documentation missing in model
pub encrypted_data_key_description_output: ::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>,
}
impl GetEncryptedDataKeyDescriptionOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn encrypted_data_key_description_output(&self) -> &::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>{
        &self.encrypted_data_key_description_output
    }
}
impl GetEncryptedDataKeyDescriptionOutput {
    /// Creates a new builder-style object to manufacture [`GetEncryptedDataKeyDescriptionOutput`](crate::operation::get_encrypted_data_key_description::builders::GetEncryptedDataKeyDescriptionOutput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::builders::GetEncryptedDataKeyDescriptionOutputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::builders::GetEncryptedDataKeyDescriptionOutputBuilder::default()
    }
}

/// A builder for [`GetEncryptedDataKeyDescriptionOutput`](crate::operation::operation::GetEncryptedDataKeyDescriptionOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetEncryptedDataKeyDescriptionOutputBuilder {
    pub(crate) encrypted_data_key_description_output: ::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>,
}
impl GetEncryptedDataKeyDescriptionOutputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn encrypted_data_key_description_output(
        mut self,
        input: impl ::std::convert::Into<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>,
    ) -> Self {
        self.encrypted_data_key_description_output = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_encrypted_data_key_description_output(
        mut self,
        input: ::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>,
    ) -> Self {
        self.encrypted_data_key_description_output = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_encrypted_data_key_description_output(&self) -> &::std::option::Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>{
        &self.encrypted_data_key_description_output
    }
    /// Consumes the builder and constructs a [`GetEncryptedDataKeyDescriptionOutput`](crate::operation::operation::GetEncryptedDataKeyDescriptionOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionOutput {
            encrypted_data_key_description_output: self.encrypted_data_key_description_output,
        })
    }
}
