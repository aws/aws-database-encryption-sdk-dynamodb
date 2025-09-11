# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
ESDK Benchmark Test Suite

This module contains the core test implementations for benchmarking the AWS Database Encryption SDK.
It provides three main test types:
1. Throughput Test - Measures operations per second for encrypt/decrypt cycles
2. Memory Test - Tracks peak memory usage during operations using tracemalloc
3. Concurrent Test - Evaluates performance under multithreaded load

Each test is designed to provide accurate, repeatable measurements of ESDK performance
characteristics under different conditions.
"""

import gc
import secrets
import time
import tracemalloc
from concurrent.futures import ThreadPoolExecutor, as_completed
from statistics import mean
from typing import List, NamedTuple, Optional, TYPE_CHECKING

from tqdm import tqdm

if TYPE_CHECKING:
    from .benchmark import ESDKBenchmark

from .models import TestResult


class MeasurementResults(NamedTuple):
    """
    Container for latency measurements from throughput testing.
    
    Attributes:
        encrypt_latencies: List of encryption operation times in milliseconds
        decrypt_latencies: List of decryption operation times in milliseconds  
        total_latencies: List of complete encrypt/decrypt cycle times in milliseconds
    """
    encrypt_latencies: List[float]
    decrypt_latencies: List[float]
    total_latencies: List[float]


class MemoryResults(NamedTuple):
    """
    Container for memory usage measurements.
    
    Attributes:
        peak_memory_mb: Maximum memory usage observed across all iterations (MB)
        avg_memory_mb: Average memory usage across all iterations (MB)
    """
    peak_memory_mb: float
    avg_memory_mb: float

# Since tracemalloc gives the peak heap allocated, we donot need to collect memory samples
# class MemorySample(NamedTuple):
#     """
#     Single point-in-time memory measurement.
#
#     Attributes:
#         heap_mb: Heap memory usage in megabytes
#         timestamp: Time when sample was taken (seconds since epoch)
#     """
#     heap_mb: float
#     timestamp: float


class IterationResult(NamedTuple):
    """
    Memory measurement result from a single test iteration.
    
    Attributes:
        peak_memory: Peak memory usage during this iteration (MB)
        avg_memory: Average memory usage during this iteration (MB)
    """
    peak_memory: float
    avg_memory: float


