// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server.adapter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Plain value mirror of the Smithy model's {@code CreateClientInput}, plus the server-side {@link
 * BackendConfig} describing where the constructed client reads and writes.
 *
 * <p>This is the single input to {@link EnhancedClientAdapter#build(CreateClientConfig)}. The
 * {@code createClient} handler (task 2.3) builds one of these by translating the generated {@code
 * CreateClientInput} (its {@code tableEncryptionConfigs} map) into {@link
 * TableEncryptionConfigValue} entries, and by supplying the process-wide {@link BackendConfig}.
 * Decoupling the adapter from generated types keeps it independently compilable.
 */
public final class CreateClientConfig {

  private final Map<String, TableEncryptionConfigValue> tableEncryptionConfigs;
  private final BackendConfig backendConfig;

  private CreateClientConfig(final Builder builder) {
    this.tableEncryptionConfigs =
        Objects.requireNonNull(
            builder.tableEncryptionConfigs, "tableEncryptionConfigs must not be null");
    this.backendConfig =
        Objects.requireNonNull(builder.backendConfig, "backendConfig must not be null");
  }

  /**
   * @return map of physical DynamoDB table name to that table's encryption configuration; mirrors
   *     the model's {@code TableEncryptionConfigList}
   */
  public Map<String, TableEncryptionConfigValue> tableEncryptionConfigs() {
    return tableEncryptionConfigs;
  }

  /** @return the backend (endpoint/region/timeout/credentials) the constructed client uses */
  public BackendConfig backendConfig() {
    return backendConfig;
  }

  public static Builder builder() {
    return new Builder();
  }

  /** Mutable builder for {@link CreateClientConfig}. */
  public static final class Builder {

    private Map<String, TableEncryptionConfigValue> tableEncryptionConfigs = new LinkedHashMap<>();
    private BackendConfig backendConfig;

    public Builder tableEncryptionConfigs(
        final Map<String, TableEncryptionConfigValue> value) {
      this.tableEncryptionConfigs = value;
      return this;
    }

    /** Adds a single table's configuration keyed by its physical table name. */
    public Builder putTableEncryptionConfig(
        final String tableName, final TableEncryptionConfigValue config) {
      this.tableEncryptionConfigs.put(tableName, config);
      return this;
    }

    public Builder backendConfig(final BackendConfig value) {
      this.backendConfig = value;
      return this;
    }

    public CreateClientConfig build() {
      return new CreateClientConfig(this);
    }
  }
}
