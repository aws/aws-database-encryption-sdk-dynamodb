package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteStatementInput;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteStatementInputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteStatementInputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.ExecuteStatementInputTransformOperation;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementRequest;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Resolves the transforms {@code ClientId}, maps the minimal wire
 * {@code ExecuteStatementInput} onto a real AWS SDK
 * {@link ExecuteStatementRequest}, and runs the DBE validate-before transform.
 * The DBE library rejects the request with a {@code DBESDKClientError} when the
 * PartiQL statement targets an encrypted table; otherwise the request passes
 * through unchanged.
 */
public final class ExecuteStatementInputTransformHandler
  implements ExecuteStatementInputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;

  public ExecuteStatementInputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
  }

  @Override
  public ExecuteStatementInputTransformOutput executeStatementInputTransform(
    ExecuteStatementInputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "ExecuteStatementInputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());

        ExecuteStatementRequest transformed =
          client.executeStatementInputTransform(
            ExecuteStatementRequest
              .builder()
              .statement(input.getSdkInput().getStatement())
              .build()
          );

        return ExecuteStatementInputTransformOutput
          .builder()
          .transformedInput(
            ExecuteStatementInput
              .builder()
              .statement(transformed.statement())
              .build()
          )
          .build();
      }
    );
  }
}
