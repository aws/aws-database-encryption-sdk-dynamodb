// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internal;

import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * Compound beacon: assembles parts (encrypted + signed) with a split character.
 *
 * //= specification/searchable-encryption/beacons.md#compound-beacon
 * //# A compound beacon is assembled from parts of a record,
 * //# combining literal plaintext strings and standard beacons into a complex string.
 */
public final class CompoundBeaconImpl {

  private final String name;
  private final char splitChar;
  private final List<EncryptedPart> encryptedParts;
  private final List<SignedPart> signedParts;

  public CompoundBeaconImpl(String name, char splitChar,
                            List<EncryptedPart> encryptedParts, List<SignedPart> signedParts) {
    this.name = name;
    this.splitChar = splitChar;
    this.encryptedParts = encryptedParts;
    this.signedParts = signedParts;
  }

  public String getName() { return name; }
  public String getBeaconAttributeName() { return "aws_dbe_b_" + name; }

  /** An encrypted part references a standard beacon. */
  public static final class EncryptedPart {
    public final String prefix;
    public final StandardBeaconImpl beacon;
    public EncryptedPart(String prefix, StandardBeaconImpl beacon) {
      this.prefix = prefix;
      this.beacon = beacon;
    }
  }

  /** A signed part references a plaintext field. */
  public static final class SignedPart {
    public final String prefix;
    public final String fieldName;
    public SignedPart(String prefix, String fieldName) {
      this.prefix = prefix;
      this.fieldName = fieldName;
    }
  }

  /**
   * Construct the compound beacon value from an item and HMAC key.
   * Returns null if no parts can be constructed.
   */
  public String construct(Map<String, AttributeValue> item, byte[] hmacKey) {
    StringBuilder sb = new StringBuilder();
    boolean first = true;

    // Signed parts first (plaintext)
    for (SignedPart sp : signedParts) {
      AttributeValue av = item.get(sp.fieldName);
      if (av == null || av.s() == null) continue;
      if (!first) sb.append(splitChar);
      sb.append(sp.prefix).append(av.s());
      first = false;
    }

    // Encrypted parts (beacon values)
    for (EncryptedPart ep : encryptedParts) {
      AttributeValue av = item.get(ep.beacon.getName());
      if (av == null) continue;
      String beaconValue;
      if (av.s() != null) {
        beaconValue = ep.beacon.hashStr(av.s(), hmacKey);
      } else if (av.b() != null) {
        beaconValue = ep.beacon.hash(av.b().asByteArray(), hmacKey);
      } else {
        continue;
      }
      if (!first) sb.append(splitChar);
      sb.append(ep.prefix).append(beaconValue);
      first = false;
    }

    return sb.length() == 0 ? null : sb.toString();
  }
}
