// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDBEncryption; namespace AWS.Cryptography.DynamoDBEncryption {
 public class DynamoDBItemEncryptorConfig {
 private string _tableName ;
 private string _partitionKeyName ;
 private string _sortKeyName ;
 private AWS.Cryptography.MaterialProviders.IKeyring _keyring ;
 private AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager _cmm ;
 public string TableName {
 get { return this._tableName; }
 set { this._tableName = value; }
}
 internal bool IsSetTableName () {
 return this._tableName != null;
}
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
 public AWS.Cryptography.MaterialProviders.IKeyring Keyring {
 get { return this._keyring; }
 set { this._keyring = value; }
}
 internal bool IsSetKeyring () {
 return this._keyring != null;
}
 public AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager Cmm {
 get { return this._cmm; }
 set { this._cmm = value; }
}
 internal bool IsSetCmm () {
 return this._cmm != null;
}
 public void Validate() {
 if (!IsSetTableName()) throw new System.ArgumentException("Missing value for required property 'TableName'");
 if (!IsSetPartitionKeyName()) throw new System.ArgumentException("Missing value for required property 'PartitionKeyName'");

}
}
}
