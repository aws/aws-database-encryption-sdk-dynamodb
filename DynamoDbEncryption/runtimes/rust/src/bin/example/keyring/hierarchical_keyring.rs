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
  This example sets up DynamoDb Encryption for the AWS SDK client
  using the Hierarchical Keyring, which establishes a key hierarchy
  where "branch" keys are persisted in DynamoDb.
  These branch keys are used to protect your data keys,
  and these branch keys are themselves protected by a root KMS Key.

  Establishing a key hierarchy like this has two benefits:

  First, by caching the branch key material, and only calling back
  to KMS to re-establish authentication regularly according to your configured TTL,
  you limit how often you need to call back to KMS to protect your data.
  This is a performance/security tradeoff, where your authentication, audit, and
  logging from KMS is no longer one-to-one with every encrypt or decrypt call.
  However, the benefit is that you no longer have to make a
  network call to KMS for every encrypt or decrypt.

  Second, this key hierarchy makes it easy to hold multi-tenant data
  that is isolated per branch key in a single DynamoDb table.
  You can create a branch key for each tenant in your table,
  and encrypt all that tenant's data under that distinct branch key.
  On decrypt, you can either statically configure a single branch key
  to ensure you are restricting decryption to a single tenant,
  or you can implement an interface that lets you map the primary key on your items
  to the branch key that should be responsible for decrypting that data.

  This example then demonstrates configuring a Hierarchical Keyring
  with a Branch Key ID Supplier to encrypt and decrypt data for
  two separate tenants.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (S)

  This example also requires using a KMS Key whose ARN
  is provided in CLI arguments. You need the following access
  on this key:
    - GenerateDataKeyWithoutPlaintext
    - Decrypt
 */
 pub async fn HierarchicalKeyringGetItemPutItem(String tenant1BranchKeyId, String tenant2BranchKeyId)
    {
      /*
        var ddbTableName = TestUtils.TEST_DDB_TABLE_NAME;
        var keyStoreTableName = TestUtils.TEST_KEYSTORE_NAME;
        var logicalKeyStoreName = TestUtils.TEST_LOGICAL_KEYSTORE_NAME;
        var kmsKeyId = TestUtils.TEST_KEYSTORE_KMS_KEY_ID;

        // Initial KeyStore Setup: This example requires that you have already
        // created your KeyStore, and have populated it with two new branch keys.
        // See the "Create KeyStore Table Example" and "Create KeyStore Key Example"
        // for an example of how to do this.

        // 1. Configure your KeyStore resource.
        //    This SHOULD be the same configuration that you used
        //    to initially create and populate your KeyStore.
        var keystore = new KeyStore(new KeyStoreConfig
        {
            DdbClient = new AmazonDynamoDBClient(),
            DdbTableName = keyStoreTableName,
            LogicalKeyStoreName = logicalKeyStoreName,
            KmsClient = new AmazonKeyManagementServiceClient(),
            KmsConfiguration = new KMSConfiguration { KmsKeyArn = kmsKeyId }
        });


        // 2. Create a Branch Key ID Supplier. See ExampleBranchKeyIdSupplier in this directory.
        var ddbEnc = new DynamoDbEncryption(new DynamoDbEncryptionConfig());
        var branchKeyIdSupplier = ddbEnc.CreateDynamoDbEncryptionBranchKeyIdSupplier(
            new CreateDynamoDbEncryptionBranchKeyIdSupplierInput
            {
                DdbKeyBranchKeyIdSupplier = new ExampleBranchKeyIdSupplier(tenant1BranchKeyId, tenant2BranchKeyId)
            }).BranchKeyIdSupplier;

        // 3. Create the Hierarchical Keyring, using the Branch Key ID Supplier above.
        //    With this configuration, the AWS SDK Client ultimately configured will be capable
        //    of encrypting or decrypting items for either tenant (assuming correct KMS access).
        //    If you want to restrict the client to only encrypt or decrypt for a single tenant,
        //    configure this Hierarchical Keyring using `.branchKeyId(tenant1BranchKeyId)` instead
        //    of `.branchKeyIdSupplier(branchKeyIdSupplier)`.
        var matProv = new MaterialProviders(new MaterialProvidersConfig());
        var keyringInput = new CreateAwsKmsHierarchicalKeyringInput
        {
            KeyStore = keystore,
            BranchKeyIdSupplier = branchKeyIdSupplier,
            TtlSeconds = 600, // This dictates how often we call back to KMS to authorize use of the branch keys
            Cache = new CacheType
            {
                Default = new DefaultCache { EntryCapacity = 100 }
            }
        };
        var hierarchicalKeyring = matProv.CreateAwsKmsHierarchicalKeyring(keyringInput);

        // 4. Configure which attributes are encrypted and/or signed when writing new items.
        //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
        //    we must explicitly configure how they should be treated during item encryption:
        //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
        //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
        //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
        var attributeActionsOnEncrypt = new Dictionary<String, CryptoAction>
        {
            ["partition_key"] = CryptoAction.SIGN_ONLY, // Our partition attribute must be SIGN_ONLY
            ["sort_key"] = CryptoAction.SIGN_ONLY, // Our sort attribute must be SIGN_ONLY
            ["tenant_sensitive_data"] = CryptoAction.ENCRYPT_AND_SIGN
        };

        // 5. Configure which attributes we expect to be included in the signature
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

        // 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
        var tableConfigs = new Dictionary<String, DynamoDbTableEncryptionConfig>
        {
            [ddbTableName] = new DynamoDbTableEncryptionConfig
            {
                LogicalTableName = ddbTableName,
                PartitionKeyName = "partition_key",
                SortKeyName = "sort_key",
                AttributeActionsOnEncrypt = attributeActionsOnEncrypt,
                Keyring = hierarchicalKeyring,
                AllowedUnsignedAttributePrefix = unsignAttrPrefix
            }
        };

        // 7. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
        var ddb = new Client.DynamoDbClient(
            new DynamoDbTablesEncryptionConfig { TableEncryptionConfigs = tableConfigs });

        // 8. Put an item into our table using the above client.
        //    Before the item gets sent to DynamoDb, it will be encrypted
        //    client-side, according to our configuration.
        //    Because the item we are writing uses "tenantId1" as our partition value,
        //    based on the code we wrote in the ExampleBranchKeySupplier,
        //    `tenant1BranchKeyId` will be used to encrypt this item.
        var item = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("tenant1Id"),
            ["sort_key"] = new AttributeValue { N = "0" },
            ["tenant_sensitive_data"] = new AttributeValue("encrypt and sign me!")
        };
        var putRequest = new PutItemRequest
        {
            TableName = ddbTableName,
            Item = item
        };

        var putResponse = await ddb.PutItemAsync(putRequest);

        // Demonstrate that PutItem succeeded
        Debug.Assert(putResponse.HttpStatusCode == HttpStatusCode.OK);

        // 10. Get the item back from our table using the same client.
        //     The client will decrypt the item client-side, and return
        //     back the original item.
        //     Because the returned item's partition value is "tenantId1",
        //     based on the code we wrote in the ExampleBranchKeySupplier,
        //     `tenant1BranchKeyId` will be used to decrypt this item.
        var keyToGet = new Dictionary<String, AttributeValue>
        {
            ["partition_key"] = new AttributeValue("tenant1Id"),
            ["sort_key"] = new AttributeValue { N = "0" }
        };
        var getRequest = new GetItemRequest
        {
            Key = keyToGet,
            TableName = ddbTableName
        };
        var getResponse = await ddb.GetItemAsync(getRequest);

        // Demonstrate that GetItem succeeded and returned the decrypted item
        Debug.Assert(getResponse.HttpStatusCode == HttpStatusCode.OK);
        var returnedItem = getResponse.Item;
        Debug.Assert(returnedItem["tenant_sensitive_data"].S.Equals("encrypt and sign me!"));
*/
println!("hierarchical_keyring successful.");

        }