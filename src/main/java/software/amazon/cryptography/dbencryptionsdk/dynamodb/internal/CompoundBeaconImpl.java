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
  private final List<List<String>> constructors; // each constructor is an ordered list of part names

  public CompoundBeaconImpl(String name, char splitChar,
                            List<EncryptedPart> encryptedParts, List<SignedPart> signedParts) {
    this(name, splitChar, encryptedParts, signedParts, null);
  }

  public CompoundBeaconImpl(String name, char splitChar,
                            List<EncryptedPart> encryptedParts, List<SignedPart> signedParts,
                            List<List<String>> constructors) {
    this.name = name;
    this.splitChar = splitChar;
    this.encryptedParts = encryptedParts;
    this.signedParts = signedParts;
    this.constructors = constructors;
  }

  public String getName() { return name; }
  public char getSplitChar() { return splitChar; }
  public String getSplitCharStr() { return String.valueOf(splitChar); }
  public List<EncryptedPart> getEncryptedParts() { return encryptedParts; }
  public List<SignedPart> getSignedParts() { return signedParts; }
  public String getBeaconAttributeName() { return "aws_dbe_b_" + name; }

  /**
   * Hash a plaintext compound value. Parses by split char, identifies parts by prefix,
   * and hashes encrypted parts while keeping signed parts as-is.
   * Input: "L-5678.U-011899988199" → Output: "L-<hash>.U-<hash>"
   */
  public String hashCompoundValue(String plaintextValue, byte[] hmacKey) {
    if (plaintextValue == null || hmacKey == null) return null;
    String[] parts = plaintextValue.split(java.util.regex.Pattern.quote(String.valueOf(splitChar)));
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < parts.length; i++) {
      if (i > 0) result.append(splitChar);
      String part = parts[i];
      boolean hashed = false;
      // Check if this part matches an encrypted part prefix
      for (EncryptedPart ep : encryptedParts) {
        if (part.startsWith(ep.prefix)) {
          String value = part.substring(ep.prefix.length());
          String beaconValue = ep.beacon.hashStr(value, hmacKey);
          result.append(ep.prefix).append(beaconValue);
          hashed = true;
          break;
        }
      }
      if (!hashed) {
        // Keep signed parts as-is
        result.append(part);
      }
    }
    return result.toString();
  }

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
   * Construct the plaintext compound beacon value (prefix + plaintext value for each part).
   * Used by ResolveAttributes to show what the compound beacon represents.
   * Returns null if no parts can be constructed.
   */
  public String constructPlaintext(Map<String, AttributeValue> item) {
    StringBuilder sb = new StringBuilder();
    boolean first = true;

    // Encrypted parts (plaintext values with prefix)
    for (EncryptedPart ep : encryptedParts) {
      AttributeValue av = item.get(ep.beacon.getName());
      if (av == null) continue;
      String plainValue;
      if (av.s() != null) {
        plainValue = av.s();
      } else if (av.n() != null) {
        plainValue = av.n();
      } else {
        continue;
      }
      if (!first) sb.append(splitChar);
      sb.append(ep.prefix).append(plainValue);
      first = false;
    }

    // Signed parts (plaintext)
    for (SignedPart sp : signedParts) {
      AttributeValue av = item.get(sp.fieldName);
      if (av == null || av.s() == null) continue;
      if (!first) sb.append(splitChar);
      sb.append(sp.prefix).append(av.s());
      first = false;
    }

    return sb.length() == 0 ? null : sb.toString();
  }

  /**
   * Construct the compound beacon value from an item and HMAC key.
   * Returns null if no parts can be constructed.
   */
  public String construct(Map<String, AttributeValue> item, byte[] hmacKey) {
    // If constructors are defined, try each in order
    if (constructors != null && !constructors.isEmpty()) {
      for (List<String> ctorParts : constructors) {
        String result = tryConstructor(ctorParts, item, hmacKey);
        if (result != null) return result;
      }
      return null;
    }
    // Fallback: iterate all parts
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (SignedPart sp : signedParts) {
      AttributeValue av = item.get(sp.fieldName);
      if (av == null || av.s() == null) continue;
      if (!first) sb.append(splitChar);
      sb.append(sp.prefix).append(av.s());
      first = false;
    }
    for (EncryptedPart ep : encryptedParts) {
      AttributeValue av = item.get(ep.beacon.getName());
      if (av == null) continue;
      String beaconValue;
      if (av.s() != null) beaconValue = ep.beacon.hashStr(av.s(), hmacKey);
      else if (av.b() != null) beaconValue = ep.beacon.hash(av.b().asByteArray(), hmacKey);
      else continue;
      if (!first) sb.append(splitChar);
      sb.append(ep.prefix).append(beaconValue);
      first = false;
    }
    String constructResult = sb.length() == 0 ? null : sb.toString();
    return constructResult;
  }

  private String tryConstructor(List<String> partNames, Map<String, AttributeValue> item, byte[] hmacKey) {
    // Check all required parts are present
    for (String partName : partNames) {
      if (findEncPart(partName) != null) {
        if (item.get(partName) == null) return null;
      } else if (findSigPart(partName) != null) {
        if (item.get(findSigPart(partName).fieldName) == null) return null;
      } else {
        return null;
      }
    }
    // Build value in constructor order
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (String partName : partNames) {
      EncryptedPart ep = findEncPart(partName);
      if (ep != null) {
        AttributeValue av = item.get(ep.beacon.getName());
        if (av == null) continue;
        String beaconValue;
        if (av.s() != null) beaconValue = ep.beacon.hashStr(av.s(), hmacKey);
        else if (av.b() != null) beaconValue = ep.beacon.hash(av.b().asByteArray(), hmacKey);
        else continue;
        if (!first) sb.append(splitChar);
        sb.append(ep.prefix).append(beaconValue);
        first = false;
      } else {
        SignedPart sp = findSigPart(partName);
        if (sp != null) {
          AttributeValue av = item.get(sp.fieldName);
          if (av == null || av.s() == null) continue;
          if (!first) sb.append(splitChar);
          sb.append(sp.prefix).append(av.s());
          first = false;
        }
      }
    }
    return sb.length() == 0 ? null : sb.toString();
  }

  private EncryptedPart findEncPart(String name) {
    for (EncryptedPart ep : encryptedParts) {
      if (ep.beacon.getName().equals(name)) return ep;
    }
    return null;
  }

  private SignedPart findSigPart(String name) {
    for (SignedPart sp : signedParts) {
      if (sp.fieldName.equals(name)) return sp;
    }
    return null;
  }
}
