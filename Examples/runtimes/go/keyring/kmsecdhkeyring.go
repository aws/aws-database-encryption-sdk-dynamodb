// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package keyring

import (
	"context"
	"crypto/x509"
	"encoding/pem"
	"fmt"
	"os"
	"reflect"

	mpl "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
	primitivestypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/primitives/awscryptographyprimitivessmithygeneratedtypes"
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

const (
	exampleEccPublicKeySenderFilename    = "KmsEccKeyringExamplePublicKeySender.pem"
	exampleEccPublicKeyRecipientFilename = "KmsEccKeyringExamplePublicKeyRecipient.pem"
)

/*
These examples set up DynamoDb Encryption for the AWS SDK client
using the AWS KMS ECDH Keyring. This keyring, depending on its KeyAgreement scheme,
takes in the sender's KMS ECC Key ARN, and the recipient's ECC Public Key to derive a shared secret.
The keyring uses the shared secret to derive a data key to protect the
data keys that encrypt and decrypt DynamoDb table items.

Running these examples require access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
*/

/*
This example takes in the sender's KMS ECC key ARN, the sender's public key,
the recipient's public key, and the algorithm definition where the ECC keys lie.
The eccKeyArn parameter takes in the sender's KMS ECC key ARN,
the eccPublicKeySenderFileName parameter takes in the sender's public key that corresponds to the
eccKeyArn, the eccPublicKeyRecipientFileName parameter takes in the recipient's public key,
and the Curve Specification where the keys lie.

Both public keys MUST be UTF8 PEM-encoded X.509 public key, also known as SubjectPublicKeyInfo (SPKI),

This example encrypts a test item using the provided ECC keys and puts the
encrypted item to the provided DynamoDb table. Then, it gets the
item from the table and decrypts it.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)

This example also requires access to a KMS ECC key.
Our tests provide a KMS ECC Key ARN that anyone can use, but you
can also provide your own KMS ECC key.
To use your own KMS ECC key, you must have either:
  - Its public key downloaded in a UTF-8 encoded PEM file
  - kms:GetPublicKey permissions on that key.

If you do not have the public key downloaded, running this example
through its main method will download the public key for you
by calling kms:GetPublicKey.
You must also have kms:DeriveSharedSecret permissions on the KMS ECC key.
This example also requires a recipient ECC Public Key that lies on the same
curve as the sender public key. This examples uses another distinct
KMS ECC Public Key, it does not have to be a KMS key; it can be a
valid SubjectPublicKeyInfo (SPKI) Public Key.
*/
func KmsEcdhKeyringGetItemPutItem(ddbTableName, eccKeyArn, eccPublicKeySenderFileName, eccPublicKeyRecipientFileName string) {
	// Load UTF-8 encoded public key PEM files as DER encoded bytes.
	// You may provide your own PEM files to use here. If you provide this, it MUST
	// be a key on curve P256.
	// If not, the main method in this class will call
	// the KMS ECC key, retrieve its public key, and store it
	// in a PEM file for example use.
	publicKeyRecipientByteBuffer, err := loadPublicKeyBytes(eccPublicKeyRecipientFileName)
	utils.HandleError(err)
	publicKeySenderByteBuffer, err := loadPublicKeyBytes(eccPublicKeySenderFileName)
	utils.HandleError(err)

	// Create a KMS ECDH keyring.
	// This keyring uses the KmsPrivateKeyToStaticPublicKey configuration. This configuration calls for both of
	// the keys to be on the same curve (P256, P384, P521).
	// On encrypt, the keyring calls AWS KMS to derive the shared secret from the sender's KMS ECC Key ARN and the recipient's public key.
	// For this example, on decrypt, the keyring calls AWS KMS to derive the shared secret from the sender's KMS ECC Key ARN and the recipient's public key;
	// however, on decrypt, the recipient can construct a keyring such that the shared secret is calculated with
	// the recipient's private key and the sender's public key. In both scenarios the shared secret will be the same.
	// For more information on this configuration see:
	// https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-ecdh-keyring.html#kms-ecdh-create
	// The DynamoDb encryption client uses this keyring to encrypt and decrypt items.
	// This keyring takes in:
	//  - kmsClient
	//  - kmsKeyId: Must be an ARN representing a KMS ECC key meant for KeyAgreement
	//  - curveSpec: The curve name where the public keys lie
	//  - senderPublicKey: A ByteBuffer of a UTF-8 encoded public
	//               key for the key passed into kmsKeyId in DER format
	//  - recipientPublicKey: A ByteBuffer of a UTF-8 encoded public
	//               key for the key passed into kmsKeyId in DER format
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)
	kmsClient := kms.NewFromConfig(cfg, func(o *kms.Options) {
		o.Region = "us-west-2"
	})

	// Initialize the mpl client
	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)

	kmsEcdhStaticConfigurationInput := mpltypes.KmsPrivateKeyToStaticPublicKeyInput{
		RecipientPublicKey:  publicKeyRecipientByteBuffer,
		SenderKmsIdentifier: eccKeyArn,
		SenderPublicKey:     publicKeySenderByteBuffer,
	}

	kmsEcdhStaticConfiguration := &mpltypes.KmsEcdhStaticConfigurationsMemberKmsPrivateKeyToStaticPublicKey{
		Value: kmsEcdhStaticConfigurationInput,
	}

	createAwsKmsEcdhKeyringInput := mpltypes.CreateAwsKmsEcdhKeyringInput{
		KmsClient:          kmsClient,
		CurveSpec:          primitivestypes.ECDHCurveSpecEccNistP256,
		KeyAgreementScheme: kmsEcdhStaticConfiguration,
	}

	kmsEcdhKeyring, err := matProv.CreateAwsKmsEcdhKeyring(context.Background(), createAwsKmsEcdhKeyringInput)
	utils.HandleError(err)

	putGetItemWithKeyring(kmsEcdhKeyring, ddbTableName)
}

