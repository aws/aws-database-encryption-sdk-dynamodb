// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DbeException;

/**
 * Compound Beacon: combines multiple source fields into a single searchable value.
 * Parts are joined with a split character. Each part has a prefix and references
 * either a standard beacon (encrypted part) or a plaintext field (signed part).
 */
public final class CompoundBeacon {

    private final String name;
    private final String splitChar;
    private final List<Part> parts;
    private final List<Constructor> constructors;

    public CompoundBeacon(String name, String splitChar, List<Part> parts, List<Constructor> constructors) {
        this.name = name;
        this.splitChar = splitChar;
        this.parts = parts;
        this.constructors = constructors != null && !constructors.isEmpty()
            ? constructors : defaultConstructors(parts);
    }

    public String getName() { return name; }
    public String getBeaconAttributeName() { return StandardBeacon.BEACON_PREFIX + name; }

    /**
     * Compute the compound beacon value for a record.
     *
     * @param record     map of field name → plaintext value
     * @param beaconValues map of beacon name → computed beacon hex string
     * @return the compound beacon string, or null if no constructor succeeds
     */
    public String computeBeacon(Map<String, String> record, Map<String, String> beaconValues) {
        for (Constructor ctor : constructors) {
            String result = ctor.tryBuild(parts, record, beaconValues, splitChar);
            if (result != null) return result;
        }
        return null; // No constructor succeeded
    }

    // ---- Part ----

    public static final class Part {
        private final String name;
        private final String prefix;
        private final boolean encrypted; // true = use beacon value, false = use plaintext
        private final String fieldName;  // source field for signed parts

        public Part(String name, String prefix, boolean encrypted, String fieldName) {
            this.name = name;
            this.prefix = prefix;
            this.encrypted = encrypted;
            this.fieldName = fieldName;
        }

        public String getName() { return name; }
        public String getPrefix() { return prefix; }
        public boolean isEncrypted() { return encrypted; }
        public String getFieldName() { return fieldName != null ? fieldName : name; }

        /** Get the value for this part from the record/beacons. */
        public String getValue(Map<String, String> record, Map<String, String> beaconValues) {
            if (encrypted) {
                return beaconValues.get(name);
            } else {
                return record.get(getFieldName());
            }
        }
    }

    // ---- Constructor ----

    public static final class Constructor {
        private final List<ConstructorPart> parts;

        public Constructor(List<ConstructorPart> parts) {
            this.parts = parts;
        }

        /** Try to build the compound beacon. Returns null if required parts are missing. */
        String tryBuild(List<Part> allParts, Map<String, String> record,
                        Map<String, String> beaconValues, String splitChar) {
            List<String> segments = new ArrayList<>();
            for (ConstructorPart cp : parts) {
                Part part = findPart(allParts, cp.name);
                if (part == null) throw new DbeException("Unknown part: " + cp.name);
                String value = part.getValue(record, beaconValues);
                if (value == null) {
                    if (cp.required) return null; // Required part missing → constructor fails
                    continue; // Optional part missing → skip
                }
                segments.add(part.getPrefix() + value);
            }
            if (segments.isEmpty()) return null;
            return String.join(splitChar, segments);
        }

        private static Part findPart(List<Part> parts, String name) {
            for (Part p : parts) {
                if (p.getName().equals(name)) return p;
            }
            return null;
        }
    }

    public static final class ConstructorPart {
        final String name;
        final boolean required;

        public ConstructorPart(String name, boolean required) {
            this.name = name;
            this.required = required;
        }
    }

    // ---- Default constructor: all parts required, signed first then encrypted ----

    private static List<Constructor> defaultConstructors(List<Part> parts) {
        List<ConstructorPart> cparts = new ArrayList<>();
        // Signed parts first
        for (Part p : parts) {
            if (!p.isEncrypted()) cparts.add(new ConstructorPart(p.getName(), true));
        }
        // Then encrypted parts
        for (Part p : parts) {
            if (p.isEncrypted()) cparts.add(new ConstructorPart(p.getName(), true));
        }
        List<Constructor> ctors = new ArrayList<>();
        ctors.add(new Constructor(cparts));
        return ctors;
    }
}
