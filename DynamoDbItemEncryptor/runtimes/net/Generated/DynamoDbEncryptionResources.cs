// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using System.IO;
using System.Collections.Generic;
using AWS.Cryptography.DynamoDbEncryption.Resources;
using Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types;
namespace AWS.Cryptography.DynamoDbEncryption.Resources
{
  public class DynamoDbEncryptionResources
  {
    private readonly Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types.IDynamoDbEncryptionResourcesClient _impl;
    public DynamoDbEncryptionResources(AWS.Cryptography.DynamoDbEncryption.Resources.DynamoDbEncryptionResourcesConfig input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IDynamoDbEncryptionResourcesConfig internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S33_DynamoDbEncryptionResourcesConfig(input);
      var result = Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.__default.DynamoDbEncryptionResources(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      this._impl = result.dtor_value;
    }
    public AWS.Cryptography.DynamoDbEncryption.Resources.CreateDynamoDbEncryptionBranchKeyIdSupplierOutput CreateDynamoDbEncryptionBranchKeyIdSupplier(AWS.Cryptography.DynamoDbEncryption.Resources.CreateDynamoDbEncryptionBranchKeyIdSupplierInput input)
    {
      Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierInput internalInput = TypeConversion.ToDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S48_CreateDynamoDbEncryptionBranchKeyIdSupplierInput(input);
      Wrappers_Compile._IResult<Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._ICreateDynamoDbEncryptionBranchKeyIdSupplierOutput, Dafny.Aws.Cryptography.DynamoDbEncryption.Resources.Types._IError> result = _impl.CreateDynamoDbEncryptionBranchKeyIdSupplier(internalInput);
      if (result.is_Failure) throw TypeConversion.FromDafny_CommonError(result.dtor_error);
      return TypeConversion.FromDafny_N3_aws__N12_cryptography__N18_dynamoDbEncryption__N9_resources__S49_CreateDynamoDbEncryptionBranchKeyIdSupplierOutput(result.dtor_value);
    }
  }
}
