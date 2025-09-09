# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Data models for the DB-ESDK Performance Benchmark Suite.

This module defines the data structures used throughout the benchmark suite,
including configuration, test results, and reporting models.
"""

import json
import platform
import sys
from dataclasses import dataclass, field
from datetime import datetime
from pathlib import Path
from typing import Dict, List, Optional, Union
from statistics import median, mean

import psutil
import yaml
from pydantic import BaseModel


@dataclass
class DataSizes:
    """Configuration for data sizes to test."""

    small: Optional[List[int]] = None
    medium: Optional[List[int]] = None
    large: Optional[List[int]] = None


@dataclass
class Iterations:
    """Configuration for test iterations."""

    warmup: int = 5
    measurement: int = 10


@dataclass
class QuickConfig:
    """Configuration for quick tests."""

    data_sizes: DataSizes = field(default_factory=DataSizes)
    iterations: Iterations = field(default_factory=Iterations)
    concurrency_levels: List[int] = field(default_factory=lambda: [1, 2])
    test_types: List[str] = field(
        default_factory=lambda: ["throughput", "memory", "concurrency"]
    )


@dataclass
class Config:
    """Main configuration for benchmark tests."""

    data_sizes: DataSizes = field(default_factory=DataSizes)
    iterations: Iterations = field(default_factory=Iterations)
    concurrency_levels: List[int] = field(default_factory=lambda: [1, 2, 4, 8])
    table_name: str = "dbesdk-performance-testing"
    keyring: str = "raw-aes"
    quick_config: Optional[QuickConfig] = None

    @classmethod
    def load_config(cls, config_path: str) -> "Config":
        """Load configuration from YAML file."""
        config_file = Path(config_path)
        if not config_file.exists():
            raise FileNotFoundError(f"Configuration file not found: {config_path}")

        with open(config_file, "r") as f:
            data = yaml.safe_load(f)

        # Parse data sizes
        data_sizes_data = data.get("data_sizes", {})
        data_sizes = DataSizes(
            small=data_sizes_data.get("small"),
            medium=data_sizes_data.get("medium"),
            large=data_sizes_data.get("large"),
        )

        # Parse iterations
        iterations_data = data.get("iterations", {})
        iterations = Iterations(
            warmup=iterations_data.get("warmup", 5),
            measurement=iterations_data.get("measurement", 10),
        )

        # Parse quick config if present
        quick_config = None
        if "quick_config" in data:
            quick_data = data["quick_config"]
            quick_data_sizes_data = quick_data.get("data_sizes", {})
            quick_data_sizes = DataSizes(
                small=quick_data_sizes_data.get("small"),
                medium=quick_data_sizes_data.get("medium"),
                large=quick_data_sizes_data.get("large"),
            )
            quick_iterations_data = quick_data.get("iterations", {})
            quick_iterations = Iterations(
                warmup=quick_iterations_data.get("warmup", 3),
                measurement=quick_iterations_data.get("measurement", 3),
            )
            quick_config = QuickConfig(
                data_sizes=quick_data_sizes,
                iterations=quick_iterations,
                concurrency_levels=quick_data.get("concurrency_levels", [1, 2]),
                test_types=quick_data.get(
                    "test_types", ["throughput", "memory", "concurrency"]
                ),
            )

        return cls(
            data_sizes=data_sizes,
            iterations=iterations,
            concurrency_levels=data.get("concurrency_levels", [1, 2, 4, 8]),
            table_name=data.get("table_name", "dbesdk-performance-testing"),
            keyring=data.get("keyring", "raw-aes"),
            quick_config=quick_config,
        )

    def adjust_for_quick_test(self):
        """Adjust configuration for quick testing."""
        if self.quick_config:
            self.data_sizes = self.quick_config.data_sizes
            self.iterations = self.quick_config.iterations
            self.concurrency_levels = self.quick_config.concurrency_levels


@dataclass
class BenchmarkMetadata:
    """Metadata about the benchmark environment."""

    language: str = "python"
    timestamp: str = field(default_factory=lambda: datetime.utcnow().isoformat() + "Z")
    python_version: str = field(
        default_factory=lambda: f"{sys.version_info.major}.{sys.version_info.minor}.{sys.version_info.micro}"
    )
    platform: str = field(default_factory=platform.platform)
    cpu_count: int = field(default_factory=lambda: psutil.cpu_count(logical=True))
    total_memory_gb: float = field(
        default_factory=lambda: psutil.virtual_memory().total / (1024**3)
    )
    total_tests: int = 0


@dataclass
class TestResult:
    """Single test result with all metrics."""

    test_name: str
    language: str = "python"
    data_size: int = 0
    concurrency: int = 1
    put_latency_ms: float = 0.0
    get_latency_ms: float = 0.0
    end_to_end_latency_ms: float = 0.0
    ops_per_second: float = 0.0
    bytes_per_second: float = 0.0
    peak_memory_mb: float = 0.0
    memory_efficiency_ratio: float = 0.0
    p50_latency: float = 0.0
    p95_latency: float = 0.0
    p99_latency: float = 0.0
    timestamp: str = field(default_factory=lambda: datetime.utcnow().isoformat() + "Z")
    python_version: str = field(
        default_factory=lambda: f"{sys.version_info.major}.{sys.version_info.minor}.{sys.version_info.micro}"
    )
    cpu_count: int = field(default_factory=lambda: psutil.cpu_count(logical=True))
    total_memory_gb: float = field(
        default_factory=lambda: psutil.virtual_memory().total / (1024**3)
    )

    @classmethod
    def create_throughput_result(
        cls,
        encrypt_latencies: List[float],
        decrypt_latencies: List[float],
        total_latencies: List[float],
        data_size: int,
        cpu_count: int,
        total_memory_mb: float,
    ) -> "TestResult":
        """Create a throughput test result."""
        if not total_latencies:
            raise ValueError("No latency data provided for throughput result")

        # Calculate percentiles
        sorted_latencies = sorted(total_latencies)
        p50 = sorted_latencies[int(len(sorted_latencies) * 0.5)]
        p95 = sorted_latencies[int(len(sorted_latencies) * 0.95)]
        p99 = sorted_latencies[int(len(sorted_latencies) * 0.99)]

        # Calculate averages
        avg_encrypt = mean(encrypt_latencies) if encrypt_latencies else 0.0
        avg_decrypt = mean(decrypt_latencies) if decrypt_latencies else 0.0
        avg_total = mean(total_latencies)

        # Calculate throughput (operations per second)
        ops_per_second = 1000.0 / avg_total if avg_total > 0 else 0.0
        bytes_per_second = ops_per_second * data_size

        return cls(
            test_name="throughput",
            data_size=data_size,
            put_latency_ms=avg_encrypt,
            get_latency_ms=avg_decrypt,
            end_to_end_latency_ms=avg_total,
            ops_per_second=ops_per_second,
            bytes_per_second=bytes_per_second,
            p50_latency=p50,
            p95_latency=p95,
            p99_latency=p99,
            cpu_count=cpu_count,
            total_memory_gb=total_memory_mb / 1024.0,
        )

    @classmethod
    def create_memory_result(
        cls,
        peak_memory_mb: float,
        avg_memory_mb: float,
        data_size: int,
        cpu_count: int,
        total_memory_mb: float,
    ) -> "TestResult":
        """Create a memory test result."""
        memory_efficiency = (
            data_size / (1024 * 1024) / peak_memory_mb if peak_memory_mb > 0 else 0.0
        )

        return cls(
            test_name="memory",
            data_size=data_size,
            peak_memory_mb=peak_memory_mb,
            memory_efficiency_ratio=memory_efficiency,
            cpu_count=cpu_count,
            total_memory_gb=total_memory_mb / 1024.0,
        )

    @classmethod
    def create_concurrent_result(
        cls,
        all_times: List[float],
        total_operations: int,
        data_size: int,
        concurrency: int,
        cpu_count: int,
        total_memory_mb: float,
    ) -> "TestResult":
        """Create a concurrent test result."""
        if not all_times:
            raise ValueError("No timing data provided for concurrent result")

        # Calculate metrics
        avg_latency = mean(all_times)
        sorted_times = sorted(all_times)
        p50 = sorted_times[int(len(sorted_times) * 0.5)]
        p95 = sorted_times[int(len(sorted_times) * 0.95)]
        p99 = sorted_times[int(len(sorted_times) * 0.99)]

        # Calculate throughput
        ops_per_second = 1000.0 / avg_latency if avg_latency > 0 else 0.0
        bytes_per_second = ops_per_second * data_size

        return cls(
            test_name="concurrency",
            data_size=data_size,
            concurrency=concurrency,
            end_to_end_latency_ms=avg_latency,
            ops_per_second=ops_per_second,
            bytes_per_second=bytes_per_second,
            p50_latency=p50,
            p95_latency=p95,
            p99_latency=p99,
            cpu_count=cpu_count,
            total_memory_gb=total_memory_mb / 1024.0,
        )

    def to_dict(self) -> Dict:
        """Convert to dictionary for JSON serialization."""
        return {
            "test_name": self.test_name,
            "language": self.language,
            "data_size": self.data_size,
            "concurrency": self.concurrency,
            "put_latency_ms": self.put_latency_ms,
            "get_latency_ms": self.get_latency_ms,
            "end_to_end_latency_ms": self.end_to_end_latency_ms,
            "ops_per_second": self.ops_per_second,
            "bytes_per_second": self.bytes_per_second,
            "peak_memory_mb": self.peak_memory_mb,
            "memory_efficiency_ratio": self.memory_efficiency_ratio,
            "p50_latency": self.p50_latency,
            "p95_latency": self.p95_latency,
            "p99_latency": self.p99_latency,
            "timestamp": self.timestamp,
            "python_version": self.python_version,
            "cpu_count": self.cpu_count,
            "total_memory_gb": self.total_memory_gb,
        }


class Report:
    """Report generation and output management."""

    @staticmethod
    def save_results(
        results: List[TestResult],
        output_path: str,
        cpu_count: int,
        total_memory_mb: float,
    ):
        """Save benchmark results to JSON file."""
        metadata = BenchmarkMetadata(
            cpu_count=cpu_count,
            total_memory_gb=total_memory_mb / 1024.0,
            total_tests=len(results),
        )

        report_data = {
            "metadata": {
                "language": metadata.language,
                "timestamp": metadata.timestamp,
                "python_version": metadata.python_version,
                "platform": metadata.platform,
                "cpu_count": metadata.cpu_count,
                "total_memory_gb": metadata.total_memory_gb,
                "total_tests": metadata.total_tests,
            },
            "results": [result.to_dict() for result in results],
        }

        # Ensure output directory exists
        output_file = Path(output_path)
        output_file.parent.mkdir(parents=True, exist_ok=True)

        # Write results
        with open(output_file, "w") as f:
            json.dump(report_data, f, indent=2)

        print(f"Results saved to: {output_path}")
