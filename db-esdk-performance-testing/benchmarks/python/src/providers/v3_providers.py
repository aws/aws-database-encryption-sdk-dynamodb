"""V3 Provider implementations for performance testing."""

import sys
from pathlib import Path
from abc import ABC, abstractmethod

# Add parent directory to path for imports
sys.path.insert(0, str(Path(__file__).parent.parent))

import boto3
from dynamodb_encryption_sdk.material_providers.aws_kms import AwsKmsCryptographicMaterialsProvider
from dynamodb_encryption_sdk.material_providers.most_recent import CachingMostRecentProvider
from dynamodb_encryption_sdk.delegated_keys.jce import JceNameLocalDelegatedKey
from dynamodb_encryption_sdk.identifiers import EncryptionKeyType, KeyEncodingType
from dynamodb_encryption_sdk.material_providers.wrapped import WrappedCryptographicMaterialsProvider
from dynamodb_encryption_sdk.material_providers.aws_kms import AwsKmsCryptographicMaterialsProvider
from dynamodb_encryption_sdk.material_providers.most_recent import CachingMostRecentProvider
from dynamodb_encryption_sdk.material_providers.store.meta import MetaStore

from ..test_constants import AES_256_KEY_MATERIAL, KMS_KEY_ARN, ENCRYPTION_CONTEXT


class V3ProviderBase(ABC):
    """Base class for V3 provider implementations."""
    
    @abstractmethod
    def get_materials_provider(self):
        """Get the cryptographic materials provider."""
        pass
    
    def get_provider_name(self) -> str:
        """Get the provider name."""
        return self.__class__.__name__


class V3AESProvider(V3ProviderBase):
    """V3 AES Key Provider using static key material."""
    
    def __init__(self):
        """Initialize the AES provider."""
        # Create a static master key using our AES key material
        # Create wrapping key using JceNameLocalDelegatedKey as shown in example
        wrapping_key = JceNameLocalDelegatedKey(
            key=AES_256_KEY_MATERIAL,
            algorithm="AES",
            key_type=EncryptionKeyType.SYMMETRIC,
            key_encoding=KeyEncodingType.RAW,
        )

        # For performance testing, we'll use the same key for signing
        # In production, you would use a separate HMAC key
        signing_key = JceNameLocalDelegatedKey(
            key=AES_256_KEY_MATERIAL,
            algorithm="HmacSHA256",
            key_type=EncryptionKeyType.SYMMETRIC,
            key_encoding=KeyEncodingType.RAW,
        )

        # Create the materials provider
        self.materials_provider = WrappedCryptographicMaterialsProvider(
            wrapping_key=wrapping_key, unwrapping_key=wrapping_key, signing_key=signing_key
        )
    
    def get_materials_provider(self):
        """Get the cryptographic materials provider."""
        return self.materials_provider


class V3KMSProvider(V3ProviderBase):
    """V3 AWS KMS Key Provider."""
    
    def __init__(self):
        """Initialize the KMS provider."""
        self.materials_provider = AwsKmsCryptographicMaterialsProvider(
            key_id=KMS_KEY_ARN
        )
    
    def get_materials_provider(self):
        """Get the cryptographic materials provider."""
        return self.materials_provider


class V3HierarchyProvider(V3ProviderBase):
    """V3 Most Recent Key Provider (equivalent to hierarchy)."""
    
    def __init__(self):
        """Initialize the hierarchy provider."""
        # Create a real table resource for the meta store
        # For performance testing, we'll use a simplified approach without actual DDB operations
        meta_table = boto3.resource("dynamodb", region_name="us-west-2").Table("v2MostRecentKeyProviderPerfTestKeys")

        # Create a crypto materials provider for the meta store using AWS KMS
        # As shown in most_recent_provider_encrypted_table.py example
        aws_kms_cmp = AwsKmsCryptographicMaterialsProvider(key_id=KMS_KEY_ARN)

        # Create a meta store using the AWS KMS crypto materials provider
        meta_store = MetaStore(table=meta_table, materials_provider=aws_kms_cmp)

        # Wrap with MostRecentProvider for hierarchy-like behavior
        self.materials_provider = CachingMostRecentProvider(
            provider_store=meta_store,
            material_name="test_material",
            version_ttl=600.0,  # Check for a new material version every 10 minutes
        )
    
    def get_materials_provider(self):
        """Get the cryptographic materials provider."""
        return self.materials_provider
