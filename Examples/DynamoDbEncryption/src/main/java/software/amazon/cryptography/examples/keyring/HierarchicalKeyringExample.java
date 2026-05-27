package software.amazon.cryptography.examples.keyring;

import java.util.HashMap;
import java.util.Map;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.CreateKeyStoreInput;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.materialproviders.IBranchKeyIdSupplier;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CacheType;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialproviders.model.DefaultCache;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  using the Hierarchical Keyring, which establishes a key hierarchy
  where "branch" keys are persisted in DynamoDb.
  These branch keys are used to protect your data keys,
  and these branch keys are themselves protected by a root KMS Key.

  Establishing a key hierarchy like this has two benefits:

  First, by caching the branch key material, and only calling back
  to KMS to re-establish authentication regularly according to your configured TTL,
  you limit how often you need to call back to KMS to protect your data.
  This is a performance/security tradeoff, where your authentication, audit, and
  logging from KMS is no longer one-to-one with every encrypt or decrypt call.
  However, the benefit is that you no longer have to make a
  network call to KMS for every encrypt or decrypt.

  Second, this key hierarchy makes it easy to hold multi-tenant data
  that is isolated per branch key in a single DynamoDb table.
  You can create a branch key for each tenant in your table,
  and encrypt all that tenant's data under that distinct branch key.
  On decrypt, you can either statically configure a single branch key
  to ensure you are restricting decryption to a single tenant,
  or you can implement an interface that lets you map the primary key on your items
  to the branch key that should be responsible for decrypting that data.

  This example then demonstrates configuring a Hierarchical Keyring
  with a Branch Key ID Supplier to encrypt and decrypt data for
  two separate tenants.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)

  This example also requires using a KMS Key whose ARN
  is provided in CLI arguments. You need the following access
  on this key:
    - GenerateDataKeyWithoutPlaintext
    - Decrypt
 */
public class HierarchicalKeyringExample {

  public static void HierarchicalKeyringGetItemPutItem(
    String ddbTableName,
    String tenant1BranchKeyId,
    String tenant2BranchKeyId,
    String keyStoreTableName,
    String logicalKeyStoreName,
    String kmsKeyId
  ) {
    // Initial KeyStore Setup: This example requires that you have already
    // created your KeyStore, and have populated it with two new branch keys.
    // See the "Create KeyStore Table Example" and "Create KeyStore Key Example"
    // for an example of how to do this.

    // 1. Configure your KeyStore resource.
    //    This SHOULD be the same configuration that you used
    //    to initially create and populate your KeyStore.
    final KeyStore keystore = KeyStore
      .builder()
      .KeyStoreConfig(
        KeyStoreConfig
          .builder()
          .ddbClient(DynamoDbClient.create())
          .ddbTableName(keyStoreTableName)
          .logicalKeyStoreName(logicalKeyStoreName)
          .kmsClient(KmsClient.create())
          .kmsConfiguration(
            KMSConfiguration.builder().kmsKeyArn(kmsKeyId).build()
          )
          .build()
      )
      .build();

    // 2. Create a Branch Key ID Supplier. See ExampleBranchKeyIdSupplier in this directory.
    final DynamoDbEncryption ddbEnc = DynamoDbEncryption
      .builder()
      .DynamoDbEncryptionConfig(DynamoDbEncryptionConfig.builder().build())
      .build();
    final IBranchKeyIdSupplier branchKeyIdSupplier = ddbEnc
      .CreateDynamoDbEncryptionBranchKeyIdSupplier(
        CreateDynamoDbEncryptionBranchKeyIdSupplierInput
          .builder()
          .ddbKeyBranchKeyIdSupplier(
            new ExampleBranchKeyIdSupplier(
              tenant1BranchKeyId,
              tenant2BranchKeyId
            )
          )
          .build()
      )
      .branchKeyIdSupplier();

    // 3. Create the Hierarchical Keyring, using the Branch Key ID Supplier above.
    //    With this configuration, the AWS SDK Client ultimately configured will be capable
    //    of encrypting or decrypting items for either tenant (assuming correct KMS access).
    //    If you want to restrict the client to only encrypt or decrypt for a single tenant,
    //    configure this Hierarchical Keyring using `.branchKeyId(tenant1BranchKeyId)` instead
    //    of `.branchKeyIdSupplier(branchKeyIdSupplier)`.
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    final CreateAwsKmsHierarchicalKeyringInput keyringInput =
      CreateAwsKmsHierarchicalKeyringInput
        .builder()
        .keyStore(keystore)
        .branchKeyIdSupplier(branchKeyIdSupplier)
        .ttlSeconds(600) // This dictates how often we call back to KMS to authorize use of the branch keys
        .cache(
          CacheType
            .builder()
            .Default(DefaultCache.builder().entryCapacity(100).build())
            .build()
        ) // This dictates how many branch keys will be held locally
        .build();
    final IKeyring hierarchicalKeyring =
      matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);

