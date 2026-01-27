# AWS Database Encryption SDK for DynamoDB - Rust Performance Benchmarks

This directory contains comprehensive performance benchmarks for the AWS Database Encryption SDK for DynamoDB Rust implementation. The benchmarks measure throughput, memory usage, and concurrency performance across various data sizes and system configurations.

## Features

- **Throughput Benchmarks**: Measure encryption/decryption operations per second
- **Memory Benchmarks**: Track peak memory usage and efficiency ratios
- **Concurrency Benchmarks**: Test performance under different thread counts
- **Raw AES Keyring**: Local 256-bit AES keys (no KMS dependency)

## Prerequisites

- Rust 1.70+ (recommended: latest stable)
- Access to the AWS Database Encryption SDK for DynamoDB Rust runtime

## Quick Start

```bash
# If necessary, build the ESDK and return here
cd ../../../DynamoDbEncryption/
make polymorph_rust transpile_rust
cd ../db-esdk-performance-testing/benchmarks/rust/

# Build and run
cargo run --release -- --config ../../config/test-scenarios.yaml

# Quick test (requires quick_config in YAML)
cargo run --release -- --quick
```

## Configuration

### Command Line

- `--config`: Path to YAML config file (required)
- `--output`: Results output path (default: `../../results/raw-data/rust_results.json`)
- `--quick`: Quick test mode (requires `quick_config` section in YAML)

## Logging

Default: info level. Override with `RUST_LOG`:

```bash
RUST_LOG=debug ./target/release/db_esdk_benchmark --config config.yaml
```

## Development

```bash
# Format and lint
cargo fmt
cargo clippy -- -D warnings

# Test
cargo test

# Debug build
cargo build
RUST_LOG=debug ./target/debug/esdk_benchmark --config config.yaml
```

## Troubleshooting

- **Build issues**: `rustup update && cargo clean && cargo build --release`
- **Config issues**: Validate YAML syntax and check file permissions
- **Memory issues**: Monitor with `htop` or Activity Monitor

## License

Apache License 2.0
