// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplierInput,
) -> ::std::rc::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierInput,
>{
    ::std::rc::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierInput::CreateDynamoDbEncryptionBranchKeyIdSupplierInput {
        ddbKeyBranchKeyIdSupplier: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::dynamo_db_key_branch_key_id_supplier::to_dafny(&value.ddb_key_branch_key_id_supplier.clone().unwrap())
,
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::std::rc::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::CreateDynamoDbEncryptionBranchKeyIdSupplierInput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplierInput{
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::create_dynamo_db_encryption_branch_key_id_supplier::CreateDynamoDbEncryptionBranchKeyIdSupplierInput::builder()
        .set_ddb_key_branch_key_id_supplier(Some( crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::dynamo_db_key_branch_key_id_supplier::from_dafny(dafny_value.ddbKeyBranchKeyIdSupplier().clone())
 ))
        .build()
        .unwrap()
}
