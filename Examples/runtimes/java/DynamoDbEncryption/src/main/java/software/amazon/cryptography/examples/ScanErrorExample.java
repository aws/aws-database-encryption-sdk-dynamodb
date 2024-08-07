package software.amazon.cryptography.examples;

import java.util.HashMap;
import java.util.Map;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.DynamoDbEncryptionInterceptor;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTableEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.model.DynamoDbTablesEncryptionConfig;
import software.amazon.cryptography.dbencryptionsdk.dynamodb.transforms.model.CollectionOfErrors;
import software.amazon.cryptography.dbencryptionsdk.structuredencryption.model.CryptoAction;
import software.amazon.cryptography.materialproviders.IKeyring;
import software.amazon.cryptography.materialproviders.MaterialProviders;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.DBEAlgorithmSuiteId;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  and uses the low level Scan operation to demonstrate
  retrieving the error messages from the returned CollectionOfErrors
  when some of the Scan results do not decrypt successfully.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (N)
 */
public class ScanErrorExample {

  public static void ScanError(String kmsKeyId, String ddbTableName) {
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

    // 2. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    attributeActionsOnEncrypt.put("partition_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("sort_key", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("attribute1", CryptoAction.ENCRYPT_AND_SIGN);
    attributeActionsOnEncrypt.put("attribute2", CryptoAction.SIGN_ONLY);
    attributeActionsOnEncrypt.put(":attribute3", CryptoAction.DO_NOTHING);

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
    //   For this example, we have designed our DynamoDb table such that any attribute name with
    //   the ":" prefix should be considered unauthenticated.
    final String unsignAttrPrefix = ":";

    // 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigs =
      new HashMap<>();
    final DynamoDbTableEncryptionConfig config = DynamoDbTableEncryptionConfig
      .builder()
      .logicalTableName(ddbTableName)
      .partitionKeyName("partition_key")
      .sortKeyName("sort_key")
      .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
      .keyring(kmsKeyring)
      .allowedUnsignedAttributePrefix(unsignAttrPrefix)
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
    final DynamoDbClient ddb = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptor)
          .build()
      )
      .build();

    // 7. Perform a Scan for which some records will not decrypt
    Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
    expressionAttributeValues.put(
      ":prefix",
      AttributeValue.builder().s("Broken").build()
    );

    ScanRequest scanRequest = ScanRequest
      .builder()
      .tableName(ddbTableName)
      .filterExpression("begins_with(partition_key, :prefix)")
      .expressionAttributeValues(expressionAttributeValues)
      .build();

    try {
      final ScanResponse scanResponse = ddb.scan(scanRequest);
      assert false;
    } catch (Exception e) {
      print_exception(e, "");
    }
  }

  public static void print_exception(Exception e, String indent) {
    System.err.println(indent + e.getMessage());
    if (e.getCause() instanceof CollectionOfErrors) {
      System.err.println(indent + e.getCause().getMessage());
      for (RuntimeException err : ((CollectionOfErrors) e.getCause()).list()) {
        print_exception(err, indent + "   ");
      }
    } else if (
      e instanceof
      software.amazon.cryptography.materialproviders.model.CollectionOfErrors
    ) {
      for (RuntimeException err : ((software.amazon.cryptography.materialproviders.model.CollectionOfErrors) e).list()) {
        print_exception(err, indent + "   ");
      }
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
    ScanError(kmsKeyId, ddbTableName);
  }
}
