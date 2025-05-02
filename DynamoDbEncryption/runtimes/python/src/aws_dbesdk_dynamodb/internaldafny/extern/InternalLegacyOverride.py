from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes import (
    DynamoDbItemEncryptorConfig,
    DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig,
)
import smithy_dafny_standard_library.internaldafny.generated.Wrappers as Wrappers
import _dafny

import aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride

try:
    from dynamodb_encryption_sdk.encrypted.client import EncryptedClient
    from dynamodb_encryption_sdk.structures import EncryptionContext

    _HAS_LEGACY_DDBEC = True
except ImportError:
    _HAS_LEGACY_DDBEC = False


class InternalLegacyOverride(aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride.InternalLegacyOverride):
    @staticmethod
    def Build(config: DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig):
        if config.legacyOverride.is_None:
            return InternalLegacyOverride.CreateBuildSuccess(InternalLegacyOverride.CreateInternalLegacyOverrideNone())

        legacy_override = config.legacyOverride.value

        maybe_encryptor = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_LegacyDynamoDbEncryptorReference(
            legacy_override.encryptor
        )

        # Precondition: The encryptor MUST be a DynamoDBEncryptor
        if not _HAS_LEGACY_DDBEC:
            return InternalLegacyOverride.CreateBuildFailure(
                InternalLegacyOverride.CreateError("Could not find aws-dynamodb-encryption-python installation")
            )
        if not isinstance(maybe_encryptor, EncryptedClient):
            return InternalLegacyOverride.CreateBuildFailure(
                InternalLegacyOverride.CreateError("Legacy encryptor is not supported")
            )

        # Preconditions: MUST be able to create valid encryption context
        maybe_encryption_context = InternalLegacyOverride.legacyEncryptionContext(config)
        if maybe_encryption_context.is_Failure:
            return InternalLegacyOverride.CreateBuildFailure(maybe_encryption_context.error())

        # Precondition: All actions MUST be supported types
        maybe_actions = InternalLegacyOverride.legacyActions(legacy_override.attributeActionsOnEncrypt)
        if maybe_actions.is_Failure:
            return InternalLegacyOverride.CreateBuildFailure(maybe_actions.error())

    def legacyEncryptionContext(config: DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig):
        try:
            encryption_context_kwargs = {
                "table_name": _dafny.string_of(config.logicalTableName),
                "hash_key_name": _dafny.string_of(config.partitionKeyName),
            }
            if config.sortKeyName.is_Some:
                encryption_context_kwargs["sort_key_name"] = _dafny.string_of(config.sortKeyName.value)
            encryption_context = EncryptionContext(**encryption_context_kwargs)
            return InternalLegacyOverride.CreateBuildSuccess(encryption_context)
        except Exception as e:
            return InternalLegacyOverride.CreateBuildFailure(InternalLegacyOverride.CreateError(str(e)))

    @staticmethod
    def EncryptItem(input):
        return Wrappers.Result_Failure("TODO-legacy-Encryptitem")

    @staticmethod
    def DecryptItem(input):
        return Wrappers.Result_Failure("TODO-legacy-Decryptitem")

    @staticmethod
    def IsLegacyinput(input):
        return False


aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride.InternalLegacyOverride = InternalLegacyOverride
