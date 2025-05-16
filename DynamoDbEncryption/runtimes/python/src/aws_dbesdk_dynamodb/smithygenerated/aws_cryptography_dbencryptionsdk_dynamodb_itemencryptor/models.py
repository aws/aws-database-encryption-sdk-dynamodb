# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from typing import Any, Dict, Optional

from aws_cryptographic_material_providers.smithygenerated.aws_cryptography_materialproviders.models import (
    EncryptedDataKey,
)


class DecryptItemInput:
    encrypted_item: dict[str, Any]

    def __init__(
        self,
        *,
        encrypted_item: dict[str, Any],
    ):
        """Inputs for decrypting a DynamoDB Item.

        :param encrypted_item: The encrypted DynamoDB item to decrypt.
        """
        self.encrypted_item = encrypted_item

    def as_dict(self) -> Dict[str, Any]:
        """Converts the DecryptItemInput to a dictionary."""
        return {
            "encrypted_item": self.encrypted_item,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "DecryptItemInput":
        """Creates a DecryptItemInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "encrypted_item": d["encrypted_item"],
        }

        return DecryptItemInput(**kwargs)

    def __repr__(self) -> str:
        result = "DecryptItemInput("
        if self.encrypted_item is not None:
            result += f"encrypted_item={repr(self.encrypted_item)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, DecryptItemInput):
            return False
        attributes: list[str] = [
            "encrypted_item",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class EncryptItemInput:
    plaintext_item: dict[str, Any]

    def __init__(
        self,
        *,
        plaintext_item: dict[str, Any],
    ):
        """Inputs for encrypting a DynamoDB Item.

        :param plaintext_item: The DynamoDB item to encrypt.
        """
        self.plaintext_item = plaintext_item

    def as_dict(self) -> Dict[str, Any]:
        """Converts the EncryptItemInput to a dictionary."""
        return {
            "plaintext_item": self.plaintext_item,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "EncryptItemInput":
        """Creates a EncryptItemInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "plaintext_item": d["plaintext_item"],
        }

        return EncryptItemInput(**kwargs)

    def __repr__(self) -> str:
        result = "EncryptItemInput("
        if self.plaintext_item is not None:
            result += f"plaintext_item={repr(self.plaintext_item)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, EncryptItemInput):
            return False
        attributes: list[str] = [
            "plaintext_item",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ParsedHeader:
    attribute_actions_on_encrypt: dict[str, str]
    algorithm_suite_id: str
    encrypted_data_keys: list[EncryptedDataKey]
    stored_encryption_context: dict[str, str]
    encryption_context: dict[str, str]
    selector_context: dict[str, Any]

    def __init__(
        self,
        *,
        attribute_actions_on_encrypt: dict[str, str],
        algorithm_suite_id: str,
        encrypted_data_keys: list[EncryptedDataKey],
        stored_encryption_context: dict[str, str],
        encryption_context: dict[str, str],
        selector_context: dict[str, Any],
    ):
        """A parsed version of the header that was written with or read on an
        encrypted DynamoDB item.

        :param attribute_actions_on_encrypt: The non-DO_NOTHING Crypto
            Actions that were configured when this item was originally
            encrypted.
        :param algorithm_suite_id: The ID of the algorithm suite that
            was used to encrypt this item.
        :param encrypted_data_keys: The encrypted data keys that are
            stored in the header of this item.
        :param stored_encryption_context: The portion of the encryption
            context that was stored in the header of this item.
        :param encryption_context: The full encryption context.
        :param selector_context: The encryption context as presented to
            the branch key selector.
        """
        self.attribute_actions_on_encrypt = attribute_actions_on_encrypt
        self.algorithm_suite_id = algorithm_suite_id
        self.encrypted_data_keys = encrypted_data_keys
        self.stored_encryption_context = stored_encryption_context
        self.encryption_context = encryption_context
        self.selector_context = selector_context

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ParsedHeader to a dictionary."""
        return {
            "attribute_actions_on_encrypt": self.attribute_actions_on_encrypt,
            "algorithm_suite_id": self.algorithm_suite_id,
            "encrypted_data_keys": self.encrypted_data_keys,
            "stored_encryption_context": self.stored_encryption_context,
            "encryption_context": self.encryption_context,
            "selector_context": self.selector_context,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ParsedHeader":
        """Creates a ParsedHeader from a dictionary."""
        kwargs: Dict[str, Any] = {
            "attribute_actions_on_encrypt": d["attribute_actions_on_encrypt"],
            "algorithm_suite_id": d["algorithm_suite_id"],
            "encrypted_data_keys": d["encrypted_data_keys"],
            "stored_encryption_context": d["stored_encryption_context"],
            "encryption_context": d["encryption_context"],
            "selector_context": d["selector_context"],
        }

        return ParsedHeader(**kwargs)

    def __repr__(self) -> str:
        result = "ParsedHeader("
        if self.attribute_actions_on_encrypt is not None:
            result += f"attribute_actions_on_encrypt={repr(self.attribute_actions_on_encrypt)}, "

        if self.algorithm_suite_id is not None:
            result += f"algorithm_suite_id={repr(self.algorithm_suite_id)}, "

        if self.encrypted_data_keys is not None:
            result += f"encrypted_data_keys={repr(self.encrypted_data_keys)}, "

        if self.stored_encryption_context is not None:
            result += f"stored_encryption_context={repr(self.stored_encryption_context)}, "

        if self.encryption_context is not None:
            result += f"encryption_context={repr(self.encryption_context)}, "

        if self.selector_context is not None:
            result += f"selector_context={repr(self.selector_context)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ParsedHeader):
            return False
        attributes: list[str] = [
            "attribute_actions_on_encrypt",
            "algorithm_suite_id",
            "encrypted_data_keys",
            "stored_encryption_context",
            "encryption_context",
            "selector_context",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class DecryptItemOutput:
    plaintext_item: dict[str, Any]
    parsed_header: Optional["ParsedHeader"]

    def __init__(
        self,
        *,
        plaintext_item: dict[str, Any],
        parsed_header: Optional["ParsedHeader"] = None,
    ):
        """Outputs for decrypting a DynamoDB Item.

        :param plaintext_item: The decrypted DynamoDB item.
        :param parsed_header: A parsed version of the header on the
            encrypted DynamoDB item.
        """
        self.plaintext_item = plaintext_item
        self.parsed_header = parsed_header

    def as_dict(self) -> Dict[str, Any]:
        """Converts the DecryptItemOutput to a dictionary."""
        d: Dict[str, Any] = {
            "plaintext_item": self.plaintext_item,
        }

        if self.parsed_header is not None:
            d["parsed_header"] = self.parsed_header.as_dict()

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "DecryptItemOutput":
        """Creates a DecryptItemOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "plaintext_item": d["plaintext_item"],
        }

        if "parsed_header" in d:
            kwargs["parsed_header"] = ParsedHeader.from_dict(d["parsed_header"])

        return DecryptItemOutput(**kwargs)

    def __repr__(self) -> str:
        result = "DecryptItemOutput("
        if self.plaintext_item is not None:
            result += f"plaintext_item={repr(self.plaintext_item)}, "

        if self.parsed_header is not None:
            result += f"parsed_header={repr(self.parsed_header)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, DecryptItemOutput):
            return False
        attributes: list[str] = [
            "plaintext_item",
            "parsed_header",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class EncryptItemOutput:
    encrypted_item: dict[str, Any]
    parsed_header: Optional["ParsedHeader"]

    def __init__(
        self,
        *,
        encrypted_item: dict[str, Any],
        parsed_header: Optional["ParsedHeader"] = None,
    ):
        """Outputs for encrypting a DynamoDB Item.

        :param encrypted_item: The encrypted DynamoDB item.
        :param parsed_header: A parsed version of the header written
            with the encrypted DynamoDB item.
        """
        self.encrypted_item = encrypted_item
        self.parsed_header = parsed_header

    def as_dict(self) -> Dict[str, Any]:
        """Converts the EncryptItemOutput to a dictionary."""
        d: Dict[str, Any] = {
            "encrypted_item": self.encrypted_item,
        }

        if self.parsed_header is not None:
            d["parsed_header"] = self.parsed_header.as_dict()

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "EncryptItemOutput":
        """Creates a EncryptItemOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "encrypted_item": d["encrypted_item"],
        }

        if "parsed_header" in d:
            kwargs["parsed_header"] = ParsedHeader.from_dict(d["parsed_header"])

        return EncryptItemOutput(**kwargs)

    def __repr__(self) -> str:
        result = "EncryptItemOutput("
        if self.encrypted_item is not None:
            result += f"encrypted_item={repr(self.encrypted_item)}, "

        if self.parsed_header is not None:
            result += f"parsed_header={repr(self.parsed_header)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, EncryptItemOutput):
            return False
        attributes: list[str] = [
            "encrypted_item",
            "parsed_header",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class Unit:
    pass
