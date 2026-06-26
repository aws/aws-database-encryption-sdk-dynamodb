// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsEcdhKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.dbesdk.testserver.model.ECDHCurveSpec;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;

/**
 * Round-trip through an AWS KMS ECDH keyring using the KmsPrivateKeyToStaticPublicKey scheme. The
 * same ECC KMS key ({@link DemoResources#ECDH_KMS_KEY_ID}) is used as both sender and recipient, so
 * the shared secret (and therefore the wrapping key) is identical on encrypt and decrypt. The
 * recipient public key is fetched from KMS as raw DER X.509 SPKI bytes. The table config MUST use a
 * non-asymmetric-signing algorithm suite.
 */
@DisplayName("AWS KMS ECDH keyring round-trip returns an attribute-for-attribute equal item")
final class AwsKmsEcdhKeyringTest extends AbstractRoundTripTest {

  @Override
  protected String partitionKeyValue() {
    return "pk-awskmsecdh-001";
  }

  @Override
  protected DBEAlgorithmSuiteId algorithmSuiteId() {
    // ECDH cannot use an asymmetric-signing suite.
    return DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384;
  }

  @Override
  protected KeyringConfig keyringConfig() {
    return KeyringConfig.builder()
        .awsKmsEcdh(
            AwsKmsEcdhKeyringConfig.builder()
                .senderKmsIdentifier(DemoResources.ECDH_KMS_KEY_ID)
                .recipientPublicKey(
                    TestKeyMaterial.kmsEccPublicKeyDer(
                        DemoResources.ECDH_KMS_KEY_ID, DemoResources.REGION))
                .curveSpec(ECDHCurveSpec.ECC_NIST_P256)
                .build())
        .build();
  }

  @Test
  @DisplayName("written item is returned equal after encrypt + decrypt with an AWS KMS ECDH keyring")
  void writeThenReadReturnsEqualItem() {
    runRoundTrip();
  }
}
