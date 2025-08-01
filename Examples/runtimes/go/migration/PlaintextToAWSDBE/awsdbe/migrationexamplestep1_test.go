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
	sortKeys := []string{"0", "1", "2"}

	// Successfully executes Step 1
	MigrationStep1(kmsKeyID, tableName, partitionKey, sortKeys[1])

	// Given: Step 0 has succeeded
	plaintext.MigrationStep0(tableName, partitionKey, sortKeys[0])
	// When: Execute Step 1 with sortReadValue=0, Then: Success (i.e. can read plaintext values)
	MigrationStep1(kmsKeyID, tableName, partitionKey, sortKeys[0])

	// Given: Step 2 has succeeded
	MigrationStep2(kmsKeyID, tableName, partitionKey, sortKeys[2])
	// When: Execute Step 1 with sortReadValue=2, Then: Success (i.e. can read encrypted values)
	MigrationStep1(kmsKeyID, tableName, partitionKey, sortKeys[2])

	// Cleanup
	for _, sortKey := range sortKeys {
		utils.DeleteItem(tableName, "partition_key", partitionKey, "sort_key", sortKey)
	}

}
