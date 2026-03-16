// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package com.amazonaws.services.dynamodbv2.datamodeling.sdkv2;

import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.CachingMostRecentProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.DirectKmsMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.EncryptionMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.store.MetaStore;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.store.ProviderStore;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.testing.ScenarioManifest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ProvisionedThroughput;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

public class CipherTextGeneratorIT extends HolisticIT {

  @Test(enabled = false)
  public void generateKmsAes128Vector() throws IOException {
    localDynamoDb.start();
    client = localDynamoDb.createLimitedWrappedClient();
    createCiphertextTables(client);

    ScenarioManifest scenarioManifest = getManifestFromFile(
      SCENARIO_MANIFEST_PATH,
      new TypeReference<ScenarioManifest>() {}
    );
    loadKeyData(scenarioManifest.keyDataPath);

    Map<String, String> desc = Collections.singletonMap("amzn-ddb-env-alg", "AES/128");
    EncryptionMaterialsProvider provider = new DirectKmsMaterialsProvider(
      kmsClient, keyDataMap.get("awsKmsUsWest2").keyId, desc);

    Set<String> tables = generateStandardData(provider);
    writeTablesAsTestVector("aws-kms-aes128-1.json", tables.toArray(new String[0]));

    client.close();
    localDynamoDb.stop();
  }

  @Test(enabled = true)
  public void generateNonAsciiMaterialNameVector() throws IOException {
    localDynamoDb.start();
    client = localDynamoDb.createLimitedWrappedClient();
    createCiphertextTables(client);

    ScenarioManifest scenarioManifest = getManifestFromFile(
      SCENARIO_MANIFEST_PATH,
      new TypeReference<ScenarioManifest>() {}
    );
    loadKeyData(scenarioManifest.keyDataPath);

    String materialName = "\u30C6\u30B9\u30C8\u03A8\u7D20\u6750\uD83D\uDE00";
    String metastoreTableName = "nonascii-metatable";

    // Create metastore table
    MetaStore.createTable(
      client,
      metastoreTableName,
      ProvisionedThroughput.builder()
        .readCapacityUnits(100L)
        .writeCapacityUnits(100L)
        .build()
    );

    // Create KMS-backed metastore
    EncryptionMaterialsProvider metaProvider = new DirectKmsMaterialsProvider(
      kmsClient, keyDataMap.get("awsKmsUsWest2").keyId);
    ProviderStore metastore = new MetaStore(
      client, metastoreTableName,
      DynamoDBEncryptor.getInstance(metaProvider));

    // Create most_recent provider with non-ASCII material name
    EncryptionMaterialsProvider provider =
      new CachingMostRecentProvider(metastore, materialName, 1000);

    Set<String> tables = generateStandardData(provider);
    writeTablesAsTestVector("nonascii-material-name-1.json", tables.toArray(new String[0]));
    writeTablesAsTestVector("metastore-nonascii-name-1.json", metastoreTableName);

    client.close();
    localDynamoDb.stop();
  }

  private void writeTablesAsTestVector(String outputFile, String... tableNames)
          throws IOException {
    com.fasterxml.jackson.databind.module.SimpleModule module =
            new com.fasterxml.jackson.databind.module.SimpleModule();
    module.addSerializer(AttributeValue.class,
            new com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.testing.AttributeValueSerializer());
    ObjectMapper jsonMapper = new ObjectMapper();
    jsonMapper.registerModule(module);

    Map<String, List<Map<String, AttributeValue>>> testVector = new HashMap<>();
    for (String table : tableNames) {
      testVector.put(table, client.scan(
              ScanRequest.builder().tableName(table).build()).items());
    }

    java.nio.file.Path vectorPath = java.nio.file.Paths.get(
            "src", "test", "resources", "vectors", "encrypted_item",
            "ciphertext", "java", outputFile);
    java.nio.file.Files.createDirectories(vectorPath.getParent());
    java.nio.file.Files.write(vectorPath,
            jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(testVector));
  }
}
