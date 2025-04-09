// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
use aws_smithy_types::error::operation::BuildError;

#[derive(::std::clone::Clone, ::std::fmt::Debug, ::std::cmp::PartialEq)]
#[allow(missing_docs)]
pub struct Client {
    pub(crate) dafny_client: ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::types::IDynamoDbItemEncryptorClient>
}

impl Client {
    /// Creates a new client from the service [`Config`](crate::Config).
    #[track_caller]
    pub fn from_conf(
        input: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::dynamo_db_item_encryptor_config::DynamoDbItemEncryptorConfig,
    ) -> Result<
        Self,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::error::Error,
    > {
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_PitemEncryptor_HDynamoDbItemEncryptorConfig(&input)
            .map_err(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::types::error::Error::wrap_validation_err)?;
        let inner =
            crate::software::amazon::cryptography::dbencryptionsdk::dynamodb::itemencryptor::internaldafny::_default::DynamoDbItemEncryptor(
                &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::dynamo_db_item_encryptor_config::_dynamo_db_item_encryptor_config::to_dafny(input),
            );
        if matches!(
            inner.as_ref(),
            crate::_Wrappers_Compile::Result::Failure { .. }
        ) {
            return Err(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb_itemEncryptor::conversions::error::from_dafny(inner.as_ref().error().clone()));
        }
        Ok(Self {
            dafny_client: ::dafny_runtime::upcast_object()(inner.Extract()),
        })
    }
}

mod encrypt_item;

mod decrypt_item;
