"""Item-based test bases for direct encryption/decryption performance testing."""

import json
import sys
from abc import ABC, abstractmethod
from pathlib import Path
from typing import Any, Dict, Union

# Add parent directory to path for imports
sys.path.insert(0, str(Path(__file__).parent.parent))

# V3 imports
from dynamodb_encryption_sdk.encrypted.item import encrypt_dynamodb_item, decrypt_dynamodb_item
from dynamodb_encryption_sdk.encrypted import CryptoConfig
from dynamodb_encryption_sdk.identifiers import CryptoAction as V3CryptoAction
from dynamodb_encryption_sdk.structures import AttributeActions, EncryptionContext

# V4 imports
from aws_cryptographic_material_providers.mpl.models import DBEAlgorithmSuiteId
from aws_dbesdk_dynamodb.encrypted.item import ItemEncryptor
from aws_dbesdk_dynamodb.structures.item_encryptor import DynamoDbItemEncryptorConfig
from aws_dbesdk_dynamodb.structures.structured_encryption import CryptoAction as V4CryptoAction

from ..test_constants import (
    FLAT_ATTRIBUTES_FILE,
    NESTED_ATTRIBUTES_FILE,
    PARTITION_KEY,
    SINGLE_ATTRIBUTE_FILE,
    SORT_KEY,
    TABLE_NAME,
)
from ..providers.v3_providers import V3ProviderBase
from ..providers.v4_providers import V4KeyringBase


class ItemTestBase(ABC):
    """Base class for item-based performance tests."""

    def __init__(self):
        """Initialize the test base."""
        self.table_name = TABLE_NAME
        self.partition_key = PARTITION_KEY
        self.sort_key = SORT_KEY

        # Load test data
        self.test_data = self._load_test_data()

    def _load_test_data(self) -> Dict[str, Any]:
        """Load test data from JSON files in DynamoDB format."""
        data = {}

        # Load single attribute data
        with open(SINGLE_ATTRIBUTE_FILE, "r") as f:
            single_data = json.load(f)
            data["single_attribute"] = self._convert_to_ddb_format(single_data)

        # Load nested attributes data
        with open(NESTED_ATTRIBUTES_FILE, "r") as f:
            nested_data = json.load(f)
            data["nested_attributes"] = self._convert_to_ddb_format(nested_data)

        # Load flat attributes data
        with open(FLAT_ATTRIBUTES_FILE, "r") as f:
            flat_data = json.load(f)
            data["flat_attributes"] = self._convert_to_ddb_format(flat_data)

        return data

    def _convert_to_ddb_value(self, value: Any) -> Dict[str, Any]:
        """Convert a Python value to DynamoDB format."""
        if isinstance(value, str):
            return {"S": value}
        elif isinstance(value, (int, float)):
            return {"N": str(value)}
        elif isinstance(value, bool):
            return {"BOOL": value}
        elif isinstance(value, list):
            return {"L": [self._convert_to_ddb_value(item) for item in value]}
        elif isinstance(value, dict):
            return {"M": {k: self._convert_to_ddb_value(v) for k, v in value.items()}}
        else:
            return {"S": str(value)}

    def _convert_to_ddb_format(self, item: Dict[str, Any]) -> Dict[str, Any]:
        """Convert a Python dict to DynamoDB format."""
        return {k: self._convert_to_ddb_value(v) for k, v in item.items()}

    def get_test_item(self, data_type: str) -> Dict[str, Any]:
        """Get a test item for the specified data type."""
        if data_type not in self.test_data:
            raise ValueError(f"Unknown data type: {data_type}")
        item = self.test_data[data_type].copy()

        # Add partition and sort keys
        item[self.partition_key] = {"S": "test_pk"}
        item[self.sort_key] = {"N": "0"}

        return item

    def calculate_item_size(self, item: Dict[str, Any]) -> int:
        """Calculate the size of a DynamoDB item in bytes."""
        # Convert the item to JSON and calculate size
        item_json = json.dumps(item, default=str)
        return len(item_json.encode("utf-8"))

    @abstractmethod
    def encrypt_item(self, item: Dict[str, Any]) -> Dict[str, Any]:
        """Encrypt a DynamoDB item directly."""
        pass

    @abstractmethod
    def decrypt_item(self, encrypted_item: Dict[str, Any]) -> Dict[str, Any]:
        """Decrypt a DynamoDB item directly."""
        pass


