// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class GetEncryptedDataKeyDescriptionOutput
  {
    private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription> _encryptedDataKeyDescriptionOutput;
    public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.DynamoDb.EncryptedDataKeyDescription> EncryptedDataKeyDescriptionOutput
    {
      get { return this._encryptedDataKeyDescriptionOutput; }
      set { this._encryptedDataKeyDescriptionOutput = value; }
    }
    public bool IsSetEncryptedDataKeyDescriptionOutput()
    {
      return this._encryptedDataKeyDescriptionOutput != null;
    }
    public void Validate()
    {
      if (!IsSetEncryptedDataKeyDescriptionOutput()) throw new System.ArgumentException("Missing value for required property 'EncryptedDataKeyDescriptionOutput'");

    }
  }
}
