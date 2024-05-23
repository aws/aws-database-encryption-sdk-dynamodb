package software.amazon.cryptography.examples.keyring;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import software.amazon.awssdk.arns.Arn;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  using the MRK multi-keyring. This keyring takes in multiple AWS KMS
  MRKs (multi-region keys) or regular AWS KMS keys (single-region keys)
  and uses them to encrypt and decrypt data. Data encrypted using an MRK
  multi-keyring can be decrypted using any of its component keys. If a component
  key is an MRK with a replica in a second region, the replica key can also be
  used to decrypt data.

  For more information on MRKs, see
  https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-overview.html

  For more information on multi-keyrings, see
  https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-multi-keyring.html

  This example creates a new MRK multi-keyring consisting of one MRK
  (labeled as the "generator keyring") and one single-region key (labeled
   as the only "child keyring"). The MRK also has a replica in a second region.

  This example encrypts a test item using the MRK multi-keyring and puts the
  encrypted item to the provided DynamoDb table. Then, it gets the item
  from the table and decrypts it using three different configs:
    1. The MRK multi-keyring, where the MRK key is used to decrypt
    2. Another MRK multi-keyring, where the replica MRK key is used to decrypt
    3. Another MRK multi-keyring, where the single-region key that was present
       in the original MRK multi-keyring is used to decrypt

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)

  This example demonstrates multi-region use cases. As a result,
  it requires that you have a default region set in your AWS client.
  You can set a default region through the AWS CLI with
  `aws configure set region [region-name]`
  e.g.
  `aws configure set region us-west-2`
  For more information on using AWS CLI to set config, see
  https://awscli.amazonaws.com/v2/documentation/api/latest/reference/configure/set.html
 */
public class MultiMrkKeyringExample {

  public static void MultiMrkKeyringGetItemPutItem(
    String ddbTableName,
    String mrkKeyArn,
    String keyArn,
    String mrkReplicaKeyArn
  ) {
    // 1. Create a single MRK multi-keyring using the MRK arn and the single-region key arn.
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    // Create the multi-keyring, using the MRK as the generator key,
    //   and the single-region key as a child key.
    // Note that the generator key will generate and encrypt a plaintext data key
    //   and all child keys will only encrypt that same plaintext data key.
    // As such, you must have permission to call KMS:GenerateDataKey on your generator key
    //   and permission to call KMS:Encrypt on all child keys.
    // For more information, see the AWS docs on multi-keyrings above.
    final CreateAwsKmsMrkMultiKeyringInput createAwsKmsMrkMultiKeyringInput =
      CreateAwsKmsMrkMultiKeyringInput
        .builder()
        .generator(mrkKeyArn)
        .kmsKeyIds(Collections.singletonList(keyArn))
        .build();
    IKeyring awsKmsMrkMultiKeyring = matProv.CreateAwsKmsMrkMultiKeyring(
      createAwsKmsMrkMultiKeyringInput
    );

    // 2. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    attributeActionsOnEncrypt.put("partition_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("sort_key", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put(
      "sensitive_data",
      CryptoAction.ENCRYPT_AND_SIGN
    );

    // 3. Configure which attributes we expect to be included in the signature
    //    when reading items. There are two options for configuring this:
    //
    //    - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
    //      When defining your DynamoDb schema and deciding on attribute names,
    //      choose a distinguishing prefix (such as ":") for all attributes that
    //      you do not want to include in the signature.
    //      This has two main benefits:
    //      - It is easier to reason about the security and authenticity of data within your item
    //        when all unauthenticated data is easily distinguishable by their attribute name.
    //      - If you need to add new unauthenticated attributes in the future,
    //        you can easily make the corresponding update to your `attributeActionsOnEncrypt`
    //        and immediately start writing to that new attribute, without
    //        any other configuration update needed.
    //      Once you configure this field, it is not safe to update it.
    //
    //    - Configure `allowedUnsignedAttributes`: You may also explicitly list
    //      a set of attributes that should be considered unauthenticated when encountered
    //      on read. Be careful if you use this configuration. Do not remove an attribute
    //      name from this configuration, even if you are no longer writing with that attribute,
    //      as old items may still include this attribute, and our configuration needs to know
    //      to continue to exclude this attribute from the signature scope.
    //      If you add new attribute names to this field, you must first deploy the update to this
    //      field to all readers in your host fleet before deploying the update to start writing
    //      with that new attribute.
    //
    //   For this example, we currently authenticate all attributes. To make it easier to
    //   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
    final String unsignAttrPrefix = ":";

    // 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig
      .builder()
      .logicalTableName(ddbTableName)
      .partitionKeyName("partition_key")
      .sortKeyName("sort_key")
      .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
      .keyring(awsKmsMrkMultiKeyring)
      .allowedUnsignedAttributePrefix(unsignAttrPrefix)
      .build();
    tableConfigs.put(ddbTableName, config);

