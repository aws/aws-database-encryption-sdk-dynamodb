package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.AttributeValue;
import aws.cryptography.dbesdk.testserver.server.model.BatchGetItemInput;
import aws.cryptography.dbesdk.testserver.server.model.BatchGetItemOutput;
import aws.cryptography.dbesdk.testserver.server.model.BatchGetItemOutputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.BatchGetItemOutputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.model.KeysAndAttributes;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.BatchGetItemOutputTransformOperation;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchGetItemResponse;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the minimal wire
 * {@code BatchGetItemOutput} / {@code BatchGetItemInput} onto a real AWS SDK
 * {@link BatchGetItemResponse} / {@link BatchGetItemRequest}, runs the DBE
 * decrypt-after transform, and maps every decrypted item back, per table.
 */
public final class BatchGetItemOutputTransformHandler
  implements BatchGetItemOutputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public BatchGetItemOutputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public BatchGetItemOutputTransformOutput batchGetItemOutputTransform(
    BatchGetItemOutputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "BatchGetItemOutputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        BatchGetItemInput wireInput = input.getOriginalInput();
        BatchGetItemOutput wireOutput = input.getSdkOutput();

        Map<
          String,
          software.amazon.awssdk.services.dynamodb.model.KeysAndAttributes
        > sdkRequestItems = new LinkedHashMap<>();
        for (Map.Entry<String, KeysAndAttributes> table : wireInput
          .getRequestItems()
          .entrySet()) {
          List<
            Map<
              String,
              software.amazon.awssdk.services.dynamodb.model.AttributeValue
            >
          > keys = new ArrayList<>(table.getValue().getKeys().size());
          for (Map<String, AttributeValue> key : table.getValue().getKeys()) {
            keys.add(itemCodec.toDdb(key));
          }
          sdkRequestItems.put(
            table.getKey(),
            software.amazon.awssdk.services.dynamodb.model.KeysAndAttributes
              .builder()
              .keys(keys)
              .build()
          );
        }
        BatchGetItemRequest originalInput = BatchGetItemRequest
          .builder()
          .requestItems(sdkRequestItems)
          .build();

        BatchGetItemResponse.Builder sdkOutput = BatchGetItemResponse.builder();
        if (wireOutput.getResponses() != null) {
          sdkOutput.responses(toSdkResponses(wireOutput.getResponses()));
        }

        BatchGetItemResponse transformed = client.batchGetItemOutputTransform(
          originalInput,
          sdkOutput.build()
        );

        BatchGetItemOutput.Builder result = BatchGetItemOutput.builder();
        if (transformed.hasResponses()) {
          result.responses(toWireResponses(transformed.responses()));
        }
        return BatchGetItemOutputTransformOutput
          .builder()
          .transformedOutput(result.build())
          .build();
      }
    );
  }

  private Map<
    String,
    List<
      Map<String, software.amazon.awssdk.services.dynamodb.model.AttributeValue>
    >
  > toSdkResponses(Map<String, List<Map<String, AttributeValue>>> wire) {
    Map<
      String,
      List<
        Map<
          String,
          software.amazon.awssdk.services.dynamodb.model.AttributeValue
        >
      >
    > out = new LinkedHashMap<>();
    for (Map.Entry<
      String,
      List<Map<String, AttributeValue>>
    > table : wire.entrySet()) {
      List<
        Map<
          String,
          software.amazon.awssdk.services.dynamodb.model.AttributeValue
        >
      > items = new ArrayList<>(table.getValue().size());
      for (Map<String, AttributeValue> item : table.getValue()) {
        items.add(itemCodec.toDdb(item));
      }
      out.put(table.getKey(), items);
    }
    return out;
  }

  private Map<String, List<Map<String, AttributeValue>>> toWireResponses(
    Map<
      String,
      List<
        Map<
          String,
          software.amazon.awssdk.services.dynamodb.model.AttributeValue
        >
      >
    > sdk
  ) {
    Map<String, List<Map<String, AttributeValue>>> out = new LinkedHashMap<>();
    for (Map.Entry<
      String,
      List<
        Map<
          String,
          software.amazon.awssdk.services.dynamodb.model.AttributeValue
        >
      >
    > table : sdk.entrySet()) {
      List<Map<String, AttributeValue>> items = new ArrayList<>(
        table.getValue().size()
      );
      for (Map<
        String,
        software.amazon.awssdk.services.dynamodb.model.AttributeValue
      > item : table.getValue()) {
        items.add(itemCodec.toModel(item));
      }
      out.put(table.getKey(), items);
    }
    return out;
  }
}
