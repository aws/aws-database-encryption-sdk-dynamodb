# ComplexSearchableEncryptionExample

This example uses a more complex searchable encryption configuration than other examples.
This is intended to demonstrate how to set up a more complicated searchable encryption configuration.
This also walks through some example query expressions one can use to search their encrypted data.

## TODO: Demo repo is private. This should be made public.

This example is based off of a use case described in [Demo.md](https://github.com/aws-samples/searchable-encryption-dynamodb-howto/blob/main/BeaconPOC/Demo.md#changes-for-encryption).
This example demonstrates a use case where a single DDB table stores multiple different record types under the same schema.

```
.
├── ComplexSearchableEncryptionExample // Main entry point for example
├── BeaconConfig // Sets up beacons and searchable encryption configuration
├── PutRequests // PUT requests added to the DDB table
├── PutRequests // QUERY requests executed on the DDB table
├── BeaconConfig // Sets up beacons and searchable encryption configuration
└── README.md
```