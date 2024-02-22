// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class DefaultAction
  {
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ExplicitUnsigned _explicitUnsigned;
    private AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction _defaultAction;
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.ExplicitUnsigned ExplicitUnsigned
    {
      get { return this._explicitUnsigned; }
      set { this._explicitUnsigned = value; }
    }
    public bool IsSetExplicitUnsigned()
    {
      return this._explicitUnsigned != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction DefaultAction
    {
      get { return this._defaultAction; }
      set { this._defaultAction = value; }
    }
    public bool IsSetDefaultAction()
    {
      return this._defaultAction != null;
    }
    public void Validate()
    {
      var numberOfPropertiesSet = Convert.ToUInt16(IsSetExplicitUnsigned()) +
      Convert.ToUInt16(IsSetDefaultAction());
      if (numberOfPropertiesSet == 0) throw new System.ArgumentException("No union value set");

      if (numberOfPropertiesSet > 1) throw new System.ArgumentException("Multiple union values set");

    }
  }
}
