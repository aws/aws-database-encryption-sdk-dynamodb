// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct CompoundBeacon {
    #[allow(missing_docs)] // documentation missing in model
    pub constructors: ::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor>,
    >,
    #[allow(missing_docs)] // documentation missing in model
    pub encrypted: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
        >,
    >,
    #[allow(missing_docs)] // documentation missing in model
    pub name: ::std::option::Option<::std::string::String>,
    #[allow(missing_docs)] // documentation missing in model
    pub signed: ::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart>,
    >,
    #[allow(missing_docs)] // documentation missing in model
    pub split: ::std::option::Option<::std::string::String>,
}
impl CompoundBeacon {
    #[allow(missing_docs)] // documentation missing in model
    pub fn constructors(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor>,
    > {
        &self.constructors
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn encrypted(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
        >,
    > {
        &self.encrypted
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn name(&self) -> &::std::option::Option<::std::string::String> {
        &self.name
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn signed(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart>,
    > {
        &self.signed
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn split(&self) -> &::std::option::Option<::std::string::String> {
        &self.split
    }
}
impl CompoundBeacon {
    /// Creates a new builder-style object to manufacture [`CompoundBeacon`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::CompoundBeaconBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::CompoundBeaconBuilder::default()
    }
}

/// A builder for [`CompoundBeacon`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct CompoundBeaconBuilder {
    pub(crate) constructors: ::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor>,
    >,
    pub(crate) encrypted: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
        >,
    >,
    pub(crate) name: ::std::option::Option<::std::string::String>,
    pub(crate) signed: ::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart>,
    >,
    pub(crate) split: ::std::option::Option<::std::string::String>,
}
impl CompoundBeaconBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn constructors(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor,
            >,
        >,
    ) -> Self {
        self.constructors = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_constructors(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor,
            >,
        >,
    ) -> Self {
        self.constructors = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_constructors(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor>,
    > {
        &self.constructors
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn encrypted(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
            >,
        >,
    ) -> Self {
        self.encrypted = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_encrypted(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
            >,
        >,
    ) -> Self {
        self.encrypted = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_encrypted(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
        >,
    > {
        &self.encrypted
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn name(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.name = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_name(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.name = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.name
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn signed(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart,
            >,
        >,
    ) -> Self {
        self.signed = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_signed(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart,
            >,
        >,
    ) -> Self {
        self.signed = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_signed(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart>,
    > {
        &self.signed
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn split(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.split = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_split(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.split = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_split(&self) -> &::std::option::Option<::std::string::String> {
        &self.split
    }
    /// Consumes the builder and constructs a [`CompoundBeacon`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon {
                constructors: self.constructors,
                encrypted: self.encrypted,
                name: self.name,
                signed: self.signed,
                split: self.split,
            },
        )
    }
}
