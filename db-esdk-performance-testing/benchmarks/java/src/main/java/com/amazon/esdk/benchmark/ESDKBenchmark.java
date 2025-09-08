// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package com.amazon.esdk.benchmark;

import com.amazon.esdk.benchmark.model.Config;
import com.amazon.esdk.benchmark.model.TestResult;
import java.lang.management.ManagementFactory;
import java.net.URI;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import me.tongfei.progressbar.ProgressBar;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.BillingMode;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableRequest;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.KeysAndAttributes;
import software.amazon.awssdk.services.dynamodb.model.PutRequest;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;
import software.amazon.awssdk.services.dynamodb.model.WriteRequest;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.AesWrappingAlg;
import software.amazon.cryptography.materialproviders.model.CreateRawAesKeyringInput;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/**
 * DB-ESDK Performance Benchmark Suite - Java Implementation
 *
 * <p>This class provides comprehensive performance testing for the AWS Database Encryption SDK (DB-ESDK) Java
 * runtime, measuring throughput, latency, memory usage, and scalability using DynamoDB operations.
 */
public final class ESDKBenchmark {

  final Config config;
  final DynamoDbItemEncryptor itemEncryptor;
  final IKeyring keyring;
  final String tableName;
  // System information
  final int cpuCount;
  final long totalMemoryMB;

  public ESDKBenchmark(final String configPath) throws Exception {
    this.config = Config.loadConfig(configPath);

    // System info
    this.cpuCount = Runtime.getRuntime().availableProcessors();
    this.totalMemoryMB = Runtime.getRuntime().maxMemory() / (1024 * 1024);

    // Table name for testing
    this.tableName = "db-esdk-performance-test";

    // Setup DB-ESDK with local DynamoDB
    this.keyring = setupKeyring();
    this.itemEncryptor = setupItemEncryptorClient();
    
    // Create table if it doesn't exist
    // createTableIfNotExists();

    System.out.println(
      "Initialized DB-ESDK Benchmark - CPU cores: " +
      cpuCount +
      ", Memory: " +
      (totalMemoryMB / 1024.0) +
      "GB"
    );
  }

  private IKeyring setupKeyring() throws Exception {
    // Generate a 256-bit AES key for testing
    final KeyGenerator aesGen = KeyGenerator.getInstance("AES");
    aesGen.init(256, new SecureRandom());
    final SecretKey encryptionKey = aesGen.generateKey();
    final ByteBuffer keyBytes = ByteBuffer.wrap(encryptionKey.getEncoded());

    // Create Raw AES keyring using Material Providers
    final String keyNamespace = "db-esdk-performance-test";
    final String keyName = "test-aes-256-key";

    final CreateRawAesKeyringInput keyringInput = CreateRawAesKeyringInput
      .builder()
      .keyName(keyName)
      .keyNamespace(keyNamespace)
      .wrappingKey(keyBytes)
      .wrappingAlg(AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16)
      .build();

    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();

    return matProv.CreateRawAesKeyring(keyringInput);
  }

