// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder;
import software.amazon.awssdk.services.dynamodb.model.AttributeDefinition;
import software.amazon.awssdk.services.dynamodb.model.BillingMode;
import software.amazon.awssdk.services.dynamodb.model.CreateTableRequest;
import software.amazon.awssdk.services.dynamodb.model.DescribeTableRequest;
import software.amazon.awssdk.services.dynamodb.model.KeySchemaElement;
import software.amazon.awssdk.services.dynamodb.model.KeyType;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;
import software.amazon.awssdk.services.dynamodb.model.ScalarAttributeType;
import software.amazon.cryptography.dbesdk.testserver.model.AttributeValue;
import software.amazon.cryptography.dbesdk.testserver.model.CreateClientInput;
import software.amazon.cryptography.dbesdk.testserver.model.CreateClientOutput;
import software.amazon.cryptography.dbesdk.testserver.model.CryptoAction;
import software.amazon.cryptography.dbesdk.testserver.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.ReadItemInput;
import software.amazon.cryptography.dbesdk.testserver.model.ReadItemOutput;
import software.amazon.cryptography.dbesdk.testserver.model.TableEncryptionConfig;
import software.amazon.cryptography.dbesdk.testserver.model.WriteItemInput;
import software.amazon.cryptography.dbesdk.testserver.model.WriteItemOutput;

/**
 * Shared base for the per-keyring create&rarr;write&rarr;read round-trip Test_Suite classes
 * (Component 6 of the design). Each concrete subclass exercises one keyring kind: it supplies the
 * {@link KeyringConfig} to configure and a DISTINCT partition-key value (so the shared real
 * DynamoDB table {@link DemoResources#ROUND_TRIP_TABLE_NAME} can host every keyring's item without
 * collisions), and inherits the full create/write/read flow plus the attribute-for-attribute
 * equality assertions (Reqs 7.2, 7.3).
 *
 * <p>The equality helpers ({@link #assertItemsEqual}, {@link #assertAttributeEquals}) and the
 * generic item/key builders are centralized here so the keyring suites stay focused on building
 * their keyring configuration. The behavior mirrors the original {@code RoundTripTest} exactly; it
 * is extracted so the new suites do not duplicate it.
 *
 * <h2>"Fails open"</h2>
 *
 * <p>The three operations under test run with no surrounding try/catch: an unreachable server,
 * rejected config, or misbehaving backend throws and JUnit records a failure, so a broken
 * round-trip can never be read as a pass (Reqs 7.5, 8.5). The only {@code catch} here is in table
 * fixture setup, which merely makes provisioning idempotent and never wraps an operation under
 * test.
 */
abstract class AbstractRoundTripTest extends AbstractTestServerTest {

  /** Physical table all keyring suites share; provisioned once, never deleted. */
  static final String TABLE_NAME = DemoResources.ROUND_TRIP_TABLE_NAME;

  /** Partition key attribute name of {@link #TABLE_NAME} (String-typed, HASH). */
  static final String PARTITION_KEY_NAME = DemoResources.ROUND_TRIP_PARTITION_KEY_NAME;

  // Encrypted-and-signed attribute names, chosen to exercise several AttributeValue variants.
  static final String ATTR_STRING = "sensitive_string";
  static final String ATTR_NUMBER = "sensitive_number";
  static final String ATTR_BINARY = "sensitive_binary";

  /** A signed-only (not encrypted) non-key attribute, to exercise a mixed action set. */
  static final String ATTR_FLAG = "a_flag";

  /** AWS SDK v2 client used only to provision the physical table the server reads/writes. */
  private static DynamoDbClient ddb;

  /**
   * @return the keyring configuration this suite exercises (built fresh per call so any generated
   *     key material is created at test time)
   */
  protected abstract KeyringConfig keyringConfig();

  /**
   * @return a partition-key value distinct to this suite, so concurrent suites never collide in the
   *     shared table
   */
  protected abstract String partitionKeyValue();

