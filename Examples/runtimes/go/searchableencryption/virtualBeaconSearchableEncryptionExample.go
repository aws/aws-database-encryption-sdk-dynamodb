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
This example demonstrates how to set up a virtual field from two DDB
attributes, create a standard beacon with that field, put an item with
that beacon, and query against that beacon.

A virtual field is a field consisting of a transformation of one or more attributes in a DDB item.
Virtual fields are useful in querying against encrypted fields that only have a handful of
possible values. They allow you to take fields with few possible values, concatenate
them to other fields, then query against the combined field. This enables using these types of
fields in queries while making it infeasible to identify which beacon values encode
the few possible distinct plaintexts. This is explained in more detail below.
Virtual fields are not stored in the DDB table. However, they are used to construct
a beacon, the value of which is stored.

For more information on virtual fields, see

	https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/beacons.html#virtual-field

For our example, we will construct a virtual field
from two DDB attributes `state` and `hasTestResult` as `state`+prefix(`hasTestResult`, 1).
We will then create a beacon out of this virtual field and use it to search.

This example follows a use case of a database that stores customer test result metadata.
Records are indexed by `customer_id` and store a `state` attribute, representing the
US state or territory where the customer lives, and a `hasTestResult` boolean attribute,
representing whether the customer has a "test result" available. (Maybe this represents
some medical test result, and this table stores "result available" metadata.) We assume
that values in these fields are uniformly distributed across all possible values for
these fields (56 for `state`, 2 for `hasTestResult`), and are uniformly distributed across
customer IDs.

The motivation behind this example is to demonstrate how and why one would use a virtual beacon.
In this example, our table stores records with an encrypted boolean `hasTestResult` attribute.
We would like to be able to query for customers in a given state with a `true` hasTestResult
attribute.

To be able to execute this query securely and efficiently, we want the following
properties on our table:
 1. Hide the distribution of `hasTestResult` attribute values (i.e. it should be infeasible
    to determine the percentage of `true`s to `false`s across the dataset from beaconized
    values)
 2. Query against a combination of whether `hasTestResult` is true/false and the `state` field

We cannot achieve these properties with a standard beacon on a true/false attribute. Following
the guidance to choose a beacon length:

	https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html

For a boolean value (in our case, whether `hasTestResult` is true or false), the acceptable
bounds for beacon length are either 0 or 1. This corresponds to either not storing a beacon
(length 0), or effectively storing another boolean attribute (length 1). With
length 0, this beacon is useless for searching (violating property 2); with length 1, this
beacon may not hide the attribute (violating property 1).
In addition, choosing a longer beacon length does not help us.
Each attribute value is mapped to a distinct beacon.
Since booleans only have 2 possible attribute values, we will still only have 2 possible
beacon values, though those values may be longer. A longer beacon provides no advantages over
beacon of length 1 in this situation.

A compound beacon also does not help.
To (over)simplify, a compound beacon is a concatenation of standard beacons,
i.e. beacon(`state`)+beacon(`hasTestResult`).
The `hasTestResult` beacon is still visible, so we would still have the problems above.

To achieve these properties, we instead construct a virtual field and use that in our beacon,
i.e. beacon(`state`+`hasTestResult`). Assuming these fields are well-distributed across
customer IDs and possible values, this gives us both desired properties; we can query against
both attributes while hiding information from the underlying data. This is demonstrated in more
detail below.

Running this example requires access to a DDB table  with the
following primary key configuration:
  - Partition key is named "customer_id" with type (S)
  - Sort key is named "create_time" with type (S)

This table must have a Global Secondary Index (GSI) configured named "stateAndHasTestResult-index":
  - Partition key is named "aws_dbe_b_stateAndHasTestResult" with type (S)

