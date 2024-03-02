// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class Action
  {
    private AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction _crypto;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EsdkEncrypt _esdk;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncrypt _dbesdk;
    public AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction Crypto
    {
      get { return this._crypto; }
      set { this._crypto = value; }
    }
    public bool IsSetCrypto()
    {
      return this._crypto != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.EsdkEncrypt Esdk
    {
      get { return this._esdk; }
      set { this._esdk = value; }
    }
    public bool IsSetEsdk()
    {
      return this._esdk != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.JsonEncrypt Dbesdk
    {
      get { return this._dbesdk; }
      set { this._dbesdk = value; }
    }
    public bool IsSetDbesdk()
    {
      return this._dbesdk != null;
    }
    public void Validate()
    {
      var numberOfPropertiesSet = Convert.ToUInt16(IsSetCrypto()) +
      Convert.ToUInt16(IsSetEsdk()) +
      Convert.ToUInt16(IsSetDbesdk());
      if (numberOfPropertiesSet == 0) throw new System.ArgumentException("No union value set");

      if (numberOfPropertiesSet > 1) throw new System.ArgumentException("Multiple union values set");

    }
  }
}
