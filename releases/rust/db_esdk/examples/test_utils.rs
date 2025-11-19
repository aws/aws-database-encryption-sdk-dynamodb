// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

pub const TEST_KEYSTORE_NAME: &str = "KeyStoreDdbTable";
pub const TEST_LOGICAL_KEYSTORE_NAME: &str = "KeyStoreDdbTable";

pub const TEST_KEYSTORE_KMS_KEY_ID: &str =
    "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";

pub const TEST_AWS_ACCOUNT_ID: &str = "658956600833";

pub const TEST_AWS_REGION: &str = "us-west-2";

// These are public KMS Keys that MUST only be used for testing, and MUST NOT be used for any production data
pub const TEST_KMS_KEY_ID: &str =
    "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f";

pub const TEST_MRK_KEY_ID: &str =
    "arn:aws:kms:us-west-2:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7";

pub const TEST_KMS_RSA_KEY_ID: &str =
    "arn:aws:kms:us-west-2:658956600833:key/8b432da4-dde4-4bc3-a794-c7d68cbab5a6";

pub const TEST_MRK_REPLICA_KEY_ID_US_EAST_1: &str =
    "arn:aws:kms:us-east-1:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7";

pub const TEST_MRK_REPLICA_KEY_ID_EU_WEST_1: &str =
    "arn:aws:kms:eu-west-1:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7";

// Our tests require access to DDB Table with this name
pub const TEST_DDB_TABLE_NAME: &str = "DynamoDbEncryptionInterceptorTestTableCS";
pub const TEST_COMPLEX_TABLE_NAME: &str = "ComplexBeaconTestTableCS";

// Our tests require access to DDB Tables with these name
pub const SIMPLE_BEACON_TEST_DDB_TABLE_NAME: &str = "SimpleBeaconTestTable";
pub const UNIT_INSPECTION_TEST_DDB_TABLE_NAME: &str = "UnitInspectionTestTableCS";

// The branch key must have been created using this KMS key
// Note: This is a public resource that anyone can access.
// This MUST NOT be used to encrypt any production data.
pub const TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN: &str =
    "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";

// Our tests require access to DDB Table with this name configured as a branch keystore
pub const TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME: &str = "KeyStoreDdbTable";
pub const TEST_COMPLEX_DDB_TABLE_NAME: &str = "ComplexBeaconTestTable";

// Helper method to clean up test items
pub async fn cleanup_items(
    table_name: &str,
    partition_key_value: &str,
    sort_key_value: &str,
) -> Result<(), Box<dyn std::error::Error>> {
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let ddb = aws_sdk_dynamodb::Client::new(&sdk_config);

    let key = std::collections::HashMap::from([
        (
            "partition_key".to_string(),
            aws_sdk_dynamodb::types::AttributeValue::S(partition_key_value.to_string()),
        ),
        (
            "sort_key".to_string(),
            aws_sdk_dynamodb::types::AttributeValue::N(sort_key_value.to_string()),
        ),
    ]);

    ddb.delete_item()
        .table_name(table_name)
        .set_key(Some(key))
        .send()
        .await?;

    Ok(())
}
