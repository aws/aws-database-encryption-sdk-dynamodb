// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class GetNumberOfQueriesInput
  {
    private Amazon.DynamoDBv2.Model.QueryRequest _input;
    public Amazon.DynamoDBv2.Model.QueryRequest Input
    {
      get { return this._input; }
      set { this._input = value; }
    }
    public bool IsSetInput()
    {
      return this._input != null;
    }
    public void Validate()
    {
      if (!IsSetInput()) throw new System.ArgumentException("Missing value for required property 'Input'");

    }
  }
}
