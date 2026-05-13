// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionUtil.*;

/**
 * Verifies the structured encryption footer on decrypt.
 *
 * //= specification/structured-encryption/footer.md#footer-verification
 * //# The footer is verified before its record is decrypted.
 */
public final class FooterVerifier {

  private static final int HMAC_TAG_LEN = 48;
  private static final int ECDSA_SIG_LEN = 96;

  private FooterVerifier() {}

  /**
   * Verify that at least one recipient tag matches.
   *
   * //= specification/structured-encryption/footer.md#recipient-tag-verification
   * //# Verification MUST fail unless at least one of the Recipient Tags
   * //# matches a calculated recipient tag using the provided symmetricSigningKey.
   * //# Recipient Tag comparisons MUST be constant time operations.
   */
  public static boolean verifyRecipientTag(
    byte[] canonicalHash,
    byte[] symmetricSigningKey,
    byte[] footerBytes,
    int edkCount
  ) {
    byte[] expectedTag = computeTag(canonicalHash, symmetricSigningKey);

    for (int i = 0; i < edkCount; i++) {
      int offset = i * HMAC_TAG_LEN;
      byte[] storedTag = Arrays.copyOfRange(footerBytes, offset, offset + HMAC_TAG_LEN);
      if (constantTimeEquals(expectedTag, storedTag)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Verify the ECDSA signature if present.
   *
   * //= specification/structured-encryption/footer.md#signature-verification
   * //# If the footer contains a signature, this signature MUST be verified.
   */
  public static boolean verifySignature(
    byte[] canonicalHash,
    ECPublicKey verificationKey,
    byte[] footerBytes,
    int edkCount
  ) {
    int sigOffset = edkCount * HMAC_TAG_LEN;
    if (footerBytes.length <= sigOffset) {
      return false; // no signature present
    }
    // Signature is everything after the recipient tags (DER-encoded, variable length)
    byte[] signature = Arrays.copyOfRange(footerBytes, sigOffset, footerBytes.length);
    return verifyEcdsa(canonicalHash, verificationKey, signature);
  }

  /** Check if the footer contains a signature (based on length). */
  public static boolean hasSignature(byte[] footerBytes, int edkCount) {
    return footerBytes.length > edkCount * HMAC_TAG_LEN;
  }

  private static byte[] computeTag(byte[] canonicalHash, byte[] symmetricSigningKey) {
    try {
      Mac mac = Mac.getInstance("HmacSHA384");
      mac.init(new SecretKeySpec(symmetricSigningKey, "HmacSHA384"));
      return mac.doFinal(canonicalHash);
    } catch (GeneralSecurityException e) {
      throw new RuntimeException("HMAC verification failed", e);
    }
  }

  private static boolean verifyEcdsa(byte[] canonicalHash, ECPublicKey key, byte[] signature) {
    try {
      Signature sig = Signature.getInstance("NONEwithECDSA");
      sig.initVerify(key);
      sig.update(canonicalHash);
      return sig.verify(signature);
    } catch (GeneralSecurityException e) {
      throw new RuntimeException("ECDSA verification failed", e);
    }
  }

  private static byte[] trimSignature(byte[] padded) {
    // DER signatures end at the actual DER length; find the real end
    // DER: 0x30 <len> ... — total length is 2 + len (for short form)
    if (padded.length < 2 || padded[0] != 0x30) return padded;
    int derLen = padded[1] & 0xFF;
    if (derLen > 127) {
      // long form: 0x81 <len>
      if (padded.length < 3) return padded;
      derLen = padded[2] & 0xFF;
      return Arrays.copyOf(padded, 3 + derLen);
    }
    return Arrays.copyOf(padded, 2 + derLen);
  }
}
