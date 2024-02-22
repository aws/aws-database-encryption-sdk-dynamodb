// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class KeyAccess
  {
    private AWS.Cryptography.MaterialProviders.IKeyring _keyring;
    private AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager _cmm;
    public AWS.Cryptography.MaterialProviders.IKeyring Keyring
    {
      get { return this._keyring; }
      set { this._keyring = value; }
    }
    public bool IsSetKeyring()
    {
      return this._keyring != null;
    }
    public AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager Cmm
    {
      get { return this._cmm; }
      set { this._cmm = value; }
    }
    public bool IsSetCmm()
    {
      return this._cmm != null;
    }
    public void Validate()
    {
      var numberOfPropertiesSet = Convert.ToUInt16(IsSetKeyring()) +
      Convert.ToUInt16(IsSetCmm());
      if (numberOfPropertiesSet == 0) throw new System.ArgumentException("No union value set");

      if (numberOfPropertiesSet > 1) throw new System.ArgumentException("Multiple union values set");

    }
  }
}
