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
import java.util.List;
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
import software.amazon.cryptography.materialproviders.model.DecryptionMaterials;
import software.amazon.cryptography.materialproviders.model.EncryptedDataKey;
import software.amazon.cryptography.materialproviders.model.EncryptionMaterials;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsInput;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsOutput;

/**
 * End-to-end encrypt → decrypt round-trip tests.
 */
class EncryptDecryptRoundTripTest {

    @Test
    void testBasicRoundTrip() {
        DynamoDbItemEncryptor enc = createEncryptor();

        Map<String, AttributeValue> original = new LinkedHashMap<>();
        original.put("pk", AttributeValue.fromS("user123"));
        original.put("sk", AttributeValue.fromN("42"));
        original.put("name", AttributeValue.fromS("Alice"));
        original.put("data", AttributeValue.fromS("secret-data"));

        Map<String, AttributeValue> encrypted = enc.encryptItem(original);

        // Verify encrypted
        assertNotNull(encrypted.get("aws_dbe_head"));
        assertNotNull(encrypted.get("name").b()); // "name" is ENCRYPT_AND_SIGN → Binary

        // Decrypt
        Map<String, AttributeValue> decrypted = enc.decryptItem(encrypted);

        // Verify round-trip
        assertEquals(original.get("pk").s(), decrypted.get("pk").s());
        assertEquals(original.get("sk").n(), decrypted.get("sk").n());
        assertEquals(original.get("name").s(), decrypted.get("name").s());
        assertEquals(original.get("data").s(), decrypted.get("data").s());
    }

    @Test
    void testRoundTripWithMultipleEncryptedFields() {
        DynamoDbItemEncryptor enc = createEncryptor();

        Map<String, AttributeValue> original = new LinkedHashMap<>();
        original.put("pk", AttributeValue.fromS("id1"));
        original.put("sk", AttributeValue.fromN("1"));
        original.put("name", AttributeValue.fromS("Bob"));
        original.put("data", AttributeValue.fromB(SdkBytes.fromByteArray(new byte[]{1, 2, 3})));

        Map<String, AttributeValue> encrypted = enc.encryptItem(original);
        Map<String, AttributeValue> decrypted = enc.decryptItem(encrypted);

        assertEquals("id1", decrypted.get("pk").s());
        assertEquals("1", decrypted.get("sk").n());
        assertEquals("Bob", decrypted.get("name").s());
        assertArrayEquals(new byte[]{1, 2, 3}, decrypted.get("data").b().asByteArray());
    }

    @Test
    void testRoundTripWithBoolean() {
        DynamoDbItemEncryptor enc = createEncryptor();

        Map<String, AttributeValue> original = new LinkedHashMap<>();
        original.put("pk", AttributeValue.fromS("id"));
        original.put("sk", AttributeValue.fromN("1"));
        original.put("name", AttributeValue.fromBool(true));
        original.put("data", AttributeValue.fromNul(true));

        Map<String, AttributeValue> encrypted = enc.encryptItem(original);
        Map<String, AttributeValue> decrypted = enc.decryptItem(encrypted);

        assertTrue(decrypted.get("name").bool());
        assertTrue(decrypted.get("data").nul());
    }

    @Test
    void testDecryptRejectsPlaintextItem() {
        DynamoDbItemEncryptor enc = createEncryptor();

        Map<String, AttributeValue> plaintext = new LinkedHashMap<>();
        plaintext.put("pk", AttributeValue.fromS("id"));
        plaintext.put("sk", AttributeValue.fromN("1"));
        plaintext.put("name", AttributeValue.fromS("Alice"));

        assertThrows(DbeException.class, () -> enc.decryptItem(plaintext));
    }

    @Test
    void testDecryptRejectsTamperedCiphertext() {
        DynamoDbItemEncryptor enc = createEncryptor();

        Map<String, AttributeValue> original = new LinkedHashMap<>();
        original.put("pk", AttributeValue.fromS("id"));
        original.put("sk", AttributeValue.fromN("1"));
        original.put("name", AttributeValue.fromS("Alice"));
        original.put("data", AttributeValue.fromS("secret"));

        Map<String, AttributeValue> encrypted = enc.encryptItem(original);

        // Tamper with encrypted data
        byte[] tampered = encrypted.get("data").b().asByteArray().clone();
        tampered[tampered.length - 1] ^= 0x01; // flip a bit in the auth tag
        Map<String, AttributeValue> tamperedItem = new LinkedHashMap<>(encrypted);
        tamperedItem.put("data", AttributeValue.fromB(SdkBytes.fromByteArray(tampered)));

        assertThrows(Exception.class, () -> enc.decryptItem(tamperedItem));
    }

    // ---- Helper ----

