# Enhanced Line Profiling Guide

This guide explains how to use the new `profile_comprehensive_line.py` script to perform detailed line-by-line profiling of DynamoDB encryption operations to identify performance bottlenecks and access patterns.

## Prerequisites

Install the required line profiler:
```bash
pip install line_profiler
```

## Quick Start

### Basic Line Profiling (V4 AES)
```bash
python profile_comprehensive_line.py
```
This will profile V4 AES encryption and decryption with single attribute data using 10 iterations each.

### Profile with More Iterations (Higher Accuracy)
```bash
python profile_comprehensive_line.py --iterations 50
```

### Compare V3 vs V4 Line Profiles
```bash
python profile_comprehensive_line.py --versions v3 v4 --iterations 20
```

### Profile All Providers for Comparison
```bash
python profile_comprehensive_line.py --providers aes kms hierarchy --iterations 15
```

## Command Line Options

| Option | Description | Default | Example |
|--------|-------------|---------|---------|
| `--test-bases` | Test bases to profile | `item` | `--test-bases item client` |
| `--providers` | Providers to profile | `aes` | `--providers aes kms hierarchy` |
| `--data-types` | Data complexity levels | `single` | `--data-types single nested flat` |
| `--operations` | Operations to profile | `encrypt decrypt` | `--operations encrypt` |
| `--versions` | SDK versions | `v4` | `--versions v3 v4` |
| `--iterations` | Iterations per test | `10` | `--iterations 50` |
| `--output-dir` | Output directory | `line_profiling_results` | `--output-dir my_analysis` |

## Output Files

The profiler generates several output files in the specified directory:

### 1. Comprehensive Analysis Report
- **File**: `comprehensive_line_profiling_report.txt`
- **Content**: Cross-configuration pattern analysis, hotspots, function summaries
- **Use**: High-level overview of performance patterns

### 2. Individual Line Profile Files
- **Files**: `{version}_{test_base}_{provider}_{data_type}_{operation}_line_profile.txt`
- **Content**: Raw line-by-line profiling output from line_profiler
- **Use**: Detailed analysis of specific configurations

### 3. JSON Results
- **File**: `line_profiling_results.json`
- **Content**: Structured data with all analysis results
- **Use**: Programmatic analysis or further processing

## Analysis Features

### Pattern Analysis
The profiler automatically categorizes operations into patterns:

- **String Operations**: `.encode()`, `.decode()`, `str()`, `.join()`, etc.
- **Crypto Operations**: `encrypt`, `decrypt`, `sign`, `hmac`, `aes`, etc.
- **Data Conversion**: `to_dafny`, `from_dafny`, `serialize`, etc.
- **AWS Operations**: `kms`, `dynamodb`, `boto3`, etc.
- **Memory Operations**: `copy`, `deepcopy`, `.append()`, etc.

### Hotspot Detection
Automatically identifies:
- Lines consuming >1% of total execution time
- Functions with highest cumulative time
- Most frequently called operations
- Slowest individual lines

### Access Pattern Insights
Provides visibility into:
- Function call hierarchies
- Time distribution across different operation types
- Performance bottlenecks in specific code paths
- Comparison across different configurations

## Example Usage Scenarios

### 1. Identify V4 Performance Issues
```bash
# Focus on V4 decrypt operations which might be slow
python profile_comprehensive_line.py --versions v4 --operations decrypt --iterations 30
```

### 2. Compare String Operation Overhead
```bash
# Profile different data types to see string conversion impact
python profile_comprehensive_line.py --data-types single nested flat --iterations 25
```

### 3. Analyze Provider-Specific Bottlenecks
```bash
# Compare all providers to identify which has overhead
python profile_comprehensive_line.py --providers aes kms hierarchy --operations encrypt --iterations 20
```

### 4. Deep Analysis of Specific Configuration
```bash
# High-iteration analysis of a problematic configuration
python profile_comprehensive_line.py --versions v4 --providers aes --data-types nested --operations decrypt --iterations 100
```

## Reading the Results

### Comprehensive Report Structure
1. **Cross-Configuration Pattern Analysis**: Shows which operation types consume the most time across all configurations
2. **Individual Configuration Analysis**: Detailed breakdown for each tested configuration
3. **Hotspots**: Specific lines of code consuming the most time
4. **Function Summary**: Time distribution across functions

### Line Profile Format
```
Line #      Hits         Time  Per Hit   % Time  Line Contents
     1                                           def encrypt_item(self, item):
     2         5         12.0      2.4      5.2      encrypted = self.encryptor.encrypt(item)
     3         5        180.0     36.0     78.3      result = convert_to_ddb_format(encrypted)
     4         5         38.0      7.6     16.5      return result
```

- **Line #**: Source code line number
- **Hits**: Number of times line was executed
- **Time**: Total time spent on this line (microseconds)
- **Per Hit**: Average time per execution
- **% Time**: Percentage of total function time
- **Line Contents**: The actual source code

### Key Metrics to Look For
- **High % Time**: Lines consuming large percentages indicate bottlenecks
- **High Per Hit**: Lines that are slow per execution
- **High Hits + High Time**: Frequently called slow operations
- **Pattern Concentrations**: Which operation types dominate execution time

## Advanced Analysis

### Finding Access Patterns
1. Look for repetitive operations with high hit counts
2. Identify data conversion bottlenecks (to_dafny/from_dafny)
3. Find string encoding/decoding overhead
4. Spot inefficient copying or memory operations

### Performance Optimization Targets
1. **String Operations**: High overhead in encode/decode operations
2. **Data Conversion**: Expensive transformations between formats
3. **Crypto Operations**: Actual encryption/decryption time
4. **Memory Operations**: Unnecessary copying or allocation

### Cross-Version Comparison
When comparing V3 vs V4:
1. Look for new overhead patterns in V4
2. Identify operations that got faster/slower
3. Find new bottlenecks introduced by architecture changes
4. Spot opportunities for optimization

## Integration with Other Tools

### With cProfile Results
Use alongside `profile_comprehensive.py` for full analysis:
```bash
# First run function-level profiling
python profile_comprehensive.py --versions v3 v4 --providers aes --iterations 100

# Then run line-level profiling for detailed analysis
python profile_comprehensive_line.py --versions v3 v4 --providers aes --iterations 50
```

### With Performance Monitoring
- Track line-level metrics over time
- Identify regressions in specific code paths
- Monitor optimization impact at line granularity

## Tips for Effective Profiling

### Iteration Count Guidelines
- **Quick Analysis**: 10-20 iterations
- **Accurate Analysis**: 50-100 iterations  
- **High Precision**: 100+ iterations (for small bottlenecks)

### Configuration Selection
- Start with problem configurations identified by function-level profiling
- Focus on operations showing performance issues
- Compare similar configurations to isolate variables

### Output Analysis
- Start with the comprehensive report for overview
- Drill down to individual profiles for specific insights
- Use JSON output for programmatic analysis or visualization

This enhanced line profiler provides the detailed insights needed to identify and optimize performance bottlenecks in DynamoDB encryption operations at the code line level.
