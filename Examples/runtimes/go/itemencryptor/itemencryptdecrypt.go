// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package itemencryptor

import (
	"context"
	"fmt"
	"reflect"

	mpl "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
	itemencryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkdynamodbitemencryptorsmithygenerated"
	dbesdkitemencryptortypes "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkdynamodbitemencryptorsmithygeneratedtypes"
	dbesdkstructuredencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/examples/utils"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
	"github.com/aws/aws-sdk-go-v2/service/kms"
)

/*
This example sets up a DynamoDb Item Encryptor and uses
the EncryptItem and DecryptItem APIs to directly encrypt and
decrypt an existing DynamoDb item.
You should use the DynamoDb Item Encryptor
if you already have a DynamoDb Item to encrypt or decrypt,
and do not need to make a Put or Get call to DynamoDb.
For example, if you are using DynamoDb Streams,
you may already be working with an encrypted item obtained from
DynamoDb, and want to directly decrypt the item.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
- Partition key is named "partition_key" with type (S)
- Sort key is named "sort_key" with type (S)
*/

func ItemEncryptDecryptExample(kmsKeyID, ddbTableName string) {
	// 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
	//    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
	//    We will use the `CreateMrkMultiKeyring` method to create this keyring,
	//    as it will correctly handle both single region and Multi-Region KMS Keys.

	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)
	// Create KMS client
	kmsClient := kms.NewFromConfig(cfg)
	// Initialize the mpl client
	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)
	// Create the Aws Kms Keyring
	awsKmsKeyringInput := mpltypes.CreateAwsKmsKeyringInput{
		KmsClient: kmsClient,
		KmsKeyId:  kmsKeyID,
	}
	keyring, err := matProv.CreateAwsKmsKeyring(context.Background(), awsKmsKeyringInput)
	utils.HandleError(err)

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
	itemEncryptorConfig := dbesdkitemencryptortypes.DynamoDbItemEncryptorConfig{
		LogicalTableName:               ddbTableName,
		PartitionKeyName:               partitionKey,
		SortKeyName:                    &sortKeyName,
		AttributeActionsOnEncrypt:      attributeActions,
		Keyring:                        keyring,
		AllowedUnsignedAttributePrefix: &allowedUnsignedAttributePrefix,
		// Specifying an algorithm suite is not required,
		// but is done here to demonstrate how to do so.
		// We suggest using the
		// `ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384` suite,
		// which includes AES-GCM with key derivation, signing, and key commitment.
		// This is also the default algorithm suite if one is not specified in this config.
		// For more information on supported algorithm suites, see:
		//   https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/supported-algorithms.html
		AlgorithmSuiteId: &algorithmSuiteID,
	}

	// 5. Create the DynamoDb Item Encryptor
	itemEncryptorClient, err := itemencryptor.NewClient(itemEncryptorConfig)
	utils.HandleError(err)

	// 6. Directly encrypt a DynamoDb item using the DynamoDb Item Encryptor
	item := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "ItemEncryptDecryptExample"},
		"sort_key":      &types.AttributeValueMemberS{Value: "0"},
		"attribute1":    &types.AttributeValueMemberS{Value: "encrypt and sign me!"},
		"attribute2":    &types.AttributeValueMemberS{Value: "sign me!"},
		":attribute3":   &types.AttributeValueMemberS{Value: "ignore me!"},
	}
	encryptItemInput := &dbesdkitemencryptortypes.EncryptItemInput{
		PlaintextItem: item,
	}
	encryptItemOutput, err := itemEncryptorClient.EncryptItem(context.Background(), *encryptItemInput)
	utils.HandleError(err)

	// Demonstrate that the item has been encrypted
	encryptedItem := encryptItemOutput.EncryptedItem
	// Check partition_key is still a string and equals "ItemEncryptDecryptExample"
	if partitionKeyAttr, ok := encryptedItem["partition_key"].(*types.AttributeValueMemberS); ok {
		if partitionKeyAttr.Value != "ItemEncryptDecryptExample" {
			panic("Partition key is not 'ItemEncryptDecryptExample'")
		}
	} else {
		panic("Partition key is not a string attribute or doesn't exist")
	}
	// Check sort_key is a string and equals "0"
	if sortKeyAttr, ok := encryptedItem["sort_key"].(*types.AttributeValueMemberS); ok {
		if sortKeyAttr.Value != "0" {
			panic("Sort key is not '0'")
		}
	} else {
		panic("Sort key is not a string attribute or doesn't exist")
	}
	// Check attribute1 is binary (encrypted) and not a string anymore
	if _, ok := encryptedItem["attribute1"].(*types.AttributeValueMemberB); !ok {
		panic("attribute1 is not binary. It might not be encrypted.")
	}

	// 7. Directly decrypt the encrypted item using the DynamoDb Item Encryptor
	decryptItemInput := &dbesdkitemencryptortypes.DecryptItemInput{
		EncryptedItem: encryptedItem,
	}
	decryptedItem, err := itemEncryptorClient.DecryptItem(context.Background(), *decryptItemInput)
	utils.HandleError(err)

	if !reflect.DeepEqual(item, decryptedItem.PlaintextItem) {
		panic("Decrypted item does not match original item")
	}
	fmt.Println("Item Encryptor example successful")
}
