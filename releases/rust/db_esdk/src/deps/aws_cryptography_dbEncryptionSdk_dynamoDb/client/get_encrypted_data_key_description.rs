// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::client::Client {
    /// Constructs a fluent builder for the [`GetEncryptedDataKeyDescription`](crate::operation::get_encrypted_data_key_description::builders::GetEncryptedDataKeyDescriptionFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`input(impl Into<Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion>>)`](crate::operation::get_encrypted_data_key_description::builders::GetEncryptedDataKeyDescriptionFluentBuilder::input) / [`set_input(Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::GetEncryptedDataKeyDescriptionUnion>)`](crate::operation::get_encrypted_data_key_description::builders::GetEncryptedDataKeyDescriptionFluentBuilder::set_input): (undocumented)<br>
    /// - On success, responds with [`GetEncryptedDataKeyDescriptionOutput`](crate::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionOutput) with field(s):
    ///   - [`encrypted_data_key_description_output(Option<::std::vec::Vec<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::EncryptedDataKeyDescription>>)`](crate::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionOutput::encrypted_data_key_description_output): (undocumented)
    /// - On failure, responds with [`SdkError<GetEncryptedDataKeyDescriptionError>`](crate::operation::get_encrypted_data_key_description::GetEncryptedDataKeyDescriptionError)
    pub fn get_encrypted_data_key_description(&self) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::builders::GetEncryptedDataKeyDescriptionFluentBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_encrypted_data_key_description::builders::GetEncryptedDataKeyDescriptionFluentBuilder::new(self.clone())
    }
}