    // 4. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    attributeActionsOnEncrypt.put("partition_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("sort_key", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put(
      "tenant_sensitive_data",
      CryptoAction.ENCRYPT_AND_SIGN
    );

    // 5. Configure which attributes we expect to be included in the signature
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

    // 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig
      .builder()
      .logicalTableName(ddbTableName)
      .partitionKeyName("partition_key")
      .sortKeyName("sort_key")
      .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
      .keyring(hierarchicalKeyring)
      .allowedUnsignedAttributePrefix(unsignAttrPrefix)
      .build();
    tableConfigs.put(ddbTableName, config);

    // 7. Create the DynamoDb Encryption Interceptor
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

    // 8. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();

    // 9. Put an item into our table using the above client.
    //    Before the item gets sent to DynamoDb, it will be encrypted
    //    client-side, according to our configuration.
    //    Because the item we are writing uses "tenantId1" as our partition value,
    //    based on the code we wrote in the ExampleBranchKeySupplier,
    //    `tenant1BranchKeyId` will be used to encrypt this item.
    final HashMap<String, AttributeValue> item = new HashMap<>();
    item.put("partition_key", AttributeValue.builder().s("tenant1Id").build());
    item.put("sort_key", AttributeValue.builder().n("0").build());
    item.put(
      "tenant_sensitive_data",
      AttributeValue.builder().s("encrypt and sign me!").build()
    );

    final PutItemRequest putRequest = PutItemRequest
      .builder()
      .tableName(ddbTableName)
      .item(item)
      .build();

    final PutItemResponse putResponse = ddb.putItem(putRequest);

    // Demonstrate that PutItem succeeded
    assert 200 == putResponse.sdkHttpResponse().statusCode();

    // 10. Get the item back from our table using the same client.
    //     The client will decrypt the item client-side, and return
    //     back the original item.
    //     Because the returned item's partition value is "tenantId1",
    //     based on the code we wrote in the ExampleBranchKeySupplier,
    //     `tenant1BranchKeyId` will be used to decrypt this item.
    final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(
      "partition_key",
      AttributeValue.builder().s("tenant1Id").build()
    );
    keyToGet.put("sort_key", AttributeValue.builder().n("0").build());

    final GetItemRequest getRequest = GetItemRequest
      .builder()
      .key(keyToGet)
      .tableName(ddbTableName)
      .build();

    final GetItemResponse getResponse = ddb.getItem(getRequest);

    // Demonstrate that GetItem succeeded and returned the decrypted item
    assert 200 == getResponse.sdkHttpResponse().statusCode();
    final Map<String, AttributeValue> returnedItem = getResponse.item();
    assert returnedItem
      .get("tenant_sensitive_data")
      .s()
      .equals("encrypt and sign me!");
  }

  public static void main(final String[] args) {
    if (args.length <= 0) {
      throw new IllegalArgumentException(
        "To run this example, include the ddbTable, tenant1BranchKeyId, " +
        "tenant2BranchKeyId, keyStoreTableName, logicalKeyStoreName, and kmsKeyId in args"
      );
    }
    final String ddbTableName = args[0];
    final String tenant1BranchKeyId = args[1];
    final String tenant2BranchKeyId = args[2];
    final String keyStoreTableName = args[3];
    final String logicalKeyStoreName = args[4];
    final String kmsKeyId = args[5];
    HierarchicalKeyringGetItemPutItem(
      ddbTableName,
      tenant1BranchKeyId,
      tenant2BranchKeyId,
      keyStoreTableName,
      logicalKeyStoreName,
      kmsKeyId
    );
  }
}
