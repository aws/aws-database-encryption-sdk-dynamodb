package awsdbe

import (
	"testing"

	plaintexttoawsdbe "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/migration/PlaintextToAWSDBE"
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
	err := MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[3], plaintexttoawsdbe.EncryptedAndSignedValue, plaintexttoawsdbe.SignOnlyValue, plaintexttoawsdbe.SignOnlyValue)
	utils.HandleError(err)

	// Given: Step 0 has succeeded
	err = plaintext.MigrationStep0(tableName, partitionKey, sortKeys[0], sortKeys[0], plaintexttoawsdbe.EncryptedAndSignedValue, plaintexttoawsdbe.SignOnlyValue, plaintexttoawsdbe.SignOnlyValue)
	utils.HandleError(err)

	// When: Execute Step 3 with sortReadValue=0, Then: should panic (cannot read plaintext values)
	err = MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[0], plaintexttoawsdbe.EncryptedAndSignedValue, plaintexttoawsdbe.SignOnlyValue, plaintexttoawsdbe.SignOnlyValue)
	utils.AssertServiceError(err, "DynamoDB", "GetItem", "Encrypted item missing expected header and footer attributes")

	// Given: Step 1 has succeeded
	err = MigrationStep1(kmsKeyID, tableName, partitionKey, sortKeys[1], sortKeys[1], plaintexttoawsdbe.EncryptedAndSignedValue, plaintexttoawsdbe.SignOnlyValue, plaintexttoawsdbe.SignOnlyValue)
	utils.HandleError(err)

	// When: Execute Step 3 with sortReadValue=1, Then: should error out (cannot read plaintext values)
	err = MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[1], plaintexttoawsdbe.EncryptedAndSignedValue, plaintexttoawsdbe.SignOnlyValue, plaintexttoawsdbe.SignOnlyValue)
	utils.AssertServiceError(err, "DynamoDB", "GetItem", "Encrypted item missing expected header and footer attributes")

	// Given: Step 2 has succeeded
	err = MigrationStep2(kmsKeyID, tableName, partitionKey, sortKeys[2], sortKeys[2], plaintexttoawsdbe.EncryptedAndSignedValue, plaintexttoawsdbe.SignOnlyValue, plaintexttoawsdbe.SignOnlyValue)
	utils.HandleError(err)

	// When: Execute Step 3 with sortReadValue=2, Then: Success (can read encrypted values)
	err = MigrationStep3(kmsKeyID, tableName, partitionKey, sortKeys[3], sortKeys[2], plaintexttoawsdbe.EncryptedAndSignedValue, plaintexttoawsdbe.SignOnlyValue, plaintexttoawsdbe.SignOnlyValue)
	utils.HandleError(err)

	// Cleanup
	for _, sortKey := range sortKeys {
		utils.DeleteItem(tableName, "partition_key", partitionKey, "sort_key", sortKey)
	}
}
