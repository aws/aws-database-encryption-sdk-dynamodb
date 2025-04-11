import boto3
import aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.CreateInterceptedDDBClient
import aws_cryptography_internal_dynamodb.internaldafny.extern
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy import aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTablesEncryptionConfig
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from smithy_dafny_standard_library.internaldafny.generated import Wrappers
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.errors import _smithy_error_to_dafny_error
from aws_dbesdk_dynamodb_test_vectors.waiting_boto3_ddb_client import WaitingDynamoClient

class default__:
    @staticmethod
    def CreateVanillaDDBClient():
        try:
            return aws_cryptography_internal_dynamodb.internaldafny.extern.Com_Amazonaws_Dynamodb.default__.DynamoDBClient(WaitingDynamoClient())
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))

    @staticmethod
    def CreateInterceptedDDBClient(dafny_encryption_config):
        try:
            native_encryption_config = aws_cryptography_dbencryptionsdk_dynamodb_DynamoDbTablesEncryptionConfig(dafny_encryption_config)
            boto3_client = WaitingDynamoClient()
            encrypted_client = EncryptedClient(client = boto3_client, encryption_config = native_encryption_config)
            return aws_cryptography_internal_dynamodb.internaldafny.extern.Com_Amazonaws_Dynamodb.default__.DynamoDBClient(encrypted_client)
        except Exception as e:
            return Wrappers.Result_Failure(_smithy_error_to_dafny_error(e))

aws_dbesdk_dynamodb_test_vectors.internaldafny.generated.CreateInterceptedDDBClient.default__ = default__
