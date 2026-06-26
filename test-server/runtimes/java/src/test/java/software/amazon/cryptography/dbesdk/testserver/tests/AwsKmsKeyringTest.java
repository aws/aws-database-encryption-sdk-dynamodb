// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;

/** Round-trip through an AWS KMS keyring (single-Region symmetric key; the server builds the KMS client). */
@DisplayName("AWS KMS keyring round-trip returns an attribute-for-attribute equal item")
final class AwsKmsKeyringTest extends AbstractRoundTripTest {

  @Override
  protected String partitionKeyValue() {
    return "pk-awskms-001";
  }

  @Override
  protected KeyringConfig keyringConfig() {
    return KeyringConfig.builder()
        .awsKms(AwsKmsKeyringConfig.builder().kmsKeyId(TestKeyMaterial.resolveKmsKeyId()).build())
        .build();
  }

  @Test
  @DisplayName("written item is returned equal after encrypt + decrypt with an AWS KMS keyring")
  void writeThenReadReturnsEqualItem() {
    runRoundTrip();
  }
}
