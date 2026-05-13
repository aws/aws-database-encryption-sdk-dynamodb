// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.materialproviders.model.EncryptedDataKey;

import static org.junit.jupiter.api.Assertions.*;
import static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionUtil.*;

class HeaderSerializerTest {

  @Test
  void roundTripSerializeDeserialize() {
    byte[] messageId = new byte[MSG_ID_LEN];
    Arrays.fill(messageId, (byte) 0x42);

    byte[] legend = new byte[] { ENCRYPT_AND_SIGN_LEGEND, SIGN_ONLY_LEGEND, CONTEXT_LEGEND };

    Map<String, String> ec = new LinkedHashMap<>();
    ec.put("aws-crypto-table-name", "MyTable");
    ec.put("aws-crypto-partition-name", "pk");

    List<EncryptedDataKey> edks = Arrays.asList(
      EncryptedDataKey.builder()
        .keyProviderId("aws-kms")
        .keyProviderInfo(ByteBuffer.wrap("arn:aws:kms:us-east-1:123456789012:key/test-key".getBytes()))
        .ciphertext(ByteBuffer.wrap(new byte[] { 0x01, 0x02, 0x03, 0x04 }))
        .build()
    );

    byte[] partialHeader = HeaderSerializer.serializePartialHeader(
      FORMAT_VERSION_1, FLAVOR_WITH_SIGNATURE, messageId, legend, ec, edks);

    byte[] commitment = new byte[32];
    Arrays.fill(commitment, (byte) 0xAB);
    byte[] fullHeader = HeaderSerializer.serializeFullHeader(partialHeader, commitment);

    // Deserialize
    HeaderDeserializer.ParsedHeader parsed = HeaderDeserializer.deserialize(fullHeader);

    assertEquals(FORMAT_VERSION_1, parsed.version);
    assertEquals(FLAVOR_WITH_SIGNATURE, parsed.flavor);
    assertArrayEquals(messageId, parsed.messageId);
    assertArrayEquals(legend, parsed.legend);
    assertEquals(ec.size(), parsed.encryptionContext.size());
    assertEquals("MyTable", parsed.encryptionContext.get("aws-crypto-table-name"));
    assertEquals("pk", parsed.encryptionContext.get("aws-crypto-partition-name"));
    assertEquals(1, parsed.encryptedDataKeys.size());
    assertEquals("aws-kms", parsed.encryptedDataKeys.get(0).keyProviderId());
    assertArrayEquals(commitment, parsed.commitment);
  }

  @Test
  void emptyEncryptionContext() {
    byte[] messageId = new byte[MSG_ID_LEN];
    byte[] legend = new byte[] { ENCRYPT_AND_SIGN_LEGEND };
    Map<String, String> ec = new LinkedHashMap<>();
    List<EncryptedDataKey> edks = Arrays.asList(
      EncryptedDataKey.builder()
        .keyProviderId("raw")
        .keyProviderInfo(ByteBuffer.wrap(new byte[0]))
        .ciphertext(ByteBuffer.wrap(new byte[] { 0x55 }))
        .build()
    );

    byte[] partial = HeaderSerializer.serializePartialHeader(
      FORMAT_VERSION_1, FLAVOR_NO_SIGNATURE, messageId, legend, ec, edks);
    byte[] commitment = new byte[32];
    byte[] full = HeaderSerializer.serializeFullHeader(partial, commitment);

    HeaderDeserializer.ParsedHeader parsed = HeaderDeserializer.deserialize(full);
    assertEquals(0, parsed.encryptionContext.size());
    assertEquals(FORMAT_VERSION_1, parsed.version);
    assertEquals(FLAVOR_NO_SIGNATURE, parsed.flavor);
  }

  @Test
  void headerCommitmentRoundTrip() {
    byte[] dataKey = new byte[32];
    Arrays.fill(dataKey, (byte) 0x11);
    byte[] messageId = new byte[32];
    Arrays.fill(messageId, (byte) 0x22);

    byte[] commitKey = HeaderCommitment.deriveCommitKey(dataKey, messageId);
    assertEquals(KEY_SIZE, commitKey.length);

    byte[] partialHeader = new byte[] { 0x01, 0x02, 0x03 };
    byte[] commitment = HeaderCommitment.computeCommitment(commitKey, partialHeader);
    assertEquals(32, commitment.length);

    assertTrue(HeaderCommitment.verifyCommitment(commitKey, partialHeader, commitment));
    assertFalse(HeaderCommitment.verifyCommitment(commitKey, new byte[] { (byte) 0x99 }, commitment));
  }
}
