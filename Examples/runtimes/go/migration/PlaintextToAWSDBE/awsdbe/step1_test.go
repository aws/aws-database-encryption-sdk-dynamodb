package awsdbe

import (
	"testing"

	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/migration/PlaintextToAWSDBE/plaintext"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
	"github.com/google/uuid"
)

func TestMigrationStep1(t *testing.T) {
	kmsKeyID := utils.KmsKeyID()
	tableName := utils.DdbTableName()
	partitionKey := uuid.New().String()
	sortKeys := []string{"0", "1", "2", "3"}

	// Successfully executes Step 1
	err := MigrationStep1(kmsKeyID, tableName, partitionKey, sortKeys[1])
	utils.HandleError(err)

	// Given: Step 0 has succeeded
	err = plaintext.MigrationStep0(tableName, partitionKey, sortKeys[0])
	utils.HandleError(err)

	// When: Execute Step 1 with sortReadValue=0, Then: Success (i.e. can read plaintext values)
	err = MigrationStep1(kmsKeyID, tableName, partitionKey, sortKeys[0])
	utils.HandleError(err)

	// Given: Step 2 has succeeded
	err = MigrationStep2(kmsKeyID, tableName, partitionKey, sortKeys[2])
	utils.HandleError(err)

	// When: Execute Step 1 with sortReadValue=2, Then: Success (i.e. can read encrypted values)
	err = MigrationStep1(kmsKeyID, tableName, partitionKey, sortKeys[2])
	utils.HandleError(err)

	// Given: Step 3 has succeeded
	err = MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[3])
	utils.HandleError(err)

	// When: Execute Step 1 with sortReadValue=3, Then: Success (i.e. can read encrypted values)
	err = MigrationStep1(kmsKeyID, tableName, partitionKey, sortKeys[3])
	utils.HandleError(err)

	// Cleanup
	for _, sortKey := range sortKeys {
		utils.DeleteItem(tableName, "partition_key", partitionKey, "sort_key", sortKey)
	}

}
