// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package searchableencryption

import (
	"context"
	"fmt"

	keystoreclient "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographykeystoresmithygenerated"
	keystoretypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographykeystoresmithygeneratedtypes"
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
	"github.com/aws/aws-sdk-go-v2/service/kms"
)

/*
This example demonstrates how to use Beacons Styles on Standard Beacons on encrypted attributes,

	put an item with the beacon, and query against that beacon.

This example follows a use case of a database that stores food information.

	This is an extension of the "BasicSearchableEncryptionExample" in this directory
	and uses the same table schema.

Running this example requires access to a DDB table with the
following key configuration:
  - Partition key is named partitionKeyName with type (S)
  - Sort key is named "inspection_time" with type (S)

In this example for storing food information, this schema is utilized for the data:
  - partitionKeyName stores a unique identifier for a unit inspection work order (v4 UUID)
  - sortKeyName stores an ISO 8601 date for the inspection (YYYY-MM-DD)
  - "fruit" stores one type of fruit
  - "basket" stores a set of types of fruit
  - "dessert" stores one type of dessert
  - "veggies" stores a set of types of vegetable
  - "work_type" stores a unit inspection category

The example requires the following ordered input command line parameters:
 1. DDB table name for table to put/query data from
 2. Branch key ID for a branch key that was previously created in your key store. See the
    CreateKeyStoreKeyExample.
 3. Branch key wrapping KMS key ARN for the KMS key used to create the branch key with ID
    provided in arg 2
 4. Branch key DDB table ARN for the DDB table representing the branch key store
*/

