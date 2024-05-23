package software.amazon.cryptography.examples.keyring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkDiscoveryMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.CreateAwsKmsMrkMultiKeyringInput;
import software.amazon.cryptography.materialproviders.model.DiscoveryFilter;
import software.amazon.cryptography.materialproviders.model.MaterialProvidersConfig;

/*
  This example sets up a MRK discovery multi-keyring to decrypt data using
  the DynamoDB encryption client. A discovery keyring is not provided with any wrapping
  keys; instead, it recognizes the KMS key that was used to encrypt a data key,
  and asks KMS to decrypt with that KMS key. Discovery keyrings cannot be used
  to encrypt data.

  For more information on discovery keyrings, see
  https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-keyring.html#kms-keyring-discovery

  This example encrypts an item using an MRK multi-keyring and puts the
  encrypted item to the configured DynamoDb table. Then, it gets the item
  from the table and decrypts it using the discovery keyring.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)
 */
public class MrkDiscoveryMultiKeyringExample {

  public static void MultiMrkDiscoveryKeyringGetItemPutItem(
    String ddbTableName,
    String keyArn,
    List<String> accountIds,
    List<String> regions
  ) {
    // 1. Create a single MRK multi-keyring using the key arn.
    //    Although this example demonstrates use of the MRK discovery multi-keyring,
    //    a discovery keyring cannot be used to encrypt. So we will need to construct
    //    a non-discovery keyring for this example to encrypt. For more information on MRK
    //    multi-keyrings, see the MultiMrkKeyringExample in this directory.
    //    Though this is an "MRK multi-keyring", we do not need to provide multiple keys,
    //    and can use single-region KMS keys. We will provide a single key here; this
    //    can be either an MRK or a single-region key.
    final MaterialProviders matProv = MaterialProviders
      .builder()
      .MaterialProvidersConfig(MaterialProvidersConfig.builder().build())
      .build();
    final CreateAwsKmsMrkMultiKeyringInput createAwsKmsMrkMultiKeyringInput =
      CreateAwsKmsMrkMultiKeyringInput.builder().generator(keyArn).build();
    IKeyring encryptKeyring = matProv.CreateAwsKmsMrkMultiKeyring(
      createAwsKmsMrkMultiKeyringInput
    );

    // 2. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and icncluded in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    final Map<String, CryptoAction> attributeActionsOnEncrypt = new HashMap<>();
    attributeActionsOnEncrypt.put("partition_key", CryptoAction.SIGN_ONLY); // Our partition attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put("sort_key", CryptoAction.SIGN_ONLY); // Our sort attribute must be SIGN_ONLY
    attributeActionsOnEncrypt.put(
      "sensitive_data",
      CryptoAction.ENCRYPT_AND_SIGN
    );

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
    //   For this example, we currently authenticate all attributes. To make it easier to
    //   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
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
      .keyring(encryptKeyring)
      .allowedUnsignedAttributePrefix(unsignAttrPrefix)
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

    // 7. Put an item into our table using the above client.
    //    Before the item gets sent to DynamoDb, it will be encrypted
    //    client-side using the MRK multi-keyring.
    final HashMap<String, AttributeValue> item = new HashMap<>();
    item.put(
      "partition_key",
      AttributeValue.builder().s("awsKmsMrkDiscoveryMultiKeyringItem").build()
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

    // 8. Construct a discovery filter.
    //    A discovery filter limits the set of encrypted data keys
    //    the keyring can use to decrypt data.
    //    We will only let the keyring use keys in the selected AWS accounts
    //    and in the `aws` partition.
    //    This is the suggested config for most users; for more detailed config, see
    //      https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-keyring.html#kms-keyring-discovery
    DiscoveryFilter discoveryFilter = DiscoveryFilter
      .builder()
      .partition("aws")
      .accountIds(accountIds)
      .build();

    // 9. Construct a discovery keyring.
    //    Note that we choose to use the MRK discovery multi-keyring, even though
    //    our original keyring used a single KMS key.
    CreateAwsKmsMrkDiscoveryMultiKeyringInput createAwsKmsMrkDiscoveryMultiKeyringInput =
      CreateAwsKmsMrkDiscoveryMultiKeyringInput
        .builder()
        .discoveryFilter(discoveryFilter)
        .regions(regions)
        .build();
    IKeyring decryptKeyring = matProv.CreateAwsKmsMrkDiscoveryMultiKeyring(
      createAwsKmsMrkDiscoveryMultiKeyringInput
    );

    // 10. Create new DDB config and client using the decrypt discovery keyring.
    //     This is the same as the above config, except we pass in the decrypt keyring.
    final Map<String, DynamoDbTableEncryptionConfig> tableConfigsForDecrypt =
      new HashMap<>();
    final DynamoDbTableEncryptionConfig configForDecrypt =
      DynamoDbTableEncryptionConfig
        .builder()
        .logicalTableName(ddbTableName)
        .partitionKeyName("partition_key")
        .sortKeyName("sort_key")
        .attributeActionsOnEncrypt(attributeActionsOnEncrypt)
        // Add decrypt keyring here
        .keyring(decryptKeyring)
        .allowedUnsignedAttributePrefix(unsignAttrPrefix)
        .build();
    tableConfigsForDecrypt.put(ddbTableName, configForDecrypt);

    DynamoDbEncryptionInterceptor encryptionInterceptorForDecrypt =
      DynamoDbEncryptionInterceptor
        .builder()
        .config(
          DynamoDbTablesEncryptionConfig
            .builder()
            .tableEncryptionConfigs(tableConfigsForDecrypt)
            .build()
        )
        .build();

    final DynamoDbClient ddbClientForDecrypt = DynamoDbClient
      .builder()
      .overrideConfiguration(
        ClientOverrideConfiguration
          .builder()
          .addExecutionInterceptor(encryptionInterceptorForDecrypt)
          .build()
      )
      .build();

    // 11. Get the item back from our table using the client.
    //     The client will retrieve encrypted items from the DDB table, then
    //     detect the KMS key that was used to encrypt their data keys.
    //     The client will make a request to KMS to decrypt with the encrypting KMS key.
    //     If the client has permission to decrypt with the KMS key,
    //     the client will decrypt the item client-side using the keyring
    //     and return the original item.
    final HashMap<String, AttributeValue> keyToGet = new HashMap<>();
    keyToGet.put(
      "partition_key",
      AttributeValue.builder().s("awsKmsMrkDiscoveryMultiKeyringItem").build()
    );
    keyToGet.put("sort_key", AttributeValue.builder().n("0").build());

    final GetItemRequest getRequest = GetItemRequest
      .builder()
      .key(keyToGet)
      .tableName(ddbTableName)
      .build();

    final GetItemResponse getResponse = ddbClientForDecrypt.getItem(getRequest);

    // Demonstrate that GetItem succeeded and returned the decrypted item
    assert 200 == getResponse.sdkHttpResponse().statusCode();
    final Map<String, AttributeValue> returnedItem = getResponse.item();
    assert returnedItem
      .get("sensitive_data")
      .s()
      .equals("encrypt and sign me!");
  }

  public static void main(final String[] args) {
    if (args.length <= 1) {
      throw new IllegalArgumentException(
        "To run this example, include the ddbTable, mrkKeyArn, accounts, and region in args"
      );
    }
    final String ddbTableName = args[0];
    final String mrkArn = args[1];

    // We will assume only 1 AWS account and 1 region will be passed into args.
    // To add more of either, change this number, then pass them into args.
    int numberOfAwsAccounts = 1;
    int numberOfRegions = 1;

    List<String> accounts = new ArrayList<>();
    int firstAccountIndex = 2; // 2 because args[0] is ddbTableName and args[1] is mrkArn
    for (
      int i = firstAccountIndex;
      i < firstAccountIndex + numberOfAwsAccounts;
      i++
    ) {
      accounts.add(args[i]);
    }
    List<String> regions = new ArrayList<>();
    int firstRegionIndex = firstAccountIndex + numberOfAwsAccounts;
    for (
      int i = firstRegionIndex;
      i < firstRegionIndex + numberOfRegions;
      i++
    ) {
      regions.add(args[i]);
    }
    MultiMrkDiscoveryKeyringGetItemPutItem(
      ddbTableName,
      mrkArn,
      accounts,
      regions
    );
  }
}
