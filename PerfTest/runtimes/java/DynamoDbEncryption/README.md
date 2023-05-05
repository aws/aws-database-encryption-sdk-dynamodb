# AWS Database Encryption SDK Performance Test

This project contains tests to benchmark the AWS Database Encryption SDK for DynamoDb in Java. 

## Benchmarking
Note: You'd need the appropriate security credentials to run the AwsKmsKeyringTest. Also, build all the Gazelle dependecies and deploy to maven local.
### Gradle Jmh

`` ./gradlew jmh``

### IDE (or Main Class)
1. Run the `main()` method in the TestBase class, or you can also run individual tests by executing the `main()` method in the respective classes.

## Profiling (Flamegraph) in IntelliJ
1. Use the main method in each Test class and `Run with Profiler`.