// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package keyring

import (
	"context"
	"fmt"
	"reflect"

	keystoreclient "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographykeystoresmithygenerated"
	keystoretypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographykeystoresmithygeneratedtypes"
	mpl "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
	dbesdkdynamodb "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbsmithygenerated"
	dbesdkdynamodbencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	dbesdkstructuredencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/dbesdkmiddleware"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"

	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
	"github.com/aws/aws-sdk-go-v2/service/kms"
)

/*
This example sets up DynamoDb Encryption for the AWS SDK client
using the Hierarchical Keyring, which establishes a key hierarchy
where "branch" keys are persisted in DynamoDb.
These branch keys are used to protect your data keys,
and these branch keys are themselves protected by a root KMS Key.

Establishing a key hierarchy like this has two benefits:

First, by caching the branch key material, and only calling back
to KMS to re-establish authentication regularly according to your configured TTL,
you limit how often you need to call back to KMS to protect your data.
This is a performance/security tradeoff, where your authentication, audit, and
logging from KMS is no longer one-to-one with every encrypt or decrypt call.
However, the benefit is that you no longer have to make a
network call to KMS for every encrypt or decrypt.

Second, this key hierarchy makes it easy to hold multi-tenant data
that is isolated per branch key in a single DynamoDb table.
You can create a branch key for each tenant in your table,
and encrypt all that tenant's data under that distinct branch key.
On decrypt, you can either statically configure a single branch key
to ensure you are restricting decryption to a single tenant,
or you can implement an interface that lets you map the primary key on your items
to the branch key that should be responsible for decrypting that data.

This example then demonstrates configuring a Hierarchical Keyring
with a Branch Key ID Supplier to encrypt and decrypt data for
two separate tenants.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)

This example also requires using a KMS Key whose ARN
is provided in CLI arguments. You need the following access
on this key:
  - GenerateDataKeyWithoutPlaintext
  - Decrypt
*/
func HierarchicalKeyringExample(ddbTableName, tenant1BranchKeyId, tenant2BranchKeyId, keyStoreTableName, logicalKeyStoreName, kmsKeyId string) {
	// Initial KeyStore Setup: This example requires that you have already
	// created your KeyStore, and have populated it with two new branch keys.
	// See the "Create KeyStore Table Example" and "Create KeyStore Key Example"
	// for an example of how to do this.

	// 1. Configure your KeyStore resource.
	//    This SHOULD be the same configuration that you used
	//    to initially create and populate your KeyStore.
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)

	// Create KMS and DynamoDB clients
	kmsClient := kms.NewFromConfig(cfg, func(o *kms.Options) {
		o.Region = "us-west-2"
	})
	ddbClient := dynamodb.NewFromConfig(cfg)

	// Create KeyStore configuration
	kmsConfig := keystoretypes.KMSConfigurationMemberkmsKeyArn{
		Value: kmsKeyId,
	}
	keystoreConfig := keystoretypes.KeyStoreConfig{
		DdbClient:           ddbClient,
		DdbTableName:        keyStoreTableName,
		LogicalKeyStoreName: logicalKeyStoreName,
		KmsClient:           kmsClient,
		KmsConfiguration:    &kmsConfig,
	}

	// Initialize the KeyStore client
	keystore, err := keystoreclient.NewClient(keystoreConfig)
	utils.HandleError(err)

	// 2. Create a Branch Key ID Supplier. See ExampleBranchKeyIdSupplier in this directory.
	dbEsdkClient, err := dbesdkdynamodb.NewClient(dbesdkdynamodbencryptiontypes.DynamoDbEncryptionConfig{})
	utils.HandleError(err)

	branchKeyIdSupplier := NewExampleBranchKeyIdSupplier(tenant1BranchKeyId, tenant2BranchKeyId)

	branchKeyIdSupplierInput := dbesdkdynamodbencryptiontypes.CreateDynamoDbEncryptionBranchKeyIdSupplierInput{
		DdbKeyBranchKeyIdSupplier: branchKeyIdSupplier,
	}

	branchKeyIdSupplierInterface, err := dbEsdkClient.CreateDynamoDbEncryptionBranchKeyIdSupplier(
		context.Background(),
		branchKeyIdSupplierInput,
	)
	utils.HandleError(err)

	// 3. Create the Hierarchical Keyring, using the Branch Key ID Supplier above.
	//    With this configuration, the AWS SDK Client ultimately configured will be capable
	//    of encrypting or decrypting items for either tenant (assuming correct KMS access).
	//    If you want to restrict the client to only encrypt or decrypt for a single tenant,
	//    configure this Hierarchical Keyring using `.BranchKeyId(tenant1BranchKeyId)` instead
	//    of `.BranchKeyIdSupplier(branchKeyIdSupplier)`.
	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)

	hierarchicalKeyringInput := mpltypes.CreateAwsKmsHierarchicalKeyringInput{
		KeyStore:            keystore,
		BranchKeyIdSupplier: branchKeyIdSupplierInterface.BranchKeyIdSupplier,
		TtlSeconds:          600, // This dictates how often we call back to KMS to authorize use of the branch keys
		Cache: &mpltypes.CacheTypeMemberDefault{ // This dictates how many branch keys will be held locally
			Value: mpltypes.DefaultCache{
				EntryCapacity: 100,
			},
		},
	}

	hierarchicalKeyring, err := matProv.CreateAwsKmsHierarchicalKeyring(context.Background(), hierarchicalKeyringInput)
	utils.HandleError(err)

	// 4. Configure which attributes are encrypted and/or signed when writing new items.
	//    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
	//    we must explicitly configure how they should be treated during item encryption:
	//      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
	//      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
	//      - DO_NOTHING: The attribute is not encrypted and not included in the signature
	attributeActions := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		"partition_key":         dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Our partition attribute must be SIGN_ONLY
		"sort_key":              dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Our sort attribute must be SIGN_ONLY
		"tenant_sensitive_data": dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
	}

	// 5. Configure which attributes we expect to be included in the signature
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
	allowedUnsignedAttributePrefix := ":"

	// 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
	partitionKey := "partition_key"
	sortKeyName := "sort_key"
	algorithmSuiteID := mpltypes.DBEAlgorithmSuiteIdAlgAes256GcmHkdfSha512CommitKeyEcdsaP384SymsigHmacSha384

	tableConfig := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:               ddbTableName,
		PartitionKeyName:               partitionKey,
		SortKeyName:                    &sortKeyName,
		AttributeActionsOnEncrypt:      attributeActions,
		Keyring:                        hierarchicalKeyring,
		AllowedUnsignedAttributePrefix: &allowedUnsignedAttributePrefix,
		AlgorithmSuiteId:               &algorithmSuiteID,
	}

	tableConfigsMap := make(map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig)
	tableConfigsMap[ddbTableName] = tableConfig
	listOfTableConfigs := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigsMap,
	}

	// 7. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(listOfTableConfigs)
	utils.HandleError(err)
	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	// 8. Put an item into our table using the above client.
	//    Before the item gets sent to DynamoDb, it will be encrypted
	//    client-side, according to our configuration.
	//    Because the item we are writing uses "tenant1Id" as our partition value,
	//    based on the code we wrote in the ExampleBranchKeySupplier,
	//    `tenant1BranchKeyId` will be used to encrypt this item.
	item := map[string]types.AttributeValue{
		"partition_key":         &types.AttributeValueMemberS{Value: "tenant1Id"},
		"sort_key":              &types.AttributeValueMemberN{Value: "0"},
		"tenant_sensitive_data": &types.AttributeValueMemberS{Value: "encrypt and sign me!"},
	}

	putInput := &dynamodb.PutItemInput{
		TableName: aws.String(ddbTableName),
		Item:      item,
	}
	_, err = ddb.PutItem(context.TODO(), putInput)
	utils.HandleError(err)

	// 9. Get the item back from our table using the same client.
	//     The client will decrypt the item client-side, and return
	//     back the original item.
	//     Because the returned item's partition value is "tenant1Id",
	//     based on the code we wrote in the ExampleBranchKeySupplier,
	//     `tenant1BranchKeyId` will be used to decrypt this item.
	key := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "tenant1Id"},
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

	fmt.Println("Hierarchical Keyring Example successful.")
}
