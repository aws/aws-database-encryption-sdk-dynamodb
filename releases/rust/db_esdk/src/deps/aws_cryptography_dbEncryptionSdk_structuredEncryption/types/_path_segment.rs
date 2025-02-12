// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub enum PathSegment {
    #[allow(missing_docs)]
    Member(
        crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructureSegment,
    ),
    /// The `Unknown` variant represents cases where new union variant was received. Consider upgrading the SDK to the latest available version.
    /// An unknown enum variant
    ///
    /// _Note: If you encounter this error, consider upgrading your SDK to the latest version._
    /// The `Unknown` variant represents cases where the server sent a value that wasn't recognized
    /// by the client. This can happen when the server adds new functionality, but the client has not been updated.
    /// To investigate this, consider turning on debug logging to print the raw HTTP response.
    #[non_exhaustive]
    Unknown,
}
impl PathSegment {
    /// Tries to convert the enum instance into [`Member`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment::Member), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructureSegment`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructureSegment).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_member(&self) -> ::std::result::Result<&crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::StructureSegment, &Self>{
        if let crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment::Member(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Returns true if this is a [`Member`](crate::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::PathSegment::Member).
    pub fn is_member(&self) -> ::std::primitive::bool {
        self.as_member().is_ok()
    }
    /// Returns true if the enum instance is the `Unknown` variant.
    pub fn is_unknown(&self) -> ::std::primitive::bool {
        matches!(self, Self::Unknown)
    }
}