func BeaconStylesSearchableEncryptionExample(
	ddbTableName,
	branchKeyId,
	branchKeyWrappingKmsKeyArn,
	branchKeyDdbTableName string) {
	partitionKeyName := "work_id"
	sortKeyName := "inspection_date"
	// 1. Create Beacons.
	standardBeaconList := []dbesdkdynamodbencryptiontypes.StandardBeacon{
		// The fruit beacon allows searching on the encrypted fruit attribute
		// We have selected 30 as an example beacon length, but you should go to
		// https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
		// when creating your beacons.
		{
			Name:   "fruit",
			Length: 30,
		},

		// The basket beacon allows searching on the encrypted basket attribute
		// basket is used as a Set, and therefore needs a beacon style to reflect that.
		// Further, we need to be able to compare the items in basket to the fruit attribute
		// so we `share` this beacon with `fruit`.
		// Since we need both of these things, we use the SharedSet style.
		{
			Name:   "basket",
			Length: 30,
			Style: &dbesdkdynamodbencryptiontypes.BeaconStyleMembersharedSet{
				Value: dbesdkdynamodbencryptiontypes.SharedSet{
					Other: "fruit",
				},
			},
		},

		// The dessert beacon allows searching on the encrypted dessert attribute
		// We need to be able to compare the dessert attribute to the fruit attribute
		// so we `share` this beacon with `fruit`.
		{
			Name:   "dessert",
			Length: 30,
			Style: &dbesdkdynamodbencryptiontypes.BeaconStyleMembershared{
				Value: dbesdkdynamodbencryptiontypes.Shared{
					Other: "fruit",
				},
			},
		},

		// The veggieBeacon allows searching on the encrypted veggies attribute
		// veggies is used as a Set, and therefore needs a beacon style to reflect that.
		{
			Name:   "veggies",
			Length: 30,
			Style: &dbesdkdynamodbencryptiontypes.BeaconStyleMemberasSet{
				Value: dbesdkdynamodbencryptiontypes.AsSet{},
			},
		},

		// The work_typeBeacon allows searching on the encrypted work_type attribute
		// We only use it as part of the compound work_unit beacon,
		// so we disable its use as a standalone beacon
		{
			Name:   "work_type",
			Length: 30,
			Style: &dbesdkdynamodbencryptiontypes.BeaconStyleMemberpartOnly{
				Value: dbesdkdynamodbencryptiontypes.PartOnly{},
			},
		},
	}

	// Here we build a compound beacon from work_id and work_type
	// If we had tried to make a StandardBeacon from work_type, we would have seen an error
	// because work_type is "PartOnly"
	encryptedPartList := []dbesdkdynamodbencryptiontypes.EncryptedPart{
		{
			Name:   "work_type",
			Prefix: "T-",
		},
	}

	signedPartList := []dbesdkdynamodbencryptiontypes.SignedPart{
		{
			Name:   partitionKeyName,
			Prefix: "I-",
		},
	}

	compoundBeaconList := []dbesdkdynamodbencryptiontypes.CompoundBeacon{
		{
			Name:      "work_unit",
			Split:     ".",
			Encrypted: encryptedPartList,
			Signed:    signedPartList,
		},
	}

	// 2. Configure the Keystore
	//    These are the same constructions as in the Basic example, which describes these in more detail.
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)

	kmsClient := kms.NewFromConfig(cfg)
	ddbClient := dynamodb.NewFromConfig(cfg)

	kmsConfig := keystoretypes.KMSConfigurationMemberkmsKeyArn{
		Value: branchKeyWrappingKmsKeyArn,
	}
	keyStoreConfig := keystoretypes.KeyStoreConfig{
		KmsClient:           kmsClient,
		DdbClient:           ddbClient,
		DdbTableName:        branchKeyDdbTableName,
		LogicalKeyStoreName: branchKeyDdbTableName,
		KmsConfiguration:    &kmsConfig,
	}

	keyStore, err := keystoreclient.NewClient(keyStoreConfig)
	utils.HandleError(err)

	// 3. Create BeaconVersion.
	//    This is similar to the Basic example
	ttl := 6000
	cacheTTL := int32(ttl)
	singleKeyStore := dbesdkdynamodbencryptiontypes.SingleKeyStore{
		KeyId:    branchKeyId,
		CacheTTL: cacheTTL,
	}
	beaconKeySource := dbesdkdynamodbencryptiontypes.BeaconKeySourceMembersingle{
		Value: singleKeyStore,
	}
	beaconVersion := dbesdkdynamodbencryptiontypes.BeaconVersion{
		StandardBeacons: standardBeaconList,
		CompoundBeacons: compoundBeaconList,
		Version:         1, // MUST be 1
		KeyStore:        keyStore,
		KeySource:       &beaconKeySource,
	}

	beaconVersions := []dbesdkdynamodbencryptiontypes.BeaconVersion{beaconVersion}

	// 4. Create a Hierarchical Keyring
	//    This is the same configuration as in the Basic example.
	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)

	ttlSeconds := int64(ttl)
	keyringInput := mpltypes.CreateAwsKmsHierarchicalKeyringInput{
		BranchKeyId: &branchKeyId,
		KeyStore:    keyStore,
		TtlSeconds:  ttlSeconds,
	}
	kmsKeyring, err := matProv.CreateAwsKmsHierarchicalKeyring(context.Background(), keyringInput)
	utils.HandleError(err)

	// 5. Configure which attributes are encrypted and/or signed when writing new items.
	attributeActionsOnEncrypt := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		partitionKeyName: dbesdkstructuredencryptiontypes.CryptoActionSignOnly,       // Our partition attribute must be SIGN_ONLY
		sortKeyName:      dbesdkstructuredencryptiontypes.CryptoActionSignOnly,       // Our sort attribute must be SIGN_ONLY
		"dessert":        dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign, // Beaconized attributes must be encrypted
		"fruit":          dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign, // Beaconized attributes must be encrypted
		"basket":         dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign, // Beaconized attributes must be encrypted
		"veggies":        dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign, // Beaconized attributes must be encrypted
		"work_type":      dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign, // Beaconized attributes must be encrypted
	}

	// 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
	//    The beaconVersions are added to the search configuration.
	writeVersion := int32(1)
	searchConfig := dbesdkdynamodbencryptiontypes.SearchConfig{
		WriteVersion: writeVersion, // MUST be 1
		Versions:     beaconVersions,
	}

	tableConfig := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:          ddbTableName,
		PartitionKeyName:          partitionKeyName,
		SortKeyName:               &sortKeyName,
		AttributeActionsOnEncrypt: attributeActionsOnEncrypt,
		Keyring:                   kmsKeyring,
		Search:                    &searchConfig,
	}

	tableConfigs := map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		ddbTableName: tableConfig,
	}

	// 7. Create config
	encryptionConfig := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigs,
	}

	// 8. Create item one, specifically with "dessert != fruit", and "fruit in basket".
	item1 := map[string]types.AttributeValue{
		partitionKeyName: &types.AttributeValueMemberS{Value: "1"},
		sortKeyName:      &types.AttributeValueMemberS{Value: "2023-06-13"},
		"dessert":        &types.AttributeValueMemberS{Value: "cake"},
		"fruit":          &types.AttributeValueMemberS{Value: "banana"},
		"basket":         &types.AttributeValueMemberSS{Value: []string{"banana", "apple", "pear"}},
		"veggies":        &types.AttributeValueMemberSS{Value: []string{"beans", "carrots", "celery"}},
		"work_type":      &types.AttributeValueMemberS{Value: "small"},
	}

	// 9. Create item two, specifically with "dessert == fruit", and "fruit not in basket".
	item2 := map[string]types.AttributeValue{
		partitionKeyName: &types.AttributeValueMemberS{Value: "2"},
		sortKeyName:      &types.AttributeValueMemberS{Value: "2023-06-13"},
		"dessert":        &types.AttributeValueMemberS{Value: "orange"},
		"fruit":          &types.AttributeValueMemberS{Value: "orange"},
		"basket":         &types.AttributeValueMemberSS{Value: []string{"strawberry", "blueberry", "blackberry"}},
		"veggies":        &types.AttributeValueMemberSS{Value: []string{"beans", "carrots", "peas"}},
		"work_type":      &types.AttributeValueMemberS{Value: "large"},
	}

	// 10. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(encryptionConfig)
	utils.HandleError(err)
	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	// 11. Put the two items
	putRequest1 := &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      item1,
	}

	_, err = ddb.PutItem(context.Background(), putRequest1)
	utils.HandleError(err)

	putRequest2 := &dynamodb.PutItemInput{
		TableName: aws.String(ddbTableName),
		Item:      item2,
	}

	_, err = ddb.PutItem(context.Background(), putRequest2)
	utils.HandleError(err)

	// 12. Test the first type of Set operation :
	// Select records where the basket attribute holds a particular value
	expressionAttributeValues := map[string]types.AttributeValue{
		":value": &types.AttributeValueMemberS{Value: "banana"},
	}

	scanRequest := &dynamodb.ScanInput{
		TableName:                 aws.String(ddbTableName),
		FilterExpression:          aws.String("contains(basket, :value)"),
		ExpressionAttributeValues: expressionAttributeValues,
	}

	scanResponse, err := ddb.Scan(context.Background(), scanRequest)
	utils.HandleError(err)

	// Validate only 1 item was returned: item1
	if len(scanResponse.Items) != 1 {
		panic(fmt.Sprintf("Expected 1 item, got %d", len(scanResponse.Items)))
	}
	returnedItem := scanResponse.Items[0]
	if returnedItem[partitionKeyName].(*types.AttributeValueMemberS).Value != item1[partitionKeyName].(*types.AttributeValueMemberS).Value {
		panic("Expected item1 to be returned")
	}

	// 13. Test the second type of Set operation :
	// Select records where the basket attribute holds the fruit attribute
	scanRequest = &dynamodb.ScanInput{
		TableName:        aws.String(ddbTableName),
		FilterExpression: aws.String("contains(basket, fruit)"),
	}

	scanResponse, err = ddb.Scan(context.Background(), scanRequest)
	utils.HandleError(err)

	// Validate only 1 item was returned: item1
	if len(scanResponse.Items) != 1 {
		panic(fmt.Sprintf("Expected 1 item, got %d", len(scanResponse.Items)))
	}
	returnedItem = scanResponse.Items[0]
	if returnedItem[partitionKeyName].(*types.AttributeValueMemberS).Value != item1[partitionKeyName].(*types.AttributeValueMemberS).Value {
		panic("Expected item1 to be returned")
	}

	// 14. Test the third type of Set operation :
	// Select records where the fruit attribute exists in a particular set
	basket3 := []string{"boysenberry", "orange", "grape"}
	expressionAttributeValues = map[string]types.AttributeValue{
		":value": &types.AttributeValueMemberSS{Value: basket3},
	}

	scanRequest = &dynamodb.ScanInput{
		TableName:                 aws.String(ddbTableName),
		FilterExpression:          aws.String("contains(:value, fruit)"),
		ExpressionAttributeValues: expressionAttributeValues,
	}

	scanResponse, err = ddb.Scan(context.Background(), scanRequest)
	utils.HandleError(err)

	// Validate only 1 item was returned: item2
	if len(scanResponse.Items) != 1 {
		panic(fmt.Sprintf("Expected 1 item, got %d", len(scanResponse.Items)))
	}
	returnedItem = scanResponse.Items[0]
	if returnedItem[partitionKeyName].(*types.AttributeValueMemberS).Value != item2[partitionKeyName].(*types.AttributeValueMemberS).Value {
		panic("Expected item2 to be returned")
	}

	// 15. Test a Shared search. Select records where the dessert attribute matches the fruit attribute
	scanRequest = &dynamodb.ScanInput{
		TableName:        aws.String(ddbTableName),
		FilterExpression: aws.String("dessert = fruit"),
	}

	scanResponse, err = ddb.Scan(context.Background(), scanRequest)
	utils.HandleError(err)

	// Validate only 1 item was returned: item2
	if len(scanResponse.Items) != 1 {
		panic(fmt.Sprintf("Expected 1 item, got %d", len(scanResponse.Items)))
	}
	returnedItem = scanResponse.Items[0]
	if returnedItem[partitionKeyName].(*types.AttributeValueMemberS).Value != item2[partitionKeyName].(*types.AttributeValueMemberS).Value {
		panic("Expected item2 to be returned")
	}

	// 16. Test the AsSet attribute 'veggies' :
	// Select records where the veggies attribute holds a particular value
	expressionAttributeValues = map[string]types.AttributeValue{
		":value": &types.AttributeValueMemberS{Value: "peas"},
	}

	scanRequest = &dynamodb.ScanInput{
		TableName:                 aws.String(ddbTableName),
		FilterExpression:          aws.String("contains(veggies, :value)"),
		ExpressionAttributeValues: expressionAttributeValues,
	}

	scanResponse, err = ddb.Scan(context.Background(), scanRequest)
	utils.HandleError(err)

	// Validate only 1 item was returned: item2
	if len(scanResponse.Items) != 1 {
		panic(fmt.Sprintf("Expected 1 item, got %d", len(scanResponse.Items)))
	}
	returnedItem = scanResponse.Items[0]
	if returnedItem[partitionKeyName].(*types.AttributeValueMemberS).Value != item2[partitionKeyName].(*types.AttributeValueMemberS).Value {
		panic("Expected item2 to be returned")
	}

	// 17. Test the compound beacon 'work_unit' :
	expressionAttributeValues = map[string]types.AttributeValue{
		":value": &types.AttributeValueMemberS{Value: "I-1.T-small"},
	}

	scanRequest = &dynamodb.ScanInput{
		TableName:                 aws.String(ddbTableName),
		FilterExpression:          aws.String("work_unit = :value"),
		ExpressionAttributeValues: expressionAttributeValues,
	}

	scanResponse, err = ddb.Scan(context.Background(), scanRequest)
	utils.HandleError(err)

	// Validate only 1 item was returned: item1
	if len(scanResponse.Items) != 1 {
		panic(fmt.Sprintf("Expected 1 item, got %d", len(scanResponse.Items)))
	}
	returnedItem = scanResponse.Items[0]
	if returnedItem[partitionKeyName].(*types.AttributeValueMemberS).Value != item1[partitionKeyName].(*types.AttributeValueMemberS).Value {
		panic("Expected item1 to be returned")
	}

	fmt.Println("Beacon Styles Searchable Encryption Example completed successfully")
}