/*
This example takes in the recipient's KMS ECC key ARN via
the eccRecipientKeyArn parameter.

This example attempts to decrypt a test item using the provided eccRecipientKeyArn,
it does so by checking if the message header contains the recipient's public key.

Running this example requires access to the DDB Table whose name
is provided in CLI arguments.
This table must be configured with the following
primary key configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)

This example also requires access to a KMS ECC key.
Our tests provide a KMS ECC Key ARN that anyone can use, but you
can also provide your own KMS ECC key.
To use your own KMS ECC key, you must have:
  - kms:GetPublicKey permissions on that key.

This example will call kms:GetPublicKey on keyring creation.
You must also have kms:DeriveSharedSecret permissions on the KMS ECC key.
*/
func KmsEcdhDiscoveryGetItem(ddbTableName, eccRecipientKeyArn string) {
	// Create a KMS ECDH keyring.
	// This keyring uses the KmsPublicKeyDiscovery configuration.
	// On encrypt, the keyring will fail as it is not allowed to encrypt data under this configuration.
	// On decrypt, the keyring will check if its corresponding public key is stored in the message header. It
	// will AWS KMS to derive the shared from the recipient's KMS ECC Key ARN and the sender's public key;
	// For more information on this configuration see:
	// https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-ecdh-keyring.html#kms-ecdh-discovery
	// The DynamoDb encryption client uses this to encrypt and decrypt items.
	// This keyring takes in:
	//  - kmsClient
	//  - recipientKmsIdentifier: Must be an ARN representing a KMS ECC key meant for KeyAgreement
	//  - curveSpec: The curve name where the public keys lie
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)
	kmsClient := kms.NewFromConfig(cfg, func(o *kms.Options) {
		o.Region = "us-west-2"
	})

	// Initialize the mpl client
	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)

	kmsEcdhDiscoveryStaticConfigurationInput := mpltypes.KmsPublicKeyDiscoveryInput{
		RecipientKmsIdentifier: eccRecipientKeyArn,
	}
	kmsEcdhDiscoveryStaticConfiguration := &mpltypes.KmsEcdhStaticConfigurationsMemberKmsPublicKeyDiscovery{
		Value: kmsEcdhDiscoveryStaticConfigurationInput,
	}
	createAwsKmsEcdhKeyringInput := mpltypes.CreateAwsKmsEcdhKeyringInput{
		KmsClient:          kmsClient,
		CurveSpec:          primitivestypes.ECDHCurveSpecEccNistP256,
		KeyAgreementScheme: kmsEcdhDiscoveryStaticConfiguration,
	}

	kmsEcdhKeyring, err := matProv.CreateAwsKmsEcdhKeyring(context.Background(), createAwsKmsEcdhKeyringInput)
	utils.HandleError(err)

	getItemWithKeyring(kmsEcdhKeyring, ddbTableName)
}

