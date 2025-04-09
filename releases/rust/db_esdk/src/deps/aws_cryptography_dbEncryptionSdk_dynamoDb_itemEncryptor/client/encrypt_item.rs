// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::client::Client {
    /// Constructs a fluent builder for the [`EncryptItem`](crate::operation::encrypt_item::builders::EncryptItemFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`plaintext_item(impl Into<Option<::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>>>)`](crate::operation::encrypt_item::builders::EncryptItemFluentBuilder::plaintext_item) / [`set_plaintext_item(Option<::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>>)`](crate::operation::encrypt_item::builders::EncryptItemFluentBuilder::set_plaintext_item): (undocumented)<br>
    /// - On success, responds with [`EncryptItemOutput`](crate::operation::encrypt_item::EncryptItemOutput) with field(s):
    ///   - [`encrypted_item(Option<::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>>)`](crate::operation::encrypt_item::EncryptItemOutput::encrypted_item): (undocumented)
    ///   - [`parsed_header(Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::ParsedHeader>)`](crate::operation::encrypt_item::EncryptItemOutput::parsed_header): (undocumented)
    /// - On failure, responds with [`SdkError<EncryptItemError>`](crate::operation::encrypt_item::EncryptItemError)
    pub fn encrypt_item(&self) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::encrypt_item::builders::EncryptItemFluentBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::operation::encrypt_item::builders::EncryptItemFluentBuilder::new(self.clone())
    }
}
