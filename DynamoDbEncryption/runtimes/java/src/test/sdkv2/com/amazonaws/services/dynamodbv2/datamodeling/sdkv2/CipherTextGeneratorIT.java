// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package com.amazonaws.services.dynamodbv2.datamodeling.sdkv2;

import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.CachingMostRecentProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.DirectKmsMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.EncryptionMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.SymmetricStaticProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.WrappedMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.store.MetaStore;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.store.ProviderStore;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.testing.ScenarioManifest;
import com.amazonaws.util.Base64;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

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

  @Test(enabled = false)
  public void generateNonAsciiMaterialNameVector() throws IOException {
    localDynamoDb.start();
    client = localDynamoDb.createLimitedWrappedClient();
    createCiphertextTables(client);

    ScenarioManifest scenarioManifest = getManifestFromFile(
      SCENARIO_MANIFEST_PATH,
      new TypeReference<ScenarioManifest>() {}
    );
    loadKeyData(scenarioManifest.keyDataPath);

    String materialName = "テストΨ素材\uD83D\uDE00";
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

  @Test(enabled = false)
  public void generateStaticAesRsaVector() throws IOException {
    localDynamoDb.start();
    client = localDynamoDb.createLimitedWrappedClient();
    createCiphertextTables(client);

    ScenarioManifest scenarioManifest = getManifestFromFile(
      SCENARIO_MANIFEST_PATH,
      new TypeReference<ScenarioManifest>() {}
    );
    loadKeyData(scenarioManifest.keyDataPath);

    ScenarioManifest.KeyData aesData = keyDataMap.get("aesKey");
    ScenarioManifest.KeyData rsaPubData = keyDataMap.get("rsaSignPub");
    ScenarioManifest.KeyData rsaPrivData = keyDataMap.get("rsaSignPriv");
    SecretKey aes = new SecretKeySpec(Base64.decode(aesData.material), aesData.algorithm);
    try {
      KeyFactory rsaFact = KeyFactory.getInstance("RSA");
      PublicKey pub = rsaFact.generatePublic(
        new X509EncodedKeySpec(Base64.decode(rsaPubData.material)));
      PrivateKey priv = rsaFact.generatePrivate(
        new PKCS8EncodedKeySpec(Base64.decode(rsaPrivData.material)));
      EncryptionMaterialsProvider provider =
        new SymmetricStaticProvider(aes, new KeyPair(pub, priv));

      Set<String> tables = generateStandardData(provider);
      writeTablesAsTestVector("static-aes-rsa-1.json", tables.toArray(new String[0]));
    } catch (java.security.GeneralSecurityException ex) {
      throw new RuntimeException(ex);
    }

    client.close();
    localDynamoDb.stop();
  }

  @Test(enabled = false)
  public void generateStaticAesHmacNonBmpDescVector() throws IOException {
    localDynamoDb.start();
    client = localDynamoDb.createLimitedWrappedClient();
    createCiphertextTables(client);

    ScenarioManifest scenarioManifest = getManifestFromFile(
      SCENARIO_MANIFEST_PATH,
      new TypeReference<ScenarioManifest>() {}
    );
    loadKeyData(scenarioManifest.keyDataPath);

    ScenarioManifest.KeyData aesData = keyDataMap.get("aesKey");
    ScenarioManifest.KeyData hmacData = keyDataMap.get("hmacKey");
    SecretKey aes = new SecretKeySpec(Base64.decode(aesData.material), aesData.algorithm);
    SecretKey hmac = new SecretKeySpec(Base64.decode(hmacData.material), hmacData.algorithm);

    Map<String, String> description = new HashMap<>();
    description.put("\uD834\uDD1Emusic", "\uD834\uDD22clef");
    description.put("emoji\uD83D\uDD11key", "value\uD83D\uDD12lock");
    description.put("\u03A8greek", "\u03A8value");

    EncryptionMaterialsProvider provider =
      new SymmetricStaticProvider(aes, hmac, description);

    Set<String> tables = generateStandardData(provider);
    writeTablesAsTestVector("static-aes-hmac-nonbmp-desc-1.json", tables.toArray(new String[0]));

    client.close();
    localDynamoDb.stop();
  }

  @Test(enabled = false)
  public void generateWrappedAesRsaVector() throws IOException {
    localDynamoDb.start();
    client = localDynamoDb.createLimitedWrappedClient();
    createCiphertextTables(client);

    ScenarioManifest scenarioManifest = getManifestFromFile(
      SCENARIO_MANIFEST_PATH,
      new TypeReference<ScenarioManifest>() {}
    );
    loadKeyData(scenarioManifest.keyDataPath);

    ScenarioManifest.KeyData aesData = keyDataMap.get("aesKey");
    ScenarioManifest.KeyData rsaPubData = keyDataMap.get("rsaSignPub");
    ScenarioManifest.KeyData rsaPrivData = keyDataMap.get("rsaSignPriv");
    SecretKey aes = new SecretKeySpec(Base64.decode(aesData.material), aesData.algorithm);
    try {
      KeyFactory rsaFact = KeyFactory.getInstance("RSA");
      PublicKey pub = rsaFact.generatePublic(
        new X509EncodedKeySpec(Base64.decode(rsaPubData.material)));
      PrivateKey priv = rsaFact.generatePrivate(
        new PKCS8EncodedKeySpec(Base64.decode(rsaPrivData.material)));
      EncryptionMaterialsProvider provider =
        new WrappedMaterialsProvider(aes, aes, new KeyPair(pub, priv));

      Set<String> tables = generateStandardData(provider);
      writeTablesAsTestVector("wrapped-aes-rsa-1.json", tables.toArray(new String[0]));
    } catch (java.security.GeneralSecurityException ex) {
      throw new RuntimeException(ex);
    }

    client.close();
    localDynamoDb.stop();
  }

  @Test(enabled = false)
  public void generateWrappedRsaHmacVector() throws IOException {
    localDynamoDb.start();
    client = localDynamoDb.createLimitedWrappedClient();
    createCiphertextTables(client);

    ScenarioManifest scenarioManifest = getManifestFromFile(
      SCENARIO_MANIFEST_PATH,
      new TypeReference<ScenarioManifest>() {}
    );
    loadKeyData(scenarioManifest.keyDataPath);

    ScenarioManifest.KeyData rsaEncPubData = keyDataMap.get("rsaEncPub");
    ScenarioManifest.KeyData rsaEncPrivData = keyDataMap.get("rsaEncPriv");
    ScenarioManifest.KeyData hmacData = keyDataMap.get("hmacKey");
    SecretKey hmac = new SecretKeySpec(Base64.decode(hmacData.material), hmacData.algorithm);
    try {
      KeyFactory rsaFact = KeyFactory.getInstance("RSA");
      PublicKey wrappingKey = rsaFact.generatePublic(
        new X509EncodedKeySpec(Base64.decode(rsaEncPubData.material)));
      PrivateKey unwrappingKey = rsaFact.generatePrivate(
        new PKCS8EncodedKeySpec(Base64.decode(rsaEncPrivData.material)));
      EncryptionMaterialsProvider provider =
        new WrappedMaterialsProvider(wrappingKey, unwrappingKey, hmac);

      Set<String> tables = generateStandardData(provider);
      writeTablesAsTestVector("wrapped-rsa-hmac-1.json", tables.toArray(new String[0]));
    } catch (java.security.GeneralSecurityException ex) {
      throw new RuntimeException(ex);
    }

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
