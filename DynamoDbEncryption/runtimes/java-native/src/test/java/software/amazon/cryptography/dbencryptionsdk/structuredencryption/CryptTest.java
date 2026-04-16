// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class CryptTest {

    private static final byte[] TEST_KEY = new byte[32]; // all zeros for testing
    private static final byte[] TEST_MSG_ID = new byte[32];

    static {
        new SecureRandom().nextBytes(TEST_MSG_ID);
    }

    // ---- Key Derivation ----

    @Test
    void testDeriveCommitKeyLength() {
        byte[] commitKey = Crypt.deriveCommitKey(TEST_KEY, TEST_MSG_ID);
        assertEquals(32, commitKey.length);
    }

    @Test
    void testDeriveFieldRootKeyLength() {
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(TEST_KEY, TEST_MSG_ID);
        assertEquals(32, fieldRootKey.length);
    }

    @Test
    void testCommitKeyDifferentFromFieldRootKey() {
        byte[] commitKey = Crypt.deriveCommitKey(TEST_KEY, TEST_MSG_ID);
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(TEST_KEY, TEST_MSG_ID);
        assertFalse(Arrays.equals(commitKey, fieldRootKey));
    }

    @Test
    void testDeriveCommitKeyDeterministic() {
        byte[] k1 = Crypt.deriveCommitKey(TEST_KEY, TEST_MSG_ID);
        byte[] k2 = Crypt.deriveCommitKey(TEST_KEY, TEST_MSG_ID);
        assertArrayEquals(k1, k2);
    }

    @Test
    void testDeriveCommitKeyDifferentMsgID() {
        byte[] msgID2 = new byte[32];
        msgID2[0] = 1;
        byte[] k1 = Crypt.deriveCommitKey(TEST_KEY, TEST_MSG_ID);
        byte[] k2 = Crypt.deriveCommitKey(TEST_KEY, msgID2);
        assertFalse(Arrays.equals(k1, k2));
    }

    // ---- Field Key Derivation ----

    @Test
    void testDeriveFieldKeyLength() {
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(TEST_KEY, TEST_MSG_ID);
        byte[] fieldKey = Crypt.deriveFieldKey(fieldRootKey, 0);
        assertEquals(44, fieldKey.length); // 32 cipher key + 12 nonce
    }

    @Test
    void testDeriveFieldKeyDifferentOffsets() {
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(TEST_KEY, TEST_MSG_ID);
        byte[] fk0 = Crypt.deriveFieldKey(fieldRootKey, 0);
        byte[] fk1 = Crypt.deriveFieldKey(fieldRootKey, 1);
        assertFalse(Arrays.equals(fk0, fk1));
    }

    @Test
    void testDeriveFieldKeyDeterministic() {
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(TEST_KEY, TEST_MSG_ID);
        byte[] fk1 = Crypt.deriveFieldKey(fieldRootKey, 5);
        byte[] fk2 = Crypt.deriveFieldKey(fieldRootKey, 5);
        assertArrayEquals(fk1, fk2);
    }

    @Test
    void testFieldKeyNonceFormat() {
        byte[] nonce = Crypt.fieldKeyNonce(0);
        assertEquals(16, nonce.length);
        // First 11 bytes = "AwsDbeField"
        assertArrayEquals("AwsDbeField".getBytes(StandardCharsets.UTF_8),
            Arrays.copyOfRange(nonce, 0, 11));
        // Byte 11 = 0x2c (44)
        assertEquals(0x2c, nonce[11] & 0xFF);
        // Last 4 bytes = offset as big-endian uint32
        assertEquals(0, nonce[12]);
        assertEquals(0, nonce[13]);
        assertEquals(0, nonce[14]);
        assertEquals(0, nonce[15]);
    }

    @Test
    void testFieldKeyNonceOffset() {
        byte[] nonce = Crypt.fieldKeyNonce(3); // offset=1 * 3
        assertEquals(0, nonce[12]);
        assertEquals(0, nonce[13]);
        assertEquals(0, nonce[14]);
        assertEquals(3, nonce[15]);
    }

    // ---- Field Encryption / Decryption Round-Trip ----

    @Test
    void testEncryptDecryptRoundTrip() {
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(TEST_KEY, TEST_MSG_ID);
        byte[] canonPath = Canonize.simpleCanon("myTable", "myAttr");
        byte[] typeId = new byte[]{0x00, 0x01}; // String
        byte[] plaintext = "hello world".getBytes(StandardCharsets.UTF_8);

        byte[] encrypted = Crypt.encryptField(fieldRootKey, 0, canonPath, typeId, plaintext);

        // Encrypted format: [2B typeId][ciphertext][16B authTag]
        assertTrue(encrypted.length > 2 + 16);
        assertEquals(typeId[0], encrypted[0]);
        assertEquals(typeId[1], encrypted[1]);

        // Decrypt
        byte[][] result = Crypt.decryptField(fieldRootKey, 0, canonPath, encrypted);
        assertArrayEquals(typeId, result[0]);
        assertArrayEquals(plaintext, result[1]);
    }

    @Test
    void testEncryptDecryptEmptyPlaintext() {
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(TEST_KEY, TEST_MSG_ID);
        byte[] canonPath = Canonize.simpleCanon("t", "a");
        byte[] typeId = new byte[]{0x00, 0x00}; // NULL

        byte[] encrypted = Crypt.encryptField(fieldRootKey, 0, canonPath, typeId, new byte[0]);
        byte[][] result = Crypt.decryptField(fieldRootKey, 0, canonPath, encrypted);
        assertArrayEquals(typeId, result[0]);
        assertEquals(0, result[1].length);
    }

    @Test
    void testEncryptDecryptMultipleFields() {
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(TEST_KEY, TEST_MSG_ID);
        byte[] typeId = new byte[]{0x00, 0x01};

        // Encrypt 3 fields with different offsets
        for (int i = 0; i < 3; i++) {
            byte[] canonPath = Canonize.simpleCanon("table", "field" + i);
            byte[] plaintext = ("value" + i).getBytes(StandardCharsets.UTF_8);

            byte[] encrypted = Crypt.encryptField(fieldRootKey, i, canonPath, typeId, plaintext);
            byte[][] result = Crypt.decryptField(fieldRootKey, i, canonPath, encrypted);
            assertArrayEquals(plaintext, result[1], "Round-trip failed for field " + i);
        }
    }

    @Test
    void testDecryptWithWrongKeyFails() {
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(TEST_KEY, TEST_MSG_ID);
        byte[] canonPath = Canonize.simpleCanon("t", "a");
        byte[] typeId = new byte[]{0x00, 0x01};
        byte[] plaintext = "secret".getBytes(StandardCharsets.UTF_8);

        byte[] encrypted = Crypt.encryptField(fieldRootKey, 0, canonPath, typeId, plaintext);

        // Wrong key
        byte[] wrongKey = new byte[32];
        wrongKey[0] = 1;
        byte[] wrongFieldRootKey = Crypt.deriveFieldRootKey(wrongKey, TEST_MSG_ID);
        assertThrows(Exception.class, () ->
            Crypt.decryptField(wrongFieldRootKey, 0, canonPath, encrypted));
    }

    @Test
    void testDecryptWithWrongAADFails() {
        byte[] fieldRootKey = Crypt.deriveFieldRootKey(TEST_KEY, TEST_MSG_ID);
        byte[] canonPath = Canonize.simpleCanon("t", "a");
        byte[] typeId = new byte[]{0x00, 0x01};
        byte[] plaintext = "secret".getBytes(StandardCharsets.UTF_8);

        byte[] encrypted = Crypt.encryptField(fieldRootKey, 0, canonPath, typeId, plaintext);

        // Wrong AAD (different attribute name)
        byte[] wrongPath = Canonize.simpleCanon("t", "b");
        assertThrows(Exception.class, () ->
            Crypt.decryptField(fieldRootKey, 0, wrongPath, encrypted));
    }

    // ---- Header Commitment ----

    @Test
    void testHeaderCommitmentLength() {
        byte[] commitKey = Crypt.deriveCommitKey(TEST_KEY, TEST_MSG_ID);
        byte[] partialHeader = new byte[]{1, 0, 0, 0}; // dummy
        byte[] commitment = Crypt.computeHeaderCommitment(commitKey, partialHeader);
        assertEquals(32, commitment.length);
    }

    @Test
    void testHeaderCommitmentDeterministic() {
        byte[] commitKey = Crypt.deriveCommitKey(TEST_KEY, TEST_MSG_ID);
        byte[] partialHeader = "test header".getBytes(StandardCharsets.UTF_8);
        byte[] c1 = Crypt.computeHeaderCommitment(commitKey, partialHeader);
        byte[] c2 = Crypt.computeHeaderCommitment(commitKey, partialHeader);
        assertArrayEquals(c1, c2);
    }

    @Test
    void testHeaderCommitmentVerification() {
        byte[] commitKey = Crypt.deriveCommitKey(TEST_KEY, TEST_MSG_ID);
        byte[] partialHeader = "test header data".getBytes(StandardCharsets.UTF_8);
        byte[] commitment = Crypt.computeHeaderCommitment(commitKey, partialHeader);

        // Build full header
        byte[] fullHeader = new byte[partialHeader.length + commitment.length];
        System.arraycopy(partialHeader, 0, fullHeader, 0, partialHeader.length);
        System.arraycopy(commitment, 0, fullHeader, partialHeader.length, commitment.length);

        assertTrue(Crypt.verifyHeaderCommitment(commitKey, fullHeader));
    }

    @Test
    void testHeaderCommitmentVerificationFailsOnTamper() {
        byte[] commitKey = Crypt.deriveCommitKey(TEST_KEY, TEST_MSG_ID);
        byte[] partialHeader = "test header data".getBytes(StandardCharsets.UTF_8);
        byte[] commitment = Crypt.computeHeaderCommitment(commitKey, partialHeader);

        byte[] fullHeader = new byte[partialHeader.length + commitment.length];
        System.arraycopy(partialHeader, 0, fullHeader, 0, partialHeader.length);
        System.arraycopy(commitment, 0, fullHeader, partialHeader.length, commitment.length);

        // Tamper with the partial header
        fullHeader[0] ^= 0x01;
        assertFalse(Crypt.verifyHeaderCommitment(commitKey, fullHeader));
    }

    // ---- Constant-time comparison ----

    @Test
    void testConstantTimeEquals() {
        byte[] a = {1, 2, 3};
        byte[] b = {1, 2, 3};
        byte[] c = {1, 2, 4};
        assertTrue(Crypt.constantTimeEquals(a, b));
        assertFalse(Crypt.constantTimeEquals(a, c));
    }

    @Test
    void testConstantTimeEqualsDifferentLength() {
        assertFalse(Crypt.constantTimeEquals(new byte[]{1}, new byte[]{1, 2}));
    }
}
