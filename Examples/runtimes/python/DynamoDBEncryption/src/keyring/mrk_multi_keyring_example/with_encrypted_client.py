# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDb Encryption using an MRK multi-keyring configuration.

The MRK multi-keyring accepts multiple AWS KMS MRKs (multi-region keys) or regular
AWS KMS keys (single-region keys) and uses them to encrypt and decrypt data. Data
encrypted using an MRK multi-keyring can be decrypted using any of its component
keys. If a component key is an MRK with a replica in a second region, the replica
key can also be used to decrypt data.

For more information on MRKs and multi-keyrings, see:
- MRKs: https://docs.aws.amazon.com/kms/latest/developerguide/multi-region-keys-overview.html
- Multi-keyrings: https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-multi-keyring.html

The example creates a new MRK multi-keyring consisting of one MRK (labeled as the
"generator keyring") and one single-region key (labeled as the only "child keyring").
The MRK also has a replica in a second region.

The example encrypts a test item using the MRK multi-keyring and puts the encrypted
item to the provided DynamoDb table. Then, it gets the item from the table and
decrypts it using three different configs:
  1. The MRK multi-keyring, where the MRK key is used to decrypt
  2. Another MRK multi-keyring, where the replica MRK key is used to decrypt
  3. Another MRK multi-keyring, where the single-region key that was present
     in the original MRK multi-keyring is used to decrypt

Running this example requires access to the DDB Table whose name is provided in
CLI arguments. This table must be configured with the following primary key
configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)

Since this example demonstrates multi-region use cases, it requires a default
region set in your AWS client. You can set a default region through the AWS CLI:
  aws configure set region [region-name]
For example:
  aws configure set region us-west-2

