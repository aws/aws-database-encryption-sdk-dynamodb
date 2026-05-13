// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internal;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;

/**
 * Validates DynamoDB UpdateItem expressions against the crypto schema.
 *
 * //= specification/dynamodb-encryption-client/ddb-sdk-integration.md#validate-before-updateitem
 * //# UpdateItem MUST NOT modify any attribute which is configured as
 * //# ENCRYPT_AND_SIGN or SIGN_ONLY.
 */
public final class UpdateExpressionValidator {

  private UpdateExpressionValidator() {}

  // Matches SET, REMOVE, ADD, DELETE clauses and their attribute paths
  private static final Pattern ATTR_PATH_PATTERN = Pattern.compile(
    "(?:#?[a-zA-Z_][a-zA-Z0-9_]*)(?:\\.[a-zA-Z_][a-zA-Z0-9_]*|\\[\\d+\\])*"
  );

  /**
   * Validate that an update expression does not modify encrypted or signed attributes.
   *
   * @param updateExpression The DDB UpdateExpression
   * @param expressionAttributeNames The #name → attribute name map (may be null)
   * @param attributeActions The crypto actions for each attribute
   * @throws IllegalArgumentException if the expression modifies a protected attribute
   */
  public static void validate(
    String updateExpression,
    Map<String, String> expressionAttributeNames,
    Map<String, CryptoAction> attributeActions
  ) {
    if (updateExpression == null || updateExpression.isEmpty()) return;
    if (attributeActions == null || attributeActions.isEmpty()) return;

    Set<String> modifiedAttributes = extractModifiedAttributes(updateExpression, expressionAttributeNames);

    for (String attr : modifiedAttributes) {
      CryptoAction action = attributeActions.get(attr);
      if (action == CryptoAction.ENCRYPT_AND_SIGN || action == CryptoAction.SIGN_ONLY
          || action == CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT) {
        throw new IllegalArgumentException(
          "UpdateItem cannot modify attribute '" + attr + "' which is configured as " + action +
          ". Use PutItem to replace the entire item instead.");
      }
    }
  }

  /**
   * Extract the set of top-level attribute names modified by an update expression.
   */
  static Set<String> extractModifiedAttributes(String updateExpression, Map<String, String> nameMap) {
    Set<String> modified = new HashSet<>();
    // Parse SET, REMOVE, ADD, DELETE clauses
    String upper = updateExpression.toUpperCase();
    String[] clauses = {"SET", "REMOVE", "ADD", "DELETE"};

    for (String clause : clauses) {
      int idx = findClause(upper, clause);
      if (idx < 0) continue;
      int start = idx + clause.length();
      int end = findNextClause(upper, start);
      String body = updateExpression.substring(start, end).trim();
      extractAttributesFromClause(body, clause, nameMap, modified);
    }
    return modified;
  }

  private static int findClause(String upper, String clause) {
    int idx = 0;
    while (idx < upper.length()) {
      int found = upper.indexOf(clause, idx);
      if (found < 0) return -1;
      // Must be at start or preceded by whitespace
      if (found == 0 || Character.isWhitespace(upper.charAt(found - 1))) {
        int after = found + clause.length();
        if (after >= upper.length() || Character.isWhitespace(upper.charAt(after))) {
          return found;
        }
      }
      idx = found + 1;
    }
    return -1;
  }

  private static int findNextClause(String upper, int start) {
    String[] clauses = {"SET", "REMOVE", "ADD", "DELETE"};
    int min = upper.length();
    for (String clause : clauses) {
      int idx = start;
      while (idx < upper.length()) {
        int found = upper.indexOf(clause, idx);
        if (found < 0) break;
        if ((found == 0 || Character.isWhitespace(upper.charAt(found - 1))) &&
            (found + clause.length() >= upper.length() || Character.isWhitespace(upper.charAt(found + clause.length())))) {
          if (found < min) min = found;
          break;
        }
        idx = found + 1;
      }
    }
    return min;
  }

  private static void extractAttributesFromClause(
    String body, String clause, Map<String, String> nameMap, Set<String> modified
  ) {
    if (body.isEmpty()) return;
    // Split by comma for SET/ADD/DELETE, or whitespace for REMOVE
    String[] parts;
    if ("REMOVE".equals(clause)) {
      parts = body.split(",");
    } else {
      parts = body.split(",");
    }

    for (String part : parts) {
      String trimmed = part.trim();
      if (trimmed.isEmpty()) continue;
      // The first token is the attribute path being modified
      // For SET: path = value
      // For REMOVE: path
      // For ADD/DELETE: path value
      String attrPath;
      if ("SET".equals(clause)) {
        int eqIdx = trimmed.indexOf('=');
        attrPath = eqIdx > 0 ? trimmed.substring(0, eqIdx).trim() : trimmed;
      } else {
        int spaceIdx = trimmed.indexOf(' ');
        attrPath = spaceIdx > 0 ? trimmed.substring(0, spaceIdx).trim() : trimmed;
      }
      // Get top-level attribute name (before any dot or bracket)
      String topLevel = getTopLevelName(attrPath);
      // Resolve #placeholder if needed
      if (topLevel.startsWith("#") && nameMap != null) {
        String resolved = nameMap.get(topLevel);
        if (resolved != null) topLevel = resolved;
      }
      if (!topLevel.isEmpty() && !topLevel.startsWith(":")) {
        modified.add(topLevel);
      }
    }
  }

  private static String getTopLevelName(String path) {
    int dotIdx = path.indexOf('.');
    int bracketIdx = path.indexOf('[');
    int end = path.length();
    if (dotIdx > 0) end = Math.min(end, dotIdx);
    if (bracketIdx > 0) end = Math.min(end, bracketIdx);
    return path.substring(0, end);
  }
}
