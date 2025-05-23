// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// A part of a Compound Becaon Construction.
pub struct ConstructorPart {
    /// The name of the Encrypted Part or Signed Part for which this constructor part gets a value.
    pub name: ::std::option::Option<::std::string::String>,
    /// Whether this Encrypted Part or Signed Part is required for this construction to succeed.
    pub required: ::std::option::Option<::std::primitive::bool>,
}
impl ConstructorPart {
    /// The name of the Encrypted Part or Signed Part for which this constructor part gets a value.
    pub fn name(&self) -> &::std::option::Option<::std::string::String> {
        &self.name
    }
    /// Whether this Encrypted Part or Signed Part is required for this construction to succeed.
    pub fn required(&self) -> &::std::option::Option<::std::primitive::bool> {
        &self.required
    }
}
impl ConstructorPart {
    /// Creates a new builder-style object to manufacture [`ConstructorPart`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::ConstructorPartBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::ConstructorPartBuilder::default()
    }
}

/// A builder for [`ConstructorPart`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ConstructorPartBuilder {
    pub(crate) name: ::std::option::Option<::std::string::String>,
    pub(crate) required: ::std::option::Option<::std::primitive::bool>,
}
impl ConstructorPartBuilder {
    /// The name of the Encrypted Part or Signed Part for which this constructor part gets a value.
    pub fn name(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.name = ::std::option::Option::Some(input.into());
        self
    }
    /// The name of the Encrypted Part or Signed Part for which this constructor part gets a value.
    pub fn set_name(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.name = input;
        self
    }
    /// The name of the Encrypted Part or Signed Part for which this constructor part gets a value.
    pub fn get_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.name
    }
    /// Whether this Encrypted Part or Signed Part is required for this construction to succeed.
    pub fn required(mut self, input: impl ::std::convert::Into<::std::primitive::bool>) -> Self {
        self.required = ::std::option::Option::Some(input.into());
        self
    }
    /// Whether this Encrypted Part or Signed Part is required for this construction to succeed.
    pub fn set_required(mut self, input: ::std::option::Option<::std::primitive::bool>) -> Self {
        self.required = input;
        self
    }
    /// Whether this Encrypted Part or Signed Part is required for this construction to succeed.
    pub fn get_required(&self) -> &::std::option::Option<::std::primitive::bool> {
        &self.required
    }
    /// Consumes the builder and constructs a [`ConstructorPart`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart {
                name: self.name,
                required: self.required,
            },
        )
    }
}
