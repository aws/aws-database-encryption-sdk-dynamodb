# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example demonstrating DynamoDb Encryption using a Hierarchical Keyring.

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
"""

import boto3
from aws_cryptographic_material_providers.keystore.client import KeyStore
from aws_cryptographic_material_providers.keystore.config import KeyStoreConfig
from aws_cryptographic_material_providers.keystore.models import KMSConfigurationKmsKeyArn
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CacheTypeDefault,
    CreateAwsKmsHierarchicalKeyringInput,
    DefaultCache,
)
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.client import DynamoDbEncryption
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.config import (
    DynamoDbEncryptionConfig,
)
from aws_dbesdk_dynamodb.structures.dynamodb import (
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput,
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.structures.structured_encryption import (
    CryptoAction,
)

from .example_branch_key_id_supplier import ExampleBranchKeyIdSupplier


def hierarchical_keyring_get_item_put_item(
    ddb_table_name: str,
    tenant1_branch_key_id: str,
    tenant2_branch_key_id: str,
    keystore_table_name: str,
    logical_keystore_name: str,
    kms_key_id: str,
):
    """
    Demonstrate using a hierarchical keyring with multiple tenants.

    :param ddb_table_name: The name of the DynamoDB table
    :param tenant1_branch_key_id: Branch key ID for tenant 1
    :param tenant2_branch_key_id: Branch key ID for tenant 2
    :param keystore_table_name: The name of the KeyStore DynamoDB table
    :param logical_keystore_name: The logical name for this keystore
    :param kms_key_id: The ARN of the KMS key to use
    """
    # Initial KeyStore Setup: This example requires that you have already
    # created your KeyStore, and have populated it with two new branch keys.
    # See the "Create KeyStore Table Example" and "Create KeyStore Key Example"
    # for an example of how to do this.

    # 1. Configure your KeyStore resource.
    #    This SHOULD be the same configuration that you used
    #    to initially create and populate your KeyStore.
    keystore = KeyStore(
        config=KeyStoreConfig(
            ddb_client=boto3.client("dynamodb"),
            ddb_table_name=keystore_table_name,
            logical_key_store_name=logical_keystore_name,
            kms_client=boto3.client("kms"),
            kms_configuration=KMSConfigurationKmsKeyArn(kms_key_id),
        )
    )

    # 2. Create a Branch Key ID Supplier. See ExampleBranchKeyIdSupplier in this directory.
    ddb_enc = DynamoDbEncryption(config=DynamoDbEncryptionConfig())
    branch_key_id_supplier = ddb_enc.create_dynamo_db_encryption_branch_key_id_supplier(
        input=CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
            ddb_key_branch_key_id_supplier=ExampleBranchKeyIdSupplier(tenant1_branch_key_id, tenant2_branch_key_id)
        )
    ).branch_key_id_supplier

    # 3. Create the Hierarchical Keyring, using the Branch Key ID Supplier above.
    #    With this configuration, the AWS SDK Client ultimately configured will be capable
    #    of encrypting or decrypting items for either tenant (assuming correct KMS access).
    #    If you want to restrict the client to only encrypt or decrypt for a single tenant,
    #    configure this Hierarchical Keyring using `.branch_key_id=tenant1_branch_key_id` instead
    #    of `.branch_key_id_supplier=branch_key_id_supplier`.
    mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

    keyring_input = CreateAwsKmsHierarchicalKeyringInput(
        key_store=keystore,
        branch_key_id_supplier=branch_key_id_supplier,
        ttl_seconds=600,  # This dictates how often we call back to KMS to authorize use of the branch keys
        cache=CacheTypeDefault(  # This dictates how many branch keys will be held locally
            value=DefaultCache(entry_capacity=100)
        ),
    )

    hierarchical_keyring = mat_prov.create_aws_kms_hierarchical_keyring(input=keyring_input)

    # 4. Configure which attributes are encrypted and/or signed when writing new items.
    #    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    #    we must explicitly configure how they should be treated during item encryption:
    #      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    #      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    #      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    attribute_actions = {
        "partition_key": CryptoAction.SIGN_ONLY,  # Our partition attribute must be SIGN_ONLY
        "sort_key": CryptoAction.SIGN_ONLY,  # Our sort attribute must be SIGN_ONLY
        "tenant_sensitive_data": CryptoAction.ENCRYPT_AND_SIGN,
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
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=ddb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions,
        keyring=hierarchical_keyring,
        allowed_unsigned_attribute_prefix=unsign_attr_prefix,
    )

    table_configs = {ddb_table_name: table_config}
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # 7. Create the EncryptedClient
    ddb_client = boto3.client("dynamodb")
    encrypted_ddb_client = EncryptedClient(client=ddb_client, encryption_config=tables_config)

    # 8. Put an item into our table using the above client.
    #    Before the item gets sent to DynamoDb, it will be encrypted
    #    client-side, according to our configuration.
    #    Because the item we are writing uses "tenantId1" as our partition value,
    #    based on the code we wrote in the ExampleBranchKeySupplier,
    #    `tenant1_branch_key_id` will be used to encrypt this item.
    item = {
        "partition_key": {"S": "tenant1Id"},
        "sort_key": {"N": "0"},
        "tenant_sensitive_data": {"S": "encrypt and sign me!"},
    }

    put_response = encrypted_ddb_client.put_item(TableName=ddb_table_name, Item=item)

    # Demonstrate that PutItem succeeded
    assert put_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 9. Get the item back from our table using the same client.
    #    The client will decrypt the item client-side, and return
    #    back the original item.
    #    Because the returned item's partition value is "tenantId1",
    #    based on the code we wrote in the ExampleBranchKeySupplier,
    #    `tenant1_branch_key_id` will be used to decrypt this item.
    key_to_get = {"partition_key": {"S": "tenant1Id"}, "sort_key": {"N": "0"}}

    get_response = encrypted_ddb_client.get_item(TableName=ddb_table_name, Key=key_to_get)

    # Demonstrate that GetItem succeeded and returned the decrypted item
    assert get_response["ResponseMetadata"]["HTTPStatusCode"] == 200
    returned_item = get_response["Item"]
    assert returned_item["tenant_sensitive_data"]["S"] == "encrypt and sign me!"
