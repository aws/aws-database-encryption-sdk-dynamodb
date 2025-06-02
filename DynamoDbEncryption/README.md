## DynamoDbEncryption

This project implements the AWS Database Encryption SDK for DynamoDB.

### Code Organization

DynamoDbEncryption is a project containing the following Dafny 'localServices' under `dafny`:

- DynamoDbEncryption: A config-less entry point for shared structures and helper methods related to DDB Encryption.
- DynamoDbItemEncryptor: A client responsible for the encryption and decryption of DDB Items (sans any DDB API call).
- DynamoDbEncryptionTransforms: An internal interface responsible for appropriately adding encryption to DDB APIs.
  A custom implementation adapts this interface to the AWS SDK for each target language.
  This custom implementation exists in each `runtimes/<target_language>` directory.
- StructuredEncryption: An internal interface responsible for encrypting and decrypting generic structured data.

`runtimes` contains the implementation (generated and hand-written) of this project in each supported target language.

#### Java

`runtimes/java` contains the Java related code and build instructions for this project.

Within `runtimes/java`:

- `src/main/java` contains all hand written Java code, including externs.
- `src/main/dafny-generated` contains all Dafny to Java transpiled code.
- `src/main/smithy-generated` contains all Smithy to Java generated code.

#### .NET

`runtimes/net` contains the .NET related code and build instructions for this project.

- `Extern/` contains all hand written Dotnet code, including externs.
- `ImplementationFromDafny.cs` contains all Dafny to .NET transpiled code.
- `Generated/` contains all Smithy to .NET generated code.

#### Rust

`runtimes/rust` contains the Rust related code and build instructions for this project.

- `src/` contains all hand written Dotnet code, including externs, and also all Smithy to Rust generated code.
- `src/implementation_from_dafny.cs` contains all Dafny to .NET transpiled code.

#### Go

`runtimes/go` contains the Go related code and build instructions for this project.

- `ImplementationFromDafny-go/` contains all the implementation code which is Smithy to Go generated code, Dafny to Go transpiled code and hand written Go code
- `TestsFromDafny-go`  contains all the test code which is Smithy to Go generated code, Dafny to Go transpiled code and hand written Go code.

### Development

Common Makefile targets are:

- `make verify` verifies the whole project. You should specify a `CORES` that is as high as your
  computer supports in order to speed this up. However, this will still probably take long enough
  that your dev loop should instead use the following:
  - You can instead specify a single service to verify via: `make verify_service SERVICE=DynamoDbItemEncryptor`
  - You can also verify a specific file and output in a more help format via: `make verify_single FILE=<filename>`,
    where `<filename>` is the path to the file to verify relative to this directory (`DynamoDbEncryption`).
    You may optionally narrow down the scope by specifying a `PROC`. For example, if you just want to verify
    the method `EncryptStructure`, use `make verify_single FILE=<filename> PROC=EncryptStructure`
- `make build_java` transpiles, builds, and tests everything from scratch in Java.
  You will need to run this the first time you clone this repo, and any time you introduce changes
  that end up adding or removing dafny-generated files.
  - The above command takes a while to complete.
    If you want to re-generate dafny code specific to a service for a service, use the following:
    `make local_transpile_impl_java_single SERVICE=DynamoDbItemEncryptor FILE=Index.dfy`
    and then `test_java` to build/test those changes.
    Using `Index.dfy` will end up transpiling the entire service, but you can also specify a different
    file to scope down the transpilation further. This target will transpile `FILE` and every
    "includes" in that `FILE`, recursively down to the bounds of the service namespace.
    Note that the `transpile_implementation_java_single` target is provided as a convenience,
    and is not guaranteed to be 100% consistent with output from the regular `build_java` target.
    The behavior SHOULD NOT be different, although if you are experiencing
    weird behavior, see if `build_java` resolves the issue.
    Only use this target for local testing.
  - `make local_transpile_test_java_single SERVICE=DynamoDbItemEncryptor FILE=DynamoDBItemEncryptorTest.dfy`
    may be used similar to above in order to re-transpile a specific test file
    (and any of that module's "includes" within `/test`).
    Note that this will clobber all other Dafny generated tests being run
    with `make test_java`. This target is useful to quickly iterate on changes
    to tests within a specific file, but you will need to `make build_java`
    again if you want to run the full test suite locally.
    Only use this target for local testing.
- `make test_java` builds and tests the transpiled code in Java.
- `make transpile_net` transpiles and builds everything from scratch in .NET.
  You will need to run this the first time you clone this repo, and any time you introduce changes
  that end up adding or removing dafny-generated files.
  - The above command takes a while to complete.
- `make test_net_mac_intel` builds and tests the transpiled code in .NET in an Intel-MacOS environment.
- `make transpile_rust` transpiles all of the Dafny code into runtimes/rust/src/implementation_from_dafny.
- `make polymorph_rust` transpiles the smithy files into untimes/rust/src/\*.rs

### Development Requirements

- Dafny 4.9.0: https://github.com/dafny-lang/dafny
- A Java 8 or newer development environment

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
