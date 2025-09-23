# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
from _dafny import Seq

import aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes import (
    DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig,
    Error_DynamoDbItemEncryptorException,
    Error_Opaque,
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
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models import (
    EncryptItemInput,
    EncryptItemOutput,
    DecryptItemOutput,
    DecryptItemInput,
)

try:
    from dynamodb_encryption_sdk.encrypted.client import EncryptedClient
    from dynamodb_encryption_sdk.encrypted.table import EncryptedTable
    from dynamodb_encryption_sdk.encrypted.resource import EncryptedResource
    from dynamodb_encryption_sdk.encrypted.client import EncryptedPaginator
    from dynamodb_encryption_sdk.encrypted.item import encrypt_dynamodb_item, decrypt_dynamodb_item
    from dynamodb_encryption_sdk.structures import EncryptionContext, AttributeActions
    from dynamodb_encryption_sdk.identifiers import CryptoAction
    from dynamodb_encryption_sdk.encrypted import CryptoConfig
    from dynamodb_encryption_sdk.internal.identifiers import ReservedAttributes

    _HAS_LEGACY_DDBEC = True
except ImportError:
    _HAS_LEGACY_DDBEC = False


class InternalLegacyOverride(aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride.InternalLegacyOverride):
    def __init__(self):
        super().__init__()
        self.crypto_config = None
        self.policy = None

    @staticmethod
    def Build(config: DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig):
        # Check for early return (Postcondition): If there is no legacyOverride there is nothing to do.
        if config.legacyOverride.is_None:
            return InternalLegacyOverride.CreateBuildSuccess(InternalLegacyOverride.CreateInternalLegacyOverrideNone())

        legacy_override = config.legacyOverride.value

        # Precondition: The encryptor MUST be a DynamoDBEncryptor
        if not _HAS_LEGACY_DDBEC:
            return InternalLegacyOverride.CreateBuildFailure(
                InternalLegacyOverride.CreateError("Could not find aws-dynamodb-encryption-python installation")
            )

        # Precondition: The encryptor MUST be one of the supported legacy types
        if not (
            isinstance(legacy_override.encryptor, EncryptedClient)
            or isinstance(legacy_override.encryptor, EncryptedTable)
            or isinstance(legacy_override.encryptor, EncryptedResource)
        ):
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
        legacy_instance.policy = legacy_override.policy
        legacy_instance.crypto_config = CryptoConfig(
            materials_provider=legacy_override.encryptor._materials_provider,
            encryption_context=maybe_encryption_context.value,
            attribute_actions=maybe_actions.value,
        )
        return InternalLegacyOverride.CreateBuildSuccess(
            InternalLegacyOverride.CreateInternalLegacyOverrideSome(legacy_instance)
        )

    @staticmethod
    def legacyEncryptionContext(config: DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig):
        """Create the legacy encryption context from the config."""
        try:
            # Convert Dafny types to Python strings for the encryption context
            table_name = InternalLegacyOverride.DafnyStringToNativeString(config.logicalTableName)
            partition_key_name = InternalLegacyOverride.DafnyStringToNativeString(config.partitionKeyName)
            sort_key_name = (
                InternalLegacyOverride.DafnyStringToNativeString(config.sortKeyName.value)
                if config.sortKeyName.is_Some
                else None
            )

            # Create the legacy encryption context with the extracted values
            encryption_context = EncryptionContext(
                table_name=table_name,
                partition_key_name=partition_key_name,
                sort_key_name=sort_key_name,
            )

            return InternalLegacyOverride.CreateBuildSuccess(encryption_context)
        except Exception as ex:
            return InternalLegacyOverride.CreateBuildFailure(Error_Opaque(ex))

    @staticmethod
    def legacyActions(attribute_actions_on_encrypt):
        """Create the legacy attribute actions from the config."""
        try:
            # Create a new AttributeActions with default ENCRYPT_AND_SIGN
            # Default Action to take if no specific action is defined in ``attribute_actions``
            # https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/DDBEC-legacy-concepts.html#legacy-attribute-actions
            legacy_actions = AttributeActions(default_action=CryptoAction.ENCRYPT_AND_SIGN)

            # Map the action from the config to legacy actions
            attribute_actions = {}
            for key, action in attribute_actions_on_encrypt.items:
                key_str = InternalLegacyOverride.DafnyStringToNativeString(key)

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
        except Exception as ex:
            return InternalLegacyOverride.CreateBuildFailure(Error_Opaque(ex))

    def EncryptItem(self, input: EncryptItemInput_EncryptItemInput):
        """Encrypt an item using the legacy DynamoDB encryptor.

        :param input: EncryptItemInput containing the plaintext item to encrypt
        :returns Result containing the encrypted item or an error
        """
        try:
            # Precondition: Policy MUST allow the caller to encrypt.
            if not self.policy.is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT:
                return self.CreateEncryptItemFailure(
                    InternalLegacyOverride.CreateError("Legacy policy does not support encrypt")
                )

            # Get the Native Plaintext Item
            native_input = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemInput(
                input
            )

            # Encrypt the item using the instance attributes
            encrypted_item = encrypt_dynamodb_item(
                item=native_input.plaintext_item,
                crypto_config=self.crypto_config.with_item(native_input.plaintext_item),
            )

            # Return the encrypted item
            # The legacy encryption method returns items in the format that Dafny expects,
            # so no additional conversion is needed here
            native_output = EncryptItemOutput(encrypted_item=encrypted_item, parsed_header=None)
            dafny_output = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemOutput(
                native_output
            )
            return self.CreateEncryptItemSuccess(dafny_output)

        except Exception as ex:
            return self.CreateEncryptItemFailure(InternalLegacyOverride.CreateError(Error_Opaque(ex)))

    def DecryptItem(self, input: DecryptItemInput_DecryptItemInput):
        """Decrypt an item using the legacy DynamoDB encryptor.

        :param input: DecryptItemInput containing the encrypted item to decrypt
        :returns Result containing the decrypted item or an error
        """
        try:
            # Precondition: Policy MUST allow the caller to decrypt.
            # = specification/dynamodb-encryption-client/decrypt-item.md#behavior
            ## If a [Legacy Policy](./ddb-table-encryption-config.md#legacy-policy) of
            ## `FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT` is configured,
            ## and the input item [is an item written in the legacy format](#determining-legacy-items),
            ## this operation MUST fail.
            if not (
                self.policy.is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT
                or self.policy.is_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT
            ):
                return self.CreateDecryptItemFailure(
                    InternalLegacyOverride.CreateError("Legacy policy does not support decrypt")
                )

            # Get the Native DecryptItemInput
            native_input: DecryptItemInput = (
                aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemInput(
                    input
                )
            )
            # Decrypt the item using the instance attributes
            decrypted_item = decrypt_dynamodb_item(
                item=native_input.encrypted_item,
                crypto_config=self.crypto_config.with_item(native_input.encrypted_item),
            )

            native_output = DecryptItemOutput(plaintext_item=decrypted_item, parsed_header=None)
            dafny_output = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemOutput(
                native_output
            )
            return self.CreateDecryptItemSuccess(dafny_output)
        except Exception as ex:
            return self.CreateDecryptItemFailure(InternalLegacyOverride.CreateError(Error_Opaque(ex)))

    def IsLegacyInput(self, input: DecryptItemInput_DecryptItemInput):
        """
        Determine if the input is from a legacy client.

        :param input: The decrypt item input to check
        :returns Boolean indicating if the input is from a legacy client
        """
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
            "*amzn-ddb-map-desc*" in native_input.encrypted_item and "*amzn-ddb-map-sig*" in native_input.encrypted_item
        )

    @staticmethod
    def DafnyStringToNativeString(dafny_input):
        return b"".join(ord(c).to_bytes(2, "big") for c in dafny_input).decode("utf-16-be")

    @staticmethod
    def NativeStringToDafnyString(native_input):
        return Seq(
            "".join([chr(int.from_bytes(pair, "big")) for pair in zip(*[iter(native_input.encode("utf-16-be"))] * 2)])
        )

    @staticmethod
    def CreateError(message):
        """Create an Error with the given message."""
        return Error_DynamoDbItemEncryptorException(InternalLegacyOverride.NativeStringToDafnyString(message))


aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride.InternalLegacyOverride = InternalLegacyOverride
