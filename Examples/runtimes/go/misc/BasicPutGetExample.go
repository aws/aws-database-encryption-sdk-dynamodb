package misc

import (
	"context"
	"fmt"

	"github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
	"github.com/aws/aws-sdk-go-v2/service/kms"

	mpl "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/dbesdkmiddleware"
)

func PutItemGetItem() {
	// Get configuration values from environment or test utils
	kmsKeyID := "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"
	ddbTableName := "DynamoDbEncryptionInterceptorTestTableCS"

	// 1. Create a Keyring using AWS KMS
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		panic(err)
	}
	kmsClient := kms.NewFromConfig(cfg, func(o *kms.Options) {
		o.Region = "us-west-2"
	})
	// Step 2: Initialize the mpl client
	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	if err != nil {
		panic(err)
	}
	// Step 3: Create the keyring
	awsKmsKeyringInput := mpltypes.CreateAwsKmsKeyringInput{
		KmsClient: kmsClient,
		KmsKeyId:  kmsKeyID,
	}
	keyring, err := matProv.CreateAwsKmsKeyring(context.Background(), awsKmsKeyringInput)
	if err != nil {
		panic(err)
	}

	// 2. Configure attribute actions for encryption/signing
	attributeActions := map[string]awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes.CryptoAction{
		"partition_key": awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes.CryptoActionSignOnly, // Partition key must be SIGN_ONLY
		"sort_key":      awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes.CryptoActionSignOnly, // Sort key must be SIGN_ONLY
		"attribute1":    awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes.CryptoActionEncryptAndSign,
		"attribute2":    awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes.CryptoActionSignOnly,
		":attribute3":   awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes.CryptoActionDoNothing,
	}

	// 3. Configure table encryption
	allowedUnsignedAttributePrefix := ":"
	sortKeyName := "sort_key"
	algorithmSuiteId := mpltypes.DBEAlgorithmSuiteIdAlgAes256GcmHkdfSha512CommitKeyEcdsaP384SymsigHmacSha384
	tableConfig := awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:               ddbTableName,
		PartitionKeyName:               "partition_key",
		SortKeyName:                    &sortKeyName,
		AttributeActionsOnEncrypt:      attributeActions,
		Keyring:                        keyring,
		AllowedUnsignedAttributePrefix: &allowedUnsignedAttributePrefix,
		AlgorithmSuiteId:               &algorithmSuiteId,
	}

	tableConfigsMap := make(map[string]awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes.DynamoDbTableEncryptionConfig)
	tableConfigsMap[ddbTableName] = tableConfig
	listOfTableConfigs := awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigsMap,
	}
	// 4. Create encrypted DynamoDB client
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(listOfTableConfigs)
	if err != nil {
		panic(err)
	}
	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	// 5. Put an encrypted item
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
	if err != nil {
		panic(err)
	}

	// 6. Get and decrypt the item
	key := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "BasicPutGetExample"},
		"sort_key":      &types.AttributeValueMemberN{Value: "0"},
	}

	getInput := &dynamodb.GetItemInput{
		TableName:      aws.String(ddbTableName),
		Key:            key,
		ConsistentRead: aws.Bool(true),
	}

	result, err := ddb.GetItem(context.TODO(), getInput)
	if err != nil {
		panic(err)
	}
	// Verify the decrypted item
	if result.Item["attribute1"].(*types.AttributeValueMemberS).Value != "encrypt and sign me!" {
		panic("unexpected value for attribute1")
	}
	fmt.Println(result.Item["attribute1"].(*types.AttributeValueMemberS).Value)
}
