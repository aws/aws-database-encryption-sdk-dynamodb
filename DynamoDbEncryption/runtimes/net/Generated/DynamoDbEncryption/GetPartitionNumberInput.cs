// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class GetPartitionNumberInput
  {
    private System.Collections.Generic.Dictionary<string, Amazon.DynamoDBv2.Model.AttributeValue> _item;
    private int? _numberOfPartitions;
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
    public int NumberOfPartitions
    {
      get { return this._numberOfPartitions.GetValueOrDefault(); }
      set { this._numberOfPartitions = value; }
    }
    public bool IsSetNumberOfPartitions()
    {
      return this._numberOfPartitions.HasValue;
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
      if (!IsSetNumberOfPartitions()) throw new System.ArgumentException("Missing value for required property 'NumberOfPartitions'");
      if (!IsSetLogicalTableName()) throw new System.ArgumentException("Missing value for required property 'LogicalTableName'");

    }
  }
}
