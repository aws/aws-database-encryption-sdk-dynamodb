// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsManager;
import software.amazon.cryptography.materialproviders.model.AlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.AlgorithmSuiteInfo;
import software.amazon.cryptography.materialproviders.model.CommitmentPolicy;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.DBECommitmentPolicy;
import software.amazon.cryptography.materialproviders.model.DecryptMaterialsInput;
import software.amazon.cryptography.materialproviders.model.DecryptMaterialsOutput;
import software.amazon.cryptography.materialproviders.model.EncryptedDataKey;
import software.amazon.cryptography.materialproviders.model.EncryptionMaterials;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsInput;
import software.amazon.cryptography.materialproviders.model.GetEncryptionMaterialsOutput;

class EncryptPathStructureTest {

    // ---- Basic encrypt ----

    @Test
    void testEncryptBasic() {
        List<CryptoItem> input = new ArrayList<>();
        input.add(makeItem("pk", "user123", new byte[]{0, 1}, CryptoAction.SIGN_ONLY));
        input.add(makeItem("data", "secret", new byte[]{0, 1}, CryptoAction.ENCRYPT_AND_SIGN));

        EncryptPathStructure.Result result = EncryptPathStructure.encrypt(
            "myTable", input, new MockCMM(), null, null);

        assertNotNull(result);
        List<CryptoItem> output = result.getEncryptedStructure();

        // Should have: pk, data (encrypted), aws_dbe_head, aws_dbe_foot
        assertEquals(4, output.size());

        // Find each field
        CryptoItem headerItem = findByKey(output, "aws_dbe_head");
        CryptoItem footerItem = findByKey(output, "aws_dbe_foot");
        CryptoItem pkItem = findByKey(output, "pk");
        CryptoItem dataItem = findByKey(output, "data");

        assertNotNull(headerItem, "Missing header");
        assertNotNull(footerItem, "Missing footer");
        assertNotNull(pkItem, "Missing pk");
        assertNotNull(dataItem, "Missing data");

        // pk should be unchanged (SIGN_ONLY)
        assertArrayEquals("user123".getBytes(StandardCharsets.UTF_8), pkItem.getData().getValue());
        assertArrayEquals(new byte[]{0, 1}, pkItem.getData().getTypeId());

        // data should be encrypted (typeId = 0xFFFF)
        assertArrayEquals(new byte[]{(byte) 0xFF, (byte) 0xFF}, dataItem.getData().getTypeId());
        // Encrypted value starts with original typeId
        byte[] encValue = dataItem.getData().getValue();
        assertEquals(0x00, encValue[0]);
        assertEquals(0x01, encValue[1]);
        // Should be longer than original (ciphertext + auth tag)
        assertTrue(encValue.length > "secret".length() + 2);

        // Header should be parseable
        byte[] headerBytes = headerItem.getData().getValue();
        Header.PartialHeader header = Header.deserialize(headerBytes);
        assertEquals(1, header.getVersion()); // no SIGN_AND_INCLUDE_IN_EC
        assertTrue(header.getFlavor() == 0 || header.getFlavor() == 1);
        assertEquals(32, header.getMsgID().length);

        // Footer should be deserializable
        byte[] footerBytes = footerItem.getData().getValue();
        boolean hasSig = header.getFlavor() == 0x01;
        Footer footer = Footer.deserialize(footerBytes, hasSig);
        assertEquals(1, footer.getTags().size()); // 1 EDK = 1 tag
    }

    @Test
    void testEncryptMultipleFields() {
        List<CryptoItem> input = new ArrayList<>();
        input.add(makeItem("pk", "id1", new byte[]{0, 1}, CryptoAction.SIGN_ONLY));
        input.add(makeItem("sk", "sort1", new byte[]{0, 1}, CryptoAction.SIGN_ONLY));
        input.add(makeItem("name", "Alice", new byte[]{0, 1}, CryptoAction.ENCRYPT_AND_SIGN));
        input.add(makeItem("ssn", "123-45-6789", new byte[]{0, 1}, CryptoAction.ENCRYPT_AND_SIGN));
        input.add(makeItem("notes", "internal", new byte[]{0, 1}, CryptoAction.DO_NOTHING));

        EncryptPathStructure.Result result = EncryptPathStructure.encrypt(
            "table", input, new MockCMM(), null, null);

        List<CryptoItem> output = result.getEncryptedStructure();
        // 5 original + header + footer = 7
        assertEquals(7, output.size());

        // SIGN_ONLY fields unchanged
        assertEquals("id1", new String(findByKey(output, "pk").getData().getValue(), StandardCharsets.UTF_8));
        assertEquals("sort1", new String(findByKey(output, "sk").getData().getValue(), StandardCharsets.UTF_8));

        // ENCRYPT_AND_SIGN fields encrypted
        assertArrayEquals(new byte[]{(byte) 0xFF, (byte) 0xFF}, findByKey(output, "name").getData().getTypeId());
        assertArrayEquals(new byte[]{(byte) 0xFF, (byte) 0xFF}, findByKey(output, "ssn").getData().getTypeId());

        // DO_NOTHING field unchanged
        assertEquals("internal", new String(findByKey(output, "notes").getData().getValue(), StandardCharsets.UTF_8));
    }

