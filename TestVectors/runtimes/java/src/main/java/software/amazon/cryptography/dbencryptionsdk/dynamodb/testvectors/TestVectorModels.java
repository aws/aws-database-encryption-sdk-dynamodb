// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors;

import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;

/**
 * Pure data classes used throughout the test vector harness.
 * These replace the Dafny-generated datatypes from JsonConfig_Compile.
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
      this.item = item;
    }
  }

  public static final class LargeRecord {
    public final String name;
    public final Map<String, AttributeValue> item;

    public LargeRecord(String name, Map<String, AttributeValue> item) {
      this.name = name;
      this.item = item;
    }
  }

  public static final class TableConfig {
    public final String name;
    public final DynamoDbTableEncryptionConfig config;
    public final boolean vanilla;

    public TableConfig(
      String name,
      DynamoDbTableEncryptionConfig config,
      boolean vanilla
    ) {
      this.name = name;
      this.config = config;
      this.vanilla = vanilla;
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
      this.failConfigs = failConfigs;
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
      this.query = query;
      this.pass = pass;
      this.fail = fail;
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
      this.config = config;
      this.queries = queries;
      this.failures = failures;
    }
  }

  public static final class RoundTripTest {
    public final Map<String, TableConfig> configs;
    public final List<Record> records;

    public RoundTripTest(
      Map<String, TableConfig> configs,
      List<Record> records
    ) {
      this.configs = configs;
      this.records = records;
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
      this.config = config;
      this.records = records;
      this.fileName = fileName;
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
      this.config = config;
      this.encryptedRecords = encryptedRecords;
      this.plaintextRecords = plaintextRecords;
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
      this.name = name;
      this.writeConfig = writeConfig;
      this.readConfig = readConfig;
      this.records = records;
      this.names = names;
      this.values = values;
      this.queries = queries;
    }
  }

  public static final class ConfigPair {
    public final String first;
    public final String second;

    public ConfigPair(String first, String second) {
      this.first = first;
      this.second = second;
    }
  }
}
