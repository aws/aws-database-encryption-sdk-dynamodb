"""Performance tests for DDBEC v3 with AES Key Provider using EncryptedClient."""

import pytest
from dynamodb_encryption_sdk.delegated_keys.jce import JceNameLocalDelegatedKey
from dynamodb_encryption_sdk.identifiers import EncryptionKeyType, KeyEncodingType
from dynamodb_encryption_sdk.material_providers.wrapped import WrappedCryptographicMaterialsProvider

from ..test_constants import AES_256_KEY_MATERIAL, TEST_DATA_CATEGORIES
from .test_base import V3PerformanceTestBase


class V3AESKeyProvider(V3PerformanceTestBase):
    """DDBEC v3 with AES Key Provider using EncryptedClient."""

    def _create_materials_provider(self) -> WrappedCryptographicMaterialsProvider:
        """Create the AES-based cryptographic materials provider."""
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

        # Create and return the wrapped materials provider
        return WrappedCryptographicMaterialsProvider(
            wrapping_key=wrapping_key, unwrapping_key=wrapping_key, signing_key=signing_key
        )


# Create a singleton instance
_test_instance = None


def get_test_instance():
    """Get or create the test instance."""
    global _test_instance
    if _test_instance is None:
        _test_instance = V3AESKeyProvider()
    return _test_instance


@pytest.mark.benchmark(group="v3-aes-encrypt")
@pytest.mark.v3
@pytest.mark.parametrize("data_type", TEST_DATA_CATEGORIES)
def test_encrypt_performance(benchmark, data_type):
    """Test encryption performance with AES Key Provider."""
    instance = get_test_instance()
    instance.benchmark_encrypt(benchmark, data_type)


@pytest.mark.benchmark(group="v3-aes-decrypt")
@pytest.mark.v3
@pytest.mark.parametrize("data_type", TEST_DATA_CATEGORIES)
def test_decrypt_performance(benchmark, data_type):
    """Test decryption performance with AES Key Provider."""
    instance = get_test_instance()
    instance.benchmark_decrypt(benchmark, data_type)