func getItemWithKeyring(kmsEcdhKeyring mpltypes.IKeyring, ddbTableName string) {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)
	// Configure which attributes are encrypted and/or signed when writing new items.
	// For each attribute that may exist on the items we plan to write to our DynamoDbTable,
	// we must explicitly configure how they should be treated during item encryption:
	//   - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
	//   - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
	//   - DO_NOTHING: The attribute is not encrypted and not included in the signature
	attributeActions := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		"partition_key":  dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Our partition attribute must be SIGN_ONLY
		"sort_key":       dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Our sort attribute must be SIGN_ONLY
		"sensitive_data": dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
	}

	// Configure which attributes we expect to be included in the signature
	// when reading items. There are two options for configuring this:
	//
	// - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
	//   When defining your DynamoDb schema and deciding on attribute names,
	//   choose a distinguishing prefix (such as ":") for all attributes that
	//   you do not want to include in the signature.
	//   This has two main benefits:
	//   - It is easier to reason about the security and authenticity of data within your item
	//     when all unauthenticated data is easily distinguishable by their attribute name.
	//   - If you need to add new unauthenticated attributes in the future,
	//     you can easily make the corresponding update to your `attributeActions`
	//     and immediately start writing to that new attribute, without
	//     any other configuration update needed.
	//   Once you configure this field, it is not safe to update it.
	//
	// - Configure `allowedUnsignedAttributes`: You may also explicitly list
	//   a set of attributes that should be considered unauthenticated when encountered
	//   on read. Be careful if you use this configuration. Do not remove an attribute
	//   name from this configuration, even if you are no longer writing with that attribute,
	//   as old items may still include this attribute, and our configuration needs to know
	//   to continue to exclude this attribute from the signature scope.
	//   If you add new attribute names to this field, you must first deploy the update to this
	//   field to all readers in your host fleet before deploying the update to start writing
	//   with that new attribute.
	//
	// For this example, we currently authenticate all attributes. To make it easier to
	// add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
	unsignAttrPrefix := ":"

	// Create the DynamoDb Encryption configuration for the table we will be writing to.
	// Note: To use the KMS ECDH keyring, your table config must specify an algorithmSuite
	// that does not use asymmetric signing.
	algorithmSuiteID := mpltypes.DBEAlgorithmSuiteIdAlgAes256GcmHkdfSha512CommitKeySymsigHmacSha384
	tableConfig := map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		ddbTableName: {
			LogicalTableName:               ddbTableName,
			PartitionKeyName:               "partition_key",
			SortKeyName:                    aws.String("sort_key"),
			AttributeActionsOnEncrypt:      attributeActions,
			Keyring:                        kmsEcdhKeyring,
			AllowedUnsignedAttributePrefix: aws.String(unsignAttrPrefix),
			// Specify algorithmSuite without asymmetric signing here
			// As of v3.0.0, the only supported algorithmSuite without asymmetric signing is
			// ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384.
			AlgorithmSuiteId: &algorithmSuiteID,
		},
	}
	listOfTableConfigs := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfig,
	}
	// Create the DynamoDb Encryption Interceptor
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(listOfTableConfigs)
	utils.HandleError(err)
	ddbClient := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())

	// Get the item back from our table using the client.
	// The client will decrypt the item client-side using the ECDH keyring
	// and return the original item.
	keyToGet := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "awsKmsEcdhKeyringItem"},
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
	sensitiveData, ok := returnedItem["sensitive_data"].(*types.AttributeValueMemberS)
	if !ok || sensitiveData.Value != "encrypt and sign me!" {
		panic("Expected sensitive_data to be 'encrypt and sign me!'")
	}
}

