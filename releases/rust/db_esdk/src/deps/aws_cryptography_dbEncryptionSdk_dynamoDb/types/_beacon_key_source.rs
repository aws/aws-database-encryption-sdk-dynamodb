// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub enum BeaconKeySource {
    #[allow(missing_docs)]
    Single(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SingleKeyStore),
    #[allow(missing_docs)]
    Multi(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::MultiKeyStore),
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
impl BeaconKeySource {
    /// Tries to convert the enum instance into [`Single`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource::Single), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SingleKeyStore`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SingleKeyStore).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_single(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SingleKeyStore,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource::Single(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Tries to convert the enum instance into [`Multi`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource::Multi), extracting the inner [`crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::MultiKeyStore`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::MultiKeyStore).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_multi(
        &self,
    ) -> ::std::result::Result<
        &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::MultiKeyStore,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource::Multi(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Returns true if this is a [`Single`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource::Single).
    pub fn is_single(&self) -> ::std::primitive::bool {
        self.as_single().is_ok()
    }
    /// Returns true if this is a [`Multi`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource::Multi).
    pub fn is_multi(&self) -> ::std::primitive::bool {
        self.as_multi().is_ok()
    }
    /// Returns true if the enum instance is the `Unknown` variant.
    pub fn is_unknown(&self) -> ::std::primitive::bool {
        matches!(self, Self::Unknown)
    }
}
