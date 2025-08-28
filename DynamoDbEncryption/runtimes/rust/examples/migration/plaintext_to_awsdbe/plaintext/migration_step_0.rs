// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;
use crate::migration::plaintext_to_awsdbe::migration_utils::{
    verify_returned_item, ENCRYPTED_AND_SIGNED_VALUE, SIGN_ONLY_VALUE, DO_NOTHING_VALUE,
};

/*
Migration Step 0: This is the pre-migration step for the
plaintext-to-encrypted database migration, and is the starting
state for our migration from a plaintext database to a
client-side encrypted database encrypted using the
AWS Database Encryption SDK for DynamoDb.

In this example, we configure a DynamoDbClient to
write a plaintext record to a table and read that record.
This emulates the starting state of a plaintext-to-encrypted
database migration; i.e. a plaintext database you can
read and write to with the DynamoDbClient.

Running this example requires access to the DDB Table whose name
is provided in the function parameter.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
*/
pub async fn migration_step_0_example(
    ddb_table_name: &str,
    partition_key_value: &str,
    sort_key_write_value: &str,
    sort_key_read_value: &str,
) -> Result<bool, Box<dyn std::error::Error>> {
    // 1. Create a standard DynamoDB client
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let ddb = aws_sdk_dynamodb::Client::new(&sdk_config);

    // 2. Put an example item into DynamoDB table
    //    This item will be stored in plaintext.
    let encrypted_and_signed_value = ENCRYPTED_AND_SIGNED_VALUE;
    let sign_only_value = SIGN_ONLY_VALUE;
    let do_nothing_value = DO_NOTHING_VALUE;
    let item = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S(partition_key_value.to_string()),
        ),
        (
            "sort_key".to_string(),
            AttributeValue::N(sort_key_write_value.to_string()),
        ),
        (
            "attribute1".to_string(),
            AttributeValue::S(encrypted_and_signed_value.to_string()),
        ),
        (
            "attribute2".to_string(),
            AttributeValue::S(sign_only_value.to_string()),
        ),
        (
            "attribute3".to_string(),
            AttributeValue::S(do_nothing_value.to_string()),
        ),
    ]);

    ddb.put_item()
        .table_name(ddb_table_name)
        .set_item(Some(item))
        .send()
        .await?;

    // 3. Get an item back from the table as it was written.
    //    If this is an item written in plaintext (i.e. any item written
    //    during Step 0 or 1), then the item will still be in plaintext
    //    and will be able to be processed.
    //    If this is an item that was encrypted client-side (i.e. any item written
    //    during Step 2 or after), then the item will still be encrypted client-side
    //    and will be unable to be processed in your code. To decrypt and process
    //    client-side encrypted items, you will need to configure encrypted reads on
    //    your dynamodb client (this is configured from Step 1 onwards).
    let key = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S(partition_key_value.to_string()),
        ),
        (
            "sort_key".to_string(),
            AttributeValue::N(sort_key_read_value.to_string()),
        ),
    ]);

    let response = ddb
        .get_item()
        .table_name(ddb_table_name)
        .set_key(Some(key))
        .send()
        .await?;

    // 4. Verify we get the expected item back
    if let Some(item) = response.item {
        let success = verify_returned_item(&item, partition_key_value, sort_key_read_value)?;
        if success {
            println!("MigrationStep0 completed successfully");
        }
        Ok(success)
    } else {
        Err("No item found".into())
    }
}

#[tokio::test(flavor = "multi_thread")]
async fn test_migration_step_0() -> Result<(), Box<dyn std::error::Error>> {
    use crate::migration::plaintext_to_awsdbe::plaintext::migration_step_0::migration_step_0_example;
    use crate::migration::plaintext_to_awsdbe::awsdbe::migration_step_2::migration_step_2_example;
    use crate::migration::plaintext_to_awsdbe::awsdbe::migration_step_3::migration_step_3_example;
    use crate::test_utils;
    use uuid::Uuid;

    let kms_key_id = test_utils::TEST_KMS_KEY_ID;
    let table_name = test_utils::TEST_DDB_TABLE_NAME;
    let partition_key = Uuid::new_v4().to_string();
    let sort_keys = ["0", "1", "2", "3"];

    // Successfully executes step 0
    let success = migration_step_0_example(table_name, &partition_key, sort_keys[0], sort_keys[0]).await?;
    assert!(success, "MigrationStep0 should complete successfully");

    // Given: Step 1 has succeeded
    migration_step_1_example(kms_key_id, table_name, &partition_key, sort_keys[1], sort_keys[1]).await?;
    
    // When: Execute Step 0 with sortReadValue=1, Then: Success (i.e. can read plaintext values)
    let success = migration_step_0_example(table_name, &partition_key, sort_keys[0], sort_keys[1]).await?;
    assert!(success, "MigrationStep0 should be able to read items written by Step 1");
    
    // Given: Step 2 has succeeded
    migration_step_2_example(kms_key_id, table_name, &partition_key, sort_keys[2], sort_keys[2]).await?;
    
    // When: Execute Step 0 with sortReadValue=2, Then: should error out when reading encrypted items.
    let result = migration_step_0_example(table_name, &partition_key, sort_keys[0], sort_keys[2]).await;
    assert!(result.is_err(), "MigrationStep0 should fail when reading encrypted items");
    assert!(result.unwrap_err().to_string().contains("attribute1 not found or not a string"));
    
    // Given: Step 3 has succeeded
    migration_step_3_example(kms_key_id, table_name, &partition_key, sort_keys[3], sort_keys[3]).await?;
    
    // When: Execute Step 0 with sortReadValue=3, Then: should error out
    let result = migration_step_0_example(table_name, &partition_key, sort_keys[0], sort_keys[3]).await;
    assert!(result.is_err(), "MigrationStep0 should fail when reading encrypted items");
    assert!(result.unwrap_err().to_string().contains("attribute1 not found or not a string"));
    
    // Cleanup
    for sort_key in &sort_keys {
        test_utils::cleanup_items(table_name, &partition_key, sort_key).await?;
    }

    Ok(())
}