// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.searchable;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

class BeaconTest {

    private static final byte[] TEST_KEY = "test-beacon-key-for-hmac-sha384!".getBytes(StandardCharsets.UTF_8);

    // ---- Standard Beacon ----

    @Test
    void testStandardBeaconCompute() {
        StandardBeacon beacon = new StandardBeacon("zipcode", "zipcode", 16);
        String result = beacon.computeBeacon("12345", TEST_KEY);
        assertNotNull(result);
        // 16 bits → 4 hex chars
        assertEquals(4, result.length());
        assertTrue(result.matches("[0-9a-f]+"));
    }

    @Test
    void testStandardBeaconDeterministic() {
        StandardBeacon beacon = new StandardBeacon("field", "field", 12);
        String r1 = beacon.computeBeacon("hello", TEST_KEY);
        String r2 = beacon.computeBeacon("hello", TEST_KEY);
        assertEquals(r1, r2);
    }

    @Test
    void testStandardBeaconDifferentValues() {
        StandardBeacon beacon = new StandardBeacon("field", "field", 24);
        String r1 = beacon.computeBeacon("hello", TEST_KEY);
        String r2 = beacon.computeBeacon("world", TEST_KEY);
        // With 24 bits, collision is unlikely for different values
        assertNotEquals(r1, r2);
    }

    @Test
    void testStandardBeaconDifferentKeys() {
        StandardBeacon beacon = new StandardBeacon("field", "field", 16);
        byte[] key2 = "different-key-for-testing-hmac!!".getBytes(StandardCharsets.UTF_8);
        String r1 = beacon.computeBeacon("hello", TEST_KEY);
        String r2 = beacon.computeBeacon("hello", key2);
        assertNotEquals(r1, r2);
    }

    @Test
    void testStandardBeaconLengthValidation() {
        assertThrows(Exception.class, () -> new StandardBeacon("b", "f", 0));
        assertThrows(Exception.class, () -> new StandardBeacon("b", "f", 64));
        assertDoesNotThrow(() -> new StandardBeacon("b", "f", 1));
        assertDoesNotThrow(() -> new StandardBeacon("b", "f", 63));
    }

    @Test
    void testStandardBeaconHexLength() {
        // beaconLength=1 → ceil(1/4) = 1 hex char
        assertEquals(1, new StandardBeacon("b", "f", 1).computeBeacon("x", TEST_KEY).length());
        // beaconLength=4 → 1 hex char
        assertEquals(1, new StandardBeacon("b", "f", 4).computeBeacon("x", TEST_KEY).length());
        // beaconLength=5 → 2 hex chars
        assertEquals(2, new StandardBeacon("b", "f", 5).computeBeacon("x", TEST_KEY).length());
        // beaconLength=8 → 2 hex chars
        assertEquals(2, new StandardBeacon("b", "f", 8).computeBeacon("x", TEST_KEY).length());
        // beaconLength=16 → 4 hex chars
        assertEquals(4, new StandardBeacon("b", "f", 16).computeBeacon("x", TEST_KEY).length());
    }

    @Test
    void testStandardBeaconAttributeName() {
        StandardBeacon beacon = new StandardBeacon("zipcode", "zip", 16);
        assertEquals("aws_dbe_b_zipcode", beacon.getBeaconAttributeName());
    }

    // ---- Compound Beacon ----

    @Test
    void testCompoundBeaconBasic() {
        CompoundBeacon.Part signedPart = new CompoundBeacon.Part("timestamp", "T-", false, "timestamp");
        CompoundBeacon.Part encryptedPart = new CompoundBeacon.Part("zipcode", "Z-", true, null);

        CompoundBeacon cb = new CompoundBeacon("location", ".",
            Arrays.asList(signedPart, encryptedPart), null);

        Map<String, String> record = new HashMap<>();
        record.put("timestamp", "20221225");

        Map<String, String> beaconValues = new HashMap<>();
        beaconValues.put("zipcode", "7abc");

        String result = cb.computeBeacon(record, beaconValues);
        assertEquals("T-20221225.Z-7abc", result);
    }

