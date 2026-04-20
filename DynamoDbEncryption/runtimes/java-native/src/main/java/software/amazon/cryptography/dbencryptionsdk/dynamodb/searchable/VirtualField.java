// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Virtual Field: a computed string from parts of a record.
 * Used as input to beacons. Never stored in the database.
 *
 * <p>Each virtual field is composed of one or more VirtualParts,
 * which extract and transform portions of source fields.
 */
public final class VirtualField {

    private final String name;
    private final List<VirtualPart> parts;

    public VirtualField(String name, List<VirtualPart> parts) {
        this.name = name;
        this.parts = parts;
    }

    public String getName() { return name; }

    /**
     * Compute the virtual field value from a record.
     * @return the computed value, or null if any required source field is missing
     */
    public String compute(Map<String, String> record) {
        StringBuilder sb = new StringBuilder();
        for (VirtualPart part : parts) {
            String value = part.compute(record);
            if (value == null) return null;
            sb.append(value);
        }
        return sb.toString();
    }

    // ---- Virtual Part ----

    public static abstract class VirtualPart {
        public abstract String compute(Map<String, String> record);
    }

    /** Extract the full value of a source field. */
    public static final class FieldPart extends VirtualPart {
        private final String fieldName;
        public FieldPart(String fieldName) { this.fieldName = fieldName; }
        @Override
        public String compute(Map<String, String> record) {
            return record.get(fieldName);
        }
    }

    /** Extract a substring of a source field. */
    public static final class SubstringPart extends VirtualPart {
        private final String fieldName;
        private final int start;
        private final int length; // -1 for "to end"

        public SubstringPart(String fieldName, int start, int length) {
            this.fieldName = fieldName;
            this.start = start;
            this.length = length;
        }

        @Override
        public String compute(Map<String, String> record) {
            String val = record.get(fieldName);
            if (val == null || val.length() <= start) return null;
            int end = length < 0 ? val.length() : Math.min(start + length, val.length());
            return val.substring(start, end);
        }
    }

    /** Extract a prefix of a source field. */
    public static final class PrefixPart extends VirtualPart {
        private final String fieldName;
        private final int length;

        public PrefixPart(String fieldName, int length) {
            this.fieldName = fieldName;
            this.length = length;
        }

        @Override
        public String compute(Map<String, String> record) {
            String val = record.get(fieldName);
            if (val == null) return null;
            return val.substring(0, Math.min(length, val.length()));
        }
    }

    /** Extract a suffix of a source field. */
    public static final class SuffixPart extends VirtualPart {
        private final String fieldName;
        private final int length;

        public SuffixPart(String fieldName, int length) {
            this.fieldName = fieldName;
            this.length = length;
        }

        @Override
        public String compute(Map<String, String> record) {
            String val = record.get(fieldName);
            if (val == null) return null;
            int start = Math.max(0, val.length() - length);
            return val.substring(start);
        }
    }

    /** Extract a segment (split by separator, take index). */
    public static final class SegmentPart extends VirtualPart {
        private final String fieldName;
        private final String separator;
        private final int index;

        public SegmentPart(String fieldName, String separator, int index) {
            this.fieldName = fieldName;
            this.separator = separator;
            this.index = index;
        }

        @Override
        public String compute(Map<String, String> record) {
            String val = record.get(fieldName);
            if (val == null) return null;
            String[] segments = val.split(java.util.regex.Pattern.quote(separator), -1);
            if (index < 0) {
                int idx = segments.length + index;
                return idx >= 0 ? segments[idx] : null;
            }
            return index < segments.length ? segments[index] : null;
        }
    }
}
