// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;

/**
 * Cryptographic operations for structured encryption:
 * key derivation (HKDF, AES-CTR field keys) and field-level AES-GCM encrypt/decrypt.
 */
public final class Crypt {

    public static final int KEY_SIZE = 32;
    public static final int NONCE_SIZE = 12;
    public static final int AUTH_TAG_SIZE = 16;
    public static final int AUTH_TAG_BITS = 128;
    public static final int FIELD_KEY_SIZE = KEY_SIZE + NONCE_SIZE; // 44

    private static final byte[] LABEL_COMMIT_KEY =
        "AWS_DBE_COMMIT_KEY".getBytes(StandardCharsets.UTF_8);
    private static final byte[] LABEL_DERIVE_KEY =
        "AWS_DBE_DERIVE_KEY".getBytes(StandardCharsets.UTF_8);
    private static final byte[] AES_DBE_FIELD =
        "AwsDbeField".getBytes(StandardCharsets.UTF_8);

    private Crypt() {}

    // ---- Key Derivation ----

    /**
     * Derive the commit key via HKDF-SHA512.
     * info = "AWS_DBE_COMMIT_KEY" + messageID
     */
    public static byte[] deriveCommitKey(byte[] plaintextDataKey, byte[] messageID) {
        byte[] info = concat(LABEL_COMMIT_KEY, messageID);
        return hkdfSha512(plaintextDataKey, info, KEY_SIZE);
    }

    /**
     * Derive the field root key via HKDF-SHA512.
     * info = "AWS_DBE_DERIVE_KEY" + messageID
     */
    public static byte[] deriveFieldRootKey(byte[] plaintextDataKey, byte[] messageID) {
        byte[] info = concat(LABEL_DERIVE_KEY, messageID);
        return hkdfSha512(plaintextDataKey, info, KEY_SIZE);
    }

    /**
     * Derive a per-field key (32B cipher key + 12B nonce) from the field root key.
     * Uses AES-256-CTR as a KDF stream.
     *
     * @param fieldRootKey 32-byte field root key
     * @param offset       field index (0-based, among ENCRYPT_AND_SIGN fields in canonical order)
     * @return 44 bytes: first 32 = cipher key, last 12 = nonce
     */
    public static byte[] deriveFieldKey(byte[] fieldRootKey, int offset) {
        if (offset < 0 || offset >= 477218588) { // ONE_THIRD_MAX_INT ~= 1431655765/3
            throw new DbeException("Too many encrypted fields");
        }
        byte[] nonce = fieldKeyNonce(offset * 3);
        return aesCtrStream(fieldRootKey, nonce, FIELD_KEY_SIZE);
    }

    // ---- Field Encryption / Decryption ----

    /**
     * Encrypt a single field value.
     *
     * @param fieldRootKey  32-byte field root key
     * @param offset        field index among ENCRYPT_AND_SIGN fields
     * @param canonicalPath canonical path bytes (used as AAD)
     * @param typeId        2-byte original type ID
     * @param plaintext     field value bytes
     * @return encrypted value: [2B typeId][ciphertext][16B authTag]
     */
    public static byte[] encryptField(byte[] fieldRootKey, int offset,
                                      byte[] canonicalPath, byte[] typeId, byte[] plaintext) {
        byte[] fieldKey = deriveFieldKey(fieldRootKey, offset);
        byte[] cipherKey = Arrays.copyOfRange(fieldKey, 0, KEY_SIZE);
        byte[] nonce = Arrays.copyOfRange(fieldKey, KEY_SIZE, FIELD_KEY_SIZE);

        byte[] ciphertextAndTag = aesGcmEncrypt(cipherKey, nonce, plaintext, canonicalPath);

        // Output: typeId + ciphertext + authTag
        // AES-GCM in Java appends the tag to the ciphertext
        byte[] result = new byte[2 + ciphertextAndTag.length];
        result[0] = typeId[0];
        result[1] = typeId[1];
        System.arraycopy(ciphertextAndTag, 0, result, 2, ciphertextAndTag.length);
        return result;
    }

    /**
     * Decrypt a single field value.
     *
     * @param fieldRootKey  32-byte field root key
     * @param offset        field index among ENCRYPT_AND_SIGN fields
     * @param canonicalPath canonical path bytes (used as AAD)
     * @param encryptedValue encrypted value: [2B typeId][ciphertext][16B authTag]
     * @return decrypted StructuredDataTerminal-compatible pair: [0]=typeId, [1]=plaintext
     */
    public static byte[][] decryptField(byte[] fieldRootKey, int offset,
                                        byte[] canonicalPath, byte[] encryptedValue) {
        if (encryptedValue.length < 2 + AUTH_TAG_SIZE) {
            throw new DbeException("Encrypted value too short");
        }

        byte[] fieldKey = deriveFieldKey(fieldRootKey, offset);
        byte[] cipherKey = Arrays.copyOfRange(fieldKey, 0, KEY_SIZE);
        byte[] nonce = Arrays.copyOfRange(fieldKey, KEY_SIZE, FIELD_KEY_SIZE);

        byte[] typeId = Arrays.copyOfRange(encryptedValue, 0, 2);
        byte[] ciphertextAndTag = Arrays.copyOfRange(encryptedValue, 2, encryptedValue.length);

        byte[] plaintext = aesGcmDecrypt(cipherKey, nonce, ciphertextAndTag, canonicalPath);
        return new byte[][] { typeId, plaintext };
    }

