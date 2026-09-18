package aws.cryptography.dbesdk.testserver.server.registry;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * In-memory, thread-safe registry of configured {@link TransformsClient}
 * instances, keyed by {@code ClientId}. Structurally identical to
 * {@link ClientRegistry} but for transforms clients, kept as a separate map so
 * a transform-client id and an item-encryptor id never collide and each
 * operation resolves only its own client kind.
 *
 * <p>{@link #register(TransformsClient)} generates a fresh UUID-format id not
 * equal to any id currently in the registry, stores the client atomically, and
 * returns the id. {@link #resolve(String)} returns {@link Optional#empty()} for
 * a {@code null}, empty, or unknown id.
 */
public final class TransformsClientRegistry {

  private final ConcurrentMap<String, TransformsClient> clients =
    new ConcurrentHashMap<>();

  /**
   * Register a client and return a fresh, unique {@code ClientId}.
   *
   * @param client the configured client to store; must not be {@code null}.
   * @return a non-empty, UUID-format id distinct from every id currently in
   *     the registry.
   */
  public String register(TransformsClient client) {
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
  public Optional<TransformsClient> resolve(String clientId) {
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
