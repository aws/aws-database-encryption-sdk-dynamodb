#!/bin/bash -eu

# Check if exactly one argument is provided
if [ "$#" -ne 1 ]; then
    echo 1>&2 "USAGE: start_release.sh N.N.N"
    exit 1
fi

# Go to the directory of this script
cd $( dirname ${BASH_SOURCE[0]} )

# Check if the provided argument matches the version pattern
REGEX_VERSION='^\d+\.\d+\.\d+$'
MATCHES=$(echo "$1" | egrep $REGEX_VERSION | wc -l)
if [ $MATCHES -eq 0 ]; then
   echo 1>&2 "Version \"$1\" must be N.N.N"
   exit 1
fi

# assume role to allow tests to run
mwinit -f
unset AWS_ACCESS_KEY_ID AWS_SECRET_ACCESS_KEY AWS_SESSION_TOKEN AWS_PROFILE
_assume_role="arn:aws:iam::370957321024:role/GitHub-CI-DDBEC-Dafny-Role-us-west-2"
_session_name="${USER}-DDBEC-Dafny-Java-Tests"
export AWS_PROFILE=aws-crypto-tools-team+optools-ci-ToolsDevelopment
export AWS_REGION=us-west-2
STS_RESPONSE=`aws sts assume-role --role-arn $_assume_role --role-session-name $_session_name`
export AWS_ACCESS_KEY_ID=`echo "$STS_RESPONSE" | jq -r .Credentials.AccessKeyId`
export AWS_SECRET_ACCESS_KEY=`echo "$STS_RESPONSE" | jq -r .Credentials.SecretAccessKey`
export AWS_SESSION_TOKEN=`echo "$STS_RESPONSE" | jq -r .Credentials.SessionToken`
unset AWS_PROFILE AWS_SDK_LOAD_CONFIG _assume_role _session_name STS_RESPONSE
    
# Update the version in Cargo.toml
perl -pe "s/^version = .*$/version = \"$1\"/" < Cargo.toml > new_Cargo.toml
mv new_Cargo.toml Cargo.toml

# Remove all files and directories in src except for specified files
find src -depth 1 | egrep -v '(intercept.rs|lib.rs|software_externs.rs|README)' | xargs rm -rf

# Change to the parent directory and run make polymorph and transpile commands
cd ../..
make polymorph_rust transpile_rust test_rust test_rust_debug

# Remove target directory
cd runtimes/rust
rm -rf target

# Remove existing release directory and copy current directory to releases
rm -rf ../../../releases/rust/db_esdk
cp -r . ../../../releases/rust/db_esdk

# Go to the release directory
cd ../../../releases/rust/db_esdk

# Restore the dafny_runtime_rust directory that was previously tracked by Git but had been deleted
git checkout dafny_runtime_rust

# Remove unnecessary files and directories
rm -rf *~ copy_externs.sh upgrade_examples.sh start_release.sh test_published.sh test_examples *.pem RELEASE.md src/README.md

# Create .gitignore file with specified entries
echo Cargo.lock > .gitignore
echo target >> .gitignore

# format the generated code
cargo fmt

# replace local path with latest dafny-runtime from crates.io
cargo rm dafny-runtime
cargo add dafny-runtime -F sync

# Run cargo test and example tests
cargo test --release
cargo run --release --example main
cargo test
cargo run --example main

# Remove Cargo.lock and .pem files after testing the examples
rm -f Cargo.lock *.pem
