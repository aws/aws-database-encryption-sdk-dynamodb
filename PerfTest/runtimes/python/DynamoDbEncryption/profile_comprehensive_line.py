#!/usr/bin/env python3
"""
Enhanced comprehensive profiling suite with detailed line profiling for access pattern analysis.

This script provides deep line-by-line profiling to identify performance bottlenecks
and access patterns in DynamoDB encryption operations.
"""

import argparse
import cProfile
import json
import pstats
import sys
import time
from io import StringIO
from pathlib import Path
from typing import Dict, Any, List, Tuple, Optional
import traceback
import re

# Try to import optional profiling tools
try:
    from line_profiler import LineProfiler
    HAS_LINE_PROFILER = True
except ImportError:
    HAS_LINE_PROFILER = False
    print("WARNING: line_profiler not available. Install with: pip install line_profiler")

try:
    import memory_profiler
    HAS_MEMORY_PROFILER = True
except ImportError:
    HAS_MEMORY_PROFILER = False

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
        
        # Map data types to constants
        self.data_type_map = {
            "single": "single_attribute",
            "nested": "nested_attributes", 
            "flat": "flat_attributes"
        }
        
        self.actual_data_type = self.data_type_map[self.data_type]
    
    def get_identifier(self) -> str:
        """Get a unique identifier for this configuration."""
        return f"{self.version}_{self.test_base}_{self.provider}_{self.data_type}_{self.operation}"
    
    def __str__(self) -> str:
        """String representation of configuration."""
        return (f"Config(version={self.version}, test_base={self.test_base}, "
                f"provider={self.provider}, data_type={self.data_type}, "
                f"operation={self.operation})")


