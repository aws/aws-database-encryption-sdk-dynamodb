// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
    #[allow(missing_docs)] // documentation missing in model
pub ddb_key_branch_key_id_supplier: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>,
}
impl CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn ddb_key_branch_key_id_supplier(&self) -> &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>{
        &self.ddb_key_branch_key_id_supplier
    }
}
impl CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
    /// Creates a new builder-style object to manufacture [`CreateDynamoDbEncryptionBranchKeyIdSupplierInput`](crate::operation::create_dynamo_db_encryption_branch_key_id_supplier::builders::CreateDynamoDbEncryptionBranchKeyIdSupplierInput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::builders::CreateDynamoDbEncryptionBranchKeyIdSupplierInputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::builders::CreateDynamoDbEncryptionBranchKeyIdSupplierInputBuilder::default()
    }
}

/// A builder for [`CreateDynamoDbEncryptionBranchKeyIdSupplierInput`](crate::operation::operation::CreateDynamoDbEncryptionBranchKeyIdSupplierInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct CreateDynamoDbEncryptionBranchKeyIdSupplierInputBuilder {
    pub(crate) ddb_key_branch_key_id_supplier: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>,
}
impl CreateDynamoDbEncryptionBranchKeyIdSupplierInputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn ddb_key_branch_key_id_supplier(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>,
    ) -> Self {
        self.ddb_key_branch_key_id_supplier = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_ddb_key_branch_key_id_supplier(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>,
    ) -> Self {
        self.ddb_key_branch_key_id_supplier = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_ddb_key_branch_key_id_supplier(&self) -> &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>{
        &self.ddb_key_branch_key_id_supplier
    }
    /// Consumes the builder and constructs a [`CreateDynamoDbEncryptionBranchKeyIdSupplierInput`](crate::operation::operation::CreateDynamoDbEncryptionBranchKeyIdSupplierInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplierInput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
            ddb_key_branch_key_id_supplier: self.ddb_key_branch_key_id_supplier,
        })
    }
}
