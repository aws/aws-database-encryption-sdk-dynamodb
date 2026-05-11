// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;

import static org.junit.jupiter.api.Assertions.*;

class DynamoDbItemConverterTest {

  @Test
  void stringRoundTrip() {
    AttributeValue av = AttributeValue.fromS("hello world");
    StructuredDataTerminal t = DynamoDbItemConverter.serializeAttr(av);
    AttributeValue result = DynamoDbItemConverter.deserializeAttr(t);
    assertEquals("hello world", result.s());
  }

  @Test
  void numberRoundTrip() {
    AttributeValue av = AttributeValue.fromN("123.456");
    StructuredDataTerminal t = DynamoDbItemConverter.serializeAttr(av);
    AttributeValue result = DynamoDbItemConverter.deserializeAttr(t);
    assertEquals("123.456", result.n());
  }

  @Test
  void numberNormalized() {
    AttributeValue av = AttributeValue.fromN("00123.4560");
    StructuredDataTerminal t = DynamoDbItemConverter.serializeAttr(av);
    AttributeValue result = DynamoDbItemConverter.deserializeAttr(t);
    assertEquals("123.456", result.n());
  }

  @Test
  void binaryRoundTrip() {
    byte[] data = new byte[] { 0x01, 0x02, 0x03 };
    AttributeValue av = AttributeValue.fromB(SdkBytes.fromByteArray(data));
    StructuredDataTerminal t = DynamoDbItemConverter.serializeAttr(av);
    AttributeValue result = DynamoDbItemConverter.deserializeAttr(t);
    assertArrayEquals(data, result.b().asByteArray());
  }

  @Test
  void booleanRoundTrip() {
    AttributeValue avTrue = AttributeValue.fromBool(true);
    AttributeValue avFalse = AttributeValue.fromBool(false);
    assertEquals(true, DynamoDbItemConverter.deserializeAttr(DynamoDbItemConverter.serializeAttr(avTrue)).bool());
    assertEquals(false, DynamoDbItemConverter.deserializeAttr(DynamoDbItemConverter.serializeAttr(avFalse)).bool());
  }

  @Test
  void nullRoundTrip() {
    AttributeValue av = AttributeValue.fromNul(true);
    StructuredDataTerminal t = DynamoDbItemConverter.serializeAttr(av);
    AttributeValue result = DynamoDbItemConverter.deserializeAttr(t);
    assertTrue(result.nul());
  }

  @Test
  void stringSetRoundTrip() {
    AttributeValue av = AttributeValue.fromSs(Arrays.asList("banana", "apple", "cherry"));
    StructuredDataTerminal t = DynamoDbItemConverter.serializeAttr(av);
    AttributeValue result = DynamoDbItemConverter.deserializeAttr(t);
    // Sets are sorted in UTF-16 binary order
    assertEquals(Arrays.asList("apple", "banana", "cherry"), result.ss());
  }

  @Test
  void numberSetRoundTrip() {
    AttributeValue av = AttributeValue.fromNs(Arrays.asList("3", "1", "2"));
    StructuredDataTerminal t = DynamoDbItemConverter.serializeAttr(av);
    AttributeValue result = DynamoDbItemConverter.deserializeAttr(t);
    assertEquals(3, result.ns().size());
  }

  @Test
  void binarySetRoundTrip() {
    AttributeValue av = AttributeValue.fromBs(Arrays.asList(
      SdkBytes.fromByteArray(new byte[] { 0x02 }),
      SdkBytes.fromByteArray(new byte[] { 0x01 })
    ));
    StructuredDataTerminal t = DynamoDbItemConverter.serializeAttr(av);
    AttributeValue result = DynamoDbItemConverter.deserializeAttr(t);
    assertEquals(2, result.bs().size());
    // Sorted lexicographically
    assertArrayEquals(new byte[] { 0x01 }, result.bs().get(0).asByteArray());
    assertArrayEquals(new byte[] { 0x02 }, result.bs().get(1).asByteArray());
  }

  @Test
  void mapRoundTrip() {
    Map<String, AttributeValue> m = new HashMap<>();
    m.put("name", AttributeValue.fromS("Alice"));
    m.put("age", AttributeValue.fromN("30"));
    AttributeValue av = AttributeValue.fromM(m);
    StructuredDataTerminal t = DynamoDbItemConverter.serializeAttr(av);
    AttributeValue result = DynamoDbItemConverter.deserializeAttr(t);
    assertEquals("Alice", result.m().get("name").s());
    assertEquals("30", result.m().get("age").n());
  }

  @Test
  void listRoundTrip() {
    AttributeValue av = AttributeValue.fromL(Arrays.asList(
      AttributeValue.fromS("hello"),
      AttributeValue.fromN("42"),
      AttributeValue.fromBool(true)
    ));
    StructuredDataTerminal t = DynamoDbItemConverter.serializeAttr(av);
    AttributeValue result = DynamoDbItemConverter.deserializeAttr(t);
    assertEquals(3, result.l().size());
    assertEquals("hello", result.l().get(0).s());
    assertEquals("42", result.l().get(1).n());
    assertTrue(result.l().get(2).bool());
  }
}
