// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput {
        branchKeyIdSupplier: crate::deps::aws_cryptography_materialProviders::conversions::branch_key_id_supplier::to_dafny(&value.branch_key_id_supplier.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput{
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplierOutput::builder()
        .set_branch_key_id_supplier(Some( crate::deps::aws_cryptography_materialProviders::conversions::branch_key_id_supplier::from_dafny(dafny_value.branchKeyIdSupplier().clone())
 ))
        .build()
        .unwrap()
}
