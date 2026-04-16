// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.ddbconversion;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;

/**
 * Converts between AWS SDK v2 {@link AttributeValue} and
 * {@link StructuredDataTerminal} per the DDB Attribute Serialization spec.
 */
public final class AttributeSerializer {

  private static final int MAX_DEPTH = 32;

  private AttributeSerializer() {}

  /** Convert a DDB AttributeValue to a StructuredDataTerminal. */
  public static StructuredDataTerminal serializeAttr(AttributeValue attr) {
    return new StructuredDataTerminal(
      serializeValue(attr),
      TypeId.typeIdForAttributeValue(attr)
    );
  }

  /** Convert a StructuredDataTerminal back to a DDB AttributeValue. */
  public static AttributeValue deserializeAttr(StructuredDataTerminal terminal) {
    return deserializeValue(terminal.getTypeId(), terminal.getValue());
  }

  /** Serialize just the value bytes for an AttributeValue. */
  public static byte[] serializeValue(AttributeValue attr) {
    return serializeValueInternal(attr, 0);
  }

  /** Deserialize value bytes given a type ID. */
  public static AttributeValue deserializeValue(byte[] typeId, byte[] value) {
    return deserializeValueInternal(typeId, value, 0);
  }

  // ---- Serialization ----

  private static byte[] serializeValueInternal(AttributeValue attr, int depth) {
    if (attr.nul() != null && attr.nul()) {
      return new byte[0];
    }
    if (attr.s() != null) {
      return attr.s().getBytes(StandardCharsets.UTF_8);
    }
    if (attr.n() != null) {
      return NormalizeNumber.normalizeNumber(attr.n())
        .getBytes(StandardCharsets.UTF_8);
    }
    if (attr.b() != null) {
      return attr.b().asByteArray();
    }
    if (attr.bool() != null) {
      return new byte[] { attr.bool() ? (byte) 0x01 : (byte) 0x00 };
    }
    if (attr.hasSs()) {
      return serializeStringSet(attr.ss());
    }
    if (attr.hasNs()) {
      return serializeNumberSet(attr.ns());
    }
    if (attr.hasBs()) {
      return serializeBinarySet(attr.bs());
    }
    if (attr.hasM()) {
      checkDepth(depth);
      return serializeMap(attr.m(), depth);
    }
    if (attr.hasL()) {
      checkDepth(depth);
      return serializeList(attr.l(), depth);
    }
    throw new DbeException("Unknown AttributeValue type");
  }

  private static byte[] serializeStringSet(List<String> ss) {
    TreeSet<String> sorted = new TreeSet<>(ss);
    if (sorted.size() != ss.size()) {
      throw new DbeException("Duplicate values in String Set");
    }
    List<byte[]> entries = new ArrayList<>(sorted.size());
    for (String s : sorted) {
      entries.add(s.getBytes(StandardCharsets.UTF_8));
    }
    return packSet(entries);
  }

  private static byte[] serializeNumberSet(List<String> ns) {
    TreeSet<String> sorted = new TreeSet<>();
    for (String n : ns) {
      if (!sorted.add(NormalizeNumber.normalizeNumber(n))) {
        throw new DbeException("Duplicate values in Number Set");
      }
    }
    List<byte[]> entries = new ArrayList<>(sorted.size());
    for (String n : sorted) {
      entries.add(n.getBytes(StandardCharsets.UTF_8));
    }
    return packSet(entries);
  }

  private static byte[] serializeBinarySet(List<SdkBytes> bs) {
    List<byte[]> arrays = new ArrayList<>(bs.size());
    for (SdkBytes b : bs) {
      arrays.add(b.asByteArray());
    }
    Collections.sort(arrays, UNSIGNED_LEX_COMPARATOR);
    // Check duplicates
    for (int i = 1; i < arrays.size(); i++) {
      if (Arrays.equals(arrays.get(i - 1), arrays.get(i))) {
        throw new DbeException("Duplicate values in Binary Set");
      }
    }
    return packSet(arrays);
  }

  /** Pack a list of byte arrays as: 4-byte count + (4-byte length + bytes) per entry. */
  private static byte[] packSet(List<byte[]> entries) {
    int total = 4;
    for (byte[] e : entries) {
      total += 4 + e.length;
    }
    ByteBuffer buf = ByteBuffer.allocate(total);
    buf.putInt(entries.size());
    for (byte[] e : entries) {
      buf.putInt(e.length);
      buf.put(e);
    }
    return buf.array();
  }

