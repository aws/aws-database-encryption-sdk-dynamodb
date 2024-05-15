// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class oneToFiveInput
  {
    private int? _inputOne;
    public int InputOne
    {
      get { return this._inputOne.GetValueOrDefault(); }
      set { this._inputOne = value; }
    }
    public bool IsSetInputOne()
    {
      return this._inputOne.HasValue;
    }
    public void Validate()
    {
      if (IsSetInputOne())
      {
        if (InputOne < 1)
        {
          throw new System.ArgumentException(
              String.Format("Member InputOne of structure oneToFiveInput has type oneToFiveIp which has a minimum of 1 but was given the value {0}.", InputOne));
        }
        if (InputOne > 5)
        {
          throw new System.ArgumentException(
              String.Format("Member InputOne of structure oneToFiveInput has type oneToFiveIp which has a maximum of 5 but was given the value {0}.", InputOne));
        }
      }
    }
  }
}
