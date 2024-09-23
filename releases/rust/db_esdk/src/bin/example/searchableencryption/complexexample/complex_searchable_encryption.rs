use crate::test_utils;

/*
 * This file is used in an example to demonstrate complex queries
 * you can perform using beacons.
 * The example data used is for demonstrative purposes only,
 * and might not meet the distribution and correlation uniqueness
 * recommendations for beacons.
 * See our documentation for whether beacons are
 * right for your particular data set:
 * https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption.html#are-beacons-right-for-me
 */
pub async fn run_example(branch_key_id: &str) {
    let ddb_table_name = test_utils::TEST_COMPLEX_DDB_TABLE_NAME;
    let branch_key_wrapping_kms_key_arn = test_utils::TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN;
    let branch_key_ddb_table_name = test_utils::TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME;

    let mut ddb = super::beacon_config::setup_beacon_config(
        ddb_table_name,
        branch_key_id,
        branch_key_wrapping_kms_key_arn,
        branch_key_ddb_table_name,
    )
    .await;
    super::put_requests::put_all_items_to_table(ddb_table_name, &mut ddb).await;
    super::query_requests::run_queries(ddb_table_name, &mut ddb).await;
    println!("complex searchable encryption example successful.");
}