  private static byte[] serializeMap(
    Map<String, AttributeValue> m,
    int depth
  ) {
    List<String> keys = new ArrayList<>(m.keySet());
    Collections.sort(keys);
    int total = 4;
    List<byte[]> serializedKeys = new ArrayList<>(keys.size());
    List<byte[]> serializedTypeIds = new ArrayList<>(keys.size());
    List<byte[]> serializedValues = new ArrayList<>(keys.size());
    for (String key : keys) {
      byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
      AttributeValue val = m.get(key);
      byte[] typeId = TypeId.typeIdForAttributeValue(val);
      byte[] valBytes = serializeValueInternal(val, depth + 1);
      serializedKeys.add(keyBytes);
      serializedTypeIds.add(typeId);
      serializedValues.add(valBytes);
      // 2 (key type) + 4 (key len) + key + 2 (val type) + 4 (val len) + val
      total += 2 + 4 + keyBytes.length + 2 + 4 + valBytes.length;
    }
    ByteBuffer buf = ByteBuffer.allocate(total);
    buf.putInt(keys.size());
    for (int i = 0; i < keys.size(); i++) {
      buf.putShort((short) 0x0001); // key type: String
      buf.putInt(serializedKeys.get(i).length);
      buf.put(serializedKeys.get(i));
      buf.put(serializedTypeIds.get(i));
      buf.putInt(serializedValues.get(i).length);
      buf.put(serializedValues.get(i));
    }
    return buf.array();
  }

  private static byte[] serializeList(
    List<AttributeValue> l,
    int depth
  ) {
    int total = 4;
    List<byte[]> typeIds = new ArrayList<>(l.size());
    List<byte[]> values = new ArrayList<>(l.size());
    for (AttributeValue item : l) {
      byte[] typeId = TypeId.typeIdForAttributeValue(item);
      byte[] valBytes = serializeValueInternal(item, depth + 1);
      typeIds.add(typeId);
      values.add(valBytes);
      total += 2 + 4 + valBytes.length;
    }
    ByteBuffer buf = ByteBuffer.allocate(total);
    buf.putInt(l.size());
    for (int i = 0; i < l.size(); i++) {
      buf.put(typeIds.get(i));
      buf.putInt(values.get(i).length);
      buf.put(values.get(i));
    }
    return buf.array();
  }

  // ---- Deserialization ----

  private static AttributeValue deserializeValueInternal(
    byte[] typeId,
    byte[] value,
    int depth
  ) {
    if (Arrays.equals(typeId, TypeId.NULL)) {
      return AttributeValue.fromNul(true);
    }
    if (Arrays.equals(typeId, TypeId.STRING)) {
      return AttributeValue.fromS(new String(value, StandardCharsets.UTF_8));
    }
    if (Arrays.equals(typeId, TypeId.NUMBER)) {
      return AttributeValue.fromN(new String(value, StandardCharsets.UTF_8));
    }
    if (Arrays.equals(typeId, TypeId.BINARY)) {
      return AttributeValue.fromB(SdkBytes.fromByteArray(value));
    }
    if (Arrays.equals(typeId, TypeId.BOOLEAN)) {
      if (value.length != 1) {
        throw new DbeException("Invalid boolean value: expected 1 byte");
      }
      if (value[0] == 0x00) {
        return AttributeValue.fromBool(false);
      } else if (value[0] == 0x01) {
        return AttributeValue.fromBool(true);
      } else {
        throw new DbeException("Invalid boolean value: " + (value[0] & 0xFF));
      }
    }
    if (Arrays.equals(typeId, TypeId.STRING_SET)) {
      return deserializeStringSet(value);
    }
    if (Arrays.equals(typeId, TypeId.NUMBER_SET)) {
      return deserializeNumberSet(value);
    }
    if (Arrays.equals(typeId, TypeId.BINARY_SET)) {
      return deserializeBinarySet(value);
    }
    if (Arrays.equals(typeId, TypeId.MAP)) {
      checkDepth(depth);
      return deserializeMap(value, depth);
    }
    if (Arrays.equals(typeId, TypeId.LIST)) {
      checkDepth(depth);
      return deserializeList(value, depth);
    }
    throw new DbeException(
      "Unknown type ID: [" + (typeId[0] & 0xFF) + ", " + (typeId[1] & 0xFF) + "]"
    );
  }

