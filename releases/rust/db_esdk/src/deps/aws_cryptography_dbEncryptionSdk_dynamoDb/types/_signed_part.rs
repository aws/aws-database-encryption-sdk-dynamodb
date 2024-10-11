// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct SignedPart {
    #[allow(missing_docs)] // documentation missing in model
    pub loc: ::std::option::Option<::std::string::String>,
    #[allow(missing_docs)] // documentation missing in model
    pub name: ::std::option::Option<::std::string::String>,
    #[allow(missing_docs)] // documentation missing in model
    pub prefix: ::std::option::Option<::std::string::String>,
}
impl SignedPart {
    #[allow(missing_docs)] // documentation missing in model
    pub fn loc(&self) -> &::std::option::Option<::std::string::String> {
        &self.loc
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn name(&self) -> &::std::option::Option<::std::string::String> {
        &self.name
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn prefix(&self) -> &::std::option::Option<::std::string::String> {
        &self.prefix
    }
}
impl SignedPart {
    /// Creates a new builder-style object to manufacture [`SignedPart`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::SignedPartBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::SignedPartBuilder::default()
    }
}

/// A builder for [`SignedPart`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct SignedPartBuilder {
    pub(crate) loc: ::std::option::Option<::std::string::String>,
    pub(crate) name: ::std::option::Option<::std::string::String>,
    pub(crate) prefix: ::std::option::Option<::std::string::String>,
}
impl SignedPartBuilder {
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
    pub fn prefix(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.prefix = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_prefix(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.prefix = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_prefix(&self) -> &::std::option::Option<::std::string::String> {
        &self.prefix
    }
    /// Consumes the builder and constructs a [`SignedPart`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart {
                loc: self.loc,
                name: self.name,
                prefix: self.prefix,
            },
        )
    }
}
