// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsMrkMultiKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.CreateClientInput;
import software.amazon.cryptography.dbesdk.testserver.model.CreateClientOutput;
import software.amazon.cryptography.dbesdk.testserver.model.CryptoAction;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.TableEncryptionConfig;

/**
 * The first concrete round-trip Test_Suite class (Component 6 of the design). It exercises exactly
 * one acceptance criterion:
 *
 * <blockquote>Req 7.1 — the Test_Suite includes a test that calls {@code CreateClient} against the
 * Java_Server and asserts the response contains a non-empty {@code ClientId}.</blockquote>
 *
 * <p>The test drives the smithy-java GENERATED {@link
 * software.amazon.cryptography.dbesdk.testserver.client.TestServerClient} inherited from {@link
 * AbstractTestServerTest}, so the wire contract is exactly the one produced from the shared
 * Smithy_Model — the test defines no request/response shapes of its own (Req 8.1).
 *
 * <h2>Why this is only the {@code CreateClient} test</h2>
 *
 * <p>This class is intentionally scoped to Req 7.1 alone. The create&rarr;write&rarr;read round-trip
 * with attribute-for-attribute equality is a separate test (task 4.4 / Reqs 7.2, 7.3) and is not
 * implemented here.
 *
 * <h2>"Fails open" — no defensive error handling</h2>
 *
 * <p>Per the design's testing strategy the framework fails open: this test adds no try/catch around
 * the operation. If the Java_Server is unreachable, the configuration is rejected by the
 * Enhanced_Client, or the backend misbehaves, the generated client throws and JUnit records a
 * failure — an unreachable or broken server is never read as a pass (Reqs 7.5, 8.5). The harness's
 * {@code @BeforeAll} additionally probes reachability so such a run fails fast.
 */
@DisplayName("CreateClient returns a non-empty ClientId (Req 7.1)")
final class CreateClientTest extends AbstractTestServerTest {

  /**
   * Runtime-configuration key for the AWS KMS key id used to build the CreateClient keyring config.
   *
   * <p>Resolved as a JVM system property first, then this environment variable. The key id is
   * <em>never</em> hard-coded: a real, account-specific KMS key ARN/id is environment-specific and
   * (for a CMK) sensitive, so it is supplied at run time exactly like the endpoint configuration
   * (Reqs 8.3, 8.4). The {@code test-java} Make target forwards {@code -Dtestserver.kms.key.id};
   * a user may instead export {@code TEST_SERVER_KMS_KEY_ID}.
   */
  static final String KMS_KEY_ID_PROPERTY = "testserver.kms.key.id";

  static final String KMS_KEY_ID_ENV = "TEST_SERVER_KMS_KEY_ID";

  /** Physical table name used for the minimal-but-valid CreateClient configuration. */
  private static final String TABLE_NAME = "TestServerCreateClientTable";

  /** Partition key attribute name for {@link #TABLE_NAME}. */
  private static final String PARTITION_KEY_NAME = "partition_key";

  /** A representative encrypted-and-signed attribute, to make the config exercise encryption. */
  private static final String ENCRYPTED_ATTRIBUTE_NAME = "sensitive_data";

  @Test
  @DisplayName("a valid configuration yields a present, non-empty ClientId")
  void createClientReturnsNonEmptyClientId() {
    final CreateClientInput input = minimalValidCreateClientInput(resolveKmsKeyId());

    // No try/catch on purpose: any server/config/backend failure surfaces as a JUnit failure.
    final CreateClientOutput output = client.createClient(input);

    assertNotNull(output, "CreateClient must return an output (Req 7.1)");
    final String clientId = output.getClientId();
    assertNotNull(clientId, "CreateClient response must contain a ClientId (Req 7.1)");
    assertFalse(clientId.isEmpty(), "CreateClient ClientId must be non-empty (Req 7.1)");
  }

  /**
   * Builds a minimal-but-valid {@link CreateClientInput}: a single table with a partition key, an
   * attribute-actions map, and a KMS keyring config. This mirrors the smallest configuration that
   * the DB-ESDK Enhanced_Client accepts so the assertion under test is about the returned
   * {@code ClientId}, not config richness.
   *
   * <p>The partition key is {@code SIGN_ONLY} (the Enhanced_Client requires primary-key attributes
   * to be signed but not encrypted), and one additional attribute is {@code ENCRYPT_AND_SIGN} so the
   * client is configured to actually encrypt.
   */
  private static CreateClientInput minimalValidCreateClientInput(final String kmsKeyId) {
    final Map<String, CryptoAction> attributeActions = new LinkedHashMap<>();
    attributeActions.put(PARTITION_KEY_NAME, CryptoAction.SIGN_ONLY);
    attributeActions.put(ENCRYPTED_ATTRIBUTE_NAME, CryptoAction.ENCRYPT_AND_SIGN);

    final KeyringConfig keyring =
        KeyringConfig.builder()
            .awsKmsMrkMulti(AwsKmsMrkMultiKeyringConfig.builder().generator(kmsKeyId).build())
            .build();

    final TableEncryptionConfig tableConfig =
        TableEncryptionConfig.builder()
            .logicalTableName(TABLE_NAME)
            .partitionKeyName(PARTITION_KEY_NAME)
            .attributeActionsOnEncrypt(attributeActions)
            .keyring(keyring)
            .build();

    return CreateClientInput.builder()
        .tableEncryptionConfigs(Map.of(TABLE_NAME, tableConfig))
        .build();
  }

  /**
   * Resolves the KMS key id, defaulting to the hard-coded demo key ({@link DemoResources#KMS_KEY_ID})
   * but still honoring a system-property / environment-variable override so the same test can target
   * a different account's key without editing source.
   */
  private static String resolveKmsKeyId() {
    final String fromProperty = System.getProperty(KMS_KEY_ID_PROPERTY);
    if (fromProperty != null && !fromProperty.isBlank()) {
      return fromProperty.trim();
    }
    final String fromEnv = System.getenv(KMS_KEY_ID_ENV);
    if (fromEnv != null && !fromEnv.isBlank()) {
      return fromEnv.trim();
    }
    return DemoResources.KMS_KEY_ID;
  }
}
