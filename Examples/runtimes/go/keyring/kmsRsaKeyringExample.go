// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package keyring

import (
	"context"
	"encoding/base64"
	"fmt"
	"os"
	"path/filepath"
	"reflect"
	"strings"

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
	kmstypes "github.com/aws/aws-sdk-go-v2/service/kms/types"
)

/*
This example sets up DynamoDb Encryption for the AWS SDK client
using the KMS RSA Keyring. This keyring uses a KMS RSA key pair to
encrypt and decrypt records. The client uses the downloaded public key
to encrypt items it adds to the table.
The keyring uses the private key to decrypt existing table items it retrieves,
by calling KMS' decrypt API.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
This example also requires access to a KMS RSA key.
Our tests provide a KMS RSA ARN that anyone can use, but you
can also provide your own KMS RSA key.
To use your own KMS RSA key, you must have either:
 - Its public key downloaded in a UTF-8 encoded PEM file
 - kms:GetPublicKey permissions on that key
If you do not have the public key downloaded, running this example
through its main method will download the public key for you
by calling kms:GetPublicKey.
You must also have kms:Decrypt permissions on the KMS RSA key.
*/

const defaultExampleRsaPublicKeyFilename = "KmsRsaKeyringExamplePublicKey.pem"

func KmsRsaKeyringExample(ddbTableName, rsaKeyArn string) {
	kmsRsaKeyringGetItemPutItem(ddbTableName, rsaKeyArn, defaultExampleRsaPublicKeyFilename)
}

func kmsRsaKeyringGetItemPutItem(ddbTableName, rsaKeyArn, rsaPublicKeyFilename string) {
	// You may provide your own RSA public key at rsaPublicKeyFilename.
	// This must be the public key for the RSA key represented at rsaKeyArn.
	// If this file is not present, this will write a UTF-8 encoded PEM file for you.
	if shouldGetNewPublicKey(rsaPublicKeyFilename) {
		writePublicKeyPemForRsaKey(rsaKeyArn, rsaPublicKeyFilename)
	}

	// 1. Load UTF-8 encoded public key PEM file.
	//    You may have an RSA public key file already defined.
	//    If not, the main method in this class will call
	//    the KMS RSA key, retrieve its public key, and store it
	//    in a PEM file for example use.
	publicKeyUtf8EncodedBytes, err := os.ReadFile(rsaPublicKeyFilename)
	utils.HandleError(err)

	// 2. Create a KMS RSA keyring.
	//    This keyring takes in:
	//     - kmsClient
	//     - kmsKeyId: Must be an ARN representing a KMS RSA key
	//     - publicKey: A ByteBuffer of a UTF-8 encoded PEM file representing the public
	//                  key for the key passed into kmsKeyId
	//     - encryptionAlgorithm: Must be either RSAES_OAEP_SHA_256 or RSAES_OAEP_SHA_1
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)

	kmsClient := kms.NewFromConfig(cfg, func(o *kms.Options) {
		o.Region = "us-west-2"
	})

	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)

	createAwsKmsRsaKeyringInput := mpltypes.CreateAwsKmsRsaKeyringInput{
		KmsClient:           kmsClient,
		KmsKeyId:            rsaKeyArn,
		PublicKey:           publicKeyUtf8EncodedBytes,
		EncryptionAlgorithm: kmstypes.EncryptionAlgorithmSpecRsaesOaepSha256,
	}
	awsKmsRsaKeyring, err := matProv.CreateAwsKmsRsaKeyring(context.Background(), createAwsKmsRsaKeyringInput)
	utils.HandleError(err)

	// 3. Configure which attributes are encrypted and/or signed when writing new items.
	//    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
	//    we must explicitly configure how they should be treated during item encryption:
	//      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
	//      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
	//      - DO_NOTHING: The attribute is not encrypted and not included in the signature
	attributeActions := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		"partition_key":  dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Our partition attribute must be SIGN_ONLY
		"sort_key":       dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Our sort attribute must be SIGN_ONLY
		"sensitive_data": dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
	}

	// 4. Configure which attributes we expect to be included in the signature
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
	//        you can easily make the corresponding update to your `attributeActions`
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

	// 5. Create the DynamoDb Encryption configuration for the table we will be writing to.
	//    Note: To use the KMS RSA keyring, your table config must specify an algorithmSuite
	//    that does not use asymmetric signing.
	partitionKey := "partition_key"
	sortKeyName := "sort_key"
	// Specify algorithmSuite without asymmetric signing here
	// As of v3.0.0, the only supported algorithmSuite without asymmetric signing is
	// ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384.
	algorithmSuiteID := mpltypes.DBEAlgorithmSuiteIdAlgAes256GcmHkdfSha512CommitKeySymsigHmacSha384

	tableConfig := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:               ddbTableName,
		PartitionKeyName:               partitionKey,
		SortKeyName:                    &sortKeyName,
		AttributeActionsOnEncrypt:      attributeActions,
		Keyring:                        awsKmsRsaKeyring,
		AllowedUnsignedAttributePrefix: &unsignAttrPrefix,
		AlgorithmSuiteId:               &algorithmSuiteID,
	}

	tableConfigsMap := make(map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig)
	tableConfigsMap[ddbTableName] = tableConfig
	listOfTableConfigs := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigsMap,
	}

	// 6. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(listOfTableConfigs)
	utils.HandleError(err)
	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	// 7. Put an item into our table using the above client.
	//    Before the item gets sent to DynamoDb, it will be encrypted
	//    client-side, according to our configuration.
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
	utils.HandleError(err)

	// 8. Get the item back from our table using the client.
	//    The client will decrypt the item client-side using the RSA keyring
	//    and return the original item.
	keyToGet := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "awsKmsRsaKeyringItem"},
		"sort_key":      &types.AttributeValueMemberN{Value: "0"},
	}

	getInput := &dynamodb.GetItemInput{
		Key:       keyToGet,
		TableName: aws.String(ddbTableName),
		// In this example we configure a strongly consistent read
		// because we perform a read immediately after a write (for demonstrative purposes).
		// By default, reads are only eventually consistent.
		// Read our docs to determine which read consistency to use for your application:
		// https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.ReadConsistency.html
		ConsistentRead: aws.Bool(true),
	}

	getResponse, err := ddb.GetItem(context.TODO(), getInput)
	utils.HandleError(err)

	returnedItem := getResponse.Item
	if !reflect.DeepEqual(item, returnedItem) {
		panic("Decrypted item does not match original item")
	}

	// Verify the sensitive data was decrypted correctly
	sensitiveDataAttr, exists := returnedItem["sensitive_data"]
	if !exists {
		panic("sensitive_data attribute not found in returned item")
	}

	if sensitiveDataValue, ok := sensitiveDataAttr.(*types.AttributeValueMemberS); ok {
		if sensitiveDataValue.Value != "encrypt and sign me!" {
			panic("Decrypted sensitive_data does not match expected value")
		}
	} else {
		panic("sensitive_data attribute is not a string")
	}

	fmt.Println("KMS RSA Keyring Example successful.")
}

