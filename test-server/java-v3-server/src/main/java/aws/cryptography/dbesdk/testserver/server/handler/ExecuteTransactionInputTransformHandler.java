package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteTransactionInput;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteTransactionInputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteTransactionInputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.model.ParameterizedStatement;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.ExecuteTransactionInputTransformOperation;
import java.util.ArrayList;
import java.util.List;
import software.amazon.awssdk.services.dynamodb.model.ExecuteTransactionRequest;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the minimal wire
 * {@code ExecuteTransactionInput} onto a real AWS SDK
 * {@link ExecuteTransactionRequest}, and runs the DBE validate-before
 * transform. The DBE library rejects the request with a {@code DBESDKClientError}
 * when any transact PartiQL statement targets an encrypted table.
 */
public final class ExecuteTransactionInputTransformHandler
  implements ExecuteTransactionInputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;

  public ExecuteTransactionInputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
  }

  @Override
  public ExecuteTransactionInputTransformOutput executeTransactionInputTransform(
    ExecuteTransactionInputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "ExecuteTransactionInputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());

        List<
          software.amazon.awssdk.services.dynamodb.model.ParameterizedStatement
        > sdkStatements = new ArrayList<>(
          input.getSdkInput().getTransactStatements().size()
        );
        for (ParameterizedStatement statement : input
          .getSdkInput()
          .getTransactStatements()) {
          sdkStatements.add(
            software.amazon.awssdk.services.dynamodb.model.ParameterizedStatement
              .builder()
              .statement(statement.getStatement())
              .build()
          );
        }

        ExecuteTransactionRequest transformed =
          client.executeTransactionInputTransform(
            ExecuteTransactionRequest
              .builder()
              .transactStatements(sdkStatements)
              .build()
          );

        List<ParameterizedStatement> wireStatements = new ArrayList<>(
          transformed.transactStatements().size()
        );
        for (software.amazon.awssdk.services.dynamodb.model.ParameterizedStatement statement : transformed.transactStatements()) {
          wireStatements.add(
            ParameterizedStatement
              .builder()
              .statement(statement.statement())
              .build()
          );
        }

        return ExecuteTransactionInputTransformOutput
          .builder()
          .transformedInput(
            ExecuteTransactionInput
              .builder()
              .transactStatements(wireStatements)
              .build()
          )
          .build();
      }
    );
  }
}
