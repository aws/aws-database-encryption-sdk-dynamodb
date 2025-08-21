package software.aws.cryptography.performance.itemencryptor.v2;

import static software.aws.cryptography.performance.itemencryptor.TestConstants.DATA_TO_ENCRYPT;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.PARTITION_ATTRIBUTE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.SIZE_RESULTS_FILE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.SORT_ATTRIBUTE;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.SORT_NUMBER;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.TEST_PK;
import static software.aws.cryptography.performance.itemencryptor.TestConstants.TEST_TABLE;

import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionContext;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.EncryptionFlags;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.EncryptionMaterialsProvider;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.univocity.parsers.fixed.FieldAlignment;
import com.univocity.parsers.fixed.FixedWidthFields;
import com.univocity.parsers.fixed.FixedWidthWriter;
import com.univocity.parsers.fixed.FixedWidthWriterSettings;
import java.io.File;
import java.io.FileOutputStream;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
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

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(1)
@Warmup(iterations = 2, time = 2)
@Measurement(iterations = 3, time = 3)
public abstract class TestBase {

  @Param(
    {
      "single_attribute.json", "nested_attributes.json", "flat_attributes.json",
    }
  )
  protected String plainTextFile;

  protected Map<String, AttributeValue> plainTextAttribute = new HashMap<>();
  protected Map<String, AttributeValue> itemBeforeEncrypt;
  protected Map<String, AttributeValue> encryptedAttributes;
  protected ObjectMapper mapper = JsonMapper
    .builder()
    .serializationInclusion(JsonInclude.Include.NON_NULL)
    .build();

  DynamoDBEncryptor encryptor;

  protected abstract EncryptionMaterialsProvider createMasterKeyProvider();

  @Setup
  public void setup() throws Exception {
    encryptor = DynamoDBEncryptor.getInstance(createMasterKeyProvider());
    plainTextAttribute =
      new ObjectMapper()
        .readValue(
          getClass().getClassLoader().getResourceAsStream(plainTextFile),
          new TypeReference<Map<String, AttributeValue>>() {}
        );
    encryptedAttributes = encrypt();
  }

  protected Map<String, Set<EncryptionFlags>> getAttributeActions(
    Map<String, AttributeValue> record
  ) {
    final EnumSet<EncryptionFlags> signOnly = EnumSet.of(EncryptionFlags.SIGN);
    final EnumSet<EncryptionFlags> encryptAndSign = EnumSet.of(
      EncryptionFlags.ENCRYPT,
      EncryptionFlags.SIGN
    );
    final Map<String, Set<EncryptionFlags>> actions = new HashMap<>();
    actions.put(PARTITION_ATTRIBUTE, signOnly);
    actions.put(SORT_ATTRIBUTE, signOnly);
    actions.put(DATA_TO_ENCRYPT, encryptAndSign);
    for (Map.Entry<String, AttributeValue> entry : record.entrySet()) {
      if (entry.getKey().contains("Attribute")) {
        actions.put(entry.getKey(), encryptAndSign);
      }
    }
    return actions;
  }

  @Benchmark
  public Map<String, AttributeValue> encrypt() throws Exception {
    final Map<String, AttributeValue> record = new HashMap<>();
    record.put(PARTITION_ATTRIBUTE, new AttributeValue().withS(TEST_PK));
    record.put(SORT_ATTRIBUTE, new AttributeValue().withN(SORT_NUMBER));
    record.putAll(plainTextAttribute);

    final EncryptionContext encryptionContext = new EncryptionContext.Builder()
      .withTableName(TEST_TABLE)
      .withHashKeyName(PARTITION_ATTRIBUTE)
      .withRangeKeyName(SORT_ATTRIBUTE)
      .build();

    itemBeforeEncrypt = record;

    final Map<String, AttributeValue> encrypted_record =
      encryptor.encryptRecord(
        record,
        getAttributeActions(record),
        encryptionContext
      );
    return encrypted_record;
  }

  @Benchmark
  public Map<String, AttributeValue> decrypt() throws Exception {
    final EncryptionContext encryptionContext = new EncryptionContext.Builder()
      .withTableName(TEST_TABLE)
      .withHashKeyName(PARTITION_ATTRIBUTE)
      .withRangeKeyName(SORT_ATTRIBUTE)
      .build();
    final Map<String, AttributeValue> decrypted_record =
      encryptor.decryptRecord(
        encryptedAttributes,
        getAttributeActions(plainTextAttribute),
        encryptionContext
      );
    return decrypted_record;
  }

  @TearDown
  public void writeSizeToFile() throws Exception {
    final File sizeResults = new File(SIZE_RESULTS_FILE);
    sizeResults.getParentFile().mkdirs();
    sizeResults.createNewFile();
    final FileOutputStream fileOutputStream = new FileOutputStream(
      sizeResults,
      true
    );

    FixedWidthFields fields = new FixedWidthFields();
    fields.addField("MethodName", 50, FieldAlignment.LEFT);
    fields.addField("OriginalSize", 20, FieldAlignment.LEFT);
    fields.addField("EncryptedSize", 20);
    fields.addField("Diff", 20);

    final ObjectMapper mapper = new ObjectMapper();
    final String operationName = StackWalker
      .getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
      .getCallerClass()
      .getSimpleName();
    int lengthBeforeEncrypt = mapper
      .writeValueAsString(itemBeforeEncrypt)
      .length();
    int lengthAfterEncrypt = mapper
      .writeValueAsString(encryptedAttributes)
      .length();
    int diff = lengthAfterEncrypt - lengthBeforeEncrypt;

    FixedWidthWriter fixedWidthWriter = new FixedWidthWriter(
      fileOutputStream,
      new FixedWidthWriterSettings(fields)
    );
    fixedWidthWriter.writeRow(
      operationName,
      lengthBeforeEncrypt,
      lengthAfterEncrypt,
      diff
    );
    fixedWidthWriter.close();
    fileOutputStream.close();
  }

  public static void main(String[] args) throws Exception {
    Options options = new OptionsBuilder().build();
    new Runner(options).run();
  }
}
