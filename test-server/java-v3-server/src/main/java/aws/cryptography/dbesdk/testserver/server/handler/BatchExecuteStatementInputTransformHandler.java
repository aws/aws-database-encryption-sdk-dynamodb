package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.BatchExecuteStatementInput;
import aws.cryptography.dbesdk.testserver.server.model.BatchExecuteStatementInputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.BatchExecuteStatementInputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.model.BatchStatementRequest;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.BatchExecuteStatementInputTransformOperation;
import java.util.ArrayList;
import java.util.List;
import software.amazon.awssdk.services.dynamodb.model.BatchExecuteStatementRequest;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the minimal wire
 * {@code BatchExecuteStatementInput} onto a real AWS SDK
 * {@link BatchExecuteStatementRequest}, and runs the DBE validate-before
 * transform. The DBE library rejects the request with a {@code DBESDKClientError}
 * when any PartiQL statement targets an encrypted table.
 */
public final class BatchExecuteStatementInputTransformHandler
  implements BatchExecuteStatementInputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;

  public BatchExecuteStatementInputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
  }

  @Override
  public BatchExecuteStatementInputTransformOutput batchExecuteStatementInputTransform(
    BatchExecuteStatementInputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "BatchExecuteStatementInputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());

        List<
          software.amazon.awssdk.services.dynamodb.model.BatchStatementRequest
        > sdkStatements = new ArrayList<>(
          input.getSdkInput().getStatements().size()
        );
        for (BatchStatementRequest statement : input
          .getSdkInput()
          .getStatements()) {
          sdkStatements.add(
            software.amazon.awssdk.services.dynamodb.model.BatchStatementRequest
              .builder()
              .statement(statement.getStatement())
              .build()
          );
        }

        BatchExecuteStatementRequest transformed =
          client.batchExecuteStatementInputTransform(
            BatchExecuteStatementRequest
              .builder()
              .statements(sdkStatements)
              .build()
          );

        List<BatchStatementRequest> wireStatements = new ArrayList<>(
          transformed.statements().size()
        );
        for (software.amazon.awssdk.services.dynamodb.model.BatchStatementRequest statement : transformed.statements()) {
          wireStatements.add(
            BatchStatementRequest
              .builder()
              .statement(statement.statement())
              .build()
          );
        }

        return BatchExecuteStatementInputTransformOutput
          .builder()
          .transformedInput(
            BatchExecuteStatementInput
              .builder()
              .statements(wireStatements)
              .build()
          )
          .build();
      }
    );
  }
}
