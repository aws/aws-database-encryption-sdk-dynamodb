// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package com.amazon.dbesdk.benchmark;

import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.EncryptionContext;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.EncryptionFlags;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.WrappedMaterialsProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * SDKv2 benchmark using DynamoDBEncryptor with WrappedMaterialsProvider.
 * Mirrors DBESDKBenchmark structure for comparable results.
 */
public class SDKv2Benchmark {

  private static final int MEMORY_TEST_ITERATIONS = 5;
  private static final int SAMPLING_INTERVAL_MS = 1;
  private static final int GC_SETTLE_TIME_MS = 5;
  private static final int FINAL_SAMPLE_WAIT_MS = 2;

  private final TestConfig config;
  private final DynamoDBEncryptor encryptor;
  private final EncryptionContext encryptionContext;
  private final Map<String, Set<EncryptionFlags>> actions;
  private final List<BenchmarkResult> results;
  private final int cpuCount;
  private final double totalMemoryGb;

  public SDKv2Benchmark(String configPath) throws Exception {
    this.config = TestConfig.loadConfig(configPath);
    this.results = new ArrayList<>();
    this.cpuCount = Utils.getCpuCount();
    this.totalMemoryGb = Utils.getTotalMemoryGb();

    // Set up WrappedMaterialsProvider with AES wrapping + HMAC signing
    SecureRandom sr = new SecureRandom();
    byte[] rawAes = new byte[32];
    byte[] rawHmac = new byte[32];
    sr.nextBytes(rawAes);
    sr.nextBytes(rawHmac);
    SecretKey wrappingKey = new SecretKeySpec(rawAes, "AES");
    SecretKey signingKey = new SecretKeySpec(rawHmac, "HmacSHA256");

    WrappedMaterialsProvider cmp = new WrappedMaterialsProvider(wrappingKey, wrappingKey, signingKey);
    this.encryptor = DynamoDBEncryptor.getInstance(cmp);

    this.encryptionContext = EncryptionContext.builder()
        .tableName(config.getTableName())
        .hashKeyName("partition_key")
        .rangeKeyName("sort_key")
        .build();

    // Define actions matching the standard benchmark item structure
    EnumSet<EncryptionFlags> signOnly = EnumSet.of(EncryptionFlags.SIGN);
    EnumSet<EncryptionFlags> encryptAndSign = EnumSet.of(EncryptionFlags.ENCRYPT, EncryptionFlags.SIGN);
    this.actions = new HashMap<>();
    actions.put("partition_key", signOnly);
    actions.put("sort_key", signOnly);
    actions.put("attribute1", encryptAndSign);
    actions.put("attribute2", signOnly);
    // :attribute3 intentionally omitted — no flags means DO_NOTHING

    System.out.printf(
        "Initialized SDKv2 Benchmark - CPU cores: %d, Memory: %.1f GB%n",
        cpuCount, totalMemoryGb);
  }

  public List<BenchmarkResult> runAllBenchmarks() throws Exception {
    System.out.println("Starting SDKv2 benchmark suite");

    List<Integer> allDataSizes = Stream.of(
            config.getDataSizes().getSmall(),
            config.getDataSizes().getMedium(),
            config.getDataSizes().getLarge())
        .filter(Objects::nonNull)
        .flatMap(List::stream)
        .collect(Collectors.toList());

    List<String> allowedTestTypes = config.getQuickConfig() != null
        ? config.getQuickConfig().getTestTypes() : null;

    if (Utils.shouldRunTestType("throughput", allowedTestTypes)) {
      runThroughputTests(allDataSizes, config.getIterations().getMeasurement());
    }
    if (Utils.shouldRunTestType("memory", allowedTestTypes)) {
      runMemoryTests(allDataSizes);
    }
    if (Utils.shouldRunTestType("concurrency", allowedTestTypes)) {
      runConcurrencyTests(allDataSizes, config.getConcurrencyLevels());
    }

    System.out.printf("SDKv2 benchmark suite completed. Total results: %d%n", results.size());
    return results;
  }

