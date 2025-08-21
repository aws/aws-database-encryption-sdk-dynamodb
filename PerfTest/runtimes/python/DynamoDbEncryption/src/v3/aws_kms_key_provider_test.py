"""Performance tests for DDBEC v3 with AWS KMS Key Provider using EncryptedClient."""

import pytest
from dynamodb_encryption_sdk.material_providers.aws_kms import AwsKmsCryptographicMaterialsProvider

from ..test_constants import KMS_KEY_ARN, TEST_DATA_CATEGORIES
from .test_base import V3PerformanceTestBase


class V3AWSKMSKeyProvider(V3PerformanceTestBase):
    """DDBEC v3 with AWS KMS Key Provider using EncryptedClient."""

    def _create_materials_provider(self) -> AwsKmsCryptographicMaterialsProvider:
        """Create the AWS KMS-based cryptographic materials provider."""
        # Create crypto materials provider using the specified AWS KMS key
        # As shown in aws_kms_encrypted_client.py example
        return AwsKmsCryptographicMaterialsProvider(key_id=KMS_KEY_ARN)


# Create a singleton instance
_test_instance = None


def get_test_instance():
    """Get or create the test instance."""
    global _test_instance
    if _test_instance is None:
        _test_instance = V3AWSKMSKeyProvider()
    return _test_instance


@pytest.mark.benchmark(group="v3-kms-encrypt")
@pytest.mark.v3
@pytest.mark.parametrize("data_type", TEST_DATA_CATEGORIES)
def test_encrypt_performance(benchmark, data_type):
    """Test encryption performance with AWS KMS Key Provider."""
    instance = get_test_instance()
    instance.benchmark_encrypt(benchmark, data_type)


@pytest.mark.benchmark(group="v3-kms-decrypt")
@pytest.mark.v3
@pytest.mark.parametrize("data_type", TEST_DATA_CATEGORIES)
def test_decrypt_performance(benchmark, data_type):
    """Test decryption performance with AWS KMS Key Provider."""
    instance = get_test_instance()
    instance.benchmark_decrypt(benchmark, data_type)