    // ---- Validation ----

    @Test
    void testRejectsReservedFieldNames() {
        List<CryptoItem> input = new ArrayList<>();
        input.add(makeItem("aws_dbe_head", "bad", new byte[]{0, 1}, CryptoAction.SIGN_ONLY));

        assertThrows(DbeException.class, () ->
            EncryptPathStructure.encrypt("t", input, new MockCMM(), null, null));
    }

    @Test
    void testRejectsNoAuthFields() {
        List<CryptoItem> input = new ArrayList<>();
        input.add(makeItem("a", "val", new byte[]{0, 1}, CryptoAction.DO_NOTHING));

        assertThrows(DbeException.class, () ->
            EncryptPathStructure.encrypt("t", input, new MockCMM(), null, null));
    }

    // ---- Header/Footer integrity ----

    @Test
    void testHeaderCommitmentIsValid() {
        List<CryptoItem> input = new ArrayList<>();
        input.add(makeItem("pk", "v", new byte[]{0, 1}, CryptoAction.SIGN_ONLY));
        input.add(makeItem("data", "s", new byte[]{0, 1}, CryptoAction.ENCRYPT_AND_SIGN));

        EncryptPathStructure.Result result = EncryptPathStructure.encrypt(
            "t", input, new MockCMM(), null, null);

        byte[] headerBytes = findByKey(result.getEncryptedStructure(), "aws_dbe_head").getData().getValue();

        // The header should have a valid commitment
        // We can't verify it without the data key, but we can verify the format
        assertTrue(headerBytes.length > Header.PREFIX_LEN + Header.COMMITMENT_LEN);
        byte[] commitment = Header.getCommitment(headerBytes);
        assertEquals(32, commitment.length);
    }

    @Test
    void testParsedHeaderOutput() {
        List<CryptoItem> input = new ArrayList<>();
        input.add(makeItem("pk", "v", new byte[]{0, 1}, CryptoAction.SIGN_ONLY));
        input.add(makeItem("data", "s", new byte[]{0, 1}, CryptoAction.ENCRYPT_AND_SIGN));

        EncryptPathStructure.Result result = EncryptPathStructure.encrypt(
            "t", input, new MockCMM(), null, null);

        assertNotNull(result.getParsedHeader());
        assertNotNull(result.getParsedHeader().getAlgorithmSuiteId());
        assertNotNull(result.getParsedHeader().getEncryptionContext());
    }

    @Test
    void testEncryptionIsDeterministicInStructure() {
        // Two encryptions of the same data should produce different ciphertexts
        // (different message IDs)
        List<CryptoItem> input = new ArrayList<>();
        input.add(makeItem("pk", "v", new byte[]{0, 1}, CryptoAction.SIGN_ONLY));
        input.add(makeItem("data", "secret", new byte[]{0, 1}, CryptoAction.ENCRYPT_AND_SIGN));

        EncryptPathStructure.Result r1 = EncryptPathStructure.encrypt("t", input, new MockCMM(), null, null);
        EncryptPathStructure.Result r2 = EncryptPathStructure.encrypt("t", input, new MockCMM(), null, null);

        byte[] enc1 = findByKey(r1.getEncryptedStructure(), "data").getData().getValue();
        byte[] enc2 = findByKey(r2.getEncryptedStructure(), "data").getData().getValue();

        // Different message IDs → different ciphertexts
        assertFalse(Arrays.equals(enc1, enc2));
    }

    // ---- Helpers ----

