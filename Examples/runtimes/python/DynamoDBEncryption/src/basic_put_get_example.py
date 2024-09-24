import boto3
from aws_cryptographic_materialproviders.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_materialproviders.mpl.config import MaterialProvidersConfig
from aws_cryptographic_materialproviders.mpl.models import CreateAwsKmsMrkKeyringInput, CreateAwsKmsMrkMultiKeyringInput
from aws_cryptographic_materialproviders.mpl.references import IKeyring

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
    DynamoDbTableEncryptionConfig
)

ddbTableName = "TODO"

table_configs = {}

table_config = DynamoDbTableEncryptionConfig(
    logical_table_name = ddbTableName,
    partition_key_name = "partition_key",
    sort_key_name = "sort_key",
    attribute_actions_on_encrypt = {},
    keyring = kms_mrk_multi_keyring,
    allowed_unsigned_attribute_prefix = unsignAttrPrefix,
)

table_configs[ddbTableName] = table_config

from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    GetItemInputTransformInput
)

get_item = {
    "partition_key": "BasicPutGetExample",
    "sort_key": "0",
}

transformed_get_item = GetItemInputTransformInput(
    get_item
)

