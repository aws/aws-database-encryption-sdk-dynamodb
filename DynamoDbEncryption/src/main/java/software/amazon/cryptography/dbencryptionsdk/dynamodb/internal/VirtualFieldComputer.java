// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internal;

import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualTransform;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.VirtualPart;

/**
 * Computes virtual fields by applying transforms to source field values.
 *
 * //= specification/searchable-encryption/virtual.md
 * //# A virtual field is a string computed from parts of a record.
 */
public final class VirtualFieldComputer {

  private VirtualFieldComputer() {}

  /**
   * Compute a virtual field value from an item given a list of parts.
   * Returns null if any required source field is missing.
   */
  public static String compute(List<VirtualPart> parts, Map<String, AttributeValue> item) {
    StringBuilder sb = new StringBuilder();
    for (VirtualPart part : parts) {
      String loc = part.loc();
      AttributeValue av = resolveLocation(loc, item);
      if (av == null || av.s() == null) return null;
      String value = av.s();
      if (part.trans() != null) {
        for (VirtualTransform transform : part.trans()) {
          value = applyTransform(transform, value);
        }
      }
      sb.append(value);
    }
    return sb.toString();
  }

  private static String applyTransform(VirtualTransform transform, String value) {
    if (transform.upper() != null) {
      return value.toUpperCase();
    } else if (transform.lower() != null) {
      return value.toLowerCase();
    } else if (transform.insert() != null) {
      String literal = transform.insert().literal();
      return value + literal;
    } else if (transform.prefix() != null) {
      int len = transform.prefix().length();
      return value.length() <= len ? value : value.substring(0, len);
    } else if (transform.suffix() != null) {
      int len = transform.suffix().length();
      return value.length() <= len ? value : value.substring(value.length() - len);
    } else if (transform.substring() != null) {
      int low = transform.substring().low();
      int high = transform.substring().high();
      if (low >= value.length()) return "";
      return value.substring(low, Math.min(high, value.length()));
    } else if (transform.segment() != null) {
      String split = transform.segment().split();
      int index = transform.segment().index();
      String[] segments = value.split(java.util.regex.Pattern.quote(split), -1);
      if (index < 0) index = segments.length + index;
      if (index < 0 || index >= segments.length) return "";
      return segments[index];
    }
    return value;
  }

  private static AttributeValue resolveLocation(String loc, Map<String, AttributeValue> item) {
    // Simple case: top-level attribute name
    // Complex case: dotted path (e.g. "address.zip") — for now handle top-level only
    if (loc.contains(".")) {
      String[] parts = loc.split("\\.", 2);
      AttributeValue av = item.get(parts[0]);
      if (av != null && av.m() != null) {
        return av.m().get(parts[1]);
      }
      return null;
    }
    return item.get(loc);
  }
}
