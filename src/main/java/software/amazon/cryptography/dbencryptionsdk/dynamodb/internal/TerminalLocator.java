// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internal;

import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * Parses and resolves terminal locations in structured data.
 * A terminal location is a dotted path like "address.zip" or "name"
 * that identifies a leaf value in a DynamoDB item.
 *
 * //= specification/searchable-encryption/virtual.md#terminal-location
 * //# A terminal location is a path to a terminal value in a structured data map.
 */
public final class TerminalLocator {

  private TerminalLocator() {}

  /**
   * Resolve a terminal location path to its value in a DDB item.
   *
   * @param loc The location path (e.g. "address.zip", "name", "tags[0]")
   * @param item The DDB item
   * @return The resolved AttributeValue, or null if not found
   */
  public static AttributeValue resolve(String loc, Map<String, AttributeValue> item) {
    if (loc == null || loc.isEmpty() || item == null) return null;

    String[] segments = loc.split("\\.");
    AttributeValue current = item.get(segments[0]);

    for (int i = 1; i < segments.length && current != null; i++) {
      String segment = segments[i];
      // Check for array index: segment[N]
      int bracketIdx = segment.indexOf('[');
      if (bracketIdx >= 0) {
        String mapKey = segment.substring(0, bracketIdx);
        int endBracket = segment.indexOf(']', bracketIdx);
        int index = Integer.parseInt(segment.substring(bracketIdx + 1, endBracket));
        if (!mapKey.isEmpty()) {
          if (current.m() == null) return null;
          current = current.m().get(mapKey);
          if (current == null) return null;
        }
        if (current.l() == null || index >= current.l().size()) return null;
        current = current.l().get(index);
      } else {
        if (current.m() == null) return null;
        current = current.m().get(segment);
      }
    }

    // Handle top-level array index: "field[0]"
    if (segments.length == 1 && segments[0].contains("[")) {
      String seg = segments[0];
      int bracketIdx = seg.indexOf('[');
      String field = seg.substring(0, bracketIdx);
      int endBracket = seg.indexOf(']', bracketIdx);
      int index = Integer.parseInt(seg.substring(bracketIdx + 1, endBracket));
      current = item.get(field);
      if (current == null || current.l() == null || index >= current.l().size()) return null;
      current = current.l().get(index);
    }

    return current;
  }

  /**
   * Resolve a terminal location to a string value.
   * Returns null if the path doesn't resolve or the terminal isn't a string.
   */
  public static String resolveToString(String loc, Map<String, AttributeValue> item) {
    AttributeValue av = resolve(loc, item);
    if (av == null) return null;
    if (av.s() != null) return av.s();
    if (av.n() != null) return av.n();
    return null;
  }
}
