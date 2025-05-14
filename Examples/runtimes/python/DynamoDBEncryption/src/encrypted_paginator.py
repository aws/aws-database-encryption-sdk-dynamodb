# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
"""
Example for using an EncryptedPaginator to scan and query an encrypted table.

Running this example requires access to the DDB Table whose name
is provided in the function arguments.
This table must be configured with the following
primary key configuration:
- Partition key is named "partition_key" with type (S)
- Sort key is named "sort_key" with type (N)

For more information on paginating the Scan operation, see:
https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Scan.html#Scan.Pagination
For more information on paginating the Query operation, see:
https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/Query.Pagination.html
"""

import boto3
from aws_cryptographic_material_providers.mpl import AwsCryptographicMaterialProviders
from aws_cryptographic_material_providers.mpl.config import MaterialProvidersConfig
from aws_cryptographic_material_providers.mpl.models import (
    CreateAwsKmsMrkMultiKeyringInput,
    DBEAlgorithmSuiteId,
)
from aws_cryptographic_material_providers.mpl.references import IKeyring
from aws_dbesdk_dynamodb.encrypted.client import EncryptedClient
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models import (
    DynamoDbTableEncryptionConfig,
    DynamoDbTablesEncryptionConfig,
)
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.models import (
    CryptoAction,
)