class Tests:
    MEMORY_TEST_ITERATIONS = 5  # Number of memory test iterations for averaging
    SAMPLING_INTERVAL_MS = 1  # Memory sampling interval in milliseconds
    GC_SETTLE_TIME_MS = 5  # Time to wait for GC to settle before measurement
    FINAL_SAMPLE_WAIT_MS = 2  # Wait time for final sample collection

    @staticmethod
    def run_throughput_test(benchmark: "ESDKBenchmark", data_size: int, iterations: int) -> Optional[TestResult]:
        """
        Execute throughput benchmark measuring encrypt/decrypt operations per second.
        
        This test performs warmup iterations followed by measured iterations to determine
        the sustained throughput of ESDK operations. It measures individual encrypt and
        decrypt latencies as well as total cycle time.
        
        Args:
            benchmark: The ESDK benchmark instance to test
            data_size: Size of test data in bytes
            iterations: Number of measurement iterations to perform
            
        Returns:
            TestResult containing throughput metrics, or None if all iterations failed
        """
        print(f"\n--- Throughput Test ---")
        print(f"Data size: {data_size:,} bytes | Iterations: {iterations}")
        
        # Generate random test data
        data = secrets.token_bytes(data_size)

        warmup_iterations = benchmark.config.iterations.warmup
        print(f"Warming up with {warmup_iterations} iterations...")
        Tests._run_measurement_iterations(benchmark, data, warmup_iterations)
        
        # Measurement
        print(f"Measuring performance over {iterations} iterations...")
        results = Tests._run_measurement_iterations(benchmark, data, iterations)
        
        if not results.total_latencies:
            print("ERROR: All test iterations failed")
            return None
        
        # Calculate and display basic statistics
        avg_total_ms = mean(results.total_latencies)
        ops_per_sec = 1000.0 / avg_total_ms if avg_total_ms > 0 else 0
        print(f"Throughput test completed: {ops_per_sec:.2f} ops/sec")
        
        return TestResult.create_throughput_result(
            results.encrypt_latencies,
            results.decrypt_latencies,
            results.total_latencies,
            data_size,
            benchmark.cpu_count,
            benchmark.total_memory_mb,
        )

    @staticmethod
    def _run_measurement_iterations(benchmark: "ESDKBenchmark", data: bytes, iterations: int) -> MeasurementResults:
        encrypt_latencies, decrypt_latencies, total_latencies = [], [], []
        
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
        """
        Execute memory usage benchmark using tracemalloc for precise memory tracking.
        
        This test measures peak memory consumption during ESDK encrypt/decrypt operations.
        It uses Python's tracemalloc module to track memory allocations with high precision,
        running multiple iterations to ensure consistent measurements.
        
        The test methodology:
        1. Force garbage collection to establish clean baseline
        2. Start tracemalloc to monitor memory allocations
        3. Execute encrypt/decrypt cycle
        4. Measure peak memory delta from baseline
        5. Repeat across multiple iterations for statistical accuracy
        
        Args:
            benchmark: The ESDK benchmark instance to test
            data_size: Size of test data in bytes
            
        Returns:
            TestResult containing memory usage metrics
            
        Raises:
            RuntimeError: If memory sampling fails completely
        """
        print(f"\n--- Memory Test ---")
        print(f"Data size: {data_size:,} bytes | Iterations: {Tests.MEMORY_TEST_ITERATIONS}")
        print("Using tracemalloc for precise memory tracking")
        
        # Generate test data
        data = secrets.token_bytes(data_size)
        
        # Execute memory sampling across multiple iterations
        memory_results = Tests._sample_memory_during_operations(benchmark, data)
        
        if memory_results is None:
            raise RuntimeError(f"Memory test failed: Unable to collect memory samples for data size {data_size:,} bytes")
        
        print(f"Memory test completed: {memory_results.peak_memory_mb:.2f} MB peak")
        
        return TestResult.create_memory_result(
            memory_results.peak_memory_mb,
            memory_results.avg_memory_mb,
            data_size,
            benchmark.cpu_count,
            benchmark.total_memory_mb,
        )

    @staticmethod
    def _sample_memory_during_operations(benchmark: "ESDKBenchmark", data: bytes) -> Optional[MemoryResults]:
        peak_memory_delta = 0.0
        peak_allocations = 0.0
        avg_memory_values = []
        
        for i in range(Tests.MEMORY_TEST_ITERATIONS):
            iteration_result = Tests._run_single_memory_iteration(benchmark, data, i + 1)
            
            if iteration_result.peak_memory > peak_memory_delta:
                peak_memory_delta = iteration_result.peak_memory

            avg_memory_values.append(iteration_result.avg_memory)
        
        overall_avg_memory = mean(avg_memory_values) if avg_memory_values else 0.0
        
        print(f"\nMemory Summary:")
        print(f"- Absolute Peak Heap: {peak_memory_delta:.2f} MB (across all runs)")
        print(f"- Average Heap: {overall_avg_memory:.2f} MB (across all runs)")
        print(f"- Total Allocations: {peak_allocations:.2f} MB (max across all runs)")
        
        return MemoryResults(peak_memory_delta, overall_avg_memory)

    @staticmethod
    def _run_single_memory_iteration(benchmark: "ESDKBenchmark", data: bytes, iteration: int) -> IterationResult:
        # Force GC and settle
        gc.collect()
        gc.collect()
        time.sleep(Tests.GC_SETTLE_TIME_MS / 1000.0)
        
        # Start tracemalloc for peak memory tracking
        tracemalloc.start()
        baseline_current, baseline_peak = tracemalloc.get_traced_memory()
        
        operation_start = time.perf_counter()
        
        # Run the actual operation
        try:
            benchmark.run_item_encryptor_cycle(data)
        except Exception as e:
            print(f"Memory test iteration {iteration} failed: {e}")
            tracemalloc.stop()
            return IterationResult(0.0, 0.0)
        
        operation_duration_ms = (time.perf_counter() - operation_start) * 1000.0
        
        # Get final memory measurements from tracemalloc
        final_current, final_peak = tracemalloc.get_traced_memory()
        tracemalloc.stop()
        
        # Calculate memory deltas in MB
        net_peak_mb = max(0, (final_peak - baseline_peak) / (1024 * 1024))
        net_current_mb = max(0, (final_current - baseline_current) / (1024 * 1024))

        print(f"=== Iteration {iteration} === Peak Heap: {net_peak_mb:.2f} MB "
              f"({operation_duration_ms:.0f}ms)")
        
        return IterationResult(net_peak_mb, net_current_mb)



    @staticmethod
    def run_concurrent_test(benchmark: "ESDKBenchmark", data_size: int, concurrency: int, iterations_per_thread: int) -> TestResult:
        """
        Execute concurrent benchmark testing multi-threaded ESDK performance.
        
        This test evaluates how well ESDK operations scale under concurrent load by
        running multiple threads simultaneously, each performing encrypt/decrypt cycles.
        It measures the aggregate throughput and individual operation latencies.
        
        The test methodology:
        1. Create a thread pool with specified concurrency level
        2. Each thread performs the specified number of iterations
        3. All operations run concurrently with shared progress tracking
        4. Collect timing data from all threads for analysis
        
        Args:
            benchmark: The ESDK benchmark instance to test
            data_size: Size of test data in bytes
            concurrency: Number of concurrent threads to run
            iterations_per_thread: Number of operations each thread performs
            
        Returns:
            TestResult containing concurrent performance metrics
            
        Raises:
            ValueError: If concurrency or iterations_per_thread are not positive
            RuntimeError: If no operations complete successfully
        """
        print(f"\n--- Concurrent Test ---")
        print(f"Data size: {data_size:,} bytes | Threads: {concurrency} | Iterations per thread: {iterations_per_thread}")
        
        # Validate input parameters
        if concurrency <= 0 or iterations_per_thread <= 0:
            raise ValueError(f"Concurrency and iterations must be positive, got: {concurrency}, {iterations_per_thread}")
        
        # Generate test data and initialize result collection
        data = secrets.token_bytes(data_size)
        all_times = []
        expected_operations = concurrency * iterations_per_thread
        
        print(f"Starting {expected_operations} total operations across {concurrency} threads...")
        
        # Execute concurrent operations with thread pool
        with ThreadPoolExecutor(max_workers=concurrency) as executor:
            with tqdm(total=expected_operations, desc="Progress", unit="ops", 
                     bar_format="{l_bar}{bar}| {n_fmt}/{total_fmt} [{elapsed}<{remaining}, {rate_fmt}]") as pbar:
                
                # Submit all thread tasks
                futures = [
                    executor.submit(Tests._run_concurrent_thread, benchmark, data, iterations_per_thread, thread_id, pbar) 
                    for thread_id in range(concurrency)
                ]
                
                # Collect results as threads complete
                for future in as_completed(futures):
                    try:
                        thread_times = future.result()
                        all_times.extend(thread_times)
                    except Exception as e:
                        print(f"\nERROR: Concurrent thread failed: {e}")
        
        # Validate results
        if not all_times:
            raise RuntimeError(f"Concurrent test failed: No operations completed successfully. "
                             f"Concurrency: {concurrency}, Expected operations: {expected_operations}")
        
        # Calculate and display summary statistics
        completed_ops = len(all_times)
        avg_latency_ms = mean(all_times)
        aggregate_ops_per_sec = completed_ops / (sum(all_times) / 1000.0) if all_times else 0
        
        print(f"Concurrent test completed: {aggregate_ops_per_sec:.2f} ops/sec @ {concurrency} threads")
        
        return TestResult.create_concurrent_result(
            all_times,
            completed_ops,
            data_size,
            concurrency,
            benchmark.cpu_count,
            benchmark.total_memory_mb,
        )

    @staticmethod
    def _run_concurrent_thread(benchmark: "ESDKBenchmark", data: bytes, iterations: int, thread_id: int, pbar: tqdm) -> List[float]:
        """
        Execute encrypt/decrypt operations in a single thread for concurrent testing.
        
        This method runs in a separate thread as part of the concurrent test. Each thread
        performs the specified number of iterations independently, measuring the latency
        of each operation and updating the shared progress bar.
        
        Args:
            benchmark: The ESDK benchmark instance to test
            data: Test data bytes to encrypt/decrypt
            iterations: Number of operations this thread should perform
            thread_id: Unique identifier for this thread (for error reporting)
            pbar: Shared progress bar for tracking overall test progress
            
        Returns:
            List of operation latencies in milliseconds for this thread
        """
        thread_times = []
        
        for j in range(iterations):
            try:
                # Measure single encrypt/decrypt cycle
                thread_start_time = time.perf_counter()
                benchmark.run_item_encryptor_cycle(data)
                elapsed = (time.perf_counter() - thread_start_time) * 1000.0
                
                # Record timing and update progress
                thread_times.append(elapsed)
                pbar.update(1)
            except Exception as e:
                print(f"\nERROR: Concurrent test iteration failed in thread {thread_id}: {e}")
        
        return thread_times
