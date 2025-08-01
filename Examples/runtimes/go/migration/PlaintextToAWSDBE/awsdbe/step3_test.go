package awsdbe

import (
	"errors"
	"strings"
	"testing"

	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/migration/PlaintextToAWSDBE/plaintext"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
	"github.com/aws/smithy-go"
	"github.com/google/uuid"
)

func TestMigrationStep3(t *testing.T) {
	kmsKeyID := utils.KmsKeyID()
	tableName := utils.DdbTableName()
	partitionKey := uuid.New().String()
	sortKeys := []string{"0", "1", "2", "3"}

	// Successfully executes Step 3
	MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[3])

	// Given: Step 0 has succeeded
	plaintext.MigrationStep0(tableName, partitionKey, sortKeys[0])
	// When: Execute Step 3 with sortReadValue=0, Then: should panic (cannot read plaintext values)
	// MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[0])
	assertError(MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[0]))

	// Given: Step 1 has succeeded
	MigrationStep1(kmsKeyID, tableName, partitionKey, sortKeys[1])
	// When: Execute Step 3 with sortReadValue=1, Then: should panic (cannot read plaintext values)
	assertError(MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[1]))

	// Given: Step 2 has succeeded
	MigrationStep2(kmsKeyID, tableName, partitionKey, sortKeys[2])
	// When: Execute Step 3 with sortReadValue=2, Then: Success (can read encrypted values)
	MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[2])

	// Cleanup
	for _, sortKey := range sortKeys {
		utils.DeleteItem(tableName, "partition_key", partitionKey, "sort_key", sortKey)
	}
}

func assertError(err error) {
	var oe *smithy.OperationError
	if errors.As(err, &oe) {
		if oe.Service() != "DynamoDB" {
			panic("Expected service to be DynamoDB")
		}
		if oe.Operation() != "GetItem" {
			panic("Expected Operation to be GetItem")
		}
		if !strings.Contains(oe.Unwrap().Error(), "Encrypted item missing expected header and footer attributes") {
			panic("Expected message to contain Encrypted item missing expected header and footer attributes")
		}
	}
}
