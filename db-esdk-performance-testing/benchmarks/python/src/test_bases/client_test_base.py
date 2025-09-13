"""EncryptedClient-based test bases for performance testing."""

import json
import sys
from abc import ABC, abstractmethod
from pathlib import Path
from typing import Any, Dict

import boto3

# Add parent directory to path for imports
sys.path.insert(0, str(Path(__file__).parent.parent))

# V3 imports
from dynamodb_encryption_sdk.encrypted.client import EncryptedClient as V3EncryptedClient
from dynamodb_encryption_sdk.identifiers import CryptoAction as V3CryptoAction
from dynamodb_encryption_sdk.structures import AttributeActions

# V4 imports
from aws_cryptographic_material_providers.mpl.models import DBEAlgorithmSuiteId
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient as V4EncryptedClient
from aws_dbesdk_dynamodb.structures.dynamodb import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
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


class ClientTestBase(ABC):
    """Base class for EncryptedClient-based performance tests."""

    def __init__(self):
        """Initialize the test base."""
        self.table_name = TABLE_NAME
        self.partition_key = PARTITION_KEY
        self.sort_key = SORT_KEY

        # Load test data
        self.test_data = self._load_test_data()

        # Create a mock DynamoDB client for testing
        self.ddb_client = boto3.client("dynamodb", region_name="us-west-2")

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
        """Encrypt a DynamoDB item using EncryptedClient."""
        pass

    @abstractmethod
    def decrypt_item(self, encrypted_item: Dict[str, Any]) -> Dict[str, Any]:
        """Decrypt a DynamoDB item using EncryptedClient."""
        pass


class V3ClientTestBase(ClientTestBase):
    """V3 EncryptedClient-based test base."""

    def __init__(self, provider: V3ProviderBase):
        """Initialize the V3 client test base with a provider."""
        super().__init__()
        self.provider = provider
        self.materials_provider = provider.get_materials_provider()

        # Create attribute actions - same as defined in original client test bases
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

        # Create the encrypted client following the migration example pattern
        self.encrypted_client = V3EncryptedClient(
            client=self.ddb_client,
            materials_provider=self.materials_provider,
            attribute_actions=self.actions
        )

    def encrypt_item(self, item: Dict[str, Any]) -> Dict[str, Any]:
        """Encrypt a DynamoDB item using V3 EncryptedClient."""
        # Focus only on the actual put_item call - this is what gets profiled
        response = self.encrypted_client.put_item(
            TableName=self.table_name,
            Item=item
        )
        assert response["ResponseMetadata"]["HTTPStatusCode"] == 200
        # For profiling purposes, return the input item since put_item doesn't return encrypted data
        # The profiler measures the put_item performance
        return item

    def decrypt_item(self, encrypted_item: Dict[str, Any]) -> Dict[str, Any]:
        """Decrypt a DynamoDB item using V3 EncryptedClient."""
        # Focus only on the actual get_item call - this is what gets profiled
        key = {
            self.partition_key: encrypted_item[self.partition_key],
            self.sort_key: encrypted_item[self.sort_key],
        }
        
        response = self.encrypted_client.get_item(
            TableName=self.table_name,
            Key=key
        )

        assert response["ResponseMetadata"]["HTTPStatusCode"] == 200
        return response["Item"]


class V4ClientTestBase(ClientTestBase):
    """V4 EncryptedClient-based test base."""

    def __init__(self, keyring: V4KeyringBase):
        """Initialize the V4 client test base with a keyring."""
        super().__init__()
        self.keyring = keyring
        self.keyring_impl = keyring.get_keyring()

        # Create attribute actions - same as defined in original client test bases
        attribute_actions = {
            self.partition_key: V4CryptoAction.SIGN_ONLY,
            self.sort_key: V4CryptoAction.SIGN_ONLY,
        }

        # Add all other attributes as ENCRYPT_AND_SIGN
        for data_type, item in self.test_data.items():
            for key in item:
                if key not in attribute_actions:
                    attribute_actions[key] = V4CryptoAction.ENCRYPT_AND_SIGN

        # Create table encryption config following the migration example pattern
        table_config = DynamoDbTableEncryptionConfig(
            logical_table_name=self.table_name,
            partition_key_name=self.partition_key,
            sort_key_name=self.sort_key,
            attribute_actions_on_encrypt=attribute_actions,
            keyring=self.keyring_impl,
            # Use unsigned attribute prefix pattern from migration examples
            allowed_unsigned_attribute_prefix=":",
            algorithm_suite_id=DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384,
        )

        # Create tables config
        table_configs = {self.table_name: table_config}
        tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

        # Create the encrypted client following the migration example pattern
        self.encrypted_client = V4EncryptedClient(
            client=self.ddb_client,
            encryption_config=tables_config,
        )

    def encrypt_item(self, item: Dict[str, Any]) -> Dict[str, Any]:
        """Encrypt a DynamoDB item using V4 EncryptedClient."""
        # Focus only on the actual put_item call - this is what gets profiled
        self.encrypted_client.put_item(
            TableName=self.table_name,
            Item=item
        )
        # For profiling purposes, we don't need the encrypted result
        # The profiler measures the put_item performance
        return item

    def decrypt_item(self, encrypted_item: Dict[str, Any]) -> Dict[str, Any]:
        """Decrypt a DynamoDB item using V4 EncryptedClient."""
        # Focus only on the actual get_item call - this is what gets profiled
        key = {
            self.partition_key: encrypted_item[self.partition_key],
            self.sort_key: encrypted_item[self.sort_key],
        }
        
        response = self.encrypted_client.get_item(
            TableName=self.table_name,
            Key=key
        )
        
        return response.get('Item', encrypted_item)
