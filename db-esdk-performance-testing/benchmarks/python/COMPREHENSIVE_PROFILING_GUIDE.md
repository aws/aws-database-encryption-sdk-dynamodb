# Comprehensive Profiling Suite

This guide explains how to use the comprehensive profiling suite for DynamoDB encryption performance testing with configurable options.

## Overview

The comprehensive profiling suite (`profile_comprehensive.py`) allows you to systematically profile all combinations of:

- **Test Base**: `item` (item encryption) vs `client` (EncryptedClient)
- **Provider**: `aes`, `kms`, `hierarchy` (most recent/hierarchy keyring)
- **Data Type**: `single`, `nested`, `flat` attributes
- **Operation**: `encrypt`, `decrypt`
- **Version**: `v3`, `v4`

Note: Profiling High Level Client or KMS Operations would require AWS credentials.

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
```

## Quick Start

### Quick Profiling for AES Only Operations(Do not need AWS Credentials)

```bash
python profile_comprehensive.py --test-bases item --providers aes --data-types single --version v4
```

### Profile All Combinations (Default)
```bash
# Profile all combinations with default settings (v4 only)
python profile_comprehensive.py

# Generated configurations: 36 total
# 2 test bases × 3 providers × 3 data types × 2 operations × 1 version = 36
```

### Profile Specific Configurations

```bash
# Profile only AES provider with item-based tests
python profile_comprehensive.py --test-bases item --providers aes

# Profile only encrypt operations
python profile_comprehensive.py --operations encrypt

# Profile specific data types
python profile_comprehensive.py --data-types single flat

# Profile with more iterations for higher precision
python profile_comprehensive.py --iterations 200
```

### Compare v3 vs v4 Performance

```bash
# Compare v3 and v4 for AES provider only
python profile_comprehensive.py --versions v3 v4 --providers aes

# Compare versions for all providers (72 configurations total)
python profile_comprehensive.py --versions v3 v4
```

### Advanced Profiling

```bash
# Enable line-by-line profiling (requires line_profiler)
python profile_comprehensive.py --line-profile --providers aes --data-types single

# Custom output directory
python profile_comprehensive.py --output-dir my_profiling_results

# Profile specific combination for detailed analysis
python profile_comprehensive.py \
  --test-bases item \
  --providers aes \
  --data-types nested \
  --operations encrypt \
  --iterations 500 \
  --line-profile
```

## Configuration Options

### Test Bases

- **`item`**: Direct encryption using `encrypt_dynamodb_item()` and `decrypt_dynamodb_item()`
  - Lower overhead, focuses on core encryption/decryption performance
  - Best for profiling the encryption algorithms themselves

- **`client`**: Encryption via `EncryptedClient`
  - Higher-level API with additional overhead
  - Best for profiling real-world usage patterns

### Providers

- **`aes`**: Raw AES encryption
  - Fastest option, no key management overhead
  - Uses fixed AES-256 key material

- **`kms`**: AWS KMS key provider/keyring
  - Production-ready key management
  - Includes network calls to KMS (may be mocked in tests)

- **`hierarchy`**: Hierarchy keyring (v4) / Most Recent key provider (v3)
  - Advanced key management with key derivation
  - Includes key caching and rotation capabilities

### Data Types

- **`single`**: Single attribute item
  - Minimal data, fastest encryption
  - Good for measuring base overhead

- **`nested`**: Nested structure with maps and lists
  - Complex data structures
  - Tests serialization/deserialization performance

- **`flat`**: Multiple flat attributes
  - Many attributes at the same level
  - Tests attribute action processing

### Operations

- **`encrypt`**: Measures encryption performance
- **`decrypt`**: Measures decryption performance

## Output Structure

The profiling suite generates comprehensive reports in the specified output directory:

```
comprehensive_profiling_results/
├── comprehensive_profiling_report.txt    # Human-readable summary
├── comprehensive_profiling_results.json  # Machine-readable results
├── v4_item_aes_single_encrypt.prof      # cProfile data files
├── v4_item_aes_single_encrypt.png       # Call graphs (if graphviz available)
├── v4_item_aes_single_decrypt.prof
├── v4_client_kms_nested_encrypt.prof
└── ... (one .prof file per configuration)
```

## Report Analysis

### Summary by Dimension

The report includes performance summaries organized by:

1. **Test Base**: Average performance for item vs client approaches
2. **Provider**: Comparison of AES, KMS, and hierarchy performance
3. **Data Type**: How data complexity affects performance
4. **Operation**: Encrypt vs decrypt timing differences

### Detailed Results

For each configuration, the report includes:

- Configuration details
- Time per operation (milliseconds)
- Throughput (operations per second)
- Data size metrics
- Size increase ratio (encrypted vs original)
- Top 5 time-consuming functions

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