// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DynamoDbEncryption.Resources;
namespace AWS.Cryptography.DynamoDbEncryption.Resources
{
  public class CreateDynamoDbEncryptionBranchKeyIdSupplierInput
  {
    private AWS.Cryptography.DynamoDbEncryption.Resources.IDynamoDbItemBranchKeyIdSupplier _ddbItemBranchKeyIdSupplier;
    public AWS.Cryptography.DynamoDbEncryption.Resources.IDynamoDbItemBranchKeyIdSupplier DdbItemBranchKeyIdSupplier
    {
      get { return this._ddbItemBranchKeyIdSupplier; }
      set { this._ddbItemBranchKeyIdSupplier = value; }
    }
    public bool IsSetDdbItemBranchKeyIdSupplier()
    {
      return this._ddbItemBranchKeyIdSupplier != null;
    }
    public void Validate()
    {
      if (!IsSetDdbItemBranchKeyIdSupplier()) throw new System.ArgumentException("Missing value for required property 'DdbItemBranchKeyIdSupplier'");

    }
  }
}
