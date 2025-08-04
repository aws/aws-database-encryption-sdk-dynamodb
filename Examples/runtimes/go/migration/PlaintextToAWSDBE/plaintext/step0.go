package plaintext

import (
	"context"
	"fmt"

	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

/*
Migration Step 0: This is the pre-migration step for the
plaintext-to-encrypted database migration, and is the starting
state for our migration from a plaintext database to a
client-side encrypted database encrypted using the
AWS Database Encryption SDK for DynamoDb.

In this example, we configure a DynamoDbClient to
write a plaintext record to a table and read that record.
This emulates the starting state of a plaintext-to-encrypted
database migration; i.e. a plaintext database you can
read and write to with the DynamoDbClient.

Running this example requires access to the DDB Table whose name
is provided in the function parameter.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
*/
func MigrationStep0(ddbTableName, partitionKeyValue, sortKeyValue string) error {
	// 1. Create a standard DynamoDB client
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)
	ddb := dynamodb.NewFromConfig(cfg)

	// 2. Put an example item into DynamoDB table
	//    This item will be stored in plaintext.
	item := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: partitionKeyValue},
		"sort_key":      &types.AttributeValueMemberN{Value: "0"},
		"attribute1":    &types.AttributeValueMemberS{Value: "this will be encrypted and signed"},
		"attribute2":    &types.AttributeValueMemberS{Value: "this will never be encrypted, but it will be signed"},
		"attribute3":    &types.AttributeValueMemberS{Value: "this will never be encrypted nor signed"},
	}

	putInput := &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      item,
	}
	_, err = ddb.PutItem(context.TODO(), putInput)
	utils.HandleError(err)

	// 3. Get an item back from the table as it was written.
	//    If this is an item written in plaintext (i.e. any item written
	//    during Step 0 or 1), then the item will still be in plaintext
	//    and will be able to be processed.
	//    If this is an item that was encrypted client-side (i.e. any item written
	//    during Step 2 or after), then the item will still be encrypted client-side
	//    and will be unable to be processed in your code. To decrypt and process
	//    client-side encrypted items, you will need to configure encrypted reads on
	//    your dynamodb client (this is configured from Step 1 onwards).
	key := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: partitionKeyValue},
		"sort_key":      &types.AttributeValueMemberN{Value: sortKeyValue},
	}

	getInput := &dynamodb.GetItemInput{
		TableName: &ddbTableName,
		Key:       key,
	}
	result, err := ddb.GetItem(context.TODO(), getInput)
	utils.HandleError(err)

	// 4. Verify we get the expected item back
	if result.Item == nil {
		panic("No item found")
	}

	returnedPartitionKey, ok := result.Item["partition_key"].(*types.AttributeValueMemberS)
	if !ok {
		// We return this error because we run test against the error.
		// When used in production code, you can decide how you want to handle errors.
		return fmt.Errorf("partition_key is not a string attribute")
	}
	returnedAttribute1, ok := result.Item["attribute1"].(*types.AttributeValueMemberS)
	if !ok {
		// We return this error because we run test against the error.
		// When used in production code, you can decide how you want to handle errors.
		return fmt.Errorf("partition_key is not a string attribute")
	}

	if returnedPartitionKey.Value != partitionKeyValue {
		panic(fmt.Sprintf("Expected partition key %s, got %s", partitionKeyValue, returnedPartitionKey))
	}
	if returnedAttribute1.Value != "this will be encrypted and signed" {
		panic(fmt.Sprintf("Expected attribute1 value, got %s", returnedAttribute1))
	}

	fmt.Println("MigrationStep0 completed successfully")
	return nil
}
