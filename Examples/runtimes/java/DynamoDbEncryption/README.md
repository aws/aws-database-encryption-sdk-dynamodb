# AWS Database Encryption SDK for DynamoDb Java Examples

This project contains examples for using the AWS Database Encryption SDK for DynamoDb in Java. 

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
