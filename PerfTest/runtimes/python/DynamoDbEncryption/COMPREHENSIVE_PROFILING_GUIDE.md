# Comprehensive Profiling Suite

This guide explains how to use the comprehensive profiling suite for DynamoDB encryption performance testing with configurable options.

## Overview

The comprehensive profiling suite (`profile_comprehensive.py`) allows you to systematically profile all combinations of:

- **Test Base**: `item` (item encryption) vs `client` (EncryptedClient)
- **Provider**: `aes`, `kms`, `hierarchy` (most recent/hierarchy keyring)
- **Data Type**: `single`, `nested`, `flat` attributes
- **Operation**: `encrypt`, `decrypt`
- **Version**: `v3`, `v4`

## Quick Start

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

### Interactive Analysis

Use `snakeviz` for interactive profiling visualization:

```bash
cd comprehensive_profiling_results
snakeviz v4_item_aes_single_encrypt.prof
```

## Example Use Cases

### 1. Find the Fastest Configuration
```bash
# Profile all with high precision
python profile_comprehensive.py --iterations 500

# Check report for best throughput numbers
less comprehensive_profiling_results/comprehensive_profiling_report.txt
```

### 2. Compare Providers
```bash
# Profile all providers with single data type for fair comparison
python profile_comprehensive.py --data-types single --test-bases item
```

### 3. Debug Performance Issues
```bash
# Profile problematic configuration with line profiler
python profile_comprehensive.py \
  --providers hierarchy \
  --operations decrypt \
  --line-profile \
  --iterations 50
```

### 4. Validate Optimizations
```bash
# Before optimization
python profile_comprehensive.py --providers aes --output-dir before_optimization

# After optimization  
python profile_comprehensive.py --providers aes --output-dir after_optimization

# Compare the results
```

## Requirements

### Basic Profiling
- Python 3.7+
- All test dependencies installed

### Enhanced Features
- `line_profiler`: For line-by-line profiling
  ```bash
  pip install line_profiler
  ```

- `snakeviz`: For interactive visualization
  ```bash
  pip install snakeviz
  ```

- `gprof2dot` + `graphviz`: For call graphs
  ```bash
  pip install gprof2dot
  brew install graphviz  # macOS
  # or apt-get install graphviz  # Ubuntu
  ```

## Performance Tips

1. **Start Small**: Begin with fewer configurations to understand the baseline
2. **Use Appropriate Iterations**: 100 iterations for general profiling, 500+ for precision
3. **Profile in Isolation**: Run on a quiet system for consistent results
4. **Compare Fairly**: Use same iterations and data types when comparing providers
5. **Check for Outliers**: Re-run if results seem inconsistent

## Troubleshooting

### Import Errors
If you see import errors for test classes, ensure all dependencies are installed and the Python path is set correctly.

### Memory Issues
For large-scale profiling (many configurations × high iterations), consider:
- Reducing iterations per test
- Profiling subsets of configurations
- Running on a machine with more RAM

### Inconsistent Results
- Ensure system is not under load during profiling
- Run multiple times and average results
- Check for background processes affecting performance

## Integration with Existing Tools

The comprehensive profiler can be used alongside existing profiling tools:

- `profile_encrypt_decrypt_aes.py`: For detailed AES-specific analysis
- `profile_memory_usage.py`: For memory profiling
- Pytest benchmarks: For regression testing

Results are compatible with standard Python profiling analysis tools.
