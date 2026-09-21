package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.UpdateItemInput;
import aws.cryptography.dbesdk.testserver.server.model.UpdateItemOutput;
import aws.cryptography.dbesdk.testserver.server.model.UpdateItemOutputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.UpdateItemOutputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.UpdateItemOutputTransformOperation;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemResponse;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Runs the DBE UpdateItem modify-after transform. The output transform's
 * behavior depends only on the table's config, so the original input is
 * reconstructed from its table + key; a response with no attributes passes
 * through with none. Twin of {@link PutItemOutputTransformHandler}.
 */
public final class UpdateItemOutputTransformHandler
  implements UpdateItemOutputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public UpdateItemOutputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public UpdateItemOutputTransformOutput updateItemOutputTransform(
    UpdateItemOutputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "UpdateItemOutputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        UpdateItemInput wireInput = input.getOriginalInput();
        UpdateItemOutput wireOutput = input.getSdkOutput();

        UpdateItemRequest originalInput = UpdateItemRequest
          .builder()
          .tableName(wireInput.getTableName())
          .key(itemCodec.toDdb(wireInput.getKey()))
          .build();

        UpdateItemResponse.Builder sdkOutput = UpdateItemResponse.builder();
        if (wireOutput.getAttributes() != null) {
          sdkOutput.attributes(itemCodec.toDdb(wireOutput.getAttributes()));
        }

        UpdateItemResponse transformed = client.updateItemOutputTransform(
          originalInput,
          sdkOutput.build()
        );

        UpdateItemOutput.Builder result = UpdateItemOutput.builder();
        if (
          transformed.hasAttributes() && !transformed.attributes().isEmpty()
        ) {
          result.attributes(itemCodec.toModel(transformed.attributes()));
        }
        return UpdateItemOutputTransformOutput
          .builder()
          .transformedOutput(result.build())
          .build();
      }
    );
  }
}
