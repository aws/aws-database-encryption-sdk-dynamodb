package plaintext

import (
	"context"
	"fmt"

	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

// MigrationStep0 demonstrates plaintext database operations before encryption migration
func MigrationStep0(ddbTableName, partitionKeyValue, sortKeyValue string) {
	// 1. Create a standard DynamoDB client (no encryption)
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)
	ddb := dynamodb.NewFromConfig(cfg)

	// 2. Put an example item into our DynamoDB table in plaintext
	item := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: partitionKeyValue},
		"sort_key":      &types.AttributeValueMemberN{Value: sortKeyValue},
		"attribute1":    &types.AttributeValueMemberS{Value: "this will be encrypted and signed"},
		"attribute2":    &types.AttributeValueMemberS{Value: "this will never be encrypted, but it will be signed"},
		"attribute3":    &types.AttributeValueMemberS{Value: "this will never be encrypted nor signed"},
	}

	putInput := &dynamodb.PutItemInput{
		TableName: aws.String(ddbTableName),
		Item:      item,
	}
	_, err = ddb.PutItem(context.TODO(), putInput)
	utils.HandleError(err)

	// 3. Get an item back from the table as it was written
	key := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: partitionKeyValue},
		"sort_key":      &types.AttributeValueMemberN{Value: sortKeyValue},
	}

	getInput := &dynamodb.GetItemInput{
		TableName: aws.String(ddbTableName),
		Key:       key,
	}
	result, err := ddb.GetItem(context.TODO(), getInput)
	utils.HandleError(err)

	// 4. Verify we get the expected item back
	if result.Item == nil {
		panic("No item found")
	}

	returnedPartitionKey := result.Item["partition_key"].(*types.AttributeValueMemberS).Value
	returnedAttribute1 := result.Item["attribute1"].(*types.AttributeValueMemberS).Value

	if returnedPartitionKey != partitionKeyValue {
		panic(fmt.Sprintf("Expected partition key %s, got %s", partitionKeyValue, returnedPartitionKey))
	}
	if returnedAttribute1 != "this will be encrypted and signed" {
		panic(fmt.Sprintf("Expected attribute1 value, got %s", returnedAttribute1))
	}

	fmt.Println("MigrationStep0 completed successfully")
}
