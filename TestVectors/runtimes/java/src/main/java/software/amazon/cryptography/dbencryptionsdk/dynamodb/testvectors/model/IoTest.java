// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * An IO test definition containing write/read configs, records, expression maps, and queries.
 */
public class IoTest {

  private final String name;
  private final TableConfig writeConfig;
  private final TableConfig readConfig;
  private final List<Record> records;
  private final Map<String, String> names;
  private final Map<String, AttributeValue> values;
  private final List<SimpleQuery> queries;

  public IoTest(
    String name,
    TableConfig writeConfig,
    TableConfig readConfig,
    List<Record> records,
    Map<String, String> names,
    Map<String, AttributeValue> values,
    List<SimpleQuery> queries
  ) {
    this.name = name;
    this.writeConfig = writeConfig;
    this.readConfig = readConfig;
    this.records =
      records != null
        ? Collections.unmodifiableList(records)
        : Collections.<Record>emptyList();
    this.names =
      names != null
        ? Collections.unmodifiableMap(names)
        : Collections.<String, String>emptyMap();
    this.values =
      values != null
        ? Collections.unmodifiableMap(values)
        : Collections.<String, AttributeValue>emptyMap();
    this.queries =
      queries != null
        ? Collections.unmodifiableList(queries)
        : Collections.<SimpleQuery>emptyList();
  }

  public String getName() {
    return name;
  }

  public TableConfig getWriteConfig() {
    return writeConfig;
  }

  public TableConfig getReadConfig() {
    return readConfig;
  }

  public List<Record> getRecords() {
    return records;
  }

  public Map<String, String> getNames() {
    return names;
  }

  public Map<String, AttributeValue> getValues() {
    return values;
  }

  public List<SimpleQuery> getQueries() {
    return queries;
  }

  @Override
  public String toString() {
    return (
      "IoTest{name='" +
      name +
      "', writeConfig=" +
      writeConfig +
      ", readConfig=" +
      readConfig +
      ", records=" +
      records.size() +
      " items}"
    );
  }
}
