# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes import (
    DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig,
    Error_DynamoDbItemEncryptorException,
)
import smithy_dafny_standard_library.internaldafny.generated.Wrappers as Wrappers
import _dafny

import aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride

try:
    from dynamodb_encryption_sdk.encrypted.client import EncryptedClient
    from dynamodb_encryption_sdk.structures import EncryptionContext, AttributeActions
    from dynamodb_encryption_sdk.identifiers import CryptoAction

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

        print("Log Success till legacy override")
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

        # Create and return the legacy override instance
        legacy_instance = InternalLegacyOverride()
        legacy_instance.encryptor = maybe_encryptor
        legacy_instance.encryption_context = maybe_encryption_context.value()
        legacy_instance.attribute_actions = maybe_actions.value()

        return InternalLegacyOverride.CreateBuildSuccess(
            InternalLegacyOverride.CreateInternalLegacyOverrideSome(legacy_instance)
        )

    @staticmethod
    def legacyEncryptionContext(config: DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig):
        try:
            encryption_context_kwargs = {
                "table_name": _dafny.string_of(config.logicalTableName),
                "partition_key_name": _dafny.string_of(config.partitionKeyName),
            }
            if config.sortKeyName.is_Some:
                encryption_context_kwargs["sort_key_name"] = _dafny.string_of(config.sortKeyName.value)
            encryption_context = EncryptionContext(**encryption_context_kwargs)
            return InternalLegacyOverride.CreateBuildSuccess(encryption_context)
        except Exception as e:
            return InternalLegacyOverride.CreateBuildFailure(InternalLegacyOverride.CreateError(str(e)))

    @staticmethod
    def legacyActions(attribute_actions_on_encrypt):
        try:
            # Create a new AttributeActions with default DO_NOTHING
            legacy_actions = AttributeActions(default_action=CryptoAction.DO_NOTHING)

            # Map the action from the config to legacy actions
            attribute_actions = {}
            for key, action in attribute_actions_on_encrypt.items():
                # Convert the string key to Python string
                key_str = _dafny.string_of(key)

                # Map the action type to the appropriate CryptoAction
                if action == "ENCRYPT_AND_SIGN":
                    attribute_actions[key_str] = CryptoAction.ENCRYPT_AND_SIGN
                elif action == "SIGN_ONLY":
                    attribute_actions[key_str] = CryptoAction.SIGN_ONLY
                elif action == "DO_NOTHING":
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

    @staticmethod
    def EncryptItem(input):
        try:
            # Extract components from the input
            legacy_override = input.legacyOverride
            item = input.plaintextItem

            if not isinstance(legacy_override.encryptor, EncryptedClient):
                return Wrappers.Result_Failure("Legacy encryptor is not an instance of EncryptedClient")

            # Convert item to Python dictionary for legacy client
            python_item = {}
            for key, value in item.items():
                python_item[_dafny.string_of(key)] = value

            # Set up the encryption context attributes for the item
            if hasattr(legacy_override.encryption_context, "attributes"):
                legacy_override.encryption_context.attributes = python_item

            # Use the legacy EncryptedClient to encrypt the item
            # The client's _encrypt_item method is used internally by put_item
            encrypted_item = legacy_override.encryptor._encrypt_item(
                item=python_item,
                crypto_config=legacy_override.encryptor._item_crypto_config(
                    TableName=legacy_override.encryption_context.table_name,
                    attribute_actions=legacy_override.attribute_actions,
                ),
            )

            # Convert the encrypted item back to the format expected by Dafny
            result_item = {}
            for key, value in encrypted_item.items():
                result_item[key] = value

            return Wrappers.Result_Success(result_item)
        except Exception as e:
            return Wrappers.Result_Failure(str(e))

    @staticmethod
    def DecryptItem(input):
        try:
            # Extract components from the input
            legacy_override = input.legacyOverride
            item = input.encryptedItem

            if not isinstance(legacy_override.encryptor, EncryptedClient):
                return Wrappers.Result_Failure("Legacy encryptor is not an instance of EncryptedClient")

            # Convert item to Python dictionary for legacy client
            python_item = {}
            for key, value in item.items():
                python_item[_dafny.string_of(key)] = value

            # Use the legacy EncryptedClient to decrypt the item
            # The client's _decrypt_item method is used internally by get_item
            decrypted_item = legacy_override.encryptor._decrypt_item(
                item=python_item,
                crypto_config=legacy_override.encryptor._item_crypto_config(
                    TableName=legacy_override.encryption_context.table_name,
                    attribute_actions=legacy_override.attribute_actions,
                ),
            )

            # Convert the decrypted item back to the format expected by Dafny
            result_item = {}
            for key, value in decrypted_item.items():
                result_item[key] = value

            return Wrappers.Result_Success(result_item)
        except Exception as e:
            return Wrappers.Result_Failure(str(e))

    @staticmethod
    def IsLegacyinput(input):
        """Determine if the input is from a legacy client.

        This is used to decide whether to use legacy or new decryption methods.
        We detect legacy encrypted items by looking for specific attributes or
        structure patterns that are unique to the legacy encryption client.
        """
        try:
            if not _HAS_LEGACY_DDBEC:
                return False

            item = input.encryptedItem

            # Look for characteristic attributes that indicate legacy encryption
            # For the old DynamoDB Encryption Client, these might include:
            # 1. The presence of the *amzn-ddb-map-sig* attribute
            # 2. The presence of the *amzn-ddb-map-desc* attribute

            legacy_markers = ["*amzn-ddb-map-sig*", "*amzn-ddb-map-desc*"]

            for marker in legacy_markers:
                if marker in item:
                    return True

            return False
        except:
            # If we encounter any error during detection, default to not using legacy
            return False

    @staticmethod
    def CreateError(message):
        """Create an Error with the given message."""
        return Error_DynamoDbItemEncryptorException(message)



aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride.InternalLegacyOverride = InternalLegacyOverride
