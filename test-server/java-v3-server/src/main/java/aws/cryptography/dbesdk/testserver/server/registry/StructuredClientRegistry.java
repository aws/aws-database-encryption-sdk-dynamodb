package aws.cryptography.dbesdk.testserver.server.registry;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * In-memory, thread-safe registry of configured {@link StructuredClient}
 * instances, keyed by {@code ClientId}. Structurally identical to
 * {@link TransformsClientRegistry} but for structured-encryption clients, kept
 * as a separate map so a structured-client id never collides with an item or
 * transforms id and each operation resolves only its own client kind.
 */
public final class StructuredClientRegistry {

  private final ConcurrentMap<String, StructuredClient> clients =
    new ConcurrentHashMap<>();

  /**
   * Register a client and return a fresh, unique {@code ClientId}.
   *
   * @param client the configured client to store; must not be {@code null}.
   * @return a non-empty, UUID-format id distinct from every id currently in
   *     the registry.
   */
  public String register(StructuredClient client) {
    Objects.requireNonNull(client, "client cannot be null");
    while (true) {
      String id = UUID.randomUUID().toString();
      if (clients.putIfAbsent(id, client) == null) {
        return id;
      }
    }
  }

  /**
   * Resolve the client registered under an id.
   *
   * @param clientId the id to look up.
   * @return the registered client, or {@link Optional#empty()} if the id is
   *     {@code null}, empty, or not present in the registry.
   */
  public Optional<StructuredClient> resolve(String clientId) {
    if (clientId == null || clientId.isEmpty()) {
      return Optional.empty();
    }
    return Optional.ofNullable(clients.get(clientId));
  }

  /** @return the number of entries currently in the registry. */
  public int size() {
    return clients.size();
  }
}
