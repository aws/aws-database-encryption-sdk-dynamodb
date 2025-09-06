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
  final DynamoDbClient ddbClient;
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
    this.ddbClient = setupDynamoDbClient();
    
    // Create table if it doesn't exist
    createTableIfNotExists();

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

  private DynamoDbClient setupDynamoDbClient() {
    // Configure attribute actions for encryption
    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    attributeActionsOnEncrypt.put("partition_key", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("sort_key", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put("attribute1", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("attribute2", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put(":attribute3", CryptoAction.DO_NOTHING);

    // Configure table encryption
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
    final DynamoDbTableEncryptionConfig tableConfig = DynamoDbTableEncryptionConfig
      .builder()
      .logicalTableName(tableName)
      .partitionKeyName("partition_key")
      .sortKeyName("sort_key")
      .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
      .keyring(keyring)
      .allowedUnsignedAttributePrefix(":")
      .algorithmSuiteId(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384)
      .build();
    tableConfigs.put(tableName, tableConfig);

    // Create encryption interceptor
    final DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor
      .builder()
      .config(
        DynamoDbTablesEncryptionConfig
          .builder()
          .tableEncryptionConfigs(tableConfigs)
          .build()
      )
      .build();

    // Create DynamoDB client with local endpoint
    return DynamoDbClient
      .builder()
      .endpointOverride(URI.create("http://localhost:8000"))
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();
  }

  private void createTableIfNotExists() {
    try {
      // Check if table exists
      ddbClient.describeTable(DescribeTableRequest.builder()
        .tableName(tableName)
        .build());
      System.out.println("Table " + tableName + " already exists");
    } catch (ResourceNotFoundException e) {
      // Table doesn't exist, create it
      System.out.println("Creating table " + tableName + "...");
      ddbClient.createTable(CreateTableRequest.builder()
        .tableName(tableName)
        .keySchema(
          KeySchemaElement.builder()
            .attributeName("partition_key")
            .keyType(KeyType.HASH)
            .build(),
          KeySchemaElement.builder()
            .attributeName("sort_key")
            .keyType(KeyType.RANGE)
            .build()
        )
        .attributeDefinitions(
          AttributeDefinition.builder()
            .attributeName("partition_key")
            .attributeType(ScalarAttributeType.S)
            .build(),
          AttributeDefinition.builder()
            .attributeName("sort_key")
            .attributeType(ScalarAttributeType.N)
            .build()
        )
        .billingMode(BillingMode.PAY_PER_REQUEST)
        .build());
      System.out.println("Table " + tableName + " created successfully");
    }
  }

  /**
   * Run a single batch put-get cycle and measure performance
   */
  public BatchPutGetResult runBatchPutGetCycle(final byte[] data) {
    // Create 25 items with same data, different sort_key
    final List<WriteRequest> writeRequests = new ArrayList<>();
    final List<Map<String, AttributeValue>> keys = new ArrayList<>();

    for (int i = 0; i < 25; i++) {
      final Map<String, AttributeValue> item = new HashMap<>();
      item.put("partition_key", AttributeValue.builder().s("benchmark-test").build());
      item.put("sort_key", AttributeValue.builder().n(String.valueOf(i)).build());
      item.put("attribute1", AttributeValue.builder()
        .m(Map.of("data", AttributeValue.builder().b(SdkBytes.fromByteArray(data)).build()))
        .build());
      item.put("attribute2", AttributeValue.builder().s("sign me!").build());
      item.put(":attribute3", AttributeValue.builder().s("ignore me!").build());

      writeRequests.add(WriteRequest.builder()
        .putRequest(PutRequest.builder().item(item).build())
        .build());

      // Prepare key for batch get
      final Map<String, AttributeValue> key = new HashMap<>();
      key.put("partition_key", AttributeValue.builder().s("benchmark-test").build());
      key.put("sort_key", AttributeValue.builder().n(String.valueOf(i)).build());
      keys.add(key);
    }

    // Measure batch write
    final long batchWriteStart = System.nanoTime();
    final BatchWriteItemResponse writeResponse = ddbClient.batchWriteItem(
      BatchWriteItemRequest.builder()
        .requestItems(Map.of(tableName, writeRequests))
        .build()
    );
    final long batchWriteTime = System.nanoTime() - batchWriteStart;

    // Measure batch get
    final long batchGetStart = System.nanoTime();
    final BatchGetItemResponse getResponse = ddbClient.batchGetItem(
      BatchGetItemRequest.builder()
        .requestItems(Map.of(tableName, KeysAndAttributes.builder()
          .keys(keys)
          .consistentRead(true)
          .build()))
        .build()
    );
    final long batchGetTime = System.nanoTime() - batchGetStart;

    // Verify 25 items retrieved
    final List<Map<String, AttributeValue>> returnedItems = getResponse.responses().get(tableName);
    if (returnedItems.size() != 25) {
      throw new RuntimeException("Expected 25 items, got " + returnedItems.size());
    }

    // Verify data integrity for first item
    final Map<String, AttributeValue> firstItem = returnedItems.get(0);
    final AttributeValue attr1 = firstItem.get("attribute1");
    if (attr1 == null || attr1.m() == null || attr1.m().get("data") == null) {
      throw new RuntimeException("Data verification failed");
    }

    return new BatchPutGetResult(
      batchWriteTime / 1_000_000.0, // Convert to milliseconds
      batchGetTime / 1_000_000.0
    );
  }

  public List<TestResult> runAllBenchmarks() {
    System.out.println("Starting comprehensive DB-ESDK benchmark suite");
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

    try (ProgressBar pb = new ProgressBar("DB-ESDK Benchmark", totalTests)) {
      // Run throughput tests
      for (final Integer dataSize : dataSizes) {
        final TestResult result = Tests.runThroughputTest(
          this,
          dataSize,
          config.iterations.measurement
        );
        allResults.add(result);
        pb.step();
      }

      // Run memory tests
      for (final Integer dataSize : dataSizes) {
        final TestResult result = Tests.runMemoryTest(this, dataSize);
        allResults.add(result);
        pb.step();
      }

      // Run concurrency tests
      for (final Integer dataSize : dataSizes) {
        for (final Integer concurrency : config.concurrencyLevels) {
          if (concurrency > 1) {
            final TestResult result = Tests.runConcurrentTest(
              this,
              dataSize,
              concurrency,
              config.iterations.measurement
            );
            allResults.add(result);
            pb.step();
          }
        }
      }
    }

    System.out.println("Benchmark suite completed successfully");
    return allResults;
  }

  public record BatchPutGetResult(
    double putLatencyMs,
    double getLatencyMs
  ) {}
}
