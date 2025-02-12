// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
use aws_smithy_types::error::operation::BuildError;

#[derive(::std::clone::Clone, ::std::fmt::Debug, ::std::cmp::PartialEq)]
#[allow(missing_docs)]
pub struct Client {
    pub(crate) dafny_client: ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IDynamoDbEncryptionClient>
}

impl Client {
    /// Creates a new client from the service [`Config`](crate::Config).
    #[track_caller]
    pub fn from_conf(
        input: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfig,
    ) -> Result<Self, crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error>
    {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbEncryptionConfig(&input)
            .map_err(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error::wrap_validation_err)?;
        let inner =
            crate::software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::_default::DynamoDbEncryption(
                &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::dynamo_db_encryption_config::_dynamo_db_encryption_config::to_dafny(input),
            );
        if matches!(
            inner.as_ref(),
            crate::_Wrappers_Compile::Result::Failure { .. }
        ) {
            return Err(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::error::from_dafny(inner.as_ref().error().clone()));
        }
        Ok(Self {
            dafny_client: ::dafny_runtime::upcast_object()(inner.Extract()),
        })
    }
}

mod create_dynamo_db_encryption_branch_key_id_supplier;

mod get_encrypted_data_key_description;
