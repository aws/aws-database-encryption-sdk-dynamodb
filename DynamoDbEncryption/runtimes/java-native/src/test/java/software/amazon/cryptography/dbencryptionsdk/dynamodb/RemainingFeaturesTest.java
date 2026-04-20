// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb;

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
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedClientEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedClientEncryption.*;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.searchable.ExpressionRewriter;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.searchable.StandardBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.DdbTransforms;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.model.*;

class RemainingFeaturesTest {

    private static final byte[] BEACON_KEY = "beacon-key-for-testing-32-bytes!".getBytes(StandardCharsets.UTF_8);

    // ---- Plaintext Policy ----

    @Test
    void testForcePlaintextWritePassesThrough() {
        DynamoDbItemEncryptor enc = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("t").partitionKeyName("pk")
                .attributeActionsOnEncrypt(Collections.singletonMap("pk", CryptoAction.SIGN_ONLY))
                .cmm(new MockCMM())
                .plaintextPolicy(DynamoDbItemEncryptorConfig.PlaintextPolicy.FORCE_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ)
                .build());

        Map<String, AttributeValue> item = Collections.singletonMap("pk", AttributeValue.fromS("id"));
        Map<String, AttributeValue> result = enc.encryptItem(item);

        // Should pass through unchanged — no encryption
        assertFalse(result.containsKey("aws_dbe_head"));
        assertEquals("id", result.get("pk").s());
    }

    @Test
    void testAllowPlaintextReadAcceptsPlaintextItem() {
        DynamoDbItemEncryptor enc = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("t").partitionKeyName("pk")
                .attributeActionsOnEncrypt(Collections.singletonMap("pk", CryptoAction.SIGN_ONLY))
                .cmm(new MockCMM())
                .plaintextPolicy(DynamoDbItemEncryptorConfig.PlaintextPolicy.FORBID_PLAINTEXT_WRITE_ALLOW_PLAINTEXT_READ)
                .build());

        Map<String, AttributeValue> plainItem = Collections.singletonMap("pk", AttributeValue.fromS("id"));
        // Should not throw — plaintext reads allowed
        Map<String, AttributeValue> result = enc.decryptItem(plainItem);
        assertEquals("id", result.get("pk").s());
    }

    @Test
    void testForbidPlaintextReadRejectsPlaintextItem() {
        DynamoDbItemEncryptor enc = DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("t").partitionKeyName("pk")
                .attributeActionsOnEncrypt(Collections.singletonMap("pk", CryptoAction.SIGN_ONLY))
                .cmm(new MockCMM())
                .plaintextPolicy(DynamoDbItemEncryptorConfig.PlaintextPolicy.FORBID_PLAINTEXT_WRITE_FORBID_PLAINTEXT_READ)
                .build());

        Map<String, AttributeValue> plainItem = Collections.singletonMap("pk", AttributeValue.fromS("id"));
        assertThrows(DbeException.class, () -> enc.decryptItem(plainItem));
    }

    // ---- Expression Rewriting ----

    @Test
    void testExpressionRewriteWithNamePlaceholder() {
        Map<String, StandardBeacon> beacons = new HashMap<>();
        beacons.put("zipcode", new StandardBeacon("zipcode", "zipcode", 16));

        Map<String, String> names = new HashMap<>();
        names.put("#z", "zipcode");
        Map<String, AttributeValue> values = new HashMap<>();
        values.put(":v", AttributeValue.fromS("12345"));

        ExpressionRewriter.RewriteResult result = ExpressionRewriter.rewrite(
            "#z = :v", names, values, beacons, BEACON_KEY);

        // Name should be rewritten to beacon attribute
        assertEquals("aws_dbe_b_zipcode", result.getExpressionAttributeNames().get("#z"));
        // Value should be rewritten to beacon value
        String beaconVal = result.getExpressionAttributeValues().get(":v").s();
        assertNotNull(beaconVal);
        assertEquals(4, beaconVal.length()); // 16 bits → 4 hex chars
        assertNotEquals("12345", beaconVal);
    }

    @Test
    void testExpressionRewriteDirectFieldName() {
        Map<String, StandardBeacon> beacons = new HashMap<>();
        beacons.put("zipcode", new StandardBeacon("zipcode", "zipcode", 16));

        ExpressionRewriter.RewriteResult result = ExpressionRewriter.rewrite(
            "zipcode = :v", null, new HashMap<String, AttributeValue>(), beacons, BEACON_KEY);

        // Direct field name should be replaced
        assertTrue(result.getExpression().contains("aws_dbe_b_zipcode"));
        assertFalse(result.getExpression().contains(" zipcode "));
    }

    @Test
    void testExpressionRewriteNullExpression() {
        ExpressionRewriter.RewriteResult result = ExpressionRewriter.rewrite(
            null, null, null, new HashMap<String, StandardBeacon>(), BEACON_KEY);
        assertNull(result.getExpression());
    }

    // ---- Enhanced Client Annotations ----

    // Test bean class
    public static class TestItem {
        private String pk;
        private String secret;
        private String status;
        private String meta;

        @DynamoDbEncryptionSignOnly
        public String getPk() { return pk; }
        public void setPk(String pk) { this.pk = pk; }

        @DynamoDbEncryptionEncryptAndSign
        public String getSecret() { return secret; }
        public void setSecret(String secret) { this.secret = secret; }

        @DynamoDbEncryptionSignOnly
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        @DynamoDbEncryptionDoNothing
        public String getMeta() { return meta; }
        public void setMeta(String meta) { this.meta = meta; }
    }

    @Test
    void testConfigFromAnnotatedClass() {
        DynamoDbItemEncryptorConfig config = DynamoDbEnhancedClientEncryption
            .configFromAnnotatedClass(TestItem.class, "TestTable", "pk", null, new MockCMM());

        assertEquals("TestTable", config.getLogicalTableName());
        assertEquals("pk", config.getPartitionKeyName());

        Map<String, CryptoAction> actions = config.getAttributeActionsOnEncrypt();
        assertEquals(CryptoAction.SIGN_ONLY, actions.get("pk"));
        assertEquals(CryptoAction.ENCRYPT_AND_SIGN, actions.get("secret"));
        assertEquals(CryptoAction.SIGN_ONLY, actions.get("status"));
        assertEquals(CryptoAction.DO_NOTHING, actions.get("meta"));
    }

    // ---- PartiQL ----

    @Test
    void testExtractTableNameFromSelect() {
        assertEquals("MyTable", DdbTransforms.extractTableName("SELECT * FROM MyTable WHERE pk = 'x'"));
    }

    @Test
    void testExtractTableNameFromInsert() {
        assertEquals("MyTable", DdbTransforms.extractTableName("INSERT INTO MyTable VALUE {'pk': 'x'}"));
    }

    @Test
    void testExtractTableNameFromUpdate() {
        assertEquals("MyTable", DdbTransforms.extractTableName("UPDATE MyTable SET x = 1 WHERE pk = 'x'"));
    }

    @Test
    void testExtractTableNameQuoted() {
        assertEquals("My Table", DdbTransforms.extractTableName("SELECT * FROM \"My Table\""));
    }

    // ---- Mock CMM ----

    static class MockCMM implements ICryptographicMaterialsManager {
        @Override
        public GetEncryptionMaterialsOutput GetEncryptionMaterials(GetEncryptionMaterialsInput input) {
            byte[] dk = new byte[32]; new SecureRandom().nextBytes(dk);
            byte[] sk = new byte[32]; new SecureRandom().nextBytes(sk);
            return GetEncryptionMaterialsOutput.builder().encryptionMaterials(
                EncryptionMaterials.builder()
                    .algorithmSuite(AlgorithmSuiteInfo.builder()
                        .id(AlgorithmSuiteId.builder().DBE(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384).build())
                        .binaryId(ByteBuffer.wrap(new byte[]{0x67, 0x00})).messageVersion(2)
                        .encrypt(software.amazon.cryptography.materialproviders.model.Encrypt.builder()
                            .AES_GCM(software.amazon.cryptography.primitives.model.AES_GCM.builder().keyLength(32).tagLength(16).ivLength(12).build()).build())
                        .kdf(DerivationAlgorithm.builder().HKDF(HKDF.builder().hmac(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_512).saltLength(0).inputKeyLength(32).outputKeyLength(32).build()).build())
                        .commitment(DerivationAlgorithm.builder().HKDF(HKDF.builder().hmac(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_512).saltLength(0).inputKeyLength(32).outputKeyLength(32).build()).build())
                        .signature(SignatureAlgorithm.builder().None(None.builder().build()).build())
                        .symmetricSignature(SymmetricSignatureAlgorithm.builder().HMAC(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_384).build())
                        .edkWrapping(EdkWrappingAlgorithm.builder().DIRECT_KEY_WRAPPING(DIRECT_KEY_WRAPPING.builder().build()).build())
                        .build())
                    .encryptionContext(input.encryptionContext() != null ? input.encryptionContext() : new HashMap<String, String>())
                    .encryptedDataKeys(Collections.singletonList(EncryptedDataKey.builder().keyProviderId("m").keyProviderInfo(ByteBuffer.wrap("i".getBytes())).ciphertext(ByteBuffer.wrap(dk)).build()))
                    .requiredEncryptionContextKeys(Collections.<String>emptyList())
                    .plaintextDataKey(ByteBuffer.wrap(dk))
                    .symmetricSigningKeys(Collections.singletonList(ByteBuffer.wrap(sk)))
                    .build()
            ).build();
        }

        @Override
        public DecryptMaterialsOutput DecryptMaterials(DecryptMaterialsInput input) {
            throw new UnsupportedOperationException();
        }
    }
}
