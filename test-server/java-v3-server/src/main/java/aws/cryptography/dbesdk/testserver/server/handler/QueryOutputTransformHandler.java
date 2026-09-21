package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.AttributeValue;
import aws.cryptography.dbesdk.testserver.server.model.QueryInput;
import aws.cryptography.dbesdk.testserver.server.model.QueryOutput;
import aws.cryptography.dbesdk.testserver.server.model.QueryOutputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.QueryOutputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.QueryOutputTransformOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.QueryRequest;
import software.amazon.awssdk.services.dynamodb.model.QueryResponse;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the minimal wire
 * {@code QueryOutput} / {@code QueryInput} onto a real AWS SDK
 * {@link QueryResponse} / {@link QueryRequest}, runs the DBE decrypt-after
 * transform, and maps every decrypted item back. A Query output with no items
 * passes through with no items.
 */
public final class QueryOutputTransformHandler
  implements QueryOutputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public QueryOutputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public QueryOutputTransformOutput queryOutputTransform(
    QueryOutputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "QueryOutputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        QueryInput wireInput = input.getOriginalInput();
        QueryOutput wireOutput = input.getSdkOutput();

        QueryRequest.Builder originalBuilder = QueryRequest
          .builder()
          .tableName(wireInput.getTableName());
        if (wireInput.getKeyConditionExpression() != null) {
          originalBuilder.keyConditionExpression(
            wireInput.getKeyConditionExpression()
          );
        }
        if (wireInput.getFilterExpression() != null) {
          originalBuilder.filterExpression(wireInput.getFilterExpression());
        }
        if (wireInput.getExpressionAttributeNames() != null) {
          originalBuilder.expressionAttributeNames(
            wireInput.getExpressionAttributeNames()
          );
        }
        if (wireInput.getExpressionAttributeValues() != null) {
          originalBuilder.expressionAttributeValues(
            itemCodec.toDdb(wireInput.getExpressionAttributeValues())
          );
        }
        QueryRequest originalInput = originalBuilder.build();

        QueryResponse.Builder sdkOutput = QueryResponse.builder();
        if (wireOutput.getItems() != null) {
          List<
            Map<
              String,
              software.amazon.awssdk.services.dynamodb.model.AttributeValue
            >
          > sdkItems = new ArrayList<>(wireOutput.getItems().size());
          for (Map<String, AttributeValue> item : wireOutput.getItems()) {
            sdkItems.add(itemCodec.toDdb(item));
          }
          sdkOutput.items(sdkItems);
        }

        QueryResponse transformed = client.queryOutputTransform(
          originalInput,
          sdkOutput.build()
        );

        QueryOutput.Builder result = QueryOutput.builder();
        if (transformed.hasItems()) {
          List<Map<String, AttributeValue>> wireItems = new ArrayList<>(
            transformed.items().size()
          );
          for (Map<
            String,
            software.amazon.awssdk.services.dynamodb.model.AttributeValue
          > item : transformed.items()) {
            wireItems.add(itemCodec.toModel(item));
          }
          result.items(wireItems);
        }
        return QueryOutputTransformOutput
          .builder()
          .transformedOutput(result.build())
          .build();
      }
    );
  }
}
