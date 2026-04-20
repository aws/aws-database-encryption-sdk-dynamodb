// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.model.AlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.AlgorithmSuiteInfo;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.DBECommitmentPolicy;
import software.amazon.cryptography.materialproviders.model.CommitmentPolicy;
import software.amazon.cryptography.materialproviders.model.DecryptMaterialsInput;
import software.amazon.cryptography.materialproviders.model.DecryptMaterialsOutput;
import software.amazon.cryptography.materialproviders.model.EncryptedDataKey;
import software.amazon.cryptography.materialproviders.model.EncryptionMaterials;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsInput;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsOutput;

class DynamoDbItemEncryptorTest {

    // ---- Config Validation ----

    @Test
    void testValidConfigV1() {
        DynamoDbItemEncryptor enc = createV1Encryptor();
        assertEquals(1, enc.getConfig().getVersion());
    }

    @Test
    void testValidConfigV2() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT);
        actions.put("data", CryptoAction.ENCRYPT_AND_SIGN);

        DynamoDbItemEncryptor enc = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("table")
                .partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions)
                .cmm(new MockCMM())
                .build());
        assertEquals(2, enc.getConfig().getVersion());
    }

    @Test
    void testRejectsWrongPartitionKeyAction() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.ENCRYPT_AND_SIGN); // Wrong! Must be SIGN_ONLY for v1
        actions.put("data", CryptoAction.ENCRYPT_AND_SIGN);

        assertThrows(DbeException.class, () -> DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("t").partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions).cmm(new MockCMM()).build()));
    }

    @Test
    void testRejectsReservedPrefix() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("aws_dbe_bad", CryptoAction.SIGN_ONLY);

        assertThrows(DbeException.class, () -> DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("t").partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions).cmm(new MockCMM()).build()));
    }

    @Test
    void testRejectsDoNothingNotInAllowedUnsigned() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("unsigned", CryptoAction.DO_NOTHING); // Not in allowed list

        assertThrows(DbeException.class, () -> DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("t").partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions).cmm(new MockCMM()).build()));
    }

    @Test
    void testAcceptsDoNothingInAllowedUnsigned() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("unsigned", CryptoAction.DO_NOTHING);

        DynamoDbItemEncryptor enc = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("t").partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions).cmm(new MockCMM())
                .allowedUnsignedAttributes(Arrays.asList("unsigned"))
                .build());
        assertNotNull(enc);
    }

    @Test
    void testAcceptsDoNothingWithPrefix() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put(":unsigned", CryptoAction.DO_NOTHING);

        DynamoDbItemEncryptor enc = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("t").partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions).cmm(new MockCMM())
                .allowedUnsignedAttributePrefix(":")
                .build());
        assertNotNull(enc);
    }

    // ---- Encryption Context ----

    @Test
    void testEncryptionContextV1() {
        DynamoDbItemEncryptor enc = createV1Encryptor();
        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("user123"));
        item.put("sk", AttributeValue.fromN("42"));
        item.put("data", AttributeValue.fromS("secret"));

        Map<String, String> ec = enc.buildEncryptionContext(item);

        assertEquals("myTable", ec.get("aws-crypto-table-name"));
        assertEquals("pk", ec.get("aws-crypto-partition-name"));
        assertEquals("sk", ec.get("aws-crypto-sort-name"));
        // V1 includes key values
        assertTrue(ec.containsKey("aws-crypto-attr.pk"));
        assertTrue(ec.containsKey("aws-crypto-attr.sk"));
    }

    @Test
    void testEncryptionContextV2() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT);
        actions.put("data", CryptoAction.ENCRYPT_AND_SIGN);

        DynamoDbItemEncryptor enc = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("myTable").partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions).cmm(new MockCMM()).build());

        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("user123"));
        item.put("data", AttributeValue.fromS("secret"));

        Map<String, String> ec = enc.buildEncryptionContext(item);

        assertEquals("myTable", ec.get("aws-crypto-table-name"));
        assertEquals("pk", ec.get("aws-crypto-partition-name"));
        // V2 does NOT include key values in base context
        assertFalse(ec.containsKey("aws-crypto-attr.pk"));
    }

    // ---- EncryptItem ----

    @Test
    void testEncryptItemBasic() {
        DynamoDbItemEncryptor enc = createV1Encryptor();

        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("user123"));
        item.put("sk", AttributeValue.fromN("1"));
        item.put("data", AttributeValue.fromS("secret"));

        Map<String, AttributeValue> encrypted = enc.encryptItem(item);

        // Should have: pk, sk (unchanged), data (encrypted), aws_dbe_head, aws_dbe_foot
        assertTrue(encrypted.containsKey("pk"));
        assertTrue(encrypted.containsKey("sk"));
        assertTrue(encrypted.containsKey("data"));
        assertTrue(encrypted.containsKey("aws_dbe_head"));
        assertTrue(encrypted.containsKey("aws_dbe_foot"));

        // pk and sk should be unchanged (SIGN_ONLY)
        assertEquals("user123", encrypted.get("pk").s());
        assertEquals("1", encrypted.get("sk").n());

        // data should be encrypted (Binary type)
        assertNotNull(encrypted.get("data").b());
        assertNull(encrypted.get("data").s());

        // Header and footer should be Binary
        assertNotNull(encrypted.get("aws_dbe_head").b());
        assertNotNull(encrypted.get("aws_dbe_foot").b());
    }

    @Test
    void testEncryptItemMissingPartitionKey() {
        DynamoDbItemEncryptor enc = createV1Encryptor();
        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("data", AttributeValue.fromS("secret"));

        assertThrows(DbeException.class, () -> enc.encryptItem(item));
    }

    @Test
    void testEncryptItemWithDoNothing() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("data", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("meta", CryptoAction.DO_NOTHING);

        DynamoDbItemEncryptor enc = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("t").partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions).cmm(new MockCMM())
                .allowedUnsignedAttributes(Arrays.asList("meta"))
                .build());

        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("id1"));
        item.put("data", AttributeValue.fromS("secret"));
        item.put("meta", AttributeValue.fromS("not-signed"));

        Map<String, AttributeValue> encrypted = enc.encryptItem(item);

        // meta should pass through unchanged
        assertEquals("not-signed", encrypted.get("meta").s());
        // data should be encrypted
        assertNotNull(encrypted.get("data").b());
    }

    @Test
    void testEncryptItemNonDeterministic() {
        DynamoDbItemEncryptor enc = createV1Encryptor();
        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("id"));
        item.put("sk", AttributeValue.fromN("1"));
        item.put("data", AttributeValue.fromS("secret"));

        Map<String, AttributeValue> enc1 = enc.encryptItem(item);
        Map<String, AttributeValue> enc2 = enc.encryptItem(item);

        // Different message IDs → different ciphertexts
        assertFalse(Arrays.equals(
            enc1.get("data").b().asByteArray(),
            enc2.get("data").b().asByteArray()));
    }

    // ---- Helpers ----

    private static DynamoDbItemEncryptor createV1Encryptor() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("sk", CryptoAction.SIGN_ONLY);
        actions.put("data", CryptoAction.ENCRYPT_AND_SIGN);

        return DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("myTable")
                .partitionKeyName("pk")
                .sortKeyName("sk")
                .attributeActionsOnEncrypt(actions)
                .cmm(new MockCMM())
                .build());
    }

    static class MockCMM implements ICryptographicMaterialsManager {
        @Override
        public GetEncryptionMaterialsOutput GetEncryptionMaterials(GetEncryptionMaterialsInput input) {
            byte[] dataKey = new byte[32];
            new SecureRandom().nextBytes(dataKey);
            byte[] sigKey = new byte[32];
            new SecureRandom().nextBytes(sigKey);

            EncryptedDataKey edk = EncryptedDataKey.builder()
                .keyProviderId("mock")
                .keyProviderInfo(ByteBuffer.wrap("info".getBytes(StandardCharsets.UTF_8)))
                .ciphertext(ByteBuffer.wrap(new byte[]{1, 2, 3}))
                .build();

            AlgorithmSuiteInfo suite = AlgorithmSuiteInfo.builder()
                .id(AlgorithmSuiteId.builder()
                    .DBE(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384).build())
                .binaryId(ByteBuffer.wrap(new byte[]{0x67, 0x00}))
                .messageVersion(2)
                .encrypt(software.amazon.cryptography.materialproviders.model.Encrypt.builder()
                    .AES_GCM(software.amazon.cryptography.primitives.model.AES_GCM.builder()
                        .keyLength(32).tagLength(16).ivLength(12).build()).build())
                .kdf(software.amazon.cryptography.materialproviders.model.DerivationAlgorithm.builder()
                    .HKDF(software.amazon.cryptography.materialproviders.model.HKDF.builder()
                        .hmac(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_512)
                        .saltLength(0).inputKeyLength(32).outputKeyLength(32).build()).build())
                .commitment(software.amazon.cryptography.materialproviders.model.DerivationAlgorithm.builder()
                    .HKDF(software.amazon.cryptography.materialproviders.model.HKDF.builder()
                        .hmac(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_512)
                        .saltLength(0).inputKeyLength(32).outputKeyLength(32).build()).build())
                .signature(software.amazon.cryptography.materialproviders.model.SignatureAlgorithm.builder()
                    .None(software.amazon.cryptography.materialproviders.model.None.builder().build()).build())
                .symmetricSignature(software.amazon.cryptography.materialproviders.model.SymmetricSignatureAlgorithm.builder()
                    .HMAC(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_384).build())
                .edkWrapping(software.amazon.cryptography.materialproviders.model.EdkWrappingAlgorithm.builder()
                    .DIRECT_KEY_WRAPPING(software.amazon.cryptography.materialproviders.model.DIRECT_KEY_WRAPPING.builder().build()).build())
                .build();

            EncryptionMaterials mat = EncryptionMaterials.builder()
                .algorithmSuite(suite)
                .encryptionContext(input.encryptionContext() != null ? input.encryptionContext() : new HashMap<String, String>())
                .encryptedDataKeys(Collections.singletonList(edk))
                .requiredEncryptionContextKeys(Collections.<String>emptyList())
                .plaintextDataKey(ByteBuffer.wrap(dataKey))
                .symmetricSigningKeys(Collections.singletonList(ByteBuffer.wrap(sigKey)))
                .build();

            return GetEncryptionMaterialsOutput.builder().encryptionMaterials(mat).build();
        }

        @Override
        public DecryptMaterialsOutput DecryptMaterials(DecryptMaterialsInput input) {
            throw new UnsupportedOperationException();
        }
    }
}
