// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
use aws_smithy_types::error::operation::BuildError;

#[derive(::std::clone::Clone, ::std::fmt::Debug, ::std::cmp::PartialEq)]
pub struct Client {
    pub(crate) dafny_client: ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::IDynamoDbEncryptionClient>
}

impl Client {
    /// Creates a new client from the service [`Config`](crate::Config).
    #[track_caller]
    pub fn from_conf(
        conf: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfig,
    ) -> Result<Self, BuildError> {
        let inner =
            crate::software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::_default::DynamoDbEncryption(
                &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::dynamo_db_encryption_config::_dynamo_db_encryption_config::to_dafny(conf),
            );
        if matches!(
            inner.as_ref(),
            crate::_Wrappers_Compile::Result::Failure { .. }
        ) {
            return Err(BuildError::other(
                ::aws_smithy_types::error::metadata::ErrorMetadata::builder()
                    .message("Invalid client config")
                    .build(),
            ));
        }
        Ok(Self {
            dafny_client: ::dafny_runtime::upcast_object()(inner.Extract()),
        })
    }
}

mod create_dynamo_db_encryption_branch_key_id_supplier;

mod get_encrypted_data_key_description;
