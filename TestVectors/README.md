# AWS Database Encryption SDK for DynamoDb Java Test Vectors

This project contains code encrypts and decrypts a suite of DynamoDB items.
This validates the Database Encryption SDK's cross-version compatibility.

## Getting Started

### Development Requirements

* Dafny 4.2.0: https://github.com/dafny-lang/dafny
  
  The code that executes the test vectors is written in Dafny. 
  You must install the Dafny runtime to compile the Dafny tests into Java.
* A Java 8 or newer development environment

### Building and Running

1. Start in the root `./TestVectors` directory
2. Run `make build_java`
3. Run `make test_java`

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.

