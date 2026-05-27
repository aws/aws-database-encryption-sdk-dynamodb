// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internal;

import java.util.HashMap;
import java.util.Map;

/**
 * Rewrites DynamoDB filter/condition/key-condition expressions to reference beacon attributes.
 *
 * //= specification/dynamodb-encryption-client/ddb-support.md#scaninputforbeacons
 * //# The request MUST be altered to transform any references to encrypted attributes
 * //# into references to beacons.
 */
public final class FilterExpressionRewriter {

  private FilterExpressionRewriter() {}

  /** Result of rewriting an expression. */
  public static final class RewriteResult {
    public final String expression;
    public final Map<String, String> expressionAttributeNames;
    public final Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> expressionAttributeValues;

    public RewriteResult(String expression, Map<String, String> expressionAttributeNames,
                         Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> expressionAttributeValues) {
      this.expression = expression;
      this.expressionAttributeNames = expressionAttributeNames;
      this.expressionAttributeValues = expressionAttributeValues;
    }
  }

  /**
   * Rewrite a filter/condition expression to use beacon attributes.
   *
   * @param expression The DDB expression (FilterExpression, KeyConditionExpression, etc.)
   * @param expressionAttributeNames The #name → attribute name map (may be null)
   * @param expressionAttributeValues The :val → AttributeValue map (may be null)
   * @param beacons Map of field name → StandardBeaconImpl for configured beacons
   * @param hmacKey The HMAC key for computing beacon values
   * @return RewriteResult with rewritten expression, names, and values
   */
  public static RewriteResult rewrite(
    String expression,
    Map<String, String> expressionAttributeNames,
    Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> expressionAttributeValues,
    Map<String, StandardBeaconImpl> beacons,
    byte[] hmacKey
  ) {
    return rewrite(expression, expressionAttributeNames, expressionAttributeValues, beacons, null, hmacKey);
  }

  /**
   * Rewrite a filter/condition expression to use beacon attributes (with compound beacon support).
   */
  public static RewriteResult rewrite(
    String expression,
    Map<String, String> expressionAttributeNames,
    Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> expressionAttributeValues,
    Map<String, StandardBeaconImpl> beacons,
    Map<String, CompoundBeaconImpl> compoundBeacons,
    byte[] hmacKey
  ) {
    if (expression == null || expression.isEmpty()) {
      return new RewriteResult(expression, expressionAttributeNames, expressionAttributeValues);
    }
    if (beacons == null || beacons.isEmpty()) {
      return new RewriteResult(expression, expressionAttributeNames, expressionAttributeValues);
    }

    Map<String, String> newNames = expressionAttributeNames != null
      ? new HashMap<>(expressionAttributeNames) : new HashMap<>();
    Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> newValues =
      expressionAttributeValues != null ? new HashMap<>(expressionAttributeValues) : new HashMap<>();

    // Build reverse map: attribute name → #placeholder(s) that reference it
    Map<String, String> attrToPlaceholder = new HashMap<>();
    for (Map.Entry<String, String> entry : newNames.entrySet()) {
      attrToPlaceholder.put(entry.getValue(), entry.getKey());
    }

    // For each beacon field, rewrite references in the expression
    StringBuilder rewritten = new StringBuilder(expression);
    for (Map.Entry<String, StandardBeaconImpl> entry : beacons.entrySet()) {
      String fieldName = entry.getKey();
      StandardBeaconImpl beacon = entry.getValue();
      String beaconAttrName = beacon.getBeaconAttributeName();

      // Case 1: field referenced via ExpressionAttributeNames (#placeholder)
      String placeholder = attrToPlaceholder.get(fieldName);
      if (placeholder != null) {
        // Rewrite the name mapping to point to beacon attribute
        newNames.put(placeholder, beaconAttrName);
        // Rewrite associated values
        rewriteValuesForField(rewritten.toString(), placeholder, beacon, hmacKey, newValues);
      } else {
        // Case 2: field referenced directly in expression (bare attribute name) — only if not via names
        if (expression.contains(fieldName)) {
          rewriteDirectReference(rewritten, fieldName, beaconAttrName, beacon, hmacKey, newValues);
        }
      }
    }

    // Handle compound beacons
    if (compoundBeacons != null && !compoundBeacons.isEmpty()) {
      for (Map.Entry<String, CompoundBeaconImpl> entry : compoundBeacons.entrySet()) {
        String fieldName = entry.getKey();
        CompoundBeaconImpl cb = entry.getValue();
        String beaconAttrName = cb.getBeaconAttributeName();

        // Check both original name and beacon attribute name (in case already renamed by prior rewrite)
        String placeholder = attrToPlaceholder.get(fieldName);
        if (placeholder == null) {
          placeholder = attrToPlaceholder.get(beaconAttrName);
        }
        if (placeholder != null && rewritten.toString().contains(placeholder)) {
          newNames.put(placeholder, beaconAttrName);
          // Hash compound beacon values
          rewriteCompoundValues(rewritten.toString(), placeholder, cb, hmacKey, newValues);
        } else if (rewritten.toString().contains(fieldName)) {
          String expr = rewritten.toString();
          String replaced = replaceWholeWord(expr, fieldName, beaconAttrName);
          rewritten.replace(0, rewritten.length(), replaced);
          rewriteCompoundValues(replaced, beaconAttrName, cb, hmacKey, newValues);
        }
      }
    }

    return new RewriteResult(rewritten.toString(), newNames, newValues);
  }

