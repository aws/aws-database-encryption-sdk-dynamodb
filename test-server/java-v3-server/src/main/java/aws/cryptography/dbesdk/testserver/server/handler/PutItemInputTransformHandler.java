package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.PutItemInput;
import aws.cryptography.dbesdk.testserver.server.model.PutItemInputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.PutItemInputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.PutItemInputTransformOperation;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the minimal wire
 * {@code PutItemInput} onto a real AWS SDK {@link PutItemRequest}, runs the DBE
 * PutItem encrypt-before transform, and maps the transformed request back to
 * the wire shape. A DBE failure is forwarded as {@code DBESDKClientError}; a
 * missing/unknown {@code ClientId} yields a {@code GenericServerError} before
 * any DBE call.
 */
public final class PutItemInputTransformHandler
  implements PutItemInputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public PutItemInputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public PutItemInputTransformOutput putItemInputTransform(
    PutItemInputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "PutItemInputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        PutItemInput wireInput = input.getSdkInput();

        PutItemRequest sdkInput = PutItemRequest
          .builder()
          .tableName(wireInput.getTableName())
          .item(itemCodec.toDdb(wireInput.getItem()))
          .build();

        PutItemRequest transformed = client.putItemInputTransform(sdkInput);

        return PutItemInputTransformOutput
          .builder()
          .transformedInput(
            PutItemInput
              .builder()
              .tableName(transformed.tableName())
              .item(itemCodec.toModel(transformed.item()))
              .build()
          )
          .build();
      }
    );
  }
}
