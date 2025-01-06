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

from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms
)

transforms_client = DynamoDbEncryptionTransforms(
    config = tables_config
)

item_to_encrypt = {
    "partition_key": "LucasPythonTesting",
    "sort_key": "StillLucasPythonTesting",
}

def transform_item_for_localservice(native_item):
    """
    Transforms a native Python dictionary into a DynamoDB item format
    with attribute value objects (e.g., {"S": "value"} for strings).
    This version supports all known boto3 DynamoDB types including decimal.Decimal.
    """
    dynamodb_item = {}
    
    for key, value in native_item.items():
        if isinstance(value, str):  # For strings
            dynamodb_item[key] = {"S": value}
        elif isinstance(value, int):  # For integers
            dynamodb_item[key] = {"N": str(value)}  # DynamoDB expects numbers as strings
        elif isinstance(value, float):  # For floats
            dynamodb_item[key] = {"N": str(value)}
        elif isinstance(value, bool):  # For booleans
            dynamodb_item[key] = {"BOOL": value}
        elif isinstance(value, list):  # For lists
            dynamodb_item[key] = {"L": [transform_item_for_localservice(v) if isinstance(v, dict) else {"S": str(v)} for v in value]}
        elif isinstance(value, dict):  # For nested dictionaries (maps)
            dynamodb_item[key] = {"M": transform_item_for_localservice(value)}
        elif isinstance(value, bytes):  # For bytes
            dynamodb_item[key] = {"B": value}
        elif isinstance(value, Binary):  # For Binary() objects from boto3
            dynamodb_item[key] = {"B": value.value}  # Extract the raw bytes from Binary object
        elif isinstance(value, Decimal):  # For Decimal (used in DynamoDB for precision)
            dynamodb_item[key] = {"N": str(value)}  # Store as string for consistency
        elif value is None:  # For None (NULL values in DynamoDB)
            dynamodb_item[key] = {"NULL": True}
        else:
            # Handle unsupported types (optional, raise an exception if needed)
            raise ValueError(f"Unsupported data type: {type(value)} for value: {value}")
    
    return dynamodb_item

item_to_encrypt = {
    "partition_key": "LucasPythonTesting",
    "sort_key": 1234,
}

transformed_item = transform_item_for_localservice(item_to_encrypt)
# print(f"{transformed_item=}")

put_item = {
    "TableName": ddb_table_name,
    "Item": transformed_item
}

put_item_transform_input = PutItemInputTransformInput(
    sdk_input = put_item
)

transformed_put_item = transforms_client.put_item_input_transform(
    put_item_transform_input
)

# print(f"{transformed_put_item=}")

encrypted_item = transformed_put_item.transformed_input["Item"]

# put to tabel

def transform_from_dynamodb_item(dynamodb_item):
    """
    Transforms a DynamoDB item (with attribute value objects) back into a
    native Python dictionary.
    """
    python_item = {}
    
    for key, value in dynamodb_item.items():
        # Handling different DynamoDB types and extracting their values
        if 'S' in value:  # For strings
            python_item[key] = value['S']
        elif 'N' in value:  # For numbers (integers or floats)
            python_item[key] = float(value['N']) if '.' in value['N'] else int(value['N'])
        elif 'BOOL' in value:  # For booleans
            python_item[key] = value['BOOL']
        elif 'L' in value:  # For lists
            python_item[key] = [transform_from_dynamodb_item(v) if isinstance(v, dict) else v['S'] for v in value['L']]
        elif 'M' in value:  # For nested maps (dictionaries)
            python_item[key] = transform_from_dynamodb_item(value['M'])
        elif 'B' in value:  # For binary (B)
            # Return binary data as bytes
            python_item[key] = value['B']
        else:
            # Handle unsupported or unexpected types (optional)
            raise ValueError(f"Unsupported DynamoDB attribute value format: {value}")
    
    return python_item

encrypted_native_item = transform_from_dynamodb_item(encrypted_item)
# print(f"{encrypted_native_item=}")

table = boto3.resource("dynamodb").Table(ddb_table_name)
table.put_item(Item=encrypted_native_item)

# get from table

get_item_output = table.get_item(
    Key = item_to_encrypt
)

# print(f"{get_item_output["Item"]=}")

transformed_get_item_output = transform_item_for_localservice(get_item_output["Item"])

print(f"{transformed_get_item_output=}")

get_item_output_transform_input = GetItemOutputTransformInput(
    original_input = {
        "TableName": ddb_table_name,
        "Key": {
           "partition_key": {"S": "LucasPythonTesting"},
            "sort_key": {"S": "StillLucasPythonTesting"},
        }
    },
    sdk_output = {
        "Item": transformed_get_item_output
    }
)

out = transforms_client.get_item_output_transform(
    get_item_output_transform_input
)

print(f"{out=}")