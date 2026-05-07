// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

package software.amazon.cryptography.examples;

import java.util.logging.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// RetryAnalyzer is intentionally duplicated across all examples project as exampels are intentionally self-contained
// so users of the library can copy a single project without pulling in shared infrastructure.
public class RetryAnalyzer implements IRetryAnalyzer {

  private static final Logger logger = Logger.getLogger(
    RetryAnalyzer.class.getName()
  );
  private int retryCount = 0;
  private static final int maxRetryCount = 3;

  @Override
  public boolean retry(ITestResult result) {
    if (retryCount < maxRetryCount) {
      retryCount++;
      logger.info(
        String.format(
          "Retrying test '%s' - attempt %d/%d",
          result.getName(),
          retryCount,
          maxRetryCount
        )
      );
      try {
        Thread.sleep(5000L * (long) Math.pow(2, retryCount - 1)); // simple exponential backoff
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      return true;
    }
    return false;
  }
}
