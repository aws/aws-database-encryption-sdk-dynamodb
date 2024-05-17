package software.amazon.cryptography.examples.keyring;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.kms.model.EncryptionAlgorithmSpec;
import software.amazon.awssdk.services.kms.model.GetPublicKeyRequest;
import software.amazon.awssdk.services.kms.model.GetPublicKeyResponse;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsRsaKeyringInput;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  using the KMS RSA Keyring. This keyring uses a KMS RSA key pair to
  encrypt and decrypt records. The client uses the downloaded public key
  to encrypt items it adds to the table.
  The keyring uses the private key to decrypt existing table items it retrieves,
  by calling KMS' decrypt API.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
  This example also requires access to a KMS RSA key.
  Our tests provide a KMS RSA ARN that anyone can use, but you
  can also provide your own KMS RSA key.
  To use your own KMS RSA key, you must have either:
   - Its public key downloaded in a UTF-8 encoded PEM file
   - kms:GetPublicKey permissions on that key
  If you do not have the public key downloaded, running this example
  through its main method will download the public key for you
  by calling kms:GetPublicKey.
  You must also have kms:Decrypt permissions on the KMS RSA key.
 */
public class KmsRsaKeyringExample {

  private static String DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME =
    "KmsRsaKeyringExamplePublicKey.pem";

