// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class oneToFiveOutput
  {
    private int? _outputOne;
    public int OutputOne
    {
      get { return this._outputOne.GetValueOrDefault(); }
      set { this._outputOne = value; }
    }
    public bool IsSetOutputOne()
    {
      return this._outputOne.HasValue;
    }
    public void Validate()
    {
      if (IsSetOutputOne())
      {
        if (OutputOne < 1)
        {
          throw new System.ArgumentException(
              String.Format("Member OutputOne of structure oneToFiveOutput has type oneToFiveOp which has a minimum of 1 but was given the value {0}.", OutputOne));
        }
        if (OutputOne > 5)
        {
          throw new System.ArgumentException(
              String.Format("Member OutputOne of structure oneToFiveOutput has type oneToFiveOp which has a maximum of 5 but was given the value {0}.", OutputOne));
        }
      }
    }
  }
}
