package software.aws.cryptography.performance.itemencryptor;

import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.AesWrappingAlg;
import software.amazon.cryptography.materialProviders.model.CreateRawAesKeyringInput;
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;

import java.nio.ByteBuffer;

public class RawAesKeyringTest extends TestBase{

    public static final String KEY_NAMESPACE = "Key_Namespace";
    public static final String KEY_NAME = "Key_Name";

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
