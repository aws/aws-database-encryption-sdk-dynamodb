package software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient;

import static org.testng.Assert.*;
import static software.amazon.cryptography.dbencryptionsdk.dynamodb.TestUtils.*;

import com.amazonaws.services.dynamodbv2.datamodeling.encryption.DynamoDBEncryptor;
import com.amazonaws.services.dynamodbv2.datamodeling.encryption.providers.DirectKmsMaterialProvider;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.testng.annotations.Test;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.invaliddatamodels.*;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.validdatamodels.*;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.model.DynamoDbItemEncryptorException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionException;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyOverride;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.LegacyPolicy;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;

public class DynamoDbEnhancedClientEncryptionTest {

  @Test
  public void TestMultipleTables() {
    TableSchema<SimpleClass> simpleSchema = TableSchema.fromBean(
      SimpleClass.class
    );
    TableSchema<SignOnlyClass> signOnlySchema = TableSchema.fromBean(
      SignOnlyClass.class
    );
    TableSchema<SignAndIncludeInEncryptionContextClass> signAndIncludeSchema =
      TableSchema.fromBean(SignAndIncludeInEncryptionContextClass.class);
    TableSchema<SingleTable1> singleTable1Schema = TableSchema.fromBean(
      SingleTable1.class
    );
    TableSchema<SingleTable2> singleTable2Schema = TableSchema.fromBean(
      SingleTable2.class
    );
    TableSchema<SingleTable3> singleTable3Schema = TableSchema.fromBean(
      SingleTable3.class
    );
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      "SimpleClassTestTable",
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName("SimpleClassTestTable")
        .keyring(createKmsKeyring())
        .allowedUnsignedAttributes(Arrays.asList("doNothing"))
        .schemaOnEncrypt(simpleSchema)
        .algorithmSuiteId(
          DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384
        )
        .build()
    );
    tableConfigs.put(
      "SignOnlyClassTestTable",
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName("SignOnlyClassTestTable")
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(signOnlySchema)
        .build()
    );
    tableConfigs.put(
      "SignAndIncludeInEncryptionContextClassTestTable",
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName("SignAndIncludeInEncryptionContextClassTestTable")
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(signAndIncludeSchema)
        .build()
    );
    tableConfigs.put(
      "SingleTableTestTable",
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName("SingleTableTestTable")
        .keyring(createKmsKeyring())
        .allowedUnsignedAttributes(Arrays.asList("doNothing"))
        .allowedUnsignedAttributePrefix("extraDoNothing")
        .schemaOnEncrypt(singleTable1Schema)
        .schemaOnEncrypt(singleTable2Schema)
        .schemaOnEncrypt(singleTable3Schema)
        .build()
    );
    DynamoDbEncryptionInterceptor interceptor =
      DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
        CreateDynamoDbEncryptionInterceptorInput
          .builder()
          .tableEncryptionConfigs(tableConfigs)
          .build()
      );
    assertEquals(4, interceptor.config().tableEncryptionConfigs().size());

    DynamoDbTableEncryptionConfig simpleConfig = interceptor
      .config()
      .tableEncryptionConfigs()
      .get("SimpleClassTestTable");
    assertEquals(
      DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384,
      simpleConfig.algorithmSuiteId()
    );
    assertEquals(
      CryptoAction.DO_NOTHING,
      simpleConfig.attributeActionsOnEncrypt().get("doNothing")
    );
    assertEquals(
      CryptoAction.SIGN_ONLY,
      simpleConfig.attributeActionsOnEncrypt().get("signOnly")
    );
    assertEquals(
      CryptoAction.SIGN_ONLY,
      simpleConfig.attributeActionsOnEncrypt().get("partition_key")
    );
    assertEquals(
      CryptoAction.SIGN_ONLY,
      simpleConfig.attributeActionsOnEncrypt().get("sort_key")
    );
    assertEquals(
      CryptoAction.ENCRYPT_AND_SIGN,
      simpleConfig.attributeActionsOnEncrypt().get("encryptAndSign")
    );

    DynamoDbTableEncryptionConfig signOnlyConfig = interceptor
      .config()
      .tableEncryptionConfigs()
      .get("SignOnlyClassTestTable");
    assertEquals(
      CryptoAction.SIGN_ONLY,
      signOnlyConfig.attributeActionsOnEncrypt().get("partition_key")
    );
    assertEquals(
      CryptoAction.SIGN_ONLY,
      signOnlyConfig.attributeActionsOnEncrypt().get("sort_key")
    );
    assertEquals(
      CryptoAction.SIGN_ONLY,
      signOnlyConfig.attributeActionsOnEncrypt().get("attr1")
    );
    assertEquals(
      CryptoAction.SIGN_ONLY,
      signOnlyConfig.attributeActionsOnEncrypt().get("attr2")
    );

    DynamoDbTableEncryptionConfig signAndIncludeConfig = interceptor
      .config()
      .tableEncryptionConfigs()
      .get("SignAndIncludeInEncryptionContextClassTestTable");
    assertEquals(
      CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      signAndIncludeConfig.attributeActionsOnEncrypt().get("partition_key")
    );
    assertEquals(
      CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      signAndIncludeConfig.attributeActionsOnEncrypt().get("sort_key")
    );
    assertEquals(
      CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      signAndIncludeConfig.attributeActionsOnEncrypt().get("attr1")
    );
    assertEquals(
      CryptoAction.SIGN_ONLY,
      signAndIncludeConfig.attributeActionsOnEncrypt().get("attr2")
    );

    DynamoDbTableEncryptionConfig singleTableConfig = interceptor
      .config()
      .tableEncryptionConfigs()
      .get("SingleTableTestTable");
    assertEquals(
      CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      singleTableConfig.attributeActionsOnEncrypt().get("partition_key")
    );
    assertEquals(
      CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      singleTableConfig.attributeActionsOnEncrypt().get("sort_key")
    );
    assertEquals(
      CryptoAction.DO_NOTHING,
      singleTableConfig.attributeActionsOnEncrypt().get("doNothing")
    );
    assertEquals(
      CryptoAction.SIGN_ONLY,
      singleTableConfig.attributeActionsOnEncrypt().get("signOnly")
    );
    assertEquals(
      CryptoAction.ENCRYPT_AND_SIGN,
      singleTableConfig.attributeActionsOnEncrypt().get("encryptAndSign")
    );

    assertEquals(
      CryptoAction.DO_NOTHING,
      singleTableConfig.attributeActionsOnEncrypt().get("extraDoNothing1")
    );
    assertEquals(
      CryptoAction.DO_NOTHING,
      singleTableConfig.attributeActionsOnEncrypt().get("extraDoNothing2")
    );
    assertEquals(
      CryptoAction.DO_NOTHING,
      singleTableConfig.attributeActionsOnEncrypt().get("extraDoNothing3")
    );
    assertEquals(
      CryptoAction.DO_NOTHING,
      singleTableConfig.attributeActionsOnEncrypt().get("extraDoNothing12")
    );
    assertEquals(
      CryptoAction.DO_NOTHING,
      singleTableConfig.attributeActionsOnEncrypt().get("extraDoNothing13")
    );
    assertEquals(
      CryptoAction.DO_NOTHING,
      singleTableConfig.attributeActionsOnEncrypt().get("extraDoNothing23")
    );

    assertEquals(
      CryptoAction.SIGN_ONLY,
      singleTableConfig.attributeActionsOnEncrypt().get("extraSignOnly1")
    );
    assertEquals(
      CryptoAction.SIGN_ONLY,
      singleTableConfig.attributeActionsOnEncrypt().get("extraSignOnly2")
    );
    assertEquals(
      CryptoAction.SIGN_ONLY,
      singleTableConfig.attributeActionsOnEncrypt().get("extraSignOnly3")
    );
    assertEquals(
      CryptoAction.SIGN_ONLY,
      singleTableConfig.attributeActionsOnEncrypt().get("extraSignOnly12")
    );
    assertEquals(
      CryptoAction.SIGN_ONLY,
      singleTableConfig.attributeActionsOnEncrypt().get("extraSignOnly13")
    );
    assertEquals(
      CryptoAction.SIGN_ONLY,
      singleTableConfig.attributeActionsOnEncrypt().get("extraSignOnly23")
    );

    assertEquals(
      CryptoAction.ENCRYPT_AND_SIGN,
      singleTableConfig.attributeActionsOnEncrypt().get("extraEncryptAndSign1")
    );
    assertEquals(
      CryptoAction.ENCRYPT_AND_SIGN,
      singleTableConfig.attributeActionsOnEncrypt().get("extraEncryptAndSign2")
    );
    assertEquals(
      CryptoAction.ENCRYPT_AND_SIGN,
      singleTableConfig.attributeActionsOnEncrypt().get("extraEncryptAndSign3")
    );
    assertEquals(
      CryptoAction.ENCRYPT_AND_SIGN,
      singleTableConfig.attributeActionsOnEncrypt().get("extraEncryptAndSign12")
    );
    assertEquals(
      CryptoAction.ENCRYPT_AND_SIGN,
      singleTableConfig.attributeActionsOnEncrypt().get("extraEncryptAndSign13")
    );
    assertEquals(
      CryptoAction.ENCRYPT_AND_SIGN,
      singleTableConfig.attributeActionsOnEncrypt().get("extraEncryptAndSign23")
    );

    assertEquals(
      CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      singleTableConfig.attributeActionsOnEncrypt().get("extraSignAndInclude1")
    );
    assertEquals(
      CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      singleTableConfig.attributeActionsOnEncrypt().get("extraSignAndInclude2")
    );
    assertEquals(
      CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      singleTableConfig.attributeActionsOnEncrypt().get("extraSignAndInclude3")
    );
    assertEquals(
      CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      singleTableConfig.attributeActionsOnEncrypt().get("extraSignAndInclude12")
    );
    assertEquals(
      CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      singleTableConfig.attributeActionsOnEncrypt().get("extraSignAndInclude13")
    );
    assertEquals(
      CryptoAction.SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT,
      singleTableConfig.attributeActionsOnEncrypt().get("extraSignAndInclude23")
    );
  }

  @Test
  public void TestEnhancedCreateWithLegacyPolicy() {
    // Encryptor creation
    AWSKMS kmsClient = AWSKMSClientBuilder.standard().build();
    final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(
      kmsClient,
      "kmsKeyARN"
    );
    final DynamoDBEncryptor oldEncryptor = DynamoDBEncryptor.getInstance(cmp);
    final Map<String, CryptoAction> oldActions = new HashMap<>();

    TableSchema<SimpleClass> simpleSchema = TableSchema.fromBean(
      SimpleClass.class
    );
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .allowedUnsignedAttributes(Arrays.asList("doNothing"))
        .schemaOnEncrypt(simpleSchema)
        .legacyOverride(
          LegacyOverride
            .builder()
            .encryptor(oldEncryptor)
            .policy(LegacyPolicy.FORCE_LEGACY_ENCRYPT_ALLOW_LEGACY_DECRYPT)
            .attributeActionsOnEncrypt(oldActions)
            .build()
        )
        .build()
    );
    DynamoDbEncryptionInterceptor interceptor =
      DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
        CreateDynamoDbEncryptionInterceptorInput
          .builder()
          .tableEncryptionConfigs(tableConfigs)
          .build()
      );
    assertNotNull(interceptor);
  }

  @Test
  public void TestEnhancedCreateWithAlgorithmSuite() {
    // Encryptor creation
    AWSKMS kmsClient = AWSKMSClientBuilder.standard().build();
    final DirectKmsMaterialProvider cmp = new DirectKmsMaterialProvider(
      kmsClient,
      "kmsKeyARN"
    );

    TableSchema<SimpleClass> simpleSchema = TableSchema.fromBean(
      SimpleClass.class
    );
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .allowedUnsignedAttributes(Arrays.asList("doNothing"))
        .schemaOnEncrypt(simpleSchema)
        .algorithmSuiteId(
          DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384
        )
        .build()
    );
    DynamoDbEncryptionInterceptor interceptor =
      DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
        CreateDynamoDbEncryptionInterceptorInput
          .builder()
          .tableEncryptionConfigs(tableConfigs)
          .build()
      );
    assertNotNull(interceptor);
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionException.class,
    expectedExceptionsMessageRegExp = "Attribute id of table DynamoDbEncryptionInterceptorTestTable is used as both a primary key and @DynamoDbEncryptionDoNothing."
  )
  public void TestDoNothingOnPartitionAttribute() {
    TableSchema<InvalidAnnotatedPartitionClass> schemaOnEncrypt =
      TableSchema.fromBean(InvalidAnnotatedPartitionClass.class);
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(schemaOnEncrypt)
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }

  @Test(
    expectedExceptions = DynamoDbItemEncryptorException.class,
    expectedExceptionsMessageRegExp = "Attribute doNothing is configured as DO_NOTHING but it must also be in unauthenticatedAttributes or begin with the unauthenticatedPrefix."
  )
  public void TestInconsistentSignatureScopeMissing() {
    TableSchema<SimpleClass> schemaOnEncrypt = TableSchema.fromBean(
      SimpleClass.class
    );

    // Do not specify Unauthenticated attributes when you should
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(schemaOnEncrypt)
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }

  @Test(
    expectedExceptions = DynamoDbItemEncryptorException.class,
    expectedExceptionsMessageRegExp = "Attribute partition_key is configured as SIGN_ONLY but it is also in unauthenticatedAttributes."
  )
  public void TestInconsistentSignatureScopeIncorrect() {
    TableSchema<SimpleClass> schemaOnEncrypt = TableSchema.fromBean(
      SimpleClass.class
    );

    // Specify Unauthenticated attributes when you should not
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .allowedUnsignedAttributes(Arrays.asList("doNothing", "partition_key"))
        .schemaOnEncrypt(schemaOnEncrypt)
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionException.class,
    expectedExceptionsMessageRegExp = "Attribute sortKey of table DynamoDbEncryptionInterceptorTestTable is used as both a primary key and @DynamoDbEncryptionDoNothing."
  )
  public void TestDoNothingOnSortAttribute() {
    TableSchema<InvalidAnnotatedSortClass> schemaOnEncrypt =
      TableSchema.fromBean(InvalidAnnotatedSortClass.class);
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(schemaOnEncrypt)
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionException.class,
    expectedExceptionsMessageRegExp = "Attribute invalid of table DynamoDbEncryptionInterceptorTestTable is used as both @DynamoDbEncryptionSignOnly and @DynamoDbEncryptionDoNothing."
  )
  public void TestDoubleAnnotationOnAttribute() {
    TableSchema<InvalidDoubleAnnotationClass> schemaOnEncrypt =
      TableSchema.fromBean(InvalidDoubleAnnotationClass.class);
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(schemaOnEncrypt)
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }

  @Test(
    expectedExceptions = DynamoDbItemEncryptorException.class,
    expectedExceptionsMessageRegExp = "Attribute lastName is configured as DO_NOTHING but it must also be in unauthenticatedAttributes or begin with the unauthenticatedPrefix."
  )
  public void TestFlattenedNestedBeanAnnotationMissingUnauthenticatedAttributes() {
    TableSchema<AnnotatedFlattenedBean> schemaOnEncrypt = TableSchema.fromBean(
      AnnotatedFlattenedBean.class
    );
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(schemaOnEncrypt)
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionException.class,
    expectedExceptionsMessageRegExp = "Attribute partition_key set to SIGN_ONLY in one table and SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT in another."
  )
  public void TestIncompatibleClasses() {
    TableSchema<?> schemaOnEncrypt1 = TableSchema.fromBean(SignOnlyClass.class);
    TableSchema<?> schemaOnEncrypt2 = TableSchema.fromBean(
      SignAndIncludeInEncryptionContextClass.class
    );
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(schemaOnEncrypt1)
        .schemaOnEncrypt(schemaOnEncrypt2)
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }

  @Test
  public void TestFlattenedNestedBeanAnnotation() {
    TableSchema<AnnotatedFlattenedBean> schemaOnEncrypt = TableSchema.fromBean(
      AnnotatedFlattenedBean.class
    );
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(schemaOnEncrypt)
        .allowedUnsignedAttributes(Collections.singletonList("lastName"))
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }

  @Test
  public void TestAnnotatedConvertedBy() {
    TableSchema<AnnotatedConvertedBy> schemaOnEncrypt = TableSchema.fromBean(
      AnnotatedConvertedBy.class
    );
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(schemaOnEncrypt)
        .allowedUnsignedAttributes(Collections.singletonList("nestedIgnored"))
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }

  @Test(expectedExceptions = DynamoDbEncryptionException.class)
  public void TestInvalidNestedBeanAnnotation() {
    TableSchema<InvalidAnnotatedNestedBean> schemaOnEncrypt =
      TableSchema.fromBean(InvalidAnnotatedNestedBean.class);
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(schemaOnEncrypt)
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }

  @Test(expectedExceptions = DynamoDbEncryptionException.class)
  public void TestConflictingAnnotatedNestedBean() {
    TableSchema<ConflictingAnnotatedNestedBean> schemaOnEncrypt =
      TableSchema.fromBean(ConflictingAnnotatedNestedBean.class);
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(schemaOnEncrypt)
        .allowedUnsignedAttributes(Collections.singletonList("nestedIgnored"))
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionException.class,
    expectedExceptionsMessageRegExp = "Detected DynamoDbEncryption Tag DynamoDbEncryption:SortOnly on a nested attribute with Path DynamoDbEncryptionInterceptorTestTable.nestedObject.secondNest.secondNestedId. This is NOT Supported at this time!"
  )
  public void TestInvalidDeepNested() {
    TableSchema<InvalidDeepNested> schemaOnEncrypt = TableSchema.fromBean(
      InvalidDeepNested.class
    );
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(schemaOnEncrypt)
        .allowedUnsignedAttributePrefix(":")
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }

  @Test(
    expectedExceptions = DynamoDbEncryptionException.class,
    expectedExceptionsMessageRegExp = "Detected DynamoDbEncryption Tag DynamoDbEncryption:SortOnly on a nested attribute with Path DynamoDbEncryptionInterceptorTestTable.nestedObject.secondNestedId. This is NOT Supported at this time!"
  )
  public void TestInvalidDeepFlatten() {
    TableSchema<InvalidDeepFlatten> schemaOnEncrypt = TableSchema.fromBean(
      InvalidDeepFlatten.class
    );
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(schemaOnEncrypt)
        .allowedUnsignedAttributePrefix(":")
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }

  @Test(
    // We skip this Test.
    enabled = false,
    // The DB-ESDK-DynamoDB for Java SHOULD detect ALL DynamoDBEncryption
    // Tags & Attributes that are IGNORED and throw an Exception.
    // However, detecting IGNORED DynamoDBEncryption Tags & Attributes
    // when a nested class is Flattened has NOT been implemented.
    // See GitHub Issue #259:
    // https://github.com/aws/aws-database-encryption-sdk-dynamodb-java/issues/259
    expectedExceptions = DynamoDbEncryptionException.class
  )
  public void TestConflictingFlattenedBean() {
    TableSchema<ConflictingFlattenedBean> schemaOnEncrypt =
      TableSchema.fromBean(ConflictingFlattenedBean.class);
    Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    List<String> allowedUnsignedAttributes = Arrays.asList(
      "lastName",
      "anotherLastName",
      "finalLastName"
    );
    tableConfigs.put(
      TEST_TABLE_NAME,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(TEST_TABLE_NAME)
        .keyring(createKmsKeyring())
        .schemaOnEncrypt(schemaOnEncrypt)
        .allowedUnsignedAttributes(allowedUnsignedAttributes)
        .build()
    );
    DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
      CreateDynamoDbEncryptionInterceptorInput
        .builder()
        .tableEncryptionConfigs(tableConfigs)
        .build()
    );
  }
}
