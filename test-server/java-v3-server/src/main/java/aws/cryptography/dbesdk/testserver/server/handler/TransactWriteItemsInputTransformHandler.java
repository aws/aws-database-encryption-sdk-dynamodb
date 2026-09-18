package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.TransactWriteItem;
import aws.cryptography.dbesdk.testserver.server.model.TransactWriteItemsInput;
import aws.cryptography.dbesdk.testserver.server.model.TransactWriteItemsInputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.TransactWriteItemsInputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.TransactWriteItemsInputTransformOperation;
import java.util.ArrayList;
import java.util.List;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the minimal wire
 * {@code TransactWriteItemsInput} onto a real AWS SDK
 * {@link software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsRequest},
 * runs the DBE encrypt-before transform (which encrypts every Put action's
 * item), and maps the transformed request back. Only the Put action is modeled;
 * a transact item with no Put is rejected.
 */
public final class TransactWriteItemsInputTransformHandler
  implements TransactWriteItemsInputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public TransactWriteItemsInputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public TransactWriteItemsInputTransformOutput transactWriteItemsInputTransform(
    TransactWriteItemsInputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "TransactWriteItemsInputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        TransactWriteItemsInput wireInput = input.getSdkInput();

        List<
          software.amazon.awssdk.services.dynamodb.model.TransactWriteItem
        > sdkItems = new ArrayList<>(wireInput.getTransactItems().size());
        for (TransactWriteItem item : wireInput.getTransactItems()) {
          sdkItems.add(TransactWriteItemCodec.toSdk(item, itemCodec));
        }

        software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsRequest transformed =
          client.transactWriteItemsInputTransform(
            software.amazon.awssdk.services.dynamodb.model.TransactWriteItemsRequest
              .builder()
              .transactItems(sdkItems)
              .build()
          );

        List<TransactWriteItem> wireItems = new ArrayList<>(
          transformed.transactItems().size()
        );
        for (software.amazon.awssdk.services.dynamodb.model.TransactWriteItem item : transformed.transactItems()) {
          wireItems.add(TransactWriteItemCodec.toWire(item, itemCodec));
        }

        return TransactWriteItemsInputTransformOutput
          .builder()
          .transformedInput(
            TransactWriteItemsInput.builder().transactItems(wireItems).build()
          )
          .build();
      }
    );
  }
}
