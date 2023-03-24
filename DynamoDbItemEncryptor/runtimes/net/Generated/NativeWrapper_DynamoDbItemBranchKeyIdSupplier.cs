// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
// ReSharper disable RedundantUsingDirective
// ReSharper disable RedundantNameQualifier
// ReSharper disable SuggestVarOrType_SimpleTypes
 using System;
 using _System;
 using Wrappers_Compile;

 namespace AWS.Cryptography.DynamoDbEncryption.Resources {
 internal class NativeWrapper_DynamoDbItemBranchKeyIdSupplier : Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbItemBranchKeyIdSupplier 
 {
 internal readonly DynamoDbItemBranchKeyIdSupplierBase _impl;
 public NativeWrapper_DynamoDbItemBranchKeyIdSupplier(DynamoDbItemBranchKeyIdSupplierBase nativeImpl)
 {
 _impl = nativeImpl;
}
 public Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IGetBranchKeyIdFromItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IError> GetBranchKeyIdFromItem(Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IGetBranchKeyIdFromItemInput input)
 {
 void validateOutput(AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemOutput nativeOutput) {
 try { nativeOutput.Validate(); } catch (ArgumentException e)
 {
 var message = $"Output of {_impl}._GetBranchKeyIdFromItem is invalid. {e.Message}";
 throw new DynamoDbEncryptionResourcesSupplierException(message);
}
}
 AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemInput nativeInput = TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S27_GetBranchKeyIdFromItemInput(input);
 try {
 AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemOutput nativeOutput = _impl.GetBranchKeyIdFromItem(nativeInput);
 _ = nativeOutput ?? throw new DynamoDbEncryptionResourcesSupplierException($"{_impl}._GetBranchKeyIdFromItem returned null, should be {typeof(AWS.Cryptography.DynamoDbEncryption.Resources.GetBranchKeyIdFromItemOutput)}");
 validateOutput(nativeOutput);
 return Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IGetBranchKeyIdFromItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IError>.create_Success(TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S28_GetBranchKeyIdFromItemOutput(nativeOutput));
}
 catch(Exception e)
 {
 return Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IGetBranchKeyIdFromItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IError>.create_Failure(TypeConversion.ToDafny_CommonError(e));
}
}
 public Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IGetBranchKeyIdFromItemOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IError> GetBranchKeyIdFromItem_k(Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IGetBranchKeyIdFromItemInput input)
 {
 throw new DynamoDbEncryptionResourcesSupplierException("Not supported at this time.");
}
}
}
