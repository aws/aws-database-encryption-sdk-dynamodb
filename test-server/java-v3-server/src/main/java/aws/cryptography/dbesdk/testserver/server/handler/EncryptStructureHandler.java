package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.EncryptStructureInput;
import aws.cryptography.dbesdk.testserver.server.model.EncryptStructureOutput;
import aws.cryptography.dbesdk.testserver.server.registry.StructuredClient;
import aws.cryptography.dbesdk.testserver.server.service.EncryptStructureOperation;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the structured {@code ClientId}, maps the wire structured data +
 * Crypto Schema onto the DBE model, runs {@code EncryptStructure}, and maps the
 * encrypted structure back to the wire shape. A DBE failure is forwarded as
 * {@code DBESDKClientError}; a missing/unknown {@code ClientId} yields a
 * {@code GenericServerError} before any DBE call.
 */
public final class EncryptStructureHandler
  implements EncryptStructureOperation {

  private final StructuredClientGuard guard;
  private final OperationWrapper wrapper;
  private final StructuredDataCodec codec;

  public EncryptStructureHandler(
    StructuredClientGuard guard,
    OperationWrapper wrapper,
    StructuredDataCodec codec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.codec = codec;
  }

  @Override
  public EncryptStructureOutput encryptStructure(
    EncryptStructureInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "EncryptStructure",
      () -> {
        StructuredClient client = guard.resolve(input.getClientId());
        var encrypted = client.encryptStructure(
          input.getTableName(),
          codec.toDbe(input.getPlaintextStructure()),
          codec.toDbeCryptoSchema(input.getCryptoSchema())
        );
        return EncryptStructureOutput
          .builder()
          .encryptedStructure(codec.toWire(encrypted))
          .build();
      }
    );
  }
}
