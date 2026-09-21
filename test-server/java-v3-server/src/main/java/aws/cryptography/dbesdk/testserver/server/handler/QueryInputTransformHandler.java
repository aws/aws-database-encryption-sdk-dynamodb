package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.QueryInput;
import aws.cryptography.dbesdk.testserver.server.model.QueryInputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.QueryInputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.QueryInputTransformOperation;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the wire {@code QueryInput}
 * (table + KeyCondition/Filter expressions + name/value maps) onto a real AWS
 * SDK {@link QueryRequest}, runs the DBE modify-before transform (which rewrites
 * beacon-attribute references to their beacons), and maps the transformed
 * request back.
 */
public final class QueryInputTransformHandler
  implements QueryInputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public QueryInputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public QueryInputTransformOutput queryInputTransform(
    QueryInputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "QueryInputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        QueryInput wire = input.getSdkInput();

        QueryRequest.Builder sdk = QueryRequest
          .builder()
          .tableName(wire.getTableName());
        if (wire.getKeyConditionExpression() != null) {
          sdk.keyConditionExpression(wire.getKeyConditionExpression());
        }
        if (wire.getFilterExpression() != null) {
          sdk.filterExpression(wire.getFilterExpression());
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

        QueryRequest transformed = client.queryInputTransform(sdk.build());

        QueryInput.Builder out = QueryInput
          .builder()
          .tableName(transformed.tableName());
        if (transformed.keyConditionExpression() != null) {
          out.keyConditionExpression(transformed.keyConditionExpression());
        }
        if (transformed.filterExpression() != null) {
          out.filterExpression(transformed.filterExpression());
        }
        if (transformed.hasExpressionAttributeNames()) {
          out.expressionAttributeNames(transformed.expressionAttributeNames());
        }
        if (transformed.hasExpressionAttributeValues()) {
          out.expressionAttributeValues(
            itemCodec.toModel(transformed.expressionAttributeValues())
          );
        }
        return QueryInputTransformOutput
          .builder()
          .transformedInput(out.build())
          .build();
      }
    );
  }
}
