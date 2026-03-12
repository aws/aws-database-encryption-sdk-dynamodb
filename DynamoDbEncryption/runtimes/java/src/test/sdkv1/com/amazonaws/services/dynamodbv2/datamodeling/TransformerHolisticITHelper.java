package com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionContext;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;

import static com.amazonaws.services.dynamodbv2.datamodeling.LegacyTestVectors.baseClassToV1AttrMap;
import static com.amazonaws.services.dynamodbv2.datamodeling.TransformerHolisticIT.ENCRYPTED_TEST_VALUE;
import static com.amazonaws.services.dynamodbv2.datamodeling.TransformerHolisticIT.symProv;
import static com.amazonaws.services.dynamodbv2.datamodeling.TransformerHolisticIT.getCiphertextManifestFromFile;
import static com.amazonaws.services.dynamodbv2.datamodeling.TransformerHolisticIT.BASE_CLASS_TABLE_NAME;
import static com.amazonaws.services.dynamodbv2.datamodeling.TransformerHolisticIT.SCENARIO_MANIFEST_PATH;
import static com.amazonaws.services.dynamodbv2.datamodeling.TransformerHolisticIT.loadKeyData;
import static com.amazonaws.services.dynamodbv2.datamodeling.TransformerHolisticIT.kmsClient;
import static com.amazonaws.services.dynamodbv2.datamodeling.TransformerHolisticIT.keyDataMap;
import static com.amazonaws.services.dynamodbv2.datamodeling.TransformerHolisticIT.getManifestFromFile;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TransformerHolisticITHelper {
    private static void decryptNullTableNameInEC(String nullTableNameInECCipherFile)
            throws IOException, GeneralSecurityException {
        DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(symProv);
        EncryptionContext ctx = new EncryptionContext.Builder()
                .withTableName(null)
                .withHashKeyName("hashKey")
                .withRangeKeyName("rangeKey")
                .build();

        Map<String, AttributeValue> expectedAttrMap = baseClassToV1AttrMap(
                ENCRYPTED_TEST_VALUE
        );
        Map<String, Set<EncryptionFlags>> actions = new HashMap<>();
        for (String attr : expectedAttrMap.keySet()) {
            switch (attr) {
                case "hashKey":
                case "rangeKey":
                case "version":
                    actions.put(attr, EnumSet.of(EncryptionFlags.SIGN));
                    break;
                default:
                    actions.put(
                            attr,
                            EnumSet.of(EncryptionFlags.ENCRYPT, EncryptionFlags.SIGN)
                    );
                    break;
            }
        }

        Map<String, List<Map<String, AttributeValue>>> manifest =
                getCiphertextManifestFromFile(nullTableNameInECCipherFile);

        for (Map<String, AttributeValue> encryptedItem : manifest.get(
                BASE_CLASS_TABLE_NAME
        )) {
            Map<String, AttributeValue> decrypted = encryptor.decryptRecord(
                    encryptedItem,
                    actions,
                    ctx
            );
            assertTrue(
                    new com.amazonaws.services.dynamodbv2.testing.DdbRecordMatcher(expectedAttrMap, false).matches(decrypted)
            );
        }
    }

    private static void decryptNonBmpHashKeyVector(String nonBMPinECCipherFile)
            throws IOException, GeneralSecurityException {
        com.amazonaws.services.dynamodbv2.testing.ScenarioManifest scenarioManifest = getManifestFromFile(
                SCENARIO_MANIFEST_PATH,
                new TypeReference<com.amazonaws.services.dynamodbv2.testing.ScenarioManifest>() {}
        );
        loadKeyData(scenarioManifest.keyDataPath);

        DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(
                new DirectKmsMaterialProvider(
                        kmsClient,
                        keyDataMap.get("awsKmsUsWest2").keyId
                )
        );
        EncryptionContext ctx = new EncryptionContext.Builder()
                .withTableName("HashKeyOnly")
                .withHashKeyName("hashKey")
                .build();

        Map<String, Set<EncryptionFlags>> actions = new HashMap<>();
        actions.put("hashKey", EnumSet.of(EncryptionFlags.SIGN));

        String nonBmpKey = "test\uD83D\uDE00Ψkey";
        Map<String, List<Map<String, AttributeValue>>> manifest =
                getCiphertextManifestFromFile(nonBMPinECCipherFile);
        for (Map<String, AttributeValue> encryptedItem : manifest.get(
                BASE_CLASS_TABLE_NAME
        )) {
            Map<String, AttributeValue> decrypted = encryptor.decryptRecord(
                    encryptedItem,
                    actions,
                    ctx
            );
            assertEquals(nonBmpKey, decrypted.get("hashKey").getS());
        }
    }

    private static void decryptNonAsciiTableNameVector(
            String nonAsciiTableInECCipherFile
    ) throws IOException, GeneralSecurityException {
        DynamoDBEncryptor encryptor = DynamoDBEncryptor.getInstance(symProv);
        com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionContext ctx =
                new com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionContext.Builder()
                        .withTableName("テーブル\uD83D\uDE00")
                        .withHashKeyName("hashKey")
                        .withRangeKeyName("rangeKey")
                        .build();

        Map<String, AttributeValue> expectedAttrMap = baseClassToV1AttrMap(
                ENCRYPTED_TEST_VALUE
        );
        Map<
                String,
                Set<
                        com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags
                        >
                > actions = new HashMap<>();
        for (String attr : expectedAttrMap.keySet()) {
            switch (attr) {
                case "hashKey":
                case "rangeKey":
                case "version":
                    actions.put(
                            attr,
                            EnumSet.of(
                                    com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags.SIGN
                            )
                    );
                    break;
                default:
                    actions.put(
                            attr,
                            EnumSet.of(
                                    com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags.ENCRYPT,
                                    com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags.SIGN
                            )
                    );
                    break;
            }
        }
    }
}
