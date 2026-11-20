package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.AttributeValue;
import aws.cryptography.dbesdk.testserver.server.model.BatchGetItemInput;
import aws.cryptography.dbesdk.testserver.server.model.BatchGetItemInputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.BatchGetItemInputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.model.KeysAndAttributes;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.BatchGetItemInputTransformOperation;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemRequest;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the wire {@code BatchGetItemInput}
 * (per-table keys) onto a real AWS SDK {@link BatchGetItemRequest}, runs the
 * modify-before transform (a passthrough when no beacon config is present), and
 * maps the result back.
 */
public final class BatchGetItemInputTransformHandler
  implements BatchGetItemInputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public BatchGetItemInputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public BatchGetItemInputTransformOutput batchGetItemInputTransform(
    BatchGetItemInputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "BatchGetItemInputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        BatchGetItemInput wire = input.getSdkInput();

        BatchGetItemRequest transformed = client.batchGetItemInputTransform(
          BatchGetItemRequest
            .builder()
            .requestItems(toSdkRequestItems(wire.getRequestItems()))
            .build()
        );

        Map<String, KeysAndAttributes> wireItems = new LinkedHashMap<>();
        for (Map.Entry<
          String,
          software.amazon.awssdk.services.dynamodb.model.KeysAndAttributes
        > table : transformed.requestItems().entrySet()) {
          List<Map<String, AttributeValue>> keys = new ArrayList<>(
            table.getValue().keys().size()
          );
          for (Map<
            String,
            software.amazon.awssdk.services.dynamodb.model.AttributeValue
          > key : table.getValue().keys()) {
            keys.add(itemCodec.toModel(key));
          }
          wireItems.put(
            table.getKey(),
            KeysAndAttributes.builder().keys(keys).build()
          );
        }
        return BatchGetItemInputTransformOutput
          .builder()
          .transformedInput(
            BatchGetItemInput.builder().requestItems(wireItems).build()
          )
          .build();
      }
    );
  }

  private Map<
    String,
    software.amazon.awssdk.services.dynamodb.model.KeysAndAttributes
  > toSdkRequestItems(Map<String, KeysAndAttributes> wire) {
    Map<
      String,
      software.amazon.awssdk.services.dynamodb.model.KeysAndAttributes
    > out = new LinkedHashMap<>();
    for (Map.Entry<String, KeysAndAttributes> table : wire.entrySet()) {
      List<
        Map<
          String,
          software.amazon.awssdk.services.dynamodb.model.AttributeValue
        >
      > keys = new ArrayList<>(table.getValue().getKeys().size());
      for (Map<String, AttributeValue> key : table.getValue().getKeys()) {
        keys.add(itemCodec.toDdb(key));
      }
      out.put(
        table.getKey(),
        software.amazon.awssdk.services.dynamodb.model.KeysAndAttributes
          .builder()
          .keys(keys)
          .build()
      );
    }
    return out;
  }
}
