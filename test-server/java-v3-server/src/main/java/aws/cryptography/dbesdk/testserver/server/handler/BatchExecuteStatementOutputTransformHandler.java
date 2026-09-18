package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.BatchExecuteStatementInput;
import aws.cryptography.dbesdk.testserver.server.model.BatchExecuteStatementOutput;
import aws.cryptography.dbesdk.testserver.server.model.BatchExecuteStatementOutputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.BatchExecuteStatementOutputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.model.BatchStatementRequest;
import aws.cryptography.dbesdk.testserver.server.model.BatchStatementResponse;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.BatchExecuteStatementOutputTransformOperation;
import java.util.ArrayList;
import java.util.List;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementResponse;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Runs the DBE BatchExecuteStatement (PartiQL) modify-after transform. Each
 * response's item is decrypted using its {@code tableName}; with an unconfigured
 * table the items pass through unchanged.
 */
public final class BatchExecuteStatementOutputTransformHandler
  implements BatchExecuteStatementOutputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public BatchExecuteStatementOutputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public BatchExecuteStatementOutputTransformOutput batchExecuteStatementOutputTransform(
    BatchExecuteStatementOutputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "BatchExecuteStatementOutputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        BatchExecuteStatementInput wireInput = input.getOriginalInput();
        BatchExecuteStatementOutput wireOutput = input.getSdkOutput();

        List<
          software.amazon.awssdk.services.dynamodb.model.BatchStatementRequest
        > sdkStatements = new ArrayList<>();
        if (wireInput.getStatements() != null) {
          for (BatchStatementRequest s : wireInput.getStatements()) {
            sdkStatements.add(
              software.amazon.awssdk.services.dynamodb.model.BatchStatementRequest
                .builder()
                .statement(s.getStatement())
                .build()
            );
          }
        }
        BatchExecuteStatementRequest originalInput =
          BatchExecuteStatementRequest
            .builder()
            .statements(sdkStatements)
            .build();

        BatchExecuteStatementResponse.Builder sdkOutput =
          BatchExecuteStatementResponse.builder();
        if (wireOutput.getResponses() != null) {
          List<
            software.amazon.awssdk.services.dynamodb.model.BatchStatementResponse
          > sdkResponses = new ArrayList<>();
          for (BatchStatementResponse r : wireOutput.getResponses()) {
            software.amazon.awssdk.services.dynamodb.model.BatchStatementResponse.Builder b =
              software.amazon.awssdk.services.dynamodb.model.BatchStatementResponse.builder();
            if (r.getTableName() != null) {
              b.tableName(r.getTableName());
            }
            if (r.getItem() != null) {
              b.item(itemCodec.toDdb(r.getItem()));
            }
            sdkResponses.add(b.build());
          }
          sdkOutput.responses(sdkResponses);
        }

        BatchExecuteStatementResponse transformed =
          client.batchExecuteStatementOutputTransform(
            originalInput,
            sdkOutput.build()
          );

        BatchExecuteStatementOutput.Builder result =
          BatchExecuteStatementOutput.builder();
        if (transformed.hasResponses()) {
          List<BatchStatementResponse> wireResponses = new ArrayList<>();
          for (software.amazon.awssdk.services.dynamodb.model.BatchStatementResponse r : transformed.responses()) {
            BatchStatementResponse.Builder b = BatchStatementResponse.builder();
            if (r.tableName() != null) {
              b.tableName(r.tableName());
            }
            if (r.hasItem() && !r.item().isEmpty()) {
              b.item(itemCodec.toModel(r.item()));
            }
            wireResponses.add(b.build());
          }
          result.responses(wireResponses);
        }
        return BatchExecuteStatementOutputTransformOutput
          .builder()
          .transformedOutput(result.build())
          .build();
      }
    );
  }
}
