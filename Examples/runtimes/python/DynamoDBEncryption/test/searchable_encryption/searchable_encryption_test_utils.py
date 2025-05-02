"""Searchable encryption test constants."""

# Our tests require access to DDB Tables with these name
SIMPLE_BEACON_TEST_DDB_TABLE_NAME = "SimpleBeaconTestTable"
UNIT_INSPECTION_TEST_DDB_TABLE_NAME = "UnitInspectionTestTable"

# The branch key must have been created using this KMS key
# Note: This is a public resource that anyone can access.
# This MUST NOT be used to encrypt any production data.
TEST_BRANCH_KEY_WRAPPING_KMS_KEY_ARN = "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126"

# Our tests require access to DDB Table with this name configured as a branch keystore
TEST_BRANCH_KEYSTORE_DDB_TABLE_NAME = "KeyStoreDdbTable"
TEST_LOGICAL_KEYSTORE_NAME = "KeyStoreDdbTable"
