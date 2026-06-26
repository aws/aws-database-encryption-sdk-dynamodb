// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import software.amazon.cryptography.dbesdk.testserver.server.adapter.BackendConfig;
import software.amazon.cryptography.dbesdk.testserver.server.handlers.CreateClientHandler;
import software.amazon.cryptography.dbesdk.testserver.server.handlers.ReadItemHandler;
import software.amazon.cryptography.dbesdk.testserver.server.handlers.WriteItemHandler;
import software.amazon.cryptography.dbesdk.testserver.service.TestServer;
import software.amazon.smithy.java.server.Server;

/**
 * Entry point and HTTP transport for the Java_Server (Component 3 of the design).
 *
 * <p>This class wires the smithy-java generated transport ({@link TestServer}) to the hand-written
 * operation handlers and serves the model's operations over HTTP. It is the {@code mainClass}
 * declared by {@code runtimes/java/build.gradle.kts} and the process the {@code start-java} Make
 * target launches for manual {@code curl} verification and for the Test_Suite to target.
 *
 * <h2>Wire format / protocol (Reqs 6.1, 6.4)</h2>
 *
 * The model declares the Smithy RPC v2 CBOR protocol. The smithy-java server runtime selects the
 * matching server protocol implementation automatically: {@code server-rpcv2-cbor} registers an
 * {@code RpcV2CborProtocolProvider} via {@code ServiceLoader}, and {@code server-netty} provides the
 * HTTP transport. We therefore only build the {@link Server}, point it at a port, add the service,
 * and start it — the framework handles HTTP framing and CBOR (de)serialization for every modeled
 * operation.
 *
 * <h2>Listen port (Reqs 6.2, 6.3)</h2>
 *
 * The port is configuration-driven, resolved in this precedence order so a single value can be set
 * however is most convenient for manual runs, Gradle's {@code run}, or CI:
 *
 * <ol>
 *   <li>the first CLI argument ({@code args[0]}),
 *   <li>the {@code testserver.port} JVM system property,
 *   <li>the {@code TEST_SERVER_PORT} environment variable,
 *   <li>otherwise the default {@value #DEFAULT_PORT}.
 * </ol>
 *
 * <p>The resolved value must be an integer in {@code 1..65535}. If it is non-numeric or out of
 * range, startup fails immediately with a clear message and a non-zero exit and <em>no</em> port is
 * bound (Req 6.3). If the port is well-formed but already in use, {@link Server#start()} surfaces
 * the bind failure; we report it and exit non-zero without attempting to bind any other port
 * (Req 6.3) — there is no silent fallback.
 *
 * <h2>Malformed bodies / unrecognized operations (Reqs 6.5, 6.6)</h2>
 *
 * These are handled by the rpcv2Cbor server protocol layer <em>before</em> any operation handler
 * runs, so no operation is performed. A body that cannot be decoded as the target operation's input
 * is rejected by the protocol as a structured framework error ({@code MalformedRequestException});
 * a request whose target is not one of the modeled operations is rejected as a structured framework
 * error ({@code UnknownOperationException}) — see {@code TestServer.getOperation}, which throws
 * {@code UnknownOperationException} for any unknown operation name. Both are modeled {@code @error}
 * shapes carrying a human-readable message, i.e. the framework-level equivalent of the model's
 * {@code GenericServerError}: the client receives a structured error describing the failure rather
 * than a partial success or an unstructured crash. (Returning the model's own {@code
 * GenericServerError} shape for these protocol-layer rejections would require a custom server
 * protocol implementation, which is outside this MVP; the behavior is structurally consistent with
 * the requirement.)
 */
public final class TestServerMain {

  /** Default listen port used when no port is supplied by arg, system property, or environment. */
  public static final int DEFAULT_PORT = 8080;

  /** Lowest legal TCP port (Req 6.2). */
  private static final int MIN_PORT = 1;

  /** Highest legal TCP port (Req 6.2). */
  private static final int MAX_PORT = 65535;

  /** CLI/system-property/environment names for the configurable listen port. */
  private static final String PORT_SYSTEM_PROPERTY = "testserver.port";

  private static final String PORT_ENV_VAR = "TEST_SERVER_PORT";

  /** Environment names for the DynamoDB_Backend the constructed Enhanced Clients talk to. */
  private static final String DDB_ENDPOINT_ENV_VAR = "TEST_SERVER_DDB_ENDPOINT";

  private static final String DDB_REGION_ENV_VAR = "TEST_SERVER_DDB_REGION";

  /** Process-wide default region when none is configured (DynamoDB Local ignores it). */
  private static final String DEFAULT_REGION = "us-west-2";

  private TestServerMain() {}

