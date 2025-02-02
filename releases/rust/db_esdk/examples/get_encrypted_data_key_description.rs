// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use aws_db_esdk::dynamodb::client as dbesdk_client;
use aws_db_esdk::dynamodb::types::dynamo_db_encryption_config::DynamoDbEncryptionConfig;
use aws_db_esdk::dynamodb::types::GetEncryptedDataKeyDescriptionUnion;
use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;

pub async fn get_encrypted_data_key_description() -> Result<(), crate::BoxError> {
    let kms_key_id = test_utils::TEST_KMS_KEY_ID;
    let ddb_table_name = test_utils::TEST_DDB_TABLE_NAME;
    let config = DynamoDbEncryptionConfig::builder().build()?;
    let ddb_enc = dbesdk_client::Client::from_conf(config)?;

    // 1. Define keys that will be used to retrieve item from the DynamoDB table.
    let key_to_get = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("BasicPutGetExample".to_string()),
        ),
        ("sort_key".to_string(), AttributeValue::N("0".to_string())),
    ]);

    // 2. Create a Amazon DynamoDB Client and retrieve item from DynamoDB table
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let ddb = aws_sdk_dynamodb::Client::new(&sdk_config);
    let get_item_response = ddb
        .get_item()
        .set_key(Some(key_to_get))
        .table_name(ddb_table_name)
        .send()
        .await?;

    // 3. Extract the item from the dynamoDB table and prepare input for the GetEncryptedDataKeyDescription method.
    // Here, we are sending dynamodb item but you can also input the header itself by extracting the header from
    // "aws_dbe_head" attribute in the dynamoDB item. The part of the code where we send input as the header is commented.
    let returned_item = get_item_response.item.unwrap();
    let input_union = GetEncryptedDataKeyDescriptionUnion::Item(returned_item);
    let output = ddb_enc
        .get_encrypted_data_key_description()
        .input(input_union)
        .send()
        .await?;

    // The code below shows how we can send header as the input to the DynamoDB. This code is written to demo the
    // alternative approach. So, it is commented.
    // let input_union = GetEncryptedDataKeyDescriptionUnion::Header(returned_item["aws_dbe_head"].as_b().unwrap().clone());

    // 4. Get encrypted DataKey Descriptions from GetEncryptedDataKeyDescription method output and assert if its true.
    let encrypted_data_key_descriptions = output.encrypted_data_key_description_output.unwrap();
    assert_eq!(
        encrypted_data_key_descriptions[0].key_provider_id,
        Some("aws-kms".to_string())
    );
    assert_eq!(
        encrypted_data_key_descriptions[0].key_provider_info,
        Some(kms_key_id.to_string())
    );

    println!("get_encrypted_data_key_description successful.");
    Ok(())
}
