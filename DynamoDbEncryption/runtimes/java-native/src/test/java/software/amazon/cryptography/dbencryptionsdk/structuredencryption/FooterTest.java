// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;

class FooterTest {

    // ---- Canonical field format ----

    @Test
    void testCanonicalPlaintextField() {
        byte[] path = Canonize.simpleCanon("table", "attr");
        StructuredDataTerminal data = new StructuredDataTerminal(
            "hello".getBytes(StandardCharsets.UTF_8), new byte[]{0x00, 0x01});

        byte[] canon = Footer.canonicalPlaintextField(path, data);

        // Should contain: path + uint64(5) + "PLAINTEXT" + typeId(0x00,0x01) + "hello"
        assertTrue(canon.length > path.length + 8 + 9 + 2 + 5 - 1);
        // Starts with canonical path
        assertArrayEquals(path, Arrays.copyOfRange(canon, 0, path.length));
    }

    @Test
    void testCanonicalEncryptedField() {
        byte[] path = Canonize.simpleCanon("table", "attr");
        // Encrypted value: [2B typeId][ciphertext][16B tag]
        byte[] encValue = new byte[2 + 10 + 16]; // typeId + 10B ciphertext + 16B tag
        encValue[0] = 0x00; encValue[1] = 0x01; // original typeId
        StructuredDataTerminal data = new StructuredDataTerminal(encValue, new byte[]{(byte) 0xFF, (byte) 0xFF});

        byte[] canon = Footer.canonicalEncryptedField(path, data);

        // Should contain: path + uint64(encValue.length - 2) + "ENCRYPTED" + encValue
        assertTrue(canon.length == path.length + 8 + 9 + encValue.length);
    }

    // ---- Canonical hash ----

    @Test
    void testCanonicalHashDeterministic() {
        List<Canonize.CanonField> fields = makeTestFields();
        byte[] header = new byte[]{1, 0}; // dummy
        Map<byte[], byte[]> ctx = new LinkedHashMap<>();

        byte[] h1 = Footer.computeCanonicalHash(fields, header, ctx);
        byte[] h2 = Footer.computeCanonicalHash(fields, header, ctx);

        assertEquals(48, h1.length); // SHA-384 = 48 bytes
        assertArrayEquals(h1, h2);
    }

    @Test
    void testCanonicalHashChangesWithDifferentData() {
        List<Canonize.CanonField> fields1 = makeTestFields();
        byte[] header = new byte[]{1, 0};
        Map<byte[], byte[]> ctx = new LinkedHashMap<>();

        byte[] h1 = Footer.computeCanonicalHash(fields1, header, ctx);

        // Different field data
        List<Canonize.CanonField> fields2 = new ArrayList<>();
        fields2.add(new Canonize.CanonField(
            Canonize.simpleCanon("t", "a"),
            Arrays.asList(new PathSegment("a")),
            new StructuredDataTerminal("different".getBytes(StandardCharsets.UTF_8), new byte[]{0, 1}),
            CryptoAction.SIGN_ONLY));

        byte[] h2 = Footer.computeCanonicalHash(fields2, header, ctx);
        assertFalse(Arrays.equals(h1, h2));
    }

    // ---- Footer creation and serialization ----

    @Test
    void testCreateFooterWithoutSignature() {
        List<Canonize.CanonField> fields = makeTestFields();
        byte[] header = new byte[66]; // dummy full header
        Map<byte[], byte[]> ctx = new LinkedHashMap<>();
        List<byte[]> signingKeys = new ArrayList<>();
        signingKeys.add(new byte[32]); // one symmetric signing key

        Footer footer = Footer.createFooter(fields, header, ctx, signingKeys, null);

        assertEquals(1, footer.getTags().size());
        assertEquals(48, footer.getTags().get(0).length);
        assertNull(footer.getSignature());

        byte[] serialized = footer.serialize();
        assertEquals(48, serialized.length); // 1 tag * 48 bytes, no signature
    }

    @Test
    void testCreateFooterMultipleKeys() {
        List<Canonize.CanonField> fields = makeTestFields();
        byte[] header = new byte[66];
        Map<byte[], byte[]> ctx = new LinkedHashMap<>();
        List<byte[]> signingKeys = new ArrayList<>();
        signingKeys.add(new byte[32]);
        signingKeys.add(new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
            17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32});

        Footer footer = Footer.createFooter(fields, header, ctx, signingKeys, null);

        assertEquals(2, footer.getTags().size());
        // Different keys should produce different tags
        assertFalse(Arrays.equals(footer.getTags().get(0), footer.getTags().get(1)));

