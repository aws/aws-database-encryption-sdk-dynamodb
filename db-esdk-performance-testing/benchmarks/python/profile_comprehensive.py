#!/usr/bin/env python3
"""
Comprehensive profiling suite for DynamoDB encryption with configurable options.

This script provides flexible profiling with configurable:
- Test Base: item (direct) vs client (EncryptedClient)
- Provider: aes, kms, hierarchy
- Data Type: single, nested, flat
- Operation: encrypt, decrypt
- Version: v3, v4
"""

import argparse
import cProfile
import json
import pstats
import sys
import time
from io import StringIO
from pathlib import Path
from typing import Dict, Any, List, Tuple, Optional, Type
import importlib

# Try to import optional profiling tools
try:
    from line_profiler import LineProfiler
    HAS_LINE_PROFILER = True
except ImportError:
    HAS_LINE_PROFILER = False

try:
    import snakeviz
    HAS_SNAKEVIZ = True
except ImportError:
    HAS_SNAKEVIZ = False

# Add parent directory to path for imports
sys.path.insert(0, str(Path(__file__).parent))

from src.test_constants import TEST_DATA_CATEGORIES
from src.providers.v3_providers import V3AESProvider, V3KMSProvider, V3HierarchyProvider
from src.providers.v4_providers import V4AESKeyring, V4KMSKeyring, V4HierarchyKeyring
from src.test_bases.item_test_base import V3ItemTestBase, V4ItemTestBase
from src.test_bases.client_test_base import V3ClientTestBase, V4ClientTestBase


class ProfilingConfiguration:
    """Configuration class for profiling parameters."""
    
    def __init__(self, test_base: str, provider: str, data_type: str, 
                 operation: str, version: str = "v4"):
        """Initialize profiling configuration."""
        self.test_base = test_base  # "item" or "client"
        self.provider = provider    # "aes", "kms", "hierarchy"
        self.data_type = data_type  # "single", "nested", "flat"
        self.operation = operation  # "encrypt", "decrypt"
        self.version = version      # "v3", "v4"
        
        # Validate configuration
        self._validate()
        
        # Map data types to constants
        self.data_type_map = {
            "single": "single_attribute",
            "nested": "nested_attributes", 
            "flat": "flat_attributes"
        }
        
        self.actual_data_type = self.data_type_map[self.data_type]
    
    def _validate(self):
        """Validate configuration parameters."""
        valid_test_bases = ["item", "client"]
        valid_providers = ["aes", "kms", "hierarchy"]
        valid_data_types = ["single", "nested", "flat"]
        valid_operations = ["encrypt", "decrypt"]
        valid_versions = ["v3", "v4"]
        
        if self.test_base not in valid_test_bases:
            raise ValueError(f"Invalid test_base: {self.test_base}. Must be one of {valid_test_bases}")
        if self.provider not in valid_providers:
            raise ValueError(f"Invalid provider: {self.provider}. Must be one of {valid_providers}")
        if self.data_type not in valid_data_types:
            raise ValueError(f"Invalid data_type: {self.data_type}. Must be one of {valid_data_types}")
        if self.operation not in valid_operations:
            raise ValueError(f"Invalid operation: {self.operation}. Must be one of {valid_operations}")
        if self.version not in valid_versions:
            raise ValueError(f"Invalid version: {self.version}. Must be one of {valid_versions}")
    
    def get_test_class_name(self) -> str:
        """Get the test class name based on configuration."""
        # Map provider names to test class names
        provider_map = {
            "v3": {
                "aes": "V3AESKeyProvider",
                "kms": "V3AWSKMSKeyProvider", 
                "hierarchy": "V3MostRecentKeyProvider"
            },
            "v4": {
                "aes": "V4RawAESKeyring",
                "kms": "V4AWSKMSKeyring",
                "hierarchy": "V4HierarchyKeyring"
            }
        }
        
        return provider_map[self.version][self.provider]
    
    def get_module_name(self) -> str:
        """Get the module name to import."""
        # Map provider names to module names
        module_map = {
            "v3": {
                "aes": "src.v3.aes_key_provider_test",
                "kms": "src.v3.aws_kms_key_provider_test",
                "hierarchy": "src.v3.most_recent_key_provider_test"
            },
            "v4": {
                "aes": "src.v4.raw_aes_keyring_test",
                "kms": "src.v4.aws_kms_keyring_test", 
                "hierarchy": "src.v4.hierarchy_keyring_test"
            }
        }
        
        return module_map[self.version][self.provider]
    
    def get_identifier(self) -> str:
        """Get a unique identifier for this configuration."""
        return f"{self.version}_{self.test_base}_{self.provider}_{self.data_type}_{self.operation}"
    
    def __str__(self) -> str:
        """String representation of configuration."""
        return (f"Config(version={self.version}, test_base={self.test_base}, "
                f"provider={self.provider}, data_type={self.data_type}, "
                f"operation={self.operation})")


