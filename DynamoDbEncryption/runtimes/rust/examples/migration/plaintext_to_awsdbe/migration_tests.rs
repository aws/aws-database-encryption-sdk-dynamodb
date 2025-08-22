// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use uuid::Uuid;

use crate::migration::plaintext_to_awsdbe::plaintext::migration_step_0::migration_step_0_example;
use crate::migration::plaintext_to_awsdbe::awsdbe::migration_step_1::migration_step_1_example;
use crate::migration::plaintext_to_awsdbe::awsdbe::migration_step_2::migration_step_2_example;
use crate::migration::plaintext_to_awsdbe::awsdbe::migration_step_3::migration_step_3_example;

// Helper method to clean up test items
async fn cleanup_items(
    table_name: &str,
    partition_key: &str,
    sort_key: &str,
) -> Result<(), Box<dyn std::error::Error>> {
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let ddb = aws_sdk_dynamodb::Client::new(&sdk_config);
    
    let key = std::collections::HashMap::from([
        (
            "partition_key".to_string(),
            aws_sdk_dynamodb::types::AttributeValue::S(partition_key.to_string()),
        ),
        (
            "sort_key".to_string(),
            aws_sdk_dynamodb::types::AttributeValue::N(sort_key.to_string()),
        ),
    ]);

    ddb.delete_item()
        .table_name(table_name)
        .set_key(Some(key))
        .send()
        .await?;

    Ok(())
}

#[tokio::test]
async fn test_migration_step_0() -> Result<(), Box<dyn std::error::Error>> {
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
    assert!(result.unwrap_err().to_string().contains("attribute1 mismatch"));
    
    // Given: Step 3 has succeeded
    migration_step_3_example(kms_key_id, table_name, &partition_key, sort_keys[3], sort_keys[3]).await?;
    
    // When: Execute Step 0 with sortReadValue=3, Then: should error out
    let result = migration_step_0_example(table_name, &partition_key, sort_keys[0], sort_keys[3]).await;
    assert!(result.is_err(), "MigrationStep0 should fail when reading encrypted items");
    assert!(result.unwrap_err().to_string().contains("attribute1 mismatch"));
    
    // Cleanup
    for sort_key in &sort_keys {
        cleanup_items(table_name, &partition_key, sort_key).await?;
    }

    Ok(())
}

#[tokio::test]
async fn test_migration_step_1() -> Result<(), Box<dyn std::error::Error>> {
    let kms_key_id = test_utils::TEST_KMS_KEY_ID;
    let table_name = test_utils::TEST_DDB_TABLE_NAME;
    let partition_key = Uuid::new_v4().to_string();
    let sort_keys = ["0", "1", "2", "3"];

    // Given: Step 0 has succeeded
    let success = migration_step_0_example(table_name, &partition_key, sort_keys[0], sort_keys[0]).await?;
    assert!(success, "MigrationStep0 should complete successfully");

    // Successfully executes step 1
    let success = migration_step_1_example(kms_key_id, table_name, &partition_key, sort_keys[1], sort_keys[1]).await?;
    assert!(success, "MigrationStep1 should complete successfully");

    // When: Execute Step 1 with sortReadValue=0, Then: Success (i.e. can read plaintext values from Step 0)
    let success = migration_step_1_example(kms_key_id, table_name, &partition_key, sort_keys[1], sort_keys[0]).await?;
    assert!(success, "MigrationStep1 should be able to read items written by Step 0");

    // Given: Step 2 has succeeded
    let success = migration_step_2_example(kms_key_id, table_name, &partition_key, sort_keys[2], sort_keys[2]).await?;
    assert!(success, "MigrationStep2 should complete successfully");

    // When: Execute Step 1 with sortReadValue=2, Then: Success (i.e. can read encrypted values from Step 2)
    let success = migration_step_1_example(kms_key_id, table_name, &partition_key, sort_keys[1], sort_keys[2]).await?;
    assert!(success, "MigrationStep1 should be able to read items written by Step 2");

    // Given: Step 3 has succeeded
    let success = migration_step_3_example(kms_key_id, table_name, &partition_key, sort_keys[3], sort_keys[3]).await?;
    assert!(success, "MigrationStep3 should complete successfully");

    // When: Execute Step 1 with sortReadValue=3, Then: Success (i.e. can read encrypted values from Step 3)
    let success = migration_step_1_example(kms_key_id, table_name, &partition_key, sort_keys[1], sort_keys[3]).await?;
    assert!(success, "MigrationStep1 should be able to read items written by Step 3");

    // Cleanup
    for sort_key in &sort_keys {
        cleanup_items(table_name, &partition_key, sort_key).await?;
    }

    Ok(())
}

