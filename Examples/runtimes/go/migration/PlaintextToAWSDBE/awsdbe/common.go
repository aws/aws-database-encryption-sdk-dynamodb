package awsdbe

import (
	"context"

	mpl "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygenerated"
	mpltypes "github.com/aws/aws-cryptographic-material-providers-library/releases/go/mpl/awscryptographymaterialproviderssmithygeneratedtypes"
	dbesdkdynamodbencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbsmithygeneratedtypes"
	dbesdkstructuredencryptiontypes "github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkstructuredencryptionsmithygeneratedtypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/examples/utils"
)

func configureTable(kmsKeyID, ddbTableName string, plaintextOverride dbesdkdynamodbencryptiontypes.PlaintextOverride) dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig {

	// Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
	// We will use the `CreateMrkMultiKeyring` method to create this keyring,
	// as it will correctly handle both single region and Multi-Region KMS Keys.
	matProv, err := mpl.NewClient(mpltypes.MaterialProvidersConfig{})
	utils.HandleError(err)

	keyringInput := mpltypes.CreateAwsKmsMrkMultiKeyringInput{
		Generator: &kmsKeyID,
	}
	kmsKeyring, err := matProv.CreateAwsKmsMrkMultiKeyring(context.Background(), keyringInput)
	utils.HandleError(err)

	// Configure which attributes are encrypted and/or signed when writing new items.
	// For each attribute that may exist on the items we plan to write to our DynamoDbTable,
	// we must explicitly configure how they should be treated during item encryption:
	//  - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
	//  - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
	//  - DO_NOTHING: The attribute is not encrypted and not included in the signature
	partitionKeyName := "partition_key"
	sortKeyName := "sort_key"

	attributeActions := map[string]dbesdkstructuredencryptiontypes.CryptoAction{
		partitionKeyName: dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		sortKeyName:      dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"attribute1":     dbesdkstructuredencryptiontypes.CryptoActionEncryptAndSign,
		"attribute2":     dbesdkstructuredencryptiontypes.CryptoActionSignOnly,
		"attribute3":     dbesdkstructuredencryptiontypes.CryptoActionDoNothing,
	}

	// Configure which attributes we expect to be excluded in the signature
	// when reading items. This value represents all unsigned attributes
	// across our entire dataset. If you ever want to add new unsigned attributes
	// in the future, you must make an update to this field to all your readers
	// before deploying any change to start writing that new data. It is not safe
	// to remove attributes from this field.
	unsignedAttributes := []string{"attribute3"}

	// Create encryption configuration for table.
	tableConfig := dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig{
		LogicalTableName:          ddbTableName,
		PartitionKeyName:          partitionKeyName,
		SortKeyName:               &sortKeyName,
		AttributeActionsOnEncrypt: attributeActions,
		Keyring:                   kmsKeyring,
		AllowedUnsignedAttributes: unsignedAttributes,
		PlaintextOverride:         &plaintextOverride,
	}

	tableConfigsMap := make(map[string]dbesdkdynamodbencryptiontypes.DynamoDbTableEncryptionConfig)
	tableConfigsMap[ddbTableName] = tableConfig

	listOfTableConfigs := dbesdkdynamodbencryptiontypes.DynamoDbTablesEncryptionConfig{
		TableEncryptionConfigs: tableConfigsMap,
	}

	return listOfTableConfigs
}