    private static DynamoDbItemEncryptor createEncryptor() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("sk", CryptoAction.SIGN_ONLY);
        actions.put("name", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("data", CryptoAction.ENCRYPT_AND_SIGN);

        return DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("TestTable")
                .partitionKeyName("pk")
                .sortKeyName("sk")
                .attributeActionsOnEncrypt(actions)
                .cmm(new RoundTripCMM())
                .build());
    }

    /**
     * A CMM that supports both encrypt and decrypt with a fixed key.
     * This simulates a real keyring that can unwrap the data key.
     */
    static class RoundTripCMM implements ICryptographicMaterialsManager {
        // Fixed key for testing round-trips
        private static final byte[] FIXED_DATA_KEY = new byte[32];
        private static final byte[] FIXED_SIGNING_KEY = new byte[32];
        static {
            new SecureRandom().nextBytes(FIXED_DATA_KEY);
            new SecureRandom().nextBytes(FIXED_SIGNING_KEY);
        }

        @Override
        public GetEncryptionMaterialsOutput GetEncryptionMaterials(GetEncryptionMaterialsInput input) {
            EncryptedDataKey edk = EncryptedDataKey.builder()
                .keyProviderId("mock")
                .keyProviderInfo(ByteBuffer.wrap("info".getBytes(StandardCharsets.UTF_8)))
                .ciphertext(ByteBuffer.wrap(FIXED_DATA_KEY)) // "encrypted" key = plaintext for mock
                .build();

            AlgorithmSuiteInfo suite = buildSuiteInfo();

            return GetEncryptionMaterialsOutput.builder().encryptionMaterials(
                EncryptionMaterials.builder()
                    .algorithmSuite(suite)
                    .encryptionContext(input.encryptionContext() != null ? input.encryptionContext() : new HashMap<String, String>())
                    .encryptedDataKeys(Collections.singletonList(edk))
                    .requiredEncryptionContextKeys(Collections.<String>emptyList())
                    .plaintextDataKey(ByteBuffer.wrap(FIXED_DATA_KEY))
                    .symmetricSigningKeys(Collections.singletonList(ByteBuffer.wrap(FIXED_SIGNING_KEY)))
                    .build()
            ).build();
        }

        @Override
        public DecryptMaterialsOutput DecryptMaterials(DecryptMaterialsInput input) {
            AlgorithmSuiteInfo suite = buildSuiteInfo();

            return DecryptMaterialsOutput.builder().decryptionMaterials(
                DecryptionMaterials.builder()
                    .algorithmSuite(suite)
                    .encryptionContext(input.encryptionContext() != null ? input.encryptionContext() : new HashMap<String, String>())
                    .requiredEncryptionContextKeys(Collections.<String>emptyList())
                    .plaintextDataKey(ByteBuffer.wrap(FIXED_DATA_KEY))
                    .symmetricSigningKey(ByteBuffer.wrap(FIXED_SIGNING_KEY))
                    .build()
            ).build();
        }

        private static AlgorithmSuiteInfo buildSuiteInfo() {
            return AlgorithmSuiteInfo.builder()
                .id(AlgorithmSuiteId.builder().DBE(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384).build())
                .binaryId(ByteBuffer.wrap(new byte[]{0x67, 0x00})).messageVersion(2)
                .encrypt(software.amazon.cryptography.materialproviders.model.Encrypt.builder()
                    .AES_GCM(software.amazon.cryptography.primitives.model.AES_GCM.builder().keyLength(32).tagLength(16).ivLength(12).build()).build())
                .kdf(software.amazon.cryptography.materialproviders.model.DerivationAlgorithm.builder()
                    .HKDF(software.amazon.cryptography.materialproviders.model.HKDF.builder().hmac(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_512).saltLength(0).inputKeyLength(32).outputKeyLength(32).build()).build())
                .commitment(software.amazon.cryptography.materialproviders.model.DerivationAlgorithm.builder()
                    .HKDF(software.amazon.cryptography.materialproviders.model.HKDF.builder().hmac(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_512).saltLength(0).inputKeyLength(32).outputKeyLength(32).build()).build())
                .signature(software.amazon.cryptography.materialproviders.model.SignatureAlgorithm.builder()
                    .None(software.amazon.cryptography.materialproviders.model.None.builder().build()).build())
                .symmetricSignature(software.amazon.cryptography.materialproviders.model.SymmetricSignatureAlgorithm.builder()
                    .HMAC(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_384).build())
                .edkWrapping(software.amazon.cryptography.materialproviders.model.EdkWrappingAlgorithm.builder()
                    .DIRECT_KEY_WRAPPING(software.amazon.cryptography.materialproviders.model.DIRECT_KEY_WRAPPING.builder().build()).build())
                .build();
        }
    }
}
