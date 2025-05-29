package software.amazon.cryptography.examples.keyring;

import java.util.HashMap;
import java.util.Map;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.keystore.KeyStore;
import software.amazon.cryptography.keystore.model.CreateKeyStoreInput;
import software.amazon.cryptography.keystore.model.KMSConfiguration;
import software.amazon.cryptography.keystore.model.KeyStoreConfig;
import software.amazon.cryptography.materialproviders.ICryptographicMaterialsCache;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CacheType;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateCryptographicMaterialsCacheInput;
import software.amazon.cryptography.materialproviders.model.DefaultCache;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/*
  This example demonstrates how to use a shared cache across multiple Hierarchical Keyrings.
  With this functionality, users only need to maintain one common shared cache across multiple
  Hierarchical Keyrings with different Key Stores instances/KMS Clients/KMS Keys.

  There are three important parameters that users need to carefully set while providing the shared cache:

  1. Partition ID - Partition ID is an optional parameter provided to the Hierarchical Keyring input,
  which distinguishes Cryptographic Material Providers (i.e: Keyrings) writing to a cache.
  - If the Partition ID is set and is the same for two Hierarchical Keyrings (or another Material Provider),
    they CAN share the same cache entries in the cache.
  - If the Partition ID is set and is different for two Hierarchical Keyrings (or another Material Provider),
    they CANNOT share the same cache entries in the cache.
  - If the Partition ID is not set by the user, it is initialized as a random 16-byte UUID which makes
    it unique for every Hierarchical Keyring, and two Hierarchical Keyrings (or another Material Provider)
    CANNOT share the same cache entries in the cache.

  2. Logical Key Store Name - This parameter is set by the user when configuring the Key Store for
  the Hierarchical Keyring. This is a logical name for the branch key store.
  Suppose you have a physical Key Store (K). You create two instances of K (K1 and K2). Now, you create
  two Hierarchical Keyrings (HK1 and HK2) with these Key Store instances (K1 and K2 respectively).
  - If you want to share cache entries across these two keyrings, you should set the Logical Key Store Names
    for both the Key Store instances (K1 and K2) to be the same.
  - If you set the Logical Key Store Names for K1 and K2 to be different, HK1 (which uses Key Store instance K1)
    and HK2 (which uses Key Store instance K2) will NOT be able to share cache entries.

  3. Branch Key ID - Choose an effective Branch Key ID Schema

  This is demonstrated in the example below.
  Notice that both K1 and K2 are instances of the same physical Key Store (K).
  You MUST NEVER have two different physical Key Stores with the same Logical Key Store Name.

  Important Note: If you have two or more Hierarchy Keyrings with:
  - Same Partition ID
  - Same Logical Key Store Name of the Key Store for the Hierarchical Keyring 
  - Same Branch Key ID
  then they WILL share the cache entries in the Shared Cache.
  Please make sure that you set all of Partition ID, Logical Key Store Name and Branch Key ID
  to be the same for two Hierarchical Keyrings if and only if you want them to share cache entries.

  This example sets up DynamoDb Encryption for the AWS SDK client using the Hierarchical
  Keyring, which establishes a key hierarchy where "branch" keys are persisted in DynamoDb.
  These branch keys are used to protect your data keys, and these branch keys are themselves
  protected by a root KMS Key.

  This example first creates a shared cache that you can use across multiple Hierarchical Keyrings.
  The example then configures a Hierarchical Keyring (HK1 and HK2) with the shared cache,
  a Branch Key ID and two instances (K1 and K2) of the same physical Key Store (K) respectively,
  i.e. HK1 with K1 and HK2 with K2. The example demonstrates that if you set the same Partition ID
  for HK1 and HK2, the two keyrings can share cache entries.
  If you set different Partition ID of the Hierarchical Keyrings, or different
  Logical Key Store Names of the Key Store instances, then the keyrings will NOT
  be able to share cache entries.

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
public class SharedCacheAcrossHierarchicalKeyringsExample {

  public static void SharedCacheAcrossHierarchicalKeyringsGetItemPutItem(
    String ddbTableName,
    String branchKeyId,
    String keyStoreTableName,
    String logicalKeyStoreName,
    String partitionId,
    String kmsKeyId
  ) {
    // 1. Create the CryptographicMaterialsCache (CMC) to share across multiple Hierarchical Keyrings
    //    using the Material Providers Library
    //      This CMC takes in:
    //      - CacheType
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();

    final CacheType cache = CacheType
      .builder()
      .Default(DefaultCache.builder().entryCapacity(100).build())
      .build();

    final CreateCryptographicMaterialsCacheInput cryptographicMaterialsCacheInput =
      CreateCryptographicMaterialsCacheInput.builder().cache(cache).build();

    final ICryptographicMaterialsCache sharedCryptographicMaterialsCache =
      matProv.CreateCryptographicMaterialsCache(
        cryptographicMaterialsCacheInput
      );

    // 2. Create a CacheType object for the sharedCryptographicMaterialsCache
    //    Note that the `cache` parameter in the Hierarchical Keyring Input takes a `CacheType` as input
    final CacheType sharedCache = CacheType
      .builder()
      // This is the `Shared` CacheType that passes an already initialized shared cache
      .Shared(sharedCryptographicMaterialsCache)
      .build();

    // Initial KeyStore Setup: This example requires that you have already
    // created your KeyStore, and have populated it with a new branch key.

    // 3. Configure your KeyStore resource keystore1.
    //    This SHOULD be the same configuration that you used
    //    to initially create and populate your KeyStore.
    // Note that keyStoreTableName is the physical Key Store,
    // and keystore1 is instances of this physical Key Store.
    final KeyStore keystore1 = KeyStore
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

    // 4. Create the Hierarchical Keyring HK1 with Key Store instance K1, partitionId,
    //    the shared Cache and the BranchKeyId.
    //    Note that we are now providing an already initialized shared cache instead of just mentioning
    //    the cache type and the Hierarchical Keyring initializing a cache at initialization.

    // This example creates a Hierarchical Keyring for a single BranchKeyId. You can, however, use a
    // BranchKeyIdSupplier as per your use-case. See the HierarchicalKeyringsExample.java for more
    // information.

    // Please make sure that you read the guidance on how to set Partition ID, Logical Key Store Name and
    // Branch Key ID at the top of this example before creating Hierarchical Keyrings with a Shared Cache.
    // partitionId for this example is a random UUID
    final CreateAwsKmsHierarchicalKeyringInput keyringInput1 =
      CreateAwsKmsHierarchicalKeyringInput
        .builder()
        .keyStore(keystore1)
        .branchKeyId(branchKeyId)
        .ttlSeconds(600) // This dictates how often we call back to KMS to authorize use of the branch keys
        .cache(sharedCache)
        .partitionId(partitionId)
        .build();
    final IKeyring hierarchicalKeyring1 =
      matProv.CreateAwsKmsHierarchicalKeyring(keyringInput1);

    // 5. Configure which attributes are encrypted and/or signed when writing new items.
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

    // 6. Get the DDB Client for Hierarchical Keyring 1.
    final DynamoDbClient ddbClient1 = GetDdbClient(
      ddbTableName,
      hierarchicalKeyring1,
      attributeActionsOnEncrypt
    );

    // 7. Encrypt Decrypt roundtrip with ddbClient1
    PutGetItems(ddbTableName, ddbClient1);

    // Through the above encrypt and decrypt roundtrip, the cache will be populated and
    // the cache entries can be used by another Hierarchical Keyring with the
    // - Same Partition ID
    // - Same Logical Key Store Name of the Key Store for the Hierarchical Keyring
    // - Same Branch Key ID

    // 8. Configure your KeyStore resource keystore2.
    //       This SHOULD be the same configuration that you used
    //       to initially create and populate your physical KeyStore.
    //    Note that keyStoreTableName is the physical Key Store,
    //    and keystore2 is instances of this physical Key Store.

    // Note that for this example, keystore2 is identical to keystore1.
    // You can optionally change configurations like KMS Client or KMS Key ID based
    // on your use-case.
    // Make sure you have the required permissions to use different configurations.

    // - If you want to share cache entries across two keyrings HK1 and HK2,
    //   you should set the Logical Key Store Names for both
    //   Key Store instances (K1 and K2) to be the same.
    // - If you set the Logical Key Store Names for K1 and K2 to be different,
    //   HK1 (which uses Key Store instance K1) and HK2 (which uses Key Store
    //   instance K2) will NOT be able to share cache entries.
    final KeyStore keystore2 = KeyStore
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

    // 9. Create the Hierarchical Keyring HK2 with Key Store instance K2, the shared Cache
    //    and the same partitionId and BranchKeyId used in HK1 because we want to share cache entries
    //    (and experience cache HITS).

    // Please make sure that you read the guidance on how to set Partition ID, Logical Key Store Name and
    // Branch Key ID at the top of this example before creating Hierarchical Keyrings with a Shared Cache.
    // partitionId for this example is a random UUID
    final CreateAwsKmsHierarchicalKeyringInput keyringInput2 =
      CreateAwsKmsHierarchicalKeyringInput
        .builder()
        .keyStore(keystore2)
        .branchKeyId(branchKeyId)
        .ttlSeconds(600) // This dictates how often we call back to KMS to authorize use of the branch keys
        .cache(sharedCache)
        .partitionId(partitionId)
        .build();
    final IKeyring hierarchicalKeyring2 =
      matProv.CreateAwsKmsHierarchicalKeyring(keyringInput2);

    // 10. Get the DDB Client for Hierarchical Keyring 2.
    final DynamoDbClient ddbClient2 = GetDdbClient(
      ddbTableName,
      hierarchicalKeyring2,
      attributeActionsOnEncrypt
    );

    // 11. Encrypt Decrypt roundtrip with ddbClient2
    PutGetItems(ddbTableName, ddbClient2);
  }

  public static DynamoDbClient GetDdbClient(
    String ddbTableName,
    IKeyring hierarchicalKeyring,
    Map<String, CryptoAction> attributeActionsOnEncrypt
  ) {
    // Configure which attributes we expect to be included in the signature
    // when reading items. There are two options for configuring this:
    //
    // - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
    //   When defining your DynamoDb schema and deciding on attribute names,
    //   choose a distinguishing prefix (such as ":") for all attributes that
    //   you do not want to include in the signature.
    //   This has two main benefits:
    //   - It is easier to reason about the security and authenticity of data within your item
    //     when all unauthenticated data is easily distinguishable by their attribute name.
    //   - If you need to add new unauthenticated attributes in the future,
    //     you can easily make the corresponding update to your `attributeActionsOnEncrypt`
    //     and immediately start writing to that new attribute, without
    //     any other configuration update needed.
    //   Once you configure this field, it is not safe to update it.
    //
    // - Configure `allowedUnsignedAttributes`: You may also explicitly list
    //   a set of attributes that should be considered unauthenticated when encountered
    //   on read. Be careful if you use this configuration. Do not remove an attribute
    //   name from this configuration, even if you are no longer writing with that attribute,
    //   as old items may still include this attribute, and our configuration needs to know
    //   to continue to exclude this attribute from the signature scope.
    //   If you add new attribute names to this field, you must first deploy the update to this
    //   field to all readers in your host fleet before deploying the update to start writing
    //   with that new attribute.
    //
    //   For this example, we currently authenticate all attributes. To make it easier to
    //   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
    final String unsignAttrPrefix = ":";

    // Create the DynamoDb Encryption configuration for the table we will be writing to.
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

    // Create the DynamoDb Encryption Interceptor
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

    // Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddbClient = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();

    return ddbClient;
  }

  public static void PutGetItems(
    String ddbTableName,
    DynamoDbClient ddbClient
  ) {
    // Put an item into our table using the given ddb client.
    // Before the item gets sent to DynamoDb, it will be encrypted
    // client-side, according to our configuration.
    // This example creates a Hierarchical Keyring for a single BranchKeyId. You can, however, use a
    // BranchKeyIdSupplier as per your use-case. See the HierarchicalKeyringsExample.java for more
    // information.
    final HashMap<String, AttributeValue> item = new HashMap<>();
    item.put("partition_key", AttributeValue.builder().s("id").build());
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

    // Get the item back from our table using the same client.
    // The client will decrypt the item client-side, and return
    // back the original item.
    // This example creates a Hierarchical Keyring for a single BranchKeyId. You can, however, use a
    // BranchKeyIdSupplier as per your use-case. See the HierarchicalKeyringsExample.java for more
    // information.
    final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put("partition_key", AttributeValue.builder().s("id").build());
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
  }

  public static void main(final String[] args) {
    if (args.length <= 0) {
      throw new IllegalArgumentException(
        "To run this example, include the ddbTable, branchKeyId, " +
        "keyStoreTableName, logicalKeyStoreName, partitionId, and kmsKeyId in args"
      );
    }
    final String ddbTableName = args[0];
    final String branchKeyId = args[1];
    final String keyStoreTableName = args[2];
    final String logicalKeyStoreName = args[3];
    final String partitionId = args[4];
    final String kmsKeyId = args[5];
    SharedCacheAcrossHierarchicalKeyringsGetItemPutItem(
      ddbTableName,
      branchKeyId,
      keyStoreTableName,
      logicalKeyStoreName,
      partitionId,
      kmsKeyId
    );
  }
}
