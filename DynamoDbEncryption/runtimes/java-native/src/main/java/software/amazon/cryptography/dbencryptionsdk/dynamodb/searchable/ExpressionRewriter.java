// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.searchable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * Rewrites DynamoDB filter/condition expressions to use beacon attribute names
 * and beacon values instead of plaintext field names and values.
 *
 * <p>For example, given a standard beacon "zipcode" with length 16:
 * <pre>
 *   Expression: "zipcode = :zip"
 *   ExpressionAttributeNames: {"#z": "zipcode"}
 *   ExpressionAttributeValues: {":zip": {"S": "12345"}}
 *
 *   Rewritten to:
 *   Expression: "aws_dbe_b_zipcode = :zip"  (or via #z → aws_dbe_b_zipcode)
 *   ExpressionAttributeValues: {":zip": {"S": "7abc"}}  (beacon value)
 * </pre>
 */
public final class ExpressionRewriter {

    private ExpressionRewriter() {}

    /** Result of rewriting an expression. */
    public static final class RewriteResult {
        private final String expression;
        private final Map<String, String> expressionAttributeNames;
        private final Map<String, AttributeValue> expressionAttributeValues;

        public RewriteResult(String expression,
                             Map<String, String> expressionAttributeNames,
                             Map<String, AttributeValue> expressionAttributeValues) {
            this.expression = expression;
            this.expressionAttributeNames = expressionAttributeNames;
            this.expressionAttributeValues = expressionAttributeValues;
        }

        public String getExpression() { return expression; }
        public Map<String, String> getExpressionAttributeNames() { return expressionAttributeNames; }
        public Map<String, AttributeValue> getExpressionAttributeValues() { return expressionAttributeValues; }
    }

    /**
     * Rewrite a filter/condition expression to use beacon attributes.
     *
     * @param expression the original expression
     * @param exprAttrNames expression attribute names (e.g. {"#z": "zipcode"})
     * @param exprAttrValues expression attribute values (e.g. {":zip": {"S": "12345"}})
     * @param beaconsByField map of source field name → StandardBeacon
     * @param beaconKey HMAC key for beacon computation
     * @return rewritten expression, names, and values
     */
    public static RewriteResult rewrite(
            String expression,
            Map<String, String> exprAttrNames,
            Map<String, AttributeValue> exprAttrValues,
            Map<String, StandardBeacon> beaconsByField,
            byte[] beaconKey) {

        if (expression == null || expression.isEmpty()) {
            return new RewriteResult(expression, exprAttrNames, exprAttrValues);
        }

        Map<String, String> newNames = exprAttrNames != null
            ? new LinkedHashMap<>(exprAttrNames) : new LinkedHashMap<String, String>();
        Map<String, AttributeValue> newValues = exprAttrValues != null
            ? new LinkedHashMap<>(exprAttrValues) : new LinkedHashMap<String, AttributeValue>();
        String newExpr = expression;

        // Rewrite expression attribute names that reference beacon fields
        // e.g. {"#z": "zipcode"} → {"#z": "aws_dbe_b_zipcode"}
        Map<String, StandardBeacon> nameToBeacon = new HashMap<>();
        for (Map.Entry<String, String> entry : newNames.entrySet()) {
            String placeholder = entry.getKey();
            String fieldName = entry.getValue();
            StandardBeacon beacon = beaconsByField.get(fieldName);
            if (beacon != null) {
                newNames.put(placeholder, beacon.getBeaconAttributeName());
                nameToBeacon.put(placeholder, beacon);
            }
        }

        // Also handle direct field references (no # prefix) in the expression
        for (Map.Entry<String, StandardBeacon> entry : beaconsByField.entrySet()) {
            String fieldName = entry.getKey();
            StandardBeacon beacon = entry.getValue();
            // Replace bare field name references with beacon attribute name
            // Only replace whole words (not substrings)
            newExpr = replaceWholeWord(newExpr, fieldName, beacon.getBeaconAttributeName());
        }

        // Rewrite expression attribute values that are compared to beacon fields
        // We need to find which value placeholders are compared to beacon fields
        // and replace their values with beacon values
        for (Map.Entry<String, AttributeValue> entry : new LinkedHashMap<>(newValues).entrySet()) {
            String valuePlaceholder = entry.getKey();
            AttributeValue value = entry.getValue();

            // Check if this value is used with a beacon field in the expression
            StandardBeacon beacon = findBeaconForValue(newExpr, valuePlaceholder, newNames, beaconsByField);
            if (beacon != null && value.s() != null) {
                String beaconValue = beacon.computeBeacon(value.s(), beaconKey);
                newValues.put(valuePlaceholder, AttributeValue.fromS(beaconValue));
            }
        }

        return new RewriteResult(newExpr, newNames, newValues);
    }

    /**
     * Find which beacon a value placeholder is compared against in the expression.
     */
    private static StandardBeacon findBeaconForValue(
            String expr, String valuePlaceholder,
            Map<String, String> names, Map<String, StandardBeacon> beaconsByField) {
        // Simple heuristic: look for patterns like "#name = :value" or "fieldName = :value"
        // and check if the field side references a beacon
        int idx = expr.indexOf(valuePlaceholder);
        while (idx >= 0) {
            // Look backwards from the value placeholder to find the field reference
            String before = expr.substring(0, idx).trim();
            // Find the last token before the operator
            String[] tokens = before.split("\\s+");
            if (tokens.length >= 2) {
                String fieldRef = tokens[tokens.length - 2]; // token before operator
                // Check if it's a name placeholder
                if (fieldRef.startsWith("#") && names.containsKey(fieldRef)) {
                    String resolvedName = names.get(fieldRef);
                    // Check if the resolved name is a beacon attribute
                    for (Map.Entry<String, StandardBeacon> e : beaconsByField.entrySet()) {
                        if (e.getValue().getBeaconAttributeName().equals(resolvedName)) {
                            return e.getValue();
                        }
                    }
                }
                // Check if it's a direct beacon attribute name
                for (Map.Entry<String, StandardBeacon> e : beaconsByField.entrySet()) {
                    if (e.getValue().getBeaconAttributeName().equals(fieldRef)) {
                        return e.getValue();
                    }
                }
            }
            idx = expr.indexOf(valuePlaceholder, idx + 1);
        }
        return null;
    }

    /** Replace whole-word occurrences of a field name in an expression. */
    private static String replaceWholeWord(String expr, String word, String replacement) {
        // Use word boundary matching: the field name must not be preceded/followed by alphanumeric or _
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < expr.length()) {
            int idx = expr.indexOf(word, i);
            if (idx < 0) {
                result.append(expr.substring(i));
                break;
            }
            // Check word boundaries
            boolean leftBound = idx == 0 || !isWordChar(expr.charAt(idx - 1));
            boolean rightBound = idx + word.length() >= expr.length()
                || !isWordChar(expr.charAt(idx + word.length()));
            if (leftBound && rightBound) {
                result.append(expr, i, idx);
                result.append(replacement);
                i = idx + word.length();
            } else {
                result.append(expr, i, idx + 1);
                i = idx + 1;
            }
        }
        return result.toString();
    }

    private static boolean isWordChar(char c) {
        return Character.isLetterOrDigit(c) || c == '_';
    }
}
