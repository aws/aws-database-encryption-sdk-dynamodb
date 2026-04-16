// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

class HeaderTest {

    // ---- Legend ----

    @Test
    void testBuildLegend() {
        List<CryptoAction> actions = Arrays.asList(
            CryptoAction.ENCRYPT_AND_SIGN,
            CryptoAction.SIGN_ONLY,
            CryptoAction.DO_NOTHING,
            CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
        );
        byte[] legend = Header.buildLegend(actions);
        // DO_NOTHING is excluded
        assertArrayEquals(new byte[]{0x65, 0x73, 0x63}, legend);
    }

    @Test
    void testBuildLegendAllDoNothing() {
        List<CryptoAction> actions = Arrays.asList(CryptoAction.DO_NOTHING, CryptoAction.DO_NOTHING);
        byte[] legend = Header.buildLegend(actions);
        assertEquals(0, legend.length);
    }

    @Test
    void testVersionForActions() {
        assertEquals(1, Header.versionForActions(Arrays.asList(
            CryptoAction.ENCRYPT_AND_SIGN, CryptoAction.SIGN_ONLY)));
        assertEquals(2, Header.versionForActions(Arrays.asList(
            CryptoAction.ENCRYPT_AND_SIGN, CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT)));
    }

    // ---- Legend serialization round-trip ----

    @Test
    void testSerializeLegendRoundTrip() {
        byte[] legend = new byte[]{0x65, 0x73, 0x63};
        byte[] serialized = Header.serializeLegend(legend);
        // [0x00, 0x03, 0x65, 0x73, 0x63]
        assertEquals(5, serialized.length);
        assertEquals(0, serialized[0]);
        assertEquals(3, serialized[1]);
        assertArrayEquals(legend, Arrays.copyOfRange(serialized, 2, 5));
    }

    @Test
    void testSerializeLegendEmpty() {
        byte[] serialized = Header.serializeLegend(new byte[0]);
        assertArrayEquals(new byte[]{0, 0}, serialized);
    }

    // ---- Context serialization round-trip ----

    @Test
    void testSerializeContextRoundTrip() {
        Map<byte[], byte[]> ctx = new LinkedHashMap<>();
        ctx.put("aws-crypto-table".getBytes(StandardCharsets.UTF_8),
                "myTable".getBytes(StandardCharsets.UTF_8));
        ctx.put("aws-crypto-pk".getBytes(StandardCharsets.UTF_8),
                "pk1".getBytes(StandardCharsets.UTF_8));

        byte[] serialized = Header.serializeContext(ctx);
        // Count = 2
        assertEquals(0, serialized[0]);
        assertEquals(2, serialized[1]);
        // Keys should be sorted by byte value: "aws-crypto-pk" < "aws-crypto-table"
        // First key after count should be "aws-crypto-pk"
        int pos = 2;
        int keyLen = ((serialized[pos] & 0xFF) << 8) | (serialized[pos + 1] & 0xFF);
        String firstKey = new String(serialized, pos + 2, keyLen, StandardCharsets.UTF_8);
        assertEquals("aws-crypto-pk", firstKey);
    }

    @Test
    void testSerializeContextEmpty() {
        Map<byte[], byte[]> ctx = new LinkedHashMap<>();
        byte[] serialized = Header.serializeContext(ctx);
        assertArrayEquals(new byte[]{0, 0}, serialized);
    }

    // ---- Data keys serialization round-trip ----

    @Test
    void testSerializeDataKeysRoundTrip() {
        Header.EncryptedDataKey edk = new Header.EncryptedDataKey(
            "aws-kms".getBytes(StandardCharsets.UTF_8),
            "arn:aws:kms:us-east-1:123456789:key/abc".getBytes(StandardCharsets.UTF_8),
            new byte[]{1, 2, 3, 4, 5}
        );
        byte[] serialized = Header.serializeDataKeys(Arrays.asList(edk));
        // First byte = count = 1
        assertEquals(1, serialized[0] & 0xFF);
        // Then: 2B provIdLen + provId + 2B provInfoLen + provInfo + 2B cipherLen + cipher
        int pos = 1;
        int provIdLen = ((serialized[pos] & 0xFF) << 8) | (serialized[pos + 1] & 0xFF);
        assertEquals(7, provIdLen); // "aws-kms" = 7 bytes
    }

    @Test
    void testSerializeDataKeysEmpty() {
        assertThrows(DbeException.class, () ->
            Header.serializeDataKeys(new ArrayList<>()));
    }

    // ---- Full header round-trip ----

