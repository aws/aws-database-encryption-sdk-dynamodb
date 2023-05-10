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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.AesWrappingAlg;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateRawAesKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.aws.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  using the multi-keyring. This keyring takes in multiple keyrings
  and uses them to encrypt and decrypt data. Data encrypted with
  a multi-keyring can be decrypted with any of its component keyrings.

  For more information on multi-keyrings, see
  https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-multi-keyring.html

  This example creates a new multi-keyring consisting of an AWS KMS
  keyring (labeled the "generator keyring") and a raw AES keyring
  (labeled as the only "child keyring"). It encrypts a test item
  using the multi-keyring and puts the encrypted item to the provided
  DynamoDb table. Then, it gets the item from the table and decrypts it
  using only the raw AES keyring.

  This example creates a new raw AES key on each execution. In practice,
  users of this library should not do this, and should instead
  retrieve an existing key from a secure key management system
  (e.g. an HSM).

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class MultiKeyringExample {

    public static void MultiKeyringGetItemPutItem(String ddbTableName, String keyArn) {
        // 1. Generate a 256-bit AES key to use with your keyring.
        //    This example uses some custom dependencies to generate the key:
        //     - AWS DynamoDbEncryption client-provided RNG instance (lightweight wrapper for Java's SecureRandom)
        //     - BouncyCastle KeyGenerator
        //    You do not need to use these in your own code.
        //    In practice, you should not generate this key in your code, and should instead
        //        retrieve this key from a secure key management system (e.g. HSM).
        //    This key is created here for example purposes only.
        KeyGenerator aesGen;
        try {
            aesGen = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("No such algorithm", e);
        }
        aesGen.init(256, Utils.getRng());
        SecretKey encryptionKey = aesGen.generateKey();
        ByteBuffer encryptionKeyByteBuffer = ByteBuffer.wrap(encryptionKey.getEncoded());

        // 2. Create the raw AES keyring.
        final MaterialProviders matProv = MaterialProviders.builder()
            .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
            .build();
        final CreateRawAesKeyringInput createRawAesKeyringInput = CreateRawAesKeyringInput.builder()
            .keyName("My example key")
            .keyNamespace("My example key namespace")
            .wrappingKey(encryptionKeyByteBuffer)
            .wrappingAlg(AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16)
            .build();
        IKeyring rawAesKeyring = matProv.CreateRawAesKeyring(createRawAesKeyringInput);

        // 3. Create the AWS KMS keyring.
        final CreateAwsKmsKeyringInput createAwsKmsKeyringInput = CreateAwsKmsKeyringInput.builder()
            .kmsClient(KmsClient.create())
            .kmsKeyId(keyArn)
            .build();
        IKeyring awsKmsKeyring = matProv.CreateAwsKmsKeyring(createAwsKmsKeyringInput);

        // 4. Create the multi-keyring.
        //    We will label the AWS KMS keyring as the generator and the raw AES keyring as the
        //        only child keyring.
        //    You must provide a generator keyring to encrypt data.
        //    You must provide at least one child keyring. Each child keyring will be able to
        //        decrypt data encrypted with the multi-keyring on its own. It does not need
        //        knowledge of any other child keyrings or the generator keyring to decrypt.
        final CreateMultiKeyringInput createMultiKeyringInput = CreateMultiKeyringInput.builder()
            .generator(awsKmsKeyring)
            .childKeyrings(Collections.singletonList(rawAesKeyring))
            .build();
        IKeyring multiKeyring = matProv.CreateMultiKeyring(createMultiKeyringInput);

        // 5. Configure which attributes are encrypted and/or signed when writing new items.
        //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //    we must explicitly configure how they should be treated during item encryption:
        //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
        final Map<String, CryptoAction> attributeActions = new HashMap<>();
        attributeActions.put("partition_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
        attributeActions.put("sort_key", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
        attributeActions.put("sensitive_data", CryptoAction.ENCRYPT_AND_SIGN);

        // 6. Configure which attributes we expect to be included in the signature
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
        //    Note that this example creates one config/client combination for PUT, and another
        //        for GET. The PUT config uses the multi-keyring, while the GET config uses the
        //        raw AES keyring. This is solely done to demonstrate that a keyring included as
        //        a child of a multi-keyring can be used to decrypt data on its own.
        final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
                .logicalTableName(ddbTableName)
                .partitionKeyName("partition_key")
                .sortKeyName("sort_key")
                .attributeActions(attributeActions)
                // Multi-keyring is added here
                .keyring(multiKeyring)
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
        final DynamoDbClient ddbClient = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(encryptionInterceptor)
                                .build())
                .build();

        // 10. Put an item into our table using the above client.
        //     Before the item gets sent to DynamoDb, it will be encrypted
        //     client-side using the multi-keyring.
        //     The item will be encrypted with all wrapping keys in the keyring,
        //     so that it can be decrypted with any one of the keys.
        final HashMap<String, AttributeValue> item = new HashMap<>();
        item.put("partition_key", AttributeValue.builder().s("multiKeyringItem").build());
        item.put("sort_key", AttributeValue.builder().n("0").build());
        item.put("sensitive_data", AttributeValue.builder().s("encrypt and sign me!").build());

        final PutItemRequest putRequest = PutItemRequest.builder()
                .tableName(ddbTableName)
                .item(item)
                .build();

        final PutItemResponse putResponse = ddbClient.putItem(putRequest);

        // Demonstrate that PutItem succeeded
        assert 200 == putResponse.sdkHttpResponse().statusCode();

        // 11. Get the item back from our table using the above client.
        //     The client will decrypt the item client-side using the AWS KMS
        //     keyring, and return back the original item.
        //     Since the generator key is the first available key in the keyring,
        //     that is the key that will be used to decrypt this item.
        final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put("partition_key", AttributeValue.builder().s("multiKeyringItem").build());
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

        // 12. Create a new config and client with only the raw AES keyring to GET the item
        //     This is the same setup as above, except the config uses the `rawAesKeyring`.
        final Map<String, DynamoDbTableEncryptionConfig> tableConfigsForRawAes = new HashMap<>();
        final DynamoDbTableEncryptionConfig configForRawAes = DynamoDbTableEncryptionConfig.builder()
            .logicalTableName(ddbTableName)
            .partitionKeyName("partition_key")
            .sortKeyName("sort_key")
            .attributeActions(attributeActions)
            // Raw AES keyring is added here
            .keyring(rawAesKeyring)
            .allowedUnauthenticatedAttributePrefix(unauthAttrPrefix)
            .build();
        tableConfigsForRawAes.put(ddbTableName, configForRawAes);

        DynamoDbEncryptionInterceptor encryptionInterceptorForRawAes = DynamoDbEncryptionInterceptor.builder()
            .config(DynamoDbTablesEncryptionConfig.builder()
                .tableEncryptionConfigs(tableConfigsForRawAes)
                .build())
            .build();

        final DynamoDbClient ddbClientForRawAes = DynamoDbClient.builder()
            .overrideConfiguration(
                ClientOverrideConfiguration.builder()
                    .addExecutionInterceptor(encryptionInterceptorForRawAes)
                    .build())
            .build();

        // 13. Get the item back from our table using the raw AES-configured client.
        //     The client will decrypt the item client-side using the raw
        //     AES keyring, and return back the original item.
        final HashMap<String, AttributeValue> keyToGetForRawAes = new HashMap<>();
        keyToGetForRawAes.put("partition_key", AttributeValue.builder().s("multiKeyringItem").build());
        keyToGetForRawAes.put("sort_key", AttributeValue.builder().n("0").build());

        final GetItemRequest getRequestForRawAes = GetItemRequest.builder()
                .key(keyToGetForRawAes)
                .tableName(ddbTableName)
                .build();

        final GetItemResponse getResponseForRawAes = ddbClientForRawAes.getItem(getRequestForRawAes);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        assert 200 == getResponse.sdkHttpResponse().statusCode();
        final Map<String, AttributeValue> returnedItemForRawAes = getResponseForRawAes.item();
        assert returnedItemForRawAes.get("sensitive_data").s().equals("encrypt and sign me!");
    }

    public static void main(final String[] args) {
        if (args.length <= 1) {
            throw new IllegalArgumentException("To run this example, include the ddbTable and keyArn in args");
        }
        final String ddbTableName = args[0];
        final String keyArn = args[1];
        MultiKeyringGetItemPutItem(ddbTableName, keyArn);
    }
}
