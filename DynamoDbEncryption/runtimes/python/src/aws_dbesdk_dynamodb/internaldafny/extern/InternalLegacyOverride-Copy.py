# # Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# # SPDX-License-Identifier: Apache-2.0
#
# from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes import (
#     DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig,
# )
# import smithy_dafny_standard_library.internaldafny.generated.Wrappers as Wrappers
# import _dafny
#
# import aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride
#
# try:
#     from dynamodb_encryption_sdk.encrypted.client import EncryptedClient
#     from dynamodb_encryption_sdk.structures import EncryptionContext, AttributeActions
#     from dynamodb_encryption_sdk.identifiers import CryptoAction
#     _HAS_LEGACY_DDBEC = True
# except ImportError:
#     _HAS_LEGACY_DDBEC = False
#
#
# class InternalLegacyOverride(aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride.InternalLegacyOverride):
#     def __init__(self):
#         # Instance variables to match the Java implementation
#         self.encryptor = None
#         self.attribute_actions = None
#         self.encryption_context = None
#         self._policy = None
#         self.material_description_field_name = None
#         self.signature_field_name = None
#
#     def policy(self):
#         """Return the policy configured for this legacy override."""
#         return self._policy
#
#     @staticmethod
#     def Build(config: DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig):
#         # Check for early return: If there is no legacyOverride there is nothing to do.
#         if config.legacyOverride.is_None:
#             return InternalLegacyOverride.CreateBuildSuccess(InternalLegacyOverride.CreateInternalLegacyOverrideNone())
#
#         legacy_override = config.legacyOverride.value
#
#         maybe_encryptor = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_LegacyDynamoDbEncryptorReference(
#             legacy_override.encryptor
#         )
#
#         # Precondition: The encryptor MUST be a DynamoDBEncryptor
#         if not _HAS_LEGACY_DDBEC:
#             return InternalLegacyOverride.CreateBuildFailure(
#                 InternalLegacyOverride.CreateError("Could not find aws-dynamodb-encryption-python installation")
#             )
#         if not isinstance(maybe_encryptor, EncryptedClient):
#             return InternalLegacyOverride.CreateBuildFailure(
#                 InternalLegacyOverride.CreateError("Legacy encryptor is not supported")
#             )
#
#         # Preconditions: MUST be able to create valid encryption context
#         maybe_encryption_context = InternalLegacyOverride.legacyEncryptionContext(config)
#         if maybe_encryption_context.is_Failure:
#             return InternalLegacyOverride.CreateBuildFailure(maybe_encryption_context.error())
#
#         # Precondition: All actions MUST be supported types
#         maybe_actions = InternalLegacyOverride.legacyActions(legacy_override.attributeActionsOnEncrypt)
#         if maybe_actions.is_Failure:
#             return InternalLegacyOverride.CreateBuildFailure(maybe_actions.error())
#
#         # Create and return the legacy override instance
#         legacy_instance = InternalLegacyOverride()
#         legacy_instance.encryptor = maybe_encryptor
#         legacy_instance.encryption_context = maybe_encryption_context.value()
#         legacy_instance.attribute_actions = maybe_actions.value()
#         legacy_instance._policy = legacy_override.policy
#
#         # It is possible that these values have been customized by the customer.
#         legacy_instance.material_description_field_name = _dafny.DafnySequence.of(list(
#             maybe_encryptor.material_description_field_name
#         ))
#         legacy_instance.signature_field_name = _dafny.DafnySequence.of(list(
#             maybe_encryptor.signature_field_name
#         ))
#
#         return InternalLegacyOverride.CreateBuildSuccess(
#             InternalLegacyOverride.CreateInternalLegacyOverrideSome(legacy_instance)
#         )
#
#     @staticmethod
#     def legacyEncryptionContext(config: DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig):
#         try:
#             encryption_context_kwargs = {
#                 "table_name": _dafny.string_of(config.logicalTableName),
#                 "partition_key_name": _dafny.string_of(config.partitionKeyName),
#             }
#             if config.sortKeyName.is_Some:
#                 encryption_context_kwargs["sort_key_name"] = _dafny.string_of(config.sortKeyName.value)
#             encryption_context = EncryptionContext(**encryption_context_kwargs)
#             return InternalLegacyOverride.CreateBuildSuccess(encryption_context)
#         except Exception as e:
#             return InternalLegacyOverride.CreateBuildFailure(InternalLegacyOverride.CreateError(str(e)))
#
#     @staticmethod
#     def legacyActions(attribute_actions_on_encrypt):
#         try:
#             # Create a new AttributeActions with default DO_NOTHING
#             legacy_actions = AttributeActions(default_action=CryptoAction.DO_NOTHING)
#
#             # Map the action from the config to legacy actions
#             attribute_actions = {}
#             for key, action in attribute_actions_on_encrypt.items():
#                 # Convert the string key to Python string
#                 key_str = _dafny.string_of(key)
#
#                 # Map the action type to the appropriate CryptoAction
#                 if action == "ENCRYPT_AND_SIGN":
#                     attribute_actions[key_str] = CryptoAction.ENCRYPT_AND_SIGN
#                 elif action == "SIGN_ONLY":
#                     attribute_actions[key_str] = CryptoAction.SIGN_ONLY
#                 elif action == "DO_NOTHING":
#                     attribute_actions[key_str] = CryptoAction.DO_NOTHING
#                 else:
#                     return InternalLegacyOverride.CreateBuildFailure(
#                         InternalLegacyOverride.CreateError(f"Unknown action type: {action}")
#                     )
#
#             # Update the attribute_actions dictionary
#             legacy_actions.attribute_actions = attribute_actions
#
#             return InternalLegacyOverride.CreateBuildSuccess(legacy_actions)
#         except Exception as e:
#             return InternalLegacyOverride.CreateBuildFailure(InternalLegacyOverride.CreateError(str(e)))
#
#     @staticmethod
#     def createError(message):
#         """Create an Error with the given message."""
#         return InternalLegacyOverride.CreateError(message)
#
#     def EncryptItem(self, input):
#         try:
#             # Precondition: Policy MUST allow the caller to encrypt.
#             if not self._policy.is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT():
#                 return Wrappers.Result_Failure("Legacy Policy does not support encrypt.")
#
#             # Extract components from the input
#             item = input.plaintextItem
#
#             if not isinstance(self.encryptor, EncryptedClient):
#                 return Wrappers.Result_Failure("Legacy encryptor is not an instance of EncryptedClient")
#
#             # Convert item to Python dictionary for legacy client
#             python_item = {}
#             for key, value in item.items():
#                 python_item[_dafny.string_of(key)] = value
#
#             # Set up the encryption context attributes for the item
#             if hasattr(self.encryption_context, 'attributes'):
#                 self.encryption_context.attributes = python_item
#
#             # Use the legacy EncryptedClient to encrypt the item
#             # The client's _encrypt_item method is used internally by put_item
#             encrypted_item = self.encryptor._encrypt_item(
#                 item=python_item,
#                 crypto_config=self.encryptor._item_crypto_config(
#                     TableName=self.encryption_context.table_name,
#                     attribute_actions=self.attribute_actions
#                 )
#             )
#
#             # Convert the encrypted item back to the format expected by Dafny
#             result_item = {}
#             for key, value in encrypted_item.items():
#                 result_item[key] = value
#
#             return Wrappers.Result_Success(result_item)
#         except Exception as e:
#             return Wrappers.Result_Failure(str(e))
#
#     def DecryptItem(self, input):
#         try:
#             # Precondition: Policy MUST allow the caller to decrypt.
#             if not (self._policy.is_FORCE__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT() or
#                     self._policy.is_FORBID__LEGACY__ENCRYPT__ALLOW__LEGACY__DECRYPT()):
#                 return Wrappers.Result_Failure("Legacy Policy does not support decrypt.")
#
#             # Extract components from the input
#             item = input.encryptedItem
#
#             if not isinstance(self.encryptor, EncryptedClient):
#                 return Wrappers.Result_Failure("Legacy encryptor is not an instance of EncryptedClient")
#
#             # Convert item to Python dictionary for legacy client
#             python_item = {}
#             for key, value in item.items():
#                 python_item[_dafny.string_of(key)] = value
#
#             # Use the legacy EncryptedClient to decrypt the item
#             # The client's _decrypt_item method is used internally by get_item
#             decrypted_item = self.encryptor._decrypt_item(
#                 item=python_item,
#                 crypto_config=self.encryptor._item_crypto_config(
#                     TableName=self.encryption_context.table_name,
#                     attribute_actions=self.attribute_actions
#                 )
#             )
#
#             # Convert the decrypted item back to the format expected by Dafny
#             result_item = {}
#             for key, value in decrypted_item.items():
#                 result_item[key] = value
#
#             return Wrappers.Result_Success(result_item)
#         except Exception as e:
#             return Wrappers.Result_Failure(str(e))
#
#     def IsLegacyInput(self, input):
#         """Determine if the input is from a legacy client.
#
#         This is used to decide whether to use legacy or new decryption methods.
#         We detect legacy encrypted items by looking for specific attributes or
#         structure patterns that are unique to the legacy encryption client.
#         """
#         try:
#             if not _HAS_LEGACY_DDBEC:
#                 return False
#
#             item = input.encryptedItem
#
#             # Check if the item contains material description and signature fields
#             # from the legacy encryptor
#             return (
#                 item.contains(self.material_description_field_name) and
#                 item.contains(self.signature_field_name)
#             )
#         except:
#             # If we encounter any error during detection, default to not using legacy
#             return False
#
#
# aws_dbesdk_dynamodb.internaldafny.generated.InternalLegacyOverride.InternalLegacyOverride = InternalLegacyOverride
