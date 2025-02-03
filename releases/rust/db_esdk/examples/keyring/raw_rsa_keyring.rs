// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0

use crate::test_utils;
use aws_db_esdk::dynamodb::types::DynamoDbTableEncryptionConfig;
use aws_db_esdk::intercept::DbEsdkInterceptor;
use aws_db_esdk::material_providers::client as mpl_client;
use aws_db_esdk::material_providers::types::material_providers_config::MaterialProvidersConfig;
use aws_db_esdk::material_providers::types::PaddingScheme;
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

const EXAMPLE_RSA_PRIVATE_KEY_FILENAME: &str = "RawRsaKeyringExamplePrivateKey.pem";
const EXAMPLE_RSA_PUBLIC_KEY_FILENAME: &str = "RawRsaKeyringExamplePublicKey.pem";

pub async fn put_item_get_item() -> Result<(), crate::BoxError> {
    let ddb_table_name = test_utils::TEST_DDB_TABLE_NAME;

    // You may provide your own RSA key pair in the files located at
    //  - EXAMPLE_RSA_PRIVATE_KEY_FILENAME
    //  - EXAMPLE_RSA_PUBLIC_KEY_FILENAME
    // If these files are not present, this will generate a pair for you
    if should_generate_new_rsa_key_pair()? {
        generate_rsa_key_pair()?;
    }

    // 1. Load key pair from UTF-8 encoded PEM files.
    //    You may provide your own PEM files to use here.
    //    If you do not, the main method in this class will generate PEM
    //    files for example use. Do not use these files for any other purpose.

    let mut file = File::open(Path::new(EXAMPLE_RSA_PUBLIC_KEY_FILENAME))?;
    let mut public_key_utf8_bytes = Vec::new();
    file.read_to_end(&mut public_key_utf8_bytes)?;

    let mut file = File::open(Path::new(EXAMPLE_RSA_PRIVATE_KEY_FILENAME))?;
    let mut private_key_utf8_bytes = Vec::new();
    file.read_to_end(&mut private_key_utf8_bytes)?;

    // 2. Create the keyring.
    //    The DynamoDb encryption client uses this to encrypt and decrypt items.
    let mpl_config = MaterialProvidersConfig::builder().build()?;
    let mpl = mpl_client::Client::from_conf(mpl_config)?;
    let raw_rsa_keyring = mpl
        .create_raw_rsa_keyring()
        .key_name("my-rsa-key-name")
        .key_namespace("my-key-namespace")
        .padding_scheme(PaddingScheme::OaepSha256Mgf1)
        .public_key(public_key_utf8_bytes)
        .private_key(private_key_utf8_bytes)
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
    const UNSIGNED_ATTR_PREFIX: &str = ":";

    // 5. Create the DynamoDb Encryption configuration for the table we will be writing to.
    let table_config = DynamoDbTableEncryptionConfig::builder()
        .logical_table_name(ddb_table_name)
        .partition_key_name("partition_key")
        .sort_key_name("sort_key")
        .attribute_actions_on_encrypt(attribute_actions_on_encrypt)
        .keyring(raw_rsa_keyring)
        .allowed_unsigned_attribute_prefix(UNSIGNED_ATTR_PREFIX)
        .build()?;

    let table_configs = DynamoDbTablesEncryptionConfig::builder()
        .table_encryption_configs(HashMap::from([(ddb_table_name.to_string(), table_config)]))
        .build()?;

    // 6. Create a new AWS SDK DynamoDb client using the config above
    let sdk_config = aws_config::load_defaults(aws_config::BehaviorVersion::latest()).await;
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
            AttributeValue::S("rawRsaKeyringItem".to_string()),
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

    // 8. Get the item back from our table using the same client.
    //    The client will decrypt the item client-side, and return
    //    back the original item.

    let key_to_get = HashMap::from([
        (
            "partition_key".to_string(),
            AttributeValue::S("rawRsaKeyringItem".to_string()),
        ),
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
        .await?;

    assert_eq!(resp.item, Some(item));
    println!("raw_rsa_keyring successful.");
    Ok(())
}

fn exists(f: &str) -> bool {
    Path::new(f).exists()
}
fn should_generate_new_rsa_key_pair() -> Result<bool, String> {
    // If a key pair already exists: do not overwrite existing key pair
    if exists(EXAMPLE_RSA_PRIVATE_KEY_FILENAME) && exists(EXAMPLE_RSA_PUBLIC_KEY_FILENAME) {
        Ok(false)
    }
    // If only one file is present: throw exception
    else if exists(EXAMPLE_RSA_PRIVATE_KEY_FILENAME) && !exists(EXAMPLE_RSA_PUBLIC_KEY_FILENAME) {
        Err("Missing public key file at ".to_string() + EXAMPLE_RSA_PUBLIC_KEY_FILENAME)
    }
    // If a key pair already exists: do not overwrite existing key pair
    else if exists(EXAMPLE_RSA_PRIVATE_KEY_FILENAME) && !exists(EXAMPLE_RSA_PUBLIC_KEY_FILENAME) {
        Err("Missing private key file at ".to_string() + EXAMPLE_RSA_PRIVATE_KEY_FILENAME)
    }
    // If neither file is present, generate a new key pair
    else {
        Ok(true)
    }
}

fn generate_rsa_key_pair() -> Result<(), crate::BoxError> {
    use aws_lc_rs::encoding::AsDer;
    use aws_lc_rs::encoding::Pkcs8V1Der;
    use aws_lc_rs::encoding::PublicKeyX509Der;
    use aws_lc_rs::rsa::KeySize;
    use aws_lc_rs::rsa::PrivateDecryptingKey;

    // Safety check: Validate neither file is present
    if exists(EXAMPLE_RSA_PRIVATE_KEY_FILENAME) || exists(EXAMPLE_RSA_PUBLIC_KEY_FILENAME) {
        return Err(crate::BoxError(
            "generate_rsa_key_pair will not overwrite existing PEM files".to_string(),
        ));
    }

    // This code will generate a new RSA key pair for example use.
    // The public and private key will be written to the files:
    //  - public: EXAMPLE_RSA_PUBLIC_KEY_FILENAME
    //  - private: EXAMPLE_RSA_PRIVATE_KEY_FILENAME
    // This example uses aws-lc-rs's KeyPairGenerator to generate the key pair.
    // In practice, you should not generate this in your code, and should instead
    // retrieve this key from a secure key management system (e.g. HSM)
    // This key is created here for example purposes only.

    let private_key = PrivateDecryptingKey::generate(KeySize::Rsa2048)?;
    let public_key = private_key.public_key();

    let public_key = AsDer::<PublicKeyX509Der>::as_der(&public_key)?;
    let public_key = pem::Pem::new("RSA PUBLIC KEY", public_key.as_ref());
    let public_key = pem::encode(&public_key);

    let private_key = AsDer::<Pkcs8V1Der>::as_der(&private_key)?;
    let private_key = pem::Pem::new("RSA PRIVATE KEY", private_key.as_ref());
    let private_key = pem::encode(&private_key);

    std::fs::OpenOptions::new()
        .write(true)
        .create(true)
        .truncate(true)
        .open(Path::new(EXAMPLE_RSA_PRIVATE_KEY_FILENAME))?
        .write_all(private_key.as_bytes())?;

    std::fs::OpenOptions::new()
        .write(true)
        .create(true)
        .truncate(true)
        .open(Path::new(EXAMPLE_RSA_PUBLIC_KEY_FILENAME))?
        .write_all(public_key.as_bytes())?;

    Ok(())
}
