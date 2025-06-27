// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package searchableencryption

import (
	"context"
	"fmt"
	"time"

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
This example demonstrates how to set up a compound beacon on encrypted attributes,

	put an item with the beacon, and query against that beacon.

This example follows a use case of a database that stores unit inspection information.

	This is an extension of the "BasicSearchableEncryptionExample" in this directory.
	This example uses the same situation (storing unit inspection information)
	and the same table schema.

However, this example uses a different Global Secondary Index (GSI)

	that is based on a compound beacon configuration composed of
	the `last4` and `unit` attributes.

Running this example requires access to a DDB table with the
following key configuration:
  - Partition key is named "work_id" with type (S)
  - Sort key is named "inspection_time" with type (S)

This table must have a Global Secondary Index (GSI) configured named "last4UnitCompound-index":
  - Partition key is named "aws_dbe_b_last4UnitCompound" with type (S)

In this example for storing unit inspection information, this schema is utilized for the data:
  - "work_id" stores a unique identifier for a unit inspection work order (v4 UUID)
  - "inspection_date" stores an ISO 8601 date for the inspection (YYYY-MM-DD)
  - "inspector_id_last4" stores the last 4 digits of the ID of the inspector performing the work
  - "unit" stores a 12-digit serial number for the unit being inspected

The example requires the following ordered input command line parameters:
 1. DDB table name for table to put/query data from
 2. Branch key ID for a branch key that was previously created in your key store. See the
    CreateKeyStoreKeyExample.
 3. Branch key wrapping KMS key ARN for the KMS key used to create the branch key with ID
    provided in arg 2
 4. Branch key DDB table ARN for the DDB table representing the branch key store
*/
func CompoundBeaconSearchableEncryptionExample(
	ddbTableName,
	branchKeyID,
	branchKeyWrappingKmsKeyArn,
	branchKeyDdbTableName string) {
	const gsiName = "last4UnitCompound-index"
	partitionKeyName := "work_id"
	sortKeyName := "inspection_date"

	// 1. Create Beacons.
	//    These are the same beacons as in the "BasicSearchableEncryptionExample" in this directory.
	//    See that file to see details on beacon construction and parameters.
	//    While we will not directly query against these beacons,
	//      you must create standard beacons on encrypted fields
	//      that we wish to use in compound beacons.
	//    We mark them both as PartOnly to enforce the fact that
	//      we will not directly query against these beacons.
	standardBeaconList := []dbesdkdynamodbencryptiontypes.StandardBeacon{
		{
			Name:   "inspector_id_last4",
			Length: 10,
			Style: &dbesdkdynamodbencryptiontypes.BeaconStyleMemberpartOnly{
				Value: dbesdkdynamodbencryptiontypes.PartOnly{},
			},
		},
		{
			Name:   "unit",
			Length: 30,
			Style: &dbesdkdynamodbencryptiontypes.BeaconStyleMemberpartOnly{
				Value: dbesdkdynamodbencryptiontypes.PartOnly{},
			},
		},
	}

	// 2. Define encrypted parts.
	//    Encrypted parts define the beacons that can be used to construct a compound beacon,
	//        and how the compound beacon prefixes those beacon values.
	// A encrypted part must receive:
	//  - name: Name of a standard beacon
	//  - prefix: Any string. This is plaintext that prefixes the beaconized value in the compound beacon.
	//            Prefixes must be unique across the configuration, and must not be a prefix of another prefix;
	//            i.e. for all configured prefixes, the first N characters of a prefix must not equal another prefix.
	// In practice, it is suggested to have a short value distinguishable from other parts served on the prefix.

	encryptedPartList := []dbesdkdynamodbencryptiontypes.EncryptedPart{
		// For this example, we will choose "L-" as the prefix for "Last 4 digits of inspector ID".
		// With this prefix and the standard beacon's bit length definition (10), the beaconized
		//     version of the inspector ID's last 4 digits will appear as
		//     `L-000` to `L-3ff` inside a compound beacon.
		{
			Name:   "inspector_id_last4",
			Prefix: "L-",
		},
		// For this example, we will choose "U-" as the prefix for "unit".
		// With this prefix and the standard beacon's bit length definition (30), a unit beacon will appear
		//     as `U-00000000` to `U-3fffffff` inside a compound beacon.
		{
			Name:   "unit",
			Prefix: "U-",
		},
	}

	constructorParts := []dbesdkdynamodbencryptiontypes.ConstructorPart{
		{
			Name:     "inspector_id_last4",
			Required: true,
		},
		{
			// This name comes from the "unit" standard beacon.
			Name:     "unit",
			Required: true,
		},
	}
	constructors := []dbesdkdynamodbencryptiontypes.Constructor{
		{
			Parts: constructorParts,
		},
	}

	// 3. Define compound beacon.
	//    A compound beacon allows one to serve multiple beacons or attributes from a single index.
	//    A compound beacon must receive:
	//     - name: The name of the beacon. Compound beacon values will be written to `aws_ddb_e_[name]`.
	//     - split: A character separating parts in a compound beacon
	//    A compound beacon may also receive:
	//     - encrypted: A list of encrypted parts. This is effectively a list of beacons. We provide the list
	//                  that we created above.
	//     - constructors: A list of constructors. This is an ordered list of possible ways to create a beacon.
	//                     We have not defined any constructors here; see the complex example for how to do this.
	//                     The client will provide a default constructor, which will write a compound beacon as:
	//                     all signed parts in the order they are added to the signed list;
	//                     all encrypted parts in order they are added to the encrypted list; all parts required.
	//                     In this example, we expect compound beacons to be written as
	//                     `L-XXX.U-YYYYYYYY`, since our encrypted list looks like
	//                     [last4EncryptedPart, unitEncryptedPart].
	//     - signed: A list of signed parts, i.e. plaintext attributes. This would be provided if we
	//                     wanted to use plaintext values as part of constructing our compound beacon. We do not
	//                     provide this here; see the Complex example for an example.
	compoundBeaconList := []dbesdkdynamodbencryptiontypes.CompoundBeacon{
		{
			Name:         "last4UnitCompound",
			Constructors: constructors,
			Split:        ".",
		},
	}

	// 4. Configure the Keystore
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

	// 5. Create BeaconVersion.
	//    This is similar to the Basic example, except we have also provided a compoundBeaconList.
	//    We must also continue to provide all of the standard beacons that compose a compound beacon list.
	ttl := 6000
	cacheTTL := int32(ttl)
	singleKeyStore := dbesdkdynamodbencryptiontypes.SingleKeyStore{
		KeyId:    branchKeyID,
		CacheTTL: cacheTTL,
	}
	beaconKeySource := dbesdkdynamodbencryptiontypes.BeaconKeySourceMembersingle{
		Value: singleKeyStore,
	}
	beaconVersion := dbesdkdynamodbencryptiontypes.BeaconVersion{
		EncryptedParts:  encryptedPartList,
		StandardBeacons: standardBeaconList,
		CompoundBeacons: compoundBeaconList,
		Version:         1, // MUST be 1
		KeyStore:        keyStore,
		KeySource:       &beaconKeySource,
	}

	beaconVersions := []dbesdkdynamodbencryptiontypes.BeaconVersion{beaconVersion}

	// 6. Create a Hierarchical Keyring
	//    This is the same configuration as in the Basic example.
	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)

	ttlSeconds := int64(ttl)
	keyringInput := mpltypes.CreateAwsKmsHierarchicalKeyringInput{
		BranchKeyId: &branchKeyID,
		KeyStore:    keyStore,
		TtlSeconds:  ttlSeconds,
	}
	kmsKeyring, err := matProv.CreateAwsKmsHierarchicalKeyring(context.Background(), keyringInput)
	utils.HandleError(err)

	// 7. Configure which attributes are encrypted and/or signed when writing new items.
	attributeActionsOnEncrypt := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		partitionKeyName:     dbesdkstructuredencryptiontypes.CryptoActionSignOnly,       // Our partition attribute must be SIGN_ONLY
		sortKeyName:          dbesdkstructuredencryptiontypes.CryptoActionSignOnly,       // Our sort attribute must be SIGN_ONLY
		"inspector_id_last4": dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign, // Beaconized attributes must be encrypted
		"unit":               dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign, // Beaconized attributes must be encrypted
	}

	// We do not need to define a crypto action on last4UnitCompound.
	// We only need to define crypto actions on attributes that we pass to PutItem.

	// 8. Create the DynamoDb Encryption configuration for the table we will be writing to.
	//    The beaconVersions are added to the search configuration.
	writeVersion := int32(1)
	searchConfig := dbesdkdynamodbencryptiontypes.SearchConfig{
		WriteVersion: writeVersion, // MUST be 1
		Versions:     beaconVersions,
	}

	tableConfig := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:          ddbTableName,
		PartitionKeyName:          partitionKeyName,
		SortKeyName:               aws.String(sortKeyName),
		AttributeActionsOnEncrypt: attributeActionsOnEncrypt,
		Keyring:                   kmsKeyring,
		Search:                    &searchConfig,
	}

	tableConfigs := map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		ddbTableName: tableConfig,
	}

	// 9. Create config
	encryptionConfig := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigs,
	}

	// 10. Create an item with both attributes used in the compound beacon.
	item := map[string]types.AttributeValue{
		partitionKeyName:     &types.AttributeValueMemberS{Value: "9ce39272-8068-4efd-a211-cd162ad65d4c"},
		sortKeyName:          &types.AttributeValueMemberS{Value: "2023-06-13"},
		"inspector_id_last4": &types.AttributeValueMemberS{Value: "5678"},
		"unit":               &types.AttributeValueMemberS{Value: "011899988199"},
	}

	// 11. Create the DynamoDb Encryption Interceptor
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(encryptionConfig)
	utils.HandleError(err)

	// 12. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	putAndQueryItemWithCompoundBeacon(ddb, ddbTableName, item, gsiName)

	fmt.Println("Compound Beacon Searchable Encryption Example completed successfully")
}

