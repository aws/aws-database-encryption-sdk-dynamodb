package software.amazon.cryptography.examples;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.kms.model.InvalidCiphertextException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.StructuredEncryptionException;
import software.amazon.cryptography.materialproviders.model.CollectionOfErrors;

public class ManipulationUtils {

  public static class ManipulationException extends RuntimeException {

    public ManipulationException(String msg) {
      super(msg);
    }

    public ManipulationException(Throwable throwable) {
      super(throwable);
    }

    public ManipulationException(String msg, Throwable throwable) {
      super(msg, throwable);
    }
  }

  public static void assertManipulationProof(
    final DynamoDbItemEncryptor itemEncryptor,
    final Map<String, AttributeValue> manipulated,
    final String attributeName
  ) {
    boolean manipulationProof = false;
    try {
      itemEncryptor.DecryptItem(
        DecryptItemInput.builder().encryptedItem(manipulated).build()
      );
    } catch (StructuredEncryptionException ex) {
      manipulationProof = true;
    }
    if (!manipulationProof) {
      throw new ManipulationException(
        String.format(
          "Attribute Named %s was supposedly manipulated but did not fail Authorization Check!",
          attributeName
        )
      );
    }
  }

  public static void assertProtectedByEncryptionContext(
    final DynamoDbItemEncryptor itemEncryptor,
    final Map<String, AttributeValue> manipulated,
    final String attributeName
  ) {
    boolean manipulationProof = false;
    String exceptionMsg = String.format(
      "Attribute Named %s was supposedly manipulated but did not fail Encryption Context Check!" +
      " (Or at least it did not fail it as expected!)",
      attributeName
    );
    try {
      itemEncryptor.DecryptItem(
        DecryptItemInput.builder().encryptedItem(manipulated).build()
      );
    } catch (CollectionOfErrors ex) {
      ex
        .list()
        .stream()
        .filter(nestedEx -> nestedEx instanceof CollectionOfErrors)
        .map(nestedEx -> (CollectionOfErrors) nestedEx)
        .map(nestedEx ->
          nestedEx
            .list()
            .stream()
            .filter(doubleNestedEx ->
              doubleNestedEx instanceof InvalidCiphertextException
            )
            .map(doubleNestedEx -> (InvalidCiphertextException) doubleNestedEx)
            .findAny()
            .orElseThrow(() -> new ManipulationException(exceptionMsg, ex))
        )
        .findAny()
        .orElseThrow(() -> new ManipulationException(exceptionMsg, ex));
      manipulationProof = true;
    }
    if (!manipulationProof) {
      throw new ManipulationException(
        String.format(
          "Attribute Named %s was supposedly manipulated but did not fail Authorization Check!",
          attributeName
        )
      );
    }
  }

  public static void assertNotManipulationProof(
    final DynamoDbItemEncryptor itemEncryptor,
    final Map<String, AttributeValue> manipulated,
    final String attributeName
  ) {
    try {
      itemEncryptor.DecryptItem(
        DecryptItemInput.builder().encryptedItem(manipulated).build()
      );
    } catch (StructuredEncryptionException ex) {
      throw new ManipulationException(
        String.format(
          "Attribute Named %s was supposedly manipulated and is NOT SIGNED " +
          "but it failed Authorization Check!\n" +
          "\tAttribute Value: %s",
          attributeName,
          manipulated.get(attributeName)
        ),
        ex
      );
    }
  }

  public static Map<String, AttributeValue> manipulateByteAttribute(
    final Map<String, AttributeValue> item,
    final String attributeName
  ) throws IOException {
    Map<String, AttributeValue> manipulated = new HashMap<>(item);
    ByteArrayOutputStream concatStream = new ByteArrayOutputStream();
    concatStream.write(item.get(attributeName).b().asByteArray());
    concatStream.write(
      SdkBytes
        .fromString("Manipulation!", Charset.defaultCharset())
        .asByteArray()
    );
    manipulated.put(
      attributeName,
      AttributeValue.fromB(SdkBytes.fromByteArray(concatStream.toByteArray()))
    );
    return manipulated;
  }

  public static Map<String, AttributeValue> manipulateStringAttribute(
    final Map<String, AttributeValue> item,
    final String attributeName
  ) {
    Map<String, AttributeValue> manipulated = new HashMap<>(item);
    String concatString = item.get(attributeName).s() + "Manipulation!";
    manipulated.put(attributeName, AttributeValue.fromS(concatString));
    return manipulated;
  }

  public static Map<String, AttributeValue> manipulateNumberAttribute(
    final Map<String, AttributeValue> item,
    final String attributeName
  ) {
    Map<String, AttributeValue> manipulated = new HashMap<>(item);
    int manipulatedInt = Integer.parseInt(item.get(attributeName).n()) + 1;
    manipulated.put(
      attributeName,
      AttributeValue.fromN(Integer.toString(manipulatedInt))
    );
    return manipulated;
  }
}
