# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""Top-level class for encrypting and decrypting individual DynamoDB items."""
from typing import Any

from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.client import (
    DynamoDbItemEncryptor,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.config import (
    DynamoDbItemEncryptorConfig,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models import (
    DecryptItemInput,
    DecryptItemOutput,
    EncryptItemInput,
    EncryptItemOutput,
)
from aws_dbesdk_dynamodb.transform import (
    ddb_to_dict,
    dict_to_ddb,
)


class ItemEncryptor:
    """Class providing item-level encryption for DynamoDB items / Python dictionaries."""

    _internal_client: DynamoDbItemEncryptor

    def __init__(
        self,
        item_encryptor_config: DynamoDbItemEncryptorConfig,
    ):
        """
        Create an ItemEncryptor.

        Args:
            item_encryptor_config (DynamoDbItemEncryptorConfig): Encryption configuration object.

        """
        self._internal_client = DynamoDbItemEncryptor(config=item_encryptor_config)

    def encrypt_python_item(
        self,
        plaintext_dict_item: dict[str, Any],
    ) -> EncryptItemOutput:
        """
        Encrypt a Python dictionary.

        This method will transform the Python dictionary into DynamoDB JSON,
            encrypt the DynamoDB JSON,
            transform the encrypted DynamoDB JSON into an encrypted Python dictionary,
            then return the encrypted Python dictionary.

        See the boto3 documentation for details on Python/DynamoDB type transfomations:
        https://boto3.amazonaws.com/v1/documentation/api/latest/_modules/boto3/dynamodb/types.html

        boto3 DynamoDB Tables and Resources expect items formatted as native Python dictionaries.
        Use this method to encrypt an item if you intend to pass the encrypted item
            to a boto3 DynamoDB Table or Resource interface to store it.
        (Alternatively, you can use this library's EncryptedTable or EncryptedResource interfaces
            to transparently encrypt items without an intermediary ItemEncryptor.)

        Args:
            plaintext_dict_item (dict[str, Any]): A standard Python dictionary.

        Returns:
            EncryptItemOutput: Structure containing the following fields:
                - `encrypted_item` (dict[str, Any]): The encrypted Python dictionary.
                    **Note:** The item was encrypted as DynamoDB JSON, then transformed to a Python dictionary.
                - `parsed_header` (Optional[ParsedHeader]): The encrypted DynamoDB item's header (parsed
                    `aws_dbe_head` value).

        Example:
        >>> plaintext_item = {
        ...     'some': 'data',
        ...     'more': 5
        ... }
        >>> encrypt_output = item_encryptor.encrypt_python_item(plaintext_item)
        >>> encrypted_item = encrypt_output.encrypted_item
        >>> header = encrypt_output.parsed_header

        """
        plaintext_ddb_item = dict_to_ddb(plaintext_dict_item)
        encrypted_ddb_item: EncryptItemOutput = self.encrypt_dynamodb_item(plaintext_ddb_item)
        encrypted_dict_item = ddb_to_dict(encrypted_ddb_item.encrypted_item)
        return EncryptItemOutput(encrypted_item=encrypted_dict_item, parsed_header=encrypted_ddb_item.parsed_header)

    def encrypt_dynamodb_item(
        self,
        plaintext_dynamodb_item: dict[str, dict[str, Any]],
    ) -> EncryptItemOutput:
        """
        Encrypt DynamoDB-formatted JSON.

        boto3 DynamoDB clients expect items formatted as DynamoDB JSON:
        https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Programming.LowLevelAPI.html
        Use this method to encrypt an item if you intend to pass the encrypted item
            to a boto3 DynamoDB client to store it.
        (Alternatively, you can use this library's EncryptedClient interface
            to transparently encrypt items without an intermediary ItemEncryptor.)

        Args:
            plaintext_dynamodb_item (dict[str, dict[str, Any]]): The item to encrypt formatted as DynamoDB JSON.

        Returns:
            EncryptItemOutput: Structure containing the following fields:
                - `encrypted_item` (dict[str, Any]): A dictionary containing the encrypted DynamoDB item
                    formatted as DynamoDB JSON.
                - `parsed_header` (Optional[ParsedHeader]): The encrypted DynamoDB item's header (`aws_dbe_head` value).

        Example:
        >>> plaintext_item = {
        ...     'some': {'S': 'data'},
        ...     'more': {'N': '5'}
        ... }
        >>> encrypt_output = item_encryptor.encrypt_dynamodb_item(plaintext_item)
        >>> encrypted_item = encrypt_output.encrypted_item
        >>> header = encrypt_output.parsed_header

        """
        return self.encrypt_item(EncryptItemInput(plaintext_item=plaintext_dynamodb_item))

    def encrypt_item(
        self,
        encrypt_item_input: EncryptItemInput,
    ) -> EncryptItemOutput:
        """
        Encrypt a DynamoDB item.

        The input item should contain a dictionary formatted as DynamoDB JSON:
        https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Programming.LowLevelAPI.html

        Args:
            encrypt_item_input (EncryptItemInput): Structure containing the following field:
                - `plaintext_item` (dict[str, Any]): The item to encrypt formatted as DynamoDB JSON.

        Returns:
            EncryptItemOutput: Structure containing the following fields:
                - `encrypted_item` (dict[str, Any]): The encrypted DynamoDB item formatted as DynamoDB JSON.
                - `parsed_header` (Optional[ParsedHeader]): The encrypted DynamoDB item's header
                    (`aws_dbe_head` value).

        Example:
        >>> plaintext_item = {
        ...     'some': {'S': 'data'},
        ...     'more': {'N': '5'}
        ... }
        >>> encrypt_output = item_encryptor.encrypt_item(
        ...     EncryptItemInput(
        ...         plaintext_ddb_item = plaintext_item
        ...     )
        ... )
        >>> encrypted_item = encrypt_output.encrypted_item
        >>> header = encrypt_output.parsed_header

        """
        return self._internal_client.encrypt_item(encrypt_item_input)

    def decrypt_python_item(
        self,
        encrypted_dict_item: dict[str, Any],
    ) -> DecryptItemOutput:
        """
        Decrypt a Python dictionary.

        This method will transform the Python dictionary into DynamoDB JSON,
            decrypt the DynamoDB JSON,
            transform the plaintext DynamoDB JSON into a plaintext Python dictionary,
            then return the plaintext Python dictionary.

        See the boto3 documentation for details on Python/DynamoDB type transfomations:
        https://boto3.amazonaws.com/v1/documentation/api/latest/_modules/boto3/dynamodb/types.html

        boto3 DynamoDB Tables and Resources return items formatted as native Python dictionaries.
        Use this method to decrypt an item if you retrieve the encrypted item
            from a boto3 DynamoDB Table or Resource interface.
        (Alternatively, you can use this library's EncryptedTable or EncryptedResource interfaces
            to transparently decrypt items without an intermediary ItemEncryptor.)

        Args:
            encrypted_dict_item (dict[str, Any]): A standard Python dictionary with encrypted values.

        Returns:
            DecryptItemOutput: Structure containing the following fields:
                - `plaintext_item` (dict[str, Any]): The decrypted Python dictionary.
                    **Note:** The item was decrypted as DynamoDB JSON, then transformed to a Python dictionary.
                - `parsed_header` (Optional[ParsedHeader]): The encrypted DynamoDB item's header
                    (parsed `aws_dbe_head` value).

        Example:
        >>> encrypted_item = {
        ...     'some': b'ENCRYPTED_DATA',
        ...     'more': b'ENCRYPTED_DATA',
        ... }
        >>> decrypt_output = item_encryptor.decrypt_python_item(encrypted_item)
        >>> plaintext_item = decrypt_output.plaintext_item
        >>> header = decrypt_output.parsed_header

        """
        encrypted_ddb_item = dict_to_ddb(encrypted_dict_item)
        plaintext_ddb_item: DecryptItemOutput = self.decrypt_dynamodb_item(encrypted_ddb_item)
        plaintext_dict_item = ddb_to_dict(plaintext_ddb_item.plaintext_item)
        return DecryptItemOutput(plaintext_item=plaintext_dict_item, parsed_header=plaintext_ddb_item.parsed_header)

    def decrypt_dynamodb_item(
        self,
        encrypted_dynamodb_item: dict[str, dict[str, Any]],
    ) -> DecryptItemOutput:
        """
        Decrypt DynamoDB-formatted JSON.

        boto3 DynamoDB clients return items formatted as DynamoDB JSON:
        https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Programming.LowLevelAPI.html
        Use this method to decrypt an item if you retrieved the encrypted item
            from a boto3 DynamoDB client.
        (Alternatively, you can use this library's EncryptedClient interface
            to transparently decrypt items without an intermediary ItemEncryptor.)

        Args:
            encrypted_dynamodb_item (dict[str, dict[str, Any]]): The item to decrypt formatted as DynamoDB JSON.

        Returns:
            DecryptItemOutput: Structure containing the following fields:
                - `plaintext_item` (dict[str, Any]): The plaintext DynamoDB item formatted as DynamoDB JSON.
                - `parsed_header` (Optional[ParsedHeader]): The decrypted DynamoDB item's header (`aws_dbe_head` value).

        Example:
        >>> encrypted_item = {
        ...     'some': {'B': b'ENCRYPTED_DATA'},
        ...     'more': {'B': b'ENCRYPTED_DATA'}
        ... }
        >>> decrypt_output = item_encryptor.decrypt_dynamodb_item(encrypted_item)
        >>> plaintext_item = decrypt_output.plaintext_item
        >>> header = decrypt_output.parsed_header

        """
        return self.decrypt_item(DecryptItemInput(encrypted_item=encrypted_dynamodb_item))

    def decrypt_item(
        self,
        decrypt_item_input: DecryptItemInput,
    ) -> DecryptItemOutput:
        """
        Decrypt a DynamoDB item.

        The input item should contain a dictionary formatted as DynamoDB JSON:
        https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Programming.LowLevelAPI.html

        Args:
            decrypt_item_input (DecryptItemInput): Structure containing the following field:
                - `encrypted_item` (dict[str, Any]): The item to decrypt formatted as DynamoDB JSON.

        Returns:
            DecryptItemOutput: Structure containing the following fields:
                - `plaintext_item` (dict[str, Any]): The decrypted DynamoDB item formatted as DynamoDB JSON.
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
        >>> plaintext_item = decrypted_item.plaintext_item
        >>> header = decrypted_item.parsed_header

        """
        return self._internal_client.decrypt_item(decrypt_item_input)
