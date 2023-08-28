package software.amazon.cryptography.examples.motica1;

import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.kms.model.DataKeySpec;
import software.amazon.awssdk.services.kms.model.DecryptRequest;
import software.amazon.awssdk.services.kms.model.DecryptResponse;
import software.amazon.awssdk.services.kms.model.GenerateDataKeyRequest;
import software.amazon.awssdk.services.kms.model.GenerateDataKeyResponse;
import software.amazon.awssdk.utils.StringUtils;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.CreateDynamoDbEncryptionInterceptorInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedClientEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedTableEncryptionConfig;
import software.amazon.cryptography.examples.enhanced.SimpleClass;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

import java.util.*;

public class PocDemoAppUtils {
  static final TableSchema<SimpleClass> tableSchema =
          TableSchema.fromBean(SimpleClass .class);
  static final String unsignAttrPrefix = ":";

  // @motica1 An Alias cannot be used for Decryption
//  private static String cmkAlias = "arn:aws:kms:us-east-1:<>:alias/pii-service-sse-key";
//  private static String cmkArn = "arn:aws:kms:us-east-1:<>:alias/pii-service-sse-key";


  /**
   * @param kmsId The arn of a KMS Symmetric Key or (encrypt only) an alias to a KMS Symmetric Key
   */
  private static IKeyring getKeyring(final String kmsId) {
    // 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that
    // protect your data.
    //    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
    //    We will use the `CreateMrkMultiKeyring` method to create this keyring,
    //    as it will correctly handle both single region and Multi-Region KMS Keys.
    final MaterialProviders matProv =
            MaterialProviders.builder()
                    .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                    .build();
    final CreateAwsKmsMrkMultiKeyringInput keyringInput =
            CreateAwsKmsMrkMultiKeyringInput.builder().generator(kmsId).build();
    return matProv.CreateAwsKmsMrkMultiKeyring(keyringInput);
  }

  /**
   * @param kmsIds The arns of KMS Symmetric Keys or (encrypt only) aliases to KMS Symmetric Keys.
   *               The first entry will be used as the generator.
   */
  private static IKeyring getMultiKeyring(final String ... kmsIds) {
    // 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that
    // protect your data.
    //    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
    //    We will use the `CreateMrkMultiKeyring` method to create this keyring,
    //    as it will correctly handle both single region and Multi-Region KMS Keys.
    final MaterialProviders matProv =
            MaterialProviders.builder()
                    .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                    .build();
    final String generatorArn = kmsIds[0];
    final List<String> nonGeneratorArns = Arrays.asList(Arrays.copyOfRange(kmsIds, 1, kmsIds.length));
    final CreateAwsKmsMrkMultiKeyringInput.Builder keyringInput = CreateAwsKmsMrkMultiKeyringInput.builder().generator(generatorArn);
    if (nonGeneratorArns.size() > 0) {
      keyringInput.kmsKeyIds(nonGeneratorArns);
    }
    return matProv.CreateAwsKmsMrkMultiKeyring(keyringInput.build());
  }

  public static void encryptNew(
          final String kmsId,
          final String kmsAlias,
          final String tableName) {

    IKeyring keyring = getKeyring(kmsAlias);
    final DynamoDbEnhancedClient encryptEnhancedClient = getDynamoDbEnhancedClient(keyring, tableName);
    DynamoDbTable<SimpleClass> table =
            encryptEnhancedClient.table(tableName, tableSchema);

    final SimpleClass bean = new SimpleClass();
    bean.setPartitionKey("motica1");
    bean.setSortKey(0);

    System.out.println("------");
    System.out.println(bean);
    System.out.println("------");

    table.putItem(bean);
    experiment(kmsId, kmsAlias);

    IKeyring decryptKeyring = StringUtils.equals(kmsAlias, kmsId) ? keyring : getMultiKeyring(kmsAlias, kmsId);
    final DynamoDbEnhancedClient enhancedClient = getDynamoDbEnhancedClient(decryptKeyring, tableName);
    table = enhancedClient.table(tableName, tableSchema);
    final Key key = Key.builder().partitionValue("motica1").sortValue(0).build();
    final SimpleClass  result =
            table.getItem((GetItemEnhancedRequest.Builder requestBuilder) -> requestBuilder.key(key));
    System.out.println(result);
  }

  private static DynamoDbEnhancedClient getDynamoDbEnhancedClient(IKeyring keyring, String tableName) {
    Map<String, DynamoDbEnhancedTableEncryptionConfig> encryptTableConfigs = new HashMap<>();
    encryptTableConfigs.put(
            tableName,
            DynamoDbEnhancedTableEncryptionConfig.builder()
                    .logicalTableName(tableName)
                    .keyring(keyring)
                    .allowedUnsignedAttributePrefix(unsignAttrPrefix)
                    .schemaOnEncrypt(tableSchema)
                    .algorithmSuiteId(
                            DBEAlgorithmSuiteId
                                    .ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384)
                    .build());
    final DynamoDbEncryptionInterceptor encryptionInterceptor =
            DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                    CreateDynamoDbEncryptionInterceptorInput.builder()
                            .tableEncryptionConfigs(encryptTableConfigs)
                            .build());

    final DynamoDbClient ddb =
            DynamoDbClient.builder()
                    .region(Region.US_WEST_2)
                    .overrideConfiguration(
                            ClientOverrideConfiguration.builder()
                                    .addExecutionInterceptor(encryptionInterceptor)
                                    .build())
                    .build();

    return DynamoDbEnhancedClient.builder().dynamoDbClient(ddb).build();
  }

  private static void experiment(
          final String kmsId,
          final String kmsAlias
  ) {
    System.out.println("Running Experiment");
    System.out.println("------");

    KmsClient kms = KmsClient.builder().region(Region.US_WEST_2).build();
    GenerateDataKeyResponse response =
            kms.generateDataKey(
                    GenerateDataKeyRequest.builder().keyId(kmsAlias).keySpec(DataKeySpec.AES_256).build());
    System.out.println("response.keyId = " + response.keyId());
    System.out.println("------");
    System.out.printf(
            "Is Response KeyId the same as Request?  %s%n",
            StringUtils.equals(kmsAlias, response.keyId())
    );

    DecryptResponse decryptResponse =
            kms.decrypt(DecryptRequest.builder().ciphertextBlob(response.ciphertextBlob()).keyId(kmsId).build());
    System.out.println("decryptResponse.keyId = " + decryptResponse.keyId());
    System.out.printf(
            "Is Response KeyId the same as Request?  %s%n",
            StringUtils.equals(kmsId, response.keyId())
    );
    System.out.println("------");
  }
}
