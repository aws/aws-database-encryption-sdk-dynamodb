package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.model.GenericServerError;
import aws.cryptography.dbesdk.testserver.server.registry.StructuredClient;
import aws.cryptography.dbesdk.testserver.server.registry.StructuredClientRegistry;

/**
 * Resolves the {@code ClientId} required by Encrypt/DecryptStructure. An absent,
 * empty, or unknown id yields a {@link GenericServerError} before any DBE call,
 * leaving the {@link StructuredClientRegistry} unchanged. The structured-client
 * analog of {@link TransformsClientGuard}.
 */
public final class StructuredClientGuard {

  private final StructuredClientRegistry registry;

  public StructuredClientGuard(StructuredClientRegistry registry) {
    this.registry = registry;
  }

  public StructuredClient resolve(String clientId) {
    return registry
      .resolve(clientId)
      .orElseThrow(() ->
        GenericServerError
          .builder()
          .message(
            "No structured client is registered under ClientId '" +
            (clientId == null ? "" : clientId) +
            "'. Call CreateStructuredClient first and pass the returned ClientId."
          )
          .build()
      );
  }
}
