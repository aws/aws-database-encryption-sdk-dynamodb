package software.aws.cryptography.performance.itemencryptor.v3;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.univocity.parsers.fixed.FieldAlignment;
import com.univocity.parsers.fixed.FixedWidthFields;
import com.univocity.parsers.fixed.FixedWidthWriter;
import com.univocity.parsers.fixed.FixedWidthWriterSettings;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DecryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.EncryptItemInput;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static software.aws.cryptography.performance.itemencryptor.TestConstants.DATA_TO_ENCRYPT;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.DATA_TO_IGNORE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.DATA_TO_SIGN;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.PARTITION_ATTRIBUTE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.SIZE_RESULTS_FILE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.SORT_ATTRIBUTE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.SORT_NUMBER;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.TEST_PK;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.TEST_TABLE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.UNAUTH_PREFIX;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(1)
@Warmup(iterations = 2, time = 2)
@Measurement(iterations = 3, time = 3)
public abstract class TestBase {
    @Param({"single_attribute.json", "nested_attributes.json", "flat_attributes.json"})
    protected String plainTextFile;
    protected Map<String, AttributeValue> encryptedAttributes;
    protected Map<String, AttributeValue.Builder> plainTextAttribute = new HashMap<>();
    protected DynamoDbItemEncryptor dynamoDbItemEncryptor;
    protected Map<String, AttributeValue> itemBeforeEncrypt;
    protected Map<String, AttributeValue> originalItem;

    protected ObjectMapper mapper = JsonMapper.builder()
                                              .serializationInclusion(JsonInclude.Include.NON_NULL)
                                              .build();
    protected abstract IKeyring createKeyring();

    protected Map<String, CryptoAction> getAttributeActions(Map<String, AttributeValue.Builder> record) {
        final Map<String, CryptoAction> attributeActions = new HashMap<>();
        attributeActions.put(PARTITION_ATTRIBUTE, CryptoAction.SIGN_ONLY);
        attributeActions.put(SORT_ATTRIBUTE, CryptoAction.SIGN_ONLY);
        attributeActions.put(DATA_TO_ENCRYPT, CryptoAction.ENCRYPT_AND_SIGN);
        attributeActions.put(DATA_TO_SIGN, CryptoAction.SIGN_ONLY);
        attributeActions.put(DATA_TO_IGNORE, CryptoAction.DO_NOTHING);
        for (Map.Entry<String, AttributeValue.Builder> entry:record.entrySet()
        ) {
            if (entry.getKey().contains("Attribute")) {
                attributeActions.put(entry.getKey(), CryptoAction.ENCRYPT_AND_SIGN);
            }
        }
        return attributeActions;
    }

    @Setup
    public void setup() throws Exception {
        final JsonNode plainTextJson = mapper.readTree(getClass().getClassLoader().getResourceAsStream(plainTextFile));
        plainTextJson.properties().forEach((entry) -> plainTextAttribute.put(entry.getKey(), mapper.convertValue(entry.getValue(), AttributeValue.serializableBuilderClass())));

        final DynamoDbItemEncryptorConfig config = DynamoDbItemEncryptorConfig.builder().logicalTableName(TEST_TABLE)
                                                                              .partitionKeyName(PARTITION_ATTRIBUTE)
                                                                              .sortKeyName(SORT_ATTRIBUTE)
                                                                              .attributeActionsOnEncrypt(getAttributeActions(plainTextAttribute))
                                                                              .keyring(createKeyring())
                                                                              .allowedUnsignedAttributePrefix(UNAUTH_PREFIX)
                                                                              .algorithmSuiteId(DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384)
                                                                              .build();

        dynamoDbItemEncryptor = DynamoDbItemEncryptor.builder().DynamoDbItemEncryptorConfig(config)
                                                     .build();
        encryptedAttributes = encrypt();

    }

    @Benchmark
    public Map<String, AttributeValue> encrypt() throws Exception {

        final Map<String, AttributeValue> originalItem = new HashMap<>();
        originalItem.put(PARTITION_ATTRIBUTE, AttributeValue.builder().s(TEST_PK).build());
        originalItem.put(SORT_ATTRIBUTE, AttributeValue.builder().n(SORT_NUMBER).build());
        plainTextAttribute.forEach((key, value) -> originalItem.put(key, value.build()));
        itemBeforeEncrypt = originalItem;
        encryptedAttributes = dynamoDbItemEncryptor.EncryptItem(
                EncryptItemInput.builder()
                                .plaintextItem(originalItem)
                                .build()
        ).encryptedItem();
        return encryptedAttributes;
    }

    @Benchmark
    public Map<String, AttributeValue> decrypt() {
        final Map<String, AttributeValue> decryptedItem = dynamoDbItemEncryptor.DecryptItem(
                DecryptItemInput.builder()
                                .encryptedItem(encryptedAttributes)
                                .build()
        ).plaintextItem();
        return decryptedItem;
    }

    @TearDown
    public void writeSizeToFile() throws Exception {
        final File sizeResults = new File(SIZE_RESULTS_FILE);
        sizeResults.getParentFile().mkdirs();
        sizeResults.createNewFile();
        final FileOutputStream fileOutputStream = new FileOutputStream(sizeResults, true);

        final Map<String, Object> originalObject = new HashMap<>();
        final Map<String, Object> encryptedObject = new HashMap<>();
        itemBeforeEncrypt.forEach((key, value) -> originalObject.put(key, value.toBuilder()));
        encryptedAttributes.forEach((key, value) -> encryptedObject.put(key, value.toBuilder()));

        final ObjectMapper mapper = new ObjectMapper();
        FixedWidthFields fields = new FixedWidthFields();
        fields.addField("MethodName", 50, FieldAlignment.LEFT);
        fields.addField("OriginalSize", 20, FieldAlignment.LEFT);
        fields.addField("EncryptedSize", 20);
        fields.addField("Diff", 20);

        int lengthBeforeEncrypt = mapper.writeValueAsString(originalObject).length();
        int lengthAfterEncrypt = mapper.writeValueAsString(encryptedObject).length();
        int diff = lengthAfterEncrypt - lengthBeforeEncrypt;

        final String operationName = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass().getSimpleName();

        FixedWidthWriter fixedWidthWriter = new FixedWidthWriter(fileOutputStream, new FixedWidthWriterSettings(fields));
        fixedWidthWriter.writeRow(operationName, lengthBeforeEncrypt, lengthAfterEncrypt, diff);
        fixedWidthWriter.close();
        fileOutputStream.close();
    }

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder()
                                  .build();
        new Runner(options).run();
    }
}
