// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct VirtualField {
    #[allow(missing_docs)] // documentation missing in model
    pub name: ::std::option::Option<::std::string::String>,
    #[allow(missing_docs)] // documentation missing in model
    pub parts: ::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart>,
    >,
}
impl VirtualField {
    #[allow(missing_docs)] // documentation missing in model
    pub fn name(&self) -> &::std::option::Option<::std::string::String> {
        &self.name
    }
    #[allow(missing_docs)] // documentation missing in model
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
    #[allow(missing_docs)] // documentation missing in model
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
    #[allow(missing_docs)] // documentation missing in model
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
