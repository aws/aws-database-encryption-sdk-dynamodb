To publish a new version of the aws-db-esdk for version N.N.N

1. Acquire the appropriate permissions
1. Ensure git checkout of main is fresh and clean
1. ./start_release.sh N.N.N
1. cd ../../../releases/rust/db_esdk
1. Create a PR with all changed or added files
1. cargo publish
1. cd ../../../DynamoDbEncryption/runtimes/rust/ # i.e. return here
1. ./test_published.sh N.N.N
