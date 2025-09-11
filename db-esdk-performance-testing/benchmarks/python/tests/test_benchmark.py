# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Basic tests for the DB-ESDK Performance Benchmark Suite.

These tests validate the core functionality of the benchmark components.
"""

import tempfile
import json
from pathlib import Path
from unittest.mock import patch, MagicMock

import pytest

from esdk_benchmark.models import Config, TestResult, DataSizes, Iterations


class TestConfig:
    """Test configuration loading and manipulation."""

    def test_config_creation(self):
        """Test basic config creation."""
        config = Config()
        assert config.table_name == "dbesdk-performance-testing"
        assert config.keyring == "raw-aes"
        assert config.concurrency_levels == [1, 2, 4, 8]

    def test_config_load_from_yaml(self):
        """Test loading configuration from YAML."""
        yaml_content = """
data_sizes:
  small: [1024, 5120]
  medium: [102400]
  
iterations:
  warmup: 3
  measurement: 5

concurrency_levels: [1, 2]
table_name: "test-table"
keyring: "test-keyring"
"""

        with tempfile.NamedTemporaryFile(mode="w", suffix=".yaml", delete=False) as f:
            f.write(yaml_content)
            f.flush()

            try:
                config = Config.load_config(f.name)
                assert config.data_sizes.small == [1024, 5120]
                assert config.data_sizes.medium == [102400]
                assert config.iterations.warmup == 3
                assert config.iterations.measurement == 5
                assert config.concurrency_levels == [1, 2]
                assert config.table_name == "test-table"
                assert config.keyring == "test-keyring"
            finally:
                Path(f.name).unlink()

    def test_config_quick_test_adjustment(self):
        """Test quick test configuration adjustment."""
        yaml_content = """
data_sizes:
  small: [1024, 5120]
  medium: [102400]
  
iterations:
  warmup: 5
  measurement: 10

concurrency_levels: [1, 2, 4, 8]

quick_config:
  data_sizes:
    small: [1024]
  iterations:
    warmup: 2
    measurement: 3
  concurrency_levels: [1, 2]
