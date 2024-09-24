# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from aws_cryptographic_materialproviders.smithygenerated.aws_cryptography_materialproviders.references import (
    CryptographicMaterialsManager,
    Keyring,
)
from aws_database_encryption_sdk.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes import (
    DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig as DafnyDynamoDbItemEncryptorConfig,
)
import aws_database_encryption_sdk.internaldafny.generated.module_
import aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy
import aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny
from dataclasses import dataclass
from typing import Any, Callable, Optional, TypeAlias

from .dafnyImplInterface import DafnyImplInterface
from smithy_python._private.retries import SimpleRetryStrategy
from smithy_python.interfaces.retries import RetryStrategy

from ..aws_cryptography_dbencryptionsdk_dynamodb.models import LegacyOverride


_ServiceInterceptor = Any
@dataclass(init=False)
class Config:
    """Configuration for DynamoDbItemEncryptor."""

    interceptors: list[_ServiceInterceptor]
    retry_strategy: RetryStrategy
    dafnyImplInterface: DafnyImplInterface | None

    def __init__(
        self,
        *,
        interceptors: list[_ServiceInterceptor] | None = None,
        retry_strategy: RetryStrategy | None = None,
        dafnyImplInterface: DafnyImplInterface | None = None,
    ):
        """Constructor.

        :param interceptors: The list of interceptors, which are hooks that are called
        during the execution of a request.

        :param retry_strategy: The retry strategy for issuing retry tokens and computing
        retry delays.

        :param dafnyImplInterface:
        """
        self.interceptors = interceptors or []
        self.retry_strategy = retry_strategy or SimpleRetryStrategy()
        self.dafnyImplInterface = dafnyImplInterface

# A callable that allows customizing the config object on each request.
Plugin: TypeAlias = Callable[[Config], None]

class DynamoDbItemEncryptorConfig(Config):
    """
    Smithy-modelled localService Config shape for this localService.
    """
    logical_table_name: str
    partition_key_name: str
    attribute_actions_on_encrypt: dict[str, str]
    sort_key_name: Optional[str]
    allowed_unsigned_attributes: Optional[list[str]]
    allowed_unsigned_attribute_prefix: Optional[str]
    algorithm_suite_id: Optional[str]
    keyring: Optional[Keyring]
    cmm: Optional[CryptographicMaterialsManager]
    legacy_override: Optional[LegacyOverride]
    plaintext_override: Optional[str]

    def __init__(
        self,
        logical_table_name: str,
        partition_key_name: str,
        attribute_actions_on_encrypt: dict[str, str],
        sort_key_name: Optional[str] = None,
        allowed_unsigned_attributes: Optional[list[str]] = None,
        allowed_unsigned_attribute_prefix: Optional[str] = None,
        algorithm_suite_id: Optional[str] = None,
        keyring: Optional[Keyring] = None,
        cmm: Optional[CryptographicMaterialsManager] = None,
        legacy_override: Optional[LegacyOverride] = None,
        plaintext_override: Optional[str] = None,
    ):
        """The configuration for the client-side encryption of DynamoDB items.

        :param logical_table_name: The logical table name for this table. This is the
        name that is cryptographically bound with your data. This can be the same as the
        actual DynamoDB table name. It's purpose is to be distinct from the DynamoDB
        table name so that the data may still be authenticated if being read from
        different (but logically similar) tables, such as a backup table.
        :param partition_key_name: The name of the partition key on the table this item
        will be written to or was read from.
        :param attribute_actions_on_encrypt: A map that describes what attributes should
        be encrypted and/or signed on encrypt. This map must contain all attributes that
        might be encountered during encryption.
        :param sort_key_name: If this table contains a sort key, the name of the sort
        key on the table this item will be written to or was read from.
        :param allowed_unsigned_attributes: A list of attribute names such that, if
        encountered during decryption, those attributes are treated as unsigned.
        :param allowed_unsigned_attribute_prefix: A prefix such that, if during
        decryption any attribute has a name with this prefix, it is treated as unsigned.
        :param algorithm_suite_id: An ID for the algorithm suite to use during
        encryption and decryption.
        :param keyring: The Keyring that should be used to wrap and unwrap data keys. If
        specified a Default Cryptographic Materials Manager with this Keyring is used to
        obtain materials for encryption and decryption. Either a Keyring or a
        Cryptographic Materials Manager must be specified.
        :param cmm: The Cryptographic Materials Manager that is used to obtain materials
        for encryption and decryption.  Either a Keyring or a Cryptographic Materials
        Manager must be specified.
        :param legacy_override: A configuration that override encryption and/or
        decryption to instead perform legacy encryption and/or decryption. Used as part
        of migration from version 2.x to version 3.x.
        :param plaintext_override: A configuration that override encryption and/or
        decryption to instead passthrough and write and/or read plaintext. Used to
        update plaintext tables to fully use client-side encryption.
        """
        super().__init__()
        self.logical_table_name = logical_table_name
        self.partition_key_name = partition_key_name
        self.attribute_actions_on_encrypt = attribute_actions_on_encrypt
        self.sort_key_name = sort_key_name
        self.allowed_unsigned_attributes = allowed_unsigned_attributes
        self.allowed_unsigned_attribute_prefix = allowed_unsigned_attribute_prefix
        self.algorithm_suite_id = algorithm_suite_id
        self.keyring = keyring
        self.cmm = cmm
        self.legacy_override = legacy_override
        self.plaintext_override = plaintext_override

def dafny_config_to_smithy_config(dafny_config) -> DynamoDbItemEncryptorConfig:
    """
    Converts the provided Dafny shape for this localService's config
    into the corresponding Smithy-modelled shape.
    """
    return aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DynamoDbItemEncryptorConfig(dafny_config)

def smithy_config_to_dafny_config(smithy_config) -> DafnyDynamoDbItemEncryptorConfig:
    """
    Converts the provided Smithy-modelled shape for this localService's config
    into the corresponding Dafny shape.
    """
    return aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DynamoDbItemEncryptorConfig(smithy_config)
