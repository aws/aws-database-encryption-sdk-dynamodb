from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateAwsKmsMrkMultiKeyringInput,
    DBEAlgorithmSuiteId,
)
from aws_cryptographic_material_providers.mpl.references import IKeyring

from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.config import (
    DynamoDbItemEncryptorConfig,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models import (
    CryptoAction,
)

MPL_CLIENT: AwsCryptographicMaterialProviders = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())
INTEG_TEST_DEFAULT_KMS_KEY_ID = "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"
INTEG_TEST_DEFAULT_KEYRING: IKeyring = MPL_CLIENT.create_aws_kms_mrk_multi_keyring(
    CreateAwsKmsMrkMultiKeyringInput(
        generator=INTEG_TEST_DEFAULT_KMS_KEY_ID,
    )
)
INTEG_TEST_DEFAULT_ATTRIBUTE_ACTIONS_ON_ENCRYPT = {
    "partition_key": CryptoAction.SIGN_ONLY,
    "sort_key": CryptoAction.SIGN_ONLY,
    "attribute1": CryptoAction.ENCRYPT_AND_SIGN,
    "attribute2": CryptoAction.SIGN_ONLY,
    ":attribute3": CryptoAction.DO_NOTHING,
}
INTEG_TEST_DEFAULT_UNSIGNED_ATTRIBUTE_PREFIX: str = ":"

INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME = "DynamoDbEncryptionInterceptorTestTable"
INTEG_TEST_DEFAULT_PARTITION_KEY_NAME = "partition_key"
INTEG_TEST_DEFAULT_SORT_KEY_NAME = "sort_key"
INTEG_TEST_DEFAULT_ALGORITHM_SUITE_ID = (
    DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384
)
INTEG_TEST_DEFAULT_TABLE_CONFIG = DynamoDbTableEncryptionConfig(
    logical_table_name=INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
    partition_key_name=INTEG_TEST_DEFAULT_PARTITION_KEY_NAME,
    sort_key_name=INTEG_TEST_DEFAULT_SORT_KEY_NAME,
    attribute_actions_on_encrypt=INTEG_TEST_DEFAULT_ATTRIBUTE_ACTIONS_ON_ENCRYPT,
    keyring=INTEG_TEST_DEFAULT_KEYRING,
    allowed_unsigned_attribute_prefix=INTEG_TEST_DEFAULT_UNSIGNED_ATTRIBUTE_PREFIX,
    algorithm_suite_id=INTEG_TEST_DEFAULT_ALGORITHM_SUITE_ID,
)
INTEG_TEST_DEFAULT_TABLE_CONFIGS = DynamoDbTablesEncryptionConfig(
    table_encryption_configs={INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME: INTEG_TEST_DEFAULT_TABLE_CONFIG}
)
INTEG_TEST_DEFAULT_ITEM_ENCRYPTOR_CONFIG = DynamoDbItemEncryptorConfig(
    logical_table_name=INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
    partition_key_name=INTEG_TEST_DEFAULT_PARTITION_KEY_NAME,
    sort_key_name=INTEG_TEST_DEFAULT_SORT_KEY_NAME,
    attribute_actions_on_encrypt=INTEG_TEST_DEFAULT_ATTRIBUTE_ACTIONS_ON_ENCRYPT,
    keyring=INTEG_TEST_DEFAULT_KEYRING,
    algorithm_suite_id=INTEG_TEST_DEFAULT_ALGORITHM_SUITE_ID,
    allowed_unsigned_attribute_prefix=INTEG_TEST_DEFAULT_UNSIGNED_ATTRIBUTE_PREFIX,
)
