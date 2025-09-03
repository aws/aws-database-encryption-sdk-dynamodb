# Profiling Examples

This directory contains example scripts demonstrating different ways to use the comprehensive profiling suite.

## Available Examples

### 1. `profile_aes_comparison.py`
Compare AES performance across different test bases (item vs client) and data types.

```bash
python examples/profile_aes_comparison.py
```

**What it does:**
- Profiles AES provider only
- Tests both item and client approaches
- Tests all data types (single, nested, flat)
- Tests both encrypt and decrypt operations
- Uses 200 iterations for higher precision

**Best for:** Understanding how test approach and data complexity affects AES performance.

### 2. `profile_v3_vs_v4.py`
Compare v3 vs v4 performance for AES provider.

```bash
python examples/profile_v3_vs_v4.py
```

**What it does:**
- Compares v3 and v4 versions
- Focuses on AES provider only
- Uses item-based tests for direct comparison
- Tests all data types and operations
- Uses 150 iterations

**Best for:** Understanding performance differences between v3 and v4 implementations.

### 3. `profile_detailed_single.py`
Detailed profiling of a single configuration with line profiling.

```bash
python examples/profile_detailed_single.py
```

**What it does:**
- Profiles one complex configuration (hierarchy + nested + decrypt)
- Enables line-by-line profiling
- Uses 500 iterations for high precision
- Generates call graphs
- Provides detailed analysis

**Best for:** Deep-dive analysis of performance bottlenecks in a specific scenario.

## Running the Examples

### Prerequisites
```bash
# Install optional profiling tools for enhanced features
pip install line_profiler snakeviz gprof2dot

# Install graphviz for call graphs (platform-specific)
# macOS:
brew install graphviz
# Ubuntu:
# sudo apt-get install graphviz
```

### Basic Usage
```bash
# Run from the main profiling directory
cd PerfTest/runtimes/python/DynamoDbEncryption/

# Run any example
python examples/profile_aes_comparison.py
python examples/profile_v3_vs_v4.py
python examples/profile_detailed_single.py
```

### Viewing Results
Each example creates its own output directory:
- `aes_comparison_results/`
- `v3_vs_v4_aes_results/`
- `detailed_profiling_results/`

View the human-readable report:
```bash
less aes_comparison_results/comprehensive_profiling_report.txt
```

View interactive profiling data:
```bash
cd aes_comparison_results
snakeviz *.prof
```

## CLI Usage Examples

You can also use the main script directly with various options:

```bash
# Quick AES-only profiling
python profile_comprehensive.py --providers aes --iterations 50

# Compare all providers with single data type
python profile_comprehensive.py --data-types single --test-bases item

# Detailed analysis with line profiling
python profile_comprehensive.py \
  --providers hierarchy \
  --data-types nested \
  --operations decrypt \
  --line-profile \
  --iterations 100

# Full v3 vs v4 comparison (72 configurations)
python profile_comprehensive.py --versions v3 v4

# Encrypt-only performance testing
python profile_comprehensive.py --operations encrypt --iterations 300

# Client-based testing only
python profile_comprehensive.py --test-bases client --providers aes kms
```

## Customizing Examples

You can modify the example scripts to create your own custom profiling scenarios:

1. **Change providers:** Modify the `provider` parameter in configurations
2. **Adjust iterations:** Change the `iterations` parameter for different precision levels
3. **Enable/disable features:** Toggle `line_profile` for line-by-line analysis
4. **Change output directory:** Modify the output directory name
5. **Add more configurations:** Expand the loops to test more combinations

## Performance Tips

1. **Start small:** Begin with fewer iterations and configurations
2. **Use appropriate precision:** 50-100 iterations for exploration, 200+ for measurement
3. **Profile on idle system:** Ensure consistent results by minimizing background activity
4. **Compare fairly:** Use identical configurations when comparing different aspects

## Output Analysis

### Key Metrics to Look For

1. **Time per operation:** Lower is better
2. **Throughput (ops/sec):** Higher is better  
3. **Size increase ratio:** How much encryption increases data size
4. **Top functions:** Where time is actually spent

### Comparing Results

- **Across providers:** AES typically fastest, KMS has network overhead, hierarchy has key derivation cost
- **Across data types:** Single < flat < nested (typically)
- **Across operations:** Decrypt often slightly slower than encrypt
- **Across test bases:** Item-based typically faster than client-based

### Red Flags

- **Unusually high times:** May indicate system load or configuration issues
- **High variance:** May need more iterations or system optimization
- **Memory issues:** Large configurations may require system tuning
