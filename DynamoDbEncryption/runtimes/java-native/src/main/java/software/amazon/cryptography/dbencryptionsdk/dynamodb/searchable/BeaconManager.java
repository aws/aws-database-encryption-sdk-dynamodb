// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.searchable;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * Manages beacon computation for a table. Integrates with the encryption pipeline
 * to add beacon attributes during PutItem and strip them during GetItem.
 */
public final class BeaconManager {

    private final List<StandardBeacon> standardBeacons;
    private final List<CompoundBeacon> compoundBeacons;
    private final List<VirtualField> virtualFields;
    private final byte[] beaconKey; // HMAC key for beacon computation

    public BeaconManager(List<StandardBeacon> standardBeacons,
                         List<CompoundBeacon> compoundBeacons,
                         List<VirtualField> virtualFields,
                         byte[] beaconKey) {
        this.standardBeacons = standardBeacons != null ? standardBeacons : Collections.<StandardBeacon>emptyList();
        this.compoundBeacons = compoundBeacons != null ? compoundBeacons : Collections.<CompoundBeacon>emptyList();
        this.virtualFields = virtualFields != null ? virtualFields : Collections.<VirtualField>emptyList();
        this.beaconKey = beaconKey;
    }

    /**
     * Compute all beacon attributes for an item (called after encryption).
     * Returns a map of beacon attribute names to their String values.
     */
    public Map<String, AttributeValue> computeBeacons(Map<String, AttributeValue> plaintextItem) {
        if (standardBeacons.isEmpty() && compoundBeacons.isEmpty()) {
            return Collections.emptyMap();
        }

        // Build a string map of plaintext values for beacon computation
        Map<String, String> record = buildStringRecord(plaintextItem);

        // Compute virtual fields and add to record
        for (VirtualField vf : virtualFields) {
            String value = vf.compute(record);
            if (value != null) {
                record.put(vf.getName(), value);
            }
        }

        // Compute standard beacons
        Map<String, String> beaconValues = new LinkedHashMap<>();
        for (StandardBeacon sb : standardBeacons) {
            String sourceValue = record.get(sb.getFieldName());
            if (sourceValue != null) {
                beaconValues.put(sb.getName(), sb.computeBeacon(sourceValue, beaconKey));
            }
        }

        // Build output attributes
        Map<String, AttributeValue> result = new LinkedHashMap<>();

        // Standard beacons → aws_dbe_b_<name>
        for (StandardBeacon sb : standardBeacons) {
            String beaconValue = beaconValues.get(sb.getName());
            if (beaconValue != null) {
                result.put(sb.getBeaconAttributeName(), AttributeValue.fromS(beaconValue));
            }
        }

        // Compound beacons → aws_dbe_b_<name>
        for (CompoundBeacon cb : compoundBeacons) {
            String value = cb.computeBeacon(record, beaconValues);
            if (value != null) {
                result.put(cb.getBeaconAttributeName(), AttributeValue.fromS(value));
            }
        }

        return result;
    }

    /**
     * Remove beacon attributes from a decrypted item.
     */
    public static Map<String, AttributeValue> removeBeacons(Map<String, AttributeValue> item) {
        Map<String, AttributeValue> result = new LinkedHashMap<>();
        for (Map.Entry<String, AttributeValue> entry : item.entrySet()) {
            if (!entry.getKey().startsWith(StandardBeacon.BEACON_PREFIX)) {
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }

    public boolean hasBeacons() {
        return !standardBeacons.isEmpty() || !compoundBeacons.isEmpty();
    }

    // ---- Internal ----

    private static Map<String, String> buildStringRecord(Map<String, AttributeValue> item) {
        Map<String, String> record = new LinkedHashMap<>();
        for (Map.Entry<String, AttributeValue> entry : item.entrySet()) {
            AttributeValue val = entry.getValue();
            if (val.s() != null) {
                record.put(entry.getKey(), val.s());
            } else if (val.n() != null) {
                record.put(entry.getKey(), val.n());
            } else if (val.bool() != null) {
                record.put(entry.getKey(), val.bool().toString());
            }
            // Other types (Binary, Sets, Maps, Lists) are not typically used as beacon sources
        }
        return record;
    }
}
