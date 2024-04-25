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
4. Run `make transpile_net`
5. Run `cd runtimes/net`
6. Run `dotnet run --framework net6.0`

### Saving results for later

Running the above commands will create `runtimes/java/decrypt.json` and `runtimes/net/decrypt.json`.

These files should be permanently saved before a release.

For example, if we're on version 3.4 and are getting close to a new release, we would

`cp runtimes/java/decrypt.json runtimes/java/decrypt_java_34.json`

`cp runtimes/net/decrypt.json runtimes/java/decrypt_dotnet_34.json`

and then modify `RunAllTests` in `dafny/DDBEncryption/src/TestVectors.dfy` to explicitly check these two files.

As other languages are supported, we will also deal with runtimes/XXX/decrypt.json and runtimes/java/decrypt_XXX_34.json
in a simlar manner.

This ensures that records written in any version in any language can be read by the current version in any language.

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.

