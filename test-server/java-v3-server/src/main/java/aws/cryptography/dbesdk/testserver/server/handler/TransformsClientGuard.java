package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.model.GenericServerError;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClientRegistry;

/**
 * Resolves the {@code ClientId} required by every transform operation. An
 * absent, empty, or unknown id yields a {@link GenericServerError} before any
 * DBE call is made, leaving the {@link TransformsClientRegistry} unchanged. The
 * transforms analog of {@link ClientIdGuard}.
 */
public final class TransformsClientGuard {

  private final TransformsClientRegistry registry;

  public TransformsClientGuard(TransformsClientRegistry registry) {
    this.registry = registry;
  }

  /**
   * Resolve a transforms client by id, or throw a {@link GenericServerError}
   * if the id is absent, empty, or not present in the registry.
   *
   * @param clientId the id from the request.
   * @return the resolved client, never {@code null}.
   */
  public TransformsClient resolve(String clientId) {
    return registry
      .resolve(clientId)
      .orElseThrow(() ->
        GenericServerError
          .builder()
          .message(
            "No transforms client is registered under ClientId '" +
            (clientId == null ? "" : clientId) +
            "'. Call CreateTransformsClient first and pass the returned ClientId."
          )
          .build()
      );
  }
}
