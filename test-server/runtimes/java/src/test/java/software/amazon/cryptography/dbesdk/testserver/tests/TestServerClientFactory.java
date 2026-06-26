// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import java.net.http.HttpClient;
import java.time.Duration;
import software.amazon.cryptography.dbesdk.testserver.client.TestServerClient;
import software.amazon.smithy.java.client.http.JavaHttpClientTransport;

/**
 * Builds the smithy-java GENERATED {@link TestServerClient} pointed at a configurable
 * Language_Server endpoint (Component 6 of the design).
 *
 * <p>The Test_Suite always talks to a Language_Server through this generated client, so the wire
 * contract is exactly the one produced from the shared Smithy_Model — no test defines request or
 * response shapes of its own (Req 8.1). Because the endpoint comes from {@link
 * TestServerEndpointConfig} (system property / environment variable, never hard-coded), the same
 * test source can target the Java_Server today or a future Rust server tomorrow with no source
 * change (Reqs 8.3, 8.4).
 *
 * <h2>How the generated client is constructed</h2>
 *
 * <ol>
 *   <li>{@code TestServerClient.builder()} — the generated builder defaults the <b>RPC v2 CBOR</b>
 *       protocol declared in the model, so we do not set a protocol explicitly.
 *   <li>{@code .endpoint(config.endpoint())} — points the client at the configured Language_Server
 *       URL (e.g. {@code http://localhost:8080}).
 *   <li>{@code .transport(new JavaHttpClientTransport(...))} — wires smithy-java's
 *       {@code java.net.http}-based HTTP transport (from {@code client-http}) explicitly, with a
 *       bounded connect timeout so an unreachable endpoint fails promptly rather than hanging.
 * </ol>
 *
 * <h2>Unreachable is always a failure, never a pass (Reqs 7.5, 8.5)</h2>
 *
 * <p>This factory never swallows or suppresses connection errors. The generated client connects
 * lazily — the TCP connection is established on the first operation call, not at {@code build()} —
 * so when the Language_Server or its DynamoDB_Backend is down, the very first operation a test
 * issues throws a transport exception that propagates out of the test method and is recorded by
 * JUnit as a failure. There is no catch-all, no fallback endpoint, and no "skip if unreachable"
 * path here. A suite that wants to fail fast with an actionable message before issuing any
 * operation may additionally call {@link TestServerEndpointConfig#requireReachable(int)} in setup.
 */
public final class TestServerClientFactory {

  /** Bound the TCP connect attempt so an unreachable endpoint fails fast (ms). */
  static final String CONNECT_TIMEOUT_PROPERTY = "testserver.connect.timeout.millis";

  /** Bound a single request/response exchange (ms). */
  static final String REQUEST_TIMEOUT_PROPERTY = "testserver.request.timeout.millis";

  private static final long DEFAULT_CONNECT_TIMEOUT_MILLIS = 2_000L;
  private static final long DEFAULT_REQUEST_TIMEOUT_MILLIS = 10_000L;

  private TestServerClientFactory() {}

  /**
   * Builds a {@link TestServerClient} for the endpoint in {@code config}.
   *
   * @param config the resolved runtime configuration (never {@code null})
   * @return a generated client ready to issue operations against the configured Language_Server
   */
  public static TestServerClient newClient(final TestServerEndpointConfig config) {
    final Duration connectTimeout = Duration.ofMillis(longProperty(CONNECT_TIMEOUT_PROPERTY, DEFAULT_CONNECT_TIMEOUT_MILLIS));
    final Duration requestTimeout = Duration.ofMillis(longProperty(REQUEST_TIMEOUT_PROPERTY, DEFAULT_REQUEST_TIMEOUT_MILLIS));

    final HttpClient httpClient = HttpClient.newBuilder().connectTimeout(connectTimeout).build();

    return TestServerClient.builder()
        // Protocol is left at the generated default (RPC v2 CBOR, per the model).
        .endpoint(config.endpoint())
        .transport(new JavaHttpClientTransport(httpClient, requestTimeout))
        .build();
  }

  /** @return the connect timeout the factory would use, honoring the override property. */
  public static Duration connectTimeout() {
    return Duration.ofMillis(longProperty(CONNECT_TIMEOUT_PROPERTY, DEFAULT_CONNECT_TIMEOUT_MILLIS));
  }

  private static long longProperty(final String property, final long fallback) {
    final String raw = System.getProperty(property);
    if (raw == null || raw.isBlank()) {
      return fallback;
    }
    try {
      return Long.parseLong(raw.trim());
    } catch (final NumberFormatException e) {
      throw new IllegalStateException(
          "Configured " + property + " value '" + raw + "' is not a valid number of milliseconds.",
          e);
    }
  }
}
