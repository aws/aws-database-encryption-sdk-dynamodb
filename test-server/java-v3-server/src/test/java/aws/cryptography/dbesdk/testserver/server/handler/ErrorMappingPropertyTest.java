package aws.cryptography.dbesdk.testserver.server.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.fail;

import aws.cryptography.dbesdk.testserver.server.error.OperationWrapper;
import aws.cryptography.dbesdk.testserver.server.model.AttributeValue;
import aws.cryptography.dbesdk.testserver.server.model.DBESDKClientError;
import aws.cryptography.dbesdk.testserver.server.model.DecryptItemInput;
import aws.cryptography.dbesdk.testserver.server.model.EncryptItemInput;
import aws.cryptography.dbesdk.testserver.server.model.GenericServerError;
import aws.cryptography.dbesdk.testserver.server.registry.ClientRegistry;
import java.util.Map;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.GenerationMode;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

/**
 * Property-based test for error mapping by origin at the handler layer, using
 * jqwik. Runs a minimum of 100 generated iterations.
 */
class ErrorMappingPropertyTest {

  private enum Op {
    ENCRYPT_ITEM,
    DECRYPT_ITEM,
  }

  @Property(tries = 200, generation = GenerationMode.RANDOMIZED)
  void errorsAreMappedByOrigin(
    @ForAll("ops") Op op,
    @ForAll boolean dbeOrigin,
    @ForAll("messages") String message
  ) {
    ClientRegistry registry = new ClientRegistry();
    OperationWrapper wrapper = new OperationWrapper();
    ClientIdGuard guard = new ClientIdGuard(registry);

    ControllableDbesdkClient client = dbeOrigin
      ? ControllableDbesdkClient.failingInsideDbe(message)
      : ControllableDbesdkClient.failingInFramework(message);
    String clientId = registry.register(client);
    int sizeBefore = registry.size();

    Throwable thrown = runExpectingThrow(op, guard, wrapper, clientId);

    if (dbeOrigin) {
      // (5.6, P8) DBE-origin failure -> DBESDKClientError, message unmodified,
      // never a GenericServerError.
      DBESDKClientError error = assertInstanceOf(
        DBESDKClientError.class,
        thrown,
        "a DBE-origin failure must map to DBESDKClientError"
      );
      assertEquals(
        message,
        error.getMessage(),
        "DBESDKClientError message must equal the DBE exception message, unmodified"
      );
    } else {
      // (5.5, P8) framework-origin failure -> GenericServerError, never a
      // DBESDKClientError.
      assertInstanceOf(
        GenericServerError.class,
        thrown,
        "a framework-origin failure must map to GenericServerError"
      );
    }

    // In the failure case no item is returned (an exception was thrown, not an
    // output) and the registry is unchanged.
    assertEquals(
      sizeBefore,
      registry.size(),
      "a failed operation must leave the registry unchanged"
    );
  }

  private static Throwable runExpectingThrow(
    Op op,
    ClientIdGuard guard,
    OperationWrapper wrapper,
    String clientId
  ) {
    DdbItemCodec codec = new DdbItemCodec();
    try {
      switch (op) {
        case ENCRYPT_ITEM -> new EncryptItemHandler(guard, wrapper, codec)
          .encryptItem(
            EncryptItemInput
              .builder()
              .clientId(clientId)
              .plaintextItem(singleAttributeItem())
              .build(),
            null
          );
        case DECRYPT_ITEM -> new DecryptItemHandler(guard, wrapper, codec)
          .decryptItem(
            DecryptItemInput
              .builder()
              .clientId(clientId)
              .encryptedItem(singleAttributeItem())
              .build(),
            null
          );
        default -> fail("unhandled op");
      }
    } catch (Throwable t) {
      return t;
    }
    throw new AssertionError("expected the operation to throw a modeled error");
  }

  /** A minimal, codec-valid modeled item the failing client is handed. */
  private static Map<String, AttributeValue> singleAttributeItem() {
    return Map.of("pk", AttributeValue.builder().s("x").build());
  }

  @Provide
  Arbitrary<Op> ops() {
    return Arbitraries.of(Op.class);
  }

  @Provide
  Arbitrary<String> messages() {
    return Arbitraries.strings().ofMinLength(1).ofMaxLength(120);
  }
}
