# Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
# SPDX-License-Identifier: Apache-2.0
# Do not modify this file. This file is machine generated, and any changes to it will be overwritten.

import abc
import aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes
from aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes import (
    GetBranchKeyIdFromDdbKeyInput_GetBranchKeyIdFromDdbKeyInput as DafnyGetBranchKeyIdFromDdbKeyInput,
    GetBranchKeyIdFromDdbKeyOutput_GetBranchKeyIdFromDdbKeyOutput as DafnyGetBranchKeyIdFromDdbKeyOutput,
)
import aws_dbesdk_dynamodb.internaldafny.generated.module_
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy
from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.errors import (
    _smithy_error_to_dafny_error,
)
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models
import aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny
from smithy_dafny_standard_library.internaldafny.generated import Wrappers
from typing import Any, Dict


class ILegacyDynamoDbEncryptor(metaclass=abc.ABCMeta):

    @classmethod
    def __subclasshook__(cls, subclass):
        return ()


class LegacyDynamoDbEncryptor(ILegacyDynamoDbEncryptor):

    _impl: (
        aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes.ILegacyDynamoDbEncryptor
    )

    def __init__(
        self,
        _impl: aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes.ILegacyDynamoDbEncryptor,
    ):
        self._impl = _impl

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "LegacyDynamoDbEncryptor":
        return LegacyDynamoDbEncryptor(d["_impl"])

    def as_dict(self) -> Dict[str, Any]:
        return {"_impl": self._impl}


class IDynamoDbKeyBranchKeyIdSupplier(metaclass=abc.ABCMeta):

    @classmethod
    def __subclasshook__(cls, subclass):
        return hasattr(subclass, "GetBranchKeyIdFromDdbKey") and callable(subclass.GetBranchKeyIdFromDdbKey)

    @abc.abstractmethod
    def get_branch_key_id_from_ddb_key(
        self,
        param: "aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetBranchKeyIdFromDdbKeyInput",
    ) -> "aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetBranchKeyIdFromDdbKeyOutput":
        """Get the Branch Key that should be used for wrapping and unwrapping
        data keys based on the primary key of the item being read or written,
        along with the values of any attributes configured as
        SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.

        :param param: Inputs for getting the Branch Key that should be
            used for wrapping and unwrapping data keys.
        :returns: Outputs for getting the Branch Key that should be used
            for wrapping and unwrapping data keys.
        """
        raise NotImplementedError

    def GetBranchKeyIdFromDdbKey(
        self, dafny_input: "DafnyGetBranchKeyIdFromDdbKeyInput"
    ) -> "DafnyGetBranchKeyIdFromDdbKeyOutput":
        """Do not use.

        This method allows custom implementations of this interface to
        interact with generated code.
        """
        native_input = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_GetBranchKeyIdFromDdbKeyInput(
            dafny_input
        )
        try:
            native_output = self.get_branch_key_id_from_ddb_key(native_input)
            dafny_output = aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_GetBranchKeyIdFromDdbKeyOutput(
                native_output
            )
            return Wrappers.Result_Success(dafny_output)
        except Exception as e:
            error = _smithy_error_to_dafny_error(e)
            return Wrappers.Result_Failure(error)


class DynamoDbKeyBranchKeyIdSupplier(IDynamoDbKeyBranchKeyIdSupplier):

    _impl: (
        aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes.IDynamoDbKeyBranchKeyIdSupplier
    )

    def __init__(
        self,
        _impl: aws_dbesdk_dynamodb.internaldafny.generated.AwsCryptographyDbEncryptionSdkDynamoDbTypes.IDynamoDbKeyBranchKeyIdSupplier,
    ):
        self._impl = _impl

    def get_branch_key_id_from_ddb_key(
        self,
        param: "aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetBranchKeyIdFromDdbKeyInput",
    ) -> "aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.models.GetBranchKeyIdFromDdbKeyOutput":
        """Get the Branch Key that should be used for wrapping and unwrapping
        data keys based on the primary key of the item being read or written,
        along with the values of any attributes configured as
        SIGN_AND_INCLUDE_IN_ENCRYPTION_CONTEXT.

        :param param: Inputs for getting the Branch Key that should be
            used for wrapping and unwrapping data keys.
        :returns: Outputs for getting the Branch Key that should be used
            for wrapping and unwrapping data keys.
        """
        dafny_output = self._impl.GetBranchKeyIdFromDdbKey(
            aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.smithy_to_dafny.aws_cryptography_dbencryptionsdk_dynamodb_GetBranchKeyIdFromDdbKeyInput(
                param
            )
        )
        if dafny_output.IsFailure():
            from aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.deserialize import (
                _deserialize_error as aws_cryptography_dbencryptionsdk_dynamodb_deserialize_error,
            )

            raise aws_cryptography_dbencryptionsdk_dynamodb_deserialize_error(dafny_output.error)

        else:
            return aws_dbesdk_dynamodb.smithygenerated.aws_cryptography_dbencryptionsdk_dynamodb.dafny_to_smithy.aws_cryptography_dbencryptionsdk_dynamodb_GetBranchKeyIdFromDdbKeyOutput(
                dafny_output.value
            )

    @staticmethod
    def from_dict(d: Dict[str, Any]) -> "DynamoDbKeyBranchKeyIdSupplier":
        return DynamoDbKeyBranchKeyIdSupplier(d["_impl"])

    def as_dict(self) -> Dict[str, Any]:
        return {"_impl": self._impl}
