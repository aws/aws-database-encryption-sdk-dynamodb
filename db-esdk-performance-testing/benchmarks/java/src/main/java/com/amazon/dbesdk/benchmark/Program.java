// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package com.amazon.dbesdk.benchmark;

import java.io.IOException;
import java.util.List;
import org.apache.commons.cli.*;

/**
 * Main entry point for the DB-ESDK Java performance benchmark.
 */
public class Program {

  public static void main(String[] args) {
    CommandLineOptions options = parseArgs(args);
    if (options == null) {
      return;
    }

    try {
      // Initialize benchmark
      DBESDKBenchmark benchmark = new DBESDKBenchmark(options.getConfigPath());

      // Adjust config for quick test if requested
      if (options.isQuickTest()) {
        benchmark.getConfig().adjustForQuickTest();
      }

      System.out.println("\n=== Starting DB-ESDK Java Benchmark ===");
      System.out.printf("Configuration: %s%n", options.getConfigPath());
      System.out.printf("Output: %s%n", options.getOutputPath());
      System.out.printf("Quick mode: %s%n", options.isQuickTest());
      System.out.printf(
        "System: %d CPU cores, %.1f GB memory%n",
        Utils.getCpuCount(),
        Utils.getTotalMemoryGb()
      );

      // Run benchmarks
      List<BenchmarkResult> results = benchmark.runAllBenchmarks();

      // Save results
      benchmark.saveResults(options.getOutputPath());

      // Print summary
      printSummary(results, options.getOutputPath());
    } catch (Exception e) {
      System.err.println("Benchmark failed: " + e.getMessage());
      e.printStackTrace();
      System.exit(1);
    }
  }

  /**
   * Parses command line arguments.
   */
  private static CommandLineOptions parseArgs(String[] args) {
    Options options = new Options();

    options.addOption(
      Option
        .builder("c")
        .longOpt("config")
        .hasArg()
        .argName("file")
        .desc(
          "Path to test configuration file (default: ../config/test-scenarios.yaml)"
        )
        .build()
    );

    options.addOption(
      Option
        .builder("o")
        .longOpt("output")
        .hasArg()
        .argName("file")
        .desc(
          "Path to output results file (default: ../results/raw-data/java_results.json)"
        )
        .build()
    );

    options.addOption(
      Option
        .builder("q")
        .longOpt("quick")
        .desc("Run quick test with reduced iterations")
        .build()
    );

    options.addOption(
      Option.builder("h").longOpt("help").desc("Show this help message").build()
    );

    CommandLineParser parser = new DefaultParser();
    try {
      CommandLine cmd = parser.parse(options, args);

      if (cmd.hasOption("h")) {
        printUsage(options);
        return null;
      }

      String configPath = cmd.getOptionValue(
        "c",
        "../config/test-scenarios.yaml"
      );
      String outputPath = cmd.getOptionValue(
        "o",
        "../results/raw-data/java_results.json"
      );
      boolean quickTest = cmd.hasOption("q");

      return new CommandLineOptions(configPath, outputPath, quickTest);
    } catch (ParseException e) {
      System.err.println("Error parsing command line: " + e.getMessage());
      printUsage(options);
      return null;
    }
  }

  /**
   * Prints usage information.
   */
  private static void printUsage(Options options) {
    HelpFormatter formatter = new HelpFormatter();
    System.out.println("DB-ESDK Java Performance Benchmark");
    System.out.println();
    formatter.printHelp("java -jar db-esdk-benchmark.jar [options]", options);
    System.out.println();
    System.out.println("Examples:");
    System.out.println("  # Run quick benchmark");
    System.out.println("  java -jar db-esdk-benchmark.jar --quick");
    System.out.println();
    System.out.println("  # Run full benchmark with custom config");
    System.out.println(
      "  java -jar db-esdk-benchmark.jar -c /path/to/config.yaml -o /path/to/results.json"
    );
    System.out.println();
    System.out.println("  # Using Gradle");
    System.out.println("  ./gradlew run --args=\"--quick\"");
  }

