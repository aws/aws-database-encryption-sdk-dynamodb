// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]
pub fn to_dafny(
    value: crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumberOutput,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetPartitionNumberOutput,
>{
    ::dafny_runtime::Rc::new(crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetPartitionNumberOutput::GetPartitionNumberOutput {
        partitionNumber: value.partition_number.clone().unwrap(),
    })
}
#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::GetPartitionNumberOutput,
    >,
) -> crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumberOutput{
    crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::operation::get_partition_number::GetPartitionNumberOutput::builder()
        .set_partition_number(Some( dafny_value.partitionNumber() .clone() ))
        .build()
        .unwrap()
}
