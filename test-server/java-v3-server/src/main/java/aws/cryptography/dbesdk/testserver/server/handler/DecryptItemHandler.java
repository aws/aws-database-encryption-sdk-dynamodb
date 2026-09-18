package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.DecryptItemInput;
import aws.cryptography.dbesdk.testserver.server.model.DecryptItemOutput;
import aws.cryptography.dbesdk.testserver.server.registry.DbesdkClient;
import aws.cryptography.dbesdk.testserver.server.service.DecryptItemOperation;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the {@code ClientId}, calls {@code DecryptItem} on the referenced
 * real DBE item encryptor, and returns the plaintext item. A DBE failure is
 * forwarded as {@code DBESDKClientError} with no plaintextItem; a missing or
 * unknown {@code ClientId} yields a {@code GenericServerError} before any DBE
 * call.
 */
public final class DecryptItemHandler implements DecryptItemOperation {

  private final ClientIdGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public DecryptItemHandler(
    ClientIdGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public DecryptItemOutput decryptItem(
    DecryptItemInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "DecryptItem",
      () -> {
        DbesdkClient client = guard.resolve(input.getClientId());
        return DecryptItemOutput
          .builder()
          .plaintextItem(
            itemCodec.toModel(
              client.decryptItem(itemCodec.toDdb(input.getEncryptedItem()))
            )
          )
          .build();
      }
    );
  }
}
