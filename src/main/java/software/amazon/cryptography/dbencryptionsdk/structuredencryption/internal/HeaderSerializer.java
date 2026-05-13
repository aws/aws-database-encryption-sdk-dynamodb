// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import software.amazon.cryptography.materialproviders.model.EncryptedDataKey;

import static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionUtil.*;

/**
 * Serializes the structured encryption header.
 *
 * //= specification/structured-encryption/header.md#partial-header
 * //# | 1  | Format Version  |
 * //# | 1  | Format Flavor   |
 * //# | 32 | Message ID      |
 * //# | Variable | Encrypt Legend |
 * //# | Variable | Encryption Context |
 * //# | Variable | Encrypted Data Keys |
 */
public final class HeaderSerializer {

  private HeaderSerializer() {}

  /**
   * Serialize the partial header (without commitment).
   */
  public static byte[] serializePartialHeader(
    byte version,
    byte flavor,
    byte[] messageId,
    byte[] legend,
    Map<String, String> encryptionContext,
    List<EncryptedDataKey> edks
  ) {
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      out.write(version);
      out.write(flavor);
      out.write(messageId);
      writeLegend(out, legend);
      writeEncryptionContext(out, encryptionContext);
      writeEncryptedDataKeys(out, edks);
      return out.toByteArray();
    } catch (IOException e) {
      throw new RuntimeException("Header serialization failed", e);
    }
  }

  /**
   * Serialize the full header (partial header + 32-byte commitment).
   */
  public static byte[] serializeFullHeader(byte[] partialHeader, byte[] commitment) {
    byte[] full = new byte[partialHeader.length + commitment.length];
    System.arraycopy(partialHeader, 0, full, 0, partialHeader.length);
    System.arraycopy(commitment, 0, full, partialHeader.length, commitment.length);
    return full;
  }

  /**
   * //= specification/structured-encryption/header.md#encrypt-legend
   * //# | Encrypt Legend Length | 2 | big endian UInt16 |
   * //# | Encrypt Legend Bytes  | Variable |
   */
  private static void writeLegend(ByteArrayOutputStream out, byte[] legend) throws IOException {
    writeUint16To(out, legend.length);
    out.write(legend);
  }

  /**
   * //= specification/structured-encryption/header.md#encryption-context
   * //# | Key Value Pair Count | 2 | big endian UInt16 |
   * //# | Key Value Pair Entries | Variable |
   *
   * Entries sorted by key in ascending UTF-8 binary order.
   */
  private static void writeEncryptionContext(ByteArrayOutputStream out, Map<String, String> ec) throws IOException {
    // Sort by UTF-8 encoded key bytes
    TreeMap<String, String> sorted = new TreeMap<>((a, b) -> {
      byte[] ab = a.getBytes(StandardCharsets.UTF_8);
      byte[] bb = b.getBytes(StandardCharsets.UTF_8);
      return compareBytes(ab, bb);
    });
    sorted.putAll(ec);

    writeUint16To(out, sorted.size());
    for (Map.Entry<String, String> entry : sorted.entrySet()) {
      byte[] keyBytes = entry.getKey().getBytes(StandardCharsets.UTF_8);
      byte[] valBytes = entry.getValue().getBytes(StandardCharsets.UTF_8);
      writeUint16To(out, keyBytes.length);
      out.write(keyBytes);
      writeUint16To(out, valBytes.length);
      out.write(valBytes);
    }
  }

  /**
   * //= specification/structured-encryption/header.md#encrypted-data-keys
   * //# | Encrypted Data Key Count | 1 | unsigned 8 bit number |
   * //# | Encrypted Data Key Entries | Variable |
   */
  private static void writeEncryptedDataKeys(ByteArrayOutputStream out, List<EncryptedDataKey> edks) throws IOException {
    out.write(edks.size() & 0xFF);
    for (EncryptedDataKey edk : edks) {
      byte[] providerId = edk.keyProviderId().getBytes(StandardCharsets.UTF_8);
      byte[] providerInfo = toByteArray(edk.keyProviderInfo());
      byte[] ciphertext = toByteArray(edk.ciphertext());

      writeUint16To(out, providerId.length);
      out.write(providerId);
      writeUint16To(out, providerInfo.length);
      out.write(providerInfo);
      writeUint16To(out, ciphertext.length);
      out.write(ciphertext);
    }
  }

  private static void writeUint16To(ByteArrayOutputStream out, int value) throws IOException {
    out.write((value >> 8) & 0xFF);
    out.write(value & 0xFF);
  }

  private static int compareBytes(byte[] a, byte[] b) {
    int len = Math.min(a.length, b.length);
    for (int i = 0; i < len; i++) {
      int cmp = (a[i] & 0xFF) - (b[i] & 0xFF);
      if (cmp != 0) return cmp;
    }
    return a.length - b.length;
  }

  private static byte[] toByteArray(java.nio.ByteBuffer buf) {
    if (buf == null) return new byte[0];
    buf = buf.asReadOnlyBuffer();
    byte[] arr = new byte[buf.remaining()];
    buf.get(arr);
    return arr;
  }
}
