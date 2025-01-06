import boto3
from boto3.dynamodb.types import Binary
from decimal import Decimal

from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateAwsKmsMrkKeyringInput,
    CreateAwsKmsMrkMultiKeyringInput,
    DBEAlgorithmSuiteId,
)
from aws_cryptographic_material_providers.mpl.references import IKeyring
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models import (
    CryptoAction,
)

mat_prov: AwsCryptographicMaterialProviders = AwsCryptographicMaterialProviders(
    config=MaterialProvidersConfig()
)

kms_key_id = "arn:aws:kms:us-west-2:658956600833:key/b3537ef1-d8dc-4780-9f5a-55776cbb2f7f"
mrk_key_id = "arn:aws:kms:us-west-2:658956600833:key/mrk-80bd8ecdcd4342aebd84b7dc9da498a7"

kms_mrk_multi_keyring_input: CreateAwsKmsMrkMultiKeyringInput =\
    CreateAwsKmsMrkMultiKeyringInput(
        generator=mrk_key_id,
        kms_key_ids=[kms_key_id]
    )

kms_mrk_multi_keyring: IKeyring = mat_prov.create_aws_kms_mrk_multi_keyring(
    input=kms_mrk_multi_keyring_input
)

attribute_actions_on_encrypt = {
    "partition_key": CryptoAction.SIGN_ONLY,
    "sort_key": CryptoAction.SIGN_ONLY,
    "attribute1": CryptoAction.ENCRYPT_AND_SIGN,
    "attribute2": CryptoAction.SIGN_ONLY,
    ":attribute3": CryptoAction.DO_NOTHING,
}

# 2. Create encryption context.
# Remember that your encryption context is NOT SECRET.
# For more information, see
# https://docs.aws.amazon.com/encryption-sdk/latest/developer-guide/concepts.html#encryption-context
encryption_context = {
    "encryption": "context",
    "is not": "secret",
    "but adds": "useful metadata",
    "that can help you": "be confident that",
    "the data you are handling": "is what you think it is",
}

unsignAttrPrefix: str = ":"

from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)

ddb_table_name = "DynamoDbEncryptionInterceptorTestTable"

table_configs = {}

table_config = DynamoDbTableEncryptionConfig(
    logical_table_name = ddb_table_name,
    partition_key_name = "partition_key",
    sort_key_name = "sort_key",
    attribute_actions_on_encrypt = attribute_actions_on_encrypt,
    keyring = kms_mrk_multi_keyring,
    allowed_unsigned_attribute_prefix = unsignAttrPrefix,
    algorithm_suite_id = DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384,
)

table_configs[ddb_table_name] = table_config

tables_config = DynamoDbTablesEncryptionConfig(
    table_encryption_configs = table_configs
)

from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    GetItemOutputTransformInput,
    PutItemInputTransformInput
)

item_to_encrypt = {
    "partition_key": "LucasPythonTesting",
    "sort_key": 1234,
    "attribute1": "abc"
}

# "Main"

boto3_client = boto3.client("dynamodb")

from aws_database_encryption_sdk.encryptor.interceptor import (
    register_encryption_interceptor
)

register_encryption_interceptor(
    client = boto3_client,
    encryption_configs = tables_config,
    expect_standard_dictionaries = True
)

put_item = {
    "TableName": ddb_table_name,
    "Item": item_to_encrypt,
}

put_item_output = boto3_client.put_item(**put_item)

get_item_key = {
    "partition_key": "LucasPythonTesting",
    "sort_key": 1234,
}

get_item = {
    "TableName": ddb_table_name,
    "Key": get_item_key
}

get_item_output = boto3_client.get_item(**get_item)

assert get_item_output["Item"] == item_to_encrypt
