// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsMrkDiscoveryKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;

/**
 * Decrypt-path round-trip for the AWS KMS MRK Discovery keyring (single Region). The item is
 * written with a normal AWS KMS keyring ({@link DemoResources#KMS_KEY_ID}) and then read back with a
 * SECOND client whose keyring is the MRK discovery keyring (configured for {@link
 * DemoResources#REGION}), asserting equality.
 */
@DisplayName("AWS KMS MRK Discovery keyring decrypts an item encrypted by a normal AWS KMS keyring")
final class AwsKmsMrkDiscoveryKeyringTest extends AbstractRoundTripTest {

  @Override
  protected String partitionKeyValue() {
    return "pk-awskmsmrkdiscovery-001";
  }

  /** Unused for the two-client flow, but the base class requires a keyring config. */
  @Override
  protected KeyringConfig keyringConfig() {
    return encryptConfig();
  }

  private KeyringConfig encryptConfig() {
    return KeyringConfig.builder()
        .awsKms(AwsKmsKeyringConfig.builder().kmsKeyId(TestKeyMaterial.resolveKmsKeyId()).build())
        .build();
  }

  private KeyringConfig discoveryConfig() {
    return KeyringConfig.builder()
        .awsKmsMrkDiscovery(
            AwsKmsMrkDiscoveryKeyringConfig.builder().region(DemoResources.REGION).build())
        .build();
  }

  @Test
  @DisplayName("item encrypted with AWS KMS keyring is read back equal with an MRK Discovery keyring")
  void encryptWithKmsDecryptWithMrkDiscovery() {
    runTwoClientRoundTrip(encryptConfig(), discoveryConfig());
  }
}
