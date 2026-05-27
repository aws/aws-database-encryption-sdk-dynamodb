// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors.model;

import java.util.Collections;
import java.util.List;

/**
 * A simple query definition with optional index, key expression, filter expression,
 * and a list of config names for which this query is expected to fail.
 */
public class SimpleQuery {

  private final String index; // nullable
  private final String keyExpr; // nullable
  private final String filterExpr; // nullable
  private final List<String> failConfigs;

  public SimpleQuery(
    String index,
    String keyExpr,
    String filterExpr,
    List<String> failConfigs
  ) {
    this.index = index;
    this.keyExpr = keyExpr;
    this.filterExpr = filterExpr;
    this.failConfigs =
      failConfigs != null
        ? Collections.unmodifiableList(failConfigs)
        : Collections.<String>emptyList();
  }

  public String getIndex() {
    return index;
  }

  public String getKeyExpr() {
    return keyExpr;
  }

  public String getFilterExpr() {
    return filterExpr;
  }

  public List<String> getFailConfigs() {
    return failConfigs;
  }

  @Override
  public String toString() {
    return (
      "SimpleQuery{index='" +
      index +
      "', keyExpr='" +
      keyExpr +
      "', filterExpr='" +
      filterExpr +
      "', failConfigs=" +
      failConfigs +
      "}"
    );
  }
}
