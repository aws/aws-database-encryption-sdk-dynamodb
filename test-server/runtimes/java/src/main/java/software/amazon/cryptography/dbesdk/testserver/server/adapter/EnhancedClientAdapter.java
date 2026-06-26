// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server.adapter;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.mapper.StaticTableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClientBuilder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.kms.KmsClientBuilder;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.CreateDynamoDbEncryptionInterceptorInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedClientEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedTableEncryptionConfig;
import software.amazon.cryptography.dbesdk.testserver.server.EnhancedClientHandle;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CacheType;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsDiscoveryKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsDiscoveryMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsEcdhKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkDiscoveryKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkDiscoveryMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsRsaKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateRawAesKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateRawEcdhKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateRawRsaKeyringInput;
import software.amazon.cryptography.materialproviders.model.DefaultCache;
import software.amazon.cryptography.materialproviders.model.DiscoveryFilter;
import software.amazon.cryptography.materialproviders.model.KmsEcdhStaticConfigurations;
import software.amazon.cryptography.materialproviders.model.KmsPrivateKeyToStaticPublicKeyInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.materialproviders.model.RawEcdhStaticConfigurations;
import software.amazon.cryptography.materialproviders.model.RawPrivateKeyToStaticPublicKeyInput;

/**
 * Translates a {@code CreateClient} configuration into a configured DB-ESDK DynamoDB Enhanced
 * Client and exposes the encrypted put/get operations the server's write/read handlers need.
 *
 * <p>This is the {@code Enhanced_Client adapter} component of the design (Component 5). It is a
 * self-contained {@link EnhancedClientHandle}: the {@link
 * software.amazon.cryptography.dbesdk.testserver.server.ClientRegistry} stores it behind that
 * interface, and the {@code createClient} handler (task 2.3) constructs one via {@link
 * #build(CreateClientConfig)} and registers it.
 *
 * <h2>Construction flow (mirrors {@code EnhancedPutGetExample})</h2>
 *
 * <ol>
 *   <li>Build the configured keyring (Raw AES, Raw RSA, AWS KMS, AWS KMS MRK, AWS KMS MRK multi,
 *       or a recursive multi-keyring) from the per-table {@code KeyringConfigValue} via the
 *       Material Providers Library.
 *   <li>Build a server-controlled {@link StaticTableSchema} per table whose DB-ESDK-derived crypto
 *       actions equal the configured {@code attributeActionsOnEncrypt} ({@link
 *       GenericItemTableSchemas}).
 *   <li>Build a {@link DynamoDbEnhancedTableEncryptionConfig} per table (logical name, keyring,
 *       schema, allowed-unsigned settings, algorithm suite, plaintext override).
 *   <li>Create the {@link DynamoDbEncryptionInterceptor} via {@link
 *       DynamoDbEnhancedClientEncryption#CreateDynamoDbEncryptionInterceptor}.
 *   <li>Attach the interceptor to a {@link DynamoDbClient} pointed at the configurable
 *       DynamoDB_Backend and configured with the backend timeout (default 5s, Req 5.5).
 *   <li>Build a {@link DynamoDbEnhancedClient} and a {@link DynamoDbTable} per configured table.
 * </ol>
 *
 * <h2>Public surface (for tasks 2.1 / 2.3 / 4.1 / 4.2)</h2>
 *
 * <ul>
 *   <li>{@link #build(CreateClientConfig)} — construct the adapter from config. Any DB-ESDK / SDK
 *       exception (e.g. a configuration the Enhanced Client rejects) propagates to the caller so the
 *       {@code createClient} handler can surface it as {@code DBESDKClientError} (Req 4.6). Nothing
 *       is registered when this throws.
 *   <li>{@link #putItem(String, Map)} / {@link #getItem(String, Map)} (from {@link
 *       EnhancedClientHandle}) — encrypted write / read using a generic attribute-map item
 *       representation. DB-ESDK encrypt/decrypt exceptions and backend failures propagate; the
 *       write/read handlers (4.1, 4.2) classify them into {@code DBESDKClientError} /
 *       {@code GenericServerError}.
 * </ul>
 *
 * <p>Instances are effectively immutable after construction and safe to share across threads (the
 * AWS SDK enhanced client and DynamoDB client are thread-safe), satisfying the stable-resolution
 * expectation of the registry (Req 4.3).
 */
