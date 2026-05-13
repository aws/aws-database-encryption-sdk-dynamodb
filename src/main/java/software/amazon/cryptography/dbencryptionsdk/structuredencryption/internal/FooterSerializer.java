// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionUtil.*;

/**
 * Serializes the structured encryption footer.
 *
 * //= specification/structured-encryption/footer.md#footer-format
 * //# | Recipient Tags | Variable. 48 bytes per EDK |
 * //# | Signature      | 0 or 96                    |
 */
public final class FooterSerializer {

  private static final int HMAC_TAG_LEN = 48; // HMAC-SHA384 output
  private static final int ECDSA_SIG_LEN = 96;
  private static final byte[] ENCRYPTED_LABEL = "ENCRYPTED".getBytes(StandardCharsets.US_ASCII);
  private static final byte[] PLAINTEXT_LABEL = "PLAINTEXT".getBytes(StandardCharsets.US_ASCII);

  private FooterSerializer() {}

  /**
   * A signed field for canonical hash computation.
   */
  public static final class SignedField {
    public final byte[] canonicalPath;
    public final byte[] typeId;
    public final byte[] value;
    public final boolean encrypted;

    public SignedField(byte[] canonicalPath, byte[] typeId, byte[] value, boolean encrypted) {
      this.canonicalPath = canonicalPath;
      this.typeId = typeId;
      this.value = value;
      this.encrypted = encrypted;
    }
  }

  /**
   * Compute the canonical hash (SHA-384) of the record.
   *
   * //= specification/structured-encryption/footer.md#canonical-record
   * //# | header    | Variable |
   * //# | AAD Length | 8       |
   * //# | AAD       | Variable | serialization of EC from encryption materials |
   * //# | Field Data | Variable | for each signed field, ordered by canonical path |
   */
  public static byte[] computeCanonicalHash(
    byte[] fullHeader,
    Map<String, String> encryptionContext,
    List<SignedField> signedFields // must already be sorted by canonical path
  ) {
    try {
      MessageDigest sha384 = MessageDigest.getInstance("SHA-384");
      sha384.update(fullHeader);

      byte[] aad = serializeEncryptionContextForAAD(encryptionContext);
      sha384.update(longToBytes(aad.length));
      sha384.update(aad);

      for (SignedField field : signedFields) {
        sha384.update(field.canonicalPath);
        long dataLen = field.encrypted
          ? field.value.length - 2  // encrypted form starts with 2-byte original typeId
          : field.value.length;
        sha384.update(longToBytes(dataLen));
        sha384.update(field.encrypted ? ENCRYPTED_LABEL : PLAINTEXT_LABEL);
        sha384.update(field.typeId);
        sha384.update(field.value);
      }

      return sha384.digest();
    } catch (GeneralSecurityException e) {
      throw new RuntimeException("SHA-384 computation failed", e);
    }
  }

  /**
   * Compute HMAC-SHA384 recipient tags.
   *
   * //= specification/structured-encryption/footer.md#recipient-tags
   * //# There MUST be one Recipient Tag for each Encrypted Data Key in the header.
   */
  public static byte[] computeRecipientTags(byte[] canonicalHash, List<byte[]> symmetricSigningKeys) {
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      for (byte[] signingKey : symmetricSigningKeys) {
        Mac mac = Mac.getInstance("HmacSHA384");
        mac.init(new SecretKeySpec(signingKey, "HmacSHA384"));
        byte[] tag = mac.doFinal(canonicalHash);
        out.write(tag);
      }
      return out.toByteArray();
    } catch (GeneralSecurityException | IOException e) {
      throw new RuntimeException("HMAC recipient tag computation failed", e);
    }
  }

  /**
   * Compute ECDSA-P384 signature over the canonical hash.
   *
   * //= specification/structured-encryption/footer.md#signature
   * //# The signature MUST be included in the footer if the flavor in the header is 0x01.
   */
  public static byte[] computeSignature(byte[] canonicalHash, ECPrivateKey signingKey) {
    try {
      // canonicalHash is already SHA-384, so use NONEwithECDSA to avoid double-hashing
      Signature sig = Signature.getInstance("NONEwithECDSA");
      sig.initSign(signingKey);
      sig.update(canonicalHash);
      return sig.sign(); // Return raw DER-encoded signature
    } catch (GeneralSecurityException e) {
      throw new RuntimeException("ECDSA signature computation failed", e);
    }
  }

  /**
   * Serialize the complete footer.
   */
  public static byte[] serializeFooter(byte[] recipientTags, byte[] signature) {
    if (signature == null) {
      return recipientTags;
    }
    byte[] footer = new byte[recipientTags.length + signature.length];
    System.arraycopy(recipientTags, 0, footer, 0, recipientTags.length);
    System.arraycopy(signature, 0, footer, recipientTags.length, signature.length);
    return footer;
  }

  private static byte[] serializeEncryptionContextForAAD(Map<String, String> ec) {
    // Same format as header EC serialization: sorted key-value pairs
    TreeMap<String, String> sorted = new TreeMap<>((a, b) -> {
      byte[] ab = a.getBytes(StandardCharsets.UTF_8);
      byte[] bb = b.getBytes(StandardCharsets.UTF_8);
      return compareBytes(ab, bb);
    });
    sorted.putAll(ec);

    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      for (Map.Entry<String, String> entry : sorted.entrySet()) {
        byte[] k = entry.getKey().getBytes(StandardCharsets.UTF_8);
        byte[] v = entry.getValue().getBytes(StandardCharsets.UTF_8);
        out.write((k.length >> 8) & 0xFF);
        out.write(k.length & 0xFF);
        out.write(k);
        out.write((v.length >> 8) & 0xFF);
        out.write(v.length & 0xFF);
        out.write(v);
      }
      return out.toByteArray();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static int compareBytes(byte[] a, byte[] b) {
    int len = Math.min(a.length, b.length);
    for (int i = 0; i < len; i++) {
      int cmp = (a[i] & 0xFF) - (b[i] & 0xFF);
      if (cmp != 0) return cmp;
    }
    return a.length - b.length;
  }

  private static byte[] longToBytes(long value) {
    ByteBuffer buf = ByteBuffer.allocate(8);
    buf.putLong(value);
    return buf.array();
  }

  private static byte[] padSignature(byte[] sig, int targetLen) {
    if (sig.length == targetLen) return sig;
    if (sig.length > targetLen) {
      byte[] padded = new byte[targetLen];
      System.arraycopy(sig, 0, padded, 0, targetLen);
      return padded;
    }
    byte[] padded = new byte[targetLen];
    System.arraycopy(sig, 0, padded, 0, sig.length);
    return padded;
  }
}