  /**
   * @return the algorithm suite id this suite's table config must use, or {@code null} for the
   *     DB-ESDK default. Keyrings that cannot use asymmetric signing (KMS RSA, ECDH) override this
   *     to {@link DBEAlgorithmSuiteId#ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384}.
   */
  protected DBEAlgorithmSuiteId algorithmSuiteId() {
    return null;
  }

  @BeforeAll
  static void createTable() {
    final DynamoDbClientBuilder builder =
        DynamoDbClient.builder().region(Region.of(DemoResources.REGION));
    config
        .ddbEndpoint()
        .ifPresent(
            endpoint -> {
              builder.endpointOverride(URI.create(endpoint));
              builder.credentialsProvider(
                  StaticCredentialsProvider.create(AwsBasicCredentials.create("dummy", "dummy")));
            });
    ddb = builder.build();

    if (!tableExists()) {
      ddb.createTable(
          CreateTableRequest.builder()
              .tableName(TABLE_NAME)
              .keySchema(
                  KeySchemaElement.builder()
                      .attributeName(PARTITION_KEY_NAME)
                      .keyType(KeyType.HASH)
                      .build())
              .attributeDefinitions(
                  AttributeDefinition.builder()
                      .attributeName(PARTITION_KEY_NAME)
                      .attributeType(ScalarAttributeType.S)
                      .build())
              .billingMode(BillingMode.PAY_PER_REQUEST)
              .build());
      ddb.waiter().waitUntilTableExists(b -> b.tableName(TABLE_NAME));
    }
  }

  private static boolean tableExists() {
    try {
      ddb.describeTable(DescribeTableRequest.builder().tableName(TABLE_NAME).build());
      return true;
    } catch (final ResourceNotFoundException absent) {
      return false;
    }
  }

  @AfterAll
  static void closeDdb() {
    if (ddb != null) {
      ddb.close();
      ddb = null;
    }
  }

  /**
   * The shared create&rarr;write&rarr;read flow: create a client configured with this suite's
   * keyring, write the round-trip item, read it back with the same client and key, and assert it is
   * found and attribute-for-attribute equal to what was written (Reqs 7.2, 7.3).
   */
  protected void runRoundTrip() {
    final CreateClientOutput created = client.createClient(createClientInput());
    final String clientId = created.getClientId();
    assertNotNull(clientId, "CreateClient must return a ClientId");
    assertTrue(!clientId.isEmpty(), "CreateClient ClientId must be non-empty");

    final Map<String, AttributeValue> writtenItem = roundTripItem();
    final WriteItemOutput writeOutput =
        client.writeItem(
            WriteItemInput.builder()
                .clientId(clientId)
                .tableName(TABLE_NAME)
                .item(writtenItem)
                .build());
    assertTrue(writeOutput.isCompleted(), "WriteItem must report completion (Req 5.1)");

    final ReadItemOutput readOutput =
        client.readItem(
            ReadItemInput.builder()
                .clientId(clientId)
                .tableName(TABLE_NAME)
                .key(primaryKey())
                .build());

    assertTrue(readOutput.isFound(), "ReadItem must find the item just written (Req 7.2)");
    assertItemsEqual(writtenItem, readOutput.getItem());
  }

  /** The single round-trip item: signed PK + three encrypted attributes + one signed-only flag. */
  protected Map<String, AttributeValue> roundTripItem() {
    final Map<String, AttributeValue> item = new LinkedHashMap<>();
    item.put(PARTITION_KEY_NAME, AttributeValue.builder().s(partitionKeyValue()).build());
    item.put(ATTR_STRING, AttributeValue.builder().s("top-secret-value").build());
    item.put(ATTR_NUMBER, AttributeValue.builder().n("42").build());
    item.put(
        ATTR_BINARY,
        AttributeValue.builder()
            .b(ByteBuffer.wrap("binary-blob".getBytes(StandardCharsets.UTF_8)))
            .build());
    item.put(ATTR_FLAG, AttributeValue.builder().bool(true).build());
    return item;
  }

