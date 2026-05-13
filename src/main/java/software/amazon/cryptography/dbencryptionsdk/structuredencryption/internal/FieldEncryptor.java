// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.crypto.params.HKDFParameters;

import static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionUtil.*;

/**
 * Handles per-field key derivation and AES-256-GCM encryption/decryption.
 *
 * //= specification/structured-encryption/encrypt-path-structure.md#calculate-cipherkey-and-nonce
 * //# The FieldRootKey is combined with the ordinal position of a field within a record
 * //# to generate a unique FieldKey for encrypting that field.
 */
public final class FieldEncryptor {

  private FieldEncryptor() {}

  /**
   * Derive the FieldRootKey from the plaintext data key and message ID using HKDF-SHA512.
   *
   * //= specification/structured-encryption/encrypt-path-structure.md#calculate-info
   * //# The info used for the HKDF function MUST be
   * //# | "AWS_DBE_DERIVE_KEY" | 18 |
   * //# | Message ID           | 32 |
   */
  public static byte[] deriveFieldRootKey(byte[] plaintextDataKey, byte[] messageId) {
    byte[] info = new byte[DERIVE_KEY_INFO_PREFIX.length + MSG_ID_LEN];
    System.arraycopy(DERIVE_KEY_INFO_PREFIX, 0, info, 0, DERIVE_KEY_INFO_PREFIX.length);
    System.arraycopy(messageId, 0, info, DERIVE_KEY_INFO_PREFIX.length, MSG_ID_LEN);

    HKDFBytesGenerator hkdf = new HKDFBytesGenerator(new SHA512Digest());
    hkdf.init(new HKDFParameters(plaintextDataKey, null, info));
    byte[] fieldRootKey = new byte[KEY_SIZE];
    hkdf.generateBytes(fieldRootKey, 0, KEY_SIZE);
    return fieldRootKey;
  }

  /**
   * Derive a FieldKey (32-byte cipherkey + 12-byte nonce) for a given field offset.
   *
   * //= specification/structured-encryption/encrypt-path-structure.md#calculate-cipherkey-and-nonce
   * //# The FieldKeyNonce for a given offset MUST be 16 bytes comprised of
   * //# | "AwsDbeField" | 11 |
   * //# | 0x2c          | 1  |
   * //# | offset        | 4  |
   * //#
   * //# The FieldKey for a given key and offset MUST be the first 44 bytes
   * //# of the aes256ctr_stream of the FieldRootKey and the FieldKeyNonce of three times the given offset.
   */
  public static byte[] deriveFieldKey(byte[] fieldRootKey, int offset) {
    byte[] nonce = buildFieldKeyNonce(offset * 3);
    return aes256CtrStream(fieldRootKey, nonce, FIELD_KEY_LENGTH);
  }

  /** Extract the 32-byte cipher key from a FieldKey. */
  public static byte[] getCipherKey(byte[] fieldKey) {
    byte[] key = new byte[KEY_SIZE];
    System.arraycopy(fieldKey, 0, key, 0, KEY_SIZE);
    return key;
  }

  /** Extract the 12-byte nonce from a FieldKey. */
  public static byte[] getNonce(byte[] fieldKey) {
    byte[] nonce = new byte[NONCE_SIZE];
    System.arraycopy(fieldKey, KEY_SIZE, nonce, 0, NONCE_SIZE);
    return nonce;
  }

  /**
   * Encrypt a terminal value with AES-256-GCM.
   *
   * //= specification/structured-encryption/encrypt-path-structure.md#encrypted-terminal-value
   * //# The AAD is the canonical path for this Terminal Data.
   */
  public static byte[] encrypt(byte[] cipherKey, byte[] nonce, byte[] plaintext, byte[] aad) {
    try {
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      cipher.init(Cipher.ENCRYPT_MODE,
        new SecretKeySpec(cipherKey, "AES"),
        new GCMParameterSpec(AUTH_TAG_SIZE * 8, nonce));
      cipher.updateAAD(aad);
      return cipher.doFinal(plaintext);
    } catch (GeneralSecurityException e) {
      throw new RuntimeException("AES-GCM encryption failed", e);
    }
  }

  /** Decrypt a terminal value with AES-256-GCM. */
  public static byte[] decrypt(byte[] cipherKey, byte[] nonce, byte[] ciphertext, byte[] aad) {
    try {
      Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
      cipher.init(Cipher.DECRYPT_MODE,
        new SecretKeySpec(cipherKey, "AES"),
        new GCMParameterSpec(AUTH_TAG_SIZE * 8, nonce));
      cipher.updateAAD(aad);
      return cipher.doFinal(ciphertext);
    } catch (GeneralSecurityException e) {
      throw new RuntimeException("AES-GCM decryption failed", e);
    }
  }

  /**
   * Build the 16-byte FieldKeyNonce.
   * //# | "AwsDbeField" | 11 |
   * //# | 0x2c          | 1  | (44, the length of the eventual FieldKey)
   * //# | offset        | 4  | 32-bit integer representation of offset
   */
  private static byte[] buildFieldKeyNonce(int offset) {
    ByteBuffer buf = ByteBuffer.allocate(16);
    buf.put(FIELD_KEY_NONCE_PREFIX); // 11 bytes
    buf.put((byte) 0x2c);           // 1 byte
    buf.putInt(offset);              // 4 bytes
    return buf.array();
  }

  /** AES-256-CTR stream: encrypt zeros to produce a pseudorandom byte stream. */
  private static byte[] aes256CtrStream(byte[] key, byte[] nonce, int length) {
    try {
      Cipher cipher = Cipher.getInstance("AES/CTR/NoPadding");
      // CTR mode uses a 16-byte IV: we use the 16-byte nonce directly
      cipher.init(Cipher.ENCRYPT_MODE,
        new SecretKeySpec(key, "AES"),
        new javax.crypto.spec.IvParameterSpec(nonce));
      return cipher.doFinal(new byte[length]);
    } catch (GeneralSecurityException e) {
      throw new RuntimeException("AES-CTR stream generation failed", e);
    }
  }
}
