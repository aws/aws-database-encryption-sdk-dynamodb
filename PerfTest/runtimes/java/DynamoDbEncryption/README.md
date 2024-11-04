# AWS Database Encryption SDK Performance Test

This project contains tests to benchmark the old v2 and the new v3 AWS Database Encryption SDK for DynamoDb in Java. 

## Benchmarking

### Prerequisites

You'd need the appropriate security credentials to run the Kms Key based tests. Also, build all the Gazelle dependecies and deploy to maven local.
The idea of perf test is to run everything from local, before the changes make it to maven central.

1. `ada credentials update --account=370957321024 --role=Admin --once`
2. `cd ../../../../DynamoDbEncryption && make build_java mvn_local_deploy_dependencies mvn_local_deploy`

In case of any failures, look into the `README` for `DynamoDbEncryption`.

### Gradle Jmh

`./gradlew jmh`

This will generate a report on console as well as in `build/results/jmh/results.txt` with the following format:

```bash
Benchmark                                             (plainTextFile)  Mode  Cnt    Score     Error  Units
s.a.c.p.i.v2.AesKeyProviderTest.decrypt         single_attribute.json  avgt    3    2.428 ±   1.484  ms/op
s.a.c.p.i.v2.AesKeyProviderTest.encrypt         single_attribute.json  avgt    3    2.691 ±   2.510  ms/op
s.a.c.p.i.v3.RawAesKeyringTest.decrypt          single_attribute.json  avgt    3   56.868 ±  14.556  ms/op
s.a.c.p.i.v3.RawAesKeyringTest.encrypt          single_attribute.json  avgt    3   42.814 ±   1.302  ms/op
...
```

Size report will also be generated in the same directory, `build/results/size.txt` with the following format:

```bash
AesKeyProviderTest_decrypt_jmhTest                205152              274001              68849
AesKeyProviderTest_encrypt_jmhTest                205152              274001              68849
AwsKmsKeyProviderTest_decrypt_jmhTest             205152              274349              69197
AwsKmsKeyProviderTest_encrypt_jmhTest             205152              274349              69197
...
```

where the columns are `OperationName     OriginalSize    EncryptedSize       Diff`

### Outside Gradle

You can also build the `jar` and then run jmh directly on the command line.
This will result in more optimized code and lower faster results.

First build the project `./gradlew build`

Now you can run the `jar`

`java -jar build/libs/DynamoDbEncryptionPerfTest-1.0-SNAPSHOT-jmh.jar`

You can also run `java -jar build/libs/DynamoDbEncryptionPerfTest-1.0-SNAPSHOT-jmh.jar -h` to get additional options.

### Profiling

You can also run a profiler from the command line `java -jar build/libs/DynamoDbEncryptionPerfTest-1.0-SNAPSHOT-jmh.jar -lprof` will list the available profilers.

If you want to use `async-profiler` you will need to download the artifacts from the [async-profiler github release page](https://github.com/async-profiler/async-profiler/releases).

To run and output a flamegraph run the following:

`java -jar build/libs/DynamoDbEncryptionPerfTest-1.0-SNAPSHOT-jmh.jar -prof async:libPath=/full/path/to/libasyncProfiler.dylib\;output=flamegraph`

### IDE (or Main Class)

1. Run the `main()` method in the TestBase class, or you can also run individual tests by executing the `main()` method in the respective classes.
2. This serves the purpose of quickly debugging benchmarking/jmh issues.

## Profiling (Flamegraph) in IntelliJ

1. Use the main method in each Test class and `Run with Profiler`
2. The graph would show the stack and the relative time taken by each of the method call
