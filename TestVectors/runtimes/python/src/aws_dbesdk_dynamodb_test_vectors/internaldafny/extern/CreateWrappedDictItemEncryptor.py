import boto3
import aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.CreateWrappedItemEncryptor
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy import aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DynamoDbItemEncryptorConfig
from aws_dbesdk_dynamodb.encrypted.item import ItemEncryptor
from smithy_dafny_standard_library.internaldafny.generated import Wrappers
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.errors import _smithy_error_to_dafny_error
from aws_dbesdk_dynamodb_test_vectors.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.shim import DynamoDbItemEncryptorShim
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.models import (
    DecryptItemInput,
    DecryptItemOutput,
    EncryptItemInput,
    EncryptItemOutput,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.smithy_to_dafny import (
    aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemOutput as SmithyToDafnyEncryptItemOutput,
    aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemOutput as SmithyToDafnyDecryptItemOutput,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor.dafny_to_smithy import (
    aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_EncryptItemInput as DafnyToSmithyEncryptItemInput,
    aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DecryptItemInput as DafnyToSmithyDecryptItemInput,
)
from aws_dbesdk_dynamodb.transform import (
    dict_to_ddb,
    ddb_to_dict,
)

class DynamoDBFormatToDictFormatWrapper:
    """
    Crypto Tools Internal wrapper class to test Python dictionary-formatted ItemEncryptor paths.

    Dafny TestVectors provide DynamoDB-formatted items to ItemEncryptors' encrypt_item and decrypt_item methods.
    However, the legacy Python DDBEC ItemEncryptor also supports Python dictionary-formatted items.
    This class transforms Dafny TestVectors' DynamoDB-formatted items
        to Python DBESDK's ItemEncryptor's Python dictionary-formatted encryption methods.
    """
    def __init__(self, item_encryptor):
        self._item_encryptor = item_encryptor
    
    def encrypt_item(self, encrypt_item_input):
        # Convert DynamoDB-formatted item to dict-formatted item
        dynamodb_plaintext_item = encrypt_item_input.plaintext_item
        python_plaintext_item = ddb_to_dict(dynamodb_plaintext_item)
        # Call native ItemEncryptor wrapper dict-formatted encryption method
        encrypt_item_output_dict = self._item_encryptor.encrypt_python_item(python_plaintext_item)
        python_encrypted_item = encrypt_item_output_dict.encrypted_item
        # Convert dict-formatted encrypted item to DynamoDB-formatted encrypted item
        dynamodb_encrypted_item = dict_to_ddb(python_encrypted_item)
        encrypt_item_output_dynamodb = EncryptItemOutput(
            encrypted_item = dynamodb_encrypted_item,
            parsed_header = encrypt_item_output_dict.parsed_header
        )
        # Surface DynamoDB-formatted encrypted item to Dafny TestVectors
        return encrypt_item_output_dynamodb

    def decrypt_item(self, decrypt_item_input):
        # Convert DynamoDB-formatted item to dict-formatted item
        dynamodb_encrypted_item = decrypt_item_input.encrypted_item
        python_encrypted_item = ddb_to_dict(dynamodb_encrypted_item)
        # Call native ItemEncryptor wrapper dict-formatted encryption method
        decrypt_item_output_dict = self._item_encryptor.decrypt_python_item(python_encrypted_item)
        python_plaintext_item = decrypt_item_output_dict.plaintext_item
        # Convert dict-formatted plaintext item to DynamoDB-formatted plaintext item
        dynamodb_plaintext_item = dict_to_ddb(python_plaintext_item)
        decrypt_item_output_dynamodb = DecryptItemOutput(
            plaintext_item = dynamodb_plaintext_item,
            parsed_header = decrypt_item_output_dict.parsed_header
        )
        # Surface DynamoDB-formatted plaintext item to Dafny TestVectors
        return decrypt_item_output_dynamodb

class default__:
    @staticmethod
    def CreateWrappedItemEncryptor(dafny_encryption_config):
        try:
            native_encryption_config = aws_cryptography_dbencryptionsdk_dynamodb_itemencryptor_DynamoDbItemEncryptorConfig(dafny_encryption_config)
            item_encryptor = ItemEncryptor(
                item_encryptor_config = native_encryption_config,
            )
            wrapped_item_encryptor = DynamoDBFormatToDictFormatWrapper(
                item_encryptor
            )
            return Wrappers.Result_Success(DynamoDbItemEncryptorShim(wrapped_item_encryptor))
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))

aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.CreateWrappedItemEncryptor.default__ = default__