  private void runThroughputTests(List<Integer> dataSizes, int iterations) throws Exception {
    System.out.println("Running throughput tests...");
    for (int dataSize : dataSizes) {
      BenchmarkResult result = runThroughputTest(dataSize, iterations);
      if (result != null) {
        results.add(result);
        System.out.printf("Throughput test completed: %.2f ops/sec%n", result.getOpsPerSecond());
      }
    }
  }

  private BenchmarkResult runThroughputTest(int dataSize, int iterations) throws Exception {
    System.out.printf("Running throughput test - Size: %d bytes, Iterations: %d%n", dataSize, iterations);

    byte[] testData = Utils.generateTestData(dataSize);

    // Warmup
    for (int i = 0; i < config.getIterations().getWarmup(); i++) {
      runEncryptDecryptCycle(testData);
    }

    List<Double> putLatencies = new ArrayList<>();
    List<Double> getLatencies = new ArrayList<>();
    List<Double> endToEndLatencies = new ArrayList<>();
    long totalBytes = 0;

    long startTime = System.nanoTime();
    for (int i = 0; i < iterations; i++) {
      long iterStart = System.nanoTime();
      LatencyResult lr = runEncryptDecryptCycle(testData);
      double iterMs = Utils.nanosToMillis(System.nanoTime() - iterStart);

      putLatencies.add(lr.putLatencyMs);
      getLatencies.add(lr.getLatencyMs);
      endToEndLatencies.add(iterMs);
      totalBytes += dataSize;
    }
    double totalDuration = Utils.nanosToMillis(System.nanoTime() - startTime) / 1000.0;

    double[] e2eArray = endToEndLatencies.stream().mapToDouble(Double::doubleValue).toArray();
    Arrays.sort(e2eArray);

    BenchmarkResult result = new BenchmarkResult("throughput", "java-sdkv2", dataSize, 1);
    result.setPutLatencyMs(Utils.average(putLatencies));
    result.setGetLatencyMs(Utils.average(getLatencies));
    result.setEndToEndLatencyMs(Utils.average(endToEndLatencies));
    result.setOpsPerSecond(iterations / totalDuration);
    result.setBytesPerSecond(totalBytes / totalDuration);
    result.setP50Latency(Utils.percentile(e2eArray, 0.50));
    result.setP95Latency(Utils.percentile(e2eArray, 0.95));
    result.setP99Latency(Utils.percentile(e2eArray, 0.99));
    result.setTimestamp(Utils.getCurrentTimestamp());
    result.setJavaVersion(Utils.getJavaVersion());
    result.setCpuCount(cpuCount);
    result.setTotalMemoryGb(totalMemoryGb);
    return result;
  }

  private void runMemoryTests(List<Integer> dataSizes) throws Exception {
    System.out.println("Running memory tests...");
    for (int dataSize : dataSizes) {
      BenchmarkResult result = runMemoryTest(dataSize);
      if (result != null) {
        results.add(result);
        System.out.printf("Memory test completed: %.2f MB peak%n", result.getPeakMemoryMb());
      }
    }
  }

  private static long getTotalAllocatedBytes() {
    final com.sun.management.ThreadMXBean sunThreadBean =
        (com.sun.management.ThreadMXBean) ManagementFactory.getThreadMXBean();
    if (!sunThreadBean.isThreadAllocatedMemoryEnabled()) {
      sunThreadBean.setThreadAllocatedMemoryEnabled(true);
    }
    return sunThreadBean.getCurrentThreadAllocatedBytes();
  }

