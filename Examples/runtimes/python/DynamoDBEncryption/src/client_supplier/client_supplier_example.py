# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDB Encryption using a custom client supplier.

A custom client supplier grants users access to more granular configuration aspects
of their authentication details and KMS client. The example creates a simple custom
client supplier that authenticates with a different IAM role based on the region
of the KMS key.

Creates a MRK multi-keyring configured with a custom client supplier using a single
MRK and puts an encrypted item to the table. Then, creates a MRK discovery
multi-keyring to decrypt the item and retrieves the item from the table.

Running this example requires access to the DDB Table whose name is provided in
CLI arguments. This table must be configured with the following primary key
configuration:
  - Partition key is named "partition_key" with type (S)
  - Sort key is named "sort_key" with type (N)
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

from .regional_role_client_supplier import RegionalRoleClientSupplier


def client_supplier_example(ddb_table_name: str, key_arn: str, account_ids: List[str], regions: List[str]) -> None:
    """
    Demonstrate using custom client supplier with AWS KMS MRK keyrings.

    Shows how to use a custom client supplier with AWS KMS MRK multi-keyring and AWS
    KMS MRK discovery multi-keyring.

    :param ddb_table_name: The name of the DynamoDB table
    :param key_arn: The ARN of the AWS KMS key
    :param account_ids: List of AWS account IDs
    :param regions: List of AWS regions
    """
    # 1. Create a single MRK multi-keyring.
    #    This can be either a single-region KMS key or an MRK.
    #    For this example to succeed, the key's region must either
    #    1) be in the regions list, or
    #    2) the key must be an MRK with a replica defined
    #    in a region in the regions list, and the client
    #    must have the correct permissions to access the replica.
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    # Create the multi-keyring using our custom client supplier
    # defined in the RegionalRoleClientSupplier class in this directory.
    create_aws_kms_mrk_multi_keyring_input = CreateAwsKmsMrkMultiKeyringInput(
        # Note: RegionalRoleClientSupplier will internally use the keyArn's region
        # to retrieve the correct IAM role.
        client_supplier=RegionalRoleClientSupplier(),
        generator=key_arn,
    )
    mrk_keyring_with_client_supplier = mat_prov.create_aws_kms_mrk_multi_keyring(
        input=create_aws_kms_mrk_multi_keyring_input
    )

    # 2. Configure which attributes are encrypted and/or signed when writing new items.
    #    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    #    we must explicitly configure how they should be treated during item encryption:
    #      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    #      - SIGN_ONLY: The attribute is not encrypted, but is still included in the signature
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
        keyring=mrk_keyring_with_client_supplier,
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
        "partition_key": {"S": "clientSupplierItem"},
        "sort_key": {"N": "0"},
        "sensitive_data": {"S": "encrypt and sign me!"},
    }

    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 7. Get the item back from our table using the same keyring.
    #    The client will decrypt the item client-side using the MRK
    #    and return the original item.
    key_to_get = {"partition_key": {"S": "clientSupplierItem"}, "sort_key": {"N": "0"}}

    get_response = encrypted_ddb_client.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["sensitive_data"]["S"] == "encrypt and sign me!"

    # 8. Create a MRK discovery multi-keyring with a custom client supplier.
    #    A discovery MRK multi-keyring will be composed of
    #    multiple discovery MRK keyrings, one for each region.
    #    Each component keyring has its own KMS client in a particular region.
    #    When we provide a client supplier to the multi-keyring, all component
    #    keyrings will use that client supplier configuration.
    #    In our tests, we make `key_arn` an MRK with a replica, and
    #    provide only the replica region in our discovery filter.
    discovery_filter = DiscoveryFilter(partition="aws", account_ids=account_ids)

    mrk_discovery_client_supplier_input = CreateAwsKmsMrkDiscoveryMultiKeyringInput(
        client_supplier=RegionalRoleClientSupplier(), discovery_filter=discovery_filter, regions=regions
    )

    mrk_discovery_client_supplier_keyring = mat_prov.create_aws_kms_mrk_discovery_multi_keyring(
        input=mrk_discovery_client_supplier_input
    )

    # 9. Create a new config and client using the discovery keyring.
    #    This is the same setup as above, except we provide the discovery keyring to the config.
    replica_key_table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions_on_encrypt,
        # Provide discovery keyring here
        keyring=mrk_discovery_client_supplier_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    replica_key_tables_config = {ddb_table_name: replica_key_table_config}
    replica_key_tables_encryption_config = DynamoDbTablesEncryptionConfig(
        table_encryption_configs=replica_key_tables_config
    )

    replica_key_encrypted_client = EncryptedClient(
        client=ddb_client, encryption_config=replica_key_tables_encryption_config
    )

    # 10. Get the item back from our table using the discovery keyring client.
    #     The client will decrypt the item client-side using the keyring,
    #     and return the original item.
    #     The discovery keyring will only use KMS keys in the provided regions and
    #     AWS accounts. Since we have provided it with a custom client supplier
    #     which uses different IAM roles based on the key region,
    #     the discovery keyring will use a particular IAM role to decrypt
    #     based on the region of the KMS key it uses to decrypt.
    replica_key_key_to_get = {"partition_key": {"S": "awsKmsMrkMultiKeyringItem"}, "sort_key": {"N": "0"}}

    replica_key_get_response = replica_key_encrypted_client.get_item(
        TableName=ddb_table_name, Key=replica_key_key_to_get
    )

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert replica_key_get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    replica_key_returned_item = replica_key_get_response["Item"]
    assert replica_key_returned_item["sensitive_data"]["S"] == "encrypt and sign me!"