    @Test
    void testPartialHeaderSerializeDeserializeRoundTrip() {
        byte[] msgID = new byte[32];
        new SecureRandom().nextBytes(msgID);

        byte[] legend = new byte[]{0x65, 0x73, 0x63};

        Map<byte[], byte[]> ctx = new LinkedHashMap<>();
        ctx.put("key1".getBytes(StandardCharsets.UTF_8), "val1".getBytes(StandardCharsets.UTF_8));

        Header.EncryptedDataKey edk = new Header.EncryptedDataKey(
            "prov".getBytes(StandardCharsets.UTF_8),
            "info".getBytes(StandardCharsets.UTF_8),
            new byte[]{10, 20, 30}
        );

        Header.PartialHeader original = new Header.PartialHeader(
            (byte) 1, (byte) 0, msgID, legend, ctx, Arrays.asList(edk));

        byte[] partialBytes = original.serialize();

        // Append a fake 32-byte commitment to make a "full header"
        byte[] commitment = new byte[32];
        Arrays.fill(commitment, (byte) 0xAB);
        byte[] fullHeader = new byte[partialBytes.length + 32];
        System.arraycopy(partialBytes, 0, fullHeader, 0, partialBytes.length);
        System.arraycopy(commitment, 0, fullHeader, partialBytes.length, 32);

        // Deserialize
        Header.PartialHeader parsed = Header.deserialize(fullHeader);

        assertEquals(original.getVersion(), parsed.getVersion());
        assertEquals(original.getFlavor(), parsed.getFlavor());
        assertArrayEquals(original.getMsgID(), parsed.getMsgID());
        assertArrayEquals(original.getLegend(), parsed.getLegend());
        assertEquals(original.getDataKeys().size(), parsed.getDataKeys().size());

        // Verify commitment extraction
        assertArrayEquals(commitment, Header.getCommitment(fullHeader));
        assertArrayEquals(partialBytes, Header.getPartialHeaderBytes(fullHeader));
    }

    @Test
    void testVersion2Header() {
        byte[] msgID = new byte[32];
        byte[] legend = new byte[]{0x65, 0x63}; // encrypt_and_sign, sign_and_include_in_ec

        Map<byte[], byte[]> ctx = new LinkedHashMap<>();
        Header.EncryptedDataKey edk = new Header.EncryptedDataKey(
            "p".getBytes(StandardCharsets.UTF_8),
            new byte[0], new byte[]{1});

        Header.PartialHeader header = new Header.PartialHeader(
            (byte) 2, (byte) 1, msgID, legend, ctx, Arrays.asList(edk));

        byte[] serialized = header.serialize();
        assertEquals(2, serialized[0]); // version
        assertEquals(1, serialized[1]); // flavor

        // Round-trip with fake commitment
        byte[] full = new byte[serialized.length + 32];
        System.arraycopy(serialized, 0, full, 0, serialized.length);
        Header.PartialHeader parsed = Header.deserialize(full);
        assertEquals(2, parsed.getVersion());
        assertEquals(1, parsed.getFlavor());
    }

    // ---- Validation tests ----

    @Test
    void testDeserializeRejectsInvalidVersion() {
        byte[] data = new byte[PREFIX_LEN_PLUS_MINIMAL];
        data[0] = 3; // invalid version
        assertThrows(DbeException.class, () -> Header.deserialize(data));
    }

    @Test
    void testDeserializeRejectsInvalidFlavor() {
        byte[] data = new byte[PREFIX_LEN_PLUS_MINIMAL];
        data[0] = 1; // valid version
        data[1] = 5; // invalid flavor
        assertThrows(DbeException.class, () -> Header.deserialize(data));
    }

    @Test
    void testDeserializeRejectsTooShort() {
        assertThrows(DbeException.class, () -> Header.deserialize(new byte[10]));
    }

    @Test
    void testDeserializeRejectsInvalidLegendByte() {
        // Build a minimal header with an invalid legend byte
        byte[] data = buildMinimalHeader((byte) 0x99); // invalid legend byte
        assertThrows(DbeException.class, () -> Header.deserialize(data));
    }

    @Test
    void testDeserializeRejectsZeroDataKeys() {
        // Build header with 0 data keys
        byte[] partial = buildHeaderWithZeroDataKeys();
        byte[] full = new byte[partial.length + 32];
        System.arraycopy(partial, 0, full, 0, partial.length);
        assertThrows(DbeException.class, () -> Header.deserialize(full));
    }

    @Test
    void testContextKeysMustBeSorted() {
        // Build header with out-of-order context keys
        byte[] header = buildHeaderWithUnsortedContext();
        byte[] full = new byte[header.length + 32];
        System.arraycopy(header, 0, full, 0, header.length);
        assertThrows(DbeException.class, () -> Header.deserialize(full));
    }

