// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsRsaKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.dbesdk.testserver.model.EncryptionAlgorithmSpec;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;

/**
 * Round-trip through an AWS KMS RSA keyring. The RSA public key is fetched from KMS (via {@code
 * kms:GetPublicKey} on {@link DemoResources#RSA_KMS_KEY_ID}) and supplied PEM-encoded (UTF-8 X.509
 * SPKI) to encrypt; KMS decrypts with the private key. The table config MUST use a
 * non-asymmetric-signing algorithm suite.
 */
@DisplayName("AWS KMS RSA keyring round-trip returns an attribute-for-attribute equal item")
final class AwsKmsRsaKeyringTest extends AbstractRoundTripTest {

  @Override
  protected String partitionKeyValue() {
    return "pk-awskmsrsa-001";
  }

  @Override
  protected DBEAlgorithmSuiteId algorithmSuiteId() {
    // KMS RSA cannot use an asymmetric-signing suite.
    return DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384;
  }

  @Override
  protected KeyringConfig keyringConfig() {
    return KeyringConfig.builder()
        .awsKmsRsa(
            AwsKmsRsaKeyringConfig.builder()
                .kmsKeyId(DemoResources.RSA_KMS_KEY_ID)
                .encryptionAlgorithm(EncryptionAlgorithmSpec.RSAES_OAEP_SHA_256)
                .publicKey(
                    TestKeyMaterial.kmsRsaPublicKeyPemUtf8(
                        DemoResources.RSA_KMS_KEY_ID, DemoResources.REGION))
                .build())
        .build();
  }

  @Test
  @DisplayName("written item is returned equal after encrypt + decrypt with an AWS KMS RSA keyring")
  void writeThenReadReturnsEqualItem() {
    runRoundTrip();
  }
}