class V3ItemTestBase(ItemTestBase):
    """V3 item-based test base using direct encryption methods."""

    def __init__(self, provider: V3ProviderBase):
        """Initialize the V3 test base with a provider."""
        super().__init__()
        self.provider = provider
        self.materials_provider = provider.get_materials_provider()

        # Create attribute actions - same as defined in original item test bases
        attribute_actions = {
            self.partition_key: V3CryptoAction.SIGN_ONLY,
            self.sort_key: V3CryptoAction.SIGN_ONLY,
        }

        # Add all other attributes as ENCRYPT_AND_SIGN
        for data_type, item in self.test_data.items():
            for key in item:
                if key not in attribute_actions:
                    attribute_actions[key] = V3CryptoAction.ENCRYPT_AND_SIGN

        self.actions = AttributeActions(
            default_action=V3CryptoAction.ENCRYPT_AND_SIGN,
            attribute_actions=attribute_actions,
        )

        # Create encryption context
        self.encryption_context = EncryptionContext(
            table_name=self.table_name,
            partition_key_name=self.partition_key,
            sort_key_name=self.sort_key,
        )

        self.crypto_config = CryptoConfig(
            materials_provider=self.materials_provider,
            encryption_context=self.encryption_context,
            attribute_actions=self.actions,
        )

    def encrypt_item(self, item: Dict[str, Any]) -> Dict[str, Any]:
        """Encrypt a DynamoDB item directly - REAL encryption only."""
        # Use the proper DDBEC v3 API

        encrypted_item = encrypt_dynamodb_item(item, self.crypto_config)
        return encrypted_item

    def decrypt_item(self, encrypted_item: Dict[str, Any]) -> Dict[str, Any]:
        """Decrypt a DynamoDB item directly - REAL decryption only."""
        # Make a copy to avoid mutating the original encrypted item
        # The decrypt_dynamodb_item function modifies the input by removing signature attributes
        encrypted_item_copy = encrypted_item.copy()
        decrypted_item = decrypt_dynamodb_item(encrypted_item_copy, self.crypto_config)
        return decrypted_item


class V4ItemTestBase(ItemTestBase):
    """V4 item-based test base using direct encryption methods."""

    def __init__(self, keyring: V4KeyringBase):
        """Initialize the V4 test base with a keyring."""
        super().__init__()
        self.keyring = keyring
        self.keyring_impl = keyring.get_keyring()

        # Create attribute actions - same as defined in original item test bases
        attribute_actions = {
            self.partition_key: V4CryptoAction.SIGN_ONLY,
            self.sort_key: V4CryptoAction.SIGN_ONLY,
        }

        # Add all other attributes as ENCRYPT_AND_SIGN
        for data_type, item in self.test_data.items():
            for key in item:
                if key not in attribute_actions:
                    attribute_actions[key] = V4CryptoAction.ENCRYPT_AND_SIGN

        # Create table encryption config
        self.table_config = DynamoDbItemEncryptorConfig(
            logical_table_name=self.table_name,
            partition_key_name=self.partition_key,
            sort_key_name=self.sort_key,
            attribute_actions_on_encrypt=attribute_actions,
            keyring=self.keyring_impl,
            # Use unsigned attribute prefix pattern from migration examples
            allowed_unsigned_attribute_prefix=":",
            algorithm_suite_id=DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384,
        )

        # Create the item encryptor
        self.item_encryptor = ItemEncryptor(self.table_config)

    def encrypt_item(self, item: Dict[str, Any]) -> Dict[str, Any]:
        """Encrypt a DynamoDB item directly - REAL encryption only."""
        encrypted_item = self.item_encryptor.encrypt_dynamodb_item(item)
        return encrypted_item.encrypted_item

    def decrypt_item(self, encrypted_item: Dict[str, Any]) -> Dict[str, Any]:
        """Decrypt a DynamoDB item directly - REAL decryption only."""
        encrypted_item_copy = encrypted_item.copy()
        decrypted_item = self.item_encryptor.decrypt_dynamodb_item(encrypted_item_copy)
        return decrypted_item.plaintext_item
