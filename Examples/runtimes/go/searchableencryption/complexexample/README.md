# ComplexSearchableEncryptionExample

This example demonstrates complex queries
you can perform using beacons.
The example data used is for demonstrative purposes only,
and might not meet the distribution and correlation uniqueness
recommendations for beacons.
See our documentation for whether beacons are
right for your particular data set:
https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/searchable-encryption.html#are-beacons-right-for-me

This example uses a more complex searchable encryption configuration than other examples.
This is intended to demonstrate how to set up a more complicated searchable encryption configuration.
This also walks through some example query expressions one can use to search their encrypted data.

```
.
├── complexsearchableencryptionexample.go // Main entry point for example
├── beaconconfig.go // Sets up beacons and searchable encryption configuration
├── putrequests.go // PUT requests added to the DDB table
├── queryrequests.go // QUERY requests executed on the DDB table
└── README.md
```