public final class EnhancedClientAdapter implements EnhancedClientHandle {

  private final DynamoDbEnhancedClient enhancedClient;
  private final Map<String, DynamoDbTable<AttributeMapItem>> tablesByName;
  // Per physical table: the partition key name and (optional) sort key name, used to build the
  // enhanced-client Key for getItem from a generic key map.
  private final Map<String, String> partitionKeyNamesByTable;
  private final Map<String, String> sortKeyNamesByTable;

  private EnhancedClientAdapter(
      final DynamoDbEnhancedClient enhancedClient,
      final Map<String, DynamoDbTable<AttributeMapItem>> tablesByName,
      final Map<String, String> partitionKeyNamesByTable,
      final Map<String, String> sortKeyNamesByTable) {
    this.enhancedClient = enhancedClient;
    this.tablesByName = tablesByName;
    this.partitionKeyNamesByTable = partitionKeyNamesByTable;
    this.sortKeyNamesByTable = sortKeyNamesByTable;
  }

  /**
   * Builds a configured Enhanced Client adapter from the supplied configuration.
   *
   * @param config the per-table encryption configuration plus backend wiring
   * @return a ready-to-use adapter
   * @throws RuntimeException any exception thrown by the DB-ESDK / Material Providers / AWS SDK
   *     while building the keyring, interceptor, or clients (for example a configuration the
   *     Enhanced Client rejects). The caller is responsible for classifying it.
   */
  public static EnhancedClientAdapter build(final CreateClientConfig config) {
    Objects.requireNonNull(config, "config must not be null");

    final MaterialProviders materialProviders =
        MaterialProviders.builder()
            .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
            .build();

    // Build one DynamoDbEnhancedTableEncryptionConfig per configured table, and remember each
    // table's key names and schema for later put/get.
    final Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
    final Map<String, StaticTableSchema<AttributeMapItem>> schemasByName = new HashMap<>();
    final Map<String, String> partitionKeyNames = new HashMap<>();
    final Map<String, String> sortKeyNames = new HashMap<>();

    for (final Map.Entry<String, TableEncryptionConfigValue> entry :
        config.tableEncryptionConfigs().entrySet()) {
      final String physicalTableName = entry.getKey();
      final TableEncryptionConfigValue tableConfig = entry.getValue();

      final IKeyring keyring =
          buildKeyring(materialProviders, tableConfig.keyring(), config.backendConfig().region());
      final StaticTableSchema<AttributeMapItem> schema =
          GenericItemTableSchemas.buildSchema(tableConfig);

      tableConfigs.put(
          physicalTableName, buildTableEncryptionConfig(tableConfig, keyring, schema));
      schemasByName.put(physicalTableName, schema);
      partitionKeyNames.put(physicalTableName, tableConfig.partitionKeyName());
      if (tableConfig.sortKeyName() != null && !tableConfig.sortKeyName().isEmpty()) {
        sortKeyNames.put(physicalTableName, tableConfig.sortKeyName());
      }
    }

    // Create the DynamoDb Encryption Interceptor over all configured tables.
    final DynamoDbEncryptionInterceptor interceptor =
        DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
            CreateDynamoDbEncryptionInterceptorInput.builder()
                .tableEncryptionConfigs(tableConfigs)
                .build());

    // Build the DynamoDb client pointed at the configurable backend, with the timeout applied.
    final DynamoDbClient ddb = buildDynamoDbClient(config.backendConfig(), interceptor);

    final DynamoDbEnhancedClient enhancedClient =
        DynamoDbEnhancedClient.builder().dynamoDbClient(ddb).build();

