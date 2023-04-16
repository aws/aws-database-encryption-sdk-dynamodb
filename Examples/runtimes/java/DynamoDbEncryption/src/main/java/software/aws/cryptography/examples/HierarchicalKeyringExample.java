package software.aws.cryptography.examples;

import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dynamoDbEncryption.DynamoDbEncryption;
import software.amazon.cryptography.dynamoDbEncryption.model.CreateDynamoDbEncryptionBranchKeyIdSupplierInput;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.keyStore.KeyStore;
import software.amazon.cryptography.keyStore.model.CreateKeyInput;
import software.amazon.cryptography.keyStore.model.CreateKeyStoreInput;
import software.amazon.cryptography.keyStore.model.KeyStoreConfig;
import software.amazon.cryptography.materialProviders.IBranchKeyIdSupplier;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsHierarchicalKeyringInput;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

import java.util.HashMap;
import java.util.Map;

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

  This example first creates the DynamoDb-backed KeyStore,
  and creates two branch keys. These are control plane operations that
  only need to occur once. While not demonstrated in this example,
  you should additionally use the `VersionKey` API on the KeyStore
  to periodically rotate your branch key material.

  This example then demonstrates configuring a Hierarchical Keyring
  with a Branch Key ID Supplier to encrypt and decrypt data for
  two separate tenants.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class HierarchicalKeyringExample {

    public static void HierarchicalKeyringGetItemPutItem(String ddbTableName, String keyStoreTableName, String kmsKeyId) {
        // Initial KeyStore Setup: Configure a keystore resource to create the table
        // that will persist your branch keys, then create two new branch keys.
        // This process should occur in your control plane, and returns
        // Branch Key IDs that you will need to configure for use in your data plane.

        // 1. Configure your KeyStore resource
        final KeyStore keystore = KeyStore.builder().KeyStoreConfig(
                KeyStoreConfig.builder()
                        .ddbClient(DynamoDbClient.create())
                        .ddbTableName(keyStoreTableName)
                        .kmsClient(KmsClient.create())
                        .build()).build();

        // 2. Create the DynamoDb table to store the branch keys
        keystore.CreateKeyStore(CreateKeyStoreInput.builder().build());

        // 3. Create two branch keys for our two tenants.
        //    Use the same KMS Key to protect both keys.
        final String tenant1BranchKey = keystore.CreateKey(
                CreateKeyInput.builder().awsKmsKeyArn(kmsKeyId).build()).branchKeyIdentifier();
        final String tenant2BranchKey = keystore.CreateKey(
                CreateKeyInput.builder().awsKmsKeyArn(kmsKeyId).build()).branchKeyIdentifier();

        // Data Plane: Given the above setup done in our control plane, we have created
        // the resources required to encrypt and decrypt items for our two tenants by
        // configuring our AWS SDK Client to use a Hierarchical Keyring.

        // 4. Create a Branch Key ID Supplier. See ExampleBranchKeyIdSupplier in this directory.
        final DynamoDbEncryption ddbEnc = DynamoDbEncryption.builder()
                .DynamoDbEncryptionConfig(DynamoDbEncryptionConfig.builder().build())
                .build();
        final IBranchKeyIdSupplier branchKeyIdSupplier = ddbEnc.CreateDynamoDbEncryptionBranchKeyIdSupplier(
                CreateDynamoDbEncryptionBranchKeyIdSupplierInput.builder()
                        .ddbKeyBranchKeyIdSupplier(new ExampleBranchKeyIdSupplier(tenant1BranchKey, tenant2BranchKey))
                        .build()).branchKeyIdSupplier();

        // 5. Create the Hierarchical Keyring, using the Branch Key ID Supplier above.
        //    With this configuration, the AWS SDK Client ultimately configured will be capable
        //    of encrypting or decrypting items for either tenant (assuming correct KMS access).
        //    If you want to restrict the client to only encrypt or decrypt for a single tenant,
        //    configure this Hierarchical Keyring using `.branchKeyId(tenant1BranchKey)` instead
        //    of `.branchKeyIdSupplier(branchKeyIdSupplier)`.
        final MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();
        final CreateAwsKmsHierarchicalKeyringInput keyringInput = CreateAwsKmsHierarchicalKeyringInput.builder()
                .kmsKeyId(kmsKeyId) // Use the same KMS Key ID that you used to create the branch keys
                .keyStore(keystore)
                .branchKeyIdSupplier(branchKeyIdSupplier)
                .ttlSeconds(600) // This dictates how often we call back to KMS to authorize use of the branch keys
                .maxCacheSize(100) // This dictates how many branch keys will be held stored on the host 
                .build();
        final IKeyring hierarchicalKeyring = matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);

        // 6. Configure which attributes are encrypted and/or signed when writing new items.
        //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //    we must explicitly configure how they should be treated during item encryption:
        //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
        final Map<String, CryptoAction> attributeActions = new HashMap<>();
        attributeActions.put("partition_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
        attributeActions.put("sort_key", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
        attributeActions.put("tenant_sensitive_data", CryptoAction.ENCRYPT_AND_SIGN);

        // 3. Configure which attributes we expect to be included in the signature
        //    when reading items. There are two options for configuring this:
        //
        //    - (Recommended) Configure `allowedUnauthenticatedAttributesPrefix`:
        //      When defining your DynamoDb schema and deciding on attribute names,
        //      choose a distinguishing prefix (such as ":") for all attributes that
        //      you do not want to include in the signature.
        //      This has two main benefits:
        //      - It is easier to reason about the security and authenticity of data within your item
        //        when all unauthenticated data is easily distinguishable by their attribute name.
        //      - If you need to add new unauthenticated attributes in the future,
        //        you can easily make the corresponding update to your `attributeActions`
        //        and immediately start writing to that new attribute, without
        //        any other configuration update needed.
        //      Once you configure this field, it is not safe to update it.
        //
        //    - Configure `allowedUnauthenticatedAttributes`: You may also explicitly list
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
        final String unauthAttrPrefix = ":";

        // 7. Create the DynamoDb Encryption configuration for the table we will be writing to.
        final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
                .partitionKeyName("partition_key")
                .sortKeyName("sort_key")
                .attributeActions(attributeActions)
                .keyring(hierarchicalKeyring)
                .allowedUnauthenticatedAttributePrefix(unauthAttrPrefix)
                .build();
        tableConfigs.put(ddbTableName, config);

        // 8. Create the DynamoDb Encryption Interceptor
        DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
                .config(DynamoDbTablesEncryptionConfig.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build())
                .build();

        // 9. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
        final DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(encryptionInterceptor)
                                .build())
                .build();

        // 10. Put an item into our table using the above client.
        //     Before the item gets sent to DynamoDb, it will be encrypted
        //     client-side, according to our configuration.
        //     Because the item we are writing uses "tenantId1" as our partition value,
        //     based on the code we wrote in the ExampleBranchKeySupplier,
        //     `tenant1BranchKey` will be used to encrypt this item.
        final HashMap<String, AttributeValue> item = new HashMap<>();
        item.put("partition_key", AttributeValue.builder().s("tenant1Id").build());
        item.put("sort_key", AttributeValue.builder().n("0").build());
        item.put("tenant_sensitive_data", AttributeValue.builder().s("encrypt and sign me!").build());

        final PutItemRequest putRequest = PutItemRequest.builder()
                .tableName(ddbTableName)
                .item(item)
                .build();

        final PutItemResponse putResponse = ddb.putItem(putRequest);

        // Demonstrate that PutItem succeeded
        assert 200 == putResponse.sdkHttpResponse().statusCode();

        // 11. Get the item back from our table using the same client.
        //     The client will decrypt the item client-side, and return
        //     back the original item.
        //     Because the returned item's partition value is "tenantId1",
        //     based on the code we wrote in the ExampleBranchKeySupplier,
        //     `tenant1BranchKey` will be used to decrypt this item.
        final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put("partition_key", AttributeValue.builder().s("tenant1Id").build());
        keyToGet.put("sort_key", AttributeValue.builder().n("0").build());

        final GetItemRequest getRequest = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(ddbTableName)
                .build();

        final GetItemResponse getResponse = ddb.getItem(getRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        assert 200 == getResponse.sdkHttpResponse().statusCode();
        final Map<String, AttributeValue> returnedItem = getResponse.item();
        assert returnedItem.get("tenant_sensitive_data").s().equals("encrypt and sign me!");
    }

    public static void main(final String[] args) {
        if (args.length <= 0) {
            throw new IllegalArgumentException("To run this example, include the ddbTable, keyStoreTableName, and kmsKeyId in args");
        }
        final String ddbTableName = args[0];
        final String keyStoreTableName = args[1];
        final String kmsKeyId = args[2];
        HierarchicalKeyringGetItemPutItem(ddbTableName, keyStoreTableName, kmsKeyId);
    }
}
