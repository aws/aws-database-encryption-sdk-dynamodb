# AWS Database Encryption SDK for DynamoDb Java Examples

This project contains examples for using the AWS Database Encryption SDK for DynamoDb in Rust.

Overview:

```
├── ..
├── examples: Examples source
│   ├── basic_get_put_example.rs: Example using AWS DB ESDK to Put and Get an encrypted item from DynamoDB
│   ├── create_keystore_key.rs: Example creating a branch key in a Keystore DynamoDB table
│   ├── clientsupplier/: Examples using a custom KMS ClientSupplier
│   ├── itemencryptor/: Examples using the DynamoDbItemEncryptor
│   ├── keyring/: Examples creating and using different keyrings
│   └── searchableencryption/: Examples demonstrating searchable encryption configuration and usage
└── src: Source code including tests
```

## Getting Started

### Development Requirements

- A Rust 1.80 or newer development environment

### Building and Running

All of the examples are called from the `main` method.
To run a given example, inspect its particular setup requirements,
create and/or grant access to any required AWS resources,
and run the example.

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.
