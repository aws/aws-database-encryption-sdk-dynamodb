// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server.handlers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsDiscoveryKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsDiscoveryMultiKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsEcdhKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsMrkDiscoveryKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsMrkDiscoveryMultiKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsMrkKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsMrkMultiKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.AwsKmsRsaKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.CreateClientInput;
import software.amazon.cryptography.dbesdk.testserver.model.CreateClientOutput;
import software.amazon.cryptography.dbesdk.testserver.model.DBESDKClientError;
import software.amazon.cryptography.dbesdk.testserver.model.GenericServerError;
import software.amazon.cryptography.dbesdk.testserver.model.HierarchicalKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.KeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.MultiKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.RawAesKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.RawEcdhKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.RawRsaKeyringConfig;
import software.amazon.cryptography.dbesdk.testserver.model.TableEncryptionConfig;
import software.amazon.cryptography.dbesdk.testserver.server.ClientRegistry;
import software.amazon.cryptography.dbesdk.testserver.server.EnhancedClientHandle;
import software.amazon.cryptography.dbesdk.testserver.server.adapter.BackendConfig;
import software.amazon.cryptography.dbesdk.testserver.server.adapter.CreateClientConfig;
import software.amazon.cryptography.dbesdk.testserver.server.adapter.EnhancedClientAdapter;
import software.amazon.cryptography.dbesdk.testserver.server.adapter.KeyringConfigValue;
import software.amazon.cryptography.dbesdk.testserver.server.adapter.TableEncryptionConfigValue;
import software.amazon.cryptography.dbesdk.testserver.service.CreateClientOperation;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Handler for the {@code CreateClient} operation (Reqs 4.1, 4.6, 4.7).
 *
 * <p>This is the {@code createClient} operation handler of the design's Java_Server component. It is
 * self-contained: it implements the smithy-java generated {@link CreateClientOperation} functional
 * interface, so task 2.4 (the transport entry point / {@code main()}) can register it directly on
 * the generated service builder without this class taking any dependency on the transport.
 *
 * <h2>Behavior</h2>
 *
 * <ol>
 *   <li><b>Accepted config (Req 4.1):</b> translate the generated {@link CreateClientInput} into the
 *       adapter's {@link CreateClientConfig}, construct exactly one {@link EnhancedClientAdapter},
 *       store exactly one entry in the {@link ClientRegistry}, and return exactly one {@code
 *       ClientId}.
 *   <li><b>Config rejected by the Enhanced Client (Req 4.6):</b> any exception thrown while
 *       translating the config or building the Enhanced Client (for example a configuration the
 *       Enhanced Client rejects, such as a missing keyring or an invalid KMS key) is caught and
 *       surfaced as {@link DBESDKClientError} carrying a human-readable message. Nothing is stored
 *       and no {@code ClientId} is returned.
 *   <li><b>Construction succeeds but storage fails (Req 4.7):</b> if registry storage fails, the
 *       constructed client is discarded (no reference is kept), {@link GenericServerError} is
 *       returned, and the registry is left unchanged with no {@code ClientId} returned. The
 *       registry's {@code register} is atomic — it either stores the entry and returns its id or
 *       stores nothing — so there is never a dangling client to clean up; this handler additionally
 *       treats a null/empty returned id defensively as a storage failure.
 * </ol>
 *
 * <h2>Error-mapping boundary</h2>
 *
 * The "build a client from this config" step (input translation + {@link
 * EnhancedClientAdapter#build}) is treated as the Enhanced-Client construction boundary and mapped
 * to {@link DBESDKClientError}. Only a failure in {@link ClientRegistry#register} — a
 * framework/server-side concern — is mapped to {@link GenericServerError}. This mirrors the design's
 * Error Handling table.
 *
 * <h2>Backend wiring (note for task 2.4)</h2>
 *
 * The DynamoDB_Backend endpoint/region/timeout/credentials are server-side wiring, not part of the
 * per-request {@code CreateClient} configuration, so they are injected once via {@link
 * BackendConfig} at construction time. Task 2.4 should build a single process-wide {@link
 * BackendConfig} from the server configuration and construct one {@code CreateClientHandler} with
 * the shared {@link ClientRegistry}, then register it on the generated service builder:
 *
 * <pre>{@code
 * ClientRegistry registry = new ClientRegistry();
 * BackendConfig backend = BackendConfig.builder()
 *     .endpointOverride(serverConfig.dynamoDbEndpoint())   // e.g. http://localhost:8000
 *     .region(serverConfig.region())
 *     .timeout(serverConfig.backendTimeout())              // default 5s if null
 *     .build();
 * CreateClientHandler createClient = new CreateClientHandler(registry, backend);
 *
 * TestServer service = TestServer.builder()
 *     .addCreateClientOperation(createClient)              // CreateClientOperation
 *     .addReadItemOperation(readItemHandler)               // task 4.2
 *     .addWriteItemOperation(writeItemHandler)             // task 4.1
 *     .build();
 * }</pre>
 *
 * The write/read handlers (tasks 4.1/4.2) resolve a {@code ClientId} against the same {@link
 * ClientRegistry} this handler populates.
 */
public final class CreateClientHandler implements CreateClientOperation {

  /**
   * Constructs an {@link EnhancedClientHandle} from a translated {@link CreateClientConfig}.
   *
   * <p>Injectable so the construction boundary is explicit and the handler's error-mapping logic
   * does not hard-depend on the concrete adapter. Defaults to {@link EnhancedClientAdapter#build}.
   */
  @FunctionalInterface
  public interface EnhancedClientFactory {
    EnhancedClientHandle build(CreateClientConfig config);
  }

  private final ClientRegistry registry;
  private final BackendConfig backendConfig;
  private final EnhancedClientFactory clientFactory;

  /**
   * Creates a handler that builds Enhanced Clients via {@link EnhancedClientAdapter#build} pointed
   * at the supplied backend.
   *
   * @param registry the shared client registry to store constructed clients in; must not be null
   * @param backendConfig the process-wide DynamoDB_Backend wiring; must not be null
   */
  public CreateClientHandler(final ClientRegistry registry, final BackendConfig backendConfig) {
    this(registry, backendConfig, EnhancedClientAdapter::build);
  }

  /**
   * Creates a handler with an explicit Enhanced Client factory.
   *
   * @param registry the shared client registry to store constructed clients in; must not be null
   * @param backendConfig the process-wide DynamoDB_Backend wiring; must not be null
   * @param clientFactory the factory used to construct an Enhanced Client from a config; must not be
   *     null
   */
  public CreateClientHandler(
      final ClientRegistry registry,
      final BackendConfig backendConfig,
      final EnhancedClientFactory clientFactory) {
    this.registry = Objects.requireNonNull(registry, "registry must not be null");
    this.backendConfig = Objects.requireNonNull(backendConfig, "backendConfig must not be null");
    this.clientFactory = Objects.requireNonNull(clientFactory, "clientFactory must not be null");
  }

  @Override
  public CreateClientOutput createClient(
      final CreateClientInput input, final RequestContext context) {
    // 1. Translate the model input + inject backend, then construct the Enhanced Client. Any
    //    failure in this boundary is a configuration the Enhanced Client rejects (Req 4.6).
    final EnhancedClientHandle handle;
    try {
      final CreateClientConfig config = toConfig(input);
      handle = clientFactory.build(config);
      if (handle == null) {
        // A factory that returns no client without throwing is still a construction failure.
        throw new IllegalStateException("Enhanced Client construction returned no client.");
      }
    } catch (final RuntimeException constructionFailure) {
      // Req 4.6: forward the config failure as DBESDKClientError; store nothing, return no ClientId.
      throw DBESDKClientError.builder()
          .message(
              "The Enhanced Client rejected the CreateClient configuration: "
                  + describe(constructionFailure))
          .withCause(constructionFailure)
          .build();
    }

    // 2. Store exactly one registry entry and return exactly one ClientId (Req 4.1). Registration is
    //    atomic: on failure nothing is stored, so the just-built client is simply discarded by
    //    leaving it unreferenced (Req 4.7).
    final String clientId;
    try {
      clientId = registry.register(handle);
    } catch (final RuntimeException storageFailure) {
      throw GenericServerError.builder()
          .message(
              "Failed to store the constructed Enhanced Client in the client registry: "
                  + describe(storageFailure))
          .withCause(storageFailure)
          .build();
    }

    // Defensive: a missing id means the client was not actually stored. Treat as storage failure
    // (Req 4.7) rather than handing back an unusable ClientId.
    if (clientId == null || clientId.isEmpty()) {
      throw GenericServerError.builder()
          .message("The client registry did not return a valid ClientId for the constructed client.")
          .build();
    }

    return CreateClientOutput.builder().clientId(clientId).build();
  }

  // --- input -> config translation -------------------------------------------------------------

  /**
   * Translates the generated {@link CreateClientInput} into the adapter's {@link
   * CreateClientConfig}, mapping the model's string-valued enums onto the DB-ESDK / Material
   * Providers enum constants and injecting the server-side {@link BackendConfig}.
   */
  private CreateClientConfig toConfig(final CreateClientInput input) {
    final Map<String, TableEncryptionConfig> modelConfigs = input.getTableEncryptionConfigs();
    if (modelConfigs == null || modelConfigs.isEmpty()) {
      throw new IllegalArgumentException(
          "CreateClient requires at least one table encryption configuration.");
    }

    final CreateClientConfig.Builder builder =
        CreateClientConfig.builder().backendConfig(backendConfig);

    for (final Map.Entry<String, TableEncryptionConfig> entry : modelConfigs.entrySet()) {
      builder.putTableEncryptionConfig(entry.getKey(), toTableConfig(entry.getValue()));
    }
    return builder.build();
  }

  private TableEncryptionConfigValue toTableConfig(final TableEncryptionConfig model) {
    final TableEncryptionConfigValue.Builder builder =
        TableEncryptionConfigValue.builder()
            .logicalTableName(model.getLogicalTableName())
            .partitionKeyName(model.getPartitionKeyName())
            .sortKeyName(model.getSortKeyName())
            .attributeActionsOnEncrypt(toCryptoActions(model.getAttributeActionsOnEncrypt()))
            .keyring(toKeyring(model.getLogicalTableName(), model.getKeyring()));

    if (model.hasAllowedUnsignedAttributes()) {
      final List<String> allowed = model.getAllowedUnsignedAttributes();
      if (allowed != null && !allowed.isEmpty()) {
        builder.allowedUnsignedAttributes(allowed);
      }
    }
    if (model.getAllowedUnsignedAttributePrefix() != null) {
      builder.allowedUnsignedAttributePrefix(model.getAllowedUnsignedAttributePrefix());
    }
    if (model.getAlgorithmSuiteId() != null) {
      builder.algorithmSuiteId(
          software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId.valueOf(
              model.getAlgorithmSuiteId().getValue()));
    }
    if (model.getPlaintextOverride() != null) {
      builder.plaintextOverride(
          software.amazon.cryptography.dbencryptionsdk.dynamodb.model.PlaintextOverride.valueOf(
              model.getPlaintextOverride().getValue()));
    }
    return builder.build();
  }

  private static Map<String, software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction>
      toCryptoActions(
          final Map<String, software.amazon.cryptography.dbesdk.testserver.model.CryptoAction>
              modelActions) {
    final Map<String, software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction>
        actions = new LinkedHashMap<>();
    for (final Map.Entry<String, software.amazon.cryptography.dbesdk.testserver.model.CryptoAction>
        entry : modelActions.entrySet()) {
      actions.put(
          entry.getKey(),
          software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction
              .valueOf(entry.getValue().getValue()));
    }
    return actions;
  }

  private static KeyringConfigValue toKeyring(
      final String logicalTableName, final KeyringConfig keyring) {
    if (keyring == null) {
      throw new IllegalArgumentException(
          "Table '" + logicalTableName + "' is missing a keyring configuration.");
    }

    // The model expresses a "tagged union via optional members": exactly one keyring kind must be
    // set. Collect the set members so we can validate the exactly-one rule and produce a clear
    // message otherwise (surfaced as DBESDKClientError by the handler — Req 4.6).
    final RawAesKeyringConfig rawAes = keyring.getRawAes();
    final RawRsaKeyringConfig rawRsa = keyring.getRawRsa();
    final AwsKmsKeyringConfig awsKms = keyring.getAwsKms();
    final AwsKmsMrkKeyringConfig awsKmsMrk = keyring.getAwsKmsMrk();
    final AwsKmsMrkMultiKeyringConfig awsKmsMrkMulti = keyring.getAwsKmsMrkMulti();
    final AwsKmsRsaKeyringConfig awsKmsRsa = keyring.getAwsKmsRsa();
    final AwsKmsEcdhKeyringConfig awsKmsEcdh = keyring.getAwsKmsEcdh();
    final RawEcdhKeyringConfig rawEcdh = keyring.getRawEcdh();
    final HierarchicalKeyringConfig hierarchical = keyring.getHierarchical();
    final AwsKmsDiscoveryKeyringConfig awsKmsDiscovery = keyring.getAwsKmsDiscovery();
    final AwsKmsMrkDiscoveryKeyringConfig awsKmsMrkDiscovery = keyring.getAwsKmsMrkDiscovery();
    final AwsKmsDiscoveryMultiKeyringConfig awsKmsDiscoveryMulti =
        keyring.getAwsKmsDiscoveryMulti();
    final AwsKmsMrkDiscoveryMultiKeyringConfig awsKmsMrkDiscoveryMulti =
        keyring.getAwsKmsMrkDiscoveryMulti();
    final MultiKeyringConfig multi = keyring.getMulti();

    final List<String> present = new ArrayList<>();
    if (rawAes != null) {
      present.add("rawAes");
    }
    if (rawRsa != null) {
      present.add("rawRsa");
    }
    if (awsKms != null) {
      present.add("awsKms");
    }
    if (awsKmsMrk != null) {
      present.add("awsKmsMrk");
    }
    if (awsKmsMrkMulti != null) {
      present.add("awsKmsMrkMulti");
    }
    if (awsKmsRsa != null) {
      present.add("awsKmsRsa");
    }
    if (awsKmsEcdh != null) {
      present.add("awsKmsEcdh");
    }
    if (rawEcdh != null) {
      present.add("rawEcdh");
    }
    if (hierarchical != null) {
      present.add("hierarchical");
    }
    if (awsKmsDiscovery != null) {
      present.add("awsKmsDiscovery");
    }
    if (awsKmsMrkDiscovery != null) {
      present.add("awsKmsMrkDiscovery");
    }
    if (awsKmsDiscoveryMulti != null) {
      present.add("awsKmsDiscoveryMulti");
    }
    if (awsKmsMrkDiscoveryMulti != null) {
      present.add("awsKmsMrkDiscoveryMulti");
    }
    if (multi != null) {
      present.add("multi");
    }

    if (present.isEmpty()) {
      throw new IllegalArgumentException(
          "Table '"
              + logicalTableName
              + "' has a keyring configuration with no keyring kind set; exactly one of"
              + " {rawAes, rawRsa, awsKms, awsKmsMrk, awsKmsMrkMulti, awsKmsRsa, awsKmsEcdh,"
              + " rawEcdh, hierarchical, awsKmsDiscovery, awsKmsMrkDiscovery, awsKmsDiscoveryMulti,"
              + " awsKmsMrkDiscoveryMulti, multi} is required.");
    }
    if (present.size() > 1) {
      throw new IllegalArgumentException(
          "Table '"
              + logicalTableName
              + "' has a keyring configuration with multiple keyring kinds set "
              + present
              + "; exactly one is required.");
    }

    if (rawAes != null) {
      return new KeyringConfigValue.RawAes(
          rawAes.getKeyNamespace(),
          rawAes.getKeyName(),
          rawAes.getWrappingKey(),
          software.amazon.cryptography.materialproviders.model.AesWrappingAlg.valueOf(
              rawAes.getWrappingAlg().getValue()));
    }
    if (rawRsa != null) {
      return new KeyringConfigValue.RawRsa(
          rawRsa.getKeyNamespace(),
          rawRsa.getKeyName(),
          software.amazon.cryptography.materialproviders.model.PaddingScheme.valueOf(
              rawRsa.getPaddingScheme().getValue()),
          rawRsa.getPublicKey(),
          rawRsa.getPrivateKey());
    }
    if (awsKms != null) {
      return new KeyringConfigValue.AwsKms(awsKms.getKmsKeyId(), grantTokensOf(awsKms.getGrantTokens()));
    }
    if (awsKmsMrk != null) {
      return new KeyringConfigValue.AwsKmsMrk(
          awsKmsMrk.getKmsKeyId(), grantTokensOf(awsKmsMrk.getGrantTokens()));
    }
    if (awsKmsMrkMulti != null) {
      return new KeyringConfigValue.AwsKmsMrkMulti(
          awsKmsMrkMulti.getGenerator(), listOrNull(awsKmsMrkMulti.getKmsKeyIds()));
    }
    if (awsKmsRsa != null) {
      return new KeyringConfigValue.AwsKmsRsa(
          awsKmsRsa.getKmsKeyId(),
          software.amazon.awssdk.services.kms.model.EncryptionAlgorithmSpec.fromValue(
              awsKmsRsa.getEncryptionAlgorithm().getValue()),
          awsKmsRsa.getPublicKey());
    }
    if (awsKmsEcdh != null) {
      return new KeyringConfigValue.AwsKmsEcdh(
          awsKmsEcdh.getSenderKmsIdentifier(),
          awsKmsEcdh.getRecipientPublicKey(),
          software.amazon.cryptography.primitives.model.ECDHCurveSpec.valueOf(
              awsKmsEcdh.getCurveSpec().getValue()));
    }
    if (rawEcdh != null) {
      return new KeyringConfigValue.RawEcdh(
          rawEcdh.getSenderStaticPrivateKey(),
          rawEcdh.getRecipientPublicKey(),
          software.amazon.cryptography.primitives.model.ECDHCurveSpec.valueOf(
              rawEcdh.getCurveSpec().getValue()));
    }
    if (hierarchical != null) {
      return new KeyringConfigValue.Hierarchical(
          hierarchical.getKeyStoreTableName(),
          hierarchical.getLogicalKeyStoreName(),
          hierarchical.getKmsKeyArn(),
          hierarchical.getBranchKeyId(),
          hierarchical.getTtlSeconds(),
          hierarchical.getCacheEntryCapacity());
    }
    if (awsKmsDiscovery != null) {
      return new KeyringConfigValue.AwsKmsDiscovery(
          awsKmsDiscovery.getAccountId(), awsKmsDiscovery.getPartition());
    }
    if (awsKmsMrkDiscovery != null) {
      return new KeyringConfigValue.AwsKmsMrkDiscovery(
          awsKmsMrkDiscovery.getRegion(),
          awsKmsMrkDiscovery.getAccountId(),
          awsKmsMrkDiscovery.getPartition());
    }
    if (awsKmsDiscoveryMulti != null) {
      return new KeyringConfigValue.AwsKmsDiscoveryMulti(
          listOrNull(awsKmsDiscoveryMulti.getRegions()),
          awsKmsDiscoveryMulti.getAccountId(),
          awsKmsDiscoveryMulti.getPartition());
    }
    if (awsKmsMrkDiscoveryMulti != null) {
      return new KeyringConfigValue.AwsKmsMrkDiscoveryMulti(
          listOrNull(awsKmsMrkDiscoveryMulti.getRegions()),
          awsKmsMrkDiscoveryMulti.getAccountId(),
          awsKmsMrkDiscoveryMulti.getPartition());
    }
    // multi != null
    final KeyringConfigValue generator =
        multi.getGenerator() != null ? toKeyring(logicalTableName, multi.getGenerator()) : null;
    final List<KeyringConfigValue> children = new ArrayList<>();
    if (multi.getChildKeyrings() != null) {
      for (final KeyringConfig child : multi.getChildKeyrings()) {
        children.add(toKeyring(logicalTableName, child));
      }
    }
    return new KeyringConfigValue.Multi(generator, children);
  }

  /** @return the list itself when non-empty, otherwise {@code null} */
  private static List<String> grantTokensOf(final List<String> grantTokens) {
    return listOrNull(grantTokens);
  }

  private static List<String> listOrNull(final List<String> list) {
    return (list == null || list.isEmpty()) ? null : list;
  }

  private static String describe(final Throwable t) {
    final String message = t.getMessage();
    return (message != null && !message.isEmpty())
        ? message
        : t.getClass().getSimpleName();
  }
}
