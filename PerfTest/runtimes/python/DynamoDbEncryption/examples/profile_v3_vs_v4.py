#!/usr/bin/env python3
"""
Example: Compare v3 vs v4 performance for AES provider.

This script demonstrates how to use the comprehensive profiler to compare
v3 and v4 encryption performance for AES provider only.
"""

import sys
from pathlib import Path

# Add parent directory to path for imports
sys.path.insert(0, str(Path(__file__).parent.parent))

from profile_comprehensive import ComprehensiveProfiler, ProfilingConfiguration


def main():
    """Compare v3 vs v4 performance for AES provider."""
    
    # Create profiler with custom output directory
    profiler = ComprehensiveProfiler("v3_vs_v4_aes_results")
    
    # Define configurations to compare
    configurations = []
    
    # Compare both versions for AES only
    versions = ["v3", "v4"]
    test_bases = ["item"]  # Focus on item-based for direct comparison
    data_types = ["single", "nested", "flat"]
    operations = ["encrypt", "decrypt"]
    
    for version in versions:
        for test_base in test_bases:
            for data_type in data_types:
                for operation in operations:
                    config = ProfilingConfiguration(
                        test_base=test_base,
                        provider="aes",  # Focus on AES only
                        data_type=data_type,
                        operation=operation,
                        version=version
                    )
                    configurations.append(config)
    
    print(f"Comparing v3 vs v4 AES performance across {len(configurations)} configurations:")
    for config in configurations:
        print(f"  - {config}")
    
    # Run profiling with moderate precision
    profiler.run_comprehensive_profiling(
        configurations=configurations,
        iterations=150,
        line_profile=False
    )
    
    print("\nv3 vs v4 comparison complete!")
    print("Check 'v3_vs_v4_aes_results/comprehensive_profiling_report.txt' for results.")
    print("\nLook for performance differences in the 'PERFORMANCE BY PROVIDER' section.")


if __name__ == "__main__":
    main()
