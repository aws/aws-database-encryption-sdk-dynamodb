// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.crossversion;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ddbconversion.AttributeSerializer;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.ddbconversion.TypeId;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.Header;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;

/**
 * Cross-version compatibility tests that validate the native Java
 * implementation can correctly parse headers and serialize attributes
 * from items encrypted by the Dafny-based SDK.
 *
 * <p>Uses test vectors from TestVectors/runtimes/java/decrypt_java_39.json.
 */
class CrossVersionTest {

    private static final String TEST_VECTORS_PATH =
        "../../../TestVectors/runtimes/java/decrypt_java_39.json";

    private static JsonNode testData;
    private static boolean vectorsAvailable;

    @BeforeAll
    static void loadTestVectors() {
        try {
            File f = new File(System.getProperty("user.dir"), TEST_VECTORS_PATH);
            if (f.exists()) {
                testData = new ObjectMapper().readTree(f);
                vectorsAvailable = true;
            }
        } catch (Exception e) {
            // Test vectors not available — tests will be skipped
        }
    }

    static boolean hasVectors() { return vectorsAvailable; }

    // ---- Header deserialization from real encrypted items ----

    @Test
    @EnabledIf("hasVectors")
    void testDeserializeAllHeaders() {
        JsonNode tests = testData.get("tests");
        int parsed = 0;
        int v1Count = 0;
        int v2Count = 0;

        Iterator<Map.Entry<String, JsonNode>> it = tests.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> entry = it.next();
            String testId = entry.getKey();
            JsonNode test = entry.getValue();

            if (!"positive-decrypt".equals(test.get("type").asText())) continue;

            JsonNode encrypted = test.get("encrypted");
            JsonNode headNode = encrypted.get("aws_dbe_head");
            if (headNode == null || headNode.get("B") == null) continue;

            byte[] headerBytes = Base64.getDecoder().decode(headNode.get("B").asText());

            // Parse the header — this must not throw
            Header.PartialHeader header;
            try {
                header = Header.deserialize(headerBytes);
            } catch (Exception e) {
                fail("Failed to parse header for test " + testId + ": " + e.getMessage());
                return;
            }

            // Validate version
            assertTrue(header.getVersion() == 1 || header.getVersion() == 2,
                "Invalid version in test " + testId);
            if (header.getVersion() == 1) v1Count++;
            else v2Count++;

            // Validate flavor
            assertTrue(header.getFlavor() == 0 || header.getFlavor() == 1,
                "Invalid flavor in test " + testId);

            // Validate message ID is 32 bytes
            assertEquals(32, header.getMsgID().length,
                "Message ID wrong length in test " + testId);

            // Validate legend bytes are all valid
            // Note: legend length depends on the encrypt-time schema and actual item attributes,
            // which may differ from the decrypt config, so we don't check the count.
            for (byte b : header.getLegend()) {
                assertTrue(Header.isValidLegendByte(b),
                    "Invalid legend byte in test " + testId);
            }
            assertTrue(header.getLegend().length > 0,
                "Legend should have at least one entry in test " + testId);

            // Validate at least one data key
            assertFalse(header.getDataKeys().isEmpty(),
                "No data keys in test " + testId);

            // Note: we don't validate version against the decrypt config's actions
            // because the decrypt config may differ from the encrypt config.
            // Version is determined at encryption time.

            // Validate commitment is exactly 32 bytes
            byte[] commitment = Header.getCommitment(headerBytes);
            assertEquals(32, commitment.length);

            // Validate partial header + commitment = full header
            byte[] partialBytes = Header.getPartialHeaderBytes(headerBytes);
            byte[] reassembled = new byte[partialBytes.length + commitment.length];
            System.arraycopy(partialBytes, 0, reassembled, 0, partialBytes.length);
            System.arraycopy(commitment, 0, reassembled, partialBytes.length, commitment.length);
            assertArrayEquals(headerBytes, reassembled);

            // Re-serialize the partial header and verify it matches
            byte[] reserialized = header.serialize();
            if (!Arrays.equals(partialBytes, reserialized)) {
                // Find first difference
                int diffPos = -1;
                for (int i = 0; i < Math.min(partialBytes.length, reserialized.length); i++) {
                    if (partialBytes[i] != reserialized[i]) { diffPos = i; break; }
                }
                fail("Re-serialized partial header doesn't match original in test " + testId
                    + ": origLen=" + partialBytes.length + " reserLen=" + reserialized.length
                    + " firstDiff=" + diffPos
                    + (diffPos >= 0 ? " orig=" + (partialBytes[diffPos] & 0xFF) + " reser=" + (reserialized[diffPos] & 0xFF) : ""));
            }

            parsed++;
        }

