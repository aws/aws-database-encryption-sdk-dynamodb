// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsMrkMultiKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;

/**
 * Round-trip through an AWS KMS MRK multi-keyring built from a single generator key id. This is the
 * keyring kind the original single {@code kmsKeyring} member built (preserved as a variant), so
 * this suite is the successor to the original {@code RoundTripTest}.
 */
@DisplayName("AWS KMS MRK multi-keyring round-trip returns an attribute-for-attribute equal item")
final class AwsKmsMrkMultiKeyringTest extends AbstractRoundTripTest {

  @Override
  protected String partitionKeyValue() {
    return "pk-awskmsmrkmulti-001";
  }

  @Override
  protected KeyringConfig keyringConfig() {
    return KeyringConfig.builder()
        .awsKmsMrkMulti(
            AwsKmsMrkMultiKeyringConfig.builder()
                .generator(TestKeyMaterial.resolveKmsKeyId())
                .build())
        .build();
  }

  @Test
  @DisplayName("written item is returned equal after encrypt + decrypt with an AWS KMS MRK multi-keyring")
  void writeThenReadReturnsEqualItem() {
    runRoundTrip();
  }
}
