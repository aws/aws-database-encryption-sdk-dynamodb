# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

import secrets
import time
from typing import Dict, List, NamedTuple, Any

import boto3
import psutil
from tqdm import tqdm

from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    AesWrappingAlg,
    CreateRawAesKeyringInput,
    DBEAlgorithmSuiteId,
)
from aws_cryptographic_material_providers.mpl.references import IKeyring

from aws_dbesdk_dynamodb.encrypted.item import ItemEncryptor
from aws_dbesdk_dynamodb.encrypted.resource import EncryptedResource
from aws_dbesdk_dynamodb.structures.item_encryptor import DynamoDbItemEncryptorConfig
from aws_dbesdk_dynamodb.structures.dynamodb import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import CryptoAction

# Legacy V3 imports for comparison
from dynamodb_encryption_sdk.encrypted.item import encrypt_dynamodb_item, decrypt_dynamodb_item
from dynamodb_encryption_sdk.encrypted import CryptoConfig
from dynamodb_encryption_sdk.identifiers import CryptoAction as V3CryptoAction
from dynamodb_encryption_sdk.structures import AttributeActions, EncryptionContext
from dynamodb_encryption_sdk.material_providers.wrapped import WrappedCryptographicMaterialsProvider
from dynamodb_encryption_sdk.delegated_keys.jce import JceNameLocalDelegatedKey
from dynamodb_encryption_sdk.identifiers import EncryptionKeyType, KeyEncodingType

from .models import Config, TestResult
from .tests import Tests


class BenchmarkResult(NamedTuple):
    """Result from a single encrypt/decrypt cycle."""

    put_latency_ms: float
    get_latency_ms: float


