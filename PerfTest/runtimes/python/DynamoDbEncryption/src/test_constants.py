"""Constants used across performance tests."""

import os
from pathlib import Path

# Table Configuration
TABLE_NAME = "Test_Table"
PARTITION_KEY = "partition_key"
SORT_KEY = "sort_key"

# AWS Configuration
AWS_REGION = os.environ.get("AWS_REGION", "us-west-2")
KMS_KEY_ARN = "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126"

# Test Data Files
RESOURCES_DIR = Path(__file__).parent.parent / "resources"
SINGLE_ATTRIBUTE_FILE = RESOURCES_DIR / "single_attribute.json"
NESTED_ATTRIBUTES_FILE = RESOURCES_DIR / "nested_attributes.json"
FLAT_ATTRIBUTES_FILE = RESOURCES_DIR / "flat_attributes.json"

# Benchmark Configuration
BENCHMARK_ROUNDS = 10
BENCHMARK_ITERATIONS = 5
BENCHMARK_WARMUP_ROUNDS = 2

# Encryption Context
ENCRYPTION_CONTEXT = {"purpose": "performance_test", "origin": "aws-database-encryption-sdk-dynamodb"}

# AES Key Material (32 bytes for AES-256)
AES_256_KEY_MATERIAL = bytes(
    [
        0x00,
        0x01,
        0x02,
        0x03,
        0x04,
        0x05,
        0x06,
        0x07,
        0x08,
        0x09,
        0x0A,
        0x0B,
        0x0C,
        0x0D,
        0x0E,
        0x0F,
        0x10,
        0x11,
        0x12,
        0x13,
        0x14,
        0x15,
        0x16,
        0x17,
        0x18,
        0x19,
        0x1A,
        0x1B,
        0x1C,
        0x1D,
        0x1E,
        0x1F,
    ]
)

# Hierarchy Keyring Configuration
HIERARCHY_KEYRING_NAMESPACE = "performance-test"
HIERARCHY_KEYRING_PARTITION = "benchmark"

# Test Data Categories
TEST_DATA_CATEGORIES = ["single_attribute", "nested_attributes", "flat_attributes"]

# Performance Thresholds (in seconds)
ENCRYPT_THRESHOLD = 1.0  # Maximum acceptable time for encryption
DECRYPT_THRESHOLD = 1.0  # Maximum acceptable time for decryption
