// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub enum VirtualTransform {
    #[allow(missing_docs)]
    Upper(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Upper),
    #[allow(missing_docs)]
    Lower(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Lower),
    #[allow(missing_docs)]
    Insert(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Insert),
    #[allow(missing_docs)]
    Prefix(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPrefix),
    #[allow(missing_docs)]
    Suffix(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSuffix),
    #[allow(missing_docs)]
    Substring(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSubstring),
    #[allow(missing_docs)]
    Segment(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegment),
    #[allow(missing_docs)]
    Segments(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegments),
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
impl VirtualTransform {
    /// Tries to convert the enum instance into [`Upper`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Upper), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Upper`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Upper).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_upper(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Upper,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Upper(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Tries to convert the enum instance into [`Lower`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Lower), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Lower`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Lower).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_lower(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Lower,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Lower(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Tries to convert the enum instance into [`Insert`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Insert), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Insert`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Insert).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_insert(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Insert,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Insert(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Tries to convert the enum instance into [`Prefix`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Prefix), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPrefix`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPrefix).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_prefix(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetPrefix,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Prefix(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Tries to convert the enum instance into [`Suffix`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Suffix), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSuffix`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSuffix).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_suffix(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSuffix,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Suffix(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Tries to convert the enum instance into [`Substring`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Substring), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSubstring`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSubstring).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_substring(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSubstring,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Substring(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Tries to convert the enum instance into [`Segment`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Segment), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegment`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegment).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_segment(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegment,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Segment(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Tries to convert the enum instance into [`Segments`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Segments), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegments`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegments).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_segments(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetSegments,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Segments(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Returns true if this is a [`Upper`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Upper).
    pub fn is_upper(&self) -> ::std::primitive::bool {
        self.as_upper().is_ok()
    }
    /// Returns true if this is a [`Lower`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Lower).
    pub fn is_lower(&self) -> ::std::primitive::bool {
        self.as_lower().is_ok()
    }
    /// Returns true if this is a [`Insert`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Insert).
    pub fn is_insert(&self) -> ::std::primitive::bool {
        self.as_insert().is_ok()
    }
    /// Returns true if this is a [`Prefix`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Prefix).
    pub fn is_prefix(&self) -> ::std::primitive::bool {
        self.as_prefix().is_ok()
    }
    /// Returns true if this is a [`Suffix`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Suffix).
    pub fn is_suffix(&self) -> ::std::primitive::bool {
        self.as_suffix().is_ok()
    }
    /// Returns true if this is a [`Substring`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Substring).
    pub fn is_substring(&self) -> ::std::primitive::bool {
        self.as_substring().is_ok()
    }
    /// Returns true if this is a [`Segment`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Segment).
    pub fn is_segment(&self) -> ::std::primitive::bool {
        self.as_segment().is_ok()
    }
    /// Returns true if this is a [`Segments`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualTransform::Segments).
    pub fn is_segments(&self) -> ::std::primitive::bool {
        self.as_segments().is_ok()
    }
    /// Returns true if the enum instance is the `Unknown` variant.
    pub fn is_unknown(&self) -> ::std::primitive::bool {
        matches!(self, Self::Unknown)
    }
}
