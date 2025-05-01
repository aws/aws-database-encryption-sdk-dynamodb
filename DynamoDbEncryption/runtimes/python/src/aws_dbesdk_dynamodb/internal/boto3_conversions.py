from abc import ABC, abstractmethod


class BotoInterfaceShapeConverter(ABC):
    """
    Class modelling transformations between boto3 DynamoDB client and resource shapes.

    DBESDK for DynamoDB provides encrypted interfaces for boto3 DynamoDB resources (ex. Table, Resource).
    boto3 resource methods accept different input shapes than boto3 clients, and return different output shapes.
    (The members of these shapes are the same, but some shapes are formatted differently.)

    DBESDK DynamoDB has an internal transformer layer that modifies requests and responses.
    This transformer layer only accepts client-formatted shapes.

    This class exists to transform from/to resource shapes to/from client shapes
        for the internal DBESDK DynamoDB transformer layer.
    This class is also used to transform shapes if the EncryptedClient has expect_standard_dictionaries set to True.

    This class is abstract, as some specific transformations depend on the transformation direction.
    (ex. Item, Key, AttributeValue, etc.)
    But many transformations are the same in both directions.
    That similarity is captured here, and implementations override the abstract methods to perform the transformations
        specific to the transformation direction.
    """

    @abstractmethod
    def expression(self, condition_expression, expression_attribute_names, expression_attribute_values):
        raise NotImplementedError("Must be implemented by subclasses")

    def key_conditions(self, key_conditions):
        return self.key_to_attribute_value_with_comparison_operator_list(key_conditions)

    def query_filter(self, query_filter):
        return self.key_to_attribute_value_with_comparison_operator_list(query_filter)

    def key_to_attribute_value_with_comparison_operator_list(
        self, key_to_attribute_value_with_comparison_operator_list
    ):
        key_names = key_to_attribute_value_with_comparison_operator_list.keys()
        key_conditions_out = {}
        for key_name in key_names:
            value = key_to_attribute_value_with_comparison_operator_list[key_name]
            key_conditions_out[key_name] = value
            if "AttributeValueList" in value:
                key_conditions_out[key_name]["AttributeValueList"] = self.attribute_value_list(
                    value["AttributeValueList"]
                )
        return key_conditions_out

    def exclusive_start_key(self, exclusive_start_key):
        return self.item(exclusive_start_key)

    def expression_attribute_values(self, expression_attribute_values):
        return self.item(expression_attribute_values)

    @abstractmethod
    def attribute_value(self, attribute_value):
        raise NotImplementedError("Must be implemented by subclasses")

    def attribute_value_list(self, attribute_value_list):
        list_out = []
        for elem in attribute_value_list:
            list_out.append(self.attribute_value(elem))
        return list_out

    @abstractmethod
    def item(self, item):
        raise NotImplementedError("Must be implemented by subclasses")

    def items(self, items):
        items_out = []
        for item in items:
            items_out.append(self.item(item))
        return items_out

    def last_evaluated_key(self, last_evaluated_key):
        return self.item(last_evaluated_key)

    def expected(self, expected):
        for expected_key, expected_value in expected.items():
            if "Value" in expected_value:
                expected_value["Value"] = self.attribute_value(expected_value["Value"])
            if "AttributeValueList" in expected_value:
                expected_value["AttributeValueList"] = self.attribute_value_list(expected_value["AttributeValueList"])
            expected[expected_key] = expected_value
        return expected

    def put_item_request(self, put_item_request):
        if "Item" in put_item_request:
            put_item_request["Item"] = self.item(put_item_request["Item"])
        if "Expected" in put_item_request:
            put_item_request["Expected"] = self.expected(put_item_request["Expected"])
        if "ExpressionAttributeValues" in put_item_request:
            put_item_request["ExpressionAttributeValues"] = self.expression_attribute_values(
                put_item_request["ExpressionAttributeValues"]
            )
        return put_item_request

    def attributes(self, attributes):
        return self.item(attributes)

    def item_collection_metrics(self, item_collection_metrics):
        if "ItemCollectionKey" in item_collection_metrics:
            item_collection_metrics["ItemCollectionKey"] = self.item(item_collection_metrics["ItemCollectionKey"])
        return item_collection_metrics

    def put_item_response(self, put_item_response):
        if "Attributes" in put_item_response:
            put_item_response["Attributes"] = self.attributes(put_item_response["Attributes"])
        if "ItemCollectionMetrics" in put_item_response:
            put_item_response["ItemCollectionMetrics"] = self.item_collection_metrics(
                put_item_response["ItemCollectionMetrics"]
            )
        return put_item_response

    def get_item_request(self, get_item_request):
        if "Key" in get_item_request:
            get_item_request["Key"] = self.item(get_item_request["Key"])
        return get_item_request

    def get_item_response(self, get_item_response):
        if "Item" in get_item_response:
            get_item_response["Item"] = self.item(get_item_response["Item"])
        return get_item_response

    def scan_filter(self, scan_filter):
        for scan_filter_key, scan_filter_value in scan_filter.items():
            if "AttributeValueList" in scan_filter_value:
                scan_filter_value["AttributeValueList"] = self.attribute_value_list(
                    scan_filter_value["AttributeValueList"]
                )
            scan_filter[scan_filter_key] = scan_filter_value
        return scan_filter

    def scan_request(self, scan_request):
        if "ScanFilter" in scan_request:
            scan_request["ScanFilter"] = self.scan_filter(scan_request["ScanFilter"])
        if "ExclusiveStartKey" in scan_request:
            scan_request["ExclusiveStartKey"] = self.exclusive_start_key(scan_request["ExclusiveStartKey"])
        if "FilterExpression" in scan_request:
            self._handle_expression_with_expression_attributes(scan_request, "FilterExpression")
        if "ExpressionAttributeValues" in scan_request:
            scan_request["ExpressionAttributeValues"] = self.expression_attribute_values(
                scan_request["ExpressionAttributeValues"]
            )
        return scan_request

    def scan_response(self, scan_response):
        if "Items" in scan_response:
            scan_response["Items"] = self.items(scan_response["Items"])
        if "LastEvaluatedKey" in scan_response:
            scan_response["LastEvaluatedKey"] = self.last_evaluated_key(scan_response["LastEvaluatedKey"])
        return scan_response

    def _handle_expression_with_expression_attributes(self, request, expression_key):
        # Pass the resource-formatted expression attribute values to the converter
        if "ExpressionAttributeValues" in request:
            expression_attribute_values = request["ExpressionAttributeValues"]
        else:
            expression_attribute_values = {}
        if "ExpressionAttributeNames" in request:
            expression_attribute_names = request["ExpressionAttributeNames"]
        else:
            expression_attribute_names = {}
        request[expression_key] = self.expression(
            request[expression_key], expression_attribute_names, expression_attribute_values
        )

    def query_request(self, query_request):
        print(f"{query_request=}")
        if "KeyConditions" in query_request:
            query_request["KeyConditions"] = self.key_conditions(query_request["KeyConditions"])
        if "QueryFilter" in query_request:
            query_request["QueryFilter"] = self.query_filter(query_request["QueryFilter"])
        if "ExclusiveStartKey" in query_request:
            query_request["ExclusiveStartKey"] = self.exclusive_start_key(query_request["ExclusiveStartKey"])
        if "FilterExpression" in query_request:
            self._handle_expression_with_expression_attributes(query_request, "FilterExpression")
        if "KeyConditionExpression" in query_request:
            self._handle_expression_with_expression_attributes(query_request, "KeyConditionExpression")
        if "ExpressionAttributeValues" in query_request:
            print(f"pre {query_request['ExpressionAttributeValues']=}")
            query_request["ExpressionAttributeValues"] = self.expression_attribute_values(
                query_request["ExpressionAttributeValues"]
            )
            print(f"post {query_request['ExpressionAttributeValues']=}")
        return query_request

    def query_response(self, query_response):
        if "Items" in query_response:
            query_response["Items"] = self.items(query_response["Items"])
        if "LastEvaluatedKey" in query_response:
            query_response["LastEvaluatedKey"] = self.last_evaluated_key(query_response["LastEvaluatedKey"])
        return query_response

    def batch_get_item_request(self, batch_get_item_request):
        if "RequestItems" in batch_get_item_request:
            batch_get_item_request["RequestItems"] = self.batch_get_item_request_items(
                batch_get_item_request["RequestItems"]
            )
        return batch_get_item_request

    def batch_get_item_request_items(self, request_items):
        keys_out = {}
        for table_name, table_value in request_items.items():
            if "Keys" in table_value:
                table_value["Keys"] = self.keys(table_value["Keys"])
            keys_out[table_name] = table_value
        return keys_out

    def batch_get_item_response(self, batch_get_item_response):
        if "Responses" in batch_get_item_response:
            batch_get_item_response["Responses"] = self.responses(batch_get_item_response["Responses"])
        if "UnprocessedKeys" in batch_get_item_response:
            batch_get_item_response["UnprocessedKeys"] = self.unprocessed_keys(
                batch_get_item_response["UnprocessedKeys"]
            )
        return batch_get_item_response

    def responses(self, responses):
        responses_out = {}
        for table_name, table_value in responses.items():
            table_value = self.items(table_value)
            responses_out[table_name] = table_value
        return responses_out

    def unprocessed_keys(self, unprocessed_keys):
        unprocessed_keys_out = {}
        for table_name, table_value in unprocessed_keys.items():
            if "Keys" in table_value:
                table_value["Keys"] = self.keys(table_value["Keys"])
            unprocessed_keys_out[table_name] = table_value
        return unprocessed_keys_out

    def keys(self, keys):
        return self.items(keys)

    def batch_write_item_request(self, batch_write_item_request):
        if "RequestItems" in batch_write_item_request:
            batch_write_item_request["RequestItems"] = self.batch_write_item_items(
                batch_write_item_request["RequestItems"]
            )
        return batch_write_item_request

    def batch_write_item_items(self, items):
        items_out = {}
        for table_name, table_value in items.items():
            request_out = []
            for request in table_value:
                if "PutRequest" in request:
                    request["PutRequest"]["Item"] = self.item(request["PutRequest"]["Item"])
                elif "DeleteRequest" in request:
                    request["DeleteRequest"]["Key"] = self.item(request["DeleteRequest"]["Key"])
                else:
                    raise ValueError(f"Unexpected request type in batch write item request: {request}")
                request_out.append(request)
            items_out[table_name] = request_out
        return items_out

    def batch_write_item_response(self, batch_write_item_response):
        if "UnprocessedItems" in batch_write_item_response:
            batch_write_item_response["UnprocessedItems"] = self.unprocessed_items(
                batch_write_item_response["UnprocessedItems"]
            )
        if "ItemCollectionMetrics" in batch_write_item_response:
            batch_write_item_response["ItemCollectionMetrics"] = self.batch_write_item_item_collection_metrics(
                batch_write_item_response["ItemCollectionMetrics"]
            )
        return batch_write_item_response

    def unprocessed_items(self, unprocessed_items):
        return self.batch_write_item_items(unprocessed_items)

    def batch_write_item_item_collection_metrics(self, item_collection_metrics):
        item_collection_metrics_out = {}
        for table_name, table_value in item_collection_metrics.items():
            table_value = self.item_collection_metrics(table_value)
            item_collection_metrics_out[table_name] = table_value
        return item_collection_metrics_out

    def transact_write_items_request(self, transact_write_items_request):
        if "TransactItems" in transact_write_items_request:
            transact_write_items_request["TransactItems"] = self.transact_write_items(
                transact_write_items_request["TransactItems"]
            )
        return transact_write_items_request

    def transact_write_items(self, transact_items):
        output_transact_items = []
        for transact_item in transact_items:
            if "Put" in transact_item:
                transact_item["Put"]["Item"] = self.item(transact_item["Put"]["Item"])
                output_transact_items.append(transact_item)
            elif "Delete" in transact_item:
                transact_item["Delete"]["Key"] = self.item(transact_item["Delete"]["Key"])
                output_transact_items.append(transact_item)
            elif "ConditionCheck" in transact_item:
                transact_item["ConditionCheck"]["Key"] = self.item(transact_item["ConditionCheck"]["Key"])
                output_transact_items.append(transact_item)
            elif "Update" in transact_item:
                # Update requests are not supported yet.
                raise NotImplementedError('"update_item" is not yet implemented')
            else:
                raise ValueError(f"Unknown transact_write_items method key: {transact_item}")
        return output_transact_items

    def transact_write_items_response(self, transact_write_items_response):
        if "ItemCollectionMetrics" in transact_write_items_response:
            # TODO this works but rename/refactor
            transact_write_items_response["ItemCollectionMetrics"] = self.batch_write_item_item_collection_metrics(
                transact_write_items_response["ItemCollectionMetrics"]
            )
        return transact_write_items_response

    def transact_get_items_request(self, transact_get_items_request):
        if "TransactItems" in transact_get_items_request:
            transact_get_items_request["TransactItems"] = self.transact_get_items(
                transact_get_items_request["TransactItems"]
            )
        return transact_get_items_request

    def transact_get_items(self, transact_items):
        output_transact_items = []
        for transact_item in transact_items:
            if "Get" in transact_item:
                transact_item["Get"]["Key"] = self.item(transact_item["Get"]["Key"])
                output_transact_items.append(transact_item)
            else:
                raise ValueError(f"Unknown transact_get_items method key: {transact_item}")
        return output_transact_items

    def transact_get_items_response(self, transact_get_items_response):
        if "Responses" in transact_get_items_response:
            transact_get_items_response["Responses"] = self.items(transact_get_items_response["Responses"])
        return transact_get_items_response
