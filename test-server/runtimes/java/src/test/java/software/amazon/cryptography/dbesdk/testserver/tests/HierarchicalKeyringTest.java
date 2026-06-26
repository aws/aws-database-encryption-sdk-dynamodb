// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dbesdk.testserver.model.HierarchicalKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.CreateKeyInput;
import software.amazon.cryptography.keystore.model.CreateKeyStoreInput;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;

/**
 * Round-trip through an AWS KMS Hierarchical keyring. In {@code @BeforeAll} a {@link KeyStore} is
 * configured (the same config the server's adapter builds), the key store table is created if
 * absent (idempotent {@code CreateKeyStore}), and a fresh branch key is created; that branch key id
 * is then passed into the CreateClient config. The branch keys are wrapped by the existing
 * symmetric demo key {@link DemoResources#KMS_KEY_ID}. Standard (default) algorithm suite is fine.
 */
@DisplayName("Hierarchical keyring round-trip returns an attribute-for-attribute equal item")
final class HierarchicalKeyringTest extends AbstractRoundTripTest {

  private static String branchKeyId;

  @BeforeAll
  static void setUpKeyStore() {
    final KeyStore keyStore =
        KeyStore.builder()
            .KeyStoreConfig(
                KeyStoreConfig.builder()
                    .ddbClient(DynamoDbClient.builder().region(Region.of(DemoResources.REGION)).build())
                    .ddbTableName(DemoResources.KEY_STORE_TABLE_NAME)
                    .logicalKeyStoreName(DemoResources.LOGICAL_KEY_STORE_NAME)
                    .kmsClient(KmsClient.builder().region(Region.of(DemoResources.REGION)).build())
                    .kmsConfiguration(
                        KMSConfiguration.builder().kmsKeyArn(DemoResources.KMS_KEY_ID).build())
                    .build())
            .build();

    // Create the key store table if it does not already exist. CreateKeyStore is idempotent: if a
    // correctly-configured table already exists this verifies it; we tolerate an already-exists
    // style failure so concurrent/repeat runs do not break.
    try {
      keyStore.CreateKeyStore(CreateKeyStoreInput.builder().build());
    } catch (final RuntimeException alreadyExistsOrInProgress) {
      // Table already present (or being created) — fine for this demo fixture.
    }

    // Wait for the key store table to be active before creating a branch key in it.
    try (DynamoDbClient ddb = DynamoDbClient.builder().region(Region.of(DemoResources.REGION)).build()) {
      ddb.waiter().waitUntilTableExists(b -> b.tableName(DemoResources.KEY_STORE_TABLE_NAME));
    }

    branchKeyId = keyStore.CreateKey(CreateKeyInput.builder().build()).branchKeyIdentifier();
  }

  @Override
  protected String partitionKeyValue() {
    return "pk-hierarchical-001";
  }

  @Override
  protected KeyringConfig keyringConfig() {
    return KeyringConfig.builder()
        .hierarchical(
            HierarchicalKeyringConfig.builder()
                .keyStoreTableName(DemoResources.KEY_STORE_TABLE_NAME)
                .logicalKeyStoreName(DemoResources.LOGICAL_KEY_STORE_NAME)
                .kmsKeyArn(DemoResources.KMS_KEY_ID)
                .branchKeyId(branchKeyId)
                .ttlSeconds(600L)
                .cacheEntryCapacity(100)
                .build())
        .build();
  }

  @Test
  @DisplayName("written item is returned equal after encrypt + decrypt with a Hierarchical keyring")
  void writeThenReadReturnsEqualItem() {
    runRoundTrip();
  }
}
