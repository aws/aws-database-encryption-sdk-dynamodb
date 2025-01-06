import boto3
import botocore
import json
import threading
from typing import Optional

from aws_database_encryption_sdk.transform import (
    dict_to_ddb,
    ddb_to_dict,
)
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.client import (
    DynamoDbEncryptionTransforms
)
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    GetItemInputTransformInput,
    GetItemOutputTransformInput,
    PutItemInputTransformInput,
    PutItemOutputTransformInput,
)

"""
TODOs:
* More operations
* Configurable request storage (TTL, pass in custom, etc)
"""

class InternalEncryptionInterceptor:
    def __init__(
        self,
        *,
        config,
        transformer,
    ):
        self._config = config
        self._transformer = transformer
        # Store request metadata per thread
        # (Is this the right level? I think so...)
        self._request_storage = threading.local()

    def _request_interceptor_python_dicts(self, params, **kwargs):
        # Convert to DDB item, then call request interceptor with DDB item
        python_item = params[item_key_name_for_operation[kwargs["event_name"]]]
        dynamo_item = dict_to_ddb(python_item)
        params[item_key_name_for_operation[kwargs["event_name"]]] = dynamo_item
        return self._request_interceptor(params, **kwargs)

    def _request_interceptor_dynamo_dicts(self, params, **kwargs):
        # Item is in expected format for transformer; call request_interceptor directly
        return self._request_interceptor(params, **kwargs)

    def _request_interceptor(self, params, **kwargs):
        event_name: str = kwargs["event_name"]
        print(f"{event_name=}")

        if event_name == "provide-client-params.dynamodb.PutItem":
            transformed_request = self._transformer.put_item_input_transform(
                PutItemInputTransformInput(
                    sdk_input = params
                )
            ).transformed_input
            print(f"put {transformed_request=}")
            return transformed_request
        elif event_name == "provide-client-params.dynamodb.GetItem":
            transformed_request = self._transformer.get_item_input_transform(
                GetItemInputTransformInput(
                    sdk_input = params
                )
            ).transformed_input
            return transformed_request
        # TODO: More operations

    def _response_interceptor_python_dicts(self, http_response, parsed, model, **kwargs):
        # If using Python dicts, convert any outputs to Python dicts

        self._response_interceptor(http_response, parsed, model, **kwargs)

        event_name = kwargs["event_name"]

        if event_name in ["after-call.dynamodb.GetItem"]:
            dynamo_item = parsed["Item"]
            python_item = ddb_to_dict(dynamo_item)
            parsed["Item"].clear()
            parsed["Item"].update(python_item)
        # TODO: more operations

    def _response_interceptor_dynamo_dicts(self, http_response, parsed, model, **kwargs):
        self._response_interceptor(http_response, parsed, model, **kwargs)

    def _response_interceptor(self, http_response, parsed, model, **kwargs):
        self.modify_response(http_response, parsed, model, **kwargs)

    def modify_response(self, http_response, parsed, model, **kwargs):
        # Get `original_request` from local storage
        serialized_request = self._request_storage.request
        deserialized_request = serialized_request.decode('utf-8')
        original_request = json.loads(deserialized_request)
        del self._request_storage.request

        sdk_output = parsed

        event_name: str = kwargs["event_name"]
        if event_name == "after-call.dynamodb.GetItem":
            transformed_response = self._transformer.get_item_output_transform(
                GetItemOutputTransformInput(
                    original_input = original_request,
                    sdk_output = sdk_output,
                )
            ).transformed_output
            # boto3 interceptor expects output in `parsed` parameter
            parsed.clear()
            parsed.update(transformed_response)
        # TODO: more operations

    def request_created_interceptor(self, request, operation_name, **kwargs):
        # Store the original request to be used in response processing
        self._request_storage.request = request.__dict__["data"]

def register_encryption_interceptor(
    *,
    client: botocore.client.BaseClient,
    encryption_configs: DynamoDbTablesEncryptionConfig,
    expect_standard_dictionaries: Optional[bool] = False
):
    """Registers Database Encryption SDK for DynamoDB encryption/decryption methods on `client`.
    Passing a boto3 DynamoDB client into this method will configure transparent encryption on its calls.

    >>> client = boto3.client("dynamodb")
    >>> tables_config = DynamoDbTablesEncryptionConfig(...)
    >>> register_encryption_interceptor(
    ...     client = client,
    ...     encryption_configs = tables_config,
    ... )
    """
    client_event_system = client.meta.events
    internal_transformer = DynamoDbEncryptionTransforms(encryption_configs)
    internal_interceptor = InternalEncryptionInterceptor(
        config = encryption_configs,
        transformer = internal_transformer
    )
    if expect_standard_dictionaries:
        # Register interceptors that expect native Python dictionaries
        client_event_system.register('provide-client-params.dynamodb', internal_interceptor._request_interceptor_python_dicts)
        client_event_system.register('after-call.dynamodb.*', internal_interceptor._response_interceptor_python_dicts)
    else:
        # Register interceptors that expect DDB JSON dictionaries
        client_event_system.register('provide-client-params.dynamodb.*', internal_interceptor._request_interceptor_dynamo_dicts)
        client_event_system.register('after-call.dynamodb.*', internal_interceptor._response_interceptor_dynamo_dicts)
    # Register any interceptors that don't care about dictionary format
    client_event_system.register('request-created.dynamodb.*', internal_interceptor.request_created_interceptor)
    
# TODO: refactor
item_key_name_for_operation = {
    "provide-client-params.dynamodb.PutItem": "Item",
    "provide-client-params.dynamodb.GetItem": "Key",
}
