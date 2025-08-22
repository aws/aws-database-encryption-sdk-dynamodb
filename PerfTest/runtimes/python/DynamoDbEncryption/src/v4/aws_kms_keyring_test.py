"""Performance tests for DB-ESDK v4 with AWS KMS Keyring using EncryptedClient."""
import boto3
import pytest
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import CreateAwsKmsMrkMultiKeyringInput
from aws_cryptographic_material_providers.mpl.references import IKeyring

from ..test_constants import KMS_KEY_ARN, TEST_DATA_CATEGORIES
from .test_base import V4PerformanceTestBase


class V4AWSKMSKeyring(V4PerformanceTestBase):
    """DB-ESDK v4 with AWS KMS Keyring."""

    def _create_keyring(self) -> IKeyring:
        """Create the AWS KMS Keyring as shown in basic_put_get_example."""
        # Create Material Providers instance
        mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

        # Create AWS KMS MRK Multi Keyring input
        # We use the CreateMrkMultiKeyring method as it correctly handles both
        # single region and Multi-Region KMS Keys
        kms_mrk_multi_keyring_input = CreateAwsKmsMrkMultiKeyringInput(
            generator=KMS_KEY_ARN,
        )

        # Create and return the keyring
        return mat_prov.create_aws_kms_mrk_multi_keyring(input=kms_mrk_multi_keyring_input)


# Create a singleton instance
_test_instance = None
_kms_client = boto3.client("kms")

def get_test_instance():
    """Get or create the test instance."""
    global _test_instance
    if _test_instance is None:
        _test_instance = V4AWSKMSKeyring()
    return _test_instance


@pytest.mark.benchmark(group="v4-kms-encrypt")
@pytest.mark.v4
@pytest.mark.parametrize("data_type", TEST_DATA_CATEGORIES)
def test_encrypt_performance(benchmark, data_type):
    """Test encryption performance with AWS KMS Keyring."""
    instance = get_test_instance()
    instance.benchmark_encrypt(benchmark, data_type)


@pytest.mark.benchmark(group="v4-kms-decrypt")
@pytest.mark.v4
@pytest.mark.parametrize("data_type", TEST_DATA_CATEGORIES)
def test_decrypt_performance(benchmark, data_type):
    """Test decryption performance with AWS KMS Keyring."""
    instance = get_test_instance()
    instance.benchmark_decrypt(benchmark, data_type)
