package keyring

import (
	"context"
	"fmt"
	"os"

	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
	"github.com/aws/aws-sdk-go-v2/service/kms"

	mpl "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/dbesdkmiddleware"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dbesdk/examples/utils"
	kmstypes "github.com/aws/aws-sdk-go-v2/service/kms/types"
)

func PutItemGetItem(kmsRsaKeyID string, kmsRSAPublicKeyFileName string) {
	ddbTableName := "DynamoDbEncryptionInterceptorTestTableCS"
	// 1. Create the aws kms client
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		panic(err)
	}
	kmsClient := kms.NewFromConfig(cfg, func(o *kms.Options) {
		o.Region = "us-west-2"
	})
	// 2. Initialize the mpl client
	matProv, err := mpl.NewClient(
		mpltypes.MaterialProvidersConfig{},
	)
	if err != nil {
		panic(err)
	}
	// 3. Load UTF-8 encoded public key PEM file.
	// You may have an RSA public key file already defined.
	// If not, this method will call the KMS RSA key, retrieve its public key,
	// and store it in a PEM file for example use.
	if !utils.FileExists(kmsRSAPublicKeyFileName) {
		err = writePublicKeyPemForRsaKey(kmsRsaKeyID, kmsRSAPublicKeyFileName)
		if err != nil {
			panic(err)
		}
	}
	kmsRSAPublicKey, err := os.ReadFile(kmsRSAPublicKeyFileName)
	if err != nil {
		panic(err)
	}

	// 4. Create the keyring
	awsKmsRSAKeyringInput := mpltypes.CreateAwsKmsRsaKeyringInput{
		KmsClient:           kmsClient,
		KmsKeyId:            kmsRsaKeyID,
		PublicKey:           kmsRSAPublicKey,
		EncryptionAlgorithm: kmstypes.EncryptionAlgorithmSpecRsaesOaepSha256,
	}
	keyring, err := matProv.CreateAwsKmsRsaKeyring(context.Background(), awsKmsRSAKeyringInput)
	if err != nil {
		panic(err)
	}

	// 2. Configure attribute actions for encryption/signing
	attributeActions := map[string]awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes.CryptoAction{
		"partition_key":  awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes.CryptoActionSignOnly, // Partition key must be SIGN_ONLY
		"sort_key":       awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes.CryptoActionSignOnly, // Sort key must be SIGN_ONLY
		"sensitive_data": awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes.CryptoActionEncryptAndSign,
	}

	// 3. Configure table encryption
	allowedUnsignedAttributePrefix := ":"
	sortKeyName := "sort_key"
	algorithmSuiteID := mpltypes.DBEAlgorithmSuiteIdAlgAes256GcmHkdfSha512CommitKeySymsigHmacSha384
	tableConfig := awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:               ddbTableName,
		PartitionKeyName:               "partition_key",
		SortKeyName:                    &sortKeyName,
		AttributeActionsOnEncrypt:      attributeActions,
		Keyring:                        keyring,
		AllowedUnsignedAttributePrefix: &allowedUnsignedAttributePrefix,
		AlgorithmSuiteId:               &algorithmSuiteID,
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
		"partition_key":  &types.AttributeValueMemberS{Value: "awsKmsRsaKeyringItem"},
		"sort_key":       &types.AttributeValueMemberN{Value: "0"},
		"sensitive_data": &types.AttributeValueMemberS{Value: "encrypt and sign me!"},
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
		"partition_key": &types.AttributeValueMemberS{Value: "awsKmsRsaKeyringItem"},
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
	fmt.Println(result.Item["partition_key"].(*types.AttributeValueMemberS).Value)
	// Verify the decrypted item
	if result.Item["sensitive_data"].(*types.AttributeValueMemberS).Value != "encrypt and sign me!" {
		panic("unexpected value for attribute1")
	}
}

func writePublicKeyPemForRsaKey(rsaKeyArn, filename string) error {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		return err
	}

	kmsClient := kms.NewFromConfig(cfg)
	resp, err := kmsClient.GetPublicKey(context.TODO(), &kms.GetPublicKeyInput{
		KeyId: aws.String(rsaKeyArn),
	})
	if err != nil {
		return err
	}
	return utils.WritePublicKey(resp.PublicKey, filename)
}
