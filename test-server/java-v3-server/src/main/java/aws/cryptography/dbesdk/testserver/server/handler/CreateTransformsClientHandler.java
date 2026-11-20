package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.config.ConfigValidator;
import aws.cryptography.dbesdk.testserver.server.config.TransformsClientFactory;
import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.CreateTransformsClientInput;
import aws.cryptography.dbesdk.testserver.server.model.CreateTransformsClientOutput;
import aws.cryptography.dbesdk.testserver.server.model.DBEClientConfig;
import aws.cryptography.dbesdk.testserver.server.model.DBESDKClientError;
import aws.cryptography.dbesdk.testserver.server.model.GenericServerError;
import aws.cryptography.dbesdk.testserver.server.model.TransformsTableConfig;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClient;
import aws.cryptography.dbesdk.testserver.server.registry.TransformsClientRegistry;
import aws.cryptography.dbesdk.testserver.server.service.CreateTransformsClientOperation;
import java.util.LinkedHashMap;
import java.util.Map;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Constructs a real DBE transforms client from the modeled config bound to the
 * given physical table, registers it, and returns its {@code ClientId}. The
 * transforms analog of {@link CreateClientHandler}: the config is validated for
 * the exactly-one-variant invariant (a modeled {@link DBESDKClientError}), then
 * the client is constructed; a construction failure leaves the registry
 * unchanged and raises a {@link GenericServerError}.
 */
public final class CreateTransformsClientHandler
  implements CreateTransformsClientOperation {

  private final TransformsClientRegistry registry;
  private final ConfigValidator validator;
  private final TransformsClientFactory factory;
  private final OperationWrapper wrapper;

  public CreateTransformsClientHandler(
    TransformsClientRegistry registry,
    ConfigValidator validator,
    TransformsClientFactory factory,
    OperationWrapper wrapper
  ) {
    this.registry = registry;
    this.validator = validator;
    this.factory = factory;
    this.wrapper = wrapper;
  }

  @Override
  public CreateTransformsClientOutput createTransformsClient(
    CreateTransformsClientInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "CreateTransformsClient",
      () -> {
        // (physical table name → its crypto config): the primary table plus
        // any additional tables. Each config is validated for the
        // exactly-one-variant invariant before construction.
        Map<String, DBEClientConfig> tables = new LinkedHashMap<>();
        validator.validate(input.getConfig());
        tables.put(input.getTableName(), input.getConfig());
        if (input.hasAdditionalTables()) {
          for (TransformsTableConfig extra : input.getAdditionalTables()) {
            validator.validate(extra.getConfig());
            tables.put(extra.getTableName(), extra.getConfig());
          }
        }

        TransformsClient client;
        try {
          client = factory.create(tables);
        } catch (DBESDKClientError modeled) {
          throw constructionFailure(modeled);
        } catch (RuntimeException constructionFailure) {
          throw constructionFailure(constructionFailure);
        }

        String clientId = registry.register(client);
        return CreateTransformsClientOutput
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
        "CreateTransformsClient failed to construct the transforms client: " +
        detail
      )
      .build();
  }
}
