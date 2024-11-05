package software.amazon.cryptography.examples.keyring;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.interfaces.ECPublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
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
import software.amazon.cryptography.materialproviders.model.CreateRawEcdhKeyringInput;
import software.amazon.cryptography.materialproviders.model.EphemeralPrivateKeyToStaticPublicKeyInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.materialproviders.model.PublicKeyDiscoveryInput;
import software.amazon.cryptography.materialproviders.model.RawEcdhStaticConfigurations;
import software.amazon.cryptography.materialproviders.model.RawPrivateKeyToStaticPublicKeyInput;
import software.amazon.cryptography.primitives.model.ECDHCurveSpec;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  using the raw ECDH Keyring. This keyring takes in the sender's ECC
  private key and the recipient's ECC Public Key to derive a shared secret.
  The keyring uses the shared secret to derive a data key to protect the
  data keys that encrypt and decrypt DynamoDb table items.

  This example takes in the sender's private key, the recipient's
  public key, and the algorithm definition where the ECC keys lie.
  This parameter takes in the sender's private key as a
  UTF8 PEM-encoded (PKCS #8 PrivateKeyInfo structures), the recipient's
  DER-encoded X.509 public key, also known as SubjectPublicKeyInfo (SPKI),
  and the Curve Specification where the keys lie.

  This example encrypts a test item using the provided ECC keys and puts the
  encrypted item to the provided DynamoDb table. Then, it gets the
  item from the table and decrypts it.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class RawEcdhKeyringExample {

  public static String EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER =
    "RawEcdhKeyringExamplePrivateKeySender.pem";
  public static String EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT =
    "RawEcdhKeyringExamplePrivateKeyRecipient.pem";
  public static String EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT =
    "RawEcdhKeyringExamplePublicKeyRecipient.pem";

  public static void RawEcdhKeyringGetItemPutItem(
    String ddbTableName,
    ECDHCurveSpec curveSpec
  ) {
    // 1. Load key pair from UTF-8 encoded PEM files.
    //    You may provide your own PEM files to use here.
    //    If you do not, the main method in this class will generate PEM
    //    files for example use. Do not use these files for any other purpose.
    ByteBuffer privateKeyUtf8EncodedByteBuffer;
    try {
      privateKeyUtf8EncodedByteBuffer =
        ByteBuffer.wrap(
          Files.readAllBytes(Paths.get(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER))
        );
    } catch (IOException e) {
      throw new RuntimeException(
        "IOException while reading the private key from file",
        e
      );
    }

    ByteBuffer publicKeyByteBuffer;
    try {
      ByteBuffer publicKeyUtf8EncodedByteBuffer = ByteBuffer.wrap(
        Files.readAllBytes(Paths.get(EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT))
      );
      PemReader pemReader = new PemReader(
        new InputStreamReader(
          new ByteArrayInputStream(publicKeyUtf8EncodedByteBuffer.array())
        )
      );
      PemObject pemObject = pemReader.readPemObject();
      byte[] content = pemObject.getContent();
      SubjectPublicKeyInfo subjectPublicKeyInfo =
        SubjectPublicKeyInfo.getInstance(content);
      X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(
        subjectPublicKeyInfo.getEncoded()
      );
      if (Security.getProvider("BC") == null) {
        Security.addProvider(new BouncyCastleProvider());
      }
      KeyFactory keyFactory = KeyFactory.getInstance("EC", "BC");
      PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
      publicKeyByteBuffer = ByteBuffer.wrap(publicKey.getEncoded());
    } catch (IOException e) {
      throw new RuntimeException(
        "IOException while reading the public key from file",
        e
      );
    } catch (
      NoSuchAlgorithmException
      | NoSuchProviderException
      | InvalidKeySpecException e
    ) {
      throw new RuntimeException(e);
    }

    // 2. Create the keyring.
    //    This keyring uses static sender and recipient keys. This configuration calls for the keys
    //    to be
    //    The DynamoDb encryption client uses this to encrypt and decrypt items.
    final CreateRawEcdhKeyringInput keyringInput = CreateRawEcdhKeyringInput
      .builder()
      .curveSpec(curveSpec)
      .KeyAgreementScheme(
        RawEcdhStaticConfigurations
          .builder()
          .RawPrivateKeyToStaticPublicKey(
            RawPrivateKeyToStaticPublicKeyInput
              .builder()
              // Must be a UTF8 PEM-encoded private key
              .senderStaticPrivateKey(privateKeyUtf8EncodedByteBuffer)
              // Must be a DER-encoded X.509 public key
              .recipientPublicKey(publicKeyByteBuffer)
              .build()
          )
          .build()
      )
      .build();

    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    IKeyring rawEcdhKeyring = matProv.CreateRawEcdhKeyring(keyringInput);

    PutGetExampleWithKeyring(rawEcdhKeyring, ddbTableName);
  }

  public static void EphemeralRawEcdhKeyringPutItem(
    String ddbTableName,
    ECDHCurveSpec ecdhCurveSpec
  ) {
    // 1. Load public key from UTF-8 encoded PEM files into a DER encoded public key.
    //    You may provide your own PEM files to use here.
    //    If you do not, the main method in this class will generate PEM
    //    files for example use. Do not use these files for any other purpose.
    ByteBuffer publicKeyByteBuffer;
    try {
      ByteBuffer publicKeyUtf8EncodedByteBuffer = ByteBuffer.wrap(
        Files.readAllBytes(Paths.get(EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT))
      );
      PemReader pemReader = new PemReader(
        new InputStreamReader(
          new ByteArrayInputStream(publicKeyUtf8EncodedByteBuffer.array())
        )
      );
      PemObject pemObject = pemReader.readPemObject();
      byte[] content = pemObject.getContent();
      SubjectPublicKeyInfo subjectPublicKeyInfo =
        SubjectPublicKeyInfo.getInstance(content);
      X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(
        subjectPublicKeyInfo.getEncoded()
      );
      if (Security.getProvider("BC") == null) {
        Security.addProvider(new BouncyCastleProvider());
      }
      KeyFactory keyFactory = KeyFactory.getInstance("EC", "BC");
      PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
      publicKeyByteBuffer = ByteBuffer.wrap(publicKey.getEncoded());
    } catch (IOException e) {
      throw new RuntimeException(
        "IOException while reading the public key from file",
        e
      );
    } catch (
      NoSuchAlgorithmException
      | NoSuchProviderException
      | InvalidKeySpecException e
    ) {
      throw new RuntimeException(e);
    }

    // 2. Create the keyring.
    //    This keyring uses an ephemeral configuration. This configuration will always create a new
    //    key pair as the sender key pair for the key agreement operation. The ephemeral configuration can only
    //    encrypt data and CANNOT decrypt messages.
    //    The DynamoDb encryption client uses this to encrypt and decrypt items.
    final CreateRawEcdhKeyringInput keyringInput = CreateRawEcdhKeyringInput
      .builder()
      .curveSpec(ecdhCurveSpec)
      .KeyAgreementScheme(
        RawEcdhStaticConfigurations
          .builder()
          .EphemeralPrivateKeyToStaticPublicKey(
            EphemeralPrivateKeyToStaticPublicKeyInput
              .builder()
              .recipientPublicKey(publicKeyByteBuffer)
              .build()
          )
          .build()
      )
      .build();

    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    IKeyring rawEcdhKeyring = matProv.CreateRawEcdhKeyring(keyringInput);

    // A raw ecdh keyring with Ephemeral configuration cannot decrypt data since the key pair
    // used as the sender is ephemeral. This means that at decrypt time it does not have
    // the private key that corresponds to the public key that is stored on the message.
    PutExampleWithKeyring(rawEcdhKeyring, ddbTableName);
  }

  public static void DiscoveryRawEcdhKeyringGetItem(
    String ddbTableName,
    ECDHCurveSpec ecdhCurveSpec
  ) {
    // 1. Load key pair from UTF-8 encoded PEM files.
    //    You may provide your own PEM files to use here.
    //    If you do not, the main method in this class will generate PEM
    //    files for example use. Do not use these files for any other purpose.
    ByteBuffer privateKeyUtf8EncodedByteBuffer;
    try {
      privateKeyUtf8EncodedByteBuffer =
        ByteBuffer.wrap(
          Files.readAllBytes(
            Paths.get(EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT)
          )
        );
    } catch (IOException e) {
      throw new RuntimeException(
        "IOException while reading the private key from file",
        e
      );
    }

    // 2. Create the keyring.
    //    This keyring uses a discovery configuration. This configuration will check on decrypt
    //    if it is meant to decrypt the message by checking if the configured public key is stored on the message.
    //    The discovery configuration can only decrypt messages and CANNOT encrypt messages.
    //    The DynamoDb encryption client uses this to encrypt and decrypt items.
    final CreateRawEcdhKeyringInput keyringInput = CreateRawEcdhKeyringInput
      .builder()
      .curveSpec(ecdhCurveSpec)
      .KeyAgreementScheme(
        RawEcdhStaticConfigurations
          .builder()
          .PublicKeyDiscovery(
            PublicKeyDiscoveryInput
              .builder()
              .recipientStaticPrivateKey(privateKeyUtf8EncodedByteBuffer)
              .build()
          )
          .build()
      )
      .build();

    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    IKeyring rawEcdhKeyring = matProv.CreateRawEcdhKeyring(keyringInput);

    // A raw ecdh keyring with discovery configuration cannot encrypt data since the keyring
    // looks for its configured public key on the message.
    GetExampleWithKeyring(rawEcdhKeyring, ddbTableName);
  }

  public static void PutGetExampleWithKeyring(
    IKeyring rawEcdhKeyring,
    String ddbTableName
  ) {
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
      .keyring(rawEcdhKeyring)
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
      AttributeValue.builder().s("rawEcdhKeyringItem").build()
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
      AttributeValue.builder().s("rawEcdhKeyringItem").build()
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

  public static void PutExampleWithKeyring(
    IKeyring rawEcdhKeyring,
    String ddbTableName
  ) {
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
      .keyring(rawEcdhKeyring)
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
      AttributeValue.builder().s("rawEcdhKeyringItem").build()
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
  }

  public static void GetExampleWithKeyring(
    IKeyring rawEcdhKeyring,
    String ddbTableName
  ) {
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
      .keyring(rawEcdhKeyring)
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

    // 8. Get the item back from our table using the same client.
    //    The client will decrypt the item client-side, and return
    //    back the original item.
    final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(
      "partition_key",
      AttributeValue.builder().s("rawEcdhKeyringItem").build()
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

    RawEcdhKeyringGetItemPutItem(ddbTableName, ECDHCurveSpec.ECC_NIST_P256);
  }

  public static boolean shouldGenerateNewEccKeyPairs() {
    File privateKeyFileSender = new File(
      EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER
    );
    File privateKeyFileRecipient = new File(
      EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT
    );
    File publicKeyFileRecipient = new File(
      EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    );

    // If keys already exist: do not overwrite existing keys
    if (
      privateKeyFileSender.exists() &&
      publicKeyFileRecipient.exists() &&
      privateKeyFileRecipient.exists()
    ) {
      return false;
    }

    // If not all three keys are present; throw an exception
    if (
      !privateKeyFileSender.exists() &&
      publicKeyFileRecipient.exists() &&
      privateKeyFileRecipient.exists()
    ) {
      throw new IllegalStateException(
        "Missing private key sender file at " +
        EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER
      );
    }
    if (
      privateKeyFileSender.exists() &&
      !publicKeyFileRecipient.exists() &&
      privateKeyFileRecipient.exists()
    ) {
      throw new IllegalStateException(
        "Missing public key recipient file at " +
        EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
      );
    }
    if (
      privateKeyFileSender.exists() &&
      publicKeyFileRecipient.exists() &&
      !privateKeyFileRecipient.exists()
    ) {
      throw new IllegalStateException(
        "Missing private key recipient file at " +
        EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT
      );
    }

    // If no keys are present, generate new keys
    return true;
  }

  public static void generateEccKeyPairs() {
    File privateKeyFileSender = new File(
      EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER
    );
    File privateKeyFileRecipient = new File(
      EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT
    );
    File publicKeyFileRecipient = new File(
      EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    );

    if (
      privateKeyFileSender.exists() ||
      publicKeyFileRecipient.exists() ||
      privateKeyFileRecipient.exists()
    ) {
      throw new IllegalStateException(
        "generateEccKeyPairs will not overwrite existing PEM files"
      );
    }

    // This code will generate new ECC key pairs for example use.
    // The keys will be written to the files:
    //  - public_sender: EXAMPLE_ECC_PUBLIC_KEY_FILENAME_SENDER
    //  - private_sender: EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER
    //  - public_recipient: EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    // This example uses BouncyCastle's KeyPairGenerator to generate the key pairs.
    // In practice, you should not generate this in your code, and should instead
    // retrieve this key from a secure key management system (e.g. HSM).
    // These examples only demonstrate using the P256 curve while the keyring accepts
    // P256, P384, or P521.
    // These keys are created here for example purposes only.
    KeyPairGenerator keyGen;
    try {
      if (Security.getProvider("BC") == null) {
        Security.addProvider(new BouncyCastleProvider());
      }
      keyGen = KeyPairGenerator.getInstance("EC", "BC");
      keyGen.initialize(
        new ECGenParameterSpec("secp256r1"),
        new SecureRandom()
      );
    } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
      throw new RuntimeException("No such algorithm", e);
    } catch (NoSuchProviderException e) {
      throw new RuntimeException(e);
    }

    final KeyPair senderKeyPair = keyGen.generateKeyPair();
    final KeyPair recipientKeyPair = keyGen.generateKeyPair();

    writePrivateKey(
      senderKeyPair.getPrivate(),
      EXAMPLE_ECC_PRIVATE_KEY_FILENAME_SENDER
    );
    writePrivateKey(
      recipientKeyPair.getPrivate(),
      EXAMPLE_ECC_PRIVATE_KEY_FILENAME_RECIPIENT
    );
    writePublicKey(
      (ECPublicKey) recipientKeyPair.getPublic(),
      EXAMPLE_ECC_PUBLIC_KEY_FILENAME_RECIPIENT
    );
  }

  private static void writePrivateKey(
    PrivateKey aPrivate,
    String exampleEccPrivateKeyFilenameSender
  ) {
    StringWriter privateKeySenderStringWriter = new StringWriter();
    PemWriter privateKeyPemWriter = new PemWriter(privateKeySenderStringWriter);

    try {
      privateKeyPemWriter.writeObject(
        new PemObject("PRIVATE KEY", aPrivate.getEncoded())
      );
      privateKeyPemWriter.close();
    } catch (IOException e) {
      throw new RuntimeException(
        "IOException while writing private key PEM",
        e
      );
    }

    ByteBuffer privateKeyUtf8EncodedPrivateKeyByteBuffer =
      StandardCharsets.UTF_8.encode(privateKeySenderStringWriter.toString());

    // Write UTF8 encoded PEM file
    try {
      FileChannel fc = new FileOutputStream(exampleEccPrivateKeyFilenameSender)
        .getChannel();
      fc.write(privateKeyUtf8EncodedPrivateKeyByteBuffer);
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
  }

  private static void writePublicKey(ECPublicKey aPublic, String fileName) {
    StringWriter publicKeyStringWriter = new StringWriter();
    PemWriter publicKeySenderPemWriter = new PemWriter(publicKeyStringWriter);
    X509EncodedKeySpec spec = new X509EncodedKeySpec(aPublic.getEncoded());

    try {
      publicKeySenderPemWriter.writeObject(
        new PemObject("PUBLIC KEY", spec.getEncoded())
      );
      publicKeySenderPemWriter.close();
    } catch (IOException e) {
      throw new RuntimeException("IOException while writing public key PEM", e);
    }

    ByteBuffer publicKeyUtf8EncodedPublicKeyByteBuffer =
      StandardCharsets.UTF_8.encode(publicKeyStringWriter.toString());

    try {
      FileChannel fc = new FileOutputStream(fileName).getChannel();
      fc.write(publicKeyUtf8EncodedPublicKeyByteBuffer);
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
  }
}
