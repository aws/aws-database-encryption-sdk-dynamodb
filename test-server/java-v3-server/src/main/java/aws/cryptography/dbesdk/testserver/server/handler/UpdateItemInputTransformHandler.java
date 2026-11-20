package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.UpdateItemInput;
import aws.cryptography.dbesdk.testserver.server.model.UpdateItemInputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.UpdateItemInputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.UpdateItemInputTransformOperation;
import software.amazon.awssdk.services.dynamodb.model.UpdateItemRequest;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the wire {@code UpdateItemInput}
 * (key + UpdateExpression/ConditionExpression + name/value maps) onto a real AWS
 * SDK {@link UpdateItemRequest}, and runs the DBE validate-before transform. The
 * DBE library rejects the request with a {@code DBESDKClientError} when the
 * UpdateExpression references a signed attribute; otherwise the request passes
 * through unchanged.
 */
public final class UpdateItemInputTransformHandler
  implements UpdateItemInputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public UpdateItemInputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public UpdateItemInputTransformOutput updateItemInputTransform(
    UpdateItemInputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "UpdateItemInputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        UpdateItemInput wire = input.getSdkInput();

        UpdateItemRequest.Builder sdk = UpdateItemRequest
          .builder()
          .tableName(wire.getTableName())
          .key(itemCodec.toDdb(wire.getKey()));
        if (wire.getUpdateExpression() != null) {
          sdk.updateExpression(wire.getUpdateExpression());
        }
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

        UpdateItemRequest transformed = client.updateItemInputTransform(
          sdk.build()
        );

        UpdateItemInput.Builder out = UpdateItemInput
          .builder()
          .tableName(transformed.tableName())
          .key(itemCodec.toModel(transformed.key()));
        if (transformed.updateExpression() != null) {
          out.updateExpression(transformed.updateExpression());
        }
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
        return UpdateItemInputTransformOutput
          .builder()
          .transformedInput(out.build())
          .build();
      }
    );
  }
}
