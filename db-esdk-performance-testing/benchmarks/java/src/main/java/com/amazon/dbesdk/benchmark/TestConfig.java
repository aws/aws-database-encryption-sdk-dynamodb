// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package com.amazon.dbesdk.benchmark;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

/**
 * Configuration class for DB-ESDK benchmark tests, loaded from YAML.
 */
public class TestConfig {

  private DataSizes dataSizes;
  private Iterations iterations;
  private List<Integer> concurrencyLevels;
  private QuickConfig quickConfig;
  private String tableName;
  private String keyring;

  // Nested classes for structured configuration
  public static class DataSizes {

    private List<Integer> small;
    private List<Integer> medium;
    private List<Integer> large;

    public List<Integer> getSmall() {
      return small;
    }

    public void setSmall(List<Integer> small) {
      this.small = small;
    }

    public List<Integer> getMedium() {
      return medium;
    }

    public void setMedium(List<Integer> medium) {
      this.medium = medium;
    }

    public List<Integer> getLarge() {
      return large;
    }

    public void setLarge(List<Integer> large) {
      this.large = large;
    }
  }

  public static class Iterations {

    private int warmup;
    private int measurement;

    public int getWarmup() {
      return warmup;
    }

    public void setWarmup(int warmup) {
      this.warmup = warmup;
    }

    public int getMeasurement() {
      return measurement;
    }

    public void setMeasurement(int measurement) {
      this.measurement = measurement;
    }
  }

  public static class QuickConfig {

    private DataSizes dataSizes;
    private Iterations iterations;
    private List<Integer> concurrencyLevels;
    private List<String> testTypes;

    public DataSizes getDataSizes() {
      return dataSizes;
    }

    public void setDataSizes(DataSizes dataSizes) {
      this.dataSizes = dataSizes;
    }

    public Iterations getIterations() {
      return iterations;
    }

    public void setIterations(Iterations iterations) {
      this.iterations = iterations;
    }

    public List<Integer> getConcurrencyLevels() {
      return concurrencyLevels;
    }

    public void setConcurrencyLevels(List<Integer> concurrencyLevels) {
      this.concurrencyLevels = concurrencyLevels;
    }

    public List<String> getTestTypes() {
      return testTypes;
    }

    public void setTestTypes(List<String> testTypes) {
      this.testTypes = testTypes;
    }
  }

  // Main getters and setters
  public DataSizes getDataSizes() {
    return dataSizes;
  }

  public void setDataSizes(DataSizes dataSizes) {
    this.dataSizes = dataSizes;
  }

  public Iterations getIterations() {
    return iterations;
  }

  public void setIterations(Iterations iterations) {
    this.iterations = iterations;
  }

  public List<Integer> getConcurrencyLevels() {
    return concurrencyLevels;
  }

  public void setConcurrencyLevels(List<Integer> concurrencyLevels) {
    this.concurrencyLevels = concurrencyLevels;
  }

  public QuickConfig getQuickConfig() {
    return quickConfig;
  }

  public void setQuickConfig(QuickConfig quickConfig) {
    this.quickConfig = quickConfig;
  }

  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  public String getKeyring() {
    return keyring;
  }

  public void setKeyring(String keyring) {
    this.keyring = keyring;
  }

  /**
   * Loads test configuration from YAML file.
   */
  public static TestConfig loadConfig(String configPath) throws IOException {
    Yaml yaml = new Yaml();
    try (FileInputStream fis = new FileInputStream(configPath)) {
      Map<String, Object> yamlData = yaml.load(fis);
      return parseYamlToConfig(yamlData);
    }
  }

