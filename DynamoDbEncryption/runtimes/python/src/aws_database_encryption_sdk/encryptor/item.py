# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Top-level class for encrypting and decrypting individual DynamoDB items."""
from typing import Any

from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.config import (
    DynamoDbItemEncryptorConfig,
)
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.client import (
    DynamoDbItemEncryptor,
)
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models import (
    DecryptItemInput,
    DecryptItemOutput,
    EncryptItemInput,
    EncryptItemOutput,
)
from aws_database_encryption_sdk.transform import (
    dict_to_ddb,
    ddb_to_dict,
)

class ItemEncryptor:
    """Client providing item-level encryption for DynamoDB items / Python dictionaries."""

    _internal_client: DynamoDbItemEncryptor

    def __init__(
        self,
        item_encryptor_config: DynamoDbItemEncryptorConfig,
    ):
        """
        Create an ItemEncryptor.

        Parameters:
        item_encryptor_config (DynamoDbItemEncryptorConfig): Encryption configuration object.
        """
        self._internal_client = DynamoDbItemEncryptor(config = item_encryptor_config)

    def encrypt_python_item(
        self,
        plaintext_dict_item: dict[str, Any]
    ) -> EncryptItemOutput:
        """
        Encrypt a Python dictionary.
        This method will convert the Python dictionary into a DynamoDB item, then encrypt the item.

        boto3 DynamoDB Tables and Resources expect items formatted as native Python dictionaries.
        Use this method to encrypt an item you intend to store using a boto3 DynamoDB Table or Resource interface.

        Parameters:
        plaintext_dict_item (dict[str, Any]): A standard Python dictionary.
        
        Returns:
        EncryptItemOutput: Structure containing the following fields:
            - `encrypted_item` (dict[str, Any]): The encrypted Python dictionary.
                **Note:** The item was encrypted as a DynamoDB item, then converted back to a native Python item.
            - `parsed_header` (Optional[ParsedHeader]): The encrypted DynamoDB item's header (`aws_dbe_head` value).

        Example:
        
        >>> plaintext_item = {
        ...     'some': 'data',
        ...     'more': 5
        ... }
        >>> encrypted_item, header = item_encryptor.encrypt_python_item(
        ...     plaintext_dict_item = plaintext_item,
        ... )
        """
        plaintext_ddb_item = dict_to_ddb(plaintext_dict_item)
        encrypted_ddb_item: EncryptItemOutput = self.encrypt_dynamodb_item(plaintext_ddb_item)
        encrypted_dict_item = ddb_to_dict(encrypted_ddb_item.encrypted_item)
        return EncryptItemOutput(
            encrypted_item = encrypted_dict_item,
            parsed_header = encrypted_ddb_item.parsed_header
        )

    def encrypt_dynamodb_item(
        self,
        plaintext_dynamodb_item: dict[str, Any]
    ) -> EncryptItemOutput:
        """
        Encrypt a DynamoDB item.

        boto3 DynamoDB clients expect items formatted as DynamoDB items.
        Use this method to encrypt an item you intend to store using a boto3 DynamoDB client.

        Parameters:
        plaintext_dynamodb_item (dict[str, Any]): A dictionary representing a DynamoDB item.
        
        Returns:
        EncryptItemOutput: Structure containing the following fields:
            - `encrypted_item` (dict[str, Any]): The encrypted DynamoDB item.
            - `parsed_header` (Optional[ParsedHeader]): The encrypted DynamoDB item's header (`aws_dbe_head` value).

        Example:
        
        >>> plaintext_item = {
        ...     'some': {'S': 'data'},
        ...     'more': {'N': '5'}
        ... }
        >>> encrypted_item, header = item_encryptor.encrypt_dynamodb_item(
        ...     plaintext_dynamodb_item = plaintext_item
        ... )
        """
        return self.encrypt_item(
            EncryptItemInput(
                plaintext_item = plaintext_dynamodb_item
            )
        )

    def encrypt_item(
        self,
        encrypt_item_input: EncryptItemInput
    ) -> EncryptItemOutput:
        """
        Encrypt a DynamoDB item.

        Parameters:
        encrypt_item_input (EncryptItemInput): Structure containing the following field:
            - `plaintext_item` (dict[str, Any]): The plaintext DynamoDB item.
        
        Returns:
        EncryptItemOutput: Structure containing the following fields:
            - `encrypted_item` (dict[str, Any]): The encrypted DynamoDB item.
            - `parsed_header` (Optional[ParsedHeader]): The encrypted DynamoDB item's header (`aws_dbe_head` value).

        Example:
        
        >>> plaintext_item = {
        ...     'some': {'S': 'data'},
        ...     'more': {'N': '5'}
        ... }
        >>> encrypted_item, header = item_encryptor.encrypt_item(
        ...     EncryptItemInput(
        ...         plaintext_ddb_item = plaintext_item
        ...     )
        ... )
        """
        return self._internal_client.encrypt_item(encrypt_item_input)

    def decrypt_python_item(
        self,
        encrypted_dict_item: dict[str, Any]
    ) -> DecryptItemOutput:
        """
        Decrypt a Python dictionary.
        This will convert the Python dictionary into a DynamoDB item, then decrypt the item.

        boto3 DynamoDB Tables and Resources expect items formatted as native Python dictionaries.
        Use this method to decrypt an item you retrieved using a boto3 DynamoDB Table or Resource interface.

        Parameters:
        encrypted_dict_item (dict[str, Any]): A standard Python dictionary with encrypted values.
        
        Returns:
        DecryptItemOutput: Structure containing the following fields:
            - `encrypted_item` (dict[str, Any]): The decrypted Python dictionary.
                **Note:** The item was decrypted as a DynamoDB item, then converted back to a native Python item.
            - `parsed_header` (Optional[ParsedHeader]): The decrypted DynamoDB item's header (`aws_dbe_head` value).

        Example:
        
        >>> plaintext_item = {
        ...     'some': 'data',
        ...     'more': 5
        ... }
        >>> encrypted_item = item_encryptor.encrypt_python_item(
        ...     plaintext_dict_item = plaintext_item,
        ... )
        """
        encrypted_ddb_item = dict_to_ddb(encrypted_dict_item)
        plaintext_ddb_item: DecryptItemOutput = self.decrypt_dynamodb_item(encrypted_ddb_item)
        plaintext_dict_item = ddb_to_dict(plaintext_ddb_item.plaintext_item)
        return DecryptItemOutput(
            plaintext_item = plaintext_dict_item,
            parsed_header = plaintext_ddb_item.parsed_header
        )

    def decrypt_dynamodb_item(
        self,
        encrypted_dynamodb_item: dict[str, Any]
    ) -> DecryptItemOutput:
        """
        Decrypt a DynamoDB item.

        boto3 DynamoDB clients expect items formatted as DynamoDB items.
        Use this method to decrypt an item you retrieved using a boto3 DynamoDB client.

        Parameters:
        encrypted_ddb_item (dict[str, Any]): A dictionary representing an encrypted DynamoDB item.
        
        Returns:
        DecryptItemOutput: Structure containing the following fields:
            - `plaintext_item` (dict[str, Any]): The plaintext DynamoDB item.
            - `parsed_header` (Optional[ParsedHeader]): The decrypted DynamoDB item's header (`aws_dbe_head` value).

        Example:
        
        >>> encrypted_item = {
        ...     'some': {'B': b'ENCRYPTED_DATA'},
        ...     'more': {'B': b'ENCRYPTED_DATA'}
        ... }
        >>> decrypted_item = item_encryptor.decrypt_dynamodb_item(
        ...     encrypted_ddb_item = encrypted_item,
        ... )
        """
        return self.decrypt_item(
            DecryptItemInput(
                encrypted_item = encrypted_dynamodb_item
            )
        )

    def decrypt_item(
        self,
        decrypt_item_input: DecryptItemInput
    ) -> DecryptItemOutput:
        """
        Decrypt a DynamoDB item.

        Parameters:
        decrypt_item_input (DecryptItemInput): Structure containing the following field:
            - `encrypted_item` (dict[str, Any]): The encrypted DynamoDB item.
        
        Returns:
        DecryptItemOutput: Structure containing the following fields:
            - `plaintext_item` (dict[str, Any]): The plaintext DynamoDB item.
            - `parsed_header` (Optional[ParsedHeader]): The decrypted DynamoDB item's header (`aws_dbe_head` value).

        Example:
        
        >>> encrypted_item = {
        ...     'some': {'B': b'ENCRYPTED_DATA'},
        ...     'more': {'B': b'ENCRYPTED_DATA'}
        ... }
        >>> decrypted_item = item_encryptor.decrypt_item(
        ...     DecryptItemInput(
        ...         encrypted_item = encrypted_item,
        ...     )
        ... )
        """
        return self._internal_client.decrypt_item(decrypt_item_input)
