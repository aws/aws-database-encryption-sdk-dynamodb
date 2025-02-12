// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// A Virtual Part is the configuration of a transformation on an existing field in an item.
pub struct VirtualPart {
    /// The DynamoDB document path to the value for this part.
    pub loc: ::std::option::Option<::std::string::String>,
    /// A list of transformations performed on the value for this part.
    pub trans: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform,
        >,
    >,
}
impl VirtualPart {
    /// The DynamoDB document path to the value for this part.
    pub fn loc(&self) -> &::std::option::Option<::std::string::String> {
        &self.loc
    }
    /// A list of transformations performed on the value for this part.
    pub fn trans(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform,
        >,
    > {
        &self.trans
    }
}
impl VirtualPart {
    /// Creates a new builder-style object to manufacture [`VirtualPart`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::VirtualPartBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::VirtualPartBuilder::default()
    }
}

/// A builder for [`VirtualPart`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct VirtualPartBuilder {
    pub(crate) loc: ::std::option::Option<::std::string::String>,
    pub(crate) trans: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform,
        >,
    >,
}
impl VirtualPartBuilder {
    /// The DynamoDB document path to the value for this part.
    pub fn loc(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.loc = ::std::option::Option::Some(input.into());
        self
    }
    /// The DynamoDB document path to the value for this part.
    pub fn set_loc(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.loc = input;
        self
    }
    /// The DynamoDB document path to the value for this part.
    pub fn get_loc(&self) -> &::std::option::Option<::std::string::String> {
        &self.loc
    }
    /// A list of transformations performed on the value for this part.
    pub fn trans(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform,
            >,
        >,
    ) -> Self {
        self.trans = ::std::option::Option::Some(input.into());
        self
    }
    /// A list of transformations performed on the value for this part.
    pub fn set_trans(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform,
            >,
        >,
    ) -> Self {
        self.trans = input;
        self
    }
    /// A list of transformations performed on the value for this part.
    pub fn get_trans(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform,
        >,
    > {
        &self.trans
    }
    /// Consumes the builder and constructs a [`VirtualPart`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualPart {
                loc: self.loc,
                trans: self.trans,
            },
        )
    }
}
