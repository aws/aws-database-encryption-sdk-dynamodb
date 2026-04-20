// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.AesWrappingAlg;
import software.amazon.cryptography.materialproviders.model.CreateDefaultCryptographicMaterialsManagerInput;
import software.amazon.cryptography.materialproviders.model.CreateRawAesKeyringInput;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/**
 * Integration test using a real MPL Raw AES Keyring.
 * This validates the full crypto chain with the actual MPL implementation
 * instead of a mock CMM.
 *
 * <p>Run with: ./gradlew test --tests "*MplKeyringIntegrationTest"
 *
 * <p>No AWS credentials required — uses a local raw AES key.
 */
class MplKeyringIntegrationTest {

    private static MaterialProviders matProv;
    private static IKeyring keyring;
    private static ICryptographicMaterialsManager cmm;

    @BeforeAll
    static void setup() {
        matProv = MaterialProviders.builder()
            .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
            .build();

        // Create a raw AES-256 keyring (no KMS needed)
        byte[] aesKey = new byte[32];
        Arrays.fill(aesKey, (byte) 0x42);
        keyring = matProv.CreateRawAesKeyring(
            CreateRawAesKeyringInput.builder()
                .keyName("test-key")
                .keyNamespace("test-namespace")
                .wrappingAlg(AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16)
                .wrappingKey(ByteBuffer.wrap(aesKey))
                .build());

        cmm = matProv.CreateDefaultCryptographicMaterialsManager(
            CreateDefaultCryptographicMaterialsManagerInput.builder()
                .keyring(keyring)
                .build());
    }

    @Test
    void testRoundTripWithRealMplKeyring() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("sk", CryptoAction.SIGN_ONLY);
        actions.put("secret", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("data", CryptoAction.ENCRYPT_AND_SIGN);

        DynamoDbItemEncryptor encryptor = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("IntegrationTestTable")
                .partitionKeyName("pk")
                .sortKeyName("sk")
                .attributeActionsOnEncrypt(actions)
                .cmm(cmm)
                .algorithmSuiteId(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384)
                .build());

        Map<String, AttributeValue> original = new LinkedHashMap<>();
        original.put("pk", AttributeValue.fromS("user-123"));
        original.put("sk", AttributeValue.fromN("42"));
        original.put("secret", AttributeValue.fromS("my-secret-value"));
        original.put("data", AttributeValue.fromB(SdkBytes.fromByteArray(new byte[]{1, 2, 3, 4, 5})));

        // Encrypt with real MPL keyring
        Map<String, AttributeValue> encrypted = encryptor.encryptItem(original);

        // Verify encrypted structure
        assertTrue(encrypted.containsKey("aws_dbe_head"));
        assertTrue(encrypted.containsKey("aws_dbe_foot"));
        assertEquals("user-123", encrypted.get("pk").s());
        assertEquals("42", encrypted.get("sk").n());
        assertNotNull(encrypted.get("secret").b());
        assertNotNull(encrypted.get("data").b());

        // Decrypt with real MPL keyring
        Map<String, AttributeValue> decrypted = encryptor.decryptItem(encrypted);

        assertEquals("user-123", decrypted.get("pk").s());
        assertEquals("42", decrypted.get("sk").n());
        assertEquals("my-secret-value", decrypted.get("secret").s());
        assertArrayEquals(new byte[]{1, 2, 3, 4, 5}, decrypted.get("data").b().asByteArray());
    }

    @Test
    void testRoundTripAllTypes() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("str", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("num", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("bool", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("nul", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("bin", CryptoAction.ENCRYPT_AND_SIGN);

        DynamoDbItemEncryptor encryptor = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("AllTypesTable")
                .partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions)
                .cmm(cmm)
                .algorithmSuiteId(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384)
                .build());

        Map<String, AttributeValue> original = new LinkedHashMap<>();
        original.put("pk", AttributeValue.fromS("id"));
        original.put("str", AttributeValue.fromS("hello world"));
        original.put("num", AttributeValue.fromN("123.456"));
        original.put("bool", AttributeValue.fromBool(true));
        original.put("nul", AttributeValue.fromNul(true));
        original.put("bin", AttributeValue.fromB(SdkBytes.fromByteArray(new byte[]{0, 127, (byte) 255})));

        Map<String, AttributeValue> encrypted = encryptor.encryptItem(original);
        Map<String, AttributeValue> decrypted = encryptor.decryptItem(encrypted);

        assertEquals("hello world", decrypted.get("str").s());
        assertEquals("123.456", decrypted.get("num").n());
        assertTrue(decrypted.get("bool").bool());
        assertTrue(decrypted.get("nul").nul());
        assertArrayEquals(new byte[]{0, 127, (byte) 255}, decrypted.get("bin").b().asByteArray());
    }

    @Test
    void testTamperDetectionWithRealKeyring() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("secret", CryptoAction.ENCRYPT_AND_SIGN);

        DynamoDbItemEncryptor encryptor = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("TamperTable")
                .partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions)
                .cmm(cmm)
                .algorithmSuiteId(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384)
                .build());

        Map<String, AttributeValue> original = new LinkedHashMap<>();
        original.put("pk", AttributeValue.fromS("id"));
        original.put("secret", AttributeValue.fromS("sensitive"));

        Map<String, AttributeValue> encrypted = encryptor.encryptItem(original);

        // Tamper with ciphertext
        byte[] tampered = encrypted.get("secret").b().asByteArray().clone();
        tampered[tampered.length - 1] ^= 0x01;
        Map<String, AttributeValue> tamperedItem = new LinkedHashMap<>(encrypted);
        tamperedItem.put("secret", AttributeValue.fromB(SdkBytes.fromByteArray(tampered)));

        assertThrows(Exception.class, () -> encryptor.decryptItem(tamperedItem));
    }

    @Test
    void testDifferentKeyCantDecrypt() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("secret", CryptoAction.ENCRYPT_AND_SIGN);

        // Encrypt with key1
        DynamoDbItemEncryptor enc1 = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("KeyTable")
                .partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions)
                .cmm(cmm)
                .algorithmSuiteId(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384)
                .build());

        Map<String, AttributeValue> original = new LinkedHashMap<>();
        original.put("pk", AttributeValue.fromS("id"));
        original.put("secret", AttributeValue.fromS("data"));

        Map<String, AttributeValue> encrypted = enc1.encryptItem(original);

        // Try to decrypt with a different key
        byte[] differentKey = new byte[32];
        Arrays.fill(differentKey, (byte) 0x99);
        IKeyring keyring2 = matProv.CreateRawAesKeyring(
            CreateRawAesKeyringInput.builder()
                .keyName("other-key")
                .keyNamespace("test-namespace")
                .wrappingAlg(AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16)
                .wrappingKey(ByteBuffer.wrap(differentKey))
                .build());
        ICryptographicMaterialsManager cmm2 = matProv.CreateDefaultCryptographicMaterialsManager(
            CreateDefaultCryptographicMaterialsManagerInput.builder()
                .keyring(keyring2).build());

        DynamoDbItemEncryptor enc2 = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("KeyTable")
                .partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions)
                .cmm(cmm2)
                .algorithmSuiteId(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384)
                .build());

        assertThrows(Exception.class, () -> enc2.decryptItem(encrypted));
    }
}
