// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server.adapter;

import java.time.Duration;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;

/**
 * Configuration for the DynamoDB_Backend the Enhanced Client talks to.
 *
 * <p>This is server-side wiring, not part of the per-client {@code CreateClient} configuration:
 * every constructed Enhanced Client points at the same backend (for example DynamoDB Local during
 * round-trip tests). The server supplies one of these when building an adapter so the backend
 * endpoint, region, credentials, and timeout are all configuration-driven rather than hard-coded.
 *
 * <h2>Timeout (Req 5.5)</h2>
 *
 * The {@link #timeout()} is enforced at the DynamoDB client configuration layer (as both the
 * overall API-call timeout and the per-attempt timeout) so it applies uniformly to writes and
 * reads. It defaults to {@value #DEFAULT_TIMEOUT_SECONDS} seconds when not overridden.
 *
 * <h2>Endpoint</h2>
 *
 * When {@link #endpointOverride()} is set, the DynamoDB client is pointed at that endpoint (for
 * example {@code http://localhost:8000} for DynamoDB Local). When it is {@code null}, the SDK
 * resolves the real regional DynamoDB endpoint.
 */
public final class BackendConfig {

  /** Default backend timeout in seconds (Req 5.5). */
  public static final long DEFAULT_TIMEOUT_SECONDS = 5;

  private final String endpointOverride;
  private final String region;
  private final Duration timeout;
  private final AwsCredentialsProvider credentialsProvider;

  private BackendConfig(final Builder builder) {
    this.endpointOverride = builder.endpointOverride;
    this.region = builder.region;
    this.timeout = builder.timeout == null
        ? Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS)
        : builder.timeout;
    this.credentialsProvider = builder.credentialsProvider;
  }

  /** @return the DynamoDB endpoint override (e.g. DynamoDB Local), or {@code null} for the real endpoint */
  public String endpointOverride() {
    return endpointOverride;
  }

  /** @return the AWS region name to sign for, or {@code null} to let the SDK resolve it */
  public String region() {
    return region;
  }

  /** @return the backend timeout; never {@code null} (defaults to {@value #DEFAULT_TIMEOUT_SECONDS}s) */
  public Duration timeout() {
    return timeout;
  }

  /** @return an explicit credentials provider, or {@code null} to use the SDK default chain */
  public AwsCredentialsProvider credentialsProvider() {
    return credentialsProvider;
  }

  public static Builder builder() {
    return new Builder();
  }

  /** Mutable builder for {@link BackendConfig}. */
  public static final class Builder {

    private String endpointOverride;
    private String region;
    private Duration timeout;
    private AwsCredentialsProvider credentialsProvider;

    public Builder endpointOverride(final String value) {
      this.endpointOverride = value;
      return this;
    }

    public Builder region(final String value) {
      this.region = value;
      return this;
    }

    /** Sets the backend timeout. Passing {@code null} keeps the {@value #DEFAULT_TIMEOUT_SECONDS}s default. */
    public Builder timeout(final Duration value) {
      this.timeout = value;
      return this;
    }

    public Builder credentialsProvider(final AwsCredentialsProvider value) {
      this.credentialsProvider = value;
      return this;
    }

    public BackendConfig build() {
      return new BackendConfig(this);
    }
  }
}
