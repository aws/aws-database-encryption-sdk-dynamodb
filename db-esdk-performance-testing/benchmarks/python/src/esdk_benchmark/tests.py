# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Test implementations for the DB-ESDK Performance Benchmark Suite.

This module contains the individual test implementations for throughput, memory usage,
and concurrent performance testing.
"""

import gc
import os
import secrets
import threading
import time
from concurrent.futures import ThreadPoolExecutor, as_completed
from statistics import mean
from typing import List, NamedTuple, Optional, TYPE_CHECKING

import psutil
from tqdm import tqdm

if TYPE_CHECKING:
    from .benchmark import ESDKBenchmark

from .models import TestResult


class MeasurementResults(NamedTuple):
    """Results from measurement iterations."""

    encrypt_latencies: List[float]
    decrypt_latencies: List[float]
    total_latencies: List[float]


class MemoryResults(NamedTuple):
    """Results from memory testing."""

    peak_memory_mb: float
    avg_memory_mb: float


class MemorySample(NamedTuple):
    """Single memory sample."""

    heap_mb: float
    timestamp: float


class IterationResult(NamedTuple):
    """Result from a single memory test iteration."""

    peak_memory: float
    avg_memory: float


class Tests:
    """Test implementations for the benchmark suite."""

    # Constants for memory testing
    MEMORY_TEST_ITERATIONS = 5
    SAMPLING_INTERVAL_MS = 1
    GC_SETTLE_TIME_MS = 5
    FINAL_SAMPLE_WAIT_MS = 2

    @staticmethod
    def run_throughput_test(
        benchmark: "ESDKBenchmark", data_size: int, iterations: int
    ) -> Optional[TestResult]:
        """Run throughput benchmark test."""
        print(
            f"Running throughput test - Size: {data_size} bytes, Iterations: {iterations}"
        )

        data = secrets.token_bytes(data_size)

        # Warmup - run measurement but drop results
        Tests._run_measurement_iterations(
            benchmark, data, benchmark.config.iterations.warmup
        )

        # Measurement runs
        results = Tests._run_measurement_iterations(benchmark, data, iterations)

        if not results.total_latencies:
            print("All test iterations failed")
            return None

        return TestResult.create_throughput_result(
            results.encrypt_latencies,
            results.decrypt_latencies,
            results.total_latencies,
            data_size,
            benchmark.cpu_count,
            benchmark.total_memory_mb,
        )

    @staticmethod
    def _run_measurement_iterations(
        benchmark: "ESDKBenchmark", data: bytes, iterations: int
    ) -> MeasurementResults:
        """Run measurement iterations and collect timing data."""
        encrypt_latencies = []
        decrypt_latencies = []
        total_latencies = []

        for i in range(iterations):
            try:
                iteration_start = time.perf_counter()
                result = benchmark.run_item_encryptor_cycle(data)
                total_ms = (time.perf_counter() - iteration_start) * 1000.0

                encrypt_latencies.append(result.put_latency_ms)
                decrypt_latencies.append(result.get_latency_ms)
                total_latencies.append(total_ms)
            except Exception as e:
                print(f"Iteration {i} failed: {e}")

        return MeasurementResults(encrypt_latencies, decrypt_latencies, total_latencies)

    @staticmethod
    def run_memory_test(benchmark: "ESDKBenchmark", data_size: int) -> TestResult:
        """Run memory usage benchmark test."""
        print(
            f"Running memory test - Size: {data_size} bytes ({Tests.MEMORY_TEST_ITERATIONS} iterations, continuous sampling)"
        )

        data = secrets.token_bytes(data_size)
        memory_results = Tests._sample_memory_during_operations(benchmark, data)

        if memory_results is None:
            raise RuntimeError(
                f"Memory test failed: Unable to collect memory samples for data size {data_size} bytes"
            )

        return TestResult.create_memory_result(
            memory_results.peak_memory_mb,
            memory_results.avg_memory_mb,
            data_size,
            benchmark.cpu_count,
            benchmark.total_memory_mb,
        )

    @staticmethod
    def _sample_memory_during_operations(
        benchmark: "ESDKBenchmark", data: bytes
    ) -> Optional[MemoryResults]:
        """Sample memory usage during benchmark operations."""
        peak_memory_delta = 0.0
        avg_memory_values = []

        for i in range(Tests.MEMORY_TEST_ITERATIONS):
            iteration_result = Tests._run_single_memory_iteration(
                benchmark, data, i + 1
            )

            if iteration_result.peak_memory > peak_memory_delta:
                peak_memory_delta = iteration_result.peak_memory

            avg_memory_values.append(iteration_result.avg_memory)

        overall_avg_memory = mean(avg_memory_values) if avg_memory_values else 0.0

        print(f"\nMemory Summary:")
        print(f"- Absolute Peak Heap: {peak_memory_delta:.2f} MB (across all runs)")
        print(f"- Average Heap: {overall_avg_memory:.2f} MB (across all runs)")

        return MemoryResults(peak_memory_delta, overall_avg_memory)

    @staticmethod
    def _run_single_memory_iteration(
        benchmark: "ESDKBenchmark", data: bytes, iteration: int
    ) -> IterationResult:
        """Run a single memory test iteration with continuous sampling."""
        # Force garbage collection and settle
        gc.collect()
        gc.collect()
        time.sleep(Tests.GC_SETTLE_TIME_MS / 1000.0)

        # Get process for memory monitoring
        process = psutil.Process()

        # Baseline memory measurement
        baseline_memory = process.memory_info().rss / (1024 * 1024)  # MB

        memory_samples = []
        sampling_active = threading.Event()
        sampling_active.set()

        operation_start = time.perf_counter()

        def memory_sampler():
            """Background thread to sample memory usage."""
            while sampling_active.is_set():
                try:
                    current_memory = process.memory_info().rss / (1024 * 1024)  # MB
                    heap_delta = max(0, current_memory - baseline_memory)

                    if heap_delta > 0:
                        memory_samples.append(
                            MemorySample(heap_delta, time.perf_counter())
                        )

                    time.sleep(Tests.SAMPLING_INTERVAL_MS / 1000.0)
                except Exception:
                    break

        # Start background sampling
        sampling_thread = threading.Thread(target=memory_sampler, daemon=True)
        sampling_thread.start()

        # Run the actual operation
        try:
            benchmark.run_item_encryptor_cycle(data)
        except Exception as e:
            print(f"Memory test iteration {iteration} failed: {e}")
            sampling_active.clear()
            return IterationResult(0.0, 0.0)

        operation_duration_ms = (time.perf_counter() - operation_start) * 1000.0

        # Stop sampling and wait for completion
        time.sleep(Tests.FINAL_SAMPLE_WAIT_MS / 1000.0)
        sampling_active.clear()
        sampling_thread.join(timeout=0.1)

        return Tests._calculate_iteration_metrics(
            baseline_memory, memory_samples, iteration, operation_duration_ms
        )

    @staticmethod
    def _calculate_iteration_metrics(
        baseline_memory: float,
        memory_samples: List[MemorySample],
        iteration: int,
        operation_duration_ms: float,
    ) -> IterationResult:
        """Calculate metrics for a single memory test iteration."""
        # Get final memory measurement
        process = psutil.Process()
        final_memory = process.memory_info().rss / (1024 * 1024)  # MB
        final_heap_delta = max(0, final_memory - baseline_memory)

        if not memory_samples:
            iter_peak_memory = final_heap_delta
            iter_avg_memory = final_heap_delta
        else:
            iter_peak_memory = max(sample.heap_mb for sample in memory_samples)
            iter_avg_memory = mean(sample.heap_mb for sample in memory_samples)

        print(
            f"=== Iteration {iteration} === Peak Heap: {iter_peak_memory:.2f} MB, "
            f"Avg Heap: {iter_avg_memory:.2f} MB ({operation_duration_ms:.0f}ms, "
            f"{len(memory_samples)} samples)"
        )

        return IterationResult(iter_peak_memory, iter_avg_memory)

    @staticmethod
    def run_concurrent_test(
        benchmark: "ESDKBenchmark",
        data_size: int,
        concurrency: int,
        iterations_per_thread: int,
    ) -> TestResult:
        """Run concurrent operations benchmark test."""
        print(
            f"Running concurrent test - Size: {data_size} bytes, Concurrency: {concurrency}, "
            f"Iterations per thread: {iterations_per_thread}"
        )

        if concurrency <= 0:
            raise ValueError(f"Concurrency must be positive, got: {concurrency}")
        if iterations_per_thread <= 0:
            raise ValueError(
                f"Iterations per thread must be positive, got: {iterations_per_thread}"
            )

        data = secrets.token_bytes(data_size)
        all_times = []

        expected_operations = concurrency * iterations_per_thread

        # Use ThreadPoolExecutor for concurrent execution
        with ThreadPoolExecutor(max_workers=concurrency) as executor:
            # Create progress bar for concurrent operations
            with tqdm(total=expected_operations, desc="Concurrent test") as pbar:
                # Submit all tasks
                futures = []
                for thread_id in range(concurrency):
                    future = executor.submit(
                        Tests._run_concurrent_thread,
                        benchmark,
                        data,
                        iterations_per_thread,
                        thread_id,
                        pbar,
                    )
                    futures.append(future)

                # Collect results
                for future in as_completed(futures):
                    try:
                        thread_times = future.result()
                        all_times.extend(thread_times)
                    except Exception as e:
                        print(f"Concurrent thread failed: {e}")

        if not all_times:
            raise RuntimeError(
                f"Concurrent test failed: No operations completed successfully. "
                f"Concurrency: {concurrency}, Expected operations: {expected_operations}"
            )

        total_operations = len(all_times)

        return TestResult.create_concurrent_result(
            all_times,
            total_operations,
            data_size,
            concurrency,
            benchmark.cpu_count,
            benchmark.total_memory_mb,
        )

    @staticmethod
    def _run_concurrent_thread(
        benchmark: "ESDKBenchmark",
        data: bytes,
        iterations: int,
        thread_id: int,
        pbar: tqdm,
    ) -> List[float]:
        """Run operations in a single thread for concurrent testing."""
        thread_times = []

        for j in range(iterations):
            try:
                thread_start_time = time.perf_counter()
                benchmark.run_item_encryptor_cycle(data)
                elapsed = (time.perf_counter() - thread_start_time) * 1000.0
                thread_times.append(elapsed)

                pbar.update(1)
            except Exception as e:
                print(f"Concurrent test iteration failed in thread {thread_id}: {e}")

        return thread_times
