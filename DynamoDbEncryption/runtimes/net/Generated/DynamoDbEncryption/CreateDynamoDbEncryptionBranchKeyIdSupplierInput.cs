// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class CreateDynamoDbEncryptionBranchKeyIdSupplierInput
  {
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.IDynamoDbKeyBranchKeyIdSupplier _ddbKeyBranchKeyIdSupplier;
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.IDynamoDbKeyBranchKeyIdSupplier DdbKeyBranchKeyIdSupplier
    {
      get { return this._ddbKeyBranchKeyIdSupplier; }
      set { this._ddbKeyBranchKeyIdSupplier = value; }
    }
    public bool IsSetDdbKeyBranchKeyIdSupplier()
    {
      return this._ddbKeyBranchKeyIdSupplier != null;
    }
    public void Validate()
    {
      if (!IsSetDdbKeyBranchKeyIdSupplier()) throw new System.ArgumentException("Missing value for required property 'DdbKeyBranchKeyIdSupplier'");

    }
  }
}
