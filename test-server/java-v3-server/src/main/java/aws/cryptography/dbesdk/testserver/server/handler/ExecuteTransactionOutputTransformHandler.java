package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteTransactionInput;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteTransactionOutput;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteTransactionOutputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteTransactionOutputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.model.ItemResponse;
import aws.cryptography.dbesdk.testserver.server.model.ParameterizedStatement;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.ExecuteTransactionOutputTransformOperation;
import java.util.ArrayList;
import java.util.List;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionRequest;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionResponse;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Runs the DBE ExecuteTransaction (PartiQL) modify-after transform. Each
 * response's item is decrypted using the table named by the parallel statement;
 * with an unconfigured table the items pass through unchanged.
 */
public final class ExecuteTransactionOutputTransformHandler
  implements ExecuteTransactionOutputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public ExecuteTransactionOutputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public ExecuteTransactionOutputTransformOutput executeTransactionOutputTransform(
    ExecuteTransactionOutputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "ExecuteTransactionOutputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        ExecuteTransactionInput wireInput = input.getOriginalInput();
        ExecuteTransactionOutput wireOutput = input.getSdkOutput();

        List<
          software.amazon.awssdk.services.dynamodb.model.ParameterizedStatement
        > sdkStatements = new ArrayList<>();
        if (wireInput.getTransactStatements() != null) {
          for (ParameterizedStatement s : wireInput.getTransactStatements()) {
            sdkStatements.add(
              software.amazon.awssdk.services.dynamodb.model.ParameterizedStatement
                .builder()
                .statement(s.getStatement())
                .build()
            );
          }
        }
        ExecuteTransactionRequest originalInput = ExecuteTransactionRequest
          .builder()
          .transactStatements(sdkStatements)
          .build();

        ExecuteTransactionResponse.Builder sdkOutput =
          ExecuteTransactionResponse.builder();
        if (wireOutput.getResponses() != null) {
          List<
            software.amazon.awssdk.services.dynamodb.model.ItemResponse
          > sdkResponses = new ArrayList<>();
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

        ExecuteTransactionResponse transformed =
          client.executeTransactionOutputTransform(
            originalInput,
            sdkOutput.build()
          );

        ExecuteTransactionOutput.Builder result =
          ExecuteTransactionOutput.builder();
        if (transformed.hasResponses()) {
          List<ItemResponse> wireResponses = new ArrayList<>();
          for (software.amazon.awssdk.services.dynamodb.model.ItemResponse r : transformed.responses()) {
            ItemResponse.Builder b = ItemResponse.builder();
            if (r.hasItem() && !r.item().isEmpty()) {
              b.item(itemCodec.toModel(r.item()));
            }
            wireResponses.add(b.build());
          }
          result.responses(wireResponses);
        }
        return ExecuteTransactionOutputTransformOutput
          .builder()
          .transformedOutput(result.build())
          .build();
      }
    );
  }
}
