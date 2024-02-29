// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class DecryptAs
  {
    private string _encrypt;
    private string _decrypt;
    public string Encrypt
    {
      get { return this._encrypt; }
      set { this._encrypt = value; }
    }
    public bool IsSetEncrypt()
    {
      return this._encrypt != null;
    }
    public string Decrypt
    {
      get { return this._decrypt; }
      set { this._decrypt = value; }
    }
    public bool IsSetDecrypt()
    {
      return this._decrypt != null;
    }
    public void Validate()
    {

    }
  }
}
