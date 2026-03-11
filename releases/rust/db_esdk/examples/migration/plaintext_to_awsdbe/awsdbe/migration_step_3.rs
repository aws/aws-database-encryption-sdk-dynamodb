// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::migration::plaintext_to_awsdbe::awsdbe::common::create_table_configs;
use crate::migration::plaintext_to_awsdbe::migration_utils::{
    verify_returned_item, DO_NOTHING_VALUE, ENCRYPTED_AND_SIGNED_VALUE, SIGN_ONLY_VALUE,
};
use aws_db_esdk::dynamodb::types::PlaintextOverride;
use aws_db_esdk::intercept::DbEsdkInterceptor;
use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;

/*
Migration Step 3: This is the final step in the migration process from
plaintext to encrypted DynamoDB using the AWS Database Encryption SDK.

In this example, we configure a DynamoDB Encryption client to do the following:
1. Write items with encryption (no longer writing plaintext)
2. Read only encrypted items (no longer reading plaintext)

Once you complete Step 3, all items being read by your system are encrypted.

Before you move onto this step, you will need to encrypt all plaintext items in your dataset.
How you will want to do this depends on your system.

Running this example requires access to the DDB Table whose name
is provided in the function parameter.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
*/
pub async fn migration_step_3_example(
    kms_key_id: &str,
    ddb_table_name: &str,
    partition_key_value: &str,
    sort_key_write_value: &str,
    sort_key_read_value: &str,
) -> Result<bool, Box<dyn std::error::Error>> {
    // 1. Create table configurations
    // In this step of migration we will use PlaintextOverride::ForbidPlaintextWriteForbidPlaintextRead
    // which means:
    //     - Write: Items are forbidden to be written as plaintext.
    //              Items will be written as encrypted items.
    //     - Read: Items are forbidden to be read as plaintext.
    //             Items will be read as encrypted items.
    // Note: If you do not specify a PlaintextOverride, it defaults to
    //       ForbidPlaintextWriteForbidPlaintextRead, which is the desired
    //       behavior for a client interacting with a fully encrypted database.
    let table_configs = create_table_configs(
        kms_key_id,
        ddb_table_name,
        PlaintextOverride::ForbidPlaintextWriteForbidPlaintextRead,
    )
    .await?;

    // 2. Create a new AWS SDK DynamoDb client using the TableEncryptionConfigs
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(table_configs)?)
        .build();
    let ddb = aws_sdk_dynamodb::Client::from_conf(dynamo_config);

    // 3. Put an item into our table using the above client.
    //    This item will be encrypted due to our PlaintextOverride configuration.
    let partition_key_name = "partition_key";
    let sort_key_name = "sort_key";
    let encrypted_and_signed_value = ENCRYPTED_AND_SIGNED_VALUE;
    let sign_only_value = SIGN_ONLY_VALUE;
    let do_nothing_value = DO_NOTHING_VALUE;
    let item = HashMap::from([
        (
            partition_key_name.to_string(),
            AttributeValue::S(partition_key_value.to_string()),
        ),
        (
            sort_key_name.to_string(),
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

    // 4. Get an item back from the table using the same client.
    //    If this is an item written in plaintext (i.e. any item written
    //    during Step 0 or 1), then the read will fail, as we have
    //    configured our client to forbid reading plaintext items.
    //    If this is an item that was encrypted client-side (i.e. any item written
    //    during Step 2 or after), then the item will be decrypted client-side
    //    and surfaced as a plaintext item.
    let key = HashMap::from([
        (
            partition_key_name.to_string(),
            AttributeValue::S(partition_key_value.to_string()),
        ),
        (
            sort_key_name.to_string(),
            AttributeValue::N(sort_key_read_value.to_string()),
        ),
    ]);

    let response = ddb
        .get_item()
        .table_name(ddb_table_name)
        .set_key(Some(key))
        // In this example we configure a strongly consistent read
        // because we perform a read immediately after a write (for demonstrative purposes).
        // By default, reads are only eventually consistent.
        .consistent_read(true)
        .send()
        .await?;

    // Verify we get the expected item back
    if let Some(item) = response.item {
        let success = verify_returned_item(&item, partition_key_value, sort_key_read_value)?;
        if success {
            println!("MigrationStep3 completed successfully");
        }
        Ok(success)
    } else {
        Err("No item found".into())
    }
}

#[tokio::test(flavor = "multi_thread")]
async fn test_migration_step_3() -> Result<(), Box<dyn std::error::Error>> {
    use crate::migration::plaintext_to_awsdbe::awsdbe::migration_step_1::migration_step_1_example;
    use crate::migration::plaintext_to_awsdbe::awsdbe::migration_step_2::migration_step_2_example;
    use crate::migration::plaintext_to_awsdbe::plaintext::migration_step_0::migration_step_0_example;
    use crate::test_utils;
    use uuid::Uuid;

    let kms_key_id = test_utils::TEST_KMS_KEY_ID;
    let table_name = test_utils::TEST_DDB_TABLE_NAME;
    let partition_key = Uuid::new_v4().to_string();
    let sort_keys = ["0", "1", "2", "3"];

    // Successfully executes step 3
    let success = migration_step_3_example(
        kms_key_id,
        table_name,
        &partition_key,
        sort_keys[3],
        sort_keys[3],
    )
    .await?;
    assert!(success, "MigrationStep3 should complete successfully");

    // Given: Step 0 has succeeded
    let success =
        migration_step_0_example(table_name, &partition_key, sort_keys[0], sort_keys[0]).await?;
    assert!(success, "MigrationStep0 should complete successfully");

    // When: Execute Step 3 with sortReadValue=0, Then: should error out when reading plaintext items from Step 0
    let result = migration_step_3_example(
        kms_key_id,
        table_name,
        &partition_key,
        sort_keys[3],
        sort_keys[0],
    )
    .await;
    assert!(
        result.is_err(),
        "MigrationStep3 should fail when reading plaintext items"
    );

    // Given: Step 1 has succeeded
    let success = migration_step_1_example(
        kms_key_id,
        table_name,
        &partition_key,
        sort_keys[1],
        sort_keys[1],
    )
    .await?;
    assert!(success, "MigrationStep1 should complete successfully");

    // When: Execute Step 3 with sortReadValue=1, Then: should error out when reading plaintext items from Step 1
    let result = migration_step_3_example(
        kms_key_id,
        table_name,
        &partition_key,
        sort_keys[3],
        sort_keys[1],
    )
    .await;
    assert!(
        result.is_err(),
        "MigrationStep3 should fail when reading plaintext items"
    );

    // Given: Step 2 has succeeded
    let success = migration_step_2_example(
        kms_key_id,
        table_name,
        &partition_key,
        sort_keys[2],
        sort_keys[2],
    )
    .await?;
    assert!(success, "MigrationStep2 should complete successfully");

    // When: Execute Step 3 with sortReadValue=2, Then: Success (i.e. can read encrypted values from Step 2)
    let success = migration_step_3_example(
        kms_key_id,
        table_name,
        &partition_key,
        sort_keys[3],
        sort_keys[2],
    )
    .await?;
    assert!(
        success,
        "MigrationStep3 should be able to read items written by Step 2"
    );

    // Cleanup
    for sort_key in &sort_keys {
        test_utils::cleanup_items(table_name, &partition_key, sort_key).await?;
    }

    Ok(())
}