func putAndQueryItemWithCompoundBeacon(ddb *dynamodb.Client, ddbTableName string, item map[string]types.AttributeValue, gsiName string) {
	// 13. Write the item to the table
	putRequest := &dynamodb.PutItemInput{
		TableName: aws.String(ddbTableName),
		Item:      item,
	}

	_, err := ddb.PutItem(context.Background(), putRequest)
	utils.HandleError(err)

	// 14. Query for the item we just put.
	expressionAttributeNames := map[string]string{
		"#compound": "last4UnitCompound",
	}

	expressionAttributeValues := map[string]types.AttributeValue{
		// This query expression takes a few factors into consideration:
		//  - The configured prefix for the last 4 digits of an inspector ID is "L-";
		//    the prefix for the unit is "U-"
		//  - The configured split character, separating component parts, is "."
		//  - The default constructor adds encrypted parts in the order they are in the encrypted list, which
		//    configures `last4` to come before `unit``
		// NOTE: We did not need to create a compound beacon for this query. This query could have also been
		//       done by querying on the partition and sort key, as was done in the Basic example.
		//       This is intended to be a simple example to demonstrate how one might set up a compound beacon.
		//       For examples where compound beacons are required, see the Complex example.
		//       The most basic extension to this example that would require a compound beacon would add a third
		//       part to the compound beacon, then query against three parts.
		":value": &types.AttributeValueMemberS{Value: "L-5678.U-011899988199"},
	}

	queryRequest := &dynamodb.QueryInput{
		TableName:                 aws.String(ddbTableName),
		IndexName:                 aws.String(gsiName),
		KeyConditionExpression:    aws.String("#compound = :value"),
		ExpressionAttributeNames:  expressionAttributeNames,
		ExpressionAttributeValues: expressionAttributeValues,
	}

	// GSIs do not update instantly
	// so if the results come back empty
	// we retry after a short sleep
	for i := 0; i < 10; i++ {
		queryResponse, err := ddb.Query(context.Background(), queryRequest)
		utils.HandleError(err)

		attributeValues := queryResponse.Items

		// if no results, sleep and try again
		if len(attributeValues) == 0 {
			time.Sleep(20 * time.Millisecond)
			continue
		}

		// Validate only 1 item was returned: the item we just put
		if len(attributeValues) != 1 {
			panic(fmt.Sprintf("Expected 1 item, got %d", len(attributeValues)))
		}
		returnedItem := attributeValues[0]
		// Validate the item has the expected attributes
		inspectorIdLast4 := returnedItem["inspector_id_last4"].(*types.AttributeValueMemberS).Value
		unit := returnedItem["unit"].(*types.AttributeValueMemberS).Value
		if inspectorIdLast4 != "5678" {
			panic(fmt.Sprintf("Expected inspector_id_last4 '5678', got '%s'", inspectorIdLast4))
		}
		if unit != "011899988199" {
			panic(fmt.Sprintf("Expected unit '011899988199', got '%s'", unit))
		}
		break
	}
}
