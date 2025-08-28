// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class GetBucketNumberInput
  {
    private System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> _item;
    private int? _numberOfBuckets;
    private string _logicalTableName;
    public System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> Item
    {
      get { return this._item; }
      set { this._item = value; }
    }
    public bool IsSetItem()
    {
      return this._item != null;
    }
    public int NumberOfBuckets
    {
      get { return this._numberOfBuckets.GetValueOrDefault(); }
      set { this._numberOfBuckets = value; }
    }
    public bool IsSetNumberOfBuckets()
    {
      return this._numberOfBuckets.HasValue;
    }
    public string LogicalTableName
    {
      get { return this._logicalTableName; }
      set { this._logicalTableName = value; }
    }
    public bool IsSetLogicalTableName()
    {
      return this._logicalTableName != null;
    }
    public void Validate()
    {
      if (!IsSetItem()) throw new System.ArgumentException("Missing value for required property 'Item'");
      if (!IsSetNumberOfBuckets()) throw new System.ArgumentException("Missing value for required property 'NumberOfBuckets'");
      if (!IsSetLogicalTableName()) throw new System.ArgumentException("Missing value for required property 'LogicalTableName'");

    }
  }
}
