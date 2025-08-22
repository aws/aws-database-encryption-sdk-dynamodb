"""Performance tests for DB-ESDK v4 with Hierarchy Keyring using EncryptedClient."""

import boto3
import pytest
from aws_cryptographic_material_providers.keystore.client import KeyStore
from aws_cryptographic_material_providers.keystore.config import KeyStoreConfig
from aws_cryptographic_material_providers.keystore.models import (
    CreateKeyInput,
    KMSConfigurationKmsKeyArn,
)
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CacheTypeDefault,
    CreateAwsKmsHierarchicalKeyringInput,
    DefaultCache,
)
from aws_cryptographic_material_providers.mpl.references import IKeyring
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.client import (
    DynamoDbEncryption,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.config import (
    DynamoDbEncryptionConfig,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.references import (
    IDynamoDbKeyBranchKeyIdSupplier,
)
from aws_dbesdk_dynamodb.structures.dynamodb import (
    CreateDynamoDbEncryptionBranchKeyIdSupplierInput,
    GetBranchKeyIdFromDdbKeyInput,
    GetBranchKeyIdFromDdbKeyOutput,
)

from ..test_constants import KMS_KEY_ARN, TEST_DATA_CATEGORIES
from .test_base import V4PerformanceTestBase


class PerformanceBranchKeyIdSupplier(IDynamoDbKeyBranchKeyIdSupplier):
    """Branch Key ID Supplier for performance testing ."""

    def __init__(self, tenant1_branch_key_id: str, tenant2_branch_key_id: str):
        """Initialize with branch key IDs for two tenants."""
        self.tenant1_branch_key_id = tenant1_branch_key_id
        self.tenant2_branch_key_id = tenant2_branch_key_id

    def get_branch_key_id_from_ddb_key(self, param: GetBranchKeyIdFromDdbKeyInput) -> GetBranchKeyIdFromDdbKeyOutput:
        """Get branch key ID based on partition key ."""
        key = param.ddb_key

        if "partition_key" not in key:
            raise ValueError("Item invalid, does not contain expected partition key attribute.")

        tenant_key_id = key["partition_key"]["S"]

        # if partition_key equals TEST_PK, use tenant1, otherwise tenant2
        if tenant_key_id == "test_pk":
            branch_key_id = self.tenant1_branch_key_id
        else:
            branch_key_id = self.tenant2_branch_key_id

        return GetBranchKeyIdFromDdbKeyOutput(branch_key_id=branch_key_id)


class V4HierarchyKeyring(V4PerformanceTestBase):
    """DB-ESDK v4 with Hierarchy Keyring."""

    def __init__(self):
        """Initialize with keystore setup."""
        super().__init__()

    def _create_keyring(self) -> IKeyring:
        """Create the Hierarchy Keyring ."""
        # 1. Create KeyStore configuration
        keystore = KeyStore(
            config=KeyStoreConfig(
                ddb_client=_ddb_client,
                ddb_table_name="KeyStoreTestTable",
                logical_key_store_name="KeyStoreTestTable",
                kms_client=_kms_client,
                kms_configuration=KMSConfigurationKmsKeyArn(KMS_KEY_ARN),
            )
        )

        # # 2. Create KeyStore and branch keys
        # try:
        #     keystore.create_key_store(input=CreateKeyStoreInput())
        # except Exception:
        #     # KeyStore might already exist - continue
        #     pass
        # # Create two branch keys for tenants
        # tenant1_branch_key = keystore.create_key(CreateKeyInput()).branch_key_identifier
        # tenant2_branch_key = keystore.create_key(CreateKeyInput()).branch_key_identifier

        # 2. Re-use two branch keys for tenants
        tenant1_branch_key = "247b2cf7-6db9-47b3-a6de-7c1fbad88cc8"
        tenant2_branch_key = "28115a523-e1d4-477f-9b3e-774fbb799ac7"

        # 3. Create DynamoDbEncryption and BranchKeyIdSupplier
        ddb_enc = DynamoDbEncryption(config=DynamoDbEncryptionConfig())

        branch_key_id_supplier = ddb_enc.create_dynamo_db_encryption_branch_key_id_supplier(
            input=CreateDynamoDbEncryptionBranchKeyIdSupplierInput(
                ddb_key_branch_key_id_supplier=PerformanceBranchKeyIdSupplier(tenant1_branch_key, tenant2_branch_key)
            )
        ).branch_key_id_supplier

        # 4. Create Hierarchical Keyring
        mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

        keyring_input = CreateAwsKmsHierarchicalKeyringInput(
            key_store=keystore,
            branch_key_id_supplier=branch_key_id_supplier,
            ttl_seconds=60,
            cache=CacheTypeDefault(value=DefaultCache(entry_capacity=100)),  # Same maxCacheSize=100
        )

        return mat_prov.create_aws_kms_hierarchical_keyring(input=keyring_input)


# Create a singleton instance
_test_instance = None
_kms_client = boto3.client("kms", region_name="us-west-2")
_ddb_client = boto3.client("dynamodb", region_name="us-west-2")

def get_test_instance():
    """Get or create the test instance."""
    global _test_instance
    if _test_instance is None:
        _test_instance = V4HierarchyKeyring()
    return _test_instance


@pytest.mark.benchmark(group="v4-hierarchy-encrypt")
@pytest.mark.v4
@pytest.mark.parametrize("data_type", TEST_DATA_CATEGORIES)
def test_encrypt_performance(benchmark, data_type):
    """Test encryption performance with Hierarchy Keyring."""
    instance = get_test_instance()
    instance.benchmark_encrypt(benchmark, data_type)


@pytest.mark.benchmark(group="v4-hierarchy-decrypt")
@pytest.mark.v4
@pytest.mark.parametrize("data_type", TEST_DATA_CATEGORIES)
def test_decrypt_performance(benchmark, data_type):
    """Test decryption performance with Hierarchy Keyring."""
    instance = get_test_instance()
    instance.benchmark_decrypt(benchmark, data_type)
