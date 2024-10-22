// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
impl crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef {
    /// Constructs a fluent builder for the [`GetBranchKeyIdFromDdbKey`](crate::operation::get_branch_key_id_from_ddb_key::builders::GetBranchKeyIdFromDdbKeyFluentBuilder) operation.
    ///
    /// - The fluent builder is configurable:
    ///   - [`ddb_key(impl Into<Option<::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>>>)`](crate::operation::get_branch_key_id_from_ddb_key::builders::GetBranchKeyIdFromDdbKeyFluentBuilder::ddb_key) / [`set_ddb_key(Option<::std::collections::HashMap<::std::string::String, aws_sdk_dynamodb::types::AttributeValue>>)`](crate::operation::get_branch_key_id_from_ddb_key::builders::GetBranchKeyIdFromDdbKeyFluentBuilder::set_ddb_key): (undocumented)<br>
    /// - On success, responds with [`GetBranchKeyIdFromDdbKeyOutput`](crate::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyOutput) with field(s):
    ///   - [`branch_key_id(Option<::std::string::String>)`](crate::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyOutput::branch_key_id): (undocumented)
    /// - On failure, responds with [`SdkError<GetBranchKeyIdFromDdbKeyError>`](crate::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyError)
    pub fn get_branch_key_id_from_ddb_key(&self) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::builders::GetBranchKeyIdFromDdbKeyFluentBuilder {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::builders::GetBranchKeyIdFromDdbKeyFluentBuilder::new(self.clone())
    }
}
