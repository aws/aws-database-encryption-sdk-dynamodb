package software.aws.cryptography.examples.keyring;

import com.amazonaws.services.dynamodbv2.datamodeling.internal.Utils;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.AesWrappingAlg;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsKeyringInput;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsMrkKeyringInput;
import software.amazon.cryptography.materialProviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialProviders.model.CreateMultiKeyringInput;
import software.amazon.cryptography.materialProviders.model.CreateRawAesKeyringInput;
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  using the MRK multi-keyring. This keyring takes in multiple AWS KMS
  MRKs (multi-region keys) or regular AWS KMS keys and uses them to encrypt
  and decrypt data. Data encrypted using an MRK multi-keyring can be decrypted
  using any of its component keys. If a component key is an MRK with a
  replica in a second region, the replica key can also be used to decrypt data.

  For more information on MRKs, see
  https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-overview.html

  This example creates a new MRK multi-keyring consisting of one MRK
  (labeled as the "generator keyring") and one AWS KMS key
  (labeled as the only "child keyring"). The MRK has a replica in a
  second region.

  This example encrypts a test item using the MRK multi-keyring and puts the
  encrypted item to the provided DynamoDb table. Then, it gets the item
  from the table and decrypts it using only the replica MRK.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class MultiMrkKeyringExample {

    public static void MultiMrkKeyringGetItemPutItem(String ddbTableName, String mrkKeyArn, String keyArn,
            String mrkReplicaKeyArn) {
        // 1. Create a single MRK multi-keyring using the MRK arn and the KMS key arn.
        final MaterialProviders matProv = MaterialProviders.builder()
            .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
            .build();
        final CreateAwsKmsMrkMultiKeyringInput createAwsKmsMrkMultiKeyringInput =
            CreateAwsKmsMrkMultiKeyringInput.builder()
                .generator(mrkKeyArn)
                .kmsKeyIds(Collections.singletonList(keyArn))
                .build();
        IKeyring awsKmsMrkMultiKeyring = matProv.CreateAwsKmsMrkMultiKeyring(createAwsKmsMrkMultiKeyringInput);

        // 2. Configure which attributes are encrypted and/or signed when writing new items.
        //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //    we must explicitly configure how they should be treated during item encryption:
        //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
        final Map<String, CryptoAction> attributeActions = new HashMap<>();
        attributeActions.put("partition_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
        attributeActions.put("sort_key", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
        attributeActions.put("sensitive_data", CryptoAction.ENCRYPT_AND_SIGN);

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

        // 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
        final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
                .logicalTableName(ddbTableName)
                .partitionKeyName("partition_key")
                .sortKeyName("sort_key")
                .attributeActions(attributeActions)
                .keyring(awsKmsMrkMultiKeyring)
                .allowedUnauthenticatedAttributePrefix(unauthAttrPrefix)
                .build();
        tableConfigs.put(ddbTableName, config);

        // 5. Create the DynamoDb Encryption Interceptor
        DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
                .config(DynamoDbTablesEncryptionConfig.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build())
                .build();

        // 6. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
        final DynamoDbClient ddbClient = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(encryptionInterceptor)
                                .build())
                .build();

        // 7. Put an item into our table using the above client.
        //    Before the item gets sent to DynamoDb, it will be encrypted
        //    client-side using the MRK multi-keyring.
        //    The item will be encrypted with all keys in the keyring,
        //    so that it can be decrypted with any one of the keys.
        final HashMap<String, AttributeValue> item = new HashMap<>();
        item.put("partition_key", AttributeValue.builder().s("awsKmsMrkMultiKeyringItem").build());
        item.put("sort_key", AttributeValue.builder().n("0").build());
        item.put("sensitive_data", AttributeValue.builder().s("encrypt and sign me!").build());

        final PutItemRequest putRequest = PutItemRequest.builder()
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
        //    that is the key that will be used to decrypt this item.
        final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put("partition_key", AttributeValue.builder().s("awsKmsMrkMultiKeyringItem").build());
        keyToGet.put("sort_key", AttributeValue.builder().n("0").build());

        final GetItemRequest getRequest = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(ddbTableName)
                .build();

        final GetItemResponse getResponse = ddbClient.getItem(getRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        assert 200 == getResponse.sdkHttpResponse().statusCode();
        final Map<String, AttributeValue> returnedItem = getResponse.item();
        assert returnedItem.get("sensitive_data").s().equals("encrypt and sign me!");

        // 9. Create a MRK keyring using the replica MRK arn.
        //    We will use this to demonstrate that the replica MRK
        //    can decrypt data created with the original MRK.
        //    Note that this example created a MRK multi-keyring above,
        //    but is creating a standard MRK keyring here.
        final CreateAwsKmsMrkKeyringInput createAwsKmsMrkKeyringInput =
            CreateAwsKmsMrkKeyringInput.builder()
                .kmsClient(KmsClient.create())
                .kmsKeyId(mrkReplicaKeyArn)
                .build();
        IKeyring awsKmsMrkKeyring = matProv.CreateAwsKmsMrkKeyring(createAwsKmsMrkKeyringInput);

        // 10. Create a new config and client using the MRK keyring.
        //     This is the same setup as above, except we provide the MRK keyring to the config.
        final Map<String, DynamoDbTableEncryptionConfig> tableConfigsForReplica = new HashMap<>();
        final DynamoDbTableEncryptionConfig configForReplica = DynamoDbTableEncryptionConfig.builder()
            .logicalTableName(ddbTableName)
            .partitionKeyName("partition_key")
            .sortKeyName("sort_key")
            .attributeActions(attributeActions)
            // MRK keyring added here
            .keyring(awsKmsMrkKeyring)
            .allowedUnauthenticatedAttributePrefix(unauthAttrPrefix)
            .build();
        tableConfigsForReplica.put(ddbTableName, configForReplica);

        DynamoDbEncryptionInterceptor encryptionInterceptorForReplica = DynamoDbEncryptionInterceptor.builder()
            .config(DynamoDbTablesEncryptionConfig.builder()
                .tableEncryptionConfigs(tableConfigsForReplica)
                .build())
            .build();

        final DynamoDbClient ddbClientForReplica = DynamoDbClient.builder()
            .overrideConfiguration(
                ClientOverrideConfiguration.builder()
                    .addExecutionInterceptor(encryptionInterceptorForReplica)
                    .build())
            .build();

        // 11. Get the item back from our table using the client configured with the replica.
        //    The client will decrypt the item client-side using the replica MRK
        //    and return back the original item.
        final HashMap<String, AttributeValue> keyToGetForReplica = new HashMap<>();
        keyToGetForReplica.put("partition_key", AttributeValue.builder().s("awsKmsMrkMultiKeyringItem").build());
        keyToGetForReplica.put("sort_key", AttributeValue.builder().n("0").build());

        final GetItemRequest getRequestForReplica = GetItemRequest.builder()
            .key(keyToGetForReplica)
            .tableName(ddbTableName)
            .build();

        final GetItemResponse getResponseForReplica = ddbClient.getItem(getRequestForReplica);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        assert 200 == getResponseForReplica.sdkHttpResponse().statusCode();
        final Map<String, AttributeValue> returnedItemForReplica = getResponseForReplica.item();
        assert returnedItemForReplica.get("sensitive_data").s().equals("encrypt and sign me!");

    }

    public static void main(final String[] args) {
        if (args.length <= 1) {
            throw new IllegalArgumentException("To run this example, include the ddbTable, mrkKeyArn, keyArn, and mrkReplicaKeyArn in args");
        }
        final String ddbTableName = args[0];
        final String mrkKeyArn = args[1];
        final String keyArn = args[2];
        final String mrkReplicaKeyArn = args[3];
        MultiMrkKeyringGetItemPutItem(ddbTableName, mrkKeyArn, keyArn, mrkReplicaKeyArn);
    }
}
