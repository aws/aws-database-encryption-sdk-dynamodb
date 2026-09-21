package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.Get;
import aws.cryptography.dbesdk.testserver.server.model.TransactGetItem;
import aws.cryptography.dbesdk.testserver.server.model.TransactGetItemsInput;
import aws.cryptography.dbesdk.testserver.server.model.TransactGetItemsInputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.TransactGetItemsInputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.TransactGetItemsInputTransformOperation;
import java.util.ArrayList;
import java.util.List;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsRequest;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the wire
 * {@code TransactGetItemsInput} (a Get per transact item) onto a real AWS SDK
 * {@link TransactGetItemsRequest}, runs the modify-before transform (a
 * passthrough when no beacon config is present), and maps the result back.
 */
public final class TransactGetItemsInputTransformHandler
  implements TransactGetItemsInputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public TransactGetItemsInputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public TransactGetItemsInputTransformOutput transactGetItemsInputTransform(
    TransactGetItemsInputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "TransactGetItemsInputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        TransactGetItemsInput wire = input.getSdkInput();

        List<
          software.amazon.awssdk.services.dynamodb.model.TransactGetItem
        > sdkItems = new ArrayList<>(wire.getTransactItems().size());
        for (TransactGetItem item : wire.getTransactItems()) {
          Get get = item.getGet();
          sdkItems.add(
            software.amazon.awssdk.services.dynamodb.model.TransactGetItem
              .builder()
              .get(
                software.amazon.awssdk.services.dynamodb.model.Get
                  .builder()
                  .tableName(get.getTableName())
                  .key(itemCodec.toDdb(get.getKey()))
                  .build()
              )
              .build()
          );
        }

        TransactGetItemsRequest transformed =
          client.transactGetItemsInputTransform(
            TransactGetItemsRequest.builder().transactItems(sdkItems).build()
          );

        List<TransactGetItem> wireItems = new ArrayList<>(
          transformed.transactItems().size()
        );
        for (software.amazon.awssdk.services.dynamodb.model.TransactGetItem item : transformed.transactItems()) {
          software.amazon.awssdk.services.dynamodb.model.Get get = item.get();
          wireItems.add(
            TransactGetItem
              .builder()
              .get(
                Get
                  .builder()
                  .tableName(get.tableName())
                  .key(itemCodec.toModel(get.key()))
                  .build()
              )
              .build()
          );
        }
        return TransactGetItemsInputTransformOutput
          .builder()
          .transformedInput(
            TransactGetItemsInput.builder().transactItems(wireItems).build()
          )
          .build();
      }
    );
  }
}
