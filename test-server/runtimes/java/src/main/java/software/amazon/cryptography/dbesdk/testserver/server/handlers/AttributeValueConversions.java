// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server.handlers;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.cryptography.dbesdk.testserver.model.AttributeValue;

/**
 * Translates between the modeled {@code AttributeValue} union (the wire shape defined by the
 * Smithy_Model, {@link AttributeValue}) and the AWS SDK v2 DynamoDB {@code AttributeValue}
 * ({@link software.amazon.awssdk.services.dynamodb.model.AttributeValue}) that the Enhanced_Client
 * adapter ({@code EnhancedClientHandle}) reads and writes.
 *
 * <p>The adapter ({@code EnhancedClientAdapter}) intentionally speaks only in SDK v2
 * {@code AttributeValue} maps and leaves the model&#8596;SDK translation to the operation handlers
 * (see {@code EnhancedClientHandle}'s contract). This class is that translation, factored out as a
 * dedicated, distinctly-named helper so both the {@code writeItem} handler (task 4.1) and the
 * {@code readItem} handler (task 4.2) share one implementation instead of duplicating it. Task 4.2
 * should reuse {@link #toModelItem(Map)} for its read path rather than recreating a converter.
 *
 * <p>All variants the Smithy_Model defines are handled in both directions: {@code S}, {@code N},
 * {@code B}, {@code BOOL}, {@code NULL}, {@code M}, {@code L}, {@code SS}, {@code NS}, {@code BS}.
 * Maps and lists recurse so arbitrarily nested items round-trip attribute-for-attribute (Req 7.3).
 *
 * <p>This class is stateless and its methods are pure; it is therefore thread-safe.
 */
public final class AttributeValueConversions {

  private AttributeValueConversions() {}

  // --- model -> SDK v2 ------------------------------------------------------------------------

  /**
   * Translates a modeled item (attribute name -&gt; modeled {@link AttributeValue}) into the SDK v2
   * attribute map the Enhanced_Client expects.
   *
   * @param modelItem the modeled item; must not be {@code null}
   * @return a new map of SDK v2 attribute values, preserving iteration order
   */
  public static Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> toSdkItem(
      final Map<String, AttributeValue> modelItem) {
    final Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> out =
        new LinkedHashMap<>(modelItem.size());
    for (final Map.Entry<String, AttributeValue> entry : modelItem.entrySet()) {
      out.put(entry.getKey(), toSdk(entry.getValue()));
    }
    return out;
  }

  /**
   * Translates a single modeled {@link AttributeValue} union into the SDK v2 {@code AttributeValue}.
   *
   * @param value the modeled attribute value; must not be {@code null}
   * @return the equivalent SDK v2 attribute value
   * @throws IllegalArgumentException if {@code value} is an unknown/unsupported union variant
   */
  public static software.amazon.awssdk.services.dynamodb.model.AttributeValue toSdk(
      final AttributeValue value) {
    final software.amazon.awssdk.services.dynamodb.model.AttributeValue.Builder b =
        software.amazon.awssdk.services.dynamodb.model.AttributeValue.builder();

    if (value instanceof AttributeValue.SMember s) {
      return b.s(s.s()).build();
    } else if (value instanceof AttributeValue.NMember n) {
      return b.n(n.n()).build();
    } else if (value instanceof AttributeValue.BMember bin) {
      return b.b(SdkBytes.fromByteBuffer(bin.b())).build();
    } else if (value instanceof AttributeValue.BoolMember bool) {
      return b.bool(bool.bool()).build();
    } else if (value instanceof AttributeValue.NullMemberMember nul) {
      // DynamoDB represents NULL as nul(true); preserve the modeled flag.
      return b.nul(nul.nullMember()).build();
    } else if (value instanceof AttributeValue.MMember m) {
      return b.m(toSdkItem(m.m())).build();
    } else if (value instanceof AttributeValue.LMember l) {
      final List<software.amazon.awssdk.services.dynamodb.model.AttributeValue> list =
          new ArrayList<>(l.l().size());
      for (final AttributeValue element : l.l()) {
        list.add(toSdk(element));
      }
      return b.l(list).build();
    } else if (value instanceof AttributeValue.SsMember ss) {
      return b.ss(ss.ss()).build();
    } else if (value instanceof AttributeValue.NsMember ns) {
      return b.ns(ns.ns()).build();
    } else if (value instanceof AttributeValue.BsMember bs) {
      final List<SdkBytes> blobs = new ArrayList<>(bs.bs().size());
      for (final ByteBuffer buffer : bs.bs()) {
        blobs.add(SdkBytes.fromByteBuffer(buffer));
      }
      return b.bs(blobs).build();
    }
    throw new IllegalArgumentException(
        "Unsupported modeled AttributeValue variant: " + value.getClass().getName());
  }

  // --- SDK v2 -> model ------------------------------------------------------------------------

  /**
   * Translates an SDK v2 attribute map (for example, a decrypted item read back from the
   * DynamoDB_Backend) into the modeled item the Smithy_Model returns on the wire. Provided here so
   * the {@code readItem} handler (task 4.2) reuses one converter rather than recreating it.
   *
   * @param sdkItem the SDK v2 item; must not be {@code null}
   * @return a new map of modeled attribute values, preserving iteration order
   */
  public static Map<String, AttributeValue> toModelItem(
      final Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> sdkItem) {
    final Map<String, AttributeValue> out = new LinkedHashMap<>(sdkItem.size());
    for (final Map.Entry<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue>
        entry : sdkItem.entrySet()) {
      out.put(entry.getKey(), toModel(entry.getValue()));
    }
    return out;
  }

  /**
   * Translates a single SDK v2 {@code AttributeValue} into the modeled {@link AttributeValue} union.
   *
   * @param value the SDK v2 attribute value; must not be {@code null}
   * @return the equivalent modeled attribute value
   * @throws IllegalArgumentException if {@code value} carries a type the model does not define
   */
  public static AttributeValue toModel(
      final software.amazon.awssdk.services.dynamodb.model.AttributeValue value) {
    switch (value.type()) {
      case S:
        return AttributeValue.builder().s(value.s()).build();
      case N:
        return AttributeValue.builder().n(value.n()).build();
      case B:
        return AttributeValue.builder().b(value.b().asByteBuffer()).build();
      case BOOL:
        return AttributeValue.builder().bool(value.bool()).build();
      case NUL:
        return AttributeValue.builder().nullMember(value.nul()).build();
      case M:
        return AttributeValue.builder().m(toModelItem(value.m())).build();
      case L:
        final List<AttributeValue> list = new ArrayList<>(value.l().size());
        for (final software.amazon.awssdk.services.dynamodb.model.AttributeValue element :
            value.l()) {
          list.add(toModel(element));
        }
        return AttributeValue.builder().l(list).build();
      case SS:
        return AttributeValue.builder().ss(value.ss()).build();
      case NS:
        return AttributeValue.builder().ns(value.ns()).build();
      case BS:
        final List<ByteBuffer> blobs = new ArrayList<>(value.bs().size());
        for (final SdkBytes blob : value.bs()) {
          blobs.add(blob.asByteBuffer());
        }
        return AttributeValue.builder().bs(blobs).build();
      default:
        throw new IllegalArgumentException(
            "Unsupported SDK AttributeValue type for the TestServer model: " + value.type());
    }
  }
}