In this example for storing customer location data, this schema is utilized for the data:
  - "customer_id" stores a unique customer identifier
  - "create_time" stores a Unix timestamp
  - "state" stores an encrypted 2-letter US state or territory abbreviation
    (https://www.faa.gov/air_traffic/publications/atpubs/cnt_html/appendix_a.html)
  - "hasTestResult" is not part of the schema, but is an attribute utilized in this example.
    It stores a boolean attribute (false/true) indicating whether this customer has a test result
    available.

The example requires the following ordered input command line parameters:
 1. DDB table name for table to put/query data from
 2. Branch key ID for a branch key that was previously created in your key store. See the
    CreateKeyStoreKeyExample.
 2. Branch key wrapping KMS key ARN for the KMS key used to create the branch key
 3. Branch key DDB table name for the DDB table representing the branch key store
*/
func VirtualBeaconSearchableEncryptionExample(ddbTableName, branchKeyId, branchKeyWrappingKmsKeyArn, branchKeyDdbTableName string) {
	const gsiName = "stateAndHasTestResult-index"

	// 1. Construct a length-1 prefix virtual transform.
	//    `hasTestResult` is a binary attribute, containing either `true` or `false`.
	//    As an example to demonstrate virtual transforms, we will truncate the value
	//    of `hasTestResult` in the virtual field to the length-1 prefix of the binary value, i.e.:
	//     - "true" -> "t"
	//     - "false -> "f"
	//    This is not necessary. This is done as a demonstration of virtual transforms.
	//    Virtual transform operations treat all attributes as strings
	//    (i.e. the boolean value `true` is interpreted as a string "true"),
	//    so its length-1 prefix is just "t".
	length1PrefixVirtualTransformList := []dbesdkdynamodbencryptiontypes.VirtualTransform{
		&dbesdkdynamodbencryptiontypes.VirtualTransformMemberprefix{
			Value: dbesdkdynamodbencryptiontypes.GetPrefix{
				Length: 1,
			},
		},
	}

	// 2. Construct the VirtualParts required for the VirtualField
	hasTestResultPart := dbesdkdynamodbencryptiontypes.VirtualPart{
		Loc: "hasTestResult",
		// Here, we apply the length-1 prefix virtual transform
		Trans: length1PrefixVirtualTransformList,
	}

	statePart := dbesdkdynamodbencryptiontypes.VirtualPart{
		Loc: "state",
		// Note that we do not apply any transform to the `state` attribute,
		// and the virtual field will read in the attribute as-is.
	}

	// 3. Construct the VirtualField from the VirtualParts
	//    Note that the order that virtual parts are added to the virtualPartList
	//    dictates the order in which they are concatenated to build the virtual field.
	//    You must add virtual parts in the same order on write as you do on read.
	virtualPartList := []dbesdkdynamodbencryptiontypes.VirtualPart{statePart, hasTestResultPart}

	stateAndHasTestResultField := dbesdkdynamodbencryptiontypes.VirtualField{
		Name:  "stateAndHasTestResult",
		Parts: virtualPartList,
	}

	virtualFieldList := []dbesdkdynamodbencryptiontypes.VirtualField{stateAndHasTestResultField}

	// 4. Configure our beacon.
	//    The virtual field is assumed to hold a US 2-letter state abbreviation
	//    (56 possible values = 50 states + 6 territories) concatenated with a binary attribute
	//    (2 possible values: true/false hasTestResult field), we expect a population size of
	//    56 * 2 = 112 possible values.
	//    We will also assume that these values are reasonably well-distributed across
	//    customer IDs. In practice, this will not be true. We would expect
	//    more populous states to appear more frequently in the database.
	//    A more complex analysis would show that a stricter upper bound
	//    is necessary to account for this by hiding information from the
	//    underlying distribution.
	//
	//    This link provides guidance for choosing a beacon length:
	//       https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/choosing-beacon-length.html
	//    We follow the guidance in the link above to determine reasonable bounds for beacon length:
	//     - min: log(sqrt(112))/log(2) ~= 3.4, round down to 3
	//     - max: log((112/2))/log(2) ~= 5.8, round up to 6
	//    You will somehow need to round results to a nearby integer.
	//    We choose to round to the nearest integer; you might consider a different rounding approach.
	//    Rounding up will return fewer expected "false positives" in queries,
	//       leading to fewer decrypt calls and better performance,
	//       but it is easier to identify which beacon values encode distinct plaintexts.
	//    Rounding down will return more expected "false positives" in queries,
	//       leading to more decrypt calls and worse performance,
	//       but it is harder to identify which beacon values encode distinct plaintexts.
	//    We can choose a beacon length between 3 and 6:
	//     - Closer to 3, we expect more "false positives" to be returned,
	//       making it harder to identify which beacon values encode distinct plaintexts,
	//       but leading to more decrypt calls and worse performance
	//     - Closer to 6, we expect fewer "false positives" returned in queries,
	//       leading to fewer decrypt calls and better performance,
	//       but it is easier to identify which beacon values encode distinct plaintexts.
	//    As an example, we will choose 5.
	//    Values stored in aws_dbe_b_stateAndHasTestResult will be 5 bits long (0x00 - 0x1f)
	//    There will be 2^5 = 32 possible HMAC values.
	//    With a well-distributed dataset (112 values), for a particular beacon we expect
	//    (112/32) = 3.5 combinations of abbreviation + true/false attribute
	//    sharing that beacon value.
	standardBeaconList := []dbesdkdynamodbencryptiontypes.StandardBeacon{
		{
			// This name is the same as our virtual field's name above
			Name:   "stateAndHasTestResult",
			Length: 5,
		},
	}

	// 5. Configure Keystore.
	//    This example expects that you have already set up a KeyStore with a single branch key.
	//    See the "CreateKeyStoreTableExample" and "CreateKeyStoreKeyExample" files for how to do this.
	//    After you create a branch key, you should persist its ID for use in this example.
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

	// Continue with the rest of the implementation
	executeVirtualBeaconExample(cfg, keyStore, branchKeyId, standardBeaconList, virtualFieldList, ddbTableName, gsiName)
}

func executeVirtualBeaconExample(cfg aws.Config, keyStore *keystoreclient.Client, branchKeyId string, standardBeaconList []dbesdkdynamodbencryptiontypes.StandardBeacon, virtualFieldList []dbesdkdynamodbencryptiontypes.VirtualField, ddbTableName, gsiName string) {
	// 6. Create BeaconVersion.
	cacheTTL := int32(6000)
	singleKeyStore := dbesdkdynamodbencryptiontypes.SingleKeyStore{
		KeyId:    branchKeyId,
		CacheTTL: cacheTTL,
	}
	beaconKeySource := dbesdkdynamodbencryptiontypes.BeaconKeySourceMembersingle{
		Value: singleKeyStore,
	}
	beaconVersion := dbesdkdynamodbencryptiontypes.BeaconVersion{
		VirtualFields:   virtualFieldList,
		StandardBeacons: standardBeaconList,
		Version:         1, // MUST be 1
		KeyStore:        keyStore,
		KeySource:       &beaconKeySource,
	}

	beaconVersions := []dbesdkdynamodbencryptiontypes.BeaconVersion{beaconVersion}

	// 7. Create a Hierarchical Keyring
	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)

	ttlSeconds := int64(6000)
	keyringInput := mpltypes.CreateAwsKmsHierarchicalKeyringInput{
		BranchKeyId: &branchKeyId,
		KeyStore:    keyStore,
		TtlSeconds:  ttlSeconds,
	}
	kmsKeyring, err := matProv.CreateAwsKmsHierarchicalKeyring(context.Background(), keyringInput)
	utils.HandleError(err)

	// 8. Configure which attributes are encrypted and/or signed when writing new items.
	attributeActionsOnEncrypt := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		"customer_id":   dbesdkstructuredencryptiontypes.CryptoActionSignOnly,       // Our partition attribute must be SIGN_ONLY
		"create_time":   dbesdkstructuredencryptiontypes.CryptoActionSignOnly,       // Our sort attribute must be SIGN_ONLY
		"state":         dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign, // Beaconized attributes must be encrypted
		"hasTestResult": dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign, // Beaconized attributes must be encrypted
	}

	// 9. Create the DynamoDb Encryption configuration for the table we will be writing to.
	writeVersion := int32(1)
	searchConfig := dbesdkdynamodbencryptiontypes.SearchConfig{
		WriteVersion: writeVersion, // MUST be 1
		Versions:     beaconVersions,
	}

	tableConfig := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:          ddbTableName,
		PartitionKeyName:          "customer_id",
		SortKeyName:               aws.String("create_time"),
		AttributeActionsOnEncrypt: attributeActionsOnEncrypt,
		Keyring:                   kmsKeyring,
		Search:                    &searchConfig,
	}

	tableConfigs := map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		ddbTableName: tableConfig,
	}

	// 10. Create config
	encryptionConfig := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigs,
	}

	// 11. Create test items
	itemWithHasTestResult := map[string]types.AttributeValue{
		"customer_id":   &types.AttributeValueMemberS{Value: "ABC-123"},
		"create_time":   &types.AttributeValueMemberN{Value: "1681495205"},
		"state":         &types.AttributeValueMemberS{Value: "CA"},
		"hasTestResult": &types.AttributeValueMemberBOOL{Value: true},
	}

	itemWithNoHasTestResult := map[string]types.AttributeValue{
		"customer_id":   &types.AttributeValueMemberS{Value: "DEF-456"},
		"create_time":   &types.AttributeValueMemberN{Value: "1681495205"},
		"state":         &types.AttributeValueMemberS{Value: "CA"},
		"hasTestResult": &types.AttributeValueMemberBOOL{Value: false},
	}

	// 12. Create the DynamoDb Encryption Interceptor
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(encryptionConfig)
	utils.HandleError(err)

	// 13. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	// 14. Put two items into our table using the above client.
	itemWithHasTestResultPutRequest := &dynamodb.PutItemInput{
		TableName: aws.String(ddbTableName),
		Item:      itemWithHasTestResult,
	}

	_, err = ddb.PutItem(context.Background(), itemWithHasTestResultPutRequest)
	utils.HandleError(err)

	itemWithNoHasTestResultPutRequest := &dynamodb.PutItemInput{
		TableName: aws.String(ddbTableName),
		Item:      itemWithNoHasTestResult,
	}

	_, err = ddb.PutItem(context.Background(), itemWithNoHasTestResultPutRequest)
	utils.HandleError(err)

	// 15. Query by stateAndHasTestResult attribute.
	expressionAttributeNames := map[string]string{
		"#stateAndHasTestResult": "stateAndHasTestResult",
	}

	expressionAttributeValues := map[string]types.AttributeValue{
		// We are querying for the item with `state`="CA" and `hasTestResult`=`true`.
		// Since we added virtual parts as `state` then `hasTestResult`,
		//     we must write our query expression in the same order.
		// We constructed our virtual field as `state`+`hasTestResult`,
		//     so we add the two parts in that order.
		// Since we also created a virtual transform that truncated `hasTestResult`
		//     to its length-1 prefix, i.e. "true" -> "t",
		//     we write that field as its length-1 prefix in the query.
		":stateAndHasTestResult": &types.AttributeValueMemberS{Value: "CAt"},
	}

	queryRequest := &dynamodb.QueryInput{
		TableName:                 aws.String(ddbTableName),
		IndexName:                 aws.String(gsiName),
		KeyConditionExpression:    aws.String("#stateAndHasTestResult = :stateAndHasTestResult"),
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
		// Validate query was returned successfully
		fmt.Printf("Query attempt %d completed successfully\n", i+1)

		// if no results, sleep and try again
		if len(attributeValues) == 0 {
			time.Sleep(20 * time.Millisecond)
			continue
		}

		// Validate only 1 item was returned: the item with the expected attributes
		if len(attributeValues) != 1 {
			panic(fmt.Sprintf("Expected 1 item, got %d", len(attributeValues)))
		}
		returnedItem := attributeValues[0]
		// Validate the item has the expected attributes
		state := returnedItem["state"].(*types.AttributeValueMemberS).Value
		hasTestResult := returnedItem["hasTestResult"].(*types.AttributeValueMemberBOOL).Value
		if state != "CA" {
			panic(fmt.Sprintf("Expected state 'CA', got '%s'", state))
		}
		if !hasTestResult {
			panic(fmt.Sprintf("Expected hasTestResult true, got %t", hasTestResult))
		}
		break
	}

	fmt.Println("Virtual Beacon Searchable Encryption Example completed successfully")
}
