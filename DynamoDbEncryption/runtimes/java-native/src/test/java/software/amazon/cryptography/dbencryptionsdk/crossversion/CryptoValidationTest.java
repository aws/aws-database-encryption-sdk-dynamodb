// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.crossversion;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ddbconversion.AttributeSerializer;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.Canonize;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.Crypt;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.Footer;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.Header;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.model.AlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.AlgorithmSuiteInfo;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.DecryptMaterialsInput;
import software.amazon.cryptography.materialproviders.model.DecryptMaterialsOutput;
import software.amazon.cryptography.materialproviders.model.DecryptionMaterials;
import software.amazon.cryptography.materialproviders.model.EncryptedDataKey;
import software.amazon.cryptography.materialproviders.model.EncryptionMaterials;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsInput;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsOutput;

/**
 * Validates the crypto chain step-by-step to ensure correctness.
 * Uses fixed keys so results are reproducible and verifiable.
 */
class CryptoValidationTest {

    // Fixed keys for deterministic testing
    private static final byte[] FIXED_DATA_KEY = hexToBytes(
        "000102030405060708090a0b0c0d0e0f101112131415161718191a1b1c1d1e1f");
    private static final byte[] FIXED_SIGNING_KEY = hexToBytes(
        "202122232425262728292a2b2c2d2e2f303132333435363738393a3b3c3d3e3f");
    private static final byte[] FIXED_MSG_ID = hexToBytes(
        "aabbccdd00112233445566778899aabb" +
        "ccddeeff0011223344556677889900aa");

    // ---- Step 1: Key Derivation Known-Answer Tests ----

    @Test
    void testCommitKeyDerivation() {
        byte[] commitKey = Crypt.deriveCommitKey(FIXED_DATA_KEY, FIXED_MSG_ID);
        assertEquals(32, commitKey.length);
        // Verify deterministic
        assertArrayEquals(commitKey, Crypt.deriveCommitKey(FIXED_DATA_KEY, FIXED_MSG_ID));
        // Different msg ID → different key
        byte[] otherMsgId = new byte[32];
        otherMsgId[0] = 1;
        assertFalse(Arrays.equals(commitKey, Crypt.deriveCommitKey(FIXED_DATA_KEY, otherMsgId)));
    }

    @Test
    void testFieldRootKeyDerivation() {
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(FIXED_DATA_KEY, FIXED_MSG_ID);
        assertEquals(32, fieldRootKey.length);
        byte[] commitKey = Crypt.deriveCommitKey(FIXED_DATA_KEY, FIXED_MSG_ID);
        // Commit key and field root key must be different (different HKDF info labels)
        assertFalse(Arrays.equals(commitKey, fieldRootKey));
    }

    @Test
    void testFieldKeyDerivation() {
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(FIXED_DATA_KEY, FIXED_MSG_ID);
        byte[] fk0 = Crypt.deriveFieldKey(fieldRootKey, 0);
        byte[] fk1 = Crypt.deriveFieldKey(fieldRootKey, 1);
        assertEquals(44, fk0.length); // 32 cipher key + 12 nonce
        assertEquals(44, fk1.length);
        // Different offsets → different keys
        assertFalse(Arrays.equals(fk0, fk1));
        // Deterministic
        assertArrayEquals(fk0, Crypt.deriveFieldKey(fieldRootKey, 0));
    }

    // ---- Step 2: Canonical Path Verification ----

    @Test
    void testCanonicalPathFormat() {
        byte[] cp = Canonize.simpleCanon("MyTable", "pk");
        // Should be: UTF8("MyTable") + uint64(1) + 0x24 + uint64(2) + UTF8("pk")
        byte[] expected = concat(
            "MyTable".getBytes(StandardCharsets.UTF_8),
            longToBytes(1),  // depth
            new byte[]{0x24}, // MAP_TAG
            longToBytes(2),  // "pk" char length
            "pk".getBytes(StandardCharsets.UTF_8)
        );
        assertArrayEquals(expected, cp);
    }

