# DB-ESDK Performance Benchmark - Python

This directory contains the Python implementation of the AWS Database Encryption SDK (DB-ESDK) performance benchmark suite.

## Overview

The Python benchmark provides comprehensive performance testing for the DB-ESDK Python runtime, measuring:

- **Throughput**: Operations per second and bytes per second using ItemEncryptor operations
- **Latency**: Encrypt, decrypt, and end-to-end timing for encrypted operations
- **Memory Usage**: Peak memory consumption and efficiency
- **Concurrency**: Multi-threaded performance scaling
- **Statistical Analysis**: P50, P95, P99 latency percentiles

## Prerequisites

- Python 3.11 or higher
- Poetry package manager

## Setup

### Install Poetry

```bash
# Install Poetry (if not already installed)
curl -sSL https://install.python-poetry.org | python3 -

# Or using pip
pip install poetry
```

### Install Dependencies

```bash
# Install all dependencies including dev dependencies
poetry install

# Install only production dependencies
poetry install --no-dev
```

## Building

```bash
# Build distribution packages
poetry build

# Install in development mode (automatic with poetry install)
poetry install

# Run tests using tox
tox -e py311

# Run all tox environments
tox
```

## Running Benchmarks

### Quick Test

```bash
# Using Poetry
poetry run esdk-benchmark --quick

# Using tox (recommended for isolated environment)
tox -e benchmark

# Using module execution
poetry run python -m esdk_benchmark --quick

# Direct script execution
poetry run python src/esdk_benchmark/program.py --quick
```

### Full Benchmark Suite

```bash
# Using Poetry
poetry run esdk-benchmark

# Using tox (recommended for isolated environment)
tox -e benchmark-full

# Using module execution
poetry run python -m esdk_benchmark

# Direct script execution
poetry run python src/esdk_benchmark/program.py
```

### Custom Configuration

```bash
# Specify custom config and output paths
poetry run esdk-benchmark \
  --config /path/to/config.yaml \
  --output /path/to/results.json
```

## Command Line Options

- `--config, -c`: Path to test configuration file (default: `../../../config/test-scenarios.yaml`)
- `--output, -o`: Path to output results file (default: `../../../results/raw-data/python_results.json`)
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
    "language": "python",
    "timestamp": "2025-09-05T15:30:00Z",
    "python_version": "3.11.5",
    "platform": "Darwin-23.1.0-arm64-arm-64bit",
    "cpu_count": 8,
    "total_memory_gb": 16.0,
    "total_tests": 45
  },
  "results": [
    {
      "test_name": "throughput",
      "language": "python",
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
      "python_version": "3.11.5",
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
- Tests ItemEncryptor operations with client-side encryption
- Uses Raw AES keyring for consistent performance testing

### ItemEncryptor Operations
- Performs encrypt_python_item operations using Python dict format
- Measures decrypt_python_item operations for consistency
- Tests realistic workloads with encryption overhead
- Supports multiple data formats (Python dict, DynamoDB JSON, DBESDK shapes)

### Performance Metrics
- **Throughput Tests**: Measures ops/sec and bytes/sec for ItemEncryptor operations
- **Memory Tests**: Tracks peak memory usage during encrypted operations using psutil
- **Concurrency Tests**: Evaluates multi-threaded performance scaling with ThreadPoolExecutor
- **Latency Analysis**: P50, P95, P99 percentiles for operation timing

## Project Structure

```
python/
├── README.md                          # This file
├── pyproject.toml                     # Poetry configuration and dependencies
├── tox.ini                           # Tox configuration for testing
├── src/
│   └── esdk_benchmark/
│       ├── __init__.py               # Package initialization
│       ├── __main__.py               # Module execution entry point
│       ├── program.py                # Main program and CLI
│       ├── benchmark.py              # Core benchmark implementation
│       ├── models.py                 # Data models and configuration
│       └── tests.py                  # Individual test implementations
├── tests/                            # Test suite
│   ├── __init__.py
│   └── test_benchmark.py
└── run_benchmark.py                  # Convenience runner script
```

## Dependencies

Key dependencies used in this benchmark:

- **aws-dbesdk-dynamodb**: Core encryption functionality for DynamoDB (with legacy-ddbec extras)
- **boto3**: AWS SDK for Python (DynamoDB client operations)
- **PyYAML**: YAML configuration file processing
- **pydantic**: Data validation and settings management
- **tqdm**: Progress bars for visual feedback
- **psutil**: System and process utilities for memory monitoring
- **numpy**: Numerical operations and statistics

### Development Dependencies
- **pytest**: Testing framework
- **pytest-cov**: Coverage reporting
- **black**: Code formatting
- **flake8**: Linting
- **mypy**: Type checking
- **tox**: Testing automation
- **memory-profiler**: Memory profiling utilities

## Development

### Code Style

The project follows Python best practices with automated tooling:

```bash
# Format code
tox -e format

# Check formatting
tox -e format-check

# Lint code
tox -e lint

# Type checking
tox -e type

# Run all quality checks
tox -e lint,type,format-check
```

### Running Tests

```bash
# Run all tests
tox -e py311

# Run tests with Poetry
poetry run pytest

# Run with coverage
poetry run pytest --cov=esdk_benchmark

# Run specific test file
poetry run pytest tests/test_benchmark.py

# Run all tox environments
tox
```

### Memory Profiling

For detailed memory analysis:

```bash
# Memory profiler is included in dev dependencies
poetry run python -m memory_profiler src/esdk_benchmark/benchmark.py

# Or using tox
tox -e benchmark  # Includes memory profiler
```

### Tox Environments

Available tox environments:

- `py311`: Run tests under Python 3.11
- `lint`: Run linting checks
- `type`: Run type checking
- `format`: Apply code formatting
- `format-check`: Check code formatting
- `benchmark`: Run quick benchmark
- `benchmark-full`: Run full benchmark suite
- `verify`: Verify setup and dependencies
- `clean`: Clean up build artifacts

## Troubleshooting

### Common Issues

1. **Import Errors**: Ensure Poetry environment is properly set up
   ```bash
   poetry install
   poetry run python -c "import esdk_benchmark; print('✓ OK')"
   ```

2. **Configuration Not Found**: Check that the config file path is correct relative to execution directory
   ```bash
   ls ../../config/test-scenarios.yaml
   ```

3. **Memory Issues**: For large data sizes, ensure sufficient system memory is available

4. **Permission Errors**: Ensure write permissions for output directory
   ```bash
   mkdir -p ../../results/raw-data/
   ```

5. **Poetry Issues**: If Poetry environment is corrupted
   ```bash
   poetry env remove python
   poetry install
   ```

### Debug Mode

Enable verbose logging for troubleshooting:

```python
import logging
logging.basicConfig(level=logging.DEBUG)
```

## Performance Comparison

This Python implementation mirrors the Java benchmark structure, enabling:

- Cross-language performance comparisons
- Consistent test scenarios and data sizes
- Standardized output format for analysis
- Similar statistical analysis and reporting

## License

This benchmark suite is part of the AWS Database Encryption SDK project and follows the same Apache-2.0 licensing terms.