class ComprehensiveProfiler:
    """Comprehensive profiler for all configuration combinations."""
    
    def __init__(self, output_dir: str = "comprehensive_profiling_results"):
        """Initialize the comprehensive profiler."""
        self.output_dir = Path(output_dir)
        self.output_dir.mkdir(exist_ok=True)
        
        # Store profiling results organized by configuration
        self.results = {}
        
        # Cache for test instances to avoid recreating them
        self._test_instance_cache = {}
    
    def _get_test_instance(self, config: ProfilingConfiguration):
        """Get or create a test instance for the given configuration."""
        cache_key = f"{config.version}_{config.provider}_{config.test_base}"
        
        if cache_key not in self._test_instance_cache:
            try:
                # Create the appropriate provider/keyring instance
                if config.version == "v3":
                    if config.provider == "aes":
                        provider = V3AESProvider()
                    elif config.provider == "kms":
                        provider = V3KMSProvider()
                    elif config.provider == "hierarchy":
                        provider = V3HierarchyProvider()
                    else:
                        raise ValueError(f"Unknown v3 provider: {config.provider}")
                    
                    # Create the appropriate test base
                    if config.test_base == "item":
                        instance = V3ItemTestBase(provider)
                    elif config.test_base == "client":
                        instance = V3ClientTestBase(provider)
                    else:
                        raise ValueError(f"Unknown test base: {config.test_base}")
                
                elif config.version == "v4":
                    if config.provider == "aes":
                        keyring = V4AESKeyring()
                    elif config.provider == "kms":
                        keyring = V4KMSKeyring()
                    elif config.provider == "hierarchy":
                        keyring = V4HierarchyKeyring()
                    else:
                        raise ValueError(f"Unknown v4 provider: {config.provider}")
                    
                    # Create the appropriate test base
                    if config.test_base == "item":
                        instance = V4ItemTestBase(keyring)
                    elif config.test_base == "client":
                        instance = V4ClientTestBase(keyring)
                    else:
                        raise ValueError(f"Unknown test base: {config.test_base}")
                
                else:
                    raise ValueError(f"Unknown version: {config.version}")
                
                self._test_instance_cache[cache_key] = instance
                
            except Exception as e:
                raise RuntimeError(f"Failed to create test instance for {config}: {e}")
        
        return self._test_instance_cache[cache_key]
    
    def profile_configuration(self, config: ProfilingConfiguration, 
                            iterations: int = 100) -> Tuple[cProfile.Profile, float, Dict[str, Any]]:
        """Profile a specific configuration."""
        print(f"Profiling: {config}")
        
        # Get test instance
        test_instance = self._get_test_instance(config)
        
        # Get test item
        test_item = test_instance.get_test_item(config.actual_data_type)
        
        # Pre-encrypt item for decrypt operations
        encrypted_item = None
        if config.operation == "decrypt":
            encrypted_item = test_instance.encrypt_item(test_item)
        
        # Create profiler
        profiler = cProfile.Profile()
        # Define the operation to profile
        if config.operation == "encrypt":
            def target_operation():
                for _ in range(iterations):
                    test_instance.encrypt_item(test_item)
        else:  # decrypt
            def target_operation():
                for _ in range(iterations):
                    test_instance.decrypt_item(encrypted_item)

        # Profile the operation with explicit profiler management
        try:
            start_time = time.time()
            profiler.enable()
            target_operation()
        finally:
            # Always disable profiler even if an error occurs
            profiler.disable()
            total_time = time.time() - start_time

        # # Decrypt if encrypt operation is used for verification
        # if config.operation == "encrypt":
        #     test_instance.decrypt_item(encrypted_item)

        # # Verify that encrypted attributes were properly decrypted (back to original)
        # for key, original_value in test_item.items():
        #     assert key in decrypted_item, f"Missing attribute {key} in decrypted item"
        #     decrypted_value = decrypted_item[key]
        #     assert (
        #             decrypted_value == original_value
        #     ), f"Attribute {key} not properly decrypted: {decrypted_value} != {original_value}"

        # Calculate additional metrics
        original_size = test_instance.calculate_item_size(test_item)
        encrypted_size = test_instance.calculate_item_size(encrypted_item) if encrypted_item else original_size
        
        metrics = {
            "total_time": total_time,
            "avg_time_per_iteration": total_time / iterations,
            "iterations": iterations,
            "original_size_bytes": original_size,
            "encrypted_size_bytes": encrypted_size,
            "size_increase_ratio": encrypted_size / original_size if original_size > 0 else 1.0,
            "throughput_ops_per_sec": iterations / total_time if total_time > 0 else 0
        }
        
        return profiler, total_time, metrics
    
    def analyze_profile(self, profiler: cProfile.Profile, config: ProfilingConfiguration) -> Dict[str, Any]:
        """Analyze profiling results and extract key metrics."""
        stats = pstats.Stats(profiler)
        stats.sort_stats('cumulative')
        
        # Capture stats output
        output = StringIO()
        stats.stream = output
        stats.print_stats(20)
        
        # Extract key function timings
        stats_dict = stats.stats
        key_functions = []
        
        # Keywords to identify important functions
        keywords = ['encrypt', 'decrypt', 'aes', 'gcm', 'hmac', 'sign', 'wrap', 
                   'unwrap', 'derive', 'material', 'crypto', 'kms', 'hierarchy']
        
        for func_key, func_stats in stats_dict.items():
            filename, line_num, func_name = func_key
            if any(keyword in func_name.lower() for keyword in keywords):
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
            'total_profile_time': stats.total_tt
        }
    
    def save_profile_data(self, profiler: cProfile.Profile, config: ProfilingConfiguration) -> Path:
        """Save profile data for later analysis."""
        filename = f"{config.get_identifier()}.prof"
        profile_path = self.output_dir / filename
        profiler.dump_stats(str(profile_path))
        return profile_path
    
    def generate_callgraph(self, profile_path: Path, config: ProfilingConfiguration) -> Optional[Path]:
        """Generate a visual call graph from profile data."""
        try:
            import subprocess
            
            output_name = config.get_identifier()
            dot_file = self.output_dir / f"{output_name}.dot"
            png_file = self.output_dir / f"{output_name}.png"
            
            # Use gprof2dot if available
            try:
                cmd = ["gprof2dot", "-f", "pstats", str(profile_path), "-o", str(dot_file)]
                subprocess.run(cmd, check=True, capture_output=True)
                
                # Convert to PNG
                cmd = ["dot", "-Tpng", str(dot_file), "-o", str(png_file)]
                subprocess.run(cmd, check=True, capture_output=True)
                
                return png_file
            except (subprocess.CalledProcessError, FileNotFoundError):
                return None
                
        except Exception:
            return None
    
    def profile_with_line_profiler(self, config: ProfilingConfiguration, 
                                 iterations: int = 10) -> Optional[str]:
        """Profile with line-by-line analysis."""
        if not HAS_LINE_PROFILER:
            return None
            
        test_instance = self._get_test_instance(config)
        test_item = test_instance.get_test_item(config.actual_data_type)
        
        # Create line profiler
        lp = LineProfiler()
        
        # Add functions to profile
        if config.operation == "encrypt":
            lp.add_function(test_instance.encrypt_item)
        else:
            encrypted_item = test_instance.encrypt_item(test_item)
            lp.add_function(test_instance.decrypt_item)
        
        # Profile the operation
        if config.operation == "encrypt":
            wrapped = lp(lambda: [test_instance.encrypt_item(test_item) for _ in range(iterations)])
        else:
            encrypted_item = test_instance.encrypt_item(test_item)
            wrapped = lp(lambda: [test_instance.decrypt_item(encrypted_item) for _ in range(iterations)])
        
        wrapped()
        
        # Capture output
        output = StringIO()
        lp.print_stats(stream=output)
        
        return output.getvalue()
    
    def run_comprehensive_profiling(self, configurations: List[ProfilingConfiguration],
                                  iterations: int = 100, line_profile: bool = False):
        """Run comprehensive profiling for all configurations."""
        print(f"\nRunning comprehensive profiling with {iterations} iterations per test...")
        print("=" * 100)
        
        for i, config in enumerate(configurations, 1):
            print(f"\n[{i}/{len(configurations)}] {config}")
            print("-" * 80)
            
            try:
                # Function-level profiling
                profiler, total_time, metrics = self.profile_configuration(config, iterations)
                
                # Analyze results
                analysis = self.analyze_profile(profiler, config)
                
                # Save profile data
                profile_path = self.save_profile_data(profiler, config)
                
                # Generate call graph
                callgraph_path = self.generate_callgraph(profile_path, config)
                
                # Line profiling (if requested)
                line_profile_output = None
                if line_profile and HAS_LINE_PROFILER:
                    print("  Running line profiler...")
                    line_profile_output = self.profile_with_line_profiler(
                        config, min(iterations, 10)
                    )
                
                # Store results
                config_id = config.get_identifier()
                self.results[config_id] = {
                    "config": {
                        "version": config.version,
                        "test_base": config.test_base,
                        "provider": config.provider,
                        "data_type": config.data_type,
                        "operation": config.operation
                    },
                    "metrics": metrics,
                    "analysis": analysis,
                    "profile_path": str(profile_path),
                    "callgraph_path": str(callgraph_path) if callgraph_path else None,
                    "line_profile": line_profile_output
                }
                
                # Print summary
                print(f"  ✓ Total time: {total_time:.3f}s")
                print(f"  ✓ Avg per iteration: {metrics['avg_time_per_iteration']*1000:.3f}ms")
                print(f"  ✓ Throughput: {metrics['throughput_ops_per_sec']:.1f} ops/sec")
                print(f"  ✓ Size increase: {metrics['size_increase_ratio']:.2f}x")
                
                if analysis['top_functions']:
                    print(f"  ✓ Top 3 time-consuming functions:")
                    for j, func in enumerate(analysis['top_functions'][:3], 1):
                        print(f"    {j}. {func['function']} - {func['cumulative_time']:.3f}s "
                              f"({func['calls']} calls)")
                
            except Exception as e:
                print(f"  ✗ Failed: {e}")
                self.results[config.get_identifier()] = {
                    "config": config.__dict__,
                    "error": str(e)
                }
        
        # Generate comprehensive report
        self.generate_comprehensive_report()
    
    def generate_comprehensive_report(self):
        """Generate comprehensive profiling report organized by dimensions."""
        report_path = self.output_dir / "comprehensive_profiling_report.txt"
        
        with open(report_path, "w") as f:
            f.write("COMPREHENSIVE PROFILING REPORT\n")
            f.write("=" * 100 + "\n\n")
            
            # V3 vs V4 Comparison Section - New Primary Focus
            f.write("V3 vs V4 PERFORMANCE COMPARISON\n")
            f.write("=" * 100 + "\n\n")
            
            # Group results by common configuration (excluding version)
            common_configs = {}
            for config_id, result in self.results.items():
                if "error" in result or "metrics" not in result:
                    continue
                    
                config = result["config"]
                common_key = f"{config['test_base']}_{config['provider']}_{config['data_type']}_{config['operation']}"
                
                if common_key not in common_configs:
                    common_configs[common_key] = {}
                common_configs[common_key][config['version']] = result
            
            # Generate V3 vs V4 comparisons
            comparisons_found = False
            for common_key, versions in common_configs.items():
                if 'v3' in versions and 'v4' in versions:
                    comparisons_found = True
                    
                    v3_result = versions['v3']
                    v4_result = versions['v4']
                    
                    v3_time = v3_result['metrics']['avg_time_per_iteration'] * 1000  # ms
                    v4_time = v4_result['metrics']['avg_time_per_iteration'] * 1000  # ms
                    
                    # Calculate performance difference - always relative to V4
                    if v3_time > 0:
                        ratio = v4_time / v3_time
                        if v4_time < v3_time:
                            # V4 is faster - calculate improvement percentage
                            improvement = ((v3_time - v4_time) / v3_time) * 100
                            status = f"V4 FASTER by {improvement:.1f}% ({ratio:.1f}x)"
                        else:
                            # V4 is slower - calculate how much slower as percentage and ratio
                            slowdown = ((v4_time - v3_time) / v3_time) * 100
                            status = f"V4 SLOWER by {slowdown:.1f}% ({ratio:.1f}x slower)"
                    else:
                        status = "Cannot compare (zero time)"
                    
                    # Parse common key for readable output
                    test_base, provider, data_type, operation = common_key.split('_')
                    
                    f.write(f"{test_base.upper()}-{provider.upper()}-{data_type.upper()}-{operation.upper()}:\n")
                    f.write(f"  V3 Time: {v3_time:.3f}ms  |  V4 Time: {v4_time:.3f}ms  |  {status}\n")
                    f.write(f"  V3 Throughput: {v3_result['metrics']['throughput_ops_per_sec']:.1f} ops/sec\n")
                    f.write(f"  V4 Throughput: {v4_result['metrics']['throughput_ops_per_sec']:.1f} ops/sec\n")
                    f.write("\n")
            
            if not comparisons_found:
                f.write("No V3 vs V4 comparisons available (need both versions profiled for same configurations)\n\n")
            
            # Overall V3 vs V4 Summary
            if comparisons_found:
                f.write("V3 vs V4 SUMMARY\n")
                f.write("-" * 50 + "\n")
                
                v4_wins = 0
                v3_wins = 0
                total_comparisons = 0
                
                for common_key, versions in common_configs.items():
                    if 'v3' in versions and 'v4' in versions:
                        total_comparisons += 1
                        v3_time = versions['v3']['metrics']['avg_time_per_iteration']
                        v4_time = versions['v4']['metrics']['avg_time_per_iteration']
                        
                        if v4_time < v3_time:
                            v4_wins += 1
                        else:
                            v3_wins += 1
                
                f.write(f"Total Comparisons: {total_comparisons}\n")
                f.write(f"V4 Faster: {v4_wins} configurations ({v4_wins/total_comparisons*100:.1f}%)\n")
                f.write(f"V3 Faster: {v3_wins} configurations ({v3_wins/total_comparisons*100:.1f}%)\n")
                f.write("\n")
            
            # Summary by test base
            f.write("PERFORMANCE BY TEST BASE\n")
            f.write("-" * 100 + "\n\n")
            
            for test_base in ["item", "client"]:
                f.write(f"{test_base.upper()} Test Base:\n")
                base_results = {k: v for k, v in self.results.items() 
                              if v.get("config", {}).get("test_base") == test_base and "metrics" in v}
                
                if base_results:
                    avg_time = sum(r["metrics"]["avg_time_per_iteration"] 
                                 for r in base_results.values()) / len(base_results)
                    f.write(f"  Average time per operation: {avg_time*1000:.3f}ms\n")
                    f.write(f"  Number of configurations: {len(base_results)}\n")
                f.write("\n")
            
            # Summary by provider
            f.write("PERFORMANCE BY PROVIDER\n")
            f.write("-" * 100 + "\n\n")
            
            for provider in ["aes", "kms", "hierarchy"]:
                f.write(f"{provider.upper()} Provider:\n")
                provider_results = {k: v for k, v in self.results.items() 
                                  if v.get("config", {}).get("provider") == provider and "metrics" in v}
                
                if provider_results:
                    encrypt_times = [r["metrics"]["avg_time_per_iteration"] 
                                   for r in provider_results.values() 
                                   if r["config"]["operation"] == "encrypt"]
                    decrypt_times = [r["metrics"]["avg_time_per_iteration"] 
                                   for r in provider_results.values() 
                                   if r["config"]["operation"] == "decrypt"]
                    
                    if encrypt_times:
                        f.write(f"  Average encrypt time: {sum(encrypt_times)/len(encrypt_times)*1000:.3f}ms\n")
                    if decrypt_times:
                        f.write(f"  Average decrypt time: {sum(decrypt_times)/len(decrypt_times)*1000:.3f}ms\n")
                f.write("\n")
            
            # Summary by data type
            f.write("PERFORMANCE BY DATA TYPE\n")
            f.write("-" * 100 + "\n\n")
            
            for data_type in ["single", "nested", "flat"]:
                f.write(f"{data_type.upper()} Data Type:\n")
                data_results = {k: v for k, v in self.results.items() 
                              if v.get("config", {}).get("data_type") == data_type and "metrics" in v}
                
                if data_results:
                    avg_size = sum(r["metrics"]["original_size_bytes"] 
                                 for r in data_results.values()) / len(data_results)
                    avg_time = sum(r["metrics"]["avg_time_per_iteration"] 
                                 for r in data_results.values()) / len(data_results)
                    f.write(f"  Average data size: {avg_size:.0f} bytes\n")
                    f.write(f"  Average processing time: {avg_time*1000:.3f}ms\n")
                f.write("\n")
            
            # Detailed results
            f.write("DETAILED RESULTS\n")
            f.write("=" * 100 + "\n\n")
            
            for config_id, result in self.results.items():
                if "error" in result:
                    f.write(f"{config_id}: ERROR - {result['error']}\n\n")
                    continue
                
                config = result["config"]
                metrics = result["metrics"]
                analysis = result["analysis"]
                
                f.write(f"{config_id}\n")
                f.write("-" * len(config_id) + "\n")
                f.write(f"Configuration: {config}\n")
                f.write(f"Time per operation: {metrics['avg_time_per_iteration']*1000:.3f}ms\n")
                f.write(f"Throughput: {metrics['throughput_ops_per_sec']:.1f} ops/sec\n")
                f.write(f"Data size: {metrics['original_size_bytes']} bytes\n")
                f.write(f"Size increase: {metrics['size_increase_ratio']:.2f}x\n")
                
                if analysis.get("top_functions"):
                    f.write("Top 5 Functions:\n")
                    for i, func in enumerate(analysis["top_functions"][:5], 1):
                        f.write(f"  {i}. {func['function']} - {func['cumulative_time']:.3f}s\n")
                f.write("\n")
        
        # Save JSON results
        json_path = self.output_dir / "comprehensive_profiling_results.json"
        with open(json_path, "w") as f:
            json.dump(self.results, f, indent=2, default=str)
        
        print(f"\nComprehensive reports saved to:")
        print(f"  - {report_path}")
        print(f"  - {json_path}")
        
        # Interactive visualization hint
        if HAS_SNAKEVIZ:
            print("\nTo view interactive visualizations, run:")
            print(f"  cd {self.output_dir}")
            print("  snakeviz *.prof")


