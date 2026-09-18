package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.PutItemInput;
import aws.cryptography.dbesdk.testserver.server.model.PutItemOutput;
import aws.cryptography.dbesdk.testserver.server.model.PutItemOutputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.PutItemOutputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.PutItemOutputTransformOperation;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the wire {@code PutItemInput} /
 * {@code PutItemOutput} onto real AWS SDK {@link PutItemRequest} /
 * {@link PutItemResponse}, runs the DBE PutItem modify-after transform, and maps
 * the result back. A PutItem output with no attributes passes through with none.
 */
public final class PutItemOutputTransformHandler
  implements PutItemOutputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public PutItemOutputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public PutItemOutputTransformOutput putItemOutputTransform(
    PutItemOutputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "PutItemOutputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        PutItemInput wireInput = input.getOriginalInput();
        PutItemOutput wireOutput = input.getSdkOutput();

        PutItemRequest originalInput = PutItemRequest
          .builder()
          .tableName(wireInput.getTableName())
          .item(itemCodec.toDdb(wireInput.getItem()))
          .build();

        PutItemResponse.Builder sdkOutput = PutItemResponse.builder();
        if (wireOutput.getAttributes() != null) {
          sdkOutput.attributes(itemCodec.toDdb(wireOutput.getAttributes()));
        }

        PutItemResponse transformed = client.putItemOutputTransform(
          originalInput,
          sdkOutput.build()
        );

        PutItemOutput.Builder result = PutItemOutput.builder();
        if (
          transformed.hasAttributes() && !transformed.attributes().isEmpty()
        ) {
          result.attributes(itemCodec.toModel(transformed.attributes()));
        }
        return PutItemOutputTransformOutput
          .builder()
          .transformedOutput(result.build())
          .build();
      }
    );
  }
}
