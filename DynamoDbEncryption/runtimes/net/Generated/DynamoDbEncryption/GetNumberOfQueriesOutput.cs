// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class GetNumberOfQueriesOutput
  {
    private int? _numberOfQueries;
    public int NumberOfQueries
    {
      get { return this._numberOfQueries.GetValueOrDefault(); }
      set { this._numberOfQueries = value; }
    }
    public bool IsSetNumberOfQueries()
    {
      return this._numberOfQueries.HasValue;
    }
    public void Validate()
    {
      if (!IsSetNumberOfQueries()) throw new System.ArgumentException("Missing value for required property 'NumberOfQueries'");

    }
  }
}
