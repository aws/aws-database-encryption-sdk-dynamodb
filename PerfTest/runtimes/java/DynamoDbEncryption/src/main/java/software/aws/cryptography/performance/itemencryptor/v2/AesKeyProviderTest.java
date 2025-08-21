package software.aws.cryptography.performance.itemencryptor.v2;

import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.EncryptionMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.WrappedMaterialsProvider;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AesKeyProviderTest extends TestBase {

  @Override
  protected EncryptionMaterialsProvider createMasterKeyProvider() {
    final SecureRandom secureRandom = new SecureRandom();
    byte[] rawAes = new byte[32];
    byte[] rawHmac = new byte[32];
    secureRandom.nextBytes(rawAes);
    secureRandom.nextBytes(rawHmac);
    final SecretKey wrappingKeys = new SecretKeySpec(rawAes, "AES");
    final SecretKey signingKeys = new SecretKeySpec(rawHmac, "HmacSHA256");
    final WrappedMaterialsProvider cmp = new WrappedMaterialsProvider(
      wrappingKeys,
      wrappingKeys,
      signingKeys
    );
    return cmp;
  }

  public AesKeyProviderTest() {}

  AesKeyProviderTest(String plainTextFileJson) {
    this.plainTextFile = plainTextFileJson;
  }

  /**
   * main Method to execute tests without JMH. This is helpful in profiling in IDEs (especially IntelliJ) which fails
   * to profile JMH annotated runs.
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    TestBase testBase = new AesKeyProviderTest("single_attribute.json");
    testBase.setup();
    testBase.decrypt();
  }
}
