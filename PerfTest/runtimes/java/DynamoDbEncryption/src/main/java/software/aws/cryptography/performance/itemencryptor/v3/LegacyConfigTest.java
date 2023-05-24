package software.aws.cryptography.performance.itemencryptor.v3;

import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.WrappedMaterialsProvider;
import com.fasterxml.jackson.databind.JsonNode;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyPolicy;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.AesWrappingAlg;
import software.amazon.cryptography.materialproviders.model.CreateRawAesKeyringInput;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import static software.aws.cryptography.performance.itemencryptor.TestConstants.DATA_TO_ENCRYPT;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.KEY_NAME;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.KEY_NAMESPACE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.PARTITION_ATTRIBUTE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.SORT_ATTRIBUTE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.TEST_TABLE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.UNAUTH_PREFIX;

public class LegacyConfigTest extends TestBase {
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

    @Override
    public void setup() throws Exception {
        final JsonNode plainTextJson = mapper.readTree(getClass().getClassLoader().getResourceAsStream(plainTextFile));
        plainTextJson.properties().forEach((entry) -> plainTextAttribute.put(entry.getKey(), mapper.convertValue(entry.getValue(), AttributeValue.serializableBuilderClass())));

        final Map<String, CryptoAction> legacyActions = new HashMap<>();
        legacyActions.put(PARTITION_ATTRIBUTE, CryptoAction.SIGN_ONLY);
        legacyActions.put(SORT_ATTRIBUTE, CryptoAction.SIGN_ONLY);
        legacyActions.put(DATA_TO_ENCRYPT, CryptoAction.ENCRYPT_AND_SIGN);
        for (Map.Entry<String, AttributeValue.Builder> entry:plainTextAttribute.entrySet()
        ) {
            if (entry.getKey().contains("Attribute")) {
                legacyActions.put(entry.getKey(), CryptoAction.ENCRYPT_AND_SIGN);
            }
        }

        final LegacyOverride legacyConfig = LegacyOverride
                                                  .builder()
                                                  .encryptor(DynamoDBEncryptor.getInstance(createLegacyMaterialProvider()))
                                                  .policy(LegacyPolicy.FORBID_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT)
                                                  .attributeActionsOnEncrypt(legacyActions)
                                                  .build();

        final DynamoDbItemEncryptorConfig config = DynamoDbItemEncryptorConfig.builder().logicalTableName(TEST_TABLE)
                                                                              .partitionKeyName(PARTITION_ATTRIBUTE)
                                                                              .sortKeyName(SORT_ATTRIBUTE)
                                                                              .attributeActionsOnEncrypt(getAttributeActions(plainTextAttribute))
                                                                              .keyring(createKeyring())
                                                                              .legacyOverride(legacyConfig)
                                                                              .allowedUnsignedAttributePrefix(UNAUTH_PREFIX)
                                                                              .algorithmSuiteId(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384)
                                                                              .build();
        dynamoDbItemEncryptor = DynamoDbItemEncryptor.builder().DynamoDbItemEncryptorConfig(config)
                                                     .build();

        encryptedAttributes = encrypt();

    }

    private WrappedMaterialsProvider createLegacyMaterialProvider() {
        final SecureRandom secureRandom = new SecureRandom();
        byte[] rawAes = new byte[32];
        byte[] rawHmac = new byte[32];
        secureRandom.nextBytes(rawAes);
        secureRandom.nextBytes(rawHmac);
        final SecretKey wrappingKeys = new SecretKeySpec(rawAes, "AES");
        final SecretKey signingKeys = new SecretKeySpec(rawHmac, "HmacSHA256");
        final WrappedMaterialsProvider cmp =
                new WrappedMaterialsProvider(wrappingKeys, wrappingKeys, signingKeys);
        return cmp;
    }

    public LegacyConfigTest() {
    }

    LegacyConfigTest(String plainTextFileJson) {
        this.plainTextFile = plainTextFileJson;
    }

    /**
     * main Method to execute tests without JMH. This is helpful in profiling in IDEs (especially IntelliJ) which fails
     * to profile JMH annotated runs.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        TestBase testBase = new LegacyConfigTest("single_attribute.json");
        testBase.setup();
        testBase.decrypt();

    }
}
