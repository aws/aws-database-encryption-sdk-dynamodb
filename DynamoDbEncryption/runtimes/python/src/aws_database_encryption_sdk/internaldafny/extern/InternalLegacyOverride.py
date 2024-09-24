from aws_database_encryption_sdk.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes import (
    DynamoDbItemEncryptorConfig,
    DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig,
)
import smithy_dafny_standard_library.internaldafny.generated.Wrappers as Wrappers

import aws_database_encryption_sdk.internaldafny.generated.InternalLegacyOverride

class InternalLegacyOverride(aws_database_encryption_sdk.internaldafny.generated.InternalLegacyOverride.InternalLegacyOverride):
    @staticmethod
    def Build(config: DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig):
        if config.legacyOverride.is_None:
            return Wrappers.Result_Success(
                Wrappers.Option_None()
            )
    
        return Wrappers.Result_Failure(
            "TODO-legacy-Build"
        )

    @staticmethod
    def EncryptItem(input):
        return Wrappers.Result_Failure(
            "TODO-legacy-Encryptitem"
        )
    
    @staticmethod
    def DecryptItem(input):
        return Wrappers.Result_Failure(
            "TODO-legacy-Decryptitem"
        )
    
    @staticmethod
    def IsLegacyinput(input):
        return False
    
aws_database_encryption_sdk.internaldafny.generated.InternalLegacyOverride.InternalLegacyOverride = InternalLegacyOverride
