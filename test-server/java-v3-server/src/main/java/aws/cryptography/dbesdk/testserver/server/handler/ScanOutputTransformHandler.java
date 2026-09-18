package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.AttributeValue;
import aws.cryptography.dbesdk.testserver.server.model.ScanInput;
import aws.cryptography.dbesdk.testserver.server.model.ScanOutput;
import aws.cryptography.dbesdk.testserver.server.model.ScanOutputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.ScanOutputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.ScanOutputTransformOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the minimal wire
 * {@code ScanOutput} / {@code ScanInput} onto a real AWS SDK
 * {@link ScanResponse} / {@link ScanRequest}, runs the DBE decrypt-after
 * transform, and maps every decrypted item back. A Scan output with no items
 * passes through with no items.
 */
public final class ScanOutputTransformHandler
  implements ScanOutputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public ScanOutputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public ScanOutputTransformOutput scanOutputTransform(
    ScanOutputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "ScanOutputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        ScanInput wireInput = input.getOriginalInput();
        ScanOutput wireOutput = input.getSdkOutput();

        ScanRequest.Builder originalBuilder = ScanRequest
          .builder()
          .tableName(wireInput.getTableName());
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
        ScanRequest originalInput = originalBuilder.build();

        ScanResponse.Builder sdkOutput = ScanResponse.builder();
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

        ScanResponse transformed = client.scanOutputTransform(
          originalInput,
          sdkOutput.build()
        );

        ScanOutput.Builder result = ScanOutput.builder();
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
        return ScanOutputTransformOutput
          .builder()
          .transformedOutput(result.build())
          .build();
      }
    );
  }
}
