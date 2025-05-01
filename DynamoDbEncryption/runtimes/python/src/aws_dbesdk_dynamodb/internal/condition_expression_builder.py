# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
import re

from boto3.dynamodb.conditions import AttributeBase, BuiltConditionExpression, ConditionBase, Key
from boto3.exceptions import (
    DynamoDBNeedsConditionError,
    DynamoDBNeedsKeyConditionError,
)

ATTR_NAME_REGEX = re.compile(r"[^.\[\]]+(?![^\[]*\])")


class InternalDBESDKDynamoDBConditionExpressionBuilder:
    """This class is used to build condition expressions with placeholders"""

    def __init__(self):
        self._name_count = 0
        self._value_count = 0
        self._name_placeholder = "n"
        self._value_placeholder = "v"

    def _get_name_placeholder(self):
        return "#" + self._name_placeholder + str(self._name_count)

    def _get_value_placeholder(self):
        return ":" + self._value_placeholder + str(self._value_count)

    def reset(self):
        """Resets the placeholder name and values"""
        self._name_count = 0
        self._value_count = 0

    def build_expression(
        self, condition, attribute_name_placeholders, attribute_value_placeholders, is_key_condition=False
    ):
        """Builds the condition expression and the dictionary of placeholders.

        :type condition: ConditionBase
        :param condition: A condition to be built into a condition expression
            string with any necessary placeholders.

        :type is_key_condition: Boolean
        :param is_key_condition: True if the expression is for a
            KeyConditionExpression. False otherwise.

        :rtype: (string, dict, dict)
        :returns: Will return a string representing the condition with
            placeholders inserted where necessary, a dictionary of
            placeholders for attribute names, and a dictionary of
            placeholders for attribute values. Here is a sample return value:

            ('#n0 = :v0', {'#n0': 'myattribute'}, {':v1': 'myvalue'})
        """
        if not isinstance(condition, ConditionBase):
            raise DynamoDBNeedsConditionError(condition)
        condition_expression = self._build_expression(
            condition,
            attribute_name_placeholders,
            attribute_value_placeholders,
            is_key_condition=is_key_condition,
        )
        print(f"BuiltConditionExpression {condition_expression=}")
        return BuiltConditionExpression(
            condition_expression=condition_expression,
            attribute_name_placeholders=attribute_name_placeholders,
            attribute_value_placeholders=attribute_value_placeholders,
        )

    def _build_expression(
        self,
        condition,
        attribute_name_placeholders,
        attribute_value_placeholders,
        is_key_condition,
    ):
        expression_dict = condition.get_expression()
        replaced_values = []
        for value in expression_dict["values"]:
            # Build the necessary placeholders for that value.
            # Placeholders are built for both attribute names and values.
            replaced_value = self._build_expression_component(
                value,
                attribute_name_placeholders,
                attribute_value_placeholders,
                condition.has_grouped_values,
                is_key_condition,
            )
            replaced_values.append(replaced_value)
        # Fill out the expression using the operator and the
        # values that have been replaced with placeholders.
        return expression_dict["format"].format(*replaced_values, operator=expression_dict["operator"])

    def _build_expression_component(
        self,
        value,
        attribute_name_placeholders,
        attribute_value_placeholders,
        has_grouped_values,
        is_key_condition,
    ):
        # Continue to recurse if the value is a ConditionBase in order
        # to extract out all parts of the expression.
        if isinstance(value, ConditionBase):
            return self._build_expression(
                value,
                attribute_name_placeholders,
                attribute_value_placeholders,
                is_key_condition,
            )
        # If it is not a ConditionBase, we can recurse no further.
        # So we check if it is an attribute and add placeholders for
        # its name
        elif isinstance(value, AttributeBase):
            if is_key_condition and not isinstance(value, Key):
                raise DynamoDBNeedsKeyConditionError(
                    f"Attribute object {value.name} is of type {type(value)}. "
                    f"KeyConditionExpression only supports Attribute objects "
                    f"of type Key"
                )
            return self._build_name_placeholder(value, attribute_name_placeholders)
        # If it is anything else, we treat it as a value and thus placeholders
        # are needed for the value.
        else:
            return self._build_value_placeholder(value, attribute_value_placeholders, has_grouped_values)

    def _build_name_placeholder(self, value, attribute_name_placeholders):
        attribute_name = value.name
        # Figure out which parts of the attribute name that needs replacement.
        attribute_name_parts = ATTR_NAME_REGEX.findall(attribute_name)

        # Add a temporary placeholder for each of these parts.
        placeholder_format = ATTR_NAME_REGEX.sub("%s", attribute_name)
        str_format_args = []
        for part in attribute_name_parts:
            # If the the name is already an AttributeName, use it. Don't make a new placeholder.
            if part in attribute_name_placeholders:
                str_format_args.append(part)
            else:
                name_placeholder = self._get_name_placeholder()
                self._name_count += 1
                str_format_args.append(name_placeholder)
                # Add the placeholder and value to dictionary of name placeholders.
                attribute_name_placeholders[name_placeholder] = part
        # Replace the temporary placeholders with the designated placeholders.
        return placeholder_format % tuple(str_format_args)

    def _build_value_placeholder(self, value, attribute_value_placeholders, has_grouped_values=False):
        print(f"{attribute_value_placeholders=}")
        # If the values are grouped, we need to add a placeholder for
        # each element inside of the actual value.

        # Also, you can define a grouped value with a colon here.
        # If it's a colon, it's not a grouped value for the sake of this logic.
        # Treat it as an "else" case.
        if has_grouped_values:
            placeholder_list = []
            # If it's a pre-defined grouped attribute, don't attempt to unpack it as if it were
            for v in value:
                print(f"v1 {v=}")
                # If the value is already an AttributeValue, reuse it. Don't make a new placeholder.
                if v in attribute_value_placeholders:
                    print("in")
                    placeholder_list.append(v)
                else:
                    print("not in")
                    value_placeholder = self._get_value_placeholder()
                    self._value_count += 1
                    placeholder_list.append(value_placeholder)
                    attribute_value_placeholders[value_placeholder] = v
            # Assuming the values are grouped by parenthesis.
            # IN is the currently the only one that uses this so it maybe
            # needed to be changed in future.
            return "(" + ", ".join(placeholder_list) + ")"
        # Otherwise, treat the value as a single value that needs only
        # one placeholder.
        else:
            print(f"v2 {value=}")
            # If the value is already an AttributeValue, reuse it. Don't make a new placeholder.
            if value in attribute_value_placeholders:
                print("in")
                return value
            else:
                print("not in")
                value_placeholder = self._get_value_placeholder()
                self._value_count += 1
                attribute_value_placeholders[value_placeholder] = value
                return value_placeholder