class LineProfilingAnalyzer:
    """Advanced analyzer for line profiling results."""
    
    def __init__(self):
        """Initialize the analyzer."""
        self.patterns = {
            'string_operations': [
                r'\.encode\(',
                r'\.decode\(',
                r'str\(',
                r'\.join\(',
                r'\.format\(',
                r'\.replace\(',
                r'\.strip\(',
                r'\.split\(',
            ],
            'crypto_operations': [
                r'encrypt',
                r'decrypt',
                r'sign',
                r'verify',
                r'hash',
                r'hmac',
                r'gcm',
                r'aes',
                r'wrap',
                r'unwrap',
            ],
            'data_conversion': [
                r'to_dafny',
                r'from_dafny',
                r'to_dict',
                r'from_dict',
                r'serialize',  
                r'deserialize',
                r'marshal',
                r'unmarshal',
            ],
            'aws_operations': [
                r'kms',
                r'dynamodb',
                r'boto3',
                r'botocore',
                r'aws_',
            ],
            'memory_operations': [
                r'copy',
                r'deepcopy',
                r'list\(',
                r'dict\(',
                r'\.append\(',
                r'\.extend\(',
            ]
        }
    
    def analyze_line_profile_output(self, output: str) -> Dict[str, Any]:
        """Analyze line profiler output and extract insights."""
        lines = output.split('\n')
        
        analysis = {
            'total_time': 0.0,
            'total_calls': 0,
            'hotspots': [],
            'pattern_analysis': {},
            'function_summary': {},
            'file_summary': {},
            'slowest_lines': [],
        }
        
        current_function = None
        current_file = None
        
        for line in lines:
            line = line.strip()
            
            # Parse function headers
            if line.startswith('File:') and 'Function:' in line:
                parts = line.split('Function:')
                if len(parts) == 2:
                    current_file = parts[0].replace('File:', '').strip()
                    current_function = parts[1].strip()
                    
                    if current_function not in analysis['function_summary']:
                        analysis['function_summary'][current_function] = {
                            'file': current_file,
                            'total_time': 0.0,
                            'lines': []
                        }
            
            # Parse line profiling data
            if line and line[0].isdigit():
                try:
                    parts = line.split()
                    if len(parts) >= 6:
                        line_num = int(parts[0])
                        hits = int(parts[1])
                        per_hit = float(parts[2]) if parts[2] != '' else 0.0
                        percent_time = float(parts[3]) if parts[3] != '' else 0.0
                        total_time = float(parts[4]) if parts[4] != '' else 0.0
                        code = ' '.join(parts[5:])
                        
                        line_data = {
                            'line_num': line_num,
                            'hits': hits,
                            'per_hit': per_hit,
                            'percent_time': percent_time,
                            'total_time': total_time,
                            'code': code,
                            'function': current_function,
                            'file': current_file
                        }
                        
                        analysis['total_time'] += total_time
                        analysis['total_calls'] += hits
                        
                        # Track hotspots (lines with > 1% of total time)
                        if percent_time > 1.0:
                            analysis['hotspots'].append(line_data)
                        
                        # Track slowest lines
                        analysis['slowest_lines'].append(line_data)
                        
                        # Update function summary
                        if current_function:
                            analysis['function_summary'][current_function]['total_time'] += total_time
                            analysis['function_summary'][current_function]['lines'].append(line_data)
                        
                        # Analyze patterns
                        self._analyze_patterns(code, line_data, analysis['pattern_analysis'])
                        
                except (ValueError, IndexError):
                    continue
        
        # Sort slowest lines by total time
        analysis['slowest_lines'].sort(key=lambda x: x['total_time'], reverse=True)
        analysis['slowest_lines'] = analysis['slowest_lines'][:20]  # Top 20
        
        # Sort hotspots by percent time
        analysis['hotspots'].sort(key=lambda x: x['percent_time'], reverse=True)
        
        return analysis
    
    def _analyze_patterns(self, code: str, line_data: Dict, pattern_analysis: Dict):
        """Analyze code patterns in a line."""
        for pattern_type, patterns in self.patterns.items():
            if pattern_type not in pattern_analysis:
                pattern_analysis[pattern_type] = {
                    'total_time': 0.0,
                    'total_calls': 0,
                    'lines': []
                }
            
            for pattern in patterns:
                if re.search(pattern, code, re.IGNORECASE):
                    pattern_analysis[pattern_type]['total_time'] += line_data['total_time']
                    pattern_analysis[pattern_type]['total_calls'] += line_data['hits']
                    pattern_analysis[pattern_type]['lines'].append(line_data)
                    break  # Only count once per line


