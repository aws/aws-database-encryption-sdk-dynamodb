// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.ddbconversion;

import java.util.Arrays;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * 2-byte Terminal Type IDs for DynamoDB attribute types used in the
 * DB-ESDK structured encryption format.
 */
public final class TypeId {

  public static final byte[] NULL = new byte[] { 0x00, 0x00 };
  public static final byte[] STRING = new byte[] { 0x00, 0x01 };
  public static final byte[] NUMBER = new byte[] { 0x00, 0x02 };
  public static final byte[] BINARY = new byte[] { (byte) 0xFF, (byte) 0xFF };
  public static final byte[] BOOLEAN = new byte[] { 0x00, 0x04 };
  public static final byte[] STRING_SET = new byte[] { 0x01, 0x01 };
  public static final byte[] NUMBER_SET = new byte[] { 0x01, 0x02 };
  public static final byte[] BINARY_SET = new byte[] { 0x01, (byte) 0xFF };
  public static final byte[] MAP = new byte[] { 0x02, 0x00 };
  public static final byte[] LIST = new byte[] { 0x03, 0x00 };

  /** Type ID for encrypted terminal data and raw binary. */
  public static final byte[] BYTES_TYPE_ID = new byte[] {
    (byte) 0xFF,
    (byte) 0xFF,
  };

  private static final byte[][] ALL_TYPE_IDS = {
    NULL,
    STRING,
    NUMBER,
    BINARY,
    BOOLEAN,
    STRING_SET,
    NUMBER_SET,
    BINARY_SET,
    MAP,
    LIST,
  };

  private TypeId() {}

  /**
   * Returns the 2-byte Terminal Type ID for the given DynamoDB AttributeValue.
   *
   * @throws IllegalArgumentException if the attribute type is unknown
   */
  public static byte[] typeIdForAttributeValue(AttributeValue attr) {
    if (attr.nul() != null && attr.nul()) return NULL;
    if (attr.s() != null) return STRING;
    if (attr.n() != null) return NUMBER;
    if (attr.b() != null) return BINARY;
    if (attr.bool() != null) return BOOLEAN;
    if (attr.hasSs()) return STRING_SET;
    if (attr.hasNs()) return NUMBER_SET;
    if (attr.hasBs()) return BINARY_SET;
    if (attr.hasM()) return MAP;
    if (attr.hasL()) return LIST;
    throw new IllegalArgumentException("Unknown AttributeValue type");
  }

  /**
   * Returns true if the given 2-byte array is a known Terminal Type ID.
   */
  public static boolean isValidTypeId(byte[] typeId) {
    if (typeId == null || typeId.length != 2) return false;
    for (byte[] known : ALL_TYPE_IDS) {
      if (known[0] == typeId[0] && known[1] == typeId[1]) return true;
    }
    return false;
  }
}
