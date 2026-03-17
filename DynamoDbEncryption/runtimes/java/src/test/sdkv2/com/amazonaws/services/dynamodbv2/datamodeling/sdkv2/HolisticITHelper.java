package com.amazonaws.services.dynamodbv2.datamodeling.sdkv2;

import static com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.HolisticIT.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.EncryptionContext;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.EncryptionFlags;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.DirectKmsMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.testing.DdbRecordMatcher;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.testing.ScenarioManifest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;

public class HolisticITHelper {

  public static void decryptNonAsciiTableNameVector(
    String nonAsciiTableInECCipherFile
  ) throws IOException, GeneralSecurityException {
    DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(symProv);
    EncryptionContext ctx = EncryptionContext
      .builder()
      .tableName("テーブル\uD83D\uDE00")
      .hashKeyName("hashKey")
      .rangeKeyName("rangeKey")
      .build();

    Map<String, Set<EncryptionFlags>> actions = new HashMap<>();
    for (String attr : ENCRYPTED_TEST_VALUE.keySet()) {
      switch (attr) {
        case "hashKey":
        case "rangeKey":
        case "version":
          actions.put(attr, signOnly);
          break;
        default:
          actions.put(attr, encryptAndSign);
          break;
      }
    }

    Map<String, List<Map<String, AttributeValue>>> manifest =
      getCiphertextManifestFromFile(nonAsciiTableInECCipherFile);
    for (Map<String, AttributeValue> encryptedItem : manifest.get(tableName)) {
      Map<String, AttributeValue> decrypted = encryptor.decryptRecord(
        encryptedItem,
        actions,
        ctx
      );
      assertTrue(
        new DdbRecordMatcher(ENCRYPTED_TEST_VALUE, false).matches(decrypted)
      );
    }
  }

  public static void decryptNullTableNameInEC(
    String nullTableNameInECCipherFile
  ) throws IOException, GeneralSecurityException {
    DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(symProv);
    EncryptionContext ctx = EncryptionContext
      .builder()
      .tableName(null)
      .hashKeyName("hashKey")
      .rangeKeyName("rangeKey")
      .build();

    Map<String, Set<EncryptionFlags>> actions = new HashMap<>();
    for (String attr : ENCRYPTED_TEST_VALUE.keySet()) {
      switch (attr) {
        case "hashKey":
        case "rangeKey":
        case "version":
          actions.put(attr, signOnly);
          break;
        default:
          actions.put(attr, encryptAndSign);
          break;
      }
    }

    Map<String, List<Map<String, AttributeValue>>> manifest =
      getCiphertextManifestFromFile(nullTableNameInECCipherFile);
    for (Map<String, AttributeValue> encryptedItem : manifest.get(tableName)) {
      Map<String, AttributeValue> decrypted = encryptor.decryptRecord(
        encryptedItem,
        actions,
        ctx
      );
      assertTrue(
        new DdbRecordMatcher(ENCRYPTED_TEST_VALUE, false).matches(decrypted)
      );
    }
  }

  public static void decryptNonBmpHashKeyVectorAndWithNullKeyId(
    String nonBMPinECCipherFile
  ) throws IOException, GeneralSecurityException {
    ScenarioManifest scenarioManifest = getManifestFromFile(
      SCENARIO_MANIFEST_PATH,
      new TypeReference<
        com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.testing.ScenarioManifest
      >() {}
    );
    loadKeyData(scenarioManifest.keyDataPath);

    DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(
      new DirectKmsMaterialsProvider(kmsClient)
    );
    EncryptionContext ctx = EncryptionContext
      .builder()
      .tableName("HashKeyOnly")
      .hashKeyName("hashKey")
      .build();

    Map<String, Set<EncryptionFlags>> actions = new HashMap<>();
    actions.put("hashKey", signOnly);

    String nonBmpKey = "test\uD83D\uDE00Ψkey";

    Map<String, List<Map<String, AttributeValue>>> manifest =
      getCiphertextManifestFromFile(nonBMPinECCipherFile);
    for (Map<String, AttributeValue> encryptedItem : manifest.get(tableName)) {
      Map<String, AttributeValue> decrypted = encryptor.decryptRecord(
        encryptedItem,
        actions,
        ctx
      );
      assertEquals(nonBmpKey, decrypted.get("hashKey").s());
    }
  }

  public static void writeTablesAsTestVector(
    DynamoDbClient client,
    String outputFile,
    String... tableNames
  ) throws IOException {
    com.fasterxml.jackson.databind.module.SimpleModule module =
      new com.fasterxml.jackson.databind.module.SimpleModule();
    module.addSerializer(
      AttributeValue.class,
      new com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.testing.AttributeValueSerializer()
    );
    ObjectMapper jsonMapper = new ObjectMapper();
    jsonMapper.registerModule(module);

    Map<String, List<Map<String, AttributeValue>>> testVector = new HashMap<>();
    for (String table : tableNames) {
      testVector.put(
        table,
        client.scan(ScanRequest.builder().tableName(table).build()).items()
      );
    }

    java.nio.file.Path vectorPath = java.nio.file.Paths.get(
      "src",
      "test",
      "resources",
      "vectors",
      "encrypted_item",
      "ciphertext",
      "java",
      outputFile
    );
    java.nio.file.Files.createDirectories(vectorPath.getParent());
    java.nio.file.Files.write(
      vectorPath,
      jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(testVector)
    );
  }
}
