// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * DDB Support utilities for searchable encryption: add/remove beacons.
 *
 * //= specification/dynamodb-encryption-client/ddb-support.md#addsignedbeacons
 * //# Signed Beacons MUST be added.
 */
public final class DdbSupport {

  private static final String BEACON_PREFIX = "aws_dbe_b_";

  private DdbSupport() {}

  /**
   * Add signed beacons (compound beacons with signed parts only) to an item.
   */
  public static Map<String, AttributeValue> addSignedBeacons(
    Map<String, AttributeValue> item,
    List<CompoundBeaconImpl> compoundBeacons,
    byte[] hmacKey
  ) {
    Map<String, AttributeValue> result = new HashMap<>(item);
    for (CompoundBeaconImpl cb : compoundBeacons) {
      String value = cb.construct(item, hmacKey);
      if (value != null) {
        result.put(cb.getBeaconAttributeName(), AttributeValue.fromS(value));
      }
    }
    return result;
  }

  /**
   * Add encrypted beacons (standard beacons computed from plaintext values) to an item.
   */
  public static Map<String, AttributeValue> addEncryptedBeacons(
    Map<String, AttributeValue> item,
    List<StandardBeaconImpl> standardBeacons,
    byte[] hmacKey
  ) {
    Map<String, AttributeValue> result = new HashMap<>(item);
    for (StandardBeaconImpl sb : standardBeacons) {
      AttributeValue av = item.get(sb.getName());
      if (av == null) continue;
      String beaconValue;
      if (av.s() != null) {
        beaconValue = sb.hashStr(av.s(), hmacKey);
      } else if (av.b() != null) {
        beaconValue = sb.hash(av.b().asByteArray(), hmacKey);
      } else if (av.n() != null) {
        beaconValue = sb.hashStr(av.n(), hmacKey);
      } else {
        continue;
      }
      result.put(sb.getBeaconAttributeName(), AttributeValue.fromS(beaconValue));
    }
    return result;
  }

  /**
   * Remove all beacon attributes from an item (attributes starting with aws_dbe_b_).
   *
   * //= specification/dynamodb-encryption-client/ddb-support.md#removebeacons
   * //# Beacons MUST be removed from the result.
   */
  public static Map<String, AttributeValue> removeBeacons(Map<String, AttributeValue> item) {
    Map<String, AttributeValue> result = new HashMap<>(item);
    Iterator<String> it = result.keySet().iterator();
    while (it.hasNext()) {
      if (it.next().startsWith(BEACON_PREFIX)) {
        it.remove();
      }
    }
    return result;
  }

  /**
   * Check if an item is writable (no reserved beacon attributes present).
   *
   * //= specification/dynamodb-encryption-client/ddb-support.md#writable
   */
  public static void validateWritable(Map<String, AttributeValue> item) {
    for (String key : item.keySet()) {
      if (key.startsWith(BEACON_PREFIX)) {
        throw new IllegalArgumentException(
          "Item contains reserved beacon attribute: " + key + ". Remove it before writing.");
      }
    }
  }
}