    // ---- HKDF-SHA512 (no salt) ----

    static byte[] hkdfSha512(byte[] ikm, byte[] info, int length) {
        try {
            // Extract: PRK = HMAC-SHA512(salt=zeros, ikm)
            byte[] salt = new byte[64]; // SHA-512 hash length
            Mac extractMac = Mac.getInstance("HmacSHA512");
            extractMac.init(new SecretKeySpec(salt, "HmacSHA512"));
            byte[] prk = extractMac.doFinal(ikm);

            // Expand
            Mac expandMac = Mac.getInstance("HmacSHA512");
            expandMac.init(new SecretKeySpec(prk, "HmacSHA512"));

            int hashLen = 64; // SHA-512 output
            int n = (length + hashLen - 1) / hashLen;
            byte[] okm = new byte[n * hashLen];
            byte[] t = new byte[0];

            for (int i = 1; i <= n; i++) {
                expandMac.reset();
                expandMac.update(t);
                expandMac.update(info);
                expandMac.update((byte) i);
                t = expandMac.doFinal();
                System.arraycopy(t, 0, okm, (i - 1) * hashLen, hashLen);
            }

            return Arrays.copyOf(okm, length);
        } catch (GeneralSecurityException e) {
            throw new DbeException("HKDF-SHA512 failed: " + e.getMessage());
        }
    }

    // ---- AES-256-CTR stream (for field key derivation) ----

    static byte[] aesCtrStream(byte[] key, byte[] iv, int length) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE,
                new SecretKeySpec(key, "AES"),
                new IvParameterSpec(iv));
            // Encrypt zeros to get the keystream
            return cipher.update(new byte[length]);
        } catch (GeneralSecurityException e) {
            throw new DbeException("AES-CTR failed: " + e.getMessage());
        }
    }

    // ---- AES-256-GCM ----

    static byte[] aesGcmEncrypt(byte[] key, byte[] nonce, byte[] plaintext, byte[] aad) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE,
                new SecretKeySpec(key, "AES"),
                new GCMParameterSpec(AUTH_TAG_BITS, nonce));
            cipher.updateAAD(aad);
            return cipher.doFinal(plaintext);
        } catch (GeneralSecurityException e) {
            throw new DbeException("AES-GCM encrypt failed: " + e.getMessage());
        }
    }

    static byte[] aesGcmDecrypt(byte[] key, byte[] nonce, byte[] ciphertextAndTag, byte[] aad) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE,
                new SecretKeySpec(key, "AES"),
                new GCMParameterSpec(AUTH_TAG_BITS, nonce));
            cipher.updateAAD(aad);
            return cipher.doFinal(ciphertextAndTag);
        } catch (GeneralSecurityException e) {
            throw new DbeException("AES-GCM decrypt failed: " + e.getMessage());
        }
    }

    // ---- Field Key Nonce ----

    /**
     * FieldKeyNonce = "AwsDbeField" (11B) + 0x2c (1B) + offset (4B big-endian) = 16 bytes
     */
    static byte[] fieldKeyNonce(int offset) {
        ByteBuffer buf = ByteBuffer.allocate(16);
        buf.put(AES_DBE_FIELD);           // 11 bytes
        buf.put((byte) FIELD_KEY_SIZE);    // 0x2c = 44
        buf.putInt(offset);                // 4 bytes big-endian
        return buf.array();
    }

    // ---- HMAC-SHA384 (for header commitment and footer) ----

    /**
     * Compute HMAC-SHA384.
     */
    public static byte[] hmacSha384(byte[] key, byte[] message) {
        try {
            Mac mac = Mac.getInstance("HmacSHA384");
            mac.init(new SecretKeySpec(key, "HmacSHA384"));
            return mac.doFinal(message);
        } catch (GeneralSecurityException e) {
            throw new DbeException("HMAC-SHA384 failed: " + e.getMessage());
        }
    }

    /**
     * Compute header commitment: first 32 bytes of HMAC-SHA384(commitKey, partialHeaderBytes).
     */
    public static byte[] computeHeaderCommitment(byte[] commitKey, byte[] partialHeaderBytes) {
        byte[] hmac = hmacSha384(commitKey, partialHeaderBytes);
        return Arrays.copyOf(hmac, Header.COMMITMENT_LEN);
    }

    /**
     * Verify header commitment in constant time.
     */
    public static boolean verifyHeaderCommitment(byte[] commitKey, byte[] fullHeaderBytes) {
        byte[] partialBytes = Header.getPartialHeaderBytes(fullHeaderBytes);
        byte[] storedCommitment = Header.getCommitment(fullHeaderBytes);
        byte[] calcCommitment = computeHeaderCommitment(commitKey, partialBytes);
        return constantTimeEquals(storedCommitment, calcCommitment);
    }

    // ---- Constant-time comparison ----

    static boolean constantTimeEquals(byte[] a, byte[] b) {
        if (a.length != b.length) return false;
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result |= a[i] ^ b[i];
        }
        return result == 0;
    }

    // ---- Utility ----

    static byte[] concat(byte[] a, byte[] b) {
        byte[] result = new byte[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
}