  /** The primary key for {@link #roundTripItem()} — just the partition key. */
  protected Map<String, AttributeValue> primaryKey() {
    final Map<String, AttributeValue> key = new LinkedHashMap<>();
    key.put(PARTITION_KEY_NAME, AttributeValue.builder().s(partitionKeyValue()).build());
    return key;
  }

  /** Builds the {@link CreateClientInput} for this suite, using {@link #keyringConfig()}. */
  protected CreateClientInput createClientInput() {
    return createClientInput(keyringConfig());
  }

  /** Builds a {@link CreateClientInput} for the supplied keyring (used by the two-client flow). */
  protected CreateClientInput createClientInput(final KeyringConfig keyring) {
    final Map<String, CryptoAction> attributeActions = new LinkedHashMap<>();
    attributeActions.put(PARTITION_KEY_NAME, CryptoAction.SIGN_ONLY);
    attributeActions.put(ATTR_STRING, CryptoAction.ENCRYPT_AND_SIGN);
    attributeActions.put(ATTR_NUMBER, CryptoAction.ENCRYPT_AND_SIGN);
    attributeActions.put(ATTR_BINARY, CryptoAction.ENCRYPT_AND_SIGN);
    attributeActions.put(ATTR_FLAG, CryptoAction.SIGN_ONLY);

    final TableEncryptionConfig.Builder tableConfig =
        TableEncryptionConfig.builder()
            .logicalTableName(TABLE_NAME)
            .partitionKeyName(PARTITION_KEY_NAME)
            .attributeActionsOnEncrypt(attributeActions)
            .keyring(keyring);
    if (algorithmSuiteId() != null) {
      tableConfig.algorithmSuiteId(algorithmSuiteId());
    }

    return CreateClientInput.builder()
        .tableEncryptionConfigs(Map.of(TABLE_NAME, tableConfig.build()))
        .build();
  }

  /**
   * Two-client flow for DECRYPT-ONLY keyrings (e.g. the discovery family): create a client whose
   * keyring is {@code encryptConfig}, write the round-trip item with it, then create a SECOND
   * client whose keyring is {@code decryptConfig} and read the item back with it, asserting it is
   * found and attribute-for-attribute equal to what was written.
   */
  protected void runTwoClientRoundTrip(
      final KeyringConfig encryptConfig, final KeyringConfig decryptConfig) {
    final String encryptClientId = client.createClient(createClientInput(encryptConfig)).getClientId();
    assertNotNull(encryptClientId, "CreateClient must return a ClientId for the encrypt client");
    assertTrue(!encryptClientId.isEmpty(), "encrypt ClientId must be non-empty");

    final Map<String, AttributeValue> writtenItem = roundTripItem();
    final WriteItemOutput writeOutput =
        client.writeItem(
            WriteItemInput.builder()
                .clientId(encryptClientId)
                .tableName(TABLE_NAME)
                .item(writtenItem)
                .build());
    assertTrue(writeOutput.isCompleted(), "WriteItem must report completion (Req 5.1)");

    final String decryptClientId = client.createClient(createClientInput(decryptConfig)).getClientId();
    assertNotNull(decryptClientId, "CreateClient must return a ClientId for the decrypt client");
    assertTrue(!decryptClientId.isEmpty(), "decrypt ClientId must be non-empty");

    final ReadItemOutput readOutput =
        client.readItem(
            ReadItemInput.builder()
                .clientId(decryptClientId)
                .tableName(TABLE_NAME)
                .key(primaryKey())
                .build());

    assertTrue(readOutput.isFound(), "ReadItem must find the item just written (Req 7.2)");
    assertItemsEqual(writtenItem, readOutput.getItem());
  }

  // --- attribute-for-attribute equality (shared; identical to the original RoundTripTest) -------

