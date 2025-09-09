# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
DB-ESDK Performance Benchmark Suite - Python Implementation

This module provides comprehensive performance testing for the AWS Database Encryption SDK (DB-ESDK) Python
runtime, measuring throughput, latency, memory usage, and scalability using DynamoDB operations.
"""

import os
import secrets
import time
from typing import Dict, List, NamedTuple, Any

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
from aws_dbesdk_dynamodb.structures.item_encryptor import DynamoDbItemEncryptorConfig
from aws_dbesdk_dynamodb.structures.structured_encryption import CryptoAction

from .models import Config, TestResult
from .tests import Tests


class BenchmarkResult(NamedTuple):
    """Result from a single encrypt/decrypt cycle."""

    put_latency_ms: float
    get_latency_ms: float


class ESDKBenchmark:
    """
    DB-ESDK Performance Benchmark Suite - Python Implementation

    This class provides comprehensive performance testing for the AWS Database Encryption SDK (DB-ESDK) Python
    runtime, measuring throughput, latency, memory usage, and scalability using DynamoDB operations.
    """

    def __init__(self, config_path: str):
        """Initialize the benchmark with configuration."""
        self.config = Config.load_config(config_path)

        # System information
        self.cpu_count = psutil.cpu_count(logical=True)
        self.total_memory_mb = psutil.virtual_memory().total / (1024 * 1024)

        # Table name for testing
        self.table_name = self.config.table_name or "db-esdk-performance-test"

        # Setup DB-ESDK components
        self.keyring = self._setup_keyring()
        self.item_encryptor = self._setup_item_encryptor()

        print(
            f"Initialized DB-ESDK Benchmark - CPU cores: {self.cpu_count}, Memory: {self.total_memory_mb / 1024.0:.1f}GB"
        )

    def _setup_keyring(self) -> IKeyring:
        """Setup Raw AES keyring for testing."""
        # Generate a 256-bit AES key for testing
        encryption_key = secrets.token_bytes(32)  # 256 bits

        # Create Raw AES keyring using Material Providers
        key_namespace = "db-esdk-performance-test"
        key_name = "test-aes-256-key"

        mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

        keyring_input = CreateRawAesKeyringInput(
            key_name=key_name,
            key_namespace=key_namespace,
            wrapping_key=encryption_key,
            wrapping_alg=AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16,
        )

        return mat_prov.create_raw_aes_keyring(input=keyring_input)

    def _setup_item_encryptor(self) -> ItemEncryptor:
        """Setup ItemEncryptor client with encryption configuration."""
        # Configure attribute actions for encryption
        attribute_actions_on_encrypt = {
            "partition_key": CryptoAction.SIGN_ONLY,
            "sort_key": CryptoAction.SIGN_ONLY,
            "attribute1": CryptoAction.ENCRYPT_AND_SIGN,
            "attribute2": CryptoAction.SIGN_ONLY,
            ":attribute3": CryptoAction.DO_NOTHING,
        }

        # Configure table encryption
        table_config = DynamoDbItemEncryptorConfig(
            logical_table_name=self.table_name,
            partition_key_name="partition_key",
            sort_key_name="sort_key",
            attribute_actions_on_encrypt=attribute_actions_on_encrypt,
            keyring=self.keyring,
            allowed_unsigned_attribute_prefix=":",
            algorithm_suite_id=DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384,
        )

        return ItemEncryptor(table_config)

    def run_item_encryptor_cycle(self, data: bytes) -> BenchmarkResult:
        """
        Run a single encrypt-decrypt cycle and measure performance.

        Args:
            data: Data to encrypt/decrypt

        Returns:
            BenchmarkResult with timing information
        """
        # Create item with test data (using Python dict format)
        plaintext_item = {
            "partition_key": "benchmark-test",
            "sort_key": 0,
            "attribute1": {"data": data},
            "attribute2": "sign me!",
            ":attribute3": "ignore me!",
        }

        # Measure encryption time
        encrypt_start = time.perf_counter()
        encrypt_output = self.item_encryptor.encrypt_python_item(plaintext_item)
        encrypted_item = encrypt_output.encrypted_item
        encrypt_time = (
            time.perf_counter() - encrypt_start
        ) * 1000.0  # Convert to milliseconds

        # Measure decryption time
        decrypt_start = time.perf_counter()
        decrypt_output = self.item_encryptor.decrypt_python_item(encrypted_item)
        decrypted_item = decrypt_output.plaintext_item
        decrypt_time = (
            time.perf_counter() - decrypt_start
        ) * 1000.0  # Convert to milliseconds

        return BenchmarkResult(put_latency_ms=encrypt_time, get_latency_ms=decrypt_time)

    def run_all_benchmarks(self) -> List[TestResult]:
        """Run the complete benchmark suite."""
        print("Starting comprehensive ESDK benchmark suite")
        all_results = []

        # Get test parameters from config
        data_sizes = []
        if self.config.data_sizes.small:
            data_sizes.extend(self.config.data_sizes.small)
        if self.config.data_sizes.medium:
            data_sizes.extend(self.config.data_sizes.medium)
        if self.config.data_sizes.large:
            data_sizes.extend(self.config.data_sizes.large)

        # Calculate total tests
        throughput_tests = len(data_sizes)
        memory_tests = len(data_sizes)
        concurrent_tests = len(data_sizes) * len(
            [c for c in self.config.concurrency_levels if c > 1]
        )
        total_tests = throughput_tests + memory_tests + concurrent_tests

        print(f"Running {total_tests} total tests")

        # Use tqdm for overall progress
        with tqdm(total=total_tests, desc="Running benchmarks") as pbar:
            # Throughput tests
            for data_size in data_sizes:
                try:
                    result = Tests.run_throughput_test(
                        self, data_size, self.config.iterations.measurement
                    )
                    if result:
                        all_results.append(result)
                        print(
                            f"Throughput test completed: {result.ops_per_second:.2f} ops/sec"
                        )
                except Exception as e:
                    print(
                        f"Throughput test failed for data size {data_size} bytes: {e}"
                    )
                pbar.update(1)

            # Memory tests
            for data_size in data_sizes:
                try:
                    result = Tests.run_memory_test(self, data_size)
                    all_results.append(result)
                    print(f"Memory test completed: {result.peak_memory_mb:.2f} MB peak")
                except Exception as e:
                    print(f"Memory test failed for data size {data_size} bytes: {e}")
                pbar.update(1)

            # Concurrent tests
            for data_size in data_sizes:
                for concurrency in self.config.concurrency_levels:
                    if concurrency > 1:  # Skip single-threaded for concurrent tests
                        try:
                            result = Tests.run_concurrent_test(
                                self, data_size, concurrency, 5
                            )
                            all_results.append(result)
                            print(
                                f"Concurrent test completed: {result.ops_per_second:.2f} ops/sec @ {concurrency} threads"
                            )
                        except Exception as e:
                            print(
                                f"Concurrent test failed for data size {data_size} bytes with {concurrency} threads: {e}"
                            )
                        pbar.update(1)

        print(f"Benchmark suite completed. Total results: {len(all_results)}")
        return all_results

    def get_system_info(self) -> Dict[str, Any]:
        """Get system information for benchmarking context."""
        return {
            "cpu_count": self.cpu_count,
            "total_memory_mb": self.total_memory_mb,
            "platform": psutil.platform,
            "python_version": f"{psutil.sys.version_info.major}.{psutil.sys.version_info.minor}.{psutil.sys.version_info.micro}",
        }