    @Test
    void testMultipleDataKeysRoundTrip() {
        byte[] msgID = new byte[32];
        Map<byte[], byte[]> ctx = new LinkedHashMap<>();

        List<Header.EncryptedDataKey> edks = new ArrayList<>();
        edks.add(new Header.EncryptedDataKey("p1".getBytes(), "i1".getBytes(), new byte[]{1}));
        edks.add(new Header.EncryptedDataKey("p2".getBytes(), "i2".getBytes(), new byte[]{2, 3}));

        Header.PartialHeader header = new Header.PartialHeader(
            (byte) 1, (byte) 0, msgID, new byte[]{0x65}, ctx, edks);

        byte[] serialized = header.serialize();
        byte[] full = new byte[serialized.length + 32];
        System.arraycopy(serialized, 0, full, 0, serialized.length);

        Header.PartialHeader parsed = Header.deserialize(full);
        assertEquals(2, parsed.getDataKeys().size());
        assertArrayEquals("p1".getBytes(), parsed.getDataKeys().get(0).getKeyProviderId());
        assertArrayEquals("p2".getBytes(), parsed.getDataKeys().get(1).getKeyProviderId());
        assertArrayEquals(new byte[]{2, 3}, parsed.getDataKeys().get(1).getCiphertext());
    }

    // ---- Helpers ----

    // Minimum full header size: prefix(34) + legend(2+0) + context(2+0) + datakeys(1+...) + commitment(32)
    private static final int PREFIX_LEN_PLUS_MINIMAL = Header.PREFIX_LEN + 2 + 2 + 1 + 32;

    private static byte[] buildMinimalHeader(byte legendByte) {
        // version(1) + flavor(1) + msgID(32) + legendLen(2) + legend(1) + ctxCount(2) + edkCount(1) + edk + commitment(32)
        byte[] provId = "p".getBytes();
        byte[] cipher = new byte[]{1};
        int edkSize = 2 + provId.length + 2 + 0 + 2 + cipher.length;
        int size = 34 + 2 + 1 + 2 + 1 + edkSize + 32;
        byte[] data = new byte[size];
        int pos = 0;
        data[pos++] = 1; // version
        data[pos++] = 0; // flavor
        pos += 32; // msgID (zeros)
        data[pos++] = 0; data[pos++] = 1; // legend length = 1
        data[pos++] = legendByte;
        data[pos++] = 0; data[pos++] = 0; // context count = 0
        data[pos++] = 1; // edk count = 1
        data[pos++] = 0; data[pos++] = (byte) provId.length;
        System.arraycopy(provId, 0, data, pos, provId.length); pos += provId.length;
        data[pos++] = 0; data[pos++] = 0; // provInfo length = 0
        data[pos++] = 0; data[pos++] = (byte) cipher.length;
        System.arraycopy(cipher, 0, data, pos, cipher.length); pos += cipher.length;
        // remaining 32 bytes are commitment (zeros)
        return data;
    }

    private static byte[] buildHeaderWithZeroDataKeys() {
        int size = 34 + 2 + 2 + 1; // prefix + legend(empty) + context(empty) + edkCount(0)
        byte[] data = new byte[size];
        data[0] = 1; data[1] = 0; // version, flavor
        int pos = 34;
        data[pos++] = 0; data[pos++] = 0; // legend length = 0
        data[pos++] = 0; data[pos++] = 0; // context count = 0
        data[pos++] = 0; // edk count = 0
        return data;
    }

    private static byte[] buildHeaderWithUnsortedContext() {
        byte[] keyB = "b".getBytes();
        byte[] keyA = "a".getBytes();
        byte[] val = "v".getBytes();
        byte[] provId = "p".getBytes();
        byte[] cipher = new byte[]{1};

        int ctxSize = 2 + (2 + 1 + 2 + 1) * 2; // count + 2 entries
        int edkSize = 2 + provId.length + 2 + 0 + 2 + cipher.length;
        int size = 34 + 2 + ctxSize + 1 + edkSize;
        byte[] data = new byte[size];
        int pos = 0;
        data[pos++] = 1; data[pos++] = 0;
        pos += 32; // msgID
        data[pos++] = 0; data[pos++] = 0; // legend length = 0
        data[pos++] = 0; data[pos++] = 2; // context count = 2
        // Key "b" first (wrong order)
        data[pos++] = 0; data[pos++] = 1; data[pos++] = 'b';
        data[pos++] = 0; data[pos++] = 1; data[pos++] = 'v';
        // Key "a" second
        data[pos++] = 0; data[pos++] = 1; data[pos++] = 'a';
        data[pos++] = 0; data[pos++] = 1; data[pos++] = 'v';
        // EDK
        data[pos++] = 1;
        data[pos++] = 0; data[pos++] = (byte) provId.length;
        System.arraycopy(provId, 0, data, pos, provId.length); pos += provId.length;
        data[pos++] = 0; data[pos++] = 0;
        data[pos++] = 0; data[pos++] = (byte) cipher.length;
        System.arraycopy(cipher, 0, data, pos, cipher.length);
        return data;
    }
}
