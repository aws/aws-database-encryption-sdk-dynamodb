package awsdbe

import (
	"context"
	"fmt"
	"reflect"

	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"

	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/dbesdkmiddleware"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"

	dbesdkdynamodbencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
)

/*
Migration Step 1: This is an example demonstrating how to start using the
AWS Database Encryption SDK with a pre-existing table with plaintext items.
In this example, we configure a DynamoDb Encryption Interceptor to do the following:
  - Write items only in plaintext
  - Read items in plaintext or, if the item is encrypted, decrypt with our encryption configuration

While this step configures your client to be ready to start reading encrypted items,
we do not yet expect to be reading any encrypted items,
as our client still writes plaintext items.
Before you move on to step 2, ensure that these changes have successfully been deployed
to all of your readers.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
*/
func MigrationStep1(kmsKeyID, ddbTableName, partitionKeyValue, sortKeyValue string) {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)

	// 1. Configure your Keyring, attribute actions,
	// 	  allowedUnsignedAttributes, and encryption configuration for table.
	//    This is common across all the steps.

	// Note that while we still are not writing encrypted items,
	// and our key will not be used to encrypt items in this example,
	// our configuration specifies that we may read encrypted items,
	// and we should expect to be able to decrypt and process any encrypted items.
	// To that end, we must fully define our encryption configuration in
	// this step.

	// This `PlaintextOverrideForcePlaintextWriteAllowPlaintextRead` means:
	//  - Write: Items are forced to be written as plaintext.
	//           Items may not be written as encrypted items.
	//  - Read: Items are allowed to be read as plaintext.
	//          Items are allowed to be read as encrypted items.
	listOfTableConfigs := configureTable(kmsKeyID, ddbTableName, dbesdkdynamodbencryptiontypes.PlaintextOverrideForcePlaintextWriteAllowPlaintextRead)

	// 2. Create DynamoDB client with dbEsdkMiddleware
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(listOfTableConfigs)
	utils.HandleError(err)

	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	// 3. Put an item into your table.
	//    This item will be stored in plaintext.
	item := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: partitionKeyValue},
		"sort_key":      &types.AttributeValueMemberN{Value: sortKeyValue},
		"attribute1":    &types.AttributeValueMemberS{Value: "this will be encrypted and signed"},
		"attribute2":    &types.AttributeValueMemberS{Value: "this will never be encrypted, but it will be signed"},
		"attribute3":    &types.AttributeValueMemberS{Value: "this will never be encrypted nor signed"},
	}

	putInput := dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      item,
	}

	_, err = ddb.PutItem(context.TODO(), &putInput)
	utils.HandleError(err)

	// 4. Get an item back from the table using the DynamoDb Client.
	//    If this is an item written in plaintext (i.e. any item written
	//    during Step 0 or 1), then the item will still be in plaintext.
	//    If this is an item that was encrypted client-side (i.e. any item written
	//    during Step 2 or after), then the item will be decrypted client-side
	//    and surfaced as a plaintext item.
	key := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: partitionKeyValue},
		"sort_key":      &types.AttributeValueMemberN{Value: sortKeyValue},
	}

	getInput := &dynamodb.GetItemInput{
		TableName:      aws.String(ddbTableName),
		Key:            key,
		ConsistentRead: aws.Bool(true),
	}

	result, err := ddb.GetItem(context.TODO(), getInput)
	utils.HandleError(err)

	// Verify we got the expected item back
	if !reflect.DeepEqual(item, result.Item) {
		panic("Decrypted item does not match original item")
	}
	fmt.Println("MigrationStep1 completed successfully")
}
