package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.DecryptStructureInput;
import aws.cryptography.dbesdk.testserver.server.model.DecryptStructureOutput;
import aws.cryptography.dbesdk.testserver.server.registry.StructuredClient;
import aws.cryptography.dbesdk.testserver.server.service.DecryptStructureOperation;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the structured {@code ClientId}, maps the wire encrypted structure +
 * Authenticate Schema onto the DBE model, runs {@code DecryptStructure}
 * (verifying the signature and decrypting encrypted terminals), and maps the
 * recovered plaintext back to the wire shape. A DBE failure is forwarded as
 * {@code DBESDKClientError}; a missing/unknown {@code ClientId} yields a
 * {@code GenericServerError} before any DBE call.
 */
public final class DecryptStructureHandler
  implements DecryptStructureOperation {

  private final StructuredClientGuard guard;
  private final OperationWrapper wrapper;
  private final StructuredDataCodec codec;

  public DecryptStructureHandler(
    StructuredClientGuard guard,
    OperationWrapper wrapper,
    StructuredDataCodec codec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.codec = codec;
  }

  @Override
  public DecryptStructureOutput decryptStructure(
    DecryptStructureInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "DecryptStructure",
      () -> {
        StructuredClient client = guard.resolve(input.getClientId());
        var plaintext = client.decryptStructure(
          input.getTableName(),
          codec.toDbe(input.getEncryptedStructure()),
          codec.toDbeAuthenticateSchema(input.getAuthenticateSchema())
        );
        return DecryptStructureOutput
          .builder()
          .plaintextStructure(codec.toWire(plaintext))
          .build();
      }
    );
  }
}
