#!/usr/bin/env python3
"""
Profile encrypt/decrypt operations for DDBEC v3 vs DB-ESDK v4.

This script provides detailed profiling information including:
- Function-level profiling with cProfile
- Line-level profiling with line_profiler (if installed)
- Visual call graphs
- Comparative analysis between v3 and v4
"""

import argparse
import cProfile
import json
import pstats
import sys
import time
from io import StringIO
from pathlib import Path
from typing import Dict, Any, List, Tuple

# Try to import optional profiling tools
try:
    from line_profiler import LineProfiler
    HAS_LINE_PROFILER = True
except ImportError:
    HAS_LINE_PROFILER = False
    print("Note: Install line_profiler for line-by-line profiling: pip install line_profiler")

try:
    import snakeviz
    HAS_SNAKEVIZ = True
except ImportError:
    HAS_SNAKEVIZ = False
    print("Note: Install snakeviz for interactive visualization: pip install snakeviz")

# Add parent directory to path for imports
sys.path.insert(0, str(Path(__file__).parent))

# Import test classes
from src.v3.aws_kms_key_provider_test import V3AWSKMSKeyProvider
from src.v4.aws_kms_keyring_test import V4AWSKMSKeyring
from src.test_constants import TEST_DATA_CATEGORIES


class EncryptionProfiler:
    """Profile encryption and decryption operations."""
    
    def __init__(self, output_dir: str = "profiling_results"):
        """Initialize the profiler."""
        self.output_dir = Path(output_dir)
        self.output_dir.mkdir(exist_ok=True)
        
        # Initialize test instances
        self.v3_provider = V3AWSKMSKeyProvider()
        self.v4_provider = V4AWSKMSKeyring()
        
        # Store profiling results
        self.results = {
            "v3": {"encrypt": {}, "decrypt": {}},
            "v4": {"encrypt": {}, "decrypt": {}}
        }
    
    def profile_operation(self, version: str, operation: str, data_type: str, 
                         iterations: int = 100) -> Tuple[cProfile.Profile, float]:
        """Profile a specific operation."""
        provider = self.v3_provider if version == "v3" else self.v4_provider
        
        # Get test item
        item = provider.get_test_item(data_type)
        
        # Pre-encrypt item for decrypt operations
        if operation == "decrypt":
            encrypted_item = provider.encrypt_item(item)
        
        # Create profiler
        profiler = cProfile.Profile()
        
        # Define the operation to profile
        if operation == "encrypt":
            def target_operation():
                for _ in range(iterations):
                    provider.encrypt_item(item)
        else:  # decrypt
            def target_operation():
                for _ in range(iterations):
                    provider.decrypt_item(encrypted_item)
        
        # Profile the operation
        start_time = time.time()
        profiler.enable()
        target_operation()
        profiler.disable()
        total_time = time.time() - start_time
        
        return profiler, total_time
    
    def analyze_profile(self, profiler: cProfile.Profile, version: str, 
                       operation: str, data_type: str) -> Dict[str, Any]:
        """Analyze profiling results and extract key metrics."""
        # Create stats object
        stats = pstats.Stats(profiler)
        
        # Get top functions by cumulative time
        stats.sort_stats('cumulative')
        
        # Capture stats output
        output = StringIO()
        stats.stream = output
        stats.print_stats(20)  # Top 20 functions
        
        # Extract key function timings
        stats_dict = stats.stats
        key_functions = []
        
        # Identify key encryption/decryption functions
        keywords = ['encrypt', 'kms', 'decrypt', 'aes', 'gcm', 'hmac', 'sign', 'wrap',
                   'unwrap', 'derive', 'material', 'crypto']
        
        for func_key, func_stats in stats_dict.items():
            filename, line_num, func_name = func_key
            if any(keyword in func_name.lower() for keyword in keywords):
                # func_stats is (ncalls, tottime, cumtime, callers)
                key_functions.append({
                    'function': func_name,
                    'file': Path(filename).name,
                    'line': line_num,
                    'calls': func_stats[0],
                    'total_time': func_stats[1],
                    'cumulative_time': func_stats[2],
                    'avg_time_per_call': func_stats[2] / func_stats[0] if func_stats[0] > 0 else 0
                })
        
        # Sort by cumulative time
        key_functions.sort(key=lambda x: x['cumulative_time'], reverse=True)
        
        return {
            'top_functions': key_functions[:10],
            'full_output': output.getvalue(),
            'total_calls': sum(v[0] for v in stats_dict.values()),
            'total_time': stats.total_tt
        }
    
    def save_profile_data(self, profiler: cProfile.Profile, filename: str):
        """Save profile data for later analysis."""
        profile_path = self.output_dir / f"{filename}.prof"
        profiler.dump_stats(str(profile_path))
        return profile_path
    
    def generate_callgraph(self, profile_path: Path, output_name: str):
        """Generate a visual call graph from profile data."""
        try:
            import subprocess
            
            # Generate dot file
            dot_file = self.output_dir / f"{output_name}.dot"
            png_file = self.output_dir / f"{output_name}.png"
            
            # Use gprof2dot if available
            try:
                cmd = [
                    "gprof2dot", "-f", "pstats", 
                    str(profile_path), "-o", str(dot_file)
                ]
                subprocess.run(cmd, check=True, capture_output=True)
                
                # Convert to PNG
                cmd = ["dot", "-Tpng", str(dot_file), "-o", str(png_file)]
                subprocess.run(cmd, check=True, capture_output=True)
                
                print(f"Generated call graph: {png_file}")
                return png_file
            except (subprocess.CalledProcessError, FileNotFoundError):
                print("Note: Install gprof2dot and graphviz for call graphs:")
                print("  pip install gprof2dot")
                print("  brew install graphviz (on macOS)")
                return None
                
        except Exception as e:
            print(f"Could not generate call graph: {e}")
            return None
    
    def profile_with_line_profiler(self, version: str, operation: str, 
                                 data_type: str, iterations: int = 10):
        """Profile with line-by-line analysis."""
        if not HAS_LINE_PROFILER:
            return None
            
        provider = self.v3_provider if version == "v3" else self.v4_provider
        item = provider.get_test_item(data_type)
        
        # Create line profiler
        lp = LineProfiler()
        
        # Add functions to profile
        if operation == "encrypt":
            lp.add_function(provider.encrypt_item)
            if version == "v3":
                from dynamodb_encryption_sdk.encrypted.item import encrypt_dynamodb_item
                lp.add_function(encrypt_dynamodb_item)
            else:
                lp.add_function(provider.item_encryptor.encrypt_dynamodb_item)
        else:  # decrypt
            encrypted_item = provider.encrypt_item(item)
            lp.add_function(provider.decrypt_item)
            if version == "v3":
                from dynamodb_encryption_sdk.encrypted.item import decrypt_dynamodb_item
                lp.add_function(decrypt_dynamodb_item)
            else:
                lp.add_function(provider.item_encryptor.decrypt_dynamodb_item)
        
        # Profile the operation
        if operation == "encrypt":
            wrapped = lp(lambda: [provider.encrypt_item(item) for _ in range(iterations)])
        else:
            wrapped = lp(lambda: [provider.decrypt_item(encrypted_item) for _ in range(iterations)])
        
        wrapped()
        
        # Capture output
        output = StringIO()
        lp.print_stats(stream=output)
        
        return output.getvalue()
    
    def compare_versions(self, operation: str, data_type: str):
        """Compare v3 and v4 performance for a specific operation."""
        comparison = {
            "operation": operation,
            "data_type": data_type,
            "versions": {}
        }
        
        for version in ["v3", "v4"]:
            analysis = self.results[version][operation].get(data_type, {})
            if analysis:
                comparison["versions"][version] = {
                    "total_time": analysis.get("total_time", 0),
                    "top_functions": analysis.get("analysis", {}).get("top_functions", [])[:5]
                }
        
        # Calculate performance difference
        if all(v in comparison["versions"] for v in ["v3", "v4"]):
            v3_time = comparison["versions"]["v3"]["total_time"]
            v4_time = comparison["versions"]["v4"]["total_time"]
            if v3_time > 0:
                comparison["performance_diff"] = {
                    "absolute_ms": (v4_time - v3_time) * 1000,
                    "relative_percent": ((v4_time / v3_time) - 1) * 100
                }
        
        return comparison
    
    def run_profiling(self, versions: List[str] = None, operations: List[str] = None,
                     data_types: List[str] = None, iterations: int = 100,
                     line_profile: bool = False):
        """Run complete profiling suite."""
        versions = versions or ["v3", "v4"]
        operations = operations or ["encrypt", "decrypt"]
        data_types = data_types or TEST_DATA_CATEGORIES
        
        print(f"\nRunning profiling with {iterations} iterations per test...")
        print("=" * 80)
        
        for version in versions:
            for operation in operations:
                for data_type in data_types:
                    print(f"\nProfiling {version} {operation} with {data_type} data...")
                    
                    # Function-level profiling
                    profiler, total_time = self.profile_operation(
                        version, operation, data_type, iterations
                    )
                    
                    # Analyze results
                    analysis = self.analyze_profile(profiler, version, operation, data_type)
                    
                    # Save profile data
                    profile_name = f"{version}_kms_{operation}_{data_type}"
                    profile_path = self.save_profile_data(profiler, profile_name)
                    
                    # Generate call graph
                    callgraph_path = self.generate_callgraph(profile_path, profile_name)
                    
                    # Line profiling (if requested)
                    line_profile_output = None
                    if line_profile and HAS_LINE_PROFILER:
                        print(f"  Running line profiler...")
                        line_profile_output = self.profile_with_line_profiler(
                            version, operation, data_type, min(iterations, 10)
                        )
                    
                    # Store results
                    self.results[version][operation][data_type] = {
                        "total_time": total_time,
                        "avg_time_per_iteration": total_time / iterations,
                        "analysis": analysis,
                        "profile_path": str(profile_path),
                        "callgraph_path": str(callgraph_path) if callgraph_path else None,
                        "line_profile": line_profile_output
                    }
                    
                    # Print summary
                    print(f"  Total time: {total_time:.3f}s")
                    print(f"  Avg per iteration: {(total_time / iterations) * 1000:.3f}ms")
                    print(f"  Top 3 time-consuming functions:")
                    for i, func in enumerate(analysis['top_functions'][:3], 1):
                        print(f"    {i}. {func['function']} - {func['cumulative_time']:.3f}s "
                              f"({func['calls']} calls)")
        
        # Generate comparison report
        self.generate_report()
    
    def generate_report(self):
        """Generate comprehensive profiling report."""
        report_path = self.output_dir / "profiling_report_kms.txt"
        
        with open(report_path, "w") as f:
            f.write("ENCRYPTION/DECRYPTION PROFILING REPORT\n")
            f.write("=" * 80 + "\n\n")
            
            # Summary comparison
            f.write("PERFORMANCE COMPARISON\n")
            f.write("-" * 80 + "\n\n")
            
            for operation in ["encrypt", "decrypt"]:
                for data_type in TEST_DATA_CATEGORIES:
                    comparison = self.compare_versions(operation, data_type)
                    
                    f.write(f"{operation.upper()} - {data_type}:\n")
                    
                    if "v3" in comparison["versions"] and "v4" in comparison["versions"]:
                        v3_time = comparison["versions"]["v3"]["total_time"]
                        v4_time = comparison["versions"]["v4"]["total_time"]
                        
                        f.write(f"  V3: {v3_time:.3f}s\n")
                        f.write(f"  V4: {v4_time:.3f}s\n")
                        
                        if "performance_diff" in comparison:
                            diff = comparison["performance_diff"]
                            f.write(f"  Difference: {diff['absolute_ms']:.1f}ms "
                                   f"({diff['relative_percent']:+.1f}%)\n")
                    f.write("\n")
            
            # Detailed function analysis
            f.write("\nDETAILED FUNCTION ANALYSIS\n")
            f.write("=" * 80 + "\n\n")
            
            for version in ["v3", "v4"]:
                for operation in ["encrypt", "decrypt"]:
                    for data_type, result in self.results[version][operation].items():
                        f.write(f"\n{version.upper()} {operation.upper()} - {data_type}\n")
                        f.write("-" * 40 + "\n")
                        
                        if result.get("analysis"):
                            f.write("Top 5 Functions by Time:\n")
                            for i, func in enumerate(result["analysis"]["top_functions"][:5], 1):
                                f.write(f"{i}. {func['function']} ({func['file']}:{func['line']})\n")
                                f.write(f"   Calls: {func['calls']}, "
                                       f"Total: {func['cumulative_time']:.3f}s, "
                                       f"Avg: {func['avg_time_per_call']*1000:.3f}ms\n")
                        
                        # Add line profile if available
                        if result.get("line_profile"):
                            f.write("\nLine-by-Line Profile:\n")
                            f.write(result["line_profile"])
                            f.write("\n")
        
        # Save JSON results
        json_path = self.output_dir / "profiling_results_kms.json"
        with open(json_path, "w") as f:
            json.dump(self.results, f, indent=2, default=str)
        
        print(f"\nReports saved to:")
        print(f"  - {report_path}")
        print(f"  - {json_path}")
        
        # Interactive visualization hint
        if HAS_SNAKEVIZ:
            print("\nTo view interactive visualizations, run:")
            for prof_file in self.output_dir.glob("*.prof"):
                print(f"  snakeviz {prof_file}")


