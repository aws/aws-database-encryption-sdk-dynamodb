# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes import (
    DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig,
    Error_DynamoDbItemEncryptorException,
    DecryptItemInput_DecryptItemInput,
    EncryptItemInput_EncryptItemInput,
)
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes import (
    CryptoAction_ENCRYPT__AND__SIGN,
    CryptoAction_SIGN__ONLY,
    CryptoAction_DO__NOTHING,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.references import (
    ILegacyDynamoDbEncryptor,
)
import smithy_dafny_standard_library.internaldafny.generated.Wrappers as Wrappers
import _dafny

import aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models import (
    EncryptItemInput,
    EncryptItemOutput,
    DecryptItemOutput,
    DecryptItemInput,
)


try:
    from dynamodb_encryption_sdk.encrypted.client import EncryptedClient
    from dynamodb_encryption_sdk.structures import EncryptionContext, AttributeActions
    from dynamodb_encryption_sdk.identifiers import CryptoAction
    from dynamodb_encryption_sdk.encrypted import CryptoConfig
    from dynamodb_encryption_sdk.internal.identifiers import ReservedAttributes

    _HAS_LEGACY_DDBEC = True
except ImportError:
    _HAS_LEGACY_DDBEC = False


class InternalLegacyOverride(aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride.InternalLegacyOverride):
    @staticmethod
    def Build(config: DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig):
        if config.legacyOverride.is_None:
            return InternalLegacyOverride.CreateBuildSuccess(InternalLegacyOverride.CreateInternalLegacyOverrideNone())

        legacy_override = config.legacyOverride.value

        # Precondition: The encryptor MUST be a DynamoDBEncryptor
        if not _HAS_LEGACY_DDBEC:
            return InternalLegacyOverride.CreateBuildFailure(
                InternalLegacyOverride.CreateError("Could not find aws-dynamodb-encryption-python installation")
            )
        if not isinstance(legacy_override.encryptor, EncryptedClient):
            return InternalLegacyOverride.CreateBuildFailure(
                InternalLegacyOverride.CreateError("Legacy encryptor is not supported")
            )

        # Preconditions: MUST be able to create valid encryption context
        maybe_encryption_context = InternalLegacyOverride.legacyEncryptionContext(config)
        if maybe_encryption_context.is_Failure:
            return maybe_encryption_context

        # Precondition: All actions MUST be supported types
        maybe_actions = InternalLegacyOverride.legacyActions(legacy_override.attributeActionsOnEncrypt)
        if maybe_actions.is_Failure:
            return maybe_actions

        # Create and return the legacy override instance
        legacy_instance = InternalLegacyOverride()
        legacy_instance.encryptor = legacy_override.encryptor
        legacy_instance.policy = legacy_override.policy
        legacy_instance.crypto_config = CryptoConfig(
            materials_provider=legacy_override.encryptor._materials_provider,
            encryption_context=maybe_encryption_context.value,
            attribute_actions=maybe_actions.value,
        )
        return InternalLegacyOverride.CreateBuildSuccess(
            InternalLegacyOverride.CreateInternalLegacyOverrideSome(legacy_instance)
        )

    def __init__(self):
        super().__init__()
        self.encryptor = None
        self.crypto_config = None
        self.policy = None

    @staticmethod
    def legacyEncryptionContext(config: DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig):
        """Create the legacy encryption context from the config."""
        try:
            # Convert Dafny types to Python strings for the encryption context
            table_name = _dafny.string_of(config.logicalTableName)
            partition_key_name = _dafny.string_of(config.partitionKeyName)
            sort_key_name = _dafny.string_of(config.sortKeyName.value) if config.sortKeyName.is_Some else None

            # Create the legacy encryption context with the extracted values
            encryption_context = EncryptionContext(
                table_name=table_name,
                partition_key_name=partition_key_name,
                sort_key_name=sort_key_name,
            )

            return InternalLegacyOverride.CreateBuildSuccess(encryption_context)
        except Exception as e:
            # Return a failure with the error message if any exception occurs
            return InternalLegacyOverride.CreateBuildFailure(InternalLegacyOverride.CreateError(str(e)))

    @staticmethod
    def legacyActions(attribute_actions_on_encrypt):
        """Create the legacy attribute actions from the config."""
        try:
            # Create a new AttributeActions with default ENCRYPT_AND_SIGN
            legacy_actions = AttributeActions(default_action=CryptoAction.ENCRYPT_AND_SIGN)

            # Map the action from the config to legacy actions
            attribute_actions = {}
            for key, action in attribute_actions_on_encrypt.items:
                # Convert the string key to Python string
                key_str = _dafny.string_of(key)

                # Map the action type to the appropriate CryptoAction
                if action == CryptoAction_ENCRYPT__AND__SIGN():
                    attribute_actions[key_str] = CryptoAction.ENCRYPT_AND_SIGN
                elif action == CryptoAction_SIGN__ONLY():
                    attribute_actions[key_str] = CryptoAction.SIGN_ONLY
                elif action == CryptoAction_DO__NOTHING():
                    attribute_actions[key_str] = CryptoAction.DO_NOTHING
                else:
                    return InternalLegacyOverride.CreateBuildFailure(
                        InternalLegacyOverride.CreateError(f"Unknown action type: {action}")
                    )

            # Update the attribute_actions dictionary
            legacy_actions.attribute_actions = attribute_actions
            return InternalLegacyOverride.CreateBuildSuccess(legacy_actions)
        except Exception as e:
            return InternalLegacyOverride.CreateBuildFailure(InternalLegacyOverride.CreateError(str(e)))

    def EncryptItem(self, input: EncryptItemInput_EncryptItemInput):
        """Encrypt an item using the legacy DynamoDB encryptor.

        Args:
            input: EncryptItemInput containing the plaintext item to encrypt

        Returns:
            Result containing the encrypted item or an error
        """
        try:
            # Check policy
            if not self.policy.is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT:
                return Wrappers.Result_Failure(
                    InternalLegacyOverride.CreateError("Legacy policy does not support encrypt")
                )

            # Get the Native Plaintext Item
            native_input = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemInput(
                input
            )

            # Use the encryptor to encrypt the item using the instance attributes
            encrypted_item = self.encryptor._encrypt_item(
                item=native_input.plaintext_item,
                crypto_config=self.crypto_config.with_item(native_input.plaintext_item),
            )

            # Return the encrypted item
            # The legacy encryption client returns items in the format that Dafny expects,
            # so no additional conversion is needed here
            native_output = EncryptItemOutput(encrypted_item=encrypted_item, parsed_header=None)
            dafny_output = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemOutput(
                native_output
            )
            return Wrappers.Result_Success(dafny_output)

        except Exception as e:
            # Return an appropriate error result with the exception details
            return Wrappers.Result_Failure(InternalLegacyOverride.CreateError(f"Error during encryption: {str(e)}"))

    def DecryptItem(self, input: DecryptItemInput_DecryptItemInput):
        """Decrypt an item using the legacy DynamoDB encryptor.

        Args:
            input: DecryptItemInput containing the encrypted item to decrypt

        Returns:
            Result containing the decrypted item or an error
        """
        try:
            # Check policy
            if not (
                self.policy.is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT
                or self.policy.is_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT
            ):
                return Wrappers.Result_Failure(
                    InternalLegacyOverride.CreateError("Legacy policy does not support decrypt")
                )

            # Get the Native DecryptItemInput
            native_input: DecryptItemInput = (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemInput(
                    input
                )
            )
            # Use the encryptor to decrypt the item using the instance attributes
            decrypted_item = self.encryptor._decrypt_item(
                item=native_input.encrypted_item,
                crypto_config=self.crypto_config.with_item(native_input.encrypted_item),
            )

            native_output = DecryptItemOutput(plaintext_item=decrypted_item, parsed_header=None)
            dafny_output = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemOutput(
                native_output
            )
            return Wrappers.Result_Success(dafny_output)
        except Exception as e:
            # Return an appropriate error result with the exception details
            return Wrappers.Result_Failure(InternalLegacyOverride.CreateError(f"Error during decryption: {str(e)}"))

    def IsLegacyInput(self, input: DecryptItemInput_DecryptItemInput):
        """
        Determine if the input is from a legacy client.

        Args:
            input: The decrypt item input to check

        Returns:
            Boolean indicating if the input is from a legacy client
        """
        try:
            if not _HAS_LEGACY_DDBEC:
                return False

            if not input.is_DecryptItemInput:
                return False

            # Get the Native DecryptItemInput
            native_input: DecryptItemInput = (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemInput(
                    input
                )
            )
            # = specification/dynamodb-encryption-client/decrypt-item.md#determining-legacy-items
            ## An item MUST be determined to be encrypted under the legacy format if it contains
            ## attributes for the material description and the signature.
            return (
                "*amzn-ddb-map-desc*" in native_input.encrypted_item
                and "*amzn-ddb-map-sig*" in native_input.encrypted_item
            )

        except Exception as e:
            # If we encounter any error during detection, default to not using legacy
            return Wrappers.Result_Failure(InternalLegacyOverride.CreateError(f"Error in IsLegacyInput: {e}"))

    @staticmethod
    def CreateError(message):
        """Create an Error with the given message."""
        return Error_DynamoDbItemEncryptorException(message)


aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride.InternalLegacyOverride = InternalLegacyOverride
