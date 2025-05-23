// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct StructureSegment {
    #[allow(missing_docs)]
    pub key: ::std::option::Option<::std::string::String>,
}
impl StructureSegment {
    #[allow(missing_docs)]
    pub fn key(&self) -> &::std::option::Option<::std::string::String> {
        &self.key
    }
}
impl StructureSegment {
    /// Creates a new builder-style object to manufacture [`StructureSegment`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructureSegment).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::builders::StructureSegmentBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::builders::StructureSegmentBuilder::default()
    }
}

/// A builder for [`StructureSegment`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructureSegment).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct StructureSegmentBuilder {
    pub(crate) key: ::std::option::Option<::std::string::String>,
}
impl StructureSegmentBuilder {
    #[allow(missing_docs)]
    pub fn key(mut self, input: impl ::std::convert::Into<::std::string::String>) -> Self {
        self.key = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_key(mut self, input: ::std::option::Option<::std::string::String>) -> Self {
        self.key = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_key(&self) -> &::std::option::Option<::std::string::String> {
        &self.key
    }
    /// Consumes the builder and constructs a [`StructureSegment`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructureSegment).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructureSegment,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructureSegment {
            key: self.key,
        })
    }
}