    // 5. Create the DynamoDb Encryption Interceptor
    DynamoDbEncryptionInterceptor encryptionInterceptor =
      DynamoDbEncryptionInterceptor
        .builder()
        .config(
          DynamoDbTablesEncryptionConfig
            .builder()
            .tableEncryptionConfigs(tableConfigs)
            .build()
        )
        .build();

    // 6. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddbClient = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();

    // 7. Put an item into our table using the above client.
    //    Before the item gets sent to DynamoDb, it will be encrypted
    //    client-side using the MRK multi-keyring.
    //    The data key protecting this item will be encrypted
    //    with all the KMS Keys in this keyring, so that it can be
    //    decrypted with any one of those KMS Keys.
    final HashMap<String, AttributeValue> item = new HashMap<>();
    item.put(
      "partition_key",
      AttributeValue.builder().s("awsKmsMrkMultiKeyringItem").build()
    );
    item.put("sort_key", AttributeValue.builder().n("0").build());
    item.put(
      "sensitive_data",
      AttributeValue.builder().s("encrypt and sign me!").build()
    );

    final PutItemRequest putRequest = PutItemRequest
      .builder()
      .tableName(ddbTableName)
      .item(item)
      .build();

    final PutItemResponse putResponse = ddbClient.putItem(putRequest);

    // Demonstrate that PutItem succeeded
    assert 200 == putResponse.sdkHttpResponse().statusCode();

    // 8. Get the item back from our table using the client.
    //    The client will decrypt the item client-side using the MRK
    //    and return back the original item.
    //    Since the generator key is the first available key in the keyring,
    //    that is the KMS Key that will be used to decrypt this item.
    final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(
      "partition_key",
      AttributeValue.builder().s("awsKmsMrkMultiKeyringItem").build()
    );
    keyToGet.put("sort_key", AttributeValue.builder().n("0").build());

    final GetItemRequest getRequest = GetItemRequest
      .builder()
      .key(keyToGet)
      .tableName(ddbTableName)
      .build();

    final GetItemResponse getResponse = ddbClient.getItem(getRequest);

    // Demonstrate that GetItem succeeded and returned the decrypted item
    assert 200 == getResponse.sdkHttpResponse().statusCode();
    final Map<String, AttributeValue> returnedItem = getResponse.item();
    assert returnedItem
      .get("sensitive_data")
      .s()
      .equals("encrypt and sign me!");

    // 9. Create a MRK keyring using the replica MRK arn.
    //    We will use this to demonstrate that the replica MRK
    //    can decrypt data created with the original MRK,
    //    even when the replica MRK was not present in the
    //    encrypting multi-keyring.
    final CreateAwsKmsMrkMultiKeyringInput onlyReplicaKeyCreateAwsKmsMrkMultiKeyringInput =
      CreateAwsKmsMrkMultiKeyringInput
        .builder()
        .kmsKeyIds(Collections.singletonList(mrkReplicaKeyArn))
        .build();
    IKeyring onlyReplicaKeyMrkMultiKeyring =
      matProv.CreateAwsKmsMrkMultiKeyring(
        onlyReplicaKeyCreateAwsKmsMrkMultiKeyringInput
      );

    // 10. Create a new config and client using the MRK keyring.
    //     This is the same setup as above, except we provide the MRK keyring to the config.
    final Map<
      String,
      DynamoDbTableEncryptionConfig
    > onlyReplicaKeyTableConfigs = new HashMap<>();
    final DynamoDbTableEncryptionConfig onlyReplicaKeyConfig =
      DynamoDbTableEncryptionConfig
        .builder()
        .logicalTableName(ddbTableName)
        .partitionKeyName("partition_key")
        .sortKeyName("sort_key")
        .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
        // Only replica keyring added here
        .keyring(onlyReplicaKeyMrkMultiKeyring)
        .allowedUnsignedAttributePrefix(unsignAttrPrefix)
        .build();
    onlyReplicaKeyTableConfigs.put(ddbTableName, onlyReplicaKeyConfig);

    DynamoDbEncryptionInterceptor onlyReplicaKeyEncryptionInterceptor =
      DynamoDbEncryptionInterceptor
        .builder()
        .config(
          DynamoDbTablesEncryptionConfig
            .builder()
            .tableEncryptionConfigs(onlyReplicaKeyTableConfigs)
            .build()
        )
        .build();

