package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.DeleteItemInput;
import aws.cryptography.dbesdk.testserver.server.model.DeleteItemOutput;
import aws.cryptography.dbesdk.testserver.server.model.DeleteItemOutputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.DeleteItemOutputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.DeleteItemOutputTransformOperation;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemResponse;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Runs the DBE DeleteItem modify-after transform. The original input is
 * reconstructed from its table + key; a response with no attributes passes
 * through with none. Twin of {@link PutItemOutputTransformHandler}.
 */
public final class DeleteItemOutputTransformHandler
  implements DeleteItemOutputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public DeleteItemOutputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public DeleteItemOutputTransformOutput deleteItemOutputTransform(
    DeleteItemOutputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "DeleteItemOutputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        DeleteItemInput wireInput = input.getOriginalInput();
        DeleteItemOutput wireOutput = input.getSdkOutput();

        DeleteItemRequest originalInput = DeleteItemRequest
          .builder()
          .tableName(wireInput.getTableName())
          .key(itemCodec.toDdb(wireInput.getKey()))
          .build();

        DeleteItemResponse.Builder sdkOutput = DeleteItemResponse.builder();
        if (wireOutput.getAttributes() != null) {
          sdkOutput.attributes(itemCodec.toDdb(wireOutput.getAttributes()));
        }

        DeleteItemResponse transformed = client.deleteItemOutputTransform(
          originalInput,
          sdkOutput.build()
        );

        DeleteItemOutput.Builder result = DeleteItemOutput.builder();
        if (
          transformed.hasAttributes() && !transformed.attributes().isEmpty()
        ) {
          result.attributes(itemCodec.toModel(transformed.attributes()));
        }
        return DeleteItemOutputTransformOutput
          .builder()
          .transformedOutput(result.build())
          .build();
      }
    );
  }
}
