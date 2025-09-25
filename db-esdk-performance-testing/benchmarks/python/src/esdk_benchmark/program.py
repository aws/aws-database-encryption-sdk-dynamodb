# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

import argparse
import sys
from pathlib import Path
from statistics import mean
from typing import List, Optional

from .benchmark import ESDKBenchmark
from .models import Report, TestResult


class CommandLineOptions:
    def __init__(self):
        self.config_path = "../../../config/test-scenarios.yaml"  # Default config file path
        self.output_path = "../../../results/raw-data/python_results.json"  # Default output path
        self.quick_test = False  # Quick test mode flag


def parse_args(args: List[str]) -> Optional[CommandLineOptions]:
    parser = argparse.ArgumentParser(
        description="ESDK Python Performance Benchmark",
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="""
Examples:
  python -m esdk_benchmark.program                    # Run full benchmark suite
  python -m esdk_benchmark.program --quick            # Run quick test
  python -m esdk_benchmark.program -c config.yaml    # Use custom config
  python -m esdk_benchmark.program -o results.json   # Custom output file
        """,
    )
    
    parser.add_argument(
        "--config", "-c",
        default="../../../config/test-scenarios.yaml",
        help="Path to test configuration file",  # Configuration file for test parameters
    )
    
    parser.add_argument(
        "--output", "-o",
        default="../../../results/raw-data/python_results.json",
        help="Path to output results file",  # JSON output file for results
    )
    
    parser.add_argument(
        "--quick", "-q",
        action="store_true",
        help="Run quick test with reduced iterations",  # Enable quick test mode
    )
    
    try:
        parsed_args = parser.parse_args(args)
        options = CommandLineOptions()
        options.config_path = parsed_args.config
        options.output_path = parsed_args.output
        options.quick_test = parsed_args.quick
        return options
    except SystemExit:
        return None


def print_summary(results: List[TestResult], output_path: str):
    print("\n=== ESDK Python Benchmark Summary ===")
    print(f"Total tests completed: {len(results)}")
    print(f"Results saved to: {output_path}")
    
    if not results:
        return
    
    # Throughput summary
    throughput_results = [r for r in results if r.test_name == "throughput"]
    if throughput_results:
        avg_ops = mean(r.ops_per_second for r in throughput_results)
        max_ops = max(r.ops_per_second for r in throughput_results)
        print(f"Throughput - Avg: {avg_ops:.2f} ops/sec, Max: {max_ops:.2f} ops/sec")
    
    # Memory summary
    memory_results = [r for r in results if r.test_name == "memory"]
    if memory_results:
        avg_memory = mean(r.peak_memory_mb for r in memory_results)
        max_memory = max(r.peak_memory_mb for r in memory_results)
        print(f"Memory - Avg: {avg_memory:.2f} MB, Max: {max_memory:.2f} MB")
    
    # Concurrency summary
    concurrent_results = [r for r in results if r.test_name == "concurrency"]
    if concurrent_results:
        avg_concurrent_ops = mean(r.ops_per_second for r in concurrent_results)
        max_concurrent_ops = max(r.ops_per_second for r in concurrent_results)
        print(f"Concurrency - Avg: {avg_concurrent_ops:.2f} ops/sec, Max: {max_concurrent_ops:.2f} ops/sec")


def main(args: Optional[List[str]] = None) -> int:
    if args is None:
        args = sys.argv[1:]
    
    options = parse_args(args)
    if options is None:
        return 1
    
    try:
        # Resolve relative paths to absolute paths
        config_path = options.config_path
        if not Path(config_path).is_absolute():
            current_dir = Path(__file__).parent
            config_path = str(current_dir / config_path)
        
        benchmark = ESDKBenchmark(config_path)
        
        if options.quick_test:
            benchmark.config.adjust_for_quick_test()  # Apply quick test settings
        
        results = benchmark.run_all_benchmarks()
        
        # Resolve output path
        output_path = options.output_path
        if not Path(output_path).is_absolute():
            current_dir = Path(__file__).parent
            output_path = str(current_dir / output_path)
        
        Report.save_results(results, output_path, benchmark.cpu_count, benchmark.total_memory_mb)
        print_summary(results, output_path)
        
        return 0
    
    except FileNotFoundError as e:
        print(f"Configuration file not found: {e}")
        return 1
    except Exception as e:
        print(f"Benchmark failed: {e}")
        import traceback
        traceback.print_exc()
        return 1


if __name__ == "__main__":
    sys.exit(main())