    private static CryptoItem makeItem(String name, String value, byte[] typeId, CryptoAction action) {
        return new CryptoItem(
            Collections.singletonList(new PathSegment(name)),
            new StructuredDataTerminal(value.getBytes(StandardCharsets.UTF_8), typeId),
            action);
    }

    private static CryptoItem findByKey(List<CryptoItem> items, String key) {
        for (CryptoItem item : items) {
            if (item.getKey().get(0).getKey().equals(key)) return item;
        }
        return null;
    }

    /**
     * Mock CMM that returns static encryption materials with a random data key.
     * Uses flavor 0x00 (HMAC only, no ECDSA) for simplicity.
     */
    static class MockCMM implements ICryptographicMaterialsManager {
        @Override
        public GetEncryptionMaterialsOutput GetEncryptionMaterials(GetEncryptionMaterialsInput input) {
            byte[] dataKey = new byte[32];
            new SecureRandom().nextBytes(dataKey);

            byte[] symmetricSigningKey = new byte[32];
            new SecureRandom().nextBytes(symmetricSigningKey);

            EncryptedDataKey edk = EncryptedDataKey.builder()
                .keyProviderId("mock-provider")
                .keyProviderInfo(ByteBuffer.wrap("mock-info".getBytes(StandardCharsets.UTF_8)))
                .ciphertext(ByteBuffer.wrap(new byte[]{1, 2, 3, 4, 5}))
                .build();

            // Build a minimal but valid AlgorithmSuiteInfo for flavor 0x00 (HMAC only)
            AlgorithmSuiteInfo suiteInfo = AlgorithmSuiteInfo.builder()
                .id(AlgorithmSuiteId.builder()
                    .DBE(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384)
                    .build())
                .binaryId(ByteBuffer.wrap(new byte[]{0x67, 0x00}))
                .messageVersion(2)
                .encrypt(software.amazon.cryptography.materialproviders.model.Encrypt.builder()
                    .AES_GCM(software.amazon.cryptography.primitives.model.AES_GCM.builder()
                        .keyLength(32).tagLength(16).ivLength(12).build())
                    .build())
                .kdf(software.amazon.cryptography.materialproviders.model.DerivationAlgorithm.builder()
                    .HKDF(software.amazon.cryptography.materialproviders.model.HKDF.builder()
                        .hmac(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_512)
                        .saltLength(0).inputKeyLength(32).outputKeyLength(32).build())
                    .build())
                .commitment(software.amazon.cryptography.materialproviders.model.DerivationAlgorithm.builder()
                    .HKDF(software.amazon.cryptography.materialproviders.model.HKDF.builder()
                        .hmac(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_512)
                        .saltLength(0).inputKeyLength(32).outputKeyLength(32).build())
                    .build())
                .signature(software.amazon.cryptography.materialproviders.model.SignatureAlgorithm.builder()
                    .None(software.amazon.cryptography.materialproviders.model.None.builder().build())
                    .build())
                .symmetricSignature(software.amazon.cryptography.materialproviders.model.SymmetricSignatureAlgorithm.builder()
                    .HMAC(software.amazon.cryptography.primitives.model.DigestAlgorithm.SHA_384)
                    .build())
                .edkWrapping(software.amazon.cryptography.materialproviders.model.EdkWrappingAlgorithm.builder()
                    .DIRECT_KEY_WRAPPING(software.amazon.cryptography.materialproviders.model.DIRECT_KEY_WRAPPING.builder().build())
                    .build())
                .build();

            EncryptionMaterials materials = EncryptionMaterials.builder()
                .algorithmSuite(suiteInfo)
                .encryptionContext(input.encryptionContext() != null
                    ? input.encryptionContext() : new HashMap<String, String>())
                .encryptedDataKeys(Collections.singletonList(edk))
                .requiredEncryptionContextKeys(Collections.<String>emptyList())
                .plaintextDataKey(ByteBuffer.wrap(dataKey))
                .symmetricSigningKeys(Collections.singletonList(ByteBuffer.wrap(symmetricSigningKey)))
                .build();

            return GetEncryptionMaterialsOutput.builder()
                .encryptionMaterials(materials)
                .build();
        }

        @Override
        public DecryptMaterialsOutput DecryptMaterials(DecryptMaterialsInput input) {
            throw new UnsupportedOperationException("Not implemented in mock");
        }
    }
}
