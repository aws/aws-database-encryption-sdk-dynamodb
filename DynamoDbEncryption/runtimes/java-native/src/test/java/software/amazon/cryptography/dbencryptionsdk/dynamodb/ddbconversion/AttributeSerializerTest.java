// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.ddbconversion;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;

/**
 * Tests ported from DynamoToStruct.dfy test suite to validate byte-level
 * compatibility between native Java and Dafny implementations.
 */
class AttributeSerializerTest {

    // ---- Basic type round-trip tests (from TestEncode/TestEncode2) ----

    @Test
    void testStringRoundTrip() {
        AttributeValue sv = AttributeValue.fromS("abc");
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(sv);
        assertArrayEquals(new byte[]{97, 98, 99}, t.getValue());
        assertArrayEquals(new byte[]{0x00, 0x01}, t.getTypeId());
        assertEquals(sv, AttributeSerializer.deserializeAttr(t));
    }

    @Test
    void testNumberRoundTrip() {
        AttributeValue nv = AttributeValue.fromN("123");
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(nv);
        assertArrayEquals(new byte[]{49, 50, 51}, t.getValue());
        assertArrayEquals(new byte[]{0x00, 0x02}, t.getTypeId());
        assertEquals(nv, AttributeSerializer.deserializeAttr(t));
    }

    @Test
    void testBinaryRoundTrip() {
        AttributeValue bv = AttributeValue.fromB(SdkBytes.fromByteArray(new byte[]{1, 2, 3, 4, 5}));
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(bv);
        assertArrayEquals(new byte[]{1, 2, 3, 4, 5}, t.getValue());
        assertArrayEquals(new byte[]{(byte) 0xFF, (byte) 0xFF}, t.getTypeId());
        assertEquals(bv, AttributeSerializer.deserializeAttr(t));
    }

    @Test
    void testNullRoundTrip() {
        AttributeValue nul = AttributeValue.fromNul(true);
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(nul);
        assertArrayEquals(new byte[]{}, t.getValue());
        assertArrayEquals(new byte[]{0x00, 0x00}, t.getTypeId());
        assertEquals(nul, AttributeSerializer.deserializeAttr(t));
    }

    @Test
    void testBoolFalseRoundTrip() {
        AttributeValue bv = AttributeValue.fromBool(false);
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(bv);
        assertArrayEquals(new byte[]{0}, t.getValue());
        assertArrayEquals(new byte[]{0x00, 0x04}, t.getTypeId());
        assertEquals(bv, AttributeSerializer.deserializeAttr(t));
    }

    @Test
    void testBoolTrueRoundTrip() {
        AttributeValue bv = AttributeValue.fromBool(true);
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(bv);
        assertArrayEquals(new byte[]{1}, t.getValue());
        assertArrayEquals(new byte[]{0x00, 0x04}, t.getTypeId());
        assertEquals(bv, AttributeSerializer.deserializeAttr(t));
    }

    // ---- Set tests (from TestEncode2) ----

    @Test
    void testNumberSetRoundTrip() {
        // NS(["123","45"]) -> sorted: "123" < "45" (UTF-16 order: '1' < '4')
        AttributeValue ns = AttributeValue.builder().ns("123", "45").build();
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(ns);
        byte[] expected = new byte[]{
            0, 0, 0, 2,       // count = 2
            0, 0, 0, 3,       // len("123") = 3
            49, 50, 51,        // "123"
            0, 0, 0, 2,       // len("45") = 2
            52, 53             // "45"
        };
        assertArrayEquals(expected, t.getValue());
        assertArrayEquals(new byte[]{0x01, 0x02}, t.getTypeId());
    }

    @Test
    void testStringSetRoundTrip() {
        // SS(["abc","de"]) -> sorted: "abc" < "de"
        AttributeValue ss = AttributeValue.builder().ss("abc", "de").build();
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(ss);
        byte[] expected = new byte[]{
            0, 0, 0, 2,       // count = 2
            0, 0, 0, 3,       // len("abc") = 3
            97, 98, 99,        // "abc"
            0, 0, 0, 2,       // len("de") = 2
            100, 101           // "de"
        };
        assertArrayEquals(expected, t.getValue());
        assertArrayEquals(new byte[]{0x01, 0x01}, t.getTypeId());
    }

