// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json
{
  public class JsonEncryptorConfig
  {
    private string _logicalTableName;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Actions _actions;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DbesdkEncrypt _encrypt;
    public string LogicalTableName
    {
      get { return this._logicalTableName; }
      set { this._logicalTableName = value; }
    }
    public bool IsSetLogicalTableName()
    {
      return this._logicalTableName != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.Actions Actions
    {
      get { return this._actions; }
      set { this._actions = value; }
    }
    public bool IsSetActions()
    {
      return this._actions != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.Json.DbesdkEncrypt Encrypt
    {
      get { return this._encrypt; }
      set { this._encrypt = value; }
    }
    public bool IsSetEncrypt()
    {
      return this._encrypt != null;
    }
    public void Validate()
    {
      if (!IsSetLogicalTableName()) throw new System.ArgumentException("Missing value for required property 'LogicalTableName'");
      if (!IsSetActions()) throw new System.ArgumentException("Missing value for required property 'Actions'");

    }
  }
}
