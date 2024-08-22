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
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
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
import software.amazon.awssdk.services.kms.KmsClient;
import software.amazon.awssdk.services.kms.model.GetPublicKeyRequest;
import software.amazon.awssdk.services.kms.model.GetPublicKeyResponse;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsEcdhKeyringInput;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.KmsEcdhStaticConfigurations;
import software.amazon.cryptography.materialproviders.model.KmsPrivateKeyToStaticPublicKeyInput;
import software.amazon.cryptography.materialproviders.model.KmsPublicKeyDiscoveryInput;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;
import software.amazon.cryptography.primitives.model.ECDHCurveSpec;

public class KmsEcdhKeyringExample {

  public static String EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME =
    "KmsEccKeyringKeyringExamplePublicKeySender.pem";
  public static String EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME =
    "KmsEccKeyringKeyringExamplePublicKeyRecipient.pem";

  public static void KmsEcdhKeyringGetItemPutItem(
    String ddbTableName,
    String eccKeyArn,
    String eccPublicKeySenderFileName,
    String eccPublicKeyRecipientFileName
  ) {
    // 1. Load UTF-8 encoded public key PEM files as DER encoded bytes.
    //    You may have an ECC public key file already defined.
    //    If not, the main method in this class will call
    //    the KMS ECC key, retrieve its public key, and store it
    //    in a PEM file for example use.
    ByteBuffer publicKeyRecipientByteBuffer = loadPublicKeyBytes(
      eccPublicKeyRecipientFileName
    );
    ByteBuffer publicKeySenderByteBuffer = loadPublicKeyBytes(
      eccPublicKeySenderFileName
    );

    // 2. Create a KMS ECDH keyring.
    //    This keyring takes in:
    //     - kmsClient
    //     - kmsKeyId: Must be an ARN representing a KMS ECC key meant for KeyAgreement
    //     - curveSpec: The curve name where the public keys lie
    //     - senderPublicKey: A ByteBuffer of a UTF-8 encoded public
    //                  key for the key passed into kmsKeyId in DER format
    //     - recipientPublicKey: A ByteBuffer of a UTF-8 encoded public key
    //                  for the recipient public key.
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    final CreateAwsKmsEcdhKeyringInput createAwsKmsEcdhKeyringInput =
      CreateAwsKmsEcdhKeyringInput
        .builder()
        .kmsClient(KmsClient.create())
        .curveSpec(ECDHCurveSpec.ECC_NIST_P256)
        .KeyAgreementScheme(
          KmsEcdhStaticConfigurations
            .builder()
            .KmsPrivateKeyToStaticPublicKey(
              KmsPrivateKeyToStaticPublicKeyInput
                .builder()
                .senderKmsIdentifier(eccKeyArn)
                .senderPublicKey(publicKeySenderByteBuffer)
                .recipientPublicKey(publicKeyRecipientByteBuffer)
                .build()
            )
            .build()
        )
        .build();
    IKeyring kmsEcdhKeyring = matProv.CreateAwsKmsEcdhKeyring(
      createAwsKmsEcdhKeyringInput
    );

    PutGetItemWithKeyring(kmsEcdhKeyring, ddbTableName);
  }

  public static void KmsEcdhDiscoveryGetItem(
    String ddbTableName,
    String eccRecipientKeyArn
  ) {
    // 1. Create a KMS ECDH keyring.
    //    This keyring takes in:
    //     - kmsClient
    //     - recipientKmsIdentifier: Must be an ARN representing a KMS ECC key meant for KeyAgreement
    //     - curveSpec: The curve name where the public keys lie
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    final CreateAwsKmsEcdhKeyringInput createAwsKmsEcdhKeyringInput =
      CreateAwsKmsEcdhKeyringInput
        .builder()
        .kmsClient(KmsClient.create())
        .curveSpec(ECDHCurveSpec.ECC_NIST_P256)
        .KeyAgreementScheme(
          KmsEcdhStaticConfigurations
            .builder()
            .KmsPublicKeyDiscovery(
              KmsPublicKeyDiscoveryInput
                .builder()
                .recipientKmsIdentifier(eccRecipientKeyArn)
                .build()
            )
            .build()
        )
        .build();
    IKeyring kmsEcdhKeyring = matProv.CreateAwsKmsEcdhKeyring(
      createAwsKmsEcdhKeyringInput
    );

    GetItemWithKeyring(kmsEcdhKeyring, ddbTableName);
  }

