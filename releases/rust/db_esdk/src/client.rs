// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
use aws_smithy_types::error::operation::BuildError;

#[derive(::std::clone::Clone, ::std::fmt::Debug, ::std::cmp::PartialEq)]
#[allow(missing_docs)]
pub struct Client {
    pub(crate) dafny_client: ::dafny_runtime::Object<dyn crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::types::IDynamoDbEncryptionTransformsClient>
}

impl Client {
    /// Creates a new client from the service [`Config`](crate::Config).
    #[track_caller]
    pub fn from_conf(
        input: crate::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfig,
    ) -> Result<Self, crate::types::error::Error> {
        crate::validation::validate_aws_Pcryptography_PdbEncryptionSdk_PdynamoDb_HDynamoDbTablesEncryptionConfig(&input)
            .map_err(crate::types::error::Error::wrap_validation_err)?;
        let inner =
            crate::software::amazon::cryptography::dbencryptionsdk::dynamodb::transforms::internaldafny::_default::DynamoDbEncryptionTransforms(
                &crate::conversions::dynamo_db_tables_encryption_config::_dynamo_db_tables_encryption_config::to_dafny(input),
            );
        if matches!(
            inner.as_ref(),
            crate::_Wrappers_Compile::Result::Failure { .. }
        ) {
            return Err(crate::conversions::error::from_dafny(
                inner.as_ref().error().clone(),
            ));
        }
        Ok(Self {
            dafny_client: ::dafny_runtime::upcast_object()(inner.Extract()),
        })
    }
}

mod put_item_input_transform;

mod put_item_output_transform;

mod get_item_input_transform;

mod get_item_output_transform;

mod batch_write_item_input_transform;

mod batch_write_item_output_transform;

mod batch_get_item_input_transform;

mod batch_get_item_output_transform;

mod scan_input_transform;

mod scan_output_transform;

mod query_input_transform;

mod query_output_transform;

mod transact_write_items_input_transform;

mod transact_write_items_output_transform;

mod update_item_input_transform;

mod update_item_output_transform;

mod delete_item_input_transform;

mod delete_item_output_transform;

mod transact_get_items_input_transform;

mod transact_get_items_output_transform;

mod execute_statement_input_transform;

mod execute_statement_output_transform;

mod batch_execute_statement_input_transform;

mod batch_execute_statement_output_transform;

mod execute_transaction_input_transform;

mod execute_transaction_output_transform;

mod resolve_attributes;
