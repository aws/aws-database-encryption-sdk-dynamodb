// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import java.security.KeyPair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbesdk.testserver.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.dbesdk.testserver.model.ECDHCurveSpec;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.RawEcdhKeyringConfig;

/**
 * Round-trip through a Raw ECDH keyring using the RawPrivateKeyToStaticPublicKey scheme. A single
 * P-256 EC key pair is generated at test time: its private key (PEM PKCS#8) is the sender static
 * private key and its own public key (DER X.509 SPKI) is the recipient public key. Using one key
 * pair for both roles means encrypt and decrypt derive the same shared secret (mirrors
 * {@code RawEcdhKeyringExample}'s RawPrivateKeyToStaticPublicKey). No AWS access required. The
 * table config MUST use a non-asymmetric-signing algorithm suite.
 */
@DisplayName("Raw ECDH keyring round-trip returns an attribute-for-attribute equal item")
final class RawEcdhKeyringTest extends AbstractRoundTripTest {

  private final KeyPair keyPair = TestKeyMaterial.generateEcKeyPair("secp256r1");

  @Override
  protected String partitionKeyValue() {
    return "pk-rawecdh-001";
  }

  @Override
  protected DBEAlgorithmSuiteId algorithmSuiteId() {
    // ECDH cannot use an asymmetric-signing suite.
    return DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384;
  }

  @Override
  protected KeyringConfig keyringConfig() {
    return KeyringConfig.builder()
        .rawEcdh(
            RawEcdhKeyringConfig.builder()
                .senderStaticPrivateKey(TestKeyMaterial.ecPrivateKeyPkcs8PemUtf8(keyPair))
                .recipientPublicKey(TestKeyMaterial.ecPublicKeyDer(keyPair))
                .curveSpec(ECDHCurveSpec.ECC_NIST_P256)
                .build())
        .build();
  }

  @Test
  @DisplayName("written item is returned equal after encrypt + decrypt with a Raw ECDH keyring")
  void writeThenReadReturnsEqualItem() {
    runRoundTrip();
  }
}