    final DynamoDbClient onlyReplicaKeyDdbClient = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(onlyReplicaKeyEncryptionInterceptor)
          .build()
      )
      .build();

    // 11. Get the item back from our table using the client configured with the replica.
    //    The client will decrypt the item client-side using the replica MRK
    //    and return back the original item.
    final HashMap<String, AttributeValue> onlyReplicaKeyKeyToGet =
      new HashMap<>();
    onlyReplicaKeyKeyToGet.put(
      "partition_key",
      AttributeValue.builder().s("awsKmsMrkMultiKeyringItem").build()
    );
    onlyReplicaKeyKeyToGet.put(
      "sort_key",
      AttributeValue.builder().n("0").build()
    );

    final GetItemRequest onlyReplicaKeyGetRequest = GetItemRequest
      .builder()
      .key(onlyReplicaKeyKeyToGet)
      .tableName(ddbTableName)
      .build();

    final GetItemResponse onlyReplicaKeyGetResponse =
      onlyReplicaKeyDdbClient.getItem(onlyReplicaKeyGetRequest);

    // Demonstrate that GetItem succeeded and returned the decrypted item
    assert 200 == onlyReplicaKeyGetResponse.sdkHttpResponse().statusCode();
    final Map<String, AttributeValue> onlyReplicaKeyReturnedItem =
      onlyReplicaKeyGetResponse.item();
    assert onlyReplicaKeyReturnedItem
      .get("sensitive_data")
      .s()
      .equals("encrypt and sign me!");

    // 12. Create an AWS KMS keyring using the single-region key ARN.
    //     We will use this to demonstrate that the single-region key
    //     can decrypt data created with the MRK multi-keyring,
    //     since it is present in the keyring used to encrypt.
    final CreateAwsKmsMrkMultiKeyringInput onlySrkCreateAwsKmsMrkMultiKeyringInput =
      CreateAwsKmsMrkMultiKeyringInput
        .builder()
        .kmsKeyIds(Collections.singletonList(keyArn))
        .build();
    IKeyring onlySrkKeyring = matProv.CreateAwsKmsMrkMultiKeyring(
      onlySrkCreateAwsKmsMrkMultiKeyringInput
    );

    // 13. Create a new config and client using the AWS KMS keyring.
    //     This is the same setup as above, except we provide the AWS KMS keyring to the config.
    final Map<String, DynamoDbTableEncryptionConfig> onlySrkTableConfigs =
      new HashMap<>();
    final DynamoDbTableEncryptionConfig onlySrkConfig =
      DynamoDbTableEncryptionConfig
        .builder()
        .logicalTableName(ddbTableName)
        .partitionKeyName("partition_key")
        .sortKeyName("sort_key")
        .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
        // Only single-region key keyring added here
        .keyring(onlySrkKeyring)
        .allowedUnsignedAttributePrefix(unsignAttrPrefix)
        .build();
    onlySrkTableConfigs.put(ddbTableName, onlySrkConfig);

    DynamoDbEncryptionInterceptor onlySrkEncryptionInterceptor =
      DynamoDbEncryptionInterceptor
        .builder()
        .config(
          DynamoDbTablesEncryptionConfig
            .builder()
            .tableEncryptionConfigs(onlySrkTableConfigs)
            .build()
        )
        .build();

    final DynamoDbClient onlySrkDdbClient = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(onlySrkEncryptionInterceptor)
          .build()
      )
      .build();

    // 14. Get the item back from our table using the client configured with the AWS KMS keyring.
    //     The client will decrypt the item client-side using the single-region key
    //     and return back the original item.
    final HashMap<String, AttributeValue> onlySrkKeyToGet = new HashMap<>();
    onlySrkKeyToGet.put(
      "partition_key",
      AttributeValue.builder().s("awsKmsMrkMultiKeyringItem").build()
    );
    onlySrkKeyToGet.put("sort_key", AttributeValue.builder().n("0").build());

    final GetItemRequest onlySrkGetRequest = GetItemRequest
      .builder()
      .key(onlySrkKeyToGet)
      .tableName(ddbTableName)
      .build();

    final GetItemResponse onlySrkGetResponse = onlySrkDdbClient.getItem(
      onlySrkGetRequest
    );

    // Demonstrate that GetItem succeeded and returned the decrypted item
    assert 200 == onlySrkGetResponse.sdkHttpResponse().statusCode();
    final Map<String, AttributeValue> onlySrkReturnedItem =
      onlySrkGetResponse.item();
    assert onlySrkReturnedItem
      .get("sensitive_data")
      .s()
      .equals("encrypt and sign me!");
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException(
        "To run this example, include the ddbTable, mrkKeyArn, keyArn, and mrkReplicaKeyArn in args"
      );
    }
    final String ddbTableName = args[0];
    final String mrkKeyArn = args[1];
    final String srkArn = args[2];
    final String mrkReplicaKeyArn = args[3];
    MultiMrkKeyringGetItemPutItem(
      ddbTableName,
      mrkKeyArn,
      srkArn,
      mrkReplicaKeyArn
    );
  }
}
