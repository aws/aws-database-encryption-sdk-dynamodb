package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.EncryptItemInput;
import aws.cryptography.dbesdk.testserver.server.model.EncryptItemOutput;
import aws.cryptography.dbesdk.testserver.server.registry.DbesdkClient;
import aws.cryptography.dbesdk.testserver.server.service.EncryptItemOperation;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the {@code ClientId}, calls {@code EncryptItem} on the referenced
 * real DBE item encryptor, and returns the encrypted item. A DBE failure is
 * forwarded as {@code DBESDKClientError} with no encryptedItem and an unchanged
 * registry; a missing/unknown {@code ClientId} yields a
 * {@code GenericServerError} before any DBE call.
 */
public final class EncryptItemHandler implements EncryptItemOperation {

  private final ClientIdGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public EncryptItemHandler(
    ClientIdGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public EncryptItemOutput encryptItem(
    EncryptItemInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "EncryptItem",
      () -> {
        DbesdkClient client = guard.resolve(input.getClientId());
        return EncryptItemOutput
          .builder()
          .encryptedItem(
            itemCodec.toModel(
              client.encryptItem(itemCodec.toDdb(input.getPlaintextItem()))
            )
          )
          .build();
      }
    );
  }
}
