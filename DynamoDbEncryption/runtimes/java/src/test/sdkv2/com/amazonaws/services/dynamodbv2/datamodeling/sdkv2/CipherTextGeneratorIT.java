// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package com.amazonaws.services.dynamodbv2.datamodeling.sdkv2;

import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.DirectKmsMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.EncryptionMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.testing.ScenarioManifest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
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

    generateStandardData(provider);
    writeTablesAsTestVector("aws-kms-aes128-1.json", "TableName", "HashKeyOnly");

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
