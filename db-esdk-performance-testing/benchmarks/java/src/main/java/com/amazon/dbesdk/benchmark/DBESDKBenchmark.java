// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package com.amazon.dbesdk.benchmark;

import com.fasterxml.jackson.databind.ObjectMapper;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemOutput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Main DB-ESDK benchmark class that orchestrates performance testing.
 */
public class DBESDKBenchmark {
    
    private static final int MEMORY_TEST_ITERATIONS = 5;
    private static final int SAMPLING_INTERVAL_MS = 1;
    private static final int GC_SETTLE_TIME_MS = 5;
    private static final int FINAL_SAMPLE_WAIT_MS = 2;
    
    private final TestConfig config;
    private final IKeyring keyring;
    private final DynamoDbItemEncryptor itemEncryptor;
    private final List<BenchmarkResult> results;
    private final int cpuCount;
    private final double totalMemoryGb;

    /**
     * Creates a new benchmark instance.
     * 
     * @param configPath Path to the YAML configuration file
     * @throws Exception if initialization fails
     */
    public DBESDKBenchmark(String configPath) throws Exception {
        this.config = TestConfig.loadConfig(configPath);
        this.results = new ArrayList<>();
        this.cpuCount = Utils.getCpuCount();
        this.totalMemoryGb = Utils.getTotalMemoryGb();
        
        // Initialize keyring
        this.keyring = KeyringSetup.createKeyring(config.getKeyring());
        
        // Initialize item encryptor
        this.itemEncryptor = setupItemEncryptor();
        
        System.out.printf("Initialized DB-ESDK Benchmark - CPU cores: %d, Memory: %.1f GB%n", 
                         cpuCount, totalMemoryGb);
    }

    /**
     * Sets up the DynamoDB Item Encryptor with proper configuration.
     */
    private DynamoDbItemEncryptor setupItemEncryptor() throws Exception {
        // Define attribute actions (matching Go implementation)
        Map<String, CryptoAction> attributeActions = new HashMap<>();
        attributeActions.put("partition_key", CryptoAction.SIGN_ONLY);
        attributeActions.put("sort_key", CryptoAction.SIGN_ONLY);
        attributeActions.put("attribute1", CryptoAction.ENCRYPT_AND_SIGN);
        attributeActions.put("attribute2", CryptoAction.SIGN_ONLY);
        attributeActions.put(":attribute3", CryptoAction.DO_NOTHING);

        String allowedUnsignedAttributePrefix = ":";
        DBEAlgorithmSuiteId algorithmSuiteId = DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384;

        DynamoDbItemEncryptorConfig itemEncryptorConfig = DynamoDbItemEncryptorConfig.builder()
                .logicalTableName(config.getTableName())
                .partitionKeyName("partition_key")
                .sortKeyName("sort_key")
                .attributeActionsOnEncrypt(attributeActions)
                .keyring(keyring)
                .allowedUnsignedAttributePrefix(allowedUnsignedAttributePrefix)
                .algorithmSuiteId(algorithmSuiteId)
                .build();

        return DynamoDbItemEncryptor.builder()
                .DynamoDbItemEncryptorConfig(itemEncryptorConfig)
                .build();
    }

    /**
     * Runs all configured benchmark tests.
     */
    public List<BenchmarkResult> runAllBenchmarks() throws Exception {
        System.out.println("Starting comprehensive DB-ESDK benchmark suite");

        // Combine all data sizes
        List<Integer> allDataSizes = Stream.of(
                config.getDataSizes().getSmall(),
                config.getDataSizes().getMedium(),
                config.getDataSizes().getLarge()
        ).filter(Objects::nonNull)
         .flatMap(List::stream)
         .collect(Collectors.toList());

        // Get allowed test types from quick config if available
        List<String> allowedTestTypes = config.getQuickConfig() != null ? 
                config.getQuickConfig().getTestTypes() : null;

        // Run test suites
        if (Utils.shouldRunTestType("throughput", allowedTestTypes)) {
            runThroughputTests(allDataSizes, config.getIterations().getMeasurement());
        } else {
            System.out.println("Skipping throughput tests (not in test_types)");
        }

        if (Utils.shouldRunTestType("memory", allowedTestTypes)) {
            runMemoryTests(allDataSizes);
        } else {
            System.out.println("Skipping memory tests (not in test_types)");
        }

        if (Utils.shouldRunTestType("concurrency", allowedTestTypes)) {
            runConcurrencyTests(allDataSizes, config.getConcurrencyLevels());
        } else {
            System.out.println("Skipping concurrency tests (not in test_types)");
        }

        System.out.printf("Benchmark suite completed. Total results: %d%n", results.size());
        return results;
    }

