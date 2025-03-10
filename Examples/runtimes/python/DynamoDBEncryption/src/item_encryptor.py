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

from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.config import (
    DynamoDbItemEncryptorConfig,
)

ddb_table_name = "DynamoDbEncryptionInterceptorTestTable"

item_encryptor_config = DynamoDbItemEncryptorConfig(
    logical_table_name = ddb_table_name,
    partition_key_name = "partition_key",
    sort_key_name = "sort_key",
    attribute_actions_on_encrypt = attribute_actions_on_encrypt,
    keyring = kms_mrk_multi_keyring,
    allowed_unsigned_attribute_prefix = unsignAttrPrefix,
    algorithm_suite_id = DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384,
)

from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    GetItemOutputTransformInput,
    PutItemInputTransformInput
)

from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms
)
from aws_database_encryption_sdk.encrypted.item import ItemEncryptor

item_encryptor = ItemEncryptor(
    item_encryptor_config = item_encryptor_config
)

item_to_encrypt = {
    "partition_key": "LucasPythonTesting",
    "sort_key": 1234,
}

encrypted_item = item_encryptor.encrypt_python_item(item_to_encrypt)

assert encrypted_item != item_to_encrypt

table = boto3.resource("dynamodb").Table(ddb_table_name)
table.put_item(Item=encrypted_item.encrypted_item)

get_item_output = table.get_item(
    Key = item_to_encrypt
)

decrypted_item = item_encryptor.decrypt_python_item(get_item_output["Item"])

assert decrypted_item.plaintext_item == item_to_encrypt