// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;

/**
 * Canonical path computation and deterministic field ordering for structured encryption.
 *
 * <p>Canonical path format:
 * <pre>
 * UTF8(tableName) + uint64(depth) + for each segment: 0x24 + uint64(keyLen) + UTF8(key)
 * </pre>
 */
public final class Canonize {

    private static final byte MAP_TAG = 0x24; // '$'

    private Canonize() {}

    /** A field with its canonical path, for sorting and crypto operations. */
    public static final class CanonField {
        private final byte[] canonicalPath;
        private final List<PathSegment> originalPath;
        private final StructuredDataTerminal data;
        private final CryptoAction action;

        public CanonField(byte[] canonicalPath, List<PathSegment> originalPath,
                          StructuredDataTerminal data, CryptoAction action) {
            this.canonicalPath = canonicalPath;
            this.originalPath = originalPath;
            this.data = data;
            this.action = action;
        }

        public byte[] getCanonicalPath() { return canonicalPath; }
        public List<PathSegment> getOriginalPath() { return originalPath; }
        public StructuredDataTerminal getData() { return data; }
        public CryptoAction getAction() { return action; }

        /** Return a copy with updated data (used after encryption/decryption). */
        public CanonField withData(StructuredDataTerminal newData) {
            return new CanonField(canonicalPath, originalPath, newData, action);
        }
    }

    /**
     * Compute the canonical path for a top-level attribute.
     *
     * <p>For DB-ESDK, all attributes are at depth 1 with a single map segment.
     * Path = UTF8(tableName) + uint64(1) + 0x24 + uint64(attrNameCharLen) + UTF8(attrName)
     */
    public static byte[] simpleCanon(String tableName, String attrName) {
        byte[] tableBytes = tableName.getBytes(StandardCharsets.UTF_8);
        byte[] attrBytes = attrName.getBytes(StandardCharsets.UTF_8);

        // tableName + depth(8B) + MAP_TAG(1B) + keyCharLen(8B) + key
        ByteBuffer buf = ByteBuffer.allocate(
            tableBytes.length + 8 + 1 + 8 + attrBytes.length);
        buf.put(tableBytes);
        buf.putLong(1L); // depth = 1 for top-level attributes
        buf.put(MAP_TAG);
        buf.putLong((long) attrName.length()); // character length, not byte length
        buf.put(attrBytes);
        return buf.array();
    }

    /**
     * Compute the canonical path for a general path.
     */
    public static byte[] canonPath(String tableName, List<PathSegment> path) {
        byte[] tableBytes = tableName.getBytes(StandardCharsets.UTF_8);
        byte[] pathBytes = makeCanonicalPath(path);

        ByteBuffer buf = ByteBuffer.allocate(tableBytes.length + 8 + pathBytes.length);
        buf.put(tableBytes);
        buf.putLong((long) path.size());
        buf.put(pathBytes);
        return buf.array();
    }

    /**
     * Canonicalize a CryptoList: compute canonical paths and sort by them.
     */
    public static List<CanonField> canonicalize(String tableName, List<CryptoItem> items) {
        List<CanonField> result = new ArrayList<>(items.size());
        for (CryptoItem item : items) {
            byte[] cp = canonPath(tableName, item.getKey());
            result.add(new CanonField(cp, item.getKey(), item.getData(), item.getAction()));
        }
        Collections.sort(result, CANON_COMPARATOR);
        return result;
    }

    /** Sort comparator: lexicographic unsigned byte comparison on canonical paths. */
    static final Comparator<CanonField> CANON_COMPARATOR = new Comparator<CanonField>() {
        @Override
        public int compare(CanonField a, CanonField b) {
            return Header.BYTES_COMPARATOR.compare(a.canonicalPath, b.canonicalPath);
        }
    };

    // ---- Internal ----

    private static byte[] makeCanonicalPath(List<PathSegment> path) {
        int totalSize = 0;
        List<byte[]> parts = new ArrayList<>(path.size());
        for (PathSegment seg : path) {
            byte[] keyBytes = seg.getKey().getBytes(StandardCharsets.UTF_8);
            // MAP_TAG(1) + keyCharLen(8) + keyBytes
            int partSize = 1 + 8 + keyBytes.length;
            byte[] part = new byte[partSize];
            ByteBuffer buf = ByteBuffer.wrap(part);
            buf.put(MAP_TAG);
            buf.putLong((long) seg.getKey().length());
            buf.put(keyBytes);
            parts.add(part);
            totalSize += partSize;
        }

        byte[] result = new byte[totalSize];
        int pos = 0;
        for (byte[] part : parts) {
            System.arraycopy(part, 0, result, pos, part.length);
            pos += part.length;
        }
        return result;
    }
}
