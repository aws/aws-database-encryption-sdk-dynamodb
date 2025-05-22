# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import aws_cryptographic_material_providers.smithygenerated.aws_cryptography_keystore.client
import aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.references
from typing import Any, Dict, List, Optional, Union

from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.models import (
    CacheType,
    _cache_type_from_dict,
)


class CreateDynamoDbEncryptionBranchKeyIdSupplierInput:
    ddb_key_branch_key_id_supplier: "aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.references.DynamoDbKeyBranchKeyIdSupplier"

    def __init__(
        self,
        *,
        ddb_key_branch_key_id_supplier: "aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.references.DynamoDbKeyBranchKeyIdSupplier",
    ):
        """Inputs for creating a Branch Key Supplier from a DynamoDB Key Branch Key Id
        Supplier

        :param ddb_key_branch_key_id_supplier: An implementation of the
        DynamoDbKeyBranchKeyIdSupplier interface, which determines what Branch Key to
        use for data key wrapping/unwrapping based on the DynamoDB item being
        written/read.
        """
        self.ddb_key_branch_key_id_supplier = ddb_key_branch_key_id_supplier

    def as_dict(self) -> Dict[str, Any]:
        """Converts the CreateDynamoDbEncryptionBranchKeyIdSupplierInput to a dictionary."""
        return {
            "ddb_key_branch_key_id_supplier": self.ddb_key_branch_key_id_supplier.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "CreateDynamoDbEncryptionBranchKeyIdSupplierInput":
        """Creates a CreateDynamoDbEncryptionBranchKeyIdSupplierInput from a dictionary."""
        from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.references import (
            DynamoDbKeyBranchKeyIdSupplier,
        )

        kwargs: Dict[str, Any] = {
            "ddb_key_branch_key_id_supplier": DynamoDbKeyBranchKeyIdSupplier.from_dict(
                d["ddb_key_branch_key_id_supplier"]
            ),
        }

        return CreateDynamoDbEncryptionBranchKeyIdSupplierInput(**kwargs)

    def __repr__(self) -> str:
        result = "CreateDynamoDbEncryptionBranchKeyIdSupplierInput("
        if self.ddb_key_branch_key_id_supplier is not None:
            result += f"ddb_key_branch_key_id_supplier={repr(self.ddb_key_branch_key_id_supplier)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, CreateDynamoDbEncryptionBranchKeyIdSupplierInput):
            return False
        attributes: list[str] = [
            "ddb_key_branch_key_id_supplier",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class CreateDynamoDbEncryptionBranchKeyIdSupplierOutput:
    branch_key_id_supplier: "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.BranchKeyIdSupplier"

    def __init__(
        self,
        *,
        branch_key_id_supplier: "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.BranchKeyIdSupplier",
    ):
        """Outputs for creating a Branch Key Supplier from a DynamoDB Key Branch Key Id
        Supplier

        :param branch_key_id_supplier: The Branch Key Supplier for use with the
        Hierarchical Keyring.
        """
        self.branch_key_id_supplier = branch_key_id_supplier

    def as_dict(self) -> Dict[str, Any]:
        """Converts the CreateDynamoDbEncryptionBranchKeyIdSupplierOutput to a dictionary."""
        return {
            "branch_key_id_supplier": self.branch_key_id_supplier.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "CreateDynamoDbEncryptionBranchKeyIdSupplierOutput":
        """Creates a CreateDynamoDbEncryptionBranchKeyIdSupplierOutput from a dictionary."""
        from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references import (
            BranchKeyIdSupplier,
        )

        kwargs: Dict[str, Any] = {
            "branch_key_id_supplier": BranchKeyIdSupplier.from_dict(d["branch_key_id_supplier"]),
        }

        return CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(**kwargs)

    def __repr__(self) -> str:
        result = "CreateDynamoDbEncryptionBranchKeyIdSupplierOutput("
        if self.branch_key_id_supplier is not None:
            result += f"branch_key_id_supplier={repr(self.branch_key_id_supplier)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, CreateDynamoDbEncryptionBranchKeyIdSupplierOutput):
            return False
        attributes: list[str] = [
            "branch_key_id_supplier",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class GetBranchKeyIdFromDdbKeyOutput:
    branch_key_id: str

    def __init__(
        self,
        *,
        branch_key_id: str,
    ):
        """Outputs for getting the Branch Key that should be used for wrapping and
        unwrapping data keys.

        :param branch_key_id: The ID of the Branch Key that should be used to wrap and
        unwrap data keys for this item.
        """
        self.branch_key_id = branch_key_id

    def as_dict(self) -> Dict[str, Any]:
        """Converts the GetBranchKeyIdFromDdbKeyOutput to a dictionary."""
        return {
            "branch_key_id": self.branch_key_id,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetBranchKeyIdFromDdbKeyOutput":
        """Creates a GetBranchKeyIdFromDdbKeyOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "branch_key_id": d["branch_key_id"],
        }

        return GetBranchKeyIdFromDdbKeyOutput(**kwargs)

    def __repr__(self) -> str:
        result = "GetBranchKeyIdFromDdbKeyOutput("
        if self.branch_key_id is not None:
            result += f"branch_key_id={repr(self.branch_key_id)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetBranchKeyIdFromDdbKeyOutput):
            return False
        attributes: list[str] = [
            "branch_key_id",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class EncryptedDataKeyDescription:
    key_provider_id: str
    key_provider_info: Optional[str]
    branch_key_id: Optional[str]
    branch_key_version: Optional[str]

    def __init__(
        self,
        *,
        key_provider_id: str,
        key_provider_info: Optional[str] = None,
        branch_key_id: Optional[str] = None,
        branch_key_version: Optional[str] = None,
    ):
        """
        :param key_provider_id: Key provider id of the encrypted data key.
        :param key_provider_info: Key provider information of the encrypted data key.
        :param branch_key_id: Branch key id of the encrypted data key.
        :param branch_key_version: Branch key version of the encrypted data key.
        """
        self.key_provider_id = key_provider_id
        self.key_provider_info = key_provider_info
        self.branch_key_id = branch_key_id
        self.branch_key_version = branch_key_version

    def as_dict(self) -> Dict[str, Any]:
        """Converts the EncryptedDataKeyDescription to a dictionary."""
        d: Dict[str, Any] = {
            "key_provider_id": self.key_provider_id,
        }

        if self.key_provider_info is not None:
            d["key_provider_info"] = self.key_provider_info

        if self.branch_key_id is not None:
            d["branch_key_id"] = self.branch_key_id

        if self.branch_key_version is not None:
            d["branch_key_version"] = self.branch_key_version

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "EncryptedDataKeyDescription":
        """Creates a EncryptedDataKeyDescription from a dictionary."""
        kwargs: Dict[str, Any] = {
            "key_provider_id": d["key_provider_id"],
        }

        if "key_provider_info" in d:
            kwargs["key_provider_info"] = d["key_provider_info"]

        if "branch_key_id" in d:
            kwargs["branch_key_id"] = d["branch_key_id"]

        if "branch_key_version" in d:
            kwargs["branch_key_version"] = d["branch_key_version"]

        return EncryptedDataKeyDescription(**kwargs)

    def __repr__(self) -> str:
        result = "EncryptedDataKeyDescription("
        if self.key_provider_id is not None:
            result += f"key_provider_id={repr(self.key_provider_id)}, "

        if self.key_provider_info is not None:
            result += f"key_provider_info={repr(self.key_provider_info)}, "

        if self.branch_key_id is not None:
            result += f"branch_key_id={repr(self.branch_key_id)}, "

        if self.branch_key_version is not None:
            result += f"branch_key_version={repr(self.branch_key_version)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, EncryptedDataKeyDescription):
            return False
        attributes: list[str] = [
            "key_provider_id",
            "key_provider_info",
            "branch_key_id",
            "branch_key_version",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class GetEncryptedDataKeyDescriptionOutput:
    encrypted_data_key_description_output: list[EncryptedDataKeyDescription]

    def __init__(
        self,
        *,
        encrypted_data_key_description_output: list[EncryptedDataKeyDescription],
    ):
        """Output for getting encrypted data key description.

        :param encrypted_data_key_description_output: A list of encrypted data key
        description.
        """
        self.encrypted_data_key_description_output = encrypted_data_key_description_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the GetEncryptedDataKeyDescriptionOutput to a dictionary."""
        return {
            "encrypted_data_key_description_output": _encrypted_data_key_description_list_as_dict(
                self.encrypted_data_key_description_output
            ),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetEncryptedDataKeyDescriptionOutput":
        """Creates a GetEncryptedDataKeyDescriptionOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "encrypted_data_key_description_output": _encrypted_data_key_description_list_from_dict(
                d["encrypted_data_key_description_output"]
            ),
        }

        return GetEncryptedDataKeyDescriptionOutput(**kwargs)

    def __repr__(self) -> str:
        result = "GetEncryptedDataKeyDescriptionOutput("
        if self.encrypted_data_key_description_output is not None:
            result += f"encrypted_data_key_description_output={repr(self.encrypted_data_key_description_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetEncryptedDataKeyDescriptionOutput):
            return False
        attributes: list[str] = [
            "encrypted_data_key_description_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class GetBranchKeyIdFromDdbKeyInput:
    ddb_key: "dict[str, dict[str, Any]]"

    def __init__(
        self,
        *,
        ddb_key: "dict[str, dict[str, Any]]",
    ):
        """Inputs for getting the Branch Key that should be used for wrapping and
        unwrapping data keys.

        :param ddb_key: The partition and sort (if it exists) attributes on the item
        being read or written, along with the values of any attributes configured as
        SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.
        """
        self.ddb_key = ddb_key

    def as_dict(self) -> Dict[str, Any]:
        """Converts the GetBranchKeyIdFromDdbKeyInput to a dictionary."""
        return {
            "ddb_key": self.ddb_key,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetBranchKeyIdFromDdbKeyInput":
        """Creates a GetBranchKeyIdFromDdbKeyInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "ddb_key": d["ddb_key"],
        }

        return GetBranchKeyIdFromDdbKeyInput(**kwargs)

    def __repr__(self) -> str:
        result = "GetBranchKeyIdFromDdbKeyInput("
        if self.ddb_key is not None:
            result += f"ddb_key={repr(self.ddb_key)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetBranchKeyIdFromDdbKeyInput):
            return False
        attributes: list[str] = [
            "ddb_key",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class GetEncryptedDataKeyDescriptionUnionHeader:
    """A binary header value."""

    def __init__(self, value: bytes | bytearray):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"header": self.value}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetEncryptedDataKeyDescriptionUnionHeader":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return GetEncryptedDataKeyDescriptionUnionHeader(d["header"])

    def __repr__(self) -> str:
        return f"GetEncryptedDataKeyDescriptionUnionHeader(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetEncryptedDataKeyDescriptionUnionHeader):
            return False
        return self.value == other.value


class GetEncryptedDataKeyDescriptionUnionItem:
    """A DynamoDB item."""

    def __init__(self, value: "dict[str, dict[str, Any]]"):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"item": self.value}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetEncryptedDataKeyDescriptionUnionItem":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return GetEncryptedDataKeyDescriptionUnionItem(d["item"])

    def __repr__(self) -> str:
        return f"GetEncryptedDataKeyDescriptionUnionItem(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetEncryptedDataKeyDescriptionUnionItem):
            return False
        return self.value == other.value


class GetEncryptedDataKeyDescriptionUnionUnknown:
    """Represents an unknown variant.

    If you receive this value, you will need to update your library to receive the
    parsed value.

    This value may not be deliberately sent.
    """

    def __init__(self, tag: str):
        self.tag = tag

    def as_dict(self) -> Dict[str, Any]:
        return {"SDK_UNKNOWN_MEMBER": {"name": self.tag}}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetEncryptedDataKeyDescriptionUnionUnknown":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")
        return GetEncryptedDataKeyDescriptionUnionUnknown(d["SDK_UNKNOWN_MEMBER"]["name"])

    def __repr__(self) -> str:
        return f"GetEncryptedDataKeyDescriptionUnionUnknown(tag={self.tag})"


GetEncryptedDataKeyDescriptionUnion = Union[
    GetEncryptedDataKeyDescriptionUnionHeader,
    GetEncryptedDataKeyDescriptionUnionItem,
    GetEncryptedDataKeyDescriptionUnionUnknown,
]


def _get_encrypted_data_key_description_union_from_dict(d: Dict[str, Any]) -> GetEncryptedDataKeyDescriptionUnion:
    if "header" in d:
        return GetEncryptedDataKeyDescriptionUnionHeader.from_dict(d)

    if "item" in d:
        return GetEncryptedDataKeyDescriptionUnionItem.from_dict(d)

    raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")


class GetEncryptedDataKeyDescriptionInput:
    input: "GetEncryptedDataKeyDescriptionUnion"

    def __init__(
        self,
        *,
        input: "GetEncryptedDataKeyDescriptionUnion",
    ):
        """Input for getting encrypted data key description."""
        self.input = input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the GetEncryptedDataKeyDescriptionInput to a dictionary."""
        return {
            "input": self.input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetEncryptedDataKeyDescriptionInput":
        """Creates a GetEncryptedDataKeyDescriptionInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "input": _get_encrypted_data_key_description_union_from_dict(d["input"]),
        }

        return GetEncryptedDataKeyDescriptionInput(**kwargs)

    def __repr__(self) -> str:
        result = "GetEncryptedDataKeyDescriptionInput("
        if self.input is not None:
            result += f"input={repr(self.input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetEncryptedDataKeyDescriptionInput):
            return False
        attributes: list[str] = [
            "input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class AsSet:
    """Attribute must be a Set. Beacon value will also be a Set."""

    def as_dict(self) -> Dict[str, Any]:
        """Converts the AsSet to a dictionary."""
        return {}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "AsSet":
        """Creates a AsSet from a dictionary."""
        return AsSet()

    def __repr__(self) -> str:
        result = "AsSet("

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        return isinstance(other, AsSet)


class MultiKeyStore:
    key_field_name: str
    cache_ttl: int
    cache: Optional[CacheType]
    partition_id: Optional[str]

    def __init__(
        self,
        *,
        key_field_name: str,
        cache_ttl: int,
        cache: Optional[CacheType] = None,
        partition_id: Optional[str] = None,
    ):
        """The configuration for using multiple Beacon Keys.

        :param key_field_name: The name of the field that stores the Beacon Key. This
        may be a Virtual Field.
        :param cache_ttl: How long (in seconds) the beacon key material is cached
        locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
        :param cache: Which type of local cache to use.
        :param partition_id: Partition ID to distinguish Beacon Key Sources writing to a
        Shared cache. If the Partition ID is the same for two Beacon Key Sources, they
        can share the same cache entries in the Shared cache.
        """
        self.key_field_name = key_field_name
        self.cache_ttl = cache_ttl
        self.cache = cache
        self.partition_id = partition_id

    def as_dict(self) -> Dict[str, Any]:
        """Converts the MultiKeyStore to a dictionary."""
        d: Dict[str, Any] = {
            "key_field_name": self.key_field_name,
            "cache_ttl": self.cache_ttl,
        }

        if self.cache is not None:
            d["cache"] = self.cache.as_dict()

        if self.partition_id is not None:
            d["partition_id"] = self.partition_id

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "MultiKeyStore":
        """Creates a MultiKeyStore from a dictionary."""
        kwargs: Dict[str, Any] = {
            "key_field_name": d["key_field_name"],
            "cache_ttl": d["cache_ttl"],
        }

        if "cache" in d:
            kwargs["cache"] = (_cache_type_from_dict(d["cache"]),)

        if "partition_id" in d:
            kwargs["partition_id"] = d["partition_id"]

        return MultiKeyStore(**kwargs)

    def __repr__(self) -> str:
        result = "MultiKeyStore("
        if self.key_field_name is not None:
            result += f"key_field_name={repr(self.key_field_name)}, "

        if self.cache_ttl is not None:
            result += f"cache_ttl={repr(self.cache_ttl)}, "

        if self.cache is not None:
            result += f"cache={repr(self.cache)}, "

        if self.partition_id is not None:
            result += f"partition_id={repr(self.partition_id)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, MultiKeyStore):
            return False
        attributes: list[str] = [
            "key_field_name",
            "cache_ttl",
            "cache",
            "partition_id",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class SingleKeyStore:
    key_id: str
    cache_ttl: int
    cache: Optional[CacheType]
    partition_id: Optional[str]

    def __init__(
        self,
        *,
        key_id: str,
        cache_ttl: int,
        cache: Optional[CacheType] = None,
        partition_id: Optional[str] = None,
    ):
        """The configuration for using a single Beacon Key.

        :param key_id: The Beacon Key ID.
        :param cache_ttl: How long (in seconds) the beacon key material is cached
        locally before it is re-retrieved from DynamoDB and re-authed with AWS KMS.
        :param cache: Which type of local cache to use. Please see the
        [spec](https://github.com/aws/aws-database-encryption-sdk-dynamodb/blob/main/specification/searchable-encryption/search-config.md#key-store-cache)
        on how to provide a cache for a SingleKeyStore.
        :param partition_id: Partition ID to distinguish Beacon Key Sources writing to a
        Shared cache. If the Partition ID is the same for two Beacon Key Sources, they
        can share the same cache entries in the Shared cache.
        """
        self.key_id = key_id
        self.cache_ttl = cache_ttl
        self.cache = cache
        self.partition_id = partition_id

    def as_dict(self) -> Dict[str, Any]:
        """Converts the SingleKeyStore to a dictionary."""
        d: Dict[str, Any] = {
            "key_id": self.key_id,
            "cache_ttl": self.cache_ttl,
        }

        if self.cache is not None:
            d["cache"] = self.cache.as_dict()

        if self.partition_id is not None:
            d["partition_id"] = self.partition_id

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "SingleKeyStore":
        """Creates a SingleKeyStore from a dictionary."""
        kwargs: Dict[str, Any] = {
            "key_id": d["key_id"],
            "cache_ttl": d["cache_ttl"],
        }

        if "cache" in d:
            kwargs["cache"] = (_cache_type_from_dict(d["cache"]),)

        if "partition_id" in d:
            kwargs["partition_id"] = d["partition_id"]

        return SingleKeyStore(**kwargs)

    def __repr__(self) -> str:
        result = "SingleKeyStore("
        if self.key_id is not None:
            result += f"key_id={repr(self.key_id)}, "

        if self.cache_ttl is not None:
            result += f"cache_ttl={repr(self.cache_ttl)}, "

        if self.cache is not None:
            result += f"cache={repr(self.cache)}, "

        if self.partition_id is not None:
            result += f"partition_id={repr(self.partition_id)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, SingleKeyStore):
            return False
        attributes: list[str] = [
            "key_id",
            "cache_ttl",
            "cache",
            "partition_id",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BeaconKeySourceSingle:
    """The configuration for using a single Beacon Key."""

    def __init__(self, value: SingleKeyStore):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"single": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BeaconKeySourceSingle":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return BeaconKeySourceSingle(SingleKeyStore.from_dict(d["single"]))

    def __repr__(self) -> str:
        return f"BeaconKeySourceSingle(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BeaconKeySourceSingle):
            return False
        return self.value == other.value


class BeaconKeySourceMulti:
    """The configuration for using multiple Beacon Keys."""

    def __init__(self, value: MultiKeyStore):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"multi": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BeaconKeySourceMulti":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return BeaconKeySourceMulti(MultiKeyStore.from_dict(d["multi"]))

    def __repr__(self) -> str:
        return f"BeaconKeySourceMulti(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BeaconKeySourceMulti):
            return False
        return self.value == other.value


class BeaconKeySourceUnknown:
    """Represents an unknown variant.

    If you receive this value, you will need to update your library to receive the
    parsed value.

    This value may not be deliberately sent.
    """

    def __init__(self, tag: str):
        self.tag = tag

    def as_dict(self) -> Dict[str, Any]:
        return {"SDK_UNKNOWN_MEMBER": {"name": self.tag}}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BeaconKeySourceUnknown":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")
        return BeaconKeySourceUnknown(d["SDK_UNKNOWN_MEMBER"]["name"])

    def __repr__(self) -> str:
        return f"BeaconKeySourceUnknown(tag={self.tag})"


BeaconKeySource = Union[BeaconKeySourceSingle, BeaconKeySourceMulti, BeaconKeySourceUnknown]


def _beacon_key_source_from_dict(d: Dict[str, Any]) -> BeaconKeySource:
    if "single" in d:
        return BeaconKeySourceSingle.from_dict(d)

    if "multi" in d:
        return BeaconKeySourceMulti.from_dict(d)

    raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")


class PartOnly:
    """Attribute must be used as part of a Compound Beacon, never alone."""

    def as_dict(self) -> Dict[str, Any]:
        """Converts the PartOnly to a dictionary."""
        return {}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "PartOnly":
        """Creates a PartOnly from a dictionary."""
        return PartOnly()

    def __repr__(self) -> str:
        result = "PartOnly("

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        return isinstance(other, PartOnly)


class Shared:
    other: str

    def __init__(
        self,
        *,
        other: str,
    ):
        """This beacon should calculate values like another beacon, so they can be
        compared.

        :param other: Calculate beacon values as for this beacon.
        """
        self.other = other

    def as_dict(self) -> Dict[str, Any]:
        """Converts the Shared to a dictionary."""
        return {
            "other": self.other,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "Shared":
        """Creates a Shared from a dictionary."""
        kwargs: Dict[str, Any] = {
            "other": d["other"],
        }

        return Shared(**kwargs)

    def __repr__(self) -> str:
        result = "Shared("
        if self.other is not None:
            result += f"other={repr(self.other)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, Shared):
            return False
        attributes: list[str] = [
            "other",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class SharedSet:
    other: str

    def __init__(
        self,
        *,
        other: str,
    ):
        """Both Shared and AsSet.

        :param other: Calculate beacon values as for this beacon.
        """
        self.other = other

    def as_dict(self) -> Dict[str, Any]:
        """Converts the SharedSet to a dictionary."""
        return {
            "other": self.other,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "SharedSet":
        """Creates a SharedSet from a dictionary."""
        kwargs: Dict[str, Any] = {
            "other": d["other"],
        }

        return SharedSet(**kwargs)

    def __repr__(self) -> str:
        result = "SharedSet("
        if self.other is not None:
            result += f"other={repr(self.other)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, SharedSet):
            return False
        attributes: list[str] = [
            "other",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BeaconStylePartOnly:
    """Attribute must be used as part of a Compound Beacon, never alone."""

    def __init__(self, value: PartOnly):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"partOnly": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BeaconStylePartOnly":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return BeaconStylePartOnly(PartOnly.from_dict(d["partOnly"]))

    def __repr__(self) -> str:
        return f"BeaconStylePartOnly(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BeaconStylePartOnly):
            return False
        return self.value == other.value


class BeaconStyleShared:
    """This beacon should calculate values like another beacon, so they can be
    compared.
    """

    def __init__(self, value: Shared):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"shared": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BeaconStyleShared":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return BeaconStyleShared(Shared.from_dict(d["shared"]))

    def __repr__(self) -> str:
        return f"BeaconStyleShared(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BeaconStyleShared):
            return False
        return self.value == other.value


class BeaconStyleAsSet:
    """Attribute must be a Set. Beacon value will also be a Set."""

    def __init__(self, value: AsSet):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"asSet": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BeaconStyleAsSet":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return BeaconStyleAsSet(AsSet.from_dict(d["asSet"]))

    def __repr__(self) -> str:
        return f"BeaconStyleAsSet(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BeaconStyleAsSet):
            return False
        return self.value == other.value


class BeaconStyleSharedSet:
    """Both Shared and AsSet."""

    def __init__(self, value: SharedSet):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"sharedSet": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BeaconStyleSharedSet":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return BeaconStyleSharedSet(SharedSet.from_dict(d["sharedSet"]))

    def __repr__(self) -> str:
        return f"BeaconStyleSharedSet(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BeaconStyleSharedSet):
            return False
        return self.value == other.value


class BeaconStyleUnknown:
    """Represents an unknown variant.

    If you receive this value, you will need to update your library to receive the
    parsed value.

    This value may not be deliberately sent.
    """

    def __init__(self, tag: str):
        self.tag = tag

    def as_dict(self) -> Dict[str, Any]:
        return {"SDK_UNKNOWN_MEMBER": {"name": self.tag}}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BeaconStyleUnknown":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")
        return BeaconStyleUnknown(d["SDK_UNKNOWN_MEMBER"]["name"])

    def __repr__(self) -> str:
        return f"BeaconStyleUnknown(tag={self.tag})"


BeaconStyle = Union[BeaconStylePartOnly, BeaconStyleShared, BeaconStyleAsSet, BeaconStyleSharedSet, BeaconStyleUnknown]


def _beacon_style_from_dict(d: Dict[str, Any]) -> BeaconStyle:
    if "partOnly" in d:
        return BeaconStylePartOnly.from_dict(d)

    if "shared" in d:
        return BeaconStyleShared.from_dict(d)

    if "asSet" in d:
        return BeaconStyleAsSet.from_dict(d)

    if "sharedSet" in d:
        return BeaconStyleSharedSet.from_dict(d)

    raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")


class ConstructorPart:
    name: str
    required: bool

    def __init__(
        self,
        *,
        name: str,
        required: bool,
    ):
        """A part of a Compound Becaon Construction.

        :param name: The name of the Encrypted Part or Signed Part for which this
        constructor part gets a value.
        :param required: Whether this Encrypted Part or Signed Part is required for this
        construction to succeed.
        """
        self.name = name
        self.required = required

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ConstructorPart to a dictionary."""
        return {
            "name": self.name,
            "required": self.required,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ConstructorPart":
        """Creates a ConstructorPart from a dictionary."""
        kwargs: Dict[str, Any] = {
            "name": d["name"],
            "required": d["required"],
        }

        return ConstructorPart(**kwargs)

    def __repr__(self) -> str:
        result = "ConstructorPart("
        if self.name is not None:
            result += f"name={repr(self.name)}, "

        if self.required is not None:
            result += f"required={repr(self.required)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ConstructorPart):
            return False
        attributes: list[str] = [
            "name",
            "required",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class Constructor:
    parts: list[ConstructorPart]

    def __init__(
        self,
        *,
        parts: list[ConstructorPart],
    ):
        """The configuration for a particular Compound Beacon construction.

        :param parts: The ordered list of parts for a particular Compound Beacon
        construction. If the item contains all required Parts, a Compound beacon will be
        written using each Part that exists on the item, in the order specified.
        """
        if (parts is not None) and (len(parts) < 1):
            raise ValueError("The size of parts must be greater than or equal to 1")

        self.parts = parts

    def as_dict(self) -> Dict[str, Any]:
        """Converts the Constructor to a dictionary."""
        return {
            "parts": _constructor_part_list_as_dict(self.parts),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "Constructor":
        """Creates a Constructor from a dictionary."""
        kwargs: Dict[str, Any] = {
            "parts": _constructor_part_list_from_dict(d["parts"]),
        }

        return Constructor(**kwargs)

    def __repr__(self) -> str:
        result = "Constructor("
        if self.parts is not None:
            result += f"parts={repr(self.parts)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, Constructor):
            return False
        attributes: list[str] = [
            "parts",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class EncryptedPart:
    name: str
    prefix: str

    def __init__(
        self,
        *,
        name: str,
        prefix: str,
    ):
        """A part of a Compound Beacon that contains a beacon over encrypted data.

        :param name: The name of the Standard Beacon, whose value this Part will hold.
        :param prefix: The prefix that is written with this Encrypted Part.
        """
        self.name = name
        if (prefix is not None) and (len(prefix) < 1):
            raise ValueError("The size of prefix must be greater than or equal to 1")

        self.prefix = prefix

    def as_dict(self) -> Dict[str, Any]:
        """Converts the EncryptedPart to a dictionary."""
        return {
            "name": self.name,
            "prefix": self.prefix,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "EncryptedPart":
        """Creates a EncryptedPart from a dictionary."""
        kwargs: Dict[str, Any] = {
            "name": d["name"],
            "prefix": d["prefix"],
        }

        return EncryptedPart(**kwargs)

    def __repr__(self) -> str:
        result = "EncryptedPart("
        if self.name is not None:
            result += f"name={repr(self.name)}, "

        if self.prefix is not None:
            result += f"prefix={repr(self.prefix)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, EncryptedPart):
            return False
        attributes: list[str] = [
            "name",
            "prefix",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class SignedPart:
    name: str
    prefix: str
    loc: Optional[str]

    def __init__(
        self,
        *,
        name: str,
        prefix: str,
        loc: Optional[str] = None,
    ):
        """A part of a Compound Beacon that contains signed plaintext data.

        :param name: The name for this Signed Part.
        :param prefix: The prefix that is written with this Signed Part.
        :param loc: The DynamoDB document path to the value for this Signed Part. If not
        provided, the 'name' is used for the location.
        """
        self.name = name
        if (prefix is not None) and (len(prefix) < 1):
            raise ValueError("The size of prefix must be greater than or equal to 1")

        self.prefix = prefix
        if (loc is not None) and (len(loc) < 1):
            raise ValueError("The size of loc must be greater than or equal to 1")

        self.loc = loc

    def as_dict(self) -> Dict[str, Any]:
        """Converts the SignedPart to a dictionary."""
        d: Dict[str, Any] = {
            "name": self.name,
            "prefix": self.prefix,
        }

        if self.loc is not None:
            d["loc"] = self.loc

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "SignedPart":
        """Creates a SignedPart from a dictionary."""
        kwargs: Dict[str, Any] = {
            "name": d["name"],
            "prefix": d["prefix"],
        }

        if "loc" in d:
            kwargs["loc"] = d["loc"]

        return SignedPart(**kwargs)

    def __repr__(self) -> str:
        result = "SignedPart("
        if self.name is not None:
            result += f"name={repr(self.name)}, "

        if self.prefix is not None:
            result += f"prefix={repr(self.prefix)}, "

        if self.loc is not None:
            result += f"loc={repr(self.loc)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, SignedPart):
            return False
        attributes: list[str] = [
            "name",
            "prefix",
            "loc",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class CompoundBeacon:
    name: str
    split: str
    encrypted: Optional[list[EncryptedPart]]
    signed: Optional[list[SignedPart]]
    constructors: Optional[list[Constructor]]

    def __init__(
        self,
        *,
        name: str,
        split: str,
        encrypted: Optional[list[EncryptedPart]] = None,
        signed: Optional[list[SignedPart]] = None,
        constructors: Optional[list[Constructor]] = None,
    ):
        """The configuration for a Compound Beacon.

        :param name: The name of the Compound Beacon.
        :param split: The characters used to split parts of a compound beacon. The split
        character should be a character that does not appear in any Signed Part or
        Prefix used by the Compound Beacon.
        :param encrypted: The list of Encrypted Parts that may be included in the
        compound beacon.
        :param signed: The list of Signed Parts that may be included in the compound
        beacon.
        :param constructors: The ordered list of constructors that may be used to create
        the Compound Beacon. Each constructor is checked, in order, to see if it can
        construct the beacon. The first constructor that can construct the beacon is
        used. If no constructor can construct the beacon, the Compound Beacon is not
        written to the item.
        """
        self.name = name
        if (split is not None) and (len(split) < 1):
            raise ValueError("The size of split must be greater than or equal to 1")

        if (split is not None) and (len(split) > 1):
            raise ValueError("The size of split must be less than or equal to 1")

        self.split = split
        if (encrypted is not None) and (len(encrypted) < 1):
            raise ValueError("The size of encrypted must be greater than or equal to 1")

        self.encrypted = encrypted
        if (signed is not None) and (len(signed) < 1):
            raise ValueError("The size of signed must be greater than or equal to 1")

        self.signed = signed
        if (constructors is not None) and (len(constructors) < 1):
            raise ValueError("The size of constructors must be greater than or equal to 1")

        self.constructors = constructors

    def as_dict(self) -> Dict[str, Any]:
        """Converts the CompoundBeacon to a dictionary."""
        d: Dict[str, Any] = {
            "name": self.name,
            "split": self.split,
        }

        if self.encrypted is not None:
            d["encrypted"] = (_encrypted_parts_list_as_dict(self.encrypted),)

        if self.signed is not None:
            d["signed"] = (_signed_parts_list_as_dict(self.signed),)

        if self.constructors is not None:
            d["constructors"] = (_constructor_list_as_dict(self.constructors),)

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "CompoundBeacon":
        """Creates a CompoundBeacon from a dictionary."""
        kwargs: Dict[str, Any] = {
            "name": d["name"],
            "split": d["split"],
        }

        if "encrypted" in d:
            kwargs["encrypted"] = (_encrypted_parts_list_from_dict(d["encrypted"]),)

        if "signed" in d:
            kwargs["signed"] = (_signed_parts_list_from_dict(d["signed"]),)

        if "constructors" in d:
            kwargs["constructors"] = (_constructor_list_from_dict(d["constructors"]),)

        return CompoundBeacon(**kwargs)

    def __repr__(self) -> str:
        result = "CompoundBeacon("
        if self.name is not None:
            result += f"name={repr(self.name)}, "

        if self.split is not None:
            result += f"split={repr(self.split)}, "

        if self.encrypted is not None:
            result += f"encrypted={repr(self.encrypted)}, "

        if self.signed is not None:
            result += f"signed={repr(self.signed)}, "

        if self.constructors is not None:
            result += f"constructors={repr(self.constructors)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, CompoundBeacon):
            return False
        attributes: list[str] = [
            "name",
            "split",
            "encrypted",
            "signed",
            "constructors",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class StandardBeacon:
    name: str
    length: int
    loc: Optional[str]
    style: Optional[BeaconStyle]

    def __init__(
        self,
        *,
        name: str,
        length: int = 0,
        loc: Optional[str] = None,
        style: Optional[BeaconStyle] = None,
    ):
        """The configuration for a Standard Beacon.

        :param name: The name for this Standard Beacon.
        :param length: The length of the calculated beacon.
        :param loc: The DynamoDB document path to the value this beacon will calculate
        over. If not specified, the beacon will calculate values for the attribute with
        the name specified in 'name'.
        :param style: Optional augmented behavior.
        """
        self.name = name
        if (length is not None) and (length < 1):
            raise ValueError("length must be greater than or equal to 1")

        if (length is not None) and (length > 63):
            raise ValueError("length must be less than or equal to 63")

        self.length = length
        if (loc is not None) and (len(loc) < 1):
            raise ValueError("The size of loc must be greater than or equal to 1")

        self.loc = loc
        self.style = style

    def as_dict(self) -> Dict[str, Any]:
        """Converts the StandardBeacon to a dictionary."""
        d: Dict[str, Any] = {
            "name": self.name,
        }

        if self.length is not None:
            d["length"] = self.length

        if self.loc is not None:
            d["loc"] = self.loc

        if self.style is not None:
            d["style"] = self.style.as_dict()

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "StandardBeacon":
        """Creates a StandardBeacon from a dictionary."""
        kwargs: Dict[str, Any] = {
            "name": d["name"],
        }

        if "length" in d:
            kwargs["length"] = d["length"]

        if "loc" in d:
            kwargs["loc"] = d["loc"]

        if "style" in d:
            kwargs["style"] = (_beacon_style_from_dict(d["style"]),)

        return StandardBeacon(**kwargs)

    def __repr__(self) -> str:
        result = "StandardBeacon("
        if self.name is not None:
            result += f"name={repr(self.name)}, "

        if self.length is not None:
            result += f"length={repr(self.length)}, "

        if self.loc is not None:
            result += f"loc={repr(self.loc)}, "

        if self.style is not None:
            result += f"style={repr(self.style)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, StandardBeacon):
            return False
        attributes: list[str] = [
            "name",
            "length",
            "loc",
            "style",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class Insert:
    literal: str

    def __init__(
        self,
        *,
        literal: str,
    ):
        """The Virtual Part Transformation that appends a literal string.

        :param literal: The literal string to append.
        """
        self.literal = literal

    def as_dict(self) -> Dict[str, Any]:
        """Converts the Insert to a dictionary."""
        return {
            "literal": self.literal,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "Insert":
        """Creates a Insert from a dictionary."""
        kwargs: Dict[str, Any] = {
            "literal": d["literal"],
        }

        return Insert(**kwargs)

    def __repr__(self) -> str:
        result = "Insert("
        if self.literal is not None:
            result += f"literal={repr(self.literal)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, Insert):
            return False
        attributes: list[str] = [
            "literal",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class Lower:
    """The Virtual Part Transformation that converts ASCII characters to lower case."""

    def as_dict(self) -> Dict[str, Any]:
        """Converts the Lower to a dictionary."""
        return {}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "Lower":
        """Creates a Lower from a dictionary."""
        return Lower()

    def __repr__(self) -> str:
        result = "Lower("

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        return isinstance(other, Lower)


class GetPrefix:
    length: int

    def __init__(
        self,
        *,
        length: int,
    ):
        """The Virtual Part Transformation that gets the prefix of a string.

        :param length: If positive, the number of characters to return from the front.
        If negative, the absolute number of characters to exclude from the end. e.g.
        GetPrefix(-1) returns all but the last character.
        """
        self.length = length

    def as_dict(self) -> Dict[str, Any]:
        """Converts the GetPrefix to a dictionary."""
        return {
            "length": self.length,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetPrefix":
        """Creates a GetPrefix from a dictionary."""
        kwargs: Dict[str, Any] = {
            "length": d["length"],
        }

        return GetPrefix(**kwargs)

    def __repr__(self) -> str:
        result = "GetPrefix("
        if self.length is not None:
            result += f"length={repr(self.length)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetPrefix):
            return False
        attributes: list[str] = [
            "length",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class GetSegment:
    split: str
    index: int

    def __init__(
        self,
        *,
        split: str,
        index: int,
    ):
        """The Virtual Part Transformation that splits a string and gets a particular
        segment of that split.

        :param split: The characters to split on.
        :param index: The index of the split string result to return. 0 represents the
        segment before the first split character. -1 respresents the segment after the
        last split character.
        """
        if (split is not None) and (len(split) < 1):
            raise ValueError("The size of split must be greater than or equal to 1")

        if (split is not None) and (len(split) > 1):
            raise ValueError("The size of split must be less than or equal to 1")

        self.split = split
        self.index = index

    def as_dict(self) -> Dict[str, Any]:
        """Converts the GetSegment to a dictionary."""
        return {
            "split": self.split,
            "index": self.index,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetSegment":
        """Creates a GetSegment from a dictionary."""
        kwargs: Dict[str, Any] = {
            "split": d["split"],
            "index": d["index"],
        }

        return GetSegment(**kwargs)

    def __repr__(self) -> str:
        result = "GetSegment("
        if self.split is not None:
            result += f"split={repr(self.split)}, "

        if self.index is not None:
            result += f"index={repr(self.index)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetSegment):
            return False
        attributes: list[str] = [
            "split",
            "index",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class GetSegments:
    split: str
    low: int
    high: int

    def __init__(
        self,
        *,
        split: str,
        low: int,
        high: int,
    ):
        """The Virtual Part Transformation that splits a string and gets a range of
        segments of that split.

        :param split: The characters to split on.
        :param low: The index to start the segments from, inclusive. Negative numbers
        count from the end. -1 is the last segment.
        :param high: The index to stop the segments at, exclusive. Negative numbers
        count from the end. -1 is the last segment.
        """
        if (split is not None) and (len(split) < 1):
            raise ValueError("The size of split must be greater than or equal to 1")

        if (split is not None) and (len(split) > 1):
            raise ValueError("The size of split must be less than or equal to 1")

        self.split = split
        self.low = low
        self.high = high

    def as_dict(self) -> Dict[str, Any]:
        """Converts the GetSegments to a dictionary."""
        return {
            "split": self.split,
            "low": self.low,
            "high": self.high,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetSegments":
        """Creates a GetSegments from a dictionary."""
        kwargs: Dict[str, Any] = {
            "split": d["split"],
            "low": d["low"],
            "high": d["high"],
        }

        return GetSegments(**kwargs)

    def __repr__(self) -> str:
        result = "GetSegments("
        if self.split is not None:
            result += f"split={repr(self.split)}, "

        if self.low is not None:
            result += f"low={repr(self.low)}, "

        if self.high is not None:
            result += f"high={repr(self.high)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetSegments):
            return False
        attributes: list[str] = [
            "split",
            "low",
            "high",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class GetSubstring:
    low: int
    high: int

    def __init__(
        self,
        *,
        low: int,
        high: int,
    ):
        """The Virtual Part Transformation that gets a substring from a string.

        :param low: The index to start the substring from, inclusive. Negative numbers
        count from the end. -1 is the last character of a string.
        :param high: The index to stop the substring at, exclusive. Negative numbers
        count from the end. -1 is the last character of a string.
        """
        self.low = low
        self.high = high

    def as_dict(self) -> Dict[str, Any]:
        """Converts the GetSubstring to a dictionary."""
        return {
            "low": self.low,
            "high": self.high,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetSubstring":
        """Creates a GetSubstring from a dictionary."""
        kwargs: Dict[str, Any] = {
            "low": d["low"],
            "high": d["high"],
        }

        return GetSubstring(**kwargs)

    def __repr__(self) -> str:
        result = "GetSubstring("
        if self.low is not None:
            result += f"low={repr(self.low)}, "

        if self.high is not None:
            result += f"high={repr(self.high)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetSubstring):
            return False
        attributes: list[str] = [
            "low",
            "high",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class GetSuffix:
    length: int

    def __init__(
        self,
        *,
        length: int,
    ):
        """The Virtual Part Transformation that gets the suffix of a string.

        :param length: If positive, the number of characters to return from the end. If
        negative, the absolute number of characters to exclude from the front. e.g.
        GetSuffix(-1) returns all but the first character.
        """
        self.length = length

    def as_dict(self) -> Dict[str, Any]:
        """Converts the GetSuffix to a dictionary."""
        return {
            "length": self.length,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetSuffix":
        """Creates a GetSuffix from a dictionary."""
        kwargs: Dict[str, Any] = {
            "length": d["length"],
        }

        return GetSuffix(**kwargs)

    def __repr__(self) -> str:
        result = "GetSuffix("
        if self.length is not None:
            result += f"length={repr(self.length)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetSuffix):
            return False
        attributes: list[str] = [
            "length",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class Upper:
    """The Virtual Part Transformation that converts ASCII characters to upper case."""

    def as_dict(self) -> Dict[str, Any]:
        """Converts the Upper to a dictionary."""
        return {}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "Upper":
        """Creates a Upper from a dictionary."""
        return Upper()

    def __repr__(self) -> str:
        result = "Upper("

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        return isinstance(other, Upper)


class VirtualTransformUpper:
    """The Virtual Part Transformation that converts ASCII characters to upper case."""

    def __init__(self, value: Upper):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"upper": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "VirtualTransformUpper":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return VirtualTransformUpper(Upper.from_dict(d["upper"]))

    def __repr__(self) -> str:
        return f"VirtualTransformUpper(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, VirtualTransformUpper):
            return False
        return self.value == other.value


class VirtualTransformLower:
    """The Virtual Part Transformation that converts ASCII characters to lower case."""

    def __init__(self, value: Lower):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"lower": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "VirtualTransformLower":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return VirtualTransformLower(Lower.from_dict(d["lower"]))

    def __repr__(self) -> str:
        return f"VirtualTransformLower(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, VirtualTransformLower):
            return False
        return self.value == other.value


class VirtualTransformInsert:
    """The Virtual Part Transformation that appends a literal string."""

    def __init__(self, value: Insert):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"insert": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "VirtualTransformInsert":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return VirtualTransformInsert(Insert.from_dict(d["insert"]))

    def __repr__(self) -> str:
        return f"VirtualTransformInsert(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, VirtualTransformInsert):
            return False
        return self.value == other.value


class VirtualTransformPrefix:
    """The Virtual Part Transformation that gets the prefix of a string."""

    def __init__(self, value: GetPrefix):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"prefix": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "VirtualTransformPrefix":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return VirtualTransformPrefix(GetPrefix.from_dict(d["prefix"]))

    def __repr__(self) -> str:
        return f"VirtualTransformPrefix(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, VirtualTransformPrefix):
            return False
        return self.value == other.value


class VirtualTransformSuffix:
    """The Virtual Part Transformation that gets the suffix of a string."""

    def __init__(self, value: GetSuffix):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"suffix": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "VirtualTransformSuffix":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return VirtualTransformSuffix(GetSuffix.from_dict(d["suffix"]))

    def __repr__(self) -> str:
        return f"VirtualTransformSuffix(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, VirtualTransformSuffix):
            return False
        return self.value == other.value


class VirtualTransformSubstring:
    """The Virtual Part Transformation that gets a substring from a string."""

    def __init__(self, value: GetSubstring):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"substring": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "VirtualTransformSubstring":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return VirtualTransformSubstring(GetSubstring.from_dict(d["substring"]))

    def __repr__(self) -> str:
        return f"VirtualTransformSubstring(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, VirtualTransformSubstring):
            return False
        return self.value == other.value


class VirtualTransformSegment:
    """The Virtual Part Transformation that splits a string and gets a particular
    segment of that split.
    """

    def __init__(self, value: GetSegment):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"segment": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "VirtualTransformSegment":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return VirtualTransformSegment(GetSegment.from_dict(d["segment"]))

    def __repr__(self) -> str:
        return f"VirtualTransformSegment(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, VirtualTransformSegment):
            return False
        return self.value == other.value


class VirtualTransformSegments:
    """The Virtual Part Transformation that splits a string and gets a range of
    segments of that split.
    """

    def __init__(self, value: GetSegments):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"segments": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "VirtualTransformSegments":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return VirtualTransformSegments(GetSegments.from_dict(d["segments"]))

    def __repr__(self) -> str:
        return f"VirtualTransformSegments(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, VirtualTransformSegments):
            return False
        return self.value == other.value


class VirtualTransformUnknown:
    """Represents an unknown variant.

    If you receive this value, you will need to update your library to receive the
    parsed value.

    This value may not be deliberately sent.
    """

    def __init__(self, tag: str):
        self.tag = tag

    def as_dict(self) -> Dict[str, Any]:
        return {"SDK_UNKNOWN_MEMBER": {"name": self.tag}}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "VirtualTransformUnknown":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")
        return VirtualTransformUnknown(d["SDK_UNKNOWN_MEMBER"]["name"])

    def __repr__(self) -> str:
        return f"VirtualTransformUnknown(tag={self.tag})"


VirtualTransform = Union[
    VirtualTransformUpper,
    VirtualTransformLower,
    VirtualTransformInsert,
    VirtualTransformPrefix,
    VirtualTransformSuffix,
    VirtualTransformSubstring,
    VirtualTransformSegment,
    VirtualTransformSegments,
    VirtualTransformUnknown,
]


def _virtual_transform_from_dict(d: Dict[str, Any]) -> VirtualTransform:
    if "upper" in d:
        return VirtualTransformUpper.from_dict(d)

    if "lower" in d:
        return VirtualTransformLower.from_dict(d)

    if "insert" in d:
        return VirtualTransformInsert.from_dict(d)

    if "prefix" in d:
        return VirtualTransformPrefix.from_dict(d)

    if "suffix" in d:
        return VirtualTransformSuffix.from_dict(d)

    if "substring" in d:
        return VirtualTransformSubstring.from_dict(d)

    if "segment" in d:
        return VirtualTransformSegment.from_dict(d)

    if "segments" in d:
        return VirtualTransformSegments.from_dict(d)

    raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")


class VirtualPart:
    loc: str
    trans: Optional[list[VirtualTransform]]

    def __init__(
        self,
        *,
        loc: str,
        trans: Optional[list[VirtualTransform]] = None,
    ):
        """A Virtual Part is the configuration of a transformation on an existing field in
        an item.

        :param loc: The DynamoDB document path to the value for this part.
        :param trans: A list of transformations performed on the value for this part.
        """
        if (loc is not None) and (len(loc) < 1):
            raise ValueError("The size of loc must be greater than or equal to 1")

        self.loc = loc
        if (trans is not None) and (len(trans) < 1):
            raise ValueError("The size of trans must be greater than or equal to 1")

        self.trans = trans

    def as_dict(self) -> Dict[str, Any]:
        """Converts the VirtualPart to a dictionary."""
        d: Dict[str, Any] = {
            "loc": self.loc,
        }

        if self.trans is not None:
            d["trans"] = (_virtual_transform_list_as_dict(self.trans),)

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "VirtualPart":
        """Creates a VirtualPart from a dictionary."""
        kwargs: Dict[str, Any] = {
            "loc": d["loc"],
        }

        if "trans" in d:
            kwargs["trans"] = (_virtual_transform_list_from_dict(d["trans"]),)

        return VirtualPart(**kwargs)

    def __repr__(self) -> str:
        result = "VirtualPart("
        if self.loc is not None:
            result += f"loc={repr(self.loc)}, "

        if self.trans is not None:
            result += f"trans={repr(self.trans)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, VirtualPart):
            return False
        attributes: list[str] = [
            "loc",
            "trans",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class VirtualField:
    name: str
    parts: list[VirtualPart]

    def __init__(
        self,
        *,
        name: str,
        parts: list[VirtualPart],
    ):
        """The configuration for a Virtual Field. A Virtual Field is a field constructed
        from parts of other fields for use with beacons, but never itself stored on
        items.

        :param name: The name of the Virtual Field.
        :param parts: The list of ordered parts that make up a Virtual Field.
        """
        self.name = name
        if (parts is not None) and (len(parts) < 1):
            raise ValueError("The size of parts must be greater than or equal to 1")

        self.parts = parts

    def as_dict(self) -> Dict[str, Any]:
        """Converts the VirtualField to a dictionary."""
        return {
            "name": self.name,
            "parts": _virtual_part_list_as_dict(self.parts),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "VirtualField":
        """Creates a VirtualField from a dictionary."""
        kwargs: Dict[str, Any] = {
            "name": d["name"],
            "parts": _virtual_part_list_from_dict(d["parts"]),
        }

        return VirtualField(**kwargs)

    def __repr__(self) -> str:
        result = "VirtualField("
        if self.name is not None:
            result += f"name={repr(self.name)}, "

        if self.parts is not None:
            result += f"parts={repr(self.parts)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, VirtualField):
            return False
        attributes: list[str] = [
            "name",
            "parts",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BeaconVersion:
    version: int
    key_store: "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_keystore.client.KeyStore"
    key_source: BeaconKeySource
    standard_beacons: list[StandardBeacon]
    compound_beacons: Optional[list[CompoundBeacon]]
    virtual_fields: Optional[list[VirtualField]]
    encrypted_parts: Optional[list[EncryptedPart]]
    signed_parts: Optional[list[SignedPart]]

    def __init__(
        self,
        *,
        key_store: "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_keystore.client.KeyStore",
        key_source: BeaconKeySource,
        standard_beacons: list[StandardBeacon],
        version: int = 0,
        compound_beacons: Optional[list[CompoundBeacon]] = None,
        virtual_fields: Optional[list[VirtualField]] = None,
        encrypted_parts: Optional[list[EncryptedPart]] = None,
        signed_parts: Optional[list[SignedPart]] = None,
    ):
        """The configuration for a particular version of searchable encryption. Currently
        the only supported version is '1'.

        :param key_store: The Key Store that contains the Beacon Keys to use with
        searchable encryption.
        :param key_source: The configuration for what beacon key(s) to use.
        :param standard_beacons: The Standard Beacons to be written with items.
        :param version: The version of searchable encryption configured. This must be
        '1'.
        :param compound_beacons: The Compound Beacons to be written with items.
        :param virtual_fields: The Virtual Fields to be calculated, supporting other
        searchable enryption configurations.
        :param encrypted_parts: The list of Encrypted Parts that may be included in any
        compound beacon.
        :param signed_parts: The list of Signed Parts that may be included in any
        compound beacon.
        """
        self.key_store = key_store
        self.key_source = key_source
        if (standard_beacons is not None) and (len(standard_beacons) < 1):
            raise ValueError("The size of standard_beacons must be greater than or equal to 1")

        self.standard_beacons = standard_beacons
        if (version is not None) and (version < 1):
            raise ValueError("version must be greater than or equal to 1")

        self.version = version
        if (compound_beacons is not None) and (len(compound_beacons) < 1):
            raise ValueError("The size of compound_beacons must be greater than or equal to 1")

        self.compound_beacons = compound_beacons
        if (virtual_fields is not None) and (len(virtual_fields) < 1):
            raise ValueError("The size of virtual_fields must be greater than or equal to 1")

        self.virtual_fields = virtual_fields
        if (encrypted_parts is not None) and (len(encrypted_parts) < 1):
            raise ValueError("The size of encrypted_parts must be greater than or equal to 1")

        self.encrypted_parts = encrypted_parts
        if (signed_parts is not None) and (len(signed_parts) < 1):
            raise ValueError("The size of signed_parts must be greater than or equal to 1")

        self.signed_parts = signed_parts

    def as_dict(self) -> Dict[str, Any]:
        """Converts the BeaconVersion to a dictionary."""
        d: Dict[str, Any] = {
            "key_store": self.key_store.as_dict(),
            "key_source": self.key_source.as_dict(),
            "standard_beacons": _standard_beacon_list_as_dict(self.standard_beacons),
        }

        if self.version is not None:
            d["version"] = self.version

        if self.compound_beacons is not None:
            d["compound_beacons"] = (_compound_beacon_list_as_dict(self.compound_beacons),)

        if self.virtual_fields is not None:
            d["virtual_fields"] = (_virtual_field_list_as_dict(self.virtual_fields),)

        if self.encrypted_parts is not None:
            d["encrypted_parts"] = (_encrypted_parts_list_as_dict(self.encrypted_parts),)

        if self.signed_parts is not None:
            d["signed_parts"] = (_signed_parts_list_as_dict(self.signed_parts),)

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BeaconVersion":
        """Creates a BeaconVersion from a dictionary."""
        from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_keystore.client import KeyStore

        kwargs: Dict[str, Any] = {
            "key_store": KeyStore.from_dict(d["key_store"]),
            "key_source": _beacon_key_source_from_dict(d["key_source"]),
            "standard_beacons": _standard_beacon_list_from_dict(d["standard_beacons"]),
        }

        if "version" in d:
            kwargs["version"] = d["version"]

        if "compound_beacons" in d:
            kwargs["compound_beacons"] = (_compound_beacon_list_from_dict(d["compound_beacons"]),)

        if "virtual_fields" in d:
            kwargs["virtual_fields"] = (_virtual_field_list_from_dict(d["virtual_fields"]),)

        if "encrypted_parts" in d:
            kwargs["encrypted_parts"] = (_encrypted_parts_list_from_dict(d["encrypted_parts"]),)

        if "signed_parts" in d:
            kwargs["signed_parts"] = (_signed_parts_list_from_dict(d["signed_parts"]),)

        return BeaconVersion(**kwargs)

    def __repr__(self) -> str:
        result = "BeaconVersion("
        if self.version is not None:
            result += f"version={repr(self.version)}, "

        if self.key_store is not None:
            result += f"key_store={repr(self.key_store)}, "

        if self.key_source is not None:
            result += f"key_source={repr(self.key_source)}, "

        if self.standard_beacons is not None:
            result += f"standard_beacons={repr(self.standard_beacons)}, "

        if self.compound_beacons is not None:
            result += f"compound_beacons={repr(self.compound_beacons)}, "

        if self.virtual_fields is not None:
            result += f"virtual_fields={repr(self.virtual_fields)}, "

        if self.encrypted_parts is not None:
            result += f"encrypted_parts={repr(self.encrypted_parts)}, "

        if self.signed_parts is not None:
            result += f"signed_parts={repr(self.signed_parts)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BeaconVersion):
            return False
        attributes: list[str] = [
            "version",
            "key_store",
            "key_source",
            "standard_beacons",
            "compound_beacons",
            "virtual_fields",
            "encrypted_parts",
            "signed_parts",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class LegacyPolicy:
    FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT = "FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT"

    FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT = "FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT"

    FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT = "FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT"

    # This set contains every possible value known at the time this was generated. New
    # values may be added in the future.
    values = frozenset(
        {
            "FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT",
            "FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT",
            "FORBID_LEGACY_ENCRYPT_FORBID_LEGACY_DECRYPT",
        }
    )


class LegacyOverride:
    policy: str
    encryptor: "aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.references.LegacyDynamoDbEncryptor"
    attribute_actions_on_encrypt: dict[str, str]
    default_attribute_flag: Optional[str]

    def __init__(
        self,
        *,
        policy: str,
        encryptor: "aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.references.LegacyDynamoDbEncryptor",
        attribute_actions_on_encrypt: dict[str, str],
        default_attribute_flag: Optional[str] = None,
    ):
        """A configuration for overriding encryption and/or decryption to instead perform
        legacy encryption and decryption.

        :param policy: A policy which configurates whether legacy behavior overrides
        encryption and/or decryption.
        :param encryptor: A configuration for the legacy DynamoDB Encryption Client's
        Encryptor.
        :param attribute_actions_on_encrypt: Overrides which attributes are encrypted
        and/or signed for any items read or written with legacy behavior.
        :param default_attribute_flag: This input is not used in the Java Client and
        should not be specified.
        """
        self.policy = policy
        self.encryptor = encryptor
        self.attribute_actions_on_encrypt = attribute_actions_on_encrypt
        self.default_attribute_flag = default_attribute_flag

    def as_dict(self) -> Dict[str, Any]:
        """Converts the LegacyOverride to a dictionary."""
        d: Dict[str, Any] = {
            "policy": self.policy,
            "encryptor": self.encryptor.as_dict(),
            "attribute_actions_on_encrypt": self.attribute_actions_on_encrypt,
        }

        if self.default_attribute_flag is not None:
            d["default_attribute_flag"] = self.default_attribute_flag

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "LegacyOverride":
        """Creates a LegacyOverride from a dictionary."""
        from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.references import (
            LegacyDynamoDbEncryptor,
        )

        kwargs: Dict[str, Any] = {
            "policy": d["policy"],
            "encryptor": LegacyDynamoDbEncryptor.from_dict(d["encryptor"]),
            "attribute_actions_on_encrypt": d["attribute_actions_on_encrypt"],
        }

        if "default_attribute_flag" in d:
            kwargs["default_attribute_flag"] = d["default_attribute_flag"]

        return LegacyOverride(**kwargs)

    def __repr__(self) -> str:
        result = "LegacyOverride("
        if self.policy is not None:
            result += f"policy={repr(self.policy)}, "

        if self.encryptor is not None:
            result += f"encryptor={repr(self.encryptor)}, "

        if self.attribute_actions_on_encrypt is not None:
            result += f"attribute_actions_on_encrypt={repr(self.attribute_actions_on_encrypt)}, "

        if self.default_attribute_flag is not None:
            result += f"default_attribute_flag={repr(self.default_attribute_flag)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, LegacyOverride):
            return False
        attributes: list[str] = [
            "policy",
            "encryptor",
            "attribute_actions_on_encrypt",
            "default_attribute_flag",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class PlaintextOverride:
    FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ = "FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ"

    FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ = "FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ"

    FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ = "FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ"

    # This set contains every possible value known at the time this was generated. New
    # values may be added in the future.
    values = frozenset(
        {
            "FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ",
            "FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ",
            "FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ",
        }
    )


class SearchConfig:
    versions: list[BeaconVersion]
    write_version: int

    def __init__(
        self,
        *,
        versions: list[BeaconVersion],
        write_version: int = 0,
    ):
        """The configuration for searchable encryption.

        :param versions: The versions of searchable encryption to support reading.
        Currently must contain a single configuration with version '1'.
        :param write_version: The searchable encryption version to use when writing new
        items. Must be '1'.
        """
        if (versions is not None) and (len(versions) < 1):
            raise ValueError("The size of versions must be greater than or equal to 1")

        if (versions is not None) and (len(versions) > 1):
            raise ValueError("The size of versions must be less than or equal to 1")

        self.versions = versions
        if (write_version is not None) and (write_version < 1):
            raise ValueError("write_version must be greater than or equal to 1")

        self.write_version = write_version

    def as_dict(self) -> Dict[str, Any]:
        """Converts the SearchConfig to a dictionary."""
        d: Dict[str, Any] = {
            "versions": _beacon_version_list_as_dict(self.versions),
        }

        if self.write_version is not None:
            d["write_version"] = self.write_version

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "SearchConfig":
        """Creates a SearchConfig from a dictionary."""
        kwargs: Dict[str, Any] = {
            "versions": _beacon_version_list_from_dict(d["versions"]),
        }

        if "write_version" in d:
            kwargs["write_version"] = d["write_version"]

        return SearchConfig(**kwargs)

    def __repr__(self) -> str:
        result = "SearchConfig("
        if self.versions is not None:
            result += f"versions={repr(self.versions)}, "

        if self.write_version is not None:
            result += f"write_version={repr(self.write_version)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, SearchConfig):
            return False
        attributes: list[str] = [
            "versions",
            "write_version",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class DynamoDbTableEncryptionConfig:
    logical_table_name: str
    partition_key_name: str
    sort_key_name: Optional[str]
    search: Optional[SearchConfig]
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
        search: Optional[SearchConfig] = None,
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
        """The configuration for client-side encryption for a particular DynamoDB table.

        :param logical_table_name: The logical table name for this table. This is the
        name that is cryptographically bound with your data. This can be the same as the
        actual DynamoDB table name. It's purpose is to be distinct from the DynamoDB
        table name so that the data may still be authenticated if being read from
        different (but logically similar) tables, such as a backup table.
        :param partition_key_name: The name of the partition key on this table.
        :param attribute_actions_on_encrypt: A map that describes what attributes should
        be encrypted and/or signed on encrypt. This map must contain all attributes that
        might be encountered during encryption.
        :param sort_key_name: If this table contains a sort key, the name of the sort
        key on this table.
        :param search: The configuration for searchable encryption.
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
        self.search = search
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
        """Converts the DynamoDbTableEncryptionConfig to a dictionary."""
        d: Dict[str, Any] = {
            "logical_table_name": self.logical_table_name,
            "partition_key_name": self.partition_key_name,
            "attribute_actions_on_encrypt": self.attribute_actions_on_encrypt,
        }

        if self.sort_key_name is not None:
            d["sort_key_name"] = self.sort_key_name

        if self.search is not None:
            d["search"] = self.search.as_dict()

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
    def from_dict(d: Dict[str, Any]) -> "DynamoDbTableEncryptionConfig":
        """Creates a DynamoDbTableEncryptionConfig from a dictionary."""
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

        if "search" in d:
            kwargs["search"] = SearchConfig.from_dict(d["search"])

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

        return DynamoDbTableEncryptionConfig(**kwargs)

    def __repr__(self) -> str:
        result = "DynamoDbTableEncryptionConfig("
        if self.logical_table_name is not None:
            result += f"logical_table_name={repr(self.logical_table_name)}, "

        if self.partition_key_name is not None:
            result += f"partition_key_name={repr(self.partition_key_name)}, "

        if self.sort_key_name is not None:
            result += f"sort_key_name={repr(self.sort_key_name)}, "

        if self.search is not None:
            result += f"search={repr(self.search)}, "

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
        if not isinstance(other, DynamoDbTableEncryptionConfig):
            return False
        attributes: list[str] = [
            "logical_table_name",
            "partition_key_name",
            "sort_key_name",
            "search",
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


class DynamoDbTablesEncryptionConfig:
    table_encryption_configs: dict[str, DynamoDbTableEncryptionConfig]

    def __init__(
        self,
        *,
        table_encryption_configs: dict[str, DynamoDbTableEncryptionConfig],
    ):
        """The configuration for client-side encryption with multiple DynamoDB table.

        :param table_encryption_configs: A map of DynamoDB table name to its
        configuration for client-side encryption.
        """
        self.table_encryption_configs = table_encryption_configs

    def as_dict(self) -> Dict[str, Any]:
        """Converts the DynamoDbTablesEncryptionConfig to a dictionary."""
        return {
            "table_encryption_configs": _dynamo_db_table_encryption_config_list_as_dict(self.table_encryption_configs),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "DynamoDbTablesEncryptionConfig":
        """Creates a DynamoDbTablesEncryptionConfig from a dictionary."""
        kwargs: Dict[str, Any] = {
            "table_encryption_configs": _dynamo_db_table_encryption_config_list_from_dict(
                d["table_encryption_configs"]
            ),
        }

        return DynamoDbTablesEncryptionConfig(**kwargs)

    def __repr__(self) -> str:
        result = "DynamoDbTablesEncryptionConfig("
        if self.table_encryption_configs is not None:
            result += f"table_encryption_configs={repr(self.table_encryption_configs)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, DynamoDbTablesEncryptionConfig):
            return False
        attributes: list[str] = [
            "table_encryption_configs",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


def _encrypted_data_key_description_list_as_dict(given: list[EncryptedDataKeyDescription]) -> List[Any]:
    return [v.as_dict() for v in given]


def _encrypted_data_key_description_list_from_dict(given: List[Any]) -> list[EncryptedDataKeyDescription]:
    return [EncryptedDataKeyDescription.from_dict(v) for v in given]


class Unit:
    pass
