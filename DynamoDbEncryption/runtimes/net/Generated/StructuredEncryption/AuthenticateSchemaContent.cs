// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption
{
  public class AuthenticateSchemaContent
  {
    private AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction _action;
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateSchema> _schemaMap;
    private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateSchema> _schemaList;
    public AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateAction Action
    {
      get { return this._action; }
      set { this._action = value; }
    }
    public bool IsSetAction()
    {
      return this._action != null;
    }
    public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateSchema> SchemaMap
    {
      get { return this._schemaMap; }
      set { this._schemaMap = value; }
    }
    public bool IsSetSchemaMap()
    {
      return this._schemaMap != null;
    }
    public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthenticateSchema> SchemaList
    {
      get { return this._schemaList; }
      set { this._schemaList = value; }
    }
    public bool IsSetSchemaList()
    {
      return this._schemaList != null;
    }
    public void Validate()
    {
      var numberOfPropertiesSet = Convert.ToUInt16(IsSetAction()) +
      Convert.ToUInt16(IsSetSchemaMap()) +
      Convert.ToUInt16(IsSetSchemaList());
      if (numberOfPropertiesSet == 0) throw new System.ArgumentException("No union value set");

      if (numberOfPropertiesSet > 1) throw new System.ArgumentException("Multiple union values set");

    }
  }
}
