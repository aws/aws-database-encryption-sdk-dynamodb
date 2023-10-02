// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class TwinnedSet
  {
    private string _other;
    public string Other
    {
      get { return this._other; }
      set { this._other = value; }
    }
    public bool IsSetOther()
    {
      return this._other != null;
    }
    public void Validate()
    {
      if (!IsSetOther()) throw new System.ArgumentException("Missing value for required property 'Other'");

    }
  }
}
