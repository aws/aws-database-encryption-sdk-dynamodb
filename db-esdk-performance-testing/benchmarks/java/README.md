# DB-ESDK Performance Benchmark - Java

This directory contains the Java implementation of the AWS Database Encryption SDK (DB-ESDK) performance benchmark suite.

## Overview

The Java benchmark provides comprehensive performance testing for the DB-ESDK Java runtime, measuring:

- **Throughput**: Operations per second and bytes per second using DynamoDB batch operations
- **Latency**: Put, get, and end-to-end timing for encrypted DynamoDB operations
- **Memory Usage**: Peak memory consumption and efficiency
- **Concurrency**: Multi-threaded performance scaling
- **Statistical Analysis**: P50, P95, P99 latency percentiles

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Local DynamoDB instance running on localhost:8000
- Access to AWS Database Encryption SDK for DynamoDB Java libraries

## Local DynamoDB Setup

Start a local DynamoDB instance:

```bash
# Using Docker
docker run -p 8000:8000 amazon/dynamodb-local

# Or download and run DynamoDB Local
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb -port 8000
```

Create the test table:

```bash
aws dynamodb create-table \
    --table-name db-esdk-performance-test \
    --attribute-definitions \
        AttributeName=partition_key,AttributeType=S \
        AttributeName=sort_key,AttributeType=N \
    --key-schema \
        AttributeName=partition_key,KeyType=HASH \
        AttributeName=sort_key,KeyType=RANGE \
    --billing-mode PAY_PER_REQUEST \
    --endpoint-url http://localhost:8000
```

## Building

```bash
# Build the project
mvn clean compile

# Create executable JAR
mvn clean package

# Run tests
mvn test
```

## Running Benchmarks

### Quick Test

```bash
# Using Maven
mvn exec:java -Dexec.mainClass="com.amazon.esdk.benchmark.Program" -Dexec.args="--quick"

# Using JAR
java -jar target/esdk-benchmark.jar --quick
```

### Full Benchmark Suite

```bash
# Using Maven
mvn exec:java -Dexec.mainClass="com.amazon.esdk.benchmark.Program"

# Using JAR
java -jar target/esdk-benchmark.jar
```

### Custom Configuration

```bash
# Specify custom config and output paths
java -jar target/esdk-benchmark.jar \
  --config /path/to/config.yaml \
  --output /path/to/results.json
```

## Command Line Options

- `--config, -c`: Path to test configuration file (default: `../../config/test-scenarios.yaml`)
- `--output, -o`: Path to output results file (default: `../../results/raw-data/java_results.json`)
- `--quick, -q`: Run quick test with reduced iterations
- `--help, -h`: Show help message

## Configuration

The benchmark uses a YAML configuration file to define test parameters:

```yaml
data_sizes:
  small: [1024, 5120, 10240]
  medium: [102400, 512000, 1048576]
  large: [10485760, 52428800, 104857600]

iterations:
  warmup: 5
  measurement: 10

concurrency_levels: [1, 2, 4, 8]
```

## Output Format

Results are saved in JSON format with the following structure:

```json
{
  "metadata": {
    "language": "java",
    "timestamp": "2025-09-05T15:30:00Z",
    "javaVersion": "17.0.2",
    "cpuCount": 8,
    "totalMemoryGB": 16.0,
    "totalTests": 45
  },
  "results": [
    {
      "test_name": "throughput",
      "language": "java",
      "data_size": 1024,
      "concurrency": 1,
      "put_latency_ms": 0.85,
      "get_latency_ms": 0.72,
      "end_to_end_latency_ms": 1.57,
      "ops_per_second": 636.94,
      "bytes_per_second": 652224.0,
      "peak_memory_mb": 0.0,
      "memory_efficiency_ratio": 0.0,
      "p50_latency": 1.55,
      "p95_latency": 1.89,
      "p99_latency": 2.12,
      "timestamp": "2025-09-05T15:30:15Z",
      "java_version": "17.0.2",
      "cpu_count": 8,
      "total_memory_gb": 16.0
    }
  ]
}
```

## Key Features

### DB-ESDK Integration
- Uses AWS Database Encryption SDK for DynamoDB with transparent encryption
- Configures attribute actions (ENCRYPT_AND_SIGN, SIGN_ONLY, DO_NOTHING)
- Tests actual DynamoDB operations with client-side encryption
- Uses Raw AES keyring for consistent performance testing

### Batch Operations
- Performs BatchWriteItem operations with 25 items per batch
- Measures BatchGetItem operations with consistent reads
- Tests realistic DynamoDB workloads with encryption overhead

### Performance Metrics
- **Throughput Tests**: Measures ops/sec and bytes/sec for batch operations
- **Memory Tests**: Tracks peak memory usage during encrypted operations
- **Concurrency Tests**: Evaluates multi-threaded performance scaling
- **Latency Analysis**: P50, P95, P99 percentiles for operation timing

## Dependencies

Key dependencies used in this benchmark:

- **AWS Database Encryption SDK for DynamoDB**: Core encryption functionality for DynamoDB
- **AWS Cryptographic Material Providers**: Keyring and cryptographic material management
- **AWS SDK for Java v2 DynamoDB**: DynamoDB client operations
- **Jackson**: JSON/YAML processing
- **Commons CLI**: Command line argument parsing
- **ProgressBar**: Visual progress indication
- **SLF4J**: Logging framework
- **JUnit**: Unit testing (test scope)

## License

This benchmark suite is part of the AWS Encryption SDK project and follows the same licensing terms.
