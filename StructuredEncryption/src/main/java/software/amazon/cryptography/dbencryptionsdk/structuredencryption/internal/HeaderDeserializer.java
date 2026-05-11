// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.materialproviders.model.EncryptedDataKey;

import static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionUtil.*;

/**
 * Deserializes the structured encryption header from binary.
 */
public final class HeaderDeserializer {

  private HeaderDeserializer() {}

  /** Parsed header result. */
  public static final class ParsedHeader {
    public final byte version;
    public final byte flavor;
    public final byte[] messageId;
    public final byte[] legend;
    public final Map<String, String> encryptionContext;
    public final List<EncryptedDataKey> encryptedDataKeys;
    public final byte[] commitment;
    public final byte[] partialHeaderBytes;

    ParsedHeader(byte version, byte flavor, byte[] messageId, byte[] legend,
                 Map<String, String> encryptionContext, List<EncryptedDataKey> encryptedDataKeys,
                 byte[] commitment, byte[] partialHeaderBytes) {
      this.version = version;
      this.flavor = flavor;
      this.messageId = messageId;
      this.legend = legend;
      this.encryptionContext = encryptionContext;
      this.encryptedDataKeys = encryptedDataKeys;
      this.commitment = commitment;
      this.partialHeaderBytes = partialHeaderBytes;
    }
  }

  /**
   * Deserialize a full header (with commitment) from raw bytes.
   */
  public static ParsedHeader deserialize(byte[] headerBytes) {
    ByteBuffer buf = ByteBuffer.wrap(headerBytes);

    byte version = buf.get();
    if (version != FORMAT_VERSION_1 && version != FORMAT_VERSION_2) {
      throw new IllegalArgumentException("Unsupported header version: " + version);
    }

    byte flavor = buf.get();
    if (flavor != FLAVOR_NO_SIGNATURE && flavor != FLAVOR_WITH_SIGNATURE) {
      throw new IllegalArgumentException("Unsupported header flavor: " + flavor);
    }

    byte[] messageId = new byte[MSG_ID_LEN];
    buf.get(messageId);

    byte[] legend = readLegend(buf);
    Map<String, String> ec = readEncryptionContext(buf);
    List<EncryptedDataKey> edks = readEncryptedDataKeys(buf);

    int partialHeaderLen = buf.position();
    byte[] partialHeaderBytes = new byte[partialHeaderLen];
    System.arraycopy(headerBytes, 0, partialHeaderBytes, 0, partialHeaderLen);

    byte[] commitment = new byte[32];
    buf.get(commitment);

    return new ParsedHeader(version, flavor, messageId, legend, ec, edks, commitment, partialHeaderBytes);
  }

  /**
   * Partial deserialize — just enough to get the legend (for resolveAuthActions).
   */
  public static byte[] partialDeserializeLegend(byte[] headerBytes) {
    ByteBuffer buf = ByteBuffer.wrap(headerBytes);
    buf.get(); // version
    buf.get(); // flavor
    buf.position(buf.position() + MSG_ID_LEN); // skip messageId
    return readLegend(buf);
  }

  private static byte[] readLegend(ByteBuffer buf) {
    int legendLen = readUint16(buf);
    byte[] legend = new byte[legendLen];
    buf.get(legend);
    return legend;
  }

  private static Map<String, String> readEncryptionContext(ByteBuffer buf) {
    int count = readUint16(buf);
    Map<String, String> ec = new LinkedHashMap<>(count);
    for (int i = 0; i < count; i++) {
      int keyLen = readUint16(buf);
      byte[] keyBytes = new byte[keyLen];
      buf.get(keyBytes);
      int valLen = readUint16(buf);
      byte[] valBytes = new byte[valLen];
      buf.get(valBytes);
      ec.put(new String(keyBytes, StandardCharsets.UTF_8), new String(valBytes, StandardCharsets.UTF_8));
    }
    return ec;
  }

  private static List<EncryptedDataKey> readEncryptedDataKeys(ByteBuffer buf) {
    int count = readUint8(buf);
    List<EncryptedDataKey> edks = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      int providerIdLen = readUint16(buf);
      byte[] providerIdBytes = new byte[providerIdLen];
      buf.get(providerIdBytes);

      int providerInfoLen = readUint16(buf);
      byte[] providerInfoBytes = new byte[providerInfoLen];
      buf.get(providerInfoBytes);

      int ciphertextLen = readUint16(buf);
      byte[] ciphertextBytes = new byte[ciphertextLen];
      buf.get(ciphertextBytes);

      edks.add(EncryptedDataKey.builder()
        .keyProviderId(new String(providerIdBytes, StandardCharsets.UTF_8))
        .keyProviderInfo(ByteBuffer.wrap(providerInfoBytes))
        .ciphertext(ByteBuffer.wrap(ciphertextBytes))
        .build());
    }
    return edks;
  }
}
