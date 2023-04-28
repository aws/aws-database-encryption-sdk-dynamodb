// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
// ReSharper disable RedundantUsingDirective
// ReSharper disable RedundantNameQualifier
// ReSharper disable SuggestVarOrType_SimpleTypes
 using System;
 using _System;
 using Wrappers_Compile;

 namespace AWS.Cryptography.DynamoDbEncryption {
 internal class NativeWrapper_DynamoDbKeyBranchKeyIdSupplier : Dafny.Aws.Cryptography.DynamoDbEncryption.Types.IDynamoDbKeyBranchKeyIdSupplier 
 {
 internal readonly DynamoDbKeyBranchKeyIdSupplierBase _impl;
 public NativeWrapper_DynamoDbKeyBranchKeyIdSupplier(DynamoDbKeyBranchKeyIdSupplierBase nativeImpl)
 {
 _impl = nativeImpl;
}
 public Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> GetBranchKeyIdFromDdbKey(Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyInput input)
 {
 void validateOutput(AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput nativeOutput) {
 try { nativeOutput.Validate(); } catch (ArgumentException e)
 {
 var message = $"Output of {_impl}._GetBranchKeyIdFromDdbKey is invalid. {e.Message}";
 throw new DynamoDbEncryptionException(message);
}
}
 AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyInput nativeInput = TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S29_GetBranchKeyIdFromDdbKeyInput(input);
 try {
 AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput nativeOutput = _impl.GetBranchKeyIdFromDdbKey(nativeInput);
 _ = nativeOutput ?? throw new DynamoDbEncryptionException($"{_impl}._GetBranchKeyIdFromDdbKey returned null, should be {typeof(AWS.Cryptography.DynamoDbEncryption.GetBranchKeyIdFromDdbKeyOutput)}");
 validateOutput(nativeOutput);
 return Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError>.create_Success(TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__S30_GetBranchKeyIdFromDdbKeyOutput(nativeOutput));
}
 catch(Exception e)
 {
 return Wrappers_Compile.Result<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError>.create_Failure(TypeConversion.ToDafny_CommonError(e));
}
}
 public Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IError> GetBranchKeyIdFromDdbKey_k(Dafny.Aws.Cryptography.DynamoDbEncryption.Types._IGetBranchKeyIdFromDdbKeyInput input)
 {
 throw new DynamoDbEncryptionException("Not supported at this time.");
}
}
}
