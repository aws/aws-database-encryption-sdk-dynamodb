// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class EncryptObjectInput
  {
    private string _plaintextObject;
    public string PlaintextObject
    {
      get { return this._plaintextObject; }
      set { this._plaintextObject = value; }
    }
    public bool IsSetPlaintextObject()
    {
      return this._plaintextObject != null;
    }
    public void Validate()
    {
      if (!IsSetPlaintextObject()) throw new System.ArgumentException("Missing value for required property 'PlaintextObject'");

    }
  }
}
