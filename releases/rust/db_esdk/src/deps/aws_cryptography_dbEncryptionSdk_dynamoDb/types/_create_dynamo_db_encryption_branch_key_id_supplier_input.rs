// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
/// Inputs for creating a Branch Key Supplier from a DynamoDB Key Branch Key Id Supplier
pub struct CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
    /// An implementation of the DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to use for data key wrapping/unwrapping based on the DynamoDB item being written/read.
pub ddb_key_branch_key_id_supplier: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>,
}
impl CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
    /// An implementation of the DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to use for data key wrapping/unwrapping based on the DynamoDB item being written/read.
    pub fn ddb_key_branch_key_id_supplier(&self) -> &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>{
        &self.ddb_key_branch_key_id_supplier
    }
}
impl CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
    /// Creates a new builder-style object to manufacture [`CreateDynamoDbEncryptionBranchKeyIdSupplierInput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierInput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::CreateDynamoDbEncryptionBranchKeyIdSupplierInputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::CreateDynamoDbEncryptionBranchKeyIdSupplierInputBuilder::default()
    }
}

/// A builder for [`CreateDynamoDbEncryptionBranchKeyIdSupplierInput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierInput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct CreateDynamoDbEncryptionBranchKeyIdSupplierInputBuilder {
    pub(crate) ddb_key_branch_key_id_supplier: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>,
}
impl CreateDynamoDbEncryptionBranchKeyIdSupplierInputBuilder {
    /// An implementation of the DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to use for data key wrapping/unwrapping based on the DynamoDB item being written/read.
    pub fn ddb_key_branch_key_id_supplier(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>,
    ) -> Self {
        self.ddb_key_branch_key_id_supplier = ::std::option::Option::Some(input.into());
        self
    }
    /// An implementation of the DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to use for data key wrapping/unwrapping based on the DynamoDB item being written/read.
    pub fn set_ddb_key_branch_key_id_supplier(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>,
    ) -> Self {
        self.ddb_key_branch_key_id_supplier = input;
        self
    }
    /// An implementation of the DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to use for data key wrapping/unwrapping based on the DynamoDB item being written/read.
    pub fn get_ddb_key_branch_key_id_supplier(&self) -> &::std::option::Option<crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::dynamo_db_key_branch_key_id_supplier::DynamoDbKeyBranchKeyIdSupplierRef>{
        &self.ddb_key_branch_key_id_supplier
    }
    /// Consumes the builder and constructs a [`CreateDynamoDbEncryptionBranchKeyIdSupplierInput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierInput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierInput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
            ddb_key_branch_key_id_supplier: self.ddb_key_branch_key_id_supplier,
        })
    }
}
