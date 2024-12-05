#!/bin/bash -eu

cd $( dirname ${BASH_SOURCE[0]} )

rm -rf test_examples/src
cp -r examples test_examples/src/
cd test_examples
cargo add aws-db-esdk
cargo run
