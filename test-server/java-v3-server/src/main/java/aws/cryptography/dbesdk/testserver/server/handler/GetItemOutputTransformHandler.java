package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.GetItemInput;
import aws.cryptography.dbesdk.testserver.server.model.GetItemOutput;
import aws.cryptography.dbesdk.testserver.server.model.GetItemOutputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.GetItemOutputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.GetItemOutputTransformOperation;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the minimal wire
 * {@code GetItemOutput} / {@code GetItemInput} onto real AWS SDK
 * {@link GetItemResponse} / {@link GetItemRequest}, runs the DBE GetItem
 * decrypt-after transform, and maps the transformed response back to the wire
 * shape. A GetItem output with no item passes through with no item.
 */
public final class GetItemOutputTransformHandler
  implements GetItemOutputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public GetItemOutputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public GetItemOutputTransformOutput getItemOutputTransform(
    GetItemOutputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "GetItemOutputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        GetItemInput wireInput = input.getOriginalInput();
        GetItemOutput wireOutput = input.getSdkOutput();

        GetItemRequest originalInput = GetItemRequest
          .builder()
          .tableName(wireInput.getTableName())
          .key(itemCodec.toDdb(wireInput.getKey()))
          .build();

        GetItemResponse.Builder sdkOutput = GetItemResponse.builder();
        if (wireOutput.getItem() != null) {
          sdkOutput.item(itemCodec.toDdb(wireOutput.getItem()));
        }

        GetItemResponse transformed = client.getItemOutputTransform(
          originalInput,
          sdkOutput.build()
        );

        GetItemOutput.Builder result = GetItemOutput.builder();
        if (transformed.hasItem() && !transformed.item().isEmpty()) {
          result.item(itemCodec.toModel(transformed.item()));
        }
        return GetItemOutputTransformOutput
          .builder()
          .transformedOutput(result.build())
          .build();
      }
    );
  }
}