  /**
   * Prints benchmark summary.
   */
  private static void printSummary(
    List<BenchmarkResult> results,
    String outputPath
  ) {
    System.out.println("\n=== DB-ESDK Java Benchmark Summary ===");
    System.out.printf("Total tests completed: %d%n", results.size());
    System.out.printf("Results saved to: %s%n", outputPath);

    if (!results.isEmpty()) {
      // Find maximum throughput
      double maxThroughput = results
        .stream()
        .filter(r -> "throughput".equals(r.getTestName()))
        .mapToDouble(BenchmarkResult::getOpsPerSecond)
        .max()
        .orElse(0.0);

      if (maxThroughput > 0) {
        System.out.printf("Maximum throughput: %.2f ops/sec%n", maxThroughput);
      }

      // Print some sample results by test type
      System.out.println();
      printTestTypeSummary(results, "throughput");
      printTestTypeSummary(results, "memory");
      printTestTypeSummary(results, "concurrent");
    }

    System.out.println("\n=== Benchmark Complete ===");
  }

  /**
   * Prints summary for a specific test type.
   */
  private static void printTestTypeSummary(
    List<BenchmarkResult> results,
    String testType
  ) {
    List<BenchmarkResult> testResults = results
      .stream()
      .filter(r -> testType.equals(r.getTestName()))
      .collect(java.util.stream.Collectors.toList());

    if (testResults.isEmpty()) {
      return;
    }

    System.out.printf(
      "\n%s Tests (%d results):%n",
      testType.substring(0, 1).toUpperCase() + testType.substring(1),
      testResults.size()
    );

    if ("throughput".equals(testType)) {
      testResults
        .stream()
        .limit(3) // Show first 3 results
        .forEach(r ->
          System.out.printf(
            "  %s: %.2f ops/sec, %.2f ms latency%n",
            formatDataSize(r.getDataSize()),
            r.getOpsPerSecond(),
            r.getEndToEndLatencyMs()
          )
        );
    } else if ("memory".equals(testType)) {
      testResults
        .stream()
        .limit(3)
        .forEach(r ->
          System.out.printf(
            "  %s: %.2f MB peak, %.4f efficiency%n",
            formatDataSize(r.getDataSize()),
            r.getPeakMemoryMb(),
            r.getMemoryEfficiencyRatio()
          )
        );
    } else if ("concurrent".equals(testType)) {
      testResults
        .stream()
        .limit(3)
        .forEach(r ->
          System.out.printf(
            "  %s (%d threads): %.2f ops/sec%n",
            formatDataSize(r.getDataSize()),
            r.getConcurrency(),
            r.getOpsPerSecond()
          )
        );
    }
  }

  /**
   * Formats data size for display.
   */
  private static String formatDataSize(int bytes) {
    if (bytes >= 1024 * 1024 * 1024) {
      return String.format("%.0f GB", bytes / (1024.0 * 1024.0 * 1024.0));
    } else if (bytes >= 1024 * 1024) {
      return String.format("%.0f MB", bytes / (1024.0 * 1024.0));
    } else if (bytes >= 1024) {
      return String.format("%.0f KB", bytes / 1024.0);
    } else {
      return bytes + " B";
    }
  }

  /**
   * Command line options holder.
   */
  public static class CommandLineOptions {

    private final String configPath;
    private final String outputPath;
    private final boolean quickTest;

    public CommandLineOptions(
      String configPath,
      String outputPath,
      boolean quickTest
    ) {
      this.configPath = configPath;
      this.outputPath = outputPath;
      this.quickTest = quickTest;
    }

    public String getConfigPath() {
      return configPath;
    }

    public String getOutputPath() {
      return outputPath;
    }

    public boolean isQuickTest() {
      return quickTest;
    }
  }
}
