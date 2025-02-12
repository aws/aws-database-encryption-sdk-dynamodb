// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
#[allow(dead_code)]

pub fn to_dafny(
    value: crate::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfig,
) -> ::dafny_runtime::Rc<
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbTablesEncryptionConfig,
>{
    ::dafny_runtime::Rc::new(to_dafny_plain(value))
}

#[allow(dead_code)]
pub fn from_dafny(
    dafny_value: ::dafny_runtime::Rc<
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbTablesEncryptionConfig,
    >,
) -> crate::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfig {
    plain_from_dafny(&*dafny_value)
}

#[allow(dead_code)]
pub fn to_dafny_plain(
    value: crate::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfig,
) -> crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbTablesEncryptionConfig{
    crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbTablesEncryptionConfig::DynamoDbTablesEncryptionConfig {
        tableEncryptionConfigs: ::dafny_runtime::dafny_runtime_conversions::hashmap_to_dafny_map(&value.table_encryption_configs.clone().unwrap(),
    |k| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::string_to_dafny_string(&k),
    |v| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::dynamo_db_table_encryption_config::to_dafny(&v.clone())
,
)
,
    }
}

#[allow(dead_code)]
pub fn plain_from_dafny(
    dafny_value: &crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbTablesEncryptionConfig,
) -> crate::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfig {
    match dafny_value {
        crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbTablesEncryptionConfig::DynamoDbTablesEncryptionConfig {..} =>
            crate::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfig::builder()
                .set_table_encryption_configs(Some( ::dafny_runtime::dafny_runtime_conversions::dafny_map_to_hashmap(&dafny_value.tableEncryptionConfigs(),
    |k: &::dafny_runtime::dafny_runtime_conversions::DafnySequence<::dafny_runtime::dafny_runtime_conversions::DafnyCharUTF16>| dafny_runtime::dafny_runtime_conversions::unicode_chars_false::dafny_string_to_string(k),
    |v: &::dafny_runtime::Rc<crate::r#software::amazon::cryptography::dbencryptionsdk::dynamodb::internaldafny::types::DynamoDbTableEncryptionConfig>| crate::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::conversions::dynamo_db_table_encryption_config::from_dafny(v.clone())
,
)
 ))
                .build()
                .unwrap()
    }
}
