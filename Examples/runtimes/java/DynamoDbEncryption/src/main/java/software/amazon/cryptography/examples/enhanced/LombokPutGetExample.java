package software.amazon.cryptography.examples.enhanced;

import static software.amazon.cryptography.examples.ConfigUtils.fromEncryptionInterceptor;
import static software.amazon.cryptography.examples.ManipulationUtils.assertManipulationProof;
import static software.amazon.cryptography.examples.ManipulationUtils.assertNotManipulationProof;
import static software.amazon.cryptography.examples.ManipulationUtils.assertProtectedByEncryptionContext;
import static software.amazon.cryptography.examples.ManipulationUtils.manipulateByteAttribute;
import static software.amazon.cryptography.examples.ManipulationUtils.manipulateNumberAttribute;
import static software.amazon.cryptography.examples.ManipulationUtils.manipulateStringAttribute;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.GetItemEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.CreateDynamoDbEncryptionInterceptorInput;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedClientEncryption;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.enhancedclient.DynamoDbEnhancedTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.itemencryptor.DynamoDbItemEncryptor;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

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
public class LombokPutGetExample {

  public static void PutItemGetItem(String kmsKeyId, String ddbTableName) {
    // 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
    //    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
    //    We will use the `CreateMrkMultiKeyring` method to create this keyring,
    //    as it will correctly handle both single region and Multi-Region KMS Keys.
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    final CreateAwsKmsMrkMultiKeyringInput keyringInput =
      CreateAwsKmsMrkMultiKeyringInput.builder().generator(kmsKeyId).build();
    final IKeyring kmsKeyring = matProv.CreateAwsKmsMrkMultiKeyring(
      keyringInput
    );

    // 2. Create a Table Schema over your annotated class (See SimpleViaLombok.java in this directory).
    //    By default, all primary key attributes will be signed but not encrypted (SIGN_ONLY)
    //    and all non-primary key attributes will be encrypted and signed (ENCRYPT_AND_SIGN).
    //    If you want a particular non-primary key attribute to be signed but not encrypted,
    //    use the `DynamoDbEncryptionSignOnly` annotation.
    //    If you want a particular attribute to be neither signed nor encrypted (DO_NOTHING),
    //    use the `DynamoDbEncryptionDoNothing` annotation.
    final TableSchema<SimpleViaLombok> tableSchema =
      TableSchema.fromImmutableClass(SimpleViaLombok.class);

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
    //        you can immediately start writing to a new `DynamoDbEncryptionDoNothing` attribute
    //        as long as it's name uses this prefix, without any other configuration update needed.
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
    //   For this example, we have designed our DynamoDb table such that any attribute name with
    //   the ":" prefix should be considered unauthenticated.
    final String unsignAttrPrefix = ":";

    // 4. Create the DynamoDb Encryption configuration for the table we will be writing to,
    final Map<String, DynamoDbEnhancedTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    tableConfigs.put(
      ddbTableName,
      DynamoDbEnhancedTableEncryptionConfig
        .builder()
        .logicalTableName(ddbTableName)
        .keyring(kmsKeyring)
        .allowedUnsignedAttributePrefix(unsignAttrPrefix)
        .schemaOnEncrypt(tableSchema)
        // Specifying an algorithm suite is not required,
        // but is done here to demonstrate how to do so.
        // We suggest using the
        // `ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384` suite,
        // which includes AES-GCM with key derivation, signing, and key commitment.
        // This is also the default algorithm suite if one is not specified in this config.
        // For more information on supported algorithm suites, see:
        //   https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/supported-algorithms.html
        .algorithmSuiteId(
          DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384
        )
        .build()
    );

    // 5. Create the DynamoDb Encryption Interceptor, using the DynamoDbEnhancedClientEncryption helper
    final DynamoDbEncryptionInterceptor encryptionInterceptor =
      DynamoDbEnhancedClientEncryption.CreateDynamoDbEncryptionInterceptor(
        CreateDynamoDbEncryptionInterceptorInput
          .builder()
          .tableEncryptionConfigs(tableConfigs)
          .build()
      );

    // 6. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddb = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();

    // 7. Create the DynamoDbEnhancedClient using the AWS SDK Client created above,
    //    and create a Table with your modelled class
    final DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient
      .builder()
      .dynamoDbClient(ddb)
      .build();
    final DynamoDbTable<SimpleViaLombok> table = enhancedClient.table(
      ddbTableName,
      tableSchema
    );

    // 8. Put an item into your table using the DynamoDb Enhanced Client.
    //    The item will be encrypted client-side according to your
    //    configuration above before it is sent to DynamoDb.
    final SimpleViaLombok.SimpleViaLombokBuilder itemBuilder =
      SimpleViaLombok.builder();
    itemBuilder.partitionKey("LombokPutGetExample");
    itemBuilder.sortKey(0);
    itemBuilder.attribute1("encrypt and sign me!");
    itemBuilder.attribute2("sign me!");
    itemBuilder.attribute3("ignore me!");
    SimpleViaLombok item = itemBuilder.build();
    table.putItem(item);

    // 9. Get the item back from the table using the DynamoDb Enhanced Client.
    //    The item will be decrypted client-side, and you will get back the
    //    original item.
    final Key key = Key
      .builder()
      .partitionValue("LombokPutGetExample")
      .sortValue(0)
      .build();

    final SimpleViaLombok decrypted =
      table.getItem((GetItemEnhancedRequest.Builder requestBuilder) ->
        requestBuilder.key(key)
      );

    // Demonstrate we get the original item back
    assert decrypted.getAttribute1().equals("encrypt and sign me!");

    // Demonstrate without the Enhanced Client, the record is encrypted
    try (DynamoDbClient noEncryptionDdb = DynamoDbClient.builder().build()) {
      GetItemResponse response =
        noEncryptionDdb.getItem((GetItemRequest.Builder requestBuilder) -> {
          requestBuilder.key(key.primaryKeyMap(tableSchema));
          requestBuilder.tableName(ddbTableName);
        });
      final Map<String, AttributeValue> itemDecrypted = response.item();
      // Assert the Encrypted Field is in Bytes
      assert Objects.nonNull(itemDecrypted.get("attribute1").b());
      // Assert the Encrypted Field is not a String
      assert Objects.isNull(itemDecrypted.get("attribute1").s());
      // Assert the Signed Only Field is a String and is Equal to the input
      assert Objects.nonNull(itemDecrypted.get("attribute2").s());
      assert itemDecrypted.get("attribute2").s().equals(item.getAttribute2());
      // Assert the Not Signed, Not Encrypted Field is a String and is Equal to the input
      assert Objects.nonNull(response.item().get(":attribute3").s());
      assert itemDecrypted.get(":attribute3").s().equals(item.getAttribute3());

      // Verify the Signed Items are protected
      final DynamoDbItemEncryptor itemEncryptor = DynamoDbItemEncryptor
        .builder()
        .DynamoDbItemEncryptorConfig(
          fromEncryptionInterceptor(encryptionInterceptor, ddbTableName)
        )
        .build();
      assertProtectedByEncryptionContext(
        itemEncryptor,
        manipulateStringAttribute(itemDecrypted, "partition_key"),
        "partition_key"
      );
      assertProtectedByEncryptionContext(
        itemEncryptor,
        manipulateNumberAttribute(itemDecrypted, "sort_key"),
        "sort_key"
      );
      assertManipulationProof(
        itemEncryptor,
        manipulateByteAttribute(itemDecrypted, "attribute1"),
        "attribute1"
      );
      assertManipulationProof(
        itemEncryptor,
        manipulateStringAttribute(itemDecrypted, "attribute2"),
        "attribute2"
      );
      assertNotManipulationProof(
        itemEncryptor,
        manipulateStringAttribute(itemDecrypted, ":attribute3"),
        ":attribute3"
      );
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(final String[] args) {
    if (args.length < 2) {
      throw new IllegalArgumentException(
        "To run this example, include the kmsKeyId as args[0] and ddbTableName as args[1]"
      );
    }
    final String kmsKeyId = args[0];
    final String ddbTableName = args[1];
    PutItemGetItem(kmsKeyId, ddbTableName);
  }
}
