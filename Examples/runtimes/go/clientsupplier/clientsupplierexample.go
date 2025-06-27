// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package clientsupplier

import (
	"context"
	"fmt"

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
This example sets up an MRK multi-keyring and an MRK discovery
multi-keyring using a custom client supplier.
A custom client supplier grants users access to more granular
configuration aspects of their authentication details and KMS
client. In this example, we create a simple custom client supplier
that authenticates with a different IAM role based on the
region of the KMS key.

This example creates a MRK multi-keyring configured with a custom
client supplier using a single MRK and puts an encrypted item to the
table. Then, it creates a MRK discovery multi-keyring to decrypt the item
and retrieves the item from the table.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
*/
func ClientSupplierExample(ddbTableName, keyArn string, accountIds, regions []string) {
	// 1. Create a single MRK multi-keyring.
	//    This can be either a single-region KMS key or an MRK.
	//    For this example to succeed, the key's region must either
	//    1) be in the regions list, or
	//    2) the key must be an MRK with a replica defined
	//    in a region in the regions list, and the client
	//    must have the correct permissions to access the replica.
	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)

	// Create the multi-keyring using our custom client supplier
	// defined in the RegionalRoleClientSupplier class in this directory.
	createAwsKmsMrkMultiKeyringInput := mpltypes.CreateAwsKmsMrkMultiKeyringInput{
		// Note: RegionalRoleClientSupplier will internally use the keyArn's region
		// to retrieve the correct IAM role.
		ClientSupplier: &RegionalRoleClientSupplier{},
		Generator:      &keyArn,
	}
	mrkKeyringWithClientSupplier, err := matProv.CreateAwsKmsMrkMultiKeyring(context.Background(), createAwsKmsMrkMultiKeyringInput)
	utils.HandleError(err)

	// 2. Configure which attributes are encrypted and/or signed when writing new items.
	//    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
	//    we must explicitly configure how they should be treated during item encryption:
	//      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
	//      - SIGN_ONLY: The attribute is not encrypted, but is still included in the signature
	//      - DO_NOTHING: The attribute is not encrypted and not included in the signature
	attributeActionsOnEncrypt := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		"partition_key":  dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Our partition attribute must be SIGN_ONLY
		"sort_key":       dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Our sort attribute must be SIGN_ONLY
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
	partitionKey := "partition_key"
	sortKey := "sort_key"
	// 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
	tableConfig := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:               ddbTableName,
		PartitionKeyName:               partitionKey,
		SortKeyName:                    &sortKey,
		AttributeActionsOnEncrypt:      attributeActionsOnEncrypt,
		Keyring:                        mrkKeyringWithClientSupplier,
		AllowedUnsignedAttributePrefix: &unsignAttrPrefix,
	}

	tableConfigs := map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		ddbTableName: tableConfig,
	}

	// 5. Create the DynamoDb Encryption Interceptor
	encryptionConfig := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigs,
	}

	// 6. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)

	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(encryptionConfig)
	utils.HandleError(err)
	ddbClient := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	// 7. Put an item into our table using the above client.
	//    Before the item gets sent to DynamoDb, it will be encrypted
	//    client-side using the MRK multi-keyring.
	//    The data key protecting this item will be encrypted
	//    with all the KMS Keys in this keyring, so that it can be
	//    decrypted with any one of those KMS Keys.
	item := map[string]types.AttributeValue{
		"partition_key":  &types.AttributeValueMemberS{Value: "clientSupplierItem"},
		"sort_key":       &types.AttributeValueMemberN{Value: "0"},
		"sensitive_data": &types.AttributeValueMemberS{Value: "encrypt and sign me!"},
	}

	putRequest := &dynamodb.PutItemInput{
		TableName: &ddbTableName,
		Item:      item,
	}

	_, err = ddbClient.PutItem(context.Background(), putRequest)
	utils.HandleError(err)

	// 8. Get the item back from our table using the same keyring.
	//    The client will decrypt the item client-side using the MRK
	//    and return the original item.
	keyToGet := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "clientSupplierItem"},
		"sort_key":      &types.AttributeValueMemberN{Value: "0"},
	}

	getRequest := &dynamodb.GetItemInput{
		Key:       keyToGet,
		TableName: aws.String(ddbTableName),
	}

	getResponse, err := ddbClient.GetItem(context.Background(), getRequest)
	utils.HandleError(err)

	// Demonstrate that GetItem succeeded and returned the decrypted item
	returnedItem := getResponse.Item
	sensitiveData := returnedItem["sensitive_data"].(*types.AttributeValueMemberS).Value
	if sensitiveData != "encrypt and sign me!" {
		panic("Decrypted data does not match expected value")
	}

	// 9. Create a MRK discovery multi-keyring with a custom client supplier.
	//    A discovery MRK multi-keyring will be composed of
	//    multiple discovery MRK keyrings, one for each region.
	//    Each component keyring has its own KMS client in a particular region.
	//    When we provide a client supplier to the multi-keyring, all component
	//    keyrings will use that client supplier configuration.
	//    In our tests, we make `keyArn` an MRK with a replica, and
	//    provide only the replica region in our discovery filter.
	discoveryFilter := mpltypes.DiscoveryFilter{
		Partition:  "aws",
		AccountIds: accountIds,
	}

	mrkDiscoveryClientSupplierInput := mpltypes.CreateAwsKmsMrkDiscoveryMultiKeyringInput{
		ClientSupplier:  &RegionalRoleClientSupplier{},
		DiscoveryFilter: &discoveryFilter,
		Regions:         regions,
	}
	mrkDiscoveryClientSupplierKeyring, err := matProv.CreateAwsKmsMrkDiscoveryMultiKeyring(context.Background(), mrkDiscoveryClientSupplierInput)
	utils.HandleError(err)

	// 10. Create a new config and client using the discovery keyring.
	//     This is the same setup as above, except we provide the discovery keyring to the config.
	onlyReplicaKeyTableConfig := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:          ddbTableName,
		PartitionKeyName:          partitionKey,
		SortKeyName:               &sortKey,
		AttributeActionsOnEncrypt: attributeActionsOnEncrypt,
		// Provide discovery keyring here
		Keyring:                        mrkDiscoveryClientSupplierKeyring,
		AllowedUnsignedAttributePrefix: &unsignAttrPrefix,
	}

	onlyReplicaKeyTableConfigs := map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		ddbTableName: onlyReplicaKeyTableConfig,
	}

	onlyReplicaKeyEncryptionConfig := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: onlyReplicaKeyTableConfigs,
	}

	onlyReplicaKeyDbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(onlyReplicaKeyEncryptionConfig)
	utils.HandleError(err)
	onlyReplicaKeyDdbClient := dynamodb.NewFromConfig(cfg, onlyReplicaKeyDbEsdkMiddleware.CreateMiddleware())

	// 11. Get the item back from our table using the discovery keyring client.
	//     The client will decrypt the item client-side using the keyring,
	//     and return the original item.
	//     The discovery keyring will only use KMS keys in the provided regions and
	//     AWS accounts. Since we have provided it with a custom client supplier
	//     which uses different IAM roles based on the key region,
	//     the discovery keyring will use a particular IAM role to decrypt
	//     based on the region of the KMS key it uses to decrypt.
	onlyReplicaKeyKeyToGet := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "clientSupplierItem"},
		"sort_key":      &types.AttributeValueMemberN{Value: "0"},
	}

	onlyReplicaKeyGetRequest := &dynamodb.GetItemInput{
		Key:       onlyReplicaKeyKeyToGet,
		TableName: &ddbTableName,
	}

	onlyReplicaKeyGetResponse, err := onlyReplicaKeyDdbClient.GetItem(context.Background(), onlyReplicaKeyGetRequest)
	utils.HandleError(err)

	// Demonstrate that GetItem succeeded and returned the decrypted item
	fmt.Println("GetItem with discovery keyring completed successfully")
	onlyReplicaKeyReturnedItem := onlyReplicaKeyGetResponse.Item
	onlyReplicaKeySensitiveData := onlyReplicaKeyReturnedItem["sensitive_data"].(*types.AttributeValueMemberS).Value
	if onlyReplicaKeySensitiveData != "encrypt and sign me!" {
		panic("Decrypted data from discovery keyring does not match expected value")
	}

	fmt.Println("Client Supplier Example completed successfully")
}
