// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
 using AWS.Cryptography.DynamoDbEncryption; namespace AWS.Cryptography.DynamoDbEncryption {
 public class DynamoDbTableEncryptionConfig {
 private string _partitionKeyName ;
 private string _sortKeyName ;
 private AWS.Cryptography.DynamoDbEncryption.SearchConfig _search ;
 private System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> _attributeActions ;
 private System.Collections.Generic.List<string> _allowedUnauthenticatedAttributes ;
 private string _allowedUnauthenticatedAttributePrefix ;
 private AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId _algorithmSuiteId ;
 private AWS.Cryptography.MaterialProviders.IKeyring _keyring ;
 private AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager _cmm ;
 public string PartitionKeyName {
 get { return this._partitionKeyName; }
 set { this._partitionKeyName = value; }
}
 public bool IsSetPartitionKeyName () {
 return this._partitionKeyName != null;
}
 public string SortKeyName {
 get { return this._sortKeyName; }
 set { this._sortKeyName = value; }
}
 public bool IsSetSortKeyName () {
 return this._sortKeyName != null;
}
 public AWS.Cryptography.DynamoDbEncryption.SearchConfig Search {
 get { return this._search; }
 set { this._search = value; }
}
 public bool IsSetSearch () {
 return this._search != null;
}
 public System.Collections.Generic.Dictionary<string, AWS.Cryptography.StructuredEncryption.CryptoAction> AttributeActions {
 get { return this._attributeActions; }
 set { this._attributeActions = value; }
}
 public bool IsSetAttributeActions () {
 return this._attributeActions != null;
}
 public System.Collections.Generic.List<string> AllowedUnauthenticatedAttributes {
 get { return this._allowedUnauthenticatedAttributes; }
 set { this._allowedUnauthenticatedAttributes = value; }
}
 public bool IsSetAllowedUnauthenticatedAttributes () {
 return this._allowedUnauthenticatedAttributes != null;
}
 public string AllowedUnauthenticatedAttributePrefix {
 get { return this._allowedUnauthenticatedAttributePrefix; }
 set { this._allowedUnauthenticatedAttributePrefix = value; }
}
 public bool IsSetAllowedUnauthenticatedAttributePrefix () {
 return this._allowedUnauthenticatedAttributePrefix != null;
}
 public AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId AlgorithmSuiteId {
 get { return this._algorithmSuiteId; }
 set { this._algorithmSuiteId = value; }
}
 public bool IsSetAlgorithmSuiteId () {
 return this._algorithmSuiteId != null;
}
 public AWS.Cryptography.MaterialProviders.IKeyring Keyring {
 get { return this._keyring; }
 set { this._keyring = value; }
}
 public bool IsSetKeyring () {
 return this._keyring != null;
}
 public AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager Cmm {
 get { return this._cmm; }
 set { this._cmm = value; }
}
 public bool IsSetCmm () {
 return this._cmm != null;
}
 public void Validate() {
 if (!IsSetPartitionKeyName()) throw new System.ArgumentException("Missing value for required property 'PartitionKeyName'");
 if (!IsSetAttributeActions()) throw new System.ArgumentException("Missing value for required property 'AttributeActions'");

}
}
}
