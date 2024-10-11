// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct EncryptedDataKeyDescription {
    #[allow(missing_docs)] // documentation missing in model
    pub branch_key_id: ::std::option::Option<::std::string::String>,
    #[allow(missing_docs)] // documentation missing in model
    pub branch_key_version: ::std::option::Option<::std::string::String>,
    #[allow(missing_docs)] // documentation missing in model
    pub key_provider_id: ::std::option::Option<::std::string::String>,
    #[allow(missing_docs)] // documentation missing in model
    pub key_provider_info: ::std::option::Option<::std::string::String>,
}
impl EncryptedDataKeyDescription {
    #[allow(missing_docs)] // documentation missing in model
    pub fn branch_key_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.branch_key_id
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn branch_key_version(&self) -> &::std::option::Option<::std::string::String> {
        &self.branch_key_version
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn key_provider_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.key_provider_id
    }
    #[allow(missing_docs)] // documentation missing in model
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
    #[allow(missing_docs)] // documentation missing in model
    pub fn branch_key_id(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.branch_key_id = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_branch_key_id(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.branch_key_id = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_branch_key_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.branch_key_id
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn branch_key_version(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.branch_key_version = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_branch_key_version(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.branch_key_version = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_branch_key_version(&self) -> &::std::option::Option<::std::string::String> {
        &self.branch_key_version
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn key_provider_id(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.key_provider_id = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_key_provider_id(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.key_provider_id = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_key_provider_id(&self) -> &::std::option::Option<::std::string::String> {
        &self.key_provider_id
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn key_provider_info(
        mut self,
        input: impl ::std::convert::Into<::std::string::String>,
    ) -> Self {
        self.key_provider_info = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_key_provider_info(
        mut self,
        input: ::std::option::Option<::std::string::String>,
    ) -> Self {
        self.key_provider_info = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
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