  private static AttributeValue deserializeStringSet(byte[] value) {
    List<byte[]> entries = unpackSet(value);
    List<String> ss = new ArrayList<>(entries.size());
    for (byte[] e : entries) {
      String s = new String(e, StandardCharsets.UTF_8);
      if (ss.contains(s)) {
        throw new DbeException("Duplicate value in String Set");
      }
      ss.add(s);
    }
    return AttributeValue.builder().ss(ss).build();
  }

  private static AttributeValue deserializeNumberSet(byte[] value) {
    List<byte[]> entries = unpackSet(value);
    List<String> ns = new ArrayList<>(entries.size());
    for (byte[] e : entries) {
      String n = new String(e, StandardCharsets.UTF_8);
      if (ns.contains(n)) {
        throw new DbeException("Duplicate value in Number Set");
      }
      ns.add(n);
    }
    return AttributeValue.builder().ns(ns).build();
  }

  private static AttributeValue deserializeBinarySet(byte[] value) {
    List<byte[]> entries = unpackSet(value);
    List<SdkBytes> bs = new ArrayList<>(entries.size());
    for (int i = 0; i < entries.size(); i++) {
      for (int j = 0; j < i; j++) {
        if (Arrays.equals(entries.get(i), entries.get(j))) {
          throw new DbeException("Duplicate value in Binary Set");
        }
      }
      bs.add(SdkBytes.fromByteArray(entries.get(i)));
    }
    return AttributeValue.builder().bs(bs).build();
  }

  private static List<byte[]> unpackSet(byte[] data) {
    ByteBuffer buf = ByteBuffer.wrap(data);
    int count = buf.getInt();
    List<byte[]> entries = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      int len = buf.getInt();
      byte[] entry = new byte[len];
      buf.get(entry);
      entries.add(entry);
    }
    return entries;
  }

  private static AttributeValue deserializeMap(byte[] value, int depth) {
    ByteBuffer buf = ByteBuffer.wrap(value);
    int count = buf.getInt();
    Map<String, AttributeValue> m = new LinkedHashMap<>(count);
    for (int i = 0; i < count; i++) {
      short keyType = buf.getShort();
      if (keyType != 0x0001) {
        throw new DbeException("Map key type must be String (0x0001), got: " + keyType);
      }
      int keyLen = buf.getInt();
      byte[] keyBytes = new byte[keyLen];
      buf.get(keyBytes);
      byte[] valTypeId = new byte[2];
      buf.get(valTypeId);
      int valLen = buf.getInt();
      byte[] valBytes = new byte[valLen];
      buf.get(valBytes);
      m.put(
        new String(keyBytes, StandardCharsets.UTF_8),
        deserializeValueInternal(valTypeId, valBytes, depth + 1)
      );
    }
    return AttributeValue.builder().m(m).build();
  }

  private static AttributeValue deserializeList(byte[] value, int depth) {
    ByteBuffer buf = ByteBuffer.wrap(value);
    int count = buf.getInt();
    List<AttributeValue> l = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      byte[] typeId = new byte[2];
      buf.get(typeId);
      int len = buf.getInt();
      byte[] valBytes = new byte[len];
      buf.get(valBytes);
      l.add(deserializeValueInternal(typeId, valBytes, depth + 1));
    }
    return AttributeValue.builder().l(l).build();
  }

  // ---- Helpers ----

  private static void checkDepth(int depth) {
    if (depth >= MAX_DEPTH) {
      throw new DbeException(
        "Exceeded max nesting depth of " + MAX_DEPTH
      );
    }
  }

  private static final Comparator<byte[]> UNSIGNED_LEX_COMPARATOR =
    new Comparator<byte[]>() {
      @Override
      public int compare(byte[] a, byte[] b) {
        int len = Math.min(a.length, b.length);
        for (int i = 0; i < len; i++) {
          int cmp = (a[i] & 0xFF) - (b[i] & 0xFF);
          if (cmp != 0) return cmp;
        }
        return a.length - b.length;
      }
    };
}
