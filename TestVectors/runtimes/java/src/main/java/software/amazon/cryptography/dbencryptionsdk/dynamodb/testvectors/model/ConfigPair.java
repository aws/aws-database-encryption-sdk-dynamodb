// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.dbencryptionsdk.dynamodb.testvectors.model;

/**
 * A pair of config names (write config, read config) used for IO and modification tests.
 */
public class ConfigPair {

  private final String writeConfig;
  private final String readConfig;

  public ConfigPair(String writeConfig, String readConfig) {
    this.writeConfig = writeConfig;
    this.readConfig = readConfig;
  }

  public String getWriteConfig() {
    return writeConfig;
  }

  public String getReadConfig() {
    return readConfig;
  }

  @Override
  public String toString() {
    return "ConfigPair{write='" + writeConfig + "', read='" + readConfig + "'}";
  }
}