    /**
     * Runs throughput benchmark tests.
     */
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

    /**
     * Runs a single throughput test.
     */
    private BenchmarkResult runThroughputTest(int dataSize, int iterations) throws Exception {
        System.out.printf("Running throughput test - Size: %d bytes, Iterations: %d%n", dataSize, iterations);

        byte[] testData = Utils.generateTestData(dataSize);

        // Warmup
        for (int i = 0; i < config.getIterations().getWarmup(); i++) {
            runItemEncryptorCycle(testData);
        }

        // Measurement runs
        List<Double> putLatencies = new ArrayList<>();
        List<Double> getLatencies = new ArrayList<>();
        List<Double> endToEndLatencies = new ArrayList<>();
        long totalBytes = 0;

        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            long iterationStart = System.nanoTime();
            
            LatencyResult latencyResult = runItemEncryptorCycle(testData);
            
            long iterationDuration = System.nanoTime() - iterationStart;
            double iterationMs = Utils.nanosToMillis(iterationDuration);

            putLatencies.add(latencyResult.putLatencyMs);
            getLatencies.add(latencyResult.getLatencyMs);
            endToEndLatencies.add(iterationMs);
            totalBytes += dataSize;
        }
        double totalDuration = Utils.nanosToMillis(System.nanoTime() - startTime) / 1000.0; // Convert to seconds

        // Calculate metrics
        double[] endToEndArray = endToEndLatencies.stream().mapToDouble(Double::doubleValue).toArray();
        Arrays.sort(endToEndArray);

        BenchmarkResult result = new BenchmarkResult("throughput", "java", dataSize, 1);
        result.setPutLatencyMs(Utils.average(putLatencies));
        result.setGetLatencyMs(Utils.average(getLatencies));
        result.setEndToEndLatencyMs(Utils.average(endToEndLatencies));
        result.setOpsPerSecond(iterations / totalDuration);
        result.setBytesPerSecond(totalBytes / totalDuration);
        result.setP50Latency(Utils.percentile(endToEndArray, 0.50));
        result.setP95Latency(Utils.percentile(endToEndArray, 0.95));
        result.setP99Latency(Utils.percentile(endToEndArray, 0.99));
        result.setTimestamp(Utils.getCurrentTimestamp());
        result.setJavaVersion(Utils.getJavaVersion());
        result.setCpuCount(cpuCount);
        result.setTotalMemoryGb(totalMemoryGb);

        System.out.printf("Throughput test completed - Ops/sec: %.2f, MB/sec: %.2f%n",
                         result.getOpsPerSecond(), result.getBytesPerSecond() / (1024 * 1024));

