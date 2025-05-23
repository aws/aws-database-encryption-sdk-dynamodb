// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::_create_dynamo_db_encryption_branch_key_id_supplier_output::CreateDynamoDbEncryptionBranchKeyIdSupplierOutputBuilder;

pub use crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::_create_dynamo_db_encryption_branch_key_id_supplier_input::CreateDynamoDbEncryptionBranchKeyIdSupplierInputBuilder;

impl CreateDynamoDbEncryptionBranchKeyIdSupplierInputBuilder {
    /// Sends a request with this input using the given client.
    pub async fn send_with(
        self,
        client: &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::client::Client,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error,
    >{
        let mut fluent_builder = client.create_dynamo_db_encryption_branch_key_id_supplier();
        fluent_builder.inner = self;
        fluent_builder.send().await
    }
}
/// Fluent builder constructing a request to `CreateDynamoDbEncryptionBranchKeyIdSupplier`.
///
/// Create a Branch Key Supplier for use with the Hierarchical Keyring that decides what Branch Key to use based on the primary key of the DynamoDB item being read or written.
#[derive(::std::clone::Clone, ::std::fmt::Debug)]
pub struct CreateDynamoDbEncryptionBranchKeyIdSupplierFluentBuilder {
    client: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::client::Client,
    pub(crate) inner: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::builders::CreateDynamoDbEncryptionBranchKeyIdSupplierInputBuilder,
}
impl CreateDynamoDbEncryptionBranchKeyIdSupplierFluentBuilder {
    /// Creates a new `CreateDynamoDbEncryptionBranchKeyIdSupplier`.
    pub(crate) fn new(
        client: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::client::Client,
    ) -> Self {
        Self {
            client,
            inner: ::std::default::Default::default(),
        }
    }
    /// Access the CreateDynamoDbEncryptionBranchKeyIdSupplier as a reference.
    pub fn as_input(&self) -> &crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::builders::CreateDynamoDbEncryptionBranchKeyIdSupplierInputBuilder{
        &self.inner
    }
    /// Sends the request and returns the response.
    pub async fn send(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error,
    >{
        let input = self
            .inner
            .build()
            // Using Opaque since we don't have a validation-specific error yet.
            // Operations' models don't declare their own validation error,
            // and smithy-rs seems to not generate a ValidationError case unless there is.
            // Vanilla smithy-rs uses SdkError::construction_failure, but we aren't using SdkError.
            .map_err(|mut e| {
	     let msg = format!("{:?}", e);
             crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::error::Error::OpaqueWithText {
                obj: ::dafny_runtime::Object::from_ref(&mut e as &mut ::dafny_runtime::DynAny),
		objMessage: msg
             }})?;
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplier::send(&self.client, input).await
    }

    /// An implementation of the DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to use for data key wrapping/unwrapping based on the DynamoDB item being written/read.
    pub fn ddb_key_branch_key_id_supplier(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>,
    ) -> Self {
        self.inner = self.inner.ddb_key_branch_key_id_supplier(input.into());
        self
    }
    /// An implementation of the DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to use for data key wrapping/unwrapping based on the DynamoDB item being written/read.
    pub fn set_ddb_key_branch_key_id_supplier(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>,
    ) -> Self {
        self.inner = self.inner.set_ddb_key_branch_key_id_supplier(input);
        self
    }
    /// An implementation of the DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to use for data key wrapping/unwrapping based on the DynamoDB item being written/read.
    pub fn get_ddb_key_branch_key_id_supplier(&self) -> &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>{
        self.inner.get_ddb_key_branch_key_id_supplier()
    }
}
