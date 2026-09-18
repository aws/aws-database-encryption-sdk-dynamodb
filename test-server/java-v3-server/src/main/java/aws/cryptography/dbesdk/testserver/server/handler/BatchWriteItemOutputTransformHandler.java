package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.BatchWriteItemOutput;
import aws.cryptography.dbesdk.testserver.server.model.BatchWriteItemOutputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.BatchWriteItemOutputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.BatchWriteItemOutputTransformOperation;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemResponse;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the wire
 * {@code BatchWriteItemOutput} (UnprocessedItems) and the original
 * {@code BatchWriteItemInput} onto real AWS SDK types, and runs the DBE
 * decrypt-after transform. Each unprocessed PutRequest item is restored to its
 * original plaintext value (matched against the original request by primary
 * key); a response with no UnprocessedItems is returned unchanged.
 */
public final class BatchWriteItemOutputTransformHandler
  implements BatchWriteItemOutputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final WriteRequestCodec writeRequestCodec;

  public BatchWriteItemOutputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    WriteRequestCodec writeRequestCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.writeRequestCodec = writeRequestCodec;
  }

  @Override
  public BatchWriteItemOutputTransformOutput batchWriteItemOutputTransform(
    BatchWriteItemOutputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "BatchWriteItemOutputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());

        BatchWriteItemRequest originalInput = BatchWriteItemRequest
          .builder()
          .requestItems(
            writeRequestCodec.toSdk(input.getOriginalInput().getRequestItems())
          )
          .build();

        BatchWriteItemResponse.Builder sdkOutput =
          BatchWriteItemResponse.builder();
        if (input.getSdkOutput().getUnprocessedItems() != null) {
          sdkOutput.unprocessedItems(
            writeRequestCodec.toSdk(input.getSdkOutput().getUnprocessedItems())
          );
        }

        BatchWriteItemResponse transformed =
          client.batchWriteItemOutputTransform(
            originalInput,
            sdkOutput.build()
          );

        BatchWriteItemOutput.Builder result = BatchWriteItemOutput.builder();
        if (transformed.hasUnprocessedItems()) {
          result.unprocessedItems(
            writeRequestCodec.toWire(transformed.unprocessedItems())
          );
        }
        return BatchWriteItemOutputTransformOutput
          .builder()
          .transformedOutput(result.build())
          .build();
      }
    );
  }
}
