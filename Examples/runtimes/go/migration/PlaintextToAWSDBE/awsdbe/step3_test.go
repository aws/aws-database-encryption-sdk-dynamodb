package awsdbe

import (
	"testing"

	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/migration/PlaintextToAWSDBE/plaintext"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
	"github.com/google/uuid"
)

func TestMigrationStep3(t *testing.T) {
	kmsKeyID := utils.KmsKeyID()
	tableName := utils.DdbTableName()
	partitionKey := uuid.New().String()
	sortKeys := []string{"0", "1", "2", "3"}

	// Successfully executes Step 3
	utils.HandleError(MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[3]))

	// Given: Step 0 has succeeded
	utils.HandleError(plaintext.MigrationStep0(tableName, partitionKey, sortKeys[0]))
	// When: Execute Step 3 with sortReadValue=0, Then: should panic (cannot read plaintext values)
	// MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[0])
	utils.AssertServiceError(MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[0]), "DynamoDB", "GetItem", "Encrypted item missing expected header and footer attributes")

	// Given: Step 1 has succeeded
	utils.HandleError(MigrationStep1(kmsKeyID, tableName, partitionKey, sortKeys[1]))
	// When: Execute Step 3 with sortReadValue=1, Then: should panic (cannot read plaintext values)
	utils.AssertServiceError(MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[1]), "DynamoDB", "GetItem", "Encrypted item missing expected header and footer attributes")

	// Given: Step 2 has succeeded
	utils.HandleError(MigrationStep2(kmsKeyID, tableName, partitionKey, sortKeys[2]))
	// When: Execute Step 3 with sortReadValue=2, Then: Success (can read encrypted values)
	utils.HandleError(MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[2]))

	// Cleanup
	for _, sortKey := range sortKeys {
		utils.DeleteItem(tableName, "partition_key", partitionKey, "sort_key", sortKey)
	}
}
