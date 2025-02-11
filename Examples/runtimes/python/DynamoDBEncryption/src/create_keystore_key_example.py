from aws_cryptographic_material_providers.keystore.models import (
    KMSConfigurationKmsKeyArn,
    CreateKeyInput,
)
import boto3
from aws_cryptographic_material_providers.keystore.client import KeyStore
from aws_cryptographic_material_providers.keystore.config import KeyStoreConfig

"""
The Hierarchical Keyring Example and Searchable Encryption Examples
rely on the existence of a DDB-backed key store with pre-existing
branch key material or beacon key material.

See the "Create KeyStore Table Example" for how to first set up
the DDB Table that will back this KeyStore.

This example demonstrates configuring a KeyStore and then
using a helper method to create a branch key and beacon key 
that share the same Id, then return that Id.
We will always create a new beacon key alongside a new branch key,
even if you are not using searchable encryption.

This key creation should occur within your control plane.
"""

def keystore_create_key(key_store_table_name: str,
                        logical_key_store_name: str,
                        kms_key_arn: str) -> str:
    # 1. Configure your KeyStore resource.
    #    This SHOULD be the same configuration that was used to create the DDB table
    #    in the "Create KeyStore Table Example".   
    keystore: KeyStore = KeyStore(
        KeyStoreConfig(
            ddb_table_name = key_store_table_name,
            kms_configuration=KMSConfigurationKmsKeyArn(
                kms_key_arn
            ),
            logical_key_store_name=logical_key_store_name,
            kms_client=boto3.client("kms"),
            ddb_client=boto3.client("dynamodb")
        )
    )

    # 2. Create a new branch key and beacon key in our KeyStore.
    #    Both the branch key and the beacon key will share an Id.
    #    This creation is eventually consistent.
    branch_key_id = keystore.create_key(
        CreateKeyInput()
    ).branch_key_identifier

    print(f"{branch_key_id=}")

    return branch_key_id
