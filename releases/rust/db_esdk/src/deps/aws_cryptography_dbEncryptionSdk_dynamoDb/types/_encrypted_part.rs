// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// A part of a Compound Beacon that contains a beacon over encrypted data.
pub struct EncryptedPart {
    /// The name of the Standard Beacon, whose value this Part will hold.
    pub name: ::std::option::Option<::std::string::String>,
    /// The prefix that is written with this Encrypted Part.
    pub prefix: ::std::option::Option<::std::string::String>,
}
impl EncryptedPart {
    /// The name of the Standard Beacon, whose value this Part will hold.
    pub fn name(&self) -> &::std::option::Option<::std::string::String> {
        &self.name
    }
    /// The prefix that is written with this Encrypted Part.
    pub fn prefix(&self) -> &::std::option::Option<::std::string::String> {
        &self.prefix
    }
}
impl EncryptedPart {
    /// Creates a new builder-style object to manufacture [`EncryptedPart`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::EncryptedPartBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::EncryptedPartBuilder::default()
    }
}

/// A builder for [`EncryptedPart`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct EncryptedPartBuilder {
    pub(crate) name: ::std::option::Option<::std::string::String>,
    pub(crate) prefix: ::std::option::Option<::std::string::String>,
}
impl EncryptedPartBuilder {
    /// The name of the Standard Beacon, whose value this Part will hold.
    pub fn name(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.name = ::std::option::Option::Some(input.into());
        self
    }
    /// The name of the Standard Beacon, whose value this Part will hold.
    pub fn set_name(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.name = input;
        self
    }
    /// The name of the Standard Beacon, whose value this Part will hold.
    pub fn get_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.name
    }
    /// The prefix that is written with this Encrypted Part.
    pub fn prefix(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.prefix = ::std::option::Option::Some(input.into());
        self
    }
    /// The prefix that is written with this Encrypted Part.
    pub fn set_prefix(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.prefix = input;
        self
    }
    /// The prefix that is written with this Encrypted Part.
    pub fn get_prefix(&self) -> &::std::option::Option<::std::string::String> {
        &self.prefix
    }
    /// Consumes the builder and constructs a [`EncryptedPart`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart {
                name: self.name,
                prefix: self.prefix,
            },
        )
    }
}
