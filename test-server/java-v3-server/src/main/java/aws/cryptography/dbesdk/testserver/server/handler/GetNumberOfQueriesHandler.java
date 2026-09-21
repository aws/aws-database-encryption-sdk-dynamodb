package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.GetNumberOfQueriesInput;
import aws.cryptography.dbesdk.testserver.server.model.GetNumberOfQueriesOutput;
import aws.cryptography.dbesdk.testserver.server.service.GetNumberOfQueriesOperation;
import software.amazon.smithy.java.server.RequestContext;

/**
 * GetNumberOfQueries is <em>not</em> exposed by the published
 * {@code aws-database-encryption-sdk-dynamodb:3.8.1} Java API this server pins
 * (the operation is absent from its {@code DynamoDbEncryptionTransforms}
 * surface — it exists in the Rust and .NET runtimes). The Java server must
 * still register a handler because the generated service builder requires every
 * modeled operation, so this stub reports the operation unsupported. Tests gate
 * on {@code beacon-partitions} (which java-v3-server also does not support), so
 * this stub is never exercised in the matrix.
 */
public final class GetNumberOfQueriesHandler
  implements GetNumberOfQueriesOperation {

  private final OperationWrapper wrapper;

  public GetNumberOfQueriesHandler(OperationWrapper wrapper) {
    this.wrapper = wrapper;
  }

  @Override
  public GetNumberOfQueriesOutput getNumberOfQueries(
    GetNumberOfQueriesInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "GetNumberOfQueries",
      () -> {
        throw new UnsupportedOperationException(
          "GetNumberOfQueries is not available in the published " +
          "aws-database-encryption-sdk-dynamodb 3.8.1 Java API"
        );
      }
    );
  }
}
