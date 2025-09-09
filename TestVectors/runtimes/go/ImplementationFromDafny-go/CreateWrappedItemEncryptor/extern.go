package CreateWrappedItemEncryptor

import (
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/WrappedAwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorService"
)

func CreateWrappedItemEncryptor(config AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes.DynamoDbItemEncryptorConfig) Wrappers.Result {
	return WrappedAwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorService.WrappedDynamoDbItemEncryptor(config)
}