  private static void GetItemWithKeyring(
    IKeyring kmsEcdhKeyring,
    String ddbTableName
  ) {
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

    // 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
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
      .keyring(kmsEcdhKeyring)
      .allowedUnsignedAttributePrefix(unsignAttrPrefix)
      // Specify algorithmSuite without asymmetric signing here
      // As of v3.0.0, the only supported algorithmSuite without asymmetric signing is
      // ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384.
      .algorithmSuiteId(
        DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384
      )
      .build();
    tableConfigs.put(ddbTableName, config);

    // 5. Create the DynamoDb Encryption Interceptor
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

    // 6. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    final DynamoDbClient ddbClient = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();

    // 7. Get the item back from our table using the client.
    //    The client will decrypt the item client-side using the ECDH keyring
    //    and return the original item.
    final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(
      "partition_key",
      AttributeValue.builder().s("awsKmsEcdhKeyringItem").build()
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

  private static void PutGetItemWithKeyring(
    IKeyring awsKmsEcdhKeyring,
    String ddbTableName
  ) {
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
      .keyring(awsKmsEcdhKeyring)
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
      AttributeValue.builder().s("awsKmsEcdhKeyringItem").build()
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
      AttributeValue.builder().s("awsKmsEcdhKeyringItem").build()
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

  private static ByteBuffer loadPublicKeyBytes(String eccPublicKeyFileName) {
    try {
      ByteBuffer publicKeyFileBytes = ByteBuffer.wrap(
        Files.readAllBytes(Paths.get(eccPublicKeyFileName))
      );

      PemReader pemReader = new PemReader(
        new InputStreamReader(
          new ByteArrayInputStream(publicKeyFileBytes.array())
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
      return ByteBuffer.wrap(publicKey.getEncoded());
    } catch (IOException e) {
      throw new RuntimeException(
        "IOException while reading public key from file",
        e
      );
    } catch (
      NoSuchProviderException
      | NoSuchAlgorithmException
      | InvalidKeySpecException e
    ) {
      throw new RuntimeException(e);
    }
  }

  public static void KmsEcdhKeyringGetItemPutItem(
    String ddbTableName,
    String eccKeyArn
  ) {
    KmsEcdhKeyringGetItemPutItem(
      ddbTableName,
      eccKeyArn,
      EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME,
      EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME
    );
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException(
        "To run this example, include the ddbTable and eccKeyArn in args; optionally include eccPublicKeySenderFilename, eccPublicKeyRecipientFilename, and eccRecipientKeyArn arguments"
      );
    }
    final String ddbTableName = args[0];
    final String eccKeyArn = args[1];
    String eccPublicKeySenderFilename;
    String eccPublicKeyRecipientFilename;
    String eccRecipientKeyArn;
    if (args.length == 4) {
      eccPublicKeySenderFilename = args[2];
      eccPublicKeyRecipientFilename = args[3];
    } else {
      eccPublicKeySenderFilename = EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME;
      eccPublicKeyRecipientFilename = EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME;
    }
    if (args.length == 5) {
      eccRecipientKeyArn = args[4];
    } else {
      eccRecipientKeyArn = null;
    }

    // You may provide your own ECC public keys at EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME and
    // EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME.
    // The EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME must be the public key for the ECC key represented at eccKeyArn.
    //
    // If these files are not present, this will write a UTF-8 encoded PEM file for you.
    // In this example we use an ECC KMS Key as the recipient key. However; this is only for
    // example purposes. You can use an ECC Key that is not stored in KMS as the recipient public key.
    if (shouldGetNewPublicKeys()) {
      writePublicKeyPemForEccKey(
        eccKeyArn,
        EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME
      );
      writePublicKeyPemForEccKey(
        eccRecipientKeyArn,
        EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME
      );
    }

    KmsEcdhKeyringGetItemPutItem(
      ddbTableName,
      eccKeyArn,
      eccPublicKeySenderFilename,
      eccPublicKeyRecipientFilename
    );
  }

  static void writePublicKeyPemForEccKey(
    String eccKeyArn,
    String eccPublicKeyFilename
  ) {
    // Safety check: Validate file is not present
    File publicKeyFile = new File(eccPublicKeyFilename);
    if (publicKeyFile.exists()) {
      throw new IllegalStateException(
        "writePublicKeyPemForEccKey will not overwrite existing PEM files"
      );
    }
    // This code will call KMS to get the public key for the KMS ECC key.
    // You must have kms:GetPublicKey permissions on the key for this to succeed.
    // The public key will be written to the file EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME
    // or EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME.
    KmsClient getterForPublicKey = KmsClient.create();
    GetPublicKeyResponse response = getterForPublicKey.getPublicKey(
      GetPublicKeyRequest.builder().keyId(eccKeyArn).build()
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
      FileChannel fc = new FileOutputStream(eccPublicKeyFilename).getChannel();
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

  static boolean shouldGetNewPublicKeys() {
    // Check if public keys already exist
    File senderPublicKeyFile = new File(EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME);
    File recipientPublicKeyFile = new File(
      EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME
    );

    if (senderPublicKeyFile.exists() || recipientPublicKeyFile.exists()) {
      return false;
    }

    if (!senderPublicKeyFile.exists() && recipientPublicKeyFile.exists()) {
      throw new IllegalStateException(
        "Missing public key sender file at " +
        EXAMPLE_ECC_PUBLIC_KEY_SENDER_FILENAME
      );
    }

    if (!recipientPublicKeyFile.exists() && senderPublicKeyFile.exists()) {
      throw new IllegalStateException(
        "Missing public key recipient file at " +
        EXAMPLE_ECC_PUBLIC_KEY_RECIPIENT_FILENAME
      );
    }

    return true;
  }
}
