// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct StandardBeacon {
    #[allow(missing_docs)] // documentation missing in model
    pub length: ::std::option::Option<::std::primitive::i32>,
    #[allow(missing_docs)] // documentation missing in model
    pub loc: ::std::option::Option<::std::string::String>,
    #[allow(missing_docs)] // documentation missing in model
    pub name: ::std::option::Option<::std::string::String>,
    #[allow(missing_docs)] // documentation missing in model
    pub style: ::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle,
    >,
}
impl StandardBeacon {
    #[allow(missing_docs)] // documentation missing in model
    pub fn length(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.length
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn loc(&self) -> &::std::option::Option<::std::string::String> {
        &self.loc
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn name(&self) -> &::std::option::Option<::std::string::String> {
        &self.name
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn style(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle,
    > {
        &self.style
    }
}
impl StandardBeacon {
    /// Creates a new builder-style object to manufacture [`StandardBeacon`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::StandardBeaconBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::StandardBeaconBuilder::default()
    }
}

/// A builder for [`StandardBeacon`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct StandardBeaconBuilder {
    pub(crate) length: ::std::option::Option<::std::primitive::i32>,
    pub(crate) loc: ::std::option::Option<::std::string::String>,
    pub(crate) name: ::std::option::Option<::std::string::String>,
    pub(crate) style: ::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle,
    >,
}
impl StandardBeaconBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn length(mut self, input: impl ::std::convert::Into<::std::primitive::i32>) -> Self {
        self.length = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_length(mut self, input: ::std::option::Option<::std::primitive::i32>) -> Self {
        self.length = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_length(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.length
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn loc(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.loc = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_loc(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.loc = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_loc(&self) -> &::std::option::Option<::std::string::String> {
        &self.loc
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
    pub fn style(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle,
        >,
    ) -> Self {
        self.style = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_style(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle,
        >,
    ) -> Self {
        self.style = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_style(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle,
    > {
        &self.style
    }
    /// Consumes the builder and constructs a [`StandardBeacon`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon {
                length: self.length,
                loc: self.loc,
                name: self.name,
                style: self.style,
            },
        )
    }
}
