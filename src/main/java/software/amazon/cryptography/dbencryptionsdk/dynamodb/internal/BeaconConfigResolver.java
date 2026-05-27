// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.BeaconVersion;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CompoundBeacon;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.EncryptedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SearchConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.SignedPart;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.StandardBeacon;

/**
 * Resolves user-facing BeaconVersion configuration into internal beacon implementations.
 */
public final class BeaconConfigResolver {

  private BeaconConfigResolver() {}

  /** Resolved search configuration holding beacon implementations. */
  public static final class SearchInfo {
    public final List<StandardBeaconImpl> standardBeacons;
    public final List<CompoundBeaconImpl> compoundBeacons;
    public final BeaconVersion beaconVersion;
    public final software.amazon.cryptography.keystore.KeyStore keyStore;
    public final String beaconKeyId;

    public SearchInfo(List<StandardBeaconImpl> standardBeacons, List<CompoundBeaconImpl> compoundBeacons,
                      BeaconVersion beaconVersion) {
      this.standardBeacons = standardBeacons;
      this.compoundBeacons = compoundBeacons;
      this.beaconVersion = beaconVersion;
      this.keyStore = beaconVersion.keyStore();
      // Extract key ID from key source
      if (beaconVersion.keySource() != null && beaconVersion.keySource().single() != null) {
        this.beaconKeyId = beaconVersion.keySource().single().keyId();
      } else {
        this.beaconKeyId = null;
      }
    }

    /** Get the HMAC key bytes from the beacon key store. Returns null if not configured. */
    public byte[] getHmacKey() {
      if (keyStore == null || beaconKeyId == null) return null;
      software.amazon.cryptography.keystore.model.GetBeaconKeyOutput output =
        keyStore.GetBeaconKey(software.amazon.cryptography.keystore.model.GetBeaconKeyInput.builder()
          .branchKeyIdentifier(beaconKeyId).build());
      java.nio.ByteBuffer keyBuf = output.beaconKeyMaterials().beaconKey();
      if (keyBuf == null) return null;
      keyBuf = keyBuf.asReadOnlyBuffer();
      byte[] key = new byte[keyBuf.remaining()];
      keyBuf.get(key);
      return key;
    }
  }

  /**
   * Resolve a SearchConfig into internal SearchInfo.
   * Returns null if no search config is provided.
   */
  public static SearchInfo resolve(SearchConfig searchConfig) {
    if (searchConfig == null || searchConfig.versions() == null || searchConfig.versions().isEmpty()) {
      return null;
    }

    // Use the first (and typically only) beacon version
    BeaconVersion version = searchConfig.versions().get(0);
    List<StandardBeaconImpl> standards = resolveStandardBeacons(version);
    List<CompoundBeaconImpl> compounds = resolveCompoundBeacons(version, standards);
    return new SearchInfo(standards, compounds, version);
  }

  private static List<StandardBeaconImpl> resolveStandardBeacons(BeaconVersion version) {
    if (version.standardBeacons() == null) return Collections.emptyList();
    List<StandardBeaconImpl> result = new ArrayList<>();
    for (StandardBeacon sb : version.standardBeacons()) {
      boolean isSet = false;
      if (sb.style() != null) {
        isSet = sb.style().asSet() != null || sb.style().sharedSet() != null;
      }
      result.add(new StandardBeaconImpl(sb.name(), sb.length(), isSet));
    }
    return result;
  }

  private static List<CompoundBeaconImpl> resolveCompoundBeacons(
    BeaconVersion version, List<StandardBeaconImpl> standards
  ) {
    if (version.compoundBeacons() == null) return Collections.emptyList();

    // Build a map of encrypted parts from both version-level and compound-level
    Map<String, EncryptedPart> versionEncParts = new java.util.HashMap<>();
    if (version.encryptedParts() != null) {
      for (EncryptedPart ep : version.encryptedParts()) {
        versionEncParts.put(ep.name(), ep);
      }
    }
    Map<String, SignedPart> versionSigParts = new java.util.HashMap<>();
    if (version.signedParts() != null) {
      for (SignedPart sp : version.signedParts()) {
        versionSigParts.put(sp.name(), sp);
      }
    }

    List<CompoundBeaconImpl> result = new ArrayList<>();
    for (CompoundBeacon cb : version.compoundBeacons()) {
      char split = cb.split().charAt(0);
      List<CompoundBeaconImpl.EncryptedPart> encParts = new ArrayList<>();
      List<CompoundBeaconImpl.SignedPart> sigParts = new ArrayList<>();

      // Use compound-level parts if defined, otherwise use version-level parts via constructors
      if (cb.encrypted() != null && !cb.encrypted().isEmpty()) {
        for (EncryptedPart ep : cb.encrypted()) {
          StandardBeaconImpl beacon = findBeacon(standards, ep.name());
          if (beacon != null) {
            encParts.add(new CompoundBeaconImpl.EncryptedPart(ep.prefix(), beacon));
          }
        }
      }
      if (cb.signed() != null && !cb.signed().isEmpty()) {
        for (SignedPart sp : cb.signed()) {
          sigParts.add(new CompoundBeaconImpl.SignedPart(sp.prefix(), sp.name()));
        }
      }

      // If no parts from compound-level, resolve from constructors using version-level parts
      if (encParts.isEmpty() && sigParts.isEmpty() && cb.constructors() != null) {
        java.util.Set<String> seenEncParts = new java.util.HashSet<>();
        java.util.Set<String> seenSigParts = new java.util.HashSet<>();
        for (software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor ctor : cb.constructors()) {
          if (ctor.parts() != null) {
            for (software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart cp : ctor.parts()) {
              String partName = cp.name();
              // Check if it's an encrypted part
              EncryptedPart ep = versionEncParts.get(partName);
              if (ep != null && seenEncParts.add(partName)) {
                StandardBeaconImpl beacon = findBeacon(standards, ep.name());
                if (beacon != null) {
                  encParts.add(new CompoundBeaconImpl.EncryptedPart(ep.prefix(), beacon));
                }
              } else {
                // Check if it's a signed part
                SignedPart sp = versionSigParts.get(partName);
                if (sp != null && seenSigParts.add(partName)) {
                  sigParts.add(new CompoundBeaconImpl.SignedPart(sp.prefix(), sp.name()));
                }
              }
            }
          }
        }
      }

      // Build constructor part name lists for ordered construction
      List<List<String>> ctorPartNames = new ArrayList<>();
      if (cb.constructors() != null) {
        for (software.amazon.cryptography.dbencryptionsdk.dynamodb.model.Constructor ctor : cb.constructors()) {
          if (ctor.parts() != null) {
            List<String> partNames = new ArrayList<>();
            for (software.amazon.cryptography.dbencryptionsdk.dynamodb.model.ConstructorPart cp : ctor.parts()) {
              partNames.add(cp.name());
            }
            ctorPartNames.add(partNames);
          }
        }
      }

      result.add(new CompoundBeaconImpl(cb.name(), split, encParts, sigParts, ctorPartNames));
    }
    return result;
  }

  private static StandardBeaconImpl findBeacon(List<StandardBeaconImpl> beacons, String name) {
    for (StandardBeaconImpl b : beacons) {
      if (b.getName().equals(name)) return b;
    }
    return null;
  }
}
