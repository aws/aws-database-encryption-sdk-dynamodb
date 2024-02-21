// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms
{
  public class GetItemOutputTransformInput
  {
    private Amazon.DynamoDBv2.Model.GetItemResponse _sdkOutput;
    private Amazon.DynamoDBv2.Model.GetItemRequest _originalInput;
    public Amazon.DynamoDBv2.Model.GetItemResponse SdkOutput
    {
      get { return this._sdkOutput; }
      set { this._sdkOutput = value; }
    }
    public bool IsSetSdkOutput()
    {
      return this._sdkOutput != null;
    }
    public Amazon.DynamoDBv2.Model.GetItemRequest OriginalInput
    {
      get { return this._originalInput; }
      set { this._originalInput = value; }
    }
    public bool IsSetOriginalInput()
    {
      return this._originalInput != null;
    }
    public void Validate()
    {
      if (!IsSetSdkOutput()) throw new System.ArgumentException("Missing value for required property 'SdkOutput'");
      if (!IsSetOriginalInput()) throw new System.ArgumentException("Missing value for required property 'OriginalInput'");

    }
  }
}
