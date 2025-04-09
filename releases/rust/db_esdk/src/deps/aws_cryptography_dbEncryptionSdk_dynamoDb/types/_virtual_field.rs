// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// The configuration for a Virtual Field. A Virtual Field is a field constructed from parts of other fields for use with beacons, but never itself stored on items.
pub struct VirtualField {
    /// The name of the Virtual Field.
    pub name: ::std::option::Option<::std::string::String>,
    /// The list of ordered parts that make up a Virtual Field.
    pub parts: ::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart>,
    >,
}
impl VirtualField {
    /// The name of the Virtual Field.
    pub fn name(&self) -> &::std::option::Option<::std::string::String> {
        &self.name
    }
    /// The list of ordered parts that make up a Virtual Field.
    pub fn parts(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart>,
    > {
        &self.parts
    }
}
impl VirtualField {
    /// Creates a new builder-style object to manufacture [`VirtualField`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::VirtualFieldBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::VirtualFieldBuilder::default()
    }
}

/// A builder for [`VirtualField`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct VirtualFieldBuilder {
    pub(crate) name: ::std::option::Option<::std::string::String>,
    pub(crate) parts: ::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart>,
    >,
}
impl VirtualFieldBuilder {
    /// The name of the Virtual Field.
    pub fn name(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.name = ::std::option::Option::Some(input.into());
        self
    }
    /// The name of the Virtual Field.
    pub fn set_name(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.name = input;
        self
    }
    /// The name of the Virtual Field.
    pub fn get_name(&self) -> &::std::option::Option<::std::string::String> {
        &self.name
    }
    /// The list of ordered parts that make up a Virtual Field.
    pub fn parts(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart,
            >,
        >,
    ) -> Self {
        self.parts = ::std::option::Option::Some(input.into());
        self
    }
    /// The list of ordered parts that make up a Virtual Field.
    pub fn set_parts(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart,
            >,
        >,
    ) -> Self {
        self.parts = input;
        self
    }
    /// The list of ordered parts that make up a Virtual Field.
    pub fn get_parts(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart>,
    > {
        &self.parts
    }
    /// Consumes the builder and constructs a [`VirtualField`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField {
                name: self.name,
                parts: self.parts,
            },
        )
    }
}
