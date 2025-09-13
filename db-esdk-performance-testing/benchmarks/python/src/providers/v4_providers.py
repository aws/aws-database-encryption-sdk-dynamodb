"""V4 Keyring implementations for performance testing."""

import sys
from pathlib import Path
from abc import ABC, abstractmethod

# Add parent directory to path for imports
sys.path.insert(0, str(Path(__file__).parent.parent))

import boto3
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.references import IKeyring
from aws_cryptographic_material_providers.mpl.models import (
    AesWrappingAlg,
    CreateRawAesKeyringInput,
    CreateAwsKmsMrkMultiKeyringInput,
    CacheTypeDefault,
    CreateAwsKmsHierarchicalKeyringInput,
    DefaultCache,
)

from aws_cryptographic_material_providers.keystore.client import KeyStore
from aws_cryptographic_material_providers.keystore.config import KeyStoreConfig
from aws_cryptographic_material_providers.keystore.models import (
    CreateKeyInput,
    KMSConfigurationKmsKeyArn,
)

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



from ..test_constants import AES_256_KEY_MATERIAL, KMS_KEY_ARN, HIERARCHY_KEYRING_NAMESPACE, HIERARCHY_KEYRING_PARTITION


_kms_client = boto3.client("kms", region_name="us-west-2")
_ddb_client = boto3.client("dynamodb", region_name="us-west-2")

class V4KeyringBase(ABC):
    """Base class for V4 keyring implementations."""
    
    def __init__(self):
        """Initialize the base keyring."""
        self.mat_prov = AwsCryptographicMaterialProviders(
            config=MaterialProvidersConfig()
        )
    
    @abstractmethod
    def get_keyring(self) -> IKeyring:
        """Get the keyring."""
        pass
    
    def get_keyring_name(self) -> str:
        """Get the keyring name."""
        return self.__class__.__name__


class V4AESKeyring(V4KeyringBase):
    """V4 Raw AES Keyring using static key material."""
    
    def __init__(self):
        """Initialize the AES keyring."""
        super().__init__()

        # Create Raw AES Keyring input matching the example
        keyring_input = CreateRawAesKeyringInput(
            key_name="my-aes-key-name",
            key_namespace="my-key-namespace",
            wrapping_key=AES_256_KEY_MATERIAL,
            wrapping_alg=AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16,
        )
        
        self.keyring = self.mat_prov.create_raw_aes_keyring(input=keyring_input)
    
    def get_keyring(self) -> IKeyring:
        """Get the keyring."""
        return self.keyring


class V4KMSKeyring(V4KeyringBase):
    """V4 AWS KMS Multi-Region Keyring."""
    
    def __init__(self):
        """Initialize the KMS keyring."""
        super().__init__()
        
        # Create the KMS MRK Multi-Keyring
        keyring_input = CreateAwsKmsMrkMultiKeyringInput(
            generator=KMS_KEY_ARN
        )
        
        self.keyring = self.mat_prov.create_aws_kms_mrk_multi_keyring(input=keyring_input)
    
    def get_keyring(self) -> IKeyring:
        """Get the keyring."""
        return self.keyring

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

class V4HierarchyKeyring(V4KeyringBase):
    """V4 AWS KMS Hierarchical Keyring."""
    
    def __init__(self):
        """Initialize the hierarchy keyring."""
        super().__init__()
        
        # Create the KMS Hierarchical Keyring
        keystore = KeyStore(
            config=KeyStoreConfig(
                ddb_client=_ddb_client,
                ddb_table_name="KeyStoreTestTable",
                logical_key_store_name="KeyStoreTestTable",
                kms_client=_kms_client,
                kms_configuration=KMSConfigurationKmsKeyArn(KMS_KEY_ARN),
            )
        )

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

        self.keyring = mat_prov.create_aws_kms_hierarchical_keyring(input=keyring_input)
    
    def get_keyring(self) -> IKeyring:
        """Get the keyring."""
        return self.keyring
