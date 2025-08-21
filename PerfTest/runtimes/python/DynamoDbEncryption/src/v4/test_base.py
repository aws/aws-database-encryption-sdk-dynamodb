"""Base class for DB-ESDK v4 performance tests using direct encryption methods."""

import json
import sys
from abc import ABC, abstractmethod
from pathlib import Path
from typing import Any, Dict

import boto3
from aws_cryptographic_material_providers.mpl.references import IKeyring
from aws_dbesdk_dynamodb.encrypted.item import ItemEncryptor
from aws_dbesdk_dynamodb.structures.item_encryptor import DynamoDbItemEncryptorConfig
from aws_dbesdk_dynamodb.structures.structured_encryption import CryptoAction
from aws_dbesdk_dynamodb.transform import ddb_to_dict

# Add parent directory to path for imports
sys.path.insert(0, str(Path(__file__).parent.parent))

from ..test_constants import (
    FLAT_ATTRIBUTES_FILE,
    NESTED_ATTRIBUTES_FILE,
    PARTITION_KEY,
    SINGLE_ATTRIBUTE_FILE,
    SORT_KEY,
    TABLE_NAME,
)


class V4PerformanceTestBase(ABC):
    """Base class for DB-ESDK v4 performance tests using direct encryption methods."""

    def __init__(self):
        """Initialize the test base."""
        self.table_name = TABLE_NAME
        self.partition_key = PARTITION_KEY
        self.sort_key = SORT_KEY

        # Load test data
        self.test_data = self._load_test_data()

        # Create a real DynamoDB client (not used for actual AWS calls in performance tests)
        self.dynamodb_client = boto3.client("dynamodb", region_name="us-west-2")

        # Create keyring
        self.keyring = self._create_keyring()

        # Create attribute actions
        self.attribute_actions = {
            self.partition_key: CryptoAction.SIGN_ONLY,
            self.sort_key: CryptoAction.SIGN_ONLY,
        }
        # Add all other attributes as ENCRYPT_AND_SIGN
        for data_type, item in self.test_data.items():
            for key in item:
                if key not in self.attribute_actions:
                    self.attribute_actions[key] = CryptoAction.ENCRYPT_AND_SIGN

        # Create the configuration for the DynamoDb Item Encryptor
        table_config = DynamoDbItemEncryptorConfig(
            logical_table_name=self.table_name,
            partition_key_name=self.partition_key,
            sort_key_name=self.sort_key,
            attribute_actions_on_encrypt=self.attribute_actions,
            keyring=self.keyring,
            allowed_unsigned_attribute_prefix=":",
        )

        # Create the DynamoDb Item Encryptor
        self.item_encryptor = ItemEncryptor(table_config)

    @abstractmethod
    def _create_keyring(self) -> IKeyring:
        """Create the keyring for this test."""
        pass

    def _load_test_data(self) -> Dict[str, Any]:
        """Load test data from JSON files in DynamoDB format."""
        data = {}

        # Load single attribute data
        with open(SINGLE_ATTRIBUTE_FILE, "r") as f:
            single_data = json.load(f)
            # Convert to DynamoDB format
            ddb_item = {}
            for k, v in single_data.items():
                if isinstance(v, str):
                    ddb_item[k] = {"S": v}
                elif isinstance(v, (int, float)):
                    ddb_item[k] = {"N": str(v)}
                elif isinstance(v, bool):
                    ddb_item[k] = {"BOOL": v}
                elif isinstance(v, list):
                    ddb_item[k] = {"L": [self._convert_to_ddb_value(item) for item in v]}
                elif isinstance(v, dict):
                    ddb_item[k] = {"M": {sk: self._convert_to_ddb_value(sv) for sk, sv in v.items()}}
            data["single_attribute"] = ddb_item

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
        item[self.sort_key] = {"S": "test_sk"}

        return item

    def encrypt_item(self, item: Dict[str, Any]) -> Dict[str, Any]:
        """Encrypt a DynamoDB item directly - REAL encryption only."""
        # Access the internal item encryptor from the encrypted client
        encrypted_output = self.item_encryptor.encrypt_dynamodb_item(item)
        return encrypted_output.encrypted_item

    def _verify_encryption(self, original_item: Dict[str, Any], encrypted_item: Dict[str, Any]) -> None:
        """Verify that real encryption occurred."""
        # 1. Verify that encrypted item has signature attribute
        signature_found = False
        for key in encrypted_item.keys():
            if "sig" in key.lower() or "head" in key.lower() or "foot" in key.lower() or "aws_dbe" in key.lower():
                signature_found = True
                break

        assert signature_found, "Encrypted item missing signature attribute - real encryption failed"

        # 2. Verify that encrypted attributes are different from original
        for key, original_value in original_item.items():
            if key not in [self.partition_key, self.sort_key]:
                if key in encrypted_item:
                    encrypted_value = encrypted_item[key]
                    assert encrypted_value != original_value, f"Attribute {key} not encrypted - real encryption failed"

        # 3. Verify encrypted item is larger (has signature and encrypted data)
        original_size = len(str(original_item))
        encrypted_size = len(str(encrypted_item))
        assert encrypted_size > original_size, f"Encrypted item not larger than original - real encryption failed"

    def decrypt_item(self, encrypted_item: Dict[str, Any]) -> Dict[str, Any]:
        """Decrypt a DynamoDB item directly - REAL decryption only."""
        # Access the internal item encryptor from the encrypted client
        decrypted_output = self.item_encryptor.decrypt_dynamodb_item(encrypted_item)
        return decrypted_output.plaintext_item

    def calculate_item_size(self, item: Dict[str, Any]) -> int:
        """Calculate the size of a DynamoDB item in bytes."""
        # Convert the item to JSON and calculate size
        item_json = json.dumps(item, default=str)
        return len(item_json.encode("utf-8"))

    def benchmark_encrypt(self, benchmark, data_type: str):
        """Benchmark encryption performance."""
        item = self.get_test_item(data_type)

        def encrypt():
            return self.encrypt_item(item)

        encrypted_item = benchmark(encrypt)
        self._verify_encryption(item, encrypted_item)

        # For encrypt: only report original (plaintext) size
        original_size = self.calculate_item_size(item)
        encrypted_size = self.calculate_item_size(encrypted_item)

        benchmark.extra_info.update(
            {
                "data_type": data_type,
                "original_size_bytes": original_size,
                "encrypted_size_bytes": encrypted_size,
                "size_increase_ratio": encrypted_size / original_size if original_size > 0 else 0,
            }
        )

    def benchmark_decrypt(self, benchmark, data_type: str):
        """Benchmark decryption performance."""
        item = self.get_test_item(data_type)
        encrypted_item = self.encrypt_item(item)

        # Calculate sizes before decryption
        original_size = self.calculate_item_size(item)
        encrypted_size = self.calculate_item_size(encrypted_item)

        def decrypt():
            return self.decrypt_item(encrypted_item)

        decrypted_item = benchmark(decrypt)

        # Verify decryption worked correctly - comprehensive verification
        assert decrypted_item[self.partition_key] == item[self.partition_key]
        assert decrypted_item[self.sort_key] == item[self.sort_key]

        # Verify that encrypted attributes were properly decrypted (back to original)
        for key, original_value in item.items():
            if key not in [self.partition_key, self.sort_key]:
                assert key in decrypted_item, f"Missing attribute {key} in decrypted item"
                decrypted_value = decrypted_item[key]
                assert (
                    decrypted_value == original_value
                ), f"Attribute {key} not properly decrypted: {decrypted_value} != {original_value}"

        # For decrypt: only report encrypted size
        benchmark.extra_info.update(
            {
                "data_type": data_type,
                "original_size_bytes": original_size,
                "encrypted_size_bytes": encrypted_size,
                "size_increase_ratio": encrypted_size / original_size if original_size > 0 else 0,
            }
        )
