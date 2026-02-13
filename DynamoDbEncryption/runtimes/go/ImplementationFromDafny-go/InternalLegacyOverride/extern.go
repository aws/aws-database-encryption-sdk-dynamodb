package InternalLegacyOverride

import (
	"github.com/aws/aws-cryptographic-material-providers-library/releases/go/smithy-dafny-standard-library/Wrappers"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/AwsCryptographyDbEncryptionSdkDynamoDbTypes"
	"github.com/aws/aws-database-encryption-sdk-dynamodb/releases/go/dynamodb-esdk/awscryptographydbencryptionsdkdynamodbitemencryptorsmithygeneratedtypes"
)

var policy = AwsCryptographyDbEncryptionSdkDynamoDbTypes.Companion_LegacyPolicy_.Create_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT_()

func (InternalLegacyOverride) Policy() AwsCryptographyDbEncryptionSdkDynamoDbTypes.LegacyPolicy {
	return policy
}

func (CompanionStruct_InternalLegacyOverride_) Build(config interface{}) Wrappers.Result {
	// Go does not support the Legacy DDB-EC
	if policy.Is_FORBID__LEGACY__ENCRYPT__FORBID__LEGACY__DECRYPT() {
		return Wrappers.Companion_Result_.Create_Success_(Wrappers.Companion_Option_.Create_None_())
	}
	err := &awscryptographydbencryptionsdkdynamodbitemencryptorsmithygeneratedtypes.DynamoDbItemEncryptorException{
		Message: "Legacy configuration unsupported.",
	}
	return Wrappers.Companion_Result_.Create_Failure_(err)
}

func (InternalLegacyOverride) EncryptItem(config interface{}) Wrappers.Result {
	// Go does not support the Legacy DDB-EC. So, this function will not be reached.
	err := &awscryptographydbencryptionsdkdynamodbitemencryptorsmithygeneratedtypes.DynamoDbItemEncryptorException{
		Message: "Legacy configuration unsupported.",
	}
	return Wrappers.Companion_Result_.Create_Failure_(err)
}

func (InternalLegacyOverride) DecryptItem(config interface{}) Wrappers.Result {
	// Go does not support the Legacy DDB-EC. So, this function will not be reached.
	err := &awscryptographydbencryptionsdkdynamodbitemencryptorsmithygeneratedtypes.DynamoDbItemEncryptorException{
		Message: "Legacy configuration unsupported.",
	}
	return Wrappers.Companion_Result_.Create_Failure_(err)
}

func (InternalLegacyOverride) IsLegacyInput(config interface{}) bool {
	// Go does not support the Legacy DDB-EC
	return false
}
