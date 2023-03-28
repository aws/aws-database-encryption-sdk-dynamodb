## DynamoDb Encryption

### Code Organization

DynamoDb Encryption is a project containing the following Dafny 'localServices':
- DynamoDbEncryption: A config-less entry point for shared structures and helper methods related to DDB Encryption.
- DynamoDbItemEncryptor: A client responsible for the encryption and decryption of DDB Items (sans any DDB API call).
- DynamoDbEncryptionTransforms: An internal interface responsible for appropriately adding encryption to DDB APIs.
  A custom implementation adapts this interface to the AWS SDK for each target language.
  This custom implementation exists in each `runtimes/<target_language>` directory. 
- StructuredEncryption: An internal interface responsible for encrypting and decrypting generic structured data.

`runtimes` contains the implementation (generated and hand-written) of this project in each supported target language.

Currently this project only supports Java.

#### Java

`runtimes/java` contains the Java related code and build instructions for this project.

Within `runtimes/java`:

- `src/main/java` contains all hand written Java code, including externs.
- `src/main/dafny-generated` contains all Dafny to Java transpiled code.
- `src/main/smithy-generated` contains all Smithy to Java generated code.

### Development

Common Makefile targets are:

- `make verify` verifies the whole project.
  - You can instead specify a single namespace to verify via: `make verify_namespace SMITHY_NAMESPACE=DynamoDbItemEncryptor`
- `make build_java` transpiles, builds, and tests everything from scratch in Java
- `make test_java` builds and tests the transpiled code in Java.

### Development Requirements

TODO

#### (Optional) Dafny Report Generator Requirements

Optionally, if you want to run the [Dafny Report Generator](#generate-dafny-report)
you will need to install the `dafny-reportgenerator` dotnet tool
(and make sure `.dotnet/tools` is within your `PATH`,
see instructions in the output from running the following command):

```
dotnet tool install --global dafny-reportgenerator --version 1.2.0
```

#### (Optional) Duvet Requirements

Optionally, if you want to run [Duvet](https://github.com/awslabs/duvet) reports,
you will need to use Cargo to install duvet.

If you don't have it already,
[get and install Cargo and Rust](https://doc.rust-lang.org/cargo/getting-started/installation.html).

Then install duvet:

```
cargo +stable install duvet
```

#### System Dependencies - macOS only

If you are using macOS then you must install OpenSSL 1.1,
and the OpenSSL 1.1 `lib` directory must be on the dynamic linker path at runtime.

If the .NET runtime cannot locate your OpenSSL 1.1 libraries,
you may encounter an error that says:

> No usable version of libssl was found

To resolve this,
we recommend that you install OpenSSL via Homebrew using `brew install openssl@1.1`.

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.

