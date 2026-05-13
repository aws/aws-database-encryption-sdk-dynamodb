// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthenticateAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.AuthItem;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.PathSegment;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredDataTerminal;

import static software.amazon.cryptography.dbencryptionsdk.structuredencryption.internal.StructuredEncryptionUtil.*;

/**
 * Canonizes crypto schemas: sorts fields by canonical path, builds the encrypt legend,
 * and resolves auth actions from a stored legend.
 */
public final class CryptoSchemaCanonizer {

  private CryptoSchemaCanonizer() {}

  /** A field with its computed canonical path, for sorting. */
  public static final class CanonicalCryptoItem {
    public final byte[] canonicalPath;
    public final List<PathSegment> originalPath;
    public final StructuredDataTerminal data;
    public final CryptoAction action;

    public CanonicalCryptoItem(byte[] canonicalPath, List<PathSegment> originalPath,
                               StructuredDataTerminal data, CryptoAction action) {
      this.canonicalPath = canonicalPath;
      this.originalPath = originalPath;
      this.data = data;
      this.action = action;
    }
  }

  /** Comparator for canonical paths (unsigned byte lexicographic order). */
  private static final Comparator<byte[]> CANON_COMPARATOR = (a, b) -> {
    int len = Math.min(a.length, b.length);
    for (int i = 0; i < len; i++) {
      int cmp = (a[i] & 0xFF) - (b[i] & 0xFF);
      if (cmp != 0) return cmp;
    }
    return a.length - b.length;
  };

  /**
   * Sort crypto items by canonical path and return the sorted list.
   * Only authenticated items (not DO_NOTHING) are included.
   */
  public static List<CanonicalCryptoItem> canonicalize(String tableName, List<CryptoItem> items) {
    List<CanonicalCryptoItem> result = new ArrayList<>();
    for (CryptoItem item : items) {
      if (!isAuthAttr(item.action())) continue;
      byte[] cp = CanonicalPath.canonPath(tableName, item.key());
      result.add(new CanonicalCryptoItem(cp, item.key(), item.data(), item.action()));
    }
    result.sort((a, b) -> CANON_COMPARATOR.compare(a.canonicalPath, b.canonicalPath));
    return result;
  }

  /**
   * Build the encrypt legend from sorted canonical items.
   *
   * //= specification/structured-encryption/header.md#encrypt-legend-bytes
   * //# - 0x65 (e) means ENCRYPT_AND_SIGN
   * //# - 0x73 (s) means SIGN_ONLY
   * //# - 0x63 (c) means SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT
   */
  public static byte[] buildLegend(List<CanonicalCryptoItem> sortedItems) {
    byte[] legend = new byte[sortedItems.size()];
    for (int i = 0; i < sortedItems.size(); i++) {
      CryptoAction action = sortedItems.get(i).action;
      if (CryptoAction.ENCRYPT_AND_SIGN.equals(action)) {
        legend[i] = ENCRYPT_AND_SIGN_LEGEND;
      } else if (CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.equals(action)) {
        legend[i] = CONTEXT_LEGEND;
      } else {
        legend[i] = SIGN_ONLY_LEGEND;
      }
    }
    return legend;
  }

  /**
   * Resolve auth actions from a stored legend during decrypt.
   * Given auth items (with SIGN action) and the legend from the header,
   * determine which fields were ENCRYPT_AND_SIGN vs SIGN_ONLY vs CONTEXT.
   */
  public static List<CryptoItem> resolveAuthActions(String tableName, List<AuthItem> authItems, byte[] legend) {
    // Sort authenticated items by canonical path
    List<AuthItem> sorted = new ArrayList<>();
    List<byte[]> sortedPaths = new ArrayList<>();
    for (AuthItem item : authItems) {
      if (!AuthenticateAction.SIGN.equals(item.action())) continue;
      // Skip header and footer
      if (isHeaderOrFooter(item.key())) continue;
      byte[] cp = CanonicalPath.canonPath(tableName, item.key());
      sorted.add(item);
      sortedPaths.add(cp);
    }

    // Sort by canonical path
    Integer[] indices = new Integer[sorted.size()];
    for (int i = 0; i < indices.length; i++) indices[i] = i;
    Arrays.sort(indices, (a, b) -> CANON_COMPARATOR.compare(sortedPaths.get(a), sortedPaths.get(b)));

    if (indices.length != legend.length) {
      throw new IllegalArgumentException(
        "Legend length (" + legend.length + ") does not match authenticated field count (" + indices.length + ")");
    }

    List<CryptoItem> result = new ArrayList<>();
    for (int i = 0; i < indices.length; i++) {
      AuthItem item = sorted.get(indices[i]);
      CryptoAction action;
      switch (legend[i]) {
        case ENCRYPT_AND_SIGN_LEGEND:
          action = CryptoAction.ENCRYPT_AND_SIGN;
          break;
        case CONTEXT_LEGEND:
          action = CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT;
          break;
        case SIGN_ONLY_LEGEND:
          action = CryptoAction.SIGN_ONLY;
          break;
        default:
          throw new IllegalArgumentException("Unknown legend byte: " + legend[i]);
      }
      result.add(CryptoItem.builder()
        .key(item.key())
        .data(item.data())
        .action(action)
        .build());
    }
    return result;
  }

  private static boolean isHeaderOrFooter(List<PathSegment> path) {
    if (path.size() != 1) return false;
    String key = path.get(0).member().key();
    return HEADER_FIELD.equals(key) || FOOTER_FIELD.equals(key);
  }
}
