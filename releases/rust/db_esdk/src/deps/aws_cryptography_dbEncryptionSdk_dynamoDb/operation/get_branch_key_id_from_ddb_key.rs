// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Orchestration and serialization glue logic for `GetBranchKeyIdFromDdbKey`.
#[derive(::std::clone::Clone, ::std::default::Default, ::std::fmt::Debug)]
#[non_exhaustive]
pub struct GetBranchKeyIdFromDdbKey;
impl GetBranchKeyIdFromDdbKey {
    /// Creates a new `GetBranchKeyIdFromDdbKey`
    pub fn new() -> Self {
        Self
    }

    pub(crate) async fn send(
        dynamo_db_key_branch_key_id_supplier: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef,
        input: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyInput,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::GetBranchKeyIdFromDdbKeyOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error,
    >{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetBranchKeyIdFromDdbKeyInput_for_DynamoDbKeyBranchKeyIdSupplier_GetBranchKeyIdFromDdbKey(&input)
            .map_err(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error::wrap_validation_err)?;
        dynamo_db_key_branch_key_id_supplier
            .inner
            .lock()
            .unwrap()
            .get_branch_key_id_from_ddb_key(input)
    }
}

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::_get_branch_key_id_from_ddb_key_output::GetBranchKeyIdFromDdbKeyOutput;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_branch_key_id_from_ddb_key::_get_branch_key_id_from_ddb_key_input::GetBranchKeyIdFromDdbKeyInput;

pub(crate) mod _get_branch_key_id_from_ddb_key_output;

pub(crate) mod _get_branch_key_id_from_ddb_key_input;

/// Builders
pub mod builders;
