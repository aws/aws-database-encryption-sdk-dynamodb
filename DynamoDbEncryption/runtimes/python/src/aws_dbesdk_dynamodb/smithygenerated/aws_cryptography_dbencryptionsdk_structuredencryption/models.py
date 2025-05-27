# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references
from typing import Any, Dict, List, Optional, Union

from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.models import (
    EncryptedDataKey,
)


class AuthenticateAction:
    SIGN = "SIGN"

    DO_NOT_SIGN = "DO_NOT_SIGN"

    # This set contains every possible value known at the time this was generated. New
    # values may be added in the future.
    values = frozenset({"SIGN", "DO_NOT_SIGN"})


class StructuredDataTerminal:
    value: bytes | bytearray
    type_id: bytes | bytearray

    def __init__(
        self,
        *,
        value: bytes | bytearray,
        type_id: bytes | bytearray,
    ):
        self.value = value
        if (type_id is not None) and (len(type_id) < 2):
            raise ValueError("The size of type_id must be greater than or equal to 2")

        if (type_id is not None) and (len(type_id) > 2):
            raise ValueError("The size of type_id must be less than or equal to 2")

        self.type_id = type_id

    def as_dict(self) -> Dict[str, Any]:
        """Converts the StructuredDataTerminal to a dictionary."""
        return {
            "value": self.value,
            "type_id": self.type_id,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "StructuredDataTerminal":
        """Creates a StructuredDataTerminal from a dictionary."""
        kwargs: Dict[str, Any] = {
            "value": d["value"],
            "type_id": d["type_id"],
        }

        return StructuredDataTerminal(**kwargs)

    def __repr__(self) -> str:
        result = "StructuredDataTerminal("
        if self.value is not None:
            result += f"value={repr(self.value)}, "

        if self.type_id is not None:
            result += f"type_id={repr(self.type_id)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, StructuredDataTerminal):
            return False
        attributes: list[str] = [
            "value",
            "type_id",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class StructureSegment:
    key: str

    def __init__(
        self,
        *,
        key: str,
    ):
        self.key = key

    def as_dict(self) -> Dict[str, Any]:
        """Converts the StructureSegment to a dictionary."""
        return {
            "key": self.key,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "StructureSegment":
        """Creates a StructureSegment from a dictionary."""
        kwargs: Dict[str, Any] = {
            "key": d["key"],
        }

        return StructureSegment(**kwargs)

    def __repr__(self) -> str:
        result = "StructureSegment("
        if self.key is not None:
            result += f"key={repr(self.key)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, StructureSegment):
            return False
        attributes: list[str] = [
            "key",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class PathSegmentMember:
    def __init__(self, value: StructureSegment):
        self.value = value

    def as_dict(self) -> Dict[str, Any]:
        return {"member": self.value.as_dict()}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "PathSegmentMember":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")

        return PathSegmentMember(StructureSegment.from_dict(d["member"]))

    def __repr__(self) -> str:
        return f"PathSegmentMember(value=repr(self.value))"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, PathSegmentMember):
            return False
        return self.value == other.value


class PathSegmentUnknown:
    """Represents an unknown variant.

    If you receive this value, you will need to update your library to
    receive the parsed value.

    This value may not be deliberately sent.
    """

    def __init__(self, tag: str):
        self.tag = tag

    def as_dict(self) -> Dict[str, Any]:
        return {"SDK_UNKNOWN_MEMBER": {"name": self.tag}}

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "PathSegmentUnknown":
        if len(d) != 1:
            raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")
        return PathSegmentUnknown(d["SDK_UNKNOWN_MEMBER"]["name"])

    def __repr__(self) -> str:
        return f"PathSegmentUnknown(tag={self.tag})"


PathSegment = Union[PathSegmentMember, PathSegmentUnknown]


def _path_segment_from_dict(d: Dict[str, Any]) -> PathSegment:
    if "member" in d:
        return PathSegmentMember.from_dict(d)

    raise TypeError(f"Unions may have exactly 1 value, but found {len(d)}")


class AuthItem:
    key: list[PathSegment]
    data: StructuredDataTerminal
    action: str

    def __init__(
        self,
        *,
        key: list[PathSegment],
        data: StructuredDataTerminal,
        action: str,
    ):
        self.key = key
        self.data = data
        self.action = action

    def as_dict(self) -> Dict[str, Any]:
        """Converts the AuthItem to a dictionary."""
        return {
            "key": _path_as_dict(self.key),
            "data": self.data.as_dict(),
            "action": self.action,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "AuthItem":
        """Creates a AuthItem from a dictionary."""
        kwargs: Dict[str, Any] = {
            "key": _path_from_dict(d["key"]),
            "data": StructuredDataTerminal.from_dict(d["data"]),
            "action": d["action"],
        }

        return AuthItem(**kwargs)

    def __repr__(self) -> str:
        result = "AuthItem("
        if self.key is not None:
            result += f"key={repr(self.key)}, "

        if self.data is not None:
            result += f"data={repr(self.data)}, "

        if self.action is not None:
            result += f"action={repr(self.action)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, AuthItem):
            return False
        attributes: list[str] = [
            "key",
            "data",
            "action",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class CryptoAction:
    ENCRYPT_AND_SIGN = "ENCRYPT_AND_SIGN"

    SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT = "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT"

    SIGN_ONLY = "SIGN_ONLY"

    DO_NOTHING = "DO_NOTHING"

    # This set contains every possible value known at the time this was generated. New
    # values may be added in the future.
    values = frozenset(
        {
            "ENCRYPT_AND_SIGN",
            "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT",
            "SIGN_ONLY",
            "DO_NOTHING",
        }
    )


class CryptoItem:
    key: list[PathSegment]
    data: StructuredDataTerminal
    action: str

    def __init__(
        self,
        *,
        key: list[PathSegment],
        data: StructuredDataTerminal,
        action: str,
    ):
        self.key = key
        self.data = data
        self.action = action

    def as_dict(self) -> Dict[str, Any]:
        """Converts the CryptoItem to a dictionary."""
        return {
            "key": _path_as_dict(self.key),
            "data": self.data.as_dict(),
            "action": self.action,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "CryptoItem":
        """Creates a CryptoItem from a dictionary."""
        kwargs: Dict[str, Any] = {
            "key": _path_from_dict(d["key"]),
            "data": StructuredDataTerminal.from_dict(d["data"]),
            "action": d["action"],
        }

        return CryptoItem(**kwargs)

    def __repr__(self) -> str:
        result = "CryptoItem("
        if self.key is not None:
            result += f"key={repr(self.key)}, "

        if self.data is not None:
            result += f"data={repr(self.data)}, "

        if self.action is not None:
            result += f"action={repr(self.action)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, CryptoItem):
            return False
        attributes: list[str] = [
            "key",
            "data",
            "action",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class DecryptPathStructureInput:
    table_name: str
    encrypted_structure: list[AuthItem]
    cmm: "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.CryptographicMaterialsManager"
    encryption_context: Optional[dict[str, str]]

    def __init__(
        self,
        *,
        table_name: str,
        encrypted_structure: list[AuthItem],
        cmm: "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.CryptographicMaterialsManager",
        encryption_context: Optional[dict[str, str]] = None,
    ):
        self.table_name = table_name
        self.encrypted_structure = encrypted_structure
        self.cmm = cmm
        self.encryption_context = encryption_context

    def as_dict(self) -> Dict[str, Any]:
        """Converts the DecryptPathStructureInput to a dictionary."""
        d: Dict[str, Any] = {
            "table_name": self.table_name,
            "encrypted_structure": _auth_list_as_dict(self.encrypted_structure),
            "cmm": self.cmm.as_dict(),
        }

        if self.encryption_context is not None:
            d["encryption_context"] = self.encryption_context

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "DecryptPathStructureInput":
        """Creates a DecryptPathStructureInput from a dictionary."""
        from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references import (
            CryptographicMaterialsManager,
        )

        kwargs: Dict[str, Any] = {
            "table_name": d["table_name"],
            "encrypted_structure": _auth_list_from_dict(d["encrypted_structure"]),
            "cmm": CryptographicMaterialsManager.from_dict(d["cmm"]),
        }

        if "encryption_context" in d:
            kwargs["encryption_context"] = d["encryption_context"]

        return DecryptPathStructureInput(**kwargs)

    def __repr__(self) -> str:
        result = "DecryptPathStructureInput("
        if self.table_name is not None:
            result += f"table_name={repr(self.table_name)}, "

        if self.encrypted_structure is not None:
            result += f"encrypted_structure={repr(self.encrypted_structure)}, "

        if self.cmm is not None:
            result += f"cmm={repr(self.cmm)}, "

        if self.encryption_context is not None:
            result += f"encryption_context={repr(self.encryption_context)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, DecryptPathStructureInput):
            return False
        attributes: list[str] = [
            "table_name",
            "encrypted_structure",
            "cmm",
            "encryption_context",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ParsedHeader:
    algorithm_suite_id: str
    encrypted_data_keys: list[EncryptedDataKey]
    stored_encryption_context: dict[str, str]
    encryption_context: dict[str, str]

    def __init__(
        self,
        *,
        algorithm_suite_id: str,
        encrypted_data_keys: list[EncryptedDataKey],
        stored_encryption_context: dict[str, str],
        encryption_context: dict[str, str],
    ):
        self.algorithm_suite_id = algorithm_suite_id
        self.encrypted_data_keys = encrypted_data_keys
        self.stored_encryption_context = stored_encryption_context
        self.encryption_context = encryption_context

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ParsedHeader to a dictionary."""
        return {
            "algorithm_suite_id": self.algorithm_suite_id,
            "encrypted_data_keys": self.encrypted_data_keys,
            "stored_encryption_context": self.stored_encryption_context,
            "encryption_context": self.encryption_context,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ParsedHeader":
        """Creates a ParsedHeader from a dictionary."""
        kwargs: Dict[str, Any] = {
            "algorithm_suite_id": d["algorithm_suite_id"],
            "encrypted_data_keys": d["encrypted_data_keys"],
            "stored_encryption_context": d["stored_encryption_context"],
            "encryption_context": d["encryption_context"],
        }

        return ParsedHeader(**kwargs)

    def __repr__(self) -> str:
        result = "ParsedHeader("
        if self.algorithm_suite_id is not None:
            result += f"algorithm_suite_id={repr(self.algorithm_suite_id)}, "

        if self.encrypted_data_keys is not None:
            result += f"encrypted_data_keys={repr(self.encrypted_data_keys)}, "

        if self.stored_encryption_context is not None:
            result += f"stored_encryption_context={repr(self.stored_encryption_context)}, "

        if self.encryption_context is not None:
            result += f"encryption_context={repr(self.encryption_context)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ParsedHeader):
            return False
        attributes: list[str] = [
            "algorithm_suite_id",
            "encrypted_data_keys",
            "stored_encryption_context",
            "encryption_context",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class DecryptPathStructureOutput:
    plaintext_structure: list[CryptoItem]
    parsed_header: ParsedHeader

    def __init__(
        self,
        *,
        plaintext_structure: list[CryptoItem],
        parsed_header: ParsedHeader,
    ):
        self.plaintext_structure = plaintext_structure
        self.parsed_header = parsed_header

    def as_dict(self) -> Dict[str, Any]:
        """Converts the DecryptPathStructureOutput to a dictionary."""
        return {
            "plaintext_structure": _crypto_list_as_dict(self.plaintext_structure),
            "parsed_header": self.parsed_header.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "DecryptPathStructureOutput":
        """Creates a DecryptPathStructureOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "plaintext_structure": _crypto_list_from_dict(d["plaintext_structure"]),
            "parsed_header": ParsedHeader.from_dict(d["parsed_header"]),
        }

        return DecryptPathStructureOutput(**kwargs)

    def __repr__(self) -> str:
        result = "DecryptPathStructureOutput("
        if self.plaintext_structure is not None:
            result += f"plaintext_structure={repr(self.plaintext_structure)}, "

        if self.parsed_header is not None:
            result += f"parsed_header={repr(self.parsed_header)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, DecryptPathStructureOutput):
            return False
        attributes: list[str] = [
            "plaintext_structure",
            "parsed_header",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class DecryptStructureInput:
    table_name: str
    encrypted_structure: dict[str, StructuredDataTerminal]
    authenticate_schema: dict[str, str]
    cmm: "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.CryptographicMaterialsManager"
    encryption_context: Optional[dict[str, str]]

    def __init__(
        self,
        *,
        table_name: str,
        encrypted_structure: dict[str, StructuredDataTerminal],
        authenticate_schema: dict[str, str],
        cmm: "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.CryptographicMaterialsManager",
        encryption_context: Optional[dict[str, str]] = None,
    ):
        self.table_name = table_name
        self.encrypted_structure = encrypted_structure
        self.authenticate_schema = authenticate_schema
        self.cmm = cmm
        self.encryption_context = encryption_context

    def as_dict(self) -> Dict[str, Any]:
        """Converts the DecryptStructureInput to a dictionary."""
        d: Dict[str, Any] = {
            "table_name": self.table_name,
            "encrypted_structure": _structured_data_map_as_dict(self.encrypted_structure),
            "authenticate_schema": self.authenticate_schema,
            "cmm": self.cmm.as_dict(),
        }

        if self.encryption_context is not None:
            d["encryption_context"] = self.encryption_context

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "DecryptStructureInput":
        """Creates a DecryptStructureInput from a dictionary."""
        from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references import (
            CryptographicMaterialsManager,
        )

        kwargs: Dict[str, Any] = {
            "table_name": d["table_name"],
            "encrypted_structure": _structured_data_map_from_dict(d["encrypted_structure"]),
            "authenticate_schema": d["authenticate_schema"],
            "cmm": CryptographicMaterialsManager.from_dict(d["cmm"]),
        }

        if "encryption_context" in d:
            kwargs["encryption_context"] = d["encryption_context"]

        return DecryptStructureInput(**kwargs)

    def __repr__(self) -> str:
        result = "DecryptStructureInput("
        if self.table_name is not None:
            result += f"table_name={repr(self.table_name)}, "

        if self.encrypted_structure is not None:
            result += f"encrypted_structure={repr(self.encrypted_structure)}, "

        if self.authenticate_schema is not None:
            result += f"authenticate_schema={repr(self.authenticate_schema)}, "

        if self.cmm is not None:
            result += f"cmm={repr(self.cmm)}, "

        if self.encryption_context is not None:
            result += f"encryption_context={repr(self.encryption_context)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, DecryptStructureInput):
            return False
        attributes: list[str] = [
            "table_name",
            "encrypted_structure",
            "authenticate_schema",
            "cmm",
            "encryption_context",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class DecryptStructureOutput:
    plaintext_structure: dict[str, StructuredDataTerminal]
    crypto_schema: dict[str, str]
    parsed_header: ParsedHeader

    def __init__(
        self,
        *,
        plaintext_structure: dict[str, StructuredDataTerminal],
        crypto_schema: dict[str, str],
        parsed_header: ParsedHeader,
    ):
        self.plaintext_structure = plaintext_structure
        self.crypto_schema = crypto_schema
        self.parsed_header = parsed_header

    def as_dict(self) -> Dict[str, Any]:
        """Converts the DecryptStructureOutput to a dictionary."""
        return {
            "plaintext_structure": _structured_data_map_as_dict(self.plaintext_structure),
            "crypto_schema": self.crypto_schema,
            "parsed_header": self.parsed_header.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "DecryptStructureOutput":
        """Creates a DecryptStructureOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "plaintext_structure": _structured_data_map_from_dict(d["plaintext_structure"]),
            "crypto_schema": d["crypto_schema"],
            "parsed_header": ParsedHeader.from_dict(d["parsed_header"]),
        }

        return DecryptStructureOutput(**kwargs)

    def __repr__(self) -> str:
        result = "DecryptStructureOutput("
        if self.plaintext_structure is not None:
            result += f"plaintext_structure={repr(self.plaintext_structure)}, "

        if self.crypto_schema is not None:
            result += f"crypto_schema={repr(self.crypto_schema)}, "

        if self.parsed_header is not None:
            result += f"parsed_header={repr(self.parsed_header)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, DecryptStructureOutput):
            return False
        attributes: list[str] = [
            "plaintext_structure",
            "crypto_schema",
            "parsed_header",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class EncryptPathStructureInput:
    table_name: str
    plaintext_structure: list[CryptoItem]
    cmm: "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.CryptographicMaterialsManager"
    algorithm_suite_id: Optional[str]
    encryption_context: Optional[dict[str, str]]

    def __init__(
        self,
        *,
        table_name: str,
        plaintext_structure: list[CryptoItem],
        cmm: "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.CryptographicMaterialsManager",
        algorithm_suite_id: Optional[str] = None,
        encryption_context: Optional[dict[str, str]] = None,
    ):
        self.table_name = table_name
        self.plaintext_structure = plaintext_structure
        self.cmm = cmm
        self.algorithm_suite_id = algorithm_suite_id
        self.encryption_context = encryption_context

    def as_dict(self) -> Dict[str, Any]:
        """Converts the EncryptPathStructureInput to a dictionary."""
        d: Dict[str, Any] = {
            "table_name": self.table_name,
            "plaintext_structure": _crypto_list_as_dict(self.plaintext_structure),
            "cmm": self.cmm.as_dict(),
        }

        if self.algorithm_suite_id is not None:
            d["algorithm_suite_id"] = self.algorithm_suite_id

        if self.encryption_context is not None:
            d["encryption_context"] = self.encryption_context

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "EncryptPathStructureInput":
        """Creates a EncryptPathStructureInput from a dictionary."""
        from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references import (
            CryptographicMaterialsManager,
        )

        kwargs: Dict[str, Any] = {
            "table_name": d["table_name"],
            "plaintext_structure": _crypto_list_from_dict(d["plaintext_structure"]),
            "cmm": CryptographicMaterialsManager.from_dict(d["cmm"]),
        }

        if "algorithm_suite_id" in d:
            kwargs["algorithm_suite_id"] = d["algorithm_suite_id"]

        if "encryption_context" in d:
            kwargs["encryption_context"] = d["encryption_context"]

        return EncryptPathStructureInput(**kwargs)

    def __repr__(self) -> str:
        result = "EncryptPathStructureInput("
        if self.table_name is not None:
            result += f"table_name={repr(self.table_name)}, "

        if self.plaintext_structure is not None:
            result += f"plaintext_structure={repr(self.plaintext_structure)}, "

        if self.cmm is not None:
            result += f"cmm={repr(self.cmm)}, "

        if self.algorithm_suite_id is not None:
            result += f"algorithm_suite_id={repr(self.algorithm_suite_id)}, "

        if self.encryption_context is not None:
            result += f"encryption_context={repr(self.encryption_context)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, EncryptPathStructureInput):
            return False
        attributes: list[str] = [
            "table_name",
            "plaintext_structure",
            "cmm",
            "algorithm_suite_id",
            "encryption_context",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class EncryptPathStructureOutput:
    encrypted_structure: list[CryptoItem]
    parsed_header: ParsedHeader

    def __init__(
        self,
        *,
        encrypted_structure: list[CryptoItem],
        parsed_header: ParsedHeader,
    ):
        self.encrypted_structure = encrypted_structure
        self.parsed_header = parsed_header

    def as_dict(self) -> Dict[str, Any]:
        """Converts the EncryptPathStructureOutput to a dictionary."""
        return {
            "encrypted_structure": _crypto_list_as_dict(self.encrypted_structure),
            "parsed_header": self.parsed_header.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "EncryptPathStructureOutput":
        """Creates a EncryptPathStructureOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "encrypted_structure": _crypto_list_from_dict(d["encrypted_structure"]),
            "parsed_header": ParsedHeader.from_dict(d["parsed_header"]),
        }

        return EncryptPathStructureOutput(**kwargs)

    def __repr__(self) -> str:
        result = "EncryptPathStructureOutput("
        if self.encrypted_structure is not None:
            result += f"encrypted_structure={repr(self.encrypted_structure)}, "

        if self.parsed_header is not None:
            result += f"parsed_header={repr(self.parsed_header)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, EncryptPathStructureOutput):
            return False
        attributes: list[str] = [
            "encrypted_structure",
            "parsed_header",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class EncryptStructureInput:
    table_name: str
    plaintext_structure: dict[str, StructuredDataTerminal]
    crypto_schema: dict[str, str]
    cmm: "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.CryptographicMaterialsManager"
    algorithm_suite_id: Optional[str]
    encryption_context: Optional[dict[str, str]]

    def __init__(
        self,
        *,
        table_name: str,
        plaintext_structure: dict[str, StructuredDataTerminal],
        crypto_schema: dict[str, str],
        cmm: "aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references.CryptographicMaterialsManager",
        algorithm_suite_id: Optional[str] = None,
        encryption_context: Optional[dict[str, str]] = None,
    ):
        self.table_name = table_name
        self.plaintext_structure = plaintext_structure
        self.crypto_schema = crypto_schema
        self.cmm = cmm
        self.algorithm_suite_id = algorithm_suite_id
        self.encryption_context = encryption_context

    def as_dict(self) -> Dict[str, Any]:
        """Converts the EncryptStructureInput to a dictionary."""
        d: Dict[str, Any] = {
            "table_name": self.table_name,
            "plaintext_structure": _structured_data_map_as_dict(self.plaintext_structure),
            "crypto_schema": self.crypto_schema,
            "cmm": self.cmm.as_dict(),
        }

        if self.algorithm_suite_id is not None:
            d["algorithm_suite_id"] = self.algorithm_suite_id

        if self.encryption_context is not None:
            d["encryption_context"] = self.encryption_context

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "EncryptStructureInput":
        """Creates a EncryptStructureInput from a dictionary."""
        from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.references import (
            CryptographicMaterialsManager,
        )

        kwargs: Dict[str, Any] = {
            "table_name": d["table_name"],
            "plaintext_structure": _structured_data_map_from_dict(d["plaintext_structure"]),
            "crypto_schema": d["crypto_schema"],
            "cmm": CryptographicMaterialsManager.from_dict(d["cmm"]),
        }

        if "algorithm_suite_id" in d:
            kwargs["algorithm_suite_id"] = d["algorithm_suite_id"]

        if "encryption_context" in d:
            kwargs["encryption_context"] = d["encryption_context"]

        return EncryptStructureInput(**kwargs)

    def __repr__(self) -> str:
        result = "EncryptStructureInput("
        if self.table_name is not None:
            result += f"table_name={repr(self.table_name)}, "

        if self.plaintext_structure is not None:
            result += f"plaintext_structure={repr(self.plaintext_structure)}, "

        if self.crypto_schema is not None:
            result += f"crypto_schema={repr(self.crypto_schema)}, "

        if self.cmm is not None:
            result += f"cmm={repr(self.cmm)}, "

        if self.algorithm_suite_id is not None:
            result += f"algorithm_suite_id={repr(self.algorithm_suite_id)}, "

        if self.encryption_context is not None:
            result += f"encryption_context={repr(self.encryption_context)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, EncryptStructureInput):
            return False
        attributes: list[str] = [
            "table_name",
            "plaintext_structure",
            "crypto_schema",
            "cmm",
            "algorithm_suite_id",
            "encryption_context",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class EncryptStructureOutput:
    encrypted_structure: dict[str, StructuredDataTerminal]
    crypto_schema: dict[str, str]
    parsed_header: ParsedHeader

    def __init__(
        self,
        *,
        encrypted_structure: dict[str, StructuredDataTerminal],
        crypto_schema: dict[str, str],
        parsed_header: ParsedHeader,
    ):
        self.encrypted_structure = encrypted_structure
        self.crypto_schema = crypto_schema
        self.parsed_header = parsed_header

    def as_dict(self) -> Dict[str, Any]:
        """Converts the EncryptStructureOutput to a dictionary."""
        return {
            "encrypted_structure": _structured_data_map_as_dict(self.encrypted_structure),
            "crypto_schema": self.crypto_schema,
            "parsed_header": self.parsed_header.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "EncryptStructureOutput":
        """Creates a EncryptStructureOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "encrypted_structure": _structured_data_map_from_dict(d["encrypted_structure"]),
            "crypto_schema": d["crypto_schema"],
            "parsed_header": ParsedHeader.from_dict(d["parsed_header"]),
        }

        return EncryptStructureOutput(**kwargs)

    def __repr__(self) -> str:
        result = "EncryptStructureOutput("
        if self.encrypted_structure is not None:
            result += f"encrypted_structure={repr(self.encrypted_structure)}, "

        if self.crypto_schema is not None:
            result += f"crypto_schema={repr(self.crypto_schema)}, "

        if self.parsed_header is not None:
            result += f"parsed_header={repr(self.parsed_header)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, EncryptStructureOutput):
            return False
        attributes: list[str] = [
            "encrypted_structure",
            "crypto_schema",
            "parsed_header",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ResolveAuthActionsInput:
    table_name: str
    auth_actions: list[AuthItem]
    header_bytes: bytes | bytearray

    def __init__(
        self,
        *,
        table_name: str,
        auth_actions: list[AuthItem],
        header_bytes: bytes | bytearray,
    ):
        self.table_name = table_name
        self.auth_actions = auth_actions
        self.header_bytes = header_bytes

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ResolveAuthActionsInput to a dictionary."""
        return {
            "table_name": self.table_name,
            "auth_actions": _auth_list_as_dict(self.auth_actions),
            "header_bytes": self.header_bytes,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ResolveAuthActionsInput":
        """Creates a ResolveAuthActionsInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "table_name": d["table_name"],
            "auth_actions": _auth_list_from_dict(d["auth_actions"]),
            "header_bytes": d["header_bytes"],
        }

        return ResolveAuthActionsInput(**kwargs)

    def __repr__(self) -> str:
        result = "ResolveAuthActionsInput("
        if self.table_name is not None:
            result += f"table_name={repr(self.table_name)}, "

        if self.auth_actions is not None:
            result += f"auth_actions={repr(self.auth_actions)}, "

        if self.header_bytes is not None:
            result += f"header_bytes={repr(self.header_bytes)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ResolveAuthActionsInput):
            return False
        attributes: list[str] = [
            "table_name",
            "auth_actions",
            "header_bytes",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ResolveAuthActionsOutput:
    crypto_actions: list[CryptoItem]

    def __init__(
        self,
        *,
        crypto_actions: list[CryptoItem],
    ):
        self.crypto_actions = crypto_actions

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ResolveAuthActionsOutput to a dictionary."""
        return {
            "crypto_actions": _crypto_list_as_dict(self.crypto_actions),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ResolveAuthActionsOutput":
        """Creates a ResolveAuthActionsOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "crypto_actions": _crypto_list_from_dict(d["crypto_actions"]),
        }

        return ResolveAuthActionsOutput(**kwargs)

    def __repr__(self) -> str:
        result = "ResolveAuthActionsOutput("
        if self.crypto_actions is not None:
            result += f"crypto_actions={repr(self.crypto_actions)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ResolveAuthActionsOutput):
            return False
        attributes: list[str] = [
            "crypto_actions",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


def _crypto_list_as_dict(given: list[CryptoItem]) -> List[Any]:
    return [v.as_dict() for v in given]


def _crypto_list_from_dict(given: List[Any]) -> list[CryptoItem]:
    return [CryptoItem.from_dict(v) for v in given]


def _path_as_dict(given: list[PathSegment]) -> List[Any]:
    return [v.as_dict() for v in given]


def _path_from_dict(given: List[Any]) -> list[PathSegment]:
    return [PathSegment.from_dict(v) for v in given]


def _auth_list_as_dict(given: list[AuthItem]) -> List[Any]:
    return [v.as_dict() for v in given]


def _auth_list_from_dict(given: List[Any]) -> list[AuthItem]:
    return [AuthItem.from_dict(v) for v in given]


def _structured_data_map_as_dict(
    given: dict[str, StructuredDataTerminal],
) -> Dict[str, Any]:
    return {k: v.as_dict() for k, v in given.items()}


def _structured_data_map_from_dict(
    given: Dict[str, Any],
) -> dict[str, StructuredDataTerminal]:
    return {k: StructuredDataTerminal.from_dict(v) for k, v in given.items()}


class Unit:
    pass
