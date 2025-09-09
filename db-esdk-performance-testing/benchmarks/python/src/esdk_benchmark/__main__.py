# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0

"""
Entry point for running the benchmark as a module.

Usage:
    python -m esdk_benchmark
    python -m esdk_benchmark --quick
    python -m esdk_benchmark --config custom_config.yaml
"""

from .program import main

if __name__ == "__main__":
    exit(main())
