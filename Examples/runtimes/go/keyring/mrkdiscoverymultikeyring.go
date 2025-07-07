// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package keyring

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

/*
This example sets up a MRK discovery multi-keyring to decrypt data using
the DynamoDB encryption client. A discovery keyring is not provided with any wrapping
keys; instead, it recognizes the KMS key that was used to encrypt a data key,
and asks KMS to decrypt with that KMS key. Discovery keyrings cannot be used
to encrypt data.

For more information on discovery keyrings, see
https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-keyring.html#kms-keyring-discovery

This example encrypts an item using an MRK multi-keyring and puts the
encrypted item to the configured DynamoDb table. Then, it gets the item
from the table and decrypts it using the discovery keyring.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
*/
func MrkDiscoveryMultiKeyringExample(keyArn, ddbTableName string, accountIds, regions []string) {
	// 1. Create a single MRK multi-keyring using the key arn.
	//    Although this example demonstrates use of the MRK discovery multi-keyring,
	//    a discovery keyring cannot be used to encrypt. So we will need to construct
	//    a non-discovery keyring for this example to encrypt. For more information on MRK
	//    multi-keyrings, see the MultiMrkKeyringExample in this directory.
	//    Though this is an "MRK multi-keyring", we do not need to provide multiple keys,
	//    and can use single-region KMS keys. We will provide a single key here; this
	//    can be either an MRK or a single-region key.
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)

	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)

	createAwsKmsMrkMultiKeyringInput := mpltypes.CreateAwsKmsMrkMultiKeyringInput{
		Generator: &keyArn,
	}
	encryptKeyring, err := matProv.CreateAwsKmsMrkMultiKeyring(context.Background(), createAwsKmsMrkMultiKeyringInput)
	utils.HandleError(err)

	// 2. Configure which attributes are encrypted and/or signed when writing new items.
	//    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
	//    we must explicitly configure how they should be treated during item encryption:
	//      - ENCRYPT_AND_SIGN: The attribute is encrypted and icncluded in the signature
	//      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
	//      - DO_NOTHING: The attribute is not encrypted and not included in the signature
	attributeActions := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		"partition_key":  dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Partition key must be SIGN_ONLY
		"sort_key":       dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Sort key must be SIGN_ONLY
		"sensitive_data": dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
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
	//   For this example, we currently authenticate all attributes. To make it easier to
	//   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
	unsignAttrPrefix := ":"

	// 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
	tableConfig := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:               ddbTableName,
		PartitionKeyName:               "partition_key",
		SortKeyName:                    aws.String("sort_key"),
		AttributeActionsOnEncrypt:      attributeActions,
		Keyring:                        encryptKeyring,
		AllowedUnsignedAttributePrefix: &unsignAttrPrefix,
	}
	tableConfigsMap := make(map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig)
	tableConfigsMap[ddbTableName] = tableConfig

	// 5. Create the DynamoDb Encryption Interceptor
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigsMap,
	})
	utils.HandleError(err)

	// 6. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
	ddbClient := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	// 7. Put an item into our table using the above client.
	//    Before the item gets sent to DynamoDb, it will be encrypted
	//    client-side using the MRK multi-keyring.
	item := map[string]types.AttributeValue{
		"partition_key":  &types.AttributeValueMemberS{Value: "awsKmsMrkDiscoveryMultiKeyringItem"},
		"sort_key":       &types.AttributeValueMemberN{Value: "0"},
		"sensitive_data": &types.AttributeValueMemberS{Value: "encrypt and sign me!"},
	}

	putRequest := &dynamodb.PutItemInput{
		TableName: aws.String(ddbTableName),
		Item:      item,
	}

	_, err = ddbClient.PutItem(context.TODO(), putRequest)
	utils.HandleError(err)

	// 8. Construct a discovery filter.
	//    A discovery filter limits the set of encrypted data keys
	//    the keyring can use to decrypt data.
	//    We will only let the keyring use keys in the selected AWS accounts
	//    and in the `aws` partition.
	//    This is the suggested config for most users; for more detailed config, see
	//      https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-keyring.html#kms-keyring-discovery
	discoveryFilter := mpltypes.DiscoveryFilter{
		Partition:  "aws",
		AccountIds: accountIds,
	}

	// 9. Construct a discovery keyring.
	//    Note that we choose to use the MRK discovery multi-keyring, even though
	//    our original keyring used a single KMS key.
	createAwsKmsMrkDiscoveryMultiKeyringInput := mpltypes.CreateAwsKmsMrkDiscoveryMultiKeyringInput{
		DiscoveryFilter: &discoveryFilter,
		Regions:         regions,
	}
	decryptKeyring, err := matProv.CreateAwsKmsMrkDiscoveryMultiKeyring(context.Background(), createAwsKmsMrkDiscoveryMultiKeyringInput)
	utils.HandleError(err)

	// 10. Create new DDB config and client using the decrypt discovery keyring.
	//     This is the same as the above config, except we pass in the decrypt keyring.
	tableConfigForDecrypt := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:               ddbTableName,
		PartitionKeyName:               "partition_key",
		SortKeyName:                    aws.String("sort_key"),
		AttributeActionsOnEncrypt:      attributeActions,
		Keyring:                        decryptKeyring,
		AllowedUnsignedAttributePrefix: &unsignAttrPrefix,
	}
	tableConfigsMapForDecrypt := make(map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig)
	tableConfigsMapForDecrypt[ddbTableName] = tableConfigForDecrypt

	dbEsdkMiddlewareForDecrypt, err := dbesdkmiddleware.NewDBEsdkMiddleware(dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigsMapForDecrypt,
	})
	utils.HandleError(err)

	ddbClientForDecrypt := dynamodb.NewFromConfig(cfg, dbEsdkMiddlewareForDecrypt.CreateMiddleware())

	// 11. Get the item back from our table using the client.
	//     The client will retrieve encrypted items from the DDB table, then
	//     detect the KMS key that was used to encrypt their data keys.
	//     The client will make a request to KMS to decrypt with the encrypting KMS key.
	//     If the client has permission to decrypt with the KMS key,
	//     the client will decrypt the item client-side using the keyring
	//     and return the original item.
	keyToGet := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "awsKmsMrkDiscoveryMultiKeyringItem"},
		"sort_key":      &types.AttributeValueMemberN{Value: "0"},
	}

	getRequest := &dynamodb.GetItemInput{
		Key:            keyToGet,
		TableName:      aws.String(ddbTableName),
		ConsistentRead: aws.Bool(true),
	}

	getResponse, err := ddbClientForDecrypt.GetItem(context.TODO(), getRequest)
	utils.HandleError(err)

	// Demonstrate that GetItem succeeded and returned the decrypted item
	if !reflect.DeepEqual(item, getResponse.Item) {
		panic("Decrypted item does not match original item")
	}
	fmt.Println("MRK Discovery Multi Keyring Example successful.")
}
