package plaintext

import (
	"testing"

	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/migration/PlaintextToAWSDBE/awsdbe"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
	"github.com/google/uuid"
)

func TestMigrationStep0(t *testing.T) {
	kmsKeyID := utils.KmsKeyID()
	tableName := utils.DdbTableName()
	partitionKey := uuid.New().String()
	sortKeys := []string{"0", "1", "2", "3"}

	// Successfully executes step 0
	err := MigrationStep0(tableName, partitionKey, sortKeys[0], sortKeys[0])
	utils.HandleError(err)

	// Given: Step 1 has succeeded
	err = awsdbe.MigrationStep1(kmsKeyID, tableName, partitionKey, sortKeys[1], sortKeys[1])
	utils.HandleError(err)

	// When: Execute Step 0 with sortReadValue=1, Then: Success (i.e. can read plaintext values)
	err = MigrationStep0(tableName, partitionKey, sortKeys[0], sortKeys[1])
	utils.HandleError(err)

	// Given: Step 2 has succeeded
	err = awsdbe.MigrationStep2(kmsKeyID, tableName, partitionKey, sortKeys[2], sortKeys[2])
	utils.HandleError(err)

	// When: Execute Step 0 with sortReadValue=2, Then: should error out when reading encrypted items.
	err = MigrationStep0(tableName, partitionKey, sortKeys[0], sortKeys[2])
	utils.AssertErrorMessage(err, "attribute1 is not a string attribute")

	// Given: Step 3 has succeeded (if it exists)
	awsdbe.MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[3])
	// When: Execute Step 0 with sortReadValue=3, Then: should error out
	err = MigrationStep0(tableName, partitionKey, sortKeys[0], sortKeys[3])
	utils.AssertErrorMessage(err, "attribute1 is not a string attribute")

	// Cleanup
	for _, sortKey := range sortKeys { // Only clean up items we created
		utils.DeleteItem(tableName, "partition_key", partitionKey, "sort_key", sortKey)
	}
}