  private DynamoDbItemEncryptor setupItemEncryptorClient() {
    // Configure attribute actions for encryption
    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    attributeActionsOnEncrypt.put("partition_key", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("sort_key", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("attribute1", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("attribute2", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put(":attribute3", CryptoAction.DO_NOTHING);

    // Configure table encryption
    final DynamoDbItemEncryptorConfig tableConfig = DynamoDbItemEncryptorConfig
      .builder()
      .logicalTableName(tableName)
      .partitionKeyName("partition_key")
      .sortKeyName("sort_key")
      .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
      .keyring(keyring)
      .allowedUnsignedAttributePrefix(":")
      .algorithmSuiteId(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384)
      .build();

    final DynamoDbItemEncryptor itemEncryptor = DynamoDbItemEncryptor
      .builder()
      .DynamoDbItemEncryptorConfig(tableConfig)
      .build();
    
    return itemEncryptor;
  }

  /**
   * Run a single batch put-get cycle and measure performance
   */
  public Result runItemEncryptorCycle(final byte[] data) {
    // Create 25 items with same data, different sort_key
    final Map<String, AttributeValue> item = new HashMap<>();
      item.put("partition_key", AttributeValue.builder().s("benchmark-test").build());
      item.put("sort_key", AttributeValue.builder().n(String.valueOf(0)).build());
      item.put("attribute1", AttributeValue.builder()
        .m(Map.of("data", AttributeValue.builder().b(SdkBytes.fromByteArray(data)).build()))
        .build());
      item.put("attribute2", AttributeValue.builder().s("sign me!").build());
      item.put(":attribute3", AttributeValue.builder().s("ignore me!").build());

    // Measure batch write
    final long encryptStart = System.nanoTime();
    final Map<String, AttributeValue> encryptedItem = itemEncryptor
      .EncryptItem(
        EncryptItemInput.builder().plaintextItem(item).build()
      )
      .encryptedItem();
    final long encryptTime = System.nanoTime() - encryptStart;

    // Measure batch get
    final long decryptStart = System.nanoTime();
    final Map<String, AttributeValue> decryptedItem = itemEncryptor
      .DecryptItem(
        DecryptItemInput.builder().encryptedItem(encryptedItem).build()
      )
      .plaintextItem();
    final long decryptTime = System.nanoTime() - decryptStart;

    return new Result(
      encryptTime / 1_000_000.0, // Convert to milliseconds
      decryptTime / 1_000_000.0
    );
  }

  public List<TestResult> runAllBenchmarks() {
    System.out.println("Starting comprehensive ESDK benchmark suite");
    final List<TestResult> allResults = new ArrayList<>();

    // Get test parameters from config
    final List<Integer> dataSizes = new ArrayList<>();
    if (config.dataSizes.small != null) dataSizes.addAll(
      config.dataSizes.small
    );
    if (config.dataSizes.medium != null) dataSizes.addAll(
      config.dataSizes.medium
    );
    if (config.dataSizes.large != null) dataSizes.addAll(
      config.dataSizes.large
    );

    // Calculate actual total tests
    final int throughputTests = dataSizes.size();
    final int memoryTests = dataSizes.size();
    final int concurrentTests =
      dataSizes.size() *
      (int) config.concurrencyLevels.stream().filter(c -> c > 1).count();
    final int totalTests = throughputTests + memoryTests + concurrentTests;

    System.out.println("Running " + totalTests + " total tests");

    try (
      final ProgressBar pb = new ProgressBar("Running benchmarks", totalTests)
    ) {
      // Throughput tests
      for (final int dataSize : dataSizes) {
        try {
          final TestResult result = Tests.runThroughputTest(
            this,
            dataSize,
            config.iterations.measurement
          );
          if (result != null) {
            allResults.add(result);
            System.out.println(
              "Throughput test completed: " +
              String.format("%.2f", result.opsPerSecond) +
              " ops/sec"
            );
            System.out.flush();
            System.out.println(
              "Throughput test completed - Ops/sec: " +
              String.format("%.2f", result.opsPerSecond) +
              ", MB/sec: " +
              String.format("%.2f", result.bytesPerSecond / (1024 * 1024))
            );
          }
        } catch (final Exception e) {
          System.err.println(
            "Throughput test failed for data size " +
            dataSize +
            " bytes: " +
            e.getMessage()
          );
        }
        System.out.flush();
        pb.step();
        System.out.flush();
      }

      // Memory tests
      for (final int dataSize : dataSizes) {
        try {
          final TestResult result = Tests.runMemoryTest(this, dataSize);
          allResults.add(result);
          System.out.println(
            "Memory test completed: " +
            String.format("%.2f", result.peakMemoryMb) +
            " MB peak"
          );
          System.out.flush();
        } catch (final Exception e) {
          System.err.println(
            "Memory test failed for data size " +
            dataSize +
            " bytes: " +
            e.getMessage()
          );
        }
        System.out.flush();
        pb.step();
        System.out.flush();
      }

      // Concurrent tests
      for (final int dataSize : dataSizes) {
        for (final int concurrency : config.concurrencyLevels) {
          if (concurrency > 1) { // Skip single-threaded for concurrent tests
            try {
              final TestResult result = Tests.runConcurrentTest(
                this,
                dataSize,
                concurrency,
                5
              );
              allResults.add(result);
              System.out.println(
                "Concurrent test completed: " +
                String.format("%.2f", result.opsPerSecond) +
                " ops/sec @ " +
                concurrency +
                " threads"
              );
            } catch (final Exception e) {
              System.err.println(
                "Concurrent test failed for data size " +
                dataSize +
                " bytes with " +
                concurrency +
                " threads: " +
                e.getMessage()
              );
            }
            System.out.flush();
            pb.step();
            System.out.flush();
          }
        }
      }
    }

    System.out.println(
      "Benchmark suite completed. Total results: " + allResults.size()
    );
    return allResults;
  }


  public record Result(
    double putLatencyMs,
    double getLatencyMs
  ) {}
}
