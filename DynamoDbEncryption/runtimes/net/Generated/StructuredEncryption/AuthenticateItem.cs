// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption
{
  public class AuthenticateItem
  {
    private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment> _key;
    private AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal _data;
    private AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction _action;
    public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.PathSegment> Key
    {
      get { return this._key; }
      set { this._key = value; }
    }
    public bool IsSetKey()
    {
      return this._key != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.StructuredDataTerminal Data
    {
      get { return this._data; }
      set { this._data = value; }
    }
    public bool IsSetData()
    {
      return this._data != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction Action
    {
      get { return this._action; }
      set { this._action = value; }
    }
    public bool IsSetAction()
    {
      return this._action != null;
    }
    public void Validate()
    {
      if (!IsSetKey()) throw new System.ArgumentException("Missing value for required property 'Key'");
      if (!IsSetData()) throw new System.ArgumentException("Missing value for required property 'Data'");
      if (!IsSetAction()) throw new System.ArgumentException("Missing value for required property 'Action'");

    }
  }
}
