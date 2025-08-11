package awsdbe

import (
	"context"
	"fmt"

	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"

	dbesdkdynamodbencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/dbesdkmiddleware"
	plaintexttoawsdbe "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/migration/PlaintextToAWSDBE"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
)

/*
Migration Step 3: This is an example demonstrating how to update your configuration
to stop accepting reading plaintext items.

Once you complete Step 3, all items being read by your system are encrypted.

Before you move onto this step, you will need to encrypt all plaintext items in your dataset.
How you will want to do this depends on your system.

Running this example requires access to the DDB Table whose name
is provided in the function parameter.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
*/
func MigrationStep3(kmsKeyID, ddbTableName, partitionKeyValue, sortKeyWriteValue, sortKeyReadValue string) error {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)

	// 1. Configure your Keyring, attribute actions,
	// 	  allowedUnsignedAttributes, and encryption configuration for table.
	//    This is common across all the steps.

	// When creating encryption configuration for your table,
	// you can either not specify PlaintextOverride or use
	// `PlaintextOverrideForbidPlaintextWriteForbidPlaintextRead` as PlaintextOverride.
	// If you do not specify `PlaintextOverrideForbidPlaintextWriteForbidPlaintextRead`
	// plaintext override defaults to `PlaintextOverrideForbidPlaintextWriteForbidPlaintextRead`,
	// which is the desired behavior for a client interacting with a fully encrypted database.
	// This plaintext override means:
	// 	- Write: Items are forbidden to be written as plaintext.
	//  	     Items will be written as encrypted items.
	//  - Read: Items are forbidden to be read as plaintext.
	//  	    Items will be read as encrypted items.

	listOfTableConfigs := configureTable(kmsKeyID, ddbTableName, dbesdkdynamodbencryptiontypes.PlaintextOverrideForbidPlaintextWriteForbidPlaintextRead)

	// 2. Create DynamoDB client with dbEsdkMiddleware
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(listOfTableConfigs)
	utils.HandleError(err)

	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	// 3. Put an item into your table.
	//    This item will be encrypted.
	encryptedAndSignedValue := "this will be encrypted and signed"
	signOnlyValue := "this will never be encrypted, but it will be signed"
	doNothingValue := "this will never be encrypted nor signed"
	item := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: partitionKeyValue},
		"sort_key":      &types.AttributeValueMemberN{Value: sortKeyWriteValue},
		"attribute1":    &types.AttributeValueMemberS{Value: encryptedAndSignedValue},
		"attribute2":    &types.AttributeValueMemberS{Value: signOnlyValue},
		"attribute3":    &types.AttributeValueMemberS{Value: doNothingValue},
	}

	putInput := dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      item,
	}

	_, err = ddb.PutItem(context.TODO(), &putInput)
	// We return this error because we run test against the error.
	// When used in production code, you can decide how you want to handle errors.
	if err != nil {
		return err
	}

	// 4. Get an item back from the table using the DynamoDb Client.
	//    If this is an item written in plaintext (i.e. any item written
	//    during Step 0 or 1), then the read will fail, as we have
	//    configured our client to forbid reading plaintext items.
	//    If this is an item that was encrypted client-side (i.e. any item written
	//    during Step 2 or after), then the item will be decrypted client-side
	//    and surfaced as a plaintext item.
	key := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: partitionKeyValue},
		"sort_key":      &types.AttributeValueMemberN{Value: sortKeyReadValue},
	}

	getInput := &dynamodb.GetItemInput{
		TableName:      &ddbTableName,
		Key:            key,
		ConsistentRead: aws.Bool(true),
	}

	result, err := ddb.GetItem(context.TODO(), getInput)
	// We return this error because we run test against the error.
	// When used in production code, you can decide how you want to handle errors.
	if err != nil {
		return err
	}

	// Verify we got the expected item back
	err = plaintexttoawsdbe.VerifyReturnedItem(result, partitionKeyValue, sortKeyReadValue, encryptedAndSignedValue, signOnlyValue, doNothingValue)
	if err != nil {
		return err
	}
	fmt.Println("MigrationStep3 completed successfully")
	return nil
}
