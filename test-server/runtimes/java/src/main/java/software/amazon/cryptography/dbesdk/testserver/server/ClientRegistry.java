// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
package software.amazon.cryptography.dbesdk.testserver.server;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * In-memory store mapping a {@code ClientId} to a constructed DB-ESDK Enhanced Client
 * ({@link EnhancedClientHandle}), owned by the Java_Server process.
 *
 * <p>The registry is the {@code Client_Registry} component of the design. It lets the server
 * reference a client created by {@code CreateClient} across multiple subsequent HTTP operations by
 * supplying the returned {@code ClientId}.
 *
 * <h2>Concurrency and lifetime guarantees</h2>
 *
 * <ul>
 *   <li><b>Unique ids under concurrency (Req 4.2):</b> {@link #register} generates a fresh
 *       {@code ClientId} that is unique among the entries currently held, even when multiple
 *       {@code CreateClient} requests are processed on different threads. Ids are random UUIDs, and
 *       insertion uses {@link ConcurrentMap#putIfAbsent} so that, in the astronomically unlikely
 *       event of a collision, a new id is generated rather than clobbering an existing entry.
 *   <li><b>Atomic registration (Req 4.7):</b> registration either fully succeeds — the entry is
 *       stored and its id returned — or stores nothing at all. There is no intermediate state in
 *       which an id is handed out without a corresponding entry.
 *   <li><b>Stable resolution, no eviction (Req 4.3):</b> entries are never overwritten or evicted
 *       for the life of the process, so a given {@code ClientId} always resolves to the same
 *       handle.
 * </ul>
 *
 * <p>This class is thread-safe. It is intentionally decoupled from the Enhanced Client adapter
 * (task 2.2) via the {@link EnhancedClientHandle} abstraction, and from request handling: callers
 * such as the {@code createClient}/operation handlers (tasks 2.3, 4.3) are responsible for mapping
 * an absent or unknown id to the appropriate {@code GenericServerError}. {@link #lookup} returns an
 * {@link Optional} precisely so that mapping can live in the handler rather than here.
 */
public final class ClientRegistry {

  private final ConcurrentMap<String, EnhancedClientHandle> clientsById =
      new ConcurrentHashMap<>();

  /**
   * Registers a constructed Enhanced Client and returns a fresh {@code ClientId} bound to it.
   *
   * <p>Registration is atomic: on return the handle is stored under the returned id, or — if this
   * method throws — nothing has been stored. The generated id is unique among the entries currently
   * held, including under concurrent calls.
   *
   * @param client the constructed Enhanced Client handle to store; must not be {@code null}
   * @return the unique {@code ClientId} now bound to {@code client}
   * @throws NullPointerException if {@code client} is {@code null}
   */
  public String register(final EnhancedClientHandle client) {
    Objects.requireNonNull(client, "client must not be null");
    // Generate ids until one wins an atomic insert. putIfAbsent never overwrites an existing
    // entry, so an id is only returned once its (id -> client) mapping is actually present.
    while (true) {
      final String clientId = newClientId();
      final EnhancedClientHandle existing = clientsById.putIfAbsent(clientId, client);
      if (existing == null) {
        return clientId;
      }
    }
  }

  /**
   * Resolves a {@code ClientId} to its Enhanced Client handle.
   *
   * @param clientId the id returned by a prior {@link #register} call; may be {@code null} or empty
   * @return the handle bound to {@code clientId}, or {@link Optional#empty()} if {@code clientId} is
   *     {@code null}, empty, or not present in the registry
   */
  public Optional<EnhancedClientHandle> lookup(final String clientId) {
    if (clientId == null || clientId.isEmpty()) {
      return Optional.empty();
    }
    return Optional.ofNullable(clientsById.get(clientId));
  }

  private static String newClientId() {
    return UUID.randomUUID().toString();
  }
}
