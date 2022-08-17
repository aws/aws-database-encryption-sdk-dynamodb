## DynamoDB Encryption Client for Dafny

TODO: Edit your repository description on GitHub

### Development Requirements

Right now this repo has a bare-bones Makefile to help with some building/testing.
The Makefile doesn't currently build dev requirements, so you will need to grab these yourself.

You will need at least:
- dotnet (I'm using v5.0.402)
- dafny (I'm using v3.4.0)

Additionally, I am working off a Mac and cannot guarantee that these commands will work on other platforms.

### Rebuild the model

```
make generate-models
```

Generates new models using the polymorph submodule.
Will overwrite models, but will not clean up old models that are not overwritten.

### Build and Verify Dafny Code

```
make build
```

Builds and verifies the dafny code.

### Run the tests

```
make test
```

Re-builds/re-verifies the dafny code and runs the dafny generated tests.

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.

