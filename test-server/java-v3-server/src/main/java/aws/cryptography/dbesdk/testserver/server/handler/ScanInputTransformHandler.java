package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.ScanInput;
import aws.cryptography.dbesdk.testserver.server.model.ScanInputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.ScanInputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.ScanInputTransformOperation;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the wire {@code ScanInput}
 * (table + FilterExpression + name/value maps) onto a real AWS SDK
 * {@link ScanRequest}, runs the DBE modify-before transform (which rewrites
 * beacon-attribute references in the FilterExpression to their beacons), and
 * maps the transformed request back.
 */
public final class ScanInputTransformHandler
  implements ScanInputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public ScanInputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public ScanInputTransformOutput scanInputTransform(
    ScanInputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "ScanInputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        ScanInput wire = input.getSdkInput();

        ScanRequest.Builder sdk = ScanRequest
          .builder()
          .tableName(wire.getTableName());
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

        ScanRequest transformed = client.scanInputTransform(sdk.build());

        ScanInput.Builder out = ScanInput
          .builder()
          .tableName(transformed.tableName());
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
        return ScanInputTransformOutput
          .builder()
          .transformedInput(out.build())
          .build();
      }
    );
  }
}