        assertTrue(parsed > 0, "No test vectors were parsed");
        assertTrue(v1Count > 0, "No version 1 headers found");
        assertTrue(v2Count > 0, "No version 2 headers found");
        System.out.println("Parsed " + parsed + " headers (" + v1Count + " v1, " + v2Count + " v2)");
    }

    // ---- Attribute serialization of plaintext values ----

    @Test
    @EnabledIf("hasVectors")
    void testSerializePlaintextAttributes() {
        JsonNode tests = testData.get("tests");
        int verified = 0;

        Iterator<Map.Entry<String, JsonNode>> it = tests.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> entry = it.next();
            String testId = entry.getKey();
            JsonNode test = entry.getValue();

            if (!"positive-decrypt".equals(test.get("type").asText())) continue;

            JsonNode plaintext = test.get("plaintext");
            JsonNode encrypted = test.get("encrypted");
            JsonNode actions = test.get("config").get("attributeActionsOnEncrypt");

            Iterator<Map.Entry<String, JsonNode>> ptIt = plaintext.fields();
            while (ptIt.hasNext()) {
                Map.Entry<String, JsonNode> attr = ptIt.next();
                String attrName = attr.getKey();
                JsonNode ptValue = attr.getValue();
                String action = actions.has(attrName) ? actions.get(attrName).asText() : "DO_NOTHING";

                // For SIGN_ONLY attributes, the encrypted item should have the same value
                if ("SIGN_ONLY".equals(action) || "SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT".equals(action)) {
                    JsonNode encValue = encrypted.get(attrName);
                    if (encValue == null) continue;

                    // Convert the plaintext JSON to an AttributeValue
                    AttributeValue av = jsonToAttributeValue(ptValue);
                    if (av == null) continue;

                    // Serialize and verify it produces a valid StructuredDataTerminal
                    StructuredDataTerminal terminal = AttributeSerializer.serializeAttr(av);
                    assertNotNull(terminal.getValue());
                    assertEquals(2, terminal.getTypeId().length);

                    // Deserialize back and verify round-trip
                    AttributeValue roundTripped = AttributeSerializer.deserializeAttr(terminal);
                    StructuredDataTerminal terminal2 = AttributeSerializer.serializeAttr(roundTripped);
                    assertArrayEquals(terminal.getValue(), terminal2.getValue(),
                        "Round-trip failed for " + attrName + " in test " + testId);

                    verified++;
                }
            }
        }

        assertTrue(verified > 0, "No plaintext attributes were verified");
        System.out.println("Verified " + verified + " plaintext attribute round-trips");
    }

    // ---- Encrypted attribute format validation ----

    @Test
    @EnabledIf("hasVectors")
    void testEncryptedAttributeFormat() {
        JsonNode tests = testData.get("tests");
        int verified = 0;

        Iterator<Map.Entry<String, JsonNode>> it = tests.fields();
        while (it.hasNext()) {
            Map.Entry<String, JsonNode> entry = it.next();
            String testId = entry.getKey();
            JsonNode test = entry.getValue();

            if (!"positive-decrypt".equals(test.get("type").asText())) continue;

            JsonNode encrypted = test.get("encrypted");
            JsonNode actions = test.get("config").get("attributeActionsOnEncrypt");

            Iterator<Map.Entry<String, JsonNode>> actIt = actions.fields();
            while (actIt.hasNext()) {
                Map.Entry<String, JsonNode> actEntry = actIt.next();
                String attrName = actEntry.getKey();
                String action = actEntry.getValue().asText();

                if (!"ENCRYPT_AND_SIGN".equals(action)) continue;

                JsonNode encNode = encrypted.get(attrName);
                if (encNode == null || encNode.get("B") == null) continue;

                byte[] encBytes = Base64.getDecoder().decode(encNode.get("B").asText());

                // Encrypted attributes have format: [2B original typeId][ciphertext][16B auth tag]
                // So minimum length is 2 + 0 + 16 = 18 bytes
                assertTrue(encBytes.length >= 18,
                    "Encrypted attr too short for " + attrName + " in test " + testId);

                // First 2 bytes should be a valid type ID
                byte[] typeId = Arrays.copyOfRange(encBytes, 0, 2);
                assertTrue(TypeId.isValidTypeId(typeId),
                    "Invalid type ID in encrypted " + attrName + " in test " + testId
                    + ": [" + (typeId[0] & 0xFF) + ", " + (typeId[1] & 0xFF) + "]");

                verified++;
            }
        }

        assertTrue(verified > 0, "No encrypted attributes were verified");
        System.out.println("Verified " + verified + " encrypted attribute formats");
    }

    // ---- Helper ----

    private static AttributeValue jsonToAttributeValue(JsonNode node) {
        if (node.isInt() || node.isLong()) {
            return AttributeValue.fromN(String.valueOf(node.asLong()));
        }
        if (node.isDouble() || node.isFloat()) {
            return AttributeValue.fromN(String.valueOf(node.asDouble()));
        }
        if (node.isTextual()) {
            return AttributeValue.fromS(node.asText());
        }
        if (node.isBoolean()) {
            return AttributeValue.fromBool(node.asBoolean());
        }
        if (node.isNull()) {
            return AttributeValue.fromNul(true);
        }
        // Skip complex types for now
        return null;
    }
}
