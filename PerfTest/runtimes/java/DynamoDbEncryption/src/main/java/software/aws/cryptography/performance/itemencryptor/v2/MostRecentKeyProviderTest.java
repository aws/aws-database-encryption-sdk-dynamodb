package software.aws.cryptography.performance.itemencryptor.v2;

import static software.aws.cryptography.performance.itemencryptor.TestConstants.KMS_KEY_ARN;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.CachingMostRecentProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.EncryptionMaterialsProvider;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.store.MetaStore;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;

public class MostRecentKeyProviderTest extends TestBase {

  public static final String TABLE_MOSTRECENT_EXAMPLE_KEYS =
    "v2MostRecentKeyProviderPerfTestKeys";

  @Override
  protected EncryptionMaterialsProvider createMasterKeyProvider() {
    final AWSKMS kms = AWSKMSClientBuilder
      .standard()
      .withRegion(Regions.DEFAULT_REGION)
      .build();
    AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder
      .standard()
      .withRegion(Regions.DEFAULT_REGION)
      .build();

    final DirectKmsMaterialProvider kmsProv = new DirectKmsMaterialProvider(
      kms,
      KMS_KEY_ARN
    );
    final DynamoDBEncryptor keyEncryptor = DynamoDBEncryptor.getInstance(
      kmsProv
    );
    final MetaStore metaStore = new MetaStore(
      ddb,
      TABLE_MOSTRECENT_EXAMPLE_KEYS,
      keyEncryptor
    );

    final CachingMostRecentProvider cmp = new CachingMostRecentProvider(
      metaStore,
      "testMaterial",
      60_000
    );
    return cmp;
  }

  public MostRecentKeyProviderTest() {}

  MostRecentKeyProviderTest(String plainTextFileJson) {
    this.plainTextFile = plainTextFileJson;
  }

  /**
   * main Method to execute tests without JMH. This is helpful in profiling in IDEs (especially IntelliJ) which fails
   * to profile JMH annotated runs.
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    TestBase testBase = new MostRecentKeyProviderTest("single_attribute.json");
    testBase.setup();
    testBase.decrypt();
  }
}