  static void assertItemsEqual(
      final Map<String, AttributeValue> written, final Map<String, AttributeValue> read) {
    assertNotNull(read, "ReadItem returned no item map");

    final Set<String> writtenNames = new LinkedHashSet<>(written.keySet());
    final Set<String> readNames = new LinkedHashSet<>(read.keySet());

    final Set<String> missing = new TreeSet<>(writtenNames);
    missing.removeAll(readNames);
    final Set<String> extra = new TreeSet<>(readNames);
    extra.removeAll(writtenNames);

    assertTrue(
        missing.isEmpty(),
        "Read item is missing attributes that were written: " + missing + " (Req 7.3)");
    assertTrue(
        extra.isEmpty(),
        "Read item has extra attributes that were not written: " + extra + " (Req 7.3)");

    for (final Map.Entry<String, AttributeValue> entry : written.entrySet()) {
      assertAttributeEquals(entry.getKey(), entry.getValue(), read.get(entry.getKey()));
    }
  }

  static void assertAttributeEquals(
      final String name, final AttributeValue expected, final AttributeValue actual) {
    assertNotNull(actual, "Attribute '" + name + "' is absent from the read item");
    assertEquals(
        expected.getClass(),
        actual.getClass(),
        "Attribute '" + name + "' has a different type: expected " + expected + " but was " + actual);

    switch (expected) {
      case AttributeValue.SMember e ->
          assertEquals(e.s(), ((AttributeValue.SMember) actual).s(), "String attribute '" + name + "' differs");
      case AttributeValue.NMember e ->
          assertEquals(e.n(), ((AttributeValue.NMember) actual).n(), "Number attribute '" + name + "' differs");
      case AttributeValue.BMember e ->
          assertEquals(
              bytesOf(e.b()),
              bytesOf(((AttributeValue.BMember) actual).b()),
              "Binary attribute '" + name + "' differs");
      case AttributeValue.BoolMember e ->
          assertEquals(
              e.bool(), ((AttributeValue.BoolMember) actual).bool(), "Boolean attribute '" + name + "' differs");
      case AttributeValue.NullMemberMember e ->
          assertEquals(
              e.nullMember(),
              ((AttributeValue.NullMemberMember) actual).nullMember(),
              "Null attribute '" + name + "' differs");
      case AttributeValue.SsMember e ->
          assertEquals(
              new LinkedHashSet<>(e.ss()),
              new LinkedHashSet<>(((AttributeValue.SsMember) actual).ss()),
              "String-set attribute '" + name + "' differs");
      case AttributeValue.NsMember e ->
          assertEquals(
              new LinkedHashSet<>(e.ns()),
              new LinkedHashSet<>(((AttributeValue.NsMember) actual).ns()),
              "Number-set attribute '" + name + "' differs");
      case AttributeValue.BsMember e ->
          assertEquals(
              byteContentSet(e.bs()),
              byteContentSet(((AttributeValue.BsMember) actual).bs()),
              "Binary-set attribute '" + name + "' differs");
      case AttributeValue.MMember e ->
          assertItemsEqual(e.m(), ((AttributeValue.MMember) actual).m());
      case AttributeValue.LMember e -> {
        final List<AttributeValue> expectedList = e.l();
        final List<AttributeValue> actualList = ((AttributeValue.LMember) actual).l();
        assertEquals(
            expectedList.size(), actualList.size(), "List attribute '" + name + "' has a different size");
        for (int i = 0; i < expectedList.size(); i++) {
          assertAttributeEquals(name + "[" + i + "]", expectedList.get(i), actualList.get(i));
        }
      }
      default -> fail("Attribute '" + name + "' has an unsupported/unknown variant: " + expected);
    }
  }

  /** Reads a {@link ByteBuffer}'s remaining bytes without disturbing its position. */
  static List<Byte> bytesOf(final ByteBuffer buffer) {
    final ByteBuffer dup = buffer.duplicate();
    final byte[] bytes = new byte[dup.remaining()];
    dup.get(bytes);
    final java.util.List<Byte> out = new java.util.ArrayList<>(bytes.length);
    for (final byte b : bytes) {
      out.add(b);
    }
    return out;
  }

  /** Turns a list of binary values into an unordered set of their byte contents. */
  static Set<List<Byte>> byteContentSet(final List<ByteBuffer> buffers) {
    final Set<List<Byte>> out = new LinkedHashSet<>();
    for (final ByteBuffer b : buffers) {
      out.add(bytesOf(b));
    }
    return out;
  }
}
