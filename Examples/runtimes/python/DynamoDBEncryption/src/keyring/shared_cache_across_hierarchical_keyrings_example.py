# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrates how to use a shared cache across multiple Hierarchical Keyrings in single-threaded environments.

IMPORTANT: This example and the shared cache functionality should ONLY be used in single-threaded environments.
The AWS Cryptographic Material Providers Library (MPL) for Python does not support multithreading for
components that interact with KMS. For more information about multithreading limitations, see:
https://github.com/aws/aws-cryptographic-material-providers-library/blob/main/AwsCryptographicMaterialProviders/runtimes/python/README.rst

With this functionality, users only need to maintain one common shared cache across multiple
Hierarchical Keyrings with different Key Stores instances/KMS Clients/KMS Keys in a single-threaded environment.

There are three important parameters that users need to carefully set while providing the shared cache:

1. Partition ID - Partition ID is an optional parameter provided to the Hierarchical Keyring input,
which distinguishes Cryptographic Material Providers (i.e: Keyrings) writing to a cache.
- If the Partition ID is set and is the same for two Hierarchical Keyrings (or another Material Provider),
  they CAN share the same cache entries in the cache.
- If the Partition ID is set and is different for two Hierarchical Keyrings (or another Material Provider),
  they CANNOT share the same cache entries in the cache.
- If the Partition ID is not set by the user, it is initialized as a random 16-byte UUID which makes
  it unique for every Hierarchical Keyring, and two Hierarchical Keyrings (or another Material Provider)
  CANNOT share the same cache entries in the cache.

2. Logical Key Store Name - This parameter is set by the user when configuring the Key Store for
the Hierarchical Keyring. This is a logical name for the branch key store.
Suppose you have a physical Key Store (K). You create two instances of K (K1 and K2). Now, you create
two Hierarchical Keyrings (HK1 and HK2) with these Key Store instances (K1 and K2 respectively).
- If you want to share cache entries across these two keyrings, you should set the Logical Key Store Names
  for both the Key Store instances (K1 and K2) to be the same.
- If you set the Logical Key Store Names for K1 and K2 to be different, HK1 (which uses Key Store instance K1)
  and HK2 (which uses Key Store instance K2) will NOT be able to share cache entries.

3. Branch Key ID - Choose an effective Branch Key ID Schema

This is demonstrated in the example below.
Notice that both K1 and K2 are instances of the same physical Key Store (K).
You MUST NEVER have two different physical Key Stores with the same Logical Key Store Name.

Important Note: If you have two or more Hierarchy Keyrings with:
- Same Partition ID
- Same Logical Key Store Name of the Key Store for the Hierarchical Keyring
- Same Branch Key ID
then they WILL share the cache entries in the Shared Cache.
Please make sure that you set all of Partition ID, Logical Key Store Name and Branch Key ID
to be the same for two Hierarchical Keyrings if and only if you want them to share cache entries.

This example sets up DynamoDb Encryption for the AWS SDK client using the Hierarchical
Keyring, which establishes a key hierarchy where "branch" keys are persisted in DynamoDb.
These branch keys are used to protect your data keys, and these branch keys are themselves
protected by a root KMS Key.