  private BenchmarkResult runMemoryTest(int dataSize) throws Exception {
    System.out.printf("Running memory test - Size: %d bytes%n", dataSize);

    byte[] data = Utils.generateTestData(dataSize);
    double peakMemoryDelta = 0.0;
    List<Double> avgMemoryValues = new ArrayList<>();

    for (int i = 0; i < MEMORY_TEST_ITERATIONS; i++) {
      System.gc();
      System.gc();
      Thread.sleep(GC_SETTLE_TIME_MS);

      long baselineMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
      List<Double> samples = Collections.synchronizedList(new ArrayList<>());

      long opStart = System.nanoTime();
      Thread sampler = new Thread(() -> {
        try {
          while (System.nanoTime() - opStart < 100_000_000) {
            long cur = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            double delta = (cur - baselineMemory) / (1024.0 * 1024.0);
            if (delta > 0) samples.add(delta);
            Thread.sleep(SAMPLING_INTERVAL_MS);
          }
        } catch (InterruptedException e) { }
      });
      sampler.start();

      try {
        runEncryptDecryptCycle(data);
      } catch (Exception e) {
        System.out.printf("Memory iteration %d failed: %s%n", i + 1, e.getMessage());
        continue;
      }

      Thread.sleep(FINAL_SAMPLE_WAIT_MS);
      sampler.join(100);

      long finalMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
      double finalDelta = (finalMem - baselineMemory) / (1024.0 * 1024.0);

      double iterPeak;
      double iterAvg;
      synchronized (samples) {
        if (samples.isEmpty()) {
          iterPeak = Math.max(0, finalDelta);
          iterAvg = Math.max(0, finalDelta);
        } else {
          iterPeak = samples.stream().mapToDouble(Double::doubleValue).max().orElse(0.0);
          iterAvg = samples.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        }
      }
      if (iterPeak > peakMemoryDelta) peakMemoryDelta = iterPeak;
      avgMemoryValues.add(iterAvg);
    }

    BenchmarkResult result = new BenchmarkResult("memory", "java-sdkv2", dataSize, 1);
    result.setPeakMemoryMb(peakMemoryDelta);
    result.setMemoryEfficiencyRatio(
        peakMemoryDelta > 0 ? dataSize / (peakMemoryDelta * 1024 * 1024) : 0.0);
    result.setTimestamp(Utils.getCurrentTimestamp());
    result.setJavaVersion(Utils.getJavaVersion());
    result.setCpuCount(cpuCount);
    result.setTotalMemoryGb(totalMemoryGb);
    return result;
  }

  private void runConcurrencyTests(List<Integer> dataSizes, List<Integer> concurrencyLevels) throws Exception {
    System.out.println("Running concurrency tests...");
    for (int dataSize : dataSizes) {
      for (int concurrency : concurrencyLevels) {
        if (concurrency > 1) {
          try {
            BenchmarkResult result = runConcurrentTest(dataSize, concurrency, 5);
            if (result != null) {
              results.add(result);
              System.out.printf("Concurrent test completed: %.2f ops/sec @ %d threads%n",
                  result.getOpsPerSecond(), concurrency);
            }
          } catch (Exception e) {
            System.out.printf("Concurrent test failed (size=%d, threads=%d): %s — skipping%n",
                dataSize, concurrency, e.getCause() != null ? e.getCause().getMessage() : e.getMessage());
          }
        }
      }
    }
  }

  private BenchmarkResult runConcurrentTest(int dataSize, int concurrency, int iterationsPerWorker) throws Exception {
    System.out.printf("Running concurrent test - Size: %d bytes, Concurrency: %d%n", dataSize, concurrency);

    byte[] data = Utils.generateTestData(dataSize);
    List<Double> allTimes = Collections.synchronizedList(new ArrayList<>());
    ExecutorService executor = Executors.newFixedThreadPool(concurrency);

    long startTime = System.nanoTime();
    try {
      List<CompletableFuture<Void>> futures = new ArrayList<>();
      for (int i = 0; i < concurrency; i++) {
        final int workerId = i;
        futures.add(CompletableFuture.runAsync(() -> {
          for (int j = 0; j < iterationsPerWorker; j++) {
            try {
              long iterStart = System.nanoTime();
              runEncryptDecryptCycle(data);
              allTimes.add(Utils.nanosToMillis(System.nanoTime() - iterStart));
            } catch (Exception e) {
              throw new RuntimeException(
                  String.format("Worker %d iteration %d failed: %s", workerId, j, e.getMessage()), e);
            }
          }
        }, executor));
      }
      CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).get();
    } finally {
      executor.shutdown();
    }

    double totalDurationSec = Utils.nanosToMillis(System.nanoTime() - startTime) / 1000.0;
    int totalOps = concurrency * iterationsPerWorker;