    @Test
    void testCanonicalPathOrdering() {
        // "a" < "b" < "z" in canonical path ordering
        byte[] cpA = Canonize.simpleCanon("t", "a");
        byte[] cpB = Canonize.simpleCanon("t", "b");
        byte[] cpZ = Canonize.simpleCanon("t", "z");
        assertTrue(compareBytes(cpA, cpB) < 0);
        assertTrue(compareBytes(cpB, cpZ) < 0);
    }

    // ---- Step 3: Field Encryption Known-Answer ----

    @Test
    void testFieldEncryptionFormat() {
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(FIXED_DATA_KEY, FIXED_MSG_ID);
        byte[] canonPath = Canonize.simpleCanon("table", "secret");
        byte[] typeId = new byte[]{0x00, 0x01}; // String
        byte[] plaintext = "hello".getBytes(StandardCharsets.UTF_8);

        byte[] encrypted = Crypt.encryptField(fieldRootKey, 0, canonPath, typeId, plaintext);

        // Format: [2B typeId][ciphertext][16B authTag]
        // typeId should be the original
        assertEquals(0x00, encrypted[0]);
        assertEquals(0x01, encrypted[1]);
        // Total length: 2 + plaintext.length + 16 (auth tag)
        assertEquals(2 + plaintext.length + 16, encrypted.length);

        // Decrypt and verify
        byte[][] result = Crypt.decryptField(fieldRootKey, 0, canonPath, encrypted);
        assertArrayEquals(typeId, result[0]);
        assertArrayEquals(plaintext, result[1]);
    }

    @Test
    void testFieldEncryptionAADBinding() {
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(FIXED_DATA_KEY, FIXED_MSG_ID);
        byte[] canonPath1 = Canonize.simpleCanon("table", "field1");
        byte[] canonPath2 = Canonize.simpleCanon("table", "field2");
        byte[] typeId = new byte[]{0x00, 0x01};
        byte[] plaintext = "data".getBytes(StandardCharsets.UTF_8);

        // Encrypt with path1
        byte[] encrypted = Crypt.encryptField(fieldRootKey, 0, canonPath1, typeId, plaintext);

        // Decrypt with path1 should work
        byte[][] ok = Crypt.decryptField(fieldRootKey, 0, canonPath1, encrypted);
        assertArrayEquals(plaintext, ok[1]);

        // Decrypt with path2 should fail (AAD mismatch)
        assertThrows(Exception.class, () ->
            Crypt.decryptField(fieldRootKey, 0, canonPath2, encrypted));
    }

    // ---- Step 4: Header Commitment Verification ----

    @Test
    void testHeaderCommitmentIntegrity() {
        byte[] commitKey = Crypt.deriveCommitKey(FIXED_DATA_KEY, FIXED_MSG_ID);

        // Build a minimal partial header
        Header.PartialHeader ph = new Header.PartialHeader(
            (byte) 1, (byte) 0, FIXED_MSG_ID, new byte[]{0x65, 0x73},
            new LinkedHashMap<byte[], byte[]>(),
            Collections.singletonList(new Header.EncryptedDataKey(
                "mock".getBytes(), "info".getBytes(), new byte[]{1, 2, 3})));

        byte[] partialBytes = ph.serialize();
        byte[] commitment = Crypt.computeHeaderCommitment(commitKey, partialBytes);
        assertEquals(32, commitment.length);

        // Full header = partial + commitment
        byte[] fullHeader = concat(partialBytes, commitment);

        // Verification should pass
        assertTrue(Crypt.verifyHeaderCommitment(commitKey, fullHeader));

        // Tamper with partial header → verification should fail
        byte[] tampered = fullHeader.clone();
        tampered[5] ^= 0x01; // flip a bit in the message ID
        assertFalse(Crypt.verifyHeaderCommitment(commitKey, tampered));

        // Tamper with commitment → verification should fail
        byte[] tampered2 = fullHeader.clone();
        tampered2[fullHeader.length - 1] ^= 0x01;
        assertFalse(Crypt.verifyHeaderCommitment(commitKey, tampered2));

        // Wrong key → verification should fail
        byte[] wrongKey = new byte[32];
        wrongKey[0] = 1;
        assertFalse(Crypt.verifyHeaderCommitment(wrongKey, fullHeader));
    }

