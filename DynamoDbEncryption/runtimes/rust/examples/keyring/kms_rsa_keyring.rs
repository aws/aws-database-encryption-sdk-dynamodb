// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use aws_db_esdk::dynamodb::types::DynamoDbTableEncryptionConfig;
use aws_db_esdk::intercept::DbEsdkInterceptor;
use aws_db_esdk::material_providers::client as mpl_client;
use aws_db_esdk::material_providers::types::material_providers_config::MaterialProvidersConfig;
use aws_db_esdk::material_providers::types::DbeAlgorithmSuiteId;
use aws_db_esdk::CryptoAction;
use aws_db_esdk::DynamoDbTablesEncryptionConfig;
use aws_sdk_dynamodb::types::AttributeValue;
use std::collections::HashMap;
use std::fs::File;
use std::io::Read;
use std::io::Write;
use std::path::Path;

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

const DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME: &str = "KmsRsaKeyringExamplePublicKey.pem";

pub async fn put_item_get_item() -> Result<(), crate::BoxError> {
    let ddb_table_name = test_utils::TEST_DDB_TABLE_NAME;
    let rsa_key_arn = test_utils::TEST_KMS_RSA_KEY_ID;

    // You may provide your own RSA public key at EXAMPLE_RSA_PUBLIC_KEY_FILENAME.
    // This must be the public key for the RSA key represented at rsaKeyArn.
    // If this file is not present, this will write a UTF-8 encoded PEM file for you.
    if should_get_new_public_key(DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME) {
        write_public_key_pem_for_rsa_key(
            test_utils::TEST_KMS_RSA_KEY_ID,
            DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME,
        )
        .await?;
    }

    // 1. Load UTF-8 encoded public key PEM file.
    //    You may have an RSA public key file already defined.
    //    If not, the main method in this class will call
    //    the KMS RSA key, retrieve its public key, and store it
    //    in a PEM file for example use.
    let mut file = File::open(Path::new(DEFAULT_EXAMPLE_RSA_PUBLIC_KEY_FILENAME))?;
    let mut public_key_utf8_bytes = Vec::new();
    file.read_to_end(&mut public_key_utf8_bytes)?;

    // 2. Create a KMS RSA keyring.
    //    This keyring takes in:
    //     - kmsClient
    //     - kmsKeyId: Must be an ARN representing a KMS RSA key
    //     - publicKey: A ByteBuffer of a UTF-8 encoded PEM file representing the public
    //                  key for the key passed into kmsKeyId
    //     - encryptionAlgorithm: Must be either RSAES_OAEP_SHA_256 or RSAES_OAEP_SHA_1
    let mpl_config = MaterialProvidersConfig::builder().build()?;
    let mpl = mpl_client::Client::from_conf(mpl_config)?;
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let kms_rsa_keyring = mpl
        .create_aws_kms_rsa_keyring()
        .kms_key_id(rsa_key_arn)
        .public_key(public_key_utf8_bytes)
        .encryption_algorithm(aws_sdk_kms::types::EncryptionAlgorithmSpec::RsaesOaepSha256)
        .kms_client(aws_sdk_kms::Client::new(&sdk_config))
        .send()
        .await?;

    // 3. Configure which attributes are encrypted and/or signed when writing new items.
    //    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    //    we must explicitly configure how they should be treated during item encryption:
    //      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    //      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    //      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    let attribute_actions_on_encrypt = HashMap::from([
        ("partition_key".to_string(), CryptoAction::SignOnly), // Our partition attribute must be SIGN_ONLY
        ("sort_key".to_string(), CryptoAction::SignOnly), // Our sort attribute must be SIGN_ONLY
        ("sensitive_data".to_string(), CryptoAction::EncryptAndSign),
    ]);

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
    const UNSIGNED_ATTR_PREFIX: &str = ":";

    // 5. Create the DynamoDb Encryption configuration for the table we will be writing to.
    //    Note: To use the KMS RSA keyring, your table config must specify an algorithmSuite
    //    that does not use asymmetric signing.
    let table_config = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("partition_key")
        .sort_key_name("sort_key")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt)
        .keyring(kms_rsa_keyring)
        .allowed_unsigned_attribute_prefix(UNSIGNED_ATTR_PREFIX)
        // Specify algorithmSuite without asymmetric signing here
        // As of v3.0.0, the only supported algorithmSuite without asymmetric signing is
        // ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_SYMSIG_HMAC_SHA384.
        .algorithm_suite_id(DbeAlgorithmSuiteId::AlgAes256GcmHkdfSha512CommitKeySymsigHmacSha384)
        .build()?;

    let table_configs = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
        .build()?;

    // 6. Create a new AWS SDK DynamoDb client using the DynamoDb Encryption Interceptor above
    let dynamo_config = aws_sdk_dynamodb::config::Builder::from(&sdk_config)
        .interceptor(DbEsdkInterceptor::new(table_configs)?)
        .build();
    let ddb = aws_sdk_dynamodb::Client::from_conf(dynamo_config);

    // 7. Put an item into our table using the above client.
    //    Before the item gets sent to DynamoDb, it will be encrypted
    //    client-side, according to our configuration.
    let item = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("awsKmsRsaKeyringItem".to_string()),
        ),
        ("sort_key".to_string(), AttributeValue::N("0".to_string())),
        (
            "sensitive_data".to_string(),
            AttributeValue::S("encrypt and sign me!".to_string()),
        ),
    ]);

    ddb.put_item()
        .table_name(ddb_table_name)
        .set_item(Some(item.clone()))
        .send()
        .await?;

    // 8. Get the item back from our table using the client.
    //    The client will decrypt the item client-side using the RSA keyring
    //    and return the original item.
    let key_to_get = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("awsKmsRsaKeyringItem".to_string()),
        ),
        ("sort_key".to_string(), AttributeValue::N("0".to_string())),
    ]);

    let resp = ddb
        .get_item()
        .table_name(ddb_table_name)
        .set_key(Some(key_to_get))
        .consistent_read(true)
        .send()
        .await?;

    assert_eq!(resp.item, Some(item));
    println!("kms_rsa_keyring successful.");
    Ok(())
}

fn should_get_new_public_key(rsa_public_key_filename: &str) -> bool {
    // Check if a public key file already exists
    !Path::new(rsa_public_key_filename).exists()
}

async fn write_public_key_pem_for_rsa_key(
    rsa_key_arn: &str,
    rsa_public_key_filename: &str,
) -> Result<(), crate::BoxError> {
    // Safety check: Validate file is not present
    if Path::new(rsa_public_key_filename).exists() {
        return Err(crate::BoxError(
            "write_public_key_pem_for_rsa_key will not overwrite existing PEM files.".to_string(),
        ));
    }

    // This code will call KMS to get the public key for the KMS RSA key.
    // You must have kms:GetPublicKey permissions on the key for this to succeed.
    // The public key will be written to the file EXAMPLE_RSA_PUBLIC_KEY_FILENAME.
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
    let getter_for_public_key = aws_sdk_kms::Client::new(&sdk_config);

    let response = getter_for_public_key
        .get_public_key()
        .key_id(rsa_key_arn)
        .send()
        .await?;

    let public_key_bytes = response.public_key.unwrap().into_inner();

    let public_key = pem::Pem::new("PUBLIC KEY", public_key_bytes);
    let public_key = pem::encode(&public_key);

    std::fs::OpenOptions::new()
        .write(true)
        .create(true)
        .truncate(true)
        .open(Path::new(rsa_public_key_filename))?
        .write_all(public_key.as_bytes())?;

    Ok(())
}
