import pytest
from decimal import Decimal

simple_item_ddb = {
    "partition_key": {"S": "test-key"},
    "sort_key": {"N": "1"},
    "attribute1": {"S": "encrypted value"},
    "attribute2": {"S": "signed value"},
    ":attribute3": {"S": "unsigned value"},
}

simple_key_ddb = {"partition_key": simple_item_ddb["partition_key"], "sort_key": simple_item_ddb["sort_key"]}

simple_item_dict = {
    "partition_key": "test-key",
    "sort_key": 1,
    "attribute1": "encrypted value",
    "attribute2": "signed value",
    ":attribute3": "unsigned value",
}

simple_key_dict = {"partition_key": simple_item_dict["partition_key"], "sort_key": simple_item_dict["sort_key"]}

complex_item_ddb = {
    "partition_key": {"S": "all-types-test"},
    "sort_key": {"N": "1"},
    "attribute1": {
        "M": {
            "string": {"S": "string value"},
            "number": {"N": "123.45"},
            "binary": {"B": b"binary data"},
            "string_set": {"SS": ["value1", "value2"]},
            "number_set": {"NS": ["1", "2", "3"]},
            "binary_set": {"BS": [b"binary1", b"binary2"]},
            "list": {"L": [{"S": "list item 1"}, {"N": "42"}, {"B": b"list binary"}]},
            "map": {"M": {"nested_string": {"S": "nested value"}, "nested_number": {"N": "42"}}},
        }
    },
    "attribute2": {"S": "signed value"},
    ":attribute3": {"S": "unsigned value"},
}

complex_key_ddb = {"partition_key": complex_item_ddb["partition_key"], "sort_key": complex_item_ddb["sort_key"]}

complex_item_dict = {
    "partition_key": "all-types-test",
    "sort_key": 1,
    "attribute1": {
        "string": "string value",
        "number": Decimal("123.45"),
        "binary": b"binary data",
        "string_set": {"value1", "value2"},
        "number_set": {Decimal("1"), 2, Decimal("3")},
        "binary_set": {b"binary1", b"binary2"},
        "list": ["list item 1", 42, b"list binary"],
        "map": {"nested_string": "nested value", "nested_number": 42},
    },
    "attribute2": "signed value",
    ":attribute3": "unsigned value",
}

complex_key_dict = {"partition_key": complex_item_dict["partition_key"], "sort_key": complex_item_dict["sort_key"]}
