// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package com.amazon.dbesdk.benchmark;

import java.util.List;
import org.apache.commons.cli.*;

/**
 * Main entry point for the DB-ESDK / SDKv2 Java performance benchmark.
 */
public class Program {

  public static void main(String[] args) {
    CommandLineOptions options = parseArgs(args);
    if (options == null) return;

    try {
      List<BenchmarkResult> results;
      String outputPath = options.getOutputPath();

      if (options.isSdkv2()) {
        // SDKv2 mode
        SDKv2Benchmark benchmark = new SDKv2Benchmark(options.getConfigPath());
        if (options.isQuickTest()) benchmark.getConfig().adjustForQuickTest();

        System.out.println("\n=== Starting SDKv2 Benchmark ===");
        System.out.printf("Configuration: %s%n", options.getConfigPath());
        System.out.printf("Output: %s%n", outputPath);
        System.out.printf("Quick mode: %s%n", options.isQuickTest());
        System.out.printf("System: %d CPU cores, %.1f GB memory%n",
            Utils.getCpuCount(), Utils.getTotalMemoryGb());

        results = benchmark.runAllBenchmarks();
        benchmark.saveResults(outputPath);
      } else {
        // DB-ESDK / legacy mode
        DBESDKBenchmark benchmark = new DBESDKBenchmark(
            options.getConfigPath(), options.isLegacyOverride());
        if (options.isQuickTest()) benchmark.getConfig().adjustForQuickTest();

        System.out.println("\n=== Starting DB-ESDK Java Benchmark ===");
        System.out.printf("Configuration: %s%n", options.getConfigPath());
        System.out.printf("Output: %s%n", outputPath);
        System.out.printf("Quick mode: %s%n", options.isQuickTest());
        System.out.printf("Legacy override: %s%n", options.isLegacyOverride());
        System.out.printf("System: %d CPU cores, %.1f GB memory%n",
            Utils.getCpuCount(), Utils.getTotalMemoryGb());

        results = benchmark.runAllBenchmarks();
        benchmark.saveResults(outputPath);
      }

      printSummary(results, outputPath);
    } catch (Exception e) {
      System.err.println("Benchmark failed: " + e.getMessage());
      e.printStackTrace();
      System.exit(1);
    }
  }

  private static CommandLineOptions parseArgs(String[] args) {
    Options options = new Options();

    options.addOption(Option.builder("c").longOpt("config").hasArg().argName("file")
        .desc("Path to test configuration file (default: ../config/test-scenarios.yaml)").build());
    options.addOption(Option.builder("o").longOpt("output").hasArg().argName("file")
        .desc("Path to output results file").build());
    options.addOption(Option.builder("q").longOpt("quick")
        .desc("Run quick test with reduced iterations").build());
    options.addOption(Option.builder("l").longOpt("legacy-override")
        .desc("Use legacy DynamoDB Encryption Client for encryption/decryption").build());
    options.addOption(Option.builder("s").longOpt("sdkv2")
        .desc("Use SDKv2 DynamoDBEncryptor with WrappedMaterialsProvider").build());
    options.addOption(Option.builder("h").longOpt("help")
        .desc("Show this help message").build());

    CommandLineParser parser = new DefaultParser();
    try {
      CommandLine cmd = parser.parse(options, args);

      if (cmd.hasOption("h")) {
        new HelpFormatter().printHelp("java -jar db-esdk-benchmark.jar [options]", options);
        return null;
      }

      String configPath = cmd.getOptionValue("c", "../config/test-scenarios.yaml");
      boolean quickTest = cmd.hasOption("q");
      boolean legacyOverride = cmd.hasOption("l");
      boolean sdkv2 = cmd.hasOption("s");

      // Determine default output path based on mode
      String defaultOutput;
      if (sdkv2) {
        defaultOutput = "../results/raw-data/java_sdkv2_results.json";
      } else if (legacyOverride) {
        defaultOutput = "../results/raw-data/java_ddbec_legacy_results.json";
      } else {
        defaultOutput = "../results/raw-data/java_dbesdk_results.json";
      }
      String outputPath = cmd.getOptionValue("o", defaultOutput);

      return new CommandLineOptions(configPath, outputPath, quickTest, legacyOverride, sdkv2);
    } catch (ParseException e) {
      System.err.println("Error parsing command line: " + e.getMessage());
      new HelpFormatter().printHelp("java -jar db-esdk-benchmark.jar [options]", options);
      return null;
    }
  }

  private static void printSummary(List<BenchmarkResult> results, String outputPath) {
    System.out.println("\n=== Benchmark Summary ===");
    System.out.printf("Total tests completed: %d%n", results.size());
    System.out.printf("Results saved to: %s%n", outputPath);

    if (!results.isEmpty()) {
      double maxThroughput = results.stream()
          .filter(r -> "throughput".equals(r.getTestName()))
          .mapToDouble(BenchmarkResult::getOpsPerSecond)
          .max().orElse(0.0);
      if (maxThroughput > 0) {
        System.out.printf("Maximum throughput: %.2f ops/sec%n", maxThroughput);
      }
    }
    System.out.println("\n=== Benchmark Complete ===");
  }

  public static class CommandLineOptions {
    private final String configPath;
    private final String outputPath;
    private final boolean quickTest;
    private final boolean legacyOverride;
    private final boolean sdkv2;

    public CommandLineOptions(String configPath, String outputPath,
        boolean quickTest, boolean legacyOverride, boolean sdkv2) {
      this.configPath = configPath;
      this.outputPath = outputPath;
      this.quickTest = quickTest;
      this.legacyOverride = legacyOverride;
      this.sdkv2 = sdkv2;
    }

    public String getConfigPath() { return configPath; }
    public String getOutputPath() { return outputPath; }
    public boolean isQuickTest() { return quickTest; }
    public boolean isLegacyOverride() { return legacyOverride; }
    public boolean isSdkv2() { return sdkv2; }
  }
}
