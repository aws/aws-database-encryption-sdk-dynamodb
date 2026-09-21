package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.config.ConfigValidator;
import aws.cryptography.dbesdk.testserver.server.config.StructuredClientFactory;
import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.CreateStructuredClientInput;
import aws.cryptography.dbesdk.testserver.server.model.CreateStructuredClientOutput;
import aws.cryptography.dbesdk.testserver.server.model.DBESDKClientError;
import aws.cryptography.dbesdk.testserver.server.model.GenericServerError;
import aws.cryptography.dbesdk.testserver.server.registry.StructuredClient;
import aws.cryptography.dbesdk.testserver.server.registry.StructuredClientRegistry;
import aws.cryptography.dbesdk.testserver.server.service.CreateStructuredClientOperation;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Constructs a real Structured Encryption client (plus the CMM its config
 * builds), registers it, and returns its {@code ClientId}. The structured analog
 * of {@link CreateTransformsClientHandler}: the config is validated for the
 * exactly-one-variant invariant, then the client is constructed; a construction
 * failure leaves the registry unchanged and raises a {@link GenericServerError}.
 */
public final class CreateStructuredClientHandler
  implements CreateStructuredClientOperation {

  private final StructuredClientRegistry registry;
  private final ConfigValidator validator;
  private final StructuredClientFactory factory;
  private final OperationWrapper wrapper;

  public CreateStructuredClientHandler(
    StructuredClientRegistry registry,
    ConfigValidator validator,
    StructuredClientFactory factory,
    OperationWrapper wrapper
  ) {
    this.registry = registry;
    this.validator = validator;
    this.factory = factory;
    this.wrapper = wrapper;
  }

  @Override
  public CreateStructuredClientOutput createStructuredClient(
    CreateStructuredClientInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "CreateStructuredClient",
      () -> {
        validator.validate(input.getConfig());
        StructuredClient client;
        try {
          client = factory.create(input.getConfig());
        } catch (DBESDKClientError modeled) {
          throw constructionFailure(modeled);
        } catch (RuntimeException constructionFailure) {
          throw constructionFailure(constructionFailure);
        }
        String clientId = registry.register(client);
        return CreateStructuredClientOutput
          .builder()
          .clientId(clientId)
          .build();
      }
    );
  }

  private static GenericServerError constructionFailure(Throwable cause) {
    String detail = cause.getMessage() == null
      ? cause.getClass().getName()
      : cause.getMessage();
    return GenericServerError
      .builder()
      .message(
        "CreateStructuredClient failed to construct the structured client: " +
        detail
      )
      .build();
  }
}