#[tokio::test]
async fn test_migration_step_2() -> Result<(), Box<dyn std::error::Error>> {
    let kms_key_id = test_utils::TEST_KMS_KEY_ID;
    let table_name = test_utils::TEST_DDB_TABLE_NAME;
    let partition_key = Uuid::new_v4().to_string();
    let sort_keys = ["0", "1", "2", "3"];

    // Given: Step 0 has succeeded
    let success = migration_step_0_example(table_name, &partition_key, sort_keys[0], sort_keys[0]).await?;
    assert!(success, "MigrationStep0 should complete successfully");

    // Given: Step 1 has succeeded
    let success = migration_step_1_example(kms_key_id, table_name, &partition_key, sort_keys[1], sort_keys[1]).await?;
    assert!(success, "MigrationStep1 should complete successfully");

    // Successfully executes step 2
    let success = migration_step_2_example(kms_key_id, table_name, &partition_key, sort_keys[2], sort_keys[2]).await?;
    assert!(success, "MigrationStep2 should complete successfully");

    // When: Execute Step 2 with sortReadValue=0, Then: Success (i.e. can read plaintext values from Step 0)
    let success = migration_step_2_example(kms_key_id, table_name, &partition_key, sort_keys[2], sort_keys[0]).await?;
    assert!(success, "MigrationStep2 should be able to read items written by Step 0");

    // When: Execute Step 2 with sortReadValue=1, Then: Success (i.e. can read plaintext values from Step 1)
    let success = migration_step_2_example(kms_key_id, table_name, &partition_key, sort_keys[2], sort_keys[1]).await?;
    assert!(success, "MigrationStep2 should be able to read items written by Step 1");

    // Given: Step 3 has succeeded
    let success = migration_step_3_example(kms_key_id, table_name, &partition_key, sort_keys[3], sort_keys[3]).await?;
    assert!(success, "MigrationStep3 should complete successfully");

    // When: Execute Step 2 with sortReadValue=3, Then: Success (i.e. can read encrypted values from Step 3)
    let success = migration_step_2_example(kms_key_id, table_name, &partition_key, sort_keys[2], sort_keys[3]).await?;
    assert!(success, "MigrationStep2 should be able to read items written by Step 3");

    // Cleanup
    for sort_key in &sort_keys {
        cleanup_items(table_name, &partition_key, sort_key).await?;
    }

    Ok(())
}

#[tokio::test]
async fn test_migration_step_3() -> Result<(), Box<dyn std::error::Error>> {
    let kms_key_id = test_utils::TEST_KMS_KEY_ID;
    let table_name = test_utils::TEST_DDB_TABLE_NAME;
    let partition_key = Uuid::new_v4().to_string();
    let sort_keys = ["0", "1", "2", "3"];

    // Given: Step 0 has succeeded
    let success = migration_step_0_example(table_name, &partition_key, sort_keys[0], sort_keys[0]).await?;
    assert!(success, "MigrationStep0 should complete successfully");

    // Given: Step 1 has succeeded
    let success = migration_step_1_example(kms_key_id, table_name, &partition_key, sort_keys[1], sort_keys[1]).await?;
    assert!(success, "MigrationStep1 should complete successfully");

    // Given: Step 2 has succeeded
    let success = migration_step_2_example(kms_key_id, table_name, &partition_key, sort_keys[2], sort_keys[2]).await?;
    assert!(success, "MigrationStep2 should complete successfully");
    
    // Successfully executes step 3
    let success = migration_step_3_example(kms_key_id, table_name, &partition_key, sort_keys[3], sort_keys[3]).await?;
    assert!(success, "MigrationStep3 should complete successfully");
    
    // When: Execute Step 3 with sortReadValue=0, Then: should error out when reading plaintext items from Step 0
    let result = migration_step_3_example(kms_key_id, table_name, &partition_key, sort_keys[3], sort_keys[0]).await;
    assert!(result.is_err(), "MigrationStep3 should fail when reading plaintext items");
    let error_msg = result.unwrap_err().to_string().to_lowercase();
    assert!(error_msg.contains("encrypted item missing expected header and footer attributes") || 
            error_msg.contains("header") || error_msg.contains("footer"));

    // When: Execute Step 3 with sortReadValue=1, Then: should error out when reading plaintext items from Step 1
    let result = migration_step_3_example(kms_key_id, table_name, &partition_key, sort_keys[3], sort_keys[1]).await;
    assert!(result.is_err(), "MigrationStep3 should fail when reading plaintext items");
    let error_msg = result.unwrap_err().to_string().to_lowercase();
    assert!(error_msg.contains("encrypted item missing expected header and footer attributes") || 
            error_msg.contains("header") || error_msg.contains("footer"));

    // When: Execute Step 3 with sortReadValue=2, Then: Success (i.e. can read encrypted values from Step 2)
    let success = migration_step_3_example(kms_key_id, table_name, &partition_key, sort_keys[3], sort_keys[2]).await?;
    assert!(success, "MigrationStep3 should be able to read items written by Step 2");

    // Cleanup
    for sort_key in &sort_keys {
        cleanup_items(table_name, &partition_key, sort_key).await?;
    }

    Ok(())
}