    double[] timesArray = allTimes.stream().mapToDouble(Double::doubleValue).toArray();
    Arrays.sort(timesArray);

    BenchmarkResult result = new BenchmarkResult("concurrent", "java-sdkv2", dataSize, concurrency);
    result.setEndToEndLatencyMs(Utils.average(timesArray));
    result.setOpsPerSecond(totalOps / totalDurationSec);
    result.setBytesPerSecond((long) totalOps * dataSize / totalDurationSec);
    result.setP50Latency(Utils.percentile(timesArray, 0.50));
    result.setP95Latency(Utils.percentile(timesArray, 0.95));
    result.setP99Latency(Utils.percentile(timesArray, 0.99));
    result.setTimestamp(Utils.getCurrentTimestamp());
    result.setJavaVersion(Utils.getJavaVersion());
    result.setCpuCount(cpuCount);
    result.setTotalMemoryGb(totalMemoryGb);
    return result;
  }

  /**
   * Single encrypt-decrypt cycle using SDKv2 DynamoDBEncryptor.
   */
  private LatencyResult runEncryptDecryptCycle(byte[] data) throws GeneralSecurityException {
    Map<String, AttributeValue> item = new HashMap<>();
    item.put("partition_key", AttributeValue.builder().s("benchmark-test").build());
    item.put("sort_key", AttributeValue.builder().n("0").build());

    Map<String, AttributeValue> nestedMap = new HashMap<>();
    nestedMap.put("data", AttributeValue.builder().b(SdkBytes.fromByteArray(data)).build());
    item.put("attribute1", AttributeValue.builder().m(nestedMap).build());
    item.put("attribute2", AttributeValue.builder().s("sign me!").build());
    item.put(":attribute3", AttributeValue.builder().s("ignore me!").build());

    // Encrypt
    long encryptStart = System.nanoTime();
    Map<String, AttributeValue> encrypted = encryptor.encryptRecord(item, actions, encryptionContext);
    double putLatencyMs = Utils.nanosToMillis(System.nanoTime() - encryptStart);

    // Decrypt
    long decryptStart = System.nanoTime();
    Map<String, AttributeValue> decrypted = encryptor.decryptRecord(encrypted, actions, encryptionContext);
    double getLatencyMs = Utils.nanosToMillis(System.nanoTime() - decryptStart);

    // Verify
    if (!item.get("partition_key").equals(decrypted.get("partition_key"))
        || !item.get("sort_key").equals(decrypted.get("sort_key"))
        || !item.get("attribute1").equals(decrypted.get("attribute1"))
        || !item.get("attribute2").equals(decrypted.get("attribute2"))) {
      throw new RuntimeException("Decrypted item does not match original");
    }

    return new LatencyResult(putLatencyMs, getLatencyMs);
  }

  public void saveResults(String outputPath) throws IOException {
    Path outputFilePath = Paths.get(outputPath);
    Files.createDirectories(outputFilePath.getParent());

    Map<String, Object> resultsData = new HashMap<>();
    Map<String, Object> metadata = new HashMap<>();
    metadata.put("language", "java-sdkv2");
    metadata.put("timestamp", Utils.getCurrentTimestamp());
    metadata.put("java_version", Utils.getJavaVersion());
    metadata.put("cpu_count", cpuCount);
    metadata.put("total_memory_gb", totalMemoryGb);
    metadata.put("total_tests", results.size());
    resultsData.put("metadata", metadata);
    resultsData.put("results", results);

    new ObjectMapper().writerWithDefaultPrettyPrinter()
        .writeValue(new File(outputPath), resultsData);
    System.out.printf("Results saved to: %s%n", outputPath);
  }

  public TestConfig getConfig() { return config; }
  public List<BenchmarkResult> getResults() { return results; }

  private static class LatencyResult {
    final double putLatencyMs;
    final double getLatencyMs;
    LatencyResult(double putLatencyMs, double getLatencyMs) {
      this.putLatencyMs = putLatencyMs;
      this.getLatencyMs = getLatencyMs;
    }
  }
}
