// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructureSegment;

public final class StructuredEncryptionUtil {

  private StructuredEncryptionUtil() {}

  // Reserved prefix for implementation attributes
  public static final String RESERVED_PREFIX = "aws_dbe_";
  public static final String HEADER_FIELD = RESERVED_PREFIX + "head";
  public static final String FOOTER_FIELD = RESERVED_PREFIX + "foot";

  public static final List<PathSegment> HEADER_PATH = Arrays.asList(
    PathSegment.builder().member(StructureSegment.builder().key(HEADER_FIELD).build()).build()
  );
  public static final List<PathSegment> FOOTER_PATH = Arrays.asList(
    PathSegment.builder().member(StructureSegment.builder().key(FOOTER_FIELD).build()).build()
  );

  // Encryption context prefixes
  public static final String RESERVED_CRYPTO_CONTEXT_PREFIX = "aws-crypto-";
  public static final String ATTR_PREFIX = RESERVED_CRYPTO_CONTEXT_PREFIX + "attr.";
  public static final String LEGEND_KEY = RESERVED_CRYPTO_CONTEXT_PREFIX + "legend";

  // Legend characters for SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
  public static final char LEGEND_STRING = 'S';
  public static final char LEGEND_NUMBER = 'N';
  public static final char LEGEND_LITERAL = 'L';
  public static final char LEGEND_BINARY = 'B';

  // Terminal Type ID for raw bytes (encrypted fields)
  public static final byte[] BYTES_TYPE_ID = new byte[] { (byte) 0xFF, (byte) 0xFF };

  // DDB Attribute Type IDs
  public static final byte[] NULL_TYPE_ID     = new byte[] { 0x00, 0x00 };
  public static final byte[] STRING_TYPE_ID   = new byte[] { 0x00, 0x01 };
  public static final byte[] NUMBER_TYPE_ID   = new byte[] { 0x00, 0x02 };
  public static final byte[] BOOLEAN_TYPE_ID  = new byte[] { 0x00, 0x04 };
  public static final byte[] STRING_SET_TYPE_ID = new byte[] { 0x01, 0x01 };
  public static final byte[] NUMBER_SET_TYPE_ID = new byte[] { 0x01, 0x02 };
  public static final byte[] BINARY_SET_TYPE_ID = new byte[] { 0x01, (byte) 0xFF };
  public static final byte[] MAP_TYPE_ID      = new byte[] { 0x02, 0x00 };
  public static final byte[] LIST_TYPE_ID     = new byte[] { 0x03, 0x00 };

  // Crypto sizes
  public static final int KEY_SIZE = 32;
  public static final int NONCE_SIZE = 12;
  public static final int AUTH_TAG_SIZE = 16;
  public static final int MSG_ID_LEN = 32;

  // Header format
  public static final byte DBE_ALGORITHM_FAMILY = 0x67;
  public static final byte FORMAT_VERSION_1 = 0x01;
  public static final byte FORMAT_VERSION_2 = 0x02;
  public static final byte FLAVOR_NO_SIGNATURE = 0x00;
  public static final byte FLAVOR_WITH_SIGNATURE = 0x01;

  // Encrypt legend bytes
  public static final byte ENCRYPT_AND_SIGN_LEGEND = 0x65; // 'e'
  public static final byte SIGN_ONLY_LEGEND = 0x73;        // 's'
  public static final byte CONTEXT_LEGEND = 0x63;          // 'c'

  // HKDF info strings
  public static final byte[] DERIVE_KEY_INFO_PREFIX = "AWS_DBE_DERIVE_KEY".getBytes(StandardCharsets.UTF_8);
  public static final byte[] COMMIT_KEY_INFO_PREFIX = "AWS_DBE_COMMIT_KEY".getBytes(StandardCharsets.UTF_8);

  // Field key derivation
  public static final byte[] FIELD_KEY_NONCE_PREFIX = "AwsDbeField".getBytes(StandardCharsets.UTF_8);
  public static final int FIELD_KEY_LENGTH = 44; // 32 (cipherkey) + 12 (nonce)

  /** Check if a CryptoAction is authenticated (not DO_NOTHING). */
  public static boolean isAuthAttr(CryptoAction action) {
    return !CryptoAction.DO_NOTHING.equals(action);
  }

  /** Constant-time byte array comparison. */
  public static boolean constantTimeEquals(byte[] a, byte[] b) {
    return MessageDigest.isEqual(a, b);
  }

  /** Write a 2-byte big-endian unsigned short into a buffer. */
  public static void writeUint16(ByteBuffer buf, int value) {
    buf.putShort((short) (value & 0xFFFF));
  }

  /** Read a 2-byte big-endian unsigned short from a buffer. */
  public static int readUint16(ByteBuffer buf) {
    return buf.getShort() & 0xFFFF;
  }

  /** Write a 1-byte unsigned value. */
  public static void writeUint8(ByteBuffer buf, int value) {
    buf.put((byte) (value & 0xFF));
  }

  /** Read a 1-byte unsigned value. */
  public static int readUint8(ByteBuffer buf) {
    return buf.get() & 0xFF;
  }
}
