// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.examples;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Shared utilities for examples. The TEST_SUFFIX provides a unique suffix
 * per JVM process so that parallel CI matrix jobs (different Java versions / OS)
 * do not overwrite each other's items in the shared DynamoDB test table.
 *
 * Each example uses a hardcoded partition key like "rawEcdhKeyringItem".
 * In CI, multiple JVMs run in parallel against the same table. Without
 * isolation, one JVM can overwrite another's item, causing decrypt failures.
 * By appending a random suffix, each JVM writes to its own partition key
 * (e.g., "rawEcdhKeyringItem-482913") while keeping cross-example reads
 * working within the same JVM.
 */
public class ExampleUtils {

  private static final String TEST_SUFFIX = String.valueOf(
    ThreadLocalRandom.current().nextInt(100000, 999999)
  );

  /**
   * Returns a partition key value unique to this JVM process.
   * Example: "rawEcdhKeyringItem" becomes "rawEcdhKeyringItem-482913"
   */
  public static String uniquePk(String base) {
    return base + "-" + TEST_SUFFIX;
  }
}
