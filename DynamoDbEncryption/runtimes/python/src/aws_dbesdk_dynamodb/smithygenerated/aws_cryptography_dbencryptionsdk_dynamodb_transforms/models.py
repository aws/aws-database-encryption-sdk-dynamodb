# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from typing import Any, Dict, Optional


class ResolveAttributesOutput:
    virtual_fields: dict[str, str]
    compound_beacons: dict[str, str]

    def __init__(
        self,
        *,
        virtual_fields: dict[str, str],
        compound_beacons: dict[str, str],
    ):
        """
        :param virtual_fields: Full plaintext of all calculable virtual fields.
        :param compound_beacons: Full plaintext of all calculable compound beacons.
        """
        self.virtual_fields = virtual_fields
        self.compound_beacons = compound_beacons

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ResolveAttributesOutput to a dictionary."""
        return {
            "virtual_fields": self.virtual_fields,
            "compound_beacons": self.compound_beacons,
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ResolveAttributesOutput":
        """Creates a ResolveAttributesOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "virtual_fields": d["virtual_fields"],
            "compound_beacons": d["compound_beacons"],
        }

        return ResolveAttributesOutput(**kwargs)

    def __repr__(self) -> str:
        result = "ResolveAttributesOutput("
        if self.virtual_fields is not None:
            result += f"virtual_fields={repr(self.virtual_fields)}, "

        if self.compound_beacons is not None:
            result += f"compound_beacons={repr(self.compound_beacons)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ResolveAttributesOutput):
            return False
        attributes: list[str] = [
            "virtual_fields",
            "compound_beacons",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ResolveAttributesInput:
    table_name: dict[str, Any]
    item: dict[str, Any]
    version: int

    def __init__(
        self,
        *,
        table_name: dict[str, Any],
        item: dict[str, Any],
        version: int = 0,
    ):
        """
        :param table_name: Use the config for this Table.
        :param item: The Item to be examined.
        :param version: The beacon version to use. Defaults to 'writeVersion'.
        """
        if (table_name is not None) and (len(table_name) < 3):
            raise ValueError(
                "The size of table_name must be greater than or equal to 3"
            )

        if (table_name is not None) and (len(table_name) > 255):
            raise ValueError("The size of table_name must be less than or equal to 255")

        self.table_name = table_name
        self.item = item
        if (version is not None) and (version < 1):
            raise ValueError("version must be greater than or equal to 1")

        self.version = version

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ResolveAttributesInput to a dictionary."""
        d: Dict[str, Any] = {
            "table_name": self.table_name,
            "item": self.item,
        }

        if self.version is not None:
            d["version"] = self.version

        return d

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ResolveAttributesInput":
        """Creates a ResolveAttributesInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "table_name": d["table_name"],
            "item": d["item"],
        }

        if "version" in d:
            kwargs["version"] = d["version"]

        return ResolveAttributesInput(**kwargs)

    def __repr__(self) -> str:
        result = "ResolveAttributesInput("
        if self.table_name is not None:
            result += f"table_name={repr(self.table_name)}, "

        if self.item is not None:
            result += f"item={repr(self.item)}, "

        if self.version is not None:
            result += f"version={repr(self.version)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ResolveAttributesInput):
            return False
        attributes: list[str] = [
            "table_name",
            "item",
            "version",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ExecuteStatementInputTransformInput:
    sdk_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_input: dict[str, Any],
    ):
        self.sdk_input = sdk_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ExecuteStatementInputTransformInput to a dictionary."""
        return {
            "sdk_input": self.sdk_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ExecuteStatementInputTransformInput":
        """Creates a ExecuteStatementInputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_input": d["sdk_input"],
        }

        return ExecuteStatementInputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "ExecuteStatementInputTransformInput("
        if self.sdk_input is not None:
            result += f"sdk_input={repr(self.sdk_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ExecuteStatementInputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ExecuteStatementInputTransformOutput:
    transformed_input: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_input: dict[str, Any],
    ):
        self.transformed_input = transformed_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ExecuteStatementInputTransformOutput to a
        dictionary."""
        return {
            "transformed_input": self.transformed_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ExecuteStatementInputTransformOutput":
        """Creates a ExecuteStatementInputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_input": d["transformed_input"],
        }

        return ExecuteStatementInputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "ExecuteStatementInputTransformOutput("
        if self.transformed_input is not None:
            result += f"transformed_input={repr(self.transformed_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ExecuteStatementInputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class GetItemInputTransformInput:
    sdk_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_input: dict[str, Any],
    ):
        """
        :param sdk_input: <p>Represents the input of a <code>GetItem</code>
        operation.</p>
        """
        self.sdk_input = sdk_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the GetItemInputTransformInput to a dictionary."""
        return {
            "sdk_input": self.sdk_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetItemInputTransformInput":
        """Creates a GetItemInputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_input": d["sdk_input"],
        }

        return GetItemInputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "GetItemInputTransformInput("
        if self.sdk_input is not None:
            result += f"sdk_input={repr(self.sdk_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetItemInputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class GetItemInputTransformOutput:
    transformed_input: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_input: dict[str, Any],
    ):
        """
        :param transformed_input: <p>Represents the input of a <code>GetItem</code>
        operation.</p>
        """
        self.transformed_input = transformed_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the GetItemInputTransformOutput to a dictionary."""
        return {
            "transformed_input": self.transformed_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetItemInputTransformOutput":
        """Creates a GetItemInputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_input": d["transformed_input"],
        }

        return GetItemInputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "GetItemInputTransformOutput("
        if self.transformed_input is not None:
            result += f"transformed_input={repr(self.transformed_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetItemInputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class GetItemOutputTransformOutput:
    transformed_output: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_output: dict[str, Any],
    ):
        """
        :param transformed_output: <p>Represents the output of a <code>GetItem</code>
        operation.</p>
        """
        self.transformed_output = transformed_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the GetItemOutputTransformOutput to a dictionary."""
        return {
            "transformed_output": self.transformed_output.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetItemOutputTransformOutput":
        """Creates a GetItemOutputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_output": d["transformed_output"],
        }

        return GetItemOutputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "GetItemOutputTransformOutput("
        if self.transformed_output is not None:
            result += f"transformed_output={repr(self.transformed_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetItemOutputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BatchExecuteStatementInputTransformInput:
    sdk_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_input: dict[str, Any],
    ):
        self.sdk_input = sdk_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the BatchExecuteStatementInputTransformInput to a
        dictionary."""
        return {
            "sdk_input": self.sdk_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BatchExecuteStatementInputTransformInput":
        """Creates a BatchExecuteStatementInputTransformInput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_input": d["sdk_input"],
        }

        return BatchExecuteStatementInputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "BatchExecuteStatementInputTransformInput("
        if self.sdk_input is not None:
            result += f"sdk_input={repr(self.sdk_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BatchExecuteStatementInputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BatchExecuteStatementInputTransformOutput:
    transformed_input: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_input: dict[str, Any],
    ):
        self.transformed_input = transformed_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the BatchExecuteStatementInputTransformOutput to a
        dictionary."""
        return {
            "transformed_input": self.transformed_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BatchExecuteStatementInputTransformOutput":
        """Creates a BatchExecuteStatementInputTransformOutput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_input": d["transformed_input"],
        }

        return BatchExecuteStatementInputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "BatchExecuteStatementInputTransformOutput("
        if self.transformed_input is not None:
            result += f"transformed_input={repr(self.transformed_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BatchExecuteStatementInputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ExecuteTransactionInputTransformInput:
    sdk_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_input: dict[str, Any],
    ):
        self.sdk_input = sdk_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ExecuteTransactionInputTransformInput to a
        dictionary."""
        return {
            "sdk_input": self.sdk_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ExecuteTransactionInputTransformInput":
        """Creates a ExecuteTransactionInputTransformInput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_input": d["sdk_input"],
        }

        return ExecuteTransactionInputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "ExecuteTransactionInputTransformInput("
        if self.sdk_input is not None:
            result += f"sdk_input={repr(self.sdk_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ExecuteTransactionInputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ExecuteTransactionInputTransformOutput:
    transformed_input: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_input: dict[str, Any],
    ):
        self.transformed_input = transformed_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ExecuteTransactionInputTransformOutput to a
        dictionary."""
        return {
            "transformed_input": self.transformed_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ExecuteTransactionInputTransformOutput":
        """Creates a ExecuteTransactionInputTransformOutput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_input": d["transformed_input"],
        }

        return ExecuteTransactionInputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "ExecuteTransactionInputTransformOutput("
        if self.transformed_input is not None:
            result += f"transformed_input={repr(self.transformed_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ExecuteTransactionInputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ExecuteTransactionOutputTransformOutput:
    transformed_output: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_output: dict[str, Any],
    ):
        self.transformed_output = transformed_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ExecuteTransactionOutputTransformOutput to a
        dictionary."""
        return {
            "transformed_output": self.transformed_output.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ExecuteTransactionOutputTransformOutput":
        """Creates a ExecuteTransactionOutputTransformOutput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_output": d["transformed_output"],
        }

        return ExecuteTransactionOutputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "ExecuteTransactionOutputTransformOutput("
        if self.transformed_output is not None:
            result += f"transformed_output={repr(self.transformed_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ExecuteTransactionOutputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class TransactGetItemsOutputTransformOutput:
    transformed_output: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_output: dict[str, Any],
    ):
        self.transformed_output = transformed_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the TransactGetItemsOutputTransformOutput to a
        dictionary."""
        return {
            "transformed_output": self.transformed_output.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "TransactGetItemsOutputTransformOutput":
        """Creates a TransactGetItemsOutputTransformOutput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_output": d["transformed_output"],
        }

        return TransactGetItemsOutputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "TransactGetItemsOutputTransformOutput("
        if self.transformed_output is not None:
            result += f"transformed_output={repr(self.transformed_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, TransactGetItemsOutputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BatchGetItemInputTransformInput:
    sdk_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_input: dict[str, Any],
    ):
        """
        :param sdk_input: <p>Represents the input of a <code>BatchGetItem</code>
        operation.</p>
        """
        self.sdk_input = sdk_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the BatchGetItemInputTransformInput to a dictionary."""
        return {
            "sdk_input": self.sdk_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BatchGetItemInputTransformInput":
        """Creates a BatchGetItemInputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_input": d["sdk_input"],
        }

        return BatchGetItemInputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "BatchGetItemInputTransformInput("
        if self.sdk_input is not None:
            result += f"sdk_input={repr(self.sdk_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BatchGetItemInputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BatchGetItemInputTransformOutput:
    transformed_input: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_input: dict[str, Any],
    ):
        """
        :param transformed_input: <p>Represents the input of a <code>BatchGetItem</code>
        operation.</p>
        """
        self.transformed_input = transformed_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the BatchGetItemInputTransformOutput to a dictionary."""
        return {
            "transformed_input": self.transformed_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BatchGetItemInputTransformOutput":
        """Creates a BatchGetItemInputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_input": d["transformed_input"],
        }

        return BatchGetItemInputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "BatchGetItemInputTransformOutput("
        if self.transformed_input is not None:
            result += f"transformed_input={repr(self.transformed_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BatchGetItemInputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class TransactGetItemsInputTransformInput:
    sdk_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_input: dict[str, Any],
    ):
        self.sdk_input = sdk_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the TransactGetItemsInputTransformInput to a dictionary."""
        return {
            "sdk_input": self.sdk_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "TransactGetItemsInputTransformInput":
        """Creates a TransactGetItemsInputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_input": d["sdk_input"],
        }

        return TransactGetItemsInputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "TransactGetItemsInputTransformInput("
        if self.sdk_input is not None:
            result += f"sdk_input={repr(self.sdk_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, TransactGetItemsInputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class TransactGetItemsInputTransformOutput:
    transformed_input: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_input: dict[str, Any],
    ):
        self.transformed_input = transformed_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the TransactGetItemsInputTransformOutput to a
        dictionary."""
        return {
            "transformed_input": self.transformed_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "TransactGetItemsInputTransformOutput":
        """Creates a TransactGetItemsInputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_input": d["transformed_input"],
        }

        return TransactGetItemsInputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "TransactGetItemsInputTransformOutput("
        if self.transformed_input is not None:
            result += f"transformed_input={repr(self.transformed_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, TransactGetItemsInputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class TransactWriteItemsOutputTransformOutput:
    transformed_output: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_output: dict[str, Any],
    ):
        self.transformed_output = transformed_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the TransactWriteItemsOutputTransformOutput to a
        dictionary."""
        return {
            "transformed_output": self.transformed_output.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "TransactWriteItemsOutputTransformOutput":
        """Creates a TransactWriteItemsOutputTransformOutput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_output": d["transformed_output"],
        }

        return TransactWriteItemsOutputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "TransactWriteItemsOutputTransformOutput("
        if self.transformed_output is not None:
            result += f"transformed_output={repr(self.transformed_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, TransactWriteItemsOutputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class GetItemOutputTransformInput:
    sdk_output: dict[str, Any]
    original_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_output: dict[str, Any],
        original_input: dict[str, Any],
    ):
        """
        :param sdk_output: <p>Represents the output of a <code>GetItem</code>
        operation.</p>
        :param original_input: <p>Represents the input of a <code>GetItem</code>
        operation.</p>
        """
        self.sdk_output = sdk_output
        self.original_input = original_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the GetItemOutputTransformInput to a dictionary."""
        return {
            "sdk_output": self.sdk_output.as_dict(),
            "original_input": self.original_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "GetItemOutputTransformInput":
        """Creates a GetItemOutputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_output": d["sdk_output"],
            "original_input": d["original_input"],
        }

        return GetItemOutputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "GetItemOutputTransformInput("
        if self.sdk_output is not None:
            result += f"sdk_output={repr(self.sdk_output)}, "

        if self.original_input is not None:
            result += f"original_input={repr(self.original_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, GetItemOutputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_output",
            "original_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class DeleteItemOutputTransformOutput:
    transformed_output: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_output: dict[str, Any],
    ):
        """
        :param transformed_output: <p>Represents the output of a <code>DeleteItem</code>
        operation.</p>
        """
        self.transformed_output = transformed_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the DeleteItemOutputTransformOutput to a dictionary."""
        return {
            "transformed_output": self.transformed_output.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "DeleteItemOutputTransformOutput":
        """Creates a DeleteItemOutputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_output": d["transformed_output"],
        }

        return DeleteItemOutputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "DeleteItemOutputTransformOutput("
        if self.transformed_output is not None:
            result += f"transformed_output={repr(self.transformed_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, DeleteItemOutputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ExecuteStatementOutputTransformOutput:
    transformed_output: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_output: dict[str, Any],
    ):
        self.transformed_output = transformed_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ExecuteStatementOutputTransformOutput to a
        dictionary."""
        return {
            "transformed_output": self.transformed_output.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ExecuteStatementOutputTransformOutput":
        """Creates a ExecuteStatementOutputTransformOutput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_output": d["transformed_output"],
        }

        return ExecuteStatementOutputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "ExecuteStatementOutputTransformOutput("
        if self.transformed_output is not None:
            result += f"transformed_output={repr(self.transformed_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ExecuteStatementOutputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class PutItemOutputTransformOutput:
    transformed_output: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_output: dict[str, Any],
    ):
        """
        :param transformed_output: <p>Represents the output of a <code>PutItem</code>
        operation.</p>
        """
        self.transformed_output = transformed_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the PutItemOutputTransformOutput to a dictionary."""
        return {
            "transformed_output": self.transformed_output.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "PutItemOutputTransformOutput":
        """Creates a PutItemOutputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_output": d["transformed_output"],
        }

        return PutItemOutputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "PutItemOutputTransformOutput("
        if self.transformed_output is not None:
            result += f"transformed_output={repr(self.transformed_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, PutItemOutputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class QueryOutputTransformOutput:
    transformed_output: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_output: dict[str, Any],
    ):
        """
        :param transformed_output: <p>Represents the output of a <code>Query</code>
        operation.</p>
        """
        self.transformed_output = transformed_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the QueryOutputTransformOutput to a dictionary."""
        return {
            "transformed_output": self.transformed_output.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "QueryOutputTransformOutput":
        """Creates a QueryOutputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_output": d["transformed_output"],
        }

        return QueryOutputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "QueryOutputTransformOutput("
        if self.transformed_output is not None:
            result += f"transformed_output={repr(self.transformed_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, QueryOutputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ScanOutputTransformOutput:
    transformed_output: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_output: dict[str, Any],
    ):
        """
        :param transformed_output: <p>Represents the output of a <code>Scan</code>
        operation.</p>
        """
        self.transformed_output = transformed_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ScanOutputTransformOutput to a dictionary."""
        return {
            "transformed_output": self.transformed_output.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ScanOutputTransformOutput":
        """Creates a ScanOutputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_output": d["transformed_output"],
        }

        return ScanOutputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "ScanOutputTransformOutput("
        if self.transformed_output is not None:
            result += f"transformed_output={repr(self.transformed_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ScanOutputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class UpdateItemOutputTransformOutput:
    transformed_output: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_output: dict[str, Any],
    ):
        """
        :param transformed_output: <p>Represents the output of an
        <code>UpdateItem</code> operation.</p>
        """
        self.transformed_output = transformed_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the UpdateItemOutputTransformOutput to a dictionary."""
        return {
            "transformed_output": self.transformed_output.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "UpdateItemOutputTransformOutput":
        """Creates a UpdateItemOutputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_output": d["transformed_output"],
        }

        return UpdateItemOutputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "UpdateItemOutputTransformOutput("
        if self.transformed_output is not None:
            result += f"transformed_output={repr(self.transformed_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, UpdateItemOutputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ExecuteTransactionOutputTransformInput:
    sdk_output: dict[str, Any]
    original_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_output: dict[str, Any],
        original_input: dict[str, Any],
    ):
        self.sdk_output = sdk_output
        self.original_input = original_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ExecuteTransactionOutputTransformInput to a
        dictionary."""
        return {
            "sdk_output": self.sdk_output.as_dict(),
            "original_input": self.original_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ExecuteTransactionOutputTransformInput":
        """Creates a ExecuteTransactionOutputTransformInput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_output": d["sdk_output"],
            "original_input": d["original_input"],
        }

        return ExecuteTransactionOutputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "ExecuteTransactionOutputTransformInput("
        if self.sdk_output is not None:
            result += f"sdk_output={repr(self.sdk_output)}, "

        if self.original_input is not None:
            result += f"original_input={repr(self.original_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ExecuteTransactionOutputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_output",
            "original_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BatchExecuteStatementOutputTransformOutput:
    transformed_output: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_output: dict[str, Any],
    ):
        self.transformed_output = transformed_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the BatchExecuteStatementOutputTransformOutput to a
        dictionary."""
        return {
            "transformed_output": self.transformed_output.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BatchExecuteStatementOutputTransformOutput":
        """Creates a BatchExecuteStatementOutputTransformOutput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_output": d["transformed_output"],
        }

        return BatchExecuteStatementOutputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "BatchExecuteStatementOutputTransformOutput("
        if self.transformed_output is not None:
            result += f"transformed_output={repr(self.transformed_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BatchExecuteStatementOutputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BatchGetItemOutputTransformOutput:
    transformed_output: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_output: dict[str, Any],
    ):
        """
        :param transformed_output: <p>Represents the output of a
        <code>BatchGetItem</code> operation.</p>
        """
        self.transformed_output = transformed_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the BatchGetItemOutputTransformOutput to a dictionary."""
        return {
            "transformed_output": self.transformed_output.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BatchGetItemOutputTransformOutput":
        """Creates a BatchGetItemOutputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_output": d["transformed_output"],
        }

        return BatchGetItemOutputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "BatchGetItemOutputTransformOutput("
        if self.transformed_output is not None:
            result += f"transformed_output={repr(self.transformed_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BatchGetItemOutputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class TransactGetItemsOutputTransformInput:
    sdk_output: dict[str, Any]
    original_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_output: dict[str, Any],
        original_input: dict[str, Any],
    ):
        self.sdk_output = sdk_output
        self.original_input = original_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the TransactGetItemsOutputTransformInput to a
        dictionary."""
        return {
            "sdk_output": self.sdk_output.as_dict(),
            "original_input": self.original_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "TransactGetItemsOutputTransformInput":
        """Creates a TransactGetItemsOutputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_output": d["sdk_output"],
            "original_input": d["original_input"],
        }

        return TransactGetItemsOutputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "TransactGetItemsOutputTransformInput("
        if self.sdk_output is not None:
            result += f"sdk_output={repr(self.sdk_output)}, "

        if self.original_input is not None:
            result += f"original_input={repr(self.original_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, TransactGetItemsOutputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_output",
            "original_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ExecuteStatementOutputTransformInput:
    sdk_output: dict[str, Any]
    original_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_output: dict[str, Any],
        original_input: dict[str, Any],
    ):
        self.sdk_output = sdk_output
        self.original_input = original_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ExecuteStatementOutputTransformInput to a
        dictionary."""
        return {
            "sdk_output": self.sdk_output.as_dict(),
            "original_input": self.original_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ExecuteStatementOutputTransformInput":
        """Creates a ExecuteStatementOutputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_output": d["sdk_output"],
            "original_input": d["original_input"],
        }

        return ExecuteStatementOutputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "ExecuteStatementOutputTransformInput("
        if self.sdk_output is not None:
            result += f"sdk_output={repr(self.sdk_output)}, "

        if self.original_input is not None:
            result += f"original_input={repr(self.original_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ExecuteStatementOutputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_output",
            "original_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ScanInputTransformInput:
    sdk_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_input: dict[str, Any],
    ):
        """
        :param sdk_input: <p>Represents the input of a <code>Scan</code> operation.</p>
        """
        self.sdk_input = sdk_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ScanInputTransformInput to a dictionary."""
        return {
            "sdk_input": self.sdk_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ScanInputTransformInput":
        """Creates a ScanInputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_input": d["sdk_input"],
        }

        return ScanInputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "ScanInputTransformInput("
        if self.sdk_input is not None:
            result += f"sdk_input={repr(self.sdk_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ScanInputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ScanInputTransformOutput:
    transformed_input: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_input: dict[str, Any],
    ):
        """
        :param transformed_input: <p>Represents the input of a <code>Scan</code>
        operation.</p>
        """
        self.transformed_input = transformed_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ScanInputTransformOutput to a dictionary."""
        return {
            "transformed_input": self.transformed_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ScanInputTransformOutput":
        """Creates a ScanInputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_input": d["transformed_input"],
        }

        return ScanInputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "ScanInputTransformOutput("
        if self.transformed_input is not None:
            result += f"transformed_input={repr(self.transformed_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ScanInputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BatchWriteItemInputTransformInput:
    sdk_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_input: dict[str, Any],
    ):
        """
        :param sdk_input: <p>Represents the input of a <code>BatchWriteItem</code>
        operation.</p>
        """
        self.sdk_input = sdk_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the BatchWriteItemInputTransformInput to a dictionary."""
        return {
            "sdk_input": self.sdk_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BatchWriteItemInputTransformInput":
        """Creates a BatchWriteItemInputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_input": d["sdk_input"],
        }

        return BatchWriteItemInputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "BatchWriteItemInputTransformInput("
        if self.sdk_input is not None:
            result += f"sdk_input={repr(self.sdk_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BatchWriteItemInputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BatchWriteItemInputTransformOutput:
    transformed_input: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_input: dict[str, Any],
    ):
        """
        :param transformed_input: <p>Represents the input of a
        <code>BatchWriteItem</code> operation.</p>
        """
        self.transformed_input = transformed_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the BatchWriteItemInputTransformOutput to a dictionary."""
        return {
            "transformed_input": self.transformed_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BatchWriteItemInputTransformOutput":
        """Creates a BatchWriteItemInputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_input": d["transformed_input"],
        }

        return BatchWriteItemInputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "BatchWriteItemInputTransformOutput("
        if self.transformed_input is not None:
            result += f"transformed_input={repr(self.transformed_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BatchWriteItemInputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BatchExecuteStatementOutputTransformInput:
    sdk_output: dict[str, Any]
    original_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_output: dict[str, Any],
        original_input: dict[str, Any],
    ):
        self.sdk_output = sdk_output
        self.original_input = original_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the BatchExecuteStatementOutputTransformInput to a
        dictionary."""
        return {
            "sdk_output": self.sdk_output.as_dict(),
            "original_input": self.original_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BatchExecuteStatementOutputTransformInput":
        """Creates a BatchExecuteStatementOutputTransformInput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_output": d["sdk_output"],
            "original_input": d["original_input"],
        }

        return BatchExecuteStatementOutputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "BatchExecuteStatementOutputTransformInput("
        if self.sdk_output is not None:
            result += f"sdk_output={repr(self.sdk_output)}, "

        if self.original_input is not None:
            result += f"original_input={repr(self.original_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BatchExecuteStatementOutputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_output",
            "original_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BatchGetItemOutputTransformInput:
    sdk_output: dict[str, Any]
    original_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_output: dict[str, Any],
        original_input: dict[str, Any],
    ):
        """
        :param sdk_output: <p>Represents the output of a <code>BatchGetItem</code>
        operation.</p>
        :param original_input: <p>Represents the input of a <code>BatchGetItem</code>
        operation.</p>
        """
        self.sdk_output = sdk_output
        self.original_input = original_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the BatchGetItemOutputTransformInput to a dictionary."""
        return {
            "sdk_output": self.sdk_output.as_dict(),
            "original_input": self.original_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BatchGetItemOutputTransformInput":
        """Creates a BatchGetItemOutputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_output": d["sdk_output"],
            "original_input": d["original_input"],
        }

        return BatchGetItemOutputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "BatchGetItemOutputTransformInput("
        if self.sdk_output is not None:
            result += f"sdk_output={repr(self.sdk_output)}, "

        if self.original_input is not None:
            result += f"original_input={repr(self.original_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BatchGetItemOutputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_output",
            "original_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class DeleteItemInputTransformInput:
    sdk_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_input: dict[str, Any],
    ):
        """
        :param sdk_input: <p>Represents the input of a <code>DeleteItem</code>
        operation.</p>
        """
        self.sdk_input = sdk_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the DeleteItemInputTransformInput to a dictionary."""
        return {
            "sdk_input": self.sdk_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "DeleteItemInputTransformInput":
        """Creates a DeleteItemInputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_input": d["sdk_input"],
        }

        return DeleteItemInputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "DeleteItemInputTransformInput("
        if self.sdk_input is not None:
            result += f"sdk_input={repr(self.sdk_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, DeleteItemInputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class DeleteItemInputTransformOutput:
    transformed_input: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_input: dict[str, Any],
    ):
        """
        :param transformed_input: <p>Represents the input of a <code>DeleteItem</code>
        operation.</p>
        """
        self.transformed_input = transformed_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the DeleteItemInputTransformOutput to a dictionary."""
        return {
            "transformed_input": self.transformed_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "DeleteItemInputTransformOutput":
        """Creates a DeleteItemInputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_input": d["transformed_input"],
        }

        return DeleteItemInputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "DeleteItemInputTransformOutput("
        if self.transformed_input is not None:
            result += f"transformed_input={repr(self.transformed_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, DeleteItemInputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class PutItemInputTransformInput:
    sdk_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_input: dict[str, Any],
    ):
        """
        :param sdk_input: <p>Represents the input of a <code>PutItem</code>
        operation.</p>
        """
        self.sdk_input = sdk_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the PutItemInputTransformInput to a dictionary."""
        return {
            "sdk_input": self.sdk_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "PutItemInputTransformInput":
        """Creates a PutItemInputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_input": d["sdk_input"],
        }

        return PutItemInputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "PutItemInputTransformInput("
        if self.sdk_input is not None:
            result += f"sdk_input={repr(self.sdk_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, PutItemInputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class PutItemInputTransformOutput:
    transformed_input: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_input: dict[str, Any],
    ):
        """
        :param transformed_input: <p>Represents the input of a <code>PutItem</code>
        operation.</p>
        """
        self.transformed_input = transformed_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the PutItemInputTransformOutput to a dictionary."""
        return {
            "transformed_input": self.transformed_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "PutItemInputTransformOutput":
        """Creates a PutItemInputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_input": d["transformed_input"],
        }

        return PutItemInputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "PutItemInputTransformOutput("
        if self.transformed_input is not None:
            result += f"transformed_input={repr(self.transformed_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, PutItemInputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class QueryInputTransformInput:
    sdk_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_input: dict[str, Any],
    ):
        """
        :param sdk_input: <p>Represents the input of a <code>Query</code> operation.</p>
        """
        self.sdk_input = sdk_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the QueryInputTransformInput to a dictionary."""
        return {
            "sdk_input": self.sdk_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "QueryInputTransformInput":
        """Creates a QueryInputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_input": d["sdk_input"],
        }

        return QueryInputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "QueryInputTransformInput("
        if self.sdk_input is not None:
            result += f"sdk_input={repr(self.sdk_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, QueryInputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class QueryInputTransformOutput:
    transformed_input: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_input: dict[str, Any],
    ):
        """
        :param transformed_input: <p>Represents the input of a <code>Query</code>
        operation.</p>
        """
        self.transformed_input = transformed_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the QueryInputTransformOutput to a dictionary."""
        return {
            "transformed_input": self.transformed_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "QueryInputTransformOutput":
        """Creates a QueryInputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_input": d["transformed_input"],
        }

        return QueryInputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "QueryInputTransformOutput("
        if self.transformed_input is not None:
            result += f"transformed_input={repr(self.transformed_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, QueryInputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BatchWriteItemOutputTransformOutput:
    transformed_output: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_output: dict[str, Any],
    ):
        """
        :param transformed_output: <p>Represents the output of a
        <code>BatchWriteItem</code> operation.</p>
        """
        self.transformed_output = transformed_output

    def as_dict(self) -> Dict[str, Any]:
        """Converts the BatchWriteItemOutputTransformOutput to a dictionary."""
        return {
            "transformed_output": self.transformed_output.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BatchWriteItemOutputTransformOutput":
        """Creates a BatchWriteItemOutputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_output": d["transformed_output"],
        }

        return BatchWriteItemOutputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "BatchWriteItemOutputTransformOutput("
        if self.transformed_output is not None:
            result += f"transformed_output={repr(self.transformed_output)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BatchWriteItemOutputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_output",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class ScanOutputTransformInput:
    sdk_output: dict[str, Any]
    original_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_output: dict[str, Any],
        original_input: dict[str, Any],
    ):
        """
        :param sdk_output: <p>Represents the output of a <code>Scan</code>
        operation.</p>
        :param original_input: <p>Represents the input of a <code>Scan</code>
        operation.</p>
        """
        self.sdk_output = sdk_output
        self.original_input = original_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the ScanOutputTransformInput to a dictionary."""
        return {
            "sdk_output": self.sdk_output.as_dict(),
            "original_input": self.original_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "ScanOutputTransformInput":
        """Creates a ScanOutputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_output": d["sdk_output"],
            "original_input": d["original_input"],
        }

        return ScanOutputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "ScanOutputTransformInput("
        if self.sdk_output is not None:
            result += f"sdk_output={repr(self.sdk_output)}, "

        if self.original_input is not None:
            result += f"original_input={repr(self.original_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, ScanOutputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_output",
            "original_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class UpdateItemInputTransformInput:
    sdk_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_input: dict[str, Any],
    ):
        """
        :param sdk_input: <p>Represents the input of an <code>UpdateItem</code>
        operation.</p>
        """
        self.sdk_input = sdk_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the UpdateItemInputTransformInput to a dictionary."""
        return {
            "sdk_input": self.sdk_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "UpdateItemInputTransformInput":
        """Creates a UpdateItemInputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_input": d["sdk_input"],
        }

        return UpdateItemInputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "UpdateItemInputTransformInput("
        if self.sdk_input is not None:
            result += f"sdk_input={repr(self.sdk_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, UpdateItemInputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class UpdateItemInputTransformOutput:
    transformed_input: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_input: dict[str, Any],
    ):
        """
        :param transformed_input: <p>Represents the input of an <code>UpdateItem</code>
        operation.</p>
        """
        self.transformed_input = transformed_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the UpdateItemInputTransformOutput to a dictionary."""
        return {
            "transformed_input": self.transformed_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "UpdateItemInputTransformOutput":
        """Creates a UpdateItemInputTransformOutput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_input": d["transformed_input"],
        }

        return UpdateItemInputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "UpdateItemInputTransformOutput("
        if self.transformed_input is not None:
            result += f"transformed_input={repr(self.transformed_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, UpdateItemInputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class DeleteItemOutputTransformInput:
    sdk_output: dict[str, Any]
    original_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_output: dict[str, Any],
        original_input: dict[str, Any],
    ):
        """
        :param sdk_output: <p>Represents the output of a <code>DeleteItem</code>
        operation.</p>
        :param original_input: <p>Represents the input of a <code>DeleteItem</code>
        operation.</p>
        """
        self.sdk_output = sdk_output
        self.original_input = original_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the DeleteItemOutputTransformInput to a dictionary."""
        return {
            "sdk_output": self.sdk_output.as_dict(),
            "original_input": self.original_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "DeleteItemOutputTransformInput":
        """Creates a DeleteItemOutputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_output": d["sdk_output"],
            "original_input": d["original_input"],
        }

        return DeleteItemOutputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "DeleteItemOutputTransformInput("
        if self.sdk_output is not None:
            result += f"sdk_output={repr(self.sdk_output)}, "

        if self.original_input is not None:
            result += f"original_input={repr(self.original_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, DeleteItemOutputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_output",
            "original_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class PutItemOutputTransformInput:
    sdk_output: dict[str, Any]
    original_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_output: dict[str, Any],
        original_input: dict[str, Any],
    ):
        """
        :param sdk_output: <p>Represents the output of a <code>PutItem</code>
        operation.</p>
        :param original_input: <p>Represents the input of a <code>PutItem</code>
        operation.</p>
        """
        self.sdk_output = sdk_output
        self.original_input = original_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the PutItemOutputTransformInput to a dictionary."""
        return {
            "sdk_output": self.sdk_output.as_dict(),
            "original_input": self.original_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "PutItemOutputTransformInput":
        """Creates a PutItemOutputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_output": d["sdk_output"],
            "original_input": d["original_input"],
        }

        return PutItemOutputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "PutItemOutputTransformInput("
        if self.sdk_output is not None:
            result += f"sdk_output={repr(self.sdk_output)}, "

        if self.original_input is not None:
            result += f"original_input={repr(self.original_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, PutItemOutputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_output",
            "original_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class QueryOutputTransformInput:
    sdk_output: dict[str, Any]
    original_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_output: dict[str, Any],
        original_input: dict[str, Any],
    ):
        """
        :param sdk_output: <p>Represents the output of a <code>Query</code>
        operation.</p>
        :param original_input: <p>Represents the input of a <code>Query</code>
        operation.</p>
        """
        self.sdk_output = sdk_output
        self.original_input = original_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the QueryOutputTransformInput to a dictionary."""
        return {
            "sdk_output": self.sdk_output.as_dict(),
            "original_input": self.original_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "QueryOutputTransformInput":
        """Creates a QueryOutputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_output": d["sdk_output"],
            "original_input": d["original_input"],
        }

        return QueryOutputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "QueryOutputTransformInput("
        if self.sdk_output is not None:
            result += f"sdk_output={repr(self.sdk_output)}, "

        if self.original_input is not None:
            result += f"original_input={repr(self.original_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, QueryOutputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_output",
            "original_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class UpdateItemOutputTransformInput:
    sdk_output: dict[str, Any]
    original_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_output: dict[str, Any],
        original_input: dict[str, Any],
    ):
        """
        :param sdk_output: <p>Represents the output of an <code>UpdateItem</code>
        operation.</p>
        :param original_input: <p>Represents the input of an <code>UpdateItem</code>
        operation.</p>
        """
        self.sdk_output = sdk_output
        self.original_input = original_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the UpdateItemOutputTransformInput to a dictionary."""
        return {
            "sdk_output": self.sdk_output.as_dict(),
            "original_input": self.original_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "UpdateItemOutputTransformInput":
        """Creates a UpdateItemOutputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_output": d["sdk_output"],
            "original_input": d["original_input"],
        }

        return UpdateItemOutputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "UpdateItemOutputTransformInput("
        if self.sdk_output is not None:
            result += f"sdk_output={repr(self.sdk_output)}, "

        if self.original_input is not None:
            result += f"original_input={repr(self.original_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, UpdateItemOutputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_output",
            "original_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class BatchWriteItemOutputTransformInput:
    sdk_output: dict[str, Any]
    original_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_output: dict[str, Any],
        original_input: dict[str, Any],
    ):
        """
        :param sdk_output: <p>Represents the output of a <code>BatchWriteItem</code>
        operation.</p>
        :param original_input: <p>Represents the input of a <code>BatchWriteItem</code>
        operation.</p>
        """
        self.sdk_output = sdk_output
        self.original_input = original_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the BatchWriteItemOutputTransformInput to a dictionary."""
        return {
            "sdk_output": self.sdk_output.as_dict(),
            "original_input": self.original_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "BatchWriteItemOutputTransformInput":
        """Creates a BatchWriteItemOutputTransformInput from a dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_output": d["sdk_output"],
            "original_input": d["original_input"],
        }

        return BatchWriteItemOutputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "BatchWriteItemOutputTransformInput("
        if self.sdk_output is not None:
            result += f"sdk_output={repr(self.sdk_output)}, "

        if self.original_input is not None:
            result += f"original_input={repr(self.original_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, BatchWriteItemOutputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_output",
            "original_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class TransactWriteItemsInputTransformInput:
    sdk_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_input: dict[str, Any],
    ):
        self.sdk_input = sdk_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the TransactWriteItemsInputTransformInput to a
        dictionary."""
        return {
            "sdk_input": self.sdk_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "TransactWriteItemsInputTransformInput":
        """Creates a TransactWriteItemsInputTransformInput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_input": d["sdk_input"],
        }

        return TransactWriteItemsInputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "TransactWriteItemsInputTransformInput("
        if self.sdk_input is not None:
            result += f"sdk_input={repr(self.sdk_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, TransactWriteItemsInputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class TransactWriteItemsInputTransformOutput:
    transformed_input: dict[str, Any]

    def __init__(
        self,
        *,
        transformed_input: dict[str, Any],
    ):
        self.transformed_input = transformed_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the TransactWriteItemsInputTransformOutput to a
        dictionary."""
        return {
            "transformed_input": self.transformed_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "TransactWriteItemsInputTransformOutput":
        """Creates a TransactWriteItemsInputTransformOutput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "transformed_input": d["transformed_input"],
        }

        return TransactWriteItemsInputTransformOutput(**kwargs)

    def __repr__(self) -> str:
        result = "TransactWriteItemsInputTransformOutput("
        if self.transformed_input is not None:
            result += f"transformed_input={repr(self.transformed_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, TransactWriteItemsInputTransformOutput):
            return False
        attributes: list[str] = [
            "transformed_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class TransactWriteItemsOutputTransformInput:
    sdk_output: dict[str, Any]
    original_input: dict[str, Any]

    def __init__(
        self,
        *,
        sdk_output: dict[str, Any],
        original_input: dict[str, Any],
    ):
        self.sdk_output = sdk_output
        self.original_input = original_input

    def as_dict(self) -> Dict[str, Any]:
        """Converts the TransactWriteItemsOutputTransformInput to a
        dictionary."""
        return {
            "sdk_output": self.sdk_output.as_dict(),
            "original_input": self.original_input.as_dict(),
        }

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "TransactWriteItemsOutputTransformInput":
        """Creates a TransactWriteItemsOutputTransformInput from a
        dictionary."""
        kwargs: Dict[str, Any] = {
            "sdk_output": d["sdk_output"],
            "original_input": d["original_input"],
        }

        return TransactWriteItemsOutputTransformInput(**kwargs)

    def __repr__(self) -> str:
        result = "TransactWriteItemsOutputTransformInput("
        if self.sdk_output is not None:
            result += f"sdk_output={repr(self.sdk_output)}, "

        if self.original_input is not None:
            result += f"original_input={repr(self.original_input)}"

        return result + ")"

    def __eq__(self, other: Any) -> bool:
        if not isinstance(other, TransactWriteItemsOutputTransformInput):
            return False
        attributes: list[str] = [
            "sdk_output",
            "original_input",
        ]
        return all(getattr(self, a) == getattr(other, a) for a in attributes)


class Unit:
    pass