    @Test
    void testBinarySetRoundTrip() {
        // BS([[1,2,3],[4,5]]) -> sorted: [1,2,3] < [4,5]
        AttributeValue bs = AttributeValue.builder()
            .bs(SdkBytes.fromByteArray(new byte[]{1, 2, 3}),
                SdkBytes.fromByteArray(new byte[]{4, 5}))
            .build();
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(bs);
        byte[] expected = new byte[]{
            0, 0, 0, 2,       // count = 2
            0, 0, 0, 3,       // len = 3
            1, 2, 3,
            0, 0, 0, 2,       // len = 2
            4, 5
        };
        assertArrayEquals(expected, t.getValue());
        assertArrayEquals(new byte[]{0x01, (byte) 0xFF}, t.getTypeId());
    }

    // ---- List test (from TestEncode) ----

    @Test
    void testListRoundTrip() {
        AttributeValue binaryVal = AttributeValue.fromB(SdkBytes.fromByteArray(new byte[]{1, 2, 3, 4, 5}));
        AttributeValue nullVal = AttributeValue.fromNul(true);
        AttributeValue boolVal = AttributeValue.fromBool(false);
        AttributeValue listVal = AttributeValue.builder().l(binaryVal, nullVal, boolVal).build();

        StructuredDataTerminal t = AttributeSerializer.serializeAttr(listVal);
        byte[] expected = new byte[]{
            0, 0, 0, 3,                         // count = 3
            (byte) 0xFF, (byte) 0xFF,            // type: Binary
            0, 0, 0, 5,                          // len = 5
            1, 2, 3, 4, 5,                       // binary value
            0, 0,                                // type: Null
            0, 0, 0, 0,                          // len = 0
            0, 4,                                // type: Boolean
            0, 0, 0, 1,                          // len = 1
            0                                    // false
        };
        assertArrayEquals(expected, t.getValue());
        assertArrayEquals(new byte[]{0x03, 0x00}, t.getTypeId());
        assertEquals(listVal, AttributeSerializer.deserializeAttr(t));
    }

    // ---- Map test (from TestEncode) ----

    @Test
    void testMapRoundTrip() {
        byte k = 'k', e = 'e', y = 'y', A = 'A', B = 'B', C = 'C', D = 'D';

        AttributeValue binaryVal = AttributeValue.fromB(SdkBytes.fromByteArray(new byte[]{1, 2, 3, 4, 5}));
        AttributeValue nullVal = AttributeValue.fromNul(true);
        AttributeValue boolVal = AttributeValue.fromBool(false);
        AttributeValue listVal = AttributeValue.builder().l(binaryVal, nullVal, boolVal).build();

        Map<String, AttributeValue> m = new LinkedHashMap<>();
        m.put("keyA", binaryVal);
        m.put("keyB", nullVal);
        m.put("keyC", boolVal);
        m.put("keyD", listVal);
        AttributeValue mapVal = AttributeValue.builder().m(m).build();

        StructuredDataTerminal t = AttributeSerializer.serializeAttr(mapVal);
        byte[] expected = new byte[]{
            0, 0, 0, 4,
            // keyA -> binary
            0, 1, 0, 0, 0, 4, k, e, y, A, (byte) 0xFF, (byte) 0xFF, 0, 0, 0, 5, 1, 2, 3, 4, 5,
            // keyB -> null
            0, 1, 0, 0, 0, 4, k, e, y, B, 0, 0, 0, 0, 0, 0,
            // keyC -> bool(false)
            0, 1, 0, 0, 0, 4, k, e, y, C, 0, 4, 0, 0, 0, 1, 0,
            // keyD -> list
            0, 1, 0, 0, 0, 4, k, e, y, D, 3, 0, 0, 0, 0, 28,
            0, 0, 0, 3, (byte) 0xFF, (byte) 0xFF, 0, 0, 0, 5, 1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 1, 0
        };
        assertArrayEquals(expected, t.getValue());
        assertArrayEquals(new byte[]{0x02, 0x00}, t.getTypeId());
        assertEquals(mapVal, AttributeSerializer.deserializeAttr(t));
    }

