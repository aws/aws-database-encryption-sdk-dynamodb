// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internal;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Standard beacon: HMAC-SHA384 truncated to configured bit length, output as hex string.
 *
 * //= specification/searchable-encryption/beacons.md#basichash
 * //# * basicHash MUST calculate the HmacSha384 of the input bytes and the hmac key,
 * //#   and keep the first 8 bytes.
 * //# * basicHash MUST return the rightmost beacon length bits of these 8 bytes as a hexadecimal string.
 */
public final class StandardBeaconImpl {

  private final String name;
  private final int length; // beacon length in bits (1-63)

  public StandardBeaconImpl(String name, int length) {
    if (length < 1 || length > 63) {
      throw new IllegalArgumentException("Beacon length must be between 1 and 63, got: " + length);
    }
    this.name = name;
    this.length = length;
  }

  public String getName() { return name; }
  public int getLength() { return length; }
  public String getBeaconAttributeName() { return "aws_dbe_b_" + name; }

  /**
   * Compute the beacon value for a byte sequence.
   */
  public String hash(byte[] value, byte[] hmacKey) {
    byte[] hmacBytes = computeHmac(value, hmacKey);
    // Keep first 8 bytes
    byte[] truncated = Arrays.copyOf(hmacBytes, 8);
    return bytesToHex(truncated, length);
  }

  /**
   * Compute the beacon value for a string (UTF-8 encoded).
   */
  public String hashStr(String value, byte[] hmacKey) {
    return hash(value.getBytes(StandardCharsets.UTF_8), hmacKey);
  }

  /**
   * HMAC-SHA384 of data with key.
   */
  private static byte[] computeHmac(byte[] data, byte[] key) {
    try {
      Mac mac = Mac.getInstance("HmacSHA384");
      mac.init(new SecretKeySpec(key, "HmacSHA384"));
      return mac.doFinal(data);
    } catch (GeneralSecurityException e) {
      throw new RuntimeException("HMAC-SHA384 computation failed", e);
    }
  }

  /**
   * Extract the rightmost `bitLength` bits from the first 8 bytes and return as hex.
   * Output length = ceil(bitLength / 4).
   */
  private static String bytesToHex(byte[] bytes, int bitLength) {
    // Interpret first 8 bytes as a long
    long value = 0;
    for (int i = 0; i < 8; i++) {
      value = (value << 8) | (bytes[i] & 0xFFL);
    }
    // Mask to keep only rightmost bitLength bits
    long mask = (1L << bitLength) - 1;
    long masked = value & mask;
    // Convert to hex string with proper length
    int hexLen = (bitLength + 3) / 4;
    String hex = Long.toHexString(masked);
    // Pad with leading zeros
    while (hex.length() < hexLen) {
      hex = "0" + hex;
    }
    return hex;
  }
}
