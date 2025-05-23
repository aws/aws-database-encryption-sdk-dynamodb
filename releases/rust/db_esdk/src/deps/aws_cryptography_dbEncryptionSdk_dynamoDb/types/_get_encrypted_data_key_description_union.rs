// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
#[allow(missing_docs)]
pub enum GetEncryptedDataKeyDescriptionUnion {
    /// A binary header value.
    Header(::aws_smithy_types::Blob),
    /// A DynamoDB item.
    Item(
        ::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>,
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
impl GetEncryptedDataKeyDescriptionUnion {
    /// Tries to convert the enum instance into [`Header`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion::Header), extracting the inner [`::aws_smithy_types::Blob`](::aws_smithy_types::Blob).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_header(&self) -> ::std::result::Result<&::aws_smithy_types::Blob, &Self> {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion::Header(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Tries to convert the enum instance into [`Item`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion::Item), extracting the inner [`::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>`](::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>).
    /// Returns `Err(&Self)` if it can't be converted.
    pub fn as_item(
        &self,
    ) -> ::std::result::Result<
        &::std::collections::HashMap<
            ::std::string::String,
            aws_sdk_dynamodb::types::AttributeValue,
        >,
        &Self,
    > {
        if let crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion::Item(val) = &self {
        ::std::result::Result::Ok(val)
    } else {
        ::std::result::Result::Err(self)
    }
    }
    /// Returns true if this is a [`Header`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion::Header).
    pub fn is_header(&self) -> ::std::primitive::bool {
        self.as_header().is_ok()
    }
    /// Returns true if this is a [`Item`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion::Item).
    pub fn is_item(&self) -> ::std::primitive::bool {
        self.as_item().is_ok()
    }
    /// Returns true if the enum instance is the `Unknown` variant.
    pub fn is_unknown(&self) -> ::std::primitive::bool {
        matches!(self, Self::Unknown)
    }
}