    // ---- Number normalization tests (from TestNormalizeNAttr, etc.) ----

    @Test
    void testNormalizeNumberInAttr() {
        AttributeValue nv = AttributeValue.fromN("000123.000");
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(nv);
        // "123" = [49, 50, 51]
        assertArrayEquals(new byte[]{49, 50, 51}, t.getValue());
        // Deserializing gives back the normalized form
        AttributeValue result = AttributeSerializer.deserializeAttr(t);
        assertEquals("123", result.n());
    }

    @Test
    void testNormalizeNumberInSet() {
        AttributeValue ns = AttributeValue.builder().ns("001.00").build();
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(ns);
        byte[] expected = new byte[]{
            0, 0, 0, 1,   // count = 1
            0, 0, 0, 1,   // len = 1
            49             // "1"
        };
        assertArrayEquals(expected, t.getValue());
    }

    @Test
    void testNormalizeNumberInList() {
        AttributeValue nv = AttributeValue.fromN("001.00");
        AttributeValue listVal = AttributeValue.builder().l(nv).build();
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(listVal);
        byte[] expected = new byte[]{
            0, 0, 0, 1,   // 1 member
            0, 2,          // type: Number
            0, 0, 0, 1,   // len = 1
            49             // "1"
        };
        assertArrayEquals(expected, t.getValue());
    }

    @Test
    void testNormalizeNumberInMap() {
        byte k = 'k', e = 'e', y = 'y', A = 'A';
        Map<String, AttributeValue> m = Collections.singletonMap(
            "keyA", AttributeValue.fromN("001.00"));
        AttributeValue mapVal = AttributeValue.builder().m(m).build();
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(mapVal);
        byte[] expected = new byte[]{
            0, 0, 0, 1,                       // 1 entry
            0, 1, 0, 0, 0, 4, k, e, y, A,     // key: "keyA"
            0, 2, 0, 0, 0, 1,                 // value type: Number, len = 1
            49                                 // "1"
        };
        assertArrayEquals(expected, t.getValue());
    }

    // ---- Sorting tests ----

    @Test
    void testSortNumberSet() {
        // NS(["1","2","10"]) -> sorted by UTF-16 order: "1" < "10" < "2"
        AttributeValue ns = AttributeValue.builder().ns("1", "2", "10").build();
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(ns);
        byte[] expected = new byte[]{
            0, 0, 0, 3,       // count = 3
            0, 0, 0, 1, 49,   // "1"
            0, 0, 0, 2, 49, 48, // "10"
            0, 0, 0, 1, 50    // "2"
        };
        assertArrayEquals(expected, t.getValue());
    }

    @Test
    void testSortNumberSetAfterNormalize() {
        // NS(["1","02","10"]) -> normalize "02" to "2", then sort: "1" < "10" < "2"
        AttributeValue ns = AttributeValue.builder().ns("1", "02", "10").build();
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(ns);
        byte[] expected = new byte[]{
            0, 0, 0, 3,
            0, 0, 0, 1, 49,     // "1"
            0, 0, 0, 2, 49, 48, // "10"
            0, 0, 0, 1, 50      // "2"
        };
        assertArrayEquals(expected, t.getValue());
    }

    @Test
    void testSortStringSetUtf16Order() {
        // SS(["&","｡","𐀂"]) -> UTF-16 order: "&" (0x0026) < "𐀂" (0xD800,0xDC02) < "｡" (0xFF61)
        AttributeValue ss = AttributeValue.builder().ss("&", "｡", "\uD800\uDC02").build();
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(ss);
        byte[] expected = new byte[]{
            0, 0, 0, 3,                                     // count = 3
            0, 0, 0, 1, 0x26,                               // "&" UTF-8
            0, 0, 0, 4, (byte) 0xF0, (byte) 0x90, (byte) 0x80, (byte) 0x82, // "𐀂" UTF-8
            0, 0, 0, 3, (byte) 0xEF, (byte) 0xBD, (byte) 0xA1  // "｡" UTF-8
        };
        assertArrayEquals(expected, t.getValue());
    }

