# AWS Database Encryption SDK for DynamoDb Java Examples

This project contains examples for using the AWS Database Encryption SDK for DynamoDb in Java.

Overview:

```
├── ..
├── src
│   ├── main/java/software/amazon/cryptography/examples: Examples source
│   │   ├── BasicPutGetExample: Example using AWS DB ESDK to Put and Get an encrypted item from DynamoDB
│   │   ├── CreateKeyStoreTableExample: Example creating a Keystore DynamoDB table for use with a hierarchical keyring
│   │   ├── CreateKeyStoreKeyExample: Example creating a branch key in a Keystore DynamoDB table
│   │   ├── clientsupplier: Examples using a custom KMS ClientSupplier
│   │   ├── enhanced: Examples using the DynamoDbEnhancedClient
│   │   ├── itemencryptor: Examples using the DynamoDbItemEncryptor
│   │   ├── keyring: Examples creating and using different keyrings
│   │   └── searchableencryption: Examples demonstrating searchable encryption configuration and usage
└── └── test: Our tests that run these examples
```

## Getting Started

### Development Requirements

- A Java 8 or newer development environment

### Building and Running

Each example includes a runnable `main` method
and a description of the required command line arguments.
To run a given example, inspect its particular setup requirements,
create and/or grant access to any required AWS resources,
and run the example as specified in the file.

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.
