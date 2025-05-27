# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbItemEncryptorTypes import (
    DynamoDbItemEncryptorConfig_DynamoDbItemEncryptorConfig as DafnyDynamoDbItemEncryptorConfig,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny
from dataclasses import dataclass
from typing import Any, Callable, Dict, Optional, TypeAlias

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

        :param interceptors: The list of interceptors, which are hooks
            that are called during the execution of a request.
        :param retry_strategy: The retry strategy for issuing retry
            tokens and computing retry delays.
        :param dafnyImplInterface:
        """
        self.interceptors = interceptors or []
        self.retry_strategy = retry_strategy or SimpleRetryStrategy()
        self.dafnyImplInterface = dafnyImplInterface


# A callable that allows customizing the config object on each request.
Plugin: TypeAlias = Callable[[Config], None]


class DynamoDbItemEncryptorConfig(Config):
    logical_table_name: str
    partition_key_name: str
    sort_key_name: Optional[str]
    attribute_actions_on_encrypt: dict[str, str]
    allowed_unsigned_attributes: Optional[list[str]]
    allowed_unsigned_attribute_prefix: Optional[str]
    algorithm_suite_id: Optional[str]
    keyring: Optional[
        "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.Keyring"
    ]
    cmm: Optional[
        "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.CryptographicMaterialsManager"
    ]
    legacy_override: Optional[LegacyOverride]
    plaintext_override: Optional[str]

    def __init__(
        self,
        *,
        logical_table_name: str,
        partition_key_name: str,
        attribute_actions_on_encrypt: dict[str, str],
        sort_key_name: Optional[str] = None,
        allowed_unsigned_attributes: Optional[list[str]] = None,
        allowed_unsigned_attribute_prefix: Optional[str] = None,
        algorithm_suite_id: Optional[str] = None,
        keyring: Optional[
            "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.Keyring"
        ] = None,
        cmm: Optional[
            "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.CryptographicMaterialsManager"
        ] = None,
        legacy_override: Optional[LegacyOverride] = None,
        plaintext_override: Optional[str] = None,
    ):
        """The configuration for the client-side encryption of DynamoDB items.

        :param logical_table_name: The logical table name for this
            table. This is the name that is cryptographically bound with
            your data. This can be the same as the actual DynamoDB table
            name. It's purpose is to be distinct from the DynamoDB table
            name so that the data may still be authenticated if being
            read from different (but logically similar) tables, such as
            a backup table.
        :param partition_key_name: The name of the partition key on the
            table this item will be written to or was read from.
        :param attribute_actions_on_encrypt: A map that describes what
            attributes should be encrypted and/or signed on encrypt.
            This map must contain all attributes that might be
            encountered during encryption.
        :param sort_key_name: If this table contains a sort key, the
            name of the sort key on the table this item will be written
            to or was read from.
        :param allowed_unsigned_attributes: A list of attribute names
            such that, if encountered during decryption, those
            attributes are treated as unsigned.
        :param allowed_unsigned_attribute_prefix: A prefix such that, if
            during decryption any attribute has a name with this prefix,
            it is treated as unsigned.
        :param algorithm_suite_id: An ID for the algorithm suite to use
            during encryption and decryption.
        :param keyring: The Keyring that should be used to wrap and
            unwrap data keys. If specified a Default Cryptographic
            Materials Manager with this Keyring is used to obtain
            materials for encryption and decryption. Either a Keyring or
            a Cryptographic Materials Manager must be specified.
        :param cmm: The Cryptographic Materials Manager that is used to
            obtain materials for encryption and decryption. Either a
            Keyring or a Cryptographic Materials Manager must be
            specified.
        :param legacy_override: A configuration that override encryption
            and/or decryption to instead perform legacy encryption
            and/or decryption. Used as part of migration from version
            2.x to version 3.x.
        :param plaintext_override: A configuration that override
            encryption and/or decryption to instead passthrough and
            write and/or read plaintext. Used to update plaintext tables
            to fully use client-side encryption.
        """
        super().__init__()
        self.logical_table_name = logical_table_name
        if (partition_key_name is not None) and (len(partition_key_name) < 1):
            raise ValueError("The size of partition_key_name must be greater than or equal to 1")

        if (partition_key_name is not None) and (len(partition_key_name) > 255):
            raise ValueError("The size of partition_key_name must be less than or equal to 255")

        self.partition_key_name = partition_key_name
        self.attribute_actions_on_encrypt = attribute_actions_on_encrypt
        if (sort_key_name is not None) and (len(sort_key_name) < 1):
            raise ValueError("The size of sort_key_name must be greater than or equal to 1")

        if (sort_key_name is not None) and (len(sort_key_name) > 255):
            raise ValueError("The size of sort_key_name must be less than or equal to 255")

        self.sort_key_name = sort_key_name
        if (allowed_unsigned_attributes is not None) and (len(allowed_unsigned_attributes) < 1):
            raise ValueError("The size of allowed_unsigned_attributes must be greater than or equal to 1")

        self.allowed_unsigned_attributes = allowed_unsigned_attributes
        self.allowed_unsigned_attribute_prefix = allowed_unsigned_attribute_prefix
        self.algorithm_suite_id = algorithm_suite_id
        self.keyring = keyring
        self.cmm = cmm
        self.legacy_override = legacy_override
        self.plaintext_override = plaintext_override

    def as_dict(self) -> Dict[str, Any]:
        """Converts the DynamoDbItemEncryptorConfig to a dictionary."""
        d: Dict[str, Any] = {
            "logical_table_name": self.logical_table_name,
            "partition_key_name": self.partition_key_name,
            "attribute_actions_on_encrypt": self.attribute_actions_on_encrypt,
        }

        if self.sort_key_name is not None:
            d["sort_key_name"] = self.sort_key_name

        if self.allowed_unsigned_attributes is not None:
            d["allowed_unsigned_attributes"] = self.allowed_unsigned_attributes

        if self.allowed_unsigned_attribute_prefix is not None:
            d["allowed_unsigned_attribute_prefix"] = self.allowed_unsigned_attribute_prefix

        if self.algorithm_suite_id is not None:
            d["algorithm_suite_id"] = self.algorithm_suite_id

        if self.keyring is not None:
            d["keyring"] = self.keyring.as_dict()

        if self.cmm is not None:
            d["cmm"] = self.cmm.as_dict()

        if self.legacy_override is not None:
            d["legacy_override"] = self.legacy_override.as_dict()

        if self.plaintext_override is not None:
            d["plaintext_override"] = self.plaintext_override

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "DynamoDbItemEncryptorConfig":
        """Creates a DynamoDbItemEncryptorConfig from a dictionary."""
        from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references import (
            Keyring,
        )
        from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references import (
            CryptographicMaterialsManager,
        )

        kwargs: Dict[str, Any] = {
            "logical_table_name": d["logical_table_name"],
            "partition_key_name": d["partition_key_name"],
            "attribute_actions_on_encrypt": d["attribute_actions_on_encrypt"],
        }

        if "sort_key_name" in d:
            kwargs["sort_key_name"] = d["sort_key_name"]

        if "allowed_unsigned_attributes" in d:
            kwargs["allowed_unsigned_attributes"] = d["allowed_unsigned_attributes"]

        if "allowed_unsigned_attribute_prefix" in d:
            kwargs["allowed_unsigned_attribute_prefix"] = d["allowed_unsigned_attribute_prefix"]

        if "algorithm_suite_id" in d:
            kwargs["algorithm_suite_id"] = d["algorithm_suite_id"]

        if "keyring" in d:
            kwargs["keyring"] = Keyring.from_dict(d["keyring"])

        if "cmm" in d:
            kwargs["cmm"] = CryptographicMaterialsManager.from_dict(d["cmm"])

        if "legacy_override" in d:
            kwargs["legacy_override"] = LegacyOverride.from_dict(d["legacy_override"])

        if "plaintext_override" in d:
            kwargs["plaintext_override"] = d["plaintext_override"]

        return DynamoDbItemEncryptorConfig(**kwargs)

    def __repr__(self) -> str:
        result = "DynamoDbItemEncryptorConfig("
        if self.logical_table_name is not None:
            result += f"logical_table_name={repr(self.logical_table_name)}, "

        if self.partition_key_name is not None:
            result += f"partition_key_name={repr(self.partition_key_name)}, "

        if self.sort_key_name is not None:
            result += f"sort_key_name={repr(self.sort_key_name)}, "

        if self.attribute_actions_on_encrypt is not None:
            result += f"attribute_actions_on_encrypt={repr(self.attribute_actions_on_encrypt)}, "

        if self.allowed_unsigned_attributes is not None:
            result += f"allowed_unsigned_attributes={repr(self.allowed_unsigned_attributes)}, "

        if self.allowed_unsigned_attribute_prefix is not None:
            result += f"allowed_unsigned_attribute_prefix={repr(self.allowed_unsigned_attribute_prefix)}, "

        if self.algorithm_suite_id is not None:
            result += f"algorithm_suite_id={repr(self.algorithm_suite_id)}, "

        if self.keyring is not None:
            result += f"keyring={repr(self.keyring)}, "

        if self.cmm is not None:
            result += f"cmm={repr(self.cmm)}, "

        if self.legacy_override is not None:
            result += f"legacy_override={repr(self.legacy_override)}, "

        if self.plaintext_override is not None:
            result += f"plaintext_override={repr(self.plaintext_override)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, DynamoDbItemEncryptorConfig):
            return False
        attributes: list[str] = [
            "logical_table_name",
            "partition_key_name",
            "sort_key_name",
            "attribute_actions_on_encrypt",
            "allowed_unsigned_attributes",
            "allowed_unsigned_attribute_prefix",
            "algorithm_suite_id",
            "keyring",
            "cmm",
            "legacy_override",
            "plaintext_override",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


def dafny_config_to_smithy_config(dafny_config) -> DynamoDbItemEncryptorConfig:
    """Converts the provided Dafny shape for this localService's config into
    the corresponding Smithy-modelled shape."""
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DynamoDbItemEncryptorConfig(
        dafny_config
    )


def smithy_config_to_dafny_config(smithy_config) -> DafnyDynamoDbItemEncryptorConfig:
    """Converts the provided Smithy-modelled shape for this localService's
    config into the corresponding Dafny shape."""
    return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DynamoDbItemEncryptorConfig(
        smithy_config
    )
