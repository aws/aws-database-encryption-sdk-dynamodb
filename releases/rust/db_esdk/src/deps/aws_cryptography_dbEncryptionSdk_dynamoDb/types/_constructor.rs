// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// The configuration for a particular Compound Beacon construction.
pub struct Constructor {
    /// The ordered list of parts for a particular Compound Beacon construction. If the item contains all required Parts, a Compound beacon will be written using each Part that exists on the item, in the order specified.
    pub parts: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart,
        >,
    >,
}
impl Constructor {
    /// The ordered list of parts for a particular Compound Beacon construction. If the item contains all required Parts, a Compound beacon will be written using each Part that exists on the item, in the order specified.
    pub fn parts(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart,
        >,
    > {
        &self.parts
    }
}
impl Constructor {
    /// Creates a new builder-style object to manufacture [`Constructor`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::ConstructorBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::ConstructorBuilder::default()
    }
}

/// A builder for [`Constructor`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct ConstructorBuilder {
    pub(crate) parts: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart,
        >,
    >,
}
impl ConstructorBuilder {
    /// The ordered list of parts for a particular Compound Beacon construction. If the item contains all required Parts, a Compound beacon will be written using each Part that exists on the item, in the order specified.
    pub fn parts(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart,
            >,
        >,
    ) -> Self {
        self.parts = ::std::option::Option::Some(input.into());
        self
    }
    /// The ordered list of parts for a particular Compound Beacon construction. If the item contains all required Parts, a Compound beacon will be written using each Part that exists on the item, in the order specified.
    pub fn set_parts(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart,
            >,
        >,
    ) -> Self {
        self.parts = input;
        self
    }
    /// The ordered list of parts for a particular Compound Beacon construction. If the item contains all required Parts, a Compound beacon will be written using each Part that exists on the item, in the order specified.
    pub fn get_parts(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::ConstructorPart,
        >,
    > {
        &self.parts
    }
    /// Consumes the builder and constructs a [`Constructor`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Constructor {
                parts: self.parts,
            },
        )
    }
}
