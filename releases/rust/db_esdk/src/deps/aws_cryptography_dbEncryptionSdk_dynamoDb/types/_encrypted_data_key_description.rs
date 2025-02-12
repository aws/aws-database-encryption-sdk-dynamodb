// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct EncryptedDataKeyDescription {
    /// Branch key id of the encrypted data key.
    pub branch_key_id: ::std::option::Option<::std::string::String>,
    /// Branch key version of the encrypted data key.
    pub branch_key_version: ::std::option::Option<::std::string::String>,
    /// Key provider id of the encrypted data key.
    pub key_provider_id: ::std::option::Option<::std::string::String>,
    /// Key provider information of the encrypted data key.
    pub key_provider_info: ::std::option::Option<::std::string::String>,
}
impl EncryptedDataKeyDescription {
    /// Branch key id of the encrypted data key.
    pub fn branch_key_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.branch_key_id
    }
    /// Branch key version of the encrypted data key.
    pub fn branch_key_version(&self) -> &::std::option::Option<::std::string::String> {
        &self.branch_key_version
    }
    /// Key provider id of the encrypted data key.
    pub fn key_provider_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.key_provider_id
    }
    /// Key provider information of the encrypted data key.
    pub fn key_provider_info(&self) -> &::std::option::Option<::std::string::String> {
        &self.key_provider_info
    }
}
impl EncryptedDataKeyDescription {
    /// Creates a new builder-style object to manufacture [`EncryptedDataKeyDescription`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::EncryptedDataKeyDescriptionBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::EncryptedDataKeyDescriptionBuilder::default()
    }
}

/// A builder for [`EncryptedDataKeyDescription`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct EncryptedDataKeyDescriptionBuilder {
    pub(crate) branch_key_id: ::std::option::Option<::std::string::String>,
    pub(crate) branch_key_version: ::std::option::Option<::std::string::String>,
    pub(crate) key_provider_id: ::std::option::Option<::std::string::String>,
    pub(crate) key_provider_info: ::std::option::Option<::std::string::String>,
}
impl EncryptedDataKeyDescriptionBuilder {
    /// Branch key id of the encrypted data key.
    pub fn branch_key_id(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.branch_key_id = ::std::option::Option::Some(input.into());
        self
    }
    /// Branch key id of the encrypted data key.
    pub fn set_branch_key_id(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.branch_key_id = input;
        self
    }
    /// Branch key id of the encrypted data key.
    pub fn get_branch_key_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.branch_key_id
    }
    /// Branch key version of the encrypted data key.
    pub fn branch_key_version(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.branch_key_version = ::std::option::Option::Some(input.into());
        self
    }
    /// Branch key version of the encrypted data key.
    pub fn set_branch_key_version(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.branch_key_version = input;
        self
    }
    /// Branch key version of the encrypted data key.
    pub fn get_branch_key_version(&self) -> &::std::option::Option<::std::string::String> {
        &self.branch_key_version
    }
    /// Key provider id of the encrypted data key.
    pub fn key_provider_id(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.key_provider_id = ::std::option::Option::Some(input.into());
        self
    }
    /// Key provider id of the encrypted data key.
    pub fn set_key_provider_id(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.key_provider_id = input;
        self
    }
    /// Key provider id of the encrypted data key.
    pub fn get_key_provider_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.key_provider_id
    }
    /// Key provider information of the encrypted data key.
    pub fn key_provider_info(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.key_provider_info = ::std::option::Option::Some(input.into());
        self
    }
    /// Key provider information of the encrypted data key.
    pub fn set_key_provider_info(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.key_provider_info = input;
        self
    }
    /// Key provider information of the encrypted data key.
    pub fn get_key_provider_info(&self) -> &::std::option::Option<::std::string::String> {
        &self.key_provider_info
    }
    /// Consumes the builder and constructs a [`EncryptedDataKeyDescription`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription {
            branch_key_id: self.branch_key_id,
branch_key_version: self.branch_key_version,
key_provider_id: self.key_provider_id,
key_provider_info: self.key_provider_info,
        })
    }
}
