// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment;

/**
 * Computes the canonical byte path for a field within structured data.
 *
 * //= specification/structured-encryption/header.md#canonical-path
 * //# The canonical path MUST start with the UTF8 encoded table name.
 * //# This MUST be followed by the depth of the Terminal within Structured Data.
 * //# This MUST be followed by the encoding for each Structured Data in the path.
 */
public final class CanonicalPath {

  private static final byte MAP_TAG = 0x24; // '$'

  private CanonicalPath() {}

  /**
   * Compute the canonical path for a field.
   * For DB-ESDK, paths are always depth-1 map members (flat DDB items).
   */
  public static byte[] canonPath(String tableName, List<PathSegment> path) {
    byte[] tableBytes = tableName.getBytes(StandardCharsets.UTF_8);
    byte[] depth = uint64ToBytes(path.size());
    byte[] pathBytes = makeCanonicalPath(path);

    ByteBuffer buf = ByteBuffer.allocate(tableBytes.length + 8 + pathBytes.length);
    buf.put(tableBytes);
    buf.put(depth);
    buf.put(pathBytes);
    return buf.array();
  }

  /**
   * Shortcut for a simple top-level attribute (depth=1, single map member).
   */
  public static byte[] simpleCanon(String tableName, String attrName) {
    byte[] tableBytes = tableName.getBytes(StandardCharsets.UTF_8);
    byte[] depth = uint64ToBytes(1);
    byte[] part = canonicalPart(attrName);

    ByteBuffer buf = ByteBuffer.allocate(tableBytes.length + 8 + part.length);
    buf.put(tableBytes);
    buf.put(depth);
    buf.put(part);
    return buf.array();
  }

  /**
   * Encode a single path segment.
   * //= specification/structured-encryption/header.md#canonical-path
   * //# For Structured Data in Structured Data Maps, this MUST be a 0x24 byte ($ in UTF-8),
   * //# followed by the length of the key, followed by the key as a UTF8 string.
   */
  private static byte[] canonicalPart(String key) {
    byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
    ByteBuffer buf = ByteBuffer.allocate(1 + 8 + keyBytes.length);
    buf.put(MAP_TAG);
    buf.putLong(key.length());
    buf.put(keyBytes);
    return buf.array();
  }

  private static byte[] makeCanonicalPath(List<PathSegment> path) {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    for (PathSegment segment : path) {
      byte[] part = canonicalPart(segment.member().key());
      out.write(part, 0, part.length);
    }
    return out.toByteArray();
  }

  private static byte[] uint64ToBytes(long value) {
    ByteBuffer buf = ByteBuffer.allocate(8);
    buf.putLong(value);
    return buf.array();
  }
}
