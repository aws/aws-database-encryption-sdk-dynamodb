# AWS Database Encryption SDK for DynamoDB

AWS Database Encryption SDK for DynamoDB

## Using the AWS Database Encryption SDK for DynamoDB for Rust

The AWS Database Encryption SDK for DynamoDB is available on [Crates.io](https://www.crates.io/).

## Building the AWS Database Encryption SDK for DynamoDB

To build, the AWS Database Encryption SDK for DynamoDB requires the most up to date version of [Dafny](https://github.com/dafny-lang/dafny) on your PATH.

You will also need to ensure that you fetch all submodules using either `git clone --recursive ...` when cloning the repository or `git submodule update --init` on an existing clone.

To setup your project to use the AWS Database Encryption SDK for DynamoDB in Rust, run:

```
cd DynamoDbEncryption
# Polymorph smithy to Rust
make polymorph_rust
# Transpile Dafny to Rust
make transpile_rust
# Build Project
cd runtimes/rust
cargo build
```

### (Optional) Set up the AWS Database Encryption SDK for DynamoDB to work with AWS KMS

If you set up the AWS Database Encryption SDK for DynamoDB to use the AWS KMS Keyring,
the AWS Database Encryption SDK for DynamoDB will make calls to AWS KMS on your behalf,
using the appropriate AWS SDK.

However, you must first set up AWS credentials for use with the AWS SDK.

## Testing the AWS Database Encryption SDK for DynamoDB for Rust

### Configure AWS credentials

To run the test suite you must first set up AWS credentials for use with the AWS SDK.
This is required in order to run the integration tests, which use a KMS Keyring against a publicly accessible KMS CMK.

### Run the tests

Run the test suite with:

```
cd AwsEncryptionSDK
make test_rust
```

Run tests on examples, to ensure they are up to date:

```
cd AwsEncryptionSDK/runtimes/rust/
cargo test --examples
```

Please look at the Examples on how to use the Encryption SDK in Rust [here](examples).

Please note that tests and test vectors require internet access and valid AWS credentials, since calls to KMS are made as part of the test workflow.

## License

This library is licensed under the Apache 2.0 License.
