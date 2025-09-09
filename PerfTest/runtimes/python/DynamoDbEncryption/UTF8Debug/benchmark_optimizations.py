#!/usr/bin/env python3

"""
Comprehensive benchmark of all optimization proposals for the new string conversion implementation.
Based on line profiling analysis showing that 98.8% of execution time is in the main loop.
"""

import time
import statistics
import sys
import os
from _dafny import Seq

# Add path to find optimization proposals
sys.path.insert(0, os.path.dirname(__file__))
from optimization_proposals import (
    current_new_implementation,
    optimized_v1_struct_pack,
    optimized_v2_type_separation,
    optimized_v3_manual_indexing,
    optimized_v4_memoryview,
    optimized_v5_hybrid,
    optimized_v6_minimal_calls,
    optimized_v7_pure_struct
)

class OptimizationBenchmark:
    """Comprehensive benchmarking suite for optimization variants"""
    
    def __init__(self):
        self.implementations = [
            ("Current (baseline)", current_new_implementation),
            ("V1: struct.pack", optimized_v1_struct_pack),
            ("V2: type separation", optimized_v2_type_separation),
            ("V3: manual indexing", optimized_v3_manual_indexing),
            ("V4: memoryview", optimized_v4_memoryview),
            ("V5: hybrid", optimized_v5_hybrid),
            ("V6: minimal calls", optimized_v6_minimal_calls),
            ("V7: pure struct", optimized_v7_pure_struct),
        ]
        
        self.test_datasets = {
            'large_str_1k': Seq(['A'] * 1000),
            'large_int_1k': Seq([65] * 1000),
            'large_mixed_1k': Seq([ord('A') + (i % 26) if i % 2 == 0 else chr(ord('A') + (i % 26)) for i in range(1000)]),
            'xlarge_str_5k': Seq(['X'] * 5000),
            'xlarge_int_5k': Seq([88] * 5000),
            'xlarge_mixed_5k': Seq([ord('A') + (i % 26) if i % 3 == 0 else chr(ord('A') + (i % 26)) for i in range(5000)]),
            'huge_str_10k': Seq(['Z'] * 10000),
            'huge_int_10k': Seq([90] * 10000),
            'unicode_large': Seq([0x4F60, 0x597D] * 500),  # Chinese repeated
        }
    
    def verify_correctness(self):
        """Verify all implementations produce identical results"""
        print("🔍 Verifying correctness of all optimization variants...")
        
        baseline_impl = self.implementations[0][1]
        all_correct = True
        
        for dataset_name, dataset in self.test_datasets.items():
            print(f"  Testing {dataset_name}: {len(dataset)} chars")
            
            try:
                baseline_result = baseline_impl(dataset)
            except Exception as e:
                print(f"    ❌ Baseline failed: {e}")
                all_correct = False
                continue
            
            for impl_name, impl_func in self.implementations[1:]:
                try:
                    result = impl_func(dataset)
                    if result == baseline_result:
                        print(f"    ✅ {impl_name}: PASS")
                    else:
                        print(f"    ❌ {impl_name}: FAIL - Different result")
                        print(f"       Expected: {repr(baseline_result[:50])}")
                        print(f"       Got:      {repr(result[:50])}")
                        all_correct = False
                except Exception as e:
                    print(f"    ❌ {impl_name}: ERROR - {e}")
                    all_correct = False
        
        return all_correct
    
    def benchmark_implementation(self, impl_func, dataset, iterations=1000):
        """Benchmark a single implementation"""
        times = []
        
        # Warmup
        for _ in range(10):
            impl_func(dataset)
        
        # Actual timing
        for _ in range(iterations):
            start = time.perf_counter()
            impl_func(dataset)
            times.append(time.perf_counter() - start)
        
        return {
            'mean': statistics.mean(times),
            'median': statistics.median(times),
            'min': min(times),
            'max': max(times),
            'stddev': statistics.stdev(times) if len(times) > 1 else 0,
            'times': times
        }
    
    def run_comprehensive_benchmark(self):
        """Run comprehensive performance benchmark"""
        print("\n🚀 Running Comprehensive Performance Benchmark")
        print("=" * 70)
        
        results = {}
        
        for dataset_name, dataset in self.test_datasets.items():
            print(f"\n📊 Dataset: {dataset_name} ({len(dataset)} characters)")
            print("-" * 50)
            
            dataset_results = {}
            baseline_time = None
            
            for impl_name, impl_func in self.implementations:
                print(f"   Benchmarking {impl_name}...")
                
                # Adjust iterations based on dataset size
                if len(dataset) > 1000:
                    iterations = 100
                elif len(dataset) > 100:
                    iterations = 500
                else:
                    iterations = 1000
                
                try:
                    bench_result = self.benchmark_implementation(impl_func, dataset, iterations)
                    dataset_results[impl_name] = bench_result
                    
                    if baseline_time is None:
                        baseline_time = bench_result['mean']
                    
                    speedup = baseline_time / bench_result['mean']
                    improvement = ((baseline_time - bench_result['mean']) / baseline_time) * 100
                    
                    print(f"      Time: {bench_result['mean']:.6f}s ± {bench_result['stddev']:.6f}s")
                    print(f"      Speedup: {speedup:.2f}x ({improvement:+.1f}%)")
                    
                except Exception as e:
                    print(f"      ❌ ERROR: {e}")
                    dataset_results[impl_name] = None
            
            results[dataset_name] = dataset_results
        
        return results
    
    def generate_summary_report(self, results):
        """Generate comprehensive summary report"""
        print("\n" + "=" * 70)
        print("📋 OPTIMIZATION BENCHMARK SUMMARY")
        print("=" * 70)
        
        # Calculate overall performance across all datasets
        impl_totals = {}
        
        for dataset_name, dataset_results in results.items():
            print(f"\n🎯 Best performers for {dataset_name.upper()}:")
            
            # Sort by performance
            valid_results = [(name, res) for name, res in dataset_results.items() if res is not None]
            valid_results.sort(key=lambda x: x[1]['mean'])
            
            baseline_time = valid_results[0][1]['mean'] if valid_results else 0
            
            for i, (impl_name, result) in enumerate(valid_results[:3]):  # Top 3
                speedup = baseline_time / result['mean'] if result['mean'] > 0 else 0
                rank_emoji = ["🥇", "🥈", "🥉"][i] if i < 3 else "  "
                print(f"   {rank_emoji} {impl_name}: {result['mean']:.6f}s ({speedup:.2f}x)")
                
                # Accumulate for overall totals
                if impl_name not in impl_totals:
                    impl_totals[impl_name] = []
                impl_totals[impl_name].append(result['mean'])
        
        # Overall winner
        print(f"\n🏆 OVERALL PERFORMANCE RANKING:")
        print("-" * 40)
        
        overall_rankings = []
        for impl_name, times in impl_totals.items():
            avg_time = statistics.mean(times)
            overall_rankings.append((impl_name, avg_time))
        
        overall_rankings.sort(key=lambda x: x[1])
        baseline_avg = overall_rankings[0][1] if overall_rankings else 0
        
        for i, (impl_name, avg_time) in enumerate(overall_rankings):
            speedup = baseline_avg / avg_time if avg_time > 0 else 0
            improvement = ((baseline_avg - avg_time) / baseline_avg) * 100 if baseline_avg else 0
            rank_emoji = ["🥇", "🥈", "🥉"][i] if i < 3 else f"{i+1:2d}."
            print(f"   {rank_emoji} {impl_name:<25} {avg_time:.6f}s ({speedup:.2f}x, {improvement:+.1f}%)")
        
        # Recommendations
        print(f"\n💡 RECOMMENDATIONS:")
        print("-" * 20)
        
        if len(overall_rankings) >= 2:
            winner = overall_rankings[0]
            runner_up = overall_rankings[1]
            
            print(f"✅ BEST OVERALL: {winner[0]}")
            print(f"   - Average time: {winner[1]:.6f}s")
            print(f"   - Consistently fastest across all dataset sizes")
            print()
            print(f"🥈 RUNNER-UP: {runner_up[0]}")
            print(f"   - Average time: {runner_up[1]:.6f}s")
            print(f"   - Good alternative with {runner_up[1]/winner[1]:.2f}x relative performance")
            
            if winner[0] != "Current (baseline)":
                improvement_pct = ((baseline_avg - winner[1]) / baseline_avg) * 100
                print(f"\n🚀 OPTIMIZATION IMPACT:")
                print(f"   - Performance improvement: {improvement_pct:.1f}% faster than baseline")
                print(f"   - Speedup factor: {baseline_avg/winner[1]:.2f}x")
        
        return overall_rankings[0] if overall_rankings else None

def main():
    """Main benchmarking function"""
    benchmark = OptimizationBenchmark()
    
    print("🧪 String Conversion Optimization Benchmark Suite")
    print("=" * 60)
    
    # Verify correctness first
    if not benchmark.verify_correctness():
        print("\n❌ Correctness verification failed! Cannot proceed with benchmarking.")
        return False
    
    print("\n✅ All implementations produce identical results!")
    
    # Run performance benchmark
    results = benchmark.run_comprehensive_benchmark()
    
    # Generate summary
    winner = benchmark.generate_summary_report(results)
    
    print(f"\n🎉 Benchmark complete! Best overall performer: {winner[0] if winner else 'Unknown'}")
    
    return True

if __name__ == '__main__':
    main()
