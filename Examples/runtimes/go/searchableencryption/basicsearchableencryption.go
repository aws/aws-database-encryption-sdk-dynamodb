package searchableencryption

import (
	"context"
	"fmt"
	"time"

	dbeskstructuredencryption "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes"
	"github.com/aws/aws-sdk-go-v2/aws"

	keystore "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographykeystoresmithygenerated"
	keystoretypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographykeystoresmithygeneratedtypes"
	mpl "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
	dbesdktypes "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/dbesdkmiddleware"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
	"github.com/aws/aws-sdk-go-v2/service/kms"
)

func putAndQueryWithBeacon(branchKeyId string) {
	ddbTableName := "UnitInspectionTestTableCS"
	branchKeyWrappingKmsKeyArn := "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126"
	branchKeyDdbTableName := "KeyStoreDdbTable"
	GSI_NAME := "last4-unit-index"

	last4Beacon := dbesdktypes.StandardBeacon{
		Name:   "inspector_id_last4",
		Length: 10,
	}

	unitBeacon := dbesdktypes.StandardBeacon{
		Name:   "unit",
		Length: 30,
	}

	standard_beacon_list := []dbesdktypes.StandardBeacon{last4Beacon, unitBeacon}

	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		panic(err)
	}
	// Step 1a: Create the aws kms client
	kmsClient := kms.NewFromConfig(cfg)
	// Step 1b: Create the ddb client
	ddbClient := dynamodb.NewFromConfig(cfg)

	kmsConfig := keystoretypes.KMSConfigurationMemberkmsKeyArn{
		Value: branchKeyWrappingKmsKeyArn,
	}
	keyStore, err := keystore.NewClient(keystoretypes.KeyStoreConfig{
		DdbTableName:        branchKeyDdbTableName,
		KmsConfiguration:    &kmsConfig,
		LogicalKeyStoreName: branchKeyDdbTableName,
		DdbClient:           ddbClient,
		KmsClient:           kmsClient,
	})
	if err != nil {
		panic(err)
	}

	beacon_version := dbesdktypes.BeaconVersion{
		StandardBeacons: standard_beacon_list,
		Version:         1,
		KeyStore:        keyStore,
		KeySource: &dbesdktypes.BeaconKeySourceMembersingle{
			Value: dbesdktypes.SingleKeyStore{
				KeyId:    branchKeyId,
				CacheTTL: 6000,
			},
		},
	}
	beaconVersions := []dbesdktypes.BeaconVersion{beacon_version}

	// Create the Hierarchical Keyring.
	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	if err != nil {
		panic(err)
	}
	hkeyringInput := mpltypes.CreateAwsKmsHierarchicalKeyringInput{
		KeyStore:    keyStore,
		BranchKeyId: &branchKeyId,
		TtlSeconds:  6000,
	}
	keyring, err := matProv.CreateAwsKmsHierarchicalKeyring(context.Background(), hkeyringInput)
	if err != nil {
		panic(err)
	}

	attributeActionsOnEncrypt := map[string]dbeskstructuredencryption.CryptoAction{
		"work_id":            dbeskstructuredencryption.CryptoActionSignOnly,       // Our partition attribute must be SIGN_ONLY
		"inspection_date":    dbeskstructuredencryption.CryptoActionSignOnly,       // Our sort attribute must be SIGN_ONLY
		"inspector_id_last4": dbeskstructuredencryption.CryptoActionEncryptAndSign, // Beaconized attributes must be encrypted
		"unit":               dbeskstructuredencryption.CryptoActionEncryptAndSign, // Beaconized attributes must be encrypted
	}

	sortName := "inspection_date"
	tableConfig := dbesdktypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:          ddbTableName,
		PartitionKeyName:          "work_id",
		SortKeyName:               &sortName,
		AttributeActionsOnEncrypt: attributeActionsOnEncrypt,
		Keyring:                   keyring,
		Search: &dbesdktypes.SearchConfig{
			WriteVersion: 1,
			Versions:     beaconVersions,
		},
	}

	tableConfigs := dbesdktypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: map[string]dbesdktypes.DynamoDbTableEncryptionConfig{
			ddbTableName: tableConfig,
		},
	}

	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(tableConfigs)
	if err != nil {
		panic(err)
	}
	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	item := map[string]types.AttributeValue{
		"work_id":            &types.AttributeValueMemberS{Value: "1313ba89-5661-41eb-ba6c-cb1b4cb67b2d"},
		"inspection_date":    &types.AttributeValueMemberS{Value: "2023-06-13"},
		"inspector_id_last4": &types.AttributeValueMemberS{Value: "4321"},
		"unit":               &types.AttributeValueMemberS{Value: "123456789012"},
	}

	putInput := &dynamodb.PutItemInput{
		TableName: aws.String(ddbTableName),
		Item:      item,
	}

	_, err = ddb.PutItem(context.TODO(), putInput)
	if err != nil {
		panic(err)
	}

	expressionAttributesNames := map[string]string{
		"#last4": "inspector_id_last4",
		"#unit":  "unit",
	}

	expressionAttributeValues := map[string]types.AttributeValue{
		":last4": &types.AttributeValueMemberS{
			Value: "4321",
		},
		":unit": &types.AttributeValueMemberS{
			Value: "123456789012",
		},
	}
	keyConditionExpression := "#last4 = :last4 and #unit = :unit"
	for i := 0; i < 10; i++ {
		queryResponse, err := ddbClient.Query(context.TODO(), &dynamodb.QueryInput{
			TableName:                 &ddbTableName,
			IndexName:                 &GSI_NAME,
			KeyConditionExpression:    &keyConditionExpression,
			ExpressionAttributeNames:  expressionAttributesNames,
			ExpressionAttributeValues: expressionAttributeValues,
		})
		if err != nil {
			panic(err)
		}

		// if no results, sleep and try again
		if queryResponse.Items == nil || len(queryResponse.Items) == 0 {
			time.Sleep(20 * time.Millisecond)
			continue
		}

		attributeValues := queryResponse.Items
		// Validate only 1 item was returned: the item we just put
		if len(attributeValues) != 1 {
			panic("expected 1 item")
		}

		returnedItem := attributeValues[0]
		// Validate the item has the expected attributes
		if returnedItem["inspector_id_last4"].(*types.AttributeValueMemberS).Value != "4321" {
			panic("expected inspector_id_last4 to be 4321")
		}
		if returnedItem["unit"].(*types.AttributeValueMemberS).Value != "123456789012" {
			panic("expected unit to be 123456789012")
		}
		break
	}
	fmt.Println("basic_searchable_encryption successful.")
}
