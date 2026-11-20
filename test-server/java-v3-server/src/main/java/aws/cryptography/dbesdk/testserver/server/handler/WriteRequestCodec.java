package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.model.DeleteRequest;
import aws.cryptography.dbesdk.testserver.server.model.PutRequest;
import aws.cryptography.dbesdk.testserver.server.model.WriteRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Bridges the wire {@link WriteRequest} shape and the AWS SDK v2
 * {@link software.amazon.awssdk.services.dynamodb.model.WriteRequest} for the
 * BatchWriteItem transforms — a WriteRequest is exactly one of a PutRequest
 * (an item to write) or a DeleteRequest (a key to delete). Shared by the
 * BatchWriteItem input transform (encrypt-before) and output transform
 * (UnprocessedItems restoration), which both carry a
 * {@code Map<String tableName, List<WriteRequest>>}.
 */
public final class WriteRequestCodec {

  private final DdbItemCodec itemCodec;

  public WriteRequestCodec(DdbItemCodec itemCodec) {
    this.itemCodec = itemCodec;
  }

  /** Wire request-item map → SDK request-item map. */
  public Map<
    String,
    List<software.amazon.awssdk.services.dynamodb.model.WriteRequest>
  > toSdk(Map<String, List<WriteRequest>> wire) {
    Map<
      String,
      List<software.amazon.awssdk.services.dynamodb.model.WriteRequest>
    > out = new LinkedHashMap<>();
    for (Map.Entry<String, List<WriteRequest>> table : wire.entrySet()) {
      List<software.amazon.awssdk.services.dynamodb.model.WriteRequest> list =
        new ArrayList<>(table.getValue().size());
      for (WriteRequest wr : table.getValue()) {
        list.add(toSdk(wr));
      }
      out.put(table.getKey(), list);
    }
    return out;
  }

  /** SDK request-item map → wire request-item map. */
  public Map<String, List<WriteRequest>> toWire(
    Map<
      String,
      List<software.amazon.awssdk.services.dynamodb.model.WriteRequest>
    > sdk
  ) {
    Map<String, List<WriteRequest>> out = new LinkedHashMap<>();
    for (Map.Entry<
      String,
      List<software.amazon.awssdk.services.dynamodb.model.WriteRequest>
    > table : sdk.entrySet()) {
      List<WriteRequest> list = new ArrayList<>(table.getValue().size());
      for (software.amazon.awssdk.services.dynamodb.model.WriteRequest wr : table.getValue()) {
        list.add(toWire(wr));
      }
      out.put(table.getKey(), list);
    }
    return out;
  }

  private software.amazon.awssdk.services.dynamodb.model.WriteRequest toSdk(
    WriteRequest wr
  ) {
    if (wr.getPutRequest() != null) {
      return software.amazon.awssdk.services.dynamodb.model.WriteRequest
        .builder()
        .putRequest(
          software.amazon.awssdk.services.dynamodb.model.PutRequest
            .builder()
            .item(itemCodec.toDdb(wr.getPutRequest().getItem()))
            .build()
        )
        .build();
    }
    if (wr.getDeleteRequest() != null) {
      return software.amazon.awssdk.services.dynamodb.model.WriteRequest
        .builder()
        .deleteRequest(
          software.amazon.awssdk.services.dynamodb.model.DeleteRequest
            .builder()
            .key(itemCodec.toDdb(wr.getDeleteRequest().getKey()))
            .build()
        )
        .build();
    }
    throw new IllegalArgumentException(
      "WriteRequest must set exactly one of putRequest or deleteRequest"
    );
  }

  private WriteRequest toWire(
    software.amazon.awssdk.services.dynamodb.model.WriteRequest wr
  ) {
    if (wr.putRequest() != null) {
      return WriteRequest
        .builder()
        .putRequest(
          PutRequest
            .builder()
            .item(itemCodec.toModel(wr.putRequest().item()))
            .build()
        )
        .build();
    }
    if (wr.deleteRequest() != null) {
      return WriteRequest
        .builder()
        .deleteRequest(
          DeleteRequest
            .builder()
            .key(itemCodec.toModel(wr.deleteRequest().key()))
            .build()
        )
        .build();
    }
    throw new IllegalStateException(
      "DBE returned a WriteRequest with neither putRequest nor deleteRequest"
    );
  }
}
