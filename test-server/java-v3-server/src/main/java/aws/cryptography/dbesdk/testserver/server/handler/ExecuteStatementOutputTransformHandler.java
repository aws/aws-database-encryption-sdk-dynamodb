package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.AttributeValue;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteStatementInput;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteStatementOutput;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteStatementOutputTransformInput;
import aws.cryptography.dbesdk.testserver.server.model.ExecuteStatementOutputTransformOutput;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.service.ExecuteStatementOutputTransformOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementRequest;
import software.amazon.awssdk.services.dynamodb.model.ExecuteStatementResponse;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Runs the DBE ExecuteStatement (PartiQL) modify-after transform. The statement
 * identifies the table whose returned items are decrypted; with no beacon config
 * (or an unconfigured table) the items pass through unchanged.
 */
public final class ExecuteStatementOutputTransformHandler
  implements ExecuteStatementOutputTransformOperation {

  private final TransformsClientGuard guard;
  private final OperationWrapper wrapper;
  private final DdbItemCodec itemCodec;

  public ExecuteStatementOutputTransformHandler(
    TransformsClientGuard guard,
    OperationWrapper wrapper,
    DdbItemCodec itemCodec
  ) {
    this.guard = guard;
    this.wrapper = wrapper;
    this.itemCodec = itemCodec;
  }

  @Override
  public ExecuteStatementOutputTransformOutput executeStatementOutputTransform(
    ExecuteStatementOutputTransformInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "ExecuteStatementOutputTransform",
      () -> {
        TransformsClient client = guard.resolve(input.getClientId());
        ExecuteStatementInput wireInput = input.getOriginalInput();
        ExecuteStatementOutput wireOutput = input.getSdkOutput();

        ExecuteStatementRequest originalInput = ExecuteStatementRequest
          .builder()
          .statement(wireInput.getStatement())
          .build();

        ExecuteStatementResponse.Builder sdkOutput =
          ExecuteStatementResponse.builder();
        if (wireOutput.getItems() != null) {
          List<
            Map<
              String,
              software.amazon.awssdk.services.dynamodb.model.AttributeValue
            >
          > sdkItems = new ArrayList<>(wireOutput.getItems().size());
          for (Map<String, AttributeValue> item : wireOutput.getItems()) {
            sdkItems.add(itemCodec.toDdb(item));
          }
          sdkOutput.items(sdkItems);
        }

        ExecuteStatementResponse transformed =
          client.executeStatementOutputTransform(
            originalInput,
            sdkOutput.build()
          );

        ExecuteStatementOutput.Builder result =
          ExecuteStatementOutput.builder();
        if (transformed.hasItems()) {
          List<Map<String, AttributeValue>> wireItems = new ArrayList<>(
            transformed.items().size()
          );
          for (Map<
            String,
            software.amazon.awssdk.services.dynamodb.model.AttributeValue
          > item : transformed.items()) {
            wireItems.add(itemCodec.toModel(item));
          }
          result.items(wireItems);
        }
        return ExecuteStatementOutputTransformOutput
          .builder()
          .transformedOutput(result.build())
          .build();
      }
    );
  }
}
