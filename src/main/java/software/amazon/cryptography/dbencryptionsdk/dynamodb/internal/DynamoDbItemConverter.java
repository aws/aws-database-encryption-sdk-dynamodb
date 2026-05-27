// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internal;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionUtil;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructureSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;

import static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionUtil.*;

/**
 * Converts DynamoDB Items (Map of AttributeValue) to/from StructuredDataTerminals.
 *
 * //= specification/dynamodb-encryption-client/ddb-item-conversion.md#convert-ddb-item-to-structured-data
 * //# A Structured Data converted from a DynamoDB Item has the following requirements:
 * //# - MUST contain a Structured Data Terminal for each attribute on the DynamoDB Item, and no others.
 */
public final class DynamoDbItemConverter {

  private DynamoDbItemConverter() {}

  // UTF-16 binary order comparator for strings (matches DDB spec for set ordering)
  private static final Comparator<String> UTF16_BINARY_ORDER = (a, b) -> {
    int len = Math.min(a.length(), b.length());
    for (int i = 0; i < len; i++) {
      int cmp = Character.compare(a.charAt(i), b.charAt(i));
      if (cmp != 0) return cmp;
    }
    return a.length() - b.length();
  };

  private static final Comparator<byte[]> BYTE_LEX_ORDER = (a, b) -> {
    int len = Math.min(a.length, b.length);
    for (int i = 0; i < len; i++) {
      int cmp = (a[i] & 0xFF) - (b[i] & 0xFF);
      if (cmp != 0) return cmp;
    }
    return a.length - b.length;
  };

  /** Convert a DDB item to a list of CryptoItems (for use with StructuredEncryption). */
  public static List<CryptoItem> itemToCryptoList(
    Map<String, AttributeValue> item,
    Map<String, CryptoAction> actions
  ) {
    List<CryptoItem> result = new ArrayList<>();
    for (Map.Entry<String, AttributeValue> entry : item.entrySet()) {
      String name = entry.getKey();
      CryptoAction action = actions.get(name);
      if (action == null) {
        // Beacon attributes added by the SDK should be SIGN_ONLY
        action = name.startsWith("aws_dbe_b_") ? CryptoAction.SIGN_ONLY : CryptoAction.DO_NOTHING;
      }
      StructuredDataTerminal terminal = serializeAttr(entry.getValue());
      List<PathSegment> path = makePath(name);
      result.add(CryptoItem.builder().key(path).data(terminal).action(action).build());
    }
    return result;
  }

  /** Convert a list of CryptoItems back to a DDB item. */
  public static Map<String, AttributeValue> cryptoListToItem(List<CryptoItem> cryptoList) {
    Map<String, AttributeValue> item = new TreeMap<>();
    for (CryptoItem ci : cryptoList) {
      String name = ci.key().get(0).member().key();
      // Skip header/footer
      if (HEADER_FIELD.equals(name) || FOOTER_FIELD.equals(name)) continue;
      AttributeValue av = deserializeAttr(ci.data());
      item.put(name, av);
    }
    return item;
  }

  /** Serialize a single AttributeValue to a StructuredDataTerminal. */
  public static StructuredDataTerminal serializeAttr(AttributeValue av) {
    if (av.s() != null) {
      return terminal(STRING_TYPE_ID, av.s().getBytes(StandardCharsets.UTF_8));
    } else if (av.n() != null) {
      String normalized = NumberNormalizer.normalize(av.n());
      return terminal(NUMBER_TYPE_ID, normalized.getBytes(StandardCharsets.UTF_8));
    } else if (av.b() != null) {
      return terminal(BYTES_TYPE_ID, av.b().asByteArray());
    } else if (av.bool() != null) {
      return terminal(BOOLEAN_TYPE_ID, new byte[] { av.bool() ? (byte) 1 : (byte) 0 });
    } else if (av.nul() != null && av.nul()) {
      return terminal(NULL_TYPE_ID, new byte[0]);
    } else if (av.hasSs()) {
      return terminal(STRING_SET_TYPE_ID, serializeStringSet(av.ss()));
    } else if (av.hasNs()) {
      return terminal(NUMBER_SET_TYPE_ID, serializeNumberSet(av.ns()));
    } else if (av.hasBs()) {
      return terminal(BINARY_SET_TYPE_ID, serializeBinarySet(av.bs()));
    } else if (av.hasM()) {
      return terminal(MAP_TYPE_ID, serializeMap(av.m()));
    } else if (av.hasL()) {
      return terminal(LIST_TYPE_ID, serializeList(av.l()));
    }
    throw new IllegalArgumentException("Unsupported AttributeValue type");
  }

