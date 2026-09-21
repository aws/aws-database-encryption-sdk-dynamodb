package aws.cryptography.dbesdk.testserver.server.registry;

import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * A trivial {@link DbesdkClient} stand-in used by the registry property tests,
 * which assert only on object identity ({@code register} stores an instance and
 * {@code resolve} returns the very same instance). The item-crypto methods are
 * never called by those tests, so they throw to make any accidental call
 * obvious.
 *
 * <p>Error-mapping and handler property tests use the richer, controllable fake
 * {@code aws.cryptography.dbesdk.testserver.server.handler.ControllableDbesdkClient}.
 */
final class StubDbesdkClient implements DbesdkClient {

  @Override
  public Map<String, AttributeValue> encryptItem(
    Map<String, AttributeValue> plaintextItem
  ) {
    throw new UnsupportedOperationException(
      "StubDbesdkClient does not encrypt"
    );
  }

  @Override
  public Map<String, AttributeValue> decryptItem(
    Map<String, AttributeValue> encryptedItem
  ) {
    throw new UnsupportedOperationException(
      "StubDbesdkClient does not decrypt"
    );
  }
}
