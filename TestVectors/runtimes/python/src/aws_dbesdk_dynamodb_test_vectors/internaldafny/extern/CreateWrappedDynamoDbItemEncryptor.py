import boto3
import aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.CreateWrappedItemEncryptor
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy import aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DynamoDbItemEncryptorConfig
from aws_dbesdk_dynamodb.encrypted.item import ItemEncryptor
from smithy_dafny_standard_library.internaldafny.generated import Wrappers
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.errors import _smithy_error_to_dafny_error
from aws_dbesdk_dynamodb_test_vectors.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.shim import DynamoDbItemEncryptorShim
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models import (
    DecryptItemInput,
    EncryptItemInput,
)

# In contrast to 

class default__:
    @staticmethod
    def CreateWrappedItemEncryptor(dafny_encryption_config):
        try:
            native_encryption_config = aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DynamoDbItemEncryptorConfig(dafny_encryption_config)
            item_encryptor = ItemEncryptor(
                item_encryptor_config = native_encryption_config,
            )
            return Wrappers.Result_Success(DynamoDbItemEncryptorShim(item_encryptor))
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))

aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.CreateWrappedItemEncryptor.default__ = default__
