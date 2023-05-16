package software.aws.cryptography.examples.enhanced;

import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;
import software.aws.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.aws.cryptography.dbencryptionsdk.dynamodb.enhancedclient.CreateDynamoDbEncryptionInterceptorInput;
import software.aws.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedClientEncryption;
import software.aws.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedTableEncryptionConfig;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.HashMap;
import java.util.Map;

/*
  This example sets up DynamoDb Encryption for the DynamoDb Enhanced Client
  and uses the high level putItem() and getItem() APIs to demonstrate
  putting a client-side encrypted item into DynamoDb
  and then retrieving and decrypting that item from DynamoDb. 

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class EnhancedPutGetExample {

    public static void PutItemGetItem(String kmsKeyId, String ddbTableName) {
        // 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
        //    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
        //    We will use the `CreateMrkMultiKeyring` method to create this keyring,
        //    as it will correctly handle both single region and Multi-Region KMS Keys.
        final MaterialProviders matProv = MaterialProviders.builder()
                .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
                .build();
        final CreateAwsKmsMrkMultiKeyringInput keyringInput = CreateAwsKmsMrkMultiKeyringInput.builder()
                .generator(kmsKeyId)
                .build();
        final IKeyring kmsKeyring = matProv.CreateAwsKmsMrkMultiKeyring(keyringInput);

        // 2. Create a Table Schema over your annotated class (See SimpleClass.java in this directory).
        //    By default, all primary key attributes will be signed but not encrypted (SIGN_ONLY)
        //    and all non-primary key attributes will be encrypted and signed (ENCRYPT_AND_SIGN).
        //    If you want a particular non-primary key attribute to be signed but not encrypted,
        //    use the `DynamoDbEncryptionSignOnly` annotation.
        //    If you want a particular attribute to be neither signed nor encrypted (DO_NOTHING),
        //    use the `DynamoDbEncryptionDoNothing` annotation.
        final TableSchema<SimpleClass> tableSchema = TableSchema.fromBean(SimpleClass.class);

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
        //        you can immediately start writing to a new `DynamoDbEncryptionDoNothing` attribute
        //        as long as it's name uses this prefix, without any other configuration update needed.
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
        //   For this example, we have designed our DynamoDb table such that any attribute name with
        //   the ":" prefix should be considered unauthenticated.
        final String unauthAttrPrefix = ":";

        // 3. Create the DynamoDb Encryption configuration for the table we will be writing to,
        final Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs = new HashMap<>();
        tableConfigs.put(ddbTableName,
                DynamoDbEnhancedTableEncryptionConfig.builder()
                        .logicalTableName(ddbTableName)
                        .keyring(kmsKeyring)
                        .allowedUnauthenticatedAttributePrefix(unauthAttrPrefix)
                        .tableSchema(tableSchema)
                        // Specifying an algorithm suite is not required,
                        // but is done here to demonstrate how to do so.
                        // We suggest using the
                        // `ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384` suite,
                        // which includes AES-GCM with key derivation, signing, and key commitment.
                        // This is also the default algorithm suite if one is not specified in this config.
                        // For more information on supported algorithm suites, see
                        //   TODO: Add DB ESDK-specific link, similar to
                        //   https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/supported-algorithms.html,
                        //   but with accurate information for DB ESDK
                        .algorithmSuiteId(
                            DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384)
                        .build());

        // 4. Create the DynamoDb Encryption Interceptor, using the DynamoDbEnhancedClientEncryption helper
        final DynamoDbEncryptionInterceptor interceptor =
                DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
                        CreateDynamoDbEncryptionInterceptorInput.builder()
                                .tableEncryptionConfigs(tableConfigs)
                                .build()
                );

        // 5. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
        final DynamoDbClient ddb = DynamoDbClient.builder()
                .overrideConfiguration(
                        ClientOverrideConfiguration.builder()
                                .addExecutionInterceptor(interceptor)
                                .build())
                .build();

        // 6. Create the DynamoDbEnhancedClient using the AWS SDK Client created above,
        //    and create a Table with your modelled class
        final DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                .dynamoDbClient(ddb)
                .build();
        final DynamoDbTable<SimpleClass> table = enhancedClient.table(ddbTableName, tableSchema);

        // 7. Put an item into your table using the DynamoDb Enhanced Client.
        //    The item will be encrypted client-side according to your
        //    configuration above before it is sent to DynamoDb.
        final SimpleClass item = new SimpleClass();
        item.setPartitionKey("EnhancedPutGetExample");
        item.setSortKey(0);
        item.setEncryptAndSign("encrypt and sign me!");
        item.setSignOnly("sign me!");
        item.setDoNothing("ignore me!");

        table.putItem(item);

        // 8. Get the item back from the table using the DynamoDb Enhanced Client.
        //    The item will be decrypted client-side, and you will get back the
        //    original item.
        final Key key = Key.builder()
                .partitionValue("EnhancedPutGetExample").sortValue(0)
                .build();

        final SimpleClass result = table.getItem(
                (GetItemEnhancedRequest.Builder requestBuilder) -> requestBuilder.key(key));

        // Demonstrate we get the original item back
        assert result.getEncryptAndSign().equals("encrypt and sign me!");
    }

    public static void main(final String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("To run this example, include the kmsKeyId as args[0] and ddbTableName as args[1]");
        }
        final String kmsKeyId = args[0];
        final String ddbTableName = args[1];
        PutItemGetItem(kmsKeyId, ddbTableName);
    }
}
