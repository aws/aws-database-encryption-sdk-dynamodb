package aws.cryptography.dbesdk.testserver.server.handler;

import aws.cryptography.dbesdk.testserver.server.error.DbesdkClientException;
import aws.cryptography.dbesdk.testserver.server.registry.DbesdkClient;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * A controllable {@link DbesdkClient} fake used by the handler and error-mapping
 * property tests. It can be told to succeed (echoing the item) or to fail on
 * demand, either as a DBE-origin failure (a wrapped {@link DbesdkClientException})
 * or a framework-origin failure (a raw unchecked exception). It counts item-crypto
 * invocations so tests can assert that a rejected request performed no DBE
 * operation (Property 5).
 */
final class ControllableDbesdkClient implements DbesdkClient {

  enum Mode {
    SUCCEED,
    FAIL_DBE,
    FAIL_FRAMEWORK,
  }

  private final Mode mode;
  private final String failureMessage;
  private final AtomicInteger cryptoCalls = new AtomicInteger();

  private ControllableDbesdkClient(Mode mode, String failureMessage) {
    this.mode = mode;
    this.failureMessage = failureMessage;
  }

  static ControllableDbesdkClient succeeding() {
    return new ControllableDbesdkClient(Mode.SUCCEED, null);
  }

  static ControllableDbesdkClient failingInsideDbe(String message) {
    return new ControllableDbesdkClient(Mode.FAIL_DBE, message);
  }

  static ControllableDbesdkClient failingInFramework(String message) {
    return new ControllableDbesdkClient(Mode.FAIL_FRAMEWORK, message);
  }

  int cryptoCalls() {
    return cryptoCalls.get();
  }

  private Map<String, AttributeValue> act(Map<String, AttributeValue> item)
    throws DbesdkClientException {
    cryptoCalls.incrementAndGet();
    switch (mode) {
      case SUCCEED:
        return item;
      case FAIL_DBE:
        throw new DbesdkClientException(new RuntimeException(failureMessage));
      case FAIL_FRAMEWORK:
      default:
        throw new IllegalStateException(failureMessage);
    }
  }

  @Override
  public Map<String, AttributeValue> encryptItem(
    Map<String, AttributeValue> plaintextItem
  ) throws DbesdkClientException {
    return act(plaintextItem);
  }

  @Override
  public Map<String, AttributeValue> decryptItem(
    Map<String, AttributeValue> encryptedItem
  ) throws DbesdkClientException {
    return act(encryptedItem);
  }
}
