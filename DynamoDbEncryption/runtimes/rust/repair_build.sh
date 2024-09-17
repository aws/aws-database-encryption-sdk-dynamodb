#!/bin/bash -eu

cd $( dirname -- "${BASH_SOURCE[0]}" )

cat extra_ddb.txt >> src/deps/com_amazonaws_dynamodb/client.rs
cat extra_kms.txt >> src/deps/com_amazonaws_kms/client.rs

cp extra_impl.txt src/new_implementation_from_dafny.rs
tail +3 src/implementation_from_dafny.rs >> src/new_implementation_from_dafny.rs
mv src/new_implementation_from_dafny.rs src/implementation_from_dafny.rs
