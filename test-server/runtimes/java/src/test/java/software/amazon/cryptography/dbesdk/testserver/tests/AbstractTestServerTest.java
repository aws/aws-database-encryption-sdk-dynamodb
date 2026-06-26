// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.tests;

import org.junit.jupiter.api.BeforeAll;
import software.amazon.cryptography.dbesdk.testserver.client.TestServerClient;

/**
 * Base class for every round-trip Test_Suite class (Component 6 of the design).
 *
 * <p>It centralizes the harness wiring so the concrete suites (the {@code CreateClient} test in
 * task 3.2 and the create&rarr;write&rarr;read round-trip in task 4.4) only express assertions:
 *
 * <ul>
 *   <li>resolves the {@link TestServerEndpointConfig} from runtime configuration (system property /
 *       environment variable, never hard-coded — Reqs 8.3, 8.4),
 *   <li>verifies the configured Language_Server endpoint is reachable, failing the whole suite up
 *       front if it is not (Reqs 7.5, 8.5), and
 *   <li>builds the smithy-java GENERATED {@link TestServerClient} pointed at that endpoint.
 * </ul>
 *
 * <h2>Why this guarantees "unreachable &rArr; failure, never a pass"</h2>
 *
 * <p>The reachability probe and client construction run in {@code @BeforeAll}. JUnit treats an
 * exception thrown from {@code @BeforeAll} as an error for <em>every</em> test in the class, so a
 * down server or backend can never yield a green run — it deterministically fails before any
 * assertion executes. The probe is in addition to the transport itself never swallowing connection
 * errors (see {@link TestServerClientFactory}); the two together make an unreachable endpoint a
 * failure no matter where the test first touches the wire.
 */
public abstract class AbstractTestServerTest {

  /** Resolved runtime configuration shared by the suite's tests. */
  protected static TestServerEndpointConfig config;

  /** Generated client pointed at the configured Language_Server. */
  protected static TestServerClient client;

  @BeforeAll
  static void initHarness() {
    config = TestServerEndpointConfig.fromRuntime();
    // Fail fast (and the whole suite) if the Language_Server is unreachable (Reqs 7.5, 8.5).
    config.requireReachable((int) TestServerClientFactory.connectTimeout().toMillis());
    client = TestServerClientFactory.newClient(config);
  }
}