class EnhancedLineProfiler:
    """Enhanced line profiler with detailed analysis capabilities."""
    
    def __init__(self, output_dir: str = "line_profiling_results"):
        """Initialize the enhanced line profiler."""
        self.output_dir = Path(output_dir)
        self.output_dir.mkdir(exist_ok=True)
        
        self.results = {}
        self._test_instance_cache = {}
        self.analyzer = LineProfilingAnalyzer()
    
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
    
    def profile_with_line_profiler(self, config: ProfilingConfiguration, 
                                 iterations: int = 10) -> Optional[Dict[str, Any]]:
        """Enhanced line profiling with detailed analysis."""
        if not HAS_LINE_PROFILER:
            print("Line profiler not available!")
            return None
            
        print(f"Line profiling: {config}")
        
        test_instance = self._get_test_instance(config)
        test_item = test_instance.get_test_item(config.actual_data_type)
        
        # Create line profiler
        lp = LineProfiler()
        
        # Add main functions to profile
        if config.operation == "encrypt":
            lp.add_function(test_instance.encrypt_item)
            # Also add internal encryption functions if available
            if hasattr(test_instance, 'item_encryptor') and hasattr(test_instance.item_encryptor, 'encrypt_dynamodb_item'):
                lp.add_function(test_instance.item_encryptor.encrypt_dynamodb_item)
        else:
            lp.add_function(test_instance.decrypt_item)
            if hasattr(test_instance, 'item_encryptor') and hasattr(test_instance.item_encryptor, 'decrypt_dynamodb_item'):
                lp.add_function(test_instance.item_encryptor.decrypt_dynamodb_item)
        
        # Try to add more granular functions for deeper analysis
        self._add_deeper_profiling_functions(lp, test_instance, config)
        
        # Profile the operation
        start_time = time.time()
        if config.operation == "encrypt":
            wrapped = lp(lambda: [test_instance.encrypt_item(test_item) for _ in range(iterations)])
        else:
            encrypted_item = test_instance.encrypt_item(test_item)
            wrapped = lp(lambda: [test_instance.decrypt_item(encrypted_item) for _ in range(iterations)])
        
        wrapped()
        total_time = time.time() - start_time
        
        # Capture output
        output = StringIO()
        lp.print_stats(stream=output)
        raw_output = output.getvalue()
        
        # Analyze the output
        analysis = self.analyzer.analyze_line_profile_output(raw_output)
        
        # Save detailed output
        output_file = self.output_dir / f"{config.get_identifier()}_line_profile.txt"
        with open(output_file, 'w') as f:
            f.write(raw_output)
        
        return {
            'config': config.__dict__,
            'raw_output': raw_output,
            'analysis': analysis,
            'total_time': total_time,
            'iterations': iterations,
            'output_file': str(output_file)
        }
    
    def _add_deeper_profiling_functions(self, profiler: LineProfiler, test_instance, config: ProfilingConfiguration):
        """Add deeper functions for more granular profiling."""
        try:
            # Try to add crypto-related functions
            if hasattr(test_instance, 'materials_provider'):
                # V3 style
                provider = test_instance.materials_provider
                if hasattr(provider, 'get_encryption_materials'):
                    profiler.add_function(provider.get_encryption_materials)
                if hasattr(provider, 'get_decryption_materials'):
                    profiler.add_function(provider.get_decryption_materials)
            
            if hasattr(test_instance, 'keyring_impl'):
                # V4 style - harder to profile due to Dafny compilation
                pass
            
            # Add string conversion functions if available
            try:
                import smithy_dafny_standard_library.internaldafny.extern.UTF8 as utf8_module
                if hasattr(utf8_module, 'Encode'):
                    profiler.add_function(utf8_module.Encode)
                if hasattr(utf8_module, 'Decode'):
                    profiler.add_function(utf8_module.Decode)
            except ImportError:
                pass
            
        except Exception as e:
            print(f"Warning: Could not add deeper profiling functions: {e}")
    
    def generate_comprehensive_analysis(self, results: List[Dict[str, Any]]):
        """Generate comprehensive analysis across all profiling results."""
        report_path = self.output_dir / "comprehensive_line_profiling_report.txt"
        
        with open(report_path, "w") as f:
            f.write("COMPREHENSIVE LINE PROFILING ANALYSIS\n")
            f.write("=" * 80 + "\n\n")
            
            # Overall summary
            total_configurations = len(results)
            f.write(f"Total Configurations Profiled: {total_configurations}\n\n")
            
            # Cross-configuration pattern analysis
            f.write("CROSS-CONFIGURATION PATTERN ANALYSIS\n")
            f.write("-" * 80 + "\n\n")
            
            all_patterns = {}
            for result in results:
                if 'analysis' not in result:
                    continue
                    
                config_id = result['config']['version'] + "_" + result['config']['provider']
                analysis = result['analysis']
                
                for pattern_type, pattern_data in analysis['pattern_analysis'].items():
                    if pattern_type not in all_patterns:
                        all_patterns[pattern_type] = {
                            'total_time': 0.0,
                            'configurations': []
                        }
                    
                    all_patterns[pattern_type]['total_time'] += pattern_data['total_time']
                    all_patterns[pattern_type]['configurations'].append({
                        'config': config_id,
                        'time': pattern_data['total_time'],
                        'calls': pattern_data['total_calls']
                    })
            
            # Sort patterns by total time
            sorted_patterns = sorted(all_patterns.items(), 
                                   key=lambda x: x[1]['total_time'], reverse=True)
            
            for pattern_type, pattern_data in sorted_patterns:
                f.write(f"{pattern_type.upper()} Operations:\n")
                f.write(f"  Total Time: {pattern_data['total_time']:.3f}s\n")
                f.write(f"  Configurations: {len(pattern_data['configurations'])}\n")
                
                # Show top configurations for this pattern
                top_configs = sorted(pattern_data['configurations'], 
                                   key=lambda x: x['time'], reverse=True)[:3]
                f.write("  Top Configurations:\n")
                for config_data in top_configs:
                    f.write(f"    {config_data['config']}: {config_data['time']:.3f}s "
                           f"({config_data['calls']} calls)\n")
                f.write("\n")
            
            # Individual configuration analysis
            f.write("INDIVIDUAL CONFIGURATION ANALYSIS\n")
            f.write("-" * 80 + "\n\n")
            
            for result in results:
                if 'analysis' not in result:
                    continue
                
                config = result['config']
                analysis = result['analysis']
                
                config_name = f"{config['version']}_{config['test_base']}_{config['provider']}_{config['data_type']}_{config['operation']}"
                f.write(f"{config_name.upper()}\n")
                f.write("-" * len(config_name) + "\n")
                
                f.write(f"Total Time: {analysis['total_time']:.3f}s\n")
                f.write(f"Total Calls: {analysis['total_calls']:,}\n")
                f.write(f"Iterations: {result['iterations']}\n")
                f.write(f"Avg Time per Iteration: {result['total_time']/result['iterations']:.3f}s\n\n")
                
                # Hotspots
                if analysis['hotspots']:
                    f.write("TOP HOTSPOTS (>1% of total time):\n")
                    for i, hotspot in enumerate(analysis['hotspots'][:5], 1):
                        f.write(f"  {i}. Line {hotspot['line_num']} in {hotspot['function']}\n")
                        f.write(f"     Time: {hotspot['total_time']:.3f}s ({hotspot['percent_time']:.1f}%)\n")
                        f.write(f"     Hits: {hotspot['hits']:,} | Per Hit: {hotspot['per_hit']:.6f}s\n")
                        f.write(f"     Code: {hotspot['code'][:100]}...\n")
                        f.write("\n")
                
                # Function summary
                if analysis['function_summary']:
                    f.write("FUNCTION SUMMARY:\n")
                    sorted_functions = sorted(analysis['function_summary'].items(),
                                            key=lambda x: x[1]['total_time'], reverse=True)
                    for func_name, func_data in sorted_functions[:5]:
                        f.write(f"  {func_name}: {func_data['total_time']:.3f}s "
                               f"({len(func_data['lines'])} lines)\n")
                
                f.write("\n" + "="*60 + "\n\n")
        
        print(f"\nComprehensive line profiling report saved to: {report_path}")
        return report_path
    
    def run_line_profiling_suite(self, configurations: List[ProfilingConfiguration],
                               iterations: int = 10):
        """Run comprehensive line profiling suite."""
        if not HAS_LINE_PROFILER:
            print("ERROR: line_profiler is required for this analysis!")
            print("Install with: pip install line_profiler")
            return
        
        print(f"\nRunning line profiling suite with {iterations} iterations per test...")
        print("=" * 80)
        
        results = []
        
        for i, config in enumerate(configurations, 1):
            print(f"\n[{i}/{len(configurations)}] Profiling: {config}")
            print("-" * 60)
            
            try:
                result = self.profile_with_line_profiler(config, iterations)
                if result:
                    results.append(result)
                    
                    # Print quick summary
                    analysis = result['analysis']
                    print(f"  ✓ Total time: {analysis['total_time']:.3f}s")
                    print(f"  ✓ Hotspots found: {len(analysis['hotspots'])}")
                    print(f"  ✓ Pattern categories: {len(analysis['pattern_analysis'])}")
                    
                    if analysis['hotspots']:
                        top_hotspot = analysis['hotspots'][0]
                        print(f"  ✓ Top hotspot: {top_hotspot['percent_time']:.1f}% - "
                             f"{top_hotspot['code'][:50]}...")
                
            except Exception as e:
                print(f"  ✗ Failed: {e}")
                traceback.print_exc()
        
        # Generate comprehensive analysis
        if results:
            self.generate_comprehensive_analysis(results)
            
            # Save raw results
            json_path = self.output_dir / "line_profiling_results.json"
            with open(json_path, "w") as f:
                json.dump(results, f, indent=2, default=str)
            
            print(f"\nResults saved to: {self.output_dir}")
            print(f"  - Comprehensive report: comprehensive_line_profiling_report.txt")
            print(f"  - Raw results: line_profiling_results.json")
            print(f"  - Individual profiles: *_line_profile.txt")


