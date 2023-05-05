package software.aws.cryptography.performance.itemencryptor;

import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsKeyringInput;
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;

public class AwsKmsKeyringTest extends TestBase {

    public static final String AWS_KMS_KEY_ARN = "arn:aws:kms:us-west-2:370957321024:key/9d989aa2-2f9c-438c-a745-cc57d3ad0126";

    @Override
    protected IKeyring createKeyring() {
        final MaterialProviders matProv = MaterialProviders.builder()
                                                           .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                                                           .build();
        return matProv.CreateAwsKmsKeyring(CreateAwsKmsKeyringInput.builder()
                                                                   .kmsKeyId(AWS_KMS_KEY_ARN)
                                                                   .kmsClient(KmsClient.create())
                                                                   .build());
    }

    public AwsKmsKeyringTest() {
    }

    AwsKmsKeyringTest(String plainTextFileJson) {
        this.plainTextFile = plainTextFileJson;
    }

    /**
     * main Method to execute tests without JMH. This is helpful in profiling in IDEs (especially IntelliJ) which fails
     * to profile JMH annotated runs.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        TestBase testBase = new AwsKmsKeyringTest("/Users/scchatur/single_attribute.json");
        testBase.setup();
        testBase.decrypt();

    }
}
