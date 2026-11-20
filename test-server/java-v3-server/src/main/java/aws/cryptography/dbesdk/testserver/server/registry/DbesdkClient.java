package aws.cryptography.dbesdk.testserver.server.registry;

import aws.cryptography.dbesdk.testserver.server.error.DbesdkClientException;
import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * A single configured DBE item encryptor stored in the {@link ClientRegistry}.
 * On the Java server this wraps a real {@link
 * software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor}
 * (see {@code RealItemEncryptorClient}); tests may substitute a controllable
 * fake to exercise handler and error-mapping logic without real crypto.
 *
 * <p>Both methods declare {@link DbesdkClientException}: implementations catch
 * exceptions thrown by the underlying DBE library and rethrow them wrapped, so
 * the operation wrapper can forward them as {@code DBESDKClientError} with the
 * DBE message unmodified.
 *
 * <p>Unlike the ESDK, DBE has no streaming API — its unit of encryption is a
 * bounded DDB item — so this interface has no {@code encryptStream} /
 * {@code decryptStream} / {@code isStreamingCapable} members.
 */
public interface DbesdkClient {
  /**
   * Encrypt a DDB item.
   *
   * @param plaintextItem the plaintext attribute map.
   * @return the encrypted attribute map (ENCRYPT_AND_SIGN attributes become
   *     binary; SIGN_ONLY, SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT, and
   *     DO_NOTHING attributes retain their original values).
   * @throws DbesdkClientException if the DBE library fails.
   */
  Map<String, AttributeValue> encryptItem(
    Map<String, AttributeValue> plaintextItem
  ) throws DbesdkClientException;

  /**
   * Decrypt a DDB item.
   *
   * @param encryptedItem the encrypted attribute map.
   * @return the plaintext attribute map.
   * @throws DbesdkClientException if the DBE library fails.
   */
  Map<String, AttributeValue> decryptItem(
    Map<String, AttributeValue> encryptedItem
  ) throws DbesdkClientException;
}
