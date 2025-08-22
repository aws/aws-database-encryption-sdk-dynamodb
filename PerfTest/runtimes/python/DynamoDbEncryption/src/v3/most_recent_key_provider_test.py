"""Performance tests for DDBEC v3 with Most Recent Key Provider using EncryptedClient."""

import pytest
from dynamodb_encryption_sdk.material_providers.aws_kms import AwsKmsCryptographicMaterialsProvider
from dynamodb_encryption_sdk.material_providers.most_recent import CachingMostRecentProvider
from dynamodb_encryption_sdk.material_providers.store.meta import MetaStore
import boto3

from ..test_constants import KMS_KEY_ARN, TEST_DATA_CATEGORIES
from .test_base import V3PerformanceTestBase


class V3MostRecentKeyProvider(V3PerformanceTestBase):
    """DDBEC v3 with Most Recent Key Provider using EncryptedClient."""

    def _create_materials_provider(self) -> CachingMostRecentProvider:
        """Create the Most Recent Key Provider."""
        # Create a real table resource for the meta store
        # For performance testing, we'll use a simplified approach without actual DDB operations
        meta_table = boto3.resource("dynamodb", region_name="us-west-2").Table("v2MostRecentKeyProviderPerfTestKeys")

        # Create a crypto materials provider for the meta store using AWS KMS
        # As shown in most_recent_provider_encrypted_table.py example
        aws_kms_cmp = AwsKmsCryptographicMaterialsProvider(key_id=KMS_KEY_ARN)

        # Create a meta store using the AWS KMS crypto materials provider
        meta_store = MetaStore(table=meta_table, materials_provider=aws_kms_cmp)

        # Create and return the Most Recent Provider
        # For performance testing, this will work without actual DDB calls
        # as we're only testing the encryption/decryption performance
        return CachingMostRecentProvider(
            provider_store=meta_store,
            material_name="test_material",
            version_ttl=600.0,  # Check for a new material version every 10 minutes
        )


# Create a singleton instance
_test_instance = None


def get_test_instance():
    """Get or create the test instance."""
    global _test_instance
    if _test_instance is None:
        _test_instance = V3MostRecentKeyProvider()
    return _test_instance


@pytest.mark.benchmark(group="v3-most-recent-encrypt")
@pytest.mark.v3
@pytest.mark.parametrize("data_type", TEST_DATA_CATEGORIES)
def test_encrypt_performance(benchmark, data_type):
    """Test encryption performance with Most Recent Key Provider."""
    instance = get_test_instance()
    instance.benchmark_encrypt(benchmark, data_type)


@pytest.mark.benchmark(group="v3-most-recent-decrypt")
@pytest.mark.v3
@pytest.mark.parametrize("data_type", TEST_DATA_CATEGORIES)
def test_decrypt_performance(benchmark, data_type):
    """Test decryption performance with Most Recent Key Provider."""
    instance = get_test_instance()
    instance.benchmark_decrypt(benchmark, data_type)
