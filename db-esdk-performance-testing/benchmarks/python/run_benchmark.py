#!/usr/bin/env python3
# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Convenience script to run the DB-ESDK Python Performance Benchmark.

This script handles setup and execution of the benchmark suite.
"""

import os
import sys
import subprocess
from pathlib import Path


def main():
    """Main entry point for the benchmark runner."""
    # Get the directory containing this script
    script_dir = Path(__file__).parent.absolute()
    
    # Change to the script directory
    os.chdir(script_dir)
    
    print("=== DB-ESDK Python Performance Benchmark ===")
    print(f"Working directory: {script_dir}")
    
    # Check if we're in a virtual environment
    in_venv = hasattr(sys, 'real_prefix') or (
        hasattr(sys, 'base_prefix') and sys.base_prefix != sys.prefix
    )
    
    if not in_venv:
        print("WARNING: Not running in a virtual environment.")
        print("It's recommended to create and activate a virtual environment:")
        print("  python -m venv benchmark-env")
        print("  source benchmark-env/bin/activate  # (macOS/Linux)")
        print("  benchmark-env\\Scripts\\activate     # (Windows)")
        print()
    
    # Check if Poetry is available
    try:
        subprocess.run(["poetry", "--version"], check=True, capture_output=True)
        print("Found Poetry package manager")
    except (subprocess.CalledProcessError, FileNotFoundError):
        print("Poetry not found. Please install Poetry first:")
        print("  curl -sSL https://install.python-poetry.org | python3 -")
        print("  # or")
        print("  pip install poetry")
        return 1
    
    # Check if package is installed
    try:
        result = subprocess.run(["poetry", "run", "python", "-c", "import esdk_benchmark; print(esdk_benchmark.__file__)"], 
                              check=True, capture_output=True, text=True, cwd=script_dir)
        print(f"Found esdk_benchmark package at: {result.stdout.strip()}")
    except subprocess.CalledProcessError:
        print("Installing benchmark package with Poetry...")
        try:
            subprocess.run(["poetry", "install"], check=True, cwd=script_dir)
            print("Package installed successfully.")
        except subprocess.CalledProcessError as e:
            print(f"Failed to install package: {e}")
            print("Please install manually with: poetry install")
            return 1
    
    # Parse command line arguments
    args = sys.argv[1:]
    
    # If no arguments provided, show help
    if not args:
        print("\nRunning benchmark with default settings...")
        print("Use --help to see all available options.")
        print("Use --quick for a faster test run.")
        print()
    
    # Run the benchmark using Poetry
    try:
        cmd = ["poetry", "run", "esdk-benchmark"] + args
        print(f"Running: {' '.join(cmd)}")
        result = subprocess.run(cmd, cwd=script_dir)
        return result.returncode
    except Exception as e:
        print(f"Benchmark execution failed: {e}")
        import traceback
        traceback.print_exc()
        return 1


if __name__ == "__main__":
    sys.exit(main())
