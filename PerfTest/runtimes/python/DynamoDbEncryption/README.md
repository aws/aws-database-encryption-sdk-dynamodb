# Python Performance Tests: DDBEC v3 vs DB-ESDK v4

This directory contains comprehensive performance benchmarks comparing the **Legacy DynamoDB Encryption Client Python v3** (DDBEC v3) against the **AWS Database Encryption SDK Python v4** (DB-ESDK v4).

## Overview

The performance tests benchmark encryption and decryption operations using pytest-benchmark across multiple data types and encryption providers/keyrings.

### Libraries Under Test

**DDBEC v3 Providers:**

- AES Key Provider
- AWS KMS Key Provider
- Most Recent Key Provider

**DB-ESDK v4 Keyrings:**

- Raw AES Keyring
- AWS KMS Keyring
- Hierarchy Keyring

### Test Data Types

- **single_attribute**: Simple string data
- **nested_attributes**: Complex nested JSON structures
- **flat_attributes**: Multiple top-level attributes

## Quick Start

### Prerequisites

- Python 3.11+
- Poetry installed
- AWS credentials configured
- Access to AWS KMS key: `arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126`

### Installation

```bash
cd PerfTest/runtimes/python/DynamoDbEncryption
poetry install
```

### Run All Benchmarks

```bash
tox -e run-benchmarks

# Or
python run_benchmarks.py

# Or using poetry
poetry run python run_benchmarks.py
```

### Advanced Options

```bash
# Don't save files, only show console output
python run_benchmarks.py --no-save

# Save to custom directory
python run_benchmarks.py --output-dir my_results
```

### Direct pytest Usage

```bash
# Run with pytest directly
poetry run pytest src/ --benchmark-only -v

# Run specific test file
poetry run pytest 'src/v3/aes_key_provider_test.py' --benchmark-only -v

# Run single test function
poetry run pytest 'src/v4/raw_aes_keyring_test.py::test_encrypt_performance[single_attribute]' --benchmark-only -v
```

## Output

The benchmark script generates:

### Console Report

```
PERFORMANCE COMPARISON: DDBEC v3 vs DB-ESDK v4
===============================================

Operation | Data Type | Provider | DDBEC(v3) Mean (ms) | DB ESDK(v4) Mean (ms) | Difference (ms) | DB ESDK(v4) vs DDBEC(v3) (%)
```

### Generated Files

- `raw_results_TIMESTAMP.csv/json` - Detailed benchmark data
- `comparison_TIMESTAMP.csv/json` - Side-by-side comparison
- `report_TIMESTAMP.html` - Visual HTML report

All files saved to `benchmark_results/` directory.

## Understanding Results

### Performance Metrics

- **Mean (ms)**: Average execution time per operation in milliseconds
- **Difference (ms)**: Time difference (DB-ESDK v4 - DDBEC v3) in milliseconds
- **Percentage**: Performance change (negative = v4 faster, positive = v4 slower)

### AWS Credentials

Configure credentials using ada and assume the ddb role:

```bash
# Configure ada credentials
ada credentials update --provider isengard --role=ToolsDevelopment --once \
                       --account 370957321024 --profile=aws-crypto-tools-team+optools-ci-ToolsDevelopment

# Set region and assume role for tests
export AWS_REGION="us-west-2"
TMP_ROLE=$(aws sts assume-role --role-arn "arn:aws:iam::370957321024:role/GitHub-CI-DDBEC-Dafny-Role-us-west-2" --role-session-name "${USER}-Tests-DBEC" --profile aws-crypto-tools-team+optools-ci-ToolsDevelopment)
export TMP_ROLE
export AWS_ACCESS_KEY_ID=$(echo "${TMP_ROLE}" | jq -r '.Credentials.AccessKeyId')
export AWS_SECRET_ACCESS_KEY=$(echo "${TMP_ROLE}" | jq -r '.Credentials.SecretAccessKey')
export AWS_SESSION_TOKEN=$(echo "${TMP_ROLE}" | jq -r '.Credentials.SessionToken')

# Verify credentials are working
aws sts get-caller-identity
```

## License

Licensed under the Apache License 2.0.
