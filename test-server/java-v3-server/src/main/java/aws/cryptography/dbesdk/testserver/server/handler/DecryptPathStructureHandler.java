package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.DecryptPathStructureInput;
import aws.cryptography.dbesdk.testserver.server.model.DecryptPathStructureOutput;
import aws.cryptography.dbesdk.testserver.server.registry.StructuredClient;
import aws.cryptography.dbesdk.testserver.server.service.DecryptPathStructureOperation;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the structured {@code ClientId}, maps the wire Auth List onto the DBE
 * model, runs {@code DecryptPathStructure}, and maps the recovered Crypto List
 * back to the wire shape. A DBE failure (e.g. a signature mismatch) is forwarded
 * as {@code DBESDKClientError}.
 */
public final class DecryptPathStructureHandler
  implements DecryptPathStructureOperation {

  private final StructuredClientGuard guard;
  private final OperationWrapper wrapper;
  private final StructuredDataCodec codec;

  public DecryptPathStructureHandler(
    StructuredClientGuard guard,
    OperationWrapper wrapper,
    StructuredDataCodec codec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.codec = codec;
  }

  @Override
  public DecryptPathStructureOutput decryptPathStructure(
    DecryptPathStructureInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "DecryptPathStructure",
      () -> {
        StructuredClient client = guard.resolve(input.getClientId());
        var plaintext = client.decryptPathStructure(
          input.getTableName(),
          codec.toDbeAuthList(input.getEncryptedStructure())
        );
        return DecryptPathStructureOutput
          .builder()
          .plaintextStructure(codec.toWireCryptoList(plaintext))
          .build();
      }
    );
  }
}
