package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.TransactWriteItem;
import aws.cryptography.dbesdk.testserver.server.model.TransactWriteItemsInput;
import aws.cryptography.dbesdk.testserver.server.model.TransactWriteItemsOutput;
import aws.cryptography.dbesdk.testserver.server.model.TransactWriteItemsOutputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.TransactWriteItemsOutputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.TransactWriteItemsOutputTransformOperation;
import java.util.ArrayList;
import java.util.List;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsResponse;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Runs the DBE TransactWriteItems modify-after transform. The response carries
 * no item content, so this is a passthrough returning an empty output — but the
 * DBE library still validates the original request, so the transact-items (Put
 * actions only, mirroring the input transform) are mapped through.
 */
public final class TransactWriteItemsOutputTransformHandler
  implements TransactWriteItemsOutputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public TransactWriteItemsOutputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public TransactWriteItemsOutputTransformOutput transactWriteItemsOutputTransform(
    TransactWriteItemsOutputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "TransactWriteItemsOutputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        TransactWriteItemsInput wireInput = input.getOriginalInput();

        List<
          software.amazon.awssdk.services.dynamodb.model.TransactWriteItem
        > sdkItems = new ArrayList<>(wireInput.getTransactItems().size());
        for (TransactWriteItem item : wireInput.getTransactItems()) {
          sdkItems.add(TransactWriteItemCodec.toSdk(item, itemCodec));
        }

        client.transactWriteItemsOutputTransform(
          TransactWriteItemsRequest.builder().transactItems(sdkItems).build(),
          TransactWriteItemsResponse.builder().build()
        );
        return TransactWriteItemsOutputTransformOutput
          .builder()
          .transformedOutput(TransactWriteItemsOutput.builder().build())
          .build();
      }
    );
  }
}
