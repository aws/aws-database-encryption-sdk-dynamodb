package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.config.ConfigValidator;
import aws.cryptography.dbesdk.testserver.server.config.ItemEncryptorFactory;
import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.CreateClientInput;
import aws.cryptography.dbesdk.testserver.server.model.CreateClientOutput;
import aws.cryptography.dbesdk.testserver.server.model.DBESDKClientError;
import aws.cryptography.dbesdk.testserver.server.model.GenericServerError;
import aws.cryptography.dbesdk.testserver.server.registry.ClientRegistry;
import aws.cryptography.dbesdk.testserver.server.registry.DbesdkClient;
import aws.cryptography.dbesdk.testserver.server.service.CreateClientOperation;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Constructs a real ESDK Java client from the modeled config and registers it,
 * returning its {@code ClientId} (Requirements 3.1, 3.5).
 *
 * <p>The config is first validated for the exactly-one-variant invariant, which
 * fails with a modeled {@link DBESDKClientError} (Requirements 2.3, 2.4). Then the
 * client is constructed; if construction fails the registry is left unchanged, no
 * {@code ClientId} is returned, and a {@link GenericServerError} is raised
 * (Requirement 3.6, Property 4). Registration happens only after a successful
 * construction, so a failed {@code CreateClient} never adds an entry.
 */
public final class CreateClientHandler implements CreateClientOperation {

  private final ClientRegistry registry;
  private final ConfigValidator validator;
  private final ItemEncryptorFactory factory;
  private final OperationWrapper wrapper;

  public CreateClientHandler(
    ClientRegistry registry,
    ConfigValidator validator,
    ItemEncryptorFactory factory,
    OperationWrapper wrapper
  ) {
    this.registry = registry;
    this.validator = validator;
    this.factory = factory;
    this.wrapper = wrapper;
  }

  @Override
  public CreateClientOutput createClient(
    CreateClientInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "CreateClient",
      () -> {
        // (2.3, 2.4) Exactly-one-variant validation surfaces as a modeled
        // DBESDKClientError, preserved by the wrapper.
        validator.validate(input.getConfig());

        DbesdkClient client;
        try {
          client = factory.create(input.getConfig());
        } catch (DBESDKClientError modeled) {
          // A config the ESDK itself rejects at construction is still a
          // client-construction failure per Requirement 3.6.
          throw constructionFailure(modeled);
        } catch (RuntimeException constructionFailure) {
          // (3.6) Construction failed: leave the registry unchanged and
          // return a GenericServerError. Registration is not attempted.
          throw constructionFailure(constructionFailure);
        }

        String clientId = registry.register(client);
        return CreateClientOutput.builder().clientId(clientId).build();
      }
    );
  }

  private static GenericServerError constructionFailure(Throwable cause) {
    String detail = cause.getMessage() == null
      ? cause.getClass().getName()
      : cause.getMessage();
    return GenericServerError
      .builder()
      .message("CreateClient failed to construct the ESDK client: " + detail)
      .build();
  }
}
