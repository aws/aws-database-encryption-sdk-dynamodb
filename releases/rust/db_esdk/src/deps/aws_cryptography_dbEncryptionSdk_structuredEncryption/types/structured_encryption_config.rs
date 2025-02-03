// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub struct StructuredEncryptionConfig {}
impl StructuredEncryptionConfig {}
impl StructuredEncryptionConfig {
    /// Creates a new builder-style object to manufacture [`StructuredEncryptionConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredEncryptionConfig).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::structured_encryption_config::StructuredEncryptionConfigBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::structured_encryption_config::StructuredEncryptionConfigBuilder::default()
    }
}

/// A builder for [`StructuredEncryptionConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredEncryptionConfig).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct StructuredEncryptionConfigBuilder {}
impl StructuredEncryptionConfigBuilder {
    /// Consumes the builder and constructs a [`StructuredEncryptionConfig`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructuredEncryptionConfig).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::structured_encryption_config::StructuredEncryptionConfig,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::structured_encryption_config::StructuredEncryptionConfig {

        })
    }
}
