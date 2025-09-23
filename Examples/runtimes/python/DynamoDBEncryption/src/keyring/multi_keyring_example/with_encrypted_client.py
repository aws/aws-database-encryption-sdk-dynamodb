# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDb Encryption using a multi-keyring configuration with EncryptedClient.

A multi-keyring accepts multiple keyrings and uses them to encrypt and decrypt data.
Data encrypted with a multi-keyring can be decrypted with any of its component keyrings.

For more information on multi-keyrings, see:
https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-multi-keyring.html

The example creates a multi-keyring consisting of an AWS KMS keyring (labeled the
"generator keyring") and a raw AES keyring (labeled as the only "child keyring").
It encrypts a test item using the multi-keyring and puts the encrypted item to the
provided DynamoDb table. Then, it gets the item from the table and decrypts it
using only the raw AES keyring.

The example takes an `aes_key_bytes` parameter representing a 256-bit AES key.
If run through the class's main method, it will create a new key. In practice,
users should not randomly generate a key, but instead retrieve an existing key
from a secure key management system (e.g. an HSM).

Running this example requires access to the DDB Table whose name is provided in
CLI arguments. This table must be configured with the following primary key
configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""
import boto3
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    AesWrappingAlg,
    CreateAwsKmsMrkMultiKeyringInput,
    CreateMultiKeyringInput,
    CreateRawAesKeyringInput,
)
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.structures.dynamodb import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import (
    CryptoAction,
)


