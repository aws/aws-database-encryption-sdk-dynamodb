// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(missing_docs)] // documentation missing in model
#[non_exhaustive]
#[derive(::std::clone::Clone, ::std::cmp::PartialEq, ::std::fmt::Debug)]
pub struct CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
    #[allow(missing_docs)] // documentation missing in model
pub branch_key_id_supplier: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::branch_key_id_supplier::BranchKeyIdSupplierRef>,
}
impl CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
    #[allow(missing_docs)] // documentation missing in model
    pub fn branch_key_id_supplier(&self) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::branch_key_id_supplier::BranchKeyIdSupplierRef>{
        &self.branch_key_id_supplier
    }
}
impl CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
    /// Creates a new builder-style object to manufacture [`CreateDynamoDbEncryptionBranchKeyIdSupplierOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput).
    pub fn builder() -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::CreateDynamoDbEncryptionBranchKeyIdSupplierOutputBuilder{
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::builders::CreateDynamoDbEncryptionBranchKeyIdSupplierOutputBuilder::default()
    }
}

/// A builder for [`CreateDynamoDbEncryptionBranchKeyIdSupplierOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput).
#[non_exhaustive]
#[derive(
    ::std::clone::Clone, ::std::cmp::PartialEq, ::std::default::Default, ::std::fmt::Debug,
)]
pub struct CreateDynamoDbEncryptionBranchKeyIdSupplierOutputBuilder {
    pub(crate) branch_key_id_supplier: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::branch_key_id_supplier::BranchKeyIdSupplierRef>,
}
impl CreateDynamoDbEncryptionBranchKeyIdSupplierOutputBuilder {
    #[allow(missing_docs)] // documentation missing in model
    pub fn branch_key_id_supplier(
        mut self,
        input: impl ::std::convert::Into<crate::deps::aws_cryptography_materialProviders::types::branch_key_id_supplier::BranchKeyIdSupplierRef>,
    ) -> Self {
        self.branch_key_id_supplier = ::std::option::Option::Some(input.into());
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn set_branch_key_id_supplier(
        mut self,
        input: ::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::branch_key_id_supplier::BranchKeyIdSupplierRef>,
    ) -> Self {
        self.branch_key_id_supplier = input;
        self
    }
    #[allow(missing_docs)] // documentation missing in model
    pub fn get_branch_key_id_supplier(&self) -> &::std::option::Option<crate::deps::aws_cryptography_materialProviders::types::branch_key_id_supplier::BranchKeyIdSupplierRef>{
        &self.branch_key_id_supplier
    }
    /// Consumes the builder and constructs a [`CreateDynamoDbEncryptionBranchKeyIdSupplierOutput`](crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput).
    pub fn build(
        self,
    ) -> ::std::result::Result<
        crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
        ::aws_smithy_types::error::operation::BuildError,
    >{
        ::std::result::Result::Ok(crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
            branch_key_id_supplier: self.branch_key_id_supplier,
        })
    }
}
