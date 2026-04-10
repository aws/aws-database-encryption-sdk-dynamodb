// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.examples;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Shared utilities for examples. The SORT_KEY constant provides a unique value
 * per JVM process so that parallel CI matrix jobs (different Java versions / OS)
 * do not overwrite each other's items in the shared DynamoDB test table.
 */
public class ExampleUtils {

  public static final int SORT_KEY =
    ThreadLocalRandom.current().nextInt(100000, 999999);

  public static final String SORT_KEY_VALUE = String.valueOf(SORT_KEY);
}