func putGetItemWithKeyring(awsKmsEcdhKeyring mpltypes.IKeyring, ddbTableName string) {
	cfg, err := config.LoadDefaultConfig(context.TODO())
	utils.HandleError(err)
	// Configure which attributes are encrypted and/or signed when writing new items.
	// For each attribute that may exist on the items we plan to write to our DynamoDbTable,
	// we must explicitly configure how they should be treated during item encryption:
	//   - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
	//   - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
	//   - DO_NOTHING: The attribute is not encrypted and not included in the signature
	attributeActions := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		"partition_key":  dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Our partition attribute must be SIGN_ONLY
		"sort_key":       dbesdkstructuredencryptiontypes.CryptoActionSignOnly, // Our sort attribute must be SIGN_ONLY
		"sensitive_data": dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
	}

	// Configure which attributes we expect to be included in the signature
	// when reading items. There are two options for configuring this:
	//
	// - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
	//   When defining your DynamoDb schema and deciding on attribute names,
	//   choose a distinguishing prefix (such as ":") for all attributes that
	//   you do not want to include in the signature.
	//   This has two main benefits:
	//   - It is easier to reason about the security and authenticity of data within your item
	//     when all unauthenticated data is easily distinguishable by their attribute name.
	//   - If you need to add new unauthenticated attributes in the future,
	//     you can easily make the corresponding update to your `attributeActions`
	//     and immediately start writing to that new attribute, without
	//     any other configuration update needed.
	//   Once you configure this field, it is not safe to update it.
	//
	// - Configure `allowedUnsignedAttributes`: You may also explicitly list
	//   a set of attributes that should be considered unauthenticated when encountered
	//   on read. Be careful if you use this configuration. Do not remove an attribute
	//   name from this configuration, even if you are no longer writing with that attribute,
	//   as old items may still include this attribute, and our configuration needs to know
	//   to continue to exclude this attribute from the signature scope.
	//   If you add new attribute names to this field, you must first deploy the update to this
	//   field to all readers in your host fleet before deploying the update to start writing
	//   with that new attribute.
	//
	// For this example, we currently authenticate all attributes. To make it easier to
	// add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
	unsignAttrPrefix := ":"

	// Create the DynamoDb Encryption configuration for the table we will be writing to.
	// Note: To use the KMS ECDH keyring, your table config must specify an algorithmSuite
	// that does not use asymmetric signing.
	algorithmSuiteID := mpltypes.DBEAlgorithmSuiteIdAlgAes256GcmHkdfSha512CommitKeySymsigHmacSha384
	tableConfigs := map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		ddbTableName: {
			LogicalTableName:               ddbTableName,
			PartitionKeyName:               "partition_key",
			SortKeyName:                    aws.String("sort_key"),
			AttributeActionsOnEncrypt:      attributeActions,
			Keyring:                        awsKmsEcdhKeyring,
			AllowedUnsignedAttributePrefix: aws.String(unsignAttrPrefix),
			// Specify algorithmSuite without asymmetric signing here
			// As of v3.0.0, the only supported algorithmSuite without asymmetric signing is
			// ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384.
			AlgorithmSuiteId: &algorithmSuiteID,
		},
	}

	// Create the DynamoDb Encryption Interceptor
	listOfTableConfigs := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigs,
	}
	// Create the DynamoDb Encryption Interceptor
	dbEsdkMiddleware, err := dbesdkmiddleware.NewDBEsdkMiddleware(listOfTableConfigs)
	utils.HandleError(err)
	ddbClient := dynamodb.NewFromConfig(cfg, dbEsdkMiddleware.CreateMiddleware())
	utils.HandleError(err)

	// Put an item into our table using the above client.
	// Before the item gets sent to DynamoDb, it will be encrypted
	// client-side, according to our configuration.
	item := map[string]types.AttributeValue{
		"partition_key":  &types.AttributeValueMemberS{Value: "awsKmsEcdhKeyringItem"},
		"sort_key":       &types.AttributeValueMemberN{Value: "0"},
		"sensitive_data": &types.AttributeValueMemberS{Value: "encrypt and sign me!"},
	}

	putRequest := &dynamodb.PutItemInput{
		TableName: aws.String(ddbTableName),
		Item:      item,
	}

	_, err = ddbClient.PutItem(context.Background(), putRequest)
	utils.HandleError(err)

	// Get the item back from our table using the client.
	// The client will decrypt the item client-side using the ECDH keyring
	// and return the original item.
	keyToGet := map[string]types.AttributeValue{
		"partition_key": &types.AttributeValueMemberS{Value: "awsKmsEcdhKeyringItem"},
		"sort_key":      &types.AttributeValueMemberN{Value: "0"},
	}

	getRequest := &dynamodb.GetItemInput{
		Key:       keyToGet,
		TableName: aws.String(ddbTableName),
	}

	getResponse, err := ddbClient.GetItem(context.Background(), getRequest)
	utils.HandleError(err)

	// Verify the decrypted item
	if !reflect.DeepEqual(item, getResponse.Item) {
		panic("Decrypted item does not match original item")
	}
}

