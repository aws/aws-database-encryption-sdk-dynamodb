## DynamoDB Encryption Client for Dafny

TODO: Edit your repository description on GitHub

### Rebuild the model

Currently only smithy -> dafny is working. Need to get smithy -> .NET with union support.

Run the following:
```
cd polymorph/smithy-dotnet
export MODEL_ROOT=<path_to_repo>/aws-dynamodb-encryption-dafny/src/StructuredEncryption/model

./gradlew run --args="\    
    -m $MODEL_ROOT \
    -namespace aws.cryptography.structuredEncryption \
    -d $MODEL_ROOT"
```

### Run the tests

Assuming you are on a Mac:

```
cd src/StructuredEncryption/runtimes/net
dotnet test -f netcoreapp3.1 Test
```

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.

