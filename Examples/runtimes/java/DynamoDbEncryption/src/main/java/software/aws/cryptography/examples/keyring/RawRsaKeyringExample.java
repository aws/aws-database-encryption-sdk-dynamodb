package software.aws.cryptography.examples.keyring;

import com.amazonaws.services.dynamodbv2.datamodeling.internal.Utils;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dynamoDbEncryption.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.materialProviders.IKeyring;
import software.amazon.cryptography.materialProviders.MaterialProviders;
import software.amazon.cryptography.materialProviders.model.CreateRawRsaKeyringInput;
import software.amazon.cryptography.materialProviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.materialProviders.model.PaddingScheme;
import software.amazon.cryptography.structuredEncryption.model.CryptoAction;
import software.aws.cryptography.dynamoDbEncryption.DynamoDbEncryptionInterceptor;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  using the raw RSA Keyring. This keyring takes in an RSA key pair.
  The client uses the private key to encrypt items it adds to the table
  and uses the public key to decrypt existing table items it retrieves.

  This example creates a new key pair, encrypts a test item, and puts the
  encrypted item to the provided DynamoDb table. Then, it gets the
  item from the table and decrypts it.

  This example creates a new key pair on each execution. In practice,
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
public class RawRsaKeyringExample {

    public static void RawRsaKeyringGetItemPutItem(String ddbTableName) {
        // 1. Generate a 2048-bit RSA key to use with your keyring.
        //    This example uses some custom dependencies to generate the key:
        //     - AWS DynamoDbEncryption client-provided RNG instance (lightweight wrapper for
        //         java.security.SecureRandom)
        //     - BouncyCastle KeyPairGenerator
        //    You do not need to use these in your own code.
        //    In practice, you should not generate this key in your code, and should instead
        //        retrieve this key from a secure key management system (e.g. HSM).
        //    This key is created here for example purposes only.
        KeyPairGenerator rsaGen;
        try {
            rsaGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("No such algorithm", e);
        }
        rsaGen.initialize(2048, Utils.getRng());
        KeyPair keyPair = rsaGen.generateKeyPair();

        StringWriter privateKeyStringWriter = new StringWriter();
        PemWriter privateKeyPemWriter = new PemWriter(privateKeyStringWriter);
        try {
            privateKeyPemWriter.writeObject(new PemObject("PRIVATE KEY", keyPair.getPrivate().getEncoded()));
            privateKeyPemWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("IOException while writing private key PEM", e);
        }

        ByteBuffer privateKeyUtf8EncodedByteBuffer = StandardCharsets.UTF_8.encode(privateKeyStringWriter.toString());

        StringWriter publicKeyStringWriter = new StringWriter();
        PemWriter publicKeyPemWriter = new PemWriter(publicKeyStringWriter);
        try {
            publicKeyPemWriter.writeObject(
                new PemObject("PUBLIC KEY", keyPair.getPublic().getEncoded()));
            publicKeyPemWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("IOException while writing public key PEM", e);
        }
        ByteBuffer publicKeyUtf8EncodedByteBuffer = StandardCharsets.UTF_8.encode(publicKeyStringWriter.toString());

        // 2. Create the keyring.
        //    The DynamoDb encryption client uses this to encrypt and decrypt items.
        final CreateRawRsaKeyringInput keyringInput = CreateRawRsaKeyringInput.builder()
            .keyName("My example RSA key")
            .keyNamespace("My example key namespace")
            .paddingScheme(PaddingScheme.OAEP_SHA256_MGF1)
            .publicKey(publicKeyUtf8EncodedByteBuffer)
            .privateKey(privateKeyUtf8EncodedByteBuffer)
            .build();
        final MaterialProviders matProv = MaterialProviders.builder()
            .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
            .build();
        IKeyring rawRsaKeyring = matProv.CreateRawRsaKeyring(keyringInput);

        // 3. Configure which attributes are encrypted and/or signed when writing new items.
        //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //    we must explicitly configure how they should be treated during item encryption:
        //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
        final Map<String, CryptoAction> attributeActions = new HashMap<>();
        attributeActions.put("partition_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
        attributeActions.put("sort_key", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
        attributeActions.put("sensitive_data", CryptoAction.ENCRYPT_AND_SIGN);

        // 4. Configure which attributes we expect to be included in the signature
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

        // 5. Create the DynamoDb Encryption configuration for the table we will be writing to.
        final Map<String, DynamoDbTableEncryptionConfig> tableConfigs = new HashMap<>();
        final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig.builder()
                .logicalTableName(ddbTableName)
                .partitionKeyName("partition_key")
                .sortKeyName("sort_key")
                .attributeActions(attributeActions)
                .keyring(rawRsaKeyring)
                .allowedUnauthenticatedAttributePrefix(unauthAttrPrefix)
                .build();
        tableConfigs.put(ddbTableName, config);

        // 6. Create the DynamoDb Encryption Interceptor
        DynamoDbEncryptionInterceptor encryptionInterceptor = DynamoDbEncryptionInterceptor.builder()
                .config(DynamoDbTablesEncryptionConfig.builder()
                        .tableEncryptionConfigs(tableConfigs)
                        .build())
                .build();

        // 7. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
        final DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(encryptionInterceptor)
                                .build())
                .build();

        // 8. Put an item into our table using the above client.
        //    Before the item gets sent to DynamoDb, it will be encrypted
        //    client-side, according to our configuration.
        final HashMap<String, AttributeValue> item = new HashMap<>();
        item.put("partition_key", AttributeValue.builder().s("rawRsaKeyringItem").build());
        item.put("sort_key", AttributeValue.builder().n("0").build());
        item.put("sensitive_data", AttributeValue.builder().s("encrypt and sign me!").build());

        final PutItemRequest putRequest = PutItemRequest.builder()
                .tableName(ddbTableName)
                .item(item)
                .build();

        final PutItemResponse putResponse = ddb.putItem(putRequest);

        // Demonstrate that PutItem succeeded
        assert 200 == putResponse.sdkHttpResponse().statusCode();

        // 9. Get the item back from our table using the same client.
        //    The client will decrypt the item client-side, and return
        //    back the original item.
        final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
        keyToGet.put("partition_key", AttributeValue.builder().s("rawRsaKeyringItem").build());
        keyToGet.put("sort_key", AttributeValue.builder().n("0").build());

        final GetItemRequest getRequest = GetItemRequest.builder()
                .key(keyToGet)
                .tableName(ddbTableName)
                .build();

        final GetItemResponse getResponse = ddb.getItem(getRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        assert 200 == getResponse.sdkHttpResponse().statusCode();
        final Map<String, AttributeValue> returnedItem = getResponse.item();
        assert returnedItem.get("sensitive_data").s().equals("encrypt and sign me!");
    }

    public static void main(final String[] args) {
        if (args.length <= 0) {
            throw new IllegalArgumentException("To run this example, include the ddbTable in args");
        }
        final String ddbTableName = args[0];
        RawRsaKeyringGetItemPutItem(ddbTableName);
    }
}
