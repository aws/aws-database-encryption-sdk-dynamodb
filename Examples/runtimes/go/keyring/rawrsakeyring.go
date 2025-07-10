// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package keyring

import (
	"context"
	"crypto/rand"
	"crypto/rsa"
	"crypto/x509"
	"encoding/pem"
	"fmt"
	"os"
	"reflect"

	mpl "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
	dbesdkdynamodbencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	dbesdkstructuredencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/dbesdkmiddleware"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
	"github.com/aws/aws-sdk-go-v2/aws"
	"github.com/aws/aws-sdk-go-v2/config"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb"
	"github.com/aws/aws-sdk-go-v2/service/dynamodb/types"
)

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  using the raw RSA Keyring. This keyring uses an RSA key pair to
  encrypt and decrypt records. This keyring accepts PEM encodings of
  the key pair as UTF-8 interpreted bytes. The client uses the public key
  to encrypt items it adds to the table and uses the private key to decrypt
  existing table items it retrieves.

  This example loads a key pair from PEM files with paths defined in
   - exampleRsaPrivateKeyFilename
   - exampleRsaPublicKeyFilename
  If you do not provide these files, running this example through this
  class' main method will generate these files for you. These files will
  be generated in the directory where the example is run.
  In practice, users of this library should not generate new key pairs
  like this, and should instead retrieve an existing key from a secure
  key management system (e.g. an HSM).
  You may also provide your own key pair by placing PEM files in the
  directory where the example is run or modifying the paths in the code
  below. These files must be valid PEM encodings of the key pair as UTF-8
  encoded bytes. If you do provide your own key pair, or if a key pair
  already exists, this class' main method will not generate a new key pair.

  This example loads a key pair from disk, encrypts a test item, and puts the
  encrypted item to the provided DynamoDb table. Then, it gets the
  item from the table and decrypts it.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
*/

func RawRsaKeyringExample(ddbTableName, exampleRsaPublicKeyFilename, exampleRsaPrivateKeyFilename string) {
	// You may provide your own RSA key pair in the files located at
	//  - exampleRsaPrivateKeyFilename
	//  - exampleRsaPublicKeyFilename
	// If these files are not present, this will generate a pair for you
	if shouldGenerateNewRsaKeyPair(exampleRsaPublicKeyFilename, exampleRsaPrivateKeyFilename) {
		generateRsaKeyPair(exampleRsaPublicKeyFilename, exampleRsaPrivateKeyFilename)
	}

	// 1. Load key pair from UTF-8 encoded PEM files.
	//    You may provide your own PEM files to use here.
	//    If you do not, the main method in this class will generate PEM
	//    files for example use. Do not use these files for any other purpose.
	publicKeyUtf8EncodedBytes, err := os.ReadFile(exampleRsaPublicKeyFilename)
	utils.HandleError(err)

	privateKeyUtf8EncodedBytes, err := os.ReadFile(exampleRsaPrivateKeyFilename)
	utils.HandleError(err)

	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)

	// 2. Create the keyring.
	//    The DynamoDb encryption client uses this to encrypt and decrypt items.
	keyringInput := mpltypes.CreateRawRsaKeyringInput{
		KeyName:       "my-rsa-key-name",
		KeyNamespace:  "my-key-namespace",
		PaddingScheme: mpltypes.PaddingSchemeOaepSha256Mgf1,
		PublicKey:     publicKeyUtf8EncodedBytes,
		PrivateKey:    privateKeyUtf8EncodedBytes,
	}
	rawRsaKeyring, err := matProv.CreateRawRsaKeyring(context.Background(), keyringInput)
	utils.HandleError(err)

	// 3. Configure which attributes are encrypted and/or signed when writing new items.
	//    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
	//    we must explicitly configure how they should be treated during item encryption:
	//      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
	//      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
	//      - DO_NOTHING: The attribute is not encrypted and not included in the signature
	attributeActionsOnEncrypt := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
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
	unsignedAttrPrefix := ":"

	// 5. Create the DynamoDb Encryption configuration for the table we will be writing to.
	partitionKey := "partition_key"
	sortKeyName := "sort_key"
	tableConfig := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:               ddbTableName,
		PartitionKeyName:               partitionKey,
		SortKeyName:                    &sortKeyName,
		AttributeActionsOnEncrypt:      attributeActionsOnEncrypt,
		Keyring:                        rawRsaKeyring,
		AllowedUnsignedAttributePrefix: &unsignedAttrPrefix,
	}
	tableConfigsMap := make(map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig)
	tableConfigsMap[ddbTableName] = tableConfig
	listOfTableConfigs := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigsMap,
	}

	// 6. Create a new AWS SDK DynamoDb client using the Config above

	// Create DBESDK middleware
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(listOfTableConfigs)
	utils.HandleError(err)
	// Create aws config
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)
	ddb := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	// 7. Put an item into our table using the above client.
	//    Before the item gets sent to DynamoDb, it will be encrypted
	//    client-side, according to our configuration.
	item := map[string]types.AttributeValue{
		"partition_key":  &types.AttributeValueMemberS{Value: "rawRsaKeyringItem"},
		"sort_key":       &types.AttributeValueMemberN{Value: "0"},
		"sensitive_data": &types.AttributeValueMemberS{Value: "encrypt and sign me!"},
	}
	putInput := &dynamodb.PutItemInput{
		TableName: aws.String(ddbTableName),
		Item:      item,
	}
	_, err = ddb.PutItem(context.TODO(), putInput)
	utils.HandleError(err)

	// 8. Get the item back from our table using the same client.
	//    The client will decrypt the item client-side, and return
	//    back the original item.
	key := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "rawRsaKeyringItem"},
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

	// Demonstrate that GetItem succeeded and returned the decrypted item
	if !reflect.DeepEqual(item, result.Item) {
		panic("Decrypted item does not match original item")
	}
	fmt.Println("Raw RSA Keyring Example successful.")
}

