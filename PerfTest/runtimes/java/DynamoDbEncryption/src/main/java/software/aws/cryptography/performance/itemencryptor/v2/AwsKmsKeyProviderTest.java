package software.aws.cryptography.performance.itemencryptor.v2;

import static software.aws.cryptography.performance.itemencryptor.TestConstants.KMS_KEY_ARN;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.EncryptionMaterialsProvider;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;

public class AwsKmsKeyProviderTest extends TestBase {

  @Override
  protected EncryptionMaterialsProvider createMasterKeyProvider() {
    AWSKMS kms = AWSKMSClientBuilder
      .standard()
      .withRegion(Regions.DEFAULT_REGION)
      .build();
    final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(
      kms,
      KMS_KEY_ARN
    );
    return cmp;
  }

  public AwsKmsKeyProviderTest() {}

  AwsKmsKeyProviderTest(String plainTextFileJson) {
    this.plainTextFile = plainTextFileJson;
  }

  /**
   * main Method to execute tests without JMH. This is helpful in profiling in IDEs (especially IntelliJ) which fails
   * to profile JMH annotated runs.
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    TestBase testBase = new AwsKmsKeyProviderTest("single_attribute.json");
    testBase.setup();
    testBase.decrypt();
  }
}
