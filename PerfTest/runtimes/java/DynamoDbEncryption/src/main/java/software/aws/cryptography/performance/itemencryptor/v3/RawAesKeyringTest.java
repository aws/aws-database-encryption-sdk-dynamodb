package software.aws.cryptography.performance.itemencryptor.v3;

import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.AesWrappingAlg;
import software.amazon.cryptography.materialproviders.model.CreateRawAesKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

import java.nio.ByteBuffer;

import static software.aws.cryptography.performance.itemencryptor.TestConstants.KEY_NAME;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.KEY_NAMESPACE;

public class RawAesKeyringTest extends TestBase{

    @Override
    protected IKeyring createKeyring() {
        final MaterialProviders matProv = MaterialProviders.builder()
                                                           .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                                                           .build();
        final CreateRawAesKeyringInput keyringInput = CreateRawAesKeyringInput.builder()
                                                                              .keyNamespace(KEY_NAMESPACE)
                                                                              .keyName(KEY_NAME)
                                                                              .wrappingKey(ByteBuffer.wrap(new byte[32]))
                                                                              .wrappingAlg(AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16)
                                                                              .build();
        return matProv.CreateRawAesKeyring(keyringInput);
    }

    public RawAesKeyringTest() {
    }

    RawAesKeyringTest(String plainTextFileJson) {
        this.plainTextFile = plainTextFileJson;
    }

    /**
     * main Method to execute tests without JMH. This is helpful in profiling in IDEs (especially IntelliJ) which fails
     * to profile JMH annotated runs.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        TestBase testBase = new RawAesKeyringTest("single_attribute.json");
        testBase.setup();
        testBase.decrypt();

    }
}
