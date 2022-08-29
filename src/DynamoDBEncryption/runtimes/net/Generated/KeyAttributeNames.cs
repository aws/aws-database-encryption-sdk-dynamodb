// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDBEncryption; namespace AWS.Cryptography.DynamoDBEncryption {
 public class KeyAttributeNames {
 private string _partitionName ;
 private string _sortName ;
 public string PartitionName {
 get { return this._partitionName; }
 set { this._partitionName = value; }
}
 internal bool IsSetPartitionName () {
 return this._partitionName != null;
}
 public string SortName {
 get { return this._sortName; }
 set { this._sortName = value; }
}
 internal bool IsSetSortName () {
 return this._sortName != null;
}
 public void Validate() {
 if (!IsSetPartitionName()) throw new System.ArgumentException("Missing value for required property 'PartitionName'");

}
}
}
