#!/usr/bin/env python3
"""
Profile _strict_tostring access patterns to identify optimization opportunities.
"""
import functools
import time
import traceback
from collections import defaultdict, Counter

# Global tracking variables
call_stats = {
    'total_calls': 0,
    'total_time': 0,
    'input_sizes': [],
    'input_types': Counter(),
    'call_stacks': defaultdict(int),
    'repeated_inputs': defaultdict(int),
}

def profile_strict_tostring(original_func):
    """Decorator to profile _strict_tostring calls."""
    
    @functools.wraps(original_func)
    def wrapper(dafny_ascii_string):
        start_time = time.perf_counter()
        
        # Track call statistics
        call_stats['total_calls'] += 1
        input_size = len(dafny_ascii_string) if dafny_ascii_string else 0
        call_stats['input_sizes'].append(input_size)
        
        # Analyze input data patterns
        if dafny_ascii_string:
            # Check first few elements to determine type pattern
            sample_size = min(5, len(dafny_ascii_string))
            type_pattern = tuple(type(dafny_ascii_string[i]).__name__ for i in range(sample_size))
            call_stats['input_types'][type_pattern] += 1
            
            # Track repeated inputs (for caching opportunities)
            if input_size < 100:  # Only track small inputs to avoid memory issues
                input_hash = hash(tuple(dafny_ascii_string[:10]))  # Hash first 10 elements
                call_stats['repeated_inputs'][input_hash] += 1
        
        # Track call stack (to see where calls originate)
        stack = traceback.extract_stack()
        caller_info = f"{stack[-3].filename}:{stack[-3].lineno}:{stack[-3].name}"
        call_stats['call_stacks'][caller_info] += 1
        
        # Execute original function
        result = original_func(dafny_ascii_string)
        
        # Track timing
        end_time = time.perf_counter()
        call_time = end_time - start_time
        call_stats['total_time'] += call_time
        
        return result
    
    return wrapper

def analyze_access_patterns():
    """Analyze collected statistics to identify optimization opportunities."""
    print("=== _strict_tostring Access Pattern Analysis ===\n")
    
    if call_stats['total_calls'] == 0:
        print("No calls recorded. Make sure profiling is enabled.")
        return
    
    # Basic statistics
    print(f"Total calls: {call_stats['total_calls']:,}")
    print(f"Total time: {call_stats['total_time']:.4f}s")
    print(f"Average time per call: {call_stats['total_time']/call_stats['total_calls']*1000:.4f}ms")
    
    # Input size analysis
    sizes = call_stats['input_sizes']
    if sizes:
        print(f"\nInput Size Statistics:")
        print(f"  Min size: {min(sizes)}")
        print(f"  Max size: {max(sizes)}")
        print(f"  Average size: {sum(sizes)/len(sizes):.1f}")
        print(f"  Median size: {sorted(sizes)[len(sizes)//2]}")
        
        # Size distribution
        size_buckets = defaultdict(int)
        for size in sizes:
            if size == 0:
                bucket = "empty"
            elif size <= 10:
                bucket = "1-10"
            elif size <= 100:
                bucket = "11-100"
            elif size <= 1000:
                bucket = "101-1000"
            else:
                bucket = "1000+"
            size_buckets[bucket] += 1
        
        print(f"\nSize Distribution:")
        for bucket, count in sorted(size_buckets.items()):
            pct = count / len(sizes) * 100
            print(f"  {bucket:8}: {count:6} calls ({pct:5.1f}%)")
    
    # Type pattern analysis
    print(f"\nInput Type Patterns:")
    for pattern, count in call_stats['input_types'].most_common(10):
        pct = count / call_stats['total_calls'] * 100
        print(f"  {str(pattern):30}: {count:6} calls ({pct:5.1f}%)")
    
    # Call origin analysis
    print(f"\nTop Call Origins:")
    for caller, count in sorted(call_stats['call_stacks'].items(), key=lambda x: x[1], reverse=True)[:10]:
        pct = count / call_stats['total_calls'] * 100
        print(f"  {caller:50}: {count:6} calls ({pct:5.1f}%)")
    
    # Caching opportunity analysis
    repeated_count = sum(1 for count in call_stats['repeated_inputs'].values() if count > 1)
    total_repeated_calls = sum(count for count in call_stats['repeated_inputs'].values() if count > 1)
    
    print(f"\nCaching Opportunities:")
    print(f"  Unique inputs that repeat: {repeated_count}")
    print(f"  Total calls that could be cached: {total_repeated_calls}")
    if call_stats['total_calls'] > 0:
        cache_potential = total_repeated_calls / call_stats['total_calls'] * 100
        print(f"  Cache hit potential: {cache_potential:.1f}%")
    
    # Optimization recommendations
    print(f"\n=== Optimization Recommendations ===")
    
    # Check for empty input pattern
    empty_calls = sum(1 for size in sizes if size == 0)
    if empty_calls > 0:
        empty_pct = empty_calls / len(sizes) * 100
        print(f"• {empty_pct:.1f}% of calls have empty input - add early return check")
    
    # Check for small input optimization
    small_calls = sum(1 for size in sizes if 0 < size <= 10)
    if small_calls > 0:
        small_pct = small_calls / len(sizes) * 100
        print(f"• {small_pct:.1f}% of calls have ≤10 elements - optimize for small inputs")
    
    # Check for type uniformity
    uniform_int_calls = call_stats['input_types'].get(('int',) * 5, 0)
    if uniform_int_calls > 0:
        uniform_pct = uniform_int_calls / call_stats['total_calls'] * 100
        print(f"• {uniform_pct:.1f}% of calls have uniform int types - optimize int-only path")
    
    # Check caching potential
    if cache_potential > 10:
        print(f"• {cache_potential:.1f}% cache hit potential - implement LRU cache")

def install_profiler():
    """Install the profiler on the actual _strict_tostring method."""
    try:
        # Import the actual module
        from smithy_dafny_standard_library.internaldafny.extern.UTF8 import default__
        
        # Wrap the method
        original_method = default__._strict_tostring
        default__._strict_tostring = staticmethod(profile_strict_tostring(original_method))
        
        print("Profiler installed on _strict_tostring")
        return True
    except ImportError as e:
        print(f"Could not install profiler: {e}")
        return False

if __name__ == "__main__":
    print("Access Pattern Profiler for _strict_tostring")
    print("Run your encryption benchmark, then call analyze_access_patterns()")
    
    if install_profiler():
        print("Profiler ready. Run your workload and then call analyze_access_patterns()")
    else:
        print("Manual profiler installation required.")