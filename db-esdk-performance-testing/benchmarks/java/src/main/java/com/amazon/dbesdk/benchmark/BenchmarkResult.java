// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package com.amazon.dbesdk.benchmark;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the results of a single benchmark test.
 * Fields match the Go implementation exactly for compatibility.
 */
public class BenchmarkResult {

  @JsonProperty("test_name")
  private String testName;

  @JsonProperty("language")
  private String language;

  @JsonProperty("data_size")
  private int dataSize;

  @JsonProperty("concurrency")
  private int concurrency;

  @JsonProperty("put_latency_ms")
  private double putLatencyMs;

  @JsonProperty("get_latency_ms")
  private double getLatencyMs;

  @JsonProperty("end_to_end_latency_ms")
  private double endToEndLatencyMs;

  @JsonProperty("ops_per_second")
  private double opsPerSecond;

  @JsonProperty("bytes_per_second")
  private double bytesPerSecond;

  @JsonProperty("peak_memory_mb")
  private double peakMemoryMb;

  @JsonProperty("memory_efficiency_ratio")
  private double memoryEfficiencyRatio;

  @JsonProperty("p50_latency")
  private double p50Latency;

  @JsonProperty("p95_latency")
  private double p95Latency;

  @JsonProperty("p99_latency")
  private double p99Latency;

  @JsonProperty("timestamp")
  private String timestamp;

  @JsonProperty("java_version")
  private String javaVersion;

  @JsonProperty("cpu_count")
  private int cpuCount;

  @JsonProperty("total_memory_gb")
  private double totalMemoryGb;

  // Constructors
  public BenchmarkResult() {}

  public BenchmarkResult(
    String testName,
    String language,
    int dataSize,
    int concurrency
  ) {
    this.testName = testName;
    this.language = language;
    this.dataSize = dataSize;
    this.concurrency = concurrency;
  }

  // Getters and Setters
  public String getTestName() {
    return testName;
  }

  public void setTestName(String testName) {
    this.testName = testName;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public int getDataSize() {
    return dataSize;
  }

  public void setDataSize(int dataSize) {
    this.dataSize = dataSize;
  }

  public int getConcurrency() {
    return concurrency;
  }

  public void setConcurrency(int concurrency) {
    this.concurrency = concurrency;
  }

  public double getPutLatencyMs() {
    return putLatencyMs;
  }

  public void setPutLatencyMs(double putLatencyMs) {
    this.putLatencyMs = putLatencyMs;
  }

  public double getGetLatencyMs() {
    return getLatencyMs;
  }

  public void setGetLatencyMs(double getLatencyMs) {
    this.getLatencyMs = getLatencyMs;
  }

  public double getEndToEndLatencyMs() {
    return endToEndLatencyMs;
  }

  public void setEndToEndLatencyMs(double endToEndLatencyMs) {
    this.endToEndLatencyMs = endToEndLatencyMs;
  }

  public double getOpsPerSecond() {
    return opsPerSecond;
  }

  public void setOpsPerSecond(double opsPerSecond) {
    this.opsPerSecond = opsPerSecond;
  }

  public double getBytesPerSecond() {
    return bytesPerSecond;
  }

  public void setBytesPerSecond(double bytesPerSecond) {
    this.bytesPerSecond = bytesPerSecond;
  }

  public double getPeakMemoryMb() {
    return peakMemoryMb;
  }

  public void setPeakMemoryMb(double peakMemoryMb) {
    this.peakMemoryMb = peakMemoryMb;
  }

  public double getMemoryEfficiencyRatio() {
    return memoryEfficiencyRatio;
  }

  public void setMemoryEfficiencyRatio(double memoryEfficiencyRatio) {
    this.memoryEfficiencyRatio = memoryEfficiencyRatio;
  }

  public double getP50Latency() {
    return p50Latency;
  }

  public void setP50Latency(double p50Latency) {
    this.p50Latency = p50Latency;
  }

  public double getP95Latency() {
    return p95Latency;
  }

  public void setP95Latency(double p95Latency) {
    this.p95Latency = p95Latency;
  }

  public double getP99Latency() {
    return p99Latency;
  }

  public void setP99Latency(double p99Latency) {
    this.p99Latency = p99Latency;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getJavaVersion() {
    return javaVersion;
  }

  public void setJavaVersion(String javaVersion) {
    this.javaVersion = javaVersion;
  }

  public int getCpuCount() {
    return cpuCount;
  }

  public void setCpuCount(int cpuCount) {
    this.cpuCount = cpuCount;
  }

  public double getTotalMemoryGb() {
    return totalMemoryGb;
  }

  public void setTotalMemoryGb(double totalMemoryGb) {
    this.totalMemoryGb = totalMemoryGb;
  }

  @Override
  public String toString() {
    return String.format(
      "BenchmarkResult{testName='%s', dataSize=%d, concurrency=%d, opsPerSecond=%.2f}",
      testName,
      dataSize,
      concurrency,
      opsPerSecond
    );
  }
}
