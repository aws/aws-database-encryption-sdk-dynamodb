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
from aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_database_encryption_sdk.encrypted.client import (
    EncryptedClient
)
from ...constants import (
    INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
    INTEG_TEST_DEFAULT_TABLE_CONFIGS,
)
from ...items import simple_item_ddb
from ...requests import get_scan_request, get_query_request

BOTO3_CLIENT = boto3.client("dynamodb")
ENCRYPTED_CLIENT = EncryptedClient(
    client=BOTO3_CLIENT,
    encryption_config=INTEG_TEST_DEFAULT_TABLE_CONFIGS
)
SCAN_PAGINATOR = ENCRYPTED_CLIENT.get_paginator("scan")
QUERY_PAGINATOR = ENCRYPTED_CLIENT.get_paginator("query")
# TODO: this is a scary thought, but I should explore this
# BOTO3_CLIENT_FROM_TABLE = boto3.client("dynamodb", region_name="us-east-1").Table(INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME)

import pytest

# @pytest.fixture
# def default_requests(simple_item_ddb):
#     """Fixture to provide default scan and query requests."""
#     return {
#         "scan": get_scan_request(simple_item_ddb["partition_key"]),
#         "query": get_query_request(simple_item_ddb["partition_key"]),
#     }

# @pytest.fixture(scope="module", autouse=True)
# def setup_module_fixture(simple_item_ddb):
#     # Runs before all tests in this module
#     for i in range(10):
#         ENCRYPTED_CLIENT.put_item(
#             TableName=INTEG_TEST_DEFAULT_DYNAMODB_TABLE_NAME,
#             Item={
#                 "partition_key": simple_item_ddb["partition_key"],
#                 "sort_key": {"N": str(i)},
#                 "attribute1": {"S": "encrypt and sign me!"},
#                 "attribute2": {"S": "sign me!"},
#                 ":attribute3": {"S": "ignore me!"},
#             },
#         )
#     # Yield to all tests in this module
#     yield
#     # TODO: Delete items? not needed but nice

# @pytest.mark.parametrize("paginator_name, request_key", [
#     ("scan", "scan"),
#     ("query", "query")
# ])
# def test_GIVEN_incomplete_search_WHEN_build_full_result_THEN_NextToken_completes_search(
#     paginator_name,
#     request_key,
#     default_requests,
# ):
#     # TODO: test
#     return
#     # Given: PaginationConfig that will result in an incomplete search.
#     # There are 10 items, and returning 2 per operation results in multiple uses of NextToken.
#     pagination_config = {
#         "MaxItems": 2,
#     }

#     paginator = getattr(ENCRYPTED_CLIENT, f"get_paginator")(paginator_name)
#     incomplete_search_request = default_requests[request_key].copy()
#     incomplete_search_request["PaginationConfig"] = pagination_config

#     # When: Build full result from paginator
#     full_result = paginator.paginate(**incomplete_search_request)

#     print(f"{full_result=}")

#     collected_items = []

#     print(f'{full_result=}')

#     for item in full_result:
#         # assert item["attribute1"]["S"] == "encrypt and sign me!"
#         collected_items.append(item)

#     # Then: NextToken should be present
#     # assert "NextToken" in full_result
#     # Then: NextToken is able to complete the search