class ESDKBenchmark:
    def __init__(self, config_path: str):
        self.config = Config.load_config(config_path)
        self.cpu_count = psutil.cpu_count(logical=True)
        self.total_memory_mb = psutil.virtual_memory().total / (1024 * 1024)
        self.table_name = self.config.table_name or "db-esdk-performance-test"
        self.keyring = self._setup_keyring()
        self.item_encryptor = self._setup_item_encryptor()
        print(f"Initialized DB-ESDK Benchmark - CPU cores: {self.cpu_count}, Memory: {self.total_memory_mb / 1024.0:.1f}GB")

    def _setup_keyring(self) -> IKeyring:
        encryption_key = secrets.token_bytes(32)  # 256-bit AES key for testing
        mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())
        keyring_input = CreateRawAesKeyringInput(
            key_name="test-aes-256-key",
            key_namespace="db-esdk-performance-test",
            wrapping_key=encryption_key,
            wrapping_alg=AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16,  # AES-256-GCM for secure wrapping
        )
        return mat_prov.create_raw_aes_keyring(input=keyring_input)

    def _setup_item_encryptor(self) -> ItemEncryptor:
        attribute_actions_on_encrypt = {
            "partition_key": CryptoAction.SIGN_ONLY,  # Keys must be signed for searchability
            "sort_key": CryptoAction.SIGN_ONLY,
            "attribute1": CryptoAction.ENCRYPT_AND_SIGN,  # Sensitive data encrypted and signed
            "attribute2": CryptoAction.SIGN_ONLY,  # Non-sensitive data signed only
            ":attribute3": CryptoAction.DO_NOTHING,  # Prefix ':' allows unsigned attributes
        }
        table_config = DynamoDbItemEncryptorConfig(
            logical_table_name=self.table_name,
            partition_key_name="partition_key",
            sort_key_name="sort_key",
            attribute_actions_on_encrypt=attribute_actions_on_encrypt,
            keyring=self.keyring,
            allowed_unsigned_attribute_prefix=":",  # Allow ':' prefixed attributes to be unsigned
            algorithm_suite_id=DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384,  # Strong encryption with commitment
        )
        return ItemEncryptor(table_config)

    def run_item_encryptor_cycle(self, data: bytes) -> BenchmarkResult:
        plaintext_item = {
            "partition_key": "benchmark-test",
            "sort_key": 0,
            "attribute1": {"data": data},  # Test payload data
            "attribute2": "sign me!",
            ":attribute3": "ignore me!",  # Unsigned attribute for testing
        }

        encrypt_start = time.perf_counter()
        encrypted_item = self.item_encryptor.encrypt_python_item(plaintext_item).encrypted_item
        encrypt_time = (time.perf_counter() - encrypt_start) * 1000.0

        decrypt_start = time.perf_counter()
        decrypted_item = self.item_encryptor.decrypt_python_item(encrypted_item).plaintext_item
        decrypt_time = (time.perf_counter() - decrypt_start) * 1000.0

        return BenchmarkResult(put_latency_ms=encrypt_time, get_latency_ms=decrypt_time)

    def _setup_legacy_client(self):
        """Setup legacy V3 DynamoDB Encryption Client for comparison."""
        # AES Key Material (32 bytes for AES-256) - same as test constants
        aes_256_key_material = bytes([
            0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
            0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F,
            0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17,
            0x18, 0x19, 0x1A, 0x1B, 0x1C, 0x1D, 0x1E, 0x1F,
        ])

        # Create wrapping key using JceNameLocalDelegatedKey
        wrapping_key = JceNameLocalDelegatedKey(
            key=aes_256_key_material,
            algorithm="AES",
            key_type=EncryptionKeyType.SYMMETRIC,
            key_encoding=KeyEncodingType.RAW,
        )

        # Create signing key (using same key for simplicity in testing)
        signing_key = JceNameLocalDelegatedKey(
            key=aes_256_key_material,
            algorithm="HmacSHA256",
            key_type=EncryptionKeyType.SYMMETRIC,
            key_encoding=KeyEncodingType.RAW,
        )

        # Create the materials provider
        materials_provider = WrappedCryptographicMaterialsProvider(
            wrapping_key=wrapping_key,
            unwrapping_key=wrapping_key,
            signing_key=signing_key
        )

        # Create attribute actions for legacy client
        attribute_actions = {
            "partition_key": V3CryptoAction.SIGN_ONLY,
            "sort_key": V3CryptoAction.SIGN_ONLY,
            "attribute1": V3CryptoAction.ENCRYPT_AND_SIGN,
            "attribute2": V3CryptoAction.SIGN_ONLY,
            ":attribute3": V3CryptoAction.DO_NOTHING,
        }

        actions = AttributeActions(
            default_action=V3CryptoAction.ENCRYPT_AND_SIGN,
            attribute_actions=attribute_actions,
        )

        # Create encryption context
        encryption_context = EncryptionContext(
            table_name=self.table_name,
            partition_key_name="partition_key",
            sort_key_name="sort_key",
        )

        # Create crypto config
        self.legacy_crypto_config = CryptoConfig(
            materials_provider=materials_provider,
            encryption_context=encryption_context,
            attribute_actions=actions,
        )

    def run_legacy_item_encryptor_cycle(self, data: bytes) -> BenchmarkResult:
        """
        Run legacy V3 item encryptor cycle for comparison with V4.
        Uses the legacy DynamoDB Encryption Client (V3).
        """
        # Ensure legacy client is set up
        if not hasattr(self, 'legacy_crypto_config'):
            self._setup_legacy_client()

        # Convert data to DynamoDB format
        plaintext_item = {
            "partition_key": {"S": "benchmark-test"},
            "sort_key": {"N": "0"},
            "attribute1": {"B": data},  # Binary data for test payload
            "attribute2": {"S": "sign me!"},
            ":attribute3": {"S": "ignore me!"},  # Unsigned attribute
        }

        # Measure encryption latency
        encrypt_start = time.perf_counter()
        encrypted_item = encrypt_dynamodb_item(plaintext_item, self.legacy_crypto_config)
        encrypt_time = (time.perf_counter() - encrypt_start) * 1000.0

        # Measure decryption latency
        decrypt_start = time.perf_counter()
        # Make a copy to avoid mutating the original encrypted item
        encrypted_item_copy = encrypted_item.copy()
        decrypted_item = decrypt_dynamodb_item(encrypted_item_copy, self.legacy_crypto_config)
        decrypt_time = (time.perf_counter() - decrypt_start) * 1000.0

        return BenchmarkResult(put_latency_ms=encrypt_time, get_latency_ms=decrypt_time)


    # def run_batch_read_write_cycle(self, item_size_kb: int = 200, batch_size: int = 6) -> BenchmarkResult:
    #     """
    #     Run batch read/write cycle with specified item size and batch size.
    #     Creates items with same partition key and incremental sort keys.
    #
    #     Args:
    #         item_size_kb: Size of each item in KB (default: 200KB)
    #         batch_size: Number of items in batch (default: 25)
    #
    #     Returns:
    #         BenchmarkResult with batch put and get latencies
    #     """
    #     # Create EncryptedResource for batch operations
    #     encrypted_resource = self._setup_encrypted_resource()
    #
    #     # Generate test data for the specified item size
    #     item_data = secrets.token_bytes(item_size_kb * 1024)  # Convert KB to bytes
    #     partition_key = "batch-benchmark-test"
    #
    #     # Create batch of items with same partition key and incremental sort keys
    #     items = []
    #     for i in range(batch_size):
    #         item = {
    #             "partition_key": partition_key,
    #             "sort_key": i,
    #             "attribute1": {"data": item_data},  # Large test payload
    #             "attribute2": f"batch_item_{i}",
    #             ":attribute3": f"unsigned_data_{i}",
    #         }
    #         items.append(item)
    #
    #     # Prepare batch write request
    #     batch_write_request = {
    #         "RequestItems": {
    #             self.table_name: [{"PutRequest": {"Item": item}} for item in items],
    #         },
    #     }
    #
    #     # Measure batch write latency
    #     batch_write_start = time.perf_counter()
    #     batch_write_response = encrypted_resource.batch_write_item(**batch_write_request)
    #     batch_write_time = (time.perf_counter() - batch_write_start) * 1000.0
    #
    #     # Verify batch write succeeded
    #     if batch_write_response["ResponseMetadata"]["HTTPStatusCode"] != 200:
    #         raise RuntimeError(f"Batch write failed with status: {batch_write_response['ResponseMetadata']['HTTPStatusCode']}")
    #
    #     # Prepare batch get request
    #     batch_get_request = {
    #         "RequestItems": {
    #             self.table_name: {
    #                 "Keys": [{"partition_key": partition_key, "sort_key": i} for i in range(batch_size)],
    #             }
    #         },
    #     }
    #
    #     # Measure batch get latency
    #     batch_get_start = time.perf_counter()
    #     batch_get_response = encrypted_resource.batch_get_item(**batch_get_request)
    #     batch_get_time = (time.perf_counter() - batch_get_start) * 1000.0
    #
    #     # Verify batch get succeeded and returned expected items
    #     if batch_get_response["ResponseMetadata"]["HTTPStatusCode"] != 200:
    #         raise RuntimeError(f"Batch get failed with status: {batch_get_response['ResponseMetadata']['HTTPStatusCode']}")
    #
    #     retrieved_items = batch_get_response["Responses"][self.table_name]
    #     if len(retrieved_items) != batch_size:
    #         raise RuntimeError(f"Expected {batch_size} items, got {len(retrieved_items)}")
    #
    #     # Clean up: Delete the batch items
    #     batch_delete_request = {
    #         "RequestItems": {
    #             self.table_name: [
    #                 {"DeleteRequest": {"Key": {"partition_key": partition_key, "sort_key": i}}}
    #                 for i in range(batch_size)
    #             ],
    #         },
    #     }
    #
    #     try:
    #         encrypted_resource.batch_write_item(**batch_delete_request)
    #     except Exception as e:
    #         print(f"Warning: Failed to clean up batch items: {e}")
    #
    #     return BenchmarkResult(put_latency_ms=batch_write_time, get_latency_ms=batch_get_time)
    #
    # def _setup_encrypted_resource(self) -> EncryptedResource:
    #     """Setup EncryptedResource for batch operations."""
    #     attribute_actions_on_encrypt = {
    #         "partition_key": CryptoAction.SIGN_ONLY,
    #         "sort_key": CryptoAction.SIGN_ONLY,
    #         "attribute1": CryptoAction.ENCRYPT_AND_SIGN,
    #         "attribute2": CryptoAction.SIGN_ONLY,
    #         ":attribute3": CryptoAction.DO_NOTHING,
    #     }
    #
    #     table_config = DynamoDbTableEncryptionConfig(
    #         logical_table_name=self.table_name,
    #         partition_key_name="partition_key",
    #         sort_key_name="sort_key",
    #         attribute_actions_on_encrypt=attribute_actions_on_encrypt,
    #         keyring=self.keyring,
    #         allowed_unsigned_attribute_prefix=":",
    #         algorithm_suite_id=DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384,
    #     )
    #
    #     table_configs = {self.table_name: table_config}
    #     tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)
    #
    #     return EncryptedResource(
    #         resource=boto3.resource("dynamodb"),
    #         encryption_config=tables_config,
    #     )

    def run_all_benchmarks(self) -> List[TestResult]:
        print("Starting comprehensive ESDK benchmark suite")
        all_results = []

        # Collect all data sizes from config
        data_sizes = []
        for size_list in [self.config.data_sizes.small, self.config.data_sizes.medium, self.config.data_sizes.large]:
            if size_list:
                data_sizes.extend(size_list)

        concurrent_levels = [c for c in self.config.concurrency_levels if c > 1]  # Skip single-threaded for concurrent tests
        total_tests = len(data_sizes) * (2 + len(concurrent_levels))  # throughput + memory + concurrent tests
        print(f"Running {total_tests} total tests")

        with tqdm(total=total_tests, desc="Running benchmarks") as pbar:
            for data_size in data_sizes:
                # Throughput test
                try:
                    result = Tests.run_throughput_test(self, data_size, self.config.iterations.measurement)
                    if result:
                        all_results.append(result)
                        print(f"Throughput test completed: {result.ops_per_second:.2f} ops/sec")
                except Exception as e:
                    print(f"Throughput test failed for data size {data_size} bytes: {e}")
                pbar.update(1)

                # Memory test
                try:
                    result = Tests.run_memory_test(self, data_size)
                    all_results.append(result)
                    print(f"Memory test completed: {result.peak_memory_mb:.2f} MB peak")
                except Exception as e:
                    print(f"Memory test failed for data size {data_size} bytes: {e}")
                pbar.update(1)

                # Concurrent tests
                for concurrency in concurrent_levels:
                    try:
                        result = Tests.run_concurrent_test(self, data_size, concurrency, 5)
                        all_results.append(result)
                        print(f"Concurrent test completed: {result.ops_per_second:.2f} ops/sec @ {concurrency} threads")
                    except Exception as e:
                        print(f"Concurrent test failed for data size {data_size} bytes with {concurrency} threads: {e}")
                    pbar.update(1)

        print(f"Benchmark suite completed. Total results: {len(all_results)}")
        return all_results

    def get_system_info(self) -> Dict[str, Any]:
        return {
            "cpu_count": self.cpu_count,
            "total_memory_mb": self.total_memory_mb,
            "platform": psutil.platform,
            "python_version": f"{psutil.sys.version_info.major}.{psutil.sys.version_info.minor}.{psutil.sys.version_info.micro}",
        }