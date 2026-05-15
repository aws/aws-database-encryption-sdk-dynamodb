// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;

/**
 * Replacement for Dafny-generated test vector model types.
 * All collections are defensively copied to unmodifiable forms.
 */
public final class TestVectorModels {

  public static final String TABLE_NAME = "GazelleVectorTable";
  public static final String HASH_NAME = "RecNum";

  private TestVectorModels() {}

  public static final class Record {
    public final int number;
    public final Map<String, AttributeValue> item;

    public Record(int number, Map<String, AttributeValue> item) {
      this.number = number;
      this.item = unmodifiableMap(Objects.requireNonNull(item, "item"));
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Record)) return false;
      Record r = (Record) o;
      return number == r.number && item.equals(r.item);
    }

    @Override
    public int hashCode() {
      return 31 * number + item.hashCode();
    }
  }

  public static final class LargeRecord {
    public final String name;
    public final Map<String, AttributeValue> item;

    public LargeRecord(String name, Map<String, AttributeValue> item) {
      this.name = Objects.requireNonNull(name, "name");
      this.item = unmodifiableMap(Objects.requireNonNull(item, "item"));
    }
  }

  public static final class TableConfig {
    public final String name;
    public final DynamoDbTableEncryptionConfig config; // null when vanilla == true
    public final boolean vanilla;

    public TableConfig(
      String name,
      DynamoDbTableEncryptionConfig config,
      boolean vanilla
    ) {
      this.name = Objects.requireNonNull(name, "name");
      this.config = config;
      this.vanilla = vanilla;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof TableConfig)) return false;
      TableConfig t = (TableConfig) o;
      return vanilla == t.vanilla
        && name.equals(t.name)
        && Objects.equals(config, t.config);
    }

    @Override
    public int hashCode() {
      int h = name.hashCode();
      h = 31 * h + (config != null ? config.hashCode() : 0);
      h = 31 * h + Boolean.hashCode(vanilla);
      return h;
    }
  }

  public static final class SimpleQuery {
    public final String index;       // nullable
    public final String keyExpr;     // nullable
    public final String filterExpr;  // nullable
    public final List<String> failConfigs;

    public SimpleQuery(
      String index,
      String keyExpr,
      String filterExpr,
      List<String> failConfigs
    ) {
      this.index = index;
      this.keyExpr = keyExpr;
      this.filterExpr = filterExpr;
      this.failConfigs = unmodifiableList(
        Objects.requireNonNull(failConfigs, "failConfigs"));
    }
  }

  public static final class ComplexQuery {
    public final SimpleQuery query;
    public final List<String> pass;
    public final List<String> fail;

    public ComplexQuery(
      SimpleQuery query,
      List<String> pass,
      List<String> fail
    ) {
      this.query = Objects.requireNonNull(query, "query");
      this.pass = unmodifiableList(Objects.requireNonNull(pass, "pass"));
      this.fail = unmodifiableList(Objects.requireNonNull(fail, "fail"));
    }
  }

  public static final class ComplexTest {
    public final String config;
    public final List<ComplexQuery> queries;
    public final List<SimpleQuery> failures;

    public ComplexTest(
      String config,
      List<ComplexQuery> queries,
      List<SimpleQuery> failures
    ) {
      this.config = Objects.requireNonNull(config, "config");
      this.queries = unmodifiableList(Objects.requireNonNull(queries, "queries"));
      this.failures = unmodifiableList(Objects.requireNonNull(failures, "failures"));
    }
  }

  public static final class RoundTripTest {
    public final Map<String, TableConfig> configs;
    public final List<Record> records;

    public RoundTripTest(
      Map<String, TableConfig> configs,
      List<Record> records
    ) {
      this.configs = unmodifiableMap(Objects.requireNonNull(configs, "configs"));
      this.records = unmodifiableList(Objects.requireNonNull(records, "records"));
    }
  }

  public static final class WriteTest {
    public final TableConfig config;
    public final List<Record> records;
    public final String fileName;

    public WriteTest(
      TableConfig config,
      List<Record> records,
      String fileName
    ) {
      this.config = Objects.requireNonNull(config, "config");
      this.records = unmodifiableList(Objects.requireNonNull(records, "records"));
      this.fileName = Objects.requireNonNull(fileName, "fileName");
    }
  }

  public static final class DecryptTest {
    public final TableConfig config;
    public final List<Record> encryptedRecords;
    public final List<Record> plaintextRecords;

    public DecryptTest(
      TableConfig config,
      List<Record> encryptedRecords,
      List<Record> plaintextRecords
    ) {
      this.config = Objects.requireNonNull(config, "config");
      this.encryptedRecords = unmodifiableList(
        Objects.requireNonNull(encryptedRecords, "encryptedRecords"));
      this.plaintextRecords = unmodifiableList(
        Objects.requireNonNull(plaintextRecords, "plaintextRecords"));
    }
  }

  public static final class IoTest {
    public final String name;
    public final TableConfig writeConfig;
    public final TableConfig readConfig;
    public final List<Record> records;
    public final Map<String, String> names;
    public final Map<String, AttributeValue> values;
    public final List<SimpleQuery> queries;

    public IoTest(
      String name,
      TableConfig writeConfig,
      TableConfig readConfig,
      List<Record> records,
      Map<String, String> names,
      Map<String, AttributeValue> values,
      List<SimpleQuery> queries
    ) {
      this.name = Objects.requireNonNull(name, "name");
      this.writeConfig = Objects.requireNonNull(writeConfig, "writeConfig");
      this.readConfig = Objects.requireNonNull(readConfig, "readConfig");
      this.records = unmodifiableList(Objects.requireNonNull(records, "records"));
      this.names = unmodifiableMap(Objects.requireNonNull(names, "names"));
      this.values = unmodifiableMap(Objects.requireNonNull(values, "values"));
      this.queries = unmodifiableList(Objects.requireNonNull(queries, "queries"));
    }
  }

  public static final class ConfigPair {
    public final String first;
    public final String second;

    public ConfigPair(String first, String second) {
      this.first = Objects.requireNonNull(first, "first");
      this.second = Objects.requireNonNull(second, "second");
    }
  }

  // Java 8 compatible defensive copy helpers

  private static <T> List<T> unmodifiableList(List<T> src) {
    return Collections.unmodifiableList(new ArrayList<>(src));
  }

  private static <K, V> Map<K, V> unmodifiableMap(Map<K, V> src) {
    return Collections.unmodifiableMap(new HashMap<>(src));
  }
}
