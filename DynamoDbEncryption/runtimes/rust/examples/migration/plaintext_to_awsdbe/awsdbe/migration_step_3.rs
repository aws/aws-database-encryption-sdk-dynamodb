// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;
use aws_db_esdk::intercept::DbEsdkInterceptor;
use aws_db_esdk::dynamodb::types::PlaintextOverride;
use crate::migration::plaintext_to_awsdbe::migration_utils::{
    verify_returned_item, ENCRYPTED_AND_SIGNED_VALUE, SIGN_ONLY_VALUE, DO_NOTHING_VALUE,
};
use crate::migration::plaintext_to_awsdbe::awsdbe::common::create_table_configs;

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
