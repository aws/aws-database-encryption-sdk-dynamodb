// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors.model;

import java.util.Collections;
import java.util.List;

/**
 * A write test definition containing a config, records to encrypt, and an output file name.
 */
public class WriteTest {

  private final TableConfig config;
  private final List<Record> records;
  private final String fileName;

  public WriteTest(TableConfig config, List<Record> records, String fileName) {
    this.config = config;
    this.records =
      records != null
        ? Collections.unmodifiableList(records)
        : Collections.<Record>emptyList();
    this.fileName = fileName;
  }

  public TableConfig getConfig() {
    return config;
  }

  public List<Record> getRecords() {
    return records;
  }

  public String getFileName() {
    return fileName;
  }

  @Override
  public String toString() {
    return (
      "WriteTest{config=" +
      config +
      ", records=" +
      records.size() +
      " items, fileName='" +
      fileName +
      "'}"
    );
  }
}
