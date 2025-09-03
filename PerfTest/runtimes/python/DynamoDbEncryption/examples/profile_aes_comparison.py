#!/usr/bin/env python3
"""
Example: Compare AES performance across different configurations.

This script demonstrates how to use the comprehensive profiler to compare
AES encryption performance across different test bases and data types.
"""

import sys
from pathlib import Path

# Add parent directory to path for imports
sys.path.insert(0, str(Path(__file__).parent.parent))

from profile_comprehensive import ComprehensiveProfiler, ProfilingConfiguration


def main():
    """Compare AES performance across configurations."""
    
    # Create profiler with custom output directory
    profiler = ComprehensiveProfiler("aes_comparison_results")
    
    # Define configurations to compare
    configurations = []
    
    # Test both item and client approaches
    test_bases = ["item", "client"]
    data_types = ["single", "nested", "flat"]
    operations = ["encrypt", "decrypt"]
    
    for test_base in test_bases:
        for data_type in data_types:
            for operation in operations:
                config = ProfilingConfiguration(
                    test_base=test_base,
                    provider="aes",  # Focus on AES only
                    data_type=data_type,
                    operation=operation,
                    version="v4"
                )
                configurations.append(config)
    
    print(f"Comparing AES performance across {len(configurations)} configurations:")
    for config in configurations:
        print(f"  - {config}")
    
    # Run profiling with higher precision
    profiler.run_comprehensive_profiling(
        configurations=configurations,
        iterations=200,  # Higher precision
        line_profile=False  # Disable for speed
    )
    
    print("\nAES comparison complete!")
    print("Check 'aes_comparison_results/comprehensive_profiling_report.txt' for results.")


if __name__ == "__main__":
    main()
