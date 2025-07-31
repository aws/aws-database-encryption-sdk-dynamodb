package awsdbe

import (
	// Standard imports
	"context"
	"reflect"

	// AWS SDK imports

	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"

	mpl "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
	dbesdkdynamodbencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	dbesdkstructuredencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/dbesdkmiddleware"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
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

	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)

	// 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
	//    We will use the `CreateMrkMultiKeyring` method to create this keyring,
	//    as it will correctly handle both single region and Multi-Region KMS Keys.
	//
	//    Note that while we still are not writing encrypted items,
	//    and our key will not be used to encrypt items in this example,
	//    our configuration specifies that we may read encrypted items,
	//    and we should expect to be able to decrypt and process any encrypted items.
	//    To that end, we must fully define our encryption configuration in
	//    this step.
	keyringInput := mpltypes.CreateAwsKmsMrkMultiKeyringInput{
		Generator: &kmsKeyID,
	}
	kmsKeyring, err := matProv.CreateAwsKmsMrkMultiKeyring(context.Background(), keyringInput)
	utils.HandleError(err)

	// 2. Configure which attributes are encrypted and/or signed when writing new items.
	//    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
	//    we must explicitly configure how they should be treated during item encryption:
	//       - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
	//       - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
	//       - DO_NOTHING: The attribute is not encrypted and not included in the signature
	attributeActions := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		"partition_key": dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"sort_key":      dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"attribute1":    dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"attribute2":    dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"attribute3":    dbesdkstructuredencryptiontypes.CryptoActionDoNothing,
	}

	// 3. Configure which attributes we expect to be excluded in the signature
	//    when reading items. This value represents all unsigned attributes
	//    across our entire dataset. If you ever want to add new unsigned attributes
	//    in the future, you must make an update to this field to all your readers
	//    before deploying any change to start writing that new data. It is not safe
	//    to remove attributes from this field.
	unsignedAttributes := []string{"attribute3"}

	// 4. Create encryption configuration for table.
	//    Again, while we are not writing encrypted items,
	//    we should expect to be able to read encrypted items.
	partitionKeyName := "partition_key"
	sortKeyName := "sort_key"
	// This `PlaintextOverrideForcePlaintextWriteAllowPlaintextRead` means:
	//  - Write: Items are forced to be written as plaintext.
	//           Items may not be written as encrypted items.
	//  - Read: Items are allowed to be read as plaintext.
	//          Items are allowed to be read as encrypted items.
	plaintextOverride := dbesdkdynamodbencryptiontypes.PlaintextOverrideForcePlaintextWriteAllowPlaintextRead
	tableConfig := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:          ddbTableName,
		PartitionKeyName:          partitionKeyName,
		SortKeyName:               &sortKeyName,
		AttributeActionsOnEncrypt: attributeActions,
		Keyring:                   kmsKeyring,
		AllowedUnsignedAttributes: unsignedAttributes,
		PlaintextOverride:         &plaintextOverride,
	}

	tableConfigsMap := make(map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig)
	tableConfigsMap[ddbTableName] = tableConfig

	listOfTableConfigs := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigsMap,
	}

	// 5. Create DynamoDB client with dbEsdkMiddleware
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(listOfTableConfigs)
	utils.HandleError(err)

	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	// 6. Put an item into your table.
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

	// 7. Get an item back from the table using the DynamoDb Client.
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
}
