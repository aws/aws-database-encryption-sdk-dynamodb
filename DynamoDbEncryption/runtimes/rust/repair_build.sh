#!/bin/bash -eu

cd $( dirname -- "${BASH_SOURCE[0]}" )

cat extra_ddb.txt >> src/deps/com_amazonaws_dynamodb/client.rs
cat extra_kms.txt >> src/deps/com_amazonaws_kms/client.rs
