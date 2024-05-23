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
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateRawRsaKeyringInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.materialproviders.model.PaddingScheme;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  using the raw RSA Keyring. This keyring uses an RSA key pair to
  encrypt and decrypt records. This keyring accepts PEM encodings of
  the key pair as UTF-8 interpreted bytes. The client uses the public key
  to encrypt items it adds to the table and uses the private key to decrypt
  existing table items it retrieves.

  This example loads a key pair from PEM files with paths defined in
   - EXAMPLE_RSA_PRIVATE_KEY_FILENAME
   - EXAMPLE_RSA_PUBLIC_KEY_FILENAME
  If you do not provide these files, running this example through this
  class' main method will generate these files for you. These files will
  be generated in the directory where the example is run.
  In practice, users of this library should not generate new key pairs
  like this, and should instead retrieve an existing key from a secure
  key management system (e.g. an HSM).
  You may also provide your own key pair by placing PEM files in the
  directory where the example is run or modifying the paths in the code
  below. These files must be valid PEM encodings of the key pair as UTF-8
  encoded bytes. If you do provide your own key pair, or if a key pair
  already exists, this class' main method will not generate a new key pair.

  This example loads a key pair from disk, encrypts a test item, and puts the
  encrypted item to the provided DynamoDb table. Then, it gets the
  item from the table and decrypts it.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class RawRsaKeyringExample {

  private static String EXAMPLE_RSA_PRIVATE_KEY_FILENAME =
    "RawRsaKeyringExamplePrivateKey.pem";
  private static String EXAMPLE_RSA_PUBLIC_KEY_FILENAME =
    "RawRsaKeyringExamplePublicKey.pem";

  public static void RawRsaKeyringGetItemPutItem(String ddbTableName) {
    // 1. Load key pair from UTF-8 encoded PEM files.
    //    You may provide your own PEM files to use here.
    //    If you do not, the main method in this class will generate PEM
    //    files for example use. Do not use these files for any other purpose.
    ByteBuffer publicKeyUtf8EncodedByteBuffer;
    try {
      publicKeyUtf8EncodedByteBuffer =
        ByteBuffer.wrap(
          Files.readAllBytes(Paths.get(EXAMPLE_RSA_PUBLIC_KEY_FILENAME))
        );
    } catch (IOException e) {
      throw new RuntimeException(
        "IOException while reading public key from file",
        e
      );
    }

    ByteBuffer privateKeyUtf8EncodedByteBuffer;
    try {
      privateKeyUtf8EncodedByteBuffer =
        ByteBuffer.wrap(
          Files.readAllBytes(Paths.get(EXAMPLE_RSA_PRIVATE_KEY_FILENAME))
        );
    } catch (IOException e) {
      throw new RuntimeException(
        "IOException while reading private key from file",
        e
      );
    }

    // 2. Create the keyring.
    //    The DynamoDb encryption client uses this to encrypt and decrypt items.
    final CreateRawRsaKeyringInput keyringInput = CreateRawRsaKeyringInput
      .builder()
      .keyName("my-rsa-key-name")
      .keyNamespace("my-key-namespace")
      .paddingScheme(PaddingScheme.OAEP_SHA256_MGF1)
      .publicKey(publicKeyUtf8EncodedByteBuffer)
      .privateKey(privateKeyUtf8EncodedByteBuffer)
      .build();
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    IKeyring rawRsaKeyring = matProv.CreateRawRsaKeyring(keyringInput);

    // 3. Configure which attributes are encrypted and/or signed when writing new items.
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

    // 5. Create the DynamoDb Encryption configuration for the table we will be writing to.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig
      .builder()
      .logicalTableName(ddbTableName)
      .partitionKeyName("partition_key")
      .sortKeyName("sort_key")
      .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
      .keyring(rawRsaKeyring)
      .allowedUnsignedAttributePrefix(unsignAttrPrefix)
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
    final DynamoDbClient ddb = DynamoDbClient
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
      AttributeValue.builder().s("rawRsaKeyringItem").build()
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

    final PutItemResponse putResponse = ddb.putItem(putRequest);

    // Demonstrate that PutItem succeeded
    assert 200 == putResponse.sdkHttpResponse().statusCode();

    // 9. Get the item back from our table using the same client.
    //    The client will decrypt the item client-side, and return
    //    back the original item.
    final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(
      "partition_key",
      AttributeValue.builder().s("rawRsaKeyringItem").build()
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
      .get("sensitive_data")
      .s()
      .equals("encrypt and sign me!");
  }

  public static void main(final String[] args) {
    if (args.length <= 0) {
      throw new IllegalArgumentException(
        "To run this example, include the ddbTable in args"
      );
    }
    final String ddbTableName = args[0];

    // You may provide your own RSA key pair in the files located at
    //  - EXAMPLE_RSA_PRIVATE_KEY_FILENAME
    //  - EXAMPLE_RSA_PUBLIC_KEY_FILENAME
    // If these files are not present, this will generate a pair for you
    if (shouldGenerateNewRsaKeyPair()) {
      generateRsaKeyPair();
    }

    RawRsaKeyringGetItemPutItem(ddbTableName);
  }

  static boolean shouldGenerateNewRsaKeyPair() {
    // Check if a key pair already exists
    File privateKeyFile = new File(EXAMPLE_RSA_PRIVATE_KEY_FILENAME);
    File publicKeyFile = new File(EXAMPLE_RSA_PUBLIC_KEY_FILENAME);

    // If a key pair already exists: do not overwrite existing key pair
    if (privateKeyFile.exists() && publicKeyFile.exists()) {
      return false;
    }

    // If only one file is present: throw exception
    if (privateKeyFile.exists() && !publicKeyFile.exists()) {
      throw new IllegalStateException(
        "Missing public key file at " + EXAMPLE_RSA_PUBLIC_KEY_FILENAME
      );
    }
    if (!privateKeyFile.exists() && publicKeyFile.exists()) {
      throw new IllegalStateException(
        "Missing private key file at " + EXAMPLE_RSA_PRIVATE_KEY_FILENAME
      );
    }

    // If neither file is present, generate a new key pair
    return true;
  }

  static void generateRsaKeyPair() {
    // Safety check: Validate neither file is present
    File privateKeyFile = new File(EXAMPLE_RSA_PRIVATE_KEY_FILENAME);
    File publicKeyFile = new File(EXAMPLE_RSA_PUBLIC_KEY_FILENAME);
    if (privateKeyFile.exists() || publicKeyFile.exists()) {
      throw new IllegalStateException(
        "generateRsaKeyPair will not overwrite existing PEM files"
      );
    }

    // This code will generate a new RSA key pair for example use.
    // The public and private key will be written to the files:
    //  - public: EXAMPLE_RSA_PUBLIC_KEY_FILENAME
    //  - private: EXAMPLE_RSA_PRIVATE_KEY_FILENAME
    // This example uses BouncyCastle's KeyPairGenerator to generate the key pair.
    // In practice, you should not generate this in your code, and should instead
    // retrieve this key from a secure key management system (e.g. HSM)
    // This key is created here for example purposes only.
    KeyPairGenerator rsaGen;
    try {
      rsaGen = KeyPairGenerator.getInstance("RSA");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("No such algorithm", e);
    }
    rsaGen.initialize(2048, new SecureRandom());
    KeyPair keyPair = rsaGen.generateKeyPair();

    StringWriter privateKeyStringWriter = new StringWriter();
    PemWriter privateKeyPemWriter = new PemWriter(privateKeyStringWriter);
    try {
      privateKeyPemWriter.writeObject(
        new PemObject("PRIVATE KEY", keyPair.getPrivate().getEncoded())
      );
      privateKeyPemWriter.close();
    } catch (IOException e) {
      throw new RuntimeException(
        "IOException while writing private key PEM",
        e
      );
    }

    ByteBuffer privateKeyUtf8EncodedByteBuffer = StandardCharsets.UTF_8.encode(
      privateKeyStringWriter.toString()
    );
    // Write UTF-8 encoded PEM file
    try {
      FileChannel fc = new FileOutputStream(EXAMPLE_RSA_PRIVATE_KEY_FILENAME)
        .getChannel();
      fc.write(privateKeyUtf8EncodedByteBuffer);
      fc.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(
        "FileNotFoundException while opening private key FileChannel",
        e
      );
    } catch (IOException e) {
      throw new RuntimeException(
        "IOException while writing private key or closing FileChannel",
        e
      );
    }

    StringWriter publicKeyStringWriter = new StringWriter();
    PemWriter publicKeyPemWriter = new PemWriter(publicKeyStringWriter);
    try {
      publicKeyPemWriter.writeObject(
        new PemObject("PUBLIC KEY", keyPair.getPublic().getEncoded())
      );
      publicKeyPemWriter.close();
    } catch (IOException e) {
      throw new RuntimeException("IOException while writing public key PEM", e);
    }
    ByteBuffer publicKeyUtf8EncodedByteBuffer = StandardCharsets.UTF_8.encode(
      publicKeyStringWriter.toString()
    );

    try {
      FileChannel fc = new FileOutputStream(EXAMPLE_RSA_PUBLIC_KEY_FILENAME)
        .getChannel();
      fc.write(publicKeyUtf8EncodedByteBuffer);
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