    @Test
    void testSortBinarySet() {
        // BS([[1],[2],[1,0]]) -> sorted: [1] < [1,0] < [2]
        AttributeValue bs = AttributeValue.builder()
            .bs(SdkBytes.fromByteArray(new byte[]{1}),
                SdkBytes.fromByteArray(new byte[]{2}),
                SdkBytes.fromByteArray(new byte[]{1, 0}))
            .build();
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(bs);
        byte[] expected = new byte[]{
            0, 0, 0, 3,
            0, 0, 0, 1, 1,       // [1]
            0, 0, 0, 2, 1, 0,    // [1,0]
            0, 0, 0, 1, 2        // [2]
        };
        assertArrayEquals(expected, t.getValue());
    }

    @Test
    void testSortMapKeysUtf16Order() {
        // Map keys: "&", "｡", "𐀂" -> UTF-16 order: "&" < "𐀂" < "｡"
        AttributeValue nullVal = AttributeValue.fromNul(true);
        Map<String, AttributeValue> m = new LinkedHashMap<>();
        m.put("&", nullVal);
        m.put("｡", nullVal);
        m.put("\uD800\uDC02", nullVal);
        AttributeValue mapVal = AttributeValue.builder().m(m).build();

        StructuredDataTerminal t = AttributeSerializer.serializeAttr(mapVal);
        byte[] expected = new byte[]{
            0, 0, 0, 3,
            // "&"
            0, 1, 0, 0, 0, 1, 0x26, 0, 0, 0, 0, 0, 0,
            // "𐀂"
            0, 1, 0, 0, 0, 4, (byte) 0xF0, (byte) 0x90, (byte) 0x80, (byte) 0x82, 0, 0, 0, 0, 0, 0,
            // "｡"
            0, 1, 0, 0, 0, 3, (byte) 0xEF, (byte) 0xBD, (byte) 0xA1, 0, 0, 0, 0, 0, 0
        };
        assertArrayEquals(expected, t.getValue());
    }

    // ---- Duplicate detection tests (from TestBadDupKeys) ----

    @Test
    void testDuplicateStringSetFails() {
        AttributeValue ss = AttributeValue.builder().ss("abc", "abc").build();
        assertThrows(DbeException.class, () -> AttributeSerializer.serializeAttr(ss));
    }

    @Test
    void testDuplicateNumberSetFails() {
        // "1" and "01" normalize to the same value
        AttributeValue ns = AttributeValue.builder().ns("1", "01").build();
        assertThrows(DbeException.class, () -> AttributeSerializer.serializeAttr(ns));
    }

    @Test
    void testDuplicateBinarySetFails() {
        AttributeValue bs = AttributeValue.builder()
            .bs(SdkBytes.fromByteArray(new byte[]{1, 2}),
                SdkBytes.fromByteArray(new byte[]{1, 2}))
            .build();
        assertThrows(DbeException.class, () -> AttributeSerializer.serializeAttr(bs));
    }

    // ---- Deserialization failure tests (from TestZeroBytes, TestBadType, TestBadLength) ----

    @Test
    void testDeserializeZeroBytesNull() {
        // NULL with zero bytes should succeed
        AttributeValue result = AttributeSerializer.deserializeValue(TypeId.NULL, new byte[]{});
        assertTrue(result.nul());
    }

    @Test
    void testDeserializeZeroBytesString() {
        // Empty string should succeed
        AttributeValue result = AttributeSerializer.deserializeValue(TypeId.STRING, new byte[]{});
        assertEquals("", result.s());
    }

    @Test
    void testDeserializeZeroBytesBoolFails() {
        assertThrows(DbeException.class,
            () -> AttributeSerializer.deserializeValue(TypeId.BOOLEAN, new byte[]{}));
    }

    @Test
    void testDeserializeZeroBytesSetFails() {
        // Sets need at least 4 bytes for count
        assertThrows(Exception.class,
            () -> AttributeSerializer.deserializeValue(TypeId.STRING_SET, new byte[]{}));
    }

