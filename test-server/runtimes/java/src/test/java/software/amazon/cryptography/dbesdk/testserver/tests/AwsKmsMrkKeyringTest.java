// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsMrkKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;

/** Round-trip through an AWS KMS MRK keyring (the server builds the KMS client). */
@DisplayName("AWS KMS MRK keyring round-trip returns an attribute-for-attribute equal item")
final class AwsKmsMrkKeyringTest extends AbstractRoundTripTest {

  @Override
  protected String partitionKeyValue() {
    return "pk-awskmsmrk-001";
  }

  @Override
  protected KeyringConfig keyringConfig() {
    return KeyringConfig.builder()
        .awsKmsMrk(AwsKmsMrkKeyringConfig.builder().kmsKeyId(TestKeyMaterial.resolveKmsKeyId()).build())
        .build();
  }

  @Test
  @DisplayName("written item is returned equal after encrypt + decrypt with an AWS KMS MRK keyring")
  void writeThenReadReturnsEqualItem() {
    runRoundTrip();
  }
}
