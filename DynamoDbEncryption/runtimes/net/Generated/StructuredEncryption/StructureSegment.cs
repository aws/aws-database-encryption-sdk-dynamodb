// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption
{
  public class StructureSegment
  {
    private string _key;
    public string Key
    {
      get { return this._key; }
      set { this._key = value; }
    }
    public bool IsSetKey()
    {
      return this._key != null;
    }
    public void Validate()
    {
      if (!IsSetKey()) throw new System.ArgumentException("Missing value for required property 'Key'");

    }
  }
}
