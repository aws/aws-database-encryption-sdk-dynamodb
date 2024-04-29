// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb.Transforms
{
  public class ResolveAttributesInput
  {
    private string _tableName;
    private System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> _item;
    private int? _version;
    public string TableName
    {
      get { return this._tableName; }
      set { this._tableName = value; }
    }
    public bool IsSetTableName()
    {
      return this._tableName != null;
    }
    public System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> Item
    {
      get { return this._item; }
      set { this._item = value; }
    }
    public bool IsSetItem()
    {
      return this._item != null;
    }
    public int Version
    {
      get { return this._version.GetValueOrDefault(); }
      set { this._version = value; }
    }
    public bool IsSetVersion()
    {
      return this._version.HasValue;
    }
    public void Validate()
    {
      if (!IsSetTableName()) throw new System.ArgumentException("Missing value for required property 'TableName'");
      if (!IsSetItem()) throw new System.ArgumentException("Missing value for required property 'Item'");
      if (IsSetVersion())
      {
        if (Version < 1)
        {
          throw new System.ArgumentException(
              String.Format("Member Version of structure ResolveAttributesInput has type VersionNumber which has a minimum of 1 but was given the value {0}.", Version));
        }
      }
    }
  }
}