func shouldGenerateNewRsaKeyPair(exampleRsaPublicKeyFilename, exampleRsaPrivateKeyFilename string) bool {
	// Check if a key pair already exists
	privateKeyExists := utils.FileExists(exampleRsaPrivateKeyFilename)
	publicKeyExists := utils.FileExists(exampleRsaPublicKeyFilename)

	// If a key pair already exists: do not overwrite existing key pair
	if privateKeyExists && publicKeyExists {
		return false
	}

	// If only one file is present: throw exception
	if privateKeyExists && !publicKeyExists {
		panic("Missing public key file at " + exampleRsaPublicKeyFilename)
	}
	if !privateKeyExists && publicKeyExists {
		panic("Missing private key file at " + exampleRsaPrivateKeyFilename)
	}

	// If neither file is present, generate a new key pair
	return true
}

func generateRsaKeyPair(exampleRsaPublicKeyFilename, exampleRsaPrivateKeyFilename string) {
	// Safety check: Validate neither file is present
	if utils.FileExists(exampleRsaPrivateKeyFilename) || utils.FileExists(exampleRsaPublicKeyFilename) {
		panic("generateRsaKeyPair will not overwrite existing PEM files")
	}

	// This code will generate a new RSA key pair for example use.
	// The public and private key will be written to the files:
	//  - public: exampleRsaPublicKeyFilename
	//  - private: exampleRsaPrivateKeyFilename
	// This example uses Go's crypto/rsa package to generate the key pair.
	// In practice, you should not generate this in your code, and should instead
	// retrieve this key from a secure key management system (e.g. HSM)
	// This key is created here for example purposes only.
	privateKey, err := rsa.GenerateKey(rand.Reader, 2048)
	utils.HandleError(err)

	// Extract public key from the private key
	publicKey := &privateKey.PublicKey

	// Encode private key to PKCS8 DER format
	privateKeyDER, err := x509.MarshalPKCS8PrivateKey(privateKey)
	utils.HandleError(err)

	// Encode public key to PKIX DER format
	publicKeyDER, err := x509.MarshalPKIXPublicKey(publicKey)
	utils.HandleError(err)

	// Create PEM blocks
	privateKeyBlock := &pem.Block{
		Type:  "PRIVATE KEY",
		Bytes: privateKeyDER,
	}

	publicKeyBlock := &pem.Block{
		Type:  "PUBLIC KEY",
		Bytes: publicKeyDER,
	}

	// Write private key to file
	privateKeyFile, err := os.Create(exampleRsaPrivateKeyFilename)
	utils.HandleError(err)
	defer privateKeyFile.Close()

	err = pem.Encode(privateKeyFile, privateKeyBlock)
	utils.HandleError(err)

	// Write public key to file
	publicKeyFile, err := os.Create(exampleRsaPublicKeyFilename)
	utils.HandleError(err)
	defer publicKeyFile.Close()

	err = pem.Encode(publicKeyFile, publicKeyBlock)
	utils.HandleError(err)
}
