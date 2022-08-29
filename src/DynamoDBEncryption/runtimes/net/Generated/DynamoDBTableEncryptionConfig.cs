// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamodbEncryption; namespace AWS.Cryptography.DynamodbEncryption {
 public class DynamoDBTableEncryptionConfig {
 private string _partitionKeyName ;
 private string _sortKeyName ;
 public string PartitionKeyName {
 get { return this._partitionKeyName; }
 set { this._partitionKeyName = value; }
}
 internal bool IsSetPartitionKeyName () {
 return this._partitionKeyName != null;
}
 public string SortKeyName {
 get { return this._sortKeyName; }
 set { this._sortKeyName = value; }
}
 internal bool IsSetSortKeyName () {
 return this._sortKeyName != null;
}
 public void Validate() {
 if (!IsSetPartitionKeyName()) throw new System.ArgumentException("Missing value for required property 'PartitionKeyName'");

}
}
}