    @Test
    void testCompoundBeaconOptionalPartMissing() {
        CompoundBeacon.Part required = new CompoundBeacon.Part("name", "N-", false, "name");
        CompoundBeacon.Part optional = new CompoundBeacon.Part("zip", "Z-", true, null);

        CompoundBeacon.Constructor ctor = new CompoundBeacon.Constructor(Arrays.asList(
            new CompoundBeacon.ConstructorPart("name", true),
            new CompoundBeacon.ConstructorPart("zip", false)));

        CompoundBeacon cb = new CompoundBeacon("test", ".", Arrays.asList(required, optional),
            Arrays.asList(ctor));

        Map<String, String> record = new HashMap<>();
        record.put("name", "Alice");
        Map<String, String> beaconValues = new HashMap<>(); // zip missing

        String result = cb.computeBeacon(record, beaconValues);
        assertEquals("N-Alice", result);
    }

    @Test
    void testCompoundBeaconRequiredPartMissing() {
        CompoundBeacon.Part required = new CompoundBeacon.Part("name", "N-", false, "name");

        CompoundBeacon cb = new CompoundBeacon("test", ".", Arrays.asList(required), null);

        Map<String, String> record = new HashMap<>(); // name missing
        Map<String, String> beaconValues = new HashMap<>();

        String result = cb.computeBeacon(record, beaconValues);
        assertNull(result); // Constructor fails
    }

    // ---- Virtual Field ----

    @Test
    void testVirtualFieldFull() {
        VirtualField vf = new VirtualField("fullName", Arrays.asList(
            new VirtualField.FieldPart("first"),
            new VirtualField.FieldPart("last")));

        Map<String, String> record = new HashMap<>();
        record.put("first", "Alice");
        record.put("last", "Smith");

        assertEquals("AliceSmith", vf.compute(record));
    }

    @Test
    void testVirtualFieldPrefix() {
        VirtualField vf = new VirtualField("zipPrefix", Arrays.asList(
            new VirtualField.PrefixPart("zipcode", 3)));

        Map<String, String> record = new HashMap<>();
        record.put("zipcode", "12345");

        assertEquals("123", vf.compute(record));
    }

    @Test
    void testVirtualFieldSuffix() {
        VirtualField vf = new VirtualField("last4", Arrays.asList(
            new VirtualField.SuffixPart("ssn", 4)));

        Map<String, String> record = new HashMap<>();
        record.put("ssn", "123-45-6789");

        assertEquals("6789", vf.compute(record));
    }

    @Test
    void testVirtualFieldSegment() {
        VirtualField vf = new VirtualField("domain", Arrays.asList(
            new VirtualField.SegmentPart("email", "@", 1)));

        Map<String, String> record = new HashMap<>();
        record.put("email", "user@example.com");

        assertEquals("example.com", vf.compute(record));
    }

    @Test
    void testVirtualFieldMissingSource() {
        VirtualField vf = new VirtualField("test", Arrays.asList(
            new VirtualField.FieldPart("missing")));

        assertNull(vf.compute(new HashMap<>()));
    }

    // ---- BeaconManager ----

    @Test
    void testBeaconManagerComputeBeacons() {
        StandardBeacon sb = new StandardBeacon("zipcode", "zipcode", 16);
        BeaconManager mgr = new BeaconManager(
            Arrays.asList(sb), null, null, TEST_KEY);

        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("id1"));
        item.put("zipcode", AttributeValue.fromS("12345"));

        Map<String, AttributeValue> beacons = mgr.computeBeacons(item);

        assertTrue(beacons.containsKey("aws_dbe_b_zipcode"));
        assertNotNull(beacons.get("aws_dbe_b_zipcode").s());
        assertEquals(4, beacons.get("aws_dbe_b_zipcode").s().length());
    }

    @Test
    void testBeaconManagerWithVirtualField() {
        VirtualField vf = new VirtualField("zip3", Arrays.asList(
            new VirtualField.PrefixPart("zipcode", 3)));
        StandardBeacon sb = new StandardBeacon("zip3", "zip3", 8);

        BeaconManager mgr = new BeaconManager(
            Arrays.asList(sb), null, Arrays.asList(vf), TEST_KEY);

        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("zipcode", AttributeValue.fromS("12345"));

        Map<String, AttributeValue> beacons = mgr.computeBeacons(item);
        assertTrue(beacons.containsKey("aws_dbe_b_zip3"));
    }

    @Test
    void testRemoveBeacons() {
        Map<String, AttributeValue> item = new LinkedHashMap<>();
        item.put("pk", AttributeValue.fromS("id"));
        item.put("aws_dbe_b_zipcode", AttributeValue.fromS("7abc"));
        item.put("aws_dbe_b_name", AttributeValue.fromS("ef"));

        Map<String, AttributeValue> cleaned = BeaconManager.removeBeacons(item);
        assertEquals(1, cleaned.size());
        assertTrue(cleaned.containsKey("pk"));
    }
}