  /**
   * Rewrite expression attribute values associated with a beacon field.
   * Finds :val placeholders used in comparisons with the given field placeholder.
   */
  private static void rewriteValuesForField(
    String expression,
    String fieldPlaceholder,
    StandardBeaconImpl beacon,
    byte[] hmacKey,
    Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> values
  ) {
    // Find value placeholders that appear near the field placeholder in comparisons
    // Pattern: fieldPlaceholder <op> :val  OR  :val <op> fieldPlaceholder
    // Also: begins_with(fieldPlaceholder, :val), contains(fieldPlaceholder, :val)
    for (Map.Entry<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> entry :
         new HashMap<>(values).entrySet()) {
      String valPlaceholder = entry.getKey();
      if (isValueAssociatedWithField(expression, fieldPlaceholder, valPlaceholder)) {
        software.amazon.awssdk.services.dynamodb.model.AttributeValue av = entry.getValue();
        software.amazon.awssdk.services.dynamodb.model.AttributeValue beaconAv = computeBeaconAttributeValue(av, beacon, hmacKey);
        if (beaconAv != null) {
          values.put(valPlaceholder, beaconAv);
        }
      }
    }
  }

  /**
   * Rewrite a direct (bare) attribute reference in the expression.
   */
  private static void rewriteDirectReference(
    StringBuilder expression,
    String fieldName,
    String beaconAttrName,
    StandardBeaconImpl beacon,
    byte[] hmacKey,
    Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> values
  ) {
    // Replace bare field name with beacon attribute name
    // Be careful to only replace whole-word matches
    String expr = expression.toString();
    String replaced = replaceWholeWord(expr, fieldName, beaconAttrName);
    expression.replace(0, expression.length(), replaced);

    // Rewrite associated values
    for (Map.Entry<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> entry :
         new HashMap<>(values).entrySet()) {
      String valPlaceholder = entry.getKey();
      if (isValueAssociatedWithField(replaced, beaconAttrName, valPlaceholder)) {
        software.amazon.awssdk.services.dynamodb.model.AttributeValue av = entry.getValue();
        software.amazon.awssdk.services.dynamodb.model.AttributeValue beaconAv = computeBeaconAttributeValue(av, beacon, hmacKey);
        if (beaconAv != null) {
          values.put(valPlaceholder, beaconAv);
        }
      }
    }
  }

  /**
   * Check if a value placeholder is associated with a field in the expression.
   * Looks for patterns like: field = :val, field < :val, begins_with(field, :val), etc.
   */
  private static boolean isValueAssociatedWithField(String expression, String field, String valPlaceholder) {
    // Check: field <op> :val
    if (expression.matches("(?s).*" + escapeRegex(field) + "\\s*[=<>!]+\\s*" + escapeRegex(valPlaceholder) + "(?:\\s|\\)|$).*")) {
      return true;
    }
    // Check: :val <op> field
    if (expression.matches("(?s).*" + escapeRegex(valPlaceholder) + "\\s*[=<>!]+\\s*" + escapeRegex(field) + "(?:\\s|\\)|$).*")) {
      return true;
    }
    // Check: begins_with(field, :val) or contains(field, :val)
    if (expression.matches("(?s).*(?:begins_with|contains)\\s*\\(\\s*" + escapeRegex(field) + "\\s*,\\s*" + escapeRegex(valPlaceholder) + "\\s*\\).*")) {
      return true;
    }
    // Check: contains(:val, field) — reversed contains for set membership
    if (expression.matches("(?s).*contains\\s*\\(\\s*" + escapeRegex(valPlaceholder) + "\\s*,\\s*" + escapeRegex(field) + "\\s*\\).*")) {
      return true;
    }
    // Check: field BETWEEN :val1 AND :val2
    String betweenPattern = "(?s).*" + escapeRegex(field) + "\\s+(?i)BETWEEN\\s+.*" + escapeRegex(valPlaceholder) + ".*";
    if (expression.matches(betweenPattern)) {
      return true;
    }
    // Check: field IN (:val1, :val2, ...)
    if (expression.matches("(?s).*" + escapeRegex(field) + "\\s+(?i)IN\\s*\\(.*" + escapeRegex(valPlaceholder) + ".*\\).*")) {
      return true;
    }
    return false;
  }

