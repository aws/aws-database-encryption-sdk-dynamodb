// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import java.util.Optional;

/**
 * Runtime configuration for the round-trip Test_Suite (Component 6 of the design).
 *
 * <p>The suite drives a {@code Language_Server} (the Java_Server first) with the smithy-java
 * GENERATED client. Both the target Language_Server endpoint (host + port) and the
 * DynamoDB_Backend endpoint are read from runtime configuration here — a JVM system property with
 * an environment-variable fallback — and are <em>never</em> hard-coded in the test source, so the
 * exact same test source can target any Language_Server simply by pointing it at a different
 * endpoint (Reqs 8.3, 8.4).
 *
 * <h2>Configuration keys</h2>
 *
 * <p>Each value is resolved in this precedence order: the JVM system property first (forwarded into
 * the forked test JVM by {@code runtimes/java/build.gradle.kts} and supplied by the {@code
 * test-java} Make target as {@code -D} flags), then the environment variable, then — only where a
 * sensible local default exists — a default.
 *
 * <table>
 *   <tr><th>Value</th><th>System property</th><th>Environment variable</th><th>Default</th></tr>
 *   <tr><td>Full server endpoint URL</td><td>{@code testserver.endpoint}</td>
 *       <td>{@code TEST_SERVER_ENDPOINT}</td><td>composed from host + port</td></tr>
 *   <tr><td>Server host</td><td>{@code testserver.endpoint.host}</td>
 *       <td>{@code TEST_SERVER_HOST}</td><td>{@code localhost}</td></tr>
 *   <tr><td>Server port</td><td>{@code testserver.port}</td>
 *       <td>{@code TEST_SERVER_PORT}</td><td><em>(required)</em></td></tr>
 *   <tr><td>DynamoDB_Backend endpoint</td><td>{@code testserver.ddb.endpoint}</td>
 *       <td>{@code TEST_SERVER_DDB_ENDPOINT}</td><td><em>(none)</em></td></tr>
 *   <tr><td>DynamoDB_Backend region</td><td>{@code testserver.ddb.region}</td>
 *       <td>{@code TEST_SERVER_DDB_REGION}</td><td>{@code us-west-2}</td></tr>
 * </table>
 *
 * <h2>Misconfiguration fails — it never silently passes (Reqs 7.5, 8.5)</h2>
 *
 * <p>If neither a full endpoint URL nor a port is configured, {@link #fromRuntime()} throws, so a
 * run with no usable endpoint surfaces as a test error (a failure) rather than a vacuous pass. This
 * is the configuration-time half of the "unreachable is always a failure" guarantee; the
 * connection-time half lives in {@link TestServerClientFactory} (connection exceptions are never
 * swallowed) and {@link #requireReachable()}.
 */
public final class TestServerEndpointConfig {

  static final String ENDPOINT_PROPERTY = "testserver.endpoint";
  static final String ENDPOINT_ENV = "TEST_SERVER_ENDPOINT";
  static final String HOST_PROPERTY = "testserver.endpoint.host";
  static final String HOST_ENV = "TEST_SERVER_HOST";
  static final String PORT_PROPERTY = "testserver.port";
  static final String PORT_ENV = "TEST_SERVER_PORT";
  static final String DDB_ENDPOINT_PROPERTY = "testserver.ddb.endpoint";
  static final String DDB_ENDPOINT_ENV = "TEST_SERVER_DDB_ENDPOINT";
  static final String DDB_REGION_PROPERTY = "testserver.ddb.region";
  static final String DDB_REGION_ENV = "TEST_SERVER_DDB_REGION";

  private static final String DEFAULT_HOST = "localhost";
  private static final String DEFAULT_SCHEME = "http";
  private static final String DEFAULT_DDB_REGION = "us-west-2";
  private static final int MIN_PORT = 1;
  private static final int MAX_PORT = 65535;

  private final String endpoint;
  private final String host;
  private final int port;
  private final String ddbEndpoint; // nullable
  private final String ddbRegion;

  private TestServerEndpointConfig(
      final String endpoint,
      final String host,
      final int port,
      final String ddbEndpoint,
      final String ddbRegion) {
    this.endpoint = endpoint;
    this.host = host;
    this.port = port;
    this.ddbEndpoint = ddbEndpoint;
    this.ddbRegion = ddbRegion;
  }

