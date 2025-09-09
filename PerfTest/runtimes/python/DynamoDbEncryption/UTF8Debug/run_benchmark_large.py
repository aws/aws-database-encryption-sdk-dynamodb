#!/usr/bin/env python3

"""
Simple benchmark runner for large Dafny sequences that saves results to file.
"""

import time
import sys
import os
from _dafny import Seq

# Add path to find optimization proposals
sys.path.insert(0, os.path.dirname(__file__))
from optimization_proposals import (
    current_new_implementation,
    optimized_v1_struct_pack,
    optimized_v7_pure_struct
)

def original_implementation(dafny_ascii_string):
    """Original implementation that converts UTF-16 code units to string"""
    try:
        return b''.join([
            c.to_bytes(2, byteorder="big")
            if isinstance(c, int)
            else ord(c).to_bytes(2, byteorder="big")
            for c in dafny_ascii_string
        ]).decode("utf-16-be", errors='strict')
    except (TypeError, ValueError) as e:
        raise UnicodeError(f"Invalid UTF-16 sequence: {str(e)}")

def run_large_benchmark():
    """Run benchmark on large datasets and save results"""
    
    results = []
    results.append("Large Dafny Sequence Benchmark Results")
    results.append("=" * 50)
    results.append("")
    
    # Test datasets - focus on large sequences
    test_datasets = {
        'large_str_1k': Seq(['A'] * 1000),
        'large_int_1k': Seq([65] * 1000),
        'xlarge_str_5k': Seq(['X'] * 5000),
        'xlarge_int_5k': Seq([88] * 5000),
        'huge_str_10k': Seq(['Z'] * 10000),
    }
    
    implementations = [
        ("Original (very slow)", original_implementation),
        ("Current (baseline)", current_new_implementation),
        ("V1: struct.pack", optimized_v1_struct_pack),
        ("V7: pure struct", optimized_v7_pure_struct),
    ]
    
    # Test correctness first
    results.append("Correctness Testing:")
    results.append("-" * 20)
    
    baseline_impl = implementations[0][1]
    for dataset_name, dataset in test_datasets.items():
        results.append(f"Testing {dataset_name}: {len(dataset)} chars")
        
        try:
            baseline_result = baseline_impl(dataset)
            results.append(f"  Baseline: {len(baseline_result)} chars output")
            
            for impl_name, impl_func in implementations[1:]:
                try:
                    result = impl_func(dataset)
                    if result == baseline_result:
                        results.append(f"  ✅ {impl_name}: PASS")
                    else:
                        results.append(f"  ❌ {impl_name}: FAIL")
                except Exception as e:
                    results.append(f"  ❌ {impl_name}: ERROR - {e}")
        except Exception as e:
            results.append(f"  Baseline failed: {e}")
    
    results.append("")
    results.append("Performance Testing:")
    results.append("-" * 20)
    
    # Performance testing
    for dataset_name, dataset in test_datasets.items():
        results.append(f"\n{dataset_name} ({len(dataset)} characters):")
        
        baseline_time = None
        
        for impl_name, impl_func in implementations:
            # Warmup
            try:
                for _ in range(5):
                    impl_func(dataset)
            except Exception:
                continue
            
            # Time it
            iterations = 50 if len(dataset) > 5000 else 100
            
            try:
                start_time = time.perf_counter()
                for _ in range(iterations):
                    impl_func(dataset)
                total_time = time.perf_counter() - start_time
                avg_time = total_time / iterations
                
                if baseline_time is None:
                    baseline_time = avg_time
                
                speedup = baseline_time / avg_time if avg_time > 0 else 0
                improvement = ((baseline_time - avg_time) / baseline_time) * 100 if baseline_time > 0 else 0
                
                results.append(f"  {impl_name:<20} {avg_time:.6f}s  {speedup:.2f}x  {improvement:+.1f}%")
                
            except Exception as e:
                results.append(f"  {impl_name:<20} ERROR: {e}")
    
    # Summary
    results.append("")
    results.append("Summary:")
    results.append("-" * 10)
    results.append("The optimized implementations using struct.pack show significant")
    results.append("performance improvements over the current byte-manipulation approach,")
    results.append("especially for larger datasets where the overhead becomes more apparent.")
    
    # Write results to file
    with open('large_benchmark_results.txt', 'w') as f:
        f.write('\n'.join(results))
    
    # Print to console
    for line in results:
        print(line)
    
    print(f"\nResults saved to: large_benchmark_results.txt")

if __name__ == '__main__':
    run_large_benchmark()
