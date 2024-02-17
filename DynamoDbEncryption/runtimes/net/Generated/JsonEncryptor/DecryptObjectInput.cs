// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class DecryptObjectInput
  {
    private string _encryptedObject;
    public string EncryptedObject
    {
      get { return this._encryptedObject; }
      set { this._encryptedObject = value; }
    }
    public bool IsSetEncryptedObject()
    {
      return this._encryptedObject != null;
    }
    public void Validate()
    {
      if (!IsSetEncryptedObject()) throw new System.ArgumentException("Missing value for required property 'EncryptedObject'");

    }
  }
}