        byte[] serialized = footer.serialize();
        assertEquals(96, serialized.length); // 2 tags * 48 bytes
    }

    // ---- Footer deserialization ----

    @Test
    void testDeserializeFooterWithoutSignature() {
        byte[] data = new byte[96]; // 2 tags
        data[0] = 1; data[48] = 2; // distinguish tags

        Footer footer = Footer.deserialize(data, false);
        assertEquals(2, footer.getTags().size());
        assertNull(footer.getSignature());
        assertEquals(1, footer.getTags().get(0)[0]);
        assertEquals(2, footer.getTags().get(1)[0]);
    }

    @Test
    void testDeserializeFooterWithSignature() {
        byte[] data = new byte[48 + 103]; // 1 tag + signature
        data[0] = 1;
        data[48] = 99; // start of signature

        Footer footer = Footer.deserialize(data, true);
        assertEquals(1, footer.getTags().size());
        assertNotNull(footer.getSignature());
        assertEquals(103, footer.getSignature().length);
        assertEquals(99, footer.getSignature()[0]);
    }

    @Test
    void testDeserializeFooterTooShort() {
        assertThrows(DbeException.class, () -> Footer.deserialize(new byte[10], false));
        assertThrows(DbeException.class, () -> Footer.deserialize(new byte[10], true));
    }

    @Test
    void testDeserializeFooterBadSize() {
        // 50 bytes is not a multiple of 48
        assertThrows(DbeException.class, () -> Footer.deserialize(new byte[50], false));
    }

    // ---- Serialize/Deserialize round-trip ----

    @Test
    void testFooterSerializeDeserializeRoundTrip() {
        List<Canonize.CanonField> fields = makeTestFields();
        byte[] header = new byte[66];
        Map<byte[], byte[]> ctx = new LinkedHashMap<>();
        List<byte[]> signingKeys = new ArrayList<>();
        signingKeys.add(new byte[32]);

        Footer original = Footer.createFooter(fields, header, ctx, signingKeys, null);
        byte[] serialized = original.serialize();
        Footer deserialized = Footer.deserialize(serialized, false);

        assertEquals(original.getTags().size(), deserialized.getTags().size());
        assertArrayEquals(original.getTags().get(0), deserialized.getTags().get(0));
    }

    // ---- Verification ----

    @Test
    void testFooterVerification() {
        List<Canonize.CanonField> fields = makeTestFields();
        byte[] header = new byte[66];
        Map<byte[], byte[]> ctx = new LinkedHashMap<>();
        byte[] signingKey = new byte[32];
        List<byte[]> signingKeys = new ArrayList<>();
        signingKeys.add(signingKey);

        Footer footer = Footer.createFooter(fields, header, ctx, signingKeys, null);

        // Verification should pass with the same key
        assertTrue(footer.verify(fields, header, ctx, signingKey, null));
    }

    @Test
    void testFooterVerificationFailsWithWrongKey() {
        List<Canonize.CanonField> fields = makeTestFields();
        byte[] header = new byte[66];
        Map<byte[], byte[]> ctx = new LinkedHashMap<>();
        byte[] signingKey = new byte[32];
        List<byte[]> signingKeys = new ArrayList<>();
        signingKeys.add(signingKey);

        Footer footer = Footer.createFooter(fields, header, ctx, signingKeys, null);

        byte[] wrongKey = new byte[32];
        wrongKey[0] = 1;
        assertThrows(DbeException.class, () ->
            footer.verify(fields, header, ctx, wrongKey, null));
    }

    // ---- Cross-version: parse real footers from test vectors ----

    @Test
    void testDeserializeRealFooterFromTestVector() {
        // From test vector 1: flavor=0x01 (ECDSA), 1 EDK
        // Footer should be: 1 * 48B tag + 103B signature = 151 bytes
        String footerB64 = "uiREMiy6aSgeZnskNZPLxCDAtM+ejd+OrwQLSvxb1ghBzRrjFJyV0S2m3Vl2qmT4" +
            "MGUCMGOyNQjitaSagLW3L4hJPZbpqcKthCjNoV49EihouNociOL8umlhllWUaxsZ" +
            "X1iN1AIxALlfECzHpS87OrNw6zj3NdMqEeSFm6hen/u7QNUFm8TbgZrpXIR3yaZP" +
            "DaB7SQ6Weg==";
        byte[] footerBytes = Base64.getDecoder().decode(footerB64);
        assertEquals(151, footerBytes.length); // 48 + 103

        Footer footer = Footer.deserialize(footerBytes, true);
        assertEquals(1, footer.getTags().size());
        assertEquals(48, footer.getTags().get(0).length);
        assertNotNull(footer.getSignature());
        assertEquals(103, footer.getSignature().length);

        // Re-serialize should match
        assertArrayEquals(footerBytes, footer.serialize());
    }

    // ---- Helpers ----

    private static List<Canonize.CanonField> makeTestFields() {
        List<CryptoItem> items = new ArrayList<>();
        items.add(new CryptoItem(
            Arrays.asList(new PathSegment("attr1")),
            new StructuredDataTerminal("value1".getBytes(StandardCharsets.UTF_8), new byte[]{0, 1}),
            CryptoAction.SIGN_ONLY));
        items.add(new CryptoItem(
            Arrays.asList(new PathSegment("attr2")),
            new StructuredDataTerminal("value2".getBytes(StandardCharsets.UTF_8), new byte[]{0, 1}),
            CryptoAction.SIGN_ONLY));
        return Canonize.canonicalize("testTable", items);
    }
}
