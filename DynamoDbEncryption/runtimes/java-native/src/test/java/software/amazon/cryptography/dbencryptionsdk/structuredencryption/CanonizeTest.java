// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;

class CanonizeTest {

    @Test
    void testSimpleCanonFormat() {
        byte[] canon = Canonize.simpleCanon("myTable", "pk");
        byte[] tableBytes = "myTable".getBytes(StandardCharsets.UTF_8);

        // Starts with UTF8(tableName)
        assertArrayEquals(tableBytes, Arrays.copyOfRange(canon, 0, tableBytes.length));

        // Followed by depth = 1 as uint64
        int pos = tableBytes.length;
        ByteBuffer depthBuf = ByteBuffer.wrap(canon, pos, 8);
        assertEquals(1L, depthBuf.getLong());
        pos += 8;

        // MAP_TAG = 0x24
        assertEquals(0x24, canon[pos] & 0xFF);
        pos++;

        // Key char length as uint64
        ByteBuffer keyLenBuf = ByteBuffer.wrap(canon, pos, 8);
        assertEquals(2L, keyLenBuf.getLong()); // "pk" = 2 chars
        pos += 8;

        // Key bytes
        assertArrayEquals("pk".getBytes(StandardCharsets.UTF_8),
            Arrays.copyOfRange(canon, pos, canon.length));
    }

    @Test
    void testSimpleCanonUnique() {
        byte[] c1 = Canonize.simpleCanon("table", "attr1");
        byte[] c2 = Canonize.simpleCanon("table", "attr2");
        assertFalse(Arrays.equals(c1, c2));
    }

    @Test
    void testSimpleCanonDifferentTables() {
        byte[] c1 = Canonize.simpleCanon("table1", "attr");
        byte[] c2 = Canonize.simpleCanon("table2", "attr");
        assertFalse(Arrays.equals(c1, c2));
    }

    @Test
    void testCanonicalizeSort() {
        // Create items in non-canonical order
        List<CryptoItem> items = new ArrayList<>();
        items.add(makeCryptoItem("zzz", CryptoAction.ENCRYPT_AND_SIGN));
        items.add(makeCryptoItem("aaa", CryptoAction.SIGN_ONLY));
        items.add(makeCryptoItem("mmm", CryptoAction.ENCRYPT_AND_SIGN));

        List<Canonize.CanonField> sorted = Canonize.canonicalize("table", items);

        assertEquals(3, sorted.size());
        // Should be sorted by canonical path: aaa < mmm < zzz
        assertEquals("aaa", sorted.get(0).getOriginalPath().get(0).getKey());
        assertEquals("mmm", sorted.get(1).getOriginalPath().get(0).getKey());
        assertEquals("zzz", sorted.get(2).getOriginalPath().get(0).getKey());
    }

    @Test
    void testCanonicalizePreservesActions() {
        List<CryptoItem> items = new ArrayList<>();
        items.add(makeCryptoItem("b", CryptoAction.ENCRYPT_AND_SIGN));
        items.add(makeCryptoItem("a", CryptoAction.SIGN_ONLY));

        List<Canonize.CanonField> sorted = Canonize.canonicalize("t", items);

        assertEquals(CryptoAction.SIGN_ONLY, sorted.get(0).getAction());
        assertEquals(CryptoAction.ENCRYPT_AND_SIGN, sorted.get(1).getAction());
    }

    @Test
    void testCanonicalizePreservesData() {
        byte[] val = "hello".getBytes(StandardCharsets.UTF_8);
        StructuredDataTerminal terminal = new StructuredDataTerminal(val, new byte[]{0, 1});

        List<CryptoItem> items = new ArrayList<>();
        items.add(new CryptoItem(
            Arrays.asList(new PathSegment("attr")),
            terminal, CryptoAction.SIGN_ONLY));

        List<Canonize.CanonField> sorted = Canonize.canonicalize("t", items);
        assertArrayEquals(val, sorted.get(0).getData().getValue());
    }

    private static CryptoItem makeCryptoItem(String attrName, CryptoAction action) {
        return new CryptoItem(
            Arrays.asList(new PathSegment(attrName)),
            new StructuredDataTerminal(new byte[0], new byte[]{0, 0}),
            action);
    }
}
