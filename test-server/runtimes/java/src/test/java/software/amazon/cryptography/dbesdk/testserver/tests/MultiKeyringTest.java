// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import java.nio.ByteBuffer;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbesdk.testserver.model.AesWrappingAlg;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsMrkMultiKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.MultiKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.RawAesKeyringConfig;

/**
 * Round-trip through a multi-keyring whose generator is an AWS KMS MRK multi-keyring and whose only
 * child is a Raw AES keyring (generated at test time). Mirrors {@code MultiKeyringExample}: an item
 * encrypted with the multi-keyring is decryptable by any component keyring.
 */
@DisplayName("Multi-keyring round-trip returns an attribute-for-attribute equal item")
final class MultiKeyringTest extends AbstractRoundTripTest {

  private final ByteBuffer childAesKey = TestKeyMaterial.generateAesKey(256);

  @Override
  protected String partitionKeyValue() {
    return "pk-multi-001";
  }

  @Override
  protected KeyringConfig keyringConfig() {
    final KeyringConfig generator =
        KeyringConfig.builder()
            .awsKmsMrkMulti(
                AwsKmsMrkMultiKeyringConfig.builder()
                    .generator(TestKeyMaterial.resolveKmsKeyId())
                    .build())
            .build();

    final KeyringConfig childRawAes =
        KeyringConfig.builder()
            .rawAes(
                RawAesKeyringConfig.builder()
                    .keyNamespace("test-server-namespace")
                    .keyName("multi-child-aes-key")
                    .wrappingKey(childAesKey)
                    .wrappingAlg(AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16)
                    .build())
            .build();

    return KeyringConfig.builder()
        .multi(
            MultiKeyringConfig.builder()
                .generator(generator)
                .childKeyrings(List.of(childRawAes))
                .build())
        .build();
  }

  @Test
  @DisplayName("written item is returned equal after encrypt + decrypt with a multi-keyring")
  void writeThenReadReturnsEqualItem() {
    runRoundTrip();
  }
}
