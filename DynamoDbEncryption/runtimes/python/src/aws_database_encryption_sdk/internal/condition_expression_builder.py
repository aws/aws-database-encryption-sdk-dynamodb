# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
from boto3.exceptions import (
    DynamoDBNeedsConditionError,
)
from boto3.dynamodb.conditions import (
    ConditionBase,
    BuiltConditionExpression,
    AttributeBase,
)


class InternalDBESDKDynamoDBConditionExpressionBuilder:
    """
    This internal class is used to transform boto3 DyamoDB conditions from
        Python classes to DynamoDB ConditionExpressions
        for use by internal DBESDK DyanmoDB operation transformers.

    This class is a modified version of boto3's ConditionExpressionBuilder:
    https://github.com/boto/boto3/blob/c5c634b53be589d6e913e6dca51ad8d6480f58c7/boto3/dynamodb/conditions.py#L304
    The original class is intended to interface from boto3 Table resources to boto3 clients,
        and has logic to replace attribute names and values with placeholders.
    This class is intended to interface from boto3 Table resources to internal DBESDK DyanmoDB operation transformers,
        which does not expect inserted placeholders.
    The placeholder insertion logic has been removed from this class along with its supporting logic,
        but this class maintains boto3's recursive ConditionExpression traversal logic.
    """

    def build_expression(
        self,
        condition,
        expression_attribute_names,
        expression_attribute_values,
    ):
        """Builds the condition expression.

        :type condition: ConditionBase
        :param condition: A condition to be built into a condition expression string.

        :rtype: (string, dict, dict)
        :returns: Will return a string representing the condition expression,
            the original dictionary of attribute names,
            and the original dictionary of attribute values.
        """
        if not isinstance(condition, ConditionBase):
            raise DynamoDBNeedsConditionError(condition)
        condition_expression = self._build_expression(condition)
        return BuiltConditionExpression(
            condition_expression=condition_expression,
            # BuiltConditionExpression uses "placeholders" nomenclature;
            # this is an artifact of the original boto3 ConditionExpressionBuilder.
            # This class neither creates placeholders, nor even uses the provided name/values dicts.
            # They are only here as required arguments for the BuiltConditionExpression class.
            attribute_name_placeholders=expression_attribute_names,
            attribute_value_placeholders=expression_attribute_values,
        )

    def _build_expression(
        self,
        condition,
    ):
        expression_dict = condition.get_expression()
        replaced_values = []
        for value in expression_dict['values']:
            # Recurse for each value in the expression.
            replaced_value = self._build_expression_component(condition, value)
            replaced_values.append(replaced_value)
        # Fill out the expression using the operator and its recursive expressions.
        return expression_dict['format'].format(
            *replaced_values, operator=expression_dict['operator']
        )

    def _build_expression_component(
        self,
        condition,
        value,
    ):
        # Continue to recurse if the value is a ConditionBase in order
        # to extract out all parts of the expression.
        if isinstance(value, ConditionBase):
            return self._build_expression(
                value,
            )
        # If it is not a ConditionBase, we can recurse no further.
        # If it's an attribute, insert its name.
        elif isinstance(value, AttributeBase):
            return value.name
        # If it is anything else, we treat it as a value.
        else:
            if condition.has_grouped_values:
                # Assuming the values are grouped by parenthesis.
                # IN is the currently the only one that uses this so it maybe
                # needed to be changed in future.
                return '(' + ', '.join(value) + ')'
            return value