def encrypted_paginator_search_example(
    kms_key_id: str,
    dynamodb_table_name: str,
):
    """Use an EncryptedPaginator to scan and query an encrypted table."""
    # 1. Create a Keyring. This Keyring will be responsible for protecting the data keys that protect your data.
    #    For this example, we will create a AWS KMS Keyring with the AWS KMS Key we want to use.
    #    We will use the `CreateMrkMultiKeyring` method to create this keyring,
    #    as it will correctly handle both single region and Multi-Region KMS Keys.
    mat_prov: AwsCryptographicMaterialProviders = AwsCryptographicMaterialProviders(config=MaterialProvidersConfig())
    kms_mrk_multi_keyring_input: CreateAwsKmsMrkMultiKeyringInput = CreateAwsKmsMrkMultiKeyringInput(
        generator=kms_key_id,
    )
    kms_mrk_multi_keyring: IKeyring = mat_prov.create_aws_kms_mrk_multi_keyring(input=kms_mrk_multi_keyring_input)

    # 2. Configure which attributes are encrypted and/or signed when writing new items.
    #    For each attribute that may exist on the items we plan to write to our DynamoDbTable,
    #    we must explicitly configure how they should be treated during item encryption:
    #      - ENCRYPT_AND_SIGN: The attribute is encrypted and included in the signature
    #      - SIGN_ONLY: The attribute not encrypted, but is still included in the signature
    #      - DO_NOTHING: The attribute is not encrypted and not included in the signature
    attribute_actions_on_encrypt = {
        "partition_key": CryptoAction.SIGN_ONLY,
        "sort_key": CryptoAction.SIGN_ONLY,
        "attribute1": CryptoAction.ENCRYPT_AND_SIGN,
        "attribute2": CryptoAction.SIGN_ONLY,
        ":attribute3": CryptoAction.DO_NOTHING,
    }

    # 3. Configure which attributes we expect to be included in the signature
    #    when reading items. There are two options for configuring this:
    #
    #    - (Recommended) Configure `allowedUnsignedAttributesPrefix`:
    #      When defining your DynamoDb schema and deciding on attribute names,
    #      choose a distinguishing prefix (such as ":") for all attributes that
    #      you do not want to include in the signature.
    #      This has two main benefits:
    #      - It is easier to reason about the security and authenticity of data within your item
    #        when all unauthenticated data is easily distinguishable by their attribute name.
    #      - If you need to add new unauthenticated attributes in the future,
    #        you can easily make the corresponding update to your `attributeActionsOnEncrypt`
    #        and immediately start writing to that new attribute, without
    #        any other configuration update needed.
    #      Once you configure this field, it is not safe to update it.
    #
    #    - Configure `allowedUnsignedAttributes`: You may also explicitly list
    #      a set of attributes that should be considered unauthenticated when encountered
    #      on read. Be careful if you use this configuration. Do not remove an attribute
    #      name from this configuration, even if you are no longer writing with that attribute,
    #      as old items may still include this attribute, and our configuration needs to know
    #      to continue to exclude this attribute from the signature scope.
    #      If you add new attribute names to this field, you must first deploy the update to this
    #      field to all readers in your host fleet before deploying the update to start writing
    #      with that new attribute.
    #
    #   For this example, we have designed our DynamoDb table such that any attribute name with
    #   the ":" prefix should be considered unauthenticated.
    unsignAttrPrefix: str = ":"

    # 4. Create the DynamoDb Encryption configuration for the table we will be writing to.
    table_configs = {}
    table_config = DynamoDbTableEncryptionConfig(
        logical_table_name=dynamodb_table_name,
        partition_key_name="partition_key",
        sort_key_name="sort_key",
        attribute_actions_on_encrypt=attribute_actions_on_encrypt,
        keyring=kms_mrk_multi_keyring,
        allowed_unsigned_attribute_prefix=unsignAttrPrefix,
        algorithm_suite_id=DBEAlgorithmSuiteId.ALG_AES_256_GCM_HKDF_SHA512_COMMIT_KEY_ECDSA_P384_SYMSIG_HMAC_SHA384,
    )
    table_configs[dynamodb_table_name] = table_config
    tables_config = DynamoDbTablesEncryptionConfig(table_encryption_configs=table_configs)

    # 5. Create a new AWS SDK DynamoDb client using the TableEncryptionConfigs
    encrypted_client = EncryptedClient(
        client=boto3.client("dynamodb"),
        encryption_config=tables_config,
    )

    # 6. Put 10 items into our table using the above client.
    #    This example will search for these items using EncryptedPaginator operations.
    #    Before the item gets sent to DynamoDb, it will be encrypted
    #    client-side, according to our configuration.
    for i in range(10):
        item_to_encrypt = {
            "partition_key": {"S": "PythonEncryptedPaginatorSearchExample"},
            "sort_key": {"N": str(i)},
            "attribute1": {"S": "encrypt and sign me!"},
            "attribute2": {"S": "sign me!"},
            ":attribute3": {"S": "ignore me!"},
        }

        put_item_request = {
            "TableName": dynamodb_table_name,
            "Item": item_to_encrypt,
        }

        put_item_response = encrypted_client.put_item(**put_item_request)

        # Demonstrate that PutItem succeeded
        assert put_item_response["ResponseMetadata"]["HTTPStatusCode"] == 200

    # 7. Search for the items using the EncryptedPaginator's Scan operation.
    encrypted_scan_paginator = encrypted_client.get_paginator("scan")

    scan_item_request = {
        "TableName": dynamodb_table_name,
        "FilterExpression": "#pk = :name and #attr3 = :ignore",
        "ExpressionAttributeNames": {"#attr3": ":attribute3", "#pk": "partition_key"},
        "ExpressionAttributeValues": {
            ":ignore": {"S": "ignore me!"},
            ":name": {"S": "PythonEncryptedPaginatorSearchExample"},
        },
        "PaginationConfig": {
            # `MaxItems` configures the number of items the paginator will return before stopping the scan.
            # Scans are expensive, and we know that we only added 10 items, so this example will stop at 10.
            # The default is None; i.e. no size limit.
            # We set this for demonstration purposes only, but leaving this unset is recommended for most cases.
            "MaxItems": 10,
            # `PageSize` configures the maximum number of items that will be returned in a single page.
            # The default is to return ~1 MB of data.
            # We set this for demonstration purposes only, but leaving this unset is recommended for most cases.
            "PageSize": 5,
        },
    }

    scan_response_iterator = encrypted_scan_paginator.paginate(**scan_item_request)

    # 8. Iterate over the paginator's response pages.
    #    Each page will contain a list of items.
    #    Each item will have been decrypted by the EncryptedPaginator before being returned here.
    scan_collected_items = []
    for scan_response_page in scan_response_iterator:
        for item in scan_response_page["Items"]:
            scan_collected_items.append(item)

    # 9. Assert that we have received all 10 items correctly.
    # We do this for demonstration purposes only; you do not need to do this in your code.
    assert len(scan_collected_items) == 10
    for scan_collected_item in scan_collected_items:
        assert scan_collected_item["attribute1"] == {"S": "encrypt and sign me!"}

    # 10. Search for the items using the EncryptedPaginator's Query operation.
    encrypted_query_paginator = encrypted_client.get_paginator("query")

    query_item_request = {
        "TableName": dynamodb_table_name,
        "KeyConditionExpression": "#pk = :name",
        "FilterExpression": "#attr3 = :ignore",
        "ExpressionAttributeNames": {"#attr3": ":attribute3", "#pk": "partition_key"},
        "ExpressionAttributeValues": {
            ":ignore": {"S": "ignore me!"},
            ":name": {"S": "PythonEncryptedPaginatorSearchExample"},
        },
    }

    query_response_iterator = encrypted_query_paginator.paginate(**query_item_request)

    # 11. Iterate over the paginator's response pages.
    #     Each page will contain a list of items.
    #     Each item will have been decrypted by the EncryptedPaginator before being returned here.
    query_collected_items = []
    for query_response_page in query_response_iterator:
        for item in query_response_page["Items"]:
            query_collected_items.append(item)

    # 12. Assert that we have received all 10 items correctly.
    # We do this for demonstration purposes only; you do not need to do this in your code.
    assert len(query_collected_items) == 10
    assert query_collected_items[0]["attribute1"] == {"S": "encrypt and sign me!"}
