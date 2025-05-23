// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub enum BeaconStyle {
    #[allow(missing_docs)]
    PartOnly(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PartOnly),
    #[allow(missing_docs)]
    Shared(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Shared),
    #[allow(missing_docs)]
    AsSet(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::AsSet),
    #[allow(missing_docs)]
    SharedSet(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SharedSet),
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
impl BeaconStyle {
    /// Tries to convert the enum instance into [`PartOnly`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::PartOnly), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PartOnly`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PartOnly).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_part_only(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::PartOnly,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::PartOnly(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Tries to convert the enum instance into [`Shared`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::Shared), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Shared`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Shared).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_shared(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::Shared,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::Shared(
            val,
        ) = &self
        {
            ::std::result::Result::Ok(val)
        } else {
            ::std::result::Result::Err(self)
        }
    }
    /// Tries to convert the enum instance into [`AsSet`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::AsSet), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::AsSet`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::AsSet).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_as_set(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::AsSet,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::AsSet(
            val,
        ) = &self
        {
            ::std::result::Result::Ok(val)
        } else {
            ::std::result::Result::Err(self)
        }
    }
    /// Tries to convert the enum instance into [`SharedSet`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::SharedSet), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SharedSet`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SharedSet).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_shared_set(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SharedSet,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::SharedSet(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Returns true if this is a [`PartOnly`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::PartOnly).
    pub fn is_part_only(&self) -> ::std::primitive::bool {
        self.as_part_only().is_ok()
    }
    /// Returns true if this is a [`Shared`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::Shared).
    pub fn is_shared(&self) -> ::std::primitive::bool {
        self.as_shared().is_ok()
    }
    /// Returns true if this is a [`AsSet`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::AsSet).
    pub fn is_as_set(&self) -> ::std::primitive::bool {
        self.as_as_set().is_ok()
    }
    /// Returns true if this is a [`SharedSet`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconStyle::SharedSet).
    pub fn is_shared_set(&self) -> ::std::primitive::bool {
        self.as_shared_set().is_ok()
    }
    /// Returns true if the enum instance is the `Unknown` variant.
    pub fn is_unknown(&self) -> ::std::primitive::bool {
        matches!(self, Self::Unknown)
    }
}
