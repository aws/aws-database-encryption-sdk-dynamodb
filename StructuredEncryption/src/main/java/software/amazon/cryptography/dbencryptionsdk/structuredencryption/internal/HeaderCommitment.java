// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.crypto.params.HKDFParameters;

import static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionUtil.*;

/**
 * Header commitment: derives a commit key and computes HMAC-SHA384 over the partial header.
 *
 * //= specification/structured-encryption/header.md#commit-key
 * //# The info used for the HKDF function MUST be
 * //# | "AWS_DBE_COMMIT_KEY" | 18 |
 * //# | Message ID           | 32 |
 */
public final class HeaderCommitment {

  private HeaderCommitment() {}

  /**
   * Derive the commit key from the plaintext data key and message ID.
   */
  public static byte[] deriveCommitKey(byte[] plaintextDataKey, byte[] messageId) {
    byte[] info = new byte[COMMIT_KEY_INFO_PREFIX.length + MSG_ID_LEN];
    System.arraycopy(COMMIT_KEY_INFO_PREFIX, 0, info, 0, COMMIT_KEY_INFO_PREFIX.length);
    System.arraycopy(messageId, 0, info, COMMIT_KEY_INFO_PREFIX.length, MSG_ID_LEN);

    HKDFBytesGenerator hkdf = new HKDFBytesGenerator(new SHA512Digest());
    hkdf.init(new HKDFParameters(plaintextDataKey, null, info));
    byte[] commitKey = new byte[KEY_SIZE];
    hkdf.generateBytes(commitKey, 0, KEY_SIZE);
    return commitKey;
  }

  /**
   * Compute the header commitment: first 32 bytes of HMAC-SHA384(commitKey, partialHeader).
   *
   * //= specification/structured-encryption/header.md#commitment-calculation
   * //# The Header Commitment MUST be calculated as a the first 32 bytes of an HmacSha384,
   * //# with the serialized partial header as the message, and the Commit Key as the key.
   */
  public static byte[] computeCommitment(byte[] commitKey, byte[] partialHeader) {
    try {
      Mac mac = Mac.getInstance("HmacSHA384");
      mac.init(new SecretKeySpec(commitKey, "HmacSHA384"));
      byte[] hmac = mac.doFinal(partialHeader);
      return Arrays.copyOf(hmac, 32);
    } catch (GeneralSecurityException e) {
      throw new RuntimeException("HMAC-SHA384 commitment computation failed", e);
    }
  }

  /**
   * Verify header commitment using constant-time comparison.
   *
   * //= specification/structured-encryption/header.md#commitment-verification
   * //# Header commitment comparisons MUST be constant time operations.
   */
  public static boolean verifyCommitment(byte[] commitKey, byte[] partialHeader, byte[] storedCommitment) {
    byte[] computed = computeCommitment(commitKey, partialHeader);
    return constantTimeEquals(computed, storedCommitment);
  }
}
