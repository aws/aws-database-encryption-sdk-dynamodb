package com.amazonaws.services.dynamodbv2.datamodeling.sdkv2;

import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.EncryptionContext;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.EncryptionFlags;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.encryption.providers.DirectKmsMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.testing.DdbRecordMatcher;
import com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.testing.ScenarioManifest;
import com.fasterxml.jackson.core.type.TypeReference;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.HolisticIT.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

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

    public static void decryptNullTableNameInEC(String nullTableNameInECCipherFile)
            throws IOException, GeneralSecurityException {
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

    public static void decryptNonBmpHashKeyVector(String nonBMPinECCipherFile)
            throws IOException, GeneralSecurityException {
        ScenarioManifest scenarioManifest = getManifestFromFile(
                SCENARIO_MANIFEST_PATH,
                new TypeReference<com.amazonaws.services.dynamodbv2.datamodeling.sdkv2.testing.ScenarioManifest>() {}
        );
        loadKeyData(scenarioManifest.keyDataPath);

        DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(
                new DirectKmsMaterialsProvider(
                        kmsClient,
                        keyDataMap.get("awsKmsUsWest2").keyId
                )
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
}
