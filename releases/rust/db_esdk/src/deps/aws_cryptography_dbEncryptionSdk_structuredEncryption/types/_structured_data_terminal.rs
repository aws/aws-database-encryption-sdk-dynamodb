// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct StructuredDataTerminal {
    #[allow(missing_docs)]
    pub type_id: ::std::option::Option<::aws_smithy_types::Blob>,
    #[allow(missing_docs)]
    pub value: ::std::option::Option<::aws_smithy_types::Blob>,
}
impl StructuredDataTerminal {
    #[allow(missing_docs)]
    pub fn type_id(&self) -> &::std::option::Option<::aws_smithy_types::Blob> {
        &self.type_id
    }
    #[allow(missing_docs)]
    pub fn value(&self) -> &::std::option::Option<::aws_smithy_types::Blob> {
        &self.value
    }
}
impl StructuredDataTerminal {
    /// Creates a new builder-style object to manufacture [`StructuredDataTerminal`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::builders::StructuredDataTerminalBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::builders::StructuredDataTerminalBuilder::default()
    }
}

/// A builder for [`StructuredDataTerminal`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct StructuredDataTerminalBuilder {
    pub(crate) type_id: ::std::option::Option<::aws_smithy_types::Blob>,
    pub(crate) value: ::std::option::Option<::aws_smithy_types::Blob>,
}
impl StructuredDataTerminalBuilder {
    #[allow(missing_docs)]
    pub fn type_id(mut self, input: impl ::std::convert::Into<::aws_smithy_types::Blob>) -> Self {
        self.type_id = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_type_id(mut self, input: ::std::option::Option<::aws_smithy_types::Blob>) -> Self {
        self.type_id = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_type_id(&self) -> &::std::option::Option<::aws_smithy_types::Blob> {
        &self.type_id
    }
    #[allow(missing_docs)]
    pub fn value(mut self, input: impl ::std::convert::Into<::aws_smithy_types::Blob>) -> Self {
        self.value = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)]
    pub fn set_value(mut self, input: ::std::option::Option<::aws_smithy_types::Blob>) -> Self {
        self.value = input;
        self
    }
    #[allow(missing_docs)]
    pub fn get_value(&self) -> &::std::option::Option<::aws_smithy_types::Blob> {
        &self.value
    }
    /// Consumes the builder and constructs a [`StructuredDataTerminal`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredDataTerminal {
            type_id: self.type_id,
value: self.value,
        })
    }
}
