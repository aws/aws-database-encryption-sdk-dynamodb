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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsMrkMultiKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.CreateClientInput;
import software.amazon.cryptography.dbesdk.testserver.model.CreateClientOutput;
import software.amazon.cryptography.dbesdk.testserver.model.CryptoAction;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.ReadItemInput;
import software.amazon.cryptography.dbesdk.testserver.model.ReadItemOutput;
import software.amazon.cryptography.dbesdk.testserver.model.TableEncryptionConfig;
import software.amazon.cryptography.dbesdk.testserver.model.WriteItemInput;
import software.amazon.cryptography.dbesdk.testserver.model.WriteItemOutput;

/**
 * The create&rarr;write&rarr;read round-trip Test_Suite class (Component 6 of the design; task 4.4).
 * This single example is the framework's headline deliverable: it proves that an item written
 * through a configured DB-ESDK Enhanced_Client comes back attribute-for-attribute identical after
 * encryption, storage in the DynamoDB_Backend, and decryption (Reqs 7.2, 7.3).
 *
 * <p>The whole exchange runs through the smithy-java GENERATED {@link
 * software.amazon.cryptography.dbesdk.testserver.client.TestServerClient} inherited from {@link
 * AbstractTestServerTest}, so the wire contract is exactly the one produced from the shared
 * Smithy_Model — the test defines no request/response shapes of its own (Req 8.1). The sequence is:
 *
 * <ol>
 *   <li>{@code CreateClient} &rarr; obtain a {@code ClientId} bound to a configured Enhanced_Client;
 *   <li>{@code WriteItem} with that {@code ClientId}, the physical table name, and a plaintext item
 *       (partition key + several encrypted-and-signed attributes of differing types);
 *   <li>{@code ReadItem} with the <em>same</em> {@code ClientId} and the item's primary key;
 *   <li>assert {@code found == true} and that the returned plaintext item equals the written item,
 *       attribute-for-attribute (Req 7.3).
 * </ol>
 *
 * <h2>How the physical table is provisioned</h2>
 *
 * <p>The Java_Server writes and reads against a real DynamoDB_Backend (DynamoDB Local) through the
 * AWS SDK Enhanced Client, which does <em>not</em> create tables. So this suite provisions the
 * physical table itself in {@link #createTable()} using an AWS SDK v2 {@link DynamoDbClient} pointed
 * at the same backend the server uses ({@link TestServerEndpointConfig#requireDdbEndpoint()} /
 * {@link TestServerEndpointConfig#ddbRegion()}), with the exact key schema the {@code CreateClient}
 * configuration declares (partition key {@link #PARTITION_KEY_NAME}, string-typed, no sort key). The
 * table is deleted in {@link #deleteTable()} so {@code make test-java} works against a fresh
 * DynamoDB Local. This assumes the configured DynamoDB_Backend endpoint is the same instance the
 * server is configured to use — which is the framework's documented test-environment contract
 * (design &sect; Test environment). The AWS SDK v2 {@code dynamodb} dependency is already on the
 * module's {@code implementation} classpath (it backs the server), so it is visible to the test
 * source set without an extra {@code testImplementation} entry.
 *
 * <h2>"Fails open" — no defensive error handling around the operations</h2>
 *
 * <p>The three operations under test are issued with no surrounding try/catch. If the Java_Server is
 * unreachable, the configuration is rejected, or the backend misbehaves, the generated client
 * throws and JUnit records a failure — a broken round-trip can never be read as a pass (Reqs 7.5,
 * 8.5). The only {@code catch} in this class is in table teardown setup, where it merely makes the
 * fixture idempotent and never touches the operations being asserted.
 */
@DisplayName("create -> write -> read returns an attribute-for-attribute equal item (Reqs 7.2, 7.3)")
final class RoundTripTest extends AbstractTestServerTest {

  /**
   * Runtime-configuration key for the AWS KMS key id used to build the CreateClient keyring config.
   * Resolved as a JVM system property first, then this environment variable, and never hard-coded so
   * the (account-specific, sensitive) key stays out of source, exactly like the endpoint
   * configuration (Reqs 8.3, 8.4). Matches the key used by {@code CreateClientTest}.
   */
  static final String KMS_KEY_ID_PROPERTY = "testserver.kms.key.id";

  static final String KMS_KEY_ID_ENV = "TEST_SERVER_KMS_KEY_ID";

  /** Physical table name; this is both the {@code CreateClient} config map key and the table we use. */
  private static final String TABLE_NAME = DemoResources.ROUND_TRIP_TABLE_NAME;

  /** Partition key attribute name; signed (not encrypted) as the Enhanced_Client requires of key attributes. */
  private static final String PARTITION_KEY_NAME = DemoResources.ROUND_TRIP_PARTITION_KEY_NAME;

  /** A specific partition-key value for the single round-trip item. */
  private static final String PARTITION_KEY_VALUE = "pk-roundtrip-001";

  // Encrypted-and-signed attribute names, chosen to exercise several AttributeValue variants.
  private static final String ATTR_STRING = "sensitive_string";
  private static final String ATTR_NUMBER = "sensitive_number";
  private static final String ATTR_BINARY = "sensitive_binary";

  /** A signed-only (not encrypted) non-key attribute, to exercise a mixed action set. */
  private static final String ATTR_FLAG = "a_flag";

  /** AWS SDK v2 client used only to provision/clean up the physical table the server reads/writes. */
  private static DynamoDbClient ddb;

