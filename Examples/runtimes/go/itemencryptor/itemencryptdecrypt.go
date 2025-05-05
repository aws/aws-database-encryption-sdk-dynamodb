// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package itemencryptor

import (
	"context"
	"reflect"

	mpl "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
	itemencryptor "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkdynamodbitemencryptorsmithygenerated"
	dbesdkitemencryptortypes "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkdynamodbitemencryptorsmithygeneratedtypes"
	dbesdkstructuredencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
	"github.com/aws/aws-sdk-go-v2/service/kms"
)

func Itemencryptdecrypt(kmsKeyID, ddbTableName string) {
	// 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
	//    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
	//    We will use the `CreateMrkMultiKeyring` method to create this keyring,
	//    as it will correctly handle both single region and Multi-Region KMS Keys.
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		panic(err)
	}
	// Create KMS client
	kmsClient := kms.NewFromConfig(cfg, func(o *kms.Options) {
		o.Region = "us-west-2"
	})
	// Initialize the mpl client
	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	if err != nil {
		panic(err)
	}

	// Create the Aws Kms Keyring
	awsKmsKeyringInput := mpltypes.CreateAwsKmsKeyringInput{
		KmsClient: kmsClient,
		KmsKeyId:  kmsKeyID,
	}
	keyring, err := matProv.CreateAwsKmsKeyring(context.Background(), awsKmsKeyringInput)
	if err != nil {
		panic(err)
	}

	// 2. Configure which attributes are encrypted and/or signed when writing new items.
	//    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
	//    we must explicitly configure how they should be treated during item encryption:
	//      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
	//      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
	//      - DO_NOTHING: The attribute is not encrypted and not included in the signature
	attributeActions := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		"ID":          dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Partition key must be SIGN_ONLY
		"sort_key":    dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Sort key must be SIGN_ONLY
		"attribute1":  dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"attribute2":  dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		":attribute3": dbesdkstructuredencryptiontypes.CryptoActionDoNothing,
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
	partitionKey := "ID"
	sortKeyName := "sort_key"
	algorithmSuiteId := mpltypes.DBEAlgorithmSuiteIdAlgAes256GcmHkdfSha512CommitKeyEcdsaP384SymsigHmacSha384
	itemEncryptorConfig := dbesdkitemencryptortypes.DynamoDbItemEncryptorConfig{
		LogicalTableName:               ddbTableName,
		PartitionKeyName:               partitionKey,
		SortKeyName:                    &sortKeyName,
		AttributeActionsOnEncrypt:      attributeActions,
		Keyring:                        keyring,
		AllowedUnsignedAttributePrefix: &allowedUnsignedAttributePrefix,
		AlgorithmSuiteId:               &algorithmSuiteId,
	}

	//  6. Put an item into our table using the above client.
	//     Before the item gets sent to DynamoDb, it will be encrypted
	//     client-side, according to our configuration.
	item := map[string]types.AttributeValue{
		"ID":          &types.AttributeValueMemberS{Value: "ItemEncryptDecryptExample"},
		"sort_key":    &types.AttributeValueMemberS{Value: "0"},
		"attribute1":  &types.AttributeValueMemberS{Value: "encrypt and sign me!"},
		"attribute2":  &types.AttributeValueMemberS{Value: "sign me!"},
		":attribute3": &types.AttributeValueMemberS{Value: "ignore me!"},
	}

	itemEncryptorClient, err := itemencryptor.NewClient(itemEncryptorConfig)
	if err != nil {
		panic(err)
	}

	encryptItemInput := &dbesdkitemencryptortypes.EncryptItemInput{
		PlaintextItem: item,
	}

	encryptedItem, err := itemEncryptorClient.EncryptItem(context.Background(), *encryptItemInput)

	if err != nil {
		panic(err)
	}

	decryptItemInput := &dbesdkitemencryptortypes.DecryptItemInput{
		EncryptedItem: encryptedItem.EncryptedItem,
	}

	decryptedItem, err := itemEncryptorClient.DecryptItem(context.Background(), *decryptItemInput)
	if !reflect.DeepEqual(item, decryptedItem.PlaintextItem) {
		panic("Decrypted item does not match original item")
	}
	// fmt.Println(decryptedItem.PlaintextItem)

	// Detailed printing showing the specific type of each AttributeValue
	// for key, value := range decryptedItem.PlaintextItem {
	// 	fmt.Printf("Key: %s, Type: %T, Value: %+v\n", key, value, value)

	// 	// You can also use a type switch to handle each type specifically
	// 	switch v := value.(type) {
	// 	case *types.AttributeValueMemberS:
	// 		fmt.Printf("  String value: %s\n", v.Value)
	// 	case *types.AttributeValueMemberN:
	// 		fmt.Printf("  Number value: %s\n", v.Value)
	// 	case *types.AttributeValueMemberB:
	// 		fmt.Printf("  Binary value: %d bytes\n", len(v.Value))
	// 	case *types.AttributeValueMemberBOOL:
	// 		fmt.Printf("  Boolean value: %t\n", v.Value)
	// 	case *types.AttributeValueMemberM:
	// 		fmt.Printf("  Map with %d entries\n", len(v.Value))
	// 	case *types.AttributeValueMemberL:
	// 		fmt.Printf("  List with %d items\n", len(v.Value))
	// 	case *types.AttributeValueMemberSS:
	// 		fmt.Printf("  String Set with %d items\n", len(v.Value))
	// 	case *types.AttributeValueMemberNS:
	// 		fmt.Printf("  Number Set with %d items\n", len(v.Value))
	// 	case *types.AttributeValueMemberBS:
	// 		fmt.Printf("  Binary Set with %d items\n", len(v.Value))
	// 	case *types.AttributeValueMemberNULL:
	// 		fmt.Println("  NULL value")
	// 	}
	// }
}