    final Map<String, DynamoDbTable<AttributeMapItem>> tables = new HashMap<>();
    for (final Map.Entry<String, StaticTableSchema<AttributeMapItem>> entry :
        schemasByName.entrySet()) {
      tables.put(entry.getKey(), enhancedClient.table(entry.getKey(), entry.getValue()));
    }

    return new EnhancedClientAdapter(
        enhancedClient,
        Collections.unmodifiableMap(tables),
        Collections.unmodifiableMap(partitionKeyNames),
        Collections.unmodifiableMap(sortKeyNames));
  }

  @Override
  public void putItem(final String tableName, final Map<String, AttributeValue> item) {
    final DynamoDbTable<AttributeMapItem> table = tableFor(tableName);
    table.putItem(new AttributeMapItem(item));
  }

  @Override
  public Optional<Map<String, AttributeValue>> getItem(
      final String tableName, final Map<String, AttributeValue> key) {
    final DynamoDbTable<AttributeMapItem> table = tableFor(tableName);
    final AttributeMapItem result = table.getItem(toEnhancedKey(tableName, key));
    if (result == null) {
      return Optional.empty();
    }
    // Copy into a plain map so callers are insulated from the AttributeMapItem subtype.
    return Optional.of(new LinkedHashMap<>(result));
  }

  // --- construction helpers -------------------------------------------------------------------

  private static IKeyring buildKeyring(
      final MaterialProviders materialProviders,
      final KeyringConfigValue keyringConfig,
      final String region) {
    if (keyringConfig == null) {
      throw new IllegalArgumentException(
          "A keyring configuration is required (exactly one keyring kind must be set).");
    }
    return switch (keyringConfig) {
      case KeyringConfigValue.RawAes raw ->
          materialProviders.CreateRawAesKeyring(
              CreateRawAesKeyringInput.builder()
                  .keyNamespace(raw.keyNamespace())
                  .keyName(raw.keyName())
                  .wrappingKey(raw.wrappingKey())
                  .wrappingAlg(raw.wrappingAlg())
                  .build());
      case KeyringConfigValue.RawRsa raw -> {
        final CreateRawRsaKeyringInput.Builder builder =
            CreateRawRsaKeyringInput.builder()
                .keyNamespace(raw.keyNamespace())
                .keyName(raw.keyName())
                .paddingScheme(raw.paddingScheme());
        if (raw.publicKey() != null) {
          builder.publicKey(raw.publicKey());
        }
        if (raw.privateKey() != null) {
          builder.privateKey(raw.privateKey());
        }
        yield materialProviders.CreateRawRsaKeyring(builder.build());
      }
      case KeyringConfigValue.AwsKms kms -> {
        final CreateAwsKmsKeyringInput.Builder builder =
            CreateAwsKmsKeyringInput.builder()
                .kmsKeyId(kms.kmsKeyId())
                .kmsClient(buildKmsClient(region));
        if (kms.grantTokens() != null && !kms.grantTokens().isEmpty()) {
          builder.grantTokens(kms.grantTokens());
        }
        yield materialProviders.CreateAwsKmsKeyring(builder.build());
      }
      case KeyringConfigValue.AwsKmsMrk mrk -> {
        final CreateAwsKmsMrkKeyringInput.Builder builder =
            CreateAwsKmsMrkKeyringInput.builder()
                .kmsKeyId(mrk.kmsKeyId())
                .kmsClient(buildKmsClient(region));
        if (mrk.grantTokens() != null && !mrk.grantTokens().isEmpty()) {
          builder.grantTokens(mrk.grantTokens());
        }
        yield materialProviders.CreateAwsKmsMrkKeyring(builder.build());
      }
      case KeyringConfigValue.AwsKmsMrkMulti multi -> {
        // CreateAwsKmsMrkMultiKeyring correctly handles both single-Region and Multi-Region KMS
        // keys and builds its own KMS clients, matching EnhancedPutGetExample.
        final CreateAwsKmsMrkMultiKeyringInput.Builder builder =
            CreateAwsKmsMrkMultiKeyringInput.builder();
        if (multi.generator() != null && !multi.generator().isEmpty()) {
          builder.generator(multi.generator());
        }
        if (multi.kmsKeyIds() != null && !multi.kmsKeyIds().isEmpty()) {
          builder.kmsKeyIds(multi.kmsKeyIds());
        }
        yield materialProviders.CreateAwsKmsMrkMultiKeyring(builder.build());
      }
      case KeyringConfigValue.AwsKmsRsa rsa -> {
        final CreateAwsKmsRsaKeyringInput.Builder builder =
            CreateAwsKmsRsaKeyringInput.builder()
                .kmsKeyId(rsa.kmsKeyId())
                .encryptionAlgorithm(rsa.encryptionAlgorithm())
                .kmsClient(buildKmsClient(region));
        if (rsa.publicKey() != null) {
          builder.publicKey(rsa.publicKey());
        }
        yield materialProviders.CreateAwsKmsRsaKeyring(builder.build());
      }
      case KeyringConfigValue.AwsKmsEcdh ecdh -> {
        final KmsEcdhStaticConfigurations scheme =
            KmsEcdhStaticConfigurations.builder()
                .KmsPrivateKeyToStaticPublicKey(
                    KmsPrivateKeyToStaticPublicKeyInput.builder()
                        .senderKmsIdentifier(ecdh.senderKmsIdentifier())
                        .recipientPublicKey(ecdh.recipientPublicKey())
                        .build())
                .build();
        yield materialProviders.CreateAwsKmsEcdhKeyring(
            CreateAwsKmsEcdhKeyringInput.builder()
                .curveSpec(ecdh.curveSpec())
                .KeyAgreementScheme(scheme)
                .kmsClient(buildKmsClient(region))
                .build());
      }
      case KeyringConfigValue.RawEcdh ecdh -> {
        final RawEcdhStaticConfigurations scheme =
            RawEcdhStaticConfigurations.builder()
                .RawPrivateKeyToStaticPublicKey(
                    RawPrivateKeyToStaticPublicKeyInput.builder()
                        .senderStaticPrivateKey(ecdh.senderStaticPrivateKey())
                        .recipientPublicKey(ecdh.recipientPublicKey())
                        .build())
                .build();
        yield materialProviders.CreateRawEcdhKeyring(
            CreateRawEcdhKeyringInput.builder()
                .curveSpec(ecdh.curveSpec())
                .KeyAgreementScheme(scheme)
                .build());
      }
      case KeyringConfigValue.Hierarchical hier -> {
        final KeyStore keyStore =
            KeyStore.builder()
                .KeyStoreConfig(
                    KeyStoreConfig.builder()
                        .ddbClient(buildPlainDynamoDbClient(region))
                        .ddbTableName(hier.keyStoreTableName())
                        .logicalKeyStoreName(hier.logicalKeyStoreName())
                        .kmsClient(buildKmsClient(region))
                        .kmsConfiguration(
                            KMSConfiguration.builder().kmsKeyArn(hier.kmsKeyArn()).build())
                        .build())
                .build();
        final CreateAwsKmsHierarchicalKeyringInput.Builder builder =
            CreateAwsKmsHierarchicalKeyringInput.builder()
                .keyStore(keyStore)
                .branchKeyId(hier.branchKeyId())
                .ttlSeconds(hier.ttlSeconds());
        if (hier.cacheEntryCapacity() != null) {
          builder.cache(
              CacheType.builder()
                  .Default(DefaultCache.builder().entryCapacity(hier.cacheEntryCapacity()).build())
                  .build());
        }
        yield materialProviders.CreateAwsKmsHierarchicalKeyring(builder.build());
      }
      case KeyringConfigValue.AwsKmsDiscovery disc -> {
        final CreateAwsKmsDiscoveryKeyringInput.Builder builder =
            CreateAwsKmsDiscoveryKeyringInput.builder().kmsClient(buildKmsClient(region));
        final DiscoveryFilter filter = discoveryFilterOf(disc.accountId(), disc.partition());
        if (filter != null) {
          builder.discoveryFilter(filter);
        }
        yield materialProviders.CreateAwsKmsDiscoveryKeyring(builder.build());
      }
      case KeyringConfigValue.AwsKmsMrkDiscovery disc -> {
        final CreateAwsKmsMrkDiscoveryKeyringInput.Builder builder =
            CreateAwsKmsMrkDiscoveryKeyringInput.builder()
                .kmsClient(buildKmsClient(disc.region()))
                .region(disc.region());
        final DiscoveryFilter filter = discoveryFilterOf(disc.accountId(), disc.partition());
        if (filter != null) {
          builder.discoveryFilter(filter);
        }
        yield materialProviders.CreateAwsKmsMrkDiscoveryKeyring(builder.build());
      }
      case KeyringConfigValue.AwsKmsDiscoveryMulti disc -> {
        final CreateAwsKmsDiscoveryMultiKeyringInput.Builder builder =
            CreateAwsKmsDiscoveryMultiKeyringInput.builder().regions(disc.regions());
        final DiscoveryFilter filter = discoveryFilterOf(disc.accountId(), disc.partition());
        if (filter != null) {
          builder.discoveryFilter(filter);
        }
        yield materialProviders.CreateAwsKmsDiscoveryMultiKeyring(builder.build());
      }
      case KeyringConfigValue.AwsKmsMrkDiscoveryMulti disc -> {
        final CreateAwsKmsMrkDiscoveryMultiKeyringInput.Builder builder =
            CreateAwsKmsMrkDiscoveryMultiKeyringInput.builder().regions(disc.regions());
        final DiscoveryFilter filter = discoveryFilterOf(disc.accountId(), disc.partition());
        if (filter != null) {
          builder.discoveryFilter(filter);
        }
        yield materialProviders.CreateAwsKmsMrkDiscoveryMultiKeyring(builder.build());
      }
      case KeyringConfigValue.Multi multi -> {
        final CreateMultiKeyringInput.Builder builder = CreateMultiKeyringInput.builder();
        if (multi.generator() != null) {
          builder.generator(buildKeyring(materialProviders, multi.generator(), region));
        }
        final List<IKeyring> children = new ArrayList<>();
        if (multi.childKeyrings() != null) {
          for (final KeyringConfigValue child : multi.childKeyrings()) {
            children.add(buildKeyring(materialProviders, child, region));
          }
        }
        builder.childKeyrings(children);
        yield materialProviders.CreateMultiKeyring(builder.build());
      }
    };
  }

  /**
   * Builds a {@link KmsClient} for the KMS-backed keyrings that require one ({@code
   * CreateAwsKmsKeyring} / {@code CreateAwsKmsMrkKeyring}). The region is sourced from the
   * server-side {@link BackendConfig} (the same region the backend is configured for); when it is
   * absent the SDK's default region resolution chain applies.
   */
  private static KmsClient buildKmsClient(final String region) {
    final KmsClientBuilder builder = KmsClient.builder();
    if (region != null && !region.isEmpty()) {
      builder.region(Region.of(region));
    }
    return builder.build();
  }

  /**
   * Builds a plain {@link DynamoDbClient} (no encryption interceptor) for the region, used as the
   * key store's backing client by the Hierarchical keyring. The key store table is a control-plane
   * resource separate from the encrypted round-trip table, so it needs an unintercepted client.
   */
  private static DynamoDbClient buildPlainDynamoDbClient(final String region) {
    final DynamoDbClientBuilder builder = DynamoDbClient.builder();
    if (region != null && !region.isEmpty()) {
      builder.region(Region.of(region));
    }
    return builder.build();
  }

  /**
   * Builds a {@link DiscoveryFilter} when an account id is supplied, defaulting the partition to
   * {@code "aws"}. Returns {@code null} when no account id is present, so the discovery keyring is
   * built without a filter (it may then decrypt with any KMS key it has access to).
   */
  private static DiscoveryFilter discoveryFilterOf(final String accountId, final String partition) {
    if (accountId == null || accountId.isEmpty()) {
      return null;
    }
    return DiscoveryFilter.builder()
        .accountIds(List.of(accountId))
        .partition((partition == null || partition.isEmpty()) ? "aws" : partition)
        .build();
  }

  private static DynamoDbEnhancedTableEncryptionConfig buildTableEncryptionConfig(
      final TableEncryptionConfigValue tableConfig,
      final IKeyring keyring,
      final StaticTableSchema<AttributeMapItem> schema) {
    final DynamoDbEnhancedTableEncryptionConfig.Builder builder =
        DynamoDbEnhancedTableEncryptionConfig.builder()
            .logicalTableName(tableConfig.logicalTableName())
            .keyring(keyring)
            .schemaOnEncrypt(schema);

    if (tableConfig.allowedUnsignedAttributes() != null) {
      builder.allowedUnsignedAttributes(tableConfig.allowedUnsignedAttributes());
    }
    if (tableConfig.allowedUnsignedAttributePrefix() != null) {
      builder.allowedUnsignedAttributePrefix(tableConfig.allowedUnsignedAttributePrefix());
    }
    if (tableConfig.algorithmSuiteId() != null) {
      builder.algorithmSuiteId(tableConfig.algorithmSuiteId());
    }
    if (tableConfig.plaintextOverride() != null) {
      builder.plaintextOverride(tableConfig.plaintextOverride());
    }
    return builder.build();
  }

  private static DynamoDbClient buildDynamoDbClient(
      final BackendConfig backend, final DynamoDbEncryptionInterceptor interceptor) {
    // Apply the configurable backend timeout (default 5s) at the client configuration layer so it
    // covers both writes and reads uniformly (Req 5.5).
    final ClientOverrideConfiguration overrideConfig =
        ClientOverrideConfiguration.builder()
            .addExecutionInterceptor(interceptor)
            .apiCallTimeout(backend.timeout())
            .apiCallAttemptTimeout(backend.timeout())
            .build();

    final DynamoDbClientBuilder builder =
        DynamoDbClient.builder().overrideConfiguration(overrideConfig);

    if (backend.endpointOverride() != null && !backend.endpointOverride().isEmpty()) {
      builder.endpointOverride(URI.create(backend.endpointOverride()));
    }
    if (backend.region() != null && !backend.region().isEmpty()) {
      builder.region(Region.of(backend.region()));
    }
    if (backend.credentialsProvider() != null) {
      builder.credentialsProvider(backend.credentialsProvider());
    } else if (backend.endpointOverride() != null && !backend.endpointOverride().isEmpty()) {
      // DynamoDB Local ignores credentials but the SDK still requires some to sign requests.
      builder.credentialsProvider(
          StaticCredentialsProvider.create(AwsBasicCredentials.create("dummy", "dummy")));
    }
    return builder.build();
  }

  // --- operation helpers ----------------------------------------------------------------------

  private DynamoDbTable<AttributeMapItem> tableFor(final String tableName) {
    final DynamoDbTable<AttributeMapItem> table = tablesByName.get(tableName);
    if (table == null) {
      throw new IllegalArgumentException(
          "No Enhanced Client table is configured for table name '" + tableName + "'.");
    }
    return table;
  }

  private Key toEnhancedKey(final String tableName, final Map<String, AttributeValue> key) {
    final String partitionKeyName = partitionKeyNamesByTable.get(tableName);
    final AttributeValue partitionValue = key.get(partitionKeyName);
    if (partitionValue == null) {
      throw new IllegalArgumentException(
          "Key for table '" + tableName + "' is missing partition key '" + partitionKeyName + "'.");
    }
    final Key.Builder keyBuilder = Key.builder().partitionValue(partitionValue);

    final String sortKeyName = sortKeyNamesByTable.get(tableName);
    if (sortKeyName != null) {
      final AttributeValue sortValue = key.get(sortKeyName);
      if (sortValue != null) {
        keyBuilder.sortValue(sortValue);
      }
    }
    return keyBuilder.build();
  }
}
