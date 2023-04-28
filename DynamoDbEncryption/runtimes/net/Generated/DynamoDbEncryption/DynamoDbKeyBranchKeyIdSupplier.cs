// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using System.IO;
 using System.Collections.Generic;
 using AWS.Cryptography.DynamoDbEncryption;
 using Dafny.Aws.Cryptography.DynamoDbEncryption.Types; namespace AWS.Cryptography.DynamoDbEncryption {
 internal class DynamoDbKeyBranchKeyIdSupplier : DynamoDbKeyBranchKeyIdSupplierBase {
 internal readonly Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier _impl;
 internal DynamoDbKeyBranchKeyIdSupplier(Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier impl) { this._impl = impl; }
 protected override AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput _GetBranchKeyIdFromDdbKey(AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyInput input) {
 Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_GetBranchKeyIdFromDdbKeyInput(input);
 Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> result = this._impl.GetBranchKeyIdFromDdbKey(internalInput);
 if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
 return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_GetBranchKeyIdFromDdbKeyOutput(result.dtor_value);
}
}
}