def generate_configurations(test_bases: List[str] = None,
                          providers: List[str] = None,
                          data_types: List[str] = None,
                          operations: List[str] = None,
                          versions: List[str] = None) -> List[ProfilingConfiguration]:
    """Generate all combinations of profiling configurations."""
    test_bases = test_bases or ["item"]  # Focus on item for line profiling
    providers = providers or ["aes"]     # Start with AES for analysis
    data_types = data_types or ["single"] # Start with simple data
    operations = operations or ["encrypt", "decrypt"]
    versions = versions or ["v4"]  # Focus on v4 for improvement analysis
    
    configurations = []
    
    for version in versions:
        for test_base in test_bases:
            for provider in providers:
                for data_type in data_types:
                    for operation in operations:
                        config = ProfilingConfiguration(
                            test_base=test_base,
                            provider=provider,
                            data_type=data_type,
                            operation=operation,
                            version=version
                        )
                        configurations.append(config)
    
    return configurations


def main():
    """Main entry point."""
    parser = argparse.ArgumentParser(
        description="Enhanced line profiling suite for DynamoDB encryption access patterns",
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="""
Examples:
  # Profile v4 AES with line profiling (default)
  python profile_comprehensive_line.py

  # Profile specific configuration with more iterations
  python profile_comprehensive_line.py --iterations 50 --providers aes --data-types single

  # Compare v3 vs v4 line profiles
  python profile_comprehensive_line.py --versions v3 v4 --providers aes --operations encrypt

  # Profile all providers for comparison
  python profile_comprehensive_line.py --providers aes kms hierarchy --iterations 20
        """
    )
    
    parser.add_argument(
        "--test-bases",
        nargs="+",
        choices=["item", "client"],
        default=["item"],
        help="Test bases to profile (default: item)"
    )
    parser.add_argument(
        "--providers",
        nargs="+",
        choices=["aes", "kms", "hierarchy"],
        default=["aes"],
        help="Providers to profile (default: aes)"
    )
    parser.add_argument(
        "--data-types",
        nargs="+",
        choices=["single", "nested", "flat"],
        default=["single"],
        help="Data types to test (default: single)"
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
        help="Versions to profile (default: v4)"
    )
    parser.add_argument(
        "--iterations",
        type=int,
        default=10,
        help="Number of iterations per test (default: 10, higher for more accuracy)"
    )
    parser.add_argument(
        "--output-dir",
        default="line_profiling_results",
        help="Output directory for results (default: line_profiling_results)"
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
    
    print(f"Generated {len(configurations)} configurations for line profiling:")
    for config in configurations:
        print(f"  - {config}")
    
    # Create enhanced line profiler
    profiler = EnhancedLineProfiler(args.output_dir)
    
    # Run line profiling suite
    profiler.run_line_profiling_suite(
        configurations=configurations,
        iterations=args.iterations
    )


if __name__ == "__main__":
    main()