    // ---- Step 5: Footer HMAC Verification ----

    @Test
    void testFooterHmacIntegrity() {
        // Create a simple encrypted structure and verify footer
        List<Canonize.CanonField> fields = Arrays.asList(
            new Canonize.CanonField(
                Canonize.simpleCanon("t", "pk"),
                Collections.singletonList(new software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment("pk")),
                new StructuredDataTerminal("val".getBytes(StandardCharsets.UTF_8), new byte[]{0, 1}),
                CryptoAction.SIGN_ONLY)
        );

        byte[] headerBytes = new byte[66]; // dummy
        Map<byte[], byte[]> ec = new LinkedHashMap<>();

        byte[] canonHash = Footer.computeCanonicalHash(fields, headerBytes, ec);
        assertEquals(48, canonHash.length); // SHA-384

        // Same inputs → same hash
        byte[] canonHash2 = Footer.computeCanonicalHash(fields, headerBytes, ec);
        assertArrayEquals(canonHash, canonHash2);

        // Different header → different hash
        byte[] headerBytes2 = new byte[66];
        headerBytes2[0] = 1;
        byte[] canonHash3 = Footer.computeCanonicalHash(fields, headerBytes2, ec);
        assertFalse(Arrays.equals(canonHash, canonHash3));
    }

    // ---- Step 6: Full Encrypt → Decrypt with Tamper Detection ----

    @Test
    void testEcdsaRoundTrip() {
        // Generate ECDSA P-384 key pair using MPL primitives
        software.amazon.cryptography.primitives.AtomicPrimitives crypto =
            software.amazon.cryptography.primitives.AtomicPrimitives.builder()
                .CryptoConfig(software.amazon.cryptography.primitives.model.CryptoConfig.builder().build())
                .build();
        software.amazon.cryptography.primitives.model.GenerateECDSASignatureKeyOutput keyOut =
            crypto.GenerateECDSASignatureKey(
                software.amazon.cryptography.primitives.model.GenerateECDSASignatureKeyInput.builder()
                    .signatureAlgorithm(software.amazon.cryptography.primitives.model.ECDSASignatureAlgorithm.ECDSA_P384)
                    .build());

        byte[] signingKey = new byte[keyOut.signingKey().remaining()];
        keyOut.signingKey().get(signingKey);
        byte[] verificationKey = new byte[keyOut.verificationKey().remaining()];
        keyOut.verificationKey().get(verificationKey);

        DynamoDbItemEncryptor enc = createEcdsaEncryptor(signingKey, verificationKey);

        Map<String, AttributeValue> original = new LinkedHashMap<>();
        original.put("pk", AttributeValue.fromS("user1"));
        original.put("data", AttributeValue.fromS("secret"));

        Map<String, AttributeValue> encrypted = enc.encryptItem(original);

        // Header should have flavor 0x01
        byte[] headerBytes = encrypted.get("aws_dbe_head").b().asByteArray();
        Header.PartialHeader header = Header.deserialize(headerBytes);
        assertEquals(0x01, header.getFlavor());

        // Footer should have signature (48B tag + 103B sig = 151B for 1 EDK)
        byte[] footerBytes = encrypted.get("aws_dbe_foot").b().asByteArray();
        Footer footer = Footer.deserialize(footerBytes, true);
        assertNotNull(footer.getSignature());

        // Decrypt should succeed
        Map<String, AttributeValue> decrypted = enc.decryptItem(encrypted);
        assertEquals("user1", decrypted.get("pk").s());
        assertEquals("secret", decrypted.get("data").s());

        // Tamper with signed field → ECDSA verification should fail
        Map<String, AttributeValue> tampered = new LinkedHashMap<>(encrypted);
        tampered.put("pk", AttributeValue.fromS("user2"));
        assertThrows(Exception.class, () -> enc.decryptItem(tampered));
    }

