package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.DeleteItemInput;
import aws.cryptography.dbesdk.testserver.server.model.DeleteItemInputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.DeleteItemInputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.DeleteItemInputTransformOperation;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the wire {@code DeleteItemInput}
 * (key + ConditionExpression + name/value maps) onto a real AWS SDK
 * {@link DeleteItemRequest}, and runs the DBE validate-before transform. The DBE
 * library rejects the request with a {@code DBESDKClientError} when the
 * ConditionExpression references an encrypted attribute; otherwise the request
 * passes through unchanged.
 */
public final class DeleteItemInputTransformHandler
  implements DeleteItemInputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public DeleteItemInputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public DeleteItemInputTransformOutput deleteItemInputTransform(
    DeleteItemInputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "DeleteItemInputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        DeleteItemInput wire = input.getSdkInput();

        DeleteItemRequest.Builder sdk = DeleteItemRequest
          .builder()
          .tableName(wire.getTableName())
          .key(itemCodec.toDdb(wire.getKey()));
        if (wire.getConditionExpression() != null) {
          sdk.conditionExpression(wire.getConditionExpression());
        }
        if (
          wire.getExpressionAttributeNames() != null &&
          !wire.getExpressionAttributeNames().isEmpty()
        ) {
          sdk.expressionAttributeNames(wire.getExpressionAttributeNames());
        }
        if (
          wire.getExpressionAttributeValues() != null &&
          !wire.getExpressionAttributeValues().isEmpty()
        ) {
          sdk.expressionAttributeValues(
            itemCodec.toDdb(wire.getExpressionAttributeValues())
          );
        }

        DeleteItemRequest transformed = client.deleteItemInputTransform(
          sdk.build()
        );

        DeleteItemInput.Builder out = DeleteItemInput
          .builder()
          .tableName(transformed.tableName())
          .key(itemCodec.toModel(transformed.key()));
        if (transformed.conditionExpression() != null) {
          out.conditionExpression(transformed.conditionExpression());
        }
        if (transformed.hasExpressionAttributeNames()) {
          out.expressionAttributeNames(transformed.expressionAttributeNames());
        }
        if (transformed.hasExpressionAttributeValues()) {
          out.expressionAttributeValues(
            itemCodec.toModel(transformed.expressionAttributeValues())
          );
        }
        return DeleteItemInputTransformOutput
          .builder()
          .transformedInput(out.build())
          .build();
      }
    );
  }
}
