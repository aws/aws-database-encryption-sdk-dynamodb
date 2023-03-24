// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using System.IO;
 using System.Collections.Generic;
 using AWS.Cryptography.DynamoDbEncryption.Resources;
 using Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types; namespace AWS.Cryptography.DynamoDbEncryption.Resources {
 internal class DynamoDbItemBranchKeyIdSupplier : DynamoDbItemBranchKeyIdSupplierBase {
 internal readonly Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbItemBranchKeyIdSupplier _impl;
 internal DynamoDbItemBranchKeyIdSupplier(Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbItemBranchKeyIdSupplier impl) { this._impl = impl; }
 protected override AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemOutput _GetBranchKeyIdFromItem(AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemInput input) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IGetBranchKeyIdFromItemInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S27_GetBranchKeyIdFromItemInput(input);
 Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IGetBranchKeyIdFromItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IError> result = this._impl.GetBranchKeyIdFromItem(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S28_GetBranchKeyIdFromItemOutput(result.dtor_value);
}
}
}