  /** Compute beacon value from an AttributeValue. For sets, hash each element. */
  private static String computeBeaconValue(
    software.amazon.awssdk.services.dynamodb.model.AttributeValue av,
    StandardBeaconImpl beacon,
    byte[] hmacKey
  ) {
    if (av.s() != null) {
      return beacon.hashStr(av.s(), hmacKey);
    } else if (av.n() != null) {
      return beacon.hashStr(av.n(), hmacKey);
    } else if (av.b() != null) {
      return beacon.hash(av.b().asByteArray(), hmacKey);
    }
    return null;
  }

  /** Compute beacon value, returning a set if input is a set. */
  private static software.amazon.awssdk.services.dynamodb.model.AttributeValue computeBeaconAttributeValue(
    software.amazon.awssdk.services.dynamodb.model.AttributeValue av,
    StandardBeaconImpl beacon,
    byte[] hmacKey
  ) {
    if (av.hasSs()) {
      java.util.List<String> hashed = new java.util.ArrayList<>();
      for (String s : av.ss()) {
        hashed.add(beacon.hashStr(s, hmacKey));
      }
      return software.amazon.awssdk.services.dynamodb.model.AttributeValue.fromSs(hashed);
    }
    String scalar = computeBeaconValue(av, beacon, hmacKey);
    if (scalar != null) {
      return software.amazon.awssdk.services.dynamodb.model.AttributeValue.fromS(scalar);
    }
    return null;
  }

  /**
   * Rewrite compound beacon values: hash each encrypted part while keeping prefixes and split chars.
   */
  private static void rewriteCompoundValues(
    String expression,
    String fieldRef,
    CompoundBeaconImpl cb,
    byte[] hmacKey,
    Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> values
  ) {
    for (Map.Entry<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue> entry :
         new java.util.HashMap<>(values).entrySet()) {
      String valPlaceholder = entry.getKey();
      software.amazon.awssdk.services.dynamodb.model.AttributeValue av = entry.getValue();
      if (av.s() == null) continue;
      // Only hash values that look like compound beacon values (have a matching part prefix)
      // AND are referenced in the expression near this field
      if (!expression.contains(valPlaceholder)) continue;
      String val = av.s();
      boolean hasMatchingPrefix = false;
      for (CompoundBeaconImpl.EncryptedPart ep : cb.getEncryptedParts()) {
        if (val.startsWith(ep.prefix) || val.contains(cb.getSplitChar() + ep.prefix)) {
          hasMatchingPrefix = true;
          break;
        }
      }
      for (CompoundBeaconImpl.SignedPart sp : cb.getSignedParts()) {
        if (val.startsWith(sp.prefix) || val.contains(cb.getSplitChar() + sp.prefix)) {
          hasMatchingPrefix = true;
          break;
        }
      }
      if (hasMatchingPrefix) {
        String hashed = cb.hashCompoundValue(val, hmacKey);
        if (hashed != null) {
          values.put(valPlaceholder,
            software.amazon.awssdk.services.dynamodb.model.AttributeValue.fromS(hashed));
        }
      }
    }
  }

  /** Replace whole-word occurrences of a token in an expression. */
  private static String replaceWholeWord(String expression, String word, String replacement) {
    // Word boundary: not preceded/followed by alphanumeric or underscore
    return expression.replaceAll("(?<![a-zA-Z0-9_])" + escapeRegex(word) + "(?![a-zA-Z0-9_])", replacement);
  }

  private static String escapeRegex(String s) {
    return s.replaceAll("([\\\\\\[\\]{}()*+?.^$|#])", "\\\\$1");
  }
}
