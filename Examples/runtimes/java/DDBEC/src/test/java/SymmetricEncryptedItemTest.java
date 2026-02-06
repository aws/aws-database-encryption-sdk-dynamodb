import java.security.SecureRandom;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.testng.annotations.Test;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class SymmetricEncryptedItemTest {

  @Test
  public void testSymmetricEncryption() throws Exception {
    // Generate random keys
    final SecureRandom secureRandom = new SecureRandom();
    byte[] rawAes = new byte[32];
    byte[] rawHmac = new byte[32];
    secureRandom.nextBytes(rawAes);
    secureRandom.nextBytes(rawHmac);
    final SecretKey wrappingKey = new SecretKeySpec(rawAes, "AES");
    final SecretKey signingKey = new SecretKeySpec(rawHmac, "HmacSHA256");

    try (final DynamoDbClient ddbClient = DynamoDbClient.create()) {
      SymmetricEncryptedItem.encryptRecord(
          ddbClient, TestUtils.TEST_DDB_TABLE_NAME, wrappingKey, signingKey);
    }
  }
}