  @BeforeAll
  static void createTable() {
    // Real AWS DynamoDB: region from the demo resources, default credential chain. A configured
    // DynamoDB endpoint (e.g. DynamoDB Local) is still honored as an override, with dummy creds.
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

    // The table is a hard-coded, persistent demo resource (pre-created via the AWS CLI). Ensure it
    // exists, creating it only if missing, and do NOT delete it afterward. This fixture setup never
    // wraps an operation under test, so it cannot turn a failed round-trip into a pass.
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
  static void closeClient() {
    if (ddb != null) {
      ddb.close();
    }
  }

  @Test
  @DisplayName("written item is returned attribute-for-attribute equal after encrypt + decrypt")
  void writeThenReadReturnsEqualItem() {
    // (1) Create a configured client and capture its ClientId.
    final CreateClientOutput created = client.createClient(createClientInput(resolveKmsKeyId()));
    final String clientId = created.getClientId();
    assertNotNull(clientId, "CreateClient must return a ClientId");
    assertTrue(!clientId.isEmpty(), "CreateClient ClientId must be non-empty");

    // (2) Write a plaintext item (partition key + several encrypted/signed attributes).
    final Map<String, AttributeValue> writtenItem = roundTripItem();
    final WriteItemOutput writeOutput =
        client.writeItem(
            WriteItemInput.builder()
                .clientId(clientId)
                .tableName(TABLE_NAME)
                .item(writtenItem)
                .build());
    assertTrue(writeOutput.isCompleted(), "WriteItem must report completion (Req 5.1)");

    // (3) Read it back with the SAME ClientId and the item's primary key.
    final ReadItemOutput readOutput =
        client.readItem(
            ReadItemInput.builder()
                .clientId(clientId)
                .tableName(TABLE_NAME)
                .key(primaryKey())
                .build());

    // (4) Assert it was found and is attribute-for-attribute equal to what we wrote (Reqs 7.2, 7.3).
    assertTrue(readOutput.isFound(), "ReadItem must find the item just written (Req 7.2)");
    assertItemsEqual(writtenItem, readOutput.getItem());
  }

  /**
   * The single round-trip item: the signed partition key, three encrypted-and-signed attributes of
   * differing types (string, number-as-string, binary), and one signed-only boolean. Number values
   * are integers to avoid DynamoDB's numeric normalization (e.g. trailing-zero trimming) confusing
   * the string comparison of {@code N} values.
   */
  private static Map<String, AttributeValue> roundTripItem() {
    final Map<String, AttributeValue> item = new LinkedHashMap<>();
    item.put(PARTITION_KEY_NAME, AttributeValue.builder().s(PARTITION_KEY_VALUE).build());
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
  private static Map<String, AttributeValue> primaryKey() {
    final Map<String, AttributeValue> key = new LinkedHashMap<>();
    key.put(PARTITION_KEY_NAME, AttributeValue.builder().s(PARTITION_KEY_VALUE).build());
    return key;
  }

  /**
   * Builds a {@link CreateClientInput} whose attribute actions cover <em>every</em> attribute in
   * {@link #roundTripItem()}: the partition key is {@code SIGN_ONLY} (the Enhanced_Client requires
   * key attributes to be signed, not encrypted), the three sensitive attributes are {@code
   * ENCRYPT_AND_SIGN} so encryption is actually exercised, and the flag is {@code SIGN_ONLY}. The
   * config uses a KMS keyring, mirroring {@code CreateClientTest}.
   */
  private static CreateClientInput createClientInput(final String kmsKeyId) {
    final Map<String, CryptoAction> attributeActions = new LinkedHashMap<>();
    attributeActions.put(PARTITION_KEY_NAME, CryptoAction.SIGN_ONLY);
    attributeActions.put(ATTR_STRING, CryptoAction.ENCRYPT_AND_SIGN);
    attributeActions.put(ATTR_NUMBER, CryptoAction.ENCRYPT_AND_SIGN);
    attributeActions.put(ATTR_BINARY, CryptoAction.ENCRYPT_AND_SIGN);
    attributeActions.put(ATTR_FLAG, CryptoAction.SIGN_ONLY);

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
   * Asserts the read item equals the written item attribute-for-attribute (Req 7.3): every written
   * attribute is present with an equal value, and there are no extra attributes. Missing, extra, or
   * differing attributes each fail the test.
   *
   * <p>The attribute-name sets are compared first so a missing or extra attribute fails with a clear
   * message; then each value is compared with {@link #assertAttributeEquals} for a precise per-name,
   * per-variant diagnosis.
   */
  private static void assertItemsEqual(
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

  /**
   * Compares one attribute value for equality, variant by variant. The two values must be the same
   * union variant, then:
   *
   * <ul>
   *   <li><b>S</b> — string equality.
   *   <li><b>N</b> — string equality of the DynamoDB number-as-string representation.
   *   <li><b>B</b> — byte-content equality, comparing a non-destructive copy of each {@link
   *       ByteBuffer} (positions are not assumed to be 0).
   *   <li><b>BOOL</b> / <b>NULL</b> — boolean equality.
   *   <li><b>SS</b> / <b>NS</b> — as unordered sets (DynamoDB string/number sets have no order).
   *   <li><b>BS</b> — as an unordered set of byte contents.
   *   <li><b>M</b> — recursively, attribute-for-attribute.
   *   <li><b>L</b> — element-by-element, in order.
   * </ul>
   */
  private static void assertAttributeEquals(
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
  private static List<Byte> bytesOf(final ByteBuffer buffer) {
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
  private static Set<List<Byte>> byteContentSet(final List<ByteBuffer> buffers) {
    final Set<List<Byte>> out = new LinkedHashSet<>();
    for (final ByteBuffer b : buffers) {
      out.add(bytesOf(b));
    }
    return out;
  }

  /**
   * Resolves the KMS key id, defaulting to the hard-coded demo key ({@link DemoResources#KMS_KEY_ID})
   * while still honoring a system-property / environment-variable override so the same test can
   * target a different account's key without editing source.
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
