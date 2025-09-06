// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package com.amazon.esdk.benchmark;

import com.amazon.esdk.benchmark.model.TestResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Tests {

  private static final Logger logger = LoggerFactory.getLogger(Tests.class);

  // Constants for memory testing
  private static final int MemoryTestIterations = 5;
  private static final int SamplingIntervalMs = 1;
  private static final int GcSettleTimeMs = 5;

  /**
   * Run throughput benchmark test
   */
  public static TestResult runThroughputTest(
    final ESDKBenchmark benchmark,
    final int dataSize,
    final int iterations
  ) {
    System.out.println(
      "Running throughput test - Size: " +
      dataSize +
      " bytes, Iterations: " +
      iterations
    );
    System.out.flush();

    final byte[] data = new byte[dataSize];
    new java.security.SecureRandom().nextBytes(data);

    // Warmup
    runWarmupIterations(benchmark, data, benchmark.config.iterations.warmup);

    // Measurement runs
    final var results = runMeasurementIterations(benchmark, data, iterations);

    // Calculate statistics
    final List<Double> putLatencies = new ArrayList<>();
    final List<Double> getLatencies = new ArrayList<>();
    final List<Double> totalLatencies = new ArrayList<>();

    for (final var result : results) {
      putLatencies.add(result.putLatencyMs);
      getLatencies.add(result.getLatencyMs);
      totalLatencies.add(result.putLatencyMs + result.getLatencyMs);
    }

    return TestResult.createThroughputResult(
      putLatencies,
      getLatencies,
      totalLatencies,
      dataSize,
      benchmark.cpuCount,
      benchmark.totalMemoryMB
    );
  }

  /**
   * Run memory benchmark test
   */
  public static TestResult runMemoryTest(
    final ESDKBenchmark benchmark,
    final int dataSize
  ) {
    System.out.println("Running memory test - Size: " + dataSize + " bytes");
    System.out.flush();

    final byte[] data = new byte[dataSize];
    new java.security.SecureRandom().nextBytes(data);

    // Force GC before starting
    System.gc();
    try {
      Thread.sleep(GcSettleTimeMs);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    final List<Double> memorySamples = new ArrayList<>();
    final Runtime runtime = Runtime.getRuntime();

    // Baseline memory
    final long baselineMemory = runtime.totalMemory() - runtime.freeMemory();

    // Run memory test iterations
    for (int i = 0; i < MemoryTestIterations; i++) {
      final long beforeMemory = runtime.totalMemory() - runtime.freeMemory();
      
      // Perform batch operation
      benchmark.runBatchPutGetCycle(data);
      
      final long afterMemory = runtime.totalMemory() - runtime.freeMemory();
      final double memoryUsedMB = (afterMemory - baselineMemory) / (1024.0 * 1024.0);
      memorySamples.add(Math.max(0, memoryUsedMB));
      
      // Small delay between iterations
      try {
        Thread.sleep(SamplingIntervalMs);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        break;
      }
    }

    final double peakMemoryMb = memorySamples.stream()
      .mapToDouble(Double::doubleValue)
      .max()
      .orElse(0.0);
    
    final double avgMemoryMb = memorySamples.stream()
      .mapToDouble(Double::doubleValue)
      .average()
      .orElse(0.0);

    return TestResult.createMemoryResult(
      peakMemoryMb,
      avgMemoryMb,
      dataSize,
      benchmark.cpuCount,
      benchmark.totalMemoryMB
    );
  }

  /**
   * Run concurrent benchmark test
   */
  public static TestResult runConcurrentTest(
    final ESDKBenchmark benchmark,
    final int dataSize,
    final int concurrency,
    final int iterations
  ) {
    System.out.println(
      "Running concurrent test - Size: " +
      dataSize +
      " bytes, Concurrency: " +
      concurrency +
      ", Iterations: " +
      iterations
    );
    System.out.flush();

    final byte[] data = new byte[dataSize];
    new java.security.SecureRandom().nextBytes(data);

    final ExecutorService executor = Executors.newFixedThreadPool(concurrency);
    final List<Future<List<Double>>> futures = new ArrayList<>();

    // Submit concurrent tasks
    for (int i = 0; i < concurrency; i++) {
      futures.add(executor.submit(() -> {
        final List<Double> threadTimes = new ArrayList<>();
        for (int j = 0; j < iterations; j++) {
          final long operationStart = System.nanoTime();
          benchmark.runBatchPutGetCycle(data);
          final long operationTime = System.nanoTime() - operationStart;
          threadTimes.add(operationTime / 1_000_000.0); // Convert to milliseconds
        }
        return threadTimes;
      }));
    }

    // Collect results
    final List<Double> allTimes = new ArrayList<>();
    int totalOps = 0;
    
    try {
      for (final Future<List<Double>> future : futures) {
        final List<Double> threadTimes = future.get();
        allTimes.addAll(threadTimes);
        totalOps += threadTimes.size();
      }
    } catch (Exception e) {
      throw new RuntimeException("Concurrent test failed", e);
    } finally {
      executor.shutdown();
    }

    return TestResult.createConcurrentResult(
      allTimes,
      totalOps,
      dataSize,
      concurrency,
      benchmark.cpuCount,
      benchmark.totalMemoryMB
    );
  }

  private static void runWarmupIterations(
    final ESDKBenchmark benchmark,
    final byte[] data,
    final int warmupIterations
  ) {
    System.out.println("Warming up with " + warmupIterations + " iterations...");
    for (int i = 0; i < warmupIterations; i++) {
      benchmark.runBatchPutGetCycle(data);
    }
    System.out.println("Warmup completed");
  }

  private static List<ESDKBenchmark.BatchPutGetResult> runMeasurementIterations(
    final ESDKBenchmark benchmark,
    final byte[] data,
    final int iterations
  ) {
    System.out.println("Running " + iterations + " measurement iterations...");
    final List<ESDKBenchmark.BatchPutGetResult> results = new ArrayList<>();
    
    for (int i = 0; i < iterations; i++) {
      final ESDKBenchmark.BatchPutGetResult result = benchmark.runBatchPutGetCycle(data);
      results.add(result);
    }
    
    return results;
  }
}
