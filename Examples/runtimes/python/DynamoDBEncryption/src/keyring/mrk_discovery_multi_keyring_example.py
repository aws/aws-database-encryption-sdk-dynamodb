# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDb Encryption using a MRK discovery multi-keyring.

A discovery keyring is not provided with any wrapping keys; instead, it recognizes
the KMS key that was used to encrypt a data key, and asks KMS to decrypt with that
KMS key. Discovery keyrings cannot be used to encrypt data.

For more information on discovery keyrings, see:
https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-keyring.html#kms-keyring-discovery

The example encrypts an item using an MRK multi-keyring and puts the encrypted
item to the configured DynamoDb table. Then, it gets the item from the table and
decrypts it using the discovery keyring.

Running this example requires access to the DDB Table whose name is provided in
CLI arguments. This table must be configured with the following primary key
configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (S)
"""
from typing import List

import boto3
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateAwsKmsMrkDiscoveryMultiKeyringInput,
    CreateAwsKmsMrkMultiKeyringInput,
    DiscoveryFilter,
)
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.structures.dynamodb import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import (
    CryptoAction,
)


def multi_mrk_discovery_keyring_get_item_put_item(
    ddb_table_name: str, key_arn: str, account_ids: List[str], regions: List[str]
):
    """
    Demonstrate using a MRK discovery multi-keyring.

    :param ddb_table_name: The name of the DynamoDB table
    :param key_arn: The ARN of the KMS key to use for encryption
    :param account_ids: List of AWS account IDs for discovery filter
    :param regions: List of AWS regions for discovery keyring
    """
    # 1. Create a single MRK multi-keyring using the key arn.
    #    Although this example demonstrates use of the MRK discovery multi-keyring,
    #    a discovery keyring cannot be used to encrypt. So we will need to construct
    #    a non-discovery keyring for this example to encrypt. For more information on MRK
    #    multi-keyrings, see the MultiMrkKeyringExample in this directory.
    #    Though this is an "MRK multi-keyring", we do not need to provide multiple keys,
    #    and can use single-region KMS keys. We will provide a single key here; this
    #    can be either an MRK or a single-region key.
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    encrypt_keyring = mat_prov.create_aws_kms_mrk_multi_keyring(
        input=CreateAwsKmsMrkMultiKeyringInput(generator=key_arn)
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
        keyring=encrypt_keyring,
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
    item = {
        "partition_key": {"S": "awsKmsMrkDiscoveryMultiKeyringItem"},
        "sort_key": {"N": "0"},
        "sensitive_data": {"S": "encrypt and sign me!"},
    }

    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 7. Construct a discovery filter.
    #    A discovery filter limits the set of encrypted data keys
    #    the keyring can use to decrypt data.
    #    We will only let the keyring use keys in the selected AWS accounts
    #    and in the `aws` partition.
    #    This is the suggested config for most users; for more detailed config, see
    #      https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/use-kms-keyring.html#kms-keyring-discovery
    discovery_filter = DiscoveryFilter(partition="aws", account_ids=account_ids)

    # 8. Construct a discovery keyring.
    #    Note that we choose to use the MRK discovery multi-keyring, even though
    #    our original keyring used a single KMS key.
    decrypt_keyring = mat_prov.create_aws_kms_mrk_discovery_multi_keyring(
        input=CreateAwsKmsMrkDiscoveryMultiKeyringInput(discovery_filter=discovery_filter, regions=regions)
    )

    # 9. Create new DDB config and client using the decrypt discovery keyring.
    #    This is the same as the above config, except we pass in the decrypt keyring.
    table_config_for_decrypt = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions_on_encrypt,
        # Add decrypt keyring here
        keyring=decrypt_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    table_configs_for_decrypt = {ddb_table_name: table_config_for_decrypt}
    tables_config_for_decrypt = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs_for_decrypt)

    encrypted_ddb_client_for_decrypt = EncryptedClient(client=ddb_client, encryption_config=tables_config_for_decrypt)

    # 10. Get the item back from our table using the client.
    #     The client will retrieve encrypted items from the DDB table, then
    #     detect the KMS key that was used to encrypt their data keys.
    #     The client will make a request to KMS to decrypt with the encrypting KMS key.
    #     If the client has permission to decrypt with the KMS key,
    #     the client will decrypt the item client-side using the keyring
    #     and return the original item.
    key_to_get = {"partition_key": {"S": "awsKmsMrkDiscoveryMultiKeyringItem"}, "sort_key": {"N": "0"}}

    get_response = encrypted_ddb_client_for_decrypt.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["sensitive_data"]["S"] == "encrypt and sign me!"
