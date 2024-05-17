package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import static org.testng.Assert.assertEquals;
import static software.amazon.cryptography.dbencryptionsdk.dynamodb.TestUtils.*;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.AttributeEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import javax.annotation.Nullable;
import org.testng.annotations.Test;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.PutItemEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.PutItemEnhancedResponse;
import software.amazon.awssdk.enhanced.dynamodb.model.UpdateItemEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.ReturnValue;
import software.amazon.awssdk.services.kms.model.KmsException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.validdatamodels.*;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyPolicy;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.IKeyring;

public class DynamoDbEncryptionEnhancedClientIntegrationTests {

  // Some integration tests MUST mutate the state of the DDB table.
  // For such tests, include a random number in the primary key
  // to avoid conflicts between distributed test runners sharing a table.
  private int randomNum = ThreadLocalRandom
    .current()
    .nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);

  private static <T> DynamoDbEnhancedClient initEnhancedClientWithInterceptor(
    final TableSchema<T> schemaOnEncrypt,
    final List<String> allowedUnsignedAttributes,
    @Nullable String kmsKeyId,
    @Nullable String tableName
  ) {
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    IKeyring kmsKeyring = kmsKeyId == null
      ? createKmsKeyring()
      : createKmsKeyring(kmsKeyId);
    String testTableName = tableName == null ? TEST_TABLE_NAME : tableName;
    tableConfigs.put(
      testTableName,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(testTableName)
        .keyring(kmsKeyring)
        .allowedUnsignedAttributes(allowedUnsignedAttributes)
        .schemaOnEncrypt(schemaOnEncrypt)
        .build()
    );

    DynamoDbEncryptionInterceptor interceptor =
      DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
        CreateDynamoDbEncryptionInterceptorInput
          .builder()
          .tableEncryptionConfigs(tableConfigs)
          .build()
      );
    DynamoDbClient ddb = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(interceptor)
          .build()
      )
      .build();
    return DynamoDbEnhancedClient.builder().dynamoDbClient(ddb).build();
  }

  private static DynamoDbEnhancedClient createEnhancedClientForLegacyClass(
    DynamoDBEncryptor oldEncryptor,
    TableSchema schemaOnEncrypt
  ) {
    Map<String, CryptoAction> legacyActions = new HashMap<>();
    legacyActions.put("partition_key", CryptoAction.SIGN_ONLY);
    legacyActions.put("sort_key", CryptoAction.SIGN_ONLY);
    legacyActions.put("encryptAndSign", CryptoAction.ENCRYPT_AND_SIGN);
    legacyActions.put("signOnly", CryptoAction.SIGN_ONLY);
    legacyActions.put("doNothing", CryptoAction.DO_NOTHING);
    LegacyOverride legacyOverride = LegacyOverride
      .builder()
      .encryptor(oldEncryptor)
      .policy(LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT)
      .attributeActionsOnEncrypt(legacyActions)
      .build();

    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .allowedUnsignedAttributes(Arrays.asList("doNothing"))
        .schemaOnEncrypt(schemaOnEncrypt)
        .legacyOverride(legacyOverride)
        .build()
    );
    DynamoDbEncryptionInterceptor interceptor =
      DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
        CreateDynamoDbEncryptionInterceptorInput
          .builder()
          .tableEncryptionConfigs(tableConfigs)
          .build()
      );
    DynamoDbClient ddb = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(interceptor)
          .build()
      )
      .build();
    return DynamoDbEnhancedClient.builder().dynamoDbClient(ddb).build();
  }

  @Test
  public void TestPutAndGet() {
    TableSchema<SimpleClass> schemaOnEncrypt = TableSchema.fromBean(
      SimpleClass.class
    );
    List<String> allowedUnsignedAttributes = Collections.singletonList(
      "doNothing"
    );
    DynamoDbEnhancedClient enhancedClient = initEnhancedClientWithInterceptor(
      schemaOnEncrypt,
      allowedUnsignedAttributes,
      null,
      null
    );

    DynamoDbTable<SimpleClass> table = enhancedClient.table(
      TEST_TABLE_NAME,
      schemaOnEncrypt
    );

    SimpleClass record = new SimpleClass();
    record.setPartitionKey("SimpleEnhanced");
    record.setSortKey(777);
    record.setEncryptAndSign("lorem");
    record.setSignOnly("ipsum");
    record.setDoNothing("fizzbuzz");

    // Put an item into an Amazon DynamoDB table.
    table.putItem(record);

    // Get the item back from the table
    Key key = Key
      .builder()
      .partitionValue("SimpleEnhanced")
      .sortValue(777)
      .build();

    // Get the item by using the key.
    SimpleClass result =
      table.getItem((GetItemEnhancedRequest.Builder requestBuilder) ->
        requestBuilder.key(key)
      );
    assertEquals(result.getPartitionKey(), "SimpleEnhanced");
    assertEquals(result.getSortKey(), 777);
    assertEquals(result.getEncryptAndSign(), "lorem");
    assertEquals(result.getSignOnly(), "ipsum");
    assertEquals(result.getDoNothing(), "fizzbuzz");
  }

  @Test
  public void TestPutAndGetAllTypes() {
    TableSchema<AllTypesClass> schemaOnEncrypt = TableSchema.fromBean(
      AllTypesClass.class
    );
    List<String> allowedUnsignedAttributes = Collections.singletonList(
      "doNothing"
    );
    DynamoDbEnhancedClient enhancedClient = initEnhancedClientWithInterceptor(
      schemaOnEncrypt,
      allowedUnsignedAttributes,
      null,
      null
    );

    DynamoDbTable<AllTypesClass> table = enhancedClient.table(
      TEST_TABLE_NAME,
      schemaOnEncrypt
    );

    AllTypesClass record = AllTypesClass.createTestItem(
      "EnhancedPutGetAllTypes",
      1
    );

    // Put an item into DDB such that it also returns back the item.
    PutItemEnhancedResponse putItemResp =
      table.putItemWithResponse((PutItemEnhancedRequest.Builder<
          AllTypesClass
        > requestBuilder) ->
        requestBuilder.item(record).returnValues(ReturnValue.ALL_OLD)
      );
    assertEquals(putItemResp.attributes(), record);

    // Get the item back from the table
    Key key = Key
      .builder()
      .partitionValue("EnhancedPutGetAllTypes")
      .sortValue(1)
      .build();

    // Get the item by using the key.
    AllTypesClass result =
      table.getItem((GetItemEnhancedRequest.Builder requestBuilder) ->
        requestBuilder.key(key)
      );
    assertEquals(result, record);
  }

  @Test
  public void TestPutAndGetAnnotatedFlattenedBean() {
    final String PARTITION = "AnnotatedFlattenedBean";
    final int SORT = 20230713;

    TableSchema<AnnotatedFlattenedBean> schemaOnEncrypt = TableSchema.fromBean(
      AnnotatedFlattenedBean.class
    );
    List<String> allowedUnsignedAttributes = Collections.singletonList(
      "lastName"
    );
    DynamoDbEnhancedClient enhancedClient = initEnhancedClientWithInterceptor(
      schemaOnEncrypt,
      allowedUnsignedAttributes,
      null,
      null
    );
    DynamoDbTable<AnnotatedFlattenedBean> table = enhancedClient.table(
      TEST_TABLE_NAME,
      schemaOnEncrypt
    );

    AnnotatedFlattenedBean record = new AnnotatedFlattenedBean();
    record.setPartitionKey(PARTITION);
    record.setSortKey(SORT);
    AnnotatedFlattenedBean.FlattenedNestedBean nestedBean =
      new AnnotatedFlattenedBean.FlattenedNestedBean(
        "9305B367-C477-4A58-9E6C-BF7D59D17C8A",
        "James",
        "Bond"
      );
    record.setNestedBeanClass(nestedBean);

    // Put an item into an Amazon DynamoDB table.
    table.putItem(record);

    // Get the item back from the table
    Key key = Key.builder().partitionValue(PARTITION).sortValue(SORT).build();

    // Get the item by using the key.
    AnnotatedFlattenedBean result =
      table.getItem((GetItemEnhancedRequest.Builder requestBuilder) ->
        requestBuilder.key(key)
      );
    assertEquals(result.getPartitionKey(), record.getPartitionKey());
    assertEquals(result.getSortKey(), record.getSortKey());
    assertEquals(result.getNestedBeanClass(), record.getNestedBeanClass());
  }

  @Test
  public void TestPutAndGetAnnotatedConvertedBy() {
    final String PARTITION = "AnnotatedConvertedBy";
    final int SORT = 20230713;
    TableSchema<AnnotatedConvertedBy> schemaOnEncrypt = TableSchema.fromBean(
      AnnotatedConvertedBy.class
    );
    List<String> allowedUnsignedAttributes = Collections.singletonList(
      "nestedIgnored"
    );
    DynamoDbEnhancedClient enhancedClient = initEnhancedClientWithInterceptor(
      schemaOnEncrypt,
      allowedUnsignedAttributes,
      null,
      null
    );

    DynamoDbTable<AnnotatedConvertedBy> table = enhancedClient.table(
      TEST_TABLE_NAME,
      schemaOnEncrypt
    );

    AnnotatedConvertedBy record = new AnnotatedConvertedBy();
    record.setPartitionKey(PARTITION);
    record.setSortKey(SORT);
    AnnotatedConvertedBy.ConvertedByNestedBean nestedBean =
      new AnnotatedConvertedBy.ConvertedByNestedBean(
        "9305B367-C477-4A58-9E6C-BF7D59D17C8A",
        "Winnie",
        "the-Pooh"
      );
    record.setNestedEncrypted(nestedBean);
    record.setNestedIgnored(nestedBean);
    record.setNestedSigned(nestedBean);

    // Put an item into an Amazon DynamoDB table.
    table.putItem(record);

    // Get the item back from the table
    Key key = Key.builder().partitionValue(PARTITION).sortValue(SORT).build();

    // Get the item by using the key.
    AnnotatedConvertedBy result =
      table.getItem((GetItemEnhancedRequest.Builder requestBuilder) ->
        requestBuilder.key(key)
      );
    assertEquals(result.getPartitionKey(), record.getPartitionKey());
    assertEquals(result.getSortKey(), record.getSortKey());
    assertEquals(result.getNestedIgnored(), record.getNestedIgnored());
    assertEquals(result.getNestedEncrypted(), record.getNestedEncrypted());
    assertEquals(result.getNestedSigned(), record.getNestedSigned());
  }

  @Test
  public void TestPutAndGetSignOnly() {
    TableSchema<SignOnlyClass> schemaOnEncrypt = TableSchema.fromBean(
      SignOnlyClass.class
    );
    List<String> allowedUnsignedAttributes = Collections.singletonList(
      "doNothing"
    );
    DynamoDbEnhancedClient enhancedClient = initEnhancedClientWithInterceptor(
      schemaOnEncrypt,
      allowedUnsignedAttributes,
      null,
      null
    );
    DynamoDbTable<SignOnlyClass> table = enhancedClient.table(
      TEST_TABLE_NAME,
      schemaOnEncrypt
    );

    SignOnlyClass record = new SignOnlyClass();
    record.setPartitionKey("SignOnlyEnhanced");
    record.setSortKey(777);
    record.setAttr1("lorem");
    record.setAttr2("ipsum");

    // Put an item into an Amazon DynamoDB table.
    table.putItem(record);

    // Get the item back from the table
    Key key = Key
      .builder()
      .partitionValue("SignOnlyEnhanced")
      .sortValue(777)
      .build();

    // Get the item by using the key.
    SignOnlyClass result =
      table.getItem((GetItemEnhancedRequest.Builder requestBuilder) ->
        requestBuilder.key(key)
      );
    assertEquals(result.getPartitionKey(), "SignOnlyEnhanced");
    assertEquals(result.getSortKey(), 777);
    assertEquals(result.getAttr1(), "lorem");
    assertEquals(result.getAttr2(), "ipsum");
  }

  @Test
  public void TestGetLegacyItem() {
    // Put item using legacy DDBMapper
    AWSKMS kmsClient = AWSKMSClientBuilder.standard().build();
    final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(
      kmsClient,
      KMS_TEST_KEY_ID
    );
    final DynamoDBEncryptor oldEncryptor = DynamoDBEncryptor.getInstance(cmp);
    final AmazonDynamoDB ddbv1 = AmazonDynamoDBClientBuilder.standard().build();
    DynamoDBMapperConfig mapperConfig = DynamoDBMapperConfig
      .builder()
      .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.PUT)
      .build();
    DynamoDBMapper mapper = new DynamoDBMapper(
      ddbv1,
      mapperConfig,
      new AttributeEncryptor(oldEncryptor)
    );

    LegacyClass record = new LegacyClass();
    record.setPartitionKey("ddbMapperItem");
    record.setSortKey(777);
    record.setEncryptAndSign("lorem");
    record.setSignOnly("ipsum");
    record.setDoNothing("fizzbuzz");

    mapper.save(record);

    TableSchema<LegacyClass> schemaOnEncrypt = TableSchema.fromBean(
      LegacyClass.class
    );
    DynamoDbEnhancedClient enhancedClient = createEnhancedClientForLegacyClass(
      oldEncryptor,
      schemaOnEncrypt
    );

    DynamoDbTable<LegacyClass> table = enhancedClient.table(
      TEST_TABLE_NAME,
      schemaOnEncrypt
    );

    // Get the item back from the table
    Key key = Key
      .builder()
      .partitionValue("ddbMapperItem")
      .sortValue(777)
      .build();
    LegacyClass result =
      table.getItem((GetItemEnhancedRequest.Builder requestBuilder) ->
        requestBuilder.key(key)
      );
    assertEquals("ddbMapperItem", result.getPartitionKey());
    assertEquals(777, result.getSortKey());
    assertEquals("lorem", result.getEncryptAndSign());
    assertEquals("ipsum", result.getSignOnly());
    assertEquals("fizzbuzz", result.getDoNothing());
  }

  @Test
  public void TestWriteLegacyItem() {
    // Configure EnhancedClient with Legacy behavior
    AWSKMS kmsClient = AWSKMSClientBuilder.standard().build();
    final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(
      kmsClient,
      KMS_TEST_KEY_ID
    );
    final DynamoDBEncryptor oldEncryptor = DynamoDBEncryptor.getInstance(cmp);
    TableSchema<LegacyClass> schemaOnEncrypt = TableSchema.fromBean(
      LegacyClass.class
    );
    DynamoDbEnhancedClient enhancedClient = createEnhancedClientForLegacyClass(
      oldEncryptor,
      schemaOnEncrypt
    );

    LegacyClass record = new LegacyClass();
    record.setPartitionKey("legacyItem");
    record.setSortKey(777);
    record.setEncryptAndSign("lorem");
    record.setSignOnly("ipsum");
    record.setDoNothing("fizzbuzz");

    DynamoDbTable<LegacyClass> table = enhancedClient.table(
      TEST_TABLE_NAME,
      schemaOnEncrypt
    );
    table.putItem(record);

    // Get item using legacy DDBMapper
    final AmazonDynamoDB ddbv1 = AmazonDynamoDBClientBuilder.standard().build();
    DynamoDBMapperConfig mapperConfig = DynamoDBMapperConfig
      .builder()
      .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.PUT)
      .build();
    DynamoDBMapper mapper = new DynamoDBMapper(
      ddbv1,
      mapperConfig,
      new AttributeEncryptor(oldEncryptor)
    );

    LegacyClass result = mapper.load(LegacyClass.class, "legacyItem", 777);
    assertEquals("legacyItem", result.getPartitionKey());
    assertEquals(777, result.getSortKey());
    assertEquals("lorem", result.getEncryptAndSign());
    assertEquals("ipsum", result.getSignOnly());
    assertEquals("fizzbuzz", result.getDoNothing());
  }

  @Test
  public void TestDelete() {
    TableSchema<AllTypesClass> schemaOnEncrypt = TableSchema.fromBean(
      AllTypesClass.class
    );
    List<String> allowedUnsignedAttributes = Collections.singletonList(
      "doNothing"
    );
    DynamoDbEnhancedClient enhancedClient = initEnhancedClientWithInterceptor(
      schemaOnEncrypt,
      allowedUnsignedAttributes,
      null,
      null
    );

    DynamoDbTable<AllTypesClass> table = enhancedClient.table(
      TEST_TABLE_NAME,
      schemaOnEncrypt
    );

    AllTypesClass record = AllTypesClass.createTestItem(
      "EnhancedDelete",
      randomNum
    );

    // Put an item into an Amazon DynamoDB table.
    table.putItem(record);

    // Get the item back from the table
    Key key = Key
      .builder()
      .partitionValue("EnhancedDelete")
      .sortValue(randomNum)
      .build();

    // Get the item by using the key.
    AllTypesClass result = table.deleteItem(key);
    assertEquals(result, record);
  }

  @Test
  public void TestUpdate() {
    TableSchema<AllTypesClass> schemaOnEncrypt = TableSchema.fromBean(
      AllTypesClass.class
    );
    List<String> allowedUnsignedAttributes = Collections.singletonList(
      "doNothing"
    );
    DynamoDbEnhancedClient enhancedClient = initEnhancedClientWithInterceptor(
      schemaOnEncrypt,
      allowedUnsignedAttributes,
      null,
      null
    );

    DynamoDbTable<AllTypesClass> table = enhancedClient.table(
      TEST_TABLE_NAME,
      schemaOnEncrypt
    );

    AllTypesClass record = AllTypesClass.createTestItem("EnhancedUpdate", 1);

    // Put an item into an Amazon DynamoDB table.
    table.putItem(record);

    AllTypesClass doNothingValue = new AllTypesClass();
    doNothingValue.setDoNothing("updatedDoNothing");
    doNothingValue.setPartitionKey("EnhancedUpdate");
    doNothingValue.setSortKey(1);

    // Perform an update only on "doNothing" attribute
    AllTypesClass result = table.updateItem((UpdateItemEnhancedRequest.Builder<
        AllTypesClass
      > requestBuilder) ->
      requestBuilder.item(doNothingValue).ignoreNulls(true)
    );
    // EnhancedClient uses ReturnValues of ALL_NEW, so compare against put item with update
    record.setDoNothing("updatedDoNothing");
    assertEquals(result, record);
  }

  @Test(
    expectedExceptions = KmsException.class,
    expectedExceptionsMessageRegExp = ".*"
  )
  public void TestKmsError() {
    // Use an KMS Key that does not exist
    String invalidKey =
      "arn:aws:kms:us-west-2:658956600833:key/ffffffff-ffff-ffff-ffff-ffffffffffff";
    TableSchema<SimpleClass> schemaOnEncrypt = TableSchema.fromBean(
      SimpleClass.class
    );
    List<String> allowedUnsignedAttributes = Collections.singletonList(
      "doNothing"
    );
    DynamoDbEnhancedClient enhancedClient = initEnhancedClientWithInterceptor(
      schemaOnEncrypt,
      allowedUnsignedAttributes,
      invalidKey,
      null
    );
    DynamoDbTable<SimpleClass> table = enhancedClient.table(
      TEST_TABLE_NAME,
      schemaOnEncrypt
    );

    SimpleClass record = new SimpleClass();
    record.setPartitionKey("foo");
    record.setSortKey(777);
    record.setEncryptAndSign("lorem");
    record.setSignOnly("ipsum");
    record.setDoNothing("fizzbuzz");

    // Put an item into an Amazon DynamoDB table.
    table.putItem(record);
  }

  @Test(
    expectedExceptions = DynamoDbException.class,
    expectedExceptionsMessageRegExp = ".*Status Code: 400.*"
  )
  public void TestDdbError() {
    // Use a DynamoDB Table that does not exist
    String badTableName = "tableDoesNotExist";
    TableSchema<SimpleClass> schemaOnEncrypt = TableSchema.fromBean(
      SimpleClass.class
    );
    List<String> allowedUnsignedAttributes = Collections.singletonList(
      "doNothing"
    );
    DynamoDbEnhancedClient enhancedClient = initEnhancedClientWithInterceptor(
      schemaOnEncrypt,
      allowedUnsignedAttributes,
      null,
      badTableName
    );

    DynamoDbTable<SimpleClass> table = enhancedClient.table(
      badTableName,
      schemaOnEncrypt
    );

    SimpleClass record = new SimpleClass();
    record.setPartitionKey("foo");
    record.setSortKey(777);
    record.setEncryptAndSign("lorem");
    record.setSignOnly("ipsum");
    record.setDoNothing("fizzbuzz");

    // Put an item into an Amazon DynamoDB table.
    table.putItem(record);
  }
}
