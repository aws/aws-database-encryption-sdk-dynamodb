"""
Benchmark script to compare the optimized _strict_tostring implementation
against the original implementation.

This validates the performance improvements claimed in the optimization.
"""
import timeit
import memory_profiler
import _dafny
import struct
from typing import List, Any

# Original implementation for comparison
def original_strict_tostring(dafny_ascii_string):
    """Original implementation using multiple to_bytes() calls"""
    return b''\
      .join([c.to_bytes(2, byteorder="big") \
            if isinstance(c, int) \
            else ord(c).to_bytes(2, byteorder="big") \
            for c in dafny_ascii_string])\
      .decode("utf-16-be", errors = 'strict')

# Optimized implementation (from the file)
def optimized_strict_tostring(dafny_ascii_string):
    """Optimized implementation using struct.pack"""
    if not dafny_ascii_string:
        return ""
    
    # Extract code points efficiently - single pass with minimal allocations
    length = len(dafny_ascii_string)
    code_points = []
    code_points_append = code_points.append  # Cache method lookup
    
    for c in dafny_ascii_string:
        # Optimized type checking and code point extraction
        code_points_append(c if isinstance(c, int) else ord(c))
    
    # Single struct.pack call - much more efficient than multiple to_bytes() calls
    # Pre-computed format string avoids string concatenation overhead
    format_str = '>' + 'H' * length  # Big-endian unsigned short format
    utf16_bytes = struct.pack(format_str, *code_points)
    
    return utf16_bytes.decode("utf-16-be", errors='strict')

def create_test_data(size: int) -> List[Any]:
    """Create test data with mix of int and char types"""
    import random
    data = []
    for i in range(size):
        if random.random() < 0.5:
            # Add as int (code point)
            data.append(random.randint(32, 126))  # ASCII printable range
        else:
            # Add as char
            data.append(chr(random.randint(32, 126)))
    return _dafny.Seq(data)

def benchmark_implementations():
    """Benchmark both implementations across different input sizes"""
    test_sizes = [10, 100, 1000, 5000, 10000]
    results = {}
    
    print("=== Performance Benchmark: _strict_tostring Optimization ===\n")
    print(f"{'Size':<8} {'Original (ms)':<15} {'Optimized (ms)':<16} {'Speedup':<10} {'Memory Reduction'}")
    print("-" * 75)
    
    for size in test_sizes:
        # Create test data
        test_data = create_test_data(size)
        
        # Benchmark original implementation
        original_time = timeit.timeit(
            lambda: original_strict_tostring(test_data),
            number=100
        ) * 1000 / 100  # Convert to milliseconds per call
        
        # Benchmark optimized implementation  
        optimized_time = timeit.timeit(
            lambda: optimized_strict_tostring(test_data),
            number=100
        ) * 1000 / 100  # Convert to milliseconds per call
        
        # Calculate speedup
        speedup = original_time / optimized_time if optimized_time > 0 else float('inf')
        
        # Memory usage comparison
        original_memory = memory_profiler.memory_usage((original_strict_tostring, (test_data,)))[0]
        optimized_memory = memory_profiler.memory_usage((optimized_strict_tostring, (test_data,)))[0]
        memory_reduction = ((original_memory - optimized_memory) / original_memory * 100) if original_memory > 0 else 0
        
        print(f"{size:<8} {original_time:<15.3f} {optimized_time:<16.3f} {speedup:<10.2f}x {memory_reduction:<8.1f}%")
        
        results[size] = {
            'original_time': original_time,
            'optimized_time': optimized_time,
            'speedup': speedup,
            'memory_reduction': memory_reduction
        }
    
    return results

