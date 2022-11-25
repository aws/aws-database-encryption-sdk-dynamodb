## DynamoDB Encryption Client for Dafny

This repo contains the following Dafny projects:

- DynamoDb Item Encryptor
- DynamoDb Encryption Middleware Internal
- Structured Encryption

All projects can be verified, built, and tested according to the instructions below.

### Development Requirements

This library builds and verifies with the following:
- dotnet 6.0.400
- dafny 3.9.1

TODO: Better define and maintain (via CI) dev dependencies for this module

Optionally, if you want to run the [Dafny Report Generator](#generate-dafny-report)
you will need to install the `dafny-reportgenerator` dotnet tool
(and make sure `.dotnet/tools` is within your `PATH`,
see instructions in the output from running the following command):

```
dotnet tool install --global dafny-reportgenerator --version 1.2.0
```

#### System Dependencies - macOS only

If you are using macOS then you must install OpenSSL 1.1,
and the OpenSSL 1.1 `lib` directory must be on the dynamic linker path at runtime.

If the .NET runtime cannot locate your OpenSSL 1.1 libraries,
you may encounter an error that says:

> No usable version of libssl was found

To resolve this,
we recommend that you install OpenSSL via Homebrew using `brew install openssl@1.1`.

### Verify

```
make verify
```

Runs the Dafny verifier over the Dafny code.

#### Generate Report

After running verifications you may also generate a report via:

```
make dafny-reportgenerator
```

### Build

#### (Optional) Rebuild the model

If you have updated the smithy model, you will also need to re-generate the corresponding models.

```
./generate-from-model.sh
```

This will generate the Dafny Types file from the smithy model.
TODO: Also have this generate the .NET and Java.

#### Compile Dafny into .NET

```
make compile_net
```

Compiles the dafny code into .NET.

### Test

#### Test .NET

If you are on macOS:
(TODO: These instructions may not work on an M1 mac)

```
make test_net_mac_intel
```

Otherwise:

```
make test_net
```

This runs the tests that were originally written in Dafny,
then compiled to .NET in the `make compile_net` step above.
