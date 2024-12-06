#!/bin/bash -eu

if [ "$#" -ne 1 ]; then
    echo 1>&2 "USAGE: start_release.sh N.N.N"
    exit 1
fi

cd $( dirname ${BASH_SOURCE[0]} )

REGEX_VERSION='^\d+\.\d+\.\d+$'
MATCHES=$(echo "$1" | egrep $REGEX_VERSION | wc -l)
if [ $MATCHES -eq 0 ]; then
   echo 1>&2 "Version \"$1\" must be N.N.N"
   exit 1
fi

perl -pe "s/^version = .*$/version = \"$1\"/" < Cargo.toml > new_Cargo.toml
mv new_Cargo.toml Cargo.toml

find src -depth 1 | egrep -v '(intercept.rs|lib.rs|software_externs.rs)' | xargs rm -rf
cd ../..
make polymorph_rust transpile_rust test_rust
cd runtimes/rust
rm -rf target
rm -rf ../../../releases/rust/db_esdk
cp -r . ../../../releases/rust/db_esdk
cd ../../../releases/rust/db_esdk
git checkout dafny_runtime_rust
rm -rf *~ copy_externs.sh start_release.sh test_published.sh test_examples *.pem RELEASE.md
echo Cargo.lock > .gitignore
echo target >> .gitignore

cargo test
cargo run --example main
rm -f Cargo.lock *.pem

