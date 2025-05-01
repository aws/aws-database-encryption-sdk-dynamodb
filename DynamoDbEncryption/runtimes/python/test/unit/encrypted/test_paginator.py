# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
import pytest
from mock import MagicMock

from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.encrypted.client import (
    EncryptedPaginator,
)

from botocore.client import BaseClient

pytestmark = [pytest.mark.unit, pytest.mark.local]

mock_boto3_dynamodb_client = MagicMock(__class__=BaseClient)
mock_tables_encryption_config = MagicMock(__class__=DynamoDbTablesEncryptionConfig)

from botocore.paginate import Paginator

from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb_transforms.models import (
    QueryInputTransformOutput,
    QueryInputTransformInput,
)


def test_GIVEN_paginator_not_query_nor_scan_WHEN_paginate_THEN_defers_to_underlying_paginator():
    # Given: A paginator that is not a Query or Scan paginator
    underlying_paginator = MagicMock(__class__=Paginator)
    underlying_paginator._model.name = "NotQueryNorScan"
    non_query_scan_paginator = EncryptedPaginator(
        paginator=underlying_paginator,
        encryption_config=mock_tables_encryption_config,
    )
    # When: Call paginate
    for _ in non_query_scan_paginator.paginate():
        pass  # Drain the generator
    # Then: Call goes to underlying paginator
    underlying_paginator.paginate.assert_called_once()


def test_GIVEN_kwargs_has_PaginationConfig_WHEN_paginate_THEN_PaginationConfig_is_added_back_to_request():
    mock_underlying_paginator = MagicMock(__class__=Paginator)
    mock_underlying_paginator._model.name = "Query"
    paginator = EncryptedPaginator(
        paginator=mock_underlying_paginator,
        encryption_config=mock_tables_encryption_config,
    )
    mock_input_transform_method = MagicMock()
    mock_input_transform_method.return_value = QueryInputTransformOutput(transformed_input={"TableName": "test-table"})
    paginator._transformer.query_input_transform = mock_input_transform_method
    # Given: A kwargs that has a PaginationConfig
    kwargs_without_pagination_config = {
        "TableName": "test-table",
    }
    kwargs_with_pagination_config = {**kwargs_without_pagination_config, "PaginationConfig": {"MaxItems": 10}}
    # When: Call paginate
    for _ in paginator.paginate(**kwargs_with_pagination_config):
        pass  # Drain the generator
    # Then: PaginationConfig is added back to the request sent to the SDK
    mock_underlying_paginator.paginate.assert_called_once_with(**kwargs_with_pagination_config)
    # And: input_transform_method is called with kwargs without PaginationConfig
    mock_input_transform_method.assert_called_once_with(
        QueryInputTransformInput(sdk_input=kwargs_without_pagination_config)
    )
