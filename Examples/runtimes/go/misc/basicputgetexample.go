package misc

import (
	"context"
	"fmt"
	"reflect"

	mpl "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
	dbesdkdynamodbencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	dbesdkstructuredencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/dbesdkmiddleware"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/utils"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

func BasicPutGetExample(kmsKeyID, ddbTableName string) {
	// 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
	//    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
	//    We will use the `CreateMrkMultiKeyring` method to create this keyring,
	//    as it will correctly handle both single region and Multi-Region KMS Keys.

	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)
	awsKmsMrkKeyringMultiInput := mpltypes.CreateAwsKmsMrkMultiKeyringInput{
		Generator: &kmsKeyID,
	}
	keyring, err := matProv.CreateAwsKmsMrkMultiKeyring(context.Background(), awsKmsMrkKeyringMultiInput)
	if err != nil {
		panic(err)
	}
	// 2. Configure which attributes are encrypted and/or signed when writing new items.
	//    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
	//    we must explicitly configure how they should be treated during item encryption:
	//      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
	//      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
	//      - DO_NOTHING: The attribute is not encrypted and not included in the signature
	attributeActions := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		"partition_key": dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Partition key must be SIGN_ONLY
		"sort_key":      dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Sort key must be SIGN_ONLY
		"attribute1":    dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"attribute2":    dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		":attribute3":   dbesdkstructuredencryptiontypes.CryptoActionDoNothing,
	}

	// 3. Configure which attributes we expect to be included in the signature
	//    when reading items. There are two options for configuring this:
	//
	//    - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
	//      When defining your DynamoDb schema and deciding on attribute names,
	//      choose a distinguishing prefix (such as ":") for all attributes that
	//      you do not want to include in the signature.
	//      This has two main benefits:
	//      - It is easier to reason about the security and authenticity of data within your item
	//        when all unauthenticated data is easily distinguishable by their attribute name.
	//      - If you need to add new unauthenticated attributes in the future,
	//        you can easily make the corresponding update to your `attributeActionsOnEncrypt`
	//        and immediately start writing to that new attribute, without
	//        any other configuration update needed.
	//      Once you configure this field, it is not safe to update it.
	//
	//    - Configure `allowedUnsignedAttributes`: You may also explicitly list
	//      a set of attributes that should be considered unauthenticated when encountered
	//      on read. Be careful if you use this configuration. Do not remove an attribute
	//      name from this configuration, even if you are no longer writing with that attribute,
	//      as old items may still include this attribute, and our configuration needs to know
	//      to continue to exclude this attribute from the signature scope.
	//      If you add new attribute names to this field, you must first deploy the update to this
	//      field to all readers in your host fleet before deploying the update to start writing
	//      with that new attribute.
	//
	//   For this example, we have designed our DynamoDb table such that any attribute name with
	//   the ":" prefix should be considered unauthenticated.
	allowedUnsignedAttributePrefix := ":"

	// 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
	partitionKey := "partition_key"
	sortKeyName := "sort_key"
	algorithmSuiteID := mpltypes.DBEAlgorithmSuiteIdAlgAes256GcmHkdfSha512CommitKeyEcdsaP384SymsigHmacSha384
	tableConfig := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:               ddbTableName,
		PartitionKeyName:               partitionKey,
		SortKeyName:                    &sortKeyName,
		AttributeActionsOnEncrypt:      attributeActions,
		Keyring:                        keyring,
		AllowedUnsignedAttributePrefix: &allowedUnsignedAttributePrefix,
		AlgorithmSuiteId:               &algorithmSuiteID,
	}
	tableConfigsMap := make(map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig)
	tableConfigsMap[ddbTableName] = tableConfig
	listOfTableConfigs := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigsMap,
	}
	// 5. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(listOfTableConfigs)
	utils.HandleError(err)
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)
	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	// 6. Put an item into our table using the above client.
	//    Before the item gets sent to DynamoDb, it will be encrypted
	//    client-side, according to our configuration.
	item := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "BasicPutGetExample"},
		"sort_key":      &types.AttributeValueMemberN{Value: "0"},
		"attribute1":    &types.AttributeValueMemberS{Value: "encrypt and sign me!"},
		"attribute2":    &types.AttributeValueMemberS{Value: "sign me!"},
		":attribute3":   &types.AttributeValueMemberS{Value: "ignore me!"},
	}
	putInput := &dynamodb.PutItemInput{
		TableName: aws.String(ddbTableName),
		Item:      item,
	}
	_, err = ddb.PutItem(context.TODO(), putInput)
	utils.HandleError(err)

	// 7. Get the item back from our table using the same client.
	//    The client will decrypt the item client-side, and return
	//    back the original item.
	key := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "BasicPutGetExample"},
		"sort_key":      &types.AttributeValueMemberN{Value: "0"},
	}
	getInput := &dynamodb.GetItemInput{
		TableName: aws.String(ddbTableName),
		Key:       key,
		// In this example we configure a strongly consistent read
		// because we perform a read immediately after a write (for demonstrative purposes).
		// By default, reads are only eventually consistent.
		// Read our docs to determine which read consistency to use for your application:
		// https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.ReadConsistency.html
		ConsistentRead: aws.Bool(true),
	}
	result, err := ddb.GetItem(context.TODO(), getInput)
	utils.HandleError(err)
	// Verify the decrypted item
	if !reflect.DeepEqual(item, result.Item) {
		panic("Decrypted item does not match original item")
	}
	fmt.Println("BasicPutGetExample successful.")
}