def multi_keyring_client_example(ddb_table_name: str, key_arn: str, aes_key_bytes: bytes):
    """
    Demonstrate using a multi-keyring.

    :param ddb_table_name: The name of the DynamoDB table
    :param key_arn: The ARN of the KMS key to use
    :param aes_key_bytes: The AES key bytes to use
    """
    # 1. Create the raw AES keyring.
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    raw_aes_keyring_input = CreateRawAesKeyringInput(
        key_name="my-aes-key-name",
        key_namespace="my-key-namespace",
        wrapping_key=aes_key_bytes,
        wrapping_alg=AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16,
    )

    raw_aes_keyring = mat_prov.create_raw_aes_keyring(input=raw_aes_keyring_input)

    # 2. Create the AWS KMS keyring.
    #    We create a MRK multi keyring, as this interface also supports
    #    single-region KMS keys (standard KMS keys),
    #    and creates the KMS client for us automatically.
    aws_kms_mrk_multi_keyring = mat_prov.create_aws_kms_mrk_multi_keyring(
        input=CreateAwsKmsMrkMultiKeyringInput(generator=key_arn)
    )

    # 3. Create the multi-keyring.
    #    We will label the AWS KMS keyring as the generator and the raw AES keyring as the
    #        only child keyring.
    #    You must provide a generator keyring to encrypt data.
    #    You may provide additional child keyrings. Each child keyring will be able to
    #        decrypt data encrypted with the multi-keyring on its own. It does not need
    #        knowledge of any other child keyrings or the generator keyring to decrypt.
    multi_keyring = mat_prov.create_multi_keyring(
        input=CreateMultiKeyringInput(generator=aws_kms_mrk_multi_keyring, child_keyrings=[raw_aes_keyring])
    )

    # 4. Configure which attributes are encrypted and/or signed when writing new items.
    #    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    #    we must explicitly configure how they should be treated during item encryption:
    #      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    #      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    #      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    attribute_actions = {
        "partition_key": CryptoAction.SIGN_ONLY,  # Our partition attribute must be SIGN_ONLY
        "sort_key": CryptoAction.SIGN_ONLY,  # Our sort attribute must be SIGN_ONLY
        "sensitive_data": CryptoAction.ENCRYPT_AND_SIGN,
    }

    # 5. Configure which attributes we expect to be included in the signature
    #    when reading items. There are two options for configuring this:
    #
    #    - (Recommended) Configure `allowed_unsigned_attribute_prefix`:
    #      When defining your DynamoDb schema and deciding on attribute names,
    #      choose a distinguishing prefix (such as ":") for all attributes that
    #      you do not want to include in the signature.
    #      This has two main benefits:
    #      - It is easier to reason about the security and authenticity of data within your item
    #        when all unauthenticated data is easily distinguishable by their attribute name.
    #      - If you need to add new unauthenticated attributes in the future,
    #        you can easily make the corresponding update to your `attribute_actions`
    #        and immediately start writing to that new attribute, without
    #        any other configuration update needed.
    #      Once you configure this field, it is not safe to update it.
    #
    #    - Configure `allowed_unsigned_attributes`: You may also explicitly list
    #      a set of attributes that should be considered unauthenticated when encountered
    #      on read. Be careful if you use this configuration. Do not remove an attribute
    #      name from this configuration, even if you are no longer writing with that attribute,
    #      as old items may still include this attribute, and our configuration needs to know
    #      to continue to exclude this attribute from the signature scope.
    #      If you add new attribute names to this field, you must first deploy the update to this
    #      field to all readers in your host fleet before deploying the update to start writing
    #      with that new attribute.
    #
    #   For this example, we currently authenticate all attributes. To make it easier to
    #   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
    unsign_attr_prefix = ":"

    # 6. Create the DynamoDb Encryption configuration for the table we will be writing to.
    #    Note that this example creates one config/client combination for PUT, and another
    #        for GET. The PUT config uses the multi-keyring, while the GET config uses the
    #        raw AES keyring. This is solely done to demonstrate that a keyring included as
    #        a child of a multi-keyring can be used to decrypt data on its own.
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions,
        keyring=multi_keyring,  # Multi-keyring is added here
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    table_configs = {ddb_table_name: table_config}
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # 7. Create the EncryptedClient
    ddb_client = boto3.client("dynamodb")
    encrypted_ddb_client = EncryptedClient(client=ddb_client, encryption_config=tables_config)

    # 8. Put an item into our table using the above client.
    #    Before the item gets sent to DynamoDb, it will be encrypted
    #    client-side using the multi-keyring.
    #    The item will be encrypted with all wrapping keys in the keyring,
    #    so that it can be decrypted with any one of the keys.
    item = {
        "partition_key": {"S": "multiKeyringItem"},
        "sort_key": {"N": "0"},
        "sensitive_data": {"S": "encrypt and sign me!"},
    }

    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 9. Get the item back from our table using the above client.
    #    The client will decrypt the item client-side using the AWS KMS
    #    keyring, and return back the original item.
    #    Since the generator key is the first available key in the keyring,
    #    that is the key that will be used to decrypt this item.
    key_to_get = {"partition_key": {"S": "multiKeyringItem"}, "sort_key": {"N": "0"}}

    get_response = encrypted_ddb_client.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["sensitive_data"]["S"] == "encrypt and sign me!"

    # 10. Create a new config and client with only the raw AES keyring to GET the item
    #     This is the same setup as above, except the config uses the `raw_aes_keyring`.
    only_aes_keyring_table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions,
        keyring=raw_aes_keyring,  # Raw AES keyring is added here
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    only_aes_keyring_table_configs = {ddb_table_name: only_aes_keyring_table_config}
    only_aes_keyring_tables_config = DynamoDbTablesEncryptionConfig(
        table_encryption_configs=only_aes_keyring_table_configs
    )

    only_aes_keyring_encrypted_ddb_client = EncryptedClient(
        client=ddb_client, encryption_config=only_aes_keyring_tables_config
    )

    # 11. Get the item back from our table using the client
    #     configured with only the raw AES keyring.
    #     The client will decrypt the item client-side using the raw
    #     AES keyring, and return back the original item.
    only_aes_keyring_get_response = only_aes_keyring_encrypted_ddb_client.get_item(
        TableName=ddb_table_name, Key=key_to_get
    )

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert only_aes_keyring_get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    only_aes_keyring_returned_item = only_aes_keyring_get_response["Item"]
    assert only_aes_keyring_returned_item["sensitive_data"]["S"] == "encrypt and sign me!"