def generate_configurations(test_bases: List[str] = None,
                          providers: List[str] = None,
                          data_types: List[str] = None,
                          operations: List[str] = None,
                          versions: List[str] = None) -> List[ProfilingConfiguration]:
    """Generate all combinations of profiling configurations."""
    test_bases = test_bases or ["item", "client"]
    providers = providers or ["aes", "kms", "hierarchy"]
    data_types = data_types or ["single", "nested", "flat"]
    operations = operations or ["encrypt", "decrypt"]
    versions = versions or ["v4"]  # Default to v4 only
    
    configurations = []
    
    for version in versions:
        for test_base in test_bases:
            for provider in providers:
                for data_type in data_types:
                    for operation in operations:
                        try:
                            config = ProfilingConfiguration(
                                test_base=test_base,
                                provider=provider,
                                data_type=data_type,
                                operation=operation,
                                version=version
                            )
                            configurations.append(config)
                        except ValueError as e:
                            print(f"Skipping invalid configuration: {e}")
    
    return configurations


def main():
    """Main entry point."""
    parser = argparse.ArgumentParser(
        description="Comprehensive profiling suite for DynamoDB encryption",
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="""
Examples:
  # Profile all combinations (default)
  python profile_comprehensive.py

  # Profile only AES with item-based tests
  python profile_comprehensive.py --test-bases item --providers aes

  # Profile encrypt operations only
  python profile_comprehensive.py --operations encrypt

  # Profile specific data types
  python profile_comprehensive.py --data-types single flat

  # Include v3 and v4 comparison
  python profile_comprehensive.py --versions v3 v4 --providers aes

  # Profile with line profiling
  python profile_comprehensive.py --line-profile --providers aes --data-types single
        """
    )
    
    parser.add_argument(
        "--test-bases",
        nargs="+",
        choices=["item", "client"],
        default=["item", "client"],
        help="Test bases to profile (default: both)"
    )
    parser.add_argument(
        "--providers",
        nargs="+",
        choices=["aes", "kms", "hierarchy"],
        default=["aes", "kms", "hierarchy"],
        help="Providers to profile (default: all)"
    )
    parser.add_argument(
        "--data-types",
        nargs="+",
        choices=["single", "nested", "flat"],
        default=["single", "nested", "flat"],
        help="Data types to test (default: all)"
    )
    parser.add_argument(
        "--operations",
        nargs="+",
        choices=["encrypt", "decrypt"],
        default=["encrypt", "decrypt"],
        help="Operations to profile (default: both)"
    )
    parser.add_argument(
        "--versions",
        nargs="+",
        choices=["v3", "v4"],
        default=["v4"],
        help="Versions to profile (default: v4 only)"
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
        default="comprehensive_profiling_results",
        help="Output directory for results (default: comprehensive_profiling_results)"
    )
    
    args = parser.parse_args()
    
    # Generate configurations
    configurations = generate_configurations(
        test_bases=args.test_bases,
        providers=args.providers,
        data_types=args.data_types,
        operations=args.operations,
        versions=args.versions
    )
    
    if not configurations:
        print("No valid configurations generated!")
        return
    
    print(f"Generated {len(configurations)} configurations to profile:")
    for config in configurations:
        print(f"  - {config}")
    
    # Create profiler
    profiler = ComprehensiveProfiler(args.output_dir)
    
    # Run profiling
    profiler.run_comprehensive_profiling(
        configurations=configurations,
        iterations=args.iterations,
        line_profile=args.line_profile
    )


if __name__ == "__main__":
    main()