  public static void main(final String[] args) {
    final int port;
    try {
      port = resolvePort(args);
    } catch (final IllegalArgumentException e) {
      // Port out of range / non-numeric: fail startup, bind nothing (Req 6.3).
      System.err.println("[TestServerMain] FATAL: " + e.getMessage());
      System.err.println(
          "[TestServerMain] The listen port must be an integer in "
              + MIN_PORT
              + ".."
              + MAX_PORT
              + ". Set it via arg, -D"
              + PORT_SYSTEM_PROPERTY
              + ", or $"
              + PORT_ENV_VAR
              + ".");
      System.exit(2);
      return; // unreachable; keeps the compiler's definite-assignment analysis happy
    }

    final Server server;
    try {
      server = buildServer(port);
      // start() binds the port. A port already in use surfaces here as a startup failure; we do
      // NOT catch-and-rebind on another port (Req 6.3).
      server.start();
    } catch (final RuntimeException e) {
      System.err.println(
          "[TestServerMain] FATAL: failed to start the server on port "
              + port
              + " (the port may already be in use): "
              + e.getMessage());
      System.exit(3);
      return; // unreachable
    }

    System.out.println(
        "[TestServerMain] TestServer listening on http://localhost:" + port + " (RPC v2 CBOR).");

    // Stop the server cleanly on SIGINT/SIGTERM and release the main thread.
    final CountDownLatch shutdownLatch = new CountDownLatch(1);
    Runtime.getRuntime()
        .addShutdownHook(
            new Thread(
                () -> {
                  System.out.println("[TestServerMain] Shutting down ...");
                  try {
                    server.shutdown().join();
                  } catch (final RuntimeException e) {
                    System.err.println(
                        "[TestServerMain] Error during shutdown: " + e.getMessage());
                  } finally {
                    shutdownLatch.countDown();
                  }
                },
                "testserver-shutdown"));

    // Keep the process alive while the (daemon) Netty threads serve requests.
    try {
      shutdownLatch.await();
    } catch (final InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  /**
   * Builds the HTTP server bound to {@code port}, wiring the generated {@link TestServer} service to
   * the operation handlers. Package-private so the wiring can be exercised without starting Netty.
   *
   * @param port a port already validated to be in {@code 1..65535}
   * @return a built (not yet started) {@link Server}
   */
  static Server buildServer(final int port) {
    return Server.builder().endpoints(port).addService(buildService()).build();
  }

  /**
   * Assembles the {@link TestServer} service from the operation handlers.
   *
   * <p>smithy-java's generated builder is staged: every operation declared by the model
   * ({@code CreateClient}, {@code ReadItem}, {@code WriteItem}) must be registered before the
   * service can be built. We register:
   *
   * <ul>
   *   <li>{@code createClient} — the real handler authored by task 2.3 ({@link CreateClientHandler},
   *       constructed with the {@link ClientRegistry} and the process-wide {@link BackendConfig}).
   *   <li>{@code writeItem} / {@code readItem} — placeholder handlers ({@link WriteItemHandler} /
   *       {@link ReadItemHandler}) that fail with a structured {@code GenericServerError} until
   *       tasks 4.1 / 4.2 supply the real logic. They are wired exactly like the real handlers, so
   *       4.1 / 4.2 only need to replace the handler implementations — this method does not change.
   * </ul>
   *
   * <p>A single {@link ClientRegistry} and {@link BackendConfig} are shared across the handlers so a
   * client created by {@code CreateClient} resolves to the same Enhanced_Client on later
   * write/read calls (Req 4.3).
   */
  static TestServer buildService() {
    final ClientRegistry registry = new ClientRegistry();
    final BackendConfig backendConfig = resolveBackendConfig();

    return TestServer.builder()
        .addCreateClientOperation(new CreateClientHandler(registry, backendConfig))
        .addReadItemOperation(new ReadItemHandler(registry))
        .addWriteItemOperation(new WriteItemHandler(registry))
        .build();
  }

  /**
   * Resolves the listen port from (in order) the first CLI arg, the {@value #PORT_SYSTEM_PROPERTY}
   * system property, the {@value #PORT_ENV_VAR} environment variable, or the default
   * {@value #DEFAULT_PORT}.
   *
   * @param args the program arguments ({@code args[0]}, if present, is the port)
   * @return a validated port in {@code 1..65535}
   * @throws IllegalArgumentException if the configured value is non-numeric or out of range
   */
  static int resolvePort(final String[] args) {
    final String raw;
    if (args != null && args.length > 0 && args[0] != null && !args[0].isBlank()) {
      raw = args[0].trim();
    } else if (notBlank(System.getProperty(PORT_SYSTEM_PROPERTY))) {
      raw = System.getProperty(PORT_SYSTEM_PROPERTY).trim();
    } else if (notBlank(System.getenv(PORT_ENV_VAR))) {
      raw = System.getenv(PORT_ENV_VAR).trim();
    } else {
      return DEFAULT_PORT;
    }

    final int port;
    try {
      port = Integer.parseInt(raw);
    } catch (final NumberFormatException e) {
      throw new IllegalArgumentException("Configured port '" + raw + "' is not an integer.", e);
    }
    if (port < MIN_PORT || port > MAX_PORT) {
      throw new IllegalArgumentException(
          "Configured port " + port + " is out of range (" + MIN_PORT + ".." + MAX_PORT + ").");
    }
    return port;
  }

  /**
   * Builds the process-wide {@link BackendConfig} from the environment so the DynamoDB_Backend
   * endpoint/region are configuration-driven (defaulting to a local-friendly region). The backend
   * timeout keeps its {@link BackendConfig} default (5s, Req 5.5).
   */
  private static BackendConfig resolveBackendConfig() {
    final BackendConfig.Builder builder =
        BackendConfig.builder().timeout(Duration.ofSeconds(BackendConfig.DEFAULT_TIMEOUT_SECONDS));

    final String endpoint = System.getenv(DDB_ENDPOINT_ENV_VAR);
    if (notBlank(endpoint)) {
      builder.endpointOverride(endpoint.trim());
    }

    final String region = System.getenv(DDB_REGION_ENV_VAR);
    builder.region(notBlank(region) ? region.trim() : DEFAULT_REGION);

    return builder.build();
  }

  private static boolean notBlank(final String s) {
    return s != null && !s.isBlank();
  }
}
