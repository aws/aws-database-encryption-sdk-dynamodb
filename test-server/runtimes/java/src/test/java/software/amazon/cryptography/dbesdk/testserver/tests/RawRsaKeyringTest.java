// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import java.security.KeyPair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.PaddingScheme;
import software.amazon.cryptography.dbesdk.testserver.model.RawRsaKeyringConfig;

/**
 * Round-trip through a Raw RSA keyring (RSA-2048 key pair generated at test time). Both the public
 * key (to encrypt) and the private key (to decrypt) are supplied, PEM-encoded as UTF-8 bytes.
 */
@DisplayName("Raw RSA keyring round-trip returns an attribute-for-attribute equal item")
final class RawRsaKeyringTest extends AbstractRoundTripTest {

  private final KeyPair keyPair = TestKeyMaterial.generateRsaKeyPair(2048);

  @Override
  protected String partitionKeyValue() {
    return "pk-rawrsa-001";
  }

  @Override
  protected KeyringConfig keyringConfig() {
    return KeyringConfig.builder()
        .rawRsa(
            RawRsaKeyringConfig.builder()
                .keyNamespace("test-server-namespace")
                .keyName("raw-rsa-key")
                .paddingScheme(PaddingScheme.OAEP_SHA256_MGF1)
                .publicKey(TestKeyMaterial.publicKeyPemUtf8(keyPair))
                .privateKey(TestKeyMaterial.privateKeyPemUtf8(keyPair))
                .build())
        .build();
  }

  @Test
  @DisplayName("written item is returned equal after encrypt + decrypt with a Raw RSA keyring")
  void writeThenReadReturnsEqualItem() {
    runRoundTrip();
  }
}
