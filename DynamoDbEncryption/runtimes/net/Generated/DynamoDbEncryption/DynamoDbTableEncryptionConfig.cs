// Copyright Amazon.com Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: Apache-2.0
// Do not modify this file. This file is machine generated, and any changes to it will be overwritten.
using System;
using AWS.Cryptography.DbEncryptionSDK.DynamoDb;
namespace AWS.Cryptography.DbEncryptionSDK.DynamoDb
{
  public class DynamoDbTableEncryptionConfig
  {
    private string _logicalTableName;
    private string _partitionKeyName;
    private string _sortKeyName;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.SearchConfig _search;
    private System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> _attributeActionsOnEncrypt;
    private System.Collections.Generic.List<string> _allowedUnsignedAttributes;
    private string _allowedUnsignedAttributePrefix;
    private AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId _algorithmSuiteId;
    private AWS.Cryptography.MaterialProviders.IKeyring _keyring;
    private AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager _cmm;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride _legacyOverride;
    private AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride _plaintextOverride;
    public string LogicalTableName
    {
      get { return this._logicalTableName; }
      set { this._logicalTableName = value; }
    }
    public bool IsSetLogicalTableName()
    {
      return this._logicalTableName != null;
    }
    public string PartitionKeyName
    {
      get { return this._partitionKeyName; }
      set { this._partitionKeyName = value; }
    }
    public bool IsSetPartitionKeyName()
    {
      return this._partitionKeyName != null;
    }
    public string SortKeyName
    {
      get { return this._sortKeyName; }
      set { this._sortKeyName = value; }
    }
    public bool IsSetSortKeyName()
    {
      return this._sortKeyName != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.SearchConfig Search
    {
      get { return this._search; }
      set { this._search = value; }
    }
    public bool IsSetSearch()
    {
      return this._search != null;
    }
    public System.Collections.Generic.Dictionary<string, AWS.Cryptography.DbEncryptionSDK.StructuredEncryption.CryptoAction> AttributeActionsOnEncrypt
    {
      get { return this._attributeActionsOnEncrypt; }
      set { this._attributeActionsOnEncrypt = value; }
    }
    public bool IsSetAttributeActionsOnEncrypt()
    {
      return this._attributeActionsOnEncrypt != null;
    }
    public System.Collections.Generic.List<string> AllowedUnsignedAttributes
    {
      get { return this._allowedUnsignedAttributes; }
      set { this._allowedUnsignedAttributes = value; }
    }
    public bool IsSetAllowedUnsignedAttributes()
    {
      return this._allowedUnsignedAttributes != null;
    }
    public string AllowedUnsignedAttributePrefix
    {
      get { return this._allowedUnsignedAttributePrefix; }
      set { this._allowedUnsignedAttributePrefix = value; }
    }
    public bool IsSetAllowedUnsignedAttributePrefix()
    {
      return this._allowedUnsignedAttributePrefix != null;
    }
    public AWS.Cryptography.MaterialProviders.DBEAlgorithmSuiteId AlgorithmSuiteId
    {
      get { return this._algorithmSuiteId; }
      set { this._algorithmSuiteId = value; }
    }
    public bool IsSetAlgorithmSuiteId()
    {
      return this._algorithmSuiteId != null;
    }
    public AWS.Cryptography.MaterialProviders.IKeyring Keyring
    {
      get { return this._keyring; }
      set { this._keyring = value; }
    }
    public bool IsSetKeyring()
    {
      return this._keyring != null;
    }
    public AWS.Cryptography.MaterialProviders.ICryptographicMaterialsManager Cmm
    {
      get { return this._cmm; }
      set { this._cmm = value; }
    }
    public bool IsSetCmm()
    {
      return this._cmm != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.LegacyOverride LegacyOverride
    {
      get { return this._legacyOverride; }
      set { this._legacyOverride = value; }
    }
    public bool IsSetLegacyOverride()
    {
      return this._legacyOverride != null;
    }
    public AWS.Cryptography.DbEncryptionSDK.DynamoDb.PlaintextOverride PlaintextOverride
    {
      get { return this._plaintextOverride; }
      set { this._plaintextOverride = value; }
    }
    public bool IsSetPlaintextOverride()
    {
      return this._plaintextOverride != null;
    }
    public void Validate()
    {
      if (!IsSetLogicalTableName()) throw new System.ArgumentException("Missing value for required property 'LogicalTableName'");
      if (!IsSetPartitionKeyName()) throw new System.ArgumentException("Missing value for required property 'PartitionKeyName'");
      if (!IsSetAttributeActionsOnEncrypt()) throw new System.ArgumentException("Missing value for required property 'AttributeActionsOnEncrypt'");

    }
  }
}
