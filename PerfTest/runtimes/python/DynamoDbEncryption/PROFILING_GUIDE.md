# Profiling Guide for Encrypt/Decrypt Operations

This guide explains how to profile and compare encryption/decryption operations between DDBEC v3 and DB-ESDK v4.

## Overview

The `profile_encrypt_decrypt.py` script provides detailed profiling information to help you understand:
- Time taken for each encrypt/decrypt operation
- Which functions consume the most time
- Performance differences between v3 and v4
- Detailed call graphs showing the execution flow

## Prerequisites

1. **Basic Requirements** (already installed):
   - Python 3.x
   - DDBEC v3 and DB-ESDK v4 libraries
   - pytest and pytest-benchmark

2. **Optional Tools for Enhanced Profiling**:
   ```bash
   # For line-by-line profiling
   pip install line_profiler

   # For interactive visualization
   pip install snakeviz

   # For call graph generation (macOS)
   pip install gprof2dot
   brew install graphviz

   # For call graph generation (Linux)
   pip install gprof2dot
   sudo apt-get install graphviz
   ```

## Basic Usage

### 1. Profile All Operations (Recommended)

```bash
cd PerfTest/runtimes/python/DynamoDbEncryption
python profile_encrypt_decrypt_aes.py
```

This will:
- Profile both v3 and v4
- Test both encrypt and decrypt operations
- Use all data types (single_attribute, nested_attributes, flat_attributes)
- Run 100 iterations per test
- Generate results in the `profiling_results/` directory

### 2. Profile Specific Versions

```bash
# Profile only v3
python profile_encrypt_decrypt_aes.py --versions v3

# Profile only v4
python profile_encrypt_decrypt_aes.py --versions v4
```

### 3. Profile Specific Operations

```bash
# Profile only encryption
python profile_encrypt_decrypt_aes.py --operations encrypt

# Profile only decryption
python profile_encrypt_decrypt_aes.py --operations decrypt
```

### 4. Profile Specific Data Types

```bash
# Profile only single attribute data
python profile_encrypt_decrypt_aes.py --data-types single_attribute

# Profile nested and flat attributes
python profile_encrypt_decrypt_aes.py --data-types nested_attributes flat_attributes
```

### 5. Advanced Profiling with Line-by-Line Analysis

```bash
# Enable line profiling (requires line_profiler)
python profile_encrypt_decrypt_aes.py --line-profile
```

### 6. Custom Iterations

```bash
# Run with 500 iterations per test for more accurate results
python profile_encrypt_decrypt_aes.py --iterations 500
```

## Understanding the Results

### 1. Console Output

During execution, you'll see real-time summaries:
```
Profiling v3 encrypt with single_attribute data...
  Total time: 0.234s
  Avg per iteration: 2.340ms
  Top 3 time-consuming functions:
    1. encrypt_dynamodb_item - 0.180s (100 calls)
    2. _encrypt_item - 0.120s (100 calls)
    3. _generate_signature - 0.045s (100 calls)
```

### 2. Generated Files

The script creates several output files in the `profiling_results/` directory:

- **profiling_report.txt**: Human-readable summary with:
  - Performance comparisons between v3 and v4
  - Top time-consuming functions for each operation
  - Line-by-line profiles (if enabled)

- **profiling_results.json**: Machine-readable results for further analysis

- **\*.prof files**: Raw profiling data for each test case

- **\*.png files**: Visual call graphs (if graphviz is installed)

### 3. Performance Comparison

The report includes a comparison section showing:
```
PERFORMANCE COMPARISON
--------------------------------------------------------------------------------

ENCRYPT - single_attribute:
  V3: 0.234s
  V4: 0.189s
  Difference: -45.0ms (-19.2%)

DECRYPT - single_attribute:
  V3: 0.156s
  V4: 0.142s
  Difference: -14.0ms (-9.0%)
```

Negative percentages mean v4 is faster than v3.

### 4. Function Analysis

Detailed breakdown of time-consuming functions:
```
V3 ENCRYPT - single_attribute
----------------------------------------
Top 5 Functions by Time:
1. encrypt_dynamodb_item (item.py:123)
   Calls: 100, Total: 0.180s, Avg: 1.800ms
2. _encrypt_item (item.py:245)
   Calls: 100, Total: 0.120s, Avg: 1.200ms
...
```

## Visualizing Results

### 1. Interactive Visualization with SnakeViz

If you have snakeviz installed, run:
```bash
# View a specific profile
snakeviz profiling_results/v3_encrypt_single_attribute.prof

# The script will also print commands for all generated profiles
```

### 2. Call Graphs

If graphviz is installed, PNG call graphs are automatically generated:
- Open `profiling_results/v3_encrypt_single_attribute.png` to see the call flow
- Thicker edges indicate more time spent
- Red nodes indicate bottlenecks

### 3. Comparing Call Graphs

You can visually compare v3 and v4 call graphs side by side:
```bash
# Open both images
open profiling_results/v3_encrypt_single_attribute.png
open profiling_results/v4_encrypt_single_attribute.png
```

## Example: Focused Profiling Session

To specifically compare AES encryption performance between v3 and v4:

```bash
# 1. Profile only AES encryption with more iterations
python profile_encrypt_decrypt_aes.py \
    --operations encrypt \
    --data-types single_attribute \
    --iterations 1000

# 2. Enable line profiling for detailed analysis
python profile_encrypt_decrypt_aes.py \
    --operations encrypt \
    --data-types single_attribute \
    --iterations 100 \
    --line-profile

# 3. View the results
cat profiling_results/profiling_report.txt

# 4. Visualize with snakeviz (if installed)
snakeviz profiling_results/v3_encrypt_single_attribute.prof
```

## Interpreting Performance Differences

When analyzing the results, look for:

1. **Overall Time Differences**: The summary shows if v4 is faster/slower than v3
2. **Function-Level Bottlenecks**: Which specific functions take the most time
3. **Call Count Differences**: v4 might make fewer function calls
4. **Algorithm Differences**: Different encryption approaches between versions

## Tips for Accurate Profiling

1. **Close Other Applications**: Minimize system load for consistent results
2. **Use Sufficient Iterations**: More iterations = more accurate averages
3. **Run Multiple Times**: Results can vary between runs
4. **Profile in Isolation**: Test one specific scenario at a time for clarity
5. **Consider Data Size**: Larger data items may show different performance characteristics

## Troubleshooting

### Missing Dependencies
```bash
# Install all optional dependencies at once
pip install line_profiler snakeviz gprof2dot
```

### Permission Errors
```bash
# Make the script executable
chmod +x profile_encrypt_decrypt_aes.py
```

### Import Errors
```bash
# Ensure you're in the correct directory
cd PerfTest/runtimes/python/DynamoDbEncryption
```

## Next Steps

1. Run the basic profiling to get an overview
2. Focus on specific operations that show performance differences
3. Use line profiling to identify exact bottlenecks
4. Generate call graphs to understand the execution flow
5. Compare the results to make informed optimization decisions

## Additional Analysis

For even deeper analysis, you can:
- Modify the script to profile specific functions
- Add custom timing code around specific operations
- Use memory profilers to analyze memory usage
- Profile with different data sizes to understand scaling