    // ---- Depth limit tests (from TestMaxDepth, TestTooDeep) ----

    @Test
    void testMaxDepthSucceeds() {
        // Build a structure 31 levels deep (alternating map/list), which is within the 32 limit
        AttributeValue value = AttributeValue.fromS("hello");
        for (int i = 0; i < 31; i++) {
            if (i % 2 == 0) {
                value = AttributeValue.builder()
                    .m(Collections.singletonMap("key", value)).build();
            } else {
                value = AttributeValue.builder()
                    .l(value).build();
            }
        }
        // Should not throw
        StructuredDataTerminal t = AttributeSerializer.serializeAttr(value);
        AttributeValue result = AttributeSerializer.deserializeAttr(t);
        assertNotNull(result);
    }

    @Test
    void testTooDeepFails() {
        // Build a structure 33 levels deep, exceeding the 32 limit
        AttributeValue value = AttributeValue.fromS("hello");
        for (int i = 0; i < 33; i++) {
            if (i % 2 == 0) {
                value = AttributeValue.builder()
                    .m(Collections.singletonMap("key", value)).build();
            } else {
                value = AttributeValue.builder()
                    .l(value).build();
            }
        }
        AttributeValue tooDeep = value;
        assertThrows(DbeException.class, () -> AttributeSerializer.serializeAttr(tooDeep));
    }

    // ---- Full round-trip test (from TestRoundTrip) ----

    @Test
    void testFullRoundTrip() {
        AttributeValue val1 = AttributeValue.fromS("astring");
        AttributeValue val2 = AttributeValue.fromN("12345");
        AttributeValue val3 = AttributeValue.fromB(SdkBytes.fromByteArray(new byte[]{1, 2, 3, 4, 5}));
        AttributeValue val4 = AttributeValue.fromBool(true);
        AttributeValue val5 = AttributeValue.fromNul(true);
        AttributeValue val6 = AttributeValue.builder()
            .bs(SdkBytes.fromByteArray(new byte[]{1, 2, 3, 4, 5}),
                SdkBytes.fromByteArray(new byte[]{2, 3, 4, 5, 6}),
                SdkBytes.fromByteArray(new byte[]{3, 4, 5, 6, 7}))
            .build();
        AttributeValue val7 = AttributeValue.builder().ss("ab", "cdef", "ghijk").build();
        AttributeValue val8 = AttributeValue.builder().ns("0", "1", "234.567").build();

        AttributeValue val9a = AttributeValue.builder().l(val8, val7, val6).build();
        AttributeValue val9b = AttributeValue.builder().l(val5, val4, val3).build();
        AttributeValue val9c = AttributeValue.builder().l(val2, val1).build();
        AttributeValue val9 = AttributeValue.builder().l(val9a, val9b, val9c).build();

        Map<String, AttributeValue> mapEntries = new LinkedHashMap<>();
        mapEntries.put("key1", val1);
        mapEntries.put("key2", val2);
        mapEntries.put("key3", val3);
        mapEntries.put("key4", val4);
        mapEntries.put("key5", val5);
        mapEntries.put("key6", val6);
        mapEntries.put("key7", val7);
        mapEntries.put("key8", val8);
        mapEntries.put("key9", val9);
        AttributeValue val10 = AttributeValue.builder().m(mapEntries).build();

        // Serialize and deserialize each value
        for (AttributeValue v : Arrays.asList(val1, val2, val3, val4, val5, val6, val7, val8, val9, val10)) {
            StructuredDataTerminal t = AttributeSerializer.serializeAttr(v);
            AttributeValue roundTripped = AttributeSerializer.deserializeAttr(t);
            // For sets, the round-trip normalizes ordering, so we compare serialized form
            StructuredDataTerminal t2 = AttributeSerializer.serializeAttr(roundTripped);
            assertArrayEquals(t.getValue(), t2.getValue(),
                "Round-trip serialization mismatch for " + v);
            assertArrayEquals(t.getTypeId(), t2.getTypeId());
        }
    }
}
