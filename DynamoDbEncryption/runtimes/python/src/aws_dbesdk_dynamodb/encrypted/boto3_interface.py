# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
import abc
from abc import abstractmethod
from typing import Any


class EncryptedBotoInterface(abc.ABC):
    """Interface for encrypted boto3 interfaces."""

    def _copy_sdk_response_to_dbesdk_response(
        self, sdk_response: dict[str, Any], dbesdk_response: dict[str, Any]
    ) -> dict[str, Any]:
        """Copy any missing fields from the SDK response to the DBESDK response.

        Args:
            sdk_response: The raw SDK response
            dbesdk_response: The current DBESDK response

        Returns:
            dict: The DBESDK response with any missing fields copied from SDK response

        """
        for sdk_response_key, sdk_response_value in sdk_response.items():
            if sdk_response_key not in dbesdk_response:
                dbesdk_response[sdk_response_key] = sdk_response_value
        return dbesdk_response

    @property
    @abstractmethod
    def _boto_client_attr_name(self) -> str:
        """Name of the attribute containing the underlying boto3 client."""

    def __getattr__(self, name: str) -> Any:
        """Delegate unknown attributes to the underlying client.

        Args:
            name: The name of the attribute to get

        Returns:
            Any: The attribute value from the underlying client

        Raises:
            AttributeError: If the attribute doesn't exist on the underlying client

        """
        client_attr = getattr(self, self._boto_client_attr_name)
        if hasattr(client_attr, name):
            return getattr(client_attr, name)
        raise AttributeError(f"'{self.__class__.__name__}' object has no attribute '{name}'")