  /**
   * Resolves the Test_Suite configuration from system properties and environment variables (never
   * from hard-coded values — Reqs 8.3, 8.4).
   *
   * @return the resolved configuration
   * @throws IllegalStateException if no usable Language_Server endpoint can be determined (so a
   *     missing/garbled endpoint becomes a failure, never a pass — Reqs 7.5, 8.5)
   */
  public static TestServerEndpointConfig fromRuntime() {
    final String explicitEndpoint = resolve(ENDPOINT_PROPERTY, ENDPOINT_ENV);
    final String configuredHost = orDefault(resolve(HOST_PROPERTY, HOST_ENV), DEFAULT_HOST);
    final String rawPort = resolve(PORT_PROPERTY, PORT_ENV);
    final String ddbEndpoint = resolve(DDB_ENDPOINT_PROPERTY, DDB_ENDPOINT_ENV);
    final String ddbRegion = orDefault(resolve(DDB_REGION_PROPERTY, DDB_REGION_ENV), DEFAULT_DDB_REGION);

    if (explicitEndpoint != null) {
      // A full URL was supplied; derive host/port from it for connectivity probing.
      final java.net.URI uri;
      try {
        uri = java.net.URI.create(explicitEndpoint);
      } catch (final IllegalArgumentException e) {
        throw new IllegalStateException(
            "Configured "
                + ENDPOINT_PROPERTY
                + "/"
                + ENDPOINT_ENV
                + " value '"
                + explicitEndpoint
                + "' is not a valid URI.",
            e);
      }
      final String host = uri.getHost() != null ? uri.getHost() : configuredHost;
      final int port = uri.getPort() != -1 ? uri.getPort() : parsePortOrThrow(rawPort);
      return new TestServerEndpointConfig(explicitEndpoint, host, port, ddbEndpoint, ddbRegion);
    }

    // No full URL: compose one from host + port. A port MUST be configured; otherwise we have no
    // way to know where the Language_Server is, and we refuse to guess — that would risk a run that
    // never actually reaches a server yet reports success (Reqs 7.5, 8.5).
    final int port = parsePortOrThrow(rawPort);
    final String endpoint = DEFAULT_SCHEME + "://" + configuredHost + ":" + port;
    return new TestServerEndpointConfig(endpoint, configuredHost, port, ddbEndpoint, ddbRegion);
  }

  private static int parsePortOrThrow(final String rawPort) {
    if (rawPort == null) {
      throw new IllegalStateException(
          "No Language_Server endpoint configured. Set a full URL via -D"
              + ENDPOINT_PROPERTY
              + " (or $"
              + ENDPOINT_ENV
              + "), or set the port via -D"
              + PORT_PROPERTY
              + " (or $"
              + PORT_ENV
              + ") with an optional -D"
              + HOST_PROPERTY
              + ". Refusing to guess an endpoint so an unreachable/misconfigured run fails rather"
              + " than silently passing (Reqs 7.5, 8.5).");
    }
    final int port;
    try {
      port = Integer.parseInt(rawPort.trim());
    } catch (final NumberFormatException e) {
      throw new IllegalStateException(
          "Configured port '" + rawPort + "' is not an integer.", e);
    }
    if (port < MIN_PORT || port > MAX_PORT) {
      throw new IllegalStateException(
          "Configured port " + port + " is out of range (" + MIN_PORT + ".." + MAX_PORT + ").");
    }
    return port;
  }

  /** @return the full Language_Server endpoint URL the generated client connects to. */
  public String endpoint() {
    return endpoint;
  }

  /** @return the Language_Server host (derived from the endpoint or host config). */
  public String host() {
    return host;
  }

  /** @return the Language_Server port. */
  public int port() {
    return port;
  }

  /** @return the configured DynamoDB_Backend endpoint, if any. */
  public Optional<String> ddbEndpoint() {
    return Optional.ofNullable(ddbEndpoint);
  }

  /**
   * @return the configured DynamoDB_Backend endpoint.
   * @throws IllegalStateException if no DynamoDB_Backend endpoint is configured (so a test that
   *     needs it fails rather than silently using an unintended default).
   */
  public String requireDdbEndpoint() {
    if (ddbEndpoint == null) {
      throw new IllegalStateException(
          "No DynamoDB_Backend endpoint configured. Set -D"
              + DDB_ENDPOINT_PROPERTY
              + " (or $"
              + DDB_ENDPOINT_ENV
              + ").");
    }
    return ddbEndpoint;
  }

  /** @return the configured DynamoDB_Backend region (DynamoDB Local ignores it). */
  public String ddbRegion() {
    return ddbRegion;
  }

  /**
   * Probes that the configured Language_Server endpoint is accepting TCP connections, failing fast
   * with a clear message if it is not.
   *
   * <p>This is the optional fail-fast complement to the "operations throw on connection errors"
   * guarantee: a suite may call this in setup so an unreachable server surfaces immediately as a
   * failure (never a pass) with an actionable message instead of an opaque mid-test transport
   * exception (Reqs 7.5, 8.5). It opens and immediately closes a socket; it performs no operation.
   *
   * @param connectTimeoutMillis how long to wait for the TCP connection before declaring the
   *     endpoint unreachable
   * @throws IllegalStateException if the endpoint cannot be reached within the timeout
   */
  public void requireReachable(final int connectTimeoutMillis) {
    try (java.net.Socket socket = new java.net.Socket()) {
      socket.connect(new java.net.InetSocketAddress(host, port), connectTimeoutMillis);
    } catch (final java.io.IOException e) {
      throw new IllegalStateException(
          "Language_Server endpoint "
              + endpoint
              + " is unreachable: "
              + e.getMessage()
              + ". Start DynamoDB Local and the Java_Server (e.g. `make start-java`) at the"
              + " configured endpoint before running the Test_Suite.",
          e);
    }
  }

  private static String resolve(final String systemProperty, final String envVar) {
    final String fromProperty = System.getProperty(systemProperty);
    if (notBlank(fromProperty)) {
      return fromProperty.trim();
    }
    final String fromEnv = System.getenv(envVar);
    if (notBlank(fromEnv)) {
      return fromEnv.trim();
    }
    return null;
  }

  private static String orDefault(final String value, final String fallback) {
    return value != null ? value : fallback;
  }

  private static boolean notBlank(final String s) {
    return s != null && !s.isBlank();
  }
}
