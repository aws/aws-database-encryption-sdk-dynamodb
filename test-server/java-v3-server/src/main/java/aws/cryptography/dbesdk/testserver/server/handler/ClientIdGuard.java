package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.model.GenericServerError;
import aws.cryptography.dbesdk.testserver.server.registry.ClientRegistry;
import aws.cryptography.dbesdk.testserver.server.registry.DbesdkClient;

/**
 * Resolves the {@code ClientId} required by every non-{@code CreateClient}
 * operation. An absent, empty, or unknown id yields a
 * {@link GenericServerError}; because the guard throws before any ESDK call is
 * made, no ESDK operation runs and the {@link ClientRegistry} is left unchanged.
 */
public final class ClientIdGuard {

  private final ClientRegistry registry;

  public ClientIdGuard(ClientRegistry registry) {
    this.registry = registry;
  }

  /**
   * Resolve a client by id, or throw a {@link GenericServerError} if the id is
   * absent, empty, or not present in the registry.
   *
   * @param clientId the id from the request (the generated shapes substitute an
   *     empty string for an absent required id).
   * @return the resolved client, never {@code null}.
   */
  public DbesdkClient resolve(String clientId) {
    return registry
      .resolve(clientId)
      .orElseThrow(() ->
        GenericServerError
          .builder()
          .message(
            "No ESDK client is registered under ClientId '" +
            (clientId == null ? "" : clientId) +
            "'. Call CreateClient first and pass the returned ClientId."
          )
          .build()
      );
  }
}
