package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.config.StructuredClientFactory;
import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.ResolveAuthActionsInput;
import aws.cryptography.dbesdk.testserver.server.model.ResolveAuthActionsOutput;
import aws.cryptography.dbesdk.testserver.server.service.ResolveAuthActionsOperation;
import software.amazon.smithy.java.server.RequestContext;

/**
 * Maps the wire Auth List + header bytes onto the DBE model and runs
 * {@code ResolveAuthActions}, which recovers the Crypto Action assigned to each
 * terminal by the header's Crypto Legend. This operation takes no CMM, so it runs
 * on the shared Structured Encryption client via {@link StructuredClientFactory}
 * rather than a registered client. A DBE failure is forwarded as
 * {@code DBESDKClientError}.
 */
public final class ResolveAuthActionsHandler
  implements ResolveAuthActionsOperation {

  private final StructuredClientFactory factory;
  private final OperationWrapper wrapper;
  private final StructuredDataCodec codec;

  public ResolveAuthActionsHandler(
    StructuredClientFactory factory,
    OperationWrapper wrapper,
    StructuredDataCodec codec
  ) {
    this.factory = factory;
    this.wrapper = wrapper;
    this.codec = codec;
  }

  @Override
  public ResolveAuthActionsOutput resolveAuthActions(
    ResolveAuthActionsInput input,
    RequestContext context
  ) {
    return wrapper.invoke(
      "ResolveAuthActions",
      () -> {
        var resolved = factory.resolveAuthActions(
          input.getTableName(),
          codec.toDbeAuthList(input.getAuthActions()),
          input.getHeaderBytes()
        );
        return ResolveAuthActionsOutput
          .builder()
          .cryptoActions(codec.toWireCryptoList(resolved))
          .build();
      }
    );
  }
}
