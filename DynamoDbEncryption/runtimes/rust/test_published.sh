#!/bin/bash -eu

if [ "$#" -ne 1 ]; then
    echo 1>&2 "USAGE: test_published.sh N.N.N"
    exit 1
fi

cd $( dirname ${BASH_SOURCE[0]} )

REGEX_VERSION='^\d+\.\d+\.\d+$'

echo "$1" | egrep -q $REGEX_VERSION
if [ $? -ne 0 ]; then
   echo 1>&2 "Version \"$1\" must be N.N.N"
   exit 1
fi

VERSION=$1

rm -rf test_examples/src
cp -r examples test_examples/src/
cd test_examples
cargo add aws-db-esdk
MATCH=$(fgrep "aws-db-esdk = \"$VERSION\"" Cargo.toml | wc -l)
if [ $MATCH -eq "0" ]; then
    echo Version $VERSION of aws-db-esdk not the most recent
    egrep '^aws-db-esdk' Cargo.toml
    exit 1
fi
cargo run