func loadPublicKeyBytes(eccPublicKeyFileName string) ([]byte, error) {
	// Read the PEM file
	publicKeyFileBytes, err := os.ReadFile(eccPublicKeyFileName)
	if err != nil {
		return nil, fmt.Errorf("error reading public key file: %w", err)
	}

	// Decode the PEM block
	block, _ := pem.Decode(publicKeyFileBytes)
	if block == nil {
		return nil, fmt.Errorf("failed to decode PEM block")
	}

	// Parse the public key to ensure it's valid
	_, err = x509.ParsePKIXPublicKey(block.Bytes)
	if err != nil {
		return nil, fmt.Errorf("failed to parse public key: %w", err)
	}

	// Return the DER-encoded bytes
	return block.Bytes, nil
}

// KmsEcdhKeyringGetItemPutItemWithDefaults uses default filenames for public keys
func KmsEcdhKeyringGetItemPutItemWithDefaults(ddbTableName, eccKeyArn string) {
	KmsEcdhKeyringGetItemPutItem(
		ddbTableName,
		eccKeyArn,
		exampleEccPublicKeySenderFilename,
		exampleEccPublicKeyRecipientFilename,
	)
}

func writePublicKeyPemForEccKey(eccKeyArn, eccPublicKeyFilename string) error {
	// Safety check: Validate file is not present
	if _, err := os.Stat(eccPublicKeyFilename); err == nil {
		return fmt.Errorf("writePublicKeyPemForEccKey will not overwrite existing PEM files")
	}

	// This code will call KMS to get the public key for the KMS ECC key.
	// You must have kms:GetPublicKey permissions on the key for this to succeed.
	// The public key will be written to the file eccPublicKeyFilename.
	cfg, err := config.LoadDefaultConfig(context.TODO())
	if err != nil {
		return fmt.Errorf("failed to load AWS config: %w", err)
	}

	kmsClient := kms.NewFromConfig(cfg)
	response, err := kmsClient.GetPublicKey(context.Background(), &kms.GetPublicKeyInput{
		KeyId: aws.String(eccKeyArn),
	})
	if err != nil {
		return fmt.Errorf("failed to get public key from KMS: %w", err)
	}

	publicKeyByteArray := response.PublicKey

	// Create PEM block
	pemBlock := &pem.Block{
		Type:  "PUBLIC KEY",
		Bytes: publicKeyByteArray,
	}

	// Write to file
	file, err := os.Create(eccPublicKeyFilename)
	if err != nil {
		return fmt.Errorf("failed to create file: %w", err)
	}
	defer file.Close()

	err = pem.Encode(file, pemBlock)
	if err != nil {
		return fmt.Errorf("failed to encode PEM: %w", err)
	}

	return nil
}

func shouldGetNewPublicKeys() bool {
	// Check if public keys already exist
	senderExists := false
	recipientExists := false

	if _, err := os.Stat(exampleEccPublicKeySenderFilename); err == nil {
		senderExists = true
	}
	if _, err := os.Stat(exampleEccPublicKeyRecipientFilename); err == nil {
		recipientExists = true
	}

	if senderExists && recipientExists {
		return false
	}

	if !senderExists && recipientExists {
		panic(fmt.Sprintf("Missing public key sender file at %s", exampleEccPublicKeySenderFilename))
	}

	if senderExists && !recipientExists {
		panic(fmt.Sprintf("Missing public key recipient file at %s", exampleEccPublicKeyRecipientFilename))
	}

	return true
}

// KmsEcdhKeyringExample demonstrates the KMS ECDH keyring functionality
func KmsEcdhKeyringExample(ddbTableName, eccSenderKeyArn, eccRecipientKeyArn string) {
	// You may provide your own ECC Keys in the files located at
	// - exampleEccPublicKeySenderFilename
	// - exampleEccPublicKeyRecipientFilename
	// If these files are not present, this will get KMS ECC keys for you.
	if shouldGetNewPublicKeys() {
		err := writePublicKeyPemForEccKey(eccSenderKeyArn, exampleEccPublicKeySenderFilename)
		utils.HandleError(err)
		err = writePublicKeyPemForEccKey(eccRecipientKeyArn, exampleEccPublicKeyRecipientFilename)
		utils.HandleError(err)
	}

	KmsEcdhKeyringGetItemPutItem(
		ddbTableName,
		eccSenderKeyArn,
		exampleEccPublicKeySenderFilename,
		exampleEccPublicKeyRecipientFilename,
	)
	KmsEcdhDiscoveryGetItem(ddbTableName, eccRecipientKeyArn)
}