For more information on using AWS CLI to set config, see:
https://awscli.amazonaws.com/v2/documentation/api/latest/reference/configure/set.html
"""
import boto3
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateAwsKmsMrkMultiKeyringInput,
)
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.structures.dynamodb import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import (
    CryptoAction,
)


def multi_mrk_keyring_client_example(ddb_table_name: str, mrk_key_arn: str, key_arn: str, mrk_replica_key_arn: str):
    """
    Demonstrate using a MRK multi-keyring with EncryptedClient.

    :param ddb_table_name: The name of the DynamoDB table
    :param mrk_key_arn: The ARN of the MRK key to use as generator
    :param key_arn: The ARN of the single-region key to use as child
    :param mrk_replica_key_arn: The ARN of the MRK replica key
    """
    # 1. Create a single MRK multi-keyring using the MRK arn and the single-region key arn.
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    # Create the multi-keyring, using the MRK as the generator key,
    #   and the single-region key as a child key.
    # Note that the generator key will generate and encrypt a plaintext data key
    #   and all child keys will only encrypt that same plaintext data key.
    # As such, you must have permission to call KMS:GenerateDataKey on your generator key
    #   and permission to call KMS:Encrypt on all child keys.
    # For more information, see the AWS docs on multi-keyrings above.
    aws_kms_mrk_multi_keyring = mat_prov.create_aws_kms_mrk_multi_keyring(
        input=CreateAwsKmsMrkMultiKeyringInput(generator=mrk_key_arn, kms_key_ids=[key_arn])
    )

    # 2. Configure which attributes are encrypted and/or signed when writing new items.
    #    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    #    we must explicitly configure how they should be treated during item encryption:
    #      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    #      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    #      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    attribute_actions_on_encrypt = {
        "partition_key": CryptoAction.SIGN_ONLY,  # Our partition attribute must be SIGN_ONLY
        "sort_key": CryptoAction.SIGN_ONLY,  # Our sort attribute must be SIGN_ONLY
        "sensitive_data": CryptoAction.ENCRYPT_AND_SIGN,
    }

    # 3. Configure which attributes we expect to be included in the signature
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
    #        you can easily make the corresponding update to your `attribute_actions_on_encrypt`
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

    # 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions_on_encrypt,
        keyring=aws_kms_mrk_multi_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    table_configs = {ddb_table_name: table_config}
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # 5. Create the EncryptedClient
    ddb_client = boto3.client("dynamodb")
    encrypted_ddb_client = EncryptedClient(client=ddb_client, encryption_config=tables_config)

    # 6. Put an item into our table using the above client.
    #    Before the item gets sent to DynamoDb, it will be encrypted
    #    client-side using the MRK multi-keyring.
    #    The data key protecting this item will be encrypted
    #    with all the KMS Keys in this keyring, so that it can be
    #    decrypted with any one of those KMS Keys.
    item = {
        "partition_key": {"S": "awsKmsMrkMultiKeyringItem"},
        "sort_key": {"N": "0"},
        "sensitive_data": {"S": "encrypt and sign me!"},
    }

    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 7. Get the item back from our table using the client.
    #    The client will decrypt the item client-side using the MRK
    #    and return back the original item.
    #    Since the generator key is the first available key in the keyring,
    #    that is the KMS Key that will be used to decrypt this item.
    key_to_get = {"partition_key": {"S": "awsKmsMrkMultiKeyringItem"}, "sort_key": {"N": "0"}}

    get_response = encrypted_ddb_client.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["sensitive_data"]["S"] == "encrypt and sign me!"

    # 8. Create a MRK keyring using the replica MRK arn.
    #    We will use this to demonstrate that the replica MRK
    #    can decrypt data created with the original MRK,
    #    even when the replica MRK was not present in the
    #    encrypting multi-keyring.
    only_replica_key_mrk_multi_keyring = mat_prov.create_aws_kms_mrk_multi_keyring(
        input=CreateAwsKmsMrkMultiKeyringInput(kms_key_ids=[mrk_replica_key_arn])
    )

    # 9. Create a new config and client using the MRK keyring.
    #    This is the same setup as above, except we provide the MRK keyring to the config.
    only_replica_key_table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions_on_encrypt,
        keyring=only_replica_key_mrk_multi_keyring,  # Only replica keyring added here
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    only_replica_key_table_configs = {ddb_table_name: only_replica_key_table_config}
    only_replica_key_tables_config = DynamoDbTablesEncryptionConfig(
        table_encryption_configs=only_replica_key_table_configs
    )

    only_replica_key_encrypted_ddb_client = EncryptedClient(
        client=ddb_client, encryption_config=only_replica_key_tables_config
    )

    # 10. Get the item back from our table using the client configured with the replica.
    #     The client will decrypt the item client-side using the replica MRK
    #     and return back the original item.
    only_replica_key_get_response = only_replica_key_encrypted_ddb_client.get_item(
        TableName=ddb_table_name, Key=key_to_get
    )

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert only_replica_key_get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    only_replica_key_returned_item = only_replica_key_get_response["Item"]
    assert only_replica_key_returned_item["sensitive_data"]["S"] == "encrypt and sign me!"

    # 11. Create an AWS KMS keyring using the single-region key ARN.
    #     We will use this to demonstrate that the single-region key
    #     can decrypt data created with the MRK multi-keyring,
    #     since it is present in the keyring used to encrypt.
    only_srk_keyring = mat_prov.create_aws_kms_mrk_multi_keyring(
        input=CreateAwsKmsMrkMultiKeyringInput(kms_key_ids=[key_arn])
    )

    # 12. Create a new config and client using the AWS KMS keyring.
    #     This is the same setup as above, except we provide the AWS KMS keyring to the config.
    only_srk_table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions_on_encrypt,
        keyring=only_srk_keyring,  # Only single-region key keyring added here
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    only_srk_table_configs = {ddb_table_name: only_srk_table_config}
    only_srk_tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=only_srk_table_configs)

    only_srk_encrypted_ddb_client = EncryptedClient(client=ddb_client, encryption_config=only_srk_tables_config)

    # 13. Get the item back from our table using the client configured with the AWS KMS keyring.
    #     The client will decrypt the item client-side using the single-region key
    #     and return back the original item.
    only_srk_get_response = only_srk_encrypted_ddb_client.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert only_srk_get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    only_srk_returned_item = only_srk_get_response["Item"]
    assert only_srk_returned_item["sensitive_data"]["S"] == "encrypt and sign me!"