func shouldGetNewPublicKey(rsaPublicKeyFilename string) bool {
	// Check if a public key file already exists
	if _, err := os.Stat(rsaPublicKeyFilename); err == nil {
		// If a public key file already exists: do not overwrite existing file
		return false
	}
	// If file is not present, generate a new key pair
	return true
}

func writePublicKeyPemForRsaKey(rsaKeyArn, rsaPublicKeyFilename string) {
	// Safety check: Validate file is not present
	if _, err := os.Stat(rsaPublicKeyFilename); err == nil {
		panic("writePublicKeyPemForRsaKey will not overwrite existing PEM files")
	}

	// This code will call KMS to get the public key for the KMS RSA key.
	// You must have kms:GetPublicKey permissions on the key for this to succeed.
	// The public key will be written to the file rsaPublicKeyFilename.
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)

	getterForPublicKey := kms.NewFromConfig(cfg, func(o *kms.Options) {
		o.Region = "us-west-2"
	})

	response, err := getterForPublicKey.GetPublicKey(context.TODO(), &kms.GetPublicKeyInput{
		KeyId: aws.String(rsaKeyArn),
	})
	utils.HandleError(err)

	publicKeyByteArray := response.PublicKey

	// Create PEM formatted public key
	pemContent := fmt.Sprintf("-----BEGIN PUBLIC KEY-----\n%s\n-----END PUBLIC KEY-----\n",
		encodeToPemBase64(publicKeyByteArray))

	// Ensure directory exists
	dir := filepath.Dir(rsaPublicKeyFilename)
	if err := os.MkdirAll(dir, 0755); err != nil {
		utils.HandleError(err)
	}

	// Write to file
	err = os.WriteFile(rsaPublicKeyFilename, []byte(pemContent), 0644)
	utils.HandleError(err)
}

// encodeToPemBase64 encodes bytes to base64 with proper line breaks for PEM format
func encodeToPemBase64(data []byte) string {
	const lineLength = 64
	encoded := base64.StdEncoding.EncodeToString(data)

	// Add line breaks every 64 characters
	var result strings.Builder
	for i := 0; i < len(encoded); i += lineLength {
		end := i + lineLength
		if end > len(encoded) {
			end = len(encoded)
		}
		result.WriteString(encoded[i:end])
		if end < len(encoded) {
			result.WriteString("\n")
		}
	}

	return result.String()
}
