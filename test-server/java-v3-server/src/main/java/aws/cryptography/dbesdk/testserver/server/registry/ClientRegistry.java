package aws.cryptography.dbesdk.testserver.server.registry;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * In-memory, thread-safe registry of configured {@link DbesdkClient} instances,
 * keyed by {@code ClientId}.
 *
 * <p>{@link #register(DbesdkClient)} generates a fresh UUID-format id that is not
 * equal to any id currently in the registry, stores the client, and returns the
 * id. {@link #resolve(String)} looks a client
 * up by id, returning {@link Optional#empty()} for a {@code null}, empty, or
 * unknown id.
 *
 * <p>Entries are never evicted, so an id resolves to the same client for the
 * lifetime of the server process. The backing map is a
 * {@link ConcurrentHashMap}, and registration uses an atomic
 * {@link ConcurrentMap#putIfAbsent} claim so concurrent registrations never
 * collide on an id and never lose an entry.
 */
public final class ClientRegistry {

  private final ConcurrentMap<String, DbesdkClient> clients =
    new ConcurrentHashMap<>();

  /**
   * Register a client and return a fresh, unique {@code ClientId}.
   *
   * @param client the configured client to store; must not be {@code null}.
   * @return a non-empty, UUID-format id distinct from every id currently in
   *     the registry.
   */
  public String register(DbesdkClient client) {
    Objects.requireNonNull(client, "client cannot be null");
    // Generate ids until one atomically claims a free slot. UUID collisions
    // are astronomically unlikely; the loop makes uniqueness a guarantee
    // rather than a probability, even under concurrent registration.
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
  public Optional<DbesdkClient> resolve(String clientId) {
    if (clientId == null || clientId.isEmpty()) {
      return Optional.empty();
    }
    return Optional.ofNullable(clients.get(clientId));
  }

  /** @return whether an id is currently present in the registry. */
  public boolean contains(String clientId) {
    return (
      clientId != null && !clientId.isEmpty() && clients.containsKey(clientId)
    );
  }

  /** @return the number of entries currently in the registry. */
  public int size() {
    return clients.size();
  }
}
