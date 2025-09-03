#!/usr/bin/env python3
"""
Quick demo of the comprehensive profiling suite.

This script runs a minimal profiling example to verify the suite is working
and demonstrate basic usage with fast execution.
"""

import sys
from pathlib import Path

# Add parent directory to path for imports
sys.path.insert(0, str(Path(__file__).parent.parent))

from profile_comprehensive import ComprehensiveProfiler, ProfilingConfiguration


def main():
    """Run a quick demo of the profiling suite."""
    
    print("=== Quick Demo of Comprehensive Profiling Suite ===\n")
    
    # Create profiler with demo output directory
    profiler = ComprehensiveProfiler("demo_results")
    
    # Define a minimal set of configurations for quick testing
    configurations = [
        # V3 AES encrypt with single attribute (fastest case)
        ProfilingConfiguration(
            test_base="item",
            provider="aes",
            data_type="single",
            operation="encrypt",
            version="v3"
        ),
        # V3 AES decrypt with single attribute
        ProfilingConfiguration(
            test_base="item",
            provider="aes",
            data_type="single",
            operation="decrypt",
            version="v3"
        ),
        # V3 Client-based encryption for comparison
        ProfilingConfiguration(
            test_base="client",
            provider="aes",
            data_type="single",
            operation="encrypt",
            version="v3"
        ),
        # V3 Client-based encryption for comparison
        ProfilingConfiguration(
            test_base="client",
            provider="aes",
            data_type="single",
            operation="decrypt",
            version="v3"
        ),
        # V4 AES encrypt with single attribute (fastest case)
        ProfilingConfiguration(
            test_base="item",
            provider="aes",
            data_type="single",
            operation="encrypt",
            version="v4"
        ),
        # V4 ES decrypt with single attribute
        ProfilingConfiguration(
            test_base="item",
            provider="aes",
            data_type="single", 
            operation="decrypt",
            version="v4"
        ),
        # V4 Client-based encryption for comparison
        ProfilingConfiguration(
            test_base="client",
            provider="aes",
            data_type="single",
            operation="encrypt",
            version="v4"
        ),
        # V4 Client-based encryption for comparison
        ProfilingConfiguration(
            test_base="client",
            provider="aes",
            data_type="single",
            operation="decrypt",
            version="v4"
        )
    ]
    
    print("Demo will profile these configurations:")
    for i, config in enumerate(configurations, 1):
        print(f"  {i}. {config}")
    
    print(f"\nRunning {len(configurations)} quick tests with 20 iterations each...")
    print("This should complete in under 30 seconds.\n")
    
    # Run profiling with low iteration count for speed
    profiler.run_comprehensive_profiling(
        configurations=configurations,
        iterations=20,  # Low count for quick demo
        line_profile=False  # Disable for speed
    )
    
    print("\n" + "="*60)
    print("DEMO COMPLETE!")
    print("="*60)
    print(f"\nResults saved to: demo_results/")
    print("Key files created:")
    print("  - comprehensive_profiling_report.txt  (Human-readable summary)")
    print("  - comprehensive_profiling_results.json (Machine-readable data)")
    print("  - *.prof files (cProfile data for each configuration)")
    
    print("\nNext steps:")
    print("  1. View the report:")
    print("     less demo_results/comprehensive_profiling_report.txt")
    print()
    print("  2. Try interactive profiling (if snakeviz is installed):")
    print("     cd demo_results")
    print("     snakeviz v4_item_aes_single_encrypt.prof")
    print()
    print("  3. Run a more comprehensive profile:")
    print("     python profile_comprehensive.py --providers aes --iterations 100")
    print()
    print("  4. Compare versions:")
    print("     python examples/profile_v3_vs_v4.py")
    
    print(f"\nDemo completed successfully! 🎉")


if __name__ == "__main__":
    main()
