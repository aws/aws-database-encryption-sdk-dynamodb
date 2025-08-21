package software.aws.cryptography.performance.itemencryptor.v3;

import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

import static software.aws.cryptography.performance.itemencryptor.TestConstants.KMS_KEY_ARN;

public class AwsKmsKeyringTest extends TestBase {


    @Override
    protected IKeyring createKeyring() {
        final MaterialProviders matProv = MaterialProviders.builder()
                                                           .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                                                           .build();
        return matProv.CreateAwsKmsKeyring(CreateAwsKmsKeyringInput.builder()
                                                                   .kmsKeyId(KMS_KEY_ARN)
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
        TestBase testBase = new AwsKmsKeyringTest("single_attribute.json");
        testBase.setup();
        testBase.decrypt();

    }
}