This example first creates a shared cache that you can use across multiple Hierarchical Keyrings.
The example then configures a Hierarchical Keyring (HK1 and HK2) with the shared cache,
a Branch Key ID and two instances (K1 and K2) of the same physical Key Store (K) respectively,
i.e. HK1 with K1 and HK2 with K2. The example demonstrates that if you set the same Partition ID
for HK1 and HK2, the two keyrings can share cache entries.
If you set different Partition ID of the Hierarchical Keyrings, or different
Logical Key Store Names of the Key Store instances, then the keyrings will NOT
be able to share cache entries.

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
"""
from typing import Dict

import boto3
from aws_cryptographic_material_providers.keystore import KeyStore
from aws_cryptographic_material_providers.keystore.config import KeyStoreConfig
from aws_cryptographic_material_providers.keystore.models import KMSConfigurationKmsKeyArn
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CacheTypeDefault,
    CacheTypeShared,
    CreateAwsKmsHierarchicalKeyringInput,
    CreateCryptographicMaterialsCacheInput,
    DefaultCache,
)
from aws_cryptographic_material_providers.mpl.references import IKeyring
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.structures.dynamodb import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import (
    CryptoAction,
)


def get_ddb_client(
    ddb_table_name: str, hierarchical_keyring: IKeyring, attribute_actions_on_encrypt: Dict[str, CryptoAction]
) -> boto3.client:
    """
    Get a DynamoDB client configured with encryption using the given keyring.

    :param ddb_table_name: The name of the DynamoDB table
    :param hierarchical_keyring: The hierarchical keyring to use
    :param attribute_actions_on_encrypt: The attribute actions for encryption
    :return: The configured DynamoDB client
    """
    # Configure which attributes we expect to be included in the signature
    # when reading items. There are two options for configuring this:
    #
    # - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
    #   When defining your DynamoDb schema and deciding on attribute names,
    #   choose a distinguishing prefix (such as ":") for all attributes that
    #   you do not want to include in the signature.
    #   This has two main benefits:
    #   - It is easier to reason about the security and authenticity of data within your item
    #     when all unauthenticated data is easily distinguishable by their attribute name.
    #   - If you need to add new unauthenticated attributes in the future,
    #     you can easily make the corresponding update to your `attributeActionsOnEncrypt`
    #     and immediately start writing to that new attribute, without
    #     any other configuration update needed.
    #   Once you configure this field, it is not safe to update it.
    #
    # - Configure `allowedUnsignedAttributes`: You may also explicitly list
    #   a set of attributes that should be considered unauthenticated when encountered
    #   on read. Be careful if you use this configuration. Do not remove an attribute
    #   name from this configuration, even if you are no longer writing with that attribute,
    #   as old items may still include this attribute, and our configuration needs to know
    #   to continue to exclude this attribute from the signature scope.
    #   If you add new attribute names to this field, you must first deploy the update to this
    #   field to all readers in your host fleet before deploying the update to start writing
    #   with that new attribute.
    #
    #   For this example, we currently authenticate all attributes. To make it easier to
    #   add unauthenticated attributes in the future, we define a prefix ":" for such attributes.
    unsign_attr_prefix = ":"

    # Create the DynamoDb Encryption configuration for the table we will be writing to.
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions_on_encrypt,
        keyring=hierarchical_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    table_configs = {ddb_table_name: table_config}
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # Create the EncryptedClient
    ddb_client = boto3.client("dynamodb")
    encrypted_ddb_client = EncryptedClient(client=ddb_client, encryption_config=tables_config)

    return encrypted_ddb_client


def put_get_items(ddb_table_name: str, ddb_client: boto3.client):
    """
    Put and get items using the given DynamoDB client.

    :param ddb_table_name: The name of the DynamoDB table
    :param ddb_client: The DynamoDB client to use
    """
    # Put an item into our table using the given ddb client.
    # Before the item gets sent to DynamoDb, it will be encrypted
    # client-side, according to our configuration.
    # This example creates a Hierarchical Keyring for a single BranchKeyId. You can, however, use a
    # BranchKeyIdSupplier as per your use-case. See the HierarchicalKeyringsExample.java for more
    # information.
    item = {"partition_key": {"S": "id"}, "sort_key": {"N": "0"}, "sensitive_data": {"S": "encrypt and sign me!"}}

    put_response = ddb_client.put_item(TableName=ddb_table_name, Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # Get the item back from our table using the same client.
    # The client will decrypt the item client-side, and return
    # back the original item.
    # This example creates a Hierarchical Keyring for a single BranchKeyId. You can, however, use a
    # BranchKeyIdSupplier as per your use-case. See the HierarchicalKeyringsExample.java for more
    # information.
    key_to_get = {"partition_key": {"S": "id"}, "sort_key": {"N": "0"}}

    get_response = ddb_client.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["sensitive_data"]["S"] == "encrypt and sign me!"


def shared_cache_across_hierarchical_keyrings_example(
    ddb_table_name: str,
    branch_key_id: str,
    key_store_table_name: str,
    logical_key_store_name: str,
    partition_id: str,
    kms_key_id: str,
):
    """
    Create multiple hierarchical keyrings sharing a cache and use them to encrypt/decrypt DynamoDB items.

    :param ddb_table_name: The name of the DynamoDB table
    :param branch_key_id: The branch key ID to use
    :param key_store_table_name: The name of the KeyStore DynamoDB table
    :param logical_key_store_name: The logical name for the KeyStore
    :param partition_id: The partition ID for cache sharing
    :param kms_key_id: ARN of the KMS key
    """
    # 1. Create the CryptographicMaterialsCache (CMC) to share across multiple Hierarchical Keyrings
    #    using the Material Providers Library in a single-threaded environment.
    #    IMPORTANT: This shared cache must only be used in single-threaded environments as the
    #    MPL for Python does not support multithreading for KMS operations.
    #      This CMC takes in:
    #      - CacheType
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    cache = CacheTypeDefault(DefaultCache(entry_capacity=100))

    cryptographic_materials_cache_input = CreateCryptographicMaterialsCacheInput(cache=cache)

    shared_cryptographic_materials_cache = mat_prov.create_cryptographic_materials_cache(
        input=cryptographic_materials_cache_input
    )

    # 2. Create a CacheType object for the sharedCryptographicMaterialsCache
    #    Note that the `cache` parameter in the Hierarchical Keyring Input takes a `CacheType` as input
    shared_cache = CacheTypeShared(
        # This is the `Shared` CacheType that passes an already initialized shared cache
        shared_cryptographic_materials_cache
    )

    # Initial KeyStore Setup: This example requires that you have already
    # created your KeyStore, and have populated it with a new branch key.

    # 3. Configure your KeyStore resource keystore1.
    #    This SHOULD be the same configuration that you used
    #    to initially create and populate your KeyStore.
    # Note that key_store_table_name is the physical Key Store,
    # and keystore1 is instances of this physical Key Store.
    keystore1 = KeyStore(
        config=KeyStoreConfig(
            ddb_client=boto3.client("dynamodb"),
            ddb_table_name=key_store_table_name,
            logical_key_store_name=logical_key_store_name,
            kms_client=boto3.client("kms"),
            kms_configuration=KMSConfigurationKmsKeyArn(kms_key_id),
        )
    )

    # 4. Create the Hierarchical Keyring HK1 with Key Store instance K1, partitionId,
    #    the shared Cache and the BranchKeyId.
    #    Note that we are now providing an already initialized shared cache instead of just mentioning
    #    the cache type and the Hierarchical Keyring initializing a cache at initialization.

    # This example creates a Hierarchical Keyring for a single BranchKeyId. You can, however, use a
    # BranchKeyIdSupplier as per your use-case. See the HierarchicalKeyringsExample.java for more
    # information.

    # Please make sure that you read the guidance on how to set Partition ID, Logical Key Store Name and
    # Branch Key ID at the top of this example before creating Hierarchical Keyrings with a Shared Cache.
    # partitionId for this example is a random UUID
    keyring_input1 = CreateAwsKmsHierarchicalKeyringInput(
        key_store=keystore1,
        branch_key_id=branch_key_id,
        ttl_seconds=600,  # This dictates how often we call back to KMS to authorize use of the branch keys
        cache=shared_cache,
        partition_id=partition_id,
    )

    hierarchical_keyring1 = mat_prov.create_aws_kms_hierarchical_keyring(input=keyring_input1)

    # 5. Configure which attributes are encrypted and/or signed when writing new items.
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

    # 6. Get the DDB Client for Hierarchical Keyring 1.
    ddb_client1 = get_ddb_client(ddb_table_name, hierarchical_keyring1, attribute_actions_on_encrypt)

    # 7. Encrypt Decrypt roundtrip with ddb_client1
    put_get_items(ddb_table_name, ddb_client1)

    # Through the above encrypt and decrypt roundtrip, the cache will be populated and
    # the cache entries can be used by another Hierarchical Keyring with the
    # - Same Partition ID
    # - Same Logical Key Store Name of the Key Store for the Hierarchical Keyring
    # - Same Branch Key ID

    # 8. Configure your KeyStore resource keystore2.
    #       This SHOULD be the same configuration that you used
    #       to initially create and populate your physical KeyStore.
    #    Note that key_store_table_name is the physical Key Store,
    #    and keystore2 is instances of this physical Key Store.

    # Note that for this example, keystore2 is identical to keystore1.
    # You can optionally change configurations like KMS Client or KMS Key ID based
    # on your use-case.
    # Make sure you have the required permissions to use different configurations.

    # - If you want to share cache entries across two keyrings HK1 and HK2,
    #   you should set the Logical Key Store Names for both
    #   Key Store instances (K1 and K2) to be the same.
    # - If you set the Logical Key Store Names for K1 and K2 to be different,
    #   HK1 (which uses Key Store instance K1) and HK2 (which uses Key Store
    #   instance K2) will NOT be able to share cache entries.
    keystore2 = KeyStore(
        config=KeyStoreConfig(
            ddb_client=boto3.client("dynamodb"),
            ddb_table_name=key_store_table_name,
            logical_key_store_name=logical_key_store_name,
            kms_client=boto3.client("kms"),
            kms_configuration=KMSConfigurationKmsKeyArn(kms_key_id),
        )
    )

    # 9. Create the Hierarchical Keyring HK2 with Key Store instance K2, the shared Cache
    #    and the same partitionId and BranchKeyId used in HK1 because we want to share cache entries
    #    (and experience cache HITS).

    # Please make sure that you read the guidance on how to set Partition ID, Logical Key Store Name and
    # Branch Key ID at the top of this example before creating Hierarchical Keyrings with a Shared Cache.
    # partitionId for this example is a random UUID
    keyring_input2 = CreateAwsKmsHierarchicalKeyringInput(
        key_store=keystore2,
        branch_key_id=branch_key_id,
        ttl_seconds=600,  # This dictates how often we call back to KMS to authorize use of the branch keys
        cache=shared_cache,
        partition_id=partition_id,
    )

    hierarchical_keyring2 = mat_prov.create_aws_kms_hierarchical_keyring(input=keyring_input2)

    # 10. Get the DDB Client for Hierarchical Keyring 2.
    ddb_client2 = get_ddb_client(ddb_table_name, hierarchical_keyring2, attribute_actions_on_encrypt)

    # 11. Encrypt Decrypt roundtrip with ddb_client2
    put_get_items(ddb_table_name, ddb_client2)