  /**
   * Parses the YAML data structure into TestConfig object.
   */
  @SuppressWarnings("unchecked")
  private static TestConfig parseYamlToConfig(Map<String, Object> yamlData) {
    TestConfig config = new TestConfig();

    // Parse data_sizes
    if (yamlData.containsKey("data_sizes")) {
      Map<String, Object> dataSizesMap = (Map<String, Object>) yamlData.get(
        "data_sizes"
      );
      DataSizes dataSizes = new DataSizes();
      dataSizes.setSmall((List<Integer>) dataSizesMap.get("small"));
      dataSizes.setMedium((List<Integer>) dataSizesMap.get("medium"));
      dataSizes.setLarge((List<Integer>) dataSizesMap.get("large"));
      config.setDataSizes(dataSizes);
    }

    // Parse iterations
    if (yamlData.containsKey("iterations")) {
      Map<String, Object> iterationsMap = (Map<String, Object>) yamlData.get(
        "iterations"
      );
      Iterations iterations = new Iterations();
      iterations.setWarmup((Integer) iterationsMap.get("warmup"));
      iterations.setMeasurement((Integer) iterationsMap.get("measurement"));
      config.setIterations(iterations);
    }

    // Parse concurrency_levels
    if (yamlData.containsKey("concurrency_levels")) {
      config.setConcurrencyLevels(
        (List<Integer>) yamlData.get("concurrency_levels")
      );
    }

    // Parse quick_config
    if (yamlData.containsKey("quick_config")) {
      Map<String, Object> quickConfigMap = (Map<String, Object>) yamlData.get(
        "quick_config"
      );
      QuickConfig quickConfig = new QuickConfig();

      // Parse quick_config data_sizes
      if (quickConfigMap.containsKey("data_sizes")) {
        Map<String, Object> quickDataSizesMap = (Map<
            String,
            Object
          >) quickConfigMap.get("data_sizes");
        DataSizes quickDataSizes = new DataSizes();
        quickDataSizes.setSmall((List<Integer>) quickDataSizesMap.get("small"));
        quickConfig.setDataSizes(quickDataSizes);
      }

      // Parse quick_config iterations
      if (quickConfigMap.containsKey("iterations")) {
        Map<String, Object> quickIterationsMap = (Map<
            String,
            Object
          >) quickConfigMap.get("iterations");
        Iterations quickIterations = new Iterations();
        quickIterations.setWarmup((Integer) quickIterationsMap.get("warmup"));
        quickIterations.setMeasurement(
          (Integer) quickIterationsMap.get("measurement")
        );
        quickConfig.setIterations(quickIterations);
      }

      // Parse quick_config concurrency_levels and test_types
      if (quickConfigMap.containsKey("concurrency_levels")) {
        quickConfig.setConcurrencyLevels(
          (List<Integer>) quickConfigMap.get("concurrency_levels")
        );
      }
      if (quickConfigMap.containsKey("test_types")) {
        quickConfig.setTestTypes(
          (List<String>) quickConfigMap.get("test_types")
        );
      }

      config.setQuickConfig(quickConfig);
    }

    // Parse table_name and keyring
    config.setTableName((String) yamlData.get("table_name"));
    config.setKeyring((String) yamlData.get("keyring"));

    return config;
  }

  /**
   * Adjusts configuration for quick test mode.
   */
  public void adjustForQuickTest() {
    if (quickConfig == null) {
      throw new IllegalStateException(
        "Quick mode requested but no quick_config found in config file"
      );
    }

    // Apply quick config settings
    this.iterations.setMeasurement(
        quickConfig.getIterations().getMeasurement()
      );
    this.iterations.setWarmup(quickConfig.getIterations().getWarmup());

    // Replace data sizes with quick config
    if (quickConfig.getDataSizes() != null) {
      this.dataSizes.setSmall(quickConfig.getDataSizes().getSmall());
      this.dataSizes.setMedium(List.of()); // Empty list
      this.dataSizes.setLarge(List.of()); // Empty list
    }

    // Replace concurrency levels
    if (quickConfig.getConcurrencyLevels() != null) {
      this.concurrencyLevels = quickConfig.getConcurrencyLevels();
    }
  }
}
