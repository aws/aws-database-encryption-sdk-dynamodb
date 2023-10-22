## DecryptWithPermute

DB-ESDK for DynamoDB supports SIGN_ONLY and ENCRYPT_AND_SIGN attribute actions.
In version 3.1.0 and below, when a Set type is assigned a SIGN_ONLY attribute action,
there is a chance that signature validation of the record containing a Set will fail on read,
even if the Set attributes contain the same values.
The probability of a failure depends on the order of the elements in the Set
combined with how DynamoDB returns this data, which is undefined.

The 3.1.1 update addresses the issue by ensuring that any Set values are canonicalized
in the same order while written to DynamoDB as when read back from DynamoDB.

This project implements a slightly modified version of DecryptItem
from the the AWS Database Encryption SDK for DynamoDB,
which can validate an encrypted record that as written with 3.1.0,
allowing it to be decrypted.

PermuteDecrypt is exactly like the DynamoDbItemEncryptor's DecryptItem,
with one exception :
If the signature fails to match, and SIGN_ONLY Sets are involved,
then other permutations of the members of those sets are tried,
and the item is decrypted if any of those permutations allow the signature to match.

If you would normally decrypt an item like this
```
DynamoDbItemEncryptor itemEncryptor = DynamoDbItemEncryptor.builder()
  .DynamoDbItemEncryptorConfig(config)
  .build();
DecryptItemOutput decryptedItem = itemEncryptor.DecryptItem(myInput);
```
You instead do this :
```
DynamoDbPermuteDecryptor itemDecryptor = DynamoDbPermuteDecryptor.builder()
  .DynamoDbPermuteDecryptorConfig.builder()
    .inner(config)
    .build()
  .build();
PermuteDecryptOutput decryptedItem = itemDecryptor.PermuteDecrypt(
  PermuteDecryptInput.builder()
    .inner(myInput),
    .maxSetSize(7)
    .build()
  .build();
```
The PermuteDecryptInput holds a normal DecryptItemInput object, plus a `maxSetSize`.
If any set in the item has more elements than `maxSetSize`,
decryption of the item is attempted, but no permutations are attempted.

The output of PermuteDecrypt holds two entries
`inner` : a DecryptItemOutput object
`didPermute` : if false, the item was validated and decrypted with no special handling.
If true, some permutation of sets in the input allowed successful validation.

If you think you know the set permutations with which the item was originally written,
set that attribute of your item to the expected permutation, and call `PermuteDecrypt`
with a `maxSetSize` of `1`. A single attempt will be made to validate and decrypt the record,
which will quickly succeed or fail.

To exhaustively try every permutation of a set of size N required N! (N factorial) attempts.
As sets get large (over 7 or 8) this can start to take a considerable amount of time,
so use `maxSetSize` to put a limit on the size of a set that will be attempted.
A set as large as 9 can probably be handled, depending on your hardware,
but over that is probably untenable. 


### Code Organization

DecryptWithPermute is a project containing the following Dafny 'localServices' under `dafny`:
- DecryptWithPermute: A single entry point : PermuteDecrypt described above.

Currently this project only supports Java.

#### Java

`runtimes/java` contains the Java related code and build instructions for this project.

Within `runtimes/java`:

- `src/main/java` contains all hand written Java code, including externs.
- `src/main/dafny-generated` contains all Dafny to Java transpiled code.
- `src/main/smithy-generated` contains all Smithy to Java generated code.

### Development

Common Makefile targets are:

- `make verify` verifies the whole project. You should specify a `CORES` that is as high as your
  computer supports in order to speed this up. However, this will still probably take long enough
  that your dev loop should instead use the following:
  - You can instead specify a single service to verify via: `make verify_service SERVICE=DecryptWithPermute`
  - You can also verify a specific file and output in a more help format via: `make verify_single FILE=<filename>`,
    where `<filename>` is the path to the file to verify relative to this directory (`DynamoDbEncryption`).
    You may optionally narrow down the scope by specifying a `PROC`. For example, if you just want to verify
    the method `EncryptStructure`, use `make verify_single FILE=<filename> PROC=EncryptStructure`
- `make build_java` transpiles, builds, and tests everything from scratch in Java.
  You will need to run this the first time you clone this repo, and any time you introduce changes
  that end up adding or removing dafny-generated files.
  - The above command takes a while to complete.
    If you want to re-generate dafny code specific to a service for a service, use the following:
    `make local_transpile_impl_java_single SERVICE=DecryptWithPermute FILE=Index.dfy`
    and then `test_java` to build/test those changes.
    Using `Index.dfy` will end up transpiling the entire service, but you can also specify a different
    file to scope down the transpilation further. This target will transpile `FILE` and every
    "includes" in that `FILE`, recursively down to the bounds of the service namespace.
    Note that the `transpile_implementation_java_single` target is provided as a convenience,
    and is not guaranteed to be 100% consistent with output from the regular `build_java` target.
    The behavior SHOULD NOT be different, although if you are experiencing
    weird behavior, see if `build_java` resolves the issue.
    Only use this target for local testing.
  - `make local_transpile_test_java_single SERVICE=DecryptWithPermute FILE=Validate.dfy`
    may be used similar to above in order to re-transpile a specific test file
    (and any of that module's "includes" within `/test`).
    Note that this will clobber all other Dafny generated tests being run
    with `make test_java`. This target is useful to quickly iterate on changes
    to tests within a specific file, but you will need to `make build_java`
    again if you want to run the full test suite locally.
    Only use this target for local testing.
- `make test_java` builds and tests the transpiled code in Java.

### Development Requirements

* Dafny 4.1.0: https://github.com/dafny-lang/dafny
* A Java 8 or newer development environment

#### (Optional) Dafny Report Generator Requirements

Optionally, if you want to run the [Dafny Report Generator](#generate-dafny-report)
you will need to install the `dafny-reportgenerator` dotnet tool
(and make sure `.dotnet/tools` is within your `PATH`,
see instructions in the output from running the following command):

```
dotnet tool install --global dafny-reportgenerator --version 1.2.0
```

#### (Optional) Duvet Requirements

Optionally, if you want to run [Duvet](https://github.com/awslabs/duvet) reports,
you will need to use Cargo to install duvet.

If you don't have it already,
[get and install Cargo and Rust](https://doc.rust-lang.org/cargo/getting-started/installation.html).

Then install duvet:

```
cargo +stable install duvet
```

#### System Dependencies - macOS only

If you are using macOS then you must install OpenSSL 1.1,
and the OpenSSL 1.1 `lib` directory must be on the dynamic linker path at runtime.

If the .NET runtime cannot locate your OpenSSL 1.1 libraries,
you may encounter an error that says:

> No usable version of libssl was found

To resolve this,
we recommend that you install OpenSSL via Homebrew using `brew install openssl@1.1`.

## Security

See [CONTRIBUTING](CONTRIBUTING.md#security-issue-notifications) for more information.

## License

This project is licensed under the Apache-2.0 License.

