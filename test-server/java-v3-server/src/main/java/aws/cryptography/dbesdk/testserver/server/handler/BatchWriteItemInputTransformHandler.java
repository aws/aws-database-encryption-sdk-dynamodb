package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.BatchWriteItemInput;
import aws.cryptography.dbesdk.testserver.server.model.BatchWriteItemInputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.BatchWriteItemInputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.BatchWriteItemInputTransformOperation;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the minimal wire
 * {@code BatchWriteItemInput} onto a real AWS SDK
 * {@link BatchWriteItemRequest}, runs the DBE encrypt-before transform (which
 * encrypts every PutRequest item and leaves DeleteRequests untouched), and maps
 * the transformed request back.
 */
public final class BatchWriteItemInputTransformHandler
  implements BatchWriteItemInputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final WriteRequestCodec writeRequestCodec;

  public BatchWriteItemInputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    WriteRequestCodec writeRequestCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.writeRequestCodec = writeRequestCodec;
  }

  @Override
  public BatchWriteItemInputTransformOutput batchWriteItemInputTransform(
    BatchWriteItemInputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "BatchWriteItemInputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());

        BatchWriteItemRequest transformed = client.batchWriteItemInputTransform(
          BatchWriteItemRequest
            .builder()
            .requestItems(
              writeRequestCodec.toSdk(input.getSdkInput().getRequestItems())
            )
            .build()
        );

        return BatchWriteItemInputTransformOutput
          .builder()
          .transformedInput(
            BatchWriteItemInput
              .builder()
              .requestItems(
                writeRequestCodec.toWire(transformed.requestItems())
              )
              .build()
          )
          .build();
      }
    );
  }
}
