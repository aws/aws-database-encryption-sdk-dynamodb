// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public SearchInfo(List<StandardBeaconImpl> standardBeacons, List<CompoundBeaconImpl> compoundBeacons,
                      BeaconVersion beaconVersion) {
      this.standardBeacons = standardBeacons;
      this.compoundBeacons = compoundBeacons;
      this.beaconVersion = beaconVersion;
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
      result.add(new StandardBeaconImpl(sb.name(), sb.length()));
    }
    return result;
  }

  private static List<CompoundBeaconImpl> resolveCompoundBeacons(
    BeaconVersion version, List<StandardBeaconImpl> standards
  ) {
    if (version.compoundBeacons() == null) return Collections.emptyList();
    List<CompoundBeaconImpl> result = new ArrayList<>();
    for (CompoundBeacon cb : version.compoundBeacons()) {
      char split = cb.split().charAt(0);
      List<CompoundBeaconImpl.EncryptedPart> encParts = new ArrayList<>();
      if (cb.encrypted() != null) {
        for (EncryptedPart ep : cb.encrypted()) {
          StandardBeaconImpl beacon = findBeacon(standards, ep.name());
          if (beacon != null) {
            encParts.add(new CompoundBeaconImpl.EncryptedPart(ep.prefix(), beacon));
          }
        }
      }
      List<CompoundBeaconImpl.SignedPart> sigParts = new ArrayList<>();
      if (cb.signed() != null) {
        for (SignedPart sp : cb.signed()) {
          sigParts.add(new CompoundBeaconImpl.SignedPart(sp.prefix(), sp.name()));
        }
      }
      result.add(new CompoundBeaconImpl(cb.name(), split, encParts, sigParts));
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
