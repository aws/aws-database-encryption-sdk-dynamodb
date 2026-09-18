package aws.cryptography.dbesdk.testserver.server.registry;

import aws.cryptography.dbesdk.testserver.server.error.DbesdkClientException;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput;

/**
 * A configured {@link DbesdkClient} backed by the real
 * {@link DynamoDbItemEncryptor} from the AWS Database Encryption SDK for
 * DynamoDB. Every call reaches the real DBE library. Any exception the library
 * throws is caught and rethrown as {@link DbesdkClientException} so the
 * operation wrapper forwards it as {@code DBESDKClientError} carrying the DBE
 * message unmodified.
 *
 * <p>Unlike ESDK there is no streaming — DBE encrypts a bounded DDB item —
 * so this class implements only {@code encryptItem} / {@code decryptItem}.
 */
public final class RealItemEncryptorClient implements DbesdkClient {

  private final DynamoDbItemEncryptor itemEncryptor;

  public RealItemEncryptorClient(DynamoDbItemEncryptor itemEncryptor) {
    this.itemEncryptor = itemEncryptor;
  }

  @Override
  public Map<String, AttributeValue> encryptItem(
    Map<String, AttributeValue> plaintextItem
  ) throws DbesdkClientException {
    try {
      return itemEncryptor
        .EncryptItem(
          EncryptItemInput.builder().plaintextItem(plaintextItem).build()
        )
        .encryptedItem();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }

  @Override
  public Map<String, AttributeValue> decryptItem(
    Map<String, AttributeValue> encryptedItem
  ) throws DbesdkClientException {
    try {
      return itemEncryptor
        .DecryptItem(
          DecryptItemInput.builder().encryptedItem(encryptedItem).build()
        )
        .plaintextItem();
    } catch (Exception dbeFailure) {
      throw new DbesdkClientException(dbeFailure);
    }
  }
}
