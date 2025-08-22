"""Performance tests for DB-ESDK v4 with Raw AES Keyring using EncryptedClient."""

import pytest
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    AesWrappingAlg,
    CreateRawAesKeyringInput,
)
from aws_cryptographic_material_providers.mpl.references import IKeyring

from ..test_constants import AES_256_KEY_MATERIAL, TEST_DATA_CATEGORIES
from .test_base import V4PerformanceTestBase


class V4RawAESKeyring(V4PerformanceTestBase):
    """DB-ESDK v4 with Raw AES Keyring using EncryptedClient."""

    def _create_keyring(self) -> IKeyring:
        """Create the Raw AES Keyring as shown in raw_aes_keyring_example."""
        # Create Material Providers instance
        mat_prov = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())

        # Create Raw AES Keyring input matching the example
        keyring_input = CreateRawAesKeyringInput(
            key_name="my-aes-key-name",
            key_namespace="my-key-namespace",
            wrapping_key=AES_256_KEY_MATERIAL,
            wrapping_alg=AesWrappingAlg.ALG_AES256_GCM_IV12_TAG16,
        )

        # Create and return the keyring
        return mat_prov.create_raw_aes_keyring(input=keyring_input)


# Create a singleton instance
_test_instance = None


def get_test_instance():
    """Get or create the test instance."""
    global _test_instance
    if _test_instance is None:
        _test_instance = V4RawAESKeyring()
    return _test_instance


@pytest.mark.benchmark(group="v4-raw-aes-encrypt")
@pytest.mark.v4
@pytest.mark.parametrize("data_type", TEST_DATA_CATEGORIES)
def test_encrypt_performance(benchmark, data_type):
    """Test encryption performance with Raw AES Keyring."""
    instance = get_test_instance()
    instance.benchmark_encrypt(benchmark, data_type)


@pytest.mark.benchmark(group="v4-raw-aes-decrypt")
@pytest.mark.v4
@pytest.mark.parametrize("data_type", TEST_DATA_CATEGORIES)
def test_decrypt_performance(benchmark, data_type):
    """Test decryption performance with Raw AES Keyring."""
    instance = get_test_instance()
    instance.benchmark_decrypt(benchmark, data_type)