        return result;
    }

    /**
     * Runs memory benchmark tests.
     */
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

    /**
     * Gets the total allocated bytes for the current thread.
     */
    private static long getTotalAllocatedBytes() {
        final var threadBean = ManagementFactory.getThreadMXBean();
        final var sunThreadBean = (com.sun.management.ThreadMXBean) threadBean;

        if (!sunThreadBean.isThreadAllocatedMemoryEnabled()) {
            sunThreadBean.setThreadAllocatedMemoryEnabled(true);
        }

        return sunThreadBean.getCurrentThreadAllocatedBytes();
    }

    /**
     * Runs a single memory test with enhanced continuous monitoring.
     */
    private BenchmarkResult runMemoryTest(int dataSize) throws Exception {
        System.out.printf("Running memory test - Size: %d bytes (%d iterations, continuous sampling)%n", 
                         dataSize, MEMORY_TEST_ITERATIONS);
        System.out.flush();

        byte[] data = Utils.generateTestData(dataSize);
        MemoryResults memoryResults = sampleMemoryDuringOperations(data);

        if (memoryResults == null) {
            throw new RuntimeException(
                "Memory test failed: Unable to collect memory samples for data size " +
                dataSize + " bytes"
            );
        }

        BenchmarkResult result = new BenchmarkResult("memory", "java", dataSize, 1);
        result.setPeakMemoryMb(memoryResults.peakMemoryMb);
        result.setMemoryEfficiencyRatio(memoryResults.peakMemoryMb > 0 ? 
            dataSize / (memoryResults.peakMemoryMb * 1024 * 1024) : 0.0);
        result.setTimestamp(Utils.getCurrentTimestamp());
        result.setJavaVersion(Utils.getJavaVersion());
        result.setCpuCount(cpuCount);
        result.setTotalMemoryGb(totalMemoryGb);

        return result;
    }

    /**
     * Samples memory usage during multiple test iterations.
     */
    private MemoryResults sampleMemoryDuringOperations(byte[] data) {
        double peakMemoryDelta = 0.0;
        double peakAllocations = 0.0;
        List<Double> avgMemoryValues = new ArrayList<>();

        for (int i = 0; i < MEMORY_TEST_ITERATIONS; i++) {
            IterationResult iterationResult = runSingleMemoryIteration(data, i + 1);
            
            if (iterationResult.peakMemory > peakMemoryDelta) {
                peakMemoryDelta = iterationResult.peakMemory;
            }
            if (iterationResult.totalAllocs > peakAllocations) {
                peakAllocations = iterationResult.totalAllocs;
            }
            avgMemoryValues.add(iterationResult.avgMemory);
        }

        double overallAvgMemory = avgMemoryValues.isEmpty() ? 0.0 :
            avgMemoryValues.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        System.out.println("\nMemory Summary:");
        System.out.printf("- Absolute Peak Heap: %.2f MB (across all runs)%n", peakMemoryDelta);
        System.out.printf("- Average Heap: %.2f MB (across all runs)%n", overallAvgMemory);
        System.out.printf("- Total Allocations: %.2f MB (max across all runs)%n", peakAllocations);
        System.out.flush();

        return new MemoryResults(peakMemoryDelta, overallAvgMemory);
    }

    /**
     * Runs a single memory iteration with enhanced sampling.
     */
    private IterationResult runSingleMemoryIteration(byte[] data, int iteration) {
        // Force GC and settle (matching ESDK approach)
        System.gc();
        System.gc();
        try {
            Thread.sleep(GC_SETTLE_TIME_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Memory test interrupted during GC settle phase", e);
        }

        long baselineMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long baselineAllocations = getTotalAllocatedBytes();
        List<EnhancedMemorySample> memorySamples = new ArrayList<>();

        long operationStart = System.nanoTime();

        // Start background sampling
        Thread samplingTask = new Thread(() -> {
            try {
                while (System.nanoTime() - operationStart < 100_000_000) { // 100ms max
                    long currentMemory = Runtime.getRuntime().totalMemory() - 
                                       Runtime.getRuntime().freeMemory();
                    long currentAllocations = getTotalAllocatedBytes();
                    double heapDelta = (currentMemory - baselineMemory) / (1024.0 * 1024.0);
                    double cumulativeAllocs = (currentAllocations - baselineAllocations) / (1024.0 * 1024.0);

                    if (heapDelta > 0 || cumulativeAllocs > 0) {
                        synchronized (memorySamples) {
                            memorySamples.add(new EnhancedMemorySample(
                                Math.max(0, heapDelta), 
                                Math.max(0, cumulativeAllocs)
                            ));
                        }
                    }
                    Thread.sleep(SAMPLING_INTERVAL_MS);
                }
            } catch (InterruptedException e) {
                // Expected when operation completes
            }
        });

        samplingTask.start();

        // Run the actual operation
        try {
            runItemEncryptorCycle(data);
        } catch (Exception e) {
            System.out.printf("Memory test iteration %d failed: %s%n", iteration, e.getMessage());
            return new IterationResult(0.0, 0.0, 0.0);
        }

        double operationDurationMs = (System.nanoTime() - operationStart) / 1_000_000.0;

        // Wait for sampling to complete
        try {
            Thread.sleep(FINAL_SAMPLE_WAIT_MS);
            samplingTask.join(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return calculateIterationMetrics(
            baselineMemory,
            baselineAllocations, 
            memorySamples,
            iteration,
            operationDurationMs
        );
    }

    /**
     * Calculates comprehensive metrics for a single iteration.
     */
    private IterationResult calculateIterationMetrics(
        long baselineMemory,
        long baselineAllocations,
        List<EnhancedMemorySample> memorySamples,
        int iteration,
        double operationDurationMs
    ) {
        long finalMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long finalAllocations = getTotalAllocatedBytes();
        double finalHeapDelta = (finalMemory - baselineMemory) / (1024.0 * 1024.0);
        double finalCumulativeAllocs = (finalAllocations - baselineAllocations) / (1024.0 * 1024.0);

        double iterPeakMemory;
        double iterTotalAllocs;
        double iterAvgMemory;

        synchronized (memorySamples) {
            if (memorySamples.isEmpty()) {
                iterPeakMemory = Math.max(0, finalHeapDelta);
                iterTotalAllocs = Math.max(0, finalCumulativeAllocs);
                iterAvgMemory = Math.max(0, finalHeapDelta);
            } else {
                iterPeakMemory = memorySamples.stream().mapToDouble(s -> s.heapMB).max().orElse(0.0);
                iterTotalAllocs = Math.max(0, finalCumulativeAllocs);
                iterAvgMemory = memorySamples.stream().mapToDouble(s -> s.heapMB).average().orElse(0.0);
            }
        }

        System.out.printf("=== Iteration %d === Peak Heap: %.2f MB, Total Allocs: %.2f MB, " +
                         "Avg Heap: %.2f MB (%.0fms, %d samples)%n",
                         iteration, iterPeakMemory, iterTotalAllocs, iterAvgMemory,
                         operationDurationMs, memorySamples.size());
        System.out.flush();

        return new IterationResult(iterPeakMemory, iterTotalAllocs, iterAvgMemory);
    }

    /**
     * Runs concurrency benchmark tests.
     */
    private void runConcurrencyTests(List<Integer> dataSizes, List<Integer> concurrencyLevels) throws Exception {
        System.out.println("Running concurrency tests...");
        for (int dataSize : dataSizes) {
            for (int concurrency : concurrencyLevels) {
                if (concurrency > 1) { // Skip single-threaded
                    BenchmarkResult result = runConcurrentTest(dataSize, concurrency, 5);
                    if (result != null) {
                        results.add(result);
                        System.out.printf("Concurrent test completed: %.2f ops/sec @ %d threads%n", 
                                         result.getOpsPerSecond(), concurrency);
                    }
                }
            }
        }
    }

    /**
     * Runs a single concurrent test.
     */
    private BenchmarkResult runConcurrentTest(int dataSize, int concurrency, int iterationsPerWorker) throws Exception {
        System.out.printf("Running concurrent test - Size: %d bytes, Concurrency: %d%n", dataSize, concurrency);

        byte[] data = Utils.generateTestData(dataSize);
        List<Double> allTimes = Collections.synchronizedList(new ArrayList<>());
        ExecutorService executor = Executors.newFixedThreadPool(concurrency);
        
        long startTime = System.nanoTime();
        
        try {
            // Submit workers
            List<CompletableFuture<Void>> futures = new ArrayList<>();
            for (int i = 0; i < concurrency; i++) {
                final int workerId = i;
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    for (int j = 0; j < iterationsPerWorker; j++) {
                        try {
                            long iterStart = System.nanoTime();
                            runItemEncryptorCycle(data);
                            double iterMs = Utils.nanosToMillis(System.nanoTime() - iterStart);
                            allTimes.add(iterMs);
                        } catch (Exception e) {
                            throw new RuntimeException(String.format("Worker %d iteration %d failed: %s", 
                                                                   workerId, j, e.getMessage()), e);
                        }
                    }
                }, executor);
                futures.add(future);
            }

            // Wait for all workers to complete
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).get();
            
        } finally {
            executor.shutdown();
        }

        double totalDurationSec = Utils.nanosToMillis(System.nanoTime() - startTime) / 1000.0;

        // Calculate metrics
        int totalOps = concurrency * iterationsPerWorker;
        long totalBytes = (long) totalOps * dataSize;

        double[] timesArray = allTimes.stream().mapToDouble(Double::doubleValue).toArray();
        Arrays.sort(timesArray);

        BenchmarkResult result = new BenchmarkResult("concurrent", "java", dataSize, concurrency);
        result.setEndToEndLatencyMs(Utils.average(timesArray));
        result.setOpsPerSecond(totalOps / totalDurationSec);
        result.setBytesPerSecond(totalBytes / totalDurationSec);
        result.setP50Latency(Utils.percentile(timesArray, 0.50));
        result.setP95Latency(Utils.percentile(timesArray, 0.95));
        result.setP99Latency(Utils.percentile(timesArray, 0.99));
        result.setTimestamp(Utils.getCurrentTimestamp());
        result.setJavaVersion(Utils.getJavaVersion());
        result.setCpuCount(cpuCount);
        result.setTotalMemoryGb(totalMemoryGb);

        System.out.printf("Concurrent test completed - Ops/sec: %.2f, Avg latency: %.2f ms%n",
                         result.getOpsPerSecond(), result.getEndToEndLatencyMs());

        return result;
    }

    /**
     * Performs a single encrypt-decrypt cycle and measures performance.
     */
    private LatencyResult runItemEncryptorCycle(byte[] data) throws Exception {
        // Create DynamoDB item
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("partition_key", AttributeValue.builder().s("benchmark-test").build());
        item.put("sort_key", AttributeValue.builder().n("0").build());
        
        Map<String, AttributeValue> nestedMap = new HashMap<>();
        nestedMap.put("data", AttributeValue.builder().b(SdkBytes.fromByteArray(data)).build());
        item.put("attribute1", AttributeValue.builder().m(nestedMap).build());
        
        item.put("attribute2", AttributeValue.builder().s("sign me!").build());
        item.put(":attribute3", AttributeValue.builder().s("ignore me!").build());

        // Encrypt item
        long encryptStart = System.nanoTime();
        EncryptItemInput encryptInput = EncryptItemInput.builder().plaintextItem(item).build();
        EncryptItemOutput encryptOutput = itemEncryptor.EncryptItem(encryptInput);
        double putLatencyMs = Utils.nanosToMillis(System.nanoTime() - encryptStart);

        Map<String, AttributeValue> encryptedItem = encryptOutput.encryptedItem();

        // Decrypt item
        long decryptStart = System.nanoTime();
        DecryptItemInput decryptInput = DecryptItemInput.builder().encryptedItem(encryptedItem).build();
        DecryptItemOutput decryptOutput = itemEncryptor.DecryptItem(decryptInput);
        double getLatencyMs = Utils.nanosToMillis(System.nanoTime() - decryptStart);

        Map<String, AttributeValue> decryptedItem = decryptOutput.plaintextItem();

        // Verify items match (basic check)
        if (!item.equals(decryptedItem)) {
            throw new RuntimeException("Decrypted item does not match original item");
        }

        return new LatencyResult(putLatencyMs, getLatencyMs);
    }

    /**
     * Saves benchmark results to JSON file.
     */
    public void saveResults(String outputPath) throws IOException {
        // Ensure output directory exists
        Path outputFilePath = Paths.get(outputPath);
        Files.createDirectories(outputFilePath.getParent());

        // Create results structure matching Go implementation
        Map<String, Object> resultsData = new HashMap<>();
        
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("language", "java");
        metadata.put("timestamp", Utils.getCurrentTimestamp());
        metadata.put("java_version", Utils.getJavaVersion());
        metadata.put("cpu_count", cpuCount);
        metadata.put("total_memory_gb", totalMemoryGb);
        metadata.put("total_tests", results.size());
        
        resultsData.put("metadata", metadata);
        resultsData.put("results", results);

        // Write to JSON file with proper formatting
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputPath), resultsData);
        
        System.out.printf("Results saved to: %s%n", outputPath);
    }

    // Getters
    public TestConfig getConfig() { return config; }
    public List<BenchmarkResult> getResults() { return results; }

    /**
     * Helper class to hold latency results.
     */
    private static class LatencyResult {
        final double putLatencyMs;
        final double getLatencyMs;

        LatencyResult(double putLatencyMs, double getLatencyMs) {
            this.putLatencyMs = putLatencyMs;
            this.getLatencyMs = getLatencyMs;
        }
    }

    // Helper records for enhanced memory testing
    private record IterationResult(double peakMemory, double totalAllocs, double avgMemory) {}
    
    private record MemoryResults(double peakMemoryMb, double avgMemoryMb) {}
    
    private record EnhancedMemorySample(double heapMB, double allocsMB) {}
}
