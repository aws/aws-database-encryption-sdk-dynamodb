// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.examples.migration;

import java.util.logging.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

  private static final Logger logger = Logger.getLogger(RetryAnalyzer.class.getName());
  private int retryCount = 0;
  private static final int maxRetryCount = 3;

  @Override
  public boolean retry(ITestResult result) {
    if (retryCount < maxRetryCount) {
      retryCount++;
      logger.info(
          String.format(
              "Retrying test '%s' - attempt %d/%d",
              result.getName(), retryCount, maxRetryCount));
      return true;
    }
    return false;
  }
}
