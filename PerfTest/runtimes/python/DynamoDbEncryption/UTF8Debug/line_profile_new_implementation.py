#!/usr/bin/env python3

"""
Line profiling script for the new string conversion implementation.
This will show which lines are consuming the most time in the new_implementation function.
"""

import sys
import os
from line_profiler import LineProfiler
from _dafny import Seq

# Add path to find the test_string_conversion module
sys.path.insert(0, os.path.dirname(__file__))
from test_string_conversion import new_implementation, original_implementation

def create_test_data():
    """Create various test datasets for profiling"""
    test_datasets = {
        # 'small_ascii': Seq(['H', 'e', 'l', 'l', 'o']),
        # 'small_int': Seq([72, 101, 108, 108, 111]),
        # 'medium_ascii': Seq(['A'] * 100),
        # 'large_ascii': Seq(['X'] * 1000),
        'mixed_data': Seq([ord('A') + (i % 26) for i in range(500)]),
        # 'unicode_chinese': Seq([0x4F60, 0x597D]),
        # 'mixed_types': Seq([72, 'e', 108, 'l', 111]),
        # 'very_large': Seq(['Z'] * 5000),
    }
    return test_datasets

def profile_function_with_dataset(profiler, func, dataset, iterations=1000):
    """Profile a function with a specific dataset"""
    for _ in range(iterations):
        func(dataset)

def run_line_profiling():
    """Run comprehensive line profiling on the new implementation"""
    print("🔍 Line Profiling Analysis for new_implementation()")
    print("=" * 70)
    
    # Create test datasets
    test_datasets = create_test_data()
    
    # Create line profiler
    profiler = LineProfiler()
    profiler.add_function(new_implementation)
    
    print("\n📊 Profiling new_implementation with various datasets...")
    
    # Enable profiling
    profiler.enable_by_count()
    
    # Run profiling with different datasets
    for dataset_name, dataset in test_datasets.items():
        print(f"   Testing with {dataset_name}: {len(dataset)} characters")
        
        # Adjust iterations based on dataset size
        if len(dataset) > 1000:
            iterations = 100
        elif len(dataset) > 100:
            iterations = 500
        else:
            iterations = 1000
            
        profile_function_with_dataset(profiler, new_implementation, dataset, iterations)
    
    # Disable profiling
    profiler.disable_by_count()
    
    print("\n📋 Generating line-by-line profiling report...")
    
    # Generate and save the profiling report
    with open('line_profile_results.txt', 'w') as f:
        f.write("Line Profiling Results for new_implementation()\n")
        f.write("=" * 60 + "\n\n")
        f.write("Dataset Summary:\n")
        for name, dataset in test_datasets.items():
            f.write(f"  {name}: {len(dataset)} characters\n")
        f.write("\n")
        
        # Redirect profiler output to file
        profiler.print_stats(stream=f)
    
    # Also print to console
    print("\n" + "=" * 70)
    print("📄 LINE PROFILING RESULTS")
    print("=" * 70)
    profiler.print_stats()
    
    return profiler

def analyze_results():
    """Analyze and summarize the profiling results"""
    print("\n" + "=" * 70)
    print("🔍 ANALYSIS SUMMARY")
    print("=" * 70)
    
    analysis = []
    analysis.append("Key areas to analyze in the new_implementation:")
    analysis.append("")
    analysis.append("1. LINE: length = len(dafny_ascii_string)")
    analysis.append("   - Function call overhead for len()")
    analysis.append("")
    analysis.append("2. LINE: buffer = bytearray(length * 2)")
    analysis.append("   - Memory allocation cost")
    analysis.append("   - Should be O(1) but depends on size")
    analysis.append("")
    analysis.append("3. LINE: for i, char in enumerate(dafny_ascii_string):")
    analysis.append("   - Loop setup overhead")
    analysis.append("   - Iterator creation cost")
    analysis.append("")
    analysis.append("4. LINE: value = ord(char) if isinstance(char, str) else char")
    analysis.append("   - Type checking overhead (isinstance)")
    analysis.append("   - Conditional execution")
    analysis.append("   - ord() function call when needed")
    analysis.append("")
    analysis.append("5. LINE: buffer[i*2] = (value >> 8) & 0xFF")
    analysis.append("   - Bit shift and mask operations")
    analysis.append("   - Array indexing and assignment")
    analysis.append("")
    analysis.append("6. LINE: buffer[i*2 + 1] = value & 0xFF")
    analysis.append("   - Mask operation")
    analysis.append("   - Array indexing and assignment")
    analysis.append("")
    analysis.append("7. LINE: return buffer.decode('utf-16be', errors='strict')")
    analysis.append("   - String decoding operation")
    analysis.append("   - Should be O(n) but relatively fast")
    analysis.append("")
    analysis.append("Expected hotspots:")
    analysis.append("- The for loop body (lines 4-6) - executed most frequently")
    analysis.append("- isinstance() calls - potentially expensive type checking")
    analysis.append("- Buffer assignments - memory write operations")
    
    for line in analysis:
        print(line)
    
    # Save analysis to file
    with open('line_profile_analysis.txt', 'w') as f:
        f.write('\n'.join(analysis))
    
    print(f"\n💾 Analysis saved to: line_profile_analysis.txt")
    print(f"💾 Detailed results saved to: line_profile_results.txt")

def main():
    """Main function to run line profiling analysis"""
    try:
        print("Starting line profiling analysis...")
        profiler = run_line_profiling()
        analyze_results()
        
        print("\n✅ Line profiling analysis complete!")
        print("\nFiles generated:")
        print("  📄 line_profile_results.txt - Detailed profiling data")
        print("  📄 line_profile_analysis.txt - Analysis summary")
        
    except ImportError as e:
        print(f"❌ Import error: {e}")
        print("Make sure line_profiler is installed: pip install line_profiler")
        sys.exit(1)
    except Exception as e:
        print(f"❌ Error during profiling: {e}")
        import traceback
        traceback.print_exc()
        sys.exit(1)

if __name__ == '__main__':
    main()