def main():
    """Main entry point."""
    parser = argparse.ArgumentParser(
        description="Profile encryption/decryption operations for DDBEC v3 vs DB-ESDK v4"
    )
    parser.add_argument(
        "--versions",
        nargs="+",
        choices=["v3", "v4"],
        default=["v3", "v4"],
        help="Versions to profile (default: both)"
    )
    parser.add_argument(
        "--operations",
        nargs="+",
        choices=["encrypt", "decrypt"],
        default=["encrypt", "decrypt"],
        help="Operations to profile (default: both)"
    )
    parser.add_argument(
        "--data-types",
        nargs="+",
        choices=TEST_DATA_CATEGORIES,
        default=TEST_DATA_CATEGORIES,
        help="Data types to test (default: all)"
    )
    parser.add_argument(
        "--iterations",
        type=int,
        default=100,
        help="Number of iterations per test (default: 100)"
    )
    parser.add_argument(
        "--line-profile",
        action="store_true",
        help="Enable line-by-line profiling (requires line_profiler)"
    )
    parser.add_argument(
        "--output-dir",
        default="profiling_results",
        help="Output directory for results (default: profiling_results)"
    )
    
    args = parser.parse_args()
    
    # Create profiler
    profiler = EncryptionProfiler(args.output_dir)
    
    # Run profiling
    profiler.run_profiling(
        versions=args.versions,
        operations=args.operations,
        data_types=args.data_types,
        iterations=args.iterations,
        line_profile=args.line_profile
    )


if __name__ == "__main__":
    main()