  /** Deserialize a StructuredDataTerminal back to an AttributeValue. */
  public static AttributeValue deserializeAttr(StructuredDataTerminal terminal) {
    byte[] typeId = toBytes(terminal.typeId());
    byte[] value = toBytes(terminal.value());

    if (eq(typeId, STRING_TYPE_ID)) {
      return AttributeValue.fromS(new String(value, StandardCharsets.UTF_8));
    } else if (eq(typeId, NUMBER_TYPE_ID)) {
      return AttributeValue.fromN(new String(value, StandardCharsets.UTF_8));
    } else if (eq(typeId, BYTES_TYPE_ID)) {
      return AttributeValue.fromB(SdkBytes.fromByteArray(value));
    } else if (eq(typeId, BOOLEAN_TYPE_ID)) {
      return AttributeValue.fromBool(value.length > 0 && value[0] != 0);
    } else if (eq(typeId, NULL_TYPE_ID)) {
      return AttributeValue.fromNul(true);
    } else if (eq(typeId, STRING_SET_TYPE_ID)) {
      return AttributeValue.fromSs(deserializeStringSet(value));
    } else if (eq(typeId, NUMBER_SET_TYPE_ID)) {
      return AttributeValue.fromNs(deserializeNumberSet(value));
    } else if (eq(typeId, BINARY_SET_TYPE_ID)) {
      return AttributeValue.fromBs(deserializeBinarySet(value));
    } else if (eq(typeId, MAP_TYPE_ID)) {
      return AttributeValue.fromM(deserializeMap(value));
    } else if (eq(typeId, LIST_TYPE_ID)) {
      return AttributeValue.fromL(deserializeList(value));
    }
    throw new IllegalArgumentException("Unknown type ID: " + hex(typeId));
  }

  // --- Set serialization (sorted, with 4-byte count + 4-byte length per entry) ---

  private static byte[] serializeStringSet(List<String> ss) {
    List<String> sorted = new ArrayList<>(ss);
    sorted.sort(UTF16_BINARY_ORDER);
    return serializeSetEntries(sorted.stream()
      .map(s -> s.getBytes(StandardCharsets.UTF_8))
      .collect(java.util.stream.Collectors.toList()));
  }

  private static byte[] serializeNumberSet(List<String> ns) {
    List<String> normalized = new ArrayList<>();
    for (String n : ns) normalized.add(NumberNormalizer.normalize(n));
    normalized.sort(UTF16_BINARY_ORDER);
    return serializeSetEntries(normalized.stream()
      .map(s -> s.getBytes(StandardCharsets.UTF_8))
      .collect(java.util.stream.Collectors.toList()));
  }

  private static byte[] serializeBinarySet(List<SdkBytes> bs) {
    List<byte[]> entries = new ArrayList<>();
    for (SdkBytes b : bs) entries.add(b.asByteArray());
    entries.sort(BYTE_LEX_ORDER);
    return serializeSetEntries(entries);
  }

  private static byte[] serializeSetEntries(List<byte[]> entries) {
    int size = 4;
    for (byte[] e : entries) size += 4 + e.length;
    ByteBuffer buf = ByteBuffer.allocate(size);
    buf.putInt(entries.size());
    for (byte[] e : entries) {
      buf.putInt(e.length);
      buf.put(e);
    }
    return buf.array();
  }

