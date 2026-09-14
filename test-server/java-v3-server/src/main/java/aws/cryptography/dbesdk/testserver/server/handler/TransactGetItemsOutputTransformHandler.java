package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.Get;
import aws.cryptography.dbesdk.testserver.server.model.ItemResponse;
import aws.cryptography.dbesdk.testserver.server.model.TransactGetItem;
import aws.cryptography.dbesdk.testserver.server.model.TransactGetItemsInput;
import aws.cryptography.dbesdk.testserver.server.model.TransactGetItemsOutput;
import aws.cryptography.dbesdk.testserver.server.model.TransactGetItemsOutputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.TransactGetItemsOutputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.TransactGetItemsOutputTransformOperation;
import java.util.ArrayList;
import java.util.List;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsRequest;
import software.amazon.awssdk.services.dynamodb.model.TransactGetItemsResponse;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Runs the DBE TransactGetItems modify-after transform. Each response's item is
 * decrypted using the table named by the parallel Get; with an unconfigured
 * table the items pass through unchanged.
 */
public final class TransactGetItemsOutputTransformHandler
  implements TransactGetItemsOutputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public TransactGetItemsOutputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public TransactGetItemsOutputTransformOutput transactGetItemsOutputTransform(
    TransactGetItemsOutputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "TransactGetItemsOutputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        TransactGetItemsInput wireInput = input.getOriginalInput();
        TransactGetItemsOutput wireOutput = input.getSdkOutput();

        List<
          software.amazon.awssdk.services.dynamodb.model.TransactGetItem
        > sdkItems = new ArrayList<>(wireInput.getTransactItems().size());
        for (TransactGetItem item : wireInput.getTransactItems()) {
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
        TransactGetItemsRequest originalInput = TransactGetItemsRequest
          .builder()
          .transactItems(sdkItems)
          .build();

        TransactGetItemsResponse.Builder sdkOutput =
          TransactGetItemsResponse.builder();
        if (wireOutput.getResponses() != null) {
          List<
            software.amazon.awssdk.services.dynamodb.model.ItemResponse
          > sdkResponses = new ArrayList<>(wireOutput.getResponses().size());
          for (ItemResponse r : wireOutput.getResponses()) {
            software.amazon.awssdk.services.dynamodb.model.ItemResponse.Builder b =
              software.amazon.awssdk.services.dynamodb.model.ItemResponse.builder();
            if (r.getItem() != null) {
              b.item(itemCodec.toDdb(r.getItem()));
            }
            sdkResponses.add(b.build());
          }
          sdkOutput.responses(sdkResponses);
        }

        TransactGetItemsResponse transformed =
          client.transactGetItemsOutputTransform(
            originalInput,
            sdkOutput.build()
          );

        TransactGetItemsOutput.Builder result =
          TransactGetItemsOutput.builder();
        if (transformed.hasResponses()) {
          List<ItemResponse> wireResponses = new ArrayList<>(
            transformed.responses().size()
          );
          for (software.amazon.awssdk.services.dynamodb.model.ItemResponse r : transformed.responses()) {
            ItemResponse.Builder b = ItemResponse.builder();
            if (r.hasItem() && !r.item().isEmpty()) {
              b.item(itemCodec.toModel(r.item()));
            }
            wireResponses.add(b.build());
          }
          result.responses(wireResponses);
        }
        return TransactGetItemsOutputTransformOutput
          .builder()
          .transformedOutput(result.build())
          .build();
      }
    );
  }
}
