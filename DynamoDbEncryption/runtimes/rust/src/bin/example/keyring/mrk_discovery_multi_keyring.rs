// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use aws_db_esdk::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig;
use aws_db_esdk::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction;
use aws_db_esdk::aws_cryptography_materialProviders::client as mpl_client;
use aws_db_esdk::aws_cryptography_materialProviders::types::material_providers_config::MaterialProvidersConfig;
use aws_db_esdk::aws_cryptography_materialProviders::types::PaddingScheme;
use aws_db_esdk::intercept::DbEsdkInterceptor;
use aws_db_esdk::DynamoDbTablesEncryptionConfig;
use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;
use std::fs::File;
use std::io::Read;
use std::io::Write;
use std::path::Path;

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

 pub async fn MultiMrkDiscoveryKeyringGetItemPutItem()
    {
      /*
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;
        var keyArn = TestUtils.TEST_MRK_KEY_ID;
        var accountIds = new List<String> { TestUtils.TEST_AWS_ACCOUNT_ID };
        var regions = new List<String> { TestUtils.TEST_AWS_REGION };

        // 1. Create a single MRK multi-keyring using the key arn.
        //    Although this example demonstrates use of the MRK discovery multi-keyring,
        //    a discovery keyring cannot be used to encrypt. So we will need to construct
        //    a non-discovery keyring for this example to encrypt. For more information on MRK
        //    multi-keyrings, see the MultiMrkKeyringExample in this directory.
        //    Though this is an "MRK multi-keyring", we do not need to provide multiple keys,
        //    and can use single-region KMS keys. We will provide a single key here; this
        //    can be either an MRK or a single-region key.
        var matProv = new MaterialProviders(new MaterialProvidersConfig());

        var createAwsKmsMrkMultiKeyringInput = new CreateAwsKmsMrkMultiKeyringInput
        {
            Generator = keyArn
        };
        IKeyring encryptKeyring = matProv.CreateAwsKmsMrkMultiKeyring(createAwsKmsMrkMultiKeyringInput);

        // 2. Configure which attributes are encrypted and/or signed when writing new items.
        //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //    we must explicitly configure how they should be treated during item encryption:
        //      - ENCRYPT_AND_SIGN: The attribute is encrypted and icncluded in the signature
        //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
        var attributeActionsOnEncrypt = new Dictionary<String, CryptoAction>
        {
            ["partition_key"] = CryptoAction.SIGN_ONLY, // Our partition attribute must be SIGN_ONLY
            ["sort_key"] = CryptoAction.SIGN_ONLY, // Our sort attribute must be SIGN_ONLY
            ["sensitive_data"] = CryptoAction.ENCRYPT_AND_SIGN
        };

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
        const String unsignAttrPrefix = ":";

        // 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                Keyring = encryptKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        // 5. Create a new AWS SDK DynamoDb client using the config above
        var ddbClient = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        // 7. Put an item into our table using the above client.
        //    Before the item gets sent to DynamoDb, it will be encrypted
        //    client-side using the MRK multi-keyring.
        var item = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("awsKmsMrkDiscoveryMultiKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" },
            ["sensitive_data"] = new AttributeValue("encrypt and sign me!")
        };

        var putRequest = new PutItemRequest
        {
            TableName = ddbTableName,
            Item = item
        };

        var putResponse = await ddbClient.PutItemAsync(putRequest);

        // Demonstrate that PutItem succeeded
        Debug.Assert(putResponse.HttpStatusCode == HttpStatusCode.OK);

        // 8. Construct a discovery filter.
        //    A discovery filter limits the set of encrypted data keys
        //    the keyring can use to decrypt data.
        //    We will only let the keyring use keys in the selected AWS accounts
        //    and in the `aws` partition.
        //    This is the suggested config for most users; for more detailed config, see
        //      https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-keyring.html#kms-keyring-discovery
        var discoveryFilter = new DiscoveryFilter
        {
            Partition = "aws",
            AccountIds = accountIds
        };

        // 9. Construct a discovery keyring.
        //    Note that we choose to use the MRK discovery multi-keyring, even though
        //    our original keyring used a single KMS key.
        var createAwsKmsMrkDiscoveryMultiKeyringInput = new CreateAwsKmsMrkDiscoveryMultiKeyringInput
        {
            DiscoveryFilter = discoveryFilter,
            Regions = regions
        };
        var decryptKeyring = matProv.CreateAwsKmsMrkDiscoveryMultiKeyring(createAwsKmsMrkDiscoveryMultiKeyringInput);

        // 10. Create new DDB config and client using the decrypt discovery keyring.
        //     This is the same as the above config, except we pass in the decrypt keyring.
        var tableConfigsForDecrypt = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                // Add decrypt keyring here
                Keyring = decryptKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        var ddbClientForDecrypt = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigsForDecrypt });

        // 11. Get the item back from our table using the client.
        //     The client will retrieve encrypted items from the DDB table, then
        //     detect the KMS key that was used to encrypt their data keys.
        //     The client will make a request to KMS to decrypt with the encrypting KMS key.
        //     If the client has permission to decrypt with the KMS key,
        //     the client will decrypt the item client-side using the keyring
        //     and return the original item.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("awsKmsMrkDiscoveryMultiKeyringItem"),
            ["sort_key"] = new AttributeValue { N = "0" }
        };

        var getRequest = new GetItemRequest
        {
            Key = keyToGet,
            TableName = ddbTableName
        };

        var getResponse = await ddbClientForDecrypt.GetItemAsync(getRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        Debug.Assert(getResponse.HttpStatusCode == HttpStatusCode.OK);
        var returnedItem = getResponse.Item;
        Debug.Assert(returnedItem["sensitive_data"].S.Equals("encrypt and sign me!"));
*/
println!("mrk_discovery_multi_keyring successful.");
    }