  private static List<String> deserializeStringSet(byte[] data) {
    ByteBuffer buf = ByteBuffer.wrap(data);
    int count = buf.getInt();
    List<String> result = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      int len = buf.getInt();
      byte[] entry = new byte[len];
      buf.get(entry);
      result.add(new String(entry, StandardCharsets.UTF_8));
    }
    return result;
  }

  private static List<String> deserializeNumberSet(byte[] data) {
    return deserializeStringSet(data); // same format, numbers stored as strings
  }

  private static List<SdkBytes> deserializeBinarySet(byte[] data) {
    ByteBuffer buf = ByteBuffer.wrap(data);
    int count = buf.getInt();
    List<SdkBytes> result = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      int len = buf.getInt();
      byte[] entry = new byte[len];
      buf.get(entry);
      result.add(SdkBytes.fromByteArray(entry));
    }
    return result;
  }

  // --- Map serialization (sorted by key, with type+length for key and value) ---

  private static byte[] serializeMap(Map<String, AttributeValue> m) {
    TreeMap<String, AttributeValue> sorted = new TreeMap<>(UTF16_BINARY_ORDER);
    sorted.putAll(m);
    java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
    writeInt(out, sorted.size());
    for (Map.Entry<String, AttributeValue> entry : sorted.entrySet()) {
      byte[] keyBytes = entry.getKey().getBytes(StandardCharsets.UTF_8);
      StructuredDataTerminal valTerminal = serializeAttr(entry.getValue());
      byte[] valTypeId = toBytes(valTerminal.typeId());
      byte[] valBytes = toBytes(valTerminal.value());
      // Key: typeId(STRING) + length + key
      write(out, STRING_TYPE_ID);
      writeInt(out, keyBytes.length);
      write(out, keyBytes);
      // Value: typeId + length + value
      write(out, valTypeId);
      writeInt(out, valBytes.length);
      write(out, valBytes);
    }
    return out.toByteArray();
  }

  private static Map<String, AttributeValue> deserializeMap(byte[] data) {
    ByteBuffer buf = ByteBuffer.wrap(data);
    int count = buf.getInt();
    Map<String, AttributeValue> result = new TreeMap<>();
    for (int i = 0; i < count; i++) {
      byte[] keyTypeId = new byte[2]; buf.get(keyTypeId);
      int keyLen = buf.getInt();
      byte[] keyBytes = new byte[keyLen]; buf.get(keyBytes);
      byte[] valTypeId = new byte[2]; buf.get(valTypeId);
      int valLen = buf.getInt();
      byte[] valBytes = new byte[valLen]; buf.get(valBytes);
      String key = new String(keyBytes, StandardCharsets.UTF_8);
      StructuredDataTerminal valTerminal = terminal(valTypeId, valBytes);
      result.put(key, deserializeAttr(valTerminal));
    }
    return result;
  }

  // --- List serialization (ordered, with type+length per entry) ---

  private static byte[] serializeList(List<AttributeValue> l) {
    java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
    writeInt(out, l.size());
    for (AttributeValue av : l) {
      StructuredDataTerminal t = serializeAttr(av);
      byte[] typeId = toBytes(t.typeId());
      byte[] value = toBytes(t.value());
      write(out, typeId);
      writeInt(out, value.length);
      write(out, value);
    }
    return out.toByteArray();
  }

  private static List<AttributeValue> deserializeList(byte[] data) {
    ByteBuffer buf = ByteBuffer.wrap(data);
    int count = buf.getInt();
    List<AttributeValue> result = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      byte[] typeId = new byte[2]; buf.get(typeId);
      int len = buf.getInt();
      byte[] value = new byte[len]; buf.get(value);
      result.add(deserializeAttr(terminal(typeId, value)));
    }
    return result;
  }

  // --- Helpers ---

  private static List<PathSegment> makePath(String name) {
    return java.util.Collections.singletonList(
      PathSegment.builder().member(StructureSegment.builder().key(name).build()).build()
    );
  }

  private static StructuredDataTerminal terminal(byte[] typeId, byte[] value) {
    return StructuredDataTerminal.builder()
      .typeId(ByteBuffer.wrap(typeId))
      .value(ByteBuffer.wrap(value))
      .build();
  }

  private static byte[] toBytes(ByteBuffer buf) {
    if (buf == null) return new byte[0];
    buf = buf.asReadOnlyBuffer();
    byte[] arr = new byte[buf.remaining()];
    buf.get(arr);
    return arr;
  }

  private static boolean eq(byte[] a, byte[] b) {
    return java.util.Arrays.equals(a, b);
  }

  private static String hex(byte[] b) {
    StringBuilder sb = new StringBuilder();
    for (byte v : b) sb.append(String.format("%02x", v & 0xFF));
    return sb.toString();
  }

  private static void writeInt(java.io.ByteArrayOutputStream out, int v) {
    out.write((v >> 24) & 0xFF);
    out.write((v >> 16) & 0xFF);
    out.write((v >> 8) & 0xFF);
    out.write(v & 0xFF);
  }

  private static void write(java.io.ByteArrayOutputStream out, byte[] data) {
    out.write(data, 0, data.length);
  }
}
