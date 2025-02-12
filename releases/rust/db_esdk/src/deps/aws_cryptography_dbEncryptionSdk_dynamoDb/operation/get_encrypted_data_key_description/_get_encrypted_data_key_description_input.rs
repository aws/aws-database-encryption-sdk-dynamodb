// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// Input for getting encrypted data key description.
pub struct GetEncryptedDataKeyDescriptionInput {
    #[allow(missing_docs)]
pub input: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion>,
}
impl GetEncryptedDataKeyDescriptionInput {
    #[allow(missing_docs)]
    pub fn input(&self) -> &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion>{
        &self.input
    }
}
impl GetEncryptedDataKeyDescriptionInput {
    /// Creates a new builder-style object to manufacture [`GetEncryptedDataKeyDescriptionInput`](crate::operation::get_encrypted_data_key_description::builders::GetEncryptedDataKeyDescriptionInput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::builders::GetEncryptedDataKeyDescriptionInputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::builders::GetEncryptedDataKeyDescriptionInputBuilder::default()
    }
}

/// A builder for [`GetEncryptedDataKeyDescriptionInput`](crate::operation::operation::GetEncryptedDataKeyDescriptionInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct GetEncryptedDataKeyDescriptionInputBuilder {
    pub(crate) input: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion>,
}
impl GetEncryptedDataKeyDescriptionInputBuilder {
    #[allow(missing_docs)]
    pub fn input(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion>,
    ) -> Self {
        self.input = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_input(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion>,
    ) -> Self {
        self.input = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_input(&self) -> &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion>{
        &self.input
    }
    /// Consumes the builder and constructs a [`GetEncryptedDataKeyDescriptionInput`](crate::operation::operation::GetEncryptedDataKeyDescriptionInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionInput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionInput {
            input: self.input,
        })
    }
}