    private static DynamoDbItemEncryptor createEcdsaEncryptor(byte[] signingKey, byte[] verificationKey) {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("data", CryptoAction.ENCRYPT_AND_SIGN);

        return DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("EcdsaTable")
                .partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions)
                .cmm(new EcdsaCMM(signingKey, verificationKey))
                .build());
    }

    /** CMM that returns flavor 0x01 (ECDSA) materials. */
    static class EcdsaCMM implements ICryptographicMaterialsManager {
        private final byte[] signingKey;
        private final byte[] verificationKey;

        EcdsaCMM(byte[] signingKey, byte[] verificationKey) {
            this.signingKey = signingKey;
            this.verificationKey = verificationKey;
        }

        @Override
        public GetEncryptionMaterialsOutput GetEncryptionMaterials(GetEncryptionMaterialsInput input) {
            return GetEncryptionMaterialsOutput.builder().encryptionMaterials(
                EncryptionMaterials.builder()
                    .algorithmSuite(buildEcdsaSuite())
                    .encryptionContext(input.encryptionContext() != null ? input.encryptionContext() : new HashMap<String, String>())
                    .encryptedDataKeys(Collections.singletonList(EncryptedDataKey.builder()
                        .keyProviderId("static").keyProviderInfo(ByteBuffer.wrap("t".getBytes(StandardCharsets.UTF_8)))
                        .ciphertext(ByteBuffer.wrap(FIXED_DATA_KEY)).build()))
                    .requiredEncryptionContextKeys(Collections.<String>emptyList())
                    .plaintextDataKey(ByteBuffer.wrap(FIXED_DATA_KEY))
                    .signingKey(ByteBuffer.wrap(signingKey))
                    .symmetricSigningKeys(Collections.singletonList(ByteBuffer.wrap(FIXED_SIGNING_KEY)))
                    .build()
            ).build();
        }

        @Override
        public DecryptMaterialsOutput DecryptMaterials(DecryptMaterialsInput input) {
            return DecryptMaterialsOutput.builder().decryptionMaterials(
                DecryptionMaterials.builder()
                    .algorithmSuite(buildEcdsaSuite())
                    .encryptionContext(input.encryptionContext() != null ? input.encryptionContext() : new HashMap<String, String>())
                    .requiredEncryptionContextKeys(Collections.<String>emptyList())
                    .plaintextDataKey(ByteBuffer.wrap(FIXED_DATA_KEY))
                    .symmetricSigningKey(ByteBuffer.wrap(FIXED_SIGNING_KEY))
                    .verificationKey(ByteBuffer.wrap(verificationKey))
                    .build()
            ).build();
        }

        private static AlgorithmSuiteInfo buildEcdsaSuite() {
            return AlgorithmSuiteInfo.builder()
                .id(AlgorithmSuiteId.builder().DBE(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384).build())
                .binaryId(ByteBuffer.wrap(new byte[]{0x67, 0x01})).messageVersion(2)
                .encrypt(software.amazon.cryptography.materialproviders.model.Encrypt.builder()
                    .AES_GCM(software.amazon.cryptography.primitives.model.AES_GCM.builder().keyLength(32).tagLength(16).ivLength(12).build()).build())
                .kdf(software.amazon.cryptography.materialproviders.model.DerivationAlgorithm.builder()
                    .HKDF(software.amazon.cryptography.materialproviders.model.HKDF.builder().hmac(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_512).saltLength(0).inputKeyLength(32).outputKeyLength(32).build()).build())
                .commitment(software.amazon.cryptography.materialproviders.model.DerivationAlgorithm.builder()
                    .HKDF(software.amazon.cryptography.materialproviders.model.HKDF.builder().hmac(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_512).saltLength(0).inputKeyLength(32).outputKeyLength(32).build()).build())
                .signature(software.amazon.cryptography.materialproviders.model.SignatureAlgorithm.builder()
                    .ECDSA(software.amazon.cryptography.materialproviders.model.ECDSA.builder()
                        .curve(software.amazon.cryptography.primitives.model.ECDSASignatureAlgorithm.ECDSA_P384).build()).build())
                .symmetricSignature(software.amazon.cryptography.materialproviders.model.SymmetricSignatureAlgorithm.builder()
                    .HMAC(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_384).build())
                .edkWrapping(software.amazon.cryptography.materialproviders.model.EdkWrappingAlgorithm.builder()
                    .DIRECT_KEY_WRAPPING(software.amazon.cryptography.materialproviders.model.DIRECT_KEY_WRAPPING.builder().build()).build())
                .build();
        }
    }

    @Test
    void testFullRoundTripWithIntegrityChecks() {
        DynamoDbItemEncryptor enc = createEncryptor();

        Map<String, AttributeValue> original = new LinkedHashMap<>();
        original.put("pk", AttributeValue.fromS("user1"));
        original.put("sk", AttributeValue.fromN("100"));
        original.put("name", AttributeValue.fromS("Alice"));
        original.put("ssn", AttributeValue.fromS("123-45-6789"));

        // Encrypt
        Map<String, AttributeValue> encrypted = enc.encryptItem(original);

        // Verify structure
        assertTrue(encrypted.containsKey("aws_dbe_head"));
        assertTrue(encrypted.containsKey("aws_dbe_foot"));
        assertEquals("user1", encrypted.get("pk").s()); // SIGN_ONLY unchanged
        assertEquals("100", encrypted.get("sk").n());    // SIGN_ONLY unchanged
        assertNotNull(encrypted.get("name").b());         // ENCRYPT_AND_SIGN → Binary
        assertNotNull(encrypted.get("ssn").b());          // ENCRYPT_AND_SIGN → Binary

        // Decrypt
        Map<String, AttributeValue> decrypted = enc.decryptItem(encrypted);
        assertEquals("user1", decrypted.get("pk").s());
        assertEquals("100", decrypted.get("sk").n());
        assertEquals("Alice", decrypted.get("name").s());
        assertEquals("123-45-6789", decrypted.get("ssn").s());

        // Tamper with encrypted field → AES-GCM auth tag failure
        Map<String, AttributeValue> tampered1 = new LinkedHashMap<>(encrypted);
        byte[] nameBytes = encrypted.get("name").b().asByteArray().clone();
        nameBytes[nameBytes.length - 1] ^= 0x01;
        tampered1.put("name", AttributeValue.fromB(SdkBytes.fromByteArray(nameBytes)));
        assertThrows(Exception.class, () -> enc.decryptItem(tampered1),
            "Should reject tampered ciphertext");

        // Tamper with header → commitment failure
        Map<String, AttributeValue> tampered2 = new LinkedHashMap<>(encrypted);
        byte[] headBytes = encrypted.get("aws_dbe_head").b().asByteArray().clone();
        headBytes[10] ^= 0x01; // flip bit in message ID
        tampered2.put("aws_dbe_head", AttributeValue.fromB(SdkBytes.fromByteArray(headBytes)));
        assertThrows(Exception.class, () -> enc.decryptItem(tampered2),
            "Should reject tampered header");

        // Tamper with footer → HMAC verification failure
        Map<String, AttributeValue> tampered3 = new LinkedHashMap<>(encrypted);
        byte[] footBytes = encrypted.get("aws_dbe_foot").b().asByteArray().clone();
        footBytes[0] ^= 0x01;
        tampered3.put("aws_dbe_foot", AttributeValue.fromB(SdkBytes.fromByteArray(footBytes)));
        assertThrows(Exception.class, () -> enc.decryptItem(tampered3),
            "Should reject tampered footer");

        // Swap encrypted fields → AAD mismatch
        Map<String, AttributeValue> tampered4 = new LinkedHashMap<>(encrypted);
        tampered4.put("name", encrypted.get("ssn"));
        tampered4.put("ssn", encrypted.get("name"));
        assertThrows(Exception.class, () -> enc.decryptItem(tampered4),
            "Should reject swapped encrypted fields");

        // Modify SIGN_ONLY field → footer HMAC failure
        Map<String, AttributeValue> tampered5 = new LinkedHashMap<>(encrypted);
        tampered5.put("pk", AttributeValue.fromS("user2"));
        assertThrows(Exception.class, () -> enc.decryptItem(tampered5),
            "Should reject modified signed field");
    }

    @Test
    void testRoundTripAllDdbTypes() {
        DynamoDbItemEncryptor enc = createAllTypesEncryptor();

        Map<String, AttributeValue> original = new LinkedHashMap<>();
        original.put("pk", AttributeValue.fromS("id"));
        original.put("str", AttributeValue.fromS("hello"));
        original.put("num", AttributeValue.fromN("42.5"));
        original.put("bin", AttributeValue.fromB(SdkBytes.fromByteArray(new byte[]{1, 2, 3})));
        original.put("bool", AttributeValue.fromBool(true));
        original.put("nul", AttributeValue.fromNul(true));
        original.put("ss", AttributeValue.builder().ss("a", "b", "c").build());
        original.put("ns", AttributeValue.builder().ns("1", "2", "3").build());
        original.put("bs", AttributeValue.builder()
            .bs(SdkBytes.fromByteArray(new byte[]{1}), SdkBytes.fromByteArray(new byte[]{2})).build());
        original.put("list", AttributeValue.builder()
            .l(AttributeValue.fromS("x"), AttributeValue.fromN("9")).build());
        Map<String, AttributeValue> mapVal = new LinkedHashMap<>();
        mapVal.put("nested", AttributeValue.fromS("value"));
        original.put("map", AttributeValue.builder().m(mapVal).build());

        Map<String, AttributeValue> encrypted = enc.encryptItem(original);
        Map<String, AttributeValue> decrypted = enc.decryptItem(encrypted);

        // Verify each type round-trips correctly
        assertEquals("hello", decrypted.get("str").s());
        assertEquals("42.5", decrypted.get("num").n());
        assertArrayEquals(new byte[]{1, 2, 3}, decrypted.get("bin").b().asByteArray());
        assertTrue(decrypted.get("bool").bool());
        assertTrue(decrypted.get("nul").nul());
        assertEquals(3, decrypted.get("ss").ss().size());
        assertEquals(3, decrypted.get("ns").ns().size());
        assertEquals(2, decrypted.get("bs").bs().size());
        assertEquals(2, decrypted.get("list").l().size());
        assertEquals("value", decrypted.get("map").m().get("nested").s());
    }

    @Test
    void testEncryptedFieldFormatMatchesSpec() {
        DynamoDbItemEncryptor enc = createEncryptor();

        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("id"));
        item.put("sk", AttributeValue.fromN("1"));
        item.put("name", AttributeValue.fromS("Alice"));
        item.put("ssn", AttributeValue.fromS("data"));

        Map<String, AttributeValue> encrypted = enc.encryptItem(item);

        // Encrypted field format: [2B original typeId][ciphertext][16B authTag]
        byte[] encName = encrypted.get("name").b().asByteArray();
        // First 2 bytes = original type ID for String = 0x0001
        assertEquals(0x00, encName[0]);
        assertEquals(0x01, encName[1]);
        // Length = 2 + plaintext_len + 16
        assertEquals(2 + "Alice".length() + 16, encName.length);

        // Header should be parseable and have correct structure
        byte[] headerBytes = encrypted.get("aws_dbe_head").b().asByteArray();
        Header.PartialHeader header = Header.deserialize(headerBytes);
        assertEquals(1, header.getVersion());
        assertTrue(header.getFlavor() == 0 || header.getFlavor() == 1);
        assertEquals(32, header.getMsgID().length);
        // Legend: 2 encrypted fields (name, ssn) + 2 signed fields (pk, sk) = 4 legend bytes
        // But order depends on canonical path sorting
        assertEquals(4, header.getLegend().length);
        assertTrue(header.getDataKeys().size() >= 1);

        // Footer should be deserializable
        byte[] footerBytes = encrypted.get("aws_dbe_foot").b().asByteArray();
        Footer footer = Footer.deserialize(footerBytes, header.getFlavor() == 0x01);
        assertEquals(header.getDataKeys().size(), footer.getTags().size());
        assertEquals(48, footer.getTags().get(0).length); // HMAC-SHA384
    }

    // ---- Helpers ----

    private static DynamoDbItemEncryptor createEncryptor() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("sk", CryptoAction.SIGN_ONLY);
        actions.put("name", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("ssn", CryptoAction.ENCRYPT_AND_SIGN);

        return DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("TestTable")
                .partitionKeyName("pk").sortKeyName("sk")
                .attributeActionsOnEncrypt(actions)
                .cmm(new FixedKeyCMM()).build());
    }

    private static DynamoDbItemEncryptor createAllTypesEncryptor() {
        Map<String, CryptoAction> actions = new LinkedHashMap<>();
        actions.put("pk", CryptoAction.SIGN_ONLY);
        actions.put("str", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("num", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("bin", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("bool", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("nul", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("ss", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("ns", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("bs", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("list", CryptoAction.ENCRYPT_AND_SIGN);
        actions.put("map", CryptoAction.ENCRYPT_AND_SIGN);

        return DynamoDbItemEncryptor.create(
            DynamoDbItemEncryptorConfig.builder()
                .logicalTableName("AllTypes")
                .partitionKeyName("pk")
                .attributeActionsOnEncrypt(actions)
                .cmm(new FixedKeyCMM()).build());
    }

    /** CMM with fixed keys for reproducible tests. */
    static class FixedKeyCMM implements ICryptographicMaterialsManager {
        @Override
        public GetEncryptionMaterialsOutput GetEncryptionMaterials(GetEncryptionMaterialsInput input) {
            return GetEncryptionMaterialsOutput.builder().encryptionMaterials(
                EncryptionMaterials.builder()
                    .algorithmSuite(buildSuite())
                    .encryptionContext(input.encryptionContext() != null ? input.encryptionContext() : new HashMap<String, String>())
                    .encryptedDataKeys(Collections.singletonList(EncryptedDataKey.builder()
                        .keyProviderId("static-key")
                        .keyProviderInfo(ByteBuffer.wrap("test".getBytes(StandardCharsets.UTF_8)))
                        .ciphertext(ByteBuffer.wrap(FIXED_DATA_KEY)).build()))
                    .requiredEncryptionContextKeys(Collections.<String>emptyList())
                    .plaintextDataKey(ByteBuffer.wrap(FIXED_DATA_KEY))
                    .symmetricSigningKeys(Collections.singletonList(ByteBuffer.wrap(FIXED_SIGNING_KEY)))
                    .build()
            ).build();
        }

        @Override
        public DecryptMaterialsOutput DecryptMaterials(DecryptMaterialsInput input) {
            return DecryptMaterialsOutput.builder().decryptionMaterials(
                DecryptionMaterials.builder()
                    .algorithmSuite(buildSuite())
                    .encryptionContext(input.encryptionContext() != null ? input.encryptionContext() : new HashMap<String, String>())
                    .requiredEncryptionContextKeys(Collections.<String>emptyList())
                    .plaintextDataKey(ByteBuffer.wrap(FIXED_DATA_KEY))
                    .symmetricSigningKey(ByteBuffer.wrap(FIXED_SIGNING_KEY))
                    .build()
            ).build();
        }

        private static AlgorithmSuiteInfo buildSuite() {
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

    private static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }

    private static byte[] longToBytes(long v) {
        byte[] b = new byte[8];
        for (int i = 7; i >= 0; i--) { b[i] = (byte) (v & 0xFF); v >>= 8; }
        return b;
    }

    private static byte[] concat(byte[]... arrays) {
        int total = 0;
        for (byte[] a : arrays) total += a.length;
        byte[] result = new byte[total];
        int pos = 0;
        for (byte[] a : arrays) { System.arraycopy(a, 0, result, pos, a.length); pos += a.length; }
        return result;
    }

    private static int compareBytes(byte[] a, byte[] b) {
        int len = Math.min(a.length, b.length);
        for (int i = 0; i < len; i++) {
            int cmp = (a[i] & 0xFF) - (b[i] & 0xFF);
            if (cmp != 0) return cmp;
        }
        return a.length - b.length;
    }
}