  public static void KmsRsaKeyringGetItemPutItem(
    String ddbTableName,
    String rsaKeyArn,
    String rsaPublicKeyFilename
  ) {
    // 1. Load UTF-8 encoded public key PEM file.
    //    You may have an RSA public key file already defined.
    //    If not, the main method in this class will call
    //    the KMS RSA key, retrieve its public key, and store it
    //    in a PEM file for example use.
    ByteBuffer publicKeyUtf8EncodedByteBuffer;
    try {
      publicKeyUtf8EncodedByteBuffer =
        ByteBuffer.wrap(Files.readAllBytes(Paths.get(rsaPublicKeyFilename)));
    } catch (IOException e) {
      throw new RuntimeException(
        "IOException while reading public key from file",
        e
      );
    }

    // 2. Create a KMS RSA keyring.
    //    This keyring takes in:
    //     - kmsClient
    //     - kmsKeyId: Must be an ARN representing a KMS RSA key
    //     - publicKey: A ByteBuffer of a UTF-8 encoded PEM file representing the public
    //                  key for the key passed into kmsKeyId
    //     - encryptionAlgorithm: Must be either RSAES_OAEP_SHA_256 or RSAES_OAEP_SHA_1
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    final CreateAwsKmsRsaKeyringInput createAwsKmsRsaKeyringInput =
      CreateAwsKmsRsaKeyringInput
        .builder()
        .kmsClient(KmsClient.create())
        .kmsKeyId(rsaKeyArn)
        .publicKey(publicKeyUtf8EncodedByteBuffer)
        .encryptionAlgorithm(EncryptionAlgorithmSpec.RSAES_OAEP_SHA_256)
        .build();
    IKeyring awsKmsRsaKeyring = matProv.CreateAwsKmsRsaKeyring(
      createAwsKmsRsaKeyringInput
    );

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
    //    - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
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

    // 5. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //    Note: To use the KMS RSA keyring, your table config must specify an algorithmSuite
    //    that does not use asymmetric signing.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig
      .builder()
      .logicalTableName(ddbTableName)
      .partitionKeyName("partition_key")
      .sortKeyName("sort_key")
      .attributeActionsOnEncrypt(attributeActions)
      .keyring(awsKmsRsaKeyring)
      .allowedUnsignedAttributePrefix(unsignAttrPrefix)
      // Specify algorithmSuite without asymmetric signing here
      // As of v3.0.0, the only supported algorithmSuite without asymmetric signing is
      // ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384.
      .algorithmSuiteId(
        DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384
      )
      .build();
    tableConfigs.put(ddbTableName, config);

    // 6. Create the DynamoDb Encryption Interceptor
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

    // 7. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddbClient = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();

    // 8. Put an item into our table using the above client.
    //    Before the item gets sent to DynamoDb, it will be encrypted
    //    client-side, according to our configuration.
    final HashMap<String, AttributeValue> item = new HashMap<>();
    item.put(
      "partition_key",
      AttributeValue.builder().s("awsKmsRsaKeyringItem").build()
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

    // 9. Get the item back from our table using the client.
    //    The client will decrypt the item client-side using the RSA keyring
    //    and return the original item.
    final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(
      "partition_key",
      AttributeValue.builder().s("awsKmsRsaKeyringItem").build()
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
  }

  public static void KmsRsaKeyringGetItemPutItem(
    String ddbTableName,
    String rsaKeyArn
  ) {
    KmsRsaKeyringGetItemPutItem(
      ddbTableName,
      rsaKeyArn,
      DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME
    );
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException(
        "To run this example, include the ddbTable and rsaKeyArn in args; optionally include rsaPublicKeyFilename"
      );
    }
    final String ddbTableName = args[0];
    final String rsaKeyArn = args[1];
    String rsaPublicKeyFilename;
    if (args.length == 3) {
      rsaPublicKeyFilename = args[2];
    } else {
      rsaPublicKeyFilename = DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME;
    }

    // You may provide your own RSA public key at EXAMPLE_RSA_PUBLIC_KEY_FILENAME.
    // This must be the public key for the RSA key represented at rsaKeyArn.
    // If this file is not present, this will write a UTF-8 encoded PEM file for you.
    if (shouldGetNewPublicKey(rsaPublicKeyFilename)) {
      writePublicKeyPemForRsaKey(rsaKeyArn, rsaPublicKeyFilename);
    }

    KmsRsaKeyringGetItemPutItem(ddbTableName, rsaKeyArn, rsaPublicKeyFilename);
  }

  static boolean shouldGetNewPublicKey() {
    return shouldGetNewPublicKey(DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME);
  }

  static boolean shouldGetNewPublicKey(String rsaPublicKeyFilename) {
    // Check if a public key file already exists
    File publicKeyFile = new File(rsaPublicKeyFilename);

    // If a public key file already exists: do not overwrite existing file
    if (publicKeyFile.exists()) {
      return false;
    }

    // If file is not present, generate a new key pair
    return true;
  }

  static void writePublicKeyPemForRsaKey(String rsaKeyArn) {
    writePublicKeyPemForRsaKey(
      rsaKeyArn,
      DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME
    );
  }

  static void writePublicKeyPemForRsaKey(
    String rsaKeyArn,
    String rsaPublicKeyFilename
  ) {
    // Safety check: Validate file is not present
    File publicKeyFile = new File(rsaPublicKeyFilename);
    if (publicKeyFile.exists()) {
      throw new IllegalStateException(
        "getRsaPublicKey will not overwrite existing PEM files"
      );
    }

    // This code will call KMS to get the public key for the KMS RSA key.
    // You must have kms:GetPublicKey permissions on the key for this to succeed.
    // The public key will be written to the file EXAMPLE_RSA_PUBLIC_KEY_FILENAME.
    KmsClient getterForPublicKey = KmsClient.create();
    GetPublicKeyResponse response = getterForPublicKey.getPublicKey(
      GetPublicKeyRequest.builder().keyId(rsaKeyArn).build()
    );
    byte[] publicKeyByteArray = response.publicKey().asByteArray();

    StringWriter publicKeyStringWriter = new StringWriter();
    PemWriter publicKeyPemWriter = new PemWriter(publicKeyStringWriter);
    try {
      publicKeyPemWriter.writeObject(
        new PemObject("PUBLIC KEY", publicKeyByteArray)
      );
      publicKeyPemWriter.close();
    } catch (IOException e) {
      throw new RuntimeException("IOException while writing public key PEM", e);
    }
    ByteBuffer publicKeyUtf8EncodedByteBufferToWrite =
      StandardCharsets.UTF_8.encode(publicKeyStringWriter.toString());

    try {
      FileChannel fc = new FileOutputStream(rsaPublicKeyFilename).getChannel();
      fc.write(publicKeyUtf8EncodedByteBufferToWrite);
      fc.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(
        "FileNotFoundException while opening public key FileChannel",
        e
      );
    } catch (IOException e) {
      throw new RuntimeException(
        "IOException while writing public key or closing FileChannel",
        e
      );
    }
  }
}