"""

        with tempfile.NamedTemporaryFile(mode="w", suffix=".yaml", delete=False) as f:
            f.write(yaml_content)
            f.flush()

            try:
                config = Config.load_config(f.name)

                # Before adjustment
                assert config.data_sizes.small == [1024, 5120]
                assert config.iterations.warmup == 5
                assert config.iterations.measurement == 10
                assert config.concurrency_levels == [1, 2, 4, 8]

                # After adjustment
                config.adjust_for_quick_test()
                assert config.data_sizes.small == [1024]
                assert config.iterations.warmup == 2
                assert config.iterations.measurement == 3
                assert config.concurrency_levels == [1, 2]
            finally:
                Path(f.name).unlink()


class TestTestResult:
    """Test TestResult creation and serialization."""

    def test_throughput_result_creation(self):
        """Test creating a throughput test result."""
        encrypt_latencies = [1.0, 1.1, 0.9, 1.2, 1.0]
        decrypt_latencies = [0.8, 0.9, 0.7, 1.0, 0.8]
        total_latencies = [1.8, 2.0, 1.6, 2.2, 1.8]

        result = TestResult.create_throughput_result(
            encrypt_latencies=encrypt_latencies,
            decrypt_latencies=decrypt_latencies,
            total_latencies=total_latencies,
            data_size=1024,
            cpu_count=8,
            total_memory_mb=16384,
        )

        assert result.test_name == "throughput"
        assert result.data_size == 1024
        assert result.put_latency_ms == 1.04  # mean of encrypt_latencies
        assert result.get_latency_ms == 0.84  # mean of decrypt_latencies
        assert result.end_to_end_latency_ms == 1.88  # mean of total_latencies
        assert result.ops_per_second > 0
        assert result.bytes_per_second > 0
        assert result.p50_latency > 0
        assert result.p95_latency > 0
        assert result.p99_latency > 0

    def test_memory_result_creation(self):
        """Test creating a memory test result."""
        result = TestResult.create_memory_result(
            peak_memory_mb=50.0,
            avg_memory_mb=35.0,
            data_size=1024,
            cpu_count=8,
            total_memory_mb=16384,
        )

        assert result.test_name == "memory"
        assert result.data_size == 1024
        assert result.peak_memory_mb == 50.0
        assert result.memory_efficiency_ratio > 0

    def test_concurrent_result_creation(self):
        """Test creating a concurrent test result."""
        all_times = [1.5, 1.8, 1.2, 2.0, 1.6, 1.9, 1.4, 1.7]

        result = TestResult.create_concurrent_result(
            all_times=all_times,
            total_operations=len(all_times),
            data_size=1024,
            concurrency=4,
            cpu_count=8,
            total_memory_mb=16384,
        )

        assert result.test_name == "concurrency"
        assert result.data_size == 1024
        assert result.concurrency == 4
        assert result.ops_per_second > 0
        assert result.bytes_per_second > 0
        assert result.p50_latency > 0
        assert result.p95_latency > 0
        assert result.p99_latency > 0

    def test_result_serialization(self):
        """Test TestResult serialization to dictionary."""
        result = TestResult(
            test_name="test",
            data_size=1024,
            concurrency=2,
            ops_per_second=100.0,
            bytes_per_second=102400.0,
        )

        result_dict = result.to_dict()

        assert isinstance(result_dict, dict)
        assert result_dict["test_name"] == "test"
        assert result_dict["data_size"] == 1024
        assert result_dict["concurrency"] == 2
        assert result_dict["ops_per_second"] == 100.0
        assert result_dict["bytes_per_second"] == 102400.0
        assert "timestamp" in result_dict
        assert "python_version" in result_dict


class TestBenchmark:
    """Test benchmark functionality with mocked dependencies."""

    @patch("esdk_benchmark.benchmark.AwsCryptographicMaterialProviders")
    @patch("esdk_benchmark.benchmark.ItemEncryptor")
    def test_benchmark_initialization(
        self, mock_item_encryptor, mock_material_providers
    ):
        """Test benchmark initialization with mocked dependencies."""
        # Mock the material providers and keyring
        mock_mat_prov = MagicMock()
        mock_keyring = MagicMock()
        mock_mat_prov.create_raw_aes_keyring.return_value = mock_keyring
        mock_material_providers.return_value = mock_mat_prov

        # Mock the item encryptor
        mock_encryptor = MagicMock()
        mock_item_encryptor.return_value = mock_encryptor

        # Create a temporary config file
        yaml_content = """
data_sizes:
  small: [1024]
iterations:
  warmup: 1
  measurement: 2
concurrency_levels: [1]
"""

        with tempfile.NamedTemporaryFile(mode="w", suffix=".yaml", delete=False) as f:
            f.write(yaml_content)
            f.flush()

            try:
                from esdk_benchmark.benchmark import ESDKBenchmark

                benchmark = ESDKBenchmark(f.name)

                assert benchmark.config is not None
                assert benchmark.keyring == mock_keyring
                assert benchmark.item_encryptor == mock_encryptor
                assert benchmark.cpu_count > 0
                assert benchmark.total_memory_mb > 0
            finally:
                Path(f.name).unlink()


def test_imports():
    """Test that all required modules can be imported."""
    # Test basic imports
    import esdk_benchmark
    from esdk_benchmark import models, benchmark, tests, program

    # Test that key classes are available
    assert hasattr(models, "Config")
    assert hasattr(models, "TestResult")
    assert hasattr(models, "Report")
    assert hasattr(benchmark, "ESDKBenchmark")
    assert hasattr(tests, "Tests")
    assert hasattr(program, "main")


if __name__ == "__main__":
    pytest.main([__file__])