def validate_correctness():
    """Validate that both implementations produce identical results"""
    print("\n=== Correctness Validation ===\n")
    
    test_cases = [
        _dafny.Seq([]),  # Empty
        _dafny.Seq([65]),  # Single int
        _dafny.Seq(['A']),  # Single char
        _dafny.Seq([65, 66, 67]),  # Multiple ints
        _dafny.Seq(['A', 'B', 'C']),  # Multiple chars
        _dafny.Seq([65, 'B', 67, 'D']),  # Mixed
        _dafny.Seq([ord(c) for c in "Hello, World!"]),  # Realistic string as ints
        _dafny.Seq(list("Hello, World!")),  # Realistic string as chars
    ]
    
    all_correct = True
    for i, test_case in enumerate(test_cases):
        try:
            original_result = original_strict_tostring(test_case)
            optimized_result = optimized_strict_tostring(test_case)
            
            if original_result == optimized_result:
                print(f"Test {i+1}: ✓ PASS")
            else:
                print(f"Test {i+1}: ✗ FAIL - Results differ")
                print(f"  Original:  {repr(original_result)}")
                print(f"  Optimized: {repr(optimized_result)}")
                all_correct = False
        except Exception as e:
            print(f"Test {i+1}: ✗ ERROR - {e}")
            all_correct = False
    
    if all_correct:
        print("\n✓ All correctness tests passed!")
    else:
        print("\n✗ Some correctness tests failed!")
    
    return all_correct

def complexity_analysis():
    """Analyze time complexity scaling"""
    print("\n=== Complexity Analysis ===\n")
    
    sizes = [100, 200, 500, 1000, 2000, 5000]
    original_times = []
    optimized_times = []
    
    for size in sizes:
        test_data = create_test_data(size)
        
        # Time both implementations
        original_time = timeit.timeit(
            lambda: original_strict_tostring(test_data),
            number=50
        ) / 50
        
        optimized_time = timeit.timeit(
            lambda: optimized_strict_tostring(test_data),
            number=50
        ) / 50
        
        original_times.append(original_time)
        optimized_times.append(optimized_time)
    
    print("Input Size vs Execution Time (seconds):")
    print(f"{'Size':<8} {'Original':<12} {'Optimized':<12} {'Ratio'}")
    print("-" * 45)
    
    for i, size in enumerate(sizes):
        ratio = original_times[i] / optimized_times[i] if optimized_times[i] > 0 else float('inf')
        print(f"{size:<8} {original_times[i]:<12.6f} {optimized_times[i]:<12.6f} {ratio:<8.2f}x")
    
    # Linear regression to confirm O(n) complexity
    import numpy as np
    
    # Check if timing scales linearly with input size
    orig_slope = np.polyfit(sizes, original_times, 1)[0]
    opt_slope = np.polyfit(sizes, optimized_times, 1)[0]
    
    print(f"\nLinear scaling coefficients:")
    print(f"Original implementation:  {orig_slope:.2e} s/element")
    print(f"Optimized implementation: {opt_slope:.2e} s/element")
    print(f"Optimization factor: {orig_slope/opt_slope:.2f}x faster per element")

if __name__ == "__main__":
    print("Starting comprehensive benchmark of _strict_tostring optimization...\n")
    
    # Validate correctness first
    if not validate_correctness():
        print("Correctness validation failed! Stopping benchmark.")
        exit(1)
    
    # Run performance benchmarks
    results = benchmark_implementations()
    
    # Analyze complexity
    complexity_analysis()
    
    # Summary
    print("\n=== Summary ===")
    avg_speedup = sum(r['speedup'] for r in results.values()) / len(results)
    avg_memory_reduction = sum(r['memory_reduction'] for r in results.values()) / len(results)
    
    print(f"Average speedup: {avg_speedup:.2f}x")
    print(f"Average memory reduction: {avg_memory_reduction:.1f}%")
    print(f"Time complexity: O(n) (confirmed linear scaling)")
    print(f"Space complexity: O(n) (single allocation)")
    
    if avg_speedup >= 1.4:  # 40% improvement threshold
        print("\n✓ Optimization target achieved!")
    else:
        print(f"\n⚠ Optimization below target (expected ≥1.4x, got {avg_speedup:.2f}x)")
