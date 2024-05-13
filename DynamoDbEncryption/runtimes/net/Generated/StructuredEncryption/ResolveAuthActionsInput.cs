// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.StructuredEncryption;
namespace AWS.Cryptography.DbEncryptionSDK.StructuredEncryption
{
  public class ResolveAuthActionsInput
  {
    private string _tableName;
    private System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem> _authActions;
    private System.IO.MemoryStream _headerBytes;
    public string TableName
    {
      get { return this._tableName; }
      set { this._tableName = value; }
    }
    public bool IsSetTableName()
    {
      return this._tableName != null;
    }
    public System.Collections.Generic.List<AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.AuthItem> AuthActions
    {
      get { return this._authActions; }
      set { this._authActions = value; }
    }
    public bool IsSetAuthActions()
    {
      return this._authActions != null;
    }
    public System.IO.MemoryStream HeaderBytes
    {
      get { return this._headerBytes; }
      set { this._headerBytes = value; }
    }
    public bool IsSetHeaderBytes()
    {
      return this._headerBytes != null;
    }
    public void Validate()
    {
      if (!IsSetTableName()) throw new System.ArgumentException("Missing value for required property 'TableName'");
      if (!IsSetAuthActions()) throw new System.ArgumentException("Missing value for required property 'AuthActions'");
      if (!IsSetHeaderBytes()) throw new System.ArgumentException("Missing value for required property 'HeaderBytes'");

    }
  }
}
