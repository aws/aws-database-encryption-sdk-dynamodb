// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// The configuration for a particular version of searchable encryption. Currently the only supported version is '1'.
pub struct BeaconVersion {
    /// The Compound Beacons to be written with items.
    pub compound_beacons: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
        >,
    >,
    /// The list of Encrypted Parts that may be included in any compound beacon.
    pub encrypted_parts: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
        >,
    >,
    /// The configuration for what beacon key(s) to use.
    pub key_source: ::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource,
    >,
    /// The Key Store that contains the Beacon Keys to use with searchable encryption.
    pub key_store: ::std::option::Option<crate::deps::aws_cryptography_keyStore::client::Client>,
    /// The list of Signed Parts that may be included in any compound beacon.
    pub signed_parts: ::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart>,
    >,
    /// The Standard Beacons to be written with items.
    pub standard_beacons: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon,
        >,
    >,
    /// The version of searchable encryption configured. This must be '1'.
    pub version: ::std::option::Option<::std::primitive::i32>,
    /// The Virtual Fields to be calculated, supporting other searchable enryption configurations.
    pub virtual_fields: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField,
        >,
    >,
}
impl BeaconVersion {
    /// The Compound Beacons to be written with items.
    pub fn compound_beacons(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
        >,
    > {
        &self.compound_beacons
    }
    /// The list of Encrypted Parts that may be included in any compound beacon.
    pub fn encrypted_parts(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
        >,
    > {
        &self.encrypted_parts
    }
    /// The configuration for what beacon key(s) to use.
    pub fn key_source(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource,
    > {
        &self.key_source
    }
    /// The Key Store that contains the Beacon Keys to use with searchable encryption.
    pub fn key_store(
        &self,
    ) -> &::std::option::Option<crate::deps::aws_cryptography_keyStore::client::Client> {
        &self.key_store
    }
    /// The list of Signed Parts that may be included in any compound beacon.
    pub fn signed_parts(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart>,
    > {
        &self.signed_parts
    }
    /// The Standard Beacons to be written with items.
    pub fn standard_beacons(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon,
        >,
    > {
        &self.standard_beacons
    }
    /// The version of searchable encryption configured. This must be '1'.
    pub fn version(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.version
    }
    /// The Virtual Fields to be calculated, supporting other searchable enryption configurations.
    pub fn virtual_fields(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField,
        >,
    > {
        &self.virtual_fields
    }
}
impl BeaconVersion {
    /// Creates a new builder-style object to manufacture [`BeaconVersion`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion).
    pub fn builder(
    ) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::BeaconVersionBuilder
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::BeaconVersionBuilder::default()
    }
}

/// A builder for [`BeaconVersion`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct BeaconVersionBuilder {
    pub(crate) compound_beacons: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
        >,
    >,
    pub(crate) encrypted_parts: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
        >,
    >,
    pub(crate) key_source: ::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource,
    >,
    pub(crate) key_store:
        ::std::option::Option<crate::deps::aws_cryptography_keyStore::client::Client>,
    pub(crate) signed_parts: ::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart>,
    >,
    pub(crate) standard_beacons: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon,
        >,
    >,
    pub(crate) version: ::std::option::Option<::std::primitive::i32>,
    pub(crate) virtual_fields: ::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField,
        >,
    >,
}
impl BeaconVersionBuilder {
    /// The Compound Beacons to be written with items.
    pub fn compound_beacons(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
            >,
        >,
    ) -> Self {
        self.compound_beacons = ::std::option::Option::Some(input.into());
        self
    }
    /// The Compound Beacons to be written with items.
    pub fn set_compound_beacons(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
            >,
        >,
    ) -> Self {
        self.compound_beacons = input;
        self
    }
    /// The Compound Beacons to be written with items.
    pub fn get_compound_beacons(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CompoundBeacon,
        >,
    > {
        &self.compound_beacons
    }
    /// The list of Encrypted Parts that may be included in any compound beacon.
    pub fn encrypted_parts(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
            >,
        >,
    ) -> Self {
        self.encrypted_parts = ::std::option::Option::Some(input.into());
        self
    }
    /// The list of Encrypted Parts that may be included in any compound beacon.
    pub fn set_encrypted_parts(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
            >,
        >,
    ) -> Self {
        self.encrypted_parts = input;
        self
    }
    /// The list of Encrypted Parts that may be included in any compound beacon.
    pub fn get_encrypted_parts(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedPart,
        >,
    > {
        &self.encrypted_parts
    }
    /// The configuration for what beacon key(s) to use.
    pub fn key_source(
        mut self,
        input: impl ::std::convert::Into<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource,
        >,
    ) -> Self {
        self.key_source = ::std::option::Option::Some(input.into());
        self
    }
    /// The configuration for what beacon key(s) to use.
    pub fn set_key_source(
        mut self,
        input: ::std::option::Option<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource,
        >,
    ) -> Self {
        self.key_source = input;
        self
    }
    /// The configuration for what beacon key(s) to use.
    pub fn get_key_source(
        &self,
    ) -> &::std::option::Option<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconKeySource,
    > {
        &self.key_source
    }
    /// The Key Store that contains the Beacon Keys to use with searchable encryption.
    pub fn key_store(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_keyStore::client::Client>,
    ) -> Self {
        self.key_store = ::std::option::Option::Some(input.into());
        self
    }
    /// The Key Store that contains the Beacon Keys to use with searchable encryption.
    pub fn set_key_store(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_keyStore::client::Client>,
    ) -> Self {
        self.key_store = input;
        self
    }
    /// The Key Store that contains the Beacon Keys to use with searchable encryption.
    pub fn get_key_store(
        &self,
    ) -> &::std::option::Option<crate::deps::aws_cryptography_keyStore::client::Client> {
        &self.key_store
    }
    /// The list of Signed Parts that may be included in any compound beacon.
    pub fn signed_parts(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart,
            >,
        >,
    ) -> Self {
        self.signed_parts = ::std::option::Option::Some(input.into());
        self
    }
    /// The list of Signed Parts that may be included in any compound beacon.
    pub fn set_signed_parts(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart,
            >,
        >,
    ) -> Self {
        self.signed_parts = input;
        self
    }
    /// The list of Signed Parts that may be included in any compound beacon.
    pub fn get_signed_parts(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::SignedPart>,
    > {
        &self.signed_parts
    }
    /// The Standard Beacons to be written with items.
    pub fn standard_beacons(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon,
            >,
        >,
    ) -> Self {
        self.standard_beacons = ::std::option::Option::Some(input.into());
        self
    }
    /// The Standard Beacons to be written with items.
    pub fn set_standard_beacons(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon,
            >,
        >,
    ) -> Self {
        self.standard_beacons = input;
        self
    }
    /// The Standard Beacons to be written with items.
    pub fn get_standard_beacons(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::StandardBeacon,
        >,
    > {
        &self.standard_beacons
    }
    /// The version of searchable encryption configured. This must be '1'.
    pub fn version(mut self, input: impl ::std::convert::Into<::std::primitive::i32>) -> Self {
        self.version = ::std::option::Option::Some(input.into());
        self
    }
    /// The version of searchable encryption configured. This must be '1'.
    pub fn set_version(mut self, input: ::std::option::Option<::std::primitive::i32>) -> Self {
        self.version = input;
        self
    }
    /// The version of searchable encryption configured. This must be '1'.
    pub fn get_version(&self) -> &::std::option::Option<::std::primitive::i32> {
        &self.version
    }
    /// The Virtual Fields to be calculated, supporting other searchable enryption configurations.
    pub fn virtual_fields(
        mut self,
        input: impl ::std::convert::Into<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField,
            >,
        >,
    ) -> Self {
        self.virtual_fields = ::std::option::Option::Some(input.into());
        self
    }
    /// The Virtual Fields to be calculated, supporting other searchable enryption configurations.
    pub fn set_virtual_fields(
        mut self,
        input: ::std::option::Option<
            ::std::vec::Vec<
                crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField,
            >,
        >,
    ) -> Self {
        self.virtual_fields = input;
        self
    }
    /// The Virtual Fields to be calculated, supporting other searchable enryption configurations.
    pub fn get_virtual_fields(
        &self,
    ) -> &::std::option::Option<
        ::std::vec::Vec<
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::VirtualField,
        >,
    > {
        &self.virtual_fields
    }
    /// Consumes the builder and constructs a [`BeaconVersion`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion,
        ::aws_smithy_types::error::operation::BuildError,
    > {
        ::std::result::Result::Ok(
            crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::BeaconVersion {
                compound_beacons: self.compound_beacons,
                encrypted_parts: self.encrypted_parts,
                key_source: self.key_source,
                key_store: self.key_store,
                signed_parts: self.signed_parts,
                standard_beacons: self.standard_beacons,
                version: self.version,
                virtual_fields: self.virtual_fields,
            },
        )
    }
}
