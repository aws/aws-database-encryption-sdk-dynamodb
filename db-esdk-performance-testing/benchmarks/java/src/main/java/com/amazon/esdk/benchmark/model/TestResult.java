package com.amazon.esdk.benchmark.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;

public final class TestResult {

  @JsonProperty("language")
  public final String language = "java";

  @JsonProperty("test_name")
  public String testName;

  @JsonProperty("data_size")
  public int dataSize;

  @JsonProperty("concurrency")
  public int concurrency = 1;

  @JsonProperty("put_latency_ms")
  public double putLatencyMs;

  @JsonProperty("get_latency_ms")
  public double getLatencyMs;

  @JsonProperty("end_to_end_latency_ms")
  public double endToEndLatencyMs;

  @JsonProperty("ops_per_second")
  public double opsPerSecond;

  @JsonProperty("bytes_per_second")
  public double bytesPerSecond;

  @JsonProperty("peak_memory_mb")
  public double peakMemoryMb;

  @JsonProperty("memory_efficiency_ratio")
  public double memoryEfficiencyRatio;

  @JsonProperty("p50_latency")
  public double p50Latency;

  @JsonProperty("p95_latency")
  public double p95Latency;

  @JsonProperty("p99_latency")
  public double p99Latency;

  @JsonProperty("timestamp")
  public String timestamp = "";

  @JsonProperty("java_version")
  public String javaVersion = "";

  @JsonProperty("cpu_count")
  public int cpuCount;

  @JsonProperty("total_memory_gb")
  public double totalMemoryGb;

  @JsonProperty("iterations")
  public int iterations;

  public static TestResult createThroughputResult(
    final List<Double> putLatencies,
    final List<Double> getLatencies,
    final List<Double> totalLatencies,
    final int dataSize,
    final int cpuCount,
    final double totalMemoryMB
  ) {
    final double avgTotalLatency = totalLatencies
      .stream()
      .mapToDouble(Double::doubleValue)
      .average()
      .orElse(0.0);
    final double opsPerSecond = avgTotalLatency > 0
      ? 1000.0 / avgTotalLatency
      : 0.0;

    Collections.sort(totalLatencies);

    final var result = new TestResult();
    result.testName = "throughput";
    result.dataSize = dataSize;
    result.concurrency = 1;
    result.opsPerSecond = opsPerSecond;
    result.bytesPerSecond = opsPerSecond * dataSize;
    result.endToEndLatencyMs = avgTotalLatency;
    result.p50Latency = calculatePercentile(totalLatencies, 50);
    result.p95Latency = calculatePercentile(totalLatencies, 95);
    result.p99Latency = calculatePercentile(totalLatencies, 99);
    result.putLatencyMs = putLatencies
      .stream()
      .mapToDouble(Double::doubleValue)
      .average()
      .orElse(0.0);
    result.getLatencyMs = getLatencies
      .stream()
      .mapToDouble(Double::doubleValue)
      .average()
      .orElse(0.0);
    result.iterations = putLatencies.size();
    result.timestamp = java.time.LocalDateTime
      .now()
      .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    result.javaVersion = System.getProperty("java.version");
    result.cpuCount = cpuCount;
    result.totalMemoryGb = totalMemoryMB / 1024.0;

    return result;
  }

  public static TestResult createMemoryResult(
    final double peakMemoryMb,
    final double avgMemoryMb,
    final int dataSize,
    final int cpuCount,
    final double totalMemoryMB
  ) {
    final double memoryEfficiency = peakMemoryMb > 0
      ? dataSize / (peakMemoryMb * 1024 * 1024)
      : 0.0;

    final var result = new TestResult();
    result.testName = "memory";
    result.dataSize = dataSize;
    result.concurrency = 1;
    result.peakMemoryMb = peakMemoryMb;
    result.memoryEfficiencyRatio = memoryEfficiency;
    result.timestamp = java.time.LocalDateTime
      .now()
      .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    result.javaVersion = System.getProperty("java.version");
    result.cpuCount = cpuCount;
    result.totalMemoryGb = totalMemoryMB / 1024.0;

    return result;
  }

  public static TestResult createConcurrentResult(
    final List<Double> allTimes,
    final int totalOps,
    final int dataSize,
    final int concurrency,
    final int cpuCount,
    final double totalMemoryMB
  ) {
    final double avgLatency = allTimes
      .stream()
      .mapToDouble(Double::doubleValue)
      .average()
      .orElse(0.0);
    final double totalTimeSeconds = allTimes
      .stream()
      .mapToDouble(Double::doubleValue)
      .sum() / 1000.0;
    final double opsPerSecond = totalTimeSeconds > 0 ? totalOps / totalTimeSeconds : 0.0;

    final var result = new TestResult();
    result.testName = "concurrent";
    result.dataSize = dataSize;
    result.concurrency = concurrency;
    result.opsPerSecond = opsPerSecond;
    result.bytesPerSecond = opsPerSecond * dataSize;
    result.endToEndLatencyMs = avgLatency;
    result.iterations = totalOps;
    result.timestamp = java.time.LocalDateTime
      .now()
      .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    result.javaVersion = System.getProperty("java.version");
    result.cpuCount = cpuCount;
    result.totalMemoryGb = totalMemoryMB / 1024.0;

    return result;
  }

  private static double calculatePercentile(
    final List<Double> values,
    final int percentile
  ) {
    if (values.isEmpty()) return 0.0;

    final int index = (int) Math.ceil((percentile / 100.0) * values.size()) - 1;
    final int clampedIndex = Math.max(0, Math.min(index, values.size() - 1));
    return values.get(clampedIndex);
  }
}
