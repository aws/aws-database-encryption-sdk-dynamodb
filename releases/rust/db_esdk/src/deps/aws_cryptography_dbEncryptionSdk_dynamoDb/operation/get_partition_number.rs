// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
/// Orchestration and serialization glue logic for `GetPartitionNumber`.
#[derive(::std::clone::Clone, ::std::default::Default, ::std::fmt::Debug)]
#[non_exhaustive]
pub struct GetPartitionNumber;
impl GetPartitionNumber {
    /// Creates a new `GetPartitionNumber`
    pub fn new() -> Self {
        Self
    }

    pub(crate) async fn send(
        partition_selector: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::partition_selector::PartitionSelectorRef,
        input: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumberInput,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumberOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error,
    >{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HGetPartitionNumberInput_for_PartitionSelector_GetPartitionNumber(&input)
            .map_err(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error::wrap_validation_err)?;
        partition_selector
            .inner
            .lock()
            .unwrap()
            .get_partition_number(input)
    }
}

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::_get_partition_number_output::GetPartitionNumberOutput;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::_get_partition_number_input::GetPartitionNumberInput;

pub(crate) mod _get_partition_number_output;

pub(crate) mod _get_partition_number_input;

/// Builders
pub mod builders;
