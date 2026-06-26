// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import java.nio.ByteBuffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbesdk.testserver.model.AesWrappingAlg;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.RawAesKeyringConfig;

/** Round-trip through a Raw AES keyring (256-bit key generated at test time). */
@DisplayName("Raw AES keyring round-trip returns an attribute-for-attribute equal item")
final class RawAesKeyringTest extends AbstractRoundTripTest {

  private final ByteBuffer wrappingKey = TestKeyMaterial.generateAesKey(256);

  @Override
  protected String partitionKeyValue() {
    return "pk-rawaes-001";
  }

  @Override
  protected KeyringConfig keyringConfig() {
    return KeyringConfig.builder()
        .rawAes(
            RawAesKeyringConfig.builder()
                .keyNamespace("test-server-namespace")
                .keyName("raw-aes-key")
                .wrappingKey(wrappingKey)
                .wrappingAlg(AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16)
                .build())
        .build();
  }

  @Test
  @DisplayName("written item is returned equal after encrypt + decrypt with a Raw AES keyring")
  void writeThenReadReturnsEqualItem() {
    runRoundTrip();
  }
}
