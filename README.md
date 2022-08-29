## DynamoDB Encryption Client for Dafny

TODO: Edit your repository description on GitHub

### Development Requirements

Right now this repo has a bare-bones Makefile to help with some building/testing.
The Makefile doesn't currently build dev requirements, so you will need to grab these yourself.

You will need at least:
- dotnet (I'm using v6.0.400)
- dafny (I'm using v3.7.3)

Additionally, I am working off a Mac and cannot guarantee that these commands will work on other platforms.

#### System Dependencies - macOS only

If you are using macOS then you must install OpenSSL 1.1,
and the OpenSSL 1.1 `lib` directory must be on the dynamic linker path at runtime.
We recommend that you install OpenSSL via Homebrew using `brew install openssl@1.1`,
and then set the `DYLD_LIBRARY_PATH` environment variable as follows:

```bash
$ export DYLD_LIBRARY_PATH="/usr/local/opt/openssl@1.1/lib"
```

If the .NET runtime cannot locate your OpenSSL 1.1 libraries,
you may encounter an error that says:

> No usable version of libssl was found

### Rebuild the model

```
make generate-models
```

Generates new models for the Structured Encryption Library and DDBEC using the polymorph submodule.
Will overwrite models, but will not clean up old models that are not overwritten.

Currently ignores models for AWS-DDB.

### Verify Dafny Code

```
make verify
```

Verifies the entire project.

### Build Dafny Code

```
make build
```

Compiles the dafny code into target languages (currently just .NET) and builds.

### Run the tests

```
make test
```

Runs the dafny generated tests.

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.

