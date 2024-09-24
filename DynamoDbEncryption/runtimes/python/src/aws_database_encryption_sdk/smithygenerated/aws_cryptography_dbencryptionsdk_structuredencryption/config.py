# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

from aws_database_encryption_sdk.internaldafny.generated.AwsCryptographyDbEncryptionSdkStructuredEncryptionTypes import (
    StructuredEncryptionConfig_StructuredEncryptionConfig as DafnyStructuredEncryptionConfig,
)
import aws_database_encryption_sdk.internaldafny.generated.module_
import aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy
import aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny
from dataclasses import dataclass
from typing import Any, Callable, TypeAlias

from .dafnyImplInterface import DafnyImplInterface
from smithy_python._private.retries import SimpleRetryStrategy
from smithy_python.interfaces.retries import RetryStrategy


_ServiceInterceptor = Any
@dataclass(init=False)
class Config:
    """Configuration for StructuredEncryption."""

    interceptors: list[_ServiceInterceptor]
    retry_strategy: RetryStrategy
    dafnyImplInterface: DafnyImplInterface | None

    def __init__(
        self,
        *,
        interceptors: list[_ServiceInterceptor] | None = None,
        retry_strategy: RetryStrategy | None = None,
        dafnyImplInterface: DafnyImplInterface | None = None,
    ):
        """Constructor.

        :param interceptors: The list of interceptors, which are hooks that are called
        during the execution of a request.

        :param retry_strategy: The retry strategy for issuing retry tokens and computing
        retry delays.

        :param dafnyImplInterface:
        """
        self.interceptors = interceptors or []
        self.retry_strategy = retry_strategy or SimpleRetryStrategy()
        self.dafnyImplInterface = dafnyImplInterface

# A callable that allows customizing the config object on each request.
Plugin: TypeAlias = Callable[[Config], None]

class StructuredEncryptionConfig(Config):
    """
    Smithy-modelled localService Config shape for this localService.
    """

    def __init__(
        self,

    ):
        """Constructor for StructuredEncryptionConfig.

        """
        super().__init__()

def dafny_config_to_smithy_config(dafny_config) -> StructuredEncryptionConfig:
    """
    Converts the provided Dafny shape for this localService's config
    into the corresponding Smithy-modelled shape.
    """
    return aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.dafny_to_smithy.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredEncryptionConfig(dafny_config)

def smithy_config_to_dafny_config(smithy_config) -> DafnyStructuredEncryptionConfig:
    """
    Converts the provided Smithy-modelled shape for this localService's config
    into the corresponding Dafny shape.
    """
    return aws_database_encryption_sdk.smithygenerated.aws_cryptography_dbencryptionsdk_structuredencryption.smithy_to_dafny.aws_cryptography_dbencryptionsdk_structuredencryption_StructuredEncryptionConfig(smithy_config)
