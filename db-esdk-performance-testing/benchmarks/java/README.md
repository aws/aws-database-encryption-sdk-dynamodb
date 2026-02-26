# DB-ESDK Java Benchmark

Performance benchmark suite for the AWS Database Encryption SDK (DB-ESDK) Java implementation.

## Quick Start

```bash
# Run quick benchmark
./gradlew run --args="--config ../config/test-scenarios.yaml --quick"

# Run full benchmark
./gradlew run --args="--config ../config/test-scenarios.yaml"

# Run with custom output path
./gradlew run --args="--config ../config/test-scenarios.yaml --output ../results/raw-data/my-java-results.json"
```

## Build

```bash
# Build the project
./gradlew build

# Build fat JAR for standalone execution
./gradlew fatJar

# Run the fat JAR
java -jar build/libs/db-esdk-benchmark-java-1.0.0-all.jar --quick
```

## Configuration

The benchmark uses YAML configuration files. See `../config/test-scenarios.yaml` for the full configuration format.

### Quick Mode

Quick mode runs a subset of tests with reduced iterations:

- Only runs test types specified in `quick_config.test_types`
- Uses smaller data sizes from `quick_config.data_sizes.small`
- Fewer iterations: `quick_config.iterations.measurement`

### Configuration Structure

```yaml
# Data sizes to test (in bytes)
data_sizes:
  small: [1024, 5120, 10240] # 1KB, 5KB, 10KB
  medium: [102400, 512000, 1048576] # 100KB, 500KB, 1MB
  large: [10485760, 52428800, 104857600] # 10MB, 50MB, 100MB

# Test iterations
iterations:
  warmup: 5 # Warmup iterations (not counted)
  measurement: 10 # Measurement iterations

# Concurrency levels to test
concurrency_levels: [1, 2, 4, 8, 16]

# DynamoDB table name
table_name: "dbesdk-performance-testing"

# Keyring type
keyring: "raw-aes"

# Quick test configuration
quick_config:
  data_sizes:
    small: [102400] # 100KB only for quick mode
  iterations:
    warmup: 3
    measurement: 3
  concurrency_levels: [1, 2]
  test_types: ["throughput", "memory", "concurrency"]
```

## Test Types

- **throughput**: Measures operations per second, latency percentiles (P50/P95/P99), and separate put/get latencies
- **memory**: Measures peak memory usage during operations with continuous sampling
- **concurrency**: Tests performance under concurrent load with multiple threads

## Command Line Options

```
Usage: java -jar db-esdk-benchmark.jar [options]

Options:
 -c,--config <file>   Path to test configuration file (default: ../config/test-scenarios.yaml)
 -h,--help           Show this help message
 -o,--output <file>   Path to output results file (default: ../results/raw-data/java_results.json)
 -q,--quick          Run quick test with reduced iterations
```

## Output Format

Results are saved to JSON format matching the Go implementation:

```json
{
  "metadata": {
    "language": "java",
    "timestamp": "2025-01-21 10:50:00",
    "java_version": "11.0.16",
    "cpu_count": 8,
    "total_memory_gb": 16.0,
    "total_tests": 22
  },
  "results": [
    {
      "test_name": "throughput",
      "language": "java",
      "data_size": 1024,
      "concurrency": 1,
      "put_latency_ms": 1.2,
      "get_latency_ms": 1.1,
      "end_to_end_latency_ms": 2.3,
      "ops_per_second": 426.4,
      "bytes_per_second": 436641.2,
      "peak_memory_mb": 0,
      "memory_efficiency_ratio": 0,
      "p50_latency": 1.8,
      "p95_latency": 1.81,
      "p99_latency": 1.82,
      "timestamp": "2025-01-21 10:45:30",
      "java_version": "11.0.16",
      "cpu_count": 8,
      "total_memory_gb": 16.0
    }
  ]
}
```

## Architecture

The Java implementation mirrors the Go benchmark architecture:

### Core Components

- **`Program.java`**: Main entry point with CLI argument parsing
- **`DBESDKBenchmark.java`**: Main benchmark orchestration and execution
- **`TestConfig.java`**: YAML configuration parsing and management
- **`BenchmarkResult.java`**: Results data structure matching Go output format
- **`KeyringSetup.java`**: Keyring initialization (Raw AES keyring)
- **`Utils.java`**: Utility functions for statistics, memory monitoring, and formatting

### Test Implementation

- **Throughput Tests**: Measure `EncryptItem` and `DecryptItem` operations separately
- **Memory Tests**: Continuous heap monitoring during operations using JVM MemoryMXBean
- **Concurrency Tests**: ExecutorService-based multi-threaded testing

### DynamoDB Item Structure

The benchmark tests encryption of DynamoDB items with this structure:

```java
{
  "partition_key": "benchmark-test",     // SIGN_ONLY
  "sort_key": "0",                       // SIGN_ONLY
  "attribute1": {                        // ENCRYPT_AND_SIGN
    "data": <test_data_bytes>
  },
  "attribute2": "sign me!",              // SIGN_ONLY
  ":attribute3": "ignore me!"            // DO_NOTHING (prefix excludes from encryption)
}
```

## Dependencies

- **AWS Database Encryption SDK for DynamoDB**: Core encryption functionality
- **AWS Cryptographic Material Providers Library**: Keyring management
- **AWS SDK for Java v2**: DynamoDB types and utilities
- **SnakeYAML**: Configuration file parsing
- **Jackson**: JSON output formatting
- **Apache Commons CLI**: Command line argument parsing

## System Requirements

- **Java 11+**: Minimum supported version
- **Gradle**: Build system (wrapper included)
- **Memory**: At least 2GB heap recommended for large data size tests
- **CPU**: Multi-core recommended for concurrency tests

## Comparison with Go Implementation

The Java implementation provides identical functionality to the Go version:

- **Same test types**: throughput, memory, concurrency
- **Same data sizes**: 1KB to 100MB range
- **Same configuration format**: YAML with quick mode support
- **Same output format**: JSON with matching field names and structure
- **Same keyring setup**: Raw AES-256 keyring with random key generation
- **Same item structure**: Identical DynamoDB attribute encryption policies

## Performance Notes

- **JVM Warmup**: The benchmark includes warmup iterations to account for JIT compilation
- **Memory Measurement**: Uses JVM MemoryMXBean for accurate heap usage tracking
- **Garbage Collection**: Forces GC between memory test iterations for consistent measurements
- **Concurrency**: Uses ExecutorService thread pools for controlled concurrent testing

## Examples

```bash
# Quick benchmark with default settings
./gradlew run --args="--quick"

# Full benchmark with custom configuration
./gradlew run --args="-c /path/to/custom-config.yaml -o /path/to/results.json"

# Run only specific test types (modify config file)
# Edit config.yaml to set quick_config.test_types: ["throughput"]
./gradlew run --args="--quick"

# Build standalone JAR and run
./gradlew fatJar
java -Xmx4g -jar build/libs/db-esdk-benchmark-java-1.0.0-all.jar --quick
```
