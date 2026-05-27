// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * A round-trip test definition containing a map of configs and a list of records
 * to encrypt then decrypt.
 */
public class RoundTripTest {

  private final Map<String, TableConfig> configs;
  private final List<Record> records;

  public RoundTripTest(Map<String, TableConfig> configs, List<Record> records) {
    this.configs =
      configs != null
        ? Collections.unmodifiableMap(configs)
        : Collections.<String, TableConfig>emptyMap();
    this.records =
      records != null
        ? Collections.unmodifiableList(records)
        : Collections.<Record>emptyList();
  }

  public Map<String, TableConfig> getConfigs() {
    return configs;
  }

  public List<Record> getRecords() {
    return records;
  }

  @Override
  public String toString() {
    return (
      "RoundTripTest{configs=" +
      configs.keySet() +
      ", records=" +
      records.size() +
      " items}"
    );
  }
}
