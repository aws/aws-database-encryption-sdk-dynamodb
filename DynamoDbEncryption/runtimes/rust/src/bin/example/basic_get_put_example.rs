

use std::collections::HashMap;
use crate::test_utils;
use aws_sdk_dynamodb::types::AttributeValue;

use db_esdk::deps::aws_cryptography_materialProviders::types::material_providers_config::MaterialProvidersConfig;
use db_esdk::deps::aws_cryptography_materialProviders::client;
use db_esdk::deps::aws_cryptography_dbEncryptionSdk_structuredEncryption::types::CryptoAction;

use db_esdk::deps::aws_cryptography_dbEncryptionSdk_dynamoDb::types::DynamoDbTableEncryptionConfig;
use db_esdk::deps::aws_cryptography_materialProviders::types::DbeAlgorithmSuiteId;
use db_esdk::intercept::DbEsdkInterceptor;
use db_esdk::types::dynamo_db_tables_encryption_config::DynamoDbTablesEncryptionConfig;

/*
  This example sets up DynamoDb Encryption for the AWS SDK client
  and uses the low level PutItem and GetItem DDB APIs to demonstrate
  putting a client-side encrypted item into DynamoDb
  and then retrieving and decrypting that item from DynamoDb.

  Running this example requires access to the DDB Table whose name
  is provided in CLI arguments.
  This table must be configured with the following
  primary key configuration:
    - Partition key is named "partition_key" with type (S)
    - Sort key is named "sort_key" with type (N)
 */

pub async fn put_item_get_item()
{
  let kms_key_id = test_utils::TEST_KMS_KEY_ID;
  let ddb_table_name = test_utils::TEST_DDB_TABLE_NAME;

  // 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
  //    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
  //    We will use the `CreateMrkMultiKeyring` method to create this keyring,
  //    as it will correctly handle both single region and Multi-Region KMS Keys.
  let provider_config = MaterialProvidersConfig::builder().build().unwrap();
  let mat_prov = client::Client::from_conf(provider_config).unwrap();
  let kms_keyring = mat_prov.create_aws_kms_mrk_multi_keyring().generator(kms_key_id).send().await.unwrap();


  // 2. Configure which attributes are encrypted and/or signed when writing new items.
  //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
  //    we must explicitly configure how they should be treated during item encryption:
  //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
  //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
  //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
  let attribute_actions_on_encrypt = HashMap::from([
    ("partition_key".to_string(), CryptoAction::SignOnly),
    ("sort_key".to_string(), CryptoAction::SignOnly),
    ("attribute1".to_string(), CryptoAction::EncryptAndSign),
    ("attribute2".to_string(), CryptoAction::SignOnly),
    (":attribute3".to_string(), CryptoAction::DoNothing),
  ]);

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
  const UNSIGNED_ATTR_PREFIX : &str = ":";

  // 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
  let table_config = DynamoDbTableEncryptionConfig::builder()
    .logical_table_name(ddb_table_name)
    .partition_key_name("partition_key")
    .sort_key_name("sort_key")
    .attribute_actions_on_encrypt(attribute_actions_on_encrypt)
    .keyring(kms_keyring)
    .allowed_unsigned_attribute_prefix(UNSIGNED_ATTR_PREFIX)
      // Specifying an algorithm suite is not required,
      // but is done here to demonstrate how to do so.
      // We suggest using the
      // `ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384` suite,
      // which includes AES-GCM with key derivation, signing, and key commitment.
      // This is also the default algorithm suite if one is not specified in this config.
      // For more information on supported algorithm suites, see:
      //   https://docs.aws.amazon.com/database-encryption-sdk/latest/devguide/supported-algorithms.html
    .algorithm_suite_id(DbeAlgorithmSuiteId::AlgAes256GcmHkdfSha512CommitKeyEcdsaP384SymsigHmacSha384)
    .build().unwrap();

  let table_configs = DynamoDbTablesEncryptionConfig::builder()
    .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
    .build()
    .unwrap();

    // 5. Create a new AWS SDK DynamoDb client using the TableEncryptionConfigs
  let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
  let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
      .interceptor(DbEsdkInterceptor::new(table_configs))
      .build();
  let ddb = aws_sdk_dynamodb::Client::from_conf(dynamo_config);

  // 6. Put an item into our table using the above client.
  //    Before the item gets sent to DynamoDb, it will be encrypted
  //    client-side, according to our configuration.
  let item = HashMap::from([
    ("partition_key".to_string(), AttributeValue::S("BasicPutGetExample".to_string())),
    ("sort_key".to_string(), AttributeValue::N("0".to_string())),
    ("attribute1".to_string(), AttributeValue::S("encrypt and sign me!".to_string())),
    ("attribute2".to_string(), AttributeValue::S("sign me!".to_string())),
    (":attribute3".to_string(), AttributeValue::S("ignore me!".to_string())),
  ]);

  let _resp = ddb
    .put_item()
    .table_name(ddb_table_name)
    .set_item(Some(item.clone()))
    .send()
    .await
    .unwrap();

    // 7. Get the item back from our table using the same client.
    //    The client will decrypt the item client-side, and return
    //    back the original item.
    let key_to_get = HashMap::from([
      ("partition_key".to_string(), AttributeValue::S("BasicPutGetExample".to_string())),
      ("sort_key".to_string(), AttributeValue::N("0".to_string())),
    ]);

    let resp = ddb
      .get_item()
      .table_name(ddb_table_name)
      .set_key(Some(key_to_get))
        // In this example we configure a strongly consistent read
        // because we perform a read immediately after a write (for demonstrative purposes).
        // By default, reads are only eventually consistent.
        // Read our docs to determine which read consistency to use for your application:
        // https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.ReadConsistency.html
      .consistent_read(true)
      .send()
      .await
      .unwrap();

      assert_eq!(resp.item, Some(item));
      println!("put_item_get_item Successful.");
  }
  