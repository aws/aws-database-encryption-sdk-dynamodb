package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.EncryptPathStructureInput;
import aws.cryptography.dbesdk.testserver.server.model.EncryptPathStructureOutput;
import aws.cryptography.dbesdk.testserver.server.registry.StructuredClient;
import aws.cryptography.dbesdk.testserver.server.service.EncryptPathStructureOperation;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the structured {@code ClientId}, maps the wire Crypto List onto the
 * DBE model, runs {@code EncryptPathStructure}, and maps the encrypted Crypto
 * List back to the wire shape. A DBE failure is forwarded as
 * {@code DBESDKClientError}; an unknown {@code ClientId} yields a
 * {@code GenericServerError} before any DBE call.
 */
public final class EncryptPathStructureHandler
  implements EncryptPathStructureOperation {

  private final StructuredClientGuard guard;
  private final OperationWrapper wrapper;
  private final StructuredDataCodec codec;

  public EncryptPathStructureHandler(
    StructuredClientGuard guard,
    OperationWrapper wrapper,
    StructuredDataCodec codec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.codec = codec;
  }

  @Override
  public EncryptPathStructureOutput encryptPathStructure(
    EncryptPathStructureInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "EncryptPathStructure",
      () -> {
        StructuredClient client = guard.resolve(input.getClientId());
        var encrypted = client.encryptPathStructure(
          input.getTableName(),
          codec.toDbeCryptoList(input.getPlaintextStructure())
        );
        return EncryptPathStructureOutput
          .builder()
          .encryptedStructure(codec.toWireCryptoList(encrypted))
          .build();
      }
    );
  }
}
