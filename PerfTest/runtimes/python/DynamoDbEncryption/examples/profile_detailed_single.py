#!/usr/bin/env python3
"""
Example: Detailed profiling of a single configuration with line profiling.

This script demonstrates how to use the comprehensive profiler for deep
analysis of a specific configuration with line-by-line profiling enabled.
"""

import sys
from pathlib import Path

# Add parent directory to path for imports
sys.path.insert(0, str(Path(__file__).parent.parent))

from profile_comprehensive import ComprehensiveProfiler, ProfilingConfiguration


def main():
    """Perform detailed profiling of a specific configuration."""
    
    # Create profiler with custom output directory
    profiler = ComprehensiveProfiler("detailed_profiling_results")
    
    # Define a single configuration for detailed analysis
    config = ProfilingConfiguration(
        test_base="item",
        provider="hierarchy",  # Most complex provider
        data_type="nested",    # Most complex data
        operation="decrypt",   # Often slower than encrypt
        version="v4"
    )
    
    print(f"Performing detailed profiling of configuration: {config}")
    print("This will include:")
    print("  - Function-level profiling with cProfile")
    print("  - Line-by-line profiling with line_profiler")
    print("  - High iteration count for precision")
    print("  - Call graph generation")
    
    # Run profiling with high precision and line profiling
    profiler.run_comprehensive_profiling(
        configurations=[config],
        iterations=500,  # High precision
        line_profile=True  # Enable line profiling
    )
    
    print("\nDetailed profiling complete!")
    print("Results available in 'detailed_profiling_results/' directory:")
    print("  - comprehensive_profiling_report.txt: Summary report")
    print("  - v4_item_hierarchy_nested_decrypt.prof: cProfile data")
    print("  - v4_item_hierarchy_nested_decrypt.png: Call graph (if available)")
    print("\nFor interactive analysis, run:")
    print("  cd detailed_profiling_results")
    print("  snakeviz v4_item_hierarchy_nested_decrypt.prof")


if __name__ == "__main__":
    main()
